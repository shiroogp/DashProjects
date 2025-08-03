package com.google.mlkit.common.sdkinternal;

import android.util.Log;
import com.google.android.gms.internal.mlkit_common.zzgr;
import com.google.android.gms.internal.mlkit_common.zzgs;
import com.google.android.gms.internal.mlkit_common.zzgv;
import com.google.android.gms.internal.mlkit_common.zzgx;
import com.google.android.gms.internal.mlkit_common.zzjl;
import com.google.android.gms.internal.mlkit_common.zzjo;
import com.google.android.gms.internal.mlkit_common.zzjw;
import com.google.mlkit.common.sdkinternal.Cleaner;
import java.io.Closeable;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public class CloseGuard implements Closeable {
    public static final int API_TRANSLATE = 1;
    private final AtomicBoolean zza = new AtomicBoolean();
    private final String zzb;
    private final Cleaner.Cleanable zzc;

    /* compiled from: com.google.mlkit:common@@17.2.0 */
    public static class Factory {
        private final Cleaner zza;

        public Factory(Cleaner cleaner) {
            this.zza = cleaner;
        }

        public CloseGuard create(Object obj, int i, Runnable runnable) {
            return new CloseGuard(obj, i, this.zza, runnable, zzjw.zzb("common"));
        }
    }

    CloseGuard(Object obj, int i, Cleaner cleaner, Runnable runnable, zzjl zzjl) {
        this.zzb = obj.toString();
        this.zzc = cleaner.register(obj, new zze(this, i, zzjl, runnable));
    }

    public final void close() {
        this.zza.set(true);
        this.zzc.clean();
    }

    public final /* synthetic */ void zza(int i, zzjl zzjl, Runnable runnable) {
        if (!this.zza.get()) {
            Log.e("MlKitCloseGuard", String.format(Locale.ENGLISH, "%s has not been closed", new Object[]{this.zzb}));
            zzgx zzgx = new zzgx();
            zzgs zzgs = new zzgs();
            zzgs.zzb(zzgr.zzb(i));
            zzgx.zzh(zzgs.zzc());
            zzjl.zzc(zzjo.zzf(zzgx), zzgv.HANDLE_LEAKED);
        }
        runnable.run();
    }
}
