package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzr();
    public int zza;
    public String zzb;
    public String zzc;
    public int zzd;
    public Point[] zze;
    public zzj zzf;
    public zzm zzg;
    public zzn zzh;
    public zzp zzi;
    public zzo zzj;
    public zzk zzk;
    public zzg zzl;
    public zzh zzm;
    public zzi zzn;
    public byte[] zzo;
    public boolean zzp;
    public double zzq;

    public zzq() {
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zza);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzd);
        SafeParcelWriter.writeTypedArray(parcel, 6, this.zze, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzf, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzh, i, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzi, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzj, i, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzk, i, false);
        SafeParcelWriter.writeParcelable(parcel, 13, this.zzl, i, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzm, i, false);
        SafeParcelWriter.writeParcelable(parcel, 15, this.zzn, i, false);
        SafeParcelWriter.writeByteArray(parcel, 16, this.zzo, false);
        SafeParcelWriter.writeBoolean(parcel, 17, this.zzp);
        SafeParcelWriter.writeDouble(parcel, 18, this.zzq);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzq(int i, String str, String str2, int i2, Point[] pointArr, zzj zzj2, zzm zzm2, zzn zzn2, zzp zzp2, zzo zzo2, zzk zzk2, zzg zzg2, zzh zzh2, zzi zzi2, byte[] bArr, boolean z, double d) {
        this.zza = i;
        this.zzb = str;
        this.zzo = bArr;
        this.zzc = str2;
        this.zzd = i2;
        this.zze = pointArr;
        this.zzp = z;
        this.zzq = d;
        this.zzf = zzj2;
        this.zzg = zzm2;
        this.zzh = zzn2;
        this.zzi = zzp2;
        this.zzj = zzo2;
        this.zzk = zzk2;
        this.zzl = zzg2;
        this.zzm = zzh2;
        this.zzn = zzi2;
    }
}
