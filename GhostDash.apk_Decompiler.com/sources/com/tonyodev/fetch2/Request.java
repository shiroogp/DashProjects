package com.tonyodev.fetch2;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.common.internal.ImagesContract;
import com.tonyodev.fetch2core.Extras;
import com.tonyodev.fetch2core.FetchCoreUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000  2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001 B\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0010H\u0016R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006!"}, d2 = {"Lcom/tonyodev/fetch2/Request;", "Lcom/tonyodev/fetch2/RequestInfo;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "url", "", "fileUri", "Landroid/net/Uri;", "(Ljava/lang/String;Landroid/net/Uri;)V", "file", "(Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getFileUri", "()Landroid/net/Uri;", "id", "", "getId", "()I", "getUrl", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Request.kt */
public class Request extends RequestInfo implements Parcelable, Serializable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private final String file;
    private final int id;
    private final String url;

    public int describeContents() {
        return 0;
    }

    public final String getUrl() {
        return this.url;
    }

    public Request(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, ImagesContract.URL);
        Intrinsics.checkParameterIsNotNull(str2, UriUtil.LOCAL_FILE_SCHEME);
        this.url = str;
        this.file = str2;
        this.id = FetchCoreUtils.getUniqueId(str, str2);
    }

    public final String getFile() {
        return this.file;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Request(java.lang.String r2, android.net.Uri r3) {
        /*
            r1 = this;
            java.lang.String r0 = "url"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.lang.String r0 = "fileUri"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.String r3 = r3.toString()
            java.lang.String r0 = "fileUri.toString()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r0)
            r1.<init>((java.lang.String) r2, (java.lang.String) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2.Request.<init>(java.lang.String, android.net.Uri):void");
    }

    public final int getId() {
        return this.id;
    }

    public final Uri getFileUri() {
        return FetchCoreUtils.getFileUri(this.file);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) || !super.equals(obj)) {
            return false;
        }
        if (obj != null) {
            Request request = (Request) obj;
            if (this.id == request.id && !(!Intrinsics.areEqual((Object) this.url, (Object) request.url)) && !(!Intrinsics.areEqual((Object) this.file, (Object) request.file))) {
                return true;
            }
            return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tonyodev.fetch2.Request");
    }

    public int hashCode() {
        return (((((super.hashCode() * 31) + this.id) * 31) + this.url.hashCode()) * 31) + this.file.hashCode();
    }

    public String toString() {
        return "Request(url='" + this.url + "', file='" + this.file + "', id=" + this.id + ", groupId=" + getGroupId() + ", " + "headers=" + getHeaders() + ", priority=" + getPriority() + ", networkType=" + getNetworkType() + ", tag=" + getTag() + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.url);
        parcel.writeString(this.file);
        parcel.writeLong(getIdentifier());
        parcel.writeInt(getGroupId());
        parcel.writeSerializable(new HashMap(getHeaders()));
        parcel.writeInt(getPriority().getValue());
        parcel.writeInt(getNetworkType().getValue());
        parcel.writeString(getTag());
        parcel.writeInt(getEnqueueAction().getValue());
        parcel.writeInt(getDownloadOnEnqueue() ? 1 : 0);
        parcel.writeSerializable(new HashMap(getExtras().getMap()));
        parcel.writeInt(getAutoRetryMaxAttempts());
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/tonyodev/fetch2/Request$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tonyodev/fetch2/Request;", "()V", "createFromParcel", "input", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tonyodev/fetch2/Request;", "fetch2_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Request.kt */
    public static final class CREATOR implements Parcelable.Creator<Request> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Request createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "input");
            String readString = parcel.readString();
            String str = "";
            if (readString == null) {
                readString = str;
            }
            Intrinsics.checkExpressionValueIsNotNull(readString, "input.readString() ?: \"\"");
            String readString2 = parcel.readString();
            if (readString2 != null) {
                str = readString2;
            }
            Intrinsics.checkExpressionValueIsNotNull(str, "input.readString() ?: \"\"");
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            Serializable readSerializable = parcel.readSerializable();
            if (readSerializable != null) {
                Map map = (Map) readSerializable;
                Priority valueOf = Priority.Companion.valueOf(parcel.readInt());
                NetworkType valueOf2 = NetworkType.Companion.valueOf(parcel.readInt());
                String readString3 = parcel.readString();
                EnqueueAction valueOf3 = EnqueueAction.Companion.valueOf(parcel.readInt());
                boolean z = true;
                if (parcel.readInt() != 1) {
                    z = false;
                }
                Serializable readSerializable2 = parcel.readSerializable();
                if (readSerializable2 != null) {
                    Map map2 = (Map) readSerializable2;
                    int readInt2 = parcel.readInt();
                    Request request = new Request(readString, str);
                    request.setIdentifier(readLong);
                    request.setGroupId(readInt);
                    for (Map.Entry entry : map.entrySet()) {
                        request.addHeader((String) entry.getKey(), (String) entry.getValue());
                    }
                    request.setPriority(valueOf);
                    request.setNetworkType(valueOf2);
                    request.setTag(readString3);
                    request.setEnqueueAction(valueOf3);
                    request.setDownloadOnEnqueue(z);
                    request.setExtras(new Extras(map2));
                    request.setAutoRetryMaxAttempts(readInt2);
                    return request;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        }

        public Request[] newArray(int i) {
            return new Request[i];
        }
    }
}
