package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.interop.InternalAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.internal.AdaptiveStreamBuffer;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.internal.StorageReferenceUri;
import com.google.firebase.storage.internal.Util;
import com.google.firebase.storage.network.NetworkRequest;
import com.google.firebase.storage.network.ResumableUploadByteRequest;
import com.google.firebase.storage.network.ResumableUploadCancelRequest;
import com.google.firebase.storage.network.ResumableUploadQueryRequest;
import com.google.firebase.storage.network.ResumableUploadStartRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

public class UploadTask extends StorageTask<TaskSnapshot> {
    private static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
    private static final int MAXIMUM_CHUNK_SIZE = 33554432;
    static final int PREFERRED_CHUNK_SIZE = 262144;
    private static final String RESUMABLE_FINAL_STATUS = "final";
    private static final String TAG = "UploadTask";
    private static final String X_GOOG_UPLOAD_URL = "X-Goog-Upload-URL";
    /* access modifiers changed from: private */
    public final InternalAppCheckTokenProvider mAppCheckProvider;
    /* access modifiers changed from: private */
    public final InternalAuthProvider mAuthProvider;
    private final AtomicLong mBytesUploaded;
    private int mCurrentChunkSize;
    private volatile Exception mException;
    private boolean mIsStreamOwned;
    private volatile StorageMetadata mMetadata;
    private volatile int mResultCode;
    private ExponentialBackoffSender mSender;
    private volatile Exception mServerException;
    private volatile String mServerStatus;
    /* access modifiers changed from: private */
    public final StorageReference mStorageRef;
    private final AdaptiveStreamBuffer mStreamBuffer;
    private final long mTotalByteCount;
    private volatile Uri mUploadUri;
    private final Uri mUri;

    private boolean isValidHttpResponseCode(int i) {
        return i == 308 || (i >= 200 && i < 300);
    }

    UploadTask(StorageReference storageReference, StorageMetadata storageMetadata, byte[] bArr) {
        this.mBytesUploaded = new AtomicLong(0);
        this.mCurrentChunkSize = 262144;
        this.mUploadUri = null;
        this.mException = null;
        this.mServerException = null;
        this.mResultCode = 0;
        Preconditions.checkNotNull(storageReference);
        Preconditions.checkNotNull(bArr);
        FirebaseStorage storage = storageReference.getStorage();
        this.mTotalByteCount = (long) bArr.length;
        this.mStorageRef = storageReference;
        this.mMetadata = storageMetadata;
        InternalAuthProvider authProvider = storage.getAuthProvider();
        this.mAuthProvider = authProvider;
        InternalAppCheckTokenProvider appCheckProvider = storage.getAppCheckProvider();
        this.mAppCheckProvider = appCheckProvider;
        this.mUri = null;
        this.mStreamBuffer = new AdaptiveStreamBuffer(new ByteArrayInputStream(bArr), 262144);
        this.mIsStreamOwned = true;
        this.mSender = new ExponentialBackoffSender(storage.getApp().getApplicationContext(), authProvider, appCheckProvider, storage.getMaxDownloadRetryTimeMillis());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: long} */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r5v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    UploadTask(com.google.firebase.storage.StorageReference r11, com.google.firebase.storage.StorageMetadata r12, android.net.Uri r13, android.net.Uri r14) {
        /*
            r10 = this;
            java.lang.String r0 = "UploadTask"
            r10.<init>()
            java.util.concurrent.atomic.AtomicLong r1 = new java.util.concurrent.atomic.AtomicLong
            r2 = 0
            r1.<init>(r2)
            r10.mBytesUploaded = r1
            r1 = 262144(0x40000, float:3.67342E-40)
            r10.mCurrentChunkSize = r1
            r2 = 0
            r10.mUploadUri = r2
            r10.mException = r2
            r10.mServerException = r2
            r3 = 0
            r10.mResultCode = r3
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)
            com.google.firebase.storage.FirebaseStorage r3 = r11.getStorage()
            r10.mStorageRef = r11
            r10.mMetadata = r12
            com.google.firebase.auth.internal.InternalAuthProvider r6 = r3.getAuthProvider()
            r10.mAuthProvider = r6
            com.google.firebase.appcheck.interop.InternalAppCheckTokenProvider r7 = r3.getAppCheckProvider()
            r10.mAppCheckProvider = r7
            r10.mUri = r13
            com.google.firebase.storage.internal.ExponentialBackoffSender r12 = new com.google.firebase.storage.internal.ExponentialBackoffSender
            com.google.firebase.FirebaseApp r4 = r11.getApp()
            android.content.Context r5 = r4.getApplicationContext()
            long r8 = r3.getMaxUploadRetryTimeMillis()
            r4 = r12
            r4.<init>(r5, r6, r7, r8)
            r10.mSender = r12
            r3 = -1
            com.google.firebase.storage.FirebaseStorage r11 = r11.getStorage()     // Catch:{ FileNotFoundException -> 0x00b7 }
            com.google.firebase.FirebaseApp r11 = r11.getApp()     // Catch:{ FileNotFoundException -> 0x00b7 }
            android.content.Context r11 = r11.getApplicationContext()     // Catch:{ FileNotFoundException -> 0x00b7 }
            android.content.ContentResolver r11 = r11.getContentResolver()     // Catch:{ FileNotFoundException -> 0x00b7 }
            java.lang.String r12 = "r"
            android.os.ParcelFileDescriptor r12 = r11.openFileDescriptor(r13, r12)     // Catch:{ NullPointerException -> 0x0091, IOException -> 0x0072 }
            if (r12 == 0) goto L_0x0098
            long r5 = r12.getStatSize()     // Catch:{ NullPointerException -> 0x0091, IOException -> 0x0072 }
            r12.close()     // Catch:{ NullPointerException -> 0x0070, IOException -> 0x006e }
            goto L_0x0099
        L_0x006e:
            r12 = move-exception
            goto L_0x0074
        L_0x0070:
            r12 = move-exception
            goto L_0x0093
        L_0x0072:
            r12 = move-exception
            r5 = r3
        L_0x0074:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00b4 }
            r13.<init>()     // Catch:{ FileNotFoundException -> 0x00b4 }
            java.lang.String r7 = "could not retrieve file size for upload "
            java.lang.StringBuilder r13 = r13.append(r7)     // Catch:{ FileNotFoundException -> 0x00b4 }
            android.net.Uri r7 = r10.mUri     // Catch:{ FileNotFoundException -> 0x00b4 }
            java.lang.String r7 = r7.toString()     // Catch:{ FileNotFoundException -> 0x00b4 }
            java.lang.StringBuilder r13 = r13.append(r7)     // Catch:{ FileNotFoundException -> 0x00b4 }
            java.lang.String r13 = r13.toString()     // Catch:{ FileNotFoundException -> 0x00b4 }
            android.util.Log.w(r0, r13, r12)     // Catch:{ FileNotFoundException -> 0x00b4 }
            goto L_0x0099
        L_0x0091:
            r12 = move-exception
            r5 = r3
        L_0x0093:
            java.lang.String r13 = "NullPointerException during file size calculation."
            android.util.Log.w(r0, r13, r12)     // Catch:{ FileNotFoundException -> 0x00b4 }
        L_0x0098:
            r5 = r3
        L_0x0099:
            android.net.Uri r12 = r10.mUri     // Catch:{ FileNotFoundException -> 0x00b4 }
            java.io.InputStream r2 = r11.openInputStream(r12)     // Catch:{ FileNotFoundException -> 0x00b4 }
            if (r2 == 0) goto L_0x00d7
            int r11 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r11 != 0) goto L_0x00ac
            int r11 = r2.available()     // Catch:{ IOException -> 0x00ac }
            if (r11 < 0) goto L_0x00ac
            long r5 = (long) r11
        L_0x00ac:
            r3 = r5
            java.io.BufferedInputStream r11 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x00b7 }
            r11.<init>(r2)     // Catch:{ FileNotFoundException -> 0x00b7 }
            r2 = r11
            goto L_0x00d6
        L_0x00b4:
            r11 = move-exception
            r3 = r5
            goto L_0x00b8
        L_0x00b7:
            r11 = move-exception
        L_0x00b8:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "could not locate file for uploading:"
            java.lang.StringBuilder r12 = r12.append(r13)
            android.net.Uri r13 = r10.mUri
            java.lang.String r13 = r13.toString()
            java.lang.StringBuilder r12 = r12.append(r13)
            java.lang.String r12 = r12.toString()
            android.util.Log.e(r0, r12)
            r10.mException = r11
        L_0x00d6:
            r5 = r3
        L_0x00d7:
            r10.mTotalByteCount = r5
            com.google.firebase.storage.internal.AdaptiveStreamBuffer r11 = new com.google.firebase.storage.internal.AdaptiveStreamBuffer
            r11.<init>(r2, r1)
            r10.mStreamBuffer = r11
            r11 = 1
            r10.mIsStreamOwned = r11
            r10.mUploadUri = r14
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.storage.UploadTask.<init>(com.google.firebase.storage.StorageReference, com.google.firebase.storage.StorageMetadata, android.net.Uri, android.net.Uri):void");
    }

    UploadTask(StorageReference storageReference, StorageMetadata storageMetadata, InputStream inputStream) {
        this.mBytesUploaded = new AtomicLong(0);
        this.mCurrentChunkSize = 262144;
        this.mUploadUri = null;
        this.mException = null;
        this.mServerException = null;
        this.mResultCode = 0;
        Preconditions.checkNotNull(storageReference);
        Preconditions.checkNotNull(inputStream);
        FirebaseStorage storage = storageReference.getStorage();
        this.mTotalByteCount = -1;
        this.mStorageRef = storageReference;
        this.mMetadata = storageMetadata;
        InternalAuthProvider authProvider = storage.getAuthProvider();
        this.mAuthProvider = authProvider;
        InternalAppCheckTokenProvider appCheckProvider = storage.getAppCheckProvider();
        this.mAppCheckProvider = appCheckProvider;
        this.mStreamBuffer = new AdaptiveStreamBuffer(inputStream, 262144);
        this.mIsStreamOwned = false;
        this.mUri = null;
        this.mSender = new ExponentialBackoffSender(storageReference.getApp().getApplicationContext(), authProvider, appCheckProvider, storageReference.getStorage().getMaxUploadRetryTimeMillis());
    }

    /* access modifiers changed from: package-private */
    public StorageReference getStorage() {
        return this.mStorageRef;
    }

    /* access modifiers changed from: package-private */
    public long getTotalByteCount() {
        return this.mTotalByteCount;
    }

    /* access modifiers changed from: protected */
    public void schedule() {
        StorageTaskScheduler.getInstance().scheduleUpload(getRunnable());
    }

    /* access modifiers changed from: package-private */
    public void run() {
        this.mSender.reset();
        if (!tryChangeState(4, false)) {
            Log.d(TAG, "The upload cannot continue as it is not in a valid state.");
            return;
        }
        if (this.mStorageRef.getParent() == null) {
            this.mException = new IllegalArgumentException("Cannot upload to getRoot. You should upload to a storage location such as .getReference('image.png').putFile...");
        }
        if (this.mException == null) {
            if (this.mUploadUri == null) {
                beginResumableUpload();
            } else {
                recoverStatus(false);
            }
            boolean shouldContinue = shouldContinue();
            while (shouldContinue) {
                uploadChunk();
                shouldContinue = shouldContinue();
                if (shouldContinue) {
                    tryChangeState(4, false);
                }
            }
            if (this.mIsStreamOwned && getInternalState() != 16) {
                try {
                    this.mStreamBuffer.close();
                } catch (IOException e) {
                    Log.e(TAG, "Unable to close stream.", e);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void resetState() {
        this.mException = null;
        this.mServerException = null;
        this.mResultCode = 0;
        this.mServerStatus = null;
    }

    private void beginResumableUpload() {
        JSONObject jSONObject = null;
        String contentType = this.mMetadata != null ? this.mMetadata.getContentType() : null;
        if (this.mUri != null && TextUtils.isEmpty(contentType)) {
            contentType = this.mStorageRef.getStorage().getApp().getApplicationContext().getContentResolver().getType(this.mUri);
        }
        if (TextUtils.isEmpty(contentType)) {
            contentType = APPLICATION_OCTET_STREAM;
        }
        StorageReferenceUri storageReferenceUri = this.mStorageRef.getStorageReferenceUri();
        FirebaseApp app = this.mStorageRef.getApp();
        if (this.mMetadata != null) {
            jSONObject = this.mMetadata.createJSONObject();
        }
        ResumableUploadStartRequest resumableUploadStartRequest = new ResumableUploadStartRequest(storageReferenceUri, app, jSONObject, contentType);
        if (sendWithRetry(resumableUploadStartRequest)) {
            String resultString = resumableUploadStartRequest.getResultString(X_GOOG_UPLOAD_URL);
            if (!TextUtils.isEmpty(resultString)) {
                this.mUploadUri = Uri.parse(resultString);
            }
        }
    }

    private boolean shouldContinue() {
        if (getInternalState() == 128) {
            return false;
        }
        if (Thread.interrupted()) {
            this.mException = new InterruptedException();
            tryChangeState(64, false);
            return false;
        } else if (getInternalState() == 32) {
            tryChangeState(256, false);
            return false;
        } else if (getInternalState() == 8) {
            tryChangeState(16, false);
            return false;
        } else if (!serverStateValid()) {
            return false;
        } else {
            if (this.mUploadUri == null) {
                if (this.mException == null) {
                    this.mException = new IllegalStateException("Unable to obtain an upload URL.");
                }
                tryChangeState(64, false);
                return false;
            } else if (this.mException != null) {
                tryChangeState(64, false);
                return false;
            } else {
                if (!(this.mServerException != null || this.mResultCode < 200 || this.mResultCode >= 300) || recoverStatus(true)) {
                    return true;
                }
                if (serverStateValid()) {
                    tryChangeState(64, false);
                }
                return false;
            }
        }
    }

    private boolean serverStateValid() {
        if (!RESUMABLE_FINAL_STATUS.equals(this.mServerStatus)) {
            return true;
        }
        if (this.mException == null) {
            this.mException = new IOException("The server has terminated the upload session", this.mServerException);
        }
        tryChangeState(64, false);
        return false;
    }

    private boolean recoverStatus(boolean z) {
        ResumableUploadQueryRequest resumableUploadQueryRequest = new ResumableUploadQueryRequest(this.mStorageRef.getStorageReferenceUri(), this.mStorageRef.getApp(), this.mUploadUri);
        if (RESUMABLE_FINAL_STATUS.equals(this.mServerStatus)) {
            return false;
        }
        if (z) {
            if (!sendWithRetry(resumableUploadQueryRequest)) {
                return false;
            }
        } else if (!send(resumableUploadQueryRequest)) {
            return false;
        }
        if (RESUMABLE_FINAL_STATUS.equals(resumableUploadQueryRequest.getResultString("X-Goog-Upload-Status"))) {
            this.mException = new IOException("The server has terminated the upload session");
            return false;
        }
        String resultString = resumableUploadQueryRequest.getResultString("X-Goog-Upload-Size-Received");
        long parseLong = !TextUtils.isEmpty(resultString) ? Long.parseLong(resultString) : 0;
        long j = this.mBytesUploaded.get();
        int i = (j > parseLong ? 1 : (j == parseLong ? 0 : -1));
        if (i > 0) {
            this.mException = new IOException("Unexpected error. The server lost a chunk update.");
            return false;
        } else if (i >= 0) {
            return true;
        } else {
            try {
                long j2 = parseLong - j;
                if (((long) this.mStreamBuffer.advance((int) j2)) != j2) {
                    this.mException = new IOException("Unexpected end of stream encountered.");
                    return false;
                } else if (this.mBytesUploaded.compareAndSet(j, parseLong)) {
                    return true;
                } else {
                    Log.e(TAG, "Somehow, the uploaded bytes changed during an uploaded.  This should nothappen");
                    this.mException = new IllegalStateException("uploaded bytes changed unexpectedly.");
                    return false;
                }
            } catch (IOException e) {
                Log.e(TAG, "Unable to recover position in Stream during resumable upload", e);
                this.mException = e;
                return false;
            }
        }
    }

    private void uploadChunk() {
        try {
            this.mStreamBuffer.fill(this.mCurrentChunkSize);
            int min = Math.min(this.mCurrentChunkSize, this.mStreamBuffer.available());
            ResumableUploadByteRequest resumableUploadByteRequest = new ResumableUploadByteRequest(this.mStorageRef.getStorageReferenceUri(), this.mStorageRef.getApp(), this.mUploadUri, this.mStreamBuffer.get(), this.mBytesUploaded.get(), min, this.mStreamBuffer.isFinished());
            if (!send(resumableUploadByteRequest)) {
                this.mCurrentChunkSize = 262144;
                Log.d(TAG, "Resetting chunk size to " + this.mCurrentChunkSize);
                return;
            }
            this.mBytesUploaded.getAndAdd((long) min);
            if (!this.mStreamBuffer.isFinished()) {
                this.mStreamBuffer.advance(min);
                int i = this.mCurrentChunkSize;
                if (i < MAXIMUM_CHUNK_SIZE) {
                    this.mCurrentChunkSize = i * 2;
                    Log.d(TAG, "Increasing chunk size to " + this.mCurrentChunkSize);
                    return;
                }
                return;
            }
            try {
                this.mMetadata = new StorageMetadata.Builder(resumableUploadByteRequest.getResultBody(), this.mStorageRef).build();
                tryChangeState(4, false);
                tryChangeState(128, false);
            } catch (JSONException e) {
                Log.e(TAG, "Unable to parse resulting metadata from upload:" + resumableUploadByteRequest.getRawResult(), e);
                this.mException = e;
            }
        } catch (IOException e2) {
            Log.e(TAG, "Unable to read bytes for uploading", e2);
            this.mException = e2;
        }
    }

    private boolean send(NetworkRequest networkRequest) {
        networkRequest.performRequest(Util.getCurrentAuthToken(this.mAuthProvider), Util.getCurrentAppCheckToken(this.mAppCheckProvider), this.mStorageRef.getApp().getApplicationContext());
        return processResultValid(networkRequest);
    }

    private boolean sendWithRetry(NetworkRequest networkRequest) {
        this.mSender.sendWithExponentialBackoff(networkRequest);
        return processResultValid(networkRequest);
    }

    private boolean processResultValid(NetworkRequest networkRequest) {
        int resultCode = networkRequest.getResultCode();
        if (this.mSender.isRetryableError(resultCode)) {
            resultCode = -2;
        }
        this.mResultCode = resultCode;
        this.mServerException = networkRequest.getException();
        this.mServerStatus = networkRequest.getResultString("X-Goog-Upload-Status");
        return isValidHttpResponseCode(this.mResultCode) && this.mServerException == null;
    }

    /* access modifiers changed from: protected */
    public void onCanceled() {
        this.mSender.cancel();
        final ResumableUploadCancelRequest resumableUploadCancelRequest = this.mUploadUri != null ? new ResumableUploadCancelRequest(this.mStorageRef.getStorageReferenceUri(), this.mStorageRef.getApp(), this.mUploadUri) : null;
        if (resumableUploadCancelRequest != null) {
            StorageTaskScheduler.getInstance().scheduleCommand(new Runnable() {
                public void run() {
                    resumableUploadCancelRequest.performRequest(Util.getCurrentAuthToken(UploadTask.this.mAuthProvider), Util.getCurrentAppCheckToken(UploadTask.this.mAppCheckProvider), UploadTask.this.mStorageRef.getApp().getApplicationContext());
                }
            });
        }
        this.mException = StorageException.fromErrorStatus(Status.RESULT_CANCELED);
        super.onCanceled();
    }

    /* access modifiers changed from: package-private */
    public TaskSnapshot snapStateImpl() {
        return new TaskSnapshot(StorageException.fromExceptionAndHttpCode(this.mException != null ? this.mException : this.mServerException, this.mResultCode), this.mBytesUploaded.get(), this.mUploadUri, this.mMetadata);
    }

    public class TaskSnapshot extends StorageTask<TaskSnapshot>.SnapshotBase {
        private final long mBytesUploaded;
        private final StorageMetadata mMetadata;
        private final Uri mUploadUri;

        TaskSnapshot(Exception exc, long j, Uri uri, StorageMetadata storageMetadata) {
            super(exc);
            this.mBytesUploaded = j;
            this.mUploadUri = uri;
            this.mMetadata = storageMetadata;
        }

        public long getBytesTransferred() {
            return this.mBytesUploaded;
        }

        public long getTotalByteCount() {
            return UploadTask.this.getTotalByteCount();
        }

        public Uri getUploadSessionUri() {
            return this.mUploadUri;
        }

        public StorageMetadata getMetadata() {
            return this.mMetadata;
        }
    }
}
