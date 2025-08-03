package org.spongycastle.apache.bzip2;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

public class CBZip2InputStream extends InputStream implements BZip2Constants {
    private static final int NO_RAND_PART_A_STATE = 5;
    private static final int NO_RAND_PART_B_STATE = 6;
    private static final int NO_RAND_PART_C_STATE = 7;
    private static final int RAND_PART_A_STATE = 2;
    private static final int RAND_PART_B_STATE = 3;
    private static final int RAND_PART_C_STATE = 4;
    private static final int START_BLOCK_STATE = 1;
    private int[][] base;
    private boolean blockRandomised;
    private int blockSize100k;
    private int bsBuff;
    private int bsLive;
    private InputStream bsStream;
    int ch2;
    int chPrev;
    private int computedBlockCRC;
    private int computedCombinedCRC;
    int count;
    private int currentChar;
    private int currentState;
    int i;
    int i2;
    private boolean[] inUse = new boolean[256];
    int j2;
    private int last;
    private int[][] limit;
    private char[] ll8;
    private CRC mCrc = new CRC();
    private int[] minLens;
    private int nInUse;
    private int origPtr;
    private int[][] perm;
    int rNToGo;
    int rTPos;
    private char[] selector = new char[BZip2Constants.MAX_SELECTORS];
    private char[] selectorMtf = new char[BZip2Constants.MAX_SELECTORS];
    private char[] seqToUnseq = new char[256];
    private int storedBlockCRC;
    private int storedCombinedCRC;
    private boolean streamEnd;
    int tPos;
    private int[] tt;
    private char[] unseqToSeq = new char[256];
    private int[] unzftab = new int[256];
    char z;

    private static void cadvise() {
        System.out.println("CRC Error");
    }

    private static void compressedStreamEOF() {
        cadvise();
    }

    private void makeMaps() {
        this.nInUse = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            if (this.inUse[i3]) {
                char[] cArr = this.seqToUnseq;
                int i4 = this.nInUse;
                cArr[i4] = (char) i3;
                this.unseqToSeq[i3] = (char) i4;
                this.nInUse = i4 + 1;
            }
        }
    }

    public CBZip2InputStream(InputStream inputStream) throws IOException {
        Class<int> cls = int.class;
        this.limit = (int[][]) Array.newInstance(cls, new int[]{6, 258});
        this.base = (int[][]) Array.newInstance(cls, new int[]{6, 258});
        this.perm = (int[][]) Array.newInstance(cls, new int[]{6, 258});
        this.minLens = new int[6];
        this.streamEnd = false;
        this.currentChar = -1;
        this.currentState = 1;
        this.rNToGo = 0;
        this.rTPos = 0;
        this.ll8 = null;
        this.tt = null;
        bsSetStream(inputStream);
        initialize();
        initBlock();
        setupBlock();
    }

    public int read() {
        if (this.streamEnd) {
            return -1;
        }
        int i3 = this.currentChar;
        int i4 = this.currentState;
        if (i4 == 3) {
            setupRandPartB();
        } else if (i4 == 4) {
            setupRandPartC();
        } else if (i4 == 6) {
            setupNoRandPartB();
        } else if (i4 == 7) {
            setupNoRandPartC();
        }
        return i3;
    }

    private void initialize() throws IOException {
        char bsGetUChar = bsGetUChar();
        char bsGetUChar2 = bsGetUChar();
        if (bsGetUChar == 'B' || bsGetUChar2 == 'Z') {
            char bsGetUChar3 = bsGetUChar();
            char bsGetUChar4 = bsGetUChar();
            if (bsGetUChar3 != 'h' || bsGetUChar4 < '1' || bsGetUChar4 > '9') {
                bsFinishedWithStream();
                this.streamEnd = true;
                return;
            }
            setDecompressStructureSizes(bsGetUChar4 - '0');
            this.computedCombinedCRC = 0;
            return;
        }
        throw new IOException("Not a BZIP2 marked stream");
    }

    private void initBlock() {
        char bsGetUChar = bsGetUChar();
        char bsGetUChar2 = bsGetUChar();
        char bsGetUChar3 = bsGetUChar();
        char bsGetUChar4 = bsGetUChar();
        char bsGetUChar5 = bsGetUChar();
        char bsGetUChar6 = bsGetUChar();
        if (bsGetUChar == 23 && bsGetUChar2 == 'r' && bsGetUChar3 == 'E' && bsGetUChar4 == '8' && bsGetUChar5 == 'P' && bsGetUChar6 == 144) {
            complete();
        } else if (bsGetUChar == '1' && bsGetUChar2 == 'A' && bsGetUChar3 == 'Y' && bsGetUChar4 == '&' && bsGetUChar5 == 'S' && bsGetUChar6 == 'Y') {
            this.storedBlockCRC = bsGetInt32();
            if (bsR(1) == 1) {
                this.blockRandomised = true;
            } else {
                this.blockRandomised = false;
            }
            getAndMoveToFrontDecode();
            this.mCrc.initialiseCRC();
            this.currentState = 1;
        } else {
            badBlockHeader();
            this.streamEnd = true;
        }
    }

    private void endBlock() {
        int finalCRC = this.mCrc.getFinalCRC();
        this.computedBlockCRC = finalCRC;
        if (this.storedBlockCRC != finalCRC) {
            crcError();
        }
        int i3 = this.computedCombinedCRC;
        int i4 = (i3 >>> 31) | (i3 << 1);
        this.computedCombinedCRC = i4;
        this.computedCombinedCRC = i4 ^ this.computedBlockCRC;
    }

    private void complete() {
        int bsGetInt32 = bsGetInt32();
        this.storedCombinedCRC = bsGetInt32;
        if (bsGetInt32 != this.computedCombinedCRC) {
            crcError();
        }
        bsFinishedWithStream();
        this.streamEnd = true;
    }

    private static void blockOverrun() {
        cadvise();
    }

    private static void badBlockHeader() {
        cadvise();
    }

    private static void crcError() {
        cadvise();
    }

    private void bsFinishedWithStream() {
        try {
            InputStream inputStream = this.bsStream;
            if (inputStream != null && inputStream != System.in) {
                this.bsStream.close();
                this.bsStream = null;
            }
        } catch (IOException unused) {
        }
    }

    private void bsSetStream(InputStream inputStream) {
        this.bsStream = inputStream;
        this.bsLive = 0;
        this.bsBuff = 0;
    }

    private int bsR(int i3) {
        while (true) {
            int i4 = this.bsLive;
            if (i4 < i3) {
                char c = 0;
                try {
                    c = (char) this.bsStream.read();
                } catch (IOException unused) {
                    compressedStreamEOF();
                }
                if (c == 65535) {
                    compressedStreamEOF();
                }
                this.bsBuff = (c & 255) | (this.bsBuff << 8);
                this.bsLive += 8;
            } else {
                int i5 = (this.bsBuff >> (i4 - i3)) & ((1 << i3) - 1);
                this.bsLive = i4 - i3;
                return i5;
            }
        }
    }

    private char bsGetUChar() {
        return (char) bsR(8);
    }

    private int bsGetint() {
        return bsR(8) | ((((((bsR(8) | 0) << 8) | bsR(8)) << 8) | bsR(8)) << 8);
    }

    private int bsGetIntVS(int i3) {
        return bsR(i3);
    }

    private int bsGetInt32() {
        return bsGetint();
    }

    private void hbCreateDecodeTables(int[] iArr, int[] iArr2, int[] iArr3, char[] cArr, int i3, int i4, int i5) {
        int i6 = 0;
        int i7 = 0;
        for (int i8 = i3; i8 <= i4; i8++) {
            for (int i9 = 0; i9 < i5; i9++) {
                if (cArr[i9] == i8) {
                    iArr3[i7] = i9;
                    i7++;
                }
            }
        }
        for (int i10 = 0; i10 < 23; i10++) {
            iArr2[i10] = 0;
        }
        for (int i11 = 0; i11 < i5; i11++) {
            int i12 = cArr[i11] + 1;
            iArr2[i12] = iArr2[i12] + 1;
        }
        for (int i13 = 1; i13 < 23; i13++) {
            iArr2[i13] = iArr2[i13] + iArr2[i13 - 1];
        }
        for (int i14 = 0; i14 < 23; i14++) {
            iArr[i14] = 0;
        }
        int i15 = i3;
        while (i15 <= i4) {
            int i16 = i15 + 1;
            int i17 = i6 + (iArr2[i16] - iArr2[i15]);
            iArr[i15] = i17 - 1;
            i6 = i17 << 1;
            i15 = i16;
        }
        for (int i18 = i3 + 1; i18 <= i4; i18++) {
            iArr2[i18] = ((iArr[i18 - 1] + 1) << 1) - iArr2[i18];
        }
    }

    private void recvDecodingTables() {
        char[][] cArr = (char[][]) Array.newInstance(char.class, new int[]{6, 258});
        boolean[] zArr = new boolean[16];
        for (int i3 = 0; i3 < 16; i3++) {
            if (bsR(1) == 1) {
                zArr[i3] = true;
            } else {
                zArr[i3] = false;
            }
        }
        for (int i4 = 0; i4 < 256; i4++) {
            this.inUse[i4] = false;
        }
        for (int i5 = 0; i5 < 16; i5++) {
            if (zArr[i5]) {
                for (int i6 = 0; i6 < 16; i6++) {
                    if (bsR(1) == 1) {
                        this.inUse[(i5 * 16) + i6] = true;
                    }
                }
            }
        }
        makeMaps();
        int i7 = this.nInUse + 2;
        int bsR = bsR(3);
        int bsR2 = bsR(15);
        for (int i8 = 0; i8 < bsR2; i8++) {
            int i9 = 0;
            while (bsR(1) == 1) {
                i9++;
            }
            this.selectorMtf[i8] = (char) i9;
        }
        char[] cArr2 = new char[6];
        for (char c = 0; c < bsR; c = (char) (c + 1)) {
            cArr2[c] = c;
        }
        for (int i10 = 0; i10 < bsR2; i10++) {
            char c2 = this.selectorMtf[i10];
            char c3 = cArr2[c2];
            while (c2 > 0) {
                int i11 = c2 - 1;
                cArr2[c2] = cArr2[i11];
                c2 = (char) i11;
            }
            cArr2[0] = c3;
            this.selector[i10] = c3;
        }
        for (int i12 = 0; i12 < bsR; i12++) {
            int bsR3 = bsR(5);
            for (int i13 = 0; i13 < i7; i13++) {
                while (bsR(1) == 1) {
                    bsR3 = bsR(1) == 0 ? bsR3 + 1 : bsR3 - 1;
                }
                cArr[i12][i13] = (char) bsR3;
            }
        }
        for (int i14 = 0; i14 < bsR; i14++) {
            int i15 = 32;
            int i16 = 0;
            char c4 = 0;
            while (i16 < i7) {
                if (cArr[i14][i16] > c4) {
                    c4 = cArr[i14][i16];
                }
                if (cArr[i14][i16] < i15) {
                    i15 = cArr[i14][i16];
                }
                i16++;
                i15 = i15;
            }
            hbCreateDecodeTables(this.limit[i14], this.base[i14], this.perm[i14], cArr[i14], i15, c4, i7);
            this.minLens[i14] = i15;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0166  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void getAndMoveToFrontDecode() {
        /*
            r18 = this;
            r0 = r18
            r1 = 256(0x100, float:3.59E-43)
            char[] r1 = new char[r1]
            int r2 = r0.blockSize100k
            r3 = 100000(0x186a0, float:1.4013E-40)
            int r2 = r2 * r3
            r3 = 24
            int r3 = r0.bsGetIntVS(r3)
            r0.origPtr = r3
            r18.recvDecodingTables()
            int r3 = r0.nInUse
            r4 = 1
            int r3 = r3 + r4
            r5 = 0
            r6 = r5
        L_0x001d:
            r7 = 255(0xff, float:3.57E-43)
            if (r6 > r7) goto L_0x0028
            int[] r7 = r0.unzftab
            r7[r6] = r5
            int r6 = r6 + 1
            goto L_0x001d
        L_0x0028:
            r6 = r5
        L_0x0029:
            if (r6 > r7) goto L_0x0031
            char r8 = (char) r6
            r1[r6] = r8
            int r6 = r6 + 1
            goto L_0x0029
        L_0x0031:
            r6 = -1
            r0.last = r6
            r8 = 49
            char[] r9 = r0.selector
            char r9 = r9[r5]
            int[] r10 = r0.minLens
            r10 = r10[r9]
            int r11 = r0.bsR(r10)
        L_0x0042:
            int[][] r12 = r0.limit
            r12 = r12[r9]
            r12 = r12[r10]
            if (r11 <= r12) goto L_0x007f
            int r10 = r10 + 1
        L_0x004c:
            int r12 = r0.bsLive
            if (r12 >= r4) goto L_0x0071
            java.io.InputStream r12 = r0.bsStream     // Catch:{ IOException -> 0x0058 }
            int r12 = r12.read()     // Catch:{ IOException -> 0x0058 }
            char r12 = (char) r12
            goto L_0x005c
        L_0x0058:
            compressedStreamEOF()
            r12 = r5
        L_0x005c:
            if (r12 != r6) goto L_0x0061
            compressedStreamEOF()
        L_0x0061:
            int r13 = r0.bsBuff
            int r13 = r13 << 8
            r12 = r12 & 255(0xff, float:3.57E-43)
            r12 = r12 | r13
            r0.bsBuff = r12
            int r12 = r0.bsLive
            int r12 = r12 + 8
            r0.bsLive = r12
            goto L_0x004c
        L_0x0071:
            int r13 = r0.bsBuff
            int r14 = r12 + -1
            int r13 = r13 >> r14
            r13 = r13 & r4
            int r12 = r12 + -1
            r0.bsLive = r12
            int r11 = r11 << 1
            r11 = r11 | r13
            goto L_0x0042
        L_0x007f:
            int[][] r12 = r0.perm
            r12 = r12[r9]
            int[][] r13 = r0.base
            r9 = r13[r9]
            r9 = r9[r10]
            int r11 = r11 - r9
            r9 = r12[r11]
            r10 = r5
        L_0x008d:
            if (r9 != r3) goto L_0x0090
            return
        L_0x0090:
            r11 = 50
            if (r9 == 0) goto L_0x013d
            if (r9 != r4) goto L_0x0098
            goto L_0x013d
        L_0x0098:
            int r12 = r0.last
            int r12 = r12 + r4
            r0.last = r12
            if (r12 < r2) goto L_0x00a2
            blockOverrun()
        L_0x00a2:
            int r9 = r9 + -1
            char r12 = r1[r9]
            int[] r13 = r0.unzftab
            char[] r14 = r0.seqToUnseq
            char r15 = r14[r12]
            r16 = r13[r15]
            int r16 = r16 + 1
            r13[r15] = r16
            char[] r13 = r0.ll8
            int r15 = r0.last
            char r14 = r14[r12]
            r13[r15] = r14
        L_0x00ba:
            r13 = 3
            if (r9 <= r13) goto L_0x00d8
            int r13 = r9 + -1
            char r14 = r1[r13]
            r1[r9] = r14
            int r14 = r9 + -2
            char r15 = r1[r14]
            r1[r13] = r15
            int r13 = r9 + -3
            char r15 = r1[r13]
            r1[r14] = r15
            int r14 = r9 + -4
            char r14 = r1[r14]
            r1[r13] = r14
            int r9 = r9 + -4
            goto L_0x00ba
        L_0x00d8:
            if (r9 <= 0) goto L_0x00e3
            int r13 = r9 + -1
            char r13 = r1[r13]
            r1[r9] = r13
            int r9 = r9 + -1
            goto L_0x00d8
        L_0x00e3:
            r1[r5] = r12
            if (r8 != 0) goto L_0x00ea
            int r10 = r10 + 1
            r8 = r11
        L_0x00ea:
            int r8 = r8 + r6
            char[] r9 = r0.selector
            char r9 = r9[r10]
            int[] r11 = r0.minLens
            r11 = r11[r9]
            int r12 = r0.bsR(r11)
        L_0x00f7:
            int[][] r13 = r0.limit
            r13 = r13[r9]
            r13 = r13[r11]
            if (r12 <= r13) goto L_0x012e
            int r11 = r11 + 1
        L_0x0101:
            int r13 = r0.bsLive
            if (r13 >= r4) goto L_0x0120
            java.io.InputStream r13 = r0.bsStream     // Catch:{ IOException -> 0x010d }
            int r13 = r13.read()     // Catch:{ IOException -> 0x010d }
            char r13 = (char) r13
            goto L_0x0111
        L_0x010d:
            compressedStreamEOF()
            r13 = r5
        L_0x0111:
            int r14 = r0.bsBuff
            int r14 = r14 << 8
            r13 = r13 & r7
            r13 = r13 | r14
            r0.bsBuff = r13
            int r13 = r0.bsLive
            int r13 = r13 + 8
            r0.bsLive = r13
            goto L_0x0101
        L_0x0120:
            int r14 = r0.bsBuff
            int r15 = r13 + -1
            int r14 = r14 >> r15
            r14 = r14 & r4
            int r13 = r13 + -1
            r0.bsLive = r13
            int r12 = r12 << 1
            r12 = r12 | r14
            goto L_0x00f7
        L_0x012e:
            int[][] r13 = r0.perm
            r13 = r13[r9]
            int[][] r14 = r0.base
            r9 = r14[r9]
            r9 = r9[r11]
            int r12 = r12 - r9
            r9 = r13[r12]
            goto L_0x008d
        L_0x013d:
            r13 = r4
            r12 = r6
        L_0x013f:
            if (r9 != 0) goto L_0x0145
            int r9 = r13 * 1
        L_0x0143:
            int r12 = r12 + r9
            goto L_0x014a
        L_0x0145:
            if (r9 != r4) goto L_0x014a
            int r9 = r13 * 2
            goto L_0x0143
        L_0x014a:
            int r13 = r13 * 2
            if (r8 != 0) goto L_0x0151
            int r10 = r10 + 1
            r8 = r11
        L_0x0151:
            int r8 = r8 + r6
            char[] r9 = r0.selector
            char r9 = r9[r10]
            int[] r14 = r0.minLens
            r14 = r14[r9]
            int r15 = r0.bsR(r14)
        L_0x015e:
            int[][] r7 = r0.limit
            r7 = r7[r9]
            r7 = r7[r14]
            if (r15 <= r7) goto L_0x019f
            int r14 = r14 + 1
        L_0x0168:
            int r7 = r0.bsLive
            if (r7 >= r4) goto L_0x018e
            java.io.InputStream r7 = r0.bsStream     // Catch:{ IOException -> 0x0174 }
            int r7 = r7.read()     // Catch:{ IOException -> 0x0174 }
            char r7 = (char) r7
            goto L_0x0178
        L_0x0174:
            compressedStreamEOF()
            r7 = r5
        L_0x0178:
            if (r7 != r6) goto L_0x017d
            compressedStreamEOF()
        L_0x017d:
            int r6 = r0.bsBuff
            int r6 = r6 << 8
            r7 = r7 & 255(0xff, float:3.57E-43)
            r6 = r6 | r7
            r0.bsBuff = r6
            int r6 = r0.bsLive
            int r6 = r6 + 8
            r0.bsLive = r6
            r6 = -1
            goto L_0x0168
        L_0x018e:
            int r6 = r0.bsBuff
            int r17 = r7 + -1
            int r6 = r6 >> r17
            r6 = r6 & r4
            int r7 = r7 + -1
            r0.bsLive = r7
            int r7 = r15 << 1
            r15 = r7 | r6
            r6 = -1
            goto L_0x015e
        L_0x019f:
            int[][] r6 = r0.perm
            r6 = r6[r9]
            int[][] r7 = r0.base
            r7 = r7[r9]
            r7 = r7[r14]
            int r15 = r15 - r7
            r9 = r6[r15]
            if (r9 == 0) goto L_0x01d9
            if (r9 == r4) goto L_0x01d9
            int r12 = r12 + 1
            char[] r6 = r0.seqToUnseq
            char r7 = r1[r5]
            char r6 = r6[r7]
            int[] r7 = r0.unzftab
            r11 = r7[r6]
            int r11 = r11 + r12
            r7[r6] = r11
        L_0x01bf:
            if (r12 <= 0) goto L_0x01cd
            int r7 = r0.last
            int r7 = r7 + r4
            r0.last = r7
            char[] r11 = r0.ll8
            r11[r7] = r6
            int r12 = r12 + -1
            goto L_0x01bf
        L_0x01cd:
            int r6 = r0.last
            if (r6 < r2) goto L_0x01d4
            blockOverrun()
        L_0x01d4:
            r6 = -1
            r7 = 255(0xff, float:3.57E-43)
            goto L_0x008d
        L_0x01d9:
            r6 = -1
            r7 = 255(0xff, float:3.57E-43)
            goto L_0x013f
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.apache.bzip2.CBZip2InputStream.getAndMoveToFrontDecode():void");
    }

    private void setupBlock() {
        int[] iArr = new int[257];
        iArr[0] = 0;
        this.i = 1;
        while (true) {
            int i3 = this.i;
            if (i3 > 256) {
                break;
            }
            iArr[i3] = this.unzftab[i3 - 1];
            this.i = i3 + 1;
        }
        this.i = 1;
        while (true) {
            int i4 = this.i;
            if (i4 > 256) {
                break;
            }
            iArr[i4] = iArr[i4] + iArr[i4 - 1];
            this.i = i4 + 1;
        }
        this.i = 0;
        while (true) {
            int i5 = this.i;
            if (i5 > this.last) {
                break;
            }
            char c = this.ll8[i5];
            this.tt[iArr[c]] = i5;
            iArr[c] = iArr[c] + 1;
            this.i = i5 + 1;
        }
        this.tPos = this.tt[this.origPtr];
        this.count = 0;
        this.i2 = 0;
        this.ch2 = 256;
        if (this.blockRandomised) {
            this.rNToGo = 0;
            this.rTPos = 0;
            setupRandPartA();
            return;
        }
        setupNoRandPartA();
    }

    private void setupRandPartA() {
        if (this.i2 <= this.last) {
            this.chPrev = this.ch2;
            char[] cArr = this.ll8;
            int i3 = this.tPos;
            this.ch2 = cArr[i3];
            this.tPos = this.tt[i3];
            int i4 = 0;
            if (this.rNToGo == 0) {
                int[] iArr = rNums;
                int i5 = this.rTPos;
                this.rNToGo = iArr[i5];
                int i6 = i5 + 1;
                this.rTPos = i6;
                if (i6 == 512) {
                    this.rTPos = 0;
                }
            }
            int i7 = this.rNToGo - 1;
            this.rNToGo = i7;
            int i8 = this.ch2;
            if (i7 == 1) {
                i4 = 1;
            }
            int i9 = i8 ^ i4;
            this.ch2 = i9;
            this.i2++;
            this.currentChar = i9;
            this.currentState = 3;
            this.mCrc.updateCRC(i9);
            return;
        }
        endBlock();
        initBlock();
        setupBlock();
    }

    private void setupNoRandPartA() {
        int i3 = this.i2;
        if (i3 <= this.last) {
            this.chPrev = this.ch2;
            char[] cArr = this.ll8;
            int i4 = this.tPos;
            char c = cArr[i4];
            this.ch2 = c;
            this.tPos = this.tt[i4];
            this.i2 = i3 + 1;
            this.currentChar = c;
            this.currentState = 6;
            this.mCrc.updateCRC(c);
            return;
        }
        endBlock();
        initBlock();
        setupBlock();
    }

    private void setupRandPartB() {
        char c = 1;
        if (this.ch2 != this.chPrev) {
            this.currentState = 2;
            this.count = 1;
            setupRandPartA();
            return;
        }
        int i3 = this.count + 1;
        this.count = i3;
        if (i3 >= 4) {
            char[] cArr = this.ll8;
            int i4 = this.tPos;
            this.z = cArr[i4];
            this.tPos = this.tt[i4];
            if (this.rNToGo == 0) {
                int[] iArr = rNums;
                int i5 = this.rTPos;
                this.rNToGo = iArr[i5];
                int i6 = i5 + 1;
                this.rTPos = i6;
                if (i6 == 512) {
                    this.rTPos = 0;
                }
            }
            int i7 = this.rNToGo - 1;
            this.rNToGo = i7;
            char c2 = this.z;
            if (i7 != 1) {
                c = 0;
            }
            this.z = (char) (c2 ^ c);
            this.j2 = 0;
            this.currentState = 4;
            setupRandPartC();
            return;
        }
        this.currentState = 2;
        setupRandPartA();
    }

    private void setupRandPartC() {
        if (this.j2 < this.z) {
            int i3 = this.ch2;
            this.currentChar = i3;
            this.mCrc.updateCRC(i3);
            this.j2++;
            return;
        }
        this.currentState = 2;
        this.i2++;
        this.count = 0;
        setupRandPartA();
    }

    private void setupNoRandPartB() {
        if (this.ch2 != this.chPrev) {
            this.currentState = 5;
            this.count = 1;
            setupNoRandPartA();
            return;
        }
        int i3 = this.count + 1;
        this.count = i3;
        if (i3 >= 4) {
            char[] cArr = this.ll8;
            int i4 = this.tPos;
            this.z = cArr[i4];
            this.tPos = this.tt[i4];
            this.currentState = 7;
            this.j2 = 0;
            setupNoRandPartC();
            return;
        }
        this.currentState = 5;
        setupNoRandPartA();
    }

    private void setupNoRandPartC() {
        if (this.j2 < this.z) {
            int i3 = this.ch2;
            this.currentChar = i3;
            this.mCrc.updateCRC(i3);
            this.j2++;
            return;
        }
        this.currentState = 5;
        this.i2++;
        this.count = 0;
        setupNoRandPartA();
    }

    private void setDecompressStructureSizes(int i3) {
        if (i3 >= 0 && i3 <= 9) {
            int i4 = this.blockSize100k;
        }
        this.blockSize100k = i3;
        if (i3 != 0) {
            int i5 = i3 * BZip2Constants.baseBlockSize;
            this.ll8 = new char[i5];
            this.tt = new int[i5];
        }
    }
}
