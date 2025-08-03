package com.drew.lang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

public final class StringUtil {
    public static String join(Iterable<? extends CharSequence> iterable, String str) {
        int length = str.length();
        Iterator<? extends CharSequence> it2 = iterable.iterator();
        int i = 0;
        if (it2.hasNext()) {
            i = 0 + ((CharSequence) it2.next()).length() + length;
        }
        StringBuilder sb = new StringBuilder(i);
        Iterator<? extends CharSequence> it3 = iterable.iterator();
        if (it3.hasNext()) {
            sb.append((CharSequence) it3.next());
            while (it3.hasNext()) {
                sb.append(str);
                sb.append((CharSequence) it3.next());
            }
        }
        return sb.toString();
    }

    public static <T extends CharSequence> String join(T[] tArr, String str) {
        int length = str.length();
        int i = 0;
        for (T length2 : tArr) {
            i += length2.length() + length;
        }
        StringBuilder sb = new StringBuilder(i);
        boolean z = true;
        for (T t : tArr) {
            if (!z) {
                sb.append(str);
            } else {
                z = false;
            }
            sb.append(t);
        }
        return sb.toString();
    }

    public static String fromStream(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return sb.toString();
            }
            sb.append(readLine);
        }
    }

    public static int compare(String str, String str2) {
        boolean z = str == null;
        boolean z2 = str2 == null;
        if (z && z2) {
            return 0;
        }
        if (z) {
            return -1;
        }
        if (z2) {
            return 1;
        }
        return str.compareTo(str2);
    }

    public static String urlEncode(String str) {
        return str.replace(" ", "%20");
    }
}
