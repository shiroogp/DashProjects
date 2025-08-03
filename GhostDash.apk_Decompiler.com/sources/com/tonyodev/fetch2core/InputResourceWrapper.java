package com.tonyodev.fetch2core;

import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/tonyodev/fetch2core/InputResourceWrapper;", "Ljava/io/Closeable;", "()V", "read", "", "byteArray", "", "offSet", "length", "setReadOffset", "", "offset", "", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: InputResourceWrapper.kt */
public abstract class InputResourceWrapper implements Closeable {
    public abstract int read(byte[] bArr, int i, int i2) throws IOException;

    public abstract void setReadOffset(long j) throws IOException;

    public static /* synthetic */ int read$default(InputResourceWrapper inputResourceWrapper, byte[] bArr, int i, int i2, int i3, Object obj) throws IOException {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return inputResourceWrapper.read(bArr, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: read");
    }
}
