package com.tonyodev.fetch2core.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\n\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u001fH\u0016J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020!H\u0016J \u0010&\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J\b\u0010'\u001a\u00020\u0010H\u0002J\b\u0010(\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/tonyodev/fetch2core/server/FetchFileResourceTransporter;", "Lcom/tonyodev/fetch2core/server/FileResourceTransporter;", "client", "Ljava/net/Socket;", "(Ljava/net/Socket;)V", "closed", "", "dataInput", "Ljava/io/DataInputStream;", "dataOutput", "Ljava/io/DataOutputStream;", "isClosed", "()Z", "lock", "", "close", "", "connect", "socketAddress", "Ljava/net/SocketAddress;", "getInputStream", "Ljava/io/InputStream;", "getOutputStream", "Ljava/io/OutputStream;", "readRawBytes", "", "byteArray", "", "offset", "length", "receiveFileRequest", "Lcom/tonyodev/fetch2core/server/FileRequest;", "receiveFileResponse", "Lcom/tonyodev/fetch2core/server/FileResponse;", "sendFileRequest", "fileRequest", "sendFileResponse", "fileResponse", "sendRawBytes", "throwExceptionIfClosed", "throwIfNotConnected", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FetchFileResourceTransporter.kt */
public final class FetchFileResourceTransporter implements FileResourceTransporter {
    private final Socket client;
    private volatile boolean closed;
    private DataInputStream dataInput;
    private DataOutputStream dataOutput;
    private final Object lock;

    public FetchFileResourceTransporter() {
        this((Socket) null, 1, (DefaultConstructorMarker) null);
    }

    public FetchFileResourceTransporter(Socket socket) {
        Intrinsics.checkParameterIsNotNull(socket, "client");
        this.client = socket;
        this.lock = new Object();
        if (socket.isConnected() && !socket.isClosed()) {
            this.dataInput = new DataInputStream(socket.getInputStream());
            this.dataOutput = new DataOutputStream(socket.getOutputStream());
        }
        if (socket.isClosed()) {
            this.closed = true;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FetchFileResourceTransporter(Socket socket, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Socket() : socket);
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this.lock) {
            z = this.closed;
        }
        return z;
    }

    public void connect(SocketAddress socketAddress) {
        Intrinsics.checkParameterIsNotNull(socketAddress, "socketAddress");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.client.connect(socketAddress);
            this.dataInput = new DataInputStream(this.client.getInputStream());
            this.dataOutput = new DataOutputStream(this.client.getOutputStream());
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:13|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r1 = com.tonyodev.fetch2core.Extras.CREATOR.getEmptyExtras();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0082 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tonyodev.fetch2core.server.FileRequest receiveFileRequest() {
        /*
            r20 = this;
            r1 = r20
            java.lang.Object r2 = r1.lock
            monitor-enter(r2)
            r20.throwExceptionIfClosed()     // Catch:{ all -> 0x00f0 }
            r20.throwIfNotConnected()     // Catch:{ all -> 0x00f0 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x00f0 }
            java.io.DataInputStream r3 = r1.dataInput     // Catch:{ all -> 0x00f0 }
            if (r3 != 0) goto L_0x0016
            java.lang.String r4 = "dataInput"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)     // Catch:{ all -> 0x00f0 }
        L_0x0016:
            java.lang.String r3 = r3.readUTF()     // Catch:{ all -> 0x00f0 }
            r0.<init>(r3)     // Catch:{ all -> 0x00f0 }
            java.lang.String r3 = "Type"
            int r5 = r0.getInt(r3)     // Catch:{ all -> 0x00f0 }
            java.lang.String r3 = "FileResourceId"
            java.lang.String r6 = r0.getString(r3)     // Catch:{ all -> 0x00f0 }
            java.lang.String r3 = "Range-Start"
            long r3 = r0.getLong(r3)     // Catch:{ all -> 0x00f0 }
            java.lang.String r7 = "Range-End"
            long r7 = r0.getLong(r7)     // Catch:{ all -> 0x00f0 }
            java.lang.String r9 = "Authorization"
            java.lang.String r11 = r0.getString(r9)     // Catch:{ all -> 0x00f0 }
            java.lang.String r9 = "Client"
            java.lang.String r12 = r0.getString(r9)     // Catch:{ all -> 0x00f0 }
            java.util.LinkedHashMap r9 = new java.util.LinkedHashMap     // Catch:{ Exception -> 0x0082 }
            r9.<init>()     // Catch:{ Exception -> 0x0082 }
            java.util.Map r9 = (java.util.Map) r9     // Catch:{ Exception -> 0x0082 }
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x0082 }
            java.lang.String r13 = "Extras"
            java.lang.String r13 = r0.getString(r13)     // Catch:{ Exception -> 0x0082 }
            r10.<init>(r13)     // Catch:{ Exception -> 0x0082 }
            java.util.Iterator r13 = r10.keys()     // Catch:{ Exception -> 0x0082 }
            java.lang.String r14 = "jsonObject.keys()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r13, r14)     // Catch:{ Exception -> 0x0082 }
        L_0x005c:
            boolean r14 = r13.hasNext()     // Catch:{ Exception -> 0x0082 }
            if (r14 == 0) goto L_0x007c
            java.lang.Object r14 = r13.next()     // Catch:{ Exception -> 0x0082 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ Exception -> 0x0082 }
            java.lang.String r15 = "it"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r15)     // Catch:{ Exception -> 0x0082 }
            java.lang.String r15 = r10.getString(r14)     // Catch:{ Exception -> 0x0082 }
            java.lang.String r1 = "jsonObject.getString(it)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r15, r1)     // Catch:{ Exception -> 0x0082 }
            r9.put(r14, r15)     // Catch:{ Exception -> 0x0082 }
            r1 = r20
            goto L_0x005c
        L_0x007c:
            com.tonyodev.fetch2core.Extras r1 = new com.tonyodev.fetch2core.Extras     // Catch:{ Exception -> 0x0082 }
            r1.<init>(r9)     // Catch:{ Exception -> 0x0082 }
            goto L_0x0088
        L_0x0082:
            com.tonyodev.fetch2core.Extras$CREATOR r1 = com.tonyodev.fetch2core.Extras.CREATOR     // Catch:{ all -> 0x00f0 }
            com.tonyodev.fetch2core.Extras r1 = r1.getEmptyExtras()     // Catch:{ all -> 0x00f0 }
        L_0x0088:
            r13 = r1
            java.lang.String r1 = "Page"
            int r1 = r0.getInt(r1)     // Catch:{ all -> 0x00f0 }
            java.lang.String r9 = "Size"
            int r9 = r0.getInt(r9)     // Catch:{ all -> 0x00f0 }
            r14 = 0
            int r10 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            r14 = -1
            if (r10 < 0) goto L_0x00a4
            int r10 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r10 <= 0) goto L_0x00a1
            goto L_0x00a4
        L_0x00a1:
            r18 = r3
            goto L_0x00b0
        L_0x00a4:
            r18 = r3
            long r3 = (long) r14     // Catch:{ all -> 0x00f0 }
            int r3 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x00b0
            r3 = 0
            r16 = 0
            goto L_0x00b4
        L_0x00b0:
            r16 = r18
            r3 = 0
        L_0x00b4:
            int r3 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x00c0
            int r3 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r3 >= 0) goto L_0x00bd
            goto L_0x00c0
        L_0x00bd:
            r18 = r7
            goto L_0x00c4
        L_0x00c0:
            r3 = -1
            r18 = r3
        L_0x00c4:
            if (r1 >= r14) goto L_0x00c7
            r1 = r14
        L_0x00c7:
            if (r9 >= r14) goto L_0x00cb
            r15 = r14
            goto L_0x00cc
        L_0x00cb:
            r15 = r9
        L_0x00cc:
            java.lang.String r3 = "Persist-Connection"
            boolean r0 = r0.getBoolean(r3)     // Catch:{ all -> 0x00f0 }
            com.tonyodev.fetch2core.server.FileRequest r3 = new com.tonyodev.fetch2core.server.FileRequest     // Catch:{ all -> 0x00f0 }
            java.lang.String r4 = "fileResourceId"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r4)     // Catch:{ all -> 0x00f0 }
            java.lang.String r4 = "authorization"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r11, r4)     // Catch:{ all -> 0x00f0 }
            java.lang.String r4 = "client"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r12, r4)     // Catch:{ all -> 0x00f0 }
            r4 = r3
            r7 = r16
            r9 = r18
            r14 = r1
            r16 = r0
            r4.<init>(r5, r6, r7, r9, r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x00f0 }
            monitor-exit(r2)
            return r3
        L_0x00f0:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2core.server.FetchFileResourceTransporter.receiveFileRequest():com.tonyodev.fetch2core.server.FileRequest");
    }

    public void sendFileRequest(FileRequest fileRequest) {
        Intrinsics.checkParameterIsNotNull(fileRequest, "fileRequest");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            throwIfNotConnected();
            DataOutputStream dataOutputStream = this.dataOutput;
            if (dataOutputStream == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataOutput");
            }
            dataOutputStream.writeUTF(fileRequest.getToJsonString());
            DataOutputStream dataOutputStream2 = this.dataOutput;
            if (dataOutputStream2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataOutput");
            }
            dataOutputStream2.flush();
            Unit unit = Unit.INSTANCE;
        }
    }

    public FileResponse receiveFileResponse() {
        FileResponse fileResponse;
        synchronized (this.lock) {
            throwExceptionIfClosed();
            throwIfNotConnected();
            DataInputStream dataInputStream = this.dataInput;
            if (dataInputStream == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataInput");
            }
            String readUTF = dataInputStream.readUTF();
            Intrinsics.checkExpressionValueIsNotNull(readUTF, "dataInput.readUTF()");
            if (readUTF != null) {
                String lowerCase = readUTF.toLowerCase();
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
                JSONObject jSONObject = new JSONObject(lowerCase);
                int i = jSONObject.getInt("status");
                int i2 = jSONObject.getInt("type");
                int i3 = jSONObject.getInt(FileResponse.FIELD_CONNECTION);
                long j = jSONObject.getLong(FileResponse.FIELD_DATE);
                long j2 = jSONObject.getLong("content-length");
                String string = jSONObject.getString(FileResponse.FIELD_MD5);
                String string2 = jSONObject.getString(FileResponse.FIELD_SESSION_ID);
                Intrinsics.checkExpressionValueIsNotNull(string, FileResponse.FIELD_MD5);
                Intrinsics.checkExpressionValueIsNotNull(string2, "sessionId");
                fileResponse = new FileResponse(i, i2, i3, j, j2, string, string2);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
        }
        return fileResponse;
    }

    public void sendFileResponse(FileResponse fileResponse) {
        Intrinsics.checkParameterIsNotNull(fileResponse, "fileResponse");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            throwIfNotConnected();
            DataOutputStream dataOutputStream = this.dataOutput;
            if (dataOutputStream == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataOutput");
            }
            dataOutputStream.writeUTF(fileResponse.getToJsonString());
            DataOutputStream dataOutputStream2 = this.dataOutput;
            if (dataOutputStream2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataOutput");
            }
            dataOutputStream2.flush();
            Unit unit = Unit.INSTANCE;
        }
    }

    public void sendRawBytes(byte[] bArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(bArr, "byteArray");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            throwIfNotConnected();
            DataOutputStream dataOutputStream = this.dataOutput;
            if (dataOutputStream == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataOutput");
            }
            dataOutputStream.write(bArr, i, i2);
            DataOutputStream dataOutputStream2 = this.dataOutput;
            if (dataOutputStream2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataOutput");
            }
            dataOutputStream2.flush();
            Unit unit = Unit.INSTANCE;
        }
    }

    public int readRawBytes(byte[] bArr, int i, int i2) {
        int read;
        Intrinsics.checkParameterIsNotNull(bArr, "byteArray");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            throwIfNotConnected();
            DataInputStream dataInputStream = this.dataInput;
            if (dataInputStream == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataInput");
            }
            read = dataInputStream.read(bArr, i, i2);
        }
        return read;
    }

    public InputStream getInputStream() {
        InputStream inputStream;
        synchronized (this.lock) {
            throwExceptionIfClosed();
            throwIfNotConnected();
            DataInputStream dataInputStream = this.dataInput;
            if (dataInputStream == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataInput");
            }
            inputStream = dataInputStream;
        }
        return inputStream;
    }

    public OutputStream getOutputStream() {
        OutputStream outputStream;
        synchronized (this.lock) {
            throwExceptionIfClosed();
            throwIfNotConnected();
            DataOutputStream dataOutputStream = this.dataOutput;
            if (dataOutputStream == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataOutput");
            }
            outputStream = dataOutputStream;
        }
        return outputStream;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:5|6|7|(1:9)|10|11|12|(1:14)|15|16|17) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:2|3|(11:5|6|7|(1:9)|10|11|12|(1:14)|15|16|17)|18|19|20) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0016 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0022 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0027 */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x001a A[Catch:{ Exception -> 0x0022 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            boolean r1 = r3.closed     // Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x0027
            r1 = 1
            r3.closed = r1     // Catch:{ all -> 0x002b }
            java.io.DataInputStream r1 = r3.dataInput     // Catch:{ Exception -> 0x0016 }
            if (r1 != 0) goto L_0x0013
            java.lang.String r2 = "dataInput"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)     // Catch:{ Exception -> 0x0016 }
        L_0x0013:
            r1.close()     // Catch:{ Exception -> 0x0016 }
        L_0x0016:
            java.io.DataOutputStream r1 = r3.dataOutput     // Catch:{ Exception -> 0x0022 }
            if (r1 != 0) goto L_0x001f
            java.lang.String r2 = "dataOutput"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)     // Catch:{ Exception -> 0x0022 }
        L_0x001f:
            r1.close()     // Catch:{ Exception -> 0x0022 }
        L_0x0022:
            java.net.Socket r1 = r3.client     // Catch:{ Exception -> 0x0027 }
            r1.close()     // Catch:{ Exception -> 0x0027 }
        L_0x0027:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002b }
            monitor-exit(r0)
            return
        L_0x002b:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2core.server.FetchFileResourceTransporter.close():void");
    }

    private final void throwExceptionIfClosed() {
        if (this.closed) {
            throw new Exception("FetchFileResourceTransporter is already closed.");
        }
    }

    private final void throwIfNotConnected() {
        DataInputStream dataInputStream = this.dataInput;
        if (dataInputStream == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataInput");
        }
        if (dataInputStream != null) {
            DataOutputStream dataOutputStream = this.dataOutput;
            if (dataOutputStream == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataOutput");
            }
            if (dataOutputStream != null) {
                return;
            }
        }
        throw new Exception("You forgot to call connect before calling this method.");
    }
}
