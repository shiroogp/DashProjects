package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import kotlin.UByte;

public final class HybridBinarizer extends GlobalHistogramBinarizer {
    private static final int BLOCK_SIZE = 8;
    private static final int BLOCK_SIZE_MASK = 7;
    private static final int BLOCK_SIZE_POWER = 3;
    private static final int MINIMUM_DIMENSION = 40;
    private static final int MIN_DYNAMIC_RANGE = 24;
    private BitMatrix matrix;

    private static int cap(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public HybridBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    public BitMatrix getBlackMatrix() throws NotFoundException {
        BitMatrix bitMatrix = this.matrix;
        if (bitMatrix != null) {
            return bitMatrix;
        }
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        if (width < 40 || height < 40) {
            this.matrix = super.getBlackMatrix();
        } else {
            byte[] matrix2 = luminanceSource.getMatrix();
            int i = width >> 3;
            if ((width & 7) != 0) {
                i++;
            }
            int i2 = i;
            int i3 = height >> 3;
            if ((height & 7) != 0) {
                i3++;
            }
            int i4 = i3;
            int[][] calculateBlackPoints = calculateBlackPoints(matrix2, i2, i4, width, height);
            BitMatrix bitMatrix2 = new BitMatrix(width, height);
            calculateThresholdForBlock(matrix2, i2, i4, width, height, calculateBlackPoints, bitMatrix2);
            this.matrix = bitMatrix2;
        }
        return this.matrix;
    }

    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new HybridBinarizer(luminanceSource);
    }

    private static void calculateThresholdForBlock(byte[] bArr, int i, int i2, int i3, int i4, int[][] iArr, BitMatrix bitMatrix) {
        int i5 = i;
        int i6 = i2;
        int i7 = i4 - 8;
        int i8 = i3 - 8;
        for (int i9 = 0; i9 < i6; i9++) {
            int i10 = i9 << 3;
            int i11 = i10 > i7 ? i7 : i10;
            int cap = cap(i9, 2, i6 - 3);
            for (int i12 = 0; i12 < i5; i12++) {
                int i13 = i12 << 3;
                int i14 = i13 > i8 ? i8 : i13;
                int cap2 = cap(i12, 2, i5 - 3);
                int i15 = 0;
                for (int i16 = -2; i16 <= 2; i16++) {
                    int[] iArr2 = iArr[cap + i16];
                    i15 += iArr2[cap2 - 2] + iArr2[cap2 - 1] + iArr2[cap2] + iArr2[cap2 + 1] + iArr2[cap2 + 2];
                }
                thresholdBlock(bArr, i14, i11, i15 / 25, i3, bitMatrix);
            }
        }
    }

    private static void thresholdBlock(byte[] bArr, int i, int i2, int i3, int i4, BitMatrix bitMatrix) {
        int i5 = (i2 * i4) + i;
        int i6 = 0;
        while (i6 < 8) {
            for (int i7 = 0; i7 < 8; i7++) {
                if ((bArr[i5 + i7] & UByte.MAX_VALUE) <= i3) {
                    bitMatrix.set(i + i7, i2 + i6);
                }
            }
            i6++;
            i5 += i4;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v20, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int[][] calculateBlackPoints(byte[] r17, int r18, int r19, int r20, int r21) {
        /*
            r0 = r18
            r1 = r19
            r2 = 8
            int r3 = r21 + -8
            int r4 = r20 + -8
            r5 = 2
            int[] r6 = new int[r5]
            r7 = 1
            r6[r7] = r0
            r8 = 0
            r6[r8] = r1
            java.lang.Class<int> r9 = int.class
            java.lang.Object r6 = java.lang.reflect.Array.newInstance(r9, r6)
            int[][] r6 = (int[][]) r6
            r9 = r8
        L_0x001c:
            if (r9 >= r1) goto L_0x00b3
            int r10 = r9 << 3
            if (r10 <= r3) goto L_0x0023
            r10 = r3
        L_0x0023:
            r11 = r8
        L_0x0024:
            if (r11 >= r0) goto L_0x00aa
            int r12 = r11 << 3
            if (r12 <= r4) goto L_0x002b
            r12 = r4
        L_0x002b:
            int r13 = r10 * r20
            int r13 = r13 + r12
            r12 = 255(0xff, float:3.57E-43)
            r14 = r8
            r15 = r14
            r16 = r15
            r8 = r12
        L_0x0035:
            if (r14 >= r2) goto L_0x0073
            r7 = r16
            r5 = 0
        L_0x003a:
            if (r5 >= r2) goto L_0x004d
            int r16 = r13 + r5
            byte r2 = r17[r16]
            r2 = r2 & r12
            int r15 = r15 + r2
            if (r2 >= r8) goto L_0x0045
            r8 = r2
        L_0x0045:
            if (r2 <= r7) goto L_0x0048
            r7 = r2
        L_0x0048:
            int r5 = r5 + 1
            r2 = 8
            goto L_0x003a
        L_0x004d:
            int r2 = r7 - r8
            r5 = 24
            if (r2 <= r5) goto L_0x0069
        L_0x0053:
            int r14 = r14 + 1
            int r13 = r13 + r20
            r2 = 8
            if (r14 >= r2) goto L_0x0069
            r5 = 0
        L_0x005c:
            if (r5 >= r2) goto L_0x0053
            int r16 = r13 + r5
            byte r2 = r17[r16]
            r2 = r2 & r12
            int r15 = r15 + r2
            int r5 = r5 + 1
            r2 = 8
            goto L_0x005c
        L_0x0069:
            r2 = 1
            int r14 = r14 + r2
            int r13 = r13 + r20
            r16 = r7
            r7 = r2
            r2 = 8
            goto L_0x0035
        L_0x0073:
            r2 = r7
            int r5 = r15 >> 6
            int r7 = r16 - r8
            r12 = 24
            if (r7 > r12) goto L_0x009c
            int r5 = r8 / 2
            if (r9 <= 0) goto L_0x009c
            if (r11 <= 0) goto L_0x009c
            int r7 = r9 + -1
            r12 = r6[r7]
            r12 = r12[r11]
            r13 = r6[r9]
            int r14 = r11 + -1
            r13 = r13[r14]
            r15 = 2
            int r13 = r13 * r15
            int r12 = r12 + r13
            r7 = r6[r7]
            r7 = r7[r14]
            int r12 = r12 + r7
            int r7 = r12 / 4
            if (r8 >= r7) goto L_0x009d
            r5 = r7
            goto L_0x009d
        L_0x009c:
            r15 = 2
        L_0x009d:
            r7 = r6[r9]
            r7[r11] = r5
            int r11 = r11 + 1
            r7 = r2
            r5 = r15
            r2 = 8
            r8 = 0
            goto L_0x0024
        L_0x00aa:
            r15 = r5
            r2 = r7
            int r9 = r9 + 1
            r2 = 8
            r8 = 0
            goto L_0x001c
        L_0x00b3:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.common.HybridBinarizer.calculateBlackPoints(byte[], int, int, int, int):int[][]");
    }
}
