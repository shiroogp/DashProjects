package com.google.android.gms.internal.mlkit_common;

import android.system.Os;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final /* synthetic */ class zzi implements Callable {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzi(String str) {
        this.zza = str;
    }

    public final Object call() {
        return Os.lstat(this.zza);
    }
}
