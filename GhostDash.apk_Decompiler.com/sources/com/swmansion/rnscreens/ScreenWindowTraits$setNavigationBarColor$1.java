package com.swmansion.rnscreens;

import android.view.Window;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: ScreenWindowTraits.kt */
final class ScreenWindowTraits$setNavigationBarColor$1 implements Runnable {
    final /* synthetic */ int $color;
    final /* synthetic */ Window $window;

    ScreenWindowTraits$setNavigationBarColor$1(Window window, int i) {
        this.$window = window;
        this.$color = i;
    }

    public final void run() {
        Window window = this.$window;
        Intrinsics.checkNotNullExpressionValue(window, "window");
        new WindowInsetsControllerCompat(window, window.getDecorView()).setAppearanceLightNavigationBars(ScreenWindowTraits.INSTANCE.isColorLight(this.$color));
    }
}
