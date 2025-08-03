package com.drew.metadata.icc;

import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.drew.lang.ByteArrayReader;
import com.drew.metadata.TagDescriptor;
import java.io.IOException;

public class IccDescriptor extends TagDescriptor<IccDirectory> {
    private static final int ICC_TAG_TYPE_CURV = 1668641398;
    private static final int ICC_TAG_TYPE_DESC = 1684370275;
    private static final int ICC_TAG_TYPE_MEAS = 1835360627;
    private static final int ICC_TAG_TYPE_MLUC = 1835824483;
    private static final int ICC_TAG_TYPE_SIG = 1936287520;
    private static final int ICC_TAG_TYPE_TEXT = 1952807028;
    private static final int ICC_TAG_TYPE_XYZ_ARRAY = 1482250784;

    public IccDescriptor(IccDirectory iccDirectory) {
        super(iccDirectory);
    }

    public String getDescription(int i) {
        if (i == 8) {
            return getProfileVersionDescription();
        }
        if (i == 12) {
            return getProfileClassDescription();
        }
        if (i == 40) {
            return getPlatformDescription();
        }
        if (i == 64) {
            return getRenderingIntentDescription();
        }
        if (i <= 538976288 || i >= 2054847098) {
            return super.getDescription(i);
        }
        return getTagDataString(i);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:13|14|15) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:20|21|22|23|24|80|25) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004b, code lost:
        return new java.lang.String(r2, 8, (r2.length - 8) - 1);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0043 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0082 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x0082=Splitter:B:23:0x0082, B:13:0x0043=Splitter:B:13:0x0043} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getTagDataString(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            com.drew.metadata.Directory r2 = r0._directory     // Catch:{ IOException -> 0x0216 }
            com.drew.metadata.icc.IccDirectory r2 = (com.drew.metadata.icc.IccDirectory) r2     // Catch:{ IOException -> 0x0216 }
            byte[] r2 = r2.getByteArray(r1)     // Catch:{ IOException -> 0x0216 }
            if (r2 != 0) goto L_0x0017
            com.drew.metadata.Directory r2 = r0._directory     // Catch:{ IOException -> 0x0216 }
            com.drew.metadata.icc.IccDirectory r2 = (com.drew.metadata.icc.IccDirectory) r2     // Catch:{ IOException -> 0x0216 }
            java.lang.String r1 = r2.getString(r1)     // Catch:{ IOException -> 0x0216 }
            return r1
        L_0x0017:
            com.drew.lang.ByteArrayReader r1 = new com.drew.lang.ByteArrayReader     // Catch:{ IOException -> 0x0216 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0216 }
            r3 = 0
            int r4 = r1.getInt32(r3)     // Catch:{ IOException -> 0x0216 }
            java.lang.String r5 = ")"
            java.lang.String r6 = "("
            r7 = 7
            r8 = 16
            r9 = 3
            java.lang.String r10 = ", "
            r11 = 2
            r12 = 12
            r13 = 1
            r14 = 8
            switch(r4) {
                case 1482250784: goto L_0x019f;
                case 1668641398: goto L_0x0170;
                case 1684370275: goto L_0x0165;
                case 1835360627: goto L_0x00a4;
                case 1835824483: goto L_0x0055;
                case 1936287520: goto L_0x004c;
                case 1952807028: goto L_0x0038;
                default: goto L_0x0034;
            }
        L_0x0034:
            java.lang.String r1 = "%s (0x%08X): %d bytes"
            goto L_0x01fc
        L_0x0038:
            java.lang.String r1 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0043 }
            int r3 = r2.length     // Catch:{ UnsupportedEncodingException -> 0x0043 }
            int r3 = r3 - r14
            int r3 = r3 - r13
            java.lang.String r4 = "ASCII"
            r1.<init>(r2, r14, r3, r4)     // Catch:{ UnsupportedEncodingException -> 0x0043 }
            return r1
        L_0x0043:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x0216 }
            int r3 = r2.length     // Catch:{ IOException -> 0x0216 }
            int r3 = r3 - r14
            int r3 = r3 - r13
            r1.<init>(r2, r14, r3)     // Catch:{ IOException -> 0x0216 }
            return r1
        L_0x004c:
            int r1 = r1.getInt32(r14)     // Catch:{ IOException -> 0x0216 }
            java.lang.String r1 = com.drew.metadata.icc.IccReader.getStringFromInt32(r1)     // Catch:{ IOException -> 0x0216 }
            return r1
        L_0x0055:
            int r4 = r1.getInt32(r14)     // Catch:{ IOException -> 0x0216 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0216 }
            r7.<init>()     // Catch:{ IOException -> 0x0216 }
            r7.append(r4)     // Catch:{ IOException -> 0x0216 }
        L_0x0061:
            if (r3 >= r4) goto L_0x009f
            int r9 = r3 * 12
            int r9 = r9 + r8
            int r10 = r1.getInt32(r9)     // Catch:{ IOException -> 0x0216 }
            java.lang.String r10 = com.drew.metadata.icc.IccReader.getStringFromInt32(r10)     // Catch:{ IOException -> 0x0216 }
            int r11 = r9 + 4
            int r11 = r1.getInt32(r11)     // Catch:{ IOException -> 0x0216 }
            int r9 = r9 + 8
            int r9 = r1.getInt32(r9)     // Catch:{ IOException -> 0x0216 }
            java.lang.String r12 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0082 }
            java.lang.String r13 = "UTF-16BE"
            r12.<init>(r2, r9, r11, r13)     // Catch:{ UnsupportedEncodingException -> 0x0082 }
            goto L_0x0087
        L_0x0082:
            java.lang.String r12 = new java.lang.String     // Catch:{ IOException -> 0x0216 }
            r12.<init>(r2, r9, r11)     // Catch:{ IOException -> 0x0216 }
        L_0x0087:
            java.lang.String r9 = " "
            java.lang.StringBuilder r9 = r7.append(r9)     // Catch:{ IOException -> 0x0216 }
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ IOException -> 0x0216 }
            java.lang.StringBuilder r9 = r9.append(r6)     // Catch:{ IOException -> 0x0216 }
            java.lang.StringBuilder r9 = r9.append(r12)     // Catch:{ IOException -> 0x0216 }
            r9.append(r5)     // Catch:{ IOException -> 0x0216 }
            int r3 = r3 + 1
            goto L_0x0061
        L_0x009f:
            java.lang.String r1 = r7.toString()     // Catch:{ IOException -> 0x0216 }
            return r1
        L_0x00a4:
            int r2 = r1.getInt32(r14)     // Catch:{ IOException -> 0x0216 }
            float r4 = r1.getS15Fixed16(r12)     // Catch:{ IOException -> 0x0216 }
            float r5 = r1.getS15Fixed16(r8)     // Catch:{ IOException -> 0x0216 }
            r6 = 20
            float r6 = r1.getS15Fixed16(r6)     // Catch:{ IOException -> 0x0216 }
            r8 = 24
            int r8 = r1.getInt32(r8)     // Catch:{ IOException -> 0x0216 }
            r10 = 28
            float r10 = r1.getS15Fixed16(r10)     // Catch:{ IOException -> 0x0216 }
            r12 = 32
            int r1 = r1.getInt32(r12)     // Catch:{ IOException -> 0x0216 }
            java.lang.String r12 = "Unknown"
            java.lang.String r14 = "Unknown %d"
            if (r2 == 0) goto L_0x00e5
            if (r2 == r13) goto L_0x00e2
            if (r2 == r11) goto L_0x00df
            java.lang.Object[] r15 = new java.lang.Object[r13]     // Catch:{ IOException -> 0x0216 }
            java.lang.Integer r16 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x0216 }
            r15[r3] = r16     // Catch:{ IOException -> 0x0216 }
            java.lang.String r15 = java.lang.String.format(r14, r15)     // Catch:{ IOException -> 0x0216 }
            goto L_0x00e6
        L_0x00df:
            java.lang.String r15 = "1964 10°"
            goto L_0x00e6
        L_0x00e2:
            java.lang.String r15 = "1931 2°"
            goto L_0x00e6
        L_0x00e5:
            r15 = r12
        L_0x00e6:
            if (r8 == 0) goto L_0x00fe
            if (r8 == r13) goto L_0x00fc
            if (r8 == r11) goto L_0x00f9
            java.lang.Object[] r8 = new java.lang.Object[r13]     // Catch:{ IOException -> 0x0216 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x0216 }
            r8[r3] = r2     // Catch:{ IOException -> 0x0216 }
            java.lang.String r12 = java.lang.String.format(r14, r8)     // Catch:{ IOException -> 0x0216 }
            goto L_0x00fe
        L_0x00f9:
            java.lang.String r12 = "0/d or d/0"
            goto L_0x00fe
        L_0x00fc:
            java.lang.String r12 = "0/45 or 45/0"
        L_0x00fe:
            switch(r1) {
                case 0: goto L_0x011a;
                case 1: goto L_0x0117;
                case 2: goto L_0x0114;
                case 3: goto L_0x0111;
                case 4: goto L_0x010e;
                case 5: goto L_0x010b;
                case 6: goto L_0x0108;
                case 7: goto L_0x0105;
                case 8: goto L_0x0102;
                default: goto L_0x0101;
            }     // Catch:{ IOException -> 0x0216 }
        L_0x0101:
            goto L_0x011e
        L_0x0102:
            java.lang.String r1 = "F8"
            goto L_0x012a
        L_0x0105:
            java.lang.String r1 = "Equi-Power (E)"
            goto L_0x012a
        L_0x0108:
            java.lang.String r1 = "A"
            goto L_0x012a
        L_0x010b:
            java.lang.String r1 = "D55"
            goto L_0x012a
        L_0x010e:
            java.lang.String r1 = "F2"
            goto L_0x012a
        L_0x0111:
            java.lang.String r1 = "D93"
            goto L_0x012a
        L_0x0114:
            java.lang.String r1 = "D65"
            goto L_0x012a
        L_0x0117:
            java.lang.String r1 = "D50"
            goto L_0x012a
        L_0x011a:
            java.lang.String r1 = "unknown"
            goto L_0x012a
        L_0x011e:
            java.lang.Object[] r2 = new java.lang.Object[r13]     // Catch:{ IOException -> 0x0216 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ IOException -> 0x0216 }
            r2[r3] = r1     // Catch:{ IOException -> 0x0216 }
            java.lang.String r1 = java.lang.String.format(r14, r2)     // Catch:{ IOException -> 0x0216 }
        L_0x012a:
            java.text.DecimalFormat r2 = new java.text.DecimalFormat     // Catch:{ IOException -> 0x0216 }
            java.lang.String r8 = "0.###"
            r2.<init>(r8)     // Catch:{ IOException -> 0x0216 }
            java.lang.String r8 = "%s Observer, Backing (%s, %s, %s), Geometry %s, Flare %d%%, Illuminant %s"
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ IOException -> 0x0216 }
            r7[r3] = r15     // Catch:{ IOException -> 0x0216 }
            double r3 = (double) r4     // Catch:{ IOException -> 0x0216 }
            java.lang.String r3 = r2.format(r3)     // Catch:{ IOException -> 0x0216 }
            r7[r13] = r3     // Catch:{ IOException -> 0x0216 }
            double r3 = (double) r5     // Catch:{ IOException -> 0x0216 }
            java.lang.String r3 = r2.format(r3)     // Catch:{ IOException -> 0x0216 }
            r7[r11] = r3     // Catch:{ IOException -> 0x0216 }
            double r3 = (double) r6     // Catch:{ IOException -> 0x0216 }
            java.lang.String r2 = r2.format(r3)     // Catch:{ IOException -> 0x0216 }
            r7[r9] = r2     // Catch:{ IOException -> 0x0216 }
            r2 = 4
            r7[r2] = r12     // Catch:{ IOException -> 0x0216 }
            r2 = 5
            r3 = 1120403456(0x42c80000, float:100.0)
            float r10 = r10 * r3
            int r3 = java.lang.Math.round(r10)     // Catch:{ IOException -> 0x0216 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IOException -> 0x0216 }
            r7[r2] = r3     // Catch:{ IOException -> 0x0216 }
            r2 = 6
            r7[r2] = r1     // Catch:{ IOException -> 0x0216 }
            java.lang.String r1 = java.lang.String.format(r8, r7)     // Catch:{ IOException -> 0x0216 }
            return r1
        L_0x0165:
            int r1 = r1.getInt32(r14)     // Catch:{ IOException -> 0x0216 }
            java.lang.String r3 = new java.lang.String     // Catch:{ IOException -> 0x0216 }
            int r1 = r1 - r13
            r3.<init>(r2, r12, r1)     // Catch:{ IOException -> 0x0216 }
            return r3
        L_0x0170:
            int r2 = r1.getInt32(r14)     // Catch:{ IOException -> 0x0216 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0216 }
            r4.<init>()     // Catch:{ IOException -> 0x0216 }
            r5 = r3
        L_0x017a:
            if (r5 >= r2) goto L_0x019a
            if (r5 == 0) goto L_0x0181
            r4.append(r10)     // Catch:{ IOException -> 0x0216 }
        L_0x0181:
            int r6 = r5 * 2
            int r6 = r6 + r12
            int r6 = r1.getUInt16(r6)     // Catch:{ IOException -> 0x0216 }
            float r6 = (float) r6     // Catch:{ IOException -> 0x0216 }
            double r8 = (double) r6     // Catch:{ IOException -> 0x0216 }
            r13 = 4679239875398991872(0x40efffe000000000, double:65535.0)
            double r8 = r8 / r13
            java.lang.String r6 = formatDoubleAsString(r8, r7, r3)     // Catch:{ IOException -> 0x0216 }
            r4.append(r6)     // Catch:{ IOException -> 0x0216 }
            int r5 = r5 + 1
            goto L_0x017a
        L_0x019a:
            java.lang.String r1 = r4.toString()     // Catch:{ IOException -> 0x0216 }
            return r1
        L_0x019f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0216 }
            r4.<init>()     // Catch:{ IOException -> 0x0216 }
            java.text.DecimalFormat r7 = new java.text.DecimalFormat     // Catch:{ IOException -> 0x0216 }
            java.lang.String r8 = "0.####"
            r7.<init>(r8)     // Catch:{ IOException -> 0x0216 }
            int r2 = r2.length     // Catch:{ IOException -> 0x0216 }
            int r2 = r2 - r14
            int r2 = r2 / r12
        L_0x01ae:
            if (r3 >= r2) goto L_0x01f7
            int r8 = r3 * 12
            int r8 = r8 + r14
            float r9 = r1.getS15Fixed16(r8)     // Catch:{ IOException -> 0x0216 }
            int r11 = r8 + 4
            float r11 = r1.getS15Fixed16(r11)     // Catch:{ IOException -> 0x0216 }
            int r8 = r8 + 8
            float r8 = r1.getS15Fixed16(r8)     // Catch:{ IOException -> 0x0216 }
            if (r3 <= 0) goto L_0x01c8
            r4.append(r10)     // Catch:{ IOException -> 0x0216 }
        L_0x01c8:
            java.lang.StringBuilder r12 = r4.append(r6)     // Catch:{ IOException -> 0x0216 }
            double r14 = (double) r9     // Catch:{ IOException -> 0x0216 }
            java.lang.String r9 = r7.format(r14)     // Catch:{ IOException -> 0x0216 }
            java.lang.StringBuilder r9 = r12.append(r9)     // Catch:{ IOException -> 0x0216 }
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ IOException -> 0x0216 }
            double r11 = (double) r11     // Catch:{ IOException -> 0x0216 }
            java.lang.String r11 = r7.format(r11)     // Catch:{ IOException -> 0x0216 }
            java.lang.StringBuilder r9 = r9.append(r11)     // Catch:{ IOException -> 0x0216 }
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ IOException -> 0x0216 }
            double r11 = (double) r8     // Catch:{ IOException -> 0x0216 }
            java.lang.String r8 = r7.format(r11)     // Catch:{ IOException -> 0x0216 }
            java.lang.StringBuilder r8 = r9.append(r8)     // Catch:{ IOException -> 0x0216 }
            r8.append(r5)     // Catch:{ IOException -> 0x0216 }
            int r3 = r3 + 1
            r14 = 8
            goto L_0x01ae
        L_0x01f7:
            java.lang.String r1 = r4.toString()     // Catch:{ IOException -> 0x0216 }
            return r1
        L_0x01fc:
            java.lang.Object[] r5 = new java.lang.Object[r9]     // Catch:{ IOException -> 0x0216 }
            java.lang.String r6 = com.drew.metadata.icc.IccReader.getStringFromInt32(r4)     // Catch:{ IOException -> 0x0216 }
            r5[r3] = r6     // Catch:{ IOException -> 0x0216 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ IOException -> 0x0216 }
            r5[r13] = r3     // Catch:{ IOException -> 0x0216 }
            int r2 = r2.length     // Catch:{ IOException -> 0x0216 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x0216 }
            r5[r11] = r2     // Catch:{ IOException -> 0x0216 }
            java.lang.String r1 = java.lang.String.format(r1, r5)     // Catch:{ IOException -> 0x0216 }
            return r1
        L_0x0216:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.drew.metadata.icc.IccDescriptor.getTagDataString(int):java.lang.String");
    }

    public static String formatDoubleAsString(double d, int i, boolean z) {
        double d2 = d;
        int i2 = i;
        String str = "";
        boolean z2 = true;
        if (i2 < 1) {
            return str + Math.round(d);
        }
        long abs = Math.abs((long) d2);
        long round = (long) ((int) Math.round((Math.abs(d) - ((double) abs)) * Math.pow(10.0d, (double) i2)));
        String str2 = str;
        long j = round;
        while (i2 > 0) {
            byte abs2 = (byte) ((int) Math.abs(j % 10));
            j /= 10;
            if (str2.length() > 0 || z || abs2 != 0 || i2 == 1) {
                str2 = abs2 + str2;
            }
            i2--;
        }
        long j2 = abs + j;
        if (d2 >= 0.0d || (j2 == 0 && round == 0)) {
            z2 = false;
        }
        StringBuilder sb = new StringBuilder();
        if (z2) {
            str = "-";
        }
        return sb.append(str).append(j2).append(".").append(str2).toString();
    }

    private String getRenderingIntentDescription() {
        return getIndexedDescription(64, "Perceptual", "Media-Relative Colorimetric", ExifInterface.TAG_SATURATION, "ICC-Absolute Colorimetric");
    }

    private String getPlatformDescription() {
        String string = ((IccDirectory) this._directory).getString(40);
        if (string == null) {
            return null;
        }
        try {
            switch (getInt32FromString(string)) {
                case 1095782476:
                    return "Apple Computer, Inc.";
                case 1297303124:
                    return "Microsoft Corporation";
                case 1397180704:
                    return "Silicon Graphics, Inc.";
                case 1398099543:
                    return "Sun Microsystems, Inc.";
                case 1413959252:
                    return "Taligent, Inc.";
                default:
                    return String.format("Unknown (%s)", new Object[]{string});
            }
        } catch (IOException unused) {
            return string;
        }
    }

    private String getProfileClassDescription() {
        String string = ((IccDirectory) this._directory).getString(12);
        if (string == null) {
            return null;
        }
        try {
            switch (getInt32FromString(string)) {
                case 1633842036:
                    return "Abstract";
                case 1818848875:
                    return "DeviceLink";
                case 1835955314:
                    return "Display Device";
                case 1852662636:
                    return "Named Color";
                case 1886549106:
                    return "Output Device";
                case 1935896178:
                    return "Input Device";
                case 1936744803:
                    return "ColorSpace Conversion";
                default:
                    return String.format("Unknown (%s)", new Object[]{string});
            }
        } catch (IOException unused) {
            return string;
        }
    }

    private String getProfileVersionDescription() {
        Integer integer = ((IccDirectory) this._directory).getInteger(8);
        if (integer == null) {
            return null;
        }
        return String.format("%d.%d.%d", new Object[]{Integer.valueOf((integer.intValue() & ViewCompat.MEASURED_STATE_MASK) >> 24), Integer.valueOf((integer.intValue() & 15728640) >> 20), Integer.valueOf((integer.intValue() & 983040) >> 16)});
    }

    private static int getInt32FromString(String str) throws IOException {
        return new ByteArrayReader(str.getBytes()).getInt32(0);
    }
}
