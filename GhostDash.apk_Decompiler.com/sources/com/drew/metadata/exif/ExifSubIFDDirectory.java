package com.drew.metadata.exif;

import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

public class ExifSubIFDDirectory extends ExifDirectoryBase {
    public static final int TAG_INTEROP_OFFSET = 40965;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "Exif SubIFD";
    }

    public ExifSubIFDDirectory() {
        setDescriptor(new ExifSubIFDDescriptor(this));
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        addExifTagNames(hashMap);
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }

    public Date getDateOriginal() {
        return getDateOriginal((TimeZone) null);
    }

    public Date getDateOriginal(TimeZone timeZone) {
        return getDate(ExifDirectoryBase.TAG_DATETIME_ORIGINAL, getString(ExifDirectoryBase.TAG_SUBSECOND_TIME_ORIGINAL), timeZone);
    }

    public Date getDateDigitized() {
        return getDateDigitized((TimeZone) null);
    }

    public Date getDateDigitized(TimeZone timeZone) {
        return getDate(ExifDirectoryBase.TAG_DATETIME_DIGITIZED, getString(ExifDirectoryBase.TAG_SUBSECOND_TIME_DIGITIZED), timeZone);
    }
}
