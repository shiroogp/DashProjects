package com.google.mlkit.common.sdkinternal.model;

import android.os.Build;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.Constants;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelType;
import java.io.File;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public class ModelFileHelper {
    public static final int INVALID_INDEX = -1;
    public static final String zza = String.format("com.google.mlkit.%s.models", new Object[]{"translate"});
    public static final String zzb = String.format("com.google.mlkit.%s.models", new Object[]{"custom"});
    static final String zzc = String.format("com.google.mlkit.%s.models", new Object[]{"base"});
    private static final GmsLogger zzd = new GmsLogger("ModelFileHelper", "");
    private final MlKitContext zze;

    public ModelFileHelper(MlKitContext mlKitContext) {
        this.zze = mlKitContext;
    }

    private final File zzc(String str, ModelType modelType, boolean z) throws MlKitException {
        File modelDirUnsafe = getModelDirUnsafe(str, modelType, z);
        if (!modelDirUnsafe.exists()) {
            GmsLogger gmsLogger = zzd;
            String valueOf = String.valueOf(modelDirUnsafe.getAbsolutePath());
            gmsLogger.d("ModelFileHelper", valueOf.length() != 0 ? "model folder does not exist, creating one: ".concat(valueOf) : new String("model folder does not exist, creating one: "));
            if (!modelDirUnsafe.mkdirs()) {
                String valueOf2 = String.valueOf(modelDirUnsafe);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 31);
                sb.append("Failed to create model folder: ");
                sb.append(valueOf2);
                throw new MlKitException(sb.toString(), 13);
            }
        } else if (!modelDirUnsafe.isDirectory()) {
            String valueOf3 = String.valueOf(modelDirUnsafe);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf3).length() + 71);
            sb2.append("Can not create model folder, since an existing file has the same name: ");
            sb2.append(valueOf3);
            throw new MlKitException(sb2.toString(), 6);
        }
        return modelDirUnsafe;
    }

    public synchronized void deleteAllModels(ModelType modelType, String str) {
        deleteRecursively(getModelDirUnsafe(str, modelType, false));
        deleteRecursively(getModelDirUnsafe(str, modelType, true));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        if (r5 != false) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean deleteRecursively(java.io.File r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8.isDirectory()
            r2 = 1
            if (r1 == 0) goto L_0x002c
            java.io.File[] r1 = r8.listFiles()
            java.lang.Object r1 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)
            java.io.File[] r1 = (java.io.File[]) r1
            int r3 = r1.length
            r4 = r0
            r5 = r2
        L_0x0018:
            if (r4 >= r3) goto L_0x002a
            r6 = r1[r4]
            if (r5 == 0) goto L_0x0026
            boolean r5 = r7.deleteRecursively(r6)
            if (r5 == 0) goto L_0x0026
            r5 = r2
            goto L_0x0027
        L_0x0026:
            r5 = r0
        L_0x0027:
            int r4 = r4 + 1
            goto L_0x0018
        L_0x002a:
            if (r5 == 0) goto L_0x0033
        L_0x002c:
            boolean r8 = r8.delete()
            if (r8 == 0) goto L_0x0033
            return r2
        L_0x0033:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.ModelFileHelper.deleteRecursively(java.io.File):boolean");
    }

    public void deleteTempFilesInPrivateFolder(String str, ModelType modelType) throws MlKitException {
        File zzc2 = zzc(str, modelType, true);
        if (!deleteRecursively(zzc2)) {
            GmsLogger gmsLogger = zzd;
            String valueOf = String.valueOf(zzc2 != null ? zzc2.getAbsolutePath() : null);
            gmsLogger.e("ModelFileHelper", valueOf.length() != 0 ? "Failed to delete the temp labels file directory: ".concat(valueOf) : new String("Failed to delete the temp labels file directory: "));
        }
    }

    public int getLatestCachedModelVersion(File file) {
        File[] listFiles = file.listFiles();
        int i = -1;
        if (!(listFiles == null || (r1 = listFiles.length) == 0)) {
            for (File file2 : listFiles) {
                try {
                    i = Math.max(i, Integer.parseInt(file2.getName()));
                } catch (NumberFormatException unused) {
                    GmsLogger gmsLogger = zzd;
                    String valueOf = String.valueOf(file2.getName());
                    gmsLogger.d("ModelFileHelper", valueOf.length() != 0 ? "Contains non-integer file name ".concat(valueOf) : new String("Contains non-integer file name "));
                }
            }
        }
        return i;
    }

    public File getModelDir(String str, ModelType modelType) throws MlKitException {
        return zzc(str, modelType, false);
    }

    public File getModelDirUnsafe(String str, ModelType modelType, boolean z) {
        String str2;
        File file;
        ModelType modelType2 = ModelType.UNKNOWN;
        int ordinal = modelType.ordinal();
        if (ordinal == 1) {
            str2 = zzc;
        } else if (ordinal == 2) {
            str2 = zza;
        } else if (ordinal == 4) {
            str2 = zzb;
        } else {
            String name = modelType.name();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 69);
            sb.append("Unknown model type ");
            sb.append(name);
            sb.append(". Cannot find a dir to store the downloaded model.");
            throw new IllegalArgumentException(sb.toString());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            file = new File(this.zze.getApplicationContext().getNoBackupFilesDir(), str2);
        } else {
            file = this.zze.getApplicationContext().getDir(str2, 0);
        }
        if (z) {
            file = new File(file, "temp");
        }
        return new File(file, str);
    }

    public File getModelTempDir(String str, ModelType modelType) throws MlKitException {
        return zzc(str, modelType, true);
    }

    public File getTempFileInPrivateFolder(String str, ModelType modelType, String str2) throws MlKitException {
        File zzc2 = zzc(str, modelType, true);
        if (!zzc2.exists() || !zzc2.isFile() || zzc2.delete()) {
            if (!zzc2.exists()) {
                GmsLogger gmsLogger = zzd;
                String valueOf = String.valueOf(zzc2.getAbsolutePath());
                gmsLogger.d("ModelFileHelper", valueOf.length() != 0 ? "Temp labels folder does not exist, creating one: ".concat(valueOf) : new String("Temp labels folder does not exist, creating one: "));
                if (!zzc2.mkdirs()) {
                    throw new MlKitException("Failed to create a directory to hold the AutoML model's labels file.", 13);
                }
            }
            return new File(zzc2, str2);
        }
        String valueOf2 = String.valueOf(zzc2.getAbsolutePath());
        throw new MlKitException(valueOf2.length() != 0 ? "Failed to delete the temp labels file: ".concat(valueOf2) : new String("Failed to delete the temp labels file: "), 13);
    }

    public boolean modelExistsLocally(String str, ModelType modelType) throws MlKitException {
        String zzb2;
        if (modelType == ModelType.UNKNOWN || (zzb2 = zzb(str, modelType)) == null) {
            return false;
        }
        File file = new File(zzb2);
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(file, Constants.MODEL_FILE_NAME);
        GmsLogger gmsLogger = zzd;
        String valueOf = String.valueOf(file2.getAbsolutePath());
        gmsLogger.i("ModelFileHelper", valueOf.length() != 0 ? "Model file path: ".concat(valueOf) : new String("Model file path: "));
        return file2.exists();
    }

    public final File zza(String str, ModelType modelType) throws MlKitException {
        return zzc(str, modelType, true);
    }

    public final String zzb(String str, ModelType modelType) throws MlKitException {
        File modelDir = getModelDir(str, modelType);
        int latestCachedModelVersion = getLatestCachedModelVersion(modelDir);
        if (latestCachedModelVersion == -1) {
            return null;
        }
        String absolutePath = modelDir.getAbsolutePath();
        StringBuilder sb = new StringBuilder(String.valueOf(absolutePath).length() + 12);
        sb.append(absolutePath);
        sb.append("/");
        sb.append(latestCachedModelVersion);
        return sb.toString();
    }
}
