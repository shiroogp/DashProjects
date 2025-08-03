package com.google.mlkit.vision.common.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.inject.Provider;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
public class MultiFlavorDetectorCreator {
    private final Map<Class<? extends DetectorOptions<?>>, Provider<? extends DetectorCreator<?, ?>>> zza = new HashMap();

    /* compiled from: com.google.mlkit:vision-common@@16.5.0 */
    public interface DetectorCreator<ResultT, OptionsT extends DetectorOptions<ResultT>> {
        MobileVisionBase<ResultT> create(OptionsT optionst);
    }

    /* compiled from: com.google.mlkit:vision-common@@16.5.0 */
    public interface DetectorOptions<ResultT> {
    }

    /* compiled from: com.google.mlkit:vision-common@@16.5.0 */
    public static class Registration {
        private final Class<? extends DetectorOptions<?>> zza;
        private final Provider<? extends DetectorCreator<?, ?>> zzb;
        private final int zzc;

        public <ResultT, OptionsT extends DetectorOptions<ResultT>> Registration(Class<? extends OptionsT> cls, Provider<? extends DetectorCreator<ResultT, OptionsT>> provider) {
            this(cls, provider, 100);
        }

        public <ResultT, OptionsT extends DetectorOptions<ResultT>> Registration(Class<? extends OptionsT> cls, Provider<? extends DetectorCreator<ResultT, OptionsT>> provider, int i) {
            this.zza = cls;
            this.zzb = provider;
            this.zzc = i;
        }

        /* access modifiers changed from: package-private */
        public final int zza() {
            return this.zzc;
        }

        /* access modifiers changed from: package-private */
        public final Provider<? extends DetectorCreator<?, ?>> zzb() {
            return this.zzb;
        }

        /* access modifiers changed from: package-private */
        public final Class<? extends DetectorOptions<?>> zzc() {
            return this.zza;
        }
    }

    MultiFlavorDetectorCreator(Set<Registration> set) {
        HashMap hashMap = new HashMap();
        for (Registration next : set) {
            Class<? extends DetectorOptions<?>> zzc = next.zzc();
            if (!this.zza.containsKey(zzc) || next.zza() >= ((Integer) Preconditions.checkNotNull((Integer) hashMap.get(zzc))).intValue()) {
                this.zza.put(zzc, next.zzb());
                hashMap.put(zzc, Integer.valueOf(next.zza()));
            }
        }
    }

    public static synchronized MultiFlavorDetectorCreator getInstance() {
        MultiFlavorDetectorCreator multiFlavorDetectorCreator;
        Class cls = MultiFlavorDetectorCreator.class;
        synchronized (cls) {
            multiFlavorDetectorCreator = (MultiFlavorDetectorCreator) MlKitContext.getInstance().get(cls);
        }
        return multiFlavorDetectorCreator;
    }

    public <ResultT, OptionsT extends DetectorOptions<ResultT>> MobileVisionBase<ResultT> create(OptionsT optionst) {
        return ((DetectorCreator) ((Provider) Preconditions.checkNotNull(this.zza.get(optionst.getClass()))).get()).create(optionst);
    }
}
