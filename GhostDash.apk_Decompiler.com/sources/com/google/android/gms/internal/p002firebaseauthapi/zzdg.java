package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzdg extends zzbi<zzhd, zzhg> {
    /* access modifiers changed from: private */
    public static final byte[] zza = new byte[0];

    zzdg() {
        super(zzhd.class, zzhg.class, new zzde(zzal.class));
    }

    static /* synthetic */ zzas zzk(zzhl zzhl, zzhq zzhq, zzgr zzgr, zzaq zzaq, byte[] bArr, int i) {
        zzjk zzjk;
        zzgw zza2 = zzgx.zza();
        zzhi zza3 = zzhj.zza();
        zza3.zza(zzhl);
        zza3.zzb(zzhq);
        zza3.zzc(zzyu.zzn(bArr));
        zzhj zzhj = (zzhj) zza3.zzk();
        zzii zza4 = zzij.zza();
        zza4.zzb(zzaq.zzb());
        zza4.zzc(zzyu.zzn(zzaq.zzc()));
        int zzd = zzaq.zzd() - 1;
        if (zzd == 0) {
            zzjk = zzjk.TINK;
        } else if (zzd == 1) {
            zzjk = zzjk.LEGACY;
        } else if (zzd != 2) {
            zzjk = zzjk.CRUNCHY;
        } else {
            zzjk = zzjk.RAW;
        }
        zza4.zza(zzjk);
        zzgt zza5 = zzgu.zza();
        zza5.zza((zzij) zza4.zzk());
        zzgz zzc = zzha.zzc();
        zzc.zzc(zzhj);
        zzc.zza((zzgu) zza5.zzk());
        zzc.zzb(zzgr);
        zza2.zza((zzha) zzc.zzk());
        return new zzas((zzgx) zza2.zzk(), i);
    }

    public static final void zzl(zzhd zzhd) throws GeneralSecurityException {
        if (zzhd.zzf().zzd() != 0) {
            zzli.zzc(zzhd.zza(), 0);
            zzdp.zzb(zzhd.zze().zzb());
            return;
        }
        throw new GeneralSecurityException("invalid ECIES private key");
    }

    public final zzat<zzgx, zzhd> zza() {
        return new zzdf(this, zzgx.class);
    }

    public final zzid zzb() {
        return zzid.ASYMMETRIC_PRIVATE;
    }

    public final /* bridge */ /* synthetic */ zzaaz zzc(zzyu zzyu) throws zzaae {
        return zzhd.zzd(zzyu, zzzj.zza());
    }

    public final String zzg() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    public final /* bridge */ /* synthetic */ void zzi(zzaaz zzaaz) throws GeneralSecurityException {
        zzl((zzhd) zzaaz);
    }
}
