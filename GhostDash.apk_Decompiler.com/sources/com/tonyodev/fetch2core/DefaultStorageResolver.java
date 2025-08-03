package com.tonyodev.fetch2core;

import android.content.ContentResolver;
import android.content.Context;
import com.facebook.common.util.UriUtil;
import com.tonyodev.fetch2core.Downloader;
import java.io.FileNotFoundException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/tonyodev/fetch2core/DefaultStorageResolver;", "Lcom/tonyodev/fetch2core/StorageResolver;", "context", "Landroid/content/Context;", "defaultTempDir", "", "(Landroid/content/Context;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "getDefaultTempDir", "()Ljava/lang/String;", "createFile", "file", "increment", "", "deleteFile", "fileExists", "getDirectoryForFileDownloaderTypeParallel", "request", "Lcom/tonyodev/fetch2core/Downloader$ServerRequest;", "getRequestOutputResourceWrapper", "Lcom/tonyodev/fetch2core/OutputResourceWrapper;", "preAllocateFile", "contentLength", "", "renameFile", "oldFile", "newFile", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DefaultStorageResolver.kt */
public class DefaultStorageResolver implements StorageResolver {
    private final Context context;
    private final String defaultTempDir;

    public DefaultStorageResolver(Context context2, String str) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(str, "defaultTempDir");
        this.context = context2;
        this.defaultTempDir = str;
    }

    /* access modifiers changed from: protected */
    public final Context getContext() {
        return this.context;
    }

    /* access modifiers changed from: protected */
    public final String getDefaultTempDir() {
        return this.defaultTempDir;
    }

    public String createFile(String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, UriUtil.LOCAL_FILE_SCHEME);
        return StorageResolverHelper.createFileAtPath(str, z, this.context);
    }

    public boolean deleteFile(String str) {
        Intrinsics.checkParameterIsNotNull(str, UriUtil.LOCAL_FILE_SCHEME);
        return StorageResolverHelper.deleteFile(str, this.context);
    }

    public OutputResourceWrapper getRequestOutputResourceWrapper(Downloader.ServerRequest serverRequest) {
        Intrinsics.checkParameterIsNotNull(serverRequest, "request");
        String file = serverRequest.getFile();
        ContentResolver contentResolver = this.context.getContentResolver();
        Intrinsics.checkExpressionValueIsNotNull(contentResolver, "context.contentResolver");
        return StorageResolverHelper.getOutputResourceWrapper(file, contentResolver);
    }

    public String getDirectoryForFileDownloaderTypeParallel(Downloader.ServerRequest serverRequest) {
        Intrinsics.checkParameterIsNotNull(serverRequest, "request");
        return this.defaultTempDir;
    }

    public boolean fileExists(String str) {
        Intrinsics.checkParameterIsNotNull(str, UriUtil.LOCAL_FILE_SCHEME);
        if (str.length() == 0) {
            return false;
        }
        try {
            ContentResolver contentResolver = this.context.getContentResolver();
            Intrinsics.checkExpressionValueIsNotNull(contentResolver, "context.contentResolver");
            StorageResolverHelper.getOutputResourceWrapper(str, contentResolver).close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean renameFile(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "oldFile");
        Intrinsics.checkParameterIsNotNull(str2, "newFile");
        boolean z = true;
        if (!(str.length() == 0)) {
            if (str2.length() != 0) {
                z = false;
            }
            if (!z) {
                return StorageResolverHelper.renameFile(str, str2, this.context);
            }
        }
        return false;
    }

    public boolean preAllocateFile(String str, long j) {
        Intrinsics.checkParameterIsNotNull(str, UriUtil.LOCAL_FILE_SCHEME);
        if (str.length() == 0) {
            throw new FileNotFoundException(str + " file_not_found");
        } else if (j < 1) {
            return true;
        } else {
            StorageResolverHelper.allocateFile(str, j, this.context);
            return true;
        }
    }
}
