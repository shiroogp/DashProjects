package com.google.mlkit.vision.text.internal;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.text.TextRecognizerOptionsInterface;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final class zzl extends LazyInstanceMap<TextRecognizerOptionsInterface, zzo> {
    private final MlKitContext zza;

    public zzl(MlKitContext mlKitContext) {
        this.zza = mlKitContext;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        return new zzo(this.zza, (TextRecognizerOptionsInterface) obj);
    }
}
