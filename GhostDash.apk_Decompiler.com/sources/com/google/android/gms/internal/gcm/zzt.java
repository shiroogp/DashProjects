package com.google.android.gms.internal.gcm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;

final class zzt extends WeakReference<Throwable> {
    private final int zzdv;

    public zzt(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        Objects.requireNonNull(th, "The referent cannot be null");
        this.zzdv = System.identityHashCode(th);
    }

    public final int hashCode() {
        return this.zzdv;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            zzt zzt = (zzt) obj;
            return this.zzdv == zzt.zzdv && get() == zzt.get();
        }
    }
}
