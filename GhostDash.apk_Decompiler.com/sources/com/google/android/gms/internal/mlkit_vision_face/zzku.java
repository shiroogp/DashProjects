package com.google.android.gms.internal.mlkit_vision_face;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final class zzku implements zzkz {
    final List<zzkz> zza;

    public zzku(Context context, zzkt zzkt) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzkt.zzc()) {
            arrayList.add(new zzli(context, zzkt));
        }
    }

    public final void zza(zzld zzld) {
        for (zzkz zza2 : this.zza) {
            zza2.zza(zzld);
        }
    }
}
