package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
final class zzp<E> extends zzo<E> {
    static final zzo<Object> zza = new zzp(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzp(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    public final E get(int i) {
        zzf.zza(i, this.zzc, "index");
        E e = this.zzb[i];
        e.getClass();
        return e;
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zze() {
        return this.zzb;
    }
}
