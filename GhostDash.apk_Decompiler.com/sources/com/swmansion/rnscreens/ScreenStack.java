package com.swmansion.rnscreens;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.events.StackFinishTransitioningEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 A2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002ABB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u001cH\u0014J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0002J\u0010\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020(H\u0014J\b\u0010)\u001a\u00020$H\u0002J\b\u0010*\u001a\u00020$H\u0002J \u0010+\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020(2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0014J\u0010\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020-H\u0016J\u0012\u00102\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020$H\u0014J\f\u00105\u001a\u00060\bR\u00020\u0000H\u0002J\b\u00106\u001a\u00020$H\u0016J\u0006\u00107\u001a\u00020$J\u0014\u00108\u001a\u00020$2\n\u00109\u001a\u00060\bR\u00020\u0000H\u0002J\b\u0010:\u001a\u00020$H\u0016J\u0010\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020\u0019H\u0016J\u0010\u0010=\u001a\u00020$2\u0006\u00101\u001a\u00020-H\u0016J\u0010\u0010>\u001a\u00020$2\u0006\u00101\u001a\u00020-H\u0016J\u0012\u0010?\u001a\u00020$2\b\u0010@\u001a\u0004\u0018\u00010\u0002H\u0002R\u0018\u0010\u0006\u001a\f\u0012\b\u0012\u00060\bR\u00020\u00000\u0007X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\f\u0012\b\u0012\u00060\bR\u00020\u00000\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0015j\b\u0012\u0004\u0012\u00020\u0002`\u0016X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001e¨\u0006C"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStack;", "Lcom/swmansion/rnscreens/ScreenContainer;", "Lcom/swmansion/rnscreens/ScreenStackFragment;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "drawingOpPool", "", "Lcom/swmansion/rnscreens/ScreenStack$DrawingOp;", "drawingOps", "goingForward", "", "getGoingForward", "()Z", "setGoingForward", "(Z)V", "isDetachingCurrentScreen", "mDismissed", "", "mRemovalTransitionStarted", "mStack", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mTopScreen", "previousChildrenCount", "", "reverseLastTwoChildren", "rootScreen", "Lcom/swmansion/rnscreens/Screen;", "getRootScreen", "()Lcom/swmansion/rnscreens/Screen;", "topScreen", "getTopScreen", "adapt", "screen", "dismiss", "", "screenFragment", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchOnFinishTransitioning", "drawAndRelease", "drawChild", "child", "Landroid/view/View;", "drawingTime", "", "endViewTransition", "view", "hasScreen", "Lcom/swmansion/rnscreens/ScreenFragment;", "notifyContainerUpdate", "obtainDrawingOp", "onUpdate", "onViewAppearTransitionEnd", "performDraw", "op", "removeAllScreens", "removeScreenAt", "index", "removeView", "startViewTransition", "turnOffA11yUnderTransparentScreen", "visibleBottom", "Companion", "DrawingOp", "react-native-screens_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: ScreenStack.kt */
public final class ScreenStack extends ScreenContainer<ScreenStackFragment> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<DrawingOp> drawingOpPool = new ArrayList();
    private final List<DrawingOp> drawingOps = new ArrayList();
    private boolean goingForward;
    private boolean isDetachingCurrentScreen;
    private final Set<ScreenStackFragment> mDismissed = new HashSet();
    private boolean mRemovalTransitionStarted;
    private final ArrayList<ScreenStackFragment> mStack = new ArrayList<>();
    private ScreenStackFragment mTopScreen;
    private int previousChildrenCount;
    private boolean reverseLastTwoChildren;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Screen.StackAnimation.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Screen.StackAnimation.DEFAULT.ordinal()] = 1;
            iArr[Screen.StackAnimation.NONE.ordinal()] = 2;
            iArr[Screen.StackAnimation.FADE.ordinal()] = 3;
            iArr[Screen.StackAnimation.SLIDE_FROM_RIGHT.ordinal()] = 4;
            iArr[Screen.StackAnimation.SLIDE_FROM_LEFT.ordinal()] = 5;
            iArr[Screen.StackAnimation.SLIDE_FROM_BOTTOM.ordinal()] = 6;
            iArr[Screen.StackAnimation.FADE_FROM_BOTTOM.ordinal()] = 7;
            int[] iArr2 = new int[Screen.StackAnimation.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[Screen.StackAnimation.DEFAULT.ordinal()] = 1;
            iArr2[Screen.StackAnimation.NONE.ordinal()] = 2;
            iArr2[Screen.StackAnimation.FADE.ordinal()] = 3;
            iArr2[Screen.StackAnimation.SLIDE_FROM_RIGHT.ordinal()] = 4;
            iArr2[Screen.StackAnimation.SLIDE_FROM_LEFT.ordinal()] = 5;
            iArr2[Screen.StackAnimation.SLIDE_FROM_BOTTOM.ordinal()] = 6;
            iArr2[Screen.StackAnimation.FADE_FROM_BOTTOM.ordinal()] = 7;
        }
    }

    public ScreenStack(Context context) {
        super(context);
    }

    public final boolean getGoingForward() {
        return this.goingForward;
    }

    public final void setGoingForward(boolean z) {
        this.goingForward = z;
    }

    public final void dismiss(ScreenStackFragment screenStackFragment) {
        Intrinsics.checkNotNullParameter(screenStackFragment, "screenFragment");
        this.mDismissed.add(screenStackFragment);
        performUpdatesNow();
    }

    public Screen getTopScreen() {
        ScreenStackFragment screenStackFragment = this.mTopScreen;
        if (screenStackFragment != null) {
            return screenStackFragment.getScreen();
        }
        return null;
    }

    public final Screen getRootScreen() {
        int screenCount = getScreenCount();
        for (int i = 0; i < screenCount; i++) {
            Screen screenAt = getScreenAt(i);
            if (!CollectionsKt.contains(this.mDismissed, screenAt.getFragment())) {
                return screenAt;
            }
        }
        throw new IllegalStateException("Stack has no root screen set");
    }

    /* access modifiers changed from: protected */
    public ScreenStackFragment adapt(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        return new ScreenStackFragment(screen);
    }

    public void startViewTransition(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.startViewTransition(view);
        this.mRemovalTransitionStarted = true;
    }

    public void endViewTransition(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.endViewTransition(view);
        if (this.mRemovalTransitionStarted) {
            this.mRemovalTransitionStarted = false;
            dispatchOnFinishTransitioning();
        }
    }

    public final void onViewAppearTransitionEnd() {
        if (!this.mRemovalTransitionStarted) {
            dispatchOnFinishTransitioning();
        }
    }

    private final void dispatchOnFinishTransitioning() {
        EventDispatcher eventDispatcher;
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        UIManagerModule uIManagerModule = (UIManagerModule) ((ReactContext) context).getNativeModule(UIManagerModule.class);
        if (uIManagerModule != null && (eventDispatcher = uIManagerModule.getEventDispatcher()) != null) {
            eventDispatcher.dispatchEvent(new StackFinishTransitioningEvent(getId()));
        }
    }

    public void removeScreenAt(int i) {
        Screen screenAt = getScreenAt(i);
        Collection collection = this.mDismissed;
        ScreenFragment fragment = screenAt.getFragment();
        Objects.requireNonNull(collection, "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        TypeIntrinsics.asMutableCollection(collection).remove(fragment);
        super.removeScreenAt(i);
    }

    public void removeAllScreens() {
        this.mDismissed.clear();
        super.removeAllScreens();
    }

    public boolean hasScreen(ScreenFragment screenFragment) {
        return super.hasScreen(screenFragment) && !CollectionsKt.contains(this.mDismissed, screenFragment);
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01e3 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x019f A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onUpdate() {
        /*
            r9 = this;
            r0 = 0
            r1 = r0
            com.swmansion.rnscreens.ScreenStackFragment r1 = (com.swmansion.rnscreens.ScreenStackFragment) r1
            r2 = 0
            r9.isDetachingCurrentScreen = r2
            java.util.ArrayList r3 = r9.mScreenFragments
            java.util.Collection r3 = (java.util.Collection) r3
            int r3 = r3.size()
            int r3 = r3 + -1
            r4 = r3
            r3 = r1
        L_0x0013:
            if (r4 < 0) goto L_0x003b
            java.util.ArrayList r5 = r9.mScreenFragments
            java.lang.Object r5 = r5.get(r4)
            java.lang.String r6 = "mScreenFragments[i]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            com.swmansion.rnscreens.ScreenStackFragment r5 = (com.swmansion.rnscreens.ScreenStackFragment) r5
            java.util.Set<com.swmansion.rnscreens.ScreenStackFragment> r6 = r9.mDismissed
            boolean r6 = r6.contains(r5)
            if (r6 != 0) goto L_0x0038
            if (r1 != 0) goto L_0x002e
            r1 = r5
            goto L_0x002f
        L_0x002e:
            r3 = r5
        L_0x002f:
            com.swmansion.rnscreens.ScreenStack$Companion r6 = Companion
            boolean r5 = r6.isTransparent(r5)
            if (r5 != 0) goto L_0x0038
            goto L_0x003b
        L_0x0038:
            int r4 = r4 + -1
            goto L_0x0013
        L_0x003b:
            r4 = r0
            com.swmansion.rnscreens.Screen$StackAnimation r4 = (com.swmansion.rnscreens.Screen.StackAnimation) r4
            java.util.ArrayList<com.swmansion.rnscreens.ScreenStackFragment> r5 = r9.mStack
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            boolean r5 = kotlin.collections.CollectionsKt.contains(r5, r1)
            r6 = 1
            if (r5 != 0) goto L_0x0099
            com.swmansion.rnscreens.ScreenStackFragment r5 = r9.mTopScreen
            if (r5 == 0) goto L_0x0090
            if (r1 == 0) goto L_0x0090
            if (r5 == 0) goto L_0x005b
            java.util.ArrayList r4 = r9.mScreenFragments
            boolean r4 = r4.contains(r5)
            if (r4 != r6) goto L_0x005b
            r4 = r6
            goto L_0x005c
        L_0x005b:
            r4 = r2
        L_0x005c:
            com.swmansion.rnscreens.Screen r5 = r1.getScreen()
            com.swmansion.rnscreens.Screen$ReplaceAnimation r5 = r5.getReplaceAnimation()
            com.swmansion.rnscreens.Screen$ReplaceAnimation r7 = com.swmansion.rnscreens.Screen.ReplaceAnimation.PUSH
            if (r5 != r7) goto L_0x006a
            r5 = r6
            goto L_0x006b
        L_0x006a:
            r5 = r2
        L_0x006b:
            if (r4 != 0) goto L_0x0072
            if (r5 == 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r4 = r2
            goto L_0x0073
        L_0x0072:
            r4 = r6
        L_0x0073:
            if (r4 == 0) goto L_0x007e
            com.swmansion.rnscreens.Screen r0 = r1.getScreen()
            com.swmansion.rnscreens.Screen$StackAnimation r0 = r0.getStackAnimation()
            goto L_0x008c
        L_0x007e:
            com.swmansion.rnscreens.ScreenStackFragment r5 = r9.mTopScreen
            if (r5 == 0) goto L_0x008c
            com.swmansion.rnscreens.Screen r5 = r5.getScreen()
            if (r5 == 0) goto L_0x008c
            com.swmansion.rnscreens.Screen$StackAnimation r0 = r5.getStackAnimation()
        L_0x008c:
            r8 = r4
            r4 = r0
            r0 = r8
            goto L_0x00b6
        L_0x0090:
            if (r5 != 0) goto L_0x00b5
            if (r1 == 0) goto L_0x00b5
            com.swmansion.rnscreens.Screen$StackAnimation r4 = com.swmansion.rnscreens.Screen.StackAnimation.NONE
            r9.goingForward = r6
            goto L_0x00b5
        L_0x0099:
            com.swmansion.rnscreens.ScreenStackFragment r5 = r9.mTopScreen
            if (r5 == 0) goto L_0x00b5
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r1)
            r5 = r5 ^ r6
            if (r5 == 0) goto L_0x00b5
            com.swmansion.rnscreens.ScreenStackFragment r4 = r9.mTopScreen
            if (r4 == 0) goto L_0x00b2
            com.swmansion.rnscreens.Screen r4 = r4.getScreen()
            if (r4 == 0) goto L_0x00b2
            com.swmansion.rnscreens.Screen$StackAnimation r0 = r4.getStackAnimation()
        L_0x00b2:
            r4 = r0
            r0 = r2
            goto L_0x00b6
        L_0x00b5:
            r0 = r6
        L_0x00b6:
            androidx.fragment.app.FragmentTransaction r5 = r9.createTransaction()
            if (r4 == 0) goto L_0x0150
            if (r0 == 0) goto L_0x010a
            if (r4 != 0) goto L_0x00c2
            goto L_0x0150
        L_0x00c2:
            int[] r7 = com.swmansion.rnscreens.ScreenStack.WhenMappings.$EnumSwitchMapping$0
            int r4 = r4.ordinal()
            r4 = r7[r4]
            switch(r4) {
                case 1: goto L_0x0102;
                case 2: goto L_0x00fa;
                case 3: goto L_0x00f2;
                case 4: goto L_0x00ea;
                case 5: goto L_0x00e1;
                case 6: goto L_0x00d8;
                case 7: goto L_0x00cf;
                default: goto L_0x00cd;
            }
        L_0x00cd:
            goto L_0x0150
        L_0x00cf:
            int r4 = com.swmansion.rnscreens.R.anim.rns_fade_from_bottom
            int r7 = com.swmansion.rnscreens.R.anim.rns_no_animation_350
            r5.setCustomAnimations(r4, r7)
            goto L_0x0150
        L_0x00d8:
            int r4 = com.swmansion.rnscreens.R.anim.rns_slide_in_from_bottom
            int r7 = com.swmansion.rnscreens.R.anim.rns_no_animation_medium
            r5.setCustomAnimations(r4, r7)
            goto L_0x0150
        L_0x00e1:
            int r4 = com.swmansion.rnscreens.R.anim.rns_slide_in_from_left
            int r7 = com.swmansion.rnscreens.R.anim.rns_slide_out_to_right
            r5.setCustomAnimations(r4, r7)
            goto L_0x0150
        L_0x00ea:
            int r4 = com.swmansion.rnscreens.R.anim.rns_slide_in_from_right
            int r7 = com.swmansion.rnscreens.R.anim.rns_slide_out_to_left
            r5.setCustomAnimations(r4, r7)
            goto L_0x0150
        L_0x00f2:
            int r4 = com.swmansion.rnscreens.R.anim.rns_fade_in
            int r7 = com.swmansion.rnscreens.R.anim.rns_fade_out
            r5.setCustomAnimations(r4, r7)
            goto L_0x0150
        L_0x00fa:
            int r4 = com.swmansion.rnscreens.R.anim.rns_no_animation_20
            int r7 = com.swmansion.rnscreens.R.anim.rns_no_animation_20
            r5.setCustomAnimations(r4, r7)
            goto L_0x0150
        L_0x0102:
            int r4 = com.swmansion.rnscreens.R.anim.rns_default_enter_in
            int r7 = com.swmansion.rnscreens.R.anim.rns_default_enter_out
            r5.setCustomAnimations(r4, r7)
            goto L_0x0150
        L_0x010a:
            if (r4 != 0) goto L_0x010d
            goto L_0x0150
        L_0x010d:
            int[] r7 = com.swmansion.rnscreens.ScreenStack.WhenMappings.$EnumSwitchMapping$1
            int r4 = r4.ordinal()
            r4 = r7[r4]
            switch(r4) {
                case 1: goto L_0x0149;
                case 2: goto L_0x0141;
                case 3: goto L_0x0139;
                case 4: goto L_0x0131;
                case 5: goto L_0x0129;
                case 6: goto L_0x0121;
                case 7: goto L_0x0119;
                default: goto L_0x0118;
            }
        L_0x0118:
            goto L_0x0150
        L_0x0119:
            int r4 = com.swmansion.rnscreens.R.anim.rns_no_animation_250
            int r7 = com.swmansion.rnscreens.R.anim.rns_fade_to_bottom
            r5.setCustomAnimations(r4, r7)
            goto L_0x0150
        L_0x0121:
            int r4 = com.swmansion.rnscreens.R.anim.rns_no_animation_medium
            int r7 = com.swmansion.rnscreens.R.anim.rns_slide_out_to_bottom
            r5.setCustomAnimations(r4, r7)
            goto L_0x0150
        L_0x0129:
            int r4 = com.swmansion.rnscreens.R.anim.rns_slide_in_from_right
            int r7 = com.swmansion.rnscreens.R.anim.rns_slide_out_to_left
            r5.setCustomAnimations(r4, r7)
            goto L_0x0150
        L_0x0131:
            int r4 = com.swmansion.rnscreens.R.anim.rns_slide_in_from_left
            int r7 = com.swmansion.rnscreens.R.anim.rns_slide_out_to_right
            r5.setCustomAnimations(r4, r7)
            goto L_0x0150
        L_0x0139:
            int r4 = com.swmansion.rnscreens.R.anim.rns_fade_in
            int r7 = com.swmansion.rnscreens.R.anim.rns_fade_out
            r5.setCustomAnimations(r4, r7)
            goto L_0x0150
        L_0x0141:
            int r4 = com.swmansion.rnscreens.R.anim.rns_no_animation_20
            int r7 = com.swmansion.rnscreens.R.anim.rns_no_animation_20
            r5.setCustomAnimations(r4, r7)
            goto L_0x0150
        L_0x0149:
            int r4 = com.swmansion.rnscreens.R.anim.rns_default_exit_in
            int r7 = com.swmansion.rnscreens.R.anim.rns_default_exit_out
            r5.setCustomAnimations(r4, r7)
        L_0x0150:
            r9.goingForward = r0
            if (r0 == 0) goto L_0x0162
            if (r1 == 0) goto L_0x0162
            com.swmansion.rnscreens.ScreenStack$Companion r0 = Companion
            boolean r0 = r0.needsDrawReordering(r1)
            if (r0 == 0) goto L_0x0162
            if (r3 != 0) goto L_0x0162
            r9.isDetachingCurrentScreen = r6
        L_0x0162:
            java.util.ArrayList<com.swmansion.rnscreens.ScreenStackFragment> r0 = r9.mStack
            java.util.Iterator r0 = r0.iterator()
        L_0x0168:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x018a
            java.lang.Object r4 = r0.next()
            com.swmansion.rnscreens.ScreenStackFragment r4 = (com.swmansion.rnscreens.ScreenStackFragment) r4
            java.util.ArrayList r7 = r9.mScreenFragments
            boolean r7 = r7.contains(r4)
            if (r7 == 0) goto L_0x0184
            java.util.Set<com.swmansion.rnscreens.ScreenStackFragment> r7 = r9.mDismissed
            boolean r7 = r7.contains(r4)
            if (r7 == 0) goto L_0x0168
        L_0x0184:
            androidx.fragment.app.Fragment r4 = (androidx.fragment.app.Fragment) r4
            r5.remove(r4)
            goto L_0x0168
        L_0x018a:
            java.util.ArrayList r0 = r9.mScreenFragments
            java.util.Iterator r0 = r0.iterator()
        L_0x0190:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x01af
            java.lang.Object r4 = r0.next()
            com.swmansion.rnscreens.ScreenStackFragment r4 = (com.swmansion.rnscreens.ScreenStackFragment) r4
            if (r4 != r3) goto L_0x019f
            goto L_0x01af
        L_0x019f:
            if (r4 == r1) goto L_0x0190
            java.util.Set<com.swmansion.rnscreens.ScreenStackFragment> r7 = r9.mDismissed
            boolean r7 = r7.contains(r4)
            if (r7 != 0) goto L_0x0190
            androidx.fragment.app.Fragment r4 = (androidx.fragment.app.Fragment) r4
            r5.remove(r4)
            goto L_0x0190
        L_0x01af:
            if (r3 == 0) goto L_0x01e3
            boolean r0 = r3.isAdded()
            if (r0 != 0) goto L_0x01e3
            java.util.ArrayList r0 = r9.mScreenFragments
            java.util.Iterator r0 = r0.iterator()
        L_0x01bd:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x01f5
            java.lang.Object r4 = r0.next()
            com.swmansion.rnscreens.ScreenStackFragment r4 = (com.swmansion.rnscreens.ScreenStackFragment) r4
            if (r6 == 0) goto L_0x01ce
            if (r4 != r3) goto L_0x01bd
            r6 = r2
        L_0x01ce:
            int r7 = r9.getId()
            androidx.fragment.app.Fragment r4 = (androidx.fragment.app.Fragment) r4
            androidx.fragment.app.FragmentTransaction r4 = r5.add((int) r7, (androidx.fragment.app.Fragment) r4)
            com.swmansion.rnscreens.ScreenStack$onUpdate$1$1 r7 = new com.swmansion.rnscreens.ScreenStack$onUpdate$1$1
            r7.<init>(r1)
            java.lang.Runnable r7 = (java.lang.Runnable) r7
            r4.runOnCommit(r7)
            goto L_0x01bd
        L_0x01e3:
            if (r1 == 0) goto L_0x01f5
            boolean r0 = r1.isAdded()
            if (r0 != 0) goto L_0x01f5
            int r0 = r9.getId()
            r2 = r1
            androidx.fragment.app.Fragment r2 = (androidx.fragment.app.Fragment) r2
            r5.add((int) r0, (androidx.fragment.app.Fragment) r2)
        L_0x01f5:
            r9.mTopScreen = r1
            java.util.ArrayList<com.swmansion.rnscreens.ScreenStackFragment> r0 = r9.mStack
            r0.clear()
            java.util.ArrayList<com.swmansion.rnscreens.ScreenStackFragment> r0 = r9.mStack
            java.util.ArrayList r1 = r9.mScreenFragments
            java.util.Collection r1 = (java.util.Collection) r1
            r0.addAll(r1)
            r9.turnOffA11yUnderTransparentScreen(r3)
            r5.commitNowAllowingStateLoss()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenStack.onUpdate():void");
    }

    private final void turnOffA11yUnderTransparentScreen(ScreenStackFragment screenStackFragment) {
        ScreenStackFragment screenStackFragment2;
        if (this.mScreenFragments.size() > 1 && screenStackFragment != null && (screenStackFragment2 = this.mTopScreen) != null && Companion.isTransparent(screenStackFragment2)) {
            for (ScreenStackFragment screenStackFragment3 : CollectionsKt.asReversed(CollectionsKt.slice(this.mScreenFragments, RangesKt.until(0, this.mScreenFragments.size() - 1)))) {
                screenStackFragment3.getScreen().changeAccessibilityMode(4);
                if (Intrinsics.areEqual((Object) screenStackFragment3, (Object) screenStackFragment)) {
                    break;
                }
            }
        }
        Screen topScreen = getTopScreen();
        if (topScreen != null) {
            topScreen.changeAccessibilityMode(0);
        }
    }

    /* access modifiers changed from: protected */
    public void notifyContainerUpdate() {
        Iterator<ScreenStackFragment> it2 = this.mStack.iterator();
        while (it2.hasNext()) {
            it2.next().onContainerUpdate();
        }
    }

    public void removeView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.isDetachingCurrentScreen) {
            this.isDetachingCurrentScreen = false;
            this.reverseLastTwoChildren = true;
        }
        super.removeView(view);
    }

    private final void drawAndRelease() {
        int size = this.drawingOps.size();
        for (int i = 0; i < size; i++) {
            DrawingOp drawingOp = this.drawingOps.get(i);
            drawingOp.draw();
            this.drawingOpPool.add(drawingOp);
        }
        this.drawingOps.clear();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (this.drawingOps.size() < this.previousChildrenCount) {
            this.reverseLastTwoChildren = false;
        }
        this.previousChildrenCount = this.drawingOps.size();
        if (this.reverseLastTwoChildren && this.drawingOps.size() >= 2) {
            List<DrawingOp> list = this.drawingOps;
            Collections.swap(list, list.size() - 1, this.drawingOps.size() - 2);
        }
        drawAndRelease();
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(view, "child");
        this.drawingOps.add(obtainDrawingOp().set(canvas, view, j));
        return true;
    }

    /* access modifiers changed from: private */
    public final void performDraw(DrawingOp drawingOp) {
        super.drawChild(drawingOp.getCanvas(), drawingOp.getChild(), drawingOp.getDrawingTime());
    }

    private final DrawingOp obtainDrawingOp() {
        if (this.drawingOpPool.isEmpty()) {
            return new DrawingOp();
        }
        List<DrawingOp> list = this.drawingOpPool;
        return list.remove(list.size() - 1);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J)\u0010\u0017\u001a\u00060\u0000R\u00020\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStack$DrawingOp;", "", "(Lcom/swmansion/rnscreens/ScreenStack;)V", "canvas", "Landroid/graphics/Canvas;", "getCanvas", "()Landroid/graphics/Canvas;", "setCanvas", "(Landroid/graphics/Canvas;)V", "child", "Landroid/view/View;", "getChild", "()Landroid/view/View;", "setChild", "(Landroid/view/View;)V", "drawingTime", "", "getDrawingTime", "()J", "setDrawingTime", "(J)V", "draw", "", "set", "Lcom/swmansion/rnscreens/ScreenStack;", "react-native-screens_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ScreenStack.kt */
    private final class DrawingOp {
        private Canvas canvas;
        private View child;
        private long drawingTime;

        public DrawingOp() {
        }

        public final Canvas getCanvas() {
            return this.canvas;
        }

        public final void setCanvas(Canvas canvas2) {
            this.canvas = canvas2;
        }

        public final View getChild() {
            return this.child;
        }

        public final void setChild(View view) {
            this.child = view;
        }

        public final long getDrawingTime() {
            return this.drawingTime;
        }

        public final void setDrawingTime(long j) {
            this.drawingTime = j;
        }

        public final DrawingOp set(Canvas canvas2, View view, long j) {
            this.canvas = canvas2;
            this.child = view;
            this.drawingTime = j;
            return this;
        }

        public final void draw() {
            ScreenStack.this.performDraw(this);
            this.canvas = null;
            this.child = null;
            this.drawingTime = 0;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\b"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStack$Companion;", "", "()V", "isTransparent", "", "fragment", "Lcom/swmansion/rnscreens/ScreenStackFragment;", "needsDrawReordering", "react-native-screens_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ScreenStack.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final boolean isTransparent(ScreenStackFragment screenStackFragment) {
            return screenStackFragment.getScreen().getStackPresentation() == Screen.StackPresentation.TRANSPARENT_MODAL;
        }

        /* access modifiers changed from: private */
        public final boolean needsDrawReordering(ScreenStackFragment screenStackFragment) {
            return screenStackFragment.getScreen().getStackAnimation() == Screen.StackAnimation.SLIDE_FROM_BOTTOM || screenStackFragment.getScreen().getStackAnimation() == Screen.StackAnimation.FADE_FROM_BOTTOM;
        }
    }
}
