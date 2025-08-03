package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final class zzjl {
    private static zzaj<String> zza;
    private final String zzb;
    private final String zzc;
    private final zzjk zzd;
    private final SharedPrefManager zze;
    private final Task<String> zzf;
    private final Task<String> zzg;
    private final String zzh;
    private final Map<zzgv, Long> zzi = new HashMap();
    private final Map<zzgv, Object> zzj = new HashMap();

    public zzjl(Context context, SharedPrefManager sharedPrefManager, zzjk zzjk, String str) {
        this.zzb = context.getPackageName();
        this.zzc = CommonUtils.getAppVersion(context);
        this.zze = sharedPrefManager;
        this.zzd = zzjk;
        this.zzh = str;
        this.zzf = MLTaskExecutor.getInstance().scheduleCallable(new zzjj(str));
        MLTaskExecutor instance = MLTaskExecutor.getInstance();
        sharedPrefManager.getClass();
        this.zzg = instance.scheduleCallable(new zzji(sharedPrefManager));
    }

    private static synchronized zzaj<String> zzg() {
        synchronized (zzjl.class) {
            zzaj<String> zzaj = zza;
            if (zzaj != null) {
                return zzaj;
            }
            LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
            zzag zzag = new zzag();
            for (int i = 0; i < locales.size(); i++) {
                zzag.zzb(CommonUtils.languageTagFromLocale(locales.get(i)));
            }
            zzaj<String> zzc2 = zzag.zzc();
            zza = zzc2;
            return zzc2;
        }
    }

    private final zzir zzh(String str, String str2) {
        String str3;
        zzir zzir = new zzir();
        zzir.zzb(this.zzb);
        zzir.zzc(this.zzc);
        zzir.zzh(zzg());
        zzir.zzg(true);
        zzir.zzk(str);
        zzir.zzj(str2);
        if (this.zzg.isSuccessful()) {
            str3 = this.zzg.getResult();
        } else {
            str3 = this.zze.getMlSdkInstanceId();
        }
        zzir.zzi(str3);
        zzir.zzd(10);
        return zzir;
    }

    private final String zzi() {
        if (this.zzf.isSuccessful()) {
            return this.zzf.getResult();
        }
        return LibraryVersion.getInstance().getVersion(this.zzh);
    }

    public final /* synthetic */ void zza(zzjc zzjc, zzgv zzgv, String str) {
        zzjc.zza(zzgv);
        zzjc.zzc(zzh(zzjc.zzd(), str));
        this.zzd.zza(zzjc);
    }

    public final /* synthetic */ void zzb(zzjc zzjc, zzjn zzjn, RemoteModel remoteModel) {
        zzjc.zza(zzgv.MODEL_DOWNLOAD);
        zzjc.zzc(zzh(zzjn.zze(), zzi()));
        zzjc.zzb(zzjx.zza(remoteModel, this.zze, zzjn));
        this.zzd.zza(zzjc);
    }

    public final void zzc(zzjc zzjc, zzgv zzgv) {
        MLTaskExecutor.workerThreadExecutor().execute(new zzjg(this, zzjc, zzgv, zzi()));
    }

    public final void zzd(zzjc zzjc, RemoteModel remoteModel, boolean z, int i) {
        zzjm zzh2 = zzjn.zzh();
        zzh2.zzf(false);
        zzh2.zzd(remoteModel.getModelType());
        zzh2.zza(zzhb.FAILED);
        zzh2.zzb(zzgu.DOWNLOAD_FAILED);
        zzh2.zzc(i);
        zzf(zzjc, remoteModel, zzh2.zzh());
    }

    public final void zze(zzjc zzjc, RemoteModel remoteModel, zzgu zzgu, boolean z, ModelType modelType, zzhb zzhb) {
        zzjm zzh2 = zzjn.zzh();
        zzh2.zzf(z);
        zzh2.zzd(modelType);
        zzh2.zzb(zzgu);
        zzh2.zza(zzhb);
        zzf(zzjc, remoteModel, zzh2.zzh());
    }

    public final void zzf(zzjc zzjc, RemoteModel remoteModel, zzjn zzjn) {
        MLTaskExecutor.workerThreadExecutor().execute(new zzjh(this, zzjc, zzjn, remoteModel));
    }
}
