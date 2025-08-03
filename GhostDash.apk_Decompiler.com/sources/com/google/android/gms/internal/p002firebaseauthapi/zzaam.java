package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaam  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
final class zzaam extends zzaan {
    private zzaam() {
        super((zzaak) null);
    }

    /* synthetic */ zzaam(zzaak zzaak) {
        super((zzaak) null);
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> zza(Object obj, long j) {
        zzaab zzaab = (zzaab) zzacj.zzf(obj, j);
        if (zzaab.zzc()) {
            return zzaab;
        }
        int size = zzaab.size();
        zzaab zzd = zzaab.zzd(size == 0 ? 10 : size + size);
        zzacj.zzs(obj, j, zzd);
        return zzd;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        ((zzaab) zzacj.zzf(obj, j)).zzb();
    }

    /* access modifiers changed from: package-private */
    public final <E> void zzc(Object obj, Object obj2, long j) {
        zzaab zzaab = (zzaab) zzacj.zzf(obj, j);
        zzaab zzaab2 = (zzaab) zzacj.zzf(obj2, j);
        int size = zzaab.size();
        int size2 = zzaab2.size();
        if (size > 0 && size2 > 0) {
            if (!zzaab.zzc()) {
                zzaab = zzaab.zzd(size2 + size);
            }
            zzaab.addAll(zzaab2);
        }
        if (size > 0) {
            zzaab2 = zzaab;
        }
        zzacj.zzs(obj, j, zzaab2);
    }
}
