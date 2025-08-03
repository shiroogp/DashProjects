package com.google.mlkit.vision.face;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.android.gms.tasks.Task;
import com.google.android.odml.image.MlImage;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.Detector;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public interface FaceDetector extends Detector<List<Face>> {
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void close();

    Task<List<Face>> process(MlImage mlImage);

    Task<List<Face>> process(InputImage inputImage);
}
