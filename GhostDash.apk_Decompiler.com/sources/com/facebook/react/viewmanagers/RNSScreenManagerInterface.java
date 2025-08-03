package com.facebook.react.viewmanagers;

import android.view.View;

public interface RNSScreenManagerInterface<T extends View> {
    void setActivityState(T t, int i);

    void setGestureEnabled(T t, boolean z);

    void setNativeBackButtonDismissalEnabled(T t, boolean z);

    void setNavigationBarColor(T t, Integer num);

    void setNavigationBarHidden(T t, boolean z);

    void setReplaceAnimation(T t, String str);

    void setScreenOrientation(T t, String str);

    void setStackAnimation(T t, String str);

    void setStackPresentation(T t, String str);

    void setStatusBarAnimation(T t, String str);

    void setStatusBarColor(T t, Integer num);

    void setStatusBarHidden(T t, boolean z);

    void setStatusBarStyle(T t, String str);

    void setStatusBarTranslucent(T t, boolean z);
}
