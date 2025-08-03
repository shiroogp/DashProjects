package com.thanosfisherman.wifiutils;

import android.net.wifi.WifiConfiguration;
import java.util.Comparator;

/* renamed from: com.thanosfisherman.wifiutils.-$$Lambda$ConnectorUtils$ZuxQRZn2nCxLMJI92xEN0dF42sw  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ConnectorUtils$ZuxQRZn2nCxLMJI92xEN0dF42sw implements Comparator {
    public static final /* synthetic */ $$Lambda$ConnectorUtils$ZuxQRZn2nCxLMJI92xEN0dF42sw INSTANCE = new $$Lambda$ConnectorUtils$ZuxQRZn2nCxLMJI92xEN0dF42sw();

    private /* synthetic */ $$Lambda$ConnectorUtils$ZuxQRZn2nCxLMJI92xEN0dF42sw() {
    }

    public final int compare(Object obj, Object obj2) {
        return ConnectorUtils.lambda$sortByPriority$2((WifiConfiguration) obj, (WifiConfiguration) obj2);
    }
}
