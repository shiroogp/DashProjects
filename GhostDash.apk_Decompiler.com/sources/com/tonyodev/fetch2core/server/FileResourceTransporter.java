package com.tonyodev.fetch2core.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketAddress;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/tonyodev/fetch2core/server/FileResourceTransporter;", "Lcom/tonyodev/fetch2core/server/FileResourceTransporterWriter;", "isClosed", "", "()Z", "close", "", "connect", "socketAddress", "Ljava/net/SocketAddress;", "getInputStream", "Ljava/io/InputStream;", "getOutputStream", "Ljava/io/OutputStream;", "readRawBytes", "", "byteArray", "", "offset", "length", "receiveFileRequest", "Lcom/tonyodev/fetch2core/server/FileRequest;", "receiveFileResponse", "Lcom/tonyodev/fetch2core/server/FileResponse;", "Companion", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FileResourceTransporter.kt */
public interface FileResourceTransporter extends FileResourceTransporterWriter {
    public static final int BUFFER_SIZE = 8192;
    public static final Companion Companion = Companion.$$INSTANCE;

    void close();

    void connect(SocketAddress socketAddress);

    InputStream getInputStream();

    OutputStream getOutputStream();

    boolean isClosed();

    int readRawBytes(byte[] bArr, int i, int i2);

    FileRequest receiveFileRequest();

    FileResponse receiveFileResponse();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tonyodev/fetch2core/server/FileResourceTransporter$Companion;", "", "()V", "BUFFER_SIZE", "", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: FileResourceTransporter.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int BUFFER_SIZE = 8192;

        private Companion() {
        }
    }
}
