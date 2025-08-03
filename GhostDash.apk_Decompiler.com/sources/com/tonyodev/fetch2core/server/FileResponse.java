package com.tonyodev.fetch2core.server;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import org.spongycastle.asn1.eac.CertificateBody;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.BK\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003JO\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\b\u0010\"\u001a\u00020\u0004H\u0016J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0004HÖ\u0001J\t\u0010(\u001a\u00020\u000bHÖ\u0001J\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0004H\u0016R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0017\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000f¨\u0006/"}, d2 = {"Lcom/tonyodev/fetch2core/server/FileResponse;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "status", "", "type", "connection", "date", "", "contentLength", "md5", "", "sessionId", "(IIIJJLjava/lang/String;Ljava/lang/String;)V", "getConnection", "()I", "getContentLength", "()J", "getDate", "getMd5", "()Ljava/lang/String;", "getSessionId", "getStatus", "toJsonString", "getToJsonString", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "CREATOR", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FileResponse.kt */
public final class FileResponse implements Parcelable, Serializable {
    public static final int CLOSE_CONNECTION = 0;
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    public static final String FIELD_CONNECTION = "connection";
    public static final String FIELD_CONTENT_LENGTH = "content-length";
    public static final String FIELD_DATE = "date";
    public static final String FIELD_MD5 = "md5";
    public static final String FIELD_SESSION_ID = "sessionid";
    public static final String FIELD_STATUS = "status";
    public static final String FIELD_TYPE = "type";
    public static final int OPEN_CONNECTION = 1;
    private final int connection;
    private final long contentLength;
    private final long date;
    private final String md5;
    private final String sessionId;
    private final int status;
    private final int type;

    public FileResponse() {
        this(0, 0, 0, 0, 0, (String) null, (String) null, CertificateBody.profileType, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FileResponse copy$default(FileResponse fileResponse, int i, int i2, int i3, long j, long j2, String str, String str2, int i4, Object obj) {
        FileResponse fileResponse2 = fileResponse;
        return fileResponse.copy((i4 & 1) != 0 ? fileResponse2.status : i, (i4 & 2) != 0 ? fileResponse2.type : i2, (i4 & 4) != 0 ? fileResponse2.connection : i3, (i4 & 8) != 0 ? fileResponse2.date : j, (i4 & 16) != 0 ? fileResponse2.contentLength : j2, (i4 & 32) != 0 ? fileResponse2.md5 : str, (i4 & 64) != 0 ? fileResponse2.sessionId : str2);
    }

    public final int component1() {
        return this.status;
    }

    public final int component2() {
        return this.type;
    }

    public final int component3() {
        return this.connection;
    }

    public final long component4() {
        return this.date;
    }

    public final long component5() {
        return this.contentLength;
    }

    public final String component6() {
        return this.md5;
    }

    public final String component7() {
        return this.sessionId;
    }

    public final FileResponse copy(int i, int i2, int i3, long j, long j2, String str, String str2) {
        String str3 = str;
        Intrinsics.checkParameterIsNotNull(str3, FIELD_MD5);
        String str4 = str2;
        Intrinsics.checkParameterIsNotNull(str4, "sessionId");
        return new FileResponse(i, i2, i3, j, j2, str3, str4);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FileResponse)) {
            return false;
        }
        FileResponse fileResponse = (FileResponse) obj;
        return this.status == fileResponse.status && this.type == fileResponse.type && this.connection == fileResponse.connection && this.date == fileResponse.date && this.contentLength == fileResponse.contentLength && Intrinsics.areEqual((Object) this.md5, (Object) fileResponse.md5) && Intrinsics.areEqual((Object) this.sessionId, (Object) fileResponse.sessionId);
    }

    public int hashCode() {
        long j = this.date;
        long j2 = this.contentLength;
        int i = ((((((((this.status * 31) + this.type) * 31) + this.connection) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str = this.md5;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.sessionId;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "FileResponse(status=" + this.status + ", type=" + this.type + ", connection=" + this.connection + ", date=" + this.date + ", contentLength=" + this.contentLength + ", md5=" + this.md5 + ", sessionId=" + this.sessionId + ")";
    }

    public FileResponse(int i, int i2, int i3, long j, long j2, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, FIELD_MD5);
        Intrinsics.checkParameterIsNotNull(str2, "sessionId");
        this.status = i;
        this.type = i2;
        this.connection = i3;
        this.date = j;
        this.contentLength = j2;
        this.md5 = str;
        this.sessionId = str2;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getType() {
        return this.type;
    }

    public final int getConnection() {
        return this.connection;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FileResponse(int r11, int r12, int r13, long r14, long r16, java.lang.String r18, java.lang.String r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20 & 1
            if (r0 == 0) goto L_0x0007
            r0 = 415(0x19f, float:5.82E-43)
            goto L_0x0008
        L_0x0007:
            r0 = r11
        L_0x0008:
            r1 = r20 & 2
            if (r1 == 0) goto L_0x000e
            r1 = -1
            goto L_0x000f
        L_0x000e:
            r1 = r12
        L_0x000f:
            r2 = r20 & 4
            if (r2 == 0) goto L_0x0015
            r2 = 0
            goto L_0x0016
        L_0x0015:
            r2 = r13
        L_0x0016:
            r3 = r20 & 8
            if (r3 == 0) goto L_0x0024
            java.util.Date r3 = new java.util.Date
            r3.<init>()
            long r3 = r3.getTime()
            goto L_0x0025
        L_0x0024:
            r3 = r14
        L_0x0025:
            r5 = r20 & 16
            if (r5 == 0) goto L_0x002c
            r5 = 0
            goto L_0x002e
        L_0x002c:
            r5 = r16
        L_0x002e:
            r7 = r20 & 32
            java.lang.String r8 = ""
            if (r7 == 0) goto L_0x0036
            r7 = r8
            goto L_0x0038
        L_0x0036:
            r7 = r18
        L_0x0038:
            r9 = r20 & 64
            if (r9 == 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r8 = r19
        L_0x003f:
            r11 = r10
            r12 = r0
            r13 = r1
            r14 = r2
            r15 = r3
            r17 = r5
            r19 = r7
            r20 = r8
            r11.<init>(r12, r13, r14, r15, r17, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2core.server.FileResponse.<init>(int, int, int, long, long, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final long getDate() {
        return this.date;
    }

    public final long getContentLength() {
        return this.contentLength;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getToJsonString() {
        String str = '{' + "\"Status\":" + this.status + ',' + "\"Md5\":" + (Typography.quote + this.md5 + Typography.quote) + ',' + "\"Connection\":" + this.connection + ',' + "\"Date\":" + this.date + ',' + "\"Content-Length\":" + this.contentLength + ',' + "\"Type\":" + this.type + ',' + "\"SessionId\":" + this.sessionId + '}';
        Intrinsics.checkExpressionValueIsNotNull(str, "builder.toString()");
        return str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "dest");
        parcel.writeInt(this.status);
        parcel.writeInt(this.type);
        parcel.writeInt(this.connection);
        parcel.writeLong(this.date);
        parcel.writeLong(this.contentLength);
        parcel.writeString(this.md5);
        parcel.writeString(this.sessionId);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001d\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/tonyodev/fetch2core/server/FileResponse$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tonyodev/fetch2core/server/FileResponse;", "()V", "CLOSE_CONNECTION", "", "FIELD_CONNECTION", "", "FIELD_CONTENT_LENGTH", "FIELD_DATE", "FIELD_MD5", "FIELD_SESSION_ID", "FIELD_STATUS", "FIELD_TYPE", "OPEN_CONNECTION", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/tonyodev/fetch2core/server/FileResponse;", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: FileResponse.kt */
    public static final class CREATOR implements Parcelable.Creator<FileResponse> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public FileResponse createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, FirebaseAnalytics.Param.SOURCE);
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            String readString = parcel.readString();
            String str = readString != null ? readString : "";
            String readString2 = parcel.readString();
            if (readString2 == null) {
                readString2 = "";
            }
            return new FileResponse(readInt, readInt2, readInt3, readLong, readLong2, str, readString2);
        }

        public FileResponse[] newArray(int i) {
            return new FileResponse[i];
        }
    }
}
