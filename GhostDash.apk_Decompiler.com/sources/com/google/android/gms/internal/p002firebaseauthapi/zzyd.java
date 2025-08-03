package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzyd;
import com.google.android.gms.internal.p002firebaseauthapi.zzye;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public abstract class zzyd<MessageType extends zzye<MessageType, BuilderType>, BuilderType extends zzyd<MessageType, BuilderType>> implements zzaay {
    /* renamed from: zzf */
    public abstract BuilderType clone();

    /* access modifiers changed from: protected */
    public abstract BuilderType zzg(MessageType messagetype);

    public final /* bridge */ /* synthetic */ zzaay zzh(zzaaz zzaaz) {
        if (zzI().getClass().isInstance(zzaaz)) {
            return zzg((zzye) zzaaz);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
