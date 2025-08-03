package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final class zzmq implements Parcelable.Creator<zzmp> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        byte[] bArr = null;
        Point[] pointArr = null;
        zzmi zzmi = null;
        zzml zzml = null;
        zzmm zzmm = null;
        zzmo zzmo = null;
        zzmn zzmn = null;
        zzmj zzmj = null;
        zzmf zzmf = null;
        zzmg zzmg = null;
        zzmh zzmh = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 4:
                    bArr = SafeParcelReader.createByteArray(parcel2, readHeader);
                    break;
                case 5:
                    pointArr = (Point[]) SafeParcelReader.createTypedArray(parcel2, readHeader, Point.CREATOR);
                    break;
                case 6:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 7:
                    zzmi = (zzmi) SafeParcelReader.createParcelable(parcel2, readHeader, zzmi.CREATOR);
                    break;
                case 8:
                    zzml = (zzml) SafeParcelReader.createParcelable(parcel2, readHeader, zzml.CREATOR);
                    break;
                case 9:
                    zzmm = (zzmm) SafeParcelReader.createParcelable(parcel2, readHeader, zzmm.CREATOR);
                    break;
                case 10:
                    zzmo = (zzmo) SafeParcelReader.createParcelable(parcel2, readHeader, zzmo.CREATOR);
                    break;
                case 11:
                    zzmn = (zzmn) SafeParcelReader.createParcelable(parcel2, readHeader, zzmn.CREATOR);
                    break;
                case 12:
                    zzmj = (zzmj) SafeParcelReader.createParcelable(parcel2, readHeader, zzmj.CREATOR);
                    break;
                case 13:
                    zzmf = (zzmf) SafeParcelReader.createParcelable(parcel2, readHeader, zzmf.CREATOR);
                    break;
                case 14:
                    zzmg = (zzmg) SafeParcelReader.createParcelable(parcel2, readHeader, zzmg.CREATOR);
                    break;
                case 15:
                    zzmh = (zzmh) SafeParcelReader.createParcelable(parcel2, readHeader, zzmh.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzmp(i, str, str2, bArr, pointArr, i2, zzmi, zzml, zzmm, zzmo, zzmn, zzmj, zzmf, zzmg, zzmh);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new zzmp[i];
    }
}
