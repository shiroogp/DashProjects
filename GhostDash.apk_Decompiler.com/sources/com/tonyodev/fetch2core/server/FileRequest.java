package com.tonyodev.fetch2core.server;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tonyodev.fetch2core.Extras;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:Bi\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\t\u0010%\u001a\u00020\u0011HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\t\u0010+\u001a\u00020\rHÆ\u0003J\t\u0010,\u001a\u00020\u0004HÆ\u0003J\t\u0010-\u001a\u00020\u0004HÆ\u0003Jm\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\b\u0010/\u001a\u00020\u0004H\u0016J\u0013\u00100\u001a\u00020\u00112\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\u0004HÖ\u0001J\t\u00104\u001a\u00020\u0006HÖ\u0001J\u0018\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0004H\u0016R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010!\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001a¨\u0006;"}, d2 = {"Lcom/tonyodev/fetch2core/server/FileRequest;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "type", "", "fileResourceId", "", "rangeStart", "", "rangeEnd", "authorization", "client", "extras", "Lcom/tonyodev/fetch2core/Extras;", "page", "size", "persistConnection", "", "(ILjava/lang/String;JJLjava/lang/String;Ljava/lang/String;Lcom/tonyodev/fetch2core/Extras;IIZ)V", "getAuthorization", "()Ljava/lang/String;", "getClient", "getExtras", "()Lcom/tonyodev/fetch2core/Extras;", "getFileResourceId", "getPage", "()I", "getPersistConnection", "()Z", "getRangeEnd", "()J", "getRangeStart", "getSize", "toJsonString", "getToJsonString", "getType", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "CREATOR", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FileRequest.kt */
public final class FileRequest implements Parcelable, Serializable {
    public static final String CATALOG_FILE = "/Catalog.json";
    public static final long CATALOG_ID = -1;
    public static final String CATALOG_NAME = "Catalog.json";
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    public static final String FIELD_AUTHORIZATION = "Authorization";
    public static final String FIELD_CLIENT = "Client";
    public static final String FIELD_EXTRAS = "Extras";
    public static final String FIELD_FILE_RESOURCE_ID = "FileResourceId";
    public static final String FIELD_PAGE = "Page";
    public static final String FIELD_PERSIST_CONNECTION = "Persist-Connection";
    public static final String FIELD_RANGE_END = "Range-End";
    public static final String FIELD_RANGE_START = "Range-Start";
    public static final String FIELD_SIZE = "Size";
    public static final String FIELD_TYPE = "Type";
    public static final int TYPE_CATALOG = 2;
    public static final int TYPE_FILE = 1;
    public static final int TYPE_INVALID = -1;
    public static final int TYPE_PING = 0;
    private final String authorization;
    private final String client;
    private final Extras extras;
    private final String fileResourceId;
    private final int page;
    private final boolean persistConnection;
    private final long rangeEnd;
    private final long rangeStart;
    private final int size;
    private final int type;

    public FileRequest() {
        this(0, (String) null, 0, 0, (String) null, (String) null, (Extras) null, 0, 0, false, 1023, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FileRequest copy$default(FileRequest fileRequest, int i, String str, long j, long j2, String str2, String str3, Extras extras2, int i2, int i3, boolean z, int i4, Object obj) {
        FileRequest fileRequest2 = fileRequest;
        int i5 = i4;
        return fileRequest.copy((i5 & 1) != 0 ? fileRequest2.type : i, (i5 & 2) != 0 ? fileRequest2.fileResourceId : str, (i5 & 4) != 0 ? fileRequest2.rangeStart : j, (i5 & 8) != 0 ? fileRequest2.rangeEnd : j2, (i5 & 16) != 0 ? fileRequest2.authorization : str2, (i5 & 32) != 0 ? fileRequest2.client : str3, (i5 & 64) != 0 ? fileRequest2.extras : extras2, (i5 & 128) != 0 ? fileRequest2.page : i2, (i5 & 256) != 0 ? fileRequest2.size : i3, (i5 & 512) != 0 ? fileRequest2.persistConnection : z);
    }

    public final int component1() {
        return this.type;
    }

    public final boolean component10() {
        return this.persistConnection;
    }

    public final String component2() {
        return this.fileResourceId;
    }

    public final long component3() {
        return this.rangeStart;
    }

    public final long component4() {
        return this.rangeEnd;
    }

    public final String component5() {
        return this.authorization;
    }

    public final String component6() {
        return this.client;
    }

    public final Extras component7() {
        return this.extras;
    }

    public final int component8() {
        return this.page;
    }

    public final int component9() {
        return this.size;
    }

    public final FileRequest copy(int i, String str, long j, long j2, String str2, String str3, Extras extras2, int i2, int i3, boolean z) {
        String str4 = str;
        Intrinsics.checkParameterIsNotNull(str4, "fileResourceId");
        String str5 = str2;
        Intrinsics.checkParameterIsNotNull(str5, "authorization");
        String str6 = str3;
        Intrinsics.checkParameterIsNotNull(str6, "client");
        Extras extras3 = extras2;
        Intrinsics.checkParameterIsNotNull(extras3, "extras");
        return new FileRequest(i, str4, j, j2, str5, str6, extras3, i2, i3, z);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FileRequest)) {
            return false;
        }
        FileRequest fileRequest = (FileRequest) obj;
        return this.type == fileRequest.type && Intrinsics.areEqual((Object) this.fileResourceId, (Object) fileRequest.fileResourceId) && this.rangeStart == fileRequest.rangeStart && this.rangeEnd == fileRequest.rangeEnd && Intrinsics.areEqual((Object) this.authorization, (Object) fileRequest.authorization) && Intrinsics.areEqual((Object) this.client, (Object) fileRequest.client) && Intrinsics.areEqual((Object) this.extras, (Object) fileRequest.extras) && this.page == fileRequest.page && this.size == fileRequest.size && this.persistConnection == fileRequest.persistConnection;
    }

    public int hashCode() {
        int i = this.type * 31;
        String str = this.fileResourceId;
        int i2 = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        long j = this.rangeStart;
        long j2 = this.rangeEnd;
        int i3 = (((((i + hashCode) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str2 = this.authorization;
        int hashCode2 = (i3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.client;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Extras extras2 = this.extras;
        if (extras2 != null) {
            i2 = extras2.hashCode();
        }
        int i4 = (((((hashCode3 + i2) * 31) + this.page) * 31) + this.size) * 31;
        boolean z = this.persistConnection;
        if (z) {
            z = true;
        }
        return i4 + (z ? 1 : 0);
    }

    public String toString() {
        return "FileRequest(type=" + this.type + ", fileResourceId=" + this.fileResourceId + ", rangeStart=" + this.rangeStart + ", rangeEnd=" + this.rangeEnd + ", authorization=" + this.authorization + ", client=" + this.client + ", extras=" + this.extras + ", page=" + this.page + ", size=" + this.size + ", persistConnection=" + this.persistConnection + ")";
    }

    public FileRequest(int i, String str, long j, long j2, String str2, String str3, Extras extras2, int i2, int i3, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "fileResourceId");
        Intrinsics.checkParameterIsNotNull(str2, "authorization");
        Intrinsics.checkParameterIsNotNull(str3, "client");
        Intrinsics.checkParameterIsNotNull(extras2, "extras");
        this.type = i;
        this.fileResourceId = str;
        this.rangeStart = j;
        this.rangeEnd = j2;
        this.authorization = str2;
        this.client = str3;
        this.extras = extras2;
        this.page = i2;
        this.size = i3;
        this.persistConnection = z;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FileRequest(int r14, java.lang.String r15, long r16, long r18, java.lang.String r20, java.lang.String r21, com.tonyodev.fetch2core.Extras r22, int r23, int r24, boolean r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r13 = this;
            r0 = r26
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = -1
            goto L_0x0009
        L_0x0008:
            r1 = r14
        L_0x0009:
            r2 = r0 & 2
            r3 = -1
            if (r2 == 0) goto L_0x0014
            java.lang.String r2 = java.lang.String.valueOf(r3)
            goto L_0x0015
        L_0x0014:
            r2 = r15
        L_0x0015:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x001c
            r5 = 0
            goto L_0x001e
        L_0x001c:
            r5 = r16
        L_0x001e:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            r3 = r18
        L_0x0025:
            r7 = r0 & 16
            java.lang.String r8 = ""
            if (r7 == 0) goto L_0x002d
            r7 = r8
            goto L_0x002f
        L_0x002d:
            r7 = r20
        L_0x002f:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r8 = r21
        L_0x0036:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0041
            com.tonyodev.fetch2core.Extras$CREATOR r9 = com.tonyodev.fetch2core.Extras.CREATOR
            com.tonyodev.fetch2core.Extras r9 = r9.getEmptyExtras()
            goto L_0x0043
        L_0x0041:
            r9 = r22
        L_0x0043:
            r10 = r0 & 128(0x80, float:1.794E-43)
            r11 = 0
            if (r10 == 0) goto L_0x004a
            r10 = r11
            goto L_0x004c
        L_0x004a:
            r10 = r23
        L_0x004c:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x0051
            goto L_0x0053
        L_0x0051:
            r11 = r24
        L_0x0053:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0059
            r0 = 1
            goto L_0x005b
        L_0x0059:
            r0 = r25
        L_0x005b:
            r14 = r13
            r15 = r1
            r16 = r2
            r17 = r5
            r19 = r3
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r11
            r26 = r0
            r14.<init>(r15, r16, r17, r19, r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2core.server.FileRequest.<init>(int, java.lang.String, long, long, java.lang.String, java.lang.String, com.tonyodev.fetch2core.Extras, int, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getFileResourceId() {
        return this.fileResourceId;
    }

    public final long getRangeStart() {
        return this.rangeStart;
    }

    public final long getRangeEnd() {
        return this.rangeEnd;
    }

    public final String getAuthorization() {
        return this.authorization;
    }

    public final String getClient() {
        return this.client;
    }

    public final Extras getExtras() {
        return this.extras;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getSize() {
        return this.size;
    }

    public final boolean getPersistConnection() {
        return this.persistConnection;
    }

    public final String getToJsonString() {
        String str = '{' + "\"Type\":" + this.type + ',' + "\"FileResourceId\":" + (Typography.quote + this.fileResourceId + Typography.quote) + ',' + "\"Range-Start\":" + this.rangeStart + ',' + "\"Range-End\":" + this.rangeEnd + ',' + "\"Authorization\":" + (Typography.quote + this.authorization + Typography.quote) + ',' + "\"Client\":" + (Typography.quote + this.client + Typography.quote) + ',' + "\"Extras\":" + this.extras.toJSONString() + ',' + "\"Page\":" + this.page + ',' + "\"Size\":" + this.size + ',' + "\"Persist-Connection\":" + this.persistConnection + '}';
        Intrinsics.checkExpressionValueIsNotNull(str, "builder.toString()");
        return str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "dest");
        parcel.writeInt(this.type);
        parcel.writeString(this.fileResourceId);
        parcel.writeLong(this.rangeStart);
        parcel.writeLong(this.rangeEnd);
        parcel.writeString(this.authorization);
        parcel.writeString(this.client);
        parcel.writeSerializable(new HashMap(this.extras.getMap()));
        parcel.writeInt(this.page);
        parcel.writeInt(this.size);
        parcel.writeInt(this.persistConnection ? 1 : 0);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001d\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0014H\u0016¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/tonyodev/fetch2core/server/FileRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tonyodev/fetch2core/server/FileRequest;", "()V", "CATALOG_FILE", "", "CATALOG_ID", "", "CATALOG_NAME", "FIELD_AUTHORIZATION", "FIELD_CLIENT", "FIELD_EXTRAS", "FIELD_FILE_RESOURCE_ID", "FIELD_PAGE", "FIELD_PERSIST_CONNECTION", "FIELD_RANGE_END", "FIELD_RANGE_START", "FIELD_SIZE", "FIELD_TYPE", "TYPE_CATALOG", "", "TYPE_FILE", "TYPE_INVALID", "TYPE_PING", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/tonyodev/fetch2core/server/FileRequest;", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: FileRequest.kt */
    public static final class CREATOR implements Parcelable.Creator<FileRequest> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public FileRequest createFromParcel(Parcel parcel) {
            String str;
            String str2;
            Intrinsics.checkParameterIsNotNull(parcel, FirebaseAnalytics.Param.SOURCE);
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String str3 = readString != null ? readString : "";
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            String readString2 = parcel.readString();
            if (readString2 != null) {
                str = readString2;
            } else {
                str = "";
            }
            String readString3 = parcel.readString();
            if (readString3 != null) {
                str2 = readString3;
            } else {
                str2 = "";
            }
            Serializable readSerializable = parcel.readSerializable();
            if (readSerializable != null) {
                return new FileRequest(readInt, str3, readLong, readLong2, str, str2, new Extras((HashMap) readSerializable), parcel.readInt(), parcel.readInt(), parcel.readInt() == 1);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
        }

        public FileRequest[] newArray(int i) {
            return new FileRequest[i];
        }
    }
}
