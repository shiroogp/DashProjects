package com.google.android.gms.internal.mlkit_vision_text;

import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final class zzbs {
    public static <F, T> List<T> zza(List<F> list, zzu<? super F, ? extends T> zzu) {
        if (list instanceof RandomAccess) {
            return new zzbp(list, zzu);
        }
        return new zzbr(list, zzu);
    }
}
