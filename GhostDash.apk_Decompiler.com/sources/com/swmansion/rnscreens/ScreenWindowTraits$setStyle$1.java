package com.swmansion.rnscreens;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: ScreenWindowTraits.kt */
final class ScreenWindowTraits$setStyle$1 implements Runnable {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $style;

    ScreenWindowTraits$setStyle$1(Activity activity, String str) {
        this.$activity = activity;
        this.$style = str;
    }

    public final void run() {
        Window window = this.$activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "activity.window");
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(Intrinsics.areEqual((Object) "dark", (Object) this.$style) ? systemUiVisibility | 8192 : systemUiVisibility & -8193);
    }
}
