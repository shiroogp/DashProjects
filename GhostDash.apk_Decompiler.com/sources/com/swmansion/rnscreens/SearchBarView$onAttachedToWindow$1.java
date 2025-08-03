package com.swmansion.rnscreens;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "newSearchView", "Lcom/swmansion/rnscreens/CustomSearchView;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: SearchBarView.kt */
final class SearchBarView$onAttachedToWindow$1 extends Lambda implements Function1<CustomSearchView, Unit> {
    final /* synthetic */ SearchBarView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBarView$onAttachedToWindow$1(SearchBarView searchBarView) {
        super(1);
        this.this$0 = searchBarView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CustomSearchView) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(CustomSearchView customSearchView) {
        ScreenStackFragment access$getScreenStackFragment$p;
        CustomSearchView searchView;
        Intrinsics.checkNotNullParameter(customSearchView, "newSearchView");
        if (this.this$0.mSearchViewFormatter == null) {
            this.this$0.mSearchViewFormatter = new SearchViewFormatter(customSearchView);
        }
        this.this$0.setSearchViewProps();
        if (this.this$0.getAutoFocus() && (access$getScreenStackFragment$p = this.this$0.getScreenStackFragment()) != null && (searchView = access$getScreenStackFragment$p.getSearchView()) != null) {
            searchView.focus();
        }
    }
}
