package com.google.android.gms.internal.mlkit_vision_face;

import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final /* synthetic */ class zzkw implements Callable {
    public final /* synthetic */ SharedPrefManager zza;

    public /* synthetic */ zzkw(SharedPrefManager sharedPrefManager) {
        this.zza = sharedPrefManager;
    }

    public final Object call() {
        return this.zza.getMlSdkInstanceId();
    }
}
