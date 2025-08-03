package com.drew.metadata.xmp;

import com.adobe.xmp.XMPException;
import com.adobe.xmp.XMPIterator;
import com.adobe.xmp.XMPMeta;
import com.adobe.xmp.impl.XMPMetaImpl;
import com.adobe.xmp.properties.XMPPropertyInfo;
import com.drew.metadata.Directory;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class XmpDirectory extends Directory {
    public static final int TAG_XMP_VALUE_COUNT = 65535;
    protected static final HashMap<Integer, String> _tagNameMap;
    private XMPMeta _xmpMeta;

    public String getName() {
        return "XMP";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(65535, "XMP Value Count");
    }

    public XmpDirectory() {
        setDescriptor(new XmpDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }

    public Map<String, String> getXmpProperties() {
        HashMap hashMap = new HashMap();
        XMPMeta xMPMeta = this._xmpMeta;
        if (xMPMeta != null) {
            try {
                XMPIterator it2 = xMPMeta.iterator();
                while (it2.hasNext()) {
                    XMPPropertyInfo xMPPropertyInfo = (XMPPropertyInfo) it2.next();
                    String path = xMPPropertyInfo.getPath();
                    String value = xMPPropertyInfo.getValue();
                    if (!(path == null || value == null)) {
                        hashMap.put(path, value);
                    }
                }
            } catch (XMPException unused) {
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public void setXMPMeta(XMPMeta xMPMeta) {
        this._xmpMeta = xMPMeta;
        int i = 0;
        try {
            XMPIterator it2 = xMPMeta.iterator();
            while (it2.hasNext()) {
                if (((XMPPropertyInfo) it2.next()).getPath() != null) {
                    i++;
                }
            }
            setInt(65535, i);
        } catch (XMPException unused) {
        }
    }

    public XMPMeta getXMPMeta() {
        if (this._xmpMeta == null) {
            this._xmpMeta = new XMPMetaImpl();
        }
        return this._xmpMeta;
    }
}
