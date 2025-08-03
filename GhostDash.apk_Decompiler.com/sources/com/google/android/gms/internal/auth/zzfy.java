package com.google.android.gms.internal.auth;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
final class zzfy {
    private static final zzfy zza = new zzfy();
    private final zzgc zzb = new zzfi();
    private final ConcurrentMap<Class<?>, zzgb<?>> zzc = new ConcurrentHashMap();

    private zzfy() {
    }

    public static zzfy zza() {
        return zza;
    }

    public final <T> zzgb<T> zzb(Class<T> cls) {
        zzev.zzf(cls, "messageType");
        zzgb<T> zzgb = (zzgb) this.zzc.get(cls);
        if (zzgb == null) {
            zzgb = this.zzb.zza(cls);
            zzev.zzf(cls, "messageType");
            zzev.zzf(zzgb, "schema");
            zzgb<T> putIfAbsent = this.zzc.putIfAbsent(cls, zzgb);
            return putIfAbsent == null ? zzgb : putIfAbsent;
        }
    }
}
