package com.google.android.gms.internal.mlkit_vision_text;

import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final /* synthetic */ class zzkx implements OnFailureListener {
    public final /* synthetic */ zzky zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zzkx(zzky zzky, long j) {
        this.zza = zzky;
        this.zzb = j;
    }

    public final void onFailure(Exception exc) {
        this.zza.zzb(this.zzb, exc);
    }
}
