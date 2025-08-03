package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
public enum zzfm implements zzv {
    SOURCE_UNKNOWN(0),
    BITMAP(1),
    BYTEARRAY(2),
    BYTEBUFFER(3),
    FILEPATH(4),
    ANDROID_MEDIA_IMAGE(5);
    
    private final int zzh;

    private zzfm(int i) {
        this.zzh = i;
    }

    public final int zza() {
        return this.zzh;
    }
}
