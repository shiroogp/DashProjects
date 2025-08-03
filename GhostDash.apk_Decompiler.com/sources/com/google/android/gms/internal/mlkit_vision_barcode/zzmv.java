package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final class zzmv implements Parcelable.Creator<zzmg> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzmk zzmk = null;
        String str = null;
        String str2 = null;
        zzml[] zzmlArr = null;
        zzmi[] zzmiArr = null;
        String[] strArr = null;
        zzmd[] zzmdArr = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    zzmk = (zzmk) SafeParcelReader.createParcelable(parcel, readHeader, zzmk.CREATOR);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    zzmlArr = (zzml[]) SafeParcelReader.createTypedArray(parcel, readHeader, zzml.CREATOR);
                    break;
                case 5:
                    zzmiArr = (zzmi[]) SafeParcelReader.createTypedArray(parcel, readHeader, zzmi.CREATOR);
                    break;
                case 6:
                    strArr = SafeParcelReader.createStringArray(parcel, readHeader);
                    break;
                case 7:
                    zzmdArr = (zzmd[]) SafeParcelReader.createTypedArray(parcel, readHeader, zzmd.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzmg(zzmk, str, str2, zzmlArr, zzmiArr, strArr, zzmdArr);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new zzmg[i];
    }
}
