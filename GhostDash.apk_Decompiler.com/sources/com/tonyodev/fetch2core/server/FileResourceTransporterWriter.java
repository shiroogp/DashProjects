package com.tonyodev.fetch2core.server;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&¨\u0006\u000f"}, d2 = {"Lcom/tonyodev/fetch2core/server/FileResourceTransporterWriter;", "", "sendFileRequest", "", "fileRequest", "Lcom/tonyodev/fetch2core/server/FileRequest;", "sendFileResponse", "fileResponse", "Lcom/tonyodev/fetch2core/server/FileResponse;", "sendRawBytes", "byteArray", "", "offset", "", "length", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FileResourceTransporterWriter.kt */
public interface FileResourceTransporterWriter {
    void sendFileRequest(FileRequest fileRequest);

    void sendFileResponse(FileResponse fileResponse);

    void sendRawBytes(byte[] bArr, int i, int i2);
}
