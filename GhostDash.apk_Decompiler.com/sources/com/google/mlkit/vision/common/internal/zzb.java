package com.google.mlkit.vision.common.internal;

import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
public final /* synthetic */ class zzb implements OnFailureListener {
    public static final /* synthetic */ zzb zza = new zzb();

    private /* synthetic */ zzb() {
    }

    public final void onFailure(Exception exc) {
        MobileVisionBase.zzb.e("MobileVisionBase", "Error preloading model resource", exc);
    }
}
