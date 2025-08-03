package com.thanosfisherman.wifiutils.utils;

import android.text.TextUtils;

public class SSIDUtils {
    public static String convertToQuotedString(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int length = str.length() - 1;
        if (length >= 0) {
            return (str.charAt(0) == '\"' && str.charAt(length) == '\"') ? str : "\"" + str + "\"";
        }
        return str;
    }
}
