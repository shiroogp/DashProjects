package com.tonyodev.fetch2core;

import com.tonyodev.fetch2core.Downloader;
import com.tonyodev.fetch2core.server.FetchFileResourceTransporter;
import com.tonyodev.fetch2core.server.FileRequest;
import java.net.InetSocketAddress;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lcom/tonyodev/fetch2core/FileServerDownloader;", "Lcom/tonyodev/fetch2core/Downloader;", "Lcom/tonyodev/fetch2core/server/FetchFileResourceTransporter;", "Lcom/tonyodev/fetch2core/FileServerDownloader$TransporterRequest;", "getFetchFileServerCatalog", "", "Lcom/tonyodev/fetch2core/FileResource;", "serverRequest", "Lcom/tonyodev/fetch2core/Downloader$ServerRequest;", "TransporterRequest", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FileServerDownloader.kt */
public interface FileServerDownloader extends Downloader<FetchFileResourceTransporter, TransporterRequest> {
    List<FileResource> getFetchFileServerCatalog(Downloader.ServerRequest serverRequest);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/tonyodev/fetch2core/FileServerDownloader$TransporterRequest;", "", "()V", "fileRequest", "Lcom/tonyodev/fetch2core/server/FileRequest;", "getFileRequest", "()Lcom/tonyodev/fetch2core/server/FileRequest;", "setFileRequest", "(Lcom/tonyodev/fetch2core/server/FileRequest;)V", "inetSocketAddress", "Ljava/net/InetSocketAddress;", "getInetSocketAddress", "()Ljava/net/InetSocketAddress;", "setInetSocketAddress", "(Ljava/net/InetSocketAddress;)V", "equals", "", "other", "hashCode", "", "toString", "", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: FileServerDownloader.kt */
    public static class TransporterRequest {
        private FileRequest fileRequest = new FileRequest(0, (String) null, 0, 0, (String) null, (String) null, (Extras) null, 0, 0, false, 1023, (DefaultConstructorMarker) null);
        private InetSocketAddress inetSocketAddress = new InetSocketAddress(0);

        public TransporterRequest() {
        }

        public final InetSocketAddress getInetSocketAddress() {
            return this.inetSocketAddress;
        }

        public final void setInetSocketAddress(InetSocketAddress inetSocketAddress2) {
            Intrinsics.checkParameterIsNotNull(inetSocketAddress2, "<set-?>");
            this.inetSocketAddress = inetSocketAddress2;
        }

        public final FileRequest getFileRequest() {
            return this.fileRequest;
        }

        public final void setFileRequest(FileRequest fileRequest2) {
            Intrinsics.checkParameterIsNotNull(fileRequest2, "<set-?>");
            this.fileRequest = fileRequest2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
                return false;
            }
            if (obj != null) {
                TransporterRequest transporterRequest = (TransporterRequest) obj;
                if (!(!Intrinsics.areEqual((Object) this.inetSocketAddress, (Object) transporterRequest.inetSocketAddress)) && !(!Intrinsics.areEqual((Object) this.fileRequest, (Object) transporterRequest.fileRequest))) {
                    return true;
                }
                return false;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.tonyodev.fetch2core.FileServerDownloader.TransporterRequest");
        }

        public int hashCode() {
            return (this.inetSocketAddress.hashCode() * 31) + this.fileRequest.hashCode();
        }

        public String toString() {
            return "TransporterRequest(inetSocketAddress=" + this.inetSocketAddress + ", fileRequest=" + this.fileRequest + ')';
        }
    }
}
