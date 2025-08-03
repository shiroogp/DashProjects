package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.common.internal.LibraryVersion;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
public final /* synthetic */ class zzhv implements Callable {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzhv(String str) {
        this.zza = str;
    }

    public final Object call() {
        return LibraryVersion.getInstance().getVersion(this.zza);
    }
}
