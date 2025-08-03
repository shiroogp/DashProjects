package com.drew.metadata.photoshop;

import com.bumptech.glide.load.Key;
import com.drew.lang.ByteArrayReader;
import com.drew.lang.Charsets;
import com.drew.metadata.TagDescriptor;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.text.Typography;

public class PhotoshopDescriptor extends TagDescriptor<PhotoshopDirectory> {
    public PhotoshopDescriptor(PhotoshopDirectory photoshopDirectory) {
        super(photoshopDirectory);
    }

    public String getDescription(int i) {
        if (i != 1002) {
            if (i == 1005) {
                return getResolutionInfoDescription();
            }
            if (i == 1028) {
                return getBinaryDataString(i);
            }
            if (i == 1030) {
                return getJpegQualityString();
            }
            if (!(i == 1044 || i == 1054)) {
                if (i == 1057) {
                    return getVersionDescription();
                }
                if (i == 1062) {
                    return getPrintScaleDescription();
                }
                if (i == 1064) {
                    return getPixelAspectRatioString();
                }
                if (i == 2999) {
                    return getClippingPathNameString(i);
                }
                if (i != 1049) {
                    if (i == 1050) {
                        return getSlicesDescription();
                    }
                    switch (i) {
                        case PhotoshopDirectory.TAG_THUMBNAIL_OLD /*1033*/:
                        case PhotoshopDirectory.TAG_THUMBNAIL /*1036*/:
                            return getThumbnailDescription(i);
                        case PhotoshopDirectory.TAG_COPYRIGHT /*1034*/:
                            return getBooleanString(i);
                        case PhotoshopDirectory.TAG_URL /*1035*/:
                            break;
                        case 1037:
                            break;
                        default:
                            if (i < 2000 || i > 2998) {
                                return super.getDescription(i);
                            }
                            return getPathString(i);
                    }
                }
            }
            return get32BitNumberString(i);
        }
        return getSimpleString(i);
    }

    public String getJpegQualityString() {
        String str;
        try {
            byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(1030);
            if (byteArray == null) {
                return ((PhotoshopDirectory) this._directory).getString(1030);
            }
            ByteArrayReader byteArrayReader = new ByteArrayReader(byteArray);
            int uInt16 = byteArrayReader.getUInt16(0);
            int uInt162 = byteArrayReader.getUInt16(2);
            int uInt163 = byteArrayReader.getUInt16(4);
            int i = (uInt16 > 65535 || uInt16 < 65533) ? uInt16 <= 8 ? uInt16 + 4 : uInt16 : uInt16 - 65532;
            switch (uInt16) {
                case 0:
                    str = "Low";
                    break;
                case 1:
                case 2:
                case 3:
                    str = "Medium";
                    break;
                case 4:
                case 5:
                    str = "High";
                    break;
                case 6:
                case 7:
                case 8:
                    str = "Maximum";
                    break;
                default:
                    switch (uInt16) {
                        case 65533:
                        case 65534:
                        case 65535:
                            break;
                        default:
                            str = "Unknown";
                            break;
                    }
                    str = "Low";
                    break;
            }
            return String.format("%d (%s), %s format, %s scans", new Object[]{Integer.valueOf(i), str, uInt162 != 0 ? uInt162 != 1 ? uInt162 != 257 ? String.format("Unknown 0x%04X", new Object[]{Integer.valueOf(uInt162)}) : "Progressive" : "Optimised" : "Standard", (uInt163 < 1 || uInt163 > 3) ? String.format("Unknown 0x%04X", new Object[]{Integer.valueOf(uInt163)}) : String.format("%d", new Object[]{Integer.valueOf(uInt163 + 2)})});
        } catch (IOException unused) {
            return null;
        }
    }

    public String getPixelAspectRatioString() {
        try {
            byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(PhotoshopDirectory.TAG_PIXEL_ASPECT_RATIO);
            if (byteArray == null) {
                return null;
            }
            return Double.toString(new ByteArrayReader(byteArray).getDouble64(4));
        } catch (Exception unused) {
            return null;
        }
    }

    public String getPrintScaleDescription() {
        try {
            byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(PhotoshopDirectory.TAG_PRINT_SCALE);
            if (byteArray == null) {
                return null;
            }
            ByteArrayReader byteArrayReader = new ByteArrayReader(byteArray);
            int int32 = byteArrayReader.getInt32(0);
            float float32 = byteArrayReader.getFloat32(2);
            float float322 = byteArrayReader.getFloat32(6);
            float float323 = byteArrayReader.getFloat32(10);
            if (int32 == 0) {
                return "Centered, Scale " + float323;
            }
            if (int32 == 1) {
                return "Size to fit";
            }
            if (int32 != 2) {
                return String.format("Unknown %04X, X:%s Y:%s, Scale:%s", new Object[]{Integer.valueOf(int32), Float.valueOf(float32), Float.valueOf(float322), Float.valueOf(float323)});
            }
            return String.format("User defined, X:%s Y:%s, Scale:%s", new Object[]{Float.valueOf(float32), Float.valueOf(float322), Float.valueOf(float323)});
        } catch (Exception unused) {
            return null;
        }
    }

    public String getResolutionInfoDescription() {
        try {
            byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(PhotoshopDirectory.TAG_RESOLUTION_INFO);
            if (byteArray == null) {
                return null;
            }
            ByteArrayReader byteArrayReader = new ByteArrayReader(byteArray);
            float s15Fixed16 = byteArrayReader.getS15Fixed16(0);
            float s15Fixed162 = byteArrayReader.getS15Fixed16(8);
            DecimalFormat decimalFormat = new DecimalFormat("0.##");
            return decimalFormat.format((double) s15Fixed16) + "x" + decimalFormat.format((double) s15Fixed162) + " DPI";
        } catch (Exception unused) {
            return null;
        }
    }

    public String getVersionDescription() {
        try {
            byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(PhotoshopDirectory.TAG_VERSION);
            if (byteArray == null) {
                return null;
            }
            ByteArrayReader byteArrayReader = new ByteArrayReader(byteArray);
            int int32 = byteArrayReader.getInt32(0);
            int int322 = byteArrayReader.getInt32(5) * 2;
            String string = byteArrayReader.getString(9, int322, "UTF-16");
            int i = 9 + int322;
            int int323 = byteArrayReader.getInt32(i);
            int i2 = i + 4;
            int i3 = int323 * 2;
            return String.format("%d (%s, %s) %d", new Object[]{Integer.valueOf(int32), string, byteArrayReader.getString(i2, i3, "UTF-16"), Integer.valueOf(byteArrayReader.getInt32(i2 + i3))});
        } catch (IOException unused) {
            return null;
        }
    }

    public String getSlicesDescription() {
        try {
            byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(PhotoshopDirectory.TAG_SLICES);
            if (byteArray == null) {
                return null;
            }
            ByteArrayReader byteArrayReader = new ByteArrayReader(byteArray);
            int int32 = byteArrayReader.getInt32(20) * 2;
            return String.format("%s (%d,%d,%d,%d) %d Slices", new Object[]{byteArrayReader.getString(24, int32, "UTF-16"), Integer.valueOf(byteArrayReader.getInt32(4)), Integer.valueOf(byteArrayReader.getInt32(8)), Integer.valueOf(byteArrayReader.getInt32(12)), Integer.valueOf(byteArrayReader.getInt32(16)), Integer.valueOf(byteArrayReader.getInt32(int32 + 24))});
        } catch (IOException unused) {
            return null;
        }
    }

    public String getThumbnailDescription(int i) {
        try {
            byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(i);
            if (byteArray == null) {
                return null;
            }
            ByteArrayReader byteArrayReader = new ByteArrayReader(byteArray);
            int int32 = byteArrayReader.getInt32(0);
            int int322 = byteArrayReader.getInt32(4);
            int int323 = byteArrayReader.getInt32(8);
            int int324 = byteArrayReader.getInt32(16);
            int int325 = byteArrayReader.getInt32(20);
            int int326 = byteArrayReader.getInt32(24);
            Object[] objArr = new Object[6];
            objArr[0] = int32 == 1 ? "JpegRGB" : "RawRGB";
            objArr[1] = Integer.valueOf(int322);
            objArr[2] = Integer.valueOf(int323);
            objArr[3] = Integer.valueOf(int324);
            objArr[4] = Integer.valueOf(int326);
            objArr[5] = Integer.valueOf(int325);
            return String.format("%s, %dx%d, Decomp %d bytes, %d bpp, %d bytes", objArr);
        } catch (IOException unused) {
            return null;
        }
    }

    private String getBooleanString(int i) {
        byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(i);
        if (byteArray == null || byteArray.length == 0) {
            return null;
        }
        return byteArray[0] == 0 ? "No" : "Yes";
    }

    private String get32BitNumberString(int i) {
        byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(i);
        if (byteArray == null) {
            return null;
        }
        try {
            return String.format("%d", new Object[]{Integer.valueOf(new ByteArrayReader(byteArray).getInt32(0))});
        } catch (IOException unused) {
            return null;
        }
    }

    private String getSimpleString(int i) {
        byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(i);
        if (byteArray == null) {
            return null;
        }
        return new String(byteArray);
    }

    private String getBinaryDataString(int i) {
        byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(i);
        if (byteArray == null) {
            return null;
        }
        return String.format("%d bytes binary data", new Object[]{Integer.valueOf(byteArray.length)});
    }

    public String getClippingPathNameString(int i) {
        try {
            byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(i);
            if (byteArray == null) {
                return null;
            }
            ByteArrayReader byteArrayReader = new ByteArrayReader(byteArray);
            return new String(byteArrayReader.getBytes(1, byteArrayReader.getByte(0)), Key.STRING_CHARSET_NAME);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getPathString(int i) {
        String str;
        String str2;
        int i2;
        int i3;
        Subpath subpath;
        ByteArrayReader byteArrayReader;
        short s;
        Knot knot;
        String str3;
        String str4;
        int i4;
        Subpath subpath2;
        ByteArrayReader byteArrayReader2;
        Knot knot2;
        String str5 = ")";
        String str6 = ",";
        try {
            byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(i);
            if (byteArray == null) {
                return null;
            }
            ByteArrayReader byteArrayReader3 = new ByteArrayReader(byteArray);
            short s2 = 1;
            int length = ((int) ((byteArrayReader3.getLength() - ((long) byteArrayReader3.getByte(((int) byteArrayReader3.getLength()) - 1))) - 1)) / 26;
            Subpath subpath3 = new Subpath();
            Subpath subpath4 = new Subpath();
            ArrayList arrayList = new ArrayList();
            String str7 = null;
            int i5 = 0;
            while (i5 < length) {
                int i6 = i5 * 26;
                try {
                    short int16 = byteArrayReader3.getInt16(i6);
                    if (int16 != 0) {
                        i2 = i5;
                        if (int16 == s2) {
                            str3 = str5;
                            str4 = str6;
                            i4 = length;
                            byteArrayReader = byteArrayReader3;
                            subpath = subpath3;
                            s = s2;
                        } else if (int16 != 2) {
                            if (int16 != 3) {
                                short s3 = 4;
                                if (int16 != 4) {
                                    if (int16 != 5) {
                                        if (int16 == 8) {
                                            str7 = byteArrayReader3.getInt16(i6 + 2) == 1 ? "with all pixels" : "without all pixels";
                                        }
                                        str2 = str5;
                                        str = str6;
                                        i3 = length;
                                    } else {
                                        s3 = 4;
                                    }
                                }
                                if (int16 == s3) {
                                    knot2 = new Knot("Linked");
                                } else {
                                    knot2 = new Knot("Unlinked");
                                }
                                int i7 = 0;
                                while (i7 < 6) {
                                    int i8 = i7 * 4;
                                    knot2.setPoint(i7, ((double) byteArrayReader3.getInt8(i8 + 2 + i6)) + (((double) byteArrayReader3.getInt24((i8 + 3) + i6)) / Math.pow(2.0d, 24.0d)));
                                    i7++;
                                    length = length;
                                    str5 = str5;
                                    str6 = str6;
                                    byteArrayReader3 = byteArrayReader3;
                                    subpath3 = subpath3;
                                }
                                str2 = str5;
                                str = str6;
                                i3 = length;
                                byteArrayReader2 = byteArrayReader3;
                                subpath2 = subpath3;
                                subpath4.add(knot2);
                            } else {
                                str2 = str5;
                                str = str6;
                                i3 = length;
                                byteArrayReader2 = byteArrayReader3;
                                subpath2 = subpath3;
                                if (subpath4.size() != 0) {
                                    arrayList.add(subpath4);
                                }
                                subpath4 = new Subpath("Open Subpath");
                            }
                            byteArrayReader3 = byteArrayReader2;
                            subpath3 = subpath2;
                        } else {
                            str3 = str5;
                            str4 = str6;
                            i4 = length;
                            byteArrayReader = byteArrayReader3;
                            subpath = subpath3;
                            s = 1;
                        }
                        if (int16 == s) {
                            knot = new Knot("Linked");
                        } else {
                            knot = new Knot("Unlinked");
                        }
                        int i9 = 0;
                        while (i9 < 6) {
                            int i10 = i9 * 4;
                            ByteArrayReader byteArrayReader4 = byteArrayReader;
                            knot.setPoint(i9, ((double) byteArrayReader4.getInt8(i10 + 2 + i6)) + (((double) byteArrayReader4.getInt24((i10 + 3) + i6)) / Math.pow(2.0d, 24.0d)));
                            i9++;
                            i6 = i6;
                            byteArrayReader = byteArrayReader4;
                        }
                        byteArrayReader3 = byteArrayReader;
                        subpath3 = subpath;
                        subpath3.add(knot);
                    } else {
                        str2 = str5;
                        str = str6;
                        i3 = length;
                        i2 = i5;
                        if (subpath3.size() != 0) {
                            arrayList.add(subpath3);
                        }
                        subpath3 = new Subpath("Closed Subpath");
                    }
                    i5 = i2 + 1;
                    length = i3;
                    str5 = str2;
                    str6 = str;
                    s2 = 1;
                } catch (Exception unused) {
                    return null;
                }
            }
            String str8 = str5;
            String str9 = str6;
            if (subpath3.size() != 0) {
                arrayList.add(subpath3);
            }
            if (subpath4.size() != 0) {
                arrayList.add(subpath4);
            }
            byte b = byteArrayReader3.getByte(((int) byteArrayReader3.getLength()) - 1);
            String string = byteArrayReader3.getString((((int) byteArrayReader3.getLength()) - b) - 1, (int) b, Charsets.ASCII);
            StringBuilder sb = new StringBuilder();
            sb.append(Typography.quote).append(string).append(Typography.quote).append(" having ");
            if (str7 != null) {
                sb.append("initial fill rule \"").append(str7).append("\" and ");
            }
            sb.append(arrayList.size()).append(arrayList.size() == 1 ? " subpath:" : " subpaths:");
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Subpath subpath5 = (Subpath) it2.next();
                sb.append("\n- ").append(subpath5.getType()).append(" with ").append(arrayList.size()).append(arrayList.size() == 1 ? " knot:" : " knots:");
                for (Knot next : subpath5.getKnots()) {
                    sb.append("\n  - ").append(next.getType());
                    String str10 = str9;
                    String str11 = str8;
                    sb.append(" (").append(next.getPoint(0)).append(str10).append(next.getPoint(1)).append(str11);
                    sb.append(" (").append(next.getPoint(2)).append(str10).append(next.getPoint(3)).append(str11);
                    str9 = str10;
                    sb.append(" (").append(next.getPoint(4)).append(str10).append(next.getPoint(5)).append(str11);
                    str8 = str11;
                }
            }
            return sb.toString();
        } catch (Exception unused2) {
            return null;
        }
    }
}
