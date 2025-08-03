package com.th3rdwave.safeareacontext;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ViewProps;
import java.util.Map;

class SerializationUtils {
    SerializationUtils() {
    }

    static WritableMap edgeInsetsToJsMap(EdgeInsets edgeInsets) {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble(ViewProps.TOP, (double) PixelUtil.toDIPFromPixel(edgeInsets.top));
        createMap.putDouble(ViewProps.RIGHT, (double) PixelUtil.toDIPFromPixel(edgeInsets.right));
        createMap.putDouble(ViewProps.BOTTOM, (double) PixelUtil.toDIPFromPixel(edgeInsets.bottom));
        createMap.putDouble(ViewProps.LEFT, (double) PixelUtil.toDIPFromPixel(edgeInsets.left));
        return createMap;
    }

    static Map<String, Float> edgeInsetsToJavaMap(EdgeInsets edgeInsets) {
        return MapBuilder.of(ViewProps.TOP, Float.valueOf(PixelUtil.toDIPFromPixel(edgeInsets.top)), ViewProps.RIGHT, Float.valueOf(PixelUtil.toDIPFromPixel(edgeInsets.right)), ViewProps.BOTTOM, Float.valueOf(PixelUtil.toDIPFromPixel(edgeInsets.bottom)), ViewProps.LEFT, Float.valueOf(PixelUtil.toDIPFromPixel(edgeInsets.left)));
    }

    static WritableMap rectToJsMap(Rect rect) {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("x", (double) PixelUtil.toDIPFromPixel(rect.x));
        createMap.putDouble("y", (double) PixelUtil.toDIPFromPixel(rect.y));
        createMap.putDouble("width", (double) PixelUtil.toDIPFromPixel(rect.width));
        createMap.putDouble("height", (double) PixelUtil.toDIPFromPixel(rect.height));
        return createMap;
    }

    static Map<String, Float> rectToJavaMap(Rect rect) {
        return MapBuilder.of("x", Float.valueOf(PixelUtil.toDIPFromPixel(rect.x)), "y", Float.valueOf(PixelUtil.toDIPFromPixel(rect.y)), "width", Float.valueOf(PixelUtil.toDIPFromPixel(rect.width)), "height", Float.valueOf(PixelUtil.toDIPFromPixel(rect.height)));
    }
}
