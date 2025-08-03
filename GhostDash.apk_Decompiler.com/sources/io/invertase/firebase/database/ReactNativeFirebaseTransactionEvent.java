package io.invertase.firebase.database;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import io.invertase.firebase.interfaces.NativeEvent;

public class ReactNativeFirebaseTransactionEvent implements NativeEvent {
    static final String EVENT_TRANSACTION = "database_transaction_event";
    private static final String KEY_APP_NAME = "appName";
    private static final String KEY_BODY = "body";
    private static final String KEY_EVENT_NAME = "eventName";
    private static final String KEY_ID = "id";
    private String appName;
    private WritableMap eventBody;
    private String eventName;
    private int id;

    ReactNativeFirebaseTransactionEvent(String str, WritableMap writableMap, String str2, int i) {
        this.eventName = str;
        this.eventBody = writableMap;
        this.appName = str2;
        this.id = i;
    }

    public String getEventName() {
        return this.eventName;
    }

    public WritableMap getEventBody() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("id", this.id);
        createMap.putMap(KEY_BODY, this.eventBody);
        createMap.putString(KEY_APP_NAME, this.appName);
        createMap.putString(KEY_EVENT_NAME, this.eventName);
        return createMap;
    }

    public String getFirebaseAppName() {
        return this.appName;
    }
}
