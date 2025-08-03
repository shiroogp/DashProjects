package com.google.android.gms.internal.mlkit_vision_face;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final class zzg implements Parcelable.Creator<zzf> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzn[] zznArr = null;
        zzd[] zzdArr = null;
        int i = 0;
        int i2 = 0;
        float f = Float.MAX_VALUE;
        float f2 = Float.MAX_VALUE;
        float f3 = Float.MAX_VALUE;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = -1.0f;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 2:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 3:
                    f4 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 4:
                    f5 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 5:
                    f6 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 6:
                    f7 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 7:
                    f = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 8:
                    f2 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 9:
                    zznArr = (zzn[]) SafeParcelReader.createTypedArray(parcel2, readHeader, zzn.CREATOR);
                    break;
                case 10:
                    f8 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 11:
                    f9 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 12:
                    f10 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 13:
                    zzdArr = (zzd[]) SafeParcelReader.createTypedArray(parcel2, readHeader, zzd.CREATOR);
                    break;
                case 14:
                    f3 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 15:
                    f11 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzf(i, i2, f4, f5, f6, f7, f, f2, f3, zznArr, f8, f9, f10, zzdArr, f11);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new zzf[i];
    }
}
