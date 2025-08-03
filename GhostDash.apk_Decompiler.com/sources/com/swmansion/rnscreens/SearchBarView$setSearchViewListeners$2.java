package com.swmansion.rnscreens;

import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"}, k = 3, mv = {1, 4, 0})
/* compiled from: SearchBarView.kt */
final class SearchBarView$setSearchViewListeners$2 implements View.OnFocusChangeListener {
    final /* synthetic */ SearchBarView this$0;

    SearchBarView$setSearchViewListeners$2(SearchBarView searchBarView) {
        this.this$0 = searchBarView;
    }

    public final void onFocusChange(View view, boolean z) {
        this.this$0.handleFocusChange(z);
    }
}
