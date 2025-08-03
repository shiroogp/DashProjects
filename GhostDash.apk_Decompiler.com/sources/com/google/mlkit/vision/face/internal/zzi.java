package com.google.mlkit.vision.face.internal;

import com.google.android.gms.internal.mlkit_vision_face.zzis;
import com.google.android.gms.internal.mlkit_vision_face.zziv;
import com.google.android.gms.internal.mlkit_vision_face.zzjk;
import com.google.android.gms.internal.mlkit_vision_face.zzky;
import com.google.android.gms.internal.mlkit_vision_face.zzld;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final /* synthetic */ class zzi implements zzky {
    public final /* synthetic */ boolean zza;
    public final /* synthetic */ zzis zzb;

    public /* synthetic */ zzi(boolean z, zzis zzis) {
        this.zza = z;
        this.zzb = zzis;
    }

    public final zzld zza() {
        boolean z = this.zza;
        zzis zzis = this.zzb;
        zziv zziv = new zziv();
        zziv.zze(Boolean.valueOf(z));
        zzjk zzjk = new zzjk();
        zzjk.zzb(zzis);
        zziv.zzg(zzjk.zzc());
        return zzld.zzd(zziv);
    }
}
