package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaah  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public class zzaah {
    private static final zzzj zzb = zzzj.zza();
    protected volatile zzaaz zza;
    private volatile zzyu zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaah)) {
            return false;
        }
        zzaah zzaah = (zzaah) obj;
        zzaaz zzaaz = this.zza;
        zzaaz zzaaz2 = zzaah.zza;
        if (zzaaz == null && zzaaz2 == null) {
            return zzb().equals(zzaah.zzb());
        }
        if (zzaaz != null && zzaaz2 != null) {
            return zzaaz.equals(zzaaz2);
        }
        if (zzaaz != null) {
            zzaah.zzc(zzaaz.zzI());
            return zzaaz.equals(zzaah.zza);
        }
        zzc(zzaaz2.zzI());
        return this.zza.equals(zzaaz2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzys) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzs();
        }
        return 0;
    }

    public final zzyu zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzyu zzyu = this.zzc;
                return zzyu;
            }
            if (this.zza == null) {
                this.zzc = zzyu.zzb;
            } else {
                this.zzc = this.zza.zzo();
            }
            zzyu zzyu2 = this.zzc;
            return zzyu2;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.gms.internal.p002firebaseauthapi.zzaaz r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.firebase-auth-api.zzaaz r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.gms.internal.firebase-auth-api.zzaaz r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.zza = r2     // Catch:{ zzaae -> 0x0011 }
            com.google.android.gms.internal.firebase-auth-api.zzyu r0 = com.google.android.gms.internal.p002firebaseauthapi.zzyu.zzb     // Catch:{ zzaae -> 0x0011 }
            r1.zzc = r0     // Catch:{ zzaae -> 0x0011 }
            goto L_0x0017
        L_0x0011:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.firebase-auth-api.zzyu r2 = com.google.android.gms.internal.p002firebaseauthapi.zzyu.zzb     // Catch:{ all -> 0x001b }
            r1.zzc = r2     // Catch:{ all -> 0x001b }
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzaah.zzc(com.google.android.gms.internal.firebase-auth-api.zzaaz):void");
    }
}
