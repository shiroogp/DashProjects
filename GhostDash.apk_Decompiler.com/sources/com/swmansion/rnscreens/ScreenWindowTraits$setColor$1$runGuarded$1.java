package com.swmansion.rnscreens;

import android.animation.ValueAnimator;
import android.view.Window;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k = 3, mv = {1, 4, 0})
/* compiled from: ScreenWindowTraits.kt */
final class ScreenWindowTraits$setColor$1$runGuarded$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ ScreenWindowTraits$setColor$1 this$0;

    ScreenWindowTraits$setColor$1$runGuarded$1(ScreenWindowTraits$setColor$1 screenWindowTraits$setColor$1) {
        this.this$0 = screenWindowTraits$setColor$1;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Window window = this.this$0.$activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "activity.window");
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "animator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        window.setStatusBarColor(((Integer) animatedValue).intValue());
    }
}
