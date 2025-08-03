package com.swmansion.rnscreens;

import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/swmansion/rnscreens/Screen$updateScreenSizePaper$1", "Lcom/facebook/react/bridge/GuardedRunnable;", "runGuarded", "", "react-native-screens_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: Screen.kt */
public final class Screen$updateScreenSizePaper$1 extends GuardedRunnable {
    final /* synthetic */ int $height;
    final /* synthetic */ ReactContext $reactContext;
    final /* synthetic */ int $width;
    final /* synthetic */ Screen this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Screen$updateScreenSizePaper$1(Screen screen, ReactContext reactContext, int i, int i2, ReactContext reactContext2) {
        super(reactContext2);
        this.this$0 = screen;
        this.$reactContext = reactContext;
        this.$width = i;
        this.$height = i2;
    }

    public void runGuarded() {
        UIManagerModule uIManagerModule = (UIManagerModule) this.$reactContext.getNativeModule(UIManagerModule.class);
        if (uIManagerModule != null) {
            uIManagerModule.updateNodeSize(this.this$0.getId(), this.$width, this.$height);
        }
    }
}
