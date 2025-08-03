package com.eko;

import android.util.Log;
import com.arthenica.ffmpegkit.Chapter;
import com.brentvatne.react.ReactVideoView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.Fetch;
import com.tonyodev.fetch2.FetchConfiguration;
import com.tonyodev.fetch2.FetchListener;
import com.tonyodev.fetch2.HttpUrlConnectionDownloader;
import com.tonyodev.fetch2.NetworkType;
import com.tonyodev.fetch2.Priority;
import com.tonyodev.fetch2.Request;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2core.DownloadBlock;
import com.tonyodev.fetch2core.Downloader;
import com.tonyodev.fetch2core.Func;
import com.tonyodev.fetch2okhttp.OkHttpDownloader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.OkHttpClient;

public class RNBackgroundDownloaderModule extends ReactContextBaseJavaModule implements FetchListener {
    private static final int ERR_FILE_NOT_FOUND = 3;
    private static final int ERR_NO_INTERNET = 1;
    private static final int ERR_NO_WRITE_PERMISSION = 2;
    private static final int ERR_OTHERS = 100;
    private static final int ERR_STORAGE_FULL = 0;
    private static final int TASK_CANCELING = 2;
    private static final int TASK_COMPLETED = 3;
    private static final int TASK_RUNNING = 0;
    private static final int TASK_SUSPENDED = 1;
    /* access modifiers changed from: private */
    public static Object sharedLock = new Object();
    /* access modifiers changed from: private */
    public static Map<Status, Integer> stateMap = new HashMap<Status, Integer>() {
        {
            put(Status.DOWNLOADING, 0);
            put(Status.COMPLETED, 3);
            put(Status.PAUSED, 1);
            put(Status.QUEUED, 0);
            put(Status.CANCELLED, 2);
            put(Status.FAILED, 2);
            put(Status.REMOVED, 2);
            put(Status.DELETED, 2);
            put(Status.NONE, 2);
        }
    };
    /* access modifiers changed from: private */
    public DeviceEventManagerModule.RCTDeviceEventEmitter ee;
    /* access modifiers changed from: private */
    public Fetch fetch;
    /* access modifiers changed from: private */
    public Map<String, Integer> idToRequestId = new HashMap();
    private Date lastProgressReport = new Date();
    private HashMap<String, WritableMap> progressReports = new HashMap<>();
    /* access modifiers changed from: private */
    public Map<Integer, RNBGDTaskConfig> requestIdToConfig = new HashMap();

    @ReactMethod
    public void addListener(String str) {
    }

    public String getName() {
        return "RNBackgroundDownloader";
    }

    public boolean hasConstants() {
        return true;
    }

    public void onAdded(Download download) {
    }

    public void onDeleted(Download download) {
    }

    public void onDownloadBlockUpdated(Download download, DownloadBlock downloadBlock, int i) {
    }

    public void onPaused(Download download) {
    }

    public void onQueued(Download download, boolean z) {
    }

    public void onRemoved(Download download) {
    }

    public void onResumed(Download download) {
    }

    public void onStarted(Download download, List<? extends DownloadBlock> list, int i) {
    }

    public void onWaitingNetwork(Download download) {
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public RNBackgroundDownloaderModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        initDownloader(Arguments.createMap());
    }

    public void onCatalystInstanceDestroy() {
        this.fetch.close();
    }

    public void initialize() {
        this.ee = (DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
    }

    @Nullable
    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        File externalFilesDir = getReactApplicationContext().getExternalFilesDir((String) null);
        if (externalFilesDir != null) {
            hashMap.put("documents", externalFilesDir.getAbsolutePath());
        } else {
            hashMap.put("documents", getReactApplicationContext().getFilesDir().getAbsolutePath());
        }
        hashMap.put("TaskRunning", 0);
        hashMap.put("TaskSuspended", 1);
        hashMap.put("TaskCanceling", 2);
        hashMap.put("TaskCompleted", 3);
        hashMap.put("PriorityHigh", Integer.valueOf(Priority.HIGH.getValue()));
        hashMap.put("PriorityNormal", Integer.valueOf(Priority.NORMAL.getValue()));
        hashMap.put("PriorityLow", Integer.valueOf(Priority.LOW.getValue()));
        hashMap.put("OnlyWifi", Integer.valueOf(NetworkType.WIFI_ONLY.getValue()));
        hashMap.put("AllNetworks", Integer.valueOf(NetworkType.ALL.getValue()));
        return hashMap;
    }

    @ReactMethod
    public void initDownloader(ReadableMap readableMap) {
        Downloader.FileDownloaderType fileDownloaderType;
        Fetch fetch2 = this.fetch;
        if (fetch2 != null) {
            fetch2.close();
            this.fetch = null;
        }
        if (readableMap.getString("type") == "parallel") {
            fileDownloaderType = Downloader.FileDownloaderType.PARALLEL;
        } else {
            fileDownloaderType = Downloader.FileDownloaderType.SEQUENTIAL;
        }
        OkHttpDownloader okHttpDownloader = new OkHttpDownloader(new OkHttpClient.Builder().build(), fileDownloaderType);
        loadConfigMap();
        Fetch instance = Fetch.Impl.getInstance(new FetchConfiguration.Builder(getReactApplicationContext()).setDownloadConcurrentLimit(4).setHttpDownloader(okHttpDownloader).enableRetryOnNetworkGain(true).setHttpDownloader(new HttpUrlConnectionDownloader(fileDownloaderType)).build());
        this.fetch = instance;
        instance.addListener(this);
    }

    /* access modifiers changed from: private */
    public void removeFromMaps(int i) {
        synchronized (sharedLock) {
            RNBGDTaskConfig rNBGDTaskConfig = this.requestIdToConfig.get(Integer.valueOf(i));
            if (rNBGDTaskConfig != null) {
                this.idToRequestId.remove(rNBGDTaskConfig.id);
                this.requestIdToConfig.remove(Integer.valueOf(i));
                saveConfigMap();
            }
        }
    }

    private void saveConfigMap() {
        synchronized (sharedLock) {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(getReactApplicationContext().getFilesDir(), "RNFileBackgroundDownload_configMap")));
                objectOutputStream.writeObject(this.requestIdToConfig);
                objectOutputStream.flush();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadConfigMap() {
        try {
            this.requestIdToConfig = (Map) new ObjectInputStream(new FileInputStream(new File(getReactApplicationContext().getFilesDir(), "RNFileBackgroundDownload_configMap"))).readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public int convertErrorCode(Error error) {
        if (error == Error.FILE_NOT_CREATED || error == Error.WRITE_PERMISSION_DENIED) {
            return 2;
        }
        if (error == Error.CONNECTION_TIMED_OUT || error == Error.NO_NETWORK_CONNECTION) {
            return 1;
        }
        if (error == Error.NO_STORAGE_SPACE) {
            return 0;
        }
        return error == Error.FILE_NOT_FOUND ? 3 : 100;
    }

    @ReactMethod
    public void download(ReadableMap readableMap) {
        final String string = readableMap.getString(Chapter.KEY_ID);
        String string2 = readableMap.getString(ImagesContract.URL);
        String string3 = readableMap.getString(FirebaseAnalytics.Param.DESTINATION);
        ReadableMap map = readableMap.getMap("headers");
        String string4 = readableMap.getString(ReactVideoView.EVENT_PROP_METADATA);
        if (string == null || string2 == null || string3 == null) {
            Log.e(getName(), "id, url and destination must be set");
            return;
        }
        RNBGDTaskConfig rNBGDTaskConfig = new RNBGDTaskConfig(string, string3, string4);
        final Request request = new Request(string2, string3);
        if (map != null) {
            ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                request.addHeader(nextKey, map.getString(nextKey));
            }
        }
        request.setPriority(readableMap.hasKey("priority") ? Priority.valueOf(readableMap.getInt("priority")) : Priority.NORMAL);
        request.setNetworkType(readableMap.hasKey("network") ? NetworkType.valueOf(readableMap.getInt("network")) : NetworkType.ALL);
        this.fetch.enqueue(request, new Func<Request>() {
            public void call(Request request) {
            }
        }, new Func<Error>() {
            public void call(Error error) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString(Chapter.KEY_ID, string);
                createMap.putString(ReactVideoView.EVENT_PROP_ERROR, error.toString());
                createMap.putInt("errorcode", RNBackgroundDownloaderModule.this.convertErrorCode(error));
                RNBackgroundDownloaderModule.this.ee.emit("downloadFailed", createMap);
                RNBackgroundDownloaderModule.this.removeFromMaps(request.getId());
                RNBackgroundDownloaderModule.this.fetch.remove(request.getId());
                Log.e(RNBackgroundDownloaderModule.this.getName(), "Error in enqueue: " + error.toString() + ":" + error.getValue());
            }
        });
        synchronized (sharedLock) {
            this.lastProgressReport = new Date();
            this.idToRequestId.put(string, Integer.valueOf(request.getId()));
            this.requestIdToConfig.put(Integer.valueOf(request.getId()), rNBGDTaskConfig);
            saveConfigMap();
        }
    }

    @ReactMethod
    public void pauseTask(String str) {
        synchronized (sharedLock) {
            Integer num = this.idToRequestId.get(str);
            if (num != null) {
                this.fetch.pause(num.intValue());
            }
        }
    }

    @ReactMethod
    public void resumeTask(String str) {
        synchronized (sharedLock) {
            Integer num = this.idToRequestId.get(str);
            if (num != null) {
                this.fetch.resume(num.intValue());
            }
        }
    }

    @ReactMethod
    public void stopTask(String str) {
        synchronized (sharedLock) {
            Integer num = this.idToRequestId.get(str);
            if (num != null) {
                this.fetch.cancel(num.intValue());
            }
        }
    }

    @ReactMethod
    public void checkForExistingDownloads(final Promise promise) {
        this.fetch.getDownloads(new Func<List<Download>>() {
            public void call(List<Download> list) {
                WritableArray createArray = Arguments.createArray();
                synchronized (RNBackgroundDownloaderModule.sharedLock) {
                    for (Download next : list) {
                        if (RNBackgroundDownloaderModule.this.requestIdToConfig.containsKey(Integer.valueOf(next.getId()))) {
                            RNBGDTaskConfig rNBGDTaskConfig = (RNBGDTaskConfig) RNBackgroundDownloaderModule.this.requestIdToConfig.get(Integer.valueOf(next.getId()));
                            WritableMap createMap = Arguments.createMap();
                            createMap.putString(Chapter.KEY_ID, rNBGDTaskConfig.id);
                            createMap.putString(ReactVideoView.EVENT_PROP_METADATA, rNBGDTaskConfig.metadata);
                            createMap.putInt("state", ((Integer) RNBackgroundDownloaderModule.stateMap.get(next.getStatus())).intValue());
                            createMap.putInt("bytesWritten", (int) next.getDownloaded());
                            createMap.putInt("totalBytes", (int) next.getTotal());
                            createMap.putDouble("percent", ((double) next.getProgress()) / 100.0d);
                            createArray.pushMap(createMap);
                            RNBackgroundDownloaderModule.this.idToRequestId.put(rNBGDTaskConfig.id, Integer.valueOf(next.getId()));
                            rNBGDTaskConfig.reportedBegin = true;
                        } else {
                            RNBackgroundDownloaderModule.this.fetch.delete(next.getId());
                        }
                    }
                }
                promise.resolve(createArray);
            }
        });
    }

    public void onCompleted(Download download) {
        synchronized (sharedLock) {
            RNBGDTaskConfig rNBGDTaskConfig = this.requestIdToConfig.get(Integer.valueOf(download.getId()));
            if (rNBGDTaskConfig != null) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString(Chapter.KEY_ID, rNBGDTaskConfig.id);
                createMap.putString(FirebaseAnalytics.Param.LOCATION, rNBGDTaskConfig.destination);
                this.ee.emit("downloadComplete", createMap);
            }
            removeFromMaps(download.getId());
            if (!this.fetch.isClosed()) {
                this.fetch.remove(download.getId());
            }
        }
    }

    public void onProgress(Download download, long j, long j2) {
        synchronized (sharedLock) {
            RNBGDTaskConfig rNBGDTaskConfig = this.requestIdToConfig.get(Integer.valueOf(download.getId()));
            if (rNBGDTaskConfig != null) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString(Chapter.KEY_ID, rNBGDTaskConfig.id);
                if (!rNBGDTaskConfig.reportedBegin) {
                    rNBGDTaskConfig.reportedBegin = true;
                    createMap.putInt("expectedBytes", (int) download.getTotal());
                    Thread thread = new Thread(new Runnable(download, createMap) {
                        public final /* synthetic */ Download f$1;
                        public final /* synthetic */ WritableMap f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            RNBackgroundDownloaderModule.this.lambda$onProgress$0$RNBackgroundDownloaderModule(this.f$1, this.f$2);
                        }
                    });
                    try {
                        thread.start();
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    createMap.putInt("written", (int) download.getDownloaded());
                    createMap.putInt("total", (int) download.getTotal());
                    createMap.putDouble("percent", ((double) download.getProgress()) / 100.0d);
                    this.progressReports.put(rNBGDTaskConfig.id, createMap);
                    Date date = new Date();
                    if (date.getTime() - this.lastProgressReport.getTime() > 250) {
                        WritableArray createArray = Arguments.createArray();
                        for (WritableMap pushMap : this.progressReports.values()) {
                            createArray.pushMap(pushMap);
                        }
                        this.ee.emit("downloadProgress", createArray);
                        this.lastProgressReport = date;
                        this.progressReports.clear();
                    }
                }
            }
        }
    }

    public /* synthetic */ void lambda$onProgress$0$RNBackgroundDownloaderModule(Download download, WritableMap writableMap) {
        try {
            WritableMap createMap = Arguments.createMap();
            URLConnection openConnection = new URL(download.getUrl()).openConnection();
            for (String next : openConnection.getHeaderFields().keySet()) {
                createMap.putString(next, openConnection.getHeaderField(next));
            }
            writableMap.putMap("headers", createMap);
            this.ee.emit("downloadBegin", writableMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onCancelled(Download download) {
        synchronized (sharedLock) {
            removeFromMaps(download.getId());
            this.fetch.delete(download.getId());
        }
    }

    public void onError(Download download, Error error, Throwable th) {
        synchronized (sharedLock) {
            RNBGDTaskConfig rNBGDTaskConfig = this.requestIdToConfig.get(Integer.valueOf(download.getId()));
            if (rNBGDTaskConfig != null) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString(Chapter.KEY_ID, rNBGDTaskConfig.id);
                createMap.putInt("errorcode", convertErrorCode(error));
                if (error != Error.UNKNOWN || th == null) {
                    createMap.putString(ReactVideoView.EVENT_PROP_ERROR, error.toString());
                    Log.e(getName(), "Error in download: " + error.toString() + ":" + error.getValue());
                } else {
                    createMap.putString(ReactVideoView.EVENT_PROP_ERROR, th.getLocalizedMessage());
                    Log.e(getName(), "UNKNOWN Error in download: " + th.getLocalizedMessage());
                }
                this.ee.emit("downloadFailed", createMap);
            }
            removeFromMaps(download.getId());
            this.fetch.remove(download.getId());
        }
    }
}
