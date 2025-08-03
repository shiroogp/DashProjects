package com.google.mlkit.common.sdkinternal.model;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import java.io.File;
import java.util.concurrent.Executor;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public abstract class LegacyModelMigrator {
    protected final ModelFileHelper modelFileHelper;
    private final TaskCompletionSource<Void> zza = new TaskCompletionSource<>();
    private final Context zzb;
    private final Executor zzc;

    protected LegacyModelMigrator(Context context, ModelFileHelper modelFileHelper2) {
        this.zzb = context;
        this.modelFileHelper = modelFileHelper2;
        this.zzc = MLTaskExecutor.workerThreadExecutor();
    }

    protected static void deleteIfEmpty(File file) {
        File[] listFiles = file.listFiles();
        if ((listFiles == null || listFiles.length == 0) && !file.delete()) {
            String valueOf = String.valueOf(file);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 31);
            sb.append("Error deleting model directory ");
            sb.append(valueOf);
            Log.e("MlKitLegacyMigration", sb.toString());
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static boolean isValidFirebasePersistenceKey(java.lang.String r3) {
        /*
            java.lang.String r0 = "\\+"
            r1 = -1
            java.lang.String[] r3 = r3.split(r0, r1)
            int r0 = r3.length
            r1 = 0
            r2 = 2
            if (r0 == r2) goto L_0x000d
            return r1
        L_0x000d:
            r0 = r3[r1]     // Catch:{ IllegalArgumentException -> 0x0019 }
            com.google.android.gms.common.util.Base64Utils.decodeUrlSafeNoPadding(r0)     // Catch:{ IllegalArgumentException -> 0x0019 }
            r0 = 1
            r3 = r3[r0]     // Catch:{  }
            com.google.android.gms.common.util.Base64Utils.decodeUrlSafeNoPadding(r3)     // Catch:{  }
            return r0
        L_0x0019:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.LegacyModelMigrator.isValidFirebasePersistenceKey(java.lang.String):boolean");
    }

    public static void migrateFile(File file, File file2) {
        if (file.exists()) {
            if (!file2.exists() && !file.renameTo(file2)) {
                String valueOf = String.valueOf(file);
                String valueOf2 = String.valueOf(file2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28 + String.valueOf(valueOf2).length());
                sb.append("Error moving model file ");
                sb.append(valueOf);
                sb.append(" to ");
                sb.append(valueOf2);
                Log.e("MlKitLegacyMigration", sb.toString());
            }
            if (file.exists() && !file.delete()) {
                String valueOf3 = String.valueOf(file);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf3).length() + 26);
                sb2.append("Error deleting model file ");
                sb2.append(valueOf3);
                Log.e("MlKitLegacyMigration", sb2.toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract String getLegacyModelDirName();

    public File getLegacyRootDir() {
        String legacyModelDirName = getLegacyModelDirName();
        if (Build.VERSION.SDK_INT >= 21) {
            return new File(this.zzb.getNoBackupFilesDir(), legacyModelDirName);
        }
        return this.zzb.getApplicationContext().getDir(legacyModelDirName, 0);
    }

    public Task<Void> getMigrationTask() {
        return this.zza.getTask();
    }

    /* access modifiers changed from: protected */
    public abstract void migrateAllModelDirs(File file);

    public void start() {
        this.zzc.execute(new zza(this));
    }

    public final /* synthetic */ void zza() {
        File legacyRootDir = getLegacyRootDir();
        File[] listFiles = legacyRootDir.listFiles();
        if (listFiles != null) {
            for (File migrateAllModelDirs : listFiles) {
                migrateAllModelDirs(migrateAllModelDirs);
            }
            deleteIfEmpty(legacyRootDir);
        }
        this.zza.setResult(null);
    }
}
