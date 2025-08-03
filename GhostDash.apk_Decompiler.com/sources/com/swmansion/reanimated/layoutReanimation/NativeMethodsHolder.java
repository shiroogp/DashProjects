package com.swmansion.reanimated.layoutReanimation;

import java.util.HashMap;

public interface NativeMethodsHolder {
    void cancelAnimation(int i, int i2, boolean z, boolean z2);

    void clearAnimationConfig(int i);

    int findPrecedingViewTagForTransition(int i);

    boolean hasAnimation(int i, int i2);

    boolean isLayoutAnimationEnabled();

    void startAnimation(int i, int i2, HashMap<String, Object> hashMap);
}
