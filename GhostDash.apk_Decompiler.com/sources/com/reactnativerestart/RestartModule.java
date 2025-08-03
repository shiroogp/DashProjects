package com.reactnativerestart;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RestartModule extends ReactContextBaseJavaModule {
    private static final String REACT_APPLICATION_CLASS_NAME = "com.facebook.react.ReactApplication";
    private static final String REACT_NATIVE_HOST_CLASS_NAME = "com.facebook.react.ReactNativeHost";
    private static ReactInstanceHolder mReactInstanceHolder;
    private LifecycleEventListener mLifecycleEventListener = null;

    public String getName() {
        return "RNRestart";
    }

    public RestartModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* access modifiers changed from: private */
    public void loadBundleLegacy() {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.runOnUiThread(new Runnable() {
                public void run() {
                    currentActivity.recreate();
                }
            });
        }
    }

    private void loadBundle() {
        clearLifecycleEventListener();
        try {
            final ReactInstanceManager resolveInstanceManager = resolveInstanceManager();
            if (resolveInstanceManager != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        try {
                            resolveInstanceManager.recreateReactContextInBackground();
                        } catch (Throwable unused) {
                            RestartModule.this.loadBundleLegacy();
                        }
                    }
                });
            }
        } catch (Throwable unused) {
            loadBundleLegacy();
        }
    }

    static ReactInstanceManager getReactInstanceManager() {
        ReactInstanceHolder reactInstanceHolder = mReactInstanceHolder;
        if (reactInstanceHolder == null) {
            return null;
        }
        return reactInstanceHolder.getReactInstanceManager();
    }

    private ReactInstanceManager resolveInstanceManager() throws NoSuchFieldException, IllegalAccessException {
        ReactInstanceManager reactInstanceManager = getReactInstanceManager();
        if (reactInstanceManager != null) {
            return reactInstanceManager;
        }
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return null;
        }
        return ((ReactApplication) currentActivity.getApplication()).getReactNativeHost().getReactInstanceManager();
    }

    private void clearLifecycleEventListener() {
        if (this.mLifecycleEventListener != null) {
            getReactApplicationContext().removeLifecycleEventListener(this.mLifecycleEventListener);
            this.mLifecycleEventListener = null;
        }
    }

    @ReactMethod
    public void Restart() {
        loadBundle();
    }
}
