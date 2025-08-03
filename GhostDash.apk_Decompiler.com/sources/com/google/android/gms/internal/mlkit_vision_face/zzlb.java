package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final /* synthetic */ class zzlb implements OnFailureListener {
    public final /* synthetic */ zzlc zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zzlb(zzlc zzlc, long j) {
        this.zza = zzlc;
        this.zzb = j;
    }

    public final void onFailure(Exception exc) {
        this.zza.zzb(this.zzb, exc);
    }
}
