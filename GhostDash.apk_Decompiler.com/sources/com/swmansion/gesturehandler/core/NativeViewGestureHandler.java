package com.swmansion.gesturehandler.core;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import com.facebook.react.views.textinput.ReactEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0003\u0019\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0014J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0011\u001a\u00020\fH\u0014J\b\u0010\u0012\u001a\u00020\fH\u0014J\b\u0010\u0013\u001a\u00020\fH\u0016J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004J\u0014\u0010\u0016\u001a\u00020\u00042\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\u0014\u0010\u0018\u001a\u00020\u00042\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "()V", "<set-?>", "", "disallowInterruption", "getDisallowInterruption", "()Z", "hook", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$NativeViewGestureHandlerHook;", "shouldActivateOnStart", "onCancel", "", "onHandle", "event", "Landroid/view/MotionEvent;", "sourceEvent", "onPrepare", "onReset", "resetConfig", "setDisallowInterruption", "setShouldActivateOnStart", "shouldBeCancelledBy", "handler", "shouldRecognizeSimultaneously", "Companion", "EditTextHook", "NativeViewGestureHandlerHook", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NativeViewGestureHandler.kt */
public final class NativeViewGestureHandler extends GestureHandler<NativeViewGestureHandler> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final NativeViewGestureHandler$Companion$defaultHook$1 defaultHook = new NativeViewGestureHandler$Companion$defaultHook$1();
    private boolean disallowInterruption;
    private NativeViewGestureHandlerHook hook = defaultHook;
    private boolean shouldActivateOnStart;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0014\u0010\n\u001a\u00020\u00072\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016¨\u0006\u000e"}, d2 = {"Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$NativeViewGestureHandlerHook;", "", "afterGestureEnd", "", "event", "Landroid/view/MotionEvent;", "canBegin", "", "handleEventBeforeActivation", "shouldCancelRootViewGestureHandlerIfNecessary", "shouldRecognizeSimultaneously", "handler", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "wantsToHandleEventBeforeActivation", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NativeViewGestureHandler.kt */
    public interface NativeViewGestureHandlerHook {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: NativeViewGestureHandler.kt */
        public static final class DefaultImpls {
            public static void afterGestureEnd(NativeViewGestureHandlerHook nativeViewGestureHandlerHook, MotionEvent motionEvent) {
                Intrinsics.checkNotNullParameter(motionEvent, NotificationCompat.CATEGORY_EVENT);
            }

            public static boolean canBegin(NativeViewGestureHandlerHook nativeViewGestureHandlerHook) {
                return true;
            }

            public static void handleEventBeforeActivation(NativeViewGestureHandlerHook nativeViewGestureHandlerHook, MotionEvent motionEvent) {
                Intrinsics.checkNotNullParameter(motionEvent, NotificationCompat.CATEGORY_EVENT);
            }

            public static boolean shouldCancelRootViewGestureHandlerIfNecessary(NativeViewGestureHandlerHook nativeViewGestureHandlerHook) {
                return false;
            }

            public static boolean shouldRecognizeSimultaneously(NativeViewGestureHandlerHook nativeViewGestureHandlerHook, GestureHandler<?> gestureHandler) {
                Intrinsics.checkNotNullParameter(gestureHandler, "handler");
                return false;
            }

            public static boolean wantsToHandleEventBeforeActivation(NativeViewGestureHandlerHook nativeViewGestureHandlerHook) {
                return false;
            }
        }

        void afterGestureEnd(MotionEvent motionEvent);

        boolean canBegin();

        void handleEventBeforeActivation(MotionEvent motionEvent);

        boolean shouldCancelRootViewGestureHandlerIfNecessary();

        boolean shouldRecognizeSimultaneously(GestureHandler<?> gestureHandler);

        boolean wantsToHandleEventBeforeActivation();
    }

    public NativeViewGestureHandler() {
        setShouldCancelWhenOutside(true);
    }

    public final boolean getDisallowInterruption() {
        return this.disallowInterruption;
    }

    public void resetConfig() {
        super.resetConfig();
        this.shouldActivateOnStart = false;
        this.disallowInterruption = false;
    }

    public final NativeViewGestureHandler setShouldActivateOnStart(boolean z) {
        NativeViewGestureHandler nativeViewGestureHandler = this;
        nativeViewGestureHandler.shouldActivateOnStart = z;
        return nativeViewGestureHandler;
    }

    public final NativeViewGestureHandler setDisallowInterruption(boolean z) {
        NativeViewGestureHandler nativeViewGestureHandler = this;
        nativeViewGestureHandler.disallowInterruption = z;
        return nativeViewGestureHandler;
    }

    public boolean shouldRecognizeSimultaneously(GestureHandler<?> gestureHandler) {
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        if (super.shouldRecognizeSimultaneously(gestureHandler) || this.hook.shouldRecognizeSimultaneously(gestureHandler)) {
            return true;
        }
        if ((gestureHandler instanceof NativeViewGestureHandler) && gestureHandler.getState() == 4 && ((NativeViewGestureHandler) gestureHandler).disallowInterruption) {
            return false;
        }
        boolean z = !this.disallowInterruption;
        int state = gestureHandler.getState();
        if ((getState() != 4 || state != 4 || !z) && getState() == 4 && z && (!this.hook.shouldCancelRootViewGestureHandlerIfNecessary() || gestureHandler.getTag() > 0)) {
            return true;
        }
        return false;
    }

    public boolean shouldBeCancelledBy(GestureHandler<?> gestureHandler) {
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        return !this.disallowInterruption;
    }

    /* access modifiers changed from: protected */
    public void onPrepare() {
        View view = getView();
        if (view instanceof NativeViewGestureHandlerHook) {
            this.hook = (NativeViewGestureHandlerHook) view;
        } else if (view instanceof ReactEditText) {
            this.hook = new EditTextHook(this, (ReactEditText) view);
        }
    }

    /* access modifiers changed from: protected */
    public void onHandle(MotionEvent motionEvent, MotionEvent motionEvent2) {
        Intrinsics.checkNotNullParameter(motionEvent, NotificationCompat.CATEGORY_EVENT);
        Intrinsics.checkNotNullParameter(motionEvent2, "sourceEvent");
        View view = getView();
        Intrinsics.checkNotNull(view);
        if (motionEvent.getActionMasked() == 1) {
            view.onTouchEvent(motionEvent);
            if ((getState() == 0 || getState() == 2) && view.isPressed()) {
                activate();
            }
            end();
            this.hook.afterGestureEnd(motionEvent);
        } else if (getState() == 0 || getState() == 2) {
            if (this.shouldActivateOnStart) {
                boolean unused = Companion.tryIntercept(view, motionEvent);
                view.onTouchEvent(motionEvent);
                activate();
            } else if (Companion.tryIntercept(view, motionEvent)) {
                view.onTouchEvent(motionEvent);
                activate();
            } else if (this.hook.wantsToHandleEventBeforeActivation()) {
                this.hook.handleEventBeforeActivation(motionEvent);
            } else if (getState() == 2) {
            } else {
                if (this.hook.canBegin()) {
                    begin();
                } else {
                    cancel();
                }
            }
        } else if (getState() == 4) {
            view.onTouchEvent(motionEvent);
        }
    }

    /* access modifiers changed from: protected */
    public void onCancel() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        obtain.setAction(3);
        View view = getView();
        Intrinsics.checkNotNull(view);
        view.onTouchEvent(obtain);
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        this.hook = defaultHook;
    }

    @Metadata(d1 = {"\u0000%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$Companion;", "", "()V", "defaultHook", "com/swmansion/gesturehandler/core/NativeViewGestureHandler$Companion$defaultHook$1", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$Companion$defaultHook$1;", "tryIntercept", "", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NativeViewGestureHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final boolean tryIntercept(View view, MotionEvent motionEvent) {
            return (view instanceof ViewGroup) && ((ViewGroup) view).onInterceptTouchEvent(motionEvent);
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0014\u0010\u0013\u001a\u00020\u00122\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$EditTextHook;", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$NativeViewGestureHandlerHook;", "handler", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler;", "editText", "Lcom/facebook/react/views/textinput/ReactEditText;", "(Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler;Lcom/facebook/react/views/textinput/ReactEditText;)V", "startX", "", "startY", "touchSlopSquared", "", "afterGestureEnd", "", "event", "Landroid/view/MotionEvent;", "handleEventBeforeActivation", "shouldCancelRootViewGestureHandlerIfNecessary", "", "shouldRecognizeSimultaneously", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "wantsToHandleEventBeforeActivation", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NativeViewGestureHandler.kt */
    private static final class EditTextHook implements NativeViewGestureHandlerHook {
        private final ReactEditText editText;
        private final NativeViewGestureHandler handler;
        private float startX;
        private float startY;
        private int touchSlopSquared;

        public boolean shouldCancelRootViewGestureHandlerIfNecessary() {
            return true;
        }

        public boolean wantsToHandleEventBeforeActivation() {
            return true;
        }

        public EditTextHook(NativeViewGestureHandler nativeViewGestureHandler, ReactEditText reactEditText) {
            Intrinsics.checkNotNullParameter(nativeViewGestureHandler, "handler");
            Intrinsics.checkNotNullParameter(reactEditText, "editText");
            this.handler = nativeViewGestureHandler;
            this.editText = reactEditText;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(reactEditText.getContext());
            this.touchSlopSquared = viewConfiguration.getScaledTouchSlop() * viewConfiguration.getScaledTouchSlop();
        }

        public boolean canBegin() {
            return NativeViewGestureHandlerHook.DefaultImpls.canBegin(this);
        }

        public void afterGestureEnd(MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(motionEvent, NotificationCompat.CATEGORY_EVENT);
            if (((motionEvent.getX() - this.startX) * (motionEvent.getX() - this.startX)) + ((motionEvent.getY() - this.startY) * (motionEvent.getY() - this.startY)) < ((float) this.touchSlopSquared)) {
                this.editText.requestFocusFromJS();
            }
        }

        public boolean shouldRecognizeSimultaneously(GestureHandler<?> gestureHandler) {
            Intrinsics.checkNotNullParameter(gestureHandler, "handler");
            return gestureHandler.getTag() > 0 && !(gestureHandler instanceof NativeViewGestureHandler);
        }

        public void handleEventBeforeActivation(MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(motionEvent, NotificationCompat.CATEGORY_EVENT);
            this.handler.activate();
            this.editText.onTouchEvent(motionEvent);
            this.startX = motionEvent.getX();
            this.startY = motionEvent.getY();
        }
    }
}
