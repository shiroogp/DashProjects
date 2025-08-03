package org.reactnative.camera.events;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.camera.CameraViewManager;

public class RecordingEndEvent extends Event<RecordingEndEvent> {
    private static final Pools.SynchronizedPool<RecordingEndEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(3);

    public short getCoalescingKey() {
        return 0;
    }

    private RecordingEndEvent() {
    }

    public static RecordingEndEvent obtain(int i) {
        RecordingEndEvent acquire = EVENTS_POOL.acquire();
        if (acquire == null) {
            acquire = new RecordingEndEvent();
        }
        acquire.init(i);
        return acquire;
    }

    public String getEventName() {
        return CameraViewManager.Events.EVENT_ON_RECORDING_END.toString();
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        return Arguments.createMap();
    }
}
