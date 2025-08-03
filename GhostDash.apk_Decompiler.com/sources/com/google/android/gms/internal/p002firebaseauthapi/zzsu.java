package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final /* synthetic */ class zzsu implements RemoteCall {
    public final /* synthetic */ zzsv zza;

    public /* synthetic */ zzsu(zzsv zzsv) {
        this.zza = zzsv;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zzd((zztm) obj, (TaskCompletionSource) obj2);
    }
}
