package com.swmansion.rnscreens;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: ScreenStack.kt */
final class ScreenStack$onUpdate$1$1 implements Runnable {
    final /* synthetic */ ScreenStackFragment $top;

    ScreenStack$onUpdate$1$1(ScreenStackFragment screenStackFragment) {
        this.$top = screenStackFragment;
    }

    public final void run() {
        Screen screen;
        ScreenStackFragment screenStackFragment = this.$top;
        if (screenStackFragment != null && (screen = screenStackFragment.getScreen()) != null) {
            screen.bringToFront();
        }
    }
}
