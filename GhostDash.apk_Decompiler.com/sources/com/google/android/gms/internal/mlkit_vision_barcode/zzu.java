package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final class zzu implements Parcelable.Creator<zzh> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzl zzl = null;
        String str = null;
        String str2 = null;
        zzm[] zzmArr = null;
        zzj[] zzjArr = null;
        String[] strArr = null;
        zze[] zzeArr = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    zzl = (zzl) SafeParcelReader.createParcelable(parcel, readHeader, zzl.CREATOR);
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    zzmArr = (zzm[]) SafeParcelReader.createTypedArray(parcel, readHeader, zzm.CREATOR);
                    break;
                case 6:
                    zzjArr = (zzj[]) SafeParcelReader.createTypedArray(parcel, readHeader, zzj.CREATOR);
                    break;
                case 7:
                    strArr = SafeParcelReader.createStringArray(parcel, readHeader);
                    break;
                case 8:
                    zzeArr = (zze[]) SafeParcelReader.createTypedArray(parcel, readHeader, zze.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzh(zzl, str, str2, zzmArr, zzjArr, strArr, zzeArr);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new zzh[i];
    }
}
