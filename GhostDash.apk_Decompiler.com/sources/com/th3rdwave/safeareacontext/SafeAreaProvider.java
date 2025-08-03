package com.th3rdwave.safeareacontext;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.views.view.ReactViewGroup;

public class SafeAreaProvider extends ReactViewGroup implements ViewTreeObserver.OnPreDrawListener {
    private OnInsetsChangeListener mInsetsChangeListener;
    private Rect mLastFrame;
    private EdgeInsets mLastInsets;

    public interface OnInsetsChangeListener {
        void onInsetsChange(SafeAreaProvider safeAreaProvider, EdgeInsets edgeInsets, Rect rect);
    }

    public SafeAreaProvider(Context context) {
        super(context);
    }

    private void maybeUpdateInsets() {
        EdgeInsets safeAreaInsets = SafeAreaUtils.getSafeAreaInsets(this);
        Rect frame = SafeAreaUtils.getFrame((ViewGroup) getRootView(), this);
        if (safeAreaInsets != null && frame != null) {
            EdgeInsets edgeInsets = this.mLastInsets;
            if (edgeInsets == null || this.mLastFrame == null || !edgeInsets.equalsToEdgeInsets(safeAreaInsets) || !this.mLastFrame.equalsToRect(frame)) {
                ((OnInsetsChangeListener) Assertions.assertNotNull(this.mInsetsChangeListener)).onInsetsChange(this, safeAreaInsets, frame);
                this.mLastInsets = safeAreaInsets;
                this.mLastFrame = frame;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this);
        maybeUpdateInsets();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this);
    }

    public boolean onPreDraw() {
        maybeUpdateInsets();
        return true;
    }

    public void setOnInsetsChangeListener(OnInsetsChangeListener onInsetsChangeListener) {
        this.mInsetsChangeListener = onInsetsChangeListener;
    }
}
