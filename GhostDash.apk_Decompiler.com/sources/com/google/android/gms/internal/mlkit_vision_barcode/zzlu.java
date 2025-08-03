package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.inject.Provider;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final /* synthetic */ class zzlu implements Provider {
    public final /* synthetic */ TransportFactory zza;

    public /* synthetic */ zzlu(TransportFactory transportFactory) {
        this.zza = transportFactory;
    }

    public final Object get() {
        return this.zza.getTransport("FIREBASE_ML_SDK", byte[].class, Encoding.of("json"), zzls.zza);
    }
}
