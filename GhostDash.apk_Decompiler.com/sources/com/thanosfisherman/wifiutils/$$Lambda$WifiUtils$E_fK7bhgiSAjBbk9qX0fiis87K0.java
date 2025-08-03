package com.thanosfisherman.wifiutils;

import androidx.core.util.Consumer;
import com.thanosfisherman.wifiutils.wifiScan.ScanResultsListener;
import java.util.ArrayList;

/* renamed from: com.thanosfisherman.wifiutils.-$$Lambda$WifiUtils$E_fK7bhgiSAjBbk9qX0fiis87K0  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$WifiUtils$E_fK7bhgiSAjBbk9qX0fiis87K0 implements Consumer {
    public static final /* synthetic */ $$Lambda$WifiUtils$E_fK7bhgiSAjBbk9qX0fiis87K0 INSTANCE = new $$Lambda$WifiUtils$E_fK7bhgiSAjBbk9qX0fiis87K0();

    private /* synthetic */ $$Lambda$WifiUtils$E_fK7bhgiSAjBbk9qX0fiis87K0() {
    }

    public final void accept(Object obj) {
        ((ScanResultsListener) obj).onScanResults(new ArrayList());
    }
}
