package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.Destination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.firebase.components.Lazy;
import com.google.firebase.inject.Provider;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final class zzjt implements zzjk {
    private Provider<Transport<byte[]>> zza;
    private final Provider<Transport<byte[]>> zzb;
    private final zzje zzc;

    public zzjt(Context context, zzje zzje) {
        this.zzc = zzje;
        CCTDestination cCTDestination = CCTDestination.INSTANCE;
        TransportRuntime.initialize(context);
        TransportFactory newFactory = TransportRuntime.getInstance().newFactory((Destination) cCTDestination);
        if (cCTDestination.getSupportedEncodings().contains(Encoding.of("json"))) {
            this.zza = new Lazy(new zzjr(newFactory));
        }
        this.zzb = new Lazy(new zzjs(newFactory));
    }

    static Event<byte[]> zzb(zzje zzje, zzjc zzjc) {
        return Event.ofTelemetry(zzjc.zze(zzje.zza(), false));
    }

    public final void zza(zzjc zzjc) {
        if (this.zzc.zza() == 0) {
            Provider<Transport<byte[]>> provider = this.zza;
            if (provider != null) {
                provider.get().send(zzb(this.zzc, zzjc));
                return;
            }
            return;
        }
        this.zzb.get().send(zzb(this.zzc, zzjc));
    }
}
