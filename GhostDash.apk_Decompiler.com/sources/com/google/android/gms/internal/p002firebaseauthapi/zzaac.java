package com.google.android.gms.internal.p002firebaseauthapi;

import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;
import org.spongycastle.i18n.LocalizedMessage;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaac  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzaac {
    static final Charset zza = Charset.forName(Key.STRING_CHARSET_NAME);
    static final Charset zzb = Charset.forName(LocalizedMessage.DEFAULT_ENCODING);
    public static final byte[] zzc;
    public static final ByteBuffer zzd;
    public static final zzyx zze;

    static {
        byte[] bArr = new byte[0];
        zzc = bArr;
        zzd = ByteBuffer.wrap(bArr);
        zze = zzyx.zzu(bArr, 0, 0, false);
    }

    public static int zza(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zzb(byte[] bArr) {
        int length = bArr.length;
        int zzd2 = zzd(length, bArr, 0, length);
        if (zzd2 == 0) {
            return 1;
        }
        return zzd2;
    }

    public static int zzc(long j) {
        return (int) (j ^ (j >>> 32));
    }

    static int zzd(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static <T> T zze(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    static <T> T zzf(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    static Object zzg(Object obj, Object obj2) {
        return ((zzaaz) obj).zzC().zzh((zzaaz) obj2).zzm();
    }

    public static String zzh(byte[] bArr) {
        return new String(bArr, zza);
    }

    public static boolean zzi(byte[] bArr) {
        return zzaco.zze(bArr);
    }
}
