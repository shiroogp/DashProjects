package com.tonyodev.fetch2core;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u001b\u0012\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0016\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000eJ\u0016\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\fJ\u0016\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u0001J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\fH\u0016R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006$"}, d2 = {"Lcom/tonyodev/fetch2core/MutableExtras;", "Lcom/tonyodev/fetch2core/Extras;", "Ljava/io/Serializable;", "mutableData", "", "", "(Ljava/util/Map;)V", "getMutableData", "()Ljava/util/Map;", "clear", "", "describeContents", "", "equals", "", "other", "", "hashCode", "putBoolean", "key", "value", "putDouble", "", "putFloat", "", "putInt", "putLong", "", "putString", "toExtras", "toString", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "CREATOR", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MutableExtras.kt */
public class MutableExtras extends Extras implements Serializable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private final Map<String, String> mutableData;

    public MutableExtras() {
        this((Map) null, 1, (DefaultConstructorMarker) null);
    }

    public int describeContents() {
        return 0;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutableExtras(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new LinkedHashMap() : map);
    }

    /* access modifiers changed from: protected */
    public final Map<String, String> getMutableData() {
        return this.mutableData;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MutableExtras(Map<String, String> map) {
        super(map);
        Intrinsics.checkParameterIsNotNull(map, "mutableData");
        this.mutableData = map;
    }

    public final void putInt(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        this.mutableData.put(str, String.valueOf(i));
    }

    public final void putString(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(str2, "value");
        this.mutableData.put(str, str2);
    }

    public final void putLong(String str, long j) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        this.mutableData.put(str, String.valueOf(j));
    }

    public final void putDouble(String str, double d) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        this.mutableData.put(str, String.valueOf(d));
    }

    public final void putFloat(String str, float f) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        this.mutableData.put(str, String.valueOf(f));
    }

    public final void putBoolean(String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        this.mutableData.put(str, String.valueOf(z));
    }

    public final void clear() {
        this.mutableData.clear();
    }

    public final Extras toExtras() {
        return new Extras(MapsKt.toMap(this.mutableData));
    }

    public String toString() {
        return toJSONString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "dest");
        parcel.writeSerializable(new HashMap(this.mutableData));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) || !super.equals(obj)) {
            return false;
        }
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.tonyodev.fetch2core.MutableExtras");
        } else if (!Intrinsics.areEqual((Object) this.mutableData, (Object) ((MutableExtras) obj).mutableData)) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.mutableData.hashCode();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/tonyodev/fetch2core/MutableExtras$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tonyodev/fetch2core/MutableExtras;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tonyodev/fetch2core/MutableExtras;", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: MutableExtras.kt */
    public static final class CREATOR implements Parcelable.Creator<MutableExtras> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public MutableExtras createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, FirebaseAnalytics.Param.SOURCE);
            Serializable readSerializable = parcel.readSerializable();
            if (readSerializable != null) {
                return new MutableExtras(MapsKt.toMutableMap((HashMap) readSerializable));
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
        }

        public MutableExtras[] newArray(int i) {
            return new MutableExtras[i];
        }
    }
}
