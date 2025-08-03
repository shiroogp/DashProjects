package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final class zzmp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzmp> CREATOR = new zzmq();
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final byte[] zzd;
    private final Point[] zze;
    private final int zzf;
    private final zzmi zzg;
    private final zzml zzh;
    private final zzmm zzi;
    private final zzmo zzj;
    private final zzmn zzk;
    private final zzmj zzl;
    private final zzmf zzm;
    private final zzmg zzn;
    private final zzmh zzo;

    public zzmp(int i, String str, String str2, byte[] bArr, Point[] pointArr, int i2, zzmi zzmi, zzml zzml, zzmm zzmm, zzmo zzmo, zzmn zzmn, zzmj zzmj, zzmf zzmf, zzmg zzmg, zzmh zzmh) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bArr;
        this.zze = pointArr;
        this.zzf = i2;
        this.zzg = zzmi;
        this.zzh = zzml;
        this.zzi = zzmm;
        this.zzj = zzmo;
        this.zzk = zzmn;
        this.zzl = zzmj;
        this.zzm = zzmf;
        this.zzn = zzmg;
        this.zzo = zzmh;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeTypedArray(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzf);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzh, i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzi, i, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzj, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzl, i, false);
        SafeParcelWriter.writeParcelable(parcel, 13, this.zzm, i, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzn, i, false);
        SafeParcelWriter.writeParcelable(parcel, 15, this.zzo, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzf;
    }

    public final zzmf zzc() {
        return this.zzm;
    }

    public final zzmg zzd() {
        return this.zzn;
    }

    public final zzmh zze() {
        return this.zzo;
    }

    public final zzmi zzf() {
        return this.zzg;
    }

    public final zzmj zzg() {
        return this.zzl;
    }

    public final zzml zzh() {
        return this.zzh;
    }

    public final zzmm zzi() {
        return this.zzi;
    }

    public final zzmn zzj() {
        return this.zzk;
    }

    public final zzmo zzk() {
        return this.zzj;
    }

    public final String zzl() {
        return this.zzb;
    }

    public final String zzm() {
        return this.zzc;
    }

    public final byte[] zzn() {
        return this.zzd;
    }

    public final Point[] zzo() {
        return this.zze;
    }
}
