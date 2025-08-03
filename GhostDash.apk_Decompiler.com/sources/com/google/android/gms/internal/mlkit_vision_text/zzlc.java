package com.google.android.gms.internal.mlkit_vision_text;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.inject.Provider;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final /* synthetic */ class zzlc implements Provider {
    public final /* synthetic */ TransportFactory zza;

    public /* synthetic */ zzlc(TransportFactory transportFactory) {
        this.zza = transportFactory;
    }

    public final Object get() {
        return this.zza.getTransport("FIREBASE_ML_SDK", byte[].class, Encoding.of("json"), zzla.zza);
    }
}
