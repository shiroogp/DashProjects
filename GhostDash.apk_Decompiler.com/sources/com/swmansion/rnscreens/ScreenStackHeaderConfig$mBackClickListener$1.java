package com.swmansion.rnscreens;

import android.view.View;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 0})
/* compiled from: ScreenStackHeaderConfig.kt */
final class ScreenStackHeaderConfig$mBackClickListener$1 implements View.OnClickListener {
    final /* synthetic */ ScreenStackHeaderConfig this$0;

    ScreenStackHeaderConfig$mBackClickListener$1(ScreenStackHeaderConfig screenStackHeaderConfig) {
        this.this$0 = screenStackHeaderConfig;
    }

    public final void onClick(View view) {
        ScreenStackFragment screenFragment = this.this$0.getScreenFragment();
        if (screenFragment != null) {
            ScreenStack access$getScreenStack$p = this.this$0.getScreenStack();
            if (access$getScreenStack$p != null && Intrinsics.areEqual((Object) access$getScreenStack$p.getRootScreen(), (Object) screenFragment.getScreen())) {
                Fragment parentFragment = screenFragment.getParentFragment();
                if (parentFragment instanceof ScreenStackFragment) {
                    ScreenStackFragment screenStackFragment = (ScreenStackFragment) parentFragment;
                    if (screenStackFragment.getScreen().getNativeBackButtonDismissalEnabled()) {
                        screenStackFragment.dismiss();
                    } else {
                        screenStackFragment.dispatchHeaderBackButtonClickedEvent();
                    }
                }
            } else if (screenFragment.getScreen().getNativeBackButtonDismissalEnabled()) {
                screenFragment.dismiss();
            } else {
                screenFragment.dispatchHeaderBackButtonClickedEvent();
            }
        }
    }
}
