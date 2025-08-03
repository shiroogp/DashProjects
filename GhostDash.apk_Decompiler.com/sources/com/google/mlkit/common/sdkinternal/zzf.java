package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final /* synthetic */ class zzf implements Continuation {
    public static final /* synthetic */ zzf zza = new zzf();

    private /* synthetic */ zzf() {
    }

    public final Object then(Task task) {
        return (Task) task.getResult();
    }
}
