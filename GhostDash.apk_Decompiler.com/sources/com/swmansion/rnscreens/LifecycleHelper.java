package com.swmansion.rnscreens;

import android.view.View;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\t\u001a\u00020\n\"\u000e\b\u0000\u0010\u000b*\u00020\u0007*\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u0002H\u000b¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0007H\u0002J#\u0010\u0010\u001a\u00020\n\"\u000e\b\u0000\u0010\u000b*\u00020\u0007*\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u0002H\u000b¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/swmansion/rnscreens/LifecycleHelper;", "", "()V", "mRegisterOnLayoutChange", "Landroid/view/View$OnLayoutChangeListener;", "mViewToLifecycleMap", "", "Landroid/view/View;", "Landroidx/lifecycle/Lifecycle;", "register", "", "T", "Landroidx/lifecycle/LifecycleObserver;", "view", "(Landroid/view/View;)V", "registerViewWithLifecycleOwner", "unregister", "Companion", "react-native-screens_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: LifecycleHelper.kt */
public final class LifecycleHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final View.OnLayoutChangeListener mRegisterOnLayoutChange = new LifecycleHelper$mRegisterOnLayoutChange$1(this);
    private final Map<View, Lifecycle> mViewToLifecycleMap = new HashMap();

    /* access modifiers changed from: private */
    public final void registerViewWithLifecycleOwner(View view) {
        Fragment findNearestScreenFragmentAncestor = Companion.findNearestScreenFragmentAncestor(view);
        if (findNearestScreenFragmentAncestor != null && (view instanceof LifecycleObserver)) {
            Lifecycle lifecycle = findNearestScreenFragmentAncestor.getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "parent.lifecycle");
            lifecycle.addObserver((LifecycleObserver) view);
            this.mViewToLifecycleMap.put(view, lifecycle);
        }
    }

    public final <T extends View & LifecycleObserver> void register(T t) {
        t.addOnLayoutChangeListener(this.mRegisterOnLayoutChange);
    }

    public final <T extends View & LifecycleObserver> void unregister(T t) {
        Lifecycle lifecycle = this.mViewToLifecycleMap.get(t);
        if (lifecycle != null) {
            lifecycle.removeObserver((LifecycleObserver) t);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/swmansion/rnscreens/LifecycleHelper$Companion;", "", "()V", "findNearestScreenFragmentAncestor", "Landroidx/fragment/app/Fragment;", "view", "Landroid/view/View;", "react-native-screens_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: LifecycleHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Fragment findNearestScreenFragmentAncestor(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ViewParent parent = view.getParent();
            while (parent != null && !(parent instanceof Screen)) {
                parent = parent.getParent();
            }
            if (parent != null) {
                return ((Screen) parent).getFragment();
            }
            return null;
        }
    }
}
