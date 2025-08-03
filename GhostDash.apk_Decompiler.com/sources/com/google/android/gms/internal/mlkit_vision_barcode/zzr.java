package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final class zzr implements Parcelable.Creator<zzq> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        int i2 = 0;
        boolean z = false;
        String str = null;
        String str2 = null;
        Point[] pointArr = null;
        zzj zzj = null;
        zzm zzm = null;
        zzn zzn = null;
        zzp zzp = null;
        zzo zzo = null;
        zzk zzk = null;
        zzg zzg = null;
        zzh zzh = null;
        zzi zzi = null;
        byte[] bArr = null;
        double d = 0.0d;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    i = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 4:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 5:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 6:
                    pointArr = (Point[]) SafeParcelReader.createTypedArray(parcel2, readHeader, Point.CREATOR);
                    break;
                case 7:
                    zzj = (zzj) SafeParcelReader.createParcelable(parcel2, readHeader, zzj.CREATOR);
                    break;
                case 8:
                    zzm = (zzm) SafeParcelReader.createParcelable(parcel2, readHeader, zzm.CREATOR);
                    break;
                case 9:
                    zzn = (zzn) SafeParcelReader.createParcelable(parcel2, readHeader, zzn.CREATOR);
                    break;
                case 10:
                    zzp = (zzp) SafeParcelReader.createParcelable(parcel2, readHeader, zzp.CREATOR);
                    break;
                case 11:
                    zzo = (zzo) SafeParcelReader.createParcelable(parcel2, readHeader, zzo.CREATOR);
                    break;
                case 12:
                    zzk = (zzk) SafeParcelReader.createParcelable(parcel2, readHeader, zzk.CREATOR);
                    break;
                case 13:
                    zzg = (zzg) SafeParcelReader.createParcelable(parcel2, readHeader, zzg.CREATOR);
                    break;
                case 14:
                    zzh = (zzh) SafeParcelReader.createParcelable(parcel2, readHeader, zzh.CREATOR);
                    break;
                case 15:
                    zzi = (zzi) SafeParcelReader.createParcelable(parcel2, readHeader, zzi.CREATOR);
                    break;
                case 16:
                    bArr = SafeParcelReader.createByteArray(parcel2, readHeader);
                    break;
                case 17:
                    z = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 18:
                    d = SafeParcelReader.readDouble(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzq(i, str, str2, i2, pointArr, zzj, zzm, zzn, zzp, zzo, zzk, zzg, zzh, zzi, bArr, z, d);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new zzq[i];
    }
}
