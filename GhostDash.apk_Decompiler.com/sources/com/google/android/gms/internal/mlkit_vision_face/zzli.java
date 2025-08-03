package com.google.android.gms.internal.mlkit_vision_face;

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

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final class zzli implements zzkz {
    private Provider<Transport<byte[]>> zza;
    private final Provider<Transport<byte[]>> zzb;
    private final zzkt zzc;

    public zzli(Context context, zzkt zzkt) {
        this.zzc = zzkt;
        CCTDestination cCTDestination = CCTDestination.INSTANCE;
        TransportRuntime.initialize(context);
        TransportFactory newFactory = TransportRuntime.getInstance().newFactory((Destination) cCTDestination);
        if (cCTDestination.getSupportedEncodings().contains(Encoding.of("json"))) {
            this.zza = new Lazy(new zzlg(newFactory));
        }
        this.zzb = new Lazy(new zzlh(newFactory));
    }

    static Event<byte[]> zzb(zzkt zzkt, zzld zzld) {
        int zza2 = zzkt.zza();
        if (zzld.zza() != 0) {
            return Event.ofData(zzld.zzc(zza2, false));
        }
        return Event.ofTelemetry(zzld.zzc(zza2, false));
    }

    public final void zza(zzld zzld) {
        if (this.zzc.zza() == 0) {
            Provider<Transport<byte[]>> provider = this.zza;
            if (provider != null) {
                provider.get().send(zzb(this.zzc, zzld));
                return;
            }
            return;
        }
        this.zzb.get().send(zzb(this.zzc, zzld));
    }
}
