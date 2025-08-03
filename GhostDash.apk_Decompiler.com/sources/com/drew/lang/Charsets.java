package com.drew.lang;

import com.bumptech.glide.load.Key;
import java.nio.charset.Charset;
import org.spongycastle.i18n.LocalizedMessage;

public final class Charsets {
    public static final Charset ASCII = Charset.forName("US-ASCII");
    public static final Charset ISO_8859_1 = Charset.forName(LocalizedMessage.DEFAULT_ENCODING);
    public static final Charset UTF_16 = Charset.forName("UTF-16");
    public static final Charset UTF_16BE = Charset.forName("UTF-16BE");
    public static final Charset UTF_16LE = Charset.forName("UTF-16LE");
    public static final Charset UTF_8 = Charset.forName(Key.STRING_CHARSET_NAME);
    public static final Charset WINDOWS_1252 = Charset.forName("Cp1252");
}
