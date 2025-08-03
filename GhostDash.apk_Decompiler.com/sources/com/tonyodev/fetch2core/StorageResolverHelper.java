package com.tonyodev.fetch2core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import com.facebook.common.util.UriUtil;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t\u001a\u0016\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u001e\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t\u001a\u0016\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u0016\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017\u001a\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f\u001a\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001c\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007\u001a\u001c\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007\u001a\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017\u001a\u001e\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006!"}, d2 = {"allocateFile", "", "file", "Ljava/io/File;", "contentLength", "", "filePath", "", "context", "Landroid/content/Context;", "allocateParcelFileDescriptor", "parcelFileDescriptor", "Landroid/os/ParcelFileDescriptor;", "createFileAtPath", "increment", "", "createLocalFile", "deleteFile", "getOutputResourceWrapper", "Lcom/tonyodev/fetch2core/OutputResourceWrapper;", "fileUri", "Landroid/net/Uri;", "contentResolver", "Landroid/content/ContentResolver;", "fileDescriptor", "Ljava/io/FileDescriptor;", "fileOutputStream", "Ljava/io/FileOutputStream;", "randomAccessFile", "Ljava/io/RandomAccessFile;", "renameFile", "oldFile", "newFile", "fetch2core_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: StorageResolverHelper.kt */
public final class StorageResolverHelper {
    public static final OutputResourceWrapper getOutputResourceWrapper(FileDescriptor fileDescriptor) {
        return getOutputResourceWrapper$default(fileDescriptor, (ParcelFileDescriptor) null, 2, (Object) null);
    }

    public static final OutputResourceWrapper getOutputResourceWrapper(FileOutputStream fileOutputStream) {
        return getOutputResourceWrapper$default(fileOutputStream, (ParcelFileDescriptor) null, 2, (Object) null);
    }

    public static final OutputResourceWrapper getOutputResourceWrapper(ParcelFileDescriptor parcelFileDescriptor) {
        Intrinsics.checkParameterIsNotNull(parcelFileDescriptor, "parcelFileDescriptor");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Intrinsics.checkExpressionValueIsNotNull(fileDescriptor, "parcelFileDescriptor.fileDescriptor");
        return getOutputResourceWrapper(fileDescriptor, parcelFileDescriptor);
    }

    public static /* synthetic */ OutputResourceWrapper getOutputResourceWrapper$default(FileDescriptor fileDescriptor, ParcelFileDescriptor parcelFileDescriptor, int i, Object obj) {
        if ((i & 2) != 0) {
            parcelFileDescriptor = null;
        }
        return getOutputResourceWrapper(fileDescriptor, parcelFileDescriptor);
    }

    public static final OutputResourceWrapper getOutputResourceWrapper(FileDescriptor fileDescriptor, ParcelFileDescriptor parcelFileDescriptor) {
        Intrinsics.checkParameterIsNotNull(fileDescriptor, "fileDescriptor");
        return getOutputResourceWrapper(new FileOutputStream(fileDescriptor), parcelFileDescriptor);
    }

    public static /* synthetic */ OutputResourceWrapper getOutputResourceWrapper$default(FileOutputStream fileOutputStream, ParcelFileDescriptor parcelFileDescriptor, int i, Object obj) {
        if ((i & 2) != 0) {
            parcelFileDescriptor = null;
        }
        return getOutputResourceWrapper(fileOutputStream, parcelFileDescriptor);
    }

    public static final OutputResourceWrapper getOutputResourceWrapper(FileOutputStream fileOutputStream, ParcelFileDescriptor parcelFileDescriptor) {
        Intrinsics.checkParameterIsNotNull(fileOutputStream, "fileOutputStream");
        return new StorageResolverHelper$getOutputResourceWrapper$1(fileOutputStream, parcelFileDescriptor);
    }

    public static final OutputResourceWrapper getOutputResourceWrapper(String str, ContentResolver contentResolver) {
        Intrinsics.checkParameterIsNotNull(str, "filePath");
        Intrinsics.checkParameterIsNotNull(contentResolver, "contentResolver");
        if (!FetchCoreUtils.isUriPath(str)) {
            return getOutputResourceWrapper(new File(str));
        }
        Uri parse = Uri.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(filePath)");
        return getOutputResourceWrapper(parse, contentResolver);
    }

    public static final OutputResourceWrapper getOutputResourceWrapper(Uri uri, ContentResolver contentResolver) {
        Intrinsics.checkParameterIsNotNull(uri, "fileUri");
        Intrinsics.checkParameterIsNotNull(contentResolver, "contentResolver");
        if (Intrinsics.areEqual((Object) uri.getScheme(), (Object) "content")) {
            ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(uri, "w");
            if (openFileDescriptor != null) {
                return getOutputResourceWrapper(openFileDescriptor);
            }
            throw new FileNotFoundException(uri + " file_not_found");
        } else if (Intrinsics.areEqual((Object) uri.getScheme(), (Object) UriUtil.LOCAL_FILE_SCHEME)) {
            File file = new File(uri.getPath());
            if (file.exists() && file.canWrite()) {
                return getOutputResourceWrapper(file);
            }
            ParcelFileDescriptor openFileDescriptor2 = contentResolver.openFileDescriptor(uri, "w");
            if (openFileDescriptor2 != null) {
                return getOutputResourceWrapper(openFileDescriptor2);
            }
            throw new FileNotFoundException(uri + " file_not_found");
        } else {
            throw new FileNotFoundException(uri + " file_not_found");
        }
    }

    public static final OutputResourceWrapper getOutputResourceWrapper(String str) {
        Intrinsics.checkParameterIsNotNull(str, "filePath");
        File file = new File(str);
        if (file.exists()) {
            return getOutputResourceWrapper(file);
        }
        throw new FileNotFoundException(file + " file_not_found");
    }

    public static final OutputResourceWrapper getOutputResourceWrapper(File file) {
        Intrinsics.checkParameterIsNotNull(file, UriUtil.LOCAL_FILE_SCHEME);
        if (file.exists()) {
            return getOutputResourceWrapper(new RandomAccessFile(file, "rw"));
        }
        throw new FileNotFoundException(file.getCanonicalPath() + " file_not_found");
    }

    public static final OutputResourceWrapper getOutputResourceWrapper(RandomAccessFile randomAccessFile) {
        Intrinsics.checkParameterIsNotNull(randomAccessFile, "randomAccessFile");
        return new StorageResolverHelper$getOutputResourceWrapper$2(randomAccessFile);
    }

    public static final boolean deleteFile(String str, Context context) {
        Intrinsics.checkParameterIsNotNull(str, "filePath");
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (!FetchCoreUtils.isUriPath(str)) {
            return FetchCoreUtils.deleteFile(new File(str));
        }
        Uri parse = Uri.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "uri");
        if (Intrinsics.areEqual((Object) parse.getScheme(), (Object) UriUtil.LOCAL_FILE_SCHEME)) {
            File file = new File(parse.getPath());
            if (!file.canWrite() || !file.exists()) {
                return false;
            }
            return FetchCoreUtils.deleteFile(file);
        } else if (!Intrinsics.areEqual((Object) parse.getScheme(), (Object) "content")) {
            return false;
        } else {
            if (Build.VERSION.SDK_INT >= 19 && DocumentsContract.isDocumentUri(context, parse)) {
                return DocumentsContract.deleteDocument(context.getContentResolver(), parse);
            }
            if (context.getContentResolver().delete(parse, (String) null, (String[]) null) > 0) {
                return true;
            }
            return false;
        }
    }

    public static final boolean renameFile(String str, String str2, Context context) {
        Intrinsics.checkParameterIsNotNull(str, "oldFile");
        Intrinsics.checkParameterIsNotNull(str2, "newFile");
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (!FetchCoreUtils.isUriPath(str)) {
            return FetchCoreUtils.renameFile(new File(str), new File(str2));
        }
        Uri parse = Uri.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "uri");
        if (Intrinsics.areEqual((Object) parse.getScheme(), (Object) UriUtil.LOCAL_FILE_SCHEME)) {
            File file = new File(parse.getPath());
            if (file.canWrite() && file.exists()) {
                return FetchCoreUtils.renameFile(file, new File(str2));
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("uri", str2);
            if (context.getContentResolver().update(parse, contentValues, (String) null, (String[]) null) > 0) {
                return true;
            }
        } else if (Intrinsics.areEqual((Object) parse.getScheme(), (Object) "content")) {
            if (Build.VERSION.SDK_INT < 21 || !DocumentsContract.isDocumentUri(context, parse)) {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("uri", str2);
                if (context.getContentResolver().update(parse, contentValues2, (String) null, (String[]) null) > 0) {
                    return true;
                }
            } else if (DocumentsContract.renameDocument(context.getContentResolver(), parse, str2) != null) {
                return true;
            }
        }
        return false;
    }

    public static final String createFileAtPath(String str, boolean z, Context context) {
        Intrinsics.checkParameterIsNotNull(str, "filePath");
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (!FetchCoreUtils.isUriPath(str)) {
            return createLocalFile(str, z);
        }
        Uri parse = Uri.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "uri");
        if (Intrinsics.areEqual((Object) parse.getScheme(), (Object) UriUtil.LOCAL_FILE_SCHEME)) {
            String path = parse.getPath();
            if (path != null) {
                str = path;
            }
            return createLocalFile(str, z);
        } else if (!Intrinsics.areEqual((Object) parse.getScheme(), (Object) "content")) {
            throw new IOException(FetchErrorStrings.FNC);
        } else if (context.getContentResolver().openFileDescriptor(parse, "w") != null) {
            return str;
        } else {
            throw new IOException(FetchErrorStrings.FNC);
        }
    }

    public static final String createLocalFile(String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "filePath");
        if (!z) {
            FetchCoreUtils.createFile(new File(str));
            return str;
        }
        String absolutePath = FetchCoreUtils.getIncrementedFileIfOriginalExists(str).getAbsolutePath();
        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "getIncrementedFileIfOrig…ts(filePath).absolutePath");
        return absolutePath;
    }

    public static final void allocateFile(String str, long j, Context context) {
        Intrinsics.checkParameterIsNotNull(str, "filePath");
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (FetchCoreUtils.isUriPath(str)) {
            Uri parse = Uri.parse(str);
            Intrinsics.checkExpressionValueIsNotNull(parse, "uri");
            if (Intrinsics.areEqual((Object) parse.getScheme(), (Object) UriUtil.LOCAL_FILE_SCHEME)) {
                String path = parse.getPath();
                if (path != null) {
                    str = path;
                }
                allocateFile(new File(str), j);
            } else if (Intrinsics.areEqual((Object) parse.getScheme(), (Object) "content")) {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(parse, "w");
                if (openFileDescriptor != null) {
                    allocateParcelFileDescriptor(openFileDescriptor, j);
                    return;
                }
                throw new IOException(FetchErrorStrings.FILE_ALLOCATION_ERROR);
            } else {
                throw new IOException(FetchErrorStrings.FILE_ALLOCATION_ERROR);
            }
        } else {
            allocateFile(new File(str), j);
        }
    }

    public static final void allocateParcelFileDescriptor(ParcelFileDescriptor parcelFileDescriptor, long j) {
        Intrinsics.checkParameterIsNotNull(parcelFileDescriptor, "parcelFileDescriptor");
        if (j > 0) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(parcelFileDescriptor.getFileDescriptor());
                if (fileOutputStream.getChannel().size() != j) {
                    fileOutputStream.getChannel().position(j - 1);
                    fileOutputStream.write(1);
                }
            } catch (Exception unused) {
                throw new IOException(FetchErrorStrings.FILE_ALLOCATION_ERROR);
            }
        }
    }

    public static final void allocateFile(File file, long j) {
        Intrinsics.checkParameterIsNotNull(file, UriUtil.LOCAL_FILE_SCHEME);
        if (!file.exists()) {
            FetchCoreUtils.createFile(file);
        }
        if (file.length() != j && j > 0) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.setLength(j);
                randomAccessFile.close();
            } catch (Exception unused) {
                throw new IOException(FetchErrorStrings.FILE_ALLOCATION_ERROR);
            }
        }
    }
}
