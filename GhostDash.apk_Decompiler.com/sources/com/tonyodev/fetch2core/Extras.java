package com.tonyodev.fetch2core;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tonyodev.fetch2.util.FetchDefaults;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0000H\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0016\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0012J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\fJ\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u001eJ\u0016\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005J\b\u0010 \u001a\u00020\fH\u0016J\u0006\u0010!\u001a\u00020\u0012J\u0006\u0010\"\u001a\u00020\u0012J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u0005J\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020\u0005H\u0016J\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\fH\u0016R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006/"}, d2 = {"Lcom/tonyodev/fetch2core/Extras;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "data", "", "", "(Ljava/util/Map;)V", "getData", "()Ljava/util/Map;", "map", "getMap", "size", "", "getSize", "()I", "copy", "describeContents", "equals", "", "other", "", "getBoolean", "key", "defaultValue", "getDouble", "", "getFloat", "", "getInt", "getLong", "", "getString", "hashCode", "isEmpty", "isNotEmpty", "toJSONObject", "Lorg/json/JSONObject;", "toJSONString", "toMutableExtras", "Lcom/tonyodev/fetch2core/MutableExtras;", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "CREATOR", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Extras.kt */
public class Extras implements Parcelable, Serializable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Extras emptyExtras = new Extras(MapsKt.emptyMap());
    private final Map<String, String> data;

    public static final Extras getEmptyExtras() {
        return emptyExtras;
    }

    public int describeContents() {
        return 0;
    }

    public Extras(Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(map, "data");
        this.data = map;
    }

    /* access modifiers changed from: protected */
    public final Map<String, String> getData() {
        return this.data;
    }

    public final String getString(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(str2, "defaultValue");
        String str3 = this.data.get(str);
        return str3 != null ? str3 : str2;
    }

    public final int getInt(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        String str2 = this.data.get(str);
        return str2 != null ? Integer.parseInt(str2) : i;
    }

    public final long getLong(String str, long j) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        String str2 = this.data.get(str);
        return str2 != null ? Long.parseLong(str2) : j;
    }

    public final boolean getBoolean(String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        String str2 = this.data.get(str);
        return str2 != null ? Boolean.parseBoolean(str2) : z;
    }

    public final double getDouble(String str, double d) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        String str2 = this.data.get(str);
        return str2 != null ? Double.parseDouble(str2) : d;
    }

    public final float getFloat(String str, float f) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        String str2 = this.data.get(str);
        return str2 != null ? Float.parseFloat(str2) : f;
    }

    public final MutableExtras toMutableExtras() {
        return new MutableExtras(MapsKt.toMutableMap(this.data));
    }

    public final String toJSONString() {
        if (isEmpty()) {
            return FetchDefaults.EMPTY_JSON_OBJECT_STRING;
        }
        String jSONObject = new JSONObject(getMap()).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "JSONObject(map).toString()");
        return jSONObject;
    }

    public final JSONObject toJSONObject() {
        if (isEmpty()) {
            return new JSONObject();
        }
        return new JSONObject(getMap());
    }

    public Extras copy() {
        return new Extras(MapsKt.toMap(this.data));
    }

    public final boolean isEmpty() {
        return this.data.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !this.data.isEmpty();
    }

    public final int getSize() {
        return this.data.size();
    }

    public final Map<String, String> getMap() {
        return MapsKt.toMap(this.data);
    }

    public String toString() {
        return toJSONString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "dest");
        parcel.writeSerializable(new HashMap(this.data));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.tonyodev.fetch2core.Extras");
        } else if (!Intrinsics.areEqual((Object) this.data, (Object) ((Extras) obj).data)) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00028\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0003\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/tonyodev/fetch2core/Extras$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tonyodev/fetch2core/Extras;", "()V", "emptyExtras", "emptyExtras$annotations", "getEmptyExtras", "()Lcom/tonyodev/fetch2core/Extras;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tonyodev/fetch2core/Extras;", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Extras.kt */
    public static final class CREATOR implements Parcelable.Creator<Extras> {
        @JvmStatic
        public static /* synthetic */ void emptyExtras$annotations() {
        }

        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Extras createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, FirebaseAnalytics.Param.SOURCE);
            Serializable readSerializable = parcel.readSerializable();
            if (readSerializable != null) {
                return new Extras((HashMap) readSerializable);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
        }

        public Extras[] newArray(int i) {
            return new Extras[i];
        }

        public final Extras getEmptyExtras() {
            return Extras.emptyExtras;
        }
    }
}
