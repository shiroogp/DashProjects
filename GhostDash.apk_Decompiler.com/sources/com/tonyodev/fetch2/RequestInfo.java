package com.tonyodev.fetch2;

import com.tonyodev.fetch2.util.FetchDefaults;
import com.tonyodev.fetch2core.Extras;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020!J\u0013\u0010>\u001a\u00020\u000b2\b\u0010?\u001a\u0004\u0018\u00010@H\u0002J\b\u0010A\u001a\u00020\u0004H\u0016J\b\u0010B\u001a\u00020!H\u0016R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0016@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001d\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0 ¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006C"}, d2 = {"Lcom/tonyodev/fetch2/RequestInfo;", "Ljava/io/Serializable;", "()V", "value", "", "autoRetryMaxAttempts", "getAutoRetryMaxAttempts", "()I", "setAutoRetryMaxAttempts", "(I)V", "downloadOnEnqueue", "", "getDownloadOnEnqueue", "()Z", "setDownloadOnEnqueue", "(Z)V", "enqueueAction", "Lcom/tonyodev/fetch2/EnqueueAction;", "getEnqueueAction", "()Lcom/tonyodev/fetch2/EnqueueAction;", "setEnqueueAction", "(Lcom/tonyodev/fetch2/EnqueueAction;)V", "Lcom/tonyodev/fetch2core/Extras;", "extras", "getExtras", "()Lcom/tonyodev/fetch2core/Extras;", "setExtras", "(Lcom/tonyodev/fetch2core/Extras;)V", "groupId", "getGroupId", "setGroupId", "headers", "", "", "getHeaders", "()Ljava/util/Map;", "identifier", "", "getIdentifier", "()J", "setIdentifier", "(J)V", "networkType", "Lcom/tonyodev/fetch2/NetworkType;", "getNetworkType", "()Lcom/tonyodev/fetch2/NetworkType;", "setNetworkType", "(Lcom/tonyodev/fetch2/NetworkType;)V", "priority", "Lcom/tonyodev/fetch2/Priority;", "getPriority", "()Lcom/tonyodev/fetch2/Priority;", "setPriority", "(Lcom/tonyodev/fetch2/Priority;)V", "tag", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "addHeader", "", "key", "equals", "other", "", "hashCode", "toString", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: RequestInfo.kt */
public class RequestInfo implements Serializable {
    private int autoRetryMaxAttempts;
    private boolean downloadOnEnqueue = true;
    private EnqueueAction enqueueAction = FetchDefaults.getDefaultEnqueueAction();
    private Extras extras = Extras.CREATOR.getEmptyExtras();
    private int groupId;
    private final Map<String, String> headers = new LinkedHashMap();
    private long identifier;
    private NetworkType networkType = FetchDefaults.getDefaultNetworkType();
    private Priority priority = FetchDefaults.getDefaultPriority();
    private String tag;

    public final long getIdentifier() {
        return this.identifier;
    }

    public final void setIdentifier(long j) {
        this.identifier = j;
    }

    public final int getGroupId() {
        return this.groupId;
    }

    public final void setGroupId(int i) {
        this.groupId = i;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final Priority getPriority() {
        return this.priority;
    }

    public final void setPriority(Priority priority2) {
        Intrinsics.checkParameterIsNotNull(priority2, "<set-?>");
        this.priority = priority2;
    }

    public final NetworkType getNetworkType() {
        return this.networkType;
    }

    public final void setNetworkType(NetworkType networkType2) {
        Intrinsics.checkParameterIsNotNull(networkType2, "<set-?>");
        this.networkType = networkType2;
    }

    public final void addHeader(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(str2, "value");
        this.headers.put(str, str2);
    }

    public final String getTag() {
        return this.tag;
    }

    public final void setTag(String str) {
        this.tag = str;
    }

    public final EnqueueAction getEnqueueAction() {
        return this.enqueueAction;
    }

    public final void setEnqueueAction(EnqueueAction enqueueAction2) {
        Intrinsics.checkParameterIsNotNull(enqueueAction2, "<set-?>");
        this.enqueueAction = enqueueAction2;
    }

    public final boolean getDownloadOnEnqueue() {
        return this.downloadOnEnqueue;
    }

    public final void setDownloadOnEnqueue(boolean z) {
        this.downloadOnEnqueue = z;
    }

    public final int getAutoRetryMaxAttempts() {
        return this.autoRetryMaxAttempts;
    }

    public final void setAutoRetryMaxAttempts(int i) {
        if (i >= 0) {
            this.autoRetryMaxAttempts = i;
            return;
        }
        throw new IllegalArgumentException("The maximum number of attempts has to be greater than -1");
    }

    public final Extras getExtras() {
        return this.extras;
    }

    public final void setExtras(Extras extras2) {
        Intrinsics.checkParameterIsNotNull(extras2, "value");
        this.extras = extras2.copy();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            RequestInfo requestInfo = (RequestInfo) obj;
            if (this.identifier == requestInfo.identifier && this.groupId == requestInfo.groupId && !(!Intrinsics.areEqual((Object) this.headers, (Object) requestInfo.headers)) && this.priority == requestInfo.priority && this.networkType == requestInfo.networkType && !(!Intrinsics.areEqual((Object) this.tag, (Object) requestInfo.tag)) && this.enqueueAction == requestInfo.enqueueAction && this.downloadOnEnqueue == requestInfo.downloadOnEnqueue && !(!Intrinsics.areEqual((Object) this.extras, (Object) requestInfo.extras)) && this.autoRetryMaxAttempts == requestInfo.autoRetryMaxAttempts) {
                return true;
            }
            return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tonyodev.fetch2.RequestInfo");
    }

    public int hashCode() {
        int hashCode = ((((((((Long.valueOf(this.identifier).hashCode() * 31) + this.groupId) * 31) + this.headers.hashCode()) * 31) + this.priority.hashCode()) * 31) + this.networkType.hashCode()) * 31;
        String str = this.tag;
        return ((((((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.enqueueAction.hashCode()) * 31) + Boolean.valueOf(this.downloadOnEnqueue).hashCode()) * 31) + this.extras.hashCode()) * 31) + this.autoRetryMaxAttempts;
    }

    public String toString() {
        return "RequestInfo(identifier=" + this.identifier + ", groupId=" + this.groupId + ',' + " headers=" + this.headers + ", priority=" + this.priority + ", networkType=" + this.networkType + ',' + " tag=" + this.tag + ", enqueueAction=" + this.enqueueAction + ", downloadOnEnqueue=" + this.downloadOnEnqueue + ", " + "autoRetryMaxAttempts=" + this.autoRetryMaxAttempts + ", extras=" + this.extras + ')';
    }
}
