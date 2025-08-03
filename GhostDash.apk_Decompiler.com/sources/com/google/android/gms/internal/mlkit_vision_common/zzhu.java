package com.google.android.gms.internal.mlkit_vision_common;

import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
public final /* synthetic */ class zzhu implements Callable {
    public final /* synthetic */ SharedPrefManager zza;

    public /* synthetic */ zzhu(SharedPrefManager sharedPrefManager) {
        this.zza = sharedPrefManager;
    }

    public final Object call() {
        return this.zza.getMlSdkInstanceId();
    }
}
