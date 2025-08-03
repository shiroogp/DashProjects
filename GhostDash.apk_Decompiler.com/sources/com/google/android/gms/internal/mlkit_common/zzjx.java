package com.google.android.gms.internal.mlkit_common;

import android.os.SystemClock;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final class zzjx {
    private static final GmsLogger zza = new GmsLogger("RemoteModelUtils", "");

    public static zzhc zza(RemoteModel remoteModel, SharedPrefManager sharedPrefManager, zzjn zzjn) {
        zzhf zzhf;
        ModelType zzb = zzjn.zzb();
        String modelHash = remoteModel.getModelHash();
        zzhj zzhj = new zzhj();
        zzhe zzhe = new zzhe();
        zzhe.zzc(remoteModel.getModelNameForBackend());
        zzhe.zzd(zzhg.CLOUD);
        zzhe.zza(zzaa.zzb(modelHash));
        ModelType modelType = ModelType.UNKNOWN;
        int ordinal = zzb.ordinal();
        if (ordinal == 2) {
            zzhf = zzhf.BASE_TRANSLATE;
        } else if (ordinal == 4) {
            zzhf = zzhf.CUSTOM;
        } else if (ordinal != 5) {
            zzhf = zzhf.TYPE_UNKNOWN;
        } else {
            zzhf = zzhf.BASE_DIGITAL_INK;
        }
        zzhe.zzb(zzhf);
        zzhj.zzb(zzhe.zzg());
        zzhl zzc = zzhj.zzc();
        zzha zzha = new zzha();
        zzha.zzd(zzjn.zzc());
        zzha.zzc(zzjn.zzd());
        zzha.zzb(Long.valueOf((long) zzjn.zza()));
        zzha.zzf(zzc);
        if (zzjn.zzg()) {
            long modelDownloadBeginTimeMs = sharedPrefManager.getModelDownloadBeginTimeMs(remoteModel);
            if (modelDownloadBeginTimeMs == 0) {
                zza.w("RemoteModelUtils", "Model downloaded without its beginning time recorded.");
            } else {
                long modelFirstUseTimeMs = sharedPrefManager.getModelFirstUseTimeMs(remoteModel);
                if (modelFirstUseTimeMs == 0) {
                    modelFirstUseTimeMs = SystemClock.elapsedRealtime();
                    sharedPrefManager.setModelFirstUseTimeMs(remoteModel, modelFirstUseTimeMs);
                }
                zzha.zzg(Long.valueOf(modelFirstUseTimeMs - modelDownloadBeginTimeMs));
            }
        }
        if (zzjn.zzf()) {
            long modelDownloadBeginTimeMs2 = sharedPrefManager.getModelDownloadBeginTimeMs(remoteModel);
            if (modelDownloadBeginTimeMs2 == 0) {
                zza.w("RemoteModelUtils", "Model downloaded without its beginning time recorded.");
            } else {
                zzha.zze(Long.valueOf(SystemClock.elapsedRealtime() - modelDownloadBeginTimeMs2));
            }
        }
        return zzha.zzi();
    }
}
