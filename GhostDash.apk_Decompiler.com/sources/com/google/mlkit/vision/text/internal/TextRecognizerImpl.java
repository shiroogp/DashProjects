package com.google.mlkit.vision.text.internal;

import com.google.android.gms.internal.mlkit_vision_text.zzis;
import com.google.android.gms.internal.mlkit_vision_text.zziu;
import com.google.android.gms.internal.mlkit_vision_text.zzka;
import com.google.android.gms.internal.mlkit_vision_text.zzkw;
import com.google.android.gms.internal.mlkit_vision_text.zzkz;
import com.google.android.gms.tasks.Task;
import com.google.android.odml.image.MlImage;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognizer;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public class TextRecognizerImpl extends MobileVisionBase<Text> implements TextRecognizer {
    TextRecognizerImpl(zzo zzo, Executor executor, zzkw zzkw, boolean z) {
        super(zzo, executor);
        zziu zziu = new zziu();
        zziu.zze(Boolean.valueOf(z));
        zziu.zzf(new zzka().zze());
        zzkw.zzc(zzkz.zze(zziu, 1), zzis.ON_DEVICE_TEXT_CREATE);
    }

    public final Task<Text> process(MlImage mlImage) {
        return super.processBase(mlImage);
    }

    public final Task<Text> process(InputImage inputImage) {
        return super.processBase(inputImage);
    }
}
