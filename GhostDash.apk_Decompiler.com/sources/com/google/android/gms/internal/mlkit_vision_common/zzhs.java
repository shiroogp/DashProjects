package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
public final class zzhs implements zzhw {
    final List<zzhw> zza;

    public zzhs(Context context, zzhr zzhr) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzhr.zzc()) {
            arrayList.add(new zzid(context, zzhr));
        }
    }

    public final void zza(zzhy zzhy) {
        for (zzhw zza2 : this.zza) {
            zza2.zza(zzhy);
        }
    }
}
