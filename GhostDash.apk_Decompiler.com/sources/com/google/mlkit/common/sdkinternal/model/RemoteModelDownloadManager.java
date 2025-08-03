package com.google.mlkit.common.sdkinternal.model;

import android.app.DownloadManager;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.LongSparseArray;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzgu;
import com.google.android.gms.internal.mlkit_common.zzhb;
import com.google.android.gms.internal.mlkit_common.zzjl;
import com.google.android.gms.internal.mlkit_common.zzjo;
import com.google.android.gms.internal.mlkit_common.zzjw;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelInfo;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public class RemoteModelDownloadManager {
    /* access modifiers changed from: private */
    public static final GmsLogger zza = new GmsLogger("ModelDownloadManager", "");
    private static final Map<RemoteModel, RemoteModelDownloadManager> zzb = new HashMap();
    /* access modifiers changed from: private */
    public final LongSparseArray<zzc> zzc = new LongSparseArray<>();
    /* access modifiers changed from: private */
    public final LongSparseArray<TaskCompletionSource<Void>> zzd = new LongSparseArray<>();
    /* access modifiers changed from: private */
    public final MlKitContext zze;
    private final DownloadManager zzf;
    /* access modifiers changed from: private */
    public final RemoteModel zzg;
    private final ModelType zzh;
    /* access modifiers changed from: private */
    public final zzjl zzi;
    private final SharedPrefManager zzj;
    private final ModelFileHelper zzk;
    private final ModelInfoRetrieverInterop zzl;
    private final RemoteModelFileManager zzm;
    private DownloadConditions zzn;

    RemoteModelDownloadManager(MlKitContext mlKitContext, RemoteModel remoteModel, ModelFileHelper modelFileHelper, RemoteModelFileManager remoteModelFileManager, ModelInfoRetrieverInterop modelInfoRetrieverInterop, zzjl zzjl) {
        this.zze = mlKitContext;
        this.zzh = remoteModel.getModelType();
        this.zzg = remoteModel;
        DownloadManager downloadManager = (DownloadManager) mlKitContext.getApplicationContext().getSystemService("download");
        this.zzf = downloadManager;
        this.zzi = zzjl;
        if (downloadManager == null) {
            zza.d("ModelDownloadManager", "Download manager service is not available in the service.");
        }
        this.zzk = modelFileHelper;
        this.zzj = SharedPrefManager.getInstance(mlKitContext);
        this.zzl = modelInfoRetrieverInterop;
        this.zzm = remoteModelFileManager;
    }

    public static synchronized RemoteModelDownloadManager getInstance(MlKitContext mlKitContext, RemoteModel remoteModel, ModelFileHelper modelFileHelper, RemoteModelFileManager remoteModelFileManager, ModelInfoRetrieverInterop modelInfoRetrieverInterop) {
        RemoteModelDownloadManager remoteModelDownloadManager;
        synchronized (RemoteModelDownloadManager.class) {
            Map<RemoteModel, RemoteModelDownloadManager> map = zzb;
            if (!map.containsKey(remoteModel)) {
                map.put(remoteModel, new RemoteModelDownloadManager(mlKitContext, remoteModel, modelFileHelper, remoteModelFileManager, modelInfoRetrieverInterop, zzjw.zzb("common")));
            }
            remoteModelDownloadManager = map.get(remoteModel);
        }
        return remoteModelDownloadManager;
    }

    private final Task<Void> zzj(long j) {
        this.zze.getApplicationContext().registerReceiver(zzm(j), new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), (String) null, MLTaskExecutor.getInstance().getHandler());
        return zzk(j).getTask();
    }

    private final synchronized TaskCompletionSource<Void> zzk(long j) {
        TaskCompletionSource<Void> taskCompletionSource = this.zzd.get(j);
        if (taskCompletionSource != null) {
            return taskCompletionSource;
        }
        TaskCompletionSource<Void> taskCompletionSource2 = new TaskCompletionSource<>();
        this.zzd.put(j, taskCompletionSource2);
        return taskCompletionSource2;
    }

    /* access modifiers changed from: private */
    public final MlKitException zzl(Long l) {
        DownloadManager downloadManager = this.zzf;
        Cursor cursor = null;
        if (!(downloadManager == null || l == null)) {
            cursor = downloadManager.query(new DownloadManager.Query().setFilterById(new long[]{l.longValue()}));
        }
        int i = 13;
        String str = "Model downloading failed";
        if (cursor != null && cursor.moveToFirst()) {
            int i2 = cursor.getInt(cursor.getColumnIndex("reason"));
            if (i2 == 1006) {
                i = 101;
                str = "Model downloading failed due to insufficient space on the device.";
            } else {
                StringBuilder sb = new StringBuilder(84);
                sb.append("Model downloading failed due to error code: ");
                sb.append(i2);
                sb.append(" from Android DownloadManager");
                str = sb.toString();
            }
        }
        return new MlKitException(str, i);
    }

    private final synchronized zzc zzm(long j) {
        zzc zzc2 = this.zzc.get(j);
        if (zzc2 != null) {
            return zzc2;
        }
        zzc zzc3 = new zzc(this, j, zzk(j), (zzb) null);
        this.zzc.put(j, zzc3);
        return zzc3;
    }

    private final synchronized Long zzn(DownloadManager.Request request, ModelInfo modelInfo) {
        DownloadManager downloadManager = this.zzf;
        if (downloadManager == null) {
            return null;
        }
        long enqueue = downloadManager.enqueue(request);
        GmsLogger gmsLogger = zza;
        StringBuilder sb = new StringBuilder(53);
        sb.append("Schedule a new downloading task: ");
        sb.append(enqueue);
        gmsLogger.d("ModelDownloadManager", sb.toString());
        this.zzj.setDownloadingModelInfo(enqueue, modelInfo);
        this.zzi.zze(zzjo.zzg(), this.zzg, zzgu.NO_ERROR, false, modelInfo.getModelType(), zzhb.SCHEDULED);
        return Long.valueOf(enqueue);
    }

    private final synchronized Long zzo(ModelInfo modelInfo, DownloadConditions downloadConditions) throws MlKitException {
        Preconditions.checkNotNull(downloadConditions, "DownloadConditions can not be null");
        String downloadingModelHash = this.zzj.getDownloadingModelHash(this.zzg);
        Integer downloadingModelStatusCode = getDownloadingModelStatusCode();
        if (downloadingModelHash == null || !downloadingModelHash.equals(modelInfo.getModelHash()) || downloadingModelStatusCode == null) {
            GmsLogger gmsLogger = zza;
            gmsLogger.d("ModelDownloadManager", "Need to download a new model.");
            removeOrCancelDownload();
            DownloadManager.Request request = new DownloadManager.Request(modelInfo.getModelUri());
            if (this.zzk.modelExistsLocally(modelInfo.getModelNameForPersist(), modelInfo.getModelType())) {
                gmsLogger.d("ModelDownloadManager", "Model update is enabled and have a previous downloaded model, use download condition");
                this.zzi.zze(zzjo.zzg(), this.zzg, zzgu.NO_ERROR, false, modelInfo.getModelType(), zzhb.UPDATE_AVAILABLE);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                request.setRequiresCharging(downloadConditions.isChargingRequired());
            }
            if (downloadConditions.isWifiRequired()) {
                request.setAllowedNetworkTypes(2);
            }
            return zzn(request, modelInfo);
        }
        Integer downloadingModelStatusCode2 = getDownloadingModelStatusCode();
        if (downloadingModelStatusCode2 == null || !(downloadingModelStatusCode2.intValue() == 8 || downloadingModelStatusCode2.intValue() == 16)) {
            this.zzi.zze(zzjo.zzg(), this.zzg, zzgu.NO_ERROR, false, this.zzg.getModelType(), zzhb.DOWNLOADING);
        }
        zza.d("ModelDownloadManager", "New model is already in downloading, do nothing.");
        return null;
    }

    public Task<Void> ensureModelDownloaded() {
        MlKitException mlKitException;
        ModelInfo modelInfo;
        this.zzi.zze(zzjo.zzg(), this.zzg, zzgu.NO_ERROR, false, ModelType.UNKNOWN, zzhb.EXPLICITLY_REQUESTED);
        Long l = null;
        try {
            modelInfo = zzg();
            mlKitException = null;
        } catch (MlKitException e) {
            mlKitException = e;
            modelInfo = null;
        }
        try {
            Integer downloadingModelStatusCode = getDownloadingModelStatusCode();
            Long downloadingId = getDownloadingId();
            if (!modelExistsLocally()) {
                if (downloadingModelStatusCode == null || downloadingModelStatusCode.intValue() != 8) {
                    if (downloadingModelStatusCode != null && downloadingModelStatusCode.intValue() == 16) {
                        MlKitException zzl2 = zzl(downloadingId);
                        removeOrCancelDownload();
                        return Tasks.forException(zzl2);
                    } else if (downloadingModelStatusCode == null || (!(downloadingModelStatusCode.intValue() == 4 || downloadingModelStatusCode.intValue() == 2 || downloadingModelStatusCode.intValue() == 1) || downloadingId == null || getDownloadingModelHash() == null)) {
                        if (modelInfo != null) {
                            l = zzo(modelInfo, this.zzn);
                        }
                        if (l == null) {
                            return Tasks.forException(new MlKitException("Failed to schedule the download task", 13, mlKitException));
                        }
                        return zzj(l.longValue());
                    } else {
                        this.zzi.zze(zzjo.zzg(), this.zzg, zzgu.NO_ERROR, false, this.zzg.getModelType(), zzhb.DOWNLOADING);
                        return zzj(downloadingId.longValue());
                    }
                }
            }
            if (modelInfo != null) {
                Long zzo = zzo(modelInfo, this.zzn);
                if (zzo != null) {
                    return zzj(zzo.longValue());
                }
                zza.i("ModelDownloadManager", "Didn't schedule download for the updated model");
            }
            return Tasks.forResult(null);
        } catch (MlKitException e2) {
            return Tasks.forException(new MlKitException("Failed to ensure the model is downloaded.", 13, e2));
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        zza.e("ModelDownloadManager", "Downloaded file is not found");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.os.ParcelFileDescriptor getDownloadedFile() {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.Long r0 = r5.getDownloadingId()     // Catch:{ all -> 0x0022 }
            android.app.DownloadManager r1 = r5.zzf     // Catch:{ all -> 0x0022 }
            r2 = 0
            if (r1 == 0) goto L_0x0020
            if (r0 == 0) goto L_0x0020
            long r3 = r0.longValue()     // Catch:{ FileNotFoundException -> 0x0015 }
            android.os.ParcelFileDescriptor r2 = r1.openDownloadedFile(r3)     // Catch:{ FileNotFoundException -> 0x0015 }
            goto L_0x001e
        L_0x0015:
            com.google.android.gms.common.internal.GmsLogger r0 = zza     // Catch:{ all -> 0x0022 }
            java.lang.String r1 = "ModelDownloadManager"
            java.lang.String r3 = "Downloaded file is not found"
            r0.e(r1, r3)     // Catch:{ all -> 0x0022 }
        L_0x001e:
            monitor-exit(r5)
            return r2
        L_0x0020:
            monitor-exit(r5)
            return r2
        L_0x0022:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager.getDownloadedFile():android.os.ParcelFileDescriptor");
    }

    public synchronized Long getDownloadingId() {
        return this.zzj.getDownloadingModelId(this.zzg);
    }

    public synchronized String getDownloadingModelHash() {
        return this.zzj.getDownloadingModelHash(this.zzg);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0047, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x007d, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0048 A[SYNTHETIC, Splitter:B:20:0x0048] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.Integer getDownloadingModelStatusCode() {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.Long r0 = r9.getDownloadingId()     // Catch:{ all -> 0x007e }
            android.app.DownloadManager r1 = r9.zzf     // Catch:{ all -> 0x007e }
            r2 = 0
            if (r1 == 0) goto L_0x007c
            if (r0 != 0) goto L_0x000e
            goto L_0x007c
        L_0x000e:
            android.app.DownloadManager$Query r3 = new android.app.DownloadManager$Query     // Catch:{ all -> 0x007e }
            r3.<init>()     // Catch:{ all -> 0x007e }
            r4 = 1
            long[] r5 = new long[r4]     // Catch:{ all -> 0x007e }
            r6 = 0
            long r7 = r0.longValue()     // Catch:{ all -> 0x007e }
            r5[r6] = r7     // Catch:{ all -> 0x007e }
            android.app.DownloadManager$Query r0 = r3.setFilterById(r5)     // Catch:{ all -> 0x007e }
            android.database.Cursor r0 = r1.query(r0)     // Catch:{ all -> 0x007e }
            if (r0 == 0) goto L_0x003e
            boolean r1 = r0.moveToFirst()     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x003e
            java.lang.String r1 = "status"
            int r1 = r0.getColumnIndex(r1)     // Catch:{ all -> 0x003c }
            int r1 = r0.getInt(r1)     // Catch:{ all -> 0x003c }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x003c }
            goto L_0x003f
        L_0x003c:
            r1 = move-exception
            goto L_0x0073
        L_0x003e:
            r1 = r2
        L_0x003f:
            if (r1 != 0) goto L_0x0048
            if (r0 == 0) goto L_0x0046
            r0.close()     // Catch:{ all -> 0x007e }
        L_0x0046:
            monitor-exit(r9)
            return r2
        L_0x0048:
            int r3 = r1.intValue()     // Catch:{ all -> 0x003c }
            r5 = 2
            if (r3 == r5) goto L_0x006d
            int r3 = r1.intValue()     // Catch:{ all -> 0x003c }
            r5 = 4
            if (r3 == r5) goto L_0x006d
            int r3 = r1.intValue()     // Catch:{ all -> 0x003c }
            if (r3 == r4) goto L_0x006d
            int r3 = r1.intValue()     // Catch:{ all -> 0x003c }
            r4 = 8
            if (r3 == r4) goto L_0x006d
            int r3 = r1.intValue()     // Catch:{ all -> 0x003c }
            r4 = 16
            if (r3 == r4) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r2 = r1
        L_0x006e:
            r0.close()     // Catch:{ all -> 0x007e }
            monitor-exit(r9)
            return r2
        L_0x0073:
            r0.close()     // Catch:{ all -> 0x0077 }
            goto L_0x007b
        L_0x0077:
            r0 = move-exception
            r1.addSuppressed(r0)     // Catch:{ all -> 0x007e }
        L_0x007b:
            throw r1     // Catch:{ all -> 0x007e }
        L_0x007c:
            monitor-exit(r9)
            return r2
        L_0x007e:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager.getDownloadingModelStatusCode():java.lang.Integer");
    }

    public int getFailureReason(Long l) {
        int columnIndex;
        DownloadManager downloadManager = this.zzf;
        Cursor cursor = null;
        if (!(downloadManager == null || l == null)) {
            cursor = downloadManager.query(new DownloadManager.Query().setFilterById(new long[]{l.longValue()}));
        }
        if (cursor == null || !cursor.moveToFirst() || (columnIndex = cursor.getColumnIndex("reason")) == -1) {
            return 0;
        }
        return cursor.getInt(columnIndex);
    }

    public boolean isModelDownloadedAndValid() throws MlKitException {
        try {
            if (modelExistsLocally()) {
                return true;
            }
        } catch (MlKitException unused) {
            zza.d("ModelDownloadManager", "Failed to check if the model exist locally.");
        }
        Long downloadingId = getDownloadingId();
        String downloadingModelHash = getDownloadingModelHash();
        if (downloadingId == null || downloadingModelHash == null) {
            zza.d("ModelDownloadManager", "No new model is downloading.");
            removeOrCancelDownload();
            return false;
        }
        Integer downloadingModelStatusCode = getDownloadingModelStatusCode();
        GmsLogger gmsLogger = zza;
        String valueOf = String.valueOf(downloadingModelStatusCode);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("Download Status code: ");
        sb.append(valueOf);
        gmsLogger.d("ModelDownloadManager", sb.toString());
        if (downloadingModelStatusCode == null) {
            removeOrCancelDownload();
            return false;
        } else if (!Objects.equal(downloadingModelStatusCode, 8) || zzi(downloadingModelHash) == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean modelExistsLocally() throws MlKitException {
        return this.zzk.modelExistsLocally(this.zzg.getUniqueModelNameForPersist(), this.zzh);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0068, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void removeOrCancelDownload() throws com.google.mlkit.common.MlKitException {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.Long r0 = r6.getDownloadingId()     // Catch:{ all -> 0x0069 }
            android.app.DownloadManager r1 = r6.zzf     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x0067
            if (r0 != 0) goto L_0x000c
            goto L_0x0067
        L_0x000c:
            com.google.android.gms.common.internal.GmsLogger r1 = zza     // Catch:{ all -> 0x0069 }
            java.lang.String r2 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0069 }
            java.lang.String r3 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0069 }
            int r3 = r3.length()     // Catch:{ all -> 0x0069 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            int r3 = r3 + 44
            r4.<init>(r3)     // Catch:{ all -> 0x0069 }
            java.lang.String r3 = "Cancel or remove existing downloading task: "
            r4.append(r3)     // Catch:{ all -> 0x0069 }
            r4.append(r2)     // Catch:{ all -> 0x0069 }
            java.lang.String r2 = "ModelDownloadManager"
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0069 }
            r1.d(r2, r3)     // Catch:{ all -> 0x0069 }
            android.app.DownloadManager r1 = r6.zzf     // Catch:{ all -> 0x0069 }
            r2 = 1
            long[] r2 = new long[r2]     // Catch:{ all -> 0x0069 }
            r3 = 0
            long r4 = r0.longValue()     // Catch:{ all -> 0x0069 }
            r2[r3] = r4     // Catch:{ all -> 0x0069 }
            int r0 = r1.remove(r2)     // Catch:{ all -> 0x0069 }
            if (r0 > 0) goto L_0x004d
            java.lang.Integer r0 = r6.getDownloadingModelStatusCode()     // Catch:{ all -> 0x0069 }
            if (r0 != 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            monitor-exit(r6)
            return
        L_0x004d:
            com.google.mlkit.common.sdkinternal.model.ModelFileHelper r0 = r6.zzk     // Catch:{ all -> 0x0069 }
            com.google.mlkit.common.model.RemoteModel r1 = r6.zzg     // Catch:{ all -> 0x0069 }
            java.lang.String r1 = r1.getUniqueModelNameForPersist()     // Catch:{ all -> 0x0069 }
            com.google.mlkit.common.model.RemoteModel r2 = r6.zzg     // Catch:{ all -> 0x0069 }
            com.google.mlkit.common.sdkinternal.ModelType r2 = r2.getModelType()     // Catch:{ all -> 0x0069 }
            r0.deleteTempFilesInPrivateFolder(r1, r2)     // Catch:{ all -> 0x0069 }
            com.google.mlkit.common.sdkinternal.SharedPrefManager r0 = r6.zzj     // Catch:{ all -> 0x0069 }
            com.google.mlkit.common.model.RemoteModel r1 = r6.zzg     // Catch:{ all -> 0x0069 }
            r0.clearDownloadingModelInfo(r1)     // Catch:{ all -> 0x0069 }
            monitor-exit(r6)
            return
        L_0x0067:
            monitor-exit(r6)
            return
        L_0x0069:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager.removeOrCancelDownload():void");
    }

    public void setDownloadConditions(DownloadConditions downloadConditions) {
        Preconditions.checkNotNull(downloadConditions, "DownloadConditions can not be null");
        this.zzn = downloadConditions;
    }

    public synchronized void updateLatestModelHashAndType(String str) throws MlKitException {
        this.zzj.setLatestModelHash(this.zzg, str);
        removeOrCancelDownload();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0088, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.mlkit.common.sdkinternal.ModelInfo zzg() throws com.google.mlkit.common.MlKitException {
        /*
            r9 = this;
            monitor-enter(r9)
            boolean r0 = r9.modelExistsLocally()     // Catch:{ all -> 0x00ca }
            if (r0 == 0) goto L_0x001d
            com.google.android.gms.internal.mlkit_common.zzjl r1 = r9.zzi     // Catch:{ all -> 0x00ca }
            com.google.android.gms.internal.mlkit_common.zzjc r2 = com.google.android.gms.internal.mlkit_common.zzjo.zzg()     // Catch:{ all -> 0x00ca }
            com.google.mlkit.common.model.RemoteModel r3 = r9.zzg     // Catch:{ all -> 0x00ca }
            com.google.android.gms.internal.mlkit_common.zzgu r4 = com.google.android.gms.internal.mlkit_common.zzgu.NO_ERROR     // Catch:{ all -> 0x00ca }
            r5 = 0
            com.google.mlkit.common.model.RemoteModel r6 = r9.zzg     // Catch:{ all -> 0x00ca }
            com.google.mlkit.common.sdkinternal.ModelType r6 = r6.getModelType()     // Catch:{ all -> 0x00ca }
            com.google.android.gms.internal.mlkit_common.zzhb r7 = com.google.android.gms.internal.mlkit_common.zzhb.LIVE     // Catch:{ all -> 0x00ca }
            r1.zze(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00ca }
        L_0x001d:
            com.google.mlkit.common.sdkinternal.model.ModelInfoRetrieverInterop r1 = r9.zzl     // Catch:{ all -> 0x00ca }
            if (r1 == 0) goto L_0x00c0
            com.google.mlkit.common.model.RemoteModel r2 = r9.zzg     // Catch:{ all -> 0x00ca }
            com.google.mlkit.common.sdkinternal.ModelInfo r1 = r1.retrieveRemoteModelInfo(r2)     // Catch:{ all -> 0x00ca }
            r2 = 0
            if (r1 != 0) goto L_0x002c
            monitor-exit(r9)
            return r2
        L_0x002c:
            com.google.mlkit.common.sdkinternal.MlKitContext r3 = r9.zze     // Catch:{ all -> 0x00ca }
            com.google.mlkit.common.model.RemoteModel r4 = r9.zzg     // Catch:{ all -> 0x00ca }
            java.lang.String r5 = r1.getModelHash()     // Catch:{ all -> 0x00ca }
            com.google.mlkit.common.sdkinternal.SharedPrefManager r6 = com.google.mlkit.common.sdkinternal.SharedPrefManager.getInstance(r3)     // Catch:{ all -> 0x00ca }
            java.lang.String r4 = r6.getIncompatibleModelHash(r4)     // Catch:{ all -> 0x00ca }
            boolean r4 = r5.equals(r4)     // Catch:{ all -> 0x00ca }
            r5 = 0
            r7 = 1
            if (r4 == 0) goto L_0x0061
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x00ca }
            java.lang.String r3 = com.google.mlkit.common.sdkinternal.CommonUtils.getAppVersion(r3)     // Catch:{ all -> 0x00ca }
            java.lang.String r4 = r6.getPreviousAppVersion()     // Catch:{ all -> 0x00ca }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x00ca }
            if (r3 == 0) goto L_0x0061
            com.google.android.gms.common.internal.GmsLogger r3 = zza     // Catch:{ all -> 0x00ca }
            java.lang.String r4 = "ModelDownloadManager"
            java.lang.String r6 = "The model is incompatible with TFLite and the app is not upgraded, do not download"
            r3.e(r4, r6)     // Catch:{ all -> 0x00ca }
            r3 = r5
            goto L_0x0062
        L_0x0061:
            r3 = r7
        L_0x0062:
            if (r0 != 0) goto L_0x006b
            com.google.mlkit.common.sdkinternal.SharedPrefManager r4 = r9.zzj     // Catch:{ all -> 0x00ca }
            com.google.mlkit.common.model.RemoteModel r6 = r9.zzg     // Catch:{ all -> 0x00ca }
            r4.clearLatestModelHash(r6)     // Catch:{ all -> 0x00ca }
        L_0x006b:
            com.google.mlkit.common.sdkinternal.MlKitContext r4 = r9.zze     // Catch:{ all -> 0x00ca }
            com.google.mlkit.common.model.RemoteModel r6 = r9.zzg     // Catch:{ all -> 0x00ca }
            java.lang.String r8 = r1.getModelHash()     // Catch:{ all -> 0x00ca }
            com.google.mlkit.common.sdkinternal.SharedPrefManager r4 = com.google.mlkit.common.sdkinternal.SharedPrefManager.getInstance(r4)     // Catch:{ all -> 0x00ca }
            java.lang.String r4 = r4.getLatestModelHash(r6)     // Catch:{ all -> 0x00ca }
            boolean r4 = r8.equals(r4)     // Catch:{ all -> 0x00ca }
            r4 = r4 ^ r7
            if (r3 == 0) goto L_0x0089
            if (r0 == 0) goto L_0x0087
            if (r4 != 0) goto L_0x0087
            goto L_0x008a
        L_0x0087:
            monitor-exit(r9)
            return r1
        L_0x0089:
            r5 = r4
        L_0x008a:
            if (r0 == 0) goto L_0x0092
            r0 = r5 ^ r3
            if (r0 == 0) goto L_0x0092
            monitor-exit(r9)
            return r2
        L_0x0092:
            com.google.mlkit.common.MlKitException r0 = new com.google.mlkit.common.MlKitException     // Catch:{ all -> 0x00ca }
            com.google.mlkit.common.model.RemoteModel r1 = r9.zzg     // Catch:{ all -> 0x00ca }
            java.lang.String r1 = r1.getModelName()     // Catch:{ all -> 0x00ca }
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00ca }
            int r2 = r2.length()     // Catch:{ all -> 0x00ca }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
            int r2 = r2 + 46
            r3.<init>(r2)     // Catch:{ all -> 0x00ca }
            java.lang.String r2 = "The model "
            r3.append(r2)     // Catch:{ all -> 0x00ca }
            r3.append(r1)     // Catch:{ all -> 0x00ca }
            java.lang.String r1 = " is incompatible with TFLite runtime"
            r3.append(r1)     // Catch:{ all -> 0x00ca }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x00ca }
            r2 = 100
            r0.<init>(r1, r2)     // Catch:{ all -> 0x00ca }
            throw r0     // Catch:{ all -> 0x00ca }
        L_0x00c0:
            com.google.mlkit.common.MlKitException r0 = new com.google.mlkit.common.MlKitException     // Catch:{ all -> 0x00ca }
            java.lang.String r1 = "Please include com.google.mlkit:linkfirebase sdk as your dependency when you try to download from Firebase."
            r2 = 14
            r0.<init>(r1, r2)     // Catch:{ all -> 0x00ca }
            throw r0     // Catch:{ all -> 0x00ca }
        L_0x00ca:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager.zzg():com.google.mlkit.common.sdkinternal.ModelInfo");
    }

    public final File zzi(String str) throws MlKitException {
        GmsLogger gmsLogger = zza;
        gmsLogger.d("ModelDownloadManager", "Model downloaded successfully");
        this.zzi.zze(zzjo.zzg(), this.zzg, zzgu.NO_ERROR, true, this.zzh, zzhb.SUCCEEDED);
        ParcelFileDescriptor downloadedFile = getDownloadedFile();
        if (downloadedFile == null) {
            removeOrCancelDownload();
            return null;
        }
        gmsLogger.d("ModelDownloadManager", "moving downloaded model from external storage to private folder.");
        try {
            return this.zzm.moveModelToPrivateFolder(downloadedFile, str, this.zzg);
        } finally {
            removeOrCancelDownload();
        }
    }
}
