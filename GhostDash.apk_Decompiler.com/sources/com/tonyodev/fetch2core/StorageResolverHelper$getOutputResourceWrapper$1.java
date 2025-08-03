package com.tonyodev.fetch2core;

import android.os.ParcelFileDescriptor;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"com/tonyodev/fetch2core/StorageResolverHelper$getOutputResourceWrapper$1", "Lcom/tonyodev/fetch2core/OutputResourceWrapper;", "fileOutputStream", "Ljava/io/FileOutputStream;", "parcelFileDescriptor", "Landroid/os/ParcelFileDescriptor;", "close", "", "flush", "setWriteOffset", "offset", "", "write", "byteArray", "", "offSet", "", "length", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: StorageResolverHelper.kt */
public final class StorageResolverHelper$getOutputResourceWrapper$1 extends OutputResourceWrapper {
    final /* synthetic */ FileOutputStream $fileOutputStream;
    final /* synthetic */ ParcelFileDescriptor $parcelFileDescriptor;
    private final FileOutputStream fileOutputStream;
    private final ParcelFileDescriptor parcelFileDescriptor;

    StorageResolverHelper$getOutputResourceWrapper$1(FileOutputStream fileOutputStream2, ParcelFileDescriptor parcelFileDescriptor2) {
        this.$fileOutputStream = fileOutputStream2;
        this.$parcelFileDescriptor = parcelFileDescriptor2;
        this.fileOutputStream = fileOutputStream2;
        this.parcelFileDescriptor = parcelFileDescriptor2;
        fileOutputStream2.getChannel().position(0);
    }

    public void write(byte[] bArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(bArr, "byteArray");
        this.fileOutputStream.write(bArr, i, i2);
    }

    public void setWriteOffset(long j) {
        this.fileOutputStream.getChannel().position(j);
    }

    public void flush() {
        this.fileOutputStream.flush();
    }

    public void close() {
        this.fileOutputStream.close();
    }
}
