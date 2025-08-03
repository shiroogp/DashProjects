package com.tonyodev.fetch2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tonyodev.fetch2core.Extras;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010.\u001a\u00020\u001aH\u0016J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0002J\b\u00103\u001a\u00020\u001aH\u0016J\b\u00104\u001a\u00020\u0011H\u0016J\u0018\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u001aH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR&\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR\u001c\u0010(\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0013\"\u0004\b*\u0010\u0015R\u001a\u0010+\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010\u0015¨\u0006;"}, d2 = {"Lcom/tonyodev/fetch2/CompletedDownload;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", "created", "", "getCreated", "()J", "setCreated", "(J)V", "extras", "Lcom/tonyodev/fetch2core/Extras;", "getExtras", "()Lcom/tonyodev/fetch2core/Extras;", "setExtras", "(Lcom/tonyodev/fetch2core/Extras;)V", "file", "", "getFile", "()Ljava/lang/String;", "setFile", "(Ljava/lang/String;)V", "fileByteSize", "getFileByteSize", "setFileByteSize", "group", "", "getGroup", "()I", "setGroup", "(I)V", "headers", "", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "identifier", "getIdentifier", "setIdentifier", "tag", "getTag", "setTag", "url", "getUrl", "setUrl", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "CREATOR", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: CompletedDownload.kt */
public class CompletedDownload implements Parcelable, Serializable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private long created;
    private Extras extras;
    private String file = "";
    private long fileByteSize;
    private int group;
    private Map<String, String> headers = MapsKt.emptyMap();
    private long identifier;
    private String tag;
    private String url = "";

    public int describeContents() {
        return 0;
    }

    public CompletedDownload() {
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "Calendar.getInstance()");
        this.created = instance.getTimeInMillis();
        this.extras = Extras.CREATOR.getEmptyExtras();
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.url = str;
    }

    public final String getFile() {
        return this.file;
    }

    public final void setFile(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.file = str;
    }

    public final int getGroup() {
        return this.group;
    }

    public final void setGroup(int i) {
        this.group = i;
    }

    public final long getFileByteSize() {
        return this.fileByteSize;
    }

    public final void setFileByteSize(long j) {
        this.fileByteSize = j;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final void setHeaders(Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(map, "<set-?>");
        this.headers = map;
    }

    public final String getTag() {
        return this.tag;
    }

    public final void setTag(String str) {
        this.tag = str;
    }

    public final long getIdentifier() {
        return this.identifier;
    }

    public final void setIdentifier(long j) {
        this.identifier = j;
    }

    public final long getCreated() {
        return this.created;
    }

    public final void setCreated(long j) {
        this.created = j;
    }

    public final Extras getExtras() {
        return this.extras;
    }

    public final void setExtras(Extras extras2) {
        Intrinsics.checkParameterIsNotNull(extras2, "<set-?>");
        this.extras = extras2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            CompletedDownload completedDownload = (CompletedDownload) obj;
            if (!(!Intrinsics.areEqual((Object) this.url, (Object) completedDownload.url)) && !(!Intrinsics.areEqual((Object) this.file, (Object) completedDownload.file)) && this.group == completedDownload.group && !(!Intrinsics.areEqual((Object) this.headers, (Object) completedDownload.headers)) && !(!Intrinsics.areEqual((Object) this.tag, (Object) completedDownload.tag)) && this.identifier == completedDownload.identifier && this.created == completedDownload.created && !(!Intrinsics.areEqual((Object) this.extras, (Object) completedDownload.extras))) {
                return true;
            }
            return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tonyodev.fetch2.CompletedDownload");
    }

    public int hashCode() {
        int hashCode = ((((((this.url.hashCode() * 31) + this.file.hashCode()) * 31) + this.group) * 31) + this.headers.hashCode()) * 31;
        String str = this.tag;
        return ((((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + Long.valueOf(this.identifier).hashCode()) * 31) + Long.valueOf(this.created).hashCode()) * 31) + this.extras.hashCode();
    }

    public String toString() {
        return "CompletedDownload(url='" + this.url + "', file='" + this.file + "', groupId=" + this.group + ", " + "headers=" + this.headers + ", tag=" + this.tag + ", identifier=" + this.identifier + ", created=" + this.created + ", " + "extras=" + this.extras + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "dest");
        parcel.writeString(this.url);
        parcel.writeString(this.file);
        parcel.writeInt(this.group);
        parcel.writeLong(this.fileByteSize);
        parcel.writeSerializable(new HashMap(this.headers));
        parcel.writeString(this.tag);
        parcel.writeLong(this.identifier);
        parcel.writeLong(this.created);
        parcel.writeSerializable(new HashMap(this.extras.getMap()));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/tonyodev/fetch2/CompletedDownload$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tonyodev/fetch2/CompletedDownload;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tonyodev/fetch2/CompletedDownload;", "fetch2_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: CompletedDownload.kt */
    public static final class CREATOR implements Parcelable.Creator<CompletedDownload> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public CompletedDownload createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, FirebaseAnalytics.Param.SOURCE);
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
            int readInt = parcel.readInt();
            long readLong = parcel.readLong();
            Serializable readSerializable = parcel.readSerializable();
            if (readSerializable != null) {
                Map map = (Map) readSerializable;
                String readString3 = parcel.readString();
                long readLong2 = parcel.readLong();
                long readLong3 = parcel.readLong();
                Serializable readSerializable2 = parcel.readSerializable();
                if (readSerializable2 != null) {
                    CompletedDownload completedDownload = new CompletedDownload();
                    completedDownload.setUrl(readString);
                    completedDownload.setFile(str);
                    completedDownload.setGroup(readInt);
                    completedDownload.setFileByteSize(readLong);
                    completedDownload.setHeaders(map);
                    completedDownload.setTag(readString3);
                    completedDownload.setIdentifier(readLong2);
                    completedDownload.setCreated(readLong3);
                    completedDownload.setExtras(new Extras((Map) readSerializable2));
                    return completedDownload;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        }

        public CompletedDownload[] newArray(int i) {
            return new CompletedDownload[i];
        }
    }
}
