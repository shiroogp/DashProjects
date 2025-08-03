package com.th3rdwave.safeareacontext;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

class InsetsChangeEvent extends Event<InsetsChangeEvent> {
    static final String EVENT_NAME = "topInsetsChange";
    private Rect mFrame;
    private EdgeInsets mInsets;

    public String getEventName() {
        return EVENT_NAME;
    }

    InsetsChangeEvent(int i, EdgeInsets edgeInsets, Rect rect) {
        super(i);
        this.mInsets = edgeInsets;
        this.mFrame = rect;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        WritableMap createMap = Arguments.createMap();
        createMap.putMap("insets", SerializationUtils.edgeInsetsToJsMap(this.mInsets));
        createMap.putMap("frame", SerializationUtils.rectToJsMap(this.mFrame));
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), createMap);
    }
}
