package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRuntime;
import com.google.mlkit.common.internal.MlKitComponentDiscoveryService;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public class MlKitContext {
    private static final AtomicReference<MlKitContext> zza = new AtomicReference<>();
    private ComponentRuntime zzb;

    private MlKitContext() {
    }

    public static MlKitContext getInstance() {
        MlKitContext mlKitContext = zza.get();
        Preconditions.checkState(mlKitContext != null, "MlKitContext has not been initialized");
        return mlKitContext;
    }

    public static MlKitContext initialize(Context context, List<ComponentRegistrar> list) {
        MlKitContext mlKitContext = new MlKitContext();
        boolean z = false;
        ComponentRuntime componentRuntime = new ComponentRuntime(TaskExecutors.MAIN_THREAD, (Iterable<ComponentRegistrar>) list, (Component<?>[]) new Component[]{Component.of(zzb(context), Context.class, new Class[0]), Component.of(mlKitContext, MlKitContext.class, new Class[0])});
        mlKitContext.zzb = componentRuntime;
        componentRuntime.initializeEagerComponents(true);
        if (zza.getAndSet(mlKitContext) == null) {
            z = true;
        }
        Preconditions.checkState(z, "MlKitContext is already initialized");
        return mlKitContext;
    }

    public static MlKitContext zza(Context context) {
        MlKitContext mlKitContext = new MlKitContext();
        Context zzb2 = zzb(context);
        boolean z = false;
        ComponentRuntime build = ComponentRuntime.builder(TaskExecutors.MAIN_THREAD).addLazyComponentRegistrars(ComponentDiscovery.forContext(zzb2, MlKitComponentDiscoveryService.class).discoverLazy()).addComponent(Component.of(zzb2, Context.class, new Class[0])).addComponent(Component.of(mlKitContext, MlKitContext.class, new Class[0])).build();
        mlKitContext.zzb = build;
        build.initializeEagerComponents(true);
        if (zza.getAndSet(mlKitContext) == null) {
            z = true;
        }
        Preconditions.checkState(z, "MlKitContext is already initialized");
        return mlKitContext;
    }

    private static Context zzb(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }

    public <T> T get(Class<T> cls) {
        Preconditions.checkState(zza.get() == this, "MlKitContext has been deleted");
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.get(cls);
    }

    public Context getApplicationContext() {
        return (Context) get(Context.class);
    }
}
