package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final class zzjf implements zzjk {
    final List<zzjk> zza;

    public zzjf(Context context, zzje zzje) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzje.zzc()) {
            arrayList.add(new zzjt(context, zzje));
        }
    }

    public final void zza(zzjc zzjc) {
        for (zzjk zza2 : this.zza) {
            zza2.zza(zzjc);
        }
    }
}
