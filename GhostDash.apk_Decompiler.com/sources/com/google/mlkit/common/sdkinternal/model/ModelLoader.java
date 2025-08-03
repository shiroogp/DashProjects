package com.google.mlkit.common.sdkinternal.model;

import android.net.Uri;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.MlKitException;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public class ModelLoader {
    private static final GmsLogger zza = new GmsLogger("ModelLoader", "");
    public final LocalModelLoader localModelLoader;
    protected ModelLoadingState modelLoadingState = ModelLoadingState.NO_MODEL_LOADED;
    public final RemoteModelLoader remoteModelLoader;
    private final ModelLoadingLogger zzb;

    /* compiled from: com.google.mlkit:common@@17.2.0 */
    public interface ModelContentHandler {
        void constructModel(MappedByteBuffer mappedByteBuffer) throws MlKitException;
    }

    /* compiled from: com.google.mlkit:common@@17.2.0 */
    public interface ModelLoadingLogger {
        void logErrorCodes(List<Integer> list);
    }

    /* compiled from: com.google.mlkit:common@@17.2.0 */
    protected enum ModelLoadingState {
        NO_MODEL_LOADED,
        REMOTE_MODEL_LOADED,
        LOCAL_MODEL_LOADED
    }

    public ModelLoader(RemoteModelLoader remoteModelLoader2, LocalModelLoader localModelLoader2, ModelLoadingLogger modelLoadingLogger) {
        boolean z = true;
        if (remoteModelLoader2 == null && localModelLoader2 == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "At least one of RemoteModelLoader or LocalModelLoader must be non-null.");
        Preconditions.checkNotNull(modelLoadingLogger);
        this.remoteModelLoader = remoteModelLoader2;
        this.localModelLoader = localModelLoader2;
        this.zzb = modelLoadingLogger;
    }

    private final String zza() {
        String str;
        LocalModelLoader localModelLoader2 = this.localModelLoader;
        String str2 = null;
        if (localModelLoader2 != null) {
            if (localModelLoader2.getLocalModel().getAssetFilePath() != null) {
                str2 = this.localModelLoader.getLocalModel().getAssetFilePath();
            } else if (this.localModelLoader.getLocalModel().getAbsoluteFilePath() != null) {
                str2 = this.localModelLoader.getLocalModel().getAbsoluteFilePath();
            } else if (this.localModelLoader.getLocalModel().getUri() != null) {
                str2 = ((Uri) Preconditions.checkNotNull(this.localModelLoader.getLocalModel().getUri())).toString();
            }
        }
        RemoteModelLoader remoteModelLoader2 = this.remoteModelLoader;
        if (remoteModelLoader2 == null) {
            str = "unspecified";
        } else {
            str = remoteModelLoader2.getRemoteModel().getUniqueModelNameForPersist();
        }
        return String.format("Local model path: %s. Remote model name: %s. ", new Object[]{str2, str});
    }

    private final synchronized boolean zzb(ModelContentHandler modelContentHandler, List<Integer> list) throws MlKitException {
        MappedByteBuffer load;
        LocalModelLoader localModelLoader2 = this.localModelLoader;
        if (localModelLoader2 == null || (load = localModelLoader2.load()) == null) {
            return false;
        }
        try {
            modelContentHandler.constructModel(load);
            zza.d("ModelLoader", "Local model source is loaded successfully");
            return true;
        } catch (RuntimeException e) {
            list.add(18);
            throw e;
        }
    }

    private final synchronized boolean zzc(ModelContentHandler modelContentHandler, List<Integer> list) throws MlKitException {
        RemoteModelLoader remoteModelLoader2 = this.remoteModelLoader;
        if (remoteModelLoader2 != null) {
            try {
                MappedByteBuffer load = remoteModelLoader2.load();
                if (load != null) {
                    modelContentHandler.constructModel(load);
                    zza.d("ModelLoader", "Remote model source is loaded successfully");
                    return true;
                }
                zza.d("ModelLoader", "Remote model source can NOT be loaded, try local model.");
                list.add(21);
            } catch (MlKitException e) {
                zza.d("ModelLoader", "Remote model source can NOT be loaded, try local model.");
                list.add(20);
                throw e;
            } catch (RuntimeException e2) {
                list.add(19);
                throw e2;
            }
        }
        return false;
    }

    public synchronized boolean isRemoteModelLoaded() {
        return this.modelLoadingState == ModelLoadingState.REMOTE_MODEL_LOADED;
    }

    public synchronized void loadWithModelContentHandler(ModelContentHandler modelContentHandler) throws MlKitException {
        Exception exc;
        boolean z;
        ArrayList arrayList = new ArrayList();
        Exception e = null;
        boolean z2 = false;
        try {
            z = zzc(modelContentHandler, arrayList);
            exc = null;
        } catch (Exception e2) {
            exc = e2;
            z = false;
        }
        if (z) {
            this.zzb.logErrorCodes(arrayList);
            this.modelLoadingState = ModelLoadingState.REMOTE_MODEL_LOADED;
            return;
        }
        try {
            z2 = zzb(modelContentHandler, arrayList);
        } catch (Exception e3) {
            e = e3;
        }
        if (z2) {
            this.zzb.logErrorCodes(arrayList);
            this.modelLoadingState = ModelLoadingState.LOCAL_MODEL_LOADED;
            return;
        }
        arrayList.add(17);
        this.zzb.logErrorCodes(arrayList);
        this.modelLoadingState = ModelLoadingState.NO_MODEL_LOADED;
        if (exc != null) {
            String valueOf = String.valueOf(zza());
            throw new MlKitException(valueOf.length() != 0 ? "Remote model load failed with the model options: ".concat(valueOf) : new String("Remote model load failed with the model options: "), 14, exc);
        } else if (e != null) {
            String valueOf2 = String.valueOf(zza());
            throw new MlKitException(valueOf2.length() != 0 ? "Local model load failed with the model options: ".concat(valueOf2) : new String("Local model load failed with the model options: "), 14, e);
        } else {
            String valueOf3 = String.valueOf(zza());
            throw new MlKitException(valueOf3.length() != 0 ? "Cannot load any model with the model options: ".concat(valueOf3) : new String("Cannot load any model with the model options: "), 14);
        }
    }
}
