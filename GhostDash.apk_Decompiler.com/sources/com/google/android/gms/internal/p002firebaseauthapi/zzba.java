package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzba  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzba {
    private static final CopyOnWriteArrayList<zzaz> zza = new CopyOnWriteArrayList<>();

    public static zzaz zza(String str) throws GeneralSecurityException {
        Iterator<zzaz> it2 = zza.iterator();
        while (it2.hasNext()) {
            zzaz next = it2.next();
            if (next.zzb(str)) {
                return next;
            }
        }
        String valueOf = String.valueOf(str);
        throw new GeneralSecurityException(valueOf.length() != 0 ? "No KMS client does support: ".concat(valueOf) : new String("No KMS client does support: "));
    }
}
