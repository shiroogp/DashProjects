package com.google.android.gms.internal.mlkit_vision_text;

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

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final class zzle implements zzkv {
    private Provider<Transport<byte[]>> zza;
    private final Provider<Transport<byte[]>> zzb;
    private final zzkq zzc;

    public zzle(Context context, zzkq zzkq) {
        this.zzc = zzkq;
        CCTDestination cCTDestination = CCTDestination.INSTANCE;
        TransportRuntime.initialize(context);
        TransportFactory newFactory = TransportRuntime.getInstance().newFactory((Destination) cCTDestination);
        if (cCTDestination.getSupportedEncodings().contains(Encoding.of("json"))) {
            this.zza = new Lazy(new zzlc(newFactory));
        }
        this.zzb = new Lazy(new zzld(newFactory));
    }

    static Event<byte[]> zzb(zzkq zzkq, zzkz zzkz) {
        int zza2 = zzkq.zza();
        if (zzkz.zza() != 0) {
            return Event.ofData(zzkz.zzc(zza2, false));
        }
        return Event.ofTelemetry(zzkz.zzc(zza2, false));
    }

    public final void zza(zzkz zzkz) {
        if (this.zzc.zza() == 0) {
            Provider<Transport<byte[]>> provider = this.zza;
            if (provider != null) {
                provider.get().send(zzb(this.zzc, zzkz));
                return;
            }
            return;
        }
        this.zzb.get().send(zzb(this.zzc, zzkz));
    }
}
