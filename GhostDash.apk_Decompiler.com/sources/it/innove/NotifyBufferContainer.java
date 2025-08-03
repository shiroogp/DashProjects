package it.innove;

import java.nio.ByteBuffer;

public class NotifyBufferContainer {
    public ByteBuffer items;

    public NotifyBufferContainer(int i) {
        this.items = ByteBuffer.allocate(i);
    }

    public void resetBuffer() {
        this.items.clear();
    }

    public byte[] put(byte[] bArr) {
        byte[] bArr2;
        int length = bArr.length - this.items.remaining();
        if (length < 0) {
            bArr2 = new byte[length];
            int length2 = bArr.length - length;
            byte[] bArr3 = new byte[length2];
            System.arraycopy(bArr, 0, bArr3, 0, length2);
            System.arraycopy(bArr, length2, bArr2, length, length);
            bArr = bArr3;
        } else {
            bArr2 = null;
        }
        this.items.put(bArr);
        return bArr2;
    }

    public boolean isBufferFull() {
        return this.items.remaining() == 0;
    }

    public int size() {
        return this.items.limit();
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        this.items = ByteBuffer.allocate(0);
    }
}
