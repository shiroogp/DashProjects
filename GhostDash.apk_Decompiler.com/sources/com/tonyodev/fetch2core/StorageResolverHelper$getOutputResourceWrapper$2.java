package com.tonyodev.fetch2core;

import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"com/tonyodev/fetch2core/StorageResolverHelper$getOutputResourceWrapper$2", "Lcom/tonyodev/fetch2core/OutputResourceWrapper;", "randomAccessFile", "Ljava/io/RandomAccessFile;", "close", "", "flush", "setWriteOffset", "offset", "", "write", "byteArray", "", "offSet", "", "length", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: StorageResolverHelper.kt */
public final class StorageResolverHelper$getOutputResourceWrapper$2 extends OutputResourceWrapper {
    final /* synthetic */ RandomAccessFile $randomAccessFile;
    private final RandomAccessFile randomAccessFile;

    public void flush() {
    }

    StorageResolverHelper$getOutputResourceWrapper$2(RandomAccessFile randomAccessFile2) {
        this.$randomAccessFile = randomAccessFile2;
        this.randomAccessFile = randomAccessFile2;
        randomAccessFile2.seek(0);
    }

    public void write(byte[] bArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(bArr, "byteArray");
        this.randomAccessFile.write(bArr, i, i2);
    }

    public void setWriteOffset(long j) {
        this.randomAccessFile.seek(j);
    }

    public void close() {
        this.randomAccessFile.close();
    }
}
