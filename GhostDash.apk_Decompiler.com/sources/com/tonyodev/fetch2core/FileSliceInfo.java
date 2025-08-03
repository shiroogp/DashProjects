package com.tonyodev.fetch2core;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/tonyodev/fetch2core/FileSliceInfo;", "", "slicingCount", "", "bytesPerFileSlice", "", "(IJ)V", "getBytesPerFileSlice", "()J", "getSlicingCount", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FileSliceInfo.kt */
public final class FileSliceInfo {
    private final long bytesPerFileSlice;
    private final int slicingCount;

    public static /* synthetic */ FileSliceInfo copy$default(FileSliceInfo fileSliceInfo, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = fileSliceInfo.slicingCount;
        }
        if ((i2 & 2) != 0) {
            j = fileSliceInfo.bytesPerFileSlice;
        }
        return fileSliceInfo.copy(i, j);
    }

    public final int component1() {
        return this.slicingCount;
    }

    public final long component2() {
        return this.bytesPerFileSlice;
    }

    public final FileSliceInfo copy(int i, long j) {
        return new FileSliceInfo(i, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FileSliceInfo)) {
            return false;
        }
        FileSliceInfo fileSliceInfo = (FileSliceInfo) obj;
        return this.slicingCount == fileSliceInfo.slicingCount && this.bytesPerFileSlice == fileSliceInfo.bytesPerFileSlice;
    }

    public int hashCode() {
        long j = this.bytesPerFileSlice;
        return (this.slicingCount * 31) + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "FileSliceInfo(slicingCount=" + this.slicingCount + ", bytesPerFileSlice=" + this.bytesPerFileSlice + ")";
    }

    public FileSliceInfo(int i, long j) {
        this.slicingCount = i;
        this.bytesPerFileSlice = j;
    }

    public final long getBytesPerFileSlice() {
        return this.bytesPerFileSlice;
    }

    public final int getSlicingCount() {
        return this.slicingCount;
    }
}
