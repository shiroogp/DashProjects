package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import androidx.core.content.ContextCompat;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final /* synthetic */ class zzb implements Callable {
    public final /* synthetic */ Context zza;

    public /* synthetic */ zzb(Context context) {
        this.zza = context;
    }

    public final Object call() {
        Context context = this.zza;
        int i = zzg.zza;
        return ContextCompat.getExternalFilesDirs(context, (String) null);
    }
}
