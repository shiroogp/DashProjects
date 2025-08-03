package com.swmansion.rnscreens;

import android.app.Activity;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: ScreenWindowTraits.kt */
final class ScreenWindowTraits$setHidden$1 implements Runnable {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ boolean $hidden;

    ScreenWindowTraits$setHidden$1(boolean z, Activity activity) {
        this.$hidden = z;
        this.$activity = activity;
    }

    public final void run() {
        if (this.$hidden) {
            this.$activity.getWindow().addFlags(1024);
            this.$activity.getWindow().clearFlags(2048);
            return;
        }
        this.$activity.getWindow().addFlags(2048);
        this.$activity.getWindow().clearFlags(1024);
    }
}
