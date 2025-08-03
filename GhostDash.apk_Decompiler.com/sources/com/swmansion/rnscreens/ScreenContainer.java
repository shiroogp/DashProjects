package com.swmansion.rnscreens;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.ChoreographerCompat;
import com.facebook.react.modules.core.ReactChoreographer;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.ScreenFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u001aH\u0014¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0016J\u0018\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0002H\u0002J\b\u0010'\u001a\u00020%H\u0004J\u0018\u0010(\u001a\u00020!2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0002H\u0002J\u0012\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010&\u001a\u00020\u0002H\u0002J\u000e\u0010+\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0016J\u0012\u0010,\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010-\u001a\u00020!J\b\u0010.\u001a\u00020!H\u0014J\b\u0010/\u001a\u00020!H\u0014J\b\u00100\u001a\u00020!H\u0014J0\u00101\u001a\u00020!2\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u00162\u0006\u00105\u001a\u00020\u00162\u0006\u00106\u001a\u00020\u0016H\u0014J\u0018\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u0016H\u0014J\b\u0010:\u001a\u00020!H\u0002J\b\u0010;\u001a\u00020!H\u0016J\u0006\u0010<\u001a\u00020!J\b\u0010=\u001a\u00020!H\u0004J\b\u0010>\u001a\u00020!H\u0016J\u0010\u0010?\u001a\u00020!2\u0006\u0010@\u001a\u00020\u000bH\u0002J\u0010\u0010A\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0016H\u0016J\u0010\u0010B\u001a\u00020!2\u0006\u0010C\u001a\u00020DH\u0016J\b\u0010E\u001a\u00020!H\u0016J\u0010\u0010F\u001a\u00020!2\u0006\u0010G\u001a\u00020\u000bH\u0002J\b\u0010H\u001a\u00020!H\u0002R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0004@\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0013j\b\u0012\u0004\u0012\u00028\u0000`\u00148\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006I"}, d2 = {"Lcom/swmansion/rnscreens/ScreenContainer;", "T", "Lcom/swmansion/rnscreens/ScreenFragment;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isNested", "", "()Z", "mFragmentManager", "Landroidx/fragment/app/FragmentManager;", "mIsAttached", "mLayoutCallback", "Lcom/facebook/react/modules/core/ChoreographerCompat$FrameCallback;", "mLayoutEnqueued", "mNeedUpdate", "mParentScreenFragment", "mScreenFragments", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "screenCount", "", "getScreenCount", "()I", "topScreen", "Lcom/swmansion/rnscreens/Screen;", "getTopScreen", "()Lcom/swmansion/rnscreens/Screen;", "adapt", "screen", "(Lcom/swmansion/rnscreens/Screen;)Lcom/swmansion/rnscreens/ScreenFragment;", "addScreen", "", "index", "attachScreen", "transaction", "Landroidx/fragment/app/FragmentTransaction;", "screenFragment", "createTransaction", "detachScreen", "getActivityState", "Lcom/swmansion/rnscreens/Screen$ActivityState;", "getScreenAt", "hasScreen", "notifyChildUpdate", "notifyContainerUpdate", "onAttachedToWindow", "onDetachedFromWindow", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onScreenChanged", "onUpdate", "performUpdates", "performUpdatesNow", "removeAllScreens", "removeMyFragments", "fragmentManager", "removeScreenAt", "removeView", "view", "Landroid/view/View;", "requestLayout", "setFragmentManager", "fm", "setupFragmentManager", "react-native-screens_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: ScreenContainer.kt */
public class ScreenContainer<T extends ScreenFragment> extends ViewGroup {
    protected FragmentManager mFragmentManager;
    private boolean mIsAttached;
    private final ChoreographerCompat.FrameCallback mLayoutCallback = new ScreenContainer$mLayoutCallback$1(this);
    /* access modifiers changed from: private */
    public boolean mLayoutEnqueued;
    private boolean mNeedUpdate;
    private ScreenFragment mParentScreenFragment;
    protected final ArrayList<T> mScreenFragments = new ArrayList<>();

    public ScreenContainer(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5).layout(0, 0, getWidth(), getHeight());
        }
    }

    public void removeView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view == getFocusedChild()) {
            Object systemService = getContext().getSystemService("input_method");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(getWindowToken(), 2);
        }
        super.removeView(view);
    }

    public void requestLayout() {
        super.requestLayout();
        if (!this.mLayoutEnqueued && this.mLayoutCallback != null) {
            this.mLayoutEnqueued = true;
            ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mLayoutCallback);
        }
    }

    public final boolean isNested() {
        return this.mParentScreenFragment != null;
    }

    public final void notifyChildUpdate() {
        performUpdatesNow();
    }

    /* access modifiers changed from: protected */
    public T adapt(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        return new ScreenFragment(screen);
    }

    public final void addScreen(Screen screen, int i) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        ScreenFragment adapt = adapt(screen);
        screen.setFragment(adapt);
        this.mScreenFragments.add(i, adapt);
        screen.setContainer(this);
        onScreenChanged();
    }

    public void removeScreenAt(int i) {
        ((ScreenFragment) this.mScreenFragments.get(i)).getScreen().setContainer((ScreenContainer<?>) null);
        this.mScreenFragments.remove(i);
        onScreenChanged();
    }

    public void removeAllScreens() {
        Iterator<T> it2 = this.mScreenFragments.iterator();
        while (it2.hasNext()) {
            ((ScreenFragment) it2.next()).getScreen().setContainer((ScreenContainer<?>) null);
        }
        this.mScreenFragments.clear();
        onScreenChanged();
    }

    public final int getScreenCount() {
        return this.mScreenFragments.size();
    }

    public final Screen getScreenAt(int i) {
        return ((ScreenFragment) this.mScreenFragments.get(i)).getScreen();
    }

    public Screen getTopScreen() {
        Iterator<T> it2 = this.mScreenFragments.iterator();
        while (it2.hasNext()) {
            ScreenFragment screenFragment = (ScreenFragment) it2.next();
            Intrinsics.checkNotNullExpressionValue(screenFragment, "screenFragment");
            if (getActivityState(screenFragment) == Screen.ActivityState.ON_TOP) {
                return screenFragment.getScreen();
            }
        }
        return null;
    }

    private final void setFragmentManager(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        performUpdatesNow();
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setupFragmentManager() {
        /*
            r3 = this;
            r0 = r3
            android.view.ViewParent r0 = (android.view.ViewParent) r0
        L_0x0003:
            boolean r1 = r0 instanceof com.facebook.react.ReactRootView
            if (r1 != 0) goto L_0x001b
            boolean r2 = r0 instanceof com.swmansion.rnscreens.Screen
            if (r2 != 0) goto L_0x001b
            android.view.ViewParent r2 = r0.getParent()
            if (r2 == 0) goto L_0x001b
            android.view.ViewParent r0 = r0.getParent()
            java.lang.String r1 = "parent.parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            goto L_0x0003
        L_0x001b:
            boolean r2 = r0 instanceof com.swmansion.rnscreens.Screen
            if (r2 == 0) goto L_0x004c
            com.swmansion.rnscreens.Screen r0 = (com.swmansion.rnscreens.Screen) r0
            com.swmansion.rnscreens.ScreenFragment r0 = r0.getFragment()
            if (r0 == 0) goto L_0x0029
            r1 = 1
            goto L_0x002a
        L_0x0029:
            r1 = 0
        L_0x002a:
            if (r1 == 0) goto L_0x003e
            r3.mParentScreenFragment = r0
            r0.registerChildScreenContainer(r3)
            androidx.fragment.app.FragmentManager r0 = r0.getChildFragmentManager()
            java.lang.String r1 = "screenFragment.childFragmentManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r3.setFragmentManager(r0)
            return
        L_0x003e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Parent Screen does not have its Fragment attached"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x004c:
            if (r1 == 0) goto L_0x0082
            com.facebook.react.ReactRootView r0 = (com.facebook.react.ReactRootView) r0
            android.content.Context r0 = r0.getContext()
        L_0x0054:
            boolean r1 = r0 instanceof androidx.fragment.app.FragmentActivity
            if (r1 != 0) goto L_0x0063
            boolean r2 = r0 instanceof android.content.ContextWrapper
            if (r2 == 0) goto L_0x0063
            android.content.ContextWrapper r0 = (android.content.ContextWrapper) r0
            android.content.Context r0 = r0.getBaseContext()
            goto L_0x0054
        L_0x0063:
            if (r1 == 0) goto L_0x0074
            androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0
            androidx.fragment.app.FragmentManager r0 = r0.getSupportFragmentManager()
            java.lang.String r1 = "context.supportFragmentManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r3.setFragmentManager(r0)
            return
        L_0x0074:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "In order to use RNScreens components your app's activity need to extend ReactActivity"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x0082:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "ScreenContainer is not attached under ReactRootView"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenContainer.setupFragmentManager():void");
    }

    /* access modifiers changed from: protected */
    public final FragmentTransaction createTransaction() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "fragmentManager.beginTransaction()");
            beginTransaction.setReorderingAllowed(true);
            return beginTransaction;
        }
        throw new IllegalArgumentException("mFragmentManager is null when creating transaction".toString());
    }

    private final void attachScreen(FragmentTransaction fragmentTransaction, ScreenFragment screenFragment) {
        fragmentTransaction.add(getId(), (Fragment) screenFragment);
    }

    private final void detachScreen(FragmentTransaction fragmentTransaction, ScreenFragment screenFragment) {
        fragmentTransaction.remove(screenFragment);
    }

    private final Screen.ActivityState getActivityState(ScreenFragment screenFragment) {
        return screenFragment.getScreen().getActivityState();
    }

    public boolean hasScreen(ScreenFragment screenFragment) {
        return CollectionsKt.contains(this.mScreenFragments, screenFragment);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsAttached = true;
        setupFragmentManager();
    }

    private final void removeMyFragments(FragmentManager fragmentManager) {
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "fragmentManager.beginTransaction()");
        boolean z = false;
        for (Fragment next : fragmentManager.getFragments()) {
            if ((next instanceof ScreenFragment) && ((ScreenFragment) next).getScreen().getContainer() == this) {
                beginTransaction.remove(next);
                z = true;
            }
        }
        if (z) {
            beginTransaction.commitNowAllowingStateLoss();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null && !fragmentManager.isDestroyed()) {
            removeMyFragments(fragmentManager);
            fragmentManager.executePendingTransactions();
        }
        ScreenFragment screenFragment = this.mParentScreenFragment;
        if (screenFragment != null) {
            screenFragment.unregisterChildScreenContainer(this);
        }
        this.mParentScreenFragment = null;
        super.onDetachedFromWindow();
        this.mIsAttached = false;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            removeViewAt(childCount);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(i, i2);
        }
    }

    private final void onScreenChanged() {
        this.mNeedUpdate = true;
        Context context = getContext();
        if (!(context instanceof ReactContext)) {
            context = null;
        }
        ReactContext reactContext = (ReactContext) context;
        if (reactContext != null) {
            reactContext.runOnUiQueueThread(new ScreenContainer$onScreenChanged$1(this));
        }
    }

    /* access modifiers changed from: protected */
    public final void performUpdatesNow() {
        this.mNeedUpdate = true;
        performUpdates();
    }

    public final void performUpdates() {
        FragmentManager fragmentManager;
        if (this.mNeedUpdate && this.mIsAttached && (fragmentManager = this.mFragmentManager) != null) {
            if (fragmentManager == null || !fragmentManager.isDestroyed()) {
                this.mNeedUpdate = false;
                onUpdate();
                notifyContainerUpdate();
            }
        }
    }

    public void onUpdate() {
        FragmentTransaction createTransaction = createTransaction();
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            Set hashSet = new HashSet(fragmentManager.getFragments());
            Iterator<T> it2 = this.mScreenFragments.iterator();
            while (it2.hasNext()) {
                ScreenFragment screenFragment = (ScreenFragment) it2.next();
                Intrinsics.checkNotNullExpressionValue(screenFragment, "screenFragment");
                if (getActivityState(screenFragment) == Screen.ActivityState.INACTIVE && screenFragment.isAdded()) {
                    detachScreen(createTransaction, screenFragment);
                }
                hashSet.remove(screenFragment);
            }
            Collection collection = hashSet;
            boolean z = false;
            if (!collection.isEmpty()) {
                Object[] array = collection.toArray(new Fragment[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                for (Fragment fragment : (Fragment[]) array) {
                    if (fragment instanceof ScreenFragment) {
                        ScreenFragment screenFragment2 = (ScreenFragment) fragment;
                        if (screenFragment2.getScreen().getContainer() == null) {
                            detachScreen(createTransaction, screenFragment2);
                        }
                    }
                }
            }
            boolean z2 = getTopScreen() == null;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it3 = this.mScreenFragments.iterator();
            while (it3.hasNext()) {
                ScreenFragment screenFragment3 = (ScreenFragment) it3.next();
                Intrinsics.checkNotNullExpressionValue(screenFragment3, "screenFragment");
                Screen.ActivityState activityState = getActivityState(screenFragment3);
                if (activityState != Screen.ActivityState.INACTIVE && !screenFragment3.isAdded()) {
                    attachScreen(createTransaction, screenFragment3);
                    z = true;
                } else if (activityState != Screen.ActivityState.INACTIVE && z) {
                    detachScreen(createTransaction, screenFragment3);
                    arrayList.add(screenFragment3);
                }
                screenFragment3.getScreen().setTransitioning(z2);
            }
            Iterator it4 = arrayList.iterator();
            while (it4.hasNext()) {
                ScreenFragment screenFragment4 = (ScreenFragment) it4.next();
                Intrinsics.checkNotNullExpressionValue(screenFragment4, "screenFragment");
                attachScreen(createTransaction, screenFragment4);
            }
            createTransaction.commitNowAllowingStateLoss();
            return;
        }
        throw new IllegalArgumentException("mFragmentManager is null when performing update in ScreenContainer".toString());
    }

    /* access modifiers changed from: protected */
    public void notifyContainerUpdate() {
        ScreenFragment fragment;
        Screen topScreen = getTopScreen();
        if (topScreen != null && (fragment = topScreen.getFragment()) != null) {
            fragment.onContainerUpdate();
        }
    }
}
