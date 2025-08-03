package com.google.android.gms.internal.mlkit_vision_text;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final class zzlw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzlw> CREATOR = new zzlx();
    private final String zza;
    private final List<zzlq> zzb;

    public zzlw(String str, List<zzlq> list) {
        this.zza = str;
        this.zzb = list;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zza() {
        return this.zza;
    }

    public final List<zzlq> zzb() {
        return this.zzb;
    }
}
