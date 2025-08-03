package com.tonyodev.fetch2core;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0016J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\b\u0010&\u001a\u00020!H\u0016J\b\u0010'\u001a\u00020\fH\u0016J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020!H\u0016R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001a\u0010\u001d\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010¨\u0006."}, d2 = {"Lcom/tonyodev/fetch2core/FileResource;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", "value", "Lcom/tonyodev/fetch2core/Extras;", "extras", "getExtras", "()Lcom/tonyodev/fetch2core/Extras;", "setExtras", "(Lcom/tonyodev/fetch2core/Extras;)V", "file", "", "getFile", "()Ljava/lang/String;", "setFile", "(Ljava/lang/String;)V", "id", "", "getId", "()J", "setId", "(J)V", "length", "getLength", "setLength", "md5", "getMd5", "setMd5", "name", "getName", "setName", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "CREATOR", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FileResource.kt */
public final class FileResource implements Parcelable, Serializable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private Extras extras = Extras.CREATOR.getEmptyExtras();
    private String file = "";
    private long id;
    private long length;
    private String md5 = "";
    private String name = "";

    public int describeContents() {
        return 0;
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final long getLength() {
        return this.length;
    }

    public final void setLength(long j) {
        this.length = j;
    }

    public final String getFile() {
        return this.file;
    }

    public final void setFile(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.file = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.name = str;
    }

    public final Extras getExtras() {
        return this.extras;
    }

    public final void setExtras(Extras extras2) {
        Intrinsics.checkParameterIsNotNull(extras2, "value");
        this.extras = extras2.copy();
    }

    public final String getMd5() {
        return this.md5;
    }

    public final void setMd5(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.md5 = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            FileResource fileResource = (FileResource) obj;
            if (this.id == fileResource.id && this.length == fileResource.length && !(!Intrinsics.areEqual((Object) this.file, (Object) fileResource.file)) && !(!Intrinsics.areEqual((Object) this.name, (Object) fileResource.name)) && !(!Intrinsics.areEqual((Object) this.extras, (Object) fileResource.extras)) && !(!Intrinsics.areEqual((Object) this.md5, (Object) fileResource.md5))) {
                return true;
            }
            return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tonyodev.fetch2core.FileResource");
    }

    public int hashCode() {
        return (((((((((Long.valueOf(this.id).hashCode() * 31) + Long.valueOf(this.length).hashCode()) * 31) + this.file.hashCode()) * 31) + this.name.hashCode()) * 31) + this.extras.hashCode()) * 31) + this.md5.hashCode();
    }

    public String toString() {
        return "FileResource(id=" + this.id + ", length=" + this.length + ", file='" + this.file + "'," + " name='" + this.name + "', extras='" + this.extras + "', md5='" + this.md5 + "')";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "dest");
        parcel.writeLong(this.id);
        parcel.writeString(this.name);
        parcel.writeLong(this.length);
        parcel.writeString(this.file);
        parcel.writeSerializable(new HashMap(this.extras.getMap()));
        parcel.writeString(this.md5);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/tonyodev/fetch2core/FileResource$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tonyodev/fetch2core/FileResource;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tonyodev/fetch2core/FileResource;", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: FileResource.kt */
    public static final class CREATOR implements Parcelable.Creator<FileResource> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public FileResource createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, FirebaseAnalytics.Param.SOURCE);
            FileResource fileResource = new FileResource();
            fileResource.setId(parcel.readLong());
            String readString = parcel.readString();
            String str = "";
            if (readString == null) {
                readString = str;
            }
            fileResource.setName(readString);
            fileResource.setLength(parcel.readLong());
            String readString2 = parcel.readString();
            if (readString2 == null) {
                readString2 = str;
            }
            fileResource.setFile(readString2);
            Serializable readSerializable = parcel.readSerializable();
            if (readSerializable != null) {
                fileResource.setExtras(new Extras((HashMap) readSerializable));
                String readString3 = parcel.readString();
                if (readString3 != null) {
                    str = readString3;
                }
                fileResource.setMd5(str);
                return fileResource;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
        }

        public FileResource[] newArray(int i) {
            return new FileResource[i];
        }
    }
}
