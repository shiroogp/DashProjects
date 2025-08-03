package com.google.android.gms.internal.mlkit_vision_text;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final class zzkr implements zzkv {
    final List<zzkv> zza;

    public zzkr(Context context, zzkq zzkq) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzkq.zzc()) {
            arrayList.add(new zzle(context, zzkq));
        }
    }

    public final void zza(zzkz zzkz) {
        for (zzkv zza2 : this.zza) {
            zza2.zza(zzkz);
        }
    }
}
