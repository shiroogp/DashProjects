package com.drew.metadata.pcx;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class PcxDirectory extends Directory {
    public static final int TAG_BITS_PER_PIXEL = 2;
    public static final int TAG_BYTES_PER_LINE = 11;
    public static final int TAG_COLOR_PLANES = 10;
    public static final int TAG_HORIZONTAL_DPI = 7;
    public static final int TAG_HSCR_SIZE = 13;
    public static final int TAG_PALETTE = 9;
    public static final int TAG_PALETTE_TYPE = 12;
    public static final int TAG_VERSION = 1;
    public static final int TAG_VERTICAL_DPI = 8;
    public static final int TAG_VSCR_SIZE = 14;
    public static final int TAG_XMAX = 5;
    public static final int TAG_XMIN = 3;
    public static final int TAG_YMAX = 6;
    public static final int TAG_YMIN = 4;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "PCX";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(1, "Version");
        hashMap.put(2, "Bits Per Pixel");
        hashMap.put(3, "X Min");
        hashMap.put(4, "Y Min");
        hashMap.put(5, "X Max");
        hashMap.put(6, "Y Max");
        hashMap.put(7, "Horizontal DPI");
        hashMap.put(8, "Vertical DPI");
        hashMap.put(9, "Palette");
        hashMap.put(10, "Color Planes");
        hashMap.put(11, "Bytes Per Line");
        hashMap.put(12, "Palette Type");
        hashMap.put(13, "H Scr Size");
        hashMap.put(14, "V Scr Size");
    }

    public PcxDirectory() {
        setDescriptor(new PcxDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
