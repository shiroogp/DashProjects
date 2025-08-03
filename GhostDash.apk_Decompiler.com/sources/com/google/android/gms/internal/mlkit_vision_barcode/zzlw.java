package com.google.android.gms.internal.mlkit_vision_barcode;

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

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final class zzlw implements zzln {
    private Provider<Transport<byte[]>> zza;
    private final Provider<Transport<byte[]>> zzb;
    private final zzlh zzc;

    public zzlw(Context context, zzlh zzlh) {
        this.zzc = zzlh;
        CCTDestination cCTDestination = CCTDestination.INSTANCE;
        TransportRuntime.initialize(context);
        TransportFactory newFactory = TransportRuntime.getInstance().newFactory((Destination) cCTDestination);
        if (cCTDestination.getSupportedEncodings().contains(Encoding.of("json"))) {
            this.zza = new Lazy(new zzlu(newFactory));
        }
        this.zzb = new Lazy(new zzlv(newFactory));
    }

    static Event<byte[]> zzb(zzlh zzlh, zzlr zzlr) {
        int zza2 = zzlh.zza();
        if (zzlr.zza() != 0) {
            return Event.ofData(zzlr.zzc(zza2, false));
        }
        return Event.ofTelemetry(zzlr.zzc(zza2, false));
    }

    public final void zza(zzlr zzlr) {
        if (this.zzc.zza() == 0) {
            Provider<Transport<byte[]>> provider = this.zza;
            if (provider != null) {
                provider.get().send(zzb(this.zzc, zzlr));
                return;
            }
            return;
        }
        this.zzb.get().send(zzb(this.zzc, zzlr));
    }
}
