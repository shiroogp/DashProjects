package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.model.RemoteModel;
import java.util.UUID;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public class SharedPrefManager {
    public static final Component<?> COMPONENT = Component.builder(SharedPrefManager.class).add(Dependency.required(MlKitContext.class)).add(Dependency.required(Context.class)).factory(zzo.zza).build();
    public static final String PREF_FILE = "com.google.mlkit.internal";
    private final Context zza;

    public SharedPrefManager(Context context) {
        this.zza = context;
    }

    public static SharedPrefManager getInstance(MlKitContext mlKitContext) {
        return (SharedPrefManager) mlKitContext.get(SharedPrefManager.class);
    }

    private final SharedPreferences zzc() {
        return this.zza.getSharedPreferences(PREF_FILE, 0);
    }

    public synchronized void clearDownloadingModelInfo(RemoteModel remoteModel) {
        String downloadingModelHash = getDownloadingModelHash(remoteModel);
        zzc().edit().remove(String.format("downloading_model_id_%s", new Object[]{remoteModel.getUniqueModelNameForPersist()})).remove(String.format("downloading_model_hash_%s", new Object[]{remoteModel.getUniqueModelNameForPersist()})).remove(String.format("downloading_model_type_%s", new Object[]{downloadingModelHash})).remove(String.format("downloading_begin_time_%s", new Object[]{remoteModel.getUniqueModelNameForPersist()})).remove(String.format("model_first_use_time_%s", new Object[]{remoteModel.getUniqueModelNameForPersist()})).apply();
    }

    public synchronized void clearIncompatibleModelInfo(RemoteModel remoteModel) {
        zzc().edit().remove(String.format("bad_hash_%s", new Object[]{remoteModel.getUniqueModelNameForPersist()})).remove("app_version").apply();
    }

    public synchronized void clearLatestModelHash(RemoteModel remoteModel) {
        zzc().edit().remove(String.format("current_model_hash_%s", new Object[]{remoteModel.getUniqueModelNameForPersist()})).commit();
    }

    public synchronized String getDownloadingModelHash(RemoteModel remoteModel) {
        return zzc().getString(String.format("downloading_model_hash_%s", new Object[]{remoteModel.getUniqueModelNameForPersist()}), (String) null);
    }

    public synchronized Long getDownloadingModelId(RemoteModel remoteModel) {
        long j = zzc().getLong(String.format("downloading_model_id_%s", new Object[]{remoteModel.getUniqueModelNameForPersist()}), -1);
        if (j < 0) {
            return null;
        }
        return Long.valueOf(j);
    }

    public synchronized String getIncompatibleModelHash(RemoteModel remoteModel) {
        return zzc().getString(String.format("bad_hash_%s", new Object[]{remoteModel.getUniqueModelNameForPersist()}), (String) null);
    }

    public synchronized String getLatestModelHash(RemoteModel remoteModel) {
        return zzc().getString(String.format("current_model_hash_%s", new Object[]{remoteModel.getUniqueModelNameForPersist()}), (String) null);
    }

    public synchronized String getMlSdkInstanceId() {
        String string = zzc().getString("ml_sdk_instance_id", (String) null);
        if (string != null) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        zzc().edit().putString("ml_sdk_instance_id", uuid).apply();
        return uuid;
    }

    public synchronized long getModelDownloadBeginTimeMs(RemoteModel remoteModel) {
        return zzc().getLong(String.format("downloading_begin_time_%s", new Object[]{remoteModel.getUniqueModelNameForPersist()}), 0);
    }

    public synchronized long getModelFirstUseTimeMs(RemoteModel remoteModel) {
        return zzc().getLong(String.format("model_first_use_time_%s", new Object[]{remoteModel.getUniqueModelNameForPersist()}), 0);
    }

    public synchronized String getPreviousAppVersion() {
        return zzc().getString("app_version", (String) null);
    }

    public synchronized void setDownloadingModelInfo(long j, ModelInfo modelInfo) {
        String modelNameForPersist = modelInfo.getModelNameForPersist();
        String modelHash = modelInfo.getModelHash();
        zzc().edit().putString(String.format("downloading_model_hash_%s", new Object[]{modelNameForPersist}), modelHash).putLong(String.format("downloading_model_id_%s", new Object[]{modelNameForPersist}), j).putLong(String.format("downloading_begin_time_%s", new Object[]{modelNameForPersist}), SystemClock.elapsedRealtime()).apply();
    }

    public synchronized void setIncompatibleModelInfo(RemoteModel remoteModel, String str, String str2) {
        zzc().edit().putString(String.format("bad_hash_%s", new Object[]{remoteModel.getUniqueModelNameForPersist()}), str).putString("app_version", str2).apply();
    }

    public synchronized void setLatestModelHash(RemoteModel remoteModel, String str) {
        zzc().edit().putString(String.format("current_model_hash_%s", new Object[]{remoteModel.getUniqueModelNameForPersist()}), str).apply();
    }

    public synchronized void setModelFirstUseTimeMs(RemoteModel remoteModel, long j) {
        zzc().edit().putLong(String.format("model_first_use_time_%s", new Object[]{remoteModel.getUniqueModelNameForPersist()}), j).apply();
    }

    public final synchronized String zza(String str, long j) {
        return zzc().getString(String.format("cached_local_model_hash_%1s_%2s", new Object[]{Preconditions.checkNotNull(str), Long.valueOf(j)}), (String) null);
    }

    public final synchronized void zzb(String str, long j, String str2) {
        zzc().edit().putString(String.format("cached_local_model_hash_%1s_%2s", new Object[]{Preconditions.checkNotNull(str), Long.valueOf(j)}), str2).apply();
    }
}
