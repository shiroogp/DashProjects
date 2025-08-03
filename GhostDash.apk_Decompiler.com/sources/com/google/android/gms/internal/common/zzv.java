package com.google.android.gms.internal.common;

import java.io.IOException;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
final class zzv implements Iterable<String> {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzx zzb;

    zzv(zzx zzx, CharSequence charSequence) {
        this.zzb = zzx;
        this.zza = charSequence;
    }

    public final Iterator<String> iterator() {
        return this.zzb.zzh(this.zza);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator it2 = iterator();
        try {
            if (it2.hasNext()) {
                sb.append(zzq.zza(it2.next(), ", "));
                while (it2.hasNext()) {
                    sb.append(", ");
                    sb.append(zzq.zza(it2.next(), ", "));
                }
            }
            sb.append(']');
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
