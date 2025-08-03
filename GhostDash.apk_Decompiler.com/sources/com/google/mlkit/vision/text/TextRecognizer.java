package com.google.mlkit.vision.text;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.android.gms.tasks.Task;
import com.google.android.odml.image.MlImage;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.Detector;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public interface TextRecognizer extends Detector<Text> {
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void close();

    Task<Text> process(MlImage mlImage);

    Task<Text> process(InputImage inputImage);
}
