package com.google.mlkit.vision.text.internal;

import android.graphics.Point;
import com.google.android.gms.internal.mlkit_vision_text.zzab;
import com.google.android.gms.internal.mlkit_vision_text.zzbs;
import com.google.android.gms.internal.mlkit_vision_text.zzl;
import com.google.android.gms.internal.mlkit_vision_text.zzu;
import com.google.mlkit.vision.text.Text;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final /* synthetic */ class zzd implements zzu {
    public static final /* synthetic */ zzd zza = new zzd();

    private /* synthetic */ zzd() {
    }

    public final Object zza(Object obj) {
        zzl zzl = (zzl) obj;
        List<Point> zzb = zza.zzb(zzl.zzb);
        return new Text.Line(zzab.zzb(zzl.zze) ? "" : zzl.zze, zza.zza(zzb), zzb, zzab.zzb(zzl.zzg) ? "und" : zzl.zzg, zzbs.zza(Arrays.asList(zzl.zza), zze.zza));
    }
}
