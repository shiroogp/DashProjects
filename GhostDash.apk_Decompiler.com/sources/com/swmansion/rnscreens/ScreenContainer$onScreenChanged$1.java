package com.swmansion.rnscreens;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Lcom/swmansion/rnscreens/ScreenFragment;", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: ScreenContainer.kt */
final class ScreenContainer$onScreenChanged$1 implements Runnable {
    final /* synthetic */ ScreenContainer this$0;

    ScreenContainer$onScreenChanged$1(ScreenContainer screenContainer) {
        this.this$0 = screenContainer;
    }

    public final void run() {
        this.this$0.performUpdates();
    }
}
