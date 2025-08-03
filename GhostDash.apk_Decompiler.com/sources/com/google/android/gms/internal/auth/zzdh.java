package com.google.android.gms.internal.auth;

import java.io.Serializable;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
final class zzdh<T> implements Serializable, zzdg {
    final zzdg<T> zza;
    volatile transient boolean zzb;
    @CheckForNull
    transient T zzc;

    zzdh(zzdg<T> zzdg) {
        Objects.requireNonNull(zzdg);
        this.zza = zzdg;
    }

    public final String toString() {
        Object obj;
        if (this.zzb) {
            String valueOf = String.valueOf(this.zzc);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(">");
            obj = sb.toString();
        } else {
            obj = this.zza;
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }

    public final T zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    T zza2 = this.zza.zza();
                    this.zzc = zza2;
                    this.zzb = true;
                    return zza2;
                }
            }
        }
        return this.zzc;
    }
}
