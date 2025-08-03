package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import com.bumptech.glide.load.Key;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.ndk.SessionFiles;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class CrashpadController {
    private static final String APP_METADATA_FILE = "app.json";
    private static final String DEVICE_METADATA_FILE = "device.json";
    private static final String OS_METADATA_FILE = "os.json";
    private static final String SESSION_METADATA_FILE = "session.json";
    private static final Charset UTF_8 = Charset.forName(Key.STRING_CHARSET_NAME);
    private final Context context;
    private final FileStore fileStore;
    private final NativeApi nativeApi;

    CrashpadController(Context context2, NativeApi nativeApi2, FileStore fileStore2) {
        this.context = context2;
        this.nativeApi = nativeApi2;
        this.fileStore = fileStore2;
    }

    public boolean initialize(String str, String str2, long j, StaticSessionData staticSessionData) {
        File nativeSessionDir = this.fileStore.getNativeSessionDir(str);
        if (nativeSessionDir == null) {
            return false;
        }
        try {
            if (!this.nativeApi.initialize(nativeSessionDir.getCanonicalPath(), this.context.getAssets())) {
                return false;
            }
            writeBeginSession(str, str2, j);
            writeSessionApp(str, staticSessionData.appData());
            writeSessionOs(str, staticSessionData.osData());
            writeSessionDevice(str, staticSessionData.deviceData());
            return true;
        } catch (IOException e) {
            Logger.getLogger().e("Error initializing Crashlytics NDK", e);
            return false;
        }
    }

    public boolean hasCrashDataForSession(String str) {
        File file = getFilesForSession(str).minidump;
        return file != null && file.exists();
    }

    public SessionFiles getFilesForSession(String str) {
        File nativeSessionDir = this.fileStore.getNativeSessionDir(str);
        File file = new File(nativeSessionDir, "pending");
        Logger.getLogger().v("Minidump directory: " + file.getAbsolutePath());
        File singleFileWithExtension = getSingleFileWithExtension(file, ".dmp");
        Logger.getLogger().v("Minidump file " + ((singleFileWithExtension == null || !singleFileWithExtension.exists()) ? "does not exist" : "exists"));
        SessionFiles.Builder builder = new SessionFiles.Builder();
        if (nativeSessionDir != null && nativeSessionDir.exists() && file.exists()) {
            builder.minidumpFile(getSingleFileWithExtension(file, ".dmp")).metadataFile(getSingleFileWithExtension(nativeSessionDir, ".device_info")).sessionFile(new File(nativeSessionDir, SESSION_METADATA_FILE)).appFile(new File(nativeSessionDir, APP_METADATA_FILE)).deviceFile(new File(nativeSessionDir, DEVICE_METADATA_FILE)).osFile(new File(nativeSessionDir, OS_METADATA_FILE));
        }
        return builder.build();
    }

    public void writeBeginSession(String str, String str2, long j) {
        writeSessionJsonFile(this.fileStore, str, SessionMetadataJsonSerializer.serializeBeginSession(str, str2, j), SESSION_METADATA_FILE);
    }

    public void writeSessionApp(String str, StaticSessionData.AppData appData) {
        writeSessionJsonFile(this.fileStore, str, SessionMetadataJsonSerializer.serializeSessionApp(appData.appIdentifier(), appData.versionCode(), appData.versionName(), appData.installUuid(), appData.deliveryMechanism(), appData.developmentPlatformProvider().getDevelopmentPlatform(), appData.developmentPlatformProvider().getDevelopmentPlatformVersion()), APP_METADATA_FILE);
    }

    public void writeSessionOs(String str, StaticSessionData.OsData osData) {
        writeSessionJsonFile(this.fileStore, str, SessionMetadataJsonSerializer.serializeSessionOs(osData.osRelease(), osData.osCodeName(), osData.isRooted()), OS_METADATA_FILE);
    }

    public void writeSessionDevice(String str, StaticSessionData.DeviceData deviceData) {
        writeSessionJsonFile(this.fileStore, str, SessionMetadataJsonSerializer.serializeSessionDevice(deviceData.arch(), deviceData.model(), deviceData.availableProcessors(), deviceData.totalRam(), deviceData.diskSpace(), deviceData.isEmulator(), deviceData.state(), deviceData.manufacturer(), deviceData.modelClass()), DEVICE_METADATA_FILE);
    }

    private static void writeSessionJsonFile(FileStore fileStore2, String str, String str2, String str3) {
        writeTextFile(new File(fileStore2.getNativeSessionDir(str), str3), str2);
    }

    private static void writeTextFile(File file, String str) {
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), UTF_8));
            try {
                bufferedWriter2.write(str);
                CommonUtils.closeOrLog(bufferedWriter2, "Failed to close " + file);
            } catch (IOException unused) {
                bufferedWriter = bufferedWriter2;
                CommonUtils.closeOrLog(bufferedWriter, "Failed to close " + file);
            } catch (Throwable th) {
                th = th;
                bufferedWriter = bufferedWriter2;
                CommonUtils.closeOrLog(bufferedWriter, "Failed to close " + file);
                throw th;
            }
        } catch (IOException unused2) {
            CommonUtils.closeOrLog(bufferedWriter, "Failed to close " + file);
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.closeOrLog(bufferedWriter, "Failed to close " + file);
            throw th;
        }
    }

    private static File getSingleFileWithExtension(File file, String str) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return null;
        }
        for (File file2 : listFiles) {
            if (file2.getName().endsWith(str)) {
                return file2;
            }
        }
        return null;
    }
}
