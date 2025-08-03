package com.google.firebase.database.core.utilities;

import com.google.firebase.database.snapshot.ChildKey;
import java.util.Random;

public class PushIdGenerator {
    private static final int MAX_KEY_LEN = 786;
    private static final char MAX_PUSH_CHAR = 'z';
    private static final char MIN_PUSH_CHAR = '-';
    private static final String PUSH_CHARS = "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz";
    private static long lastPushTime = 0;
    private static final int[] lastRandChars = new int[12];
    private static final Random randGen = new Random();

    public static synchronized String generatePushChildName(long j) {
        String sb;
        synchronized (PushIdGenerator.class) {
            boolean z = true;
            boolean z2 = j == lastPushTime;
            lastPushTime = j;
            char[] cArr = new char[8];
            StringBuilder sb2 = new StringBuilder(20);
            for (int i = 7; i >= 0; i--) {
                cArr[i] = PUSH_CHARS.charAt((int) (j % 64));
                j /= 64;
            }
            Utilities.hardAssert(j == 0);
            sb2.append(cArr);
            if (!z2) {
                for (int i2 = 0; i2 < 12; i2++) {
                    lastRandChars[i2] = randGen.nextInt(64);
                }
            } else {
                incrementArray();
            }
            for (int i3 = 0; i3 < 12; i3++) {
                sb2.append(PUSH_CHARS.charAt(lastRandChars[i3]));
            }
            if (sb2.length() != 20) {
                z = false;
            }
            Utilities.hardAssert(z);
            sb = sb2.toString();
        }
        return sb;
    }

    public static final String predecessor(String str) {
        Validation.validateNullableKey(str);
        Integer tryParseInt = Utilities.tryParseInt(str);
        if (tryParseInt == null) {
            StringBuilder sb = new StringBuilder(str);
            if (sb.charAt(sb.length() - 1) != '-') {
                sb.setCharAt(sb.length() - 1, PUSH_CHARS.charAt(PUSH_CHARS.indexOf(sb.charAt(sb.length() - 1)) - 1));
                return sb.append(new String(new char[(786 - sb.length())]).replace("\u0000", "z")).toString();
            } else if (sb.length() == 1) {
                return String.valueOf(Integer.MAX_VALUE);
            } else {
                return sb.substring(0, sb.length() - 1);
            }
        } else if (tryParseInt.intValue() == Integer.MIN_VALUE) {
            return ChildKey.MIN_KEY_NAME;
        } else {
            return String.valueOf(tryParseInt.intValue() - 1);
        }
    }

    public static final String successor(String str) {
        Validation.validateNullableKey(str);
        Integer tryParseInt = Utilities.tryParseInt(str);
        if (tryParseInt == null) {
            StringBuilder sb = new StringBuilder(str);
            if (sb.length() < 786) {
                sb.append(MIN_PUSH_CHAR);
                return sb.toString();
            }
            int length = sb.length() - 1;
            while (length >= 0 && sb.charAt(length) == 'z') {
                length--;
            }
            if (length == -1) {
                return ChildKey.MAX_KEY_NAME;
            }
            int i = length + 1;
            sb.replace(length, i, String.valueOf(PUSH_CHARS.charAt(PUSH_CHARS.indexOf(sb.charAt(length)) + 1)));
            return sb.substring(0, i);
        } else if (tryParseInt.intValue() == Integer.MAX_VALUE) {
            return String.valueOf(MIN_PUSH_CHAR);
        } else {
            return String.valueOf(tryParseInt.intValue() + 1);
        }
    }

    private static void incrementArray() {
        int i = 11;
        while (i >= 0) {
            int[] iArr = lastRandChars;
            if (iArr[i] != 63) {
                iArr[i] = iArr[i] + 1;
                return;
            } else {
                iArr[i] = 0;
                i--;
            }
        }
    }
}
