package com.google.mlkit.vision.text;

import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.text.TextRecognizerOptions;
import com.google.mlkit.vision.text.internal.zzk;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public class TextRecognition {
    private TextRecognition() {
    }

    @Deprecated
    public static TextRecognizer getClient() {
        return ((zzk) MlKitContext.getInstance().get(zzk.class)).zza(new TextRecognizerOptions.Builder().build());
    }

    public static TextRecognizer getClient(TextRecognizerOptionsInterface textRecognizerOptionsInterface) {
        return ((zzk) MlKitContext.getInstance().get(zzk.class)).zza(textRecognizerOptionsInterface);
    }
}
