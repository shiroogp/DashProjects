package com.drew.metadata.eps;

import androidx.exifinterface.media.ExifInterface;
import com.drew.metadata.Directory;
import java.util.HashMap;

public class EpsDirectory extends Directory {
    public static final int TAG_AUTHOR = 2;
    public static final int TAG_BOUNDING_BOX = 3;
    public static final int TAG_COLOR_TYPE = 30;
    public static final int TAG_CONTINUE_LINE = 36;
    public static final int TAG_COPYRIGHT = 4;
    public static final int TAG_CREATION_DATE = 5;
    public static final int TAG_CREATOR = 6;
    public static final int TAG_DOCUMENT_DATA = 16;
    public static final int TAG_DSC_VERSION = 1;
    public static final int TAG_EMULATION = 17;
    public static final int TAG_EXTENSIONS = 18;
    public static final int TAG_FOR = 7;
    public static final int TAG_IMAGE_DATA = 8;
    public static final int TAG_IMAGE_HEIGHT = 29;
    public static final int TAG_IMAGE_WIDTH = 28;
    public static final int TAG_KEYWORDS = 9;
    public static final int TAG_LANGUAGE_LEVEL = 19;
    public static final int TAG_MODIFY_DATE = 10;
    public static final int TAG_OPERATOR_INTERNVENTION = 22;
    public static final int TAG_OPERATOR_MESSAGE = 23;
    public static final int TAG_ORIENTATION = 20;
    public static final int TAG_PAGES = 11;
    public static final int TAG_PAGE_ORDER = 21;
    public static final int TAG_PROOF_MODE = 24;
    public static final int TAG_RAM_SIZE = 31;
    public static final int TAG_REQUIREMENTS = 25;
    public static final int TAG_ROUTING = 12;
    public static final int TAG_SUBJECT = 13;
    public static final int TAG_TIFF_PREVIEW_OFFSET = 33;
    public static final int TAG_TIFF_PREVIEW_SIZE = 32;
    public static final int TAG_TITLE = 14;
    public static final int TAG_VERSION = 15;
    public static final int TAG_VM_LOCATION = 26;
    public static final int TAG_VM_USAGE = 27;
    public static final int TAG_WMF_PREVIEW_OFFSET = 35;
    public static final int TAG_WMF_PREVIEW_SIZE = 34;
    protected static final HashMap<String, Integer> _tagIntegerMap;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "EPS";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        HashMap<String, Integer> hashMap2 = new HashMap<>();
        _tagIntegerMap = hashMap2;
        hashMap2.put("%!PS-Adobe-", 1);
        hashMap2.put("%%Author", 2);
        hashMap2.put("%%BoundingBox", 3);
        hashMap2.put("%%Copyright", 4);
        hashMap2.put("%%CreationDate", 5);
        hashMap2.put("%%Creator", 6);
        hashMap2.put("%%For", 7);
        hashMap2.put("%ImageData", 8);
        hashMap2.put("%%Keywords", 9);
        hashMap2.put("%%ModDate", 10);
        hashMap2.put("%%Pages", 11);
        hashMap2.put("%%Routing", 12);
        hashMap2.put("%%Subject", 13);
        hashMap2.put("%%Title", 14);
        hashMap2.put("%%Version", 15);
        hashMap2.put("%%DocumentData", 16);
        hashMap2.put("%%Emulation", 17);
        hashMap2.put("%%Extensions", 18);
        hashMap2.put("%%LanguageLevel", 19);
        hashMap2.put("%%Orientation", 20);
        hashMap2.put("%%PageOrder", 21);
        hashMap2.put("%%OperatorIntervention", 22);
        hashMap2.put("%%OperatorMessage", 23);
        hashMap2.put("%%ProofMode", 24);
        hashMap2.put("%%Requirements", 25);
        hashMap2.put("%%VMlocation", 26);
        hashMap2.put("%%VMusage", 27);
        hashMap2.put("Image Width", 28);
        hashMap2.put("Image Height", 29);
        hashMap2.put("Color Type", 30);
        hashMap2.put("Ram Size", 31);
        hashMap2.put("TIFFPreview", 32);
        hashMap2.put("TIFFPreviewOffset", 33);
        hashMap2.put("WMFPreview", 34);
        hashMap2.put("WMFPreviewOffset", 35);
        hashMap2.put("%%+", 36);
        hashMap.put(36, "Line Continuation");
        hashMap.put(3, "Bounding Box");
        hashMap.put(4, ExifInterface.TAG_COPYRIGHT);
        hashMap.put(16, "Document Data");
        hashMap.put(17, "Emulation");
        hashMap.put(18, "Extensions");
        hashMap.put(19, "Language Level");
        hashMap.put(20, ExifInterface.TAG_ORIENTATION);
        hashMap.put(21, "Page Order");
        hashMap.put(15, "Version");
        hashMap.put(8, "Image Data");
        hashMap.put(28, "Image Width");
        hashMap.put(29, "Image Height");
        hashMap.put(30, "Color Type");
        hashMap.put(31, "Ram Size");
        hashMap.put(6, "Creator");
        hashMap.put(5, "Creation Date");
        hashMap.put(7, "For");
        hashMap.put(25, "Requirements");
        hashMap.put(12, "Routing");
        hashMap.put(14, "Title");
        hashMap.put(1, "DSC Version");
        hashMap.put(11, "Pages");
        hashMap.put(22, "Operator Intervention");
        hashMap.put(23, "Operator Message");
        hashMap.put(24, "Proof Mode");
        hashMap.put(26, "VM Location");
        hashMap.put(27, "VM Usage");
        hashMap.put(2, "Author");
        hashMap.put(9, "Keywords");
        hashMap.put(10, "Modify Date");
        hashMap.put(13, "Subject");
        hashMap.put(32, "TIFF Preview Size");
        hashMap.put(33, "TIFF Preview Offset");
        hashMap.put(34, "WMF Preview Size");
        hashMap.put(35, "WMF Preview Offset");
    }

    public EpsDirectory() {
        setDescriptor(new EpsDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
