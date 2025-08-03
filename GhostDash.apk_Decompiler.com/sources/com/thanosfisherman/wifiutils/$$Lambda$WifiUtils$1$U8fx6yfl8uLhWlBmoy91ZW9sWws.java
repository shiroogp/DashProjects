package com.thanosfisherman.wifiutils;

import androidx.core.util.Consumer;
import com.thanosfisherman.wifiutils.wifiScan.ScanResultsListener;
import java.util.ArrayList;

/* renamed from: com.thanosfisherman.wifiutils.-$$Lambda$WifiUtils$1$U8fx6yfl8uLhWlBmoy91ZW9sWws  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$WifiUtils$1$U8fx6yfl8uLhWlBmoy91ZW9sWws implements Consumer {
    public static final /* synthetic */ $$Lambda$WifiUtils$1$U8fx6yfl8uLhWlBmoy91ZW9sWws INSTANCE = new $$Lambda$WifiUtils$1$U8fx6yfl8uLhWlBmoy91ZW9sWws();

    private /* synthetic */ $$Lambda$WifiUtils$1$U8fx6yfl8uLhWlBmoy91ZW9sWws() {
    }

    public final void accept(Object obj) {
        ((ScanResultsListener) obj).onScanResults(new ArrayList());
    }
}
