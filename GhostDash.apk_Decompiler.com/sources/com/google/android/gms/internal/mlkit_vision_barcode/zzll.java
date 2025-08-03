package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.internal.LibraryVersion;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final /* synthetic */ class zzll implements Callable {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzll(String str) {
        this.zza = str;
    }

    public final Object call() {
        return LibraryVersion.getInstance().getVersion(this.zza);
    }
}
