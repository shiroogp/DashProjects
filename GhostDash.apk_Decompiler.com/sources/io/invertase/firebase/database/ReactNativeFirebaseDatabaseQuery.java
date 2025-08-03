package io.invertase.firebase.database;

import com.facebook.react.bridge.ReadableArray;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import io.invertase.firebase.common.RCTConvertFirebase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ReactNativeFirebaseDatabaseQuery {
    private HashMap<String, ChildEventListener> childEventListeners = new HashMap<>();
    public Query query;
    private HashMap<String, ValueEventListener> valueEventListeners = new HashMap<>();

    ReactNativeFirebaseDatabaseQuery(DatabaseReference databaseReference, ReadableArray readableArray) {
        this.query = databaseReference;
        Iterator<Object> it2 = RCTConvertFirebase.toArrayList(readableArray).iterator();
        while (it2.hasNext()) {
            Map map = (Map) it2.next();
            String str = (String) map.get("type");
            String str2 = (String) map.get(AppMeasurementSdk.ConditionalUserProperty.NAME);
            if ("orderBy".equals(str)) {
                applyOrderByModifier(str2, map);
            } else if ("limit".equals(str)) {
                applyLimitModifier(str2, map);
            } else if ("filter".equals(str)) {
                applyFilterModifier(str2, map);
            }
        }
    }

    public void addSingleValueEventListener(ValueEventListener valueEventListener) {
        this.query.addListenerForSingleValueEvent(valueEventListener);
    }

    public void addSingleChildEventListener(ChildEventListener childEventListener) {
        this.query.addChildEventListener(childEventListener);
    }

    public void addEventListener(String str, ValueEventListener valueEventListener) {
        this.valueEventListeners.put(str, valueEventListener);
        this.query.addValueEventListener(valueEventListener);
    }

    public void addEventListener(String str, ChildEventListener childEventListener) {
        this.childEventListeners.put(str, childEventListener);
        this.query.addChildEventListener(childEventListener);
    }

    public void removeEventListener(ValueEventListener valueEventListener) {
        this.query.removeEventListener(valueEventListener);
    }

    public void removeEventListener(ChildEventListener childEventListener) {
        this.query.removeEventListener(childEventListener);
    }

    public void removeEventListener(String str) {
        if (this.valueEventListeners.containsKey(str)) {
            this.query.removeEventListener(this.valueEventListeners.get(str));
            this.valueEventListeners.remove(str);
        }
        if (this.childEventListeners.containsKey(str)) {
            this.query.removeEventListener(this.childEventListeners.get(str));
            this.childEventListeners.remove(str);
        }
    }

    public void removeAllEventListeners() {
        if (hasListeners().booleanValue()) {
            Iterator<Map.Entry<String, ValueEventListener>> it2 = this.valueEventListeners.entrySet().iterator();
            while (it2.hasNext()) {
                this.query.removeEventListener((ValueEventListener) it2.next().getValue());
                it2.remove();
            }
            Iterator<Map.Entry<String, ChildEventListener>> it3 = this.childEventListeners.entrySet().iterator();
            while (it3.hasNext()) {
                this.query.removeEventListener((ChildEventListener) it3.next().getValue());
                it3.remove();
            }
        }
    }

    public Boolean hasEventListener(String str) {
        return Boolean.valueOf(this.valueEventListeners.containsKey(str) || this.childEventListeners.containsKey(str));
    }

    public Boolean hasListeners() {
        return Boolean.valueOf(this.valueEventListeners.size() > 0 || this.childEventListeners.size() > 0);
    }

    private void applyOrderByModifier(String str, Map map) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -626148087:
                if (str.equals("orderByPriority")) {
                    c = 0;
                    break;
                }
                break;
            case 729747418:
                if (str.equals("orderByKey")) {
                    c = 1;
                    break;
                }
                break;
            case 1200288727:
                if (str.equals("orderByChild")) {
                    c = 2;
                    break;
                }
                break;
            case 1217630252:
                if (str.equals("orderByValue")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.query = this.query.orderByPriority();
                return;
            case 1:
                this.query = this.query.orderByKey();
                return;
            case 2:
                this.query = this.query.orderByChild((String) map.get("key"));
                return;
            case 3:
                this.query = this.query.orderByValue();
                return;
            default:
                return;
        }
    }

    private Query applyLimitModifier(String str, Map map) {
        int intValue = ((Double) map.get("value")).intValue();
        if ("limitToLast".equals(str)) {
            this.query = this.query.limitToLast(intValue);
        } else if ("limitToFirst".equals(str)) {
            this.query = this.query.limitToFirst(intValue);
        }
        return this.query;
    }

    private void applyFilterModifier(String str, Map map) {
        String str2 = (String) map.get("valueType");
        String str3 = (String) map.get("key");
        if ("endAt".equals(str)) {
            applyEndAtFilter(str3, str2, map);
        } else if ("startAt".equals(str)) {
            applyStartAtFilter(str3, str2, map);
        }
    }

    private void applyEndAtFilter(String str, String str2, Map map) {
        if ("number".equals(str2)) {
            double doubleValue = ((Double) map.get("value")).doubleValue();
            if (str == null) {
                this.query = this.query.endAt(doubleValue);
            } else {
                this.query = this.query.endAt(doubleValue, str);
            }
        } else if ("boolean".equals(str2)) {
            boolean booleanValue = ((Boolean) map.get("value")).booleanValue();
            if (str == null) {
                this.query = this.query.endAt(booleanValue);
            } else {
                this.query = this.query.endAt(booleanValue, str);
            }
        } else if ("string".equals(str2)) {
            String str3 = (String) map.get("value");
            if (str == null) {
                this.query = this.query.endAt(str3);
            } else {
                this.query = this.query.endAt(str3, str);
            }
        } else if (!"null".equals(str2)) {
        } else {
            if (str == null) {
                this.query = this.query.endAt((String) null);
            } else {
                this.query = this.query.endAt((String) null, str);
            }
        }
    }

    private void applyStartAtFilter(String str, String str2, Map map) {
        if ("number".equals(str2)) {
            double doubleValue = ((Double) map.get("value")).doubleValue();
            if (str == null) {
                this.query = this.query.startAt(doubleValue);
            } else {
                this.query = this.query.startAt(doubleValue, str);
            }
        } else if ("boolean".equals(str2)) {
            boolean booleanValue = ((Boolean) map.get("value")).booleanValue();
            if (str == null) {
                this.query = this.query.startAt(booleanValue);
            } else {
                this.query = this.query.startAt(booleanValue, str);
            }
        } else if ("string".equals(str2)) {
            String str3 = (String) map.get("value");
            if (str == null) {
                this.query = this.query.startAt(str3);
            } else {
                this.query = this.query.startAt(str3, str);
            }
        } else if (!"null".equals(str2)) {
        } else {
            if (str == null) {
                this.query = this.query.startAt((String) null);
            } else {
                this.query = this.query.startAt((String) null, str);
            }
        }
    }
}
