package com.swmansion.rnscreens;

import androidx.appcompat.widget.SearchView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onClose"}, k = 3, mv = {1, 4, 0})
/* compiled from: SearchBarView.kt */
final class SearchBarView$setSearchViewListeners$3 implements SearchView.OnCloseListener {
    final /* synthetic */ SearchBarView this$0;

    SearchBarView$setSearchViewListeners$3(SearchBarView searchBarView) {
        this.this$0 = searchBarView;
    }

    public final boolean onClose() {
        this.this$0.handleClose();
        return false;
    }
}
