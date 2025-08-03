package com.tonyodev.fetch2.database;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.EnqueueAction;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.NetworkType;
import com.tonyodev.fetch2.Priority;
import com.tonyodev.fetch2.Request;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2.util.FetchDefaults;
import com.tonyodev.fetch2.util.FetchTypeConverterExtensions;
import com.tonyodev.fetch2core.Extras;
import com.tonyodev.fetch2core.FetchCoreUtils;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 |2\u00020\u0001:\u0001|B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010p\u001a\u00020\u0001H\u0016J\b\u0010q\u001a\u00020\u0004H\u0016J\u0013\u0010r\u001a\u00020\u00132\b\u0010s\u001a\u0004\u0018\u00010tH\u0002J\b\u0010u\u001a\u00020\u0004H\u0016J\b\u0010v\u001a\u000204H\u0016J\u0018\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020\u0004H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\r8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001e\u0010\u001b\u001a\u00020\r8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001e\u0010\u001e\u001a\u00020\u001f8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020%8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020\r8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011R\u001e\u0010-\u001a\u00020.8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u00103\u001a\u0002048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0014\u00109\u001a\u00020:8VX\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u001e\u0010=\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR*\u0010@\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002040A8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001e\u0010F\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0006\"\u0004\bH\u0010\bR\u001e\u0010I\u001a\u00020\r8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u000f\"\u0004\bK\u0010\u0011R\u001e\u0010L\u001a\u0002048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u00106\"\u0004\bN\u00108R\u001e\u0010O\u001a\u00020P8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001e\u0010U\u001a\u00020V8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0014\u0010[\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010\u0006R\u0014\u0010]\u001a\u00020^8VX\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R\u001e\u0010a\u001a\u00020b8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR \u0010g\u001a\u0004\u0018\u0001048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u00106\"\u0004\bi\u00108R\u001e\u0010j\u001a\u00020\r8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u000f\"\u0004\bl\u0010\u0011R\u001e\u0010m\u001a\u0002048\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u00106\"\u0004\bo\u00108¨\u0006}"}, d2 = {"Lcom/tonyodev/fetch2/database/DownloadInfo;", "Lcom/tonyodev/fetch2/Download;", "()V", "autoRetryAttempts", "", "getAutoRetryAttempts", "()I", "setAutoRetryAttempts", "(I)V", "autoRetryMaxAttempts", "getAutoRetryMaxAttempts", "setAutoRetryMaxAttempts", "created", "", "getCreated", "()J", "setCreated", "(J)V", "downloadOnEnqueue", "", "getDownloadOnEnqueue", "()Z", "setDownloadOnEnqueue", "(Z)V", "downloaded", "getDownloaded", "setDownloaded", "downloadedBytesPerSecond", "getDownloadedBytesPerSecond", "setDownloadedBytesPerSecond", "enqueueAction", "Lcom/tonyodev/fetch2/EnqueueAction;", "getEnqueueAction", "()Lcom/tonyodev/fetch2/EnqueueAction;", "setEnqueueAction", "(Lcom/tonyodev/fetch2/EnqueueAction;)V", "error", "Lcom/tonyodev/fetch2/Error;", "getError", "()Lcom/tonyodev/fetch2/Error;", "setError", "(Lcom/tonyodev/fetch2/Error;)V", "etaInMilliSeconds", "getEtaInMilliSeconds", "setEtaInMilliSeconds", "extras", "Lcom/tonyodev/fetch2core/Extras;", "getExtras", "()Lcom/tonyodev/fetch2core/Extras;", "setExtras", "(Lcom/tonyodev/fetch2core/Extras;)V", "file", "", "getFile", "()Ljava/lang/String;", "setFile", "(Ljava/lang/String;)V", "fileUri", "Landroid/net/Uri;", "getFileUri", "()Landroid/net/Uri;", "group", "getGroup", "setGroup", "headers", "", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "id", "getId", "setId", "identifier", "getIdentifier", "setIdentifier", "namespace", "getNamespace", "setNamespace", "networkType", "Lcom/tonyodev/fetch2/NetworkType;", "getNetworkType", "()Lcom/tonyodev/fetch2/NetworkType;", "setNetworkType", "(Lcom/tonyodev/fetch2/NetworkType;)V", "priority", "Lcom/tonyodev/fetch2/Priority;", "getPriority", "()Lcom/tonyodev/fetch2/Priority;", "setPriority", "(Lcom/tonyodev/fetch2/Priority;)V", "progress", "getProgress", "request", "Lcom/tonyodev/fetch2/Request;", "getRequest", "()Lcom/tonyodev/fetch2/Request;", "status", "Lcom/tonyodev/fetch2/Status;", "getStatus", "()Lcom/tonyodev/fetch2/Status;", "setStatus", "(Lcom/tonyodev/fetch2/Status;)V", "tag", "getTag", "setTag", "total", "getTotal", "setTotal", "url", "getUrl", "setUrl", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "CREATOR", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DownloadInfo.kt */
public class DownloadInfo implements Download {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private int autoRetryAttempts;
    private int autoRetryMaxAttempts;
    private long created;
    private boolean downloadOnEnqueue;
    private long downloaded;
    private long downloadedBytesPerSecond;
    private EnqueueAction enqueueAction;
    private Error error = FetchDefaults.getDefaultNoError();
    private long etaInMilliSeconds;
    private Extras extras;
    private String file = "";
    private int group;
    private Map<String, String> headers = new LinkedHashMap();
    private int id;
    private long identifier;
    private String namespace = "";
    private NetworkType networkType = FetchDefaults.getDefaultNetworkType();
    private Priority priority = FetchDefaults.getDefaultPriority();
    private Status status = FetchDefaults.getDefaultStatus();
    private String tag;
    private long total = -1;
    private String url = "";

    public int describeContents() {
        return 0;
    }

    public DownloadInfo() {
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "Calendar.getInstance()");
        this.created = instance.getTimeInMillis();
        this.enqueueAction = EnqueueAction.REPLACE_EXISTING;
        this.downloadOnEnqueue = true;
        this.extras = Extras.CREATOR.getEmptyExtras();
        this.etaInMilliSeconds = -1;
        this.downloadedBytesPerSecond = -1;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public void setNamespace(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.namespace = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.url = str;
    }

    public String getFile() {
        return this.file;
    }

    public void setFile(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.file = str;
    }

    public int getGroup() {
        return this.group;
    }

    public void setGroup(int i) {
        this.group = i;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public void setPriority(Priority priority2) {
        Intrinsics.checkParameterIsNotNull(priority2, "<set-?>");
        this.priority = priority2;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public void setHeaders(Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(map, "<set-?>");
        this.headers = map;
    }

    public long getDownloaded() {
        return this.downloaded;
    }

    public void setDownloaded(long j) {
        this.downloaded = j;
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long j) {
        this.total = j;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status2) {
        Intrinsics.checkParameterIsNotNull(status2, "<set-?>");
        this.status = status2;
    }

    public Error getError() {
        return this.error;
    }

    public void setError(Error error2) {
        Intrinsics.checkParameterIsNotNull(error2, "<set-?>");
        this.error = error2;
    }

    public NetworkType getNetworkType() {
        return this.networkType;
    }

    public void setNetworkType(NetworkType networkType2) {
        Intrinsics.checkParameterIsNotNull(networkType2, "<set-?>");
        this.networkType = networkType2;
    }

    public long getCreated() {
        return this.created;
    }

    public void setCreated(long j) {
        this.created = j;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public EnqueueAction getEnqueueAction() {
        return this.enqueueAction;
    }

    public void setEnqueueAction(EnqueueAction enqueueAction2) {
        Intrinsics.checkParameterIsNotNull(enqueueAction2, "<set-?>");
        this.enqueueAction = enqueueAction2;
    }

    public long getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(long j) {
        this.identifier = j;
    }

    public boolean getDownloadOnEnqueue() {
        return this.downloadOnEnqueue;
    }

    public void setDownloadOnEnqueue(boolean z) {
        this.downloadOnEnqueue = z;
    }

    public Extras getExtras() {
        return this.extras;
    }

    public void setExtras(Extras extras2) {
        Intrinsics.checkParameterIsNotNull(extras2, "<set-?>");
        this.extras = extras2;
    }

    public int getAutoRetryMaxAttempts() {
        return this.autoRetryMaxAttempts;
    }

    public void setAutoRetryMaxAttempts(int i) {
        this.autoRetryMaxAttempts = i;
    }

    public int getAutoRetryAttempts() {
        return this.autoRetryAttempts;
    }

    public void setAutoRetryAttempts(int i) {
        this.autoRetryAttempts = i;
    }

    public long getEtaInMilliSeconds() {
        return this.etaInMilliSeconds;
    }

    public void setEtaInMilliSeconds(long j) {
        this.etaInMilliSeconds = j;
    }

    public long getDownloadedBytesPerSecond() {
        return this.downloadedBytesPerSecond;
    }

    public void setDownloadedBytesPerSecond(long j) {
        this.downloadedBytesPerSecond = j;
    }

    public int getProgress() {
        return FetchCoreUtils.calculateProgress(getDownloaded(), getTotal());
    }

    public Uri getFileUri() {
        return FetchCoreUtils.getFileUri(getFile());
    }

    public Request getRequest() {
        Request request = new Request(getUrl(), getFile());
        request.setGroupId(getGroup());
        request.getHeaders().putAll(getHeaders());
        request.setNetworkType(getNetworkType());
        request.setPriority(getPriority());
        request.setEnqueueAction(getEnqueueAction());
        request.setIdentifier(getIdentifier());
        request.setDownloadOnEnqueue(getDownloadOnEnqueue());
        request.setExtras(getExtras());
        request.setAutoRetryMaxAttempts(getAutoRetryMaxAttempts());
        return request;
    }

    public Download copy() {
        return FetchTypeConverterExtensions.toDownloadInfo((Download) this, new DownloadInfo());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            DownloadInfo downloadInfo = (DownloadInfo) obj;
            if (getId() == downloadInfo.getId() && !(!Intrinsics.areEqual((Object) getNamespace(), (Object) downloadInfo.getNamespace())) && !(!Intrinsics.areEqual((Object) getUrl(), (Object) downloadInfo.getUrl())) && !(!Intrinsics.areEqual((Object) getFile(), (Object) downloadInfo.getFile())) && getGroup() == downloadInfo.getGroup() && getPriority() == downloadInfo.getPriority() && !(!Intrinsics.areEqual((Object) getHeaders(), (Object) downloadInfo.getHeaders())) && getDownloaded() == downloadInfo.getDownloaded() && getTotal() == downloadInfo.getTotal() && getStatus() == downloadInfo.getStatus() && getError() == downloadInfo.getError() && getNetworkType() == downloadInfo.getNetworkType() && getCreated() == downloadInfo.getCreated() && !(!Intrinsics.areEqual((Object) getTag(), (Object) downloadInfo.getTag())) && getEnqueueAction() == downloadInfo.getEnqueueAction() && getIdentifier() == downloadInfo.getIdentifier() && getDownloadOnEnqueue() == downloadInfo.getDownloadOnEnqueue() && !(!Intrinsics.areEqual((Object) getExtras(), (Object) downloadInfo.getExtras())) && getEtaInMilliSeconds() == downloadInfo.getEtaInMilliSeconds() && getDownloadedBytesPerSecond() == downloadInfo.getDownloadedBytesPerSecond() && getAutoRetryMaxAttempts() == downloadInfo.getAutoRetryMaxAttempts() && getAutoRetryAttempts() == downloadInfo.getAutoRetryAttempts()) {
                return true;
            }
            return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tonyodev.fetch2.database.DownloadInfo");
    }

    public int hashCode() {
        int id2 = ((((((((((((((((((((((((getId() * 31) + getNamespace().hashCode()) * 31) + getUrl().hashCode()) * 31) + getFile().hashCode()) * 31) + getGroup()) * 31) + getPriority().hashCode()) * 31) + getHeaders().hashCode()) * 31) + Long.valueOf(getDownloaded()).hashCode()) * 31) + Long.valueOf(getTotal()).hashCode()) * 31) + getStatus().hashCode()) * 31) + getError().hashCode()) * 31) + getNetworkType().hashCode()) * 31) + Long.valueOf(getCreated()).hashCode()) * 31;
        String tag2 = getTag();
        return ((((((((((((((((id2 + (tag2 != null ? tag2.hashCode() : 0)) * 31) + getEnqueueAction().hashCode()) * 31) + Long.valueOf(getIdentifier()).hashCode()) * 31) + Boolean.valueOf(getDownloadOnEnqueue()).hashCode()) * 31) + getExtras().hashCode()) * 31) + Long.valueOf(getEtaInMilliSeconds()).hashCode()) * 31) + Long.valueOf(getDownloadedBytesPerSecond()).hashCode()) * 31) + Integer.valueOf(getAutoRetryMaxAttempts()).hashCode()) * 31) + Integer.valueOf(getAutoRetryAttempts()).hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "dest");
        parcel.writeInt(getId());
        parcel.writeString(getNamespace());
        parcel.writeString(getUrl());
        parcel.writeString(getFile());
        parcel.writeInt(getGroup());
        parcel.writeInt(getPriority().getValue());
        parcel.writeSerializable(new HashMap(getHeaders()));
        parcel.writeLong(getDownloaded());
        parcel.writeLong(getTotal());
        parcel.writeInt(getStatus().getValue());
        parcel.writeInt(getError().getValue());
        parcel.writeInt(getNetworkType().getValue());
        parcel.writeLong(getCreated());
        parcel.writeString(getTag());
        parcel.writeInt(getEnqueueAction().getValue());
        parcel.writeLong(getIdentifier());
        parcel.writeInt(getDownloadOnEnqueue() ? 1 : 0);
        parcel.writeLong(getEtaInMilliSeconds());
        parcel.writeLong(getDownloadedBytesPerSecond());
        parcel.writeSerializable(new HashMap(getExtras().getMap()));
        parcel.writeInt(getAutoRetryMaxAttempts());
        parcel.writeInt(getAutoRetryAttempts());
    }

    public String toString() {
        return "DownloadInfo(id=" + getId() + ", namespace='" + getNamespace() + "', url='" + getUrl() + "', file='" + getFile() + "', " + "group=" + getGroup() + ", priority=" + getPriority() + ", headers=" + getHeaders() + ", downloaded=" + getDownloaded() + ',' + " total=" + getTotal() + ", status=" + getStatus() + ", error=" + getError() + ", networkType=" + getNetworkType() + ", " + "created=" + getCreated() + ", tag=" + getTag() + ", enqueueAction=" + getEnqueueAction() + ", identifier=" + getIdentifier() + ',' + " downloadOnEnqueue=" + getDownloadOnEnqueue() + ", extras=" + getExtras() + ", " + "autoRetryMaxAttempts=" + getAutoRetryMaxAttempts() + ", autoRetryAttempts=" + getAutoRetryAttempts() + ',' + " etaInMilliSeconds=" + getEtaInMilliSeconds() + ", downloadedBytesPerSecond=" + getDownloadedBytesPerSecond() + ')';
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/tonyodev/fetch2/database/DownloadInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tonyodev/fetch2/database/DownloadInfo;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tonyodev/fetch2/database/DownloadInfo;", "fetch2_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: DownloadInfo.kt */
    public static final class CREATOR implements Parcelable.Creator<DownloadInfo> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public DownloadInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, FirebaseAnalytics.Param.SOURCE);
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String str = "";
            if (readString == null) {
                readString = str;
            }
            Intrinsics.checkExpressionValueIsNotNull(readString, "source.readString() ?: \"\"");
            String readString2 = parcel.readString();
            if (readString2 == null) {
                readString2 = str;
            }
            Intrinsics.checkExpressionValueIsNotNull(readString2, "source.readString() ?: \"\"");
            String readString3 = parcel.readString();
            if (readString3 != null) {
                str = readString3;
            }
            Intrinsics.checkExpressionValueIsNotNull(str, "source.readString() ?: \"\"");
            int readInt2 = parcel.readInt();
            Priority valueOf = Priority.Companion.valueOf(parcel.readInt());
            Serializable readSerializable = parcel.readSerializable();
            if (readSerializable != null) {
                Map map = (Map) readSerializable;
                long readLong = parcel.readLong();
                long readLong2 = parcel.readLong();
                Status valueOf2 = Status.Companion.valueOf(parcel.readInt());
                Error valueOf3 = Error.Companion.valueOf(parcel.readInt());
                NetworkType valueOf4 = NetworkType.Companion.valueOf(parcel.readInt());
                Error error = valueOf3;
                long readLong3 = parcel.readLong();
                String str2 = "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>";
                String readString4 = parcel.readString();
                long j = readLong3;
                EnqueueAction valueOf5 = EnqueueAction.Companion.valueOf(parcel.readInt());
                long readLong4 = parcel.readLong();
                boolean z = true;
                if (parcel.readInt() != 1) {
                    z = false;
                }
                boolean z2 = z;
                long readLong5 = parcel.readLong();
                long readLong6 = parcel.readLong();
                Serializable readSerializable2 = parcel.readSerializable();
                if (readSerializable2 != null) {
                    int readInt3 = parcel.readInt();
                    int readInt4 = parcel.readInt();
                    DownloadInfo downloadInfo = new DownloadInfo();
                    downloadInfo.setId(readInt);
                    downloadInfo.setNamespace(readString);
                    downloadInfo.setUrl(readString2);
                    downloadInfo.setFile(str);
                    downloadInfo.setGroup(readInt2);
                    downloadInfo.setPriority(valueOf);
                    downloadInfo.setHeaders(map);
                    downloadInfo.setDownloaded(readLong);
                    downloadInfo.setTotal(readLong2);
                    downloadInfo.setStatus(valueOf2);
                    downloadInfo.setError(error);
                    downloadInfo.setNetworkType(valueOf4);
                    downloadInfo.setCreated(j);
                    downloadInfo.setTag(readString4);
                    downloadInfo.setEnqueueAction(valueOf5);
                    downloadInfo.setIdentifier(readLong4);
                    downloadInfo.setDownloadOnEnqueue(z2);
                    downloadInfo.setEtaInMilliSeconds(readLong5);
                    downloadInfo.setDownloadedBytesPerSecond(readLong6);
                    downloadInfo.setExtras(new Extras((Map) readSerializable2));
                    downloadInfo.setAutoRetryMaxAttempts(readInt3);
                    downloadInfo.setAutoRetryAttempts(readInt4);
                    return downloadInfo;
                }
                throw new TypeCastException(str2);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        }

        public DownloadInfo[] newArray(int i) {
            return new DownloadInfo[i];
        }
    }
}
