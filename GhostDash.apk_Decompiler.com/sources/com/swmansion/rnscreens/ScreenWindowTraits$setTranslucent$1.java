package com.swmansion.rnscreens;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import androidx.core.view.ViewCompat;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017¨\u0006\u0004"}, d2 = {"com/swmansion/rnscreens/ScreenWindowTraits$setTranslucent$1", "Lcom/facebook/react/bridge/GuardedRunnable;", "runGuarded", "", "react-native-screens_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: ScreenWindowTraits.kt */
public final class ScreenWindowTraits$setTranslucent$1 extends GuardedRunnable {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ ReactContext $context;
    final /* synthetic */ boolean $translucent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScreenWindowTraits$setTranslucent$1(Activity activity, boolean z, ReactContext reactContext, ReactContext reactContext2) {
        super(reactContext2);
        this.$activity = activity;
        this.$translucent = z;
        this.$context = reactContext;
    }

    public void runGuarded() {
        Window window = this.$activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "activity.window");
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        if (this.$translucent) {
            decorView.setOnApplyWindowInsetsListener(ScreenWindowTraits$setTranslucent$1$runGuarded$1.INSTANCE);
        } else {
            decorView.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) null);
        }
        ViewCompat.requestApplyInsets(decorView);
    }
}
