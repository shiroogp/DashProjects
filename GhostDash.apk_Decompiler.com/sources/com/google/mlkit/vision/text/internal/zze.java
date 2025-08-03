package com.google.mlkit.vision.text.internal;

import android.graphics.Point;
import com.google.android.gms.internal.mlkit_vision_text.zzab;
import com.google.android.gms.internal.mlkit_vision_text.zzr;
import com.google.android.gms.internal.mlkit_vision_text.zzu;
import com.google.mlkit.vision.text.Text;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final /* synthetic */ class zze implements zzu {
    public static final /* synthetic */ zze zza = new zze();

    private /* synthetic */ zze() {
    }

    public final Object zza(Object obj) {
        zzr zzr = (zzr) obj;
        List<Point> zzb = zza.zzb(zzr.zzb);
        return new Text.Element(zzab.zzb(zzr.zzd) ? "" : zzr.zzd, zza.zza(zzb), zzb, zzab.zzb(zzr.zzf) ? "und" : zzr.zzf);
    }
}
