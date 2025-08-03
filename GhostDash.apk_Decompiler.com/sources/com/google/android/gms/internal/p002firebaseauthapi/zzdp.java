package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
final class zzdp {
    public static String zza(zzhq zzhq) throws NoSuchAlgorithmException {
        zzgr zzgr = zzgr.UNKNOWN_FORMAT;
        zzhl zzhl = zzhl.UNKNOWN_CURVE;
        zzhq zzhq2 = zzhq.UNKNOWN_HASH;
        int ordinal = zzhq.ordinal();
        if (ordinal == 1) {
            return "HmacSha1";
        }
        if (ordinal == 2) {
            return "HmacSha384";
        }
        if (ordinal == 3) {
            return "HmacSha256";
        }
        if (ordinal == 4) {
            return "HmacSha512";
        }
        if (ordinal == 5) {
            return "HmacSha224";
        }
        String valueOf = String.valueOf(zzhq);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("hash unsupported for HMAC: ");
        sb.append(valueOf);
        throw new NoSuchAlgorithmException(sb.toString());
    }

    public static void zzb(zzha zzha) throws GeneralSecurityException {
        zzkn.zzf(zzc(zzha.zzf().zzd()));
        zza(zzha.zzf().zze());
        if (zzha.zza() != zzgr.UNKNOWN_FORMAT) {
            zzbn.zzc(zzha.zzb().zzd());
            return;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }

    public static int zzc(zzhl zzhl) throws GeneralSecurityException {
        zzgr zzgr = zzgr.UNKNOWN_FORMAT;
        zzhl zzhl2 = zzhl.UNKNOWN_CURVE;
        zzhq zzhq = zzhq.UNKNOWN_HASH;
        int ordinal = zzhl.ordinal();
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                if (ordinal == 3) {
                    return 3;
                }
                String valueOf = String.valueOf(zzhl);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb.append("unknown curve type: ");
                sb.append(valueOf);
                throw new GeneralSecurityException(sb.toString());
            }
        }
        return i;
    }

    public static int zzd(zzgr zzgr) throws GeneralSecurityException {
        zzgr zzgr2 = zzgr.UNKNOWN_FORMAT;
        zzhl zzhl = zzhl.UNKNOWN_CURVE;
        zzhq zzhq = zzhq.UNKNOWN_HASH;
        int ordinal = zzgr.ordinal();
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                if (ordinal == 3) {
                    return 3;
                }
                String valueOf = String.valueOf(zzgr);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                sb.append("unknown point format: ");
                sb.append(valueOf);
                throw new GeneralSecurityException(sb.toString());
            }
        }
        return i;
    }
}
