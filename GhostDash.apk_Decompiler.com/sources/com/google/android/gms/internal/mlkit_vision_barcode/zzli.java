package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final class zzli implements zzln {
    final List<zzln> zza;

    public zzli(Context context, zzlh zzlh) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzlh.zzc()) {
            arrayList.add(new zzlw(context, zzlh));
        }
    }

    public final void zza(zzlr zzlr) {
        for (zzln zza2 : this.zza) {
            zza2.zza(zzlr);
        }
    }
}
