package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.events.EventDispatcher;

/* compiled from: ReanimatedUIManager */
class ReaUiImplementationProvider extends UIImplementationProvider {
    ReaUiImplementationProvider() {
    }

    /* access modifiers changed from: package-private */
    public UIImplementation createUIImplementation(ReactApplicationContext reactApplicationContext, ViewManagerRegistry viewManagerRegistry, EventDispatcher eventDispatcher, int i) {
        return new ReanimatedUIImplementation(reactApplicationContext, viewManagerRegistry, eventDispatcher, i);
    }
}
