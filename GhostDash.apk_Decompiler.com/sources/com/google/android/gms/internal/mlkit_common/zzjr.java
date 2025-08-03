package com.google.android.gms.internal.mlkit_common;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.inject.Provider;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final /* synthetic */ class zzjr implements Provider {
    public final /* synthetic */ TransportFactory zza;

    public /* synthetic */ zzjr(TransportFactory transportFactory) {
        this.zza = transportFactory;
    }

    public final Object get() {
        return this.zza.getTransport("FIREBASE_ML_SDK", byte[].class, Encoding.of("json"), zzjp.zza);
    }
}
