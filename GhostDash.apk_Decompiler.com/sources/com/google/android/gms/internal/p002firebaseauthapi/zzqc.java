package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final /* synthetic */ class zzqc implements RemoteCall {
    public final /* synthetic */ zzqd zza;

    public /* synthetic */ zzqc(zzqd zzqd) {
        this.zza = zzqd;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zzd((zztm) obj, (TaskCompletionSource) obj2);
    }
}
