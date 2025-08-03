package org.reactnative.camera.events;

import androidx.core.util.Pools;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.camera.CameraViewManager;

public class RecordingStartEvent extends Event<RecordingStartEvent> {
    private static final Pools.SynchronizedPool<RecordingStartEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(3);
    private WritableMap mResponse;

    private RecordingStartEvent() {
    }

    public static RecordingStartEvent obtain(int i, WritableMap writableMap) {
        RecordingStartEvent acquire = EVENTS_POOL.acquire();
        if (acquire == null) {
            acquire = new RecordingStartEvent();
        }
        acquire.init(i, writableMap);
        return acquire;
    }

    private void init(int i, WritableMap writableMap) {
        super.init(i);
        this.mResponse = writableMap;
    }

    public String getEventName() {
        return CameraViewManager.Events.EVENT_ON_RECORDING_START.toString();
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), this.mResponse);
    }
}
