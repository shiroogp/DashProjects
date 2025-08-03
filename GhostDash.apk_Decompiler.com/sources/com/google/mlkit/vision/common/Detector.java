package com.google.mlkit.vision.common;

import androidx.lifecycle.LifecycleObserver;
import com.google.android.gms.tasks.Task;
import java.io.Closeable;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
public interface Detector<DetectionResultT> extends Closeable, LifecycleObserver {
    Task<DetectionResultT> process(InputImage inputImage);
}
