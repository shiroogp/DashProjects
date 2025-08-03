package com.swmansion.rnscreens;

import android.content.Context;
import android.graphics.Paint;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import com.facebook.react.bridge.ReactContext;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0005xyz{|B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020/J\u0016\u0010`\u001a\u00020^2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020b0aH\u0014J\u0016\u0010c\u001a\u00020^2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020b0aH\u0014J\u0010\u0010d\u001a\u00020\u001b2\u0006\u0010e\u001a\u00020fH\u0002J0\u0010g\u001a\u00020^2\u0006\u0010h\u001a\u00020\u001b2\u0006\u0010i\u001a\u00020/2\u0006\u0010j\u001a\u00020/2\u0006\u0010k\u001a\u00020/2\u0006\u0010l\u001a\u00020/H\u0014J\u000e\u0010m\u001a\u00020^2\u0006\u0010\u0007\u001a\u00020\u0006J\u001a\u0010n\u001a\u00020^2\u0006\u0010o\u001a\u00020/2\b\u0010p\u001a\u0004\u0018\u00010qH\u0016J\u0010\u0010r\u001a\u00020^2\b\u0010G\u001a\u0004\u0018\u000105J\u000e\u0010s\u001a\u00020^2\u0006\u0010t\u001a\u00020\u001bJ\u0018\u0010u\u001a\u00020^2\u0006\u0010v\u001a\u00020/2\u0006\u0010w\u001a\u00020/H\u0002R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010 \u001a\u0004\u0018\u00010\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001b8F@FX\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R(\u0010(\u001a\u0004\u0018\u00010\u001b2\b\u0010'\u001a\u0004\u0018\u00010\u001b8F@FX\u000e¢\u0006\f\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R(\u0010+\u001a\u0004\u0018\u00010\u001b2\b\u0010*\u001a\u0004\u0018\u00010\u001b8F@FX\u000e¢\u0006\f\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#R\u000e\u0010-\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0004\n\u0002\u00100R\u0012\u00101\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0004\n\u0002\u0010&R\u0012\u00102\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0004\n\u0002\u00100R\u0012\u00103\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0004\n\u0002\u0010&R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R\u0012\u00106\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0004\n\u0002\u0010&R\u000e\u00107\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R$\u00109\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u001b8F@FX\u000e¢\u0006\f\u001a\u0004\b:\u0010\u001c\"\u0004\b;\u0010\u001eR(\u0010<\u001a\u0004\u0018\u00010/2\b\u0010<\u001a\u0004\u0018\u00010/8F@FX\u000e¢\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010G\u001a\u0004\u0018\u00010/2\b\u0010\u0005\u001a\u0004\u0018\u00010/@BX\u000e¢\u0006\n\n\u0002\u00100\u001a\u0004\bH\u0010>R\u001a\u0010I\u001a\u00020JX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001a\u0010O\u001a\u00020PX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR(\u0010U\u001a\u0004\u0018\u00010/2\b\u0010U\u001a\u0004\u0018\u00010/8F@FX\u000e¢\u0006\f\u001a\u0004\bV\u0010>\"\u0004\bW\u0010@R(\u0010X\u001a\u0004\u0018\u0001052\b\u0010X\u001a\u0004\u0018\u0001058F@FX\u000e¢\u0006\f\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\¨\u0006}"}, d2 = {"Lcom/swmansion/rnscreens/Screen;", "Lcom/swmansion/rnscreens/FabricEnabledViewGroup;", "context", "Lcom/facebook/react/bridge/ReactContext;", "(Lcom/facebook/react/bridge/ReactContext;)V", "<set-?>", "Lcom/swmansion/rnscreens/Screen$ActivityState;", "activityState", "getActivityState", "()Lcom/swmansion/rnscreens/Screen$ActivityState;", "container", "Lcom/swmansion/rnscreens/ScreenContainer;", "getContainer", "()Lcom/swmansion/rnscreens/ScreenContainer;", "setContainer", "(Lcom/swmansion/rnscreens/ScreenContainer;)V", "fragment", "Lcom/swmansion/rnscreens/ScreenFragment;", "getFragment", "()Lcom/swmansion/rnscreens/ScreenFragment;", "setFragment", "(Lcom/swmansion/rnscreens/ScreenFragment;)V", "headerConfig", "Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;", "getHeaderConfig", "()Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;", "isGestureEnabled", "", "()Z", "setGestureEnabled", "(Z)V", "navigationBarHidden", "isNavigationBarHidden", "()Ljava/lang/Boolean;", "setNavigationBarHidden", "(Ljava/lang/Boolean;)V", "isStatusBarAnimated", "setStatusBarAnimated", "Ljava/lang/Boolean;", "statusBarHidden", "isStatusBarHidden", "setStatusBarHidden", "statusBarTranslucent", "isStatusBarTranslucent", "setStatusBarTranslucent", "mNativeBackButtonDismissalEnabled", "mNavigationBarColor", "", "Ljava/lang/Integer;", "mNavigationBarHidden", "mStatusBarColor", "mStatusBarHidden", "mStatusBarStyle", "", "mStatusBarTranslucent", "mTransitioning", "enableNativeBackButtonDismissal", "nativeBackButtonDismissalEnabled", "getNativeBackButtonDismissalEnabled", "setNativeBackButtonDismissalEnabled", "navigationBarColor", "getNavigationBarColor", "()Ljava/lang/Integer;", "setNavigationBarColor", "(Ljava/lang/Integer;)V", "replaceAnimation", "Lcom/swmansion/rnscreens/Screen$ReplaceAnimation;", "getReplaceAnimation", "()Lcom/swmansion/rnscreens/Screen$ReplaceAnimation;", "setReplaceAnimation", "(Lcom/swmansion/rnscreens/Screen$ReplaceAnimation;)V", "screenOrientation", "getScreenOrientation", "stackAnimation", "Lcom/swmansion/rnscreens/Screen$StackAnimation;", "getStackAnimation", "()Lcom/swmansion/rnscreens/Screen$StackAnimation;", "setStackAnimation", "(Lcom/swmansion/rnscreens/Screen$StackAnimation;)V", "stackPresentation", "Lcom/swmansion/rnscreens/Screen$StackPresentation;", "getStackPresentation", "()Lcom/swmansion/rnscreens/Screen$StackPresentation;", "setStackPresentation", "(Lcom/swmansion/rnscreens/Screen$StackPresentation;)V", "statusBarColor", "getStatusBarColor", "setStatusBarColor", "statusBarStyle", "getStatusBarStyle", "()Ljava/lang/String;", "setStatusBarStyle", "(Ljava/lang/String;)V", "changeAccessibilityMode", "", "mode", "dispatchRestoreInstanceState", "Landroid/util/SparseArray;", "Landroid/os/Parcelable;", "dispatchSaveInstanceState", "hasWebView", "viewGroup", "Landroid/view/ViewGroup;", "onLayout", "changed", "l", "t", "r", "b", "setActivityState", "setLayerType", "layerType", "paint", "Landroid/graphics/Paint;", "setScreenOrientation", "setTransitioning", "transitioning", "updateScreenSizePaper", "width", "height", "ActivityState", "ReplaceAnimation", "StackAnimation", "StackPresentation", "WindowTraits", "react-native-screens_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: Screen.kt */
public final class Screen extends FabricEnabledViewGroup {
    private ActivityState activityState;
    private ScreenContainer<?> container;
    private ScreenFragment fragment;
    private boolean isGestureEnabled = true;
    private Boolean isStatusBarAnimated;
    private boolean mNativeBackButtonDismissalEnabled = true;
    private Integer mNavigationBarColor;
    private Boolean mNavigationBarHidden;
    private Integer mStatusBarColor;
    private Boolean mStatusBarHidden;
    private String mStatusBarStyle;
    private Boolean mStatusBarTranslucent;
    private boolean mTransitioning;
    private ReplaceAnimation replaceAnimation = ReplaceAnimation.POP;
    private Integer screenOrientation;
    private StackAnimation stackAnimation = StackAnimation.DEFAULT;
    private StackPresentation stackPresentation = StackPresentation.PUSH;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/swmansion/rnscreens/Screen$ActivityState;", "", "(Ljava/lang/String;I)V", "INACTIVE", "TRANSITIONING_OR_BELOW_TOP", "ON_TOP", "react-native-screens_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: Screen.kt */
    public enum ActivityState {
        INACTIVE,
        TRANSITIONING_OR_BELOW_TOP,
        ON_TOP
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/swmansion/rnscreens/Screen$ReplaceAnimation;", "", "(Ljava/lang/String;I)V", "PUSH", "POP", "react-native-screens_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: Screen.kt */
    public enum ReplaceAnimation {
        PUSH,
        POP
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/swmansion/rnscreens/Screen$StackAnimation;", "", "(Ljava/lang/String;I)V", "DEFAULT", "NONE", "FADE", "SLIDE_FROM_BOTTOM", "SLIDE_FROM_RIGHT", "SLIDE_FROM_LEFT", "FADE_FROM_BOTTOM", "react-native-screens_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: Screen.kt */
    public enum StackAnimation {
        DEFAULT,
        NONE,
        FADE,
        SLIDE_FROM_BOTTOM,
        SLIDE_FROM_RIGHT,
        SLIDE_FROM_LEFT,
        FADE_FROM_BOTTOM
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/swmansion/rnscreens/Screen$StackPresentation;", "", "(Ljava/lang/String;I)V", "PUSH", "MODAL", "TRANSPARENT_MODAL", "react-native-screens_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: Screen.kt */
    public enum StackPresentation {
        PUSH,
        MODAL,
        TRANSPARENT_MODAL
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/swmansion/rnscreens/Screen$WindowTraits;", "", "(Ljava/lang/String;I)V", "ORIENTATION", "COLOR", "STYLE", "TRANSLUCENT", "HIDDEN", "ANIMATED", "NAVIGATION_BAR_COLOR", "NAVIGATION_BAR_HIDDEN", "react-native-screens_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: Screen.kt */
    public enum WindowTraits {
        ORIENTATION,
        COLOR,
        STYLE,
        TRANSLUCENT,
        HIDDEN,
        ANIMATED,
        NAVIGATION_BAR_COLOR,
        NAVIGATION_BAR_HIDDEN
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Intrinsics.checkNotNullParameter(sparseArray, "container");
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        Intrinsics.checkNotNullParameter(sparseArray, "container");
    }

    public void setLayerType(int i, Paint paint) {
    }

    public Screen(ReactContext reactContext) {
        super(reactContext);
        setLayoutParams(new WindowManager.LayoutParams(2));
    }

    public final ScreenFragment getFragment() {
        return this.fragment;
    }

    public final void setFragment(ScreenFragment screenFragment) {
        this.fragment = screenFragment;
    }

    public final ScreenContainer<?> getContainer() {
        return this.container;
    }

    public final void setContainer(ScreenContainer<?> screenContainer) {
        this.container = screenContainer;
    }

    public final ActivityState getActivityState() {
        return this.activityState;
    }

    public final StackPresentation getStackPresentation() {
        return this.stackPresentation;
    }

    public final void setStackPresentation(StackPresentation stackPresentation2) {
        Intrinsics.checkNotNullParameter(stackPresentation2, "<set-?>");
        this.stackPresentation = stackPresentation2;
    }

    public final ReplaceAnimation getReplaceAnimation() {
        return this.replaceAnimation;
    }

    public final void setReplaceAnimation(ReplaceAnimation replaceAnimation2) {
        Intrinsics.checkNotNullParameter(replaceAnimation2, "<set-?>");
        this.replaceAnimation = replaceAnimation2;
    }

    public final StackAnimation getStackAnimation() {
        return this.stackAnimation;
    }

    public final void setStackAnimation(StackAnimation stackAnimation2) {
        Intrinsics.checkNotNullParameter(stackAnimation2, "<set-?>");
        this.stackAnimation = stackAnimation2;
    }

    public final boolean isGestureEnabled() {
        return this.isGestureEnabled;
    }

    public final void setGestureEnabled(boolean z) {
        this.isGestureEnabled = z;
    }

    public final Integer getScreenOrientation() {
        return this.screenOrientation;
    }

    public final Boolean isStatusBarAnimated() {
        return this.isStatusBarAnimated;
    }

    public final void setStatusBarAnimated(Boolean bool) {
        this.isStatusBarAnimated = bool;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            updateScreenSizePaper(i3 - i, i4 - i2);
        }
    }

    private final void updateScreenSizePaper(int i, int i2) {
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        reactContext.runOnNativeModulesQueueThread(new Screen$updateScreenSizePaper$1(this, reactContext, i, i2, reactContext));
    }

    public final ScreenStackHeaderConfig getHeaderConfig() {
        View childAt = getChildAt(0);
        if (childAt instanceof ScreenStackHeaderConfig) {
            return (ScreenStackHeaderConfig) childAt;
        }
        return null;
    }

    public final void setTransitioning(boolean z) {
        if (this.mTransitioning != z) {
            this.mTransitioning = z;
            boolean hasWebView = hasWebView(this);
            int i = 2;
            if (!hasWebView || getLayerType() == 2) {
                if (!z || hasWebView) {
                    i = 0;
                }
                super.setLayerType(i, (Paint) null);
            }
        }
    }

    private final boolean hasWebView(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof WebView) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && hasWebView((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    public final void setActivityState(ActivityState activityState2) {
        Intrinsics.checkNotNullParameter(activityState2, "activityState");
        if (activityState2 != this.activityState) {
            this.activityState = activityState2;
            ScreenContainer<?> screenContainer = this.container;
            if (screenContainer != null) {
                screenContainer.notifyChildUpdate();
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setScreenOrientation(java.lang.String r2) {
        /*
            r1 = this;
            if (r2 != 0) goto L_0x0008
            r2 = 0
            java.lang.Integer r2 = (java.lang.Integer) r2
            r1.screenOrientation = r2
            return
        L_0x0008:
            com.swmansion.rnscreens.ScreenWindowTraits r0 = com.swmansion.rnscreens.ScreenWindowTraits.INSTANCE
            r0.applyDidSetOrientation$react_native_screens_release()
            int r0 = r2.hashCode()
            switch(r0) {
                case -1894896954: goto L_0x006b;
                case 96673: goto L_0x005c;
                case 729267099: goto L_0x004e;
                case 1430647483: goto L_0x0040;
                case 1651658175: goto L_0x0032;
                case 1730732811: goto L_0x0023;
                case 2118770584: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x007a
        L_0x0015:
            java.lang.String r0 = "landscape_right"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x007a
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x007f
        L_0x0023:
            java.lang.String r0 = "landscape_left"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x007a
            r2 = 8
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x007f
        L_0x0032:
            java.lang.String r0 = "portrait_up"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x007a
            r2 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x007f
        L_0x0040:
            java.lang.String r0 = "landscape"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x007a
            r2 = 6
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x007f
        L_0x004e:
            java.lang.String r0 = "portrait"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x007a
            r2 = 7
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x007f
        L_0x005c:
            java.lang.String r0 = "all"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x007a
            r2 = 10
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x007f
        L_0x006b:
            java.lang.String r0 = "portrait_down"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x007a
            r2 = 9
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x007f
        L_0x007a:
            r2 = -1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x007f:
            r1.screenOrientation = r2
            com.swmansion.rnscreens.ScreenFragment r2 = r1.fragment
            if (r2 == 0) goto L_0x008e
            com.swmansion.rnscreens.ScreenWindowTraits r0 = com.swmansion.rnscreens.ScreenWindowTraits.INSTANCE
            android.app.Activity r2 = r2.tryGetActivity()
            r0.setOrientation$react_native_screens_release(r1, r2)
        L_0x008e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.Screen.setScreenOrientation(java.lang.String):void");
    }

    public final void changeAccessibilityMode(int i) {
        CustomToolbar toolbar;
        setImportantForAccessibility(i);
        ScreenStackHeaderConfig headerConfig = getHeaderConfig();
        if (headerConfig != null && (toolbar = headerConfig.getToolbar()) != null) {
            toolbar.setImportantForAccessibility(i);
        }
    }

    public final String getStatusBarStyle() {
        return this.mStatusBarStyle;
    }

    public final void setStatusBarStyle(String str) {
        if (str != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetStatusBarAppearance$react_native_screens_release();
        }
        this.mStatusBarStyle = str;
        ScreenFragment screenFragment = this.fragment;
        if (screenFragment != null) {
            ScreenWindowTraits.INSTANCE.setStyle$react_native_screens_release(this, screenFragment.tryGetActivity(), screenFragment.tryGetContext());
        }
    }

    public final Boolean isStatusBarHidden() {
        return this.mStatusBarHidden;
    }

    public final void setStatusBarHidden(Boolean bool) {
        if (bool != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetStatusBarAppearance$react_native_screens_release();
        }
        this.mStatusBarHidden = bool;
        ScreenFragment screenFragment = this.fragment;
        if (screenFragment != null) {
            ScreenWindowTraits.INSTANCE.setHidden$react_native_screens_release(this, screenFragment.tryGetActivity());
        }
    }

    public final Boolean isStatusBarTranslucent() {
        return this.mStatusBarTranslucent;
    }

    public final void setStatusBarTranslucent(Boolean bool) {
        if (bool != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetStatusBarAppearance$react_native_screens_release();
        }
        this.mStatusBarTranslucent = bool;
        ScreenFragment screenFragment = this.fragment;
        if (screenFragment != null) {
            ScreenWindowTraits.INSTANCE.setTranslucent$react_native_screens_release(this, screenFragment.tryGetActivity(), screenFragment.tryGetContext());
        }
    }

    public final Integer getStatusBarColor() {
        return this.mStatusBarColor;
    }

    public final void setStatusBarColor(Integer num) {
        if (num != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetStatusBarAppearance$react_native_screens_release();
        }
        this.mStatusBarColor = num;
        ScreenFragment screenFragment = this.fragment;
        if (screenFragment != null) {
            ScreenWindowTraits.INSTANCE.setColor$react_native_screens_release(this, screenFragment.tryGetActivity(), screenFragment.tryGetContext());
        }
    }

    public final Integer getNavigationBarColor() {
        return this.mNavigationBarColor;
    }

    public final void setNavigationBarColor(Integer num) {
        if (num != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetNavigationBarAppearance$react_native_screens_release();
        }
        this.mNavigationBarColor = num;
        ScreenFragment screenFragment = this.fragment;
        if (screenFragment != null) {
            ScreenWindowTraits.INSTANCE.setNavigationBarColor$react_native_screens_release(this, screenFragment.tryGetActivity());
        }
    }

    public final Boolean isNavigationBarHidden() {
        return this.mNavigationBarHidden;
    }

    public final void setNavigationBarHidden(Boolean bool) {
        if (bool != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetNavigationBarAppearance$react_native_screens_release();
        }
        this.mNavigationBarHidden = bool;
        ScreenFragment screenFragment = this.fragment;
        if (screenFragment != null) {
            ScreenWindowTraits.INSTANCE.setNavigationBarHidden$react_native_screens_release(this, screenFragment.tryGetActivity());
        }
    }

    public final boolean getNativeBackButtonDismissalEnabled() {
        return this.mNativeBackButtonDismissalEnabled;
    }

    public final void setNativeBackButtonDismissalEnabled(boolean z) {
        this.mNativeBackButtonDismissalEnabled = z;
    }
}
