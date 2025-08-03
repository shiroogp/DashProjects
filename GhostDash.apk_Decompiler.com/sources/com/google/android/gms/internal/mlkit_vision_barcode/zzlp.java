package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final /* synthetic */ class zzlp implements OnFailureListener {
    public final /* synthetic */ zzlq zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zzlp(zzlq zzlq, long j) {
        this.zza = zzlq;
        this.zzb = j;
    }

    public final void onFailure(Exception exc) {
        this.zza.zzb(this.zzb, exc);
    }
}
