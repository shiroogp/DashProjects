package com.google.mlkit.common.sdkinternal.model;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzgu;
import com.google.android.gms.internal.mlkit_common.zzhb;
import com.google.android.gms.internal.mlkit_common.zzjo;
import com.google.android.gms.internal.mlkit_common.zzjw;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.internal.model.ModelUtils;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import com.google.mlkit.common.sdkinternal.model.ModelValidator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public class RemoteModelFileManager {
    private static final GmsLogger zza = new GmsLogger("RemoteModelFileManager", "");
    private final MlKitContext zzb;
    private final String zzc;
    private final ModelType zzd;
    private final ModelValidator zze;
    private final RemoteModelFileMover zzf;
    private final SharedPrefManager zzg;
    private final ModelFileHelper zzh;

    public RemoteModelFileManager(MlKitContext mlKitContext, RemoteModel remoteModel, ModelValidator modelValidator, ModelFileHelper modelFileHelper, RemoteModelFileMover remoteModelFileMover) {
        String str;
        this.zzb = mlKitContext;
        ModelType modelType = remoteModel.getModelType();
        this.zzd = modelType;
        if (modelType == ModelType.TRANSLATE) {
            str = remoteModel.getModelNameForBackend();
        } else {
            str = remoteModel.getUniqueModelNameForPersist();
        }
        this.zzc = str;
        this.zze = modelValidator;
        this.zzg = SharedPrefManager.getInstance(mlKitContext);
        this.zzh = modelFileHelper;
        this.zzf = remoteModelFileMover;
    }

    public File getModelDirUnsafe(boolean z) {
        return this.zzh.getModelDirUnsafe(this.zzc, this.zzd, z);
    }

    public synchronized File moveModelToPrivateFolder(ParcelFileDescriptor parcelFileDescriptor, String str, RemoteModel remoteModel) throws MlKitException {
        File file;
        FileOutputStream fileOutputStream;
        MlKitException mlKitException;
        String str2;
        ModelValidator modelValidator;
        file = new File(this.zzh.zza(this.zzc, this.zzd), "to_be_validated_model.tmp");
        ModelValidator.ValidationResult validationResult = null;
        try {
            ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
            try {
                fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = autoCloseInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.getFD().sync();
                fileOutputStream.close();
                autoCloseInputStream.close();
                boolean zza2 = ModelUtils.zza(file, str);
                if (zza2 && (modelValidator = this.zze) != null) {
                    validationResult = modelValidator.validateModel(file, remoteModel);
                    if (validationResult.getErrorCode().equals(ModelValidator.ValidationResult.ErrorCode.TFLITE_VERSION_INCOMPATIBLE)) {
                        String appVersion = CommonUtils.getAppVersion(this.zzb.getApplicationContext());
                        this.zzg.setIncompatibleModelInfo(remoteModel, str, appVersion);
                        GmsLogger gmsLogger = zza;
                        String valueOf = String.valueOf(str);
                        gmsLogger.d("RemoteModelFileManager", valueOf.length() != 0 ? "Model is not compatible. Model hash: ".concat(valueOf) : new String("Model is not compatible. Model hash: "));
                        String valueOf2 = String.valueOf(appVersion);
                        gmsLogger.d("RemoteModelFileManager", valueOf2.length() != 0 ? "The current app version is: ".concat(valueOf2) : new String("The current app version is: "));
                    }
                }
                if (zza2) {
                    if (validationResult == null || validationResult.isValid()) {
                    }
                }
                if (!zza2) {
                    GmsLogger gmsLogger2 = zza;
                    String valueOf3 = String.valueOf(str);
                    gmsLogger2.d("RemoteModelFileManager", valueOf3.length() != 0 ? "Hash does not match with expected: ".concat(valueOf3) : new String("Hash does not match with expected: "));
                    zzjw.zzb("common").zze(zzjo.zzg(), remoteModel, zzgu.MODEL_HASH_MISMATCH, true, this.zzd, zzhb.SUCCEEDED);
                    mlKitException = new MlKitException("Hash does not match with expected", 102);
                } else {
                    mlKitException = new MlKitException("Model is not compatible with TFLite run time", 100);
                }
                if (!file.delete()) {
                    GmsLogger gmsLogger3 = zza;
                    String valueOf4 = String.valueOf(file.getAbsolutePath());
                    if (valueOf4.length() != 0) {
                        str2 = "Failed to delete the temp file: ".concat(valueOf4);
                    } else {
                        str2 = new String("Failed to delete the temp file: ");
                    }
                    gmsLogger3.d("RemoteModelFileManager", str2);
                }
                throw mlKitException;
            } catch (Throwable th) {
                autoCloseInputStream.close();
                throw th;
            }
        } catch (IOException e) {
            GmsLogger gmsLogger4 = zza;
            String valueOf5 = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf5).length() + 56);
            sb.append("Failed to copy downloaded model file to private folder: ");
            sb.append(valueOf5);
            gmsLogger4.e("RemoteModelFileManager", sb.toString());
            return null;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        return this.zzf.moveAllFilesFromPrivateTempToPrivateDestination(file);
        throw th;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002d, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002b, code lost:
        if (r4.renameTo(r1) == false) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.io.File zza(java.io.File r4) throws com.google.mlkit.common.MlKitException {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.mlkit.common.sdkinternal.model.ModelFileHelper r0 = r3.zzh     // Catch:{ all -> 0x002f }
            java.lang.String r1 = r3.zzc     // Catch:{ all -> 0x002f }
            com.google.mlkit.common.sdkinternal.ModelType r2 = r3.zzd     // Catch:{ all -> 0x002f }
            java.io.File r0 = r0.getModelDir(r1, r2)     // Catch:{ all -> 0x002f }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x002f }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x002f }
            java.lang.String r1 = "/0"
            java.lang.String r0 = r0.concat(r1)     // Catch:{ all -> 0x002f }
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x002f }
            r1.<init>(r0)     // Catch:{ all -> 0x002f }
            boolean r0 = r1.exists()     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x0026
            monitor-exit(r3)
            return r4
        L_0x0026:
            boolean r0 = r4.renameTo(r1)     // Catch:{ all -> 0x002f }
            monitor-exit(r3)
            if (r0 == 0) goto L_0x002e
            return r1
        L_0x002e:
            return r4
        L_0x002f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.RemoteModelFileManager.zza(java.io.File):java.io.File");
    }

    public final synchronized String zzb() throws MlKitException {
        return this.zzh.zzb(this.zzc, this.zzd);
    }

    public final synchronized void zzc(File file) {
        File modelDirUnsafe = getModelDirUnsafe(false);
        if (modelDirUnsafe.exists()) {
            File[] listFiles = modelDirUnsafe.listFiles();
            if (listFiles != null) {
                for (File equals : listFiles) {
                    if (equals.equals(file)) {
                        this.zzh.deleteRecursively(file);
                        return;
                    }
                }
            }
        }
    }

    public final synchronized boolean zzd(File file) throws MlKitException {
        File modelDir = this.zzh.getModelDir(this.zzc, this.zzd);
        if (!modelDir.exists()) {
            return false;
        }
        File[] listFiles = modelDir.listFiles();
        boolean z = true;
        if (listFiles == null) {
            return true;
        }
        for (File file2 : listFiles) {
            if (!file2.equals(file) && !this.zzh.deleteRecursively(file2)) {
                z = false;
            }
        }
        return z;
    }
}
