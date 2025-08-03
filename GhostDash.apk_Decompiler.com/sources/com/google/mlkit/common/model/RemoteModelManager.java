package com.google.mlkit.common.model;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.inject.Provider;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public class RemoteModelManager {
    private final Map<Class<? extends RemoteModel>, Provider<? extends RemoteModelManagerInterface<? extends RemoteModel>>> zza = new HashMap();

    /* compiled from: com.google.mlkit:common@@17.2.0 */
    public static class RemoteModelManagerRegistration {
        private final Class<? extends RemoteModel> zza;
        private final Provider<? extends RemoteModelManagerInterface<? extends RemoteModel>> zzb;

        public <RemoteT extends RemoteModel> RemoteModelManagerRegistration(Class<RemoteT> cls, Provider<? extends RemoteModelManagerInterface<RemoteT>> provider) {
            this.zza = cls;
            this.zzb = provider;
        }

        /* access modifiers changed from: package-private */
        public final Provider<? extends RemoteModelManagerInterface<? extends RemoteModel>> zza() {
            return this.zzb;
        }

        /* access modifiers changed from: package-private */
        public final Class<? extends RemoteModel> zzb() {
            return this.zza;
        }
    }

    public RemoteModelManager(Set<RemoteModelManagerRegistration> set) {
        for (RemoteModelManagerRegistration next : set) {
            this.zza.put(next.zzb(), next.zza());
        }
    }

    public static synchronized RemoteModelManager getInstance() {
        RemoteModelManager remoteModelManager;
        Class cls = RemoteModelManager.class;
        synchronized (cls) {
            remoteModelManager = (RemoteModelManager) MlKitContext.getInstance().get(cls);
        }
        return remoteModelManager;
    }

    private final RemoteModelManagerInterface<RemoteModel> zza(Class<? extends RemoteModel> cls) {
        return (RemoteModelManagerInterface) ((Provider) Preconditions.checkNotNull(this.zza.get(cls))).get();
    }

    public Task<Void> deleteDownloadedModel(RemoteModel remoteModel) {
        Preconditions.checkNotNull(remoteModel, "RemoteModel cannot be null");
        return zza(remoteModel.getClass()).deleteDownloadedModel(remoteModel);
    }

    public Task<Void> download(RemoteModel remoteModel, DownloadConditions downloadConditions) {
        Preconditions.checkNotNull(remoteModel, "RemoteModel cannot be null");
        Preconditions.checkNotNull(downloadConditions, "DownloadConditions cannot be null");
        if (this.zza.containsKey(remoteModel.getClass())) {
            return zza(remoteModel.getClass()).download(remoteModel, downloadConditions);
        }
        String simpleName = remoteModel.getClass().getSimpleName();
        StringBuilder sb = new StringBuilder(String.valueOf(simpleName).length() + 70);
        sb.append("Feature model '");
        sb.append(simpleName);
        sb.append("' doesn't have a corresponding modelmanager registered.");
        return Tasks.forException(new MlKitException(sb.toString(), 13));
    }

    public <T extends RemoteModel> Task<Set<T>> getDownloadedModels(Class<T> cls) {
        return ((RemoteModelManagerInterface) ((Provider) Preconditions.checkNotNull(this.zza.get(cls))).get()).getDownloadedModels();
    }

    public Task<Boolean> isModelDownloaded(RemoteModel remoteModel) {
        Preconditions.checkNotNull(remoteModel, "RemoteModel cannot be null");
        return zza(remoteModel.getClass()).isModelDownloaded(remoteModel);
    }
}
