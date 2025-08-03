package com.swmansion.rnscreens;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"com/swmansion/rnscreens/LifecycleHelper$mRegisterOnLayoutChange$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "i", "", "i1", "i2", "i3", "i4", "i5", "i6", "i7", "react-native-screens_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: LifecycleHelper.kt */
public final class LifecycleHelper$mRegisterOnLayoutChange$1 implements View.OnLayoutChangeListener {
    final /* synthetic */ LifecycleHelper this$0;

    LifecycleHelper$mRegisterOnLayoutChange$1(LifecycleHelper lifecycleHelper) {
        this.this$0 = lifecycleHelper;
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.this$0.registerViewWithLifecycleOwner(view);
        view.removeOnLayoutChangeListener(this);
    }
}
