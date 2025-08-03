package com.thanosfisherman.wifiutils.wifiConnect;

import android.net.wifi.ScanResult;
import androidx.arch.core.util.Function;

/* renamed from: com.thanosfisherman.wifiutils.wifiConnect.-$$Lambda$TimeoutHandler$1$gBk2DqUip7Jc5LW6L_Mk07R2Exc  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$TimeoutHandler$1$gBk2DqUip7Jc5LW6L_Mk07R2Exc implements Function {
    public static final /* synthetic */ $$Lambda$TimeoutHandler$1$gBk2DqUip7Jc5LW6L_Mk07R2Exc INSTANCE = new $$Lambda$TimeoutHandler$1$gBk2DqUip7Jc5LW6L_Mk07R2Exc();

    private /* synthetic */ $$Lambda$TimeoutHandler$1$gBk2DqUip7Jc5LW6L_Mk07R2Exc() {
    }

    public final Object apply(Object obj) {
        return ((ScanResult) obj).BSSID;
    }
}
