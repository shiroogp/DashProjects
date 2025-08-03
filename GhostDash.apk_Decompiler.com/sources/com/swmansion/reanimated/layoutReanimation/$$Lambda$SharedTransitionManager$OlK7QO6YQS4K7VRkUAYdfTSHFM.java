package com.swmansion.reanimated.layoutReanimation;

import android.view.View;
import java.util.Comparator;

/* renamed from: com.swmansion.reanimated.layoutReanimation.-$$Lambda$SharedTransitionManager$-OlK7QO6YQS4K7VRkUAYdfTSHFM  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$SharedTransitionManager$OlK7QO6YQS4K7VRkUAYdfTSHFM implements Comparator {
    public static final /* synthetic */ $$Lambda$SharedTransitionManager$OlK7QO6YQS4K7VRkUAYdfTSHFM INSTANCE = new $$Lambda$SharedTransitionManager$OlK7QO6YQS4K7VRkUAYdfTSHFM();

    private /* synthetic */ $$Lambda$SharedTransitionManager$OlK7QO6YQS4K7VRkUAYdfTSHFM() {
    }

    public final int compare(Object obj, Object obj2) {
        return Integer.compare(((View) obj2).getId(), ((View) obj).getId());
    }
}
