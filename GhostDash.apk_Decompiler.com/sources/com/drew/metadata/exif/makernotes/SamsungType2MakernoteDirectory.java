package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class SamsungType2MakernoteDirectory extends Directory {
    public static final int TagCameraTemperature = 67;
    public static final int TagDeviceType = 2;
    public static final int TagFaceDetect = 256;
    public static final int TagFaceName = 291;
    public static final int TagFaceRecognition = 288;
    public static final int TagFirmwareName = 40961;
    public static final int TagMakerNoteVersion = 1;
    public static final int TagSamsungModelId = 3;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "Samsung Makernote";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(1, "Maker Note Version");
        hashMap.put(2, "Device Type");
        hashMap.put(3, "Model Id");
        hashMap.put(67, "Camera Temperature");
        hashMap.put(256, "Face Detect");
        hashMap.put(288, "Face Recognition");
        hashMap.put(291, "Face Name");
        hashMap.put(40961, "Firmware Name");
    }

    public SamsungType2MakernoteDirectory() {
        setDescriptor(new SamsungType2MakernoteDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
