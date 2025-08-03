package com.google.android.gms.internal.mlkit_common;

import android.system.Os;
import java.io.FileDescriptor;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final /* synthetic */ class zzh implements Callable {
    public final /* synthetic */ FileDescriptor zza;

    public /* synthetic */ zzh(FileDescriptor fileDescriptor) {
        this.zza = fileDescriptor;
    }

    public final Object call() {
        return Os.fstat(this.zza);
    }
}
