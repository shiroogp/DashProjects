package com.swmansion.rnscreens;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNSScreenManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenManagerInterface;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.events.HeaderBackButtonClickedEvent;
import com.swmansion.rnscreens.events.ScreenAppearEvent;
import com.swmansion.rnscreens.events.ScreenDisappearEvent;
import com.swmansion.rnscreens.events.ScreenDismissedEvent;
import com.swmansion.rnscreens.events.ScreenTransitionProgressEvent;
import com.swmansion.rnscreens.events.ScreenWillAppearEvent;
import com.swmansion.rnscreens.events.ScreenWillDisappearEvent;
import com.swmansion.rnscreens.events.StackFinishTransitioningEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0007\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u00010B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0014J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0014J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0017J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0017H\u0017J\u001f\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014H\u0017¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0017H\u0017J\u001a\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\rH\u0017J\u001a\u0010!\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\rH\u0017J\u001a\u0010#\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\rH\u0017J\u001a\u0010$\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010\rH\u0017J\u001a\u0010&\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\rH\u0017J\u001f\u0010(\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010\u0014H\u0017¢\u0006\u0002\u0010\u001cJ\u0018\u0010*\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u0017H\u0017J\u001a\u0010,\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010-\u001a\u0004\u0018\u00010\rH\u0017J\u0018\u0010.\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u0017H\u0017R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/swmansion/rnscreens/ScreenViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/Screen;", "Lcom/facebook/react/viewmanagers/RNSScreenManagerInterface;", "()V", "mDelegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getDelegate", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "setActivityState", "", "view", "activityState", "", "setGestureEnabled", "gestureEnabled", "", "setNativeBackButtonDismissalEnabled", "nativeBackButtonDismissalEnabled", "setNavigationBarColor", "navigationBarColor", "(Lcom/swmansion/rnscreens/Screen;Ljava/lang/Integer;)V", "setNavigationBarHidden", "navigationBarHidden", "setReplaceAnimation", "animation", "setScreenOrientation", "screenOrientation", "setStackAnimation", "setStackPresentation", "presentation", "setStatusBarAnimation", "statusBarAnimation", "setStatusBarColor", "statusBarColor", "setStatusBarHidden", "statusBarHidden", "setStatusBarStyle", "statusBarStyle", "setStatusBarTranslucent", "statusBarTranslucent", "Companion", "react-native-screens_release"}, k = 1, mv = {1, 4, 0})
@ReactModule(name = "RNSScreen")
/* compiled from: ScreenViewManager.kt */
public final class ScreenViewManager extends ViewGroupManager<Screen> implements RNSScreenManagerInterface<Screen> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RNSScreen";
    private final ViewManagerDelegate<Screen> mDelegate = new RNSScreenManagerDelegate(this);

    public String getName() {
        return REACT_CLASS;
    }

    /* access modifiers changed from: protected */
    public Screen createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "reactContext");
        return new Screen(themedReactContext);
    }

    @ReactProp(name = "activityState")
    public void setActivityState(Screen screen, int i) {
        Intrinsics.checkNotNullParameter(screen, "view");
        if (i != -1) {
            if (i == 0) {
                screen.setActivityState(Screen.ActivityState.INACTIVE);
            } else if (i == 1) {
                screen.setActivityState(Screen.ActivityState.TRANSITIONING_OR_BELOW_TOP);
            } else if (i == 2) {
                screen.setActivityState(Screen.ActivityState.ON_TOP);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        if (r4.equals("containedModal") != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        if (r4.equals("modal") != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        r4 = com.swmansion.rnscreens.Screen.StackPresentation.MODAL;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004f, code lost:
        if (r4.equals("transparentModal") != false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0051, code lost:
        r4 = com.swmansion.rnscreens.Screen.StackPresentation.TRANSPARENT_MODAL;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0053, code lost:
        r3.setStackPresentation(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
        if (r4.equals("formSheet") != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        if (r4.equals("fullScreenModal") != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0027, code lost:
        if (r4.equals("containedTransparentModal") != false) goto L_0x0051;
     */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "stackPresentation")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setStackPresentation(com.swmansion.rnscreens.Screen r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            if (r4 == 0) goto L_0x0057
            int r0 = r4.hashCode()
            switch(r0) {
                case -76271493: goto L_0x0049;
                case 3452698: goto L_0x003e;
                case 104069805: goto L_0x0033;
                case 438078970: goto L_0x002a;
                case 955284238: goto L_0x0021;
                case 1171936146: goto L_0x0018;
                case 1798290171: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0057
        L_0x000f:
            java.lang.String r0 = "formSheet"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0057
            goto L_0x003b
        L_0x0018:
            java.lang.String r0 = "fullScreenModal"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0057
            goto L_0x003b
        L_0x0021:
            java.lang.String r0 = "containedTransparentModal"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0057
            goto L_0x0051
        L_0x002a:
            java.lang.String r0 = "containedModal"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0057
            goto L_0x003b
        L_0x0033:
            java.lang.String r0 = "modal"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0057
        L_0x003b:
            com.swmansion.rnscreens.Screen$StackPresentation r4 = com.swmansion.rnscreens.Screen.StackPresentation.MODAL
            goto L_0x0053
        L_0x003e:
            java.lang.String r0 = "push"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0057
            com.swmansion.rnscreens.Screen$StackPresentation r4 = com.swmansion.rnscreens.Screen.StackPresentation.PUSH
            goto L_0x0053
        L_0x0049:
            java.lang.String r0 = "transparentModal"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0057
        L_0x0051:
            com.swmansion.rnscreens.Screen$StackPresentation r4 = com.swmansion.rnscreens.Screen.StackPresentation.TRANSPARENT_MODAL
        L_0x0053:
            r3.setStackPresentation(r4)
            return
        L_0x0057:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r3 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown presentation type "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r4 = r0.append(r4)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenViewManager.setStackPresentation(com.swmansion.rnscreens.Screen, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
        if (r4.equals("flip") != false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006b, code lost:
        if (r4.equals("simple_push") != false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008d, code lost:
        throw new com.facebook.react.bridge.JSApplicationIllegalArgumentException("Unknown animation type " + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        if (r4.equals("default") != false) goto L_0x006d;
     */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "stackAnimation")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setStackAnimation(com.swmansion.rnscreens.Screen r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            if (r4 != 0) goto L_0x0009
            goto L_0x006d
        L_0x0009:
            int r0 = r4.hashCode()
            switch(r0) {
                case -1418955385: goto L_0x0065;
                case -427095442: goto L_0x005a;
                case -349395819: goto L_0x004f;
                case 3135100: goto L_0x0044;
                case 3145837: goto L_0x003b;
                case 3387192: goto L_0x0030;
                case 182437661: goto L_0x0025;
                case 1544803905: goto L_0x001c;
                case 1601504978: goto L_0x0011;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x0073
        L_0x0011:
            java.lang.String r0 = "slide_from_bottom"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0073
            com.swmansion.rnscreens.Screen$StackAnimation r4 = com.swmansion.rnscreens.Screen.StackAnimation.SLIDE_FROM_BOTTOM
            goto L_0x006f
        L_0x001c:
            java.lang.String r0 = "default"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0073
            goto L_0x006d
        L_0x0025:
            java.lang.String r0 = "fade_from_bottom"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0073
            com.swmansion.rnscreens.Screen$StackAnimation r4 = com.swmansion.rnscreens.Screen.StackAnimation.FADE_FROM_BOTTOM
            goto L_0x006f
        L_0x0030:
            java.lang.String r0 = "none"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0073
            com.swmansion.rnscreens.Screen$StackAnimation r4 = com.swmansion.rnscreens.Screen.StackAnimation.NONE
            goto L_0x006f
        L_0x003b:
            java.lang.String r0 = "flip"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0073
            goto L_0x006d
        L_0x0044:
            java.lang.String r0 = "fade"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0073
            com.swmansion.rnscreens.Screen$StackAnimation r4 = com.swmansion.rnscreens.Screen.StackAnimation.FADE
            goto L_0x006f
        L_0x004f:
            java.lang.String r0 = "slide_from_right"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0073
            com.swmansion.rnscreens.Screen$StackAnimation r4 = com.swmansion.rnscreens.Screen.StackAnimation.SLIDE_FROM_RIGHT
            goto L_0x006f
        L_0x005a:
            java.lang.String r0 = "slide_from_left"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0073
            com.swmansion.rnscreens.Screen$StackAnimation r4 = com.swmansion.rnscreens.Screen.StackAnimation.SLIDE_FROM_LEFT
            goto L_0x006f
        L_0x0065:
            java.lang.String r0 = "simple_push"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0073
        L_0x006d:
            com.swmansion.rnscreens.Screen$StackAnimation r4 = com.swmansion.rnscreens.Screen.StackAnimation.DEFAULT
        L_0x006f:
            r3.setStackAnimation(r4)
            return
        L_0x0073:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r3 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown animation type "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r4 = r0.append(r4)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenViewManager.setStackAnimation(com.swmansion.rnscreens.Screen, java.lang.String):void");
    }

    @ReactProp(defaultBoolean = true, name = "gestureEnabled")
    public void setGestureEnabled(Screen screen, boolean z) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setGestureEnabled(z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        if (r4.equals("pop") != false) goto L_0x0029;
     */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "replaceAnimation")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setReplaceAnimation(com.swmansion.rnscreens.Screen r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            if (r4 != 0) goto L_0x0008
            goto L_0x0029
        L_0x0008:
            int r0 = r4.hashCode()
            r1 = 111185(0x1b251, float:1.55803E-40)
            if (r0 == r1) goto L_0x0021
            r1 = 3452698(0x34af1a, float:4.83826E-39)
            if (r0 != r1) goto L_0x002f
            java.lang.String r0 = "push"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x002f
            com.swmansion.rnscreens.Screen$ReplaceAnimation r4 = com.swmansion.rnscreens.Screen.ReplaceAnimation.PUSH
            goto L_0x002b
        L_0x0021:
            java.lang.String r0 = "pop"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x002f
        L_0x0029:
            com.swmansion.rnscreens.Screen$ReplaceAnimation r4 = com.swmansion.rnscreens.Screen.ReplaceAnimation.POP
        L_0x002b:
            r3.setReplaceAnimation(r4)
            return
        L_0x002f:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r3 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown replace animation type "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r4 = r0.append(r4)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenViewManager.setReplaceAnimation(com.swmansion.rnscreens.Screen, java.lang.String):void");
    }

    @ReactProp(name = "screenOrientation")
    public void setScreenOrientation(Screen screen, String str) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setScreenOrientation(str);
    }

    @ReactProp(name = "statusBarAnimation")
    public void setStatusBarAnimation(Screen screen, String str) {
        Intrinsics.checkNotNullParameter(screen, "view");
        boolean z = true;
        if (str == null || !(!Intrinsics.areEqual((Object) ViewProps.NONE, (Object) str))) {
            z = false;
        }
        screen.setStatusBarAnimated(Boolean.valueOf(z));
    }

    @ReactProp(name = "statusBarColor")
    public void setStatusBarColor(Screen screen, Integer num) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setStatusBarColor(num);
    }

    @ReactProp(name = "statusBarStyle")
    public void setStatusBarStyle(Screen screen, String str) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setStatusBarStyle(str);
    }

    @ReactProp(name = "statusBarTranslucent")
    public void setStatusBarTranslucent(Screen screen, boolean z) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setStatusBarTranslucent(Boolean.valueOf(z));
    }

    @ReactProp(name = "statusBarHidden")
    public void setStatusBarHidden(Screen screen, boolean z) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setStatusBarHidden(Boolean.valueOf(z));
    }

    @ReactProp(customType = "Color", name = "navigationBarColor")
    public void setNavigationBarColor(Screen screen, Integer num) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setNavigationBarColor(num);
    }

    @ReactProp(name = "navigationBarHidden")
    public void setNavigationBarHidden(Screen screen, boolean z) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setNavigationBarHidden(Boolean.valueOf(z));
    }

    @ReactProp(name = "nativeBackButtonDismissalEnabled")
    public void setNativeBackButtonDismissalEnabled(Screen screen, boolean z) {
        Intrinsics.checkNotNullParameter(screen, "view");
        screen.setNativeBackButtonDismissalEnabled(z);
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> of = MapBuilder.of(ScreenDismissedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onDismissed"), ScreenWillAppearEvent.EVENT_NAME, MapBuilder.of("registrationName", "onWillAppear"), ScreenAppearEvent.EVENT_NAME, MapBuilder.of("registrationName", "onAppear"), ScreenWillDisappearEvent.EVENT_NAME, MapBuilder.of("registrationName", "onWillDisappear"), ScreenDisappearEvent.EVENT_NAME, MapBuilder.of("registrationName", "onDisappear"), StackFinishTransitioningEvent.EVENT_NAME, MapBuilder.of("registrationName", "onFinishTransitioning"), ScreenTransitionProgressEvent.EVENT_NAME, MapBuilder.of("registrationName", "onTransitionProgress"));
        Intrinsics.checkNotNullExpressionValue(of, "MapBuilder.of(\n         …itionProgress\")\n        )");
        Map of2 = MapBuilder.of("registrationName", "onHeaderBackButtonClicked");
        Intrinsics.checkNotNullExpressionValue(of2, "MapBuilder.of(\"registrat…HeaderBackButtonClicked\")");
        of.put(HeaderBackButtonClickedEvent.EVENT_NAME, of2);
        return of;
    }

    /* access modifiers changed from: protected */
    public ViewManagerDelegate<Screen> getDelegate() {
        return this.mDelegate;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/swmansion/rnscreens/ScreenViewManager$Companion;", "", "()V", "REACT_CLASS", "", "react-native-screens_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ScreenViewManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
