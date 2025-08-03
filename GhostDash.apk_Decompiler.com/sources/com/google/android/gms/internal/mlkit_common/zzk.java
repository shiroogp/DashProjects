package com.google.android.gms.internal.mlkit_common;

import java.io.FileDescriptor;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final /* synthetic */ class zzk implements Callable {
    public final /* synthetic */ FileDescriptor zza;

    public /* synthetic */ zzk(FileDescriptor fileDescriptor) {
        this.zza = fileDescriptor;
    }

    public final Object call() {
        return zzm.zze(zzm.zzc.invoke(zzm.zzg, new Object[]{this.zza}));
    }
}
