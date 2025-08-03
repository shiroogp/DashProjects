package com.swmansion.rnscreens;

import android.content.Context;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\b\u0010\u0019\u001a\u00020\u0017H\u0014J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/swmansion/rnscreens/CustomSearchView;", "Landroidx/appcompat/widget/SearchView;", "context", "Landroid/content/Context;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;)V", "backPressOverrider", "Lcom/swmansion/rnscreens/FragmentBackPressOverrider;", "mCustomOnCloseListener", "Landroidx/appcompat/widget/SearchView$OnCloseListener;", "mCustomOnSearchClickedListener", "Landroid/view/View$OnClickListener;", "mOnBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "value", "", "overrideBackAction", "getOverrideBackAction", "()Z", "setOverrideBackAction", "(Z)V", "focus", "", "onAttachedToWindow", "onDetachedFromWindow", "setOnCloseListener", "listener", "setOnSearchClickListener", "react-native-screens_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: CustomSearchView.kt */
public final class CustomSearchView extends SearchView {
    /* access modifiers changed from: private */
    public final FragmentBackPressOverrider backPressOverrider;
    /* access modifiers changed from: private */
    public SearchView.OnCloseListener mCustomOnCloseListener;
    /* access modifiers changed from: private */
    public View.OnClickListener mCustomOnSearchClickedListener;
    private OnBackPressedCallback mOnBackPressedCallback = new CustomSearchView$mOnBackPressedCallback$1(this, true);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomSearchView(Context context, Fragment fragment) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.backPressOverrider = new FragmentBackPressOverrider(fragment, this.mOnBackPressedCallback);
        super.setOnSearchClickListener(new View.OnClickListener(this) {
            final /* synthetic */ CustomSearchView this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                View.OnClickListener access$getMCustomOnSearchClickedListener$p = this.this$0.mCustomOnSearchClickedListener;
                if (access$getMCustomOnSearchClickedListener$p != null) {
                    access$getMCustomOnSearchClickedListener$p.onClick(view);
                }
                this.this$0.backPressOverrider.maybeAddBackCallback();
            }
        });
        super.setOnCloseListener(new SearchView.OnCloseListener(this) {
            final /* synthetic */ CustomSearchView this$0;

            {
                this.this$0 = r1;
            }

            public final boolean onClose() {
                SearchView.OnCloseListener access$getMCustomOnCloseListener$p = this.this$0.mCustomOnCloseListener;
                boolean onClose = access$getMCustomOnCloseListener$p != null ? access$getMCustomOnCloseListener$p.onClose() : false;
                this.this$0.backPressOverrider.removeBackCallbackIfAdded();
                return onClose;
            }
        });
        setMaxWidth(Integer.MAX_VALUE);
    }

    public final void setOverrideBackAction(boolean z) {
        this.backPressOverrider.setOverrideBackAction(z);
    }

    public final boolean getOverrideBackAction() {
        return this.backPressOverrider.getOverrideBackAction();
    }

    public final void focus() {
        setIconified(false);
        requestFocusFromTouch();
    }

    public void setOnCloseListener(SearchView.OnCloseListener onCloseListener) {
        this.mCustomOnCloseListener = onCloseListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.mCustomOnSearchClickedListener = onClickListener;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isIconified()) {
            this.backPressOverrider.maybeAddBackCallback();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.backPressOverrider.removeBackCallbackIfAdded();
    }
}
