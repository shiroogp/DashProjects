package com.tonyodev.fetch2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tonyodev.fetch2.util.FetchDefaults;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0002IJB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010>\u001a\u00020\u0011H\u0016J\u0013\u0010?\u001a\u00020\u00172\b\u0010@\u001a\u0004\u0018\u00010AH\u0002J\b\u0010B\u001a\u00020\u0011H\u0016J\b\u0010C\u001a\u00020%H\u0016J\u0018\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0011H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u001a\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u001c\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u001d\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\u001e\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\u001f\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0018R\u0011\u0010 \u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b \u0010\u0018R\u0011\u0010!\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b!\u0010\u0018R\u0011\u0010\"\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0018R\u0011\u0010#\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b#\u0010\u0018R\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0013\"\u0004\b,\u0010\u0015R\u001a\u0010-\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0013\"\u0004\b/\u0010\u0015R\u0011\u00100\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b1\u0010\u0018R\u001a\u00102\u001a\u000203X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010'\"\u0004\b:\u0010)R\u001a\u0010;\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0007\"\u0004\b=\u0010\t¨\u0006K"}, d2 = {"Lcom/tonyodev/fetch2/DownloadNotification;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", "downloaded", "", "getDownloaded", "()J", "setDownloaded", "(J)V", "downloadedBytesPerSecond", "getDownloadedBytesPerSecond", "setDownloadedBytesPerSecond", "etaInMilliSeconds", "getEtaInMilliSeconds", "setEtaInMilliSeconds", "groupId", "", "getGroupId", "()I", "setGroupId", "(I)V", "isActive", "", "()Z", "isCancelled", "isCancelledNotification", "isCompleted", "isDeleted", "isDownloading", "isFailed", "isOnGoingNotification", "isPaused", "isQueued", "isRemovableNotification", "isRemoved", "namespace", "", "getNamespace", "()Ljava/lang/String;", "setNamespace", "(Ljava/lang/String;)V", "notificationId", "getNotificationId", "setNotificationId", "progress", "getProgress", "setProgress", "progressIndeterminate", "getProgressIndeterminate", "status", "Lcom/tonyodev/fetch2/Status;", "getStatus", "()Lcom/tonyodev/fetch2/Status;", "setStatus", "(Lcom/tonyodev/fetch2/Status;)V", "title", "getTitle", "setTitle", "total", "getTotal", "setTotal", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "ActionType", "CREATOR", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DownloadNotification.kt */
public class DownloadNotification implements Parcelable, Serializable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private long downloaded = -1;
    private long downloadedBytesPerSecond = -1;
    private long etaInMilliSeconds = -1;
    private int groupId = -1;
    private String namespace = FetchDefaults.DEFAULT_INSTANCE_NAMESPACE;
    private int notificationId = -1;
    private int progress = -1;
    private Status status = Status.NONE;
    private String title = "";
    private long total = -1;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/tonyodev/fetch2/DownloadNotification$ActionType;", "", "(Ljava/lang/String;I)V", "PAUSE", "RESUME", "CANCEL", "DELETE", "RETRY", "PAUSE_ALL", "RESUME_ALL", "CANCEL_ALL", "DELETE_ALL", "RETRY_ALL", "fetch2_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: DownloadNotification.kt */
    public enum ActionType {
        PAUSE,
        RESUME,
        CANCEL,
        DELETE,
        RETRY,
        PAUSE_ALL,
        RESUME_ALL,
        CANCEL_ALL,
        DELETE_ALL,
        RETRY_ALL
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[Status.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Status.QUEUED.ordinal()] = 1;
            iArr[Status.DOWNLOADING.ordinal()] = 2;
            int[] iArr2 = new int[Status.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[Status.DELETED.ordinal()] = 1;
            iArr2[Status.REMOVED.ordinal()] = 2;
            iArr2[Status.CANCELLED.ordinal()] = 3;
            int[] iArr3 = new int[Status.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[Status.COMPLETED.ordinal()] = 1;
            iArr3[Status.FAILED.ordinal()] = 2;
            iArr3[Status.CANCELLED.ordinal()] = 3;
            iArr3[Status.REMOVED.ordinal()] = 4;
            iArr3[Status.DELETED.ordinal()] = 5;
        }
    }

    public int describeContents() {
        return 0;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final void setStatus(Status status2) {
        Intrinsics.checkParameterIsNotNull(status2, "<set-?>");
        this.status = status2;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final void setProgress(int i) {
        this.progress = i;
    }

    public final int getNotificationId() {
        return this.notificationId;
    }

    public final void setNotificationId(int i) {
        this.notificationId = i;
    }

    public final int getGroupId() {
        return this.groupId;
    }

    public final void setGroupId(int i) {
        this.groupId = i;
    }

    public final long getEtaInMilliSeconds() {
        return this.etaInMilliSeconds;
    }

    public final void setEtaInMilliSeconds(long j) {
        this.etaInMilliSeconds = j;
    }

    public final long getDownloadedBytesPerSecond() {
        return this.downloadedBytesPerSecond;
    }

    public final void setDownloadedBytesPerSecond(long j) {
        this.downloadedBytesPerSecond = j;
    }

    public final long getTotal() {
        return this.total;
    }

    public final void setTotal(long j) {
        this.total = j;
    }

    public final long getDownloaded() {
        return this.downloaded;
    }

    public final void setDownloaded(long j) {
        this.downloaded = j;
    }

    public final String getNamespace() {
        return this.namespace;
    }

    public final void setNamespace(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.namespace = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.title = str;
    }

    public final boolean isActive() {
        return this.status == Status.QUEUED || this.status == Status.DOWNLOADING;
    }

    public final boolean isPaused() {
        return this.status == Status.PAUSED;
    }

    public final boolean isFailed() {
        return this.status == Status.FAILED;
    }

    public final boolean isCompleted() {
        return this.status == Status.COMPLETED;
    }

    public final boolean isDownloading() {
        return this.status == Status.DOWNLOADING;
    }

    public final boolean isCancelled() {
        return this.status == Status.CANCELLED;
    }

    public final boolean isDeleted() {
        return this.status == Status.DELETED;
    }

    public final boolean isRemoved() {
        return this.status == Status.REMOVED;
    }

    public final boolean isQueued() {
        return this.status == Status.QUEUED;
    }

    public final boolean isOnGoingNotification() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.status.ordinal()];
        return i == 1 || i == 2;
    }

    public final boolean isCancelledNotification() {
        int i = WhenMappings.$EnumSwitchMapping$1[this.status.ordinal()];
        return i == 1 || i == 2 || i == 3;
    }

    public final boolean isRemovableNotification() {
        int i = WhenMappings.$EnumSwitchMapping$2[this.status.ordinal()];
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5;
    }

    public final boolean getProgressIndeterminate() {
        return this.total == -1;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "dest");
        parcel.writeInt(this.status.getValue());
        parcel.writeInt(this.progress);
        parcel.writeInt(this.notificationId);
        parcel.writeInt(this.groupId);
        parcel.writeLong(this.etaInMilliSeconds);
        parcel.writeLong(this.downloadedBytesPerSecond);
        parcel.writeLong(this.total);
        parcel.writeLong(this.downloaded);
        parcel.writeString(this.namespace);
        parcel.writeString(this.title);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            DownloadNotification downloadNotification = (DownloadNotification) obj;
            if (this.status == downloadNotification.status && this.progress == downloadNotification.progress && this.notificationId == downloadNotification.notificationId && this.groupId == downloadNotification.groupId && this.etaInMilliSeconds == downloadNotification.etaInMilliSeconds && this.downloadedBytesPerSecond == downloadNotification.downloadedBytesPerSecond && this.total == downloadNotification.total && this.downloaded == downloadNotification.downloaded && !(!Intrinsics.areEqual((Object) this.namespace, (Object) downloadNotification.namespace)) && !(!Intrinsics.areEqual((Object) this.title, (Object) downloadNotification.title))) {
                return true;
            }
            return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tonyodev.fetch2.DownloadNotification");
    }

    public int hashCode() {
        return (((((((((((((((((this.status.hashCode() * 31) + this.progress) * 31) + this.notificationId) * 31) + this.groupId) * 31) + Long.valueOf(this.etaInMilliSeconds).hashCode()) * 31) + Long.valueOf(this.downloadedBytesPerSecond).hashCode()) * 31) + Long.valueOf(this.total).hashCode()) * 31) + Long.valueOf(this.downloaded).hashCode()) * 31) + this.namespace.hashCode()) * 31) + this.title.hashCode();
    }

    public String toString() {
        return "DownloadNotification(status=" + this.status + ", progress=" + this.progress + ", notificationId=" + this.notificationId + ',' + " groupId=" + this.groupId + ", etaInMilliSeconds=" + this.etaInMilliSeconds + ", downloadedBytesPerSecond=" + this.downloadedBytesPerSecond + ", " + "total=" + this.total + ", downloaded=" + this.downloaded + ", namespace='" + this.namespace + "', title='" + this.title + "')";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/tonyodev/fetch2/DownloadNotification$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tonyodev/fetch2/DownloadNotification;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tonyodev/fetch2/DownloadNotification;", "fetch2_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: DownloadNotification.kt */
    public static final class CREATOR implements Parcelable.Creator<DownloadNotification> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public DownloadNotification createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, FirebaseAnalytics.Param.SOURCE);
            Status valueOf = Status.Companion.valueOf(parcel.readInt());
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            long readLong3 = parcel.readLong();
            long readLong4 = parcel.readLong();
            String readString = parcel.readString();
            String str = "";
            if (readString == null) {
                readString = str;
            }
            Intrinsics.checkExpressionValueIsNotNull(readString, "source.readString() ?: \"\"");
            String readString2 = parcel.readString();
            if (readString2 != null) {
                str = readString2;
            }
            Intrinsics.checkExpressionValueIsNotNull(str, "source.readString() ?: \"\"");
            DownloadNotification downloadNotification = new DownloadNotification();
            downloadNotification.setStatus(valueOf);
            downloadNotification.setProgress(readInt);
            downloadNotification.setNotificationId(readInt2);
            downloadNotification.setGroupId(readInt3);
            downloadNotification.setEtaInMilliSeconds(readLong);
            downloadNotification.setDownloadedBytesPerSecond(readLong2);
            downloadNotification.setTotal(readLong3);
            downloadNotification.setDownloaded(readLong4);
            downloadNotification.setNamespace(readString);
            downloadNotification.setTitle(str);
            return downloadNotification;
        }

        public DownloadNotification[] newArray(int i) {
            return new DownloadNotification[i];
        }
    }
}
