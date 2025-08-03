package com.google.android.gms.internal.mlkit_vision_common;

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

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
public final class zzid implements zzhw {
    private Provider<Transport<byte[]>> zza;
    private final Provider<Transport<byte[]>> zzb;
    private final zzhr zzc;

    public zzid(Context context, zzhr zzhr) {
        this.zzc = zzhr;
        CCTDestination cCTDestination = CCTDestination.INSTANCE;
        TransportRuntime.initialize(context);
        TransportFactory newFactory = TransportRuntime.getInstance().newFactory((Destination) cCTDestination);
        if (cCTDestination.getSupportedEncodings().contains(Encoding.of("json"))) {
            this.zza = new Lazy(new zzib(newFactory));
        }
        this.zzb = new Lazy(new zzic(newFactory));
    }

    static Event<byte[]> zzb(zzhr zzhr, zzhy zzhy) {
        return Event.ofTelemetry(zzhy.zzb(zzhr.zza(), false));
    }

    public final void zza(zzhy zzhy) {
        if (this.zzc.zza() == 0) {
            Provider<Transport<byte[]>> provider = this.zza;
            if (provider != null) {
                provider.get().send(zzb(this.zzc, zzhy));
                return;
            }
            return;
        }
        this.zzb.get().send(zzb(this.zzc, zzhy));
    }
}
