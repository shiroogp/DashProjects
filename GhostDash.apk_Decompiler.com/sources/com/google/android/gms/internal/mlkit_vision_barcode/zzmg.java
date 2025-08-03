package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final class zzmg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzmg> CREATOR = new zzmv();
    private final zzmk zza;
    private final String zzb;
    private final String zzc;
    private final zzml[] zzd;
    private final zzmi[] zze;
    private final String[] zzf;
    private final zzmd[] zzg;

    public zzmg(zzmk zzmk, String str, String str2, zzml[] zzmlArr, zzmi[] zzmiArr, String[] strArr, zzmd[] zzmdArr) {
        this.zza = zzmk;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzmlArr;
        this.zze = zzmiArr;
        this.zzf = strArr;
        this.zzg = zzmdArr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeTypedArray(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeStringArray(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeTypedArray(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzmk zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final zzmd[] zzd() {
        return this.zzg;
    }

    public final zzmi[] zze() {
        return this.zze;
    }

    public final zzml[] zzf() {
        return this.zzd;
    }

    public final String[] zzg() {
        return this.zzf;
    }
}
