package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Iterator;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final class zzbm {
    static void zza(Iterator<?> it2) {
        Objects.requireNonNull(it2);
        while (it2.hasNext()) {
            it2.next();
            it2.remove();
        }
    }
}
