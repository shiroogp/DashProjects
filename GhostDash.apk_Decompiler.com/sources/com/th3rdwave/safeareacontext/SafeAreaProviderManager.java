package com.th3rdwave.safeareacontext;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.th3rdwave.safeareacontext.SafeAreaProvider;
import java.util.Map;

public class SafeAreaProviderManager extends ViewGroupManager<SafeAreaProvider> {
    private final ReactApplicationContext mContext;

    public String getName() {
        return "RNCSafeAreaProvider";
    }

    public SafeAreaProviderManager(ReactApplicationContext reactApplicationContext) {
        this.mContext = reactApplicationContext;
    }

    public SafeAreaProvider createViewInstance(ThemedReactContext themedReactContext) {
        return new SafeAreaProvider(themedReactContext);
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(ThemedReactContext themedReactContext, SafeAreaProvider safeAreaProvider) {
        final EventDispatcher eventDispatcher = ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
        safeAreaProvider.setOnInsetsChangeListener(new SafeAreaProvider.OnInsetsChangeListener() {
            public void onInsetsChange(SafeAreaProvider safeAreaProvider, EdgeInsets edgeInsets, Rect rect) {
                eventDispatcher.dispatchEvent(new InsetsChangeEvent(safeAreaProvider.getId(), edgeInsets, rect));
            }
        });
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("topInsetsChange", MapBuilder.of("registrationName", "onInsetsChange")).build();
    }

    private Map<String, Object> getInitialWindowMetrics() {
        ViewGroup viewGroup;
        View findViewById;
        Activity currentActivity = this.mContext.getCurrentActivity();
        if (currentActivity == null || (viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView()) == null || (findViewById = viewGroup.findViewById(16908290)) == null) {
            return null;
        }
        EdgeInsets safeAreaInsets = SafeAreaUtils.getSafeAreaInsets(viewGroup);
        Rect frame = SafeAreaUtils.getFrame(viewGroup, findViewById);
        if (safeAreaInsets == null || frame == null) {
            return null;
        }
        return MapBuilder.of("insets", SerializationUtils.edgeInsetsToJavaMap(safeAreaInsets), "frame", SerializationUtils.rectToJavaMap(frame));
    }

    public Map<String, Object> getExportedViewConstants() {
        return MapBuilder.of("initialWindowMetrics", getInitialWindowMetrics());
    }
}
