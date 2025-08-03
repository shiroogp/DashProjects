package com.tonyodev.fetch2core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001a\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000b¨\u0006!"}, d2 = {"Lcom/tonyodev/fetch2core/FileSlice;", "", "id", "", "position", "startBytes", "", "endBytes", "downloaded", "(IIJJJ)V", "getDownloaded", "()J", "setDownloaded", "(J)V", "getEndBytes", "getId", "()I", "isDownloaded", "", "()Z", "getPosition", "getStartBytes", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FileSlice.kt */
public final class FileSlice {
    private long downloaded;
    private final long endBytes;
    private final int id;
    private final int position;
    private final long startBytes;

    public FileSlice() {
        this(0, 0, 0, 0, 0, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FileSlice copy$default(FileSlice fileSlice, int i, int i2, long j, long j2, long j3, int i3, Object obj) {
        FileSlice fileSlice2 = fileSlice;
        return fileSlice.copy((i3 & 1) != 0 ? fileSlice2.id : i, (i3 & 2) != 0 ? fileSlice2.position : i2, (i3 & 4) != 0 ? fileSlice2.startBytes : j, (i3 & 8) != 0 ? fileSlice2.endBytes : j2, (i3 & 16) != 0 ? fileSlice2.downloaded : j3);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.position;
    }

    public final long component3() {
        return this.startBytes;
    }

    public final long component4() {
        return this.endBytes;
    }

    public final long component5() {
        return this.downloaded;
    }

    public final FileSlice copy(int i, int i2, long j, long j2, long j3) {
        return new FileSlice(i, i2, j, j2, j3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FileSlice)) {
            return false;
        }
        FileSlice fileSlice = (FileSlice) obj;
        return this.id == fileSlice.id && this.position == fileSlice.position && this.startBytes == fileSlice.startBytes && this.endBytes == fileSlice.endBytes && this.downloaded == fileSlice.downloaded;
    }

    public int hashCode() {
        long j = this.startBytes;
        long j2 = this.endBytes;
        long j3 = this.downloaded;
        return (((((((this.id * 31) + this.position) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        return "FileSlice(id=" + this.id + ", position=" + this.position + ", startBytes=" + this.startBytes + ", endBytes=" + this.endBytes + ", downloaded=" + this.downloaded + ")";
    }

    public FileSlice(int i, int i2, long j, long j2, long j3) {
        this.id = i;
        this.position = i2;
        this.startBytes = j;
        this.endBytes = j2;
        this.downloaded = j3;
    }

    public final int getId() {
        return this.id;
    }

    public final int getPosition() {
        return this.position;
    }

    public final long getStartBytes() {
        return this.startBytes;
    }

    public final long getEndBytes() {
        return this.endBytes;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FileSlice(int r10, int r11, long r12, long r14, long r16, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18 & 1
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = r1
            goto L_0x0008
        L_0x0007:
            r0 = r10
        L_0x0008:
            r2 = r18 & 2
            if (r2 == 0) goto L_0x000d
            goto L_0x000e
        L_0x000d:
            r1 = r11
        L_0x000e:
            r2 = r18 & 4
            r3 = 0
            if (r2 == 0) goto L_0x0016
            r5 = r3
            goto L_0x0017
        L_0x0016:
            r5 = r12
        L_0x0017:
            r2 = r18 & 8
            if (r2 == 0) goto L_0x001d
            r7 = r3
            goto L_0x001e
        L_0x001d:
            r7 = r14
        L_0x001e:
            r2 = r18 & 16
            if (r2 == 0) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            r3 = r16
        L_0x0025:
            r10 = r9
            r11 = r0
            r12 = r1
            r13 = r5
            r15 = r7
            r17 = r3
            r10.<init>(r11, r12, r13, r15, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2core.FileSlice.<init>(int, int, long, long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final long getDownloaded() {
        return this.downloaded;
    }

    public final void setDownloaded(long j) {
        this.downloaded = j;
    }

    public final boolean isDownloaded() {
        return this.startBytes + this.downloaded == this.endBytes;
    }
}
