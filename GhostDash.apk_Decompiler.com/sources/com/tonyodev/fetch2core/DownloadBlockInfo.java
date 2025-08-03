package com.tonyodev.fetch2core;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u0001H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010 \u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011¨\u0006)"}, d2 = {"Lcom/tonyodev/fetch2core/DownloadBlockInfo;", "Lcom/tonyodev/fetch2core/DownloadBlock;", "()V", "blockPosition", "", "getBlockPosition", "()I", "setBlockPosition", "(I)V", "downloadId", "getDownloadId", "setDownloadId", "downloadedBytes", "", "getDownloadedBytes", "()J", "setDownloadedBytes", "(J)V", "endByte", "getEndByte", "setEndByte", "progress", "getProgress", "startByte", "getStartByte", "setStartByte", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "CREATOR", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DownloadBlockInfo.kt */
public final class DownloadBlockInfo implements DownloadBlock {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private int blockPosition = -1;
    private int downloadId = -1;
    private long downloadedBytes = -1;
    private long endByte = -1;
    private long startByte = -1;

    public int describeContents() {
        return 0;
    }

    public int getDownloadId() {
        return this.downloadId;
    }

    public void setDownloadId(int i) {
        this.downloadId = i;
    }

    public int getBlockPosition() {
        return this.blockPosition;
    }

    public void setBlockPosition(int i) {
        this.blockPosition = i;
    }

    public long getStartByte() {
        return this.startByte;
    }

    public void setStartByte(long j) {
        this.startByte = j;
    }

    public long getEndByte() {
        return this.endByte;
    }

    public void setEndByte(long j) {
        this.endByte = j;
    }

    public long getDownloadedBytes() {
        return this.downloadedBytes;
    }

    public void setDownloadedBytes(long j) {
        this.downloadedBytes = j;
    }

    public int getProgress() {
        return FetchCoreUtils.calculateProgress(getDownloadedBytes(), getEndByte() - getStartByte());
    }

    public DownloadBlock copy() {
        DownloadBlockInfo downloadBlockInfo = new DownloadBlockInfo();
        downloadBlockInfo.setDownloadId(getDownloadId());
        downloadBlockInfo.setBlockPosition(getBlockPosition());
        downloadBlockInfo.setStartByte(getStartByte());
        downloadBlockInfo.setEndByte(getEndByte());
        downloadBlockInfo.setDownloadedBytes(getDownloadedBytes());
        return downloadBlockInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            DownloadBlockInfo downloadBlockInfo = (DownloadBlockInfo) obj;
            if (getDownloadId() == downloadBlockInfo.getDownloadId() && getBlockPosition() == downloadBlockInfo.getBlockPosition() && getStartByte() == downloadBlockInfo.getStartByte() && getEndByte() == downloadBlockInfo.getEndByte() && getDownloadedBytes() == downloadBlockInfo.getDownloadedBytes()) {
                return true;
            }
            return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tonyodev.fetch2core.DownloadBlockInfo");
    }

    public int hashCode() {
        return (((((((getDownloadId() * 31) + getBlockPosition()) * 31) + Long.valueOf(getStartByte()).hashCode()) * 31) + Long.valueOf(getEndByte()).hashCode()) * 31) + Long.valueOf(getDownloadedBytes()).hashCode();
    }

    public String toString() {
        return "DownloadBlock(downloadId=" + getDownloadId() + ", blockPosition=" + getBlockPosition() + ", " + "startByte=" + getStartByte() + ", endByte=" + getEndByte() + ", downloadedBytes=" + getDownloadedBytes() + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "dest");
        parcel.writeInt(getDownloadId());
        parcel.writeInt(getBlockPosition());
        parcel.writeLong(getStartByte());
        parcel.writeLong(getEndByte());
        parcel.writeLong(getDownloadedBytes());
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/tonyodev/fetch2core/DownloadBlockInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tonyodev/fetch2core/DownloadBlockInfo;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tonyodev/fetch2core/DownloadBlockInfo;", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: DownloadBlockInfo.kt */
    public static final class CREATOR implements Parcelable.Creator<DownloadBlockInfo> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public DownloadBlockInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, FirebaseAnalytics.Param.SOURCE);
            DownloadBlockInfo downloadBlockInfo = new DownloadBlockInfo();
            downloadBlockInfo.setDownloadId(parcel.readInt());
            downloadBlockInfo.setBlockPosition(parcel.readInt());
            downloadBlockInfo.setStartByte(parcel.readLong());
            downloadBlockInfo.setEndByte(parcel.readLong());
            downloadBlockInfo.setDownloadedBytes(parcel.readLong());
            return downloadBlockInfo;
        }

        public DownloadBlockInfo[] newArray(int i) {
            return new DownloadBlockInfo[i];
        }
    }
}
