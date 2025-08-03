package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class OlympusFocusInfoMakernoteDirectory extends Directory {
    public static final int TagAfInfo = 808;
    public static final int TagAfPoint = 776;
    public static final int TagAutoFocus = 521;
    public static final int TagExternalFlash = 4609;
    public static final int TagExternalFlashBounce = 4612;
    public static final int TagExternalFlashGuideNumber = 4611;
    public static final int TagExternalFlashZoom = 4613;
    public static final int TagFocusDistance = 773;
    public static final int TagFocusInfoVersion = 0;
    public static final int TagFocusStepCount = 769;
    public static final int TagFocusStepInfinity = 771;
    public static final int TagFocusStepNear = 772;
    public static final int TagImageStabilization = 5632;
    public static final int TagInternalFlash = 4616;
    public static final int TagMacroLed = 4618;
    public static final int TagManualFlash = 4617;
    public static final int TagSceneArea = 529;
    public static final int TagSceneDetect = 528;
    public static final int TagSceneDetectData = 530;
    public static final int TagSensorTemperature = 5376;
    public static final int TagZoomStepCount = 768;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "Olympus Focus Info";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(0, "Focus Info Version");
        hashMap.put(521, "Auto Focus");
        hashMap.put(528, "Scene Detect");
        hashMap.put(529, "Scene Area");
        hashMap.put(530, "Scene Detect Data");
        hashMap.put(768, "Zoom Step Count");
        hashMap.put(769, "Focus Step Count");
        hashMap.put(771, "Focus Step Infinity");
        hashMap.put(772, "Focus Step Near");
        hashMap.put(773, "Focus Distance");
        hashMap.put(Integer.valueOf(TagAfPoint), "AF Point");
        hashMap.put(Integer.valueOf(TagAfInfo), "AF Info");
        hashMap.put(4609, "External Flash");
        hashMap.put(4611, "External Flash Guide Number");
        hashMap.put(Integer.valueOf(TagExternalFlashBounce), "External Flash Bounce");
        hashMap.put(Integer.valueOf(TagExternalFlashZoom), "External Flash Zoom");
        hashMap.put(Integer.valueOf(TagInternalFlash), "Internal Flash");
        hashMap.put(Integer.valueOf(TagManualFlash), "Manual Flash");
        hashMap.put(Integer.valueOf(TagMacroLed), "Macro LED");
        hashMap.put(Integer.valueOf(TagSensorTemperature), "Sensor Temperature");
        hashMap.put(Integer.valueOf(TagImageStabilization), "Image Stabilization");
    }

    public OlympusFocusInfoMakernoteDirectory() {
        setDescriptor(new OlympusFocusInfoMakernoteDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
