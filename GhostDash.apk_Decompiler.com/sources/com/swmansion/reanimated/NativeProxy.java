package com.swmansion.reanimated;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.swmansion.reanimated.layoutReanimation.LayoutAnimations;
import com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder;
import com.swmansion.reanimated.nativeProxy.NativeProxyCommon;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class NativeProxy extends NativeProxyCommon {
    private final HybridData mHybridData;

    private native HybridData initHybrid(long j, CallInvokerHolderImpl callInvokerHolderImpl, Scheduler scheduler, LayoutAnimations layoutAnimations);

    private native void installJSIBindings(MessageQueueThread messageQueueThread);

    public native boolean isAnyHandlerWaitingForEvent(String str);

    public native void performOperations();

    public NativeProxy(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        LayoutAnimations layoutAnimations = new LayoutAnimations(reactApplicationContext);
        this.mHybridData = initHybrid(reactApplicationContext.getJavaScriptContextHolder().get(), (CallInvokerHolderImpl) reactApplicationContext.getCatalystInstance().getJSCallInvokerHolder(), this.mScheduler, layoutAnimations);
        prepareLayoutAnimations(layoutAnimations);
        installJSIBindings(new ReanimatedMessageQueueThread());
    }

    /* access modifiers changed from: protected */
    public HybridData getHybridData() {
        return this.mHybridData;
    }

    public static NativeMethodsHolder createNativeMethodsHolder(LayoutAnimations layoutAnimations) {
        final WeakReference weakReference = new WeakReference(layoutAnimations);
        return new NativeMethodsHolder() {
            public void startAnimation(int i, int i2, HashMap<String, Object> hashMap) {
                LayoutAnimations layoutAnimations = (LayoutAnimations) weakReference.get();
                if (layoutAnimations != null) {
                    HashMap hashMap2 = new HashMap();
                    for (String next : hashMap.keySet()) {
                        String obj = hashMap.get(next).toString();
                        if (next.endsWith("TransformMatrix")) {
                            hashMap2.put(next, Utils.simplifyStringNumbersList(obj));
                        } else {
                            hashMap2.put(next, obj);
                        }
                    }
                    layoutAnimations.startAnimationForTag(i, i2, hashMap2);
                }
            }

            public boolean isLayoutAnimationEnabled() {
                LayoutAnimations layoutAnimations = (LayoutAnimations) weakReference.get();
                if (layoutAnimations != null) {
                    return layoutAnimations.isLayoutAnimationEnabled();
                }
                return false;
            }

            public boolean hasAnimation(int i, int i2) {
                LayoutAnimations layoutAnimations = (LayoutAnimations) weakReference.get();
                if (layoutAnimations != null) {
                    return layoutAnimations.hasAnimationForTag(i, i2);
                }
                return false;
            }

            public void clearAnimationConfig(int i) {
                LayoutAnimations layoutAnimations = (LayoutAnimations) weakReference.get();
                if (layoutAnimations != null) {
                    layoutAnimations.clearAnimationConfigForTag(i);
                }
            }

            public void cancelAnimation(int i, int i2, boolean z, boolean z2) {
                LayoutAnimations layoutAnimations = (LayoutAnimations) weakReference.get();
                if (layoutAnimations != null) {
                    layoutAnimations.cancelAnimationForTag(i, i2, z, z2);
                }
            }

            public int findPrecedingViewTagForTransition(int i) {
                LayoutAnimations layoutAnimations = (LayoutAnimations) weakReference.get();
                if (layoutAnimations != null) {
                    return layoutAnimations.findPrecedingViewTagForTransition(i);
                }
                return -1;
            }
        };
    }
}
