package org.spongycastle.pqc.crypto.newhope;

import com.drew.metadata.exif.makernotes.CasioType2MakernoteDirectory;
import kotlin.UShort;

class Reduce {
    static final int QInv = 12287;
    static final int RLog = 18;
    static final int RMask = 262143;

    static short barrett(short s) {
        short s2 = s & UShort.MAX_VALUE;
        return (short) (s2 - (((s2 * 5) >>> 16) * CasioType2MakernoteDirectory.TAG_SELF_TIMER));
    }

    static short montgomery(int i) {
        return (short) (((((i * QInv) & RMask) * CasioType2MakernoteDirectory.TAG_SELF_TIMER) + i) >>> 18);
    }

    Reduce() {
    }
}
