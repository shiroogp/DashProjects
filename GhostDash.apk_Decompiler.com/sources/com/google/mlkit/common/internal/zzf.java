package com.google.mlkit.common.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.sdkinternal.Cleaner;
import com.google.mlkit.common.sdkinternal.CloseGuard;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final /* synthetic */ class zzf implements ComponentFactory {
    public static final /* synthetic */ zzf zza = new zzf();

    private /* synthetic */ zzf() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new CloseGuard.Factory((Cleaner) componentContainer.get(Cleaner.class));
    }
}
