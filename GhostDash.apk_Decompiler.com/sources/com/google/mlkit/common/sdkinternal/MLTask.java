package com.google.mlkit.common.sdkinternal;

import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTaskInput;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public abstract class MLTask<T, S extends MLTaskInput> extends ModelResource {
    public abstract T run(S s) throws MlKitException;
}
