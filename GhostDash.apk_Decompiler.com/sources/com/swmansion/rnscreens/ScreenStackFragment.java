package com.swmansion.rnscreens;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import com.facebook.react.uimanager.PixelUtil;
import com.google.android.material.appbar.AppBarLayout;
import com.swmansion.rnscreens.ScreenStackHeaderSubview;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u000278B\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0016¢\u0006\u0002\u0010\u0005J\u0006\u0010\u001c\u001a\u00020\tJ\u0006\u0010\u001d\u001a\u00020\u0013J\b\u0010\u001e\u001a\u00020\u0013H\u0002J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\u0018\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010#\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010,\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010-\u001a\u00020\u0013H\u0016J\u0006\u0010.\u001a\u00020\u0013J\u000e\u0010/\u001a\u00020\u00132\u0006\u00100\u001a\u00020\fJ\u000e\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\tJ\u000e\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u00020\tJ\b\u00105\u001a\u00020\tH\u0002J\u0010\u00106\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R7\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u00069"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStackFragment;", "Lcom/swmansion/rnscreens/ScreenFragment;", "screenView", "Lcom/swmansion/rnscreens/Screen;", "(Lcom/swmansion/rnscreens/Screen;)V", "()V", "mAppBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "mIsTranslucent", "", "mShadowHidden", "mToolbar", "Landroidx/appcompat/widget/Toolbar;", "onSearchViewCreate", "Lkotlin/Function1;", "Lcom/swmansion/rnscreens/CustomSearchView;", "Lkotlin/ParameterName;", "name", "searchView", "", "getOnSearchViewCreate", "()Lkotlin/jvm/functions/Function1;", "setOnSearchViewCreate", "(Lkotlin/jvm/functions/Function1;)V", "getSearchView", "()Lcom/swmansion/rnscreens/CustomSearchView;", "setSearchView", "(Lcom/swmansion/rnscreens/CustomSearchView;)V", "canNavigateBack", "dismiss", "notifyViewAppearTransitionEnd", "onContainerUpdate", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPrepareOptionsMenu", "onViewAnimationEnd", "removeToolbar", "setToolbar", "toolbar", "setToolbarShadowHidden", "hidden", "setToolbarTranslucent", "translucent", "shouldShowSearchBar", "updateToolbarMenu", "ScreensAnimation", "ScreensCoordinatorLayout", "react-native-screens_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: ScreenStackFragment.kt */
public final class ScreenStackFragment extends ScreenFragment {
    private AppBarLayout mAppBarLayout;
    private boolean mIsTranslucent;
    private boolean mShadowHidden;
    private Toolbar mToolbar;
    private Function1<? super CustomSearchView, Unit> onSearchViewCreate;
    private CustomSearchView searchView;

    public final CustomSearchView getSearchView() {
        return this.searchView;
    }

    public final void setSearchView(CustomSearchView customSearchView) {
        this.searchView = customSearchView;
    }

    public final Function1<CustomSearchView, Unit> getOnSearchViewCreate() {
        return this.onSearchViewCreate;
    }

    public final void setOnSearchViewCreate(Function1<? super CustomSearchView, Unit> function1) {
        this.onSearchViewCreate = function1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScreenStackFragment(Screen screen) {
        super(screen);
        Intrinsics.checkNotNullParameter(screen, "screenView");
    }

    public ScreenStackFragment() {
        throw new IllegalStateException("ScreenStack fragments should never be restored. Follow instructions from https://github.com/software-mansion/react-native-screens/issues/17#issuecomment-424704067 to properly configure your main activity.");
    }

    public final void removeToolbar() {
        Toolbar toolbar;
        AppBarLayout appBarLayout = this.mAppBarLayout;
        if (!(appBarLayout == null || (toolbar = this.mToolbar) == null || toolbar.getParent() != appBarLayout)) {
            appBarLayout.removeView(toolbar);
        }
        this.mToolbar = null;
    }

    public final void setToolbar(Toolbar toolbar) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        AppBarLayout appBarLayout = this.mAppBarLayout;
        if (appBarLayout != null) {
            appBarLayout.addView(toolbar);
        }
        AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(-1, -2);
        layoutParams.setScrollFlags(0);
        toolbar.setLayoutParams(layoutParams);
        this.mToolbar = toolbar;
    }

    public final void setToolbarShadowHidden(boolean z) {
        if (this.mShadowHidden != z) {
            AppBarLayout appBarLayout = this.mAppBarLayout;
            if (appBarLayout != null) {
                appBarLayout.setTargetElevation(z ? 0.0f : PixelUtil.toPixelFromDIP(4.0f));
            }
            this.mShadowHidden = z;
        }
    }

    public final void setToolbarTranslucent(boolean z) {
        if (this.mIsTranslucent != z) {
            ViewGroup.LayoutParams layoutParams = getScreen().getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            ((CoordinatorLayout.LayoutParams) layoutParams).setBehavior(z ? null : new AppBarLayout.ScrollingViewBehavior());
            this.mIsTranslucent = z;
        }
    }

    public void onContainerUpdate() {
        ScreenStackHeaderConfig headerConfig = getScreen().getHeaderConfig();
        if (headerConfig != null) {
            headerConfig.onUpdate();
        }
    }

    public void onViewAnimationEnd() {
        super.onViewAnimationEnd();
        notifyViewAppearTransitionEnd();
    }

    private final void notifyViewAppearTransitionEnd() {
        View view = getView();
        ViewParent parent = view != null ? view.getParent() : null;
        if (parent instanceof ScreenStack) {
            ((ScreenStack) parent).onViewAppearTransitionEnd();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ScreensCoordinatorLayout screensCoordinatorLayout;
        AppBarLayout appBarLayout;
        AppBarLayout appBarLayout2;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Context context = getContext();
        AppBarLayout appBarLayout3 = null;
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(context, "it");
            screensCoordinatorLayout = new ScreensCoordinatorLayout(context, this);
        } else {
            screensCoordinatorLayout = null;
        }
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -1);
        layoutParams.setBehavior(this.mIsTranslucent ? null : new AppBarLayout.ScrollingViewBehavior());
        getScreen().setLayoutParams(layoutParams);
        if (screensCoordinatorLayout != null) {
            screensCoordinatorLayout.addView(ScreenFragment.Companion.recycleView(getScreen()));
        }
        Context context2 = getContext();
        if (context2 != null) {
            appBarLayout3 = new AppBarLayout(context2);
        }
        this.mAppBarLayout = appBarLayout3;
        if (appBarLayout3 != null) {
            appBarLayout3.setBackgroundColor(0);
        }
        AppBarLayout appBarLayout4 = this.mAppBarLayout;
        if (appBarLayout4 != null) {
            appBarLayout4.setLayoutParams(new AppBarLayout.LayoutParams(-1, -2));
        }
        if (screensCoordinatorLayout != null) {
            screensCoordinatorLayout.addView(this.mAppBarLayout);
        }
        if (this.mShadowHidden && (appBarLayout2 = this.mAppBarLayout) != null) {
            appBarLayout2.setTargetElevation(0.0f);
        }
        Toolbar toolbar = this.mToolbar;
        if (!(toolbar == null || (appBarLayout = this.mAppBarLayout) == null)) {
            appBarLayout.addView(ScreenFragment.Companion.recycleView(toolbar));
        }
        setHasOptionsMenu(true);
        return screensCoordinatorLayout;
    }

    public void onPrepareOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        updateToolbarMenu(menu);
        super.onPrepareOptionsMenu(menu);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        updateToolbarMenu(menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    private final boolean shouldShowSearchBar() {
        ScreenStackHeaderConfig headerConfig = getScreen().getHeaderConfig();
        int configSubviewsCount = headerConfig != null ? headerConfig.getConfigSubviewsCount() : 0;
        if (headerConfig != null && configSubviewsCount > 0) {
            for (int i = 0; i < configSubviewsCount; i++) {
                if (headerConfig.getConfigSubview(i).getType() == ScreenStackHeaderSubview.Type.SEARCH_BAR) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void updateToolbarMenu(Menu menu) {
        menu.clear();
        if (shouldShowSearchBar()) {
            Context context = getContext();
            if (this.searchView == null && context != null) {
                CustomSearchView customSearchView = new CustomSearchView(context, this);
                this.searchView = customSearchView;
                Function1<? super CustomSearchView, Unit> function1 = this.onSearchViewCreate;
                if (function1 != null) {
                    Unit invoke = function1.invoke(customSearchView);
                }
            }
            MenuItem add = menu.add("");
            add.setShowAsAction(2);
            Intrinsics.checkNotNullExpressionValue(add, "item");
            add.setActionView(this.searchView);
        }
    }

    public final boolean canNavigateBack() {
        ScreenContainer<?> container = getScreen().getContainer();
        if (!(container instanceof ScreenStack)) {
            throw new IllegalStateException("ScreenStackFragment added into a non-stack container".toString());
        } else if (!Intrinsics.areEqual((Object) ((ScreenStack) container).getRootScreen(), (Object) getScreen())) {
            return true;
        } else {
            Fragment parentFragment = getParentFragment();
            if (parentFragment instanceof ScreenStackFragment) {
                return ((ScreenStackFragment) parentFragment).canNavigateBack();
            }
            return false;
        }
    }

    public final void dismiss() {
        ScreenContainer<?> container = getScreen().getContainer();
        if (container instanceof ScreenStack) {
            ((ScreenStack) container).dismiss(this);
            return;
        }
        throw new IllegalStateException("ScreenStackFragment added into a non-stack container".toString());
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStackFragment$ScreensCoordinatorLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "context", "Landroid/content/Context;", "mFragment", "Lcom/swmansion/rnscreens/ScreenFragment;", "(Landroid/content/Context;Lcom/swmansion/rnscreens/ScreenFragment;)V", "mAnimationListener", "Landroid/view/animation/Animation$AnimationListener;", "clearFocus", "", "startAnimation", "animation", "Landroid/view/animation/Animation;", "react-native-screens_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ScreenStackFragment.kt */
    private static final class ScreensCoordinatorLayout extends CoordinatorLayout {
        private final Animation.AnimationListener mAnimationListener = new ScreenStackFragment$ScreensCoordinatorLayout$mAnimationListener$1(this);
        /* access modifiers changed from: private */
        public final ScreenFragment mFragment;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ScreensCoordinatorLayout(Context context, ScreenFragment screenFragment) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(screenFragment, "mFragment");
            this.mFragment = screenFragment;
        }

        public void startAnimation(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            ScreensAnimation screensAnimation = new ScreensAnimation(this.mFragment);
            screensAnimation.setDuration(animation.getDuration());
            if (!(animation instanceof AnimationSet) || this.mFragment.isRemoving()) {
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(animation);
                animationSet.addAnimation(screensAnimation);
                animationSet.setAnimationListener(this.mAnimationListener);
                super.startAnimation(animationSet);
                return;
            }
            ((AnimationSet) animation).addAnimation(screensAnimation);
            animation.setAnimationListener(this.mAnimationListener);
            super.startAnimation(animation);
        }

        public void clearFocus() {
            if (getVisibility() != 4) {
                super.clearFocus();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStackFragment$ScreensAnimation;", "Landroid/view/animation/Animation;", "mFragment", "Lcom/swmansion/rnscreens/ScreenFragment;", "(Lcom/swmansion/rnscreens/ScreenFragment;)V", "applyTransformation", "", "interpolatedTime", "", "t", "Landroid/view/animation/Transformation;", "react-native-screens_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ScreenStackFragment.kt */
    private static final class ScreensAnimation extends Animation {
        private final ScreenFragment mFragment;

        public ScreensAnimation(ScreenFragment screenFragment) {
            Intrinsics.checkNotNullParameter(screenFragment, "mFragment");
            this.mFragment = screenFragment;
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            Intrinsics.checkNotNullParameter(transformation, "t");
            super.applyTransformation(f, transformation);
            ScreenFragment screenFragment = this.mFragment;
            screenFragment.dispatchTransitionProgress(f, !screenFragment.isResumed());
        }
    }
}
