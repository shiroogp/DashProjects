package org.spongycastle.apache.bzip2;

import androidx.core.view.InputDeviceCompat;
import java.io.IOException;
import java.io.OutputStream;

public class CBZip2OutputStream extends OutputStream implements BZip2Constants {
    protected static final int CLEARMASK = -2097153;
    protected static final int DEPTH_THRESH = 10;
    protected static final int GREATER_ICOST = 15;
    protected static final int LESSER_ICOST = 0;
    protected static final int QSORT_STACK_SIZE = 1000;
    protected static final int SETMASK = 2097152;
    protected static final int SMALL_THRESH = 20;
    private int allowableBlockSize;
    private char[] block;
    private int blockCRC;
    boolean blockRandomised;
    int blockSize100k;
    int bsBuff;
    int bsLive;
    private OutputStream bsStream;
    int bytesOut;
    boolean closed;
    private int combinedCRC;
    private int currentChar;
    private boolean finished;
    private boolean firstAttempt;
    private int[] ftab;
    private boolean[] inUse;
    private int[] incs;
    int last;
    CRC mCrc;
    private int[] mtfFreq;
    private int nBlocksRandomised;
    private int nInUse;
    private int nMTF;
    int origPtr;
    private int[] quadrant;
    private int runLength;
    private char[] selector;
    private char[] selectorMtf;
    private char[] seqToUnseq;
    private short[] szptr;
    private char[] unseqToSeq;
    private int workDone;
    private int workFactor;
    private int workLimit;
    private int[] zptr;

    private char med3(char c, char c2, char c3) {
        if (c <= c2) {
            char c4 = c2;
            c2 = c;
            c = c4;
        }
        if (c <= c3) {
            c3 = c;
        }
        return c2 > c3 ? c2 : c3;
    }

    private static void panic() {
        System.out.println("panic");
    }

    private void makeMaps() {
        this.nInUse = 0;
        for (int i = 0; i < 256; i++) {
            if (this.inUse[i]) {
                char[] cArr = this.seqToUnseq;
                int i2 = this.nInUse;
                cArr[i2] = (char) i;
                this.unseqToSeq[i] = (char) i2;
                this.nInUse = i2 + 1;
            }
        }
    }

    protected static void hbMakeCodeLengths(char[] cArr, int[] iArr, int i, int i2) {
        int i3 = i;
        int i4 = 260;
        int[] iArr2 = new int[260];
        int i5 = 516;
        int[] iArr3 = new int[516];
        int[] iArr4 = new int[516];
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int i8 = 1;
            if (i7 >= i3) {
                break;
            }
            int i9 = i7 + 1;
            if (iArr[i7] != 0) {
                i8 = iArr[i7];
            }
            iArr3[i9] = i8 << 8;
            i7 = i9;
        }
        while (true) {
            iArr2[i6] = i6;
            iArr3[i6] = i6;
            iArr4[i6] = -2;
            int i10 = i6;
            for (int i11 = 1; i11 <= i3; i11++) {
                iArr4[i11] = -1;
                i10++;
                iArr2[i10] = i11;
                int i12 = iArr2[i10];
                int i13 = i10;
                while (true) {
                    int i14 = i13 >> 1;
                    if (iArr3[i12] >= iArr3[iArr2[i14]]) {
                        break;
                    }
                    iArr2[i13] = iArr2[i14];
                    i13 = i14;
                }
                iArr2[i13] = i12;
            }
            if (i10 >= i4) {
                panic();
            }
            int i15 = i3;
            while (i10 > 1) {
                int i16 = iArr2[1];
                iArr2[1] = iArr2[i10];
                int i17 = i10 - 1;
                int i18 = iArr2[1];
                int i19 = 1;
                while (true) {
                    int i20 = i19 << 1;
                    if (i20 > i17) {
                        break;
                    }
                    if (i20 < i17) {
                        int i21 = i20 + 1;
                        if (iArr3[iArr2[i21]] < iArr3[iArr2[i20]]) {
                            i20 = i21;
                        }
                    }
                    if (iArr3[i18] < iArr3[iArr2[i20]]) {
                        break;
                    }
                    iArr2[i19] = iArr2[i20];
                    i19 = i20;
                }
                iArr2[i19] = i18;
                int i22 = iArr2[1];
                iArr2[1] = iArr2[i17];
                int i23 = i17 - 1;
                int i24 = iArr2[1];
                int i25 = 1;
                while (true) {
                    int i26 = i25 << 1;
                    if (i26 > i23) {
                        break;
                    }
                    if (i26 < i23) {
                        int i27 = i26 + 1;
                        if (iArr3[iArr2[i27]] < iArr3[iArr2[i26]]) {
                            i26 = i27;
                        }
                    }
                    if (iArr3[i24] < iArr3[iArr2[i26]]) {
                        break;
                    }
                    iArr2[i25] = iArr2[i26];
                    i25 = i26;
                }
                iArr2[i25] = i24;
                i15++;
                iArr4[i22] = i15;
                iArr4[i16] = i15;
                iArr3[i15] = ((((iArr3[i16] & 255) > (iArr3[i22] & 255) ? iArr3[i16] : iArr3[i22]) & 255) + 1) | ((iArr3[i16] & InputDeviceCompat.SOURCE_ANY) + (iArr3[i22] & InputDeviceCompat.SOURCE_ANY));
                iArr4[i15] = -1;
                i10 = i23 + 1;
                iArr2[i10] = i15;
                int i28 = iArr2[i10];
                int i29 = i10;
                while (true) {
                    int i30 = i29 >> 1;
                    if (iArr3[i28] >= iArr3[iArr2[i30]]) {
                        break;
                    }
                    iArr2[i29] = iArr2[i30];
                    i29 = i30;
                }
                iArr2[i29] = i28;
                i5 = 516;
            }
            int i31 = i5;
            if (i15 >= i31) {
                panic();
            }
            boolean z = false;
            for (int i32 = 1; i32 <= i3; i32++) {
                int i33 = i32;
                int i34 = 0;
                while (iArr4[i33] >= 0) {
                    i33 = iArr4[i33];
                    i34++;
                }
                cArr[i32 - 1] = (char) i34;
                if (i34 > i2) {
                    z = true;
                }
            }
            int i35 = i2;
            if (z) {
                for (int i36 = 1; i36 < i3; i36++) {
                    iArr3[i36] = (((iArr3[i36] >> 8) / 2) + 1) << 8;
                }
                i5 = i31;
                i4 = 260;
                i6 = 0;
            } else {
                return;
            }
        }
    }

    public CBZip2OutputStream(OutputStream outputStream) throws IOException {
        this(outputStream, 9);
    }

    public CBZip2OutputStream(OutputStream outputStream, int i) throws IOException {
        this.mCrc = new CRC();
        this.inUse = new boolean[256];
        this.seqToUnseq = new char[256];
        this.unseqToSeq = new char[256];
        this.selector = new char[BZip2Constants.MAX_SELECTORS];
        this.selectorMtf = new char[BZip2Constants.MAX_SELECTORS];
        this.mtfFreq = new int[258];
        this.currentChar = -1;
        this.runLength = 0;
        this.closed = false;
        this.incs = new int[]{1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524, 88573, 265720, 797161, 2391484};
        this.block = null;
        this.quadrant = null;
        this.zptr = null;
        this.ftab = null;
        outputStream.write(66);
        outputStream.write(90);
        bsSetStream(outputStream);
        this.workFactor = 50;
        i = i > 9 ? 9 : i;
        this.blockSize100k = i < 1 ? 1 : i;
        allocateCompressStructures();
        initialize();
        initBlock();
    }

    public void write(int i) throws IOException {
        int i2 = (i + 256) % 256;
        int i3 = this.currentChar;
        if (i3 == -1) {
            this.currentChar = i2;
            this.runLength++;
        } else if (i3 == i2) {
            int i4 = this.runLength + 1;
            this.runLength = i4;
            if (i4 > 254) {
                writeRun();
                this.currentChar = -1;
                this.runLength = 0;
            }
        } else {
            writeRun();
            this.runLength = 1;
            this.currentChar = i2;
        }
    }

    private void writeRun() throws IOException {
        int i;
        if (this.last < this.allowableBlockSize) {
            this.inUse[this.currentChar] = true;
            int i2 = 0;
            while (true) {
                i = this.runLength;
                if (i2 >= i) {
                    break;
                }
                this.mCrc.updateCRC((char) this.currentChar);
                i2++;
            }
            if (i == 1) {
                int i3 = this.last + 1;
                this.last = i3;
                this.block[i3 + 1] = (char) this.currentChar;
            } else if (i == 2) {
                int i4 = this.last + 1;
                this.last = i4;
                char[] cArr = this.block;
                int i5 = this.currentChar;
                cArr[i4 + 1] = (char) i5;
                int i6 = i4 + 1;
                this.last = i6;
                cArr[i6 + 1] = (char) i5;
            } else if (i != 3) {
                this.inUse[i - 4] = true;
                int i7 = this.last + 1;
                this.last = i7;
                char[] cArr2 = this.block;
                int i8 = this.currentChar;
                cArr2[i7 + 1] = (char) i8;
                int i9 = i7 + 1;
                this.last = i9;
                cArr2[i9 + 1] = (char) i8;
                int i10 = i9 + 1;
                this.last = i10;
                cArr2[i10 + 1] = (char) i8;
                int i11 = i10 + 1;
                this.last = i11;
                cArr2[i11 + 1] = (char) i8;
                int i12 = i11 + 1;
                this.last = i12;
                cArr2[i12 + 1] = (char) (i - 4);
            } else {
                int i13 = this.last + 1;
                this.last = i13;
                char[] cArr3 = this.block;
                int i14 = this.currentChar;
                cArr3[i13 + 1] = (char) i14;
                int i15 = i13 + 1;
                this.last = i15;
                cArr3[i15 + 1] = (char) i14;
                int i16 = i15 + 1;
                this.last = i16;
                cArr3[i16 + 1] = (char) i14;
            }
        } else {
            endBlock();
            initBlock();
            writeRun();
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        close();
        super.finalize();
    }

    public void close() throws IOException {
        if (!this.closed) {
            finish();
            this.closed = true;
            super.close();
            this.bsStream.close();
        }
    }

    public void finish() throws IOException {
        if (!this.finished) {
            if (this.runLength > 0) {
                writeRun();
            }
            this.currentChar = -1;
            endBlock();
            endCompression();
            this.finished = true;
            flush();
        }
    }

    public void flush() throws IOException {
        super.flush();
        this.bsStream.flush();
    }

    private void initialize() throws IOException {
        this.bytesOut = 0;
        this.nBlocksRandomised = 0;
        bsPutUChar(104);
        bsPutUChar(this.blockSize100k + 48);
        this.combinedCRC = 0;
    }

    private void initBlock() {
        this.mCrc.initialiseCRC();
        this.last = -1;
        for (int i = 0; i < 256; i++) {
            this.inUse[i] = false;
        }
        this.allowableBlockSize = (this.blockSize100k * BZip2Constants.baseBlockSize) - 20;
    }

    private void endBlock() throws IOException {
        int finalCRC = this.mCrc.getFinalCRC();
        this.blockCRC = finalCRC;
        int i = this.combinedCRC;
        int i2 = (i >>> 31) | (i << 1);
        this.combinedCRC = i2;
        this.combinedCRC = finalCRC ^ i2;
        doReversibleTransformation();
        bsPutUChar(49);
        bsPutUChar(65);
        bsPutUChar(89);
        bsPutUChar(38);
        bsPutUChar(83);
        bsPutUChar(89);
        bsPutint(this.blockCRC);
        if (this.blockRandomised) {
            bsW(1, 1);
            this.nBlocksRandomised++;
        } else {
            bsW(1, 0);
        }
        moveToFrontCodeAndSend();
    }

    private void endCompression() throws IOException {
        bsPutUChar(23);
        bsPutUChar(114);
        bsPutUChar(69);
        bsPutUChar(56);
        bsPutUChar(80);
        bsPutUChar(144);
        bsPutint(this.combinedCRC);
        bsFinishedWithStream();
    }

    private void hbAssignCodes(int[] iArr, char[] cArr, int i, int i2, int i3) {
        int i4 = 0;
        while (i <= i2) {
            for (int i5 = 0; i5 < i3; i5++) {
                if (cArr[i5] == i) {
                    iArr[i5] = i4;
                    i4++;
                }
            }
            i4 <<= 1;
            i++;
        }
    }

    private void bsSetStream(OutputStream outputStream) {
        this.bsStream = outputStream;
        this.bsLive = 0;
        this.bsBuff = 0;
        this.bytesOut = 0;
    }

    private void bsFinishedWithStream() throws IOException {
        while (this.bsLive > 0) {
            try {
                this.bsStream.write(this.bsBuff >> 24);
                this.bsBuff <<= 8;
                this.bsLive -= 8;
                this.bytesOut++;
            } catch (IOException e) {
                throw e;
            }
        }
    }

    private void bsW(int i, int i2) throws IOException {
        while (true) {
            int i3 = this.bsLive;
            if (i3 >= 8) {
                try {
                    this.bsStream.write(this.bsBuff >> 24);
                    this.bsBuff <<= 8;
                    this.bsLive -= 8;
                    this.bytesOut++;
                } catch (IOException e) {
                    throw e;
                }
            } else {
                this.bsBuff = (i2 << ((32 - i3) - i)) | this.bsBuff;
                this.bsLive = i3 + i;
                return;
            }
        }
    }

    private void bsPutUChar(int i) throws IOException {
        bsW(8, i);
    }

    private void bsPutint(int i) throws IOException {
        bsW(8, (i >> 24) & 255);
        bsW(8, (i >> 16) & 255);
        bsW(8, (i >> 8) & 255);
        bsW(8, i & 255);
    }

    private void bsPutIntVS(int i, int i2) throws IOException {
        bsW(i, i2);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [char, short], vars: [r10v0 ?, r10v1 ?, r10v12 ?, r10v25 ?, r10v29 ?, r10v18 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    private void sendMTFValues() throws java.io.IOException {
        /*
            r30 = this;
            r6 = r30
            java.lang.Class<int> r0 = int.class
            r7 = 2
            int[] r1 = new int[r7]
            r1 = {6, 258} // fill-array
            java.lang.Class<char> r2 = char.class
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r2, r1)
            r8 = r1
            char[][] r8 = (char[][]) r8
            int r1 = r6.nInUse
            int r9 = r1 + 2
            r10 = 0
            r1 = r10
        L_0x0019:
            r11 = 15
            r2 = 6
            if (r1 >= r2) goto L_0x002b
            r2 = r10
        L_0x001f:
            if (r2 >= r9) goto L_0x0028
            r3 = r8[r1]
            r3[r2] = r11
            int r2 = r2 + 1
            goto L_0x001f
        L_0x0028:
            int r1 = r1 + 1
            goto L_0x0019
        L_0x002b:
            int r1 = r6.nMTF
            if (r1 > 0) goto L_0x0032
            panic()
        L_0x0032:
            int r1 = r6.nMTF
            r3 = 200(0xc8, float:2.8E-43)
            if (r1 >= r3) goto L_0x003a
            r14 = r7
            goto L_0x004d
        L_0x003a:
            r3 = 600(0x258, float:8.41E-43)
            if (r1 >= r3) goto L_0x0040
            r14 = 3
            goto L_0x004d
        L_0x0040:
            r3 = 1200(0x4b0, float:1.682E-42)
            if (r1 >= r3) goto L_0x0046
            r14 = 4
            goto L_0x004d
        L_0x0046:
            r3 = 2400(0x960, float:3.363E-42)
            if (r1 >= r3) goto L_0x004c
            r14 = 5
            goto L_0x004d
        L_0x004c:
            r14 = r2
        L_0x004d:
            r5 = r10
            r3 = r14
        L_0x004f:
            r15 = 1
            if (r3 <= 0) goto L_0x0098
            int r12 = r1 / r3
            int r17 = r5 + -1
            r4 = r10
            r13 = r17
        L_0x0059:
            if (r4 >= r12) goto L_0x0068
            int r2 = r9 + -1
            if (r13 >= r2) goto L_0x0068
            int r13 = r13 + 1
            int[] r2 = r6.mtfFreq
            r2 = r2[r13]
            int r4 = r4 + r2
            r2 = 6
            goto L_0x0059
        L_0x0068:
            if (r13 <= r5) goto L_0x007a
            if (r3 == r14) goto L_0x007a
            if (r3 == r15) goto L_0x007a
            int r2 = r14 - r3
            int r2 = r2 % r7
            if (r2 != r15) goto L_0x007a
            int[] r2 = r6.mtfFreq
            r2 = r2[r13]
            int r4 = r4 - r2
            int r13 = r13 + -1
        L_0x007a:
            r2 = r10
        L_0x007b:
            if (r2 >= r9) goto L_0x0091
            if (r2 < r5) goto L_0x0088
            if (r2 > r13) goto L_0x0088
            int r12 = r3 + -1
            r12 = r8[r12]
            r12[r2] = r10
            goto L_0x008e
        L_0x0088:
            int r12 = r3 + -1
            r12 = r8[r12]
            r12[r2] = r11
        L_0x008e:
            int r2 = r2 + 1
            goto L_0x007b
        L_0x0091:
            int r3 = r3 + -1
            int r5 = r13 + 1
            int r1 = r1 - r4
            r2 = 6
            goto L_0x004f
        L_0x0098:
            int[] r1 = new int[r7]
            r1 = {6, 258} // fill-array
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r0, r1)
            int[][] r1 = (int[][]) r1
            r2 = 6
            int[] r3 = new int[r2]
            short[] r4 = new short[r2]
            r2 = r10
            r12 = r2
        L_0x00aa:
            r13 = 20
            r5 = 4
            if (r2 >= r5) goto L_0x01c2
            r5 = r10
        L_0x00b0:
            if (r5 >= r14) goto L_0x00b7
            r3[r5] = r10
            int r5 = r5 + 1
            goto L_0x00b0
        L_0x00b7:
            r5 = r10
        L_0x00b8:
            if (r5 >= r14) goto L_0x00c7
            r12 = r10
        L_0x00bb:
            if (r12 >= r9) goto L_0x00c4
            r19 = r1[r5]
            r19[r12] = r10
            int r12 = r12 + 1
            goto L_0x00bb
        L_0x00c4:
            int r5 = r5 + 1
            goto L_0x00b8
        L_0x00c7:
            r5 = r10
            r12 = r5
        L_0x00c9:
            int r11 = r6.nMTF
            if (r5 < r11) goto L_0x00e1
            r5 = r10
        L_0x00ce:
            if (r5 >= r14) goto L_0x00db
            r11 = r8[r5]
            r7 = r1[r5]
            hbMakeCodeLengths(r11, r7, r9, r13)
            int r5 = r5 + 1
            r7 = 2
            goto L_0x00ce
        L_0x00db:
            int r2 = r2 + 1
            r7 = 2
            r11 = 15
            goto L_0x00aa
        L_0x00e1:
            int r7 = r5 + 50
            int r7 = r7 - r15
            if (r7 < r11) goto L_0x00e8
            int r7 = r11 + -1
        L_0x00e8:
            r11 = r10
        L_0x00e9:
            if (r11 >= r14) goto L_0x00f0
            r4[r11] = r10
            int r11 = r11 + 1
            goto L_0x00e9
        L_0x00f0:
            r11 = 6
            if (r14 != r11) goto L_0x0168
            r11 = r5
            r21 = r10
            r22 = r21
            r23 = r22
            r24 = r23
            r25 = r24
            r26 = r25
        L_0x0100:
            if (r11 > r7) goto L_0x0153
            short[] r13 = r6.szptr
            short r13 = r13[r11]
            r27 = r8[r10]
            char r27 = r27[r13]
            int r10 = r21 + r27
            short r10 = (short) r10
            r21 = r8[r15]
            char r21 = r21[r13]
            int r15 = r22 + r21
            short r15 = (short) r15
            r20 = 2
            r21 = r8[r20]
            char r21 = r21[r13]
            r29 = r2
            int r2 = r23 + r21
            short r2 = (short) r2
            r18 = 3
            r21 = r8[r18]
            char r21 = r21[r13]
            r22 = r2
            int r2 = r24 + r21
            short r2 = (short) r2
            r17 = 4
            r21 = r8[r17]
            char r21 = r21[r13]
            r23 = r2
            int r2 = r25 + r21
            short r2 = (short) r2
            r16 = 5
            r21 = r8[r16]
            char r13 = r21[r13]
            int r13 = r26 + r13
            short r13 = (short) r13
            int r11 = r11 + 1
            r25 = r2
            r21 = r10
            r26 = r13
            r24 = r23
            r2 = r29
            r10 = 0
            r13 = 20
            r23 = r22
            r22 = r15
            r15 = 1
            goto L_0x0100
        L_0x0153:
            r29 = r2
            r2 = r10
            r4[r2] = r21
            r2 = 1
            r4[r2] = r22
            r2 = 2
            r4[r2] = r23
            r2 = 3
            r4[r2] = r24
            r2 = 4
            r4[r2] = r25
            r10 = 5
            r4[r10] = r26
            goto L_0x0186
        L_0x0168:
            r29 = r2
            r2 = 4
            r10 = r5
        L_0x016c:
            if (r10 > r7) goto L_0x0186
            short[] r11 = r6.szptr
            short r11 = r11[r10]
            r13 = 0
        L_0x0173:
            if (r13 >= r14) goto L_0x0183
            short r15 = r4[r13]
            r17 = r8[r13]
            char r17 = r17[r11]
            int r15 = r15 + r17
            short r15 = (short) r15
            r4[r13] = r15
            int r13 = r13 + 1
            goto L_0x0173
        L_0x0183:
            int r10 = r10 + 1
            goto L_0x016c
        L_0x0186:
            r10 = 999999999(0x3b9ac9ff, float:0.004723787)
            r11 = -1
            r13 = 0
        L_0x018b:
            if (r13 >= r14) goto L_0x0197
            short r15 = r4[r13]
            if (r15 >= r10) goto L_0x0194
            short r10 = r4[r13]
            r11 = r13
        L_0x0194:
            int r13 = r13 + 1
            goto L_0x018b
        L_0x0197:
            r10 = r3[r11]
            r13 = 1
            int r10 = r10 + r13
            r3[r11] = r10
            char[] r10 = r6.selector
            char r13 = (char) r11
            r10[r12] = r13
            int r12 = r12 + 1
        L_0x01a4:
            if (r5 > r7) goto L_0x01b7
            r10 = r1[r11]
            short[] r13 = r6.szptr
            short r13 = r13[r5]
            r15 = r10[r13]
            r17 = 1
            int r15 = r15 + 1
            r10[r13] = r15
            int r5 = r5 + 1
            goto L_0x01a4
        L_0x01b7:
            int r5 = r7 + 1
            r2 = r29
            r7 = 2
            r10 = 0
            r13 = 20
            r15 = 1
            goto L_0x00c9
        L_0x01c2:
            r1 = 0
            int[][] r1 = (int[][]) r1
            r1 = 8
            if (r14 < r1) goto L_0x01cc
            panic()
        L_0x01cc:
            r1 = 32768(0x8000, float:4.5918E-41)
            if (r12 >= r1) goto L_0x01d5
            r1 = 18002(0x4652, float:2.5226E-41)
            if (r12 <= r1) goto L_0x01d8
        L_0x01d5:
            panic()
        L_0x01d8:
            r1 = 6
            char[] r1 = new char[r1]
            r2 = 0
        L_0x01dc:
            if (r2 >= r14) goto L_0x01e4
            char r3 = (char) r2
            r1[r2] = r3
            int r2 = r2 + 1
            goto L_0x01dc
        L_0x01e4:
            r2 = 0
        L_0x01e5:
            if (r2 >= r12) goto L_0x0205
            char[] r3 = r6.selector
            char r3 = r3[r2]
            r28 = 0
            char r4 = r1[r28]
            r5 = r28
        L_0x01f1:
            if (r3 == r4) goto L_0x01fb
            int r5 = r5 + 1
            char r7 = r1[r5]
            r1[r5] = r4
            r4 = r7
            goto L_0x01f1
        L_0x01fb:
            r1[r28] = r4
            char[] r3 = r6.selectorMtf
            char r4 = (char) r5
            r3[r2] = r4
            int r2 = r2 + 1
            goto L_0x01e5
        L_0x0205:
            r2 = 2
            int[] r1 = new int[r2]
            r1 = {6, 258} // fill-array
            java.lang.Object r0 = java.lang.reflect.Array.newInstance(r0, r1)
            r7 = r0
            int[][] r7 = (int[][]) r7
            r10 = 0
        L_0x0213:
            if (r10 >= r14) goto L_0x024d
            r0 = 32
            r3 = r0
            r0 = 0
            r4 = 0
        L_0x021a:
            if (r0 >= r9) goto L_0x0233
            r1 = r8[r10]
            char r1 = r1[r0]
            if (r1 <= r4) goto L_0x0226
            r1 = r8[r10]
            char r4 = r1[r0]
        L_0x0226:
            r1 = r8[r10]
            char r1 = r1[r0]
            if (r1 >= r3) goto L_0x0230
            r1 = r8[r10]
            char r3 = r1[r0]
        L_0x0230:
            int r0 = r0 + 1
            goto L_0x021a
        L_0x0233:
            r11 = 20
            if (r4 <= r11) goto L_0x023a
            panic()
        L_0x023a:
            r0 = 1
            if (r3 >= r0) goto L_0x0240
            panic()
        L_0x0240:
            r1 = r7[r10]
            r2 = r8[r10]
            r0 = r30
            r5 = r9
            r0.hbAssignCodes(r1, r2, r3, r4, r5)
            int r10 = r10 + 1
            goto L_0x0213
        L_0x024d:
            r0 = 16
            boolean[] r1 = new boolean[r0]
            r2 = 0
        L_0x0252:
            if (r2 >= r0) goto L_0x026c
            r3 = 0
            r1[r2] = r3
            r3 = 0
        L_0x0258:
            if (r3 >= r0) goto L_0x0269
            boolean[] r4 = r6.inUse
            int r5 = r2 * 16
            int r5 = r5 + r3
            boolean r4 = r4[r5]
            if (r4 == 0) goto L_0x0266
            r4 = 1
            r1[r2] = r4
        L_0x0266:
            int r3 = r3 + 1
            goto L_0x0258
        L_0x0269:
            int r2 = r2 + 1
            goto L_0x0252
        L_0x026c:
            r2 = 0
        L_0x026d:
            if (r2 >= r0) goto L_0x0280
            boolean r3 = r1[r2]
            if (r3 == 0) goto L_0x0278
            r3 = 1
            r6.bsW(r3, r3)
            goto L_0x027d
        L_0x0278:
            r3 = 1
            r4 = 0
            r6.bsW(r3, r4)
        L_0x027d:
            int r2 = r2 + 1
            goto L_0x026d
        L_0x0280:
            r2 = 0
        L_0x0281:
            if (r2 >= r0) goto L_0x02a3
            boolean r3 = r1[r2]
            if (r3 == 0) goto L_0x02a0
            r3 = 0
        L_0x0288:
            if (r3 >= r0) goto L_0x02a0
            boolean[] r4 = r6.inUse
            int r5 = r2 * 16
            int r5 = r5 + r3
            boolean r4 = r4[r5]
            if (r4 == 0) goto L_0x0298
            r4 = 1
            r6.bsW(r4, r4)
            goto L_0x029d
        L_0x0298:
            r4 = 1
            r5 = 0
            r6.bsW(r4, r5)
        L_0x029d:
            int r3 = r3 + 1
            goto L_0x0288
        L_0x02a0:
            int r2 = r2 + 1
            goto L_0x0281
        L_0x02a3:
            r2 = 3
            r6.bsW(r2, r14)
            r0 = 15
            r6.bsW(r0, r12)
            r0 = 0
        L_0x02ad:
            if (r0 >= r12) goto L_0x02c5
            r1 = 0
        L_0x02b0:
            char[] r2 = r6.selectorMtf
            char r2 = r2[r0]
            if (r1 >= r2) goto L_0x02bd
            r2 = 1
            r6.bsW(r2, r2)
            int r1 = r1 + 1
            goto L_0x02b0
        L_0x02bd:
            r1 = 0
            r2 = 1
            r6.bsW(r2, r1)
            int r0 = r0 + 1
            goto L_0x02ad
        L_0x02c5:
            r1 = 0
            r2 = r1
        L_0x02c7:
            if (r2 >= r14) goto L_0x02ff
            r0 = r8[r2]
            char r0 = r0[r1]
            r1 = 5
            r6.bsW(r1, r0)
            r3 = 0
        L_0x02d2:
            if (r3 >= r9) goto L_0x02f8
        L_0x02d4:
            r4 = r8[r2]
            char r4 = r4[r3]
            if (r0 >= r4) goto L_0x02e1
            r4 = 2
            r6.bsW(r4, r4)
            int r0 = r0 + 1
            goto L_0x02d4
        L_0x02e1:
            r4 = 2
        L_0x02e2:
            r5 = r8[r2]
            char r5 = r5[r3]
            if (r0 <= r5) goto L_0x02ef
            r5 = 3
            r6.bsW(r4, r5)
            int r0 = r0 + -1
            goto L_0x02e2
        L_0x02ef:
            r5 = 3
            r10 = 0
            r11 = 1
            r6.bsW(r11, r10)
            int r3 = r3 + 1
            goto L_0x02d2
        L_0x02f8:
            r4 = 2
            r5 = 3
            r10 = 0
            int r2 = r2 + 1
            r1 = r10
            goto L_0x02c7
        L_0x02ff:
            r10 = r1
            r0 = r10
        L_0x0301:
            int r1 = r6.nMTF
            if (r10 < r1) goto L_0x030b
            if (r0 == r12) goto L_0x030a
            panic()
        L_0x030a:
            return
        L_0x030b:
            int r2 = r10 + 50
            r3 = 1
            int r2 = r2 - r3
            if (r2 < r1) goto L_0x0313
            int r2 = r1 + -1
        L_0x0313:
            if (r10 > r2) goto L_0x032f
            char[] r1 = r6.selector
            char r4 = r1[r0]
            r4 = r8[r4]
            short[] r5 = r6.szptr
            short r9 = r5[r10]
            char r4 = r4[r9]
            char r1 = r1[r0]
            r1 = r7[r1]
            short r5 = r5[r10]
            r1 = r1[r5]
            r6.bsW(r4, r1)
            int r10 = r10 + 1
            goto L_0x0313
        L_0x032f:
            int r10 = r2 + 1
            int r0 = r0 + 1
            goto L_0x0301
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.apache.bzip2.CBZip2OutputStream.sendMTFValues():void");
    }

    private void moveToFrontCodeAndSend() throws IOException {
        bsPutIntVS(24, this.origPtr);
        generateMTFValues();
        sendMTFValues();
    }

    private void simpleSort(int i, int i2, int i3) {
        int i4 = (i2 - i) + 1;
        if (i4 >= 2) {
            int i5 = 0;
            while (this.incs[i5] < i4) {
                i5++;
            }
            while (true) {
                i5--;
                if (i5 >= 0) {
                    int i6 = this.incs[i5];
                    int i7 = i + i6;
                    int i8 = i7;
                    while (i8 <= i2) {
                        int i9 = this.zptr[i8];
                        int i10 = i8;
                        while (true) {
                            int i11 = i10 - i6;
                            if (!fullGtU(this.zptr[i11] + i3, i9 + i3)) {
                                break;
                            }
                            int[] iArr = this.zptr;
                            iArr[i10] = iArr[i11];
                            if (i11 <= i7 - 1) {
                                i10 = i11;
                                break;
                            }
                            i10 = i11;
                        }
                        int[] iArr2 = this.zptr;
                        iArr2[i10] = i9;
                        int i12 = i8 + 1;
                        if (i12 > i2) {
                            continue;
                            break;
                        }
                        int i13 = iArr2[i12];
                        int i14 = i12;
                        while (true) {
                            int i15 = i14 - i6;
                            if (!fullGtU(this.zptr[i15] + i3, i13 + i3)) {
                                break;
                            }
                            int[] iArr3 = this.zptr;
                            iArr3[i14] = iArr3[i15];
                            if (i15 <= i7 - 1) {
                                i14 = i15;
                                break;
                            }
                            i14 = i15;
                        }
                        int[] iArr4 = this.zptr;
                        iArr4[i14] = i13;
                        int i16 = i12 + 1;
                        if (i16 > i2) {
                            continue;
                            break;
                        }
                        int i17 = iArr4[i16];
                        int i18 = i16;
                        while (true) {
                            int i19 = i18 - i6;
                            if (!fullGtU(this.zptr[i19] + i3, i17 + i3)) {
                                break;
                            }
                            int[] iArr5 = this.zptr;
                            iArr5[i18] = iArr5[i19];
                            if (i19 <= i7 - 1) {
                                i18 = i19;
                                break;
                            }
                            i18 = i19;
                        }
                        this.zptr[i18] = i17;
                        i8 = i16 + 1;
                        if (this.workDone > this.workLimit && this.firstAttempt) {
                            return;
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void vswap(int i, int i2, int i3) {
        while (i3 > 0) {
            int[] iArr = this.zptr;
            int i4 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i4;
            i++;
            i2++;
            i3--;
        }
    }

    private static class StackElem {
        int dd;
        int hh;
        int ll;

        private StackElem() {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0080, code lost:
        if (r9 > 0) goto L_0x0082;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void qSort3(int r13, int r14, int r15) {
        /*
            r12 = this;
            r0 = 1000(0x3e8, float:1.401E-42)
            org.spongycastle.apache.bzip2.CBZip2OutputStream$StackElem[] r1 = new org.spongycastle.apache.bzip2.CBZip2OutputStream.StackElem[r0]
            r2 = 0
            r3 = r2
        L_0x0006:
            if (r3 >= r0) goto L_0x0013
            org.spongycastle.apache.bzip2.CBZip2OutputStream$StackElem r4 = new org.spongycastle.apache.bzip2.CBZip2OutputStream$StackElem
            r5 = 0
            r4.<init>()
            r1[r3] = r4
            int r3 = r3 + 1
            goto L_0x0006
        L_0x0013:
            r3 = r1[r2]
            r3.ll = r13
            r13 = r1[r2]
            r13.hh = r14
            r13 = r1[r2]
            r13.dd = r15
            r13 = 1
            r14 = r13
        L_0x0021:
            if (r14 <= 0) goto L_0x0123
            if (r14 < r0) goto L_0x0028
            panic()
        L_0x0028:
            int r14 = r14 + -1
            r15 = r1[r14]
            int r15 = r15.ll
            r2 = r1[r14]
            int r2 = r2.hh
            r3 = r1[r14]
            int r3 = r3.dd
            int r4 = r2 - r15
            r5 = 20
            if (r4 < r5) goto L_0x0116
            r4 = 10
            if (r3 <= r4) goto L_0x0042
            goto L_0x0116
        L_0x0042:
            char[] r4 = r12.block
            int[] r5 = r12.zptr
            r6 = r5[r15]
            int r6 = r6 + r3
            int r6 = r6 + r13
            char r6 = r4[r6]
            r7 = r5[r2]
            int r7 = r7 + r3
            int r7 = r7 + r13
            char r7 = r4[r7]
            int r8 = r15 + r2
            int r8 = r8 >> r13
            r5 = r5[r8]
            int r5 = r5 + r3
            int r5 = r5 + r13
            char r4 = r4[r5]
            char r4 = r12.med3(r6, r7, r4)
            r5 = r15
            r7 = r5
            r6 = r2
            r8 = r6
        L_0x0063:
            if (r5 <= r6) goto L_0x0066
            goto L_0x0082
        L_0x0066:
            char[] r9 = r12.block
            int[] r10 = r12.zptr
            r11 = r10[r5]
            int r11 = r11 + r3
            int r11 = r11 + r13
            char r9 = r9[r11]
            int r9 = r9 - r4
            if (r9 != 0) goto L_0x0080
            r9 = r10[r5]
            r11 = r10[r7]
            r10[r5] = r11
            r10[r7] = r9
            int r7 = r7 + 1
        L_0x007d:
            int r5 = r5 + 1
            goto L_0x0063
        L_0x0080:
            if (r9 <= 0) goto L_0x007d
        L_0x0082:
            if (r5 <= r6) goto L_0x0085
            goto L_0x00a1
        L_0x0085:
            char[] r9 = r12.block
            int[] r10 = r12.zptr
            r11 = r10[r6]
            int r11 = r11 + r3
            int r11 = r11 + r13
            char r9 = r9[r11]
            int r9 = r9 - r4
            if (r9 != 0) goto L_0x009f
            r9 = r10[r6]
            r11 = r10[r8]
            r10[r6] = r11
            r10[r8] = r9
            int r8 = r8 + -1
        L_0x009c:
            int r6 = r6 + -1
            goto L_0x0082
        L_0x009f:
            if (r9 >= 0) goto L_0x009c
        L_0x00a1:
            if (r5 <= r6) goto L_0x0106
            if (r8 >= r7) goto L_0x00b7
            r4 = r1[r14]
            r4.ll = r15
            r15 = r1[r14]
            r15.hh = r2
            r15 = r1[r14]
            int r3 = r3 + 1
            r15.dd = r3
            int r14 = r14 + 1
            goto L_0x0021
        L_0x00b7:
            int r4 = r7 - r15
            int r9 = r5 - r7
            if (r4 >= r9) goto L_0x00be
            goto L_0x00bf
        L_0x00be:
            r4 = r9
        L_0x00bf:
            int r9 = r5 - r4
            r12.vswap(r15, r9, r4)
            int r4 = r2 - r8
            int r8 = r8 - r6
            if (r4 >= r8) goto L_0x00ca
            goto L_0x00cb
        L_0x00ca:
            r4 = r8
        L_0x00cb:
            int r6 = r2 - r4
            int r6 = r6 + r13
            r12.vswap(r5, r6, r4)
            int r5 = r5 + r15
            int r5 = r5 - r7
            int r5 = r5 - r13
            int r4 = r2 - r8
            int r4 = r4 + r13
            r6 = r1[r14]
            r6.ll = r15
            r15 = r1[r14]
            r15.hh = r5
            r15 = r1[r14]
            r15.dd = r3
            int r14 = r14 + 1
            r15 = r1[r14]
            int r5 = r5 + r13
            r15.ll = r5
            r15 = r1[r14]
            int r5 = r4 + -1
            r15.hh = r5
            r15 = r1[r14]
            int r5 = r3 + 1
            r15.dd = r5
            int r14 = r14 + r13
            r15 = r1[r14]
            r15.ll = r4
            r15 = r1[r14]
            r15.hh = r2
            r15 = r1[r14]
            r15.dd = r3
            int r14 = r14 + r13
            goto L_0x0021
        L_0x0106:
            int[] r9 = r12.zptr
            r10 = r9[r5]
            r11 = r9[r6]
            r9[r5] = r11
            r9[r6] = r10
            int r5 = r5 + 1
            int r6 = r6 + -1
            goto L_0x0063
        L_0x0116:
            r12.simpleSort(r15, r2, r3)
            int r15 = r12.workDone
            int r2 = r12.workLimit
            if (r15 <= r2) goto L_0x0021
            boolean r15 = r12.firstAttempt
            if (r15 == 0) goto L_0x0021
        L_0x0123:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.apache.bzip2.CBZip2OutputStream.qSort3(int, int, int):void");
    }

    private void mainSort() {
        int i;
        int i2;
        int i3;
        int i4;
        int[] iArr = new int[256];
        int[] iArr2 = new int[256];
        boolean[] zArr = new boolean[256];
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i = 2;
            i2 = 20;
            if (i6 >= 20) {
                break;
            }
            char[] cArr = this.block;
            int i7 = this.last;
            cArr[i7 + i6 + 2] = cArr[(i6 % (i7 + 1)) + 1];
            i6++;
        }
        int i8 = 0;
        while (true) {
            i3 = this.last;
            if (i8 > i3 + 20) {
                break;
            }
            this.quadrant[i8] = 0;
            i8++;
        }
        char[] cArr2 = this.block;
        cArr2[0] = cArr2[i3 + 1];
        if (i3 < 4000) {
            int i9 = 0;
            while (true) {
                int i10 = this.last;
                if (i9 <= i10) {
                    this.zptr[i9] = i9;
                    i9++;
                } else {
                    this.firstAttempt = false;
                    this.workLimit = 0;
                    this.workDone = 0;
                    simpleSort(0, i10, 0);
                    return;
                }
            }
        } else {
            for (int i11 = 0; i11 <= 255; i11++) {
                zArr[i11] = false;
            }
            for (int i12 = 0; i12 <= 65536; i12++) {
                this.ftab[i12] = 0;
            }
            char c = this.block[0];
            int i13 = 0;
            while (i13 <= this.last) {
                i13++;
                char c2 = this.block[i13];
                int[] iArr3 = this.ftab;
                int i14 = (c << 8) + c2;
                iArr3[i14] = iArr3[i14] + 1;
                c = c2;
            }
            for (int i15 = 1; i15 <= 65536; i15++) {
                int[] iArr4 = this.ftab;
                iArr4[i15] = iArr4[i15] + iArr4[i15 - 1];
            }
            char c3 = this.block[1];
            int i16 = 0;
            while (true) {
                i4 = this.last;
                if (i16 >= i4) {
                    break;
                }
                char c4 = this.block[i16 + 2];
                int i17 = (c3 << 8) + c4;
                int[] iArr5 = this.ftab;
                iArr5[i17] = iArr5[i17] - 1;
                this.zptr[iArr5[i17]] = i16;
                i16++;
                c3 = c4;
            }
            char[] cArr3 = this.block;
            int i18 = (cArr3[i4 + 1] << 8) + cArr3[1];
            int[] iArr6 = this.ftab;
            iArr6[i18] = iArr6[i18] - 1;
            this.zptr[iArr6[i18]] = i4;
            for (int i19 = 0; i19 <= 255; i19++) {
                iArr[i19] = i19;
            }
            int i20 = 1;
            do {
                i20 = (i20 * 3) + 1;
            } while (i20 <= 256);
            do {
                i20 /= 3;
                for (int i21 = i20; i21 <= 255; i21++) {
                    int i22 = iArr[i21];
                    int i23 = i21;
                    while (true) {
                        int[] iArr7 = this.ftab;
                        int i24 = i23 - i20;
                        if (iArr7[(iArr[i24] + 1) << 8] - iArr7[iArr[i24] << 8] <= iArr7[(i22 + 1) << 8] - iArr7[i22 << 8]) {
                            break;
                        }
                        iArr[i23] = iArr[i24];
                        if (i24 <= i20 - 1) {
                            i23 = i24;
                            break;
                        }
                        i23 = i24;
                    }
                    iArr[i23] = i22;
                }
            } while (i20 != 1);
            int i25 = 0;
            while (i25 <= 255) {
                int i26 = iArr[i25];
                for (int i27 = i5; i27 <= 255; i27++) {
                    int i28 = (i26 << 8) + i27;
                    int[] iArr8 = this.ftab;
                    if ((iArr8[i28] & 2097152) != 2097152) {
                        int i29 = iArr8[i28] & CLEARMASK;
                        int i30 = (CLEARMASK & iArr8[i28 + 1]) - 1;
                        if (i30 > i29) {
                            qSort3(i29, i30, i);
                            if (this.workDone > this.workLimit && this.firstAttempt) {
                                return;
                            }
                        }
                        int[] iArr9 = this.ftab;
                        iArr9[i28] = 2097152 | iArr9[i28];
                    }
                }
                zArr[i26] = true;
                if (i25 < 255) {
                    int[] iArr10 = this.ftab;
                    int i31 = iArr10[i26 << 8] & CLEARMASK;
                    int i32 = (iArr10[(i26 + 1) << 8] & CLEARMASK) - i31;
                    int i33 = 0;
                    while ((i32 >> i33) > 65534) {
                        i33++;
                    }
                    int i34 = 0;
                    while (i34 < i32) {
                        int i35 = this.zptr[i31 + i34];
                        int i36 = i34 >> i33;
                        int[] iArr11 = this.quadrant;
                        iArr11[i35] = i36;
                        if (i35 < i2) {
                            iArr11[i35 + this.last + 1] = i36;
                        }
                        i34++;
                        i2 = 20;
                    }
                    if (((i32 - 1) >> i33) > 65535) {
                        panic();
                    }
                }
                for (int i37 = 0; i37 <= 255; i37++) {
                    iArr2[i37] = this.ftab[(i37 << 8) + i26] & CLEARMASK;
                }
                for (int i38 = this.ftab[i26 << 8] & CLEARMASK; i38 < (this.ftab[(i26 + 1) << 8] & CLEARMASK); i38++) {
                    char[] cArr4 = this.block;
                    int[] iArr12 = this.zptr;
                    char c5 = cArr4[iArr12[i38]];
                    if (!zArr[c5]) {
                        iArr12[iArr2[c5]] = iArr12[i38] == 0 ? this.last : iArr12[i38] - 1;
                        iArr2[c5] = iArr2[c5] + 1;
                    }
                }
                for (int i39 = 0; i39 <= 255; i39++) {
                    int[] iArr13 = this.ftab;
                    int i40 = (i39 << 8) + i26;
                    iArr13[i40] = iArr13[i40] | 2097152;
                }
                i25++;
                i5 = 0;
                i = 2;
                i2 = 20;
            }
        }
    }

    private void randomiseBlock() {
        for (int i = 0; i < 256; i++) {
            this.inUse[i] = false;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 <= this.last) {
            if (i3 == 0) {
                i3 = (char) rNums[i4];
                i4++;
                if (i4 == 512) {
                    i4 = 0;
                }
            }
            i3--;
            char[] cArr = this.block;
            i2++;
            cArr[i2] = (char) (cArr[i2] ^ (i3 == 1 ? (char) 1 : 0));
            cArr[i2] = (char) (cArr[i2] & 255);
            this.inUse[cArr[i2]] = true;
        }
    }

    private void doReversibleTransformation() {
        this.workLimit = this.workFactor * this.last;
        int i = 0;
        this.workDone = 0;
        this.blockRandomised = false;
        this.firstAttempt = true;
        mainSort();
        if (this.workDone > this.workLimit && this.firstAttempt) {
            randomiseBlock();
            this.workDone = 0;
            this.workLimit = 0;
            this.blockRandomised = true;
            this.firstAttempt = false;
            mainSort();
        }
        this.origPtr = -1;
        while (true) {
            if (i > this.last) {
                break;
            } else if (this.zptr[i] == 0) {
                this.origPtr = i;
                break;
            } else {
                i++;
            }
        }
        if (this.origPtr == -1) {
            panic();
        }
    }

    private boolean fullGtU(int i, int i2) {
        char[] cArr = this.block;
        int i3 = i + 1;
        char c = cArr[i3];
        int i4 = i2 + 1;
        char c2 = cArr[i4];
        if (c == c2) {
            int i5 = i3 + 1;
            char c3 = cArr[i5];
            int i6 = i4 + 1;
            char c4 = cArr[i6];
            if (c3 == c4) {
                int i7 = i5 + 1;
                char c5 = cArr[i7];
                int i8 = i6 + 1;
                char c6 = cArr[i8];
                if (c5 == c6) {
                    int i9 = i7 + 1;
                    char c7 = cArr[i9];
                    int i10 = i8 + 1;
                    char c8 = cArr[i10];
                    if (c7 == c8) {
                        int i11 = i9 + 1;
                        char c9 = cArr[i11];
                        int i12 = i10 + 1;
                        char c10 = cArr[i12];
                        if (c9 == c10) {
                            int i13 = i11 + 1;
                            char c11 = cArr[i13];
                            int i14 = i12 + 1;
                            char c12 = cArr[i14];
                            if (c11 == c12) {
                                int i15 = this.last + 1;
                                do {
                                    char[] cArr2 = this.block;
                                    int i16 = i13 + 1;
                                    char c13 = cArr2[i16];
                                    int i17 = i14 + 1;
                                    char c14 = cArr2[i17];
                                    if (c13 == c14) {
                                        int[] iArr = this.quadrant;
                                        int i18 = iArr[i13];
                                        int i19 = iArr[i14];
                                        if (i18 == i19) {
                                            int i20 = i16 + 1;
                                            char c15 = cArr2[i20];
                                            int i21 = i17 + 1;
                                            char c16 = cArr2[i21];
                                            if (c15 == c16) {
                                                int i22 = iArr[i16];
                                                int i23 = iArr[i17];
                                                if (i22 == i23) {
                                                    int i24 = i20 + 1;
                                                    char c17 = cArr2[i24];
                                                    int i25 = i21 + 1;
                                                    char c18 = cArr2[i25];
                                                    if (c17 == c18) {
                                                        int i26 = iArr[i20];
                                                        int i27 = iArr[i21];
                                                        if (i26 == i27) {
                                                            i13 = i24 + 1;
                                                            char c19 = cArr2[i13];
                                                            int i28 = i25 + 1;
                                                            char c20 = cArr2[i28];
                                                            if (c19 == c20) {
                                                                int i29 = iArr[i24];
                                                                int i30 = iArr[i25];
                                                                if (i29 == i30) {
                                                                    int i31 = this.last;
                                                                    if (i13 > i31) {
                                                                        i13 = (i13 - i31) - 1;
                                                                    }
                                                                    if (i28 > i31) {
                                                                        i28 = (i28 - i31) - 1;
                                                                    }
                                                                    i14 = i28;
                                                                    i15 -= 4;
                                                                    this.workDone++;
                                                                } else if (i29 > i30) {
                                                                    return true;
                                                                } else {
                                                                    return false;
                                                                }
                                                            } else if (c19 > c20) {
                                                                return true;
                                                            } else {
                                                                return false;
                                                            }
                                                        } else if (i26 > i27) {
                                                            return true;
                                                        } else {
                                                            return false;
                                                        }
                                                    } else if (c17 > c18) {
                                                        return true;
                                                    } else {
                                                        return false;
                                                    }
                                                } else if (i22 > i23) {
                                                    return true;
                                                } else {
                                                    return false;
                                                }
                                            } else if (c15 > c16) {
                                                return true;
                                            } else {
                                                return false;
                                            }
                                        } else if (i18 > i19) {
                                            return true;
                                        } else {
                                            return false;
                                        }
                                    } else if (c13 > c14) {
                                        return true;
                                    } else {
                                        return false;
                                    }
                                } while (i15 >= 0);
                                return false;
                            } else if (c11 > c12) {
                                return true;
                            } else {
                                return false;
                            }
                        } else if (c9 > c10) {
                            return true;
                        } else {
                            return false;
                        }
                    } else if (c7 > c8) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (c5 > c6) {
                    return true;
                } else {
                    return false;
                }
            } else if (c3 > c4) {
                return true;
            } else {
                return false;
            }
        } else if (c > c2) {
            return true;
        } else {
            return false;
        }
    }

    private void allocateCompressStructures() {
        int i = this.blockSize100k * BZip2Constants.baseBlockSize;
        this.block = new char[(i + 1 + 20)];
        this.quadrant = new int[(i + 20)];
        this.zptr = new int[i];
        this.ftab = new int[65537];
        this.szptr = new short[(i * 2)];
    }

    private void generateMTFValues() {
        char[] cArr = new char[256];
        makeMaps();
        int i = this.nInUse + 1;
        for (int i2 = 0; i2 <= i; i2++) {
            this.mtfFreq[i2] = 0;
        }
        for (int i3 = 0; i3 < this.nInUse; i3++) {
            cArr[i3] = (char) i3;
        }
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 <= this.last; i6++) {
            char c = this.unseqToSeq[this.block[this.zptr[i6]]];
            char c2 = cArr[0];
            int i7 = 0;
            while (c != c2) {
                i7++;
                char c3 = cArr[i7];
                cArr[i7] = c2;
                c2 = c3;
            }
            cArr[0] = c2;
            if (i7 == 0) {
                i4++;
            } else {
                if (i4 > 0) {
                    int i8 = i4 - 1;
                    while (true) {
                        int i9 = i8 % 2;
                        if (i9 == 0) {
                            this.szptr[i5] = 0;
                            i5++;
                            int[] iArr = this.mtfFreq;
                            iArr[0] = iArr[0] + 1;
                        } else if (i9 == 1) {
                            this.szptr[i5] = 1;
                            i5++;
                            int[] iArr2 = this.mtfFreq;
                            iArr2[1] = iArr2[1] + 1;
                        }
                        if (i8 < 2) {
                            break;
                        }
                        i8 = (i8 - 2) / 2;
                    }
                    i4 = 0;
                }
                int i10 = i7 + 1;
                this.szptr[i5] = (short) i10;
                i5++;
                int[] iArr3 = this.mtfFreq;
                iArr3[i10] = iArr3[i10] + 1;
            }
        }
        if (i4 > 0) {
            int i11 = i4 - 1;
            while (true) {
                int i12 = i11 % 2;
                if (i12 == 0) {
                    this.szptr[i5] = 0;
                    i5++;
                    int[] iArr4 = this.mtfFreq;
                    iArr4[0] = iArr4[0] + 1;
                } else if (i12 == 1) {
                    this.szptr[i5] = 1;
                    i5++;
                    int[] iArr5 = this.mtfFreq;
                    iArr5[1] = iArr5[1] + 1;
                }
                if (i11 < 2) {
                    break;
                }
                i11 = (i11 - 2) / 2;
            }
        }
        this.szptr[i5] = (short) i;
        int[] iArr6 = this.mtfFreq;
        iArr6[i] = iArr6[i] + 1;
        this.nMTF = i5 + 1;
    }
}
