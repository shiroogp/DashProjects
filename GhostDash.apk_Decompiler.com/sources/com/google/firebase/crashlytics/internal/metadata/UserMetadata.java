package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;

public class UserMetadata {
    public static final String INTERNAL_KEYDATA_FILENAME = "internal-keys";
    public static final String KEYDATA_FILENAME = "keys";
    public static final int MAX_ATTRIBUTES = 64;
    public static final int MAX_ATTRIBUTE_SIZE = 1024;
    public static final int MAX_INTERNAL_KEY_SIZE = 8192;
    public static final String USERDATA_FILENAME = "user-data";
    /* access modifiers changed from: private */
    public final CrashlyticsBackgroundWorker backgroundWorker;
    private final SerializeableKeysMap customKeys = new SerializeableKeysMap(false);
    private final SerializeableKeysMap internalKeys = new SerializeableKeysMap(true);
    /* access modifiers changed from: private */
    public final MetaDataStore metaDataStore;
    /* access modifiers changed from: private */
    public final String sessionIdentifier;
    private final AtomicMarkableReference<String> userId = new AtomicMarkableReference<>((Object) null, false);

    public static String readUserId(String str, FileStore fileStore) {
        return new MetaDataStore(fileStore).readUserId(str);
    }

    public static UserMetadata loadFromExistingSession(String str, FileStore fileStore, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker) {
        MetaDataStore metaDataStore2 = new MetaDataStore(fileStore);
        UserMetadata userMetadata = new UserMetadata(str, fileStore, crashlyticsBackgroundWorker);
        userMetadata.customKeys.map.getReference().setKeys(metaDataStore2.readKeyData(str, false));
        userMetadata.internalKeys.map.getReference().setKeys(metaDataStore2.readKeyData(str, true));
        userMetadata.userId.set(metaDataStore2.readUserId(str), false);
        return userMetadata;
    }

    public UserMetadata(String str, FileStore fileStore, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker) {
        this.sessionIdentifier = str;
        this.metaDataStore = new MetaDataStore(fileStore);
        this.backgroundWorker = crashlyticsBackgroundWorker;
    }

    public String getUserId() {
        return this.userId.getReference();
    }

    public void setUserId(String str) {
        String sanitizeString = KeysMap.sanitizeString(str, 1024);
        synchronized (this.userId) {
            if (!CommonUtils.nullSafeEquals(sanitizeString, this.userId.getReference())) {
                this.userId.set(sanitizeString, true);
                this.backgroundWorker.submit(new Callable() {
                    public final Object call() {
                        return UserMetadata.this.lambda$setUserId$0$UserMetadata();
                    }
                });
            }
        }
    }

    public /* synthetic */ Object lambda$setUserId$0$UserMetadata() throws Exception {
        serializeUserDataIfNeeded();
        return null;
    }

    public Map<String, String> getCustomKeys() {
        return this.customKeys.getKeys();
    }

    public boolean setCustomKey(String str, String str2) {
        return this.customKeys.setKey(str, str2);
    }

    public void setCustomKeys(Map<String, String> map) {
        this.customKeys.setKeys(map);
    }

    public Map<String, String> getInternalKeys() {
        return this.internalKeys.getKeys();
    }

    public boolean setInternalKey(String str, String str2) {
        return this.internalKeys.setKey(str, str2);
    }

    private void serializeUserDataIfNeeded() {
        boolean z;
        String str;
        synchronized (this.userId) {
            z = false;
            if (this.userId.isMarked()) {
                str = getUserId();
                this.userId.set(str, false);
                z = true;
            } else {
                str = null;
            }
        }
        if (z) {
            this.metaDataStore.writeUserData(this.sessionIdentifier, str);
        }
    }

    private class SerializeableKeysMap {
        private final boolean isInternal;
        final AtomicMarkableReference<KeysMap> map;
        private final AtomicReference<Callable<Void>> queuedSerializer = new AtomicReference<>((Object) null);

        public SerializeableKeysMap(boolean z) {
            this.isInternal = z;
            this.map = new AtomicMarkableReference<>(new KeysMap(64, z ? 8192 : 1024), false);
        }

        public Map<String, String> getKeys() {
            return this.map.getReference().getKeys();
        }

        public boolean setKey(String str, String str2) {
            synchronized (this) {
                if (!this.map.getReference().setKey(str, str2)) {
                    return false;
                }
                AtomicMarkableReference<KeysMap> atomicMarkableReference = this.map;
                atomicMarkableReference.set(atomicMarkableReference.getReference(), true);
                scheduleSerializationTaskIfNeeded();
                return true;
            }
        }

        public void setKeys(Map<String, String> map2) {
            synchronized (this) {
                this.map.getReference().setKeys(map2);
                AtomicMarkableReference<KeysMap> atomicMarkableReference = this.map;
                atomicMarkableReference.set(atomicMarkableReference.getReference(), true);
            }
            scheduleSerializationTaskIfNeeded();
        }

        private void scheduleSerializationTaskIfNeeded() {
            $$Lambda$UserMetadata$SerializeableKeysMap$LH_5nmLNx7JWSKpBG7431_guENk r0 = new Callable() {
                public final Object call() {
                    return UserMetadata.SerializeableKeysMap.this.lambda$scheduleSerializationTaskIfNeeded$0$UserMetadata$SerializeableKeysMap();
                }
            };
            if (this.queuedSerializer.compareAndSet((Object) null, r0)) {
                UserMetadata.this.backgroundWorker.submit(r0);
            }
        }

        public /* synthetic */ Void lambda$scheduleSerializationTaskIfNeeded$0$UserMetadata$SerializeableKeysMap() throws Exception {
            this.queuedSerializer.set((Object) null);
            serializeIfMarked();
            return null;
        }

        private void serializeIfMarked() {
            Map<String, String> map2;
            synchronized (this) {
                if (this.map.isMarked()) {
                    map2 = this.map.getReference().getKeys();
                    AtomicMarkableReference<KeysMap> atomicMarkableReference = this.map;
                    atomicMarkableReference.set(atomicMarkableReference.getReference(), false);
                } else {
                    map2 = null;
                }
            }
            if (map2 != null) {
                UserMetadata.this.metaDataStore.writeKeyData(UserMetadata.this.sessionIdentifier, map2, this.isInternal);
            }
        }
    }
}
