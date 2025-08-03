package com.tonyodev.fetch2.database;

import com.brentvatne.react.ReactVideoView;
import com.tonyodev.fetch2.EnqueueAction;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.NetworkType;
import com.tonyodev.fetch2.Priority;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2.util.FetchDefaults;
import com.tonyodev.fetch2core.Extras;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nH\u0007J\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0004H\u0007J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\bH\u0007J\u001c\u0010\u001b\u001a\u00020\f2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0010H\u0007J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0012H\u0007J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0014H\u0007J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0016H\u0007¨\u0006#"}, d2 = {"Lcom/tonyodev/fetch2/database/Converter;", "", "()V", "fromEnqueueActionValue", "Lcom/tonyodev/fetch2/EnqueueAction;", "value", "", "fromErrorValue", "Lcom/tonyodev/fetch2/Error;", "fromExtrasJsonToExtras", "Lcom/tonyodev/fetch2core/Extras;", "jsonString", "", "fromExtrasToString", "extras", "fromJsonString", "", "fromNetworkTypeValue", "Lcom/tonyodev/fetch2/NetworkType;", "fromPriorityValue", "Lcom/tonyodev/fetch2/Priority;", "fromStatusValue", "Lcom/tonyodev/fetch2/Status;", "toEnqueueActionValue", "enqueueAction", "toErrorValue", "error", "toHeaderStringsMap", "headerMap", "toNetworkTypeValue", "networkType", "toPriorityValue", "priority", "toStatusValue", "status", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Converter.kt */
public final class Converter {
    public final Status fromStatusValue(int i) {
        return Status.Companion.valueOf(i);
    }

    public final int toStatusValue(Status status) {
        Intrinsics.checkParameterIsNotNull(status, "status");
        return status.getValue();
    }

    public final Map<String, String> fromJsonString(String str) {
        Intrinsics.checkParameterIsNotNull(str, "jsonString");
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkExpressionValueIsNotNull(keys, "json.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            Intrinsics.checkExpressionValueIsNotNull(next, "it");
            String string = jSONObject.getString(next);
            Intrinsics.checkExpressionValueIsNotNull(string, "json.getString(it)");
            linkedHashMap.put(next, string);
        }
        return linkedHashMap;
    }

    public final String toHeaderStringsMap(Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(map, "headerMap");
        if (map.isEmpty()) {
            return FetchDefaults.EMPTY_JSON_OBJECT_STRING;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : map.entrySet()) {
            jSONObject.put((String) next.getKey(), next.getValue());
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "json.toString()");
        return jSONObject2;
    }

    public final Priority fromPriorityValue(int i) {
        return Priority.Companion.valueOf(i);
    }

    public final int toPriorityValue(Priority priority) {
        Intrinsics.checkParameterIsNotNull(priority, "priority");
        return priority.getValue();
    }

    public final Error fromErrorValue(int i) {
        return Error.Companion.valueOf(i);
    }

    public final int toErrorValue(Error error) {
        Intrinsics.checkParameterIsNotNull(error, ReactVideoView.EVENT_PROP_ERROR);
        return error.getValue();
    }

    public final NetworkType fromNetworkTypeValue(int i) {
        return NetworkType.Companion.valueOf(i);
    }

    public final int toNetworkTypeValue(NetworkType networkType) {
        Intrinsics.checkParameterIsNotNull(networkType, "networkType");
        return networkType.getValue();
    }

    public final int toEnqueueActionValue(EnqueueAction enqueueAction) {
        Intrinsics.checkParameterIsNotNull(enqueueAction, "enqueueAction");
        return enqueueAction.getValue();
    }

    public final EnqueueAction fromEnqueueActionValue(int i) {
        return EnqueueAction.Companion.valueOf(i);
    }

    public final String fromExtrasToString(Extras extras) {
        Intrinsics.checkParameterIsNotNull(extras, "extras");
        if (extras.isEmpty()) {
            return FetchDefaults.EMPTY_JSON_OBJECT_STRING;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : extras.getMap().entrySet()) {
            jSONObject.put((String) next.getKey(), next.getValue());
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "json.toString()");
        return jSONObject2;
    }

    public final Extras fromExtrasJsonToExtras(String str) {
        Intrinsics.checkParameterIsNotNull(str, "jsonString");
        Map linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkExpressionValueIsNotNull(keys, "json.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            Intrinsics.checkExpressionValueIsNotNull(next, "it");
            String string = jSONObject.getString(next);
            Intrinsics.checkExpressionValueIsNotNull(string, "json.getString(it)");
            linkedHashMap.put(next, string);
        }
        return new Extras(linkedHashMap);
    }
}
