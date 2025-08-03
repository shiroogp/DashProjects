package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.internal.LibraryVersion;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final /* synthetic */ class zzkx implements Callable {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzkx(String str) {
        this.zza = str;
    }

    public final Object call() {
        return LibraryVersion.getInstance().getVersion(this.zza);
    }
}
