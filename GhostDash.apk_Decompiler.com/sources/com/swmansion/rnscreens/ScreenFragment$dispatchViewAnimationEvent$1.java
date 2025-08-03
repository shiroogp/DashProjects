package com.swmansion.rnscreens;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: ScreenFragment.kt */
final class ScreenFragment$dispatchViewAnimationEvent$1 implements Runnable {
    final /* synthetic */ boolean $animationEnd;
    final /* synthetic */ ScreenFragment this$0;

    ScreenFragment$dispatchViewAnimationEvent$1(ScreenFragment screenFragment, boolean z) {
        this.this$0 = screenFragment;
        this.$animationEnd = z;
    }

    public final void run() {
        if (this.$animationEnd) {
            this.this$0.dispatchOnAppear();
        } else {
            this.this$0.dispatchOnWillAppear();
        }
    }
}
