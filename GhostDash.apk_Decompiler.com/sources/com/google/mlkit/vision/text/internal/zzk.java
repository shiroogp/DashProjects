package com.google.mlkit.vision.text.internal;

import com.google.android.gms.internal.mlkit_vision_text.zzlh;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.TextRecognizerOptionsInterface;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final class zzk {
    private final zzl zza;
    private final ExecutorSelector zzb;

    zzk(zzl zzl, ExecutorSelector executorSelector) {
        this.zza = zzl;
        this.zzb = executorSelector;
    }

    public final TextRecognizer zza(TextRecognizerOptionsInterface textRecognizerOptionsInterface) {
        return new TextRecognizerImpl((zzo) this.zza.get(textRecognizerOptionsInterface), this.zzb.getExecutorToUse(textRecognizerOptionsInterface.getExecutor()), zzlh.zzb(textRecognizerOptionsInterface.getLoggingLibraryName()), textRecognizerOptionsInterface.getIsThickClient());
    }
}
