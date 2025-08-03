package com.google.mlkit.vision.text;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public interface TextRecognizerOptionsInterface {
    String getCreatorClass();

    Executor getExecutor();

    boolean getIsThickClient();

    int getLoggingEventId();

    String getLoggingLibraryName();

    String getModuleId();
}
