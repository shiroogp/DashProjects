package com.drew.imaging.tiff;

import com.drew.lang.RandomAccessReader;
import com.drew.lang.Rational;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashSet;

public class TiffReader {
    private static int calculateTagOffset(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    public void processTiff(RandomAccessReader randomAccessReader, TiffHandler tiffHandler, int i) throws TiffProcessingException, IOException {
        short int16 = randomAccessReader.getInt16(i);
        if (int16 == 19789) {
            randomAccessReader.setMotorolaByteOrder(true);
        } else if (int16 == 18761) {
            randomAccessReader.setMotorolaByteOrder(false);
        } else {
            throw new TiffProcessingException("Unclear distinction between Motorola/Intel byte ordering: " + int16);
        }
        int i2 = i + 2;
        tiffHandler.setTiffMarker(randomAccessReader.getUInt16(i2));
        int int32 = randomAccessReader.getInt32(i + 4) + i;
        if (((long) int32) >= randomAccessReader.getLength() - 1) {
            tiffHandler.warn("First IFD offset is beyond the end of the TIFF data segment -- trying default offset");
            int32 = i2 + 2 + 4;
        }
        processIfd(tiffHandler, randomAccessReader, new HashSet(), int32, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:128:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0127 A[SYNTHETIC, Splitter:B:70:0x0127] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void processIfd(com.drew.imaging.tiff.TiffHandler r29, com.drew.lang.RandomAccessReader r30, java.util.Set<java.lang.Integer> r31, int r32, int r33) throws java.io.IOException {
        /*
            r8 = r29
            r9 = r30
            r0 = r31
            r10 = r32
            r11 = r33
            r1 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r32)     // Catch:{ all -> 0x021b }
            boolean r2 = r0.contains(r2)     // Catch:{ all -> 0x021b }
            if (r2 == 0) goto L_0x0019
            r29.endingIFD()
            return
        L_0x0019:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r32)     // Catch:{ all -> 0x021b }
            r0.add(r2)     // Catch:{ all -> 0x021b }
            long r2 = (long) r10     // Catch:{ all -> 0x021b }
            long r4 = r30.getLength()     // Catch:{ all -> 0x021b }
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0212
            if (r10 >= 0) goto L_0x002d
            goto L_0x0212
        L_0x002d:
            int r2 = r9.getUInt16(r10)     // Catch:{ all -> 0x021b }
            r3 = 255(0xff, float:3.57E-43)
            if (r2 <= r3) goto L_0x004f
            r3 = r2 & 255(0xff, float:3.57E-43)
            if (r3 != 0) goto L_0x004f
            boolean r3 = r30.isMotorolaByteOrder()     // Catch:{ all -> 0x021b }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x021b }
            int r2 = r2 >> 8
            boolean r3 = r30.isMotorolaByteOrder()     // Catch:{ all -> 0x021b }
            if (r3 != 0) goto L_0x004b
            r3 = 1
            goto L_0x004c
        L_0x004b:
            r3 = 0
        L_0x004c:
            r9.setMotorolaByteOrder(r3)     // Catch:{ all -> 0x021b }
        L_0x004f:
            r14 = r1
            r15 = r2
            int r1 = r15 * 12
            r7 = 2
            int r1 = r1 + r7
            int r1 = r1 + 4
            int r1 = r1 + r10
            long r1 = (long) r1
            long r3 = r30.getLength()     // Catch:{ all -> 0x020c }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0077
            java.lang.String r0 = "Illegally sized IFD"
            r8.error(r0)     // Catch:{ all -> 0x0073 }
            r29.endingIFD()
            if (r14 == 0) goto L_0x0072
            boolean r0 = r14.booleanValue()
            r9.setMotorolaByteOrder(r0)
        L_0x0072:
            return
        L_0x0073:
            r0 = move-exception
            r1 = r14
            goto L_0x021c
        L_0x0077:
            r6 = 0
            r16 = 0
        L_0x007a:
            if (r6 >= r15) goto L_0x01c1
            int r1 = calculateTagOffset(r10, r6)     // Catch:{ all -> 0x020c }
            int r5 = r9.getUInt16(r1)     // Catch:{ all -> 0x020c }
            int r2 = r1 + 2
            int r4 = r9.getUInt16(r2)     // Catch:{ all -> 0x020c }
            com.drew.imaging.tiff.TiffDataFormat r2 = com.drew.imaging.tiff.TiffDataFormat.fromTiffFormatCode(r4)     // Catch:{ all -> 0x020c }
            int r3 = r1 + 4
            long r12 = r9.getUInt32(r3)     // Catch:{ all -> 0x020c }
            if (r2 != 0) goto L_0x00e3
            java.lang.Long r2 = r8.tryCustomProcessFormat(r5, r4, r12)     // Catch:{ all -> 0x0073 }
            if (r2 != 0) goto L_0x00da
            java.lang.String r1 = "Invalid TIFF tag format code %d for tag 0x%04X"
            java.lang.Object[] r2 = new java.lang.Object[r7]     // Catch:{ all -> 0x0073 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0073 }
            r18 = 0
            r2[r18] = r3     // Catch:{ all -> 0x0073 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0073 }
            r17 = 1
            r2[r17] = r3     // Catch:{ all -> 0x0073 }
            java.lang.String r1 = java.lang.String.format(r1, r2)     // Catch:{ all -> 0x0073 }
            r8.error(r1)     // Catch:{ all -> 0x0073 }
            int r1 = r16 + 1
            r2 = 5
            if (r1 <= r2) goto L_0x00ce
            java.lang.String r0 = "Stopping processing as too many errors seen in TIFF IFD"
            r8.error(r0)     // Catch:{ all -> 0x0073 }
            r29.endingIFD()
            if (r14 == 0) goto L_0x00cd
            boolean r0 = r14.booleanValue()
            r9.setMotorolaByteOrder(r0)
        L_0x00cd:
            return
        L_0x00ce:
            r16 = r1
            r19 = r6
            r22 = r7
            r25 = r14
            r21 = r15
            goto L_0x01b7
        L_0x00da:
            r17 = 1
            r18 = 0
            long r2 = r2.longValue()     // Catch:{ all -> 0x0073 }
            goto L_0x00ed
        L_0x00e3:
            r17 = 1
            r18 = 0
            int r2 = r2.getComponentSizeBytes()     // Catch:{ all -> 0x020c }
            long r2 = (long) r2
            long r2 = r2 * r12
        L_0x00ed:
            r19 = 4
            int r21 = (r2 > r19 ? 1 : (r2 == r19 ? 0 : -1))
            java.lang.String r7 = "Illegal TIFF tag pointer offset"
            if (r21 <= 0) goto L_0x011a
            int r1 = r1 + 8
            long r23 = r9.getUInt32(r1)     // Catch:{ all -> 0x020c }
            long r25 = r23 + r2
            long r27 = r30.getLength()     // Catch:{ all -> 0x020c }
            int r1 = (r25 > r27 ? 1 : (r25 == r27 ? 0 : -1))
            if (r1 <= 0) goto L_0x0112
            r8.error(r7)     // Catch:{ all -> 0x0073 }
            r19 = r6
            r25 = r14
            r21 = r15
        L_0x010e:
            r22 = 2
            goto L_0x01b7
        L_0x0112:
            r25 = r14
            r21 = r15
            long r14 = (long) r11
            long r14 = r14 + r23
            goto L_0x0121
        L_0x011a:
            r25 = r14
            r21 = r15
            int r1 = r1 + 8
            long r14 = (long) r1
        L_0x0121:
            r23 = 0
            int r1 = (r14 > r23 ? 1 : (r14 == r23 ? 0 : -1))
            if (r1 < 0) goto L_0x01b0
            long r26 = r30.getLength()     // Catch:{ all -> 0x020a }
            int r1 = (r14 > r26 ? 1 : (r14 == r26 ? 0 : -1))
            if (r1 <= 0) goto L_0x0131
            goto L_0x01b0
        L_0x0131:
            int r1 = (r2 > r23 ? 1 : (r2 == r23 ? 0 : -1))
            if (r1 < 0) goto L_0x0195
            long r23 = r14 + r2
            long r26 = r30.getLength()     // Catch:{ all -> 0x020a }
            int r1 = (r23 > r26 ? 1 : (r23 == r26 ? 0 : -1))
            if (r1 <= 0) goto L_0x0140
            goto L_0x0195
        L_0x0140:
            long r19 = r19 * r12
            int r1 = (r2 > r19 ? 1 : (r2 == r19 ? 0 : -1))
            r19 = r6
            if (r1 != 0) goto L_0x016c
            r1 = r18
            r20 = r1
        L_0x014c:
            long r6 = (long) r1     // Catch:{ all -> 0x020a }
            int r6 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r6 >= 0) goto L_0x0169
            boolean r6 = r8.tryEnterSubIfd(r5)     // Catch:{ all -> 0x020a }
            if (r6 == 0) goto L_0x0166
            int r6 = r1 * 4
            long r6 = (long) r6     // Catch:{ all -> 0x020a }
            long r6 = r6 + r14
            int r6 = (int) r6     // Catch:{ all -> 0x020a }
            int r6 = r9.getInt32(r6)     // Catch:{ all -> 0x020a }
            int r6 = r6 + r11
            processIfd(r8, r9, r0, r6, r11)     // Catch:{ all -> 0x020a }
            r20 = r17
        L_0x0166:
            int r1 = r1 + 1
            goto L_0x014c
        L_0x0169:
            r7 = r20
            goto L_0x016e
        L_0x016c:
            r7 = r18
        L_0x016e:
            if (r7 != 0) goto L_0x010e
            int r14 = (int) r14     // Catch:{ all -> 0x020a }
            int r7 = (int) r2     // Catch:{ all -> 0x020a }
            r1 = r29
            r2 = r14
            r3 = r31
            r15 = r4
            r4 = r33
            r20 = r5
            r5 = r30
            r6 = r20
            r22 = 2
            boolean r1 = r1.customProcessTag(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x020a }
            if (r1 != 0) goto L_0x01b7
            int r4 = (int) r12     // Catch:{ all -> 0x020a }
            r1 = r29
            r2 = r20
            r3 = r14
            r5 = r15
            r6 = r30
            processTag(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x020a }
            goto L_0x01b7
        L_0x0195:
            r19 = r6
            r22 = 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x020a }
            r1.<init>()     // Catch:{ all -> 0x020a }
            java.lang.String r4 = "Illegal number of bytes for TIFF tag data: "
            java.lang.StringBuilder r1 = r1.append(r4)     // Catch:{ all -> 0x020a }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x020a }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x020a }
            r8.error(r1)     // Catch:{ all -> 0x020a }
            goto L_0x01b7
        L_0x01b0:
            r19 = r6
            r22 = 2
            r8.error(r7)     // Catch:{ all -> 0x020a }
        L_0x01b7:
            int r6 = r19 + 1
            r15 = r21
            r7 = r22
            r14 = r25
            goto L_0x007a
        L_0x01c1:
            r25 = r14
            r2 = r15
            int r1 = calculateTagOffset(r10, r2)     // Catch:{ all -> 0x020a }
            int r1 = r9.getInt32(r1)     // Catch:{ all -> 0x020a }
            if (r1 == 0) goto L_0x01fd
            int r1 = r1 + r11
            long r2 = (long) r1     // Catch:{ all -> 0x020a }
            long r4 = r30.getLength()     // Catch:{ all -> 0x020a }
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x01e5
            r29.endingIFD()
            if (r25 == 0) goto L_0x01e4
            boolean r0 = r25.booleanValue()
            r9.setMotorolaByteOrder(r0)
        L_0x01e4:
            return
        L_0x01e5:
            if (r1 >= r10) goto L_0x01f4
            r29.endingIFD()
            if (r25 == 0) goto L_0x01f3
            boolean r0 = r25.booleanValue()
            r9.setMotorolaByteOrder(r0)
        L_0x01f3:
            return
        L_0x01f4:
            boolean r2 = r29.hasFollowerIfd()     // Catch:{ all -> 0x020a }
            if (r2 == 0) goto L_0x01fd
            processIfd(r8, r9, r0, r1, r11)     // Catch:{ all -> 0x020a }
        L_0x01fd:
            r29.endingIFD()
            if (r25 == 0) goto L_0x0209
            boolean r0 = r25.booleanValue()
            r9.setMotorolaByteOrder(r0)
        L_0x0209:
            return
        L_0x020a:
            r0 = move-exception
            goto L_0x020f
        L_0x020c:
            r0 = move-exception
            r25 = r14
        L_0x020f:
            r1 = r25
            goto L_0x021c
        L_0x0212:
            java.lang.String r0 = "Ignored IFD marked to start outside data segment"
            r8.error(r0)     // Catch:{ all -> 0x021b }
            r29.endingIFD()
            return
        L_0x021b:
            r0 = move-exception
        L_0x021c:
            r29.endingIFD()
            if (r1 == 0) goto L_0x0228
            boolean r1 = r1.booleanValue()
            r9.setMotorolaByteOrder(r1)
        L_0x0228:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.drew.imaging.tiff.TiffReader.processIfd(com.drew.imaging.tiff.TiffHandler, com.drew.lang.RandomAccessReader, java.util.Set, int, int):void");
    }

    private static void processTag(TiffHandler tiffHandler, int i, int i2, int i3, int i4, RandomAccessReader randomAccessReader) throws IOException {
        int i5 = 0;
        switch (i4) {
            case 1:
                if (i3 == 1) {
                    tiffHandler.setInt8u(i, randomAccessReader.getUInt8(i2));
                    return;
                }
                short[] sArr = new short[i3];
                while (i5 < i3) {
                    sArr[i5] = randomAccessReader.getUInt8(i2 + i5);
                    i5++;
                }
                tiffHandler.setInt8uArray(i, sArr);
                return;
            case 2:
                tiffHandler.setString(i, randomAccessReader.getNullTerminatedStringValue(i2, i3, (Charset) null));
                return;
            case 3:
                if (i3 == 1) {
                    tiffHandler.setInt16u(i, randomAccessReader.getUInt16(i2));
                    return;
                }
                int[] iArr = new int[i3];
                while (i5 < i3) {
                    iArr[i5] = randomAccessReader.getUInt16((i5 * 2) + i2);
                    i5++;
                }
                tiffHandler.setInt16uArray(i, iArr);
                return;
            case 4:
                if (i3 == 1) {
                    tiffHandler.setInt32u(i, randomAccessReader.getUInt32(i2));
                    return;
                }
                long[] jArr = new long[i3];
                while (i5 < i3) {
                    jArr[i5] = randomAccessReader.getUInt32((i5 * 4) + i2);
                    i5++;
                }
                tiffHandler.setInt32uArray(i, jArr);
                return;
            case 5:
                if (i3 == 1) {
                    tiffHandler.setRational(i, new Rational(randomAccessReader.getUInt32(i2), randomAccessReader.getUInt32(i2 + 4)));
                    return;
                } else if (i3 > 1) {
                    Rational[] rationalArr = new Rational[i3];
                    while (i5 < i3) {
                        int i6 = i5 * 8;
                        rationalArr[i5] = new Rational(randomAccessReader.getUInt32(i2 + i6), randomAccessReader.getUInt32(i2 + 4 + i6));
                        i5++;
                    }
                    tiffHandler.setRationalArray(i, rationalArr);
                    return;
                } else {
                    return;
                }
            case 6:
                if (i3 == 1) {
                    tiffHandler.setInt8s(i, randomAccessReader.getInt8(i2));
                    return;
                }
                byte[] bArr = new byte[i3];
                while (i5 < i3) {
                    bArr[i5] = randomAccessReader.getInt8(i2 + i5);
                    i5++;
                }
                tiffHandler.setInt8sArray(i, bArr);
                return;
            case 7:
                tiffHandler.setByteArray(i, randomAccessReader.getBytes(i2, i3));
                return;
            case 8:
                if (i3 == 1) {
                    tiffHandler.setInt16s(i, randomAccessReader.getInt16(i2));
                    return;
                }
                short[] sArr2 = new short[i3];
                while (i5 < i3) {
                    sArr2[i5] = randomAccessReader.getInt16((i5 * 2) + i2);
                    i5++;
                }
                tiffHandler.setInt16sArray(i, sArr2);
                return;
            case 9:
                if (i3 == 1) {
                    tiffHandler.setInt32s(i, randomAccessReader.getInt32(i2));
                    return;
                }
                int[] iArr2 = new int[i3];
                while (i5 < i3) {
                    iArr2[i5] = randomAccessReader.getInt32((i5 * 4) + i2);
                    i5++;
                }
                tiffHandler.setInt32sArray(i, iArr2);
                return;
            case 10:
                if (i3 == 1) {
                    tiffHandler.setRational(i, new Rational((long) randomAccessReader.getInt32(i2), (long) randomAccessReader.getInt32(i2 + 4)));
                    return;
                } else if (i3 > 1) {
                    Rational[] rationalArr2 = new Rational[i3];
                    while (i5 < i3) {
                        int i7 = i5 * 8;
                        rationalArr2[i5] = new Rational((long) randomAccessReader.getInt32(i2 + i7), (long) randomAccessReader.getInt32(i2 + 4 + i7));
                        i5++;
                    }
                    tiffHandler.setRationalArray(i, rationalArr2);
                    return;
                } else {
                    return;
                }
            case 11:
                if (i3 == 1) {
                    tiffHandler.setFloat(i, randomAccessReader.getFloat32(i2));
                    return;
                }
                float[] fArr = new float[i3];
                while (i5 < i3) {
                    fArr[i5] = randomAccessReader.getFloat32((i5 * 4) + i2);
                    i5++;
                }
                tiffHandler.setFloatArray(i, fArr);
                return;
            case 12:
                if (i3 == 1) {
                    tiffHandler.setDouble(i, randomAccessReader.getDouble64(i2));
                    return;
                }
                double[] dArr = new double[i3];
                while (i5 < i3) {
                    dArr[i5] = randomAccessReader.getDouble64((i5 * 4) + i2);
                    i5++;
                }
                tiffHandler.setDoubleArray(i, dArr);
                return;
            default:
                tiffHandler.error(String.format("Invalid TIFF tag format code %d for tag 0x%04X", new Object[]{Integer.valueOf(i4), Integer.valueOf(i)}));
                return;
        }
    }
}
