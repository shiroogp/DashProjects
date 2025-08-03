package com.google.android.gms.internal.p001authapi;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.google.android.gms.auth.api.credentials.CredentialsApi;

/* renamed from: com.google.android.gms.internal.auth-api.zbbc  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbbc {
    public static final int zba;

    static {
        int i = 33554432;
        if (Build.VERSION.SDK_INT < 31 && (Build.VERSION.SDK_INT < 30 || Build.VERSION.CODENAME.length() != 1 || Build.VERSION.CODENAME.charAt(0) < 'S' || Build.VERSION.CODENAME.charAt(0) > 'Z')) {
            i = 0;
        }
        zba = i;
    }

    public static PendingIntent zba(Context context, int i, Intent intent, int i2) {
        return PendingIntent.getActivity(context, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, intent, i2);
    }
}
