package org.spongycastle.pqc.crypto.gmss.util;

import kotlin.UByte;
import org.spongycastle.crypto.Digest;

public class WinternitzOTSVerify {
    private Digest messDigestOTS;
    private int w;

    public int getLog(int i) {
        int i2 = 1;
        int i3 = 2;
        while (i3 < i) {
            i3 <<= 1;
            i2++;
        }
        return i2;
    }

    public WinternitzOTSVerify(Digest digest, int i) {
        this.w = i;
        this.messDigestOTS = digest;
    }

    public int getSignatureLength() {
        int digestSize = this.messDigestOTS.getDigestSize();
        int i = this.w;
        int i2 = ((digestSize << 3) + (i - 1)) / i;
        int log = getLog((i2 << i) + 1);
        int i3 = this.w;
        return digestSize * (i2 + (((log + i3) - 1) / i3));
    }

    public byte[] Verify(byte[] bArr, byte[] bArr2) {
        int i;
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int digestSize = this.messDigestOTS.getDigestSize();
        byte[] bArr5 = new byte[digestSize];
        int i2 = 0;
        this.messDigestOTS.update(bArr3, 0, bArr3.length);
        int digestSize2 = this.messDigestOTS.getDigestSize();
        byte[] bArr6 = new byte[digestSize2];
        this.messDigestOTS.doFinal(bArr6, 0);
        int i3 = digestSize << 3;
        int i4 = this.w;
        int i5 = ((i4 - 1) + i3) / i4;
        int log = getLog((i5 << i4) + 1);
        int i6 = this.w;
        int i7 = ((((log + i6) - 1) / i6) + i5) * digestSize;
        if (i7 != bArr4.length) {
            return null;
        }
        byte[] bArr7 = new byte[i7];
        int i8 = 8;
        if (8 % i6 == 0) {
            int i9 = 8 / i6;
            int i10 = (1 << i6) - 1;
            byte[] bArr8 = new byte[digestSize];
            int i11 = 0;
            byte b = 0;
            int i12 = 0;
            while (i11 < digestSize2) {
                while (i2 < i9) {
                    byte b2 = bArr6[i11] & i10;
                    b += b2;
                    int i13 = digestSize2;
                    int i14 = i12 * digestSize;
                    int i15 = i9;
                    System.arraycopy(bArr4, i14, bArr8, 0, digestSize);
                    int i16 = b2;
                    while (i16 < i10) {
                        this.messDigestOTS.update(bArr8, 0, bArr8.length);
                        bArr8 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr8, 0);
                        i16++;
                        byte[] bArr9 = bArr2;
                        b = b;
                        i7 = i7;
                    }
                    int i17 = i7;
                    int i18 = b;
                    System.arraycopy(bArr8, 0, bArr7, i14, digestSize);
                    bArr6[i11] = (byte) (bArr6[i11] >>> this.w);
                    i12++;
                    i2++;
                    digestSize2 = i13;
                    bArr4 = bArr2;
                    i9 = i15;
                }
                int i19 = digestSize2;
                int i20 = i7;
                int i21 = i9;
                i11++;
                bArr4 = bArr2;
                i2 = 0;
            }
            i = i7;
            int i22 = (i5 << this.w) - b;
            int i23 = 0;
            while (i23 < log) {
                int i24 = i12 * digestSize;
                System.arraycopy(bArr2, i24, bArr8, 0, digestSize);
                for (int i25 = i22 & i10; i25 < i10; i25++) {
                    this.messDigestOTS.update(bArr8, 0, bArr8.length);
                    bArr8 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr8, 0);
                }
                System.arraycopy(bArr8, 0, bArr7, i24, digestSize);
                int i26 = this.w;
                i22 >>>= i26;
                i12++;
                i23 += i26;
            }
        } else {
            i = i7;
            byte[] bArr10 = bArr4;
            if (i6 < 8) {
                int i27 = digestSize / i6;
                int i28 = (1 << i6) - 1;
                byte[] bArr11 = new byte[digestSize];
                int i29 = 0;
                int i30 = 0;
                int i31 = 0;
                int i32 = 0;
                while (i29 < i27) {
                    int i33 = 0;
                    long j = 0;
                    while (i33 < this.w) {
                        j ^= (long) ((bArr6[i30] & UByte.MAX_VALUE) << (i33 << 3));
                        i30++;
                        i33++;
                        bArr11 = bArr11;
                    }
                    byte[] bArr12 = bArr11;
                    int i34 = 0;
                    while (i34 < i8) {
                        int i35 = i29;
                        int i36 = (int) (j & ((long) i28));
                        i31 += i36;
                        int i37 = i32 * digestSize;
                        System.arraycopy(bArr10, i37, bArr11, 0, digestSize);
                        while (i36 < i28) {
                            this.messDigestOTS.update(bArr11, 0, bArr11.length);
                            bArr11 = new byte[this.messDigestOTS.getDigestSize()];
                            this.messDigestOTS.doFinal(bArr11, 0);
                            i36++;
                            i27 = i27;
                            i30 = i30;
                        }
                        int i38 = i27;
                        int i39 = i30;
                        System.arraycopy(bArr11, 0, bArr7, i37, digestSize);
                        j >>>= this.w;
                        i32++;
                        i34++;
                        i29 = i35;
                        i8 = 8;
                    }
                    int i40 = i27;
                    int i41 = i30;
                    i29++;
                    i8 = 8;
                }
                byte[] bArr13 = bArr11;
                int i42 = digestSize % this.w;
                long j2 = 0;
                for (int i43 = 0; i43 < i42; i43++) {
                    j2 ^= (long) ((bArr6[i30] & UByte.MAX_VALUE) << (i43 << 3));
                    i30++;
                }
                int i44 = i42 << 3;
                byte[] bArr14 = bArr13;
                int i45 = 0;
                while (i45 < i44) {
                    int i46 = (int) (j2 & ((long) i28));
                    i31 += i46;
                    int i47 = i32 * digestSize;
                    System.arraycopy(bArr10, i47, bArr14, 0, digestSize);
                    while (i46 < i28) {
                        this.messDigestOTS.update(bArr14, 0, bArr14.length);
                        bArr14 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr14, 0);
                        i46++;
                    }
                    System.arraycopy(bArr14, 0, bArr7, i47, digestSize);
                    int i48 = this.w;
                    j2 >>>= i48;
                    i32++;
                    i45 += i48;
                }
                int i49 = (i5 << this.w) - i31;
                int i50 = 0;
                while (i50 < log) {
                    int i51 = i32 * digestSize;
                    System.arraycopy(bArr10, i51, bArr14, 0, digestSize);
                    for (int i52 = i49 & i28; i52 < i28; i52++) {
                        this.messDigestOTS.update(bArr14, 0, bArr14.length);
                        bArr14 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr14, 0);
                    }
                    System.arraycopy(bArr14, 0, bArr7, i51, digestSize);
                    int i53 = this.w;
                    i49 >>>= i53;
                    i32++;
                    i50 += i53;
                }
            } else if (i6 < 57) {
                int i54 = i3 - i6;
                int i55 = (1 << i6) - 1;
                byte[] bArr15 = new byte[digestSize];
                int i56 = 0;
                int i57 = 0;
                int i58 = 0;
                while (i57 <= i54) {
                    int i59 = i57 >>> 3;
                    int i60 = i57 % 8;
                    int i61 = i57 + this.w;
                    int i62 = (i61 + 7) >>> 3;
                    int i63 = 0;
                    long j3 = 0;
                    while (i59 < i62) {
                        j3 ^= (long) ((bArr6[i59] & UByte.MAX_VALUE) << (i63 << 3));
                        i63++;
                        i59++;
                        i54 = i54;
                        log = log;
                        i5 = i5;
                    }
                    int i64 = i54;
                    int i65 = log;
                    int i66 = i5;
                    long j4 = (long) i55;
                    long j5 = (j3 >>> i60) & j4;
                    int i67 = i61;
                    i58 = (int) (((long) i58) + j5);
                    int i68 = i56 * digestSize;
                    System.arraycopy(bArr10, i68, bArr15, 0, digestSize);
                    while (j5 < j4) {
                        this.messDigestOTS.update(bArr15, 0, bArr15.length);
                        bArr15 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr15, 0);
                        j5++;
                        i67 = i67;
                        i58 = i58;
                    }
                    int i69 = i58;
                    System.arraycopy(bArr15, 0, bArr7, i68, digestSize);
                    i56++;
                    i57 = i67;
                    i54 = i64;
                    log = i65;
                    i5 = i66;
                }
                int i70 = log;
                int i71 = i5;
                int i72 = i57 >>> 3;
                if (i72 < digestSize) {
                    int i73 = i57 % 8;
                    int i74 = 0;
                    long j6 = 0;
                    while (i72 < digestSize) {
                        j6 ^= (long) ((bArr6[i72] & UByte.MAX_VALUE) << (i74 << 3));
                        i74++;
                        i72++;
                    }
                    long j7 = (long) i55;
                    long j8 = (j6 >>> i73) & j7;
                    i58 = (int) (((long) i58) + j8);
                    int i75 = i56 * digestSize;
                    System.arraycopy(bArr10, i75, bArr15, 0, digestSize);
                    while (j8 < j7) {
                        this.messDigestOTS.update(bArr15, 0, bArr15.length);
                        bArr15 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr15, 0);
                        j8++;
                    }
                    System.arraycopy(bArr15, 0, bArr7, i75, digestSize);
                    i56++;
                }
                int i76 = (i71 << this.w) - i58;
                int i77 = i70;
                int i78 = 0;
                while (i78 < i77) {
                    int i79 = i56 * digestSize;
                    System.arraycopy(bArr10, i79, bArr15, 0, digestSize);
                    for (long j9 = (long) (i76 & i55); j9 < ((long) i55); j9++) {
                        this.messDigestOTS.update(bArr15, 0, bArr15.length);
                        bArr15 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr15, 0);
                    }
                    System.arraycopy(bArr15, 0, bArr7, i79, digestSize);
                    int i80 = this.w;
                    i76 >>>= i80;
                    i56++;
                    i78 += i80;
                }
            }
        }
        byte[] bArr16 = new byte[digestSize];
        this.messDigestOTS.update(bArr7, 0, i);
        byte[] bArr17 = new byte[this.messDigestOTS.getDigestSize()];
        this.messDigestOTS.doFinal(bArr17, 0);
        return bArr17;
    }
}
