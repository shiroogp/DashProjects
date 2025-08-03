package com.thanosfisherman.wifiutils;

import android.net.ConnectivityManager;
import androidx.arch.core.util.Function;

/* renamed from: com.thanosfisherman.wifiutils.-$$Lambda$ConnectorUtils$xHcNDFCgUnUjBAwiusO0maarZNQ  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ConnectorUtils$xHcNDFCgUnUjBAwiusO0maarZNQ implements Function {
    public static final /* synthetic */ $$Lambda$ConnectorUtils$xHcNDFCgUnUjBAwiusO0maarZNQ INSTANCE = new $$Lambda$ConnectorUtils$xHcNDFCgUnUjBAwiusO0maarZNQ();

    private /* synthetic */ $$Lambda$ConnectorUtils$xHcNDFCgUnUjBAwiusO0maarZNQ() {
    }

    public final Object apply(Object obj) {
        return ((ConnectivityManager) obj).getNetworkInfo(1);
    }
}
