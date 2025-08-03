package com.swmansion.rnscreens;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.Window;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/swmansion/rnscreens/ScreenWindowTraits$setColor$1", "Lcom/facebook/react/bridge/GuardedRunnable;", "runGuarded", "", "react-native-screens_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: ScreenWindowTraits.kt */
public final class ScreenWindowTraits$setColor$1 extends GuardedRunnable {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ boolean $animated;
    final /* synthetic */ Integer $color;
    final /* synthetic */ ReactContext $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScreenWindowTraits$setColor$1(Activity activity, Integer num, boolean z, ReactContext reactContext, ReactContext reactContext2) {
        super(reactContext2);
        this.$activity = activity;
        this.$color = num;
        this.$animated = z;
        this.$context = reactContext;
    }

    public void runGuarded() {
        this.$activity.getWindow().addFlags(Integer.MIN_VALUE);
        Window window = this.$activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "activity.window");
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(window.getStatusBarColor()), this.$color});
        ofObject.addUpdateListener(new ScreenWindowTraits$setColor$1$runGuarded$1(this));
        if (this.$animated) {
            ValueAnimator duration = ofObject.setDuration(300);
            Intrinsics.checkNotNullExpressionValue(duration, "colorAnimation.setDuration(300)");
            duration.setStartDelay(0);
        } else {
            ValueAnimator duration2 = ofObject.setDuration(0);
            Intrinsics.checkNotNullExpressionValue(duration2, "colorAnimation.setDuration(0)");
            duration2.setStartDelay(300);
        }
        ofObject.start();
    }
}
