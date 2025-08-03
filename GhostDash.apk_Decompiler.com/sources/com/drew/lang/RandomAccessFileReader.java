package com.drew.lang;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Objects;

public class RandomAccessFileReader extends RandomAccessReader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final int _baseOffset;
    private int _currentIndex;
    private final RandomAccessFile _file;
    private final long _length;

    public RandomAccessFileReader(RandomAccessFile randomAccessFile) throws IOException {
        this(randomAccessFile, 0);
    }

    public RandomAccessFileReader(RandomAccessFile randomAccessFile, int i) throws IOException {
        Objects.requireNonNull(randomAccessFile);
        this._file = randomAccessFile;
        this._baseOffset = i;
        this._length = randomAccessFile.length();
    }

    public int toUnshiftedOffset(int i) {
        return i + this._baseOffset;
    }

    public long getLength() {
        return this._length;
    }

    public byte getByte(int i) throws IOException {
        if (i != this._currentIndex) {
            seek(i);
        }
        int read = this._file.read();
        if (read >= 0) {
            this._currentIndex++;
            return (byte) read;
        }
        throw new BufferBoundsException("Unexpected end of file encountered.");
    }

    public byte[] getBytes(int i, int i2) throws IOException {
        validateIndex(i, i2);
        if (i != this._currentIndex) {
            seek(i);
        }
        byte[] bArr = new byte[i2];
        int read = this._file.read(bArr);
        this._currentIndex += read;
        if (read == i2) {
            return bArr;
        }
        throw new BufferBoundsException("Unexpected end of file encountered.");
    }

    private void seek(int i) throws IOException {
        if (i != this._currentIndex) {
            this._file.seek((long) i);
            this._currentIndex = i;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isValidIndex(int i, int i2) throws IOException {
        return i2 >= 0 && i >= 0 && (((long) i) + ((long) i2)) - 1 < this._length;
    }

    /* access modifiers changed from: protected */
    public void validateIndex(int i, int i2) throws IOException {
        if (!isValidIndex(i, i2)) {
            throw new BufferBoundsException(i, i2, this._length);
        }
    }
}
