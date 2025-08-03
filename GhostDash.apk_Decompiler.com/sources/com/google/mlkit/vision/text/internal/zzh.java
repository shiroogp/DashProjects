package com.google.mlkit.vision.text.internal;

import java.util.Comparator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final /* synthetic */ class zzh implements Comparator {
    public static final /* synthetic */ zzh zza = new zzh();

    private /* synthetic */ zzh() {
    }

    public final int compare(Object obj, Object obj2) {
        return ((Integer) ((Map.Entry) obj).getValue()).compareTo((Integer) ((Map.Entry) obj2).getValue());
    }
}
