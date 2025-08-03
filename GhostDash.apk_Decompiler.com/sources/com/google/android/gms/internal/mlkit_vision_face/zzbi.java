package com.google.android.gms.internal.mlkit_vision_face;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
final class zzbi<K, V> extends zzaq<K, V> implements Serializable {
    @NullableDecl
    final K zza;
    @NullableDecl
    final V zzb;

    zzbi(@NullableDecl K k, @NullableDecl V v) {
        this.zza = k;
        this.zzb = v;
    }

    @NullableDecl
    public final K getKey() {
        return this.zza;
    }

    @NullableDecl
    public final V getValue() {
        return this.zzb;
    }

    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}
