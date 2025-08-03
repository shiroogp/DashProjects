package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@17.2.0 */
final class zzah<E> extends zzab<E> {
    private final zzaj<E> zza;

    zzah(zzaj<E> zzaj, int i) {
        super(zzaj.size(), i);
        this.zza = zzaj;
    }

    /* access modifiers changed from: protected */
    public final E zza(int i) {
        return this.zza.get(i);
    }
}
