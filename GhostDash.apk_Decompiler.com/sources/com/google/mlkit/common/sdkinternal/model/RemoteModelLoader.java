package com.google.mlkit.common.sdkinternal.model;

import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzjl;
import com.google.android.gms.internal.mlkit_common.zzjw;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import java.io.File;
import java.nio.MappedByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public class RemoteModelLoader {
    private static final GmsLogger zza = new GmsLogger("RemoteModelLoader", "");
    private static final Map<String, RemoteModelLoader> zzb = new HashMap();
    private final MlKitContext zzc;
    private final RemoteModel zzd;
    private final RemoteModelDownloadManager zze;
    private final RemoteModelFileManager zzf;
    private final RemoteModelLoaderHelper zzg;
    private final zzjl zzh;
    private boolean zzi = true;

    private RemoteModelLoader(MlKitContext mlKitContext, RemoteModel remoteModel, ModelValidator modelValidator, RemoteModelLoaderHelper remoteModelLoaderHelper, RemoteModelFileMover remoteModelFileMover) {
        RemoteModelFileManager remoteModelFileManager = new RemoteModelFileManager(mlKitContext, remoteModel, modelValidator, new ModelFileHelper(mlKitContext), remoteModelFileMover);
        this.zzf = remoteModelFileManager;
        this.zze = RemoteModelDownloadManager.getInstance(mlKitContext, remoteModel, new ModelFileHelper(mlKitContext), remoteModelFileManager, (ModelInfoRetrieverInterop) mlKitContext.get(ModelInfoRetrieverInterop.class));
        this.zzg = remoteModelLoaderHelper;
        this.zzc = mlKitContext;
        this.zzd = remoteModel;
        this.zzh = zzjw.zzb("common");
    }

    public static synchronized RemoteModelLoader getInstance(MlKitContext mlKitContext, RemoteModel remoteModel, ModelValidator modelValidator, RemoteModelLoaderHelper remoteModelLoaderHelper, RemoteModelFileMover remoteModelFileMover) {
        RemoteModelLoader remoteModelLoader;
        synchronized (RemoteModelLoader.class) {
            String uniqueModelNameForPersist = remoteModel.getUniqueModelNameForPersist();
            Map<String, RemoteModelLoader> map = zzb;
            if (!map.containsKey(uniqueModelNameForPersist)) {
                map.put(uniqueModelNameForPersist, new RemoteModelLoader(mlKitContext, remoteModel, modelValidator, remoteModelLoaderHelper, remoteModelFileMover));
            }
            remoteModelLoader = map.get(uniqueModelNameForPersist);
        }
        return remoteModelLoader;
    }

    private final MappedByteBuffer zza(String str) throws MlKitException {
        return this.zzg.loadModelAtPath(str);
    }

    private final MappedByteBuffer zzb(File file) throws MlKitException {
        try {
            return zza(file.getAbsolutePath());
        } catch (Exception e) {
            this.zzf.zzc(file);
            throw new MlKitException("Failed to load newly downloaded model.", 14, e);
        }
    }

    public RemoteModel getRemoteModel() {
        return this.zzd;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d6 A[Catch:{ Exception -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0112 A[Catch:{ Exception -> 0x00f2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.nio.MappedByteBuffer load() throws com.google.mlkit.common.MlKitException {
        /*
            r10 = this;
            monitor-enter(r10)
            com.google.android.gms.common.internal.GmsLogger r0 = zza     // Catch:{ all -> 0x0117 }
            java.lang.String r1 = "RemoteModelLoader"
            java.lang.String r2 = "Try to load newly downloaded model file."
            r0.d(r1, r2)     // Catch:{ all -> 0x0117 }
            boolean r1 = r10.zzi     // Catch:{ all -> 0x0117 }
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r2 = r10.zze     // Catch:{ all -> 0x0117 }
            java.lang.Long r2 = r2.getDownloadingId()     // Catch:{ all -> 0x0117 }
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r3 = r10.zze     // Catch:{ all -> 0x0117 }
            java.lang.String r3 = r3.getDownloadingModelHash()     // Catch:{ all -> 0x0117 }
            r4 = 0
            r5 = 0
            if (r2 == 0) goto L_0x00c7
            if (r3 != 0) goto L_0x0020
            goto L_0x00c7
        L_0x0020:
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r6 = r10.zze     // Catch:{ all -> 0x0117 }
            java.lang.Integer r6 = r6.getDownloadingModelStatusCode()     // Catch:{ all -> 0x0117 }
            if (r6 != 0) goto L_0x002f
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r1 = r10.zze     // Catch:{ all -> 0x0117 }
            r1.removeOrCancelDownload()     // Catch:{ all -> 0x0117 }
            goto L_0x00d3
        L_0x002f:
            java.lang.String r7 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0117 }
            java.lang.String r8 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0117 }
            int r8 = r8.length()     // Catch:{ all -> 0x0117 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0117 }
            int r8 = r8 + 22
            r9.<init>(r8)     // Catch:{ all -> 0x0117 }
            java.lang.String r8 = "Download Status code: "
            r9.append(r8)     // Catch:{ all -> 0x0117 }
            r9.append(r7)     // Catch:{ all -> 0x0117 }
            java.lang.String r7 = "RemoteModelLoader"
            java.lang.String r8 = r9.toString()     // Catch:{ all -> 0x0117 }
            r0.d(r7, r8)     // Catch:{ all -> 0x0117 }
            int r7 = r6.intValue()     // Catch:{ all -> 0x0117 }
            r8 = 8
            if (r7 != r8) goto L_0x00a8
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r2 = r10.zze     // Catch:{ all -> 0x0117 }
            java.io.File r2 = r2.zzi(r3)     // Catch:{ all -> 0x0117 }
            if (r2 != 0) goto L_0x0064
            goto L_0x00d3
        L_0x0064:
            java.nio.MappedByteBuffer r6 = r10.zzb(r2)     // Catch:{ all -> 0x0117 }
            java.lang.String r7 = r2.getParent()     // Catch:{ all -> 0x0117 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0117 }
            java.lang.String r8 = "Moved the downloaded model to private folder successfully: "
            int r9 = r7.length()     // Catch:{ all -> 0x0117 }
            if (r9 == 0) goto L_0x007d
            java.lang.String r7 = r8.concat(r7)     // Catch:{ all -> 0x0117 }
            goto L_0x0082
        L_0x007d:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x0117 }
            r7.<init>(r8)     // Catch:{ all -> 0x0117 }
        L_0x0082:
            java.lang.String r8 = "RemoteModelLoader"
            r0.d(r8, r7)     // Catch:{ all -> 0x0117 }
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r7 = r10.zze     // Catch:{ all -> 0x0117 }
            r7.updateLatestModelHashAndType(r3)     // Catch:{ all -> 0x0117 }
            if (r1 == 0) goto L_0x00d4
            com.google.mlkit.common.sdkinternal.model.RemoteModelFileManager r1 = r10.zzf     // Catch:{ all -> 0x0117 }
            boolean r1 = r1.zzd(r2)     // Catch:{ all -> 0x0117 }
            if (r1 == 0) goto L_0x00d4
            java.lang.String r1 = "RemoteModelLoader"
            java.lang.String r3 = "All old models are deleted."
            r0.d(r1, r3)     // Catch:{ all -> 0x0117 }
            com.google.mlkit.common.sdkinternal.model.RemoteModelFileManager r1 = r10.zzf     // Catch:{ all -> 0x0117 }
            java.io.File r1 = r1.zza(r2)     // Catch:{ all -> 0x0117 }
            java.nio.MappedByteBuffer r6 = r10.zzb(r1)     // Catch:{ all -> 0x0117 }
            goto L_0x00d4
        L_0x00a8:
            int r1 = r6.intValue()     // Catch:{ all -> 0x0117 }
            r3 = 16
            if (r1 != r3) goto L_0x00d3
            com.google.android.gms.internal.mlkit_common.zzjl r1 = r10.zzh     // Catch:{ all -> 0x0117 }
            com.google.android.gms.internal.mlkit_common.zzjc r3 = com.google.android.gms.internal.mlkit_common.zzjo.zzg()     // Catch:{ all -> 0x0117 }
            com.google.mlkit.common.model.RemoteModel r6 = r10.zzd     // Catch:{ all -> 0x0117 }
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r7 = r10.zze     // Catch:{ all -> 0x0117 }
            int r2 = r7.getFailureReason(r2)     // Catch:{ all -> 0x0117 }
            r1.zzd(r3, r6, r4, r2)     // Catch:{ all -> 0x0117 }
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r1 = r10.zze     // Catch:{ all -> 0x0117 }
            r1.removeOrCancelDownload()     // Catch:{ all -> 0x0117 }
            goto L_0x00d3
        L_0x00c7:
            java.lang.String r1 = "RemoteModelLoader"
            java.lang.String r2 = "No new model is downloading."
            r0.d(r1, r2)     // Catch:{ all -> 0x0117 }
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r1 = r10.zze     // Catch:{ all -> 0x0117 }
            r1.removeOrCancelDownload()     // Catch:{ all -> 0x0117 }
        L_0x00d3:
            r6 = r5
        L_0x00d4:
            if (r6 != 0) goto L_0x0112
            java.lang.String r1 = "RemoteModelLoader"
            java.lang.String r2 = "Loading existing model file."
            r0.d(r1, r2)     // Catch:{ all -> 0x0117 }
            com.google.mlkit.common.sdkinternal.model.RemoteModelFileManager r1 = r10.zzf     // Catch:{ all -> 0x0117 }
            java.lang.String r1 = r1.zzb()     // Catch:{ all -> 0x0117 }
            if (r1 != 0) goto L_0x00ed
            java.lang.String r1 = "RemoteModelLoader"
            java.lang.String r2 = "No existing model file"
            r0.d(r1, r2)     // Catch:{ all -> 0x0117 }
            goto L_0x0115
        L_0x00ed:
            java.nio.MappedByteBuffer r5 = r10.zza(r1)     // Catch:{ Exception -> 0x00f2 }
            goto L_0x0115
        L_0x00f2:
            r0 = move-exception
            com.google.mlkit.common.sdkinternal.model.RemoteModelFileManager r2 = r10.zzf     // Catch:{ all -> 0x0117 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0117 }
            r3.<init>(r1)     // Catch:{ all -> 0x0117 }
            r2.zzc(r3)     // Catch:{ all -> 0x0117 }
            com.google.mlkit.common.sdkinternal.MlKitContext r1 = r10.zzc     // Catch:{ all -> 0x0117 }
            com.google.mlkit.common.sdkinternal.SharedPrefManager r1 = com.google.mlkit.common.sdkinternal.SharedPrefManager.getInstance(r1)     // Catch:{ all -> 0x0117 }
            com.google.mlkit.common.model.RemoteModel r2 = r10.zzd     // Catch:{ all -> 0x0117 }
            r1.clearLatestModelHash(r2)     // Catch:{ all -> 0x0117 }
            com.google.mlkit.common.MlKitException r1 = new com.google.mlkit.common.MlKitException     // Catch:{ all -> 0x0117 }
            java.lang.String r2 = "Failed to load an already downloaded model."
            r3 = 14
            r1.<init>(r2, r3, r0)     // Catch:{ all -> 0x0117 }
            throw r1     // Catch:{ all -> 0x0117 }
        L_0x0112:
            r10.zzi = r4     // Catch:{ all -> 0x0117 }
            r5 = r6
        L_0x0115:
            monitor-exit(r10)
            return r5
        L_0x0117:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.RemoteModelLoader.load():java.nio.MappedByteBuffer");
    }
}
