package com.tonyodev.fetch2core;

import com.tonyodev.fetch2core.Downloader;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH&J\u001a\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010H&J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H&¨\u0006\u0014"}, d2 = {"Lcom/tonyodev/fetch2core/StorageResolver;", "", "createFile", "", "file", "increment", "", "deleteFile", "fileExists", "getDirectoryForFileDownloaderTypeParallel", "request", "Lcom/tonyodev/fetch2core/Downloader$ServerRequest;", "getRequestOutputResourceWrapper", "Lcom/tonyodev/fetch2core/OutputResourceWrapper;", "preAllocateFile", "contentLength", "", "renameFile", "oldFile", "newFile", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: StorageResolver.kt */
public interface StorageResolver {
    String createFile(String str, boolean z);

    boolean deleteFile(String str);

    boolean fileExists(String str);

    String getDirectoryForFileDownloaderTypeParallel(Downloader.ServerRequest serverRequest);

    OutputResourceWrapper getRequestOutputResourceWrapper(Downloader.ServerRequest serverRequest);

    boolean preAllocateFile(String str, long j);

    boolean renameFile(String str, String str2);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* compiled from: StorageResolver.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ String createFile$default(StorageResolver storageResolver, String str, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return storageResolver.createFile(str, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createFile");
        }

        public static /* synthetic */ boolean preAllocateFile$default(StorageResolver storageResolver, String str, long j, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    j = -1;
                }
                return storageResolver.preAllocateFile(str, j);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preAllocateFile");
        }
    }
}
