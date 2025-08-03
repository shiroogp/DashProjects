package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.common.internal.LibraryVersion;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final /* synthetic */ class zzjj implements Callable {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzjj(String str) {
        this.zza = str;
    }

    public final Object call() {
        return LibraryVersion.getInstance().getVersion(this.zza);
    }
}
