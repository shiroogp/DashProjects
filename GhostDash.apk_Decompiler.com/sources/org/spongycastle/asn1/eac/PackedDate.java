package org.spongycastle.asn1.eac;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import kotlin.UByte;
import org.spongycastle.util.Arrays;

public class PackedDate {
    private byte[] time;

    public PackedDate(String str) {
        this.time = convert(str);
    }

    public PackedDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd'Z'");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = convert(simpleDateFormat.format(date));
    }

    public PackedDate(Date date, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd'Z'", locale);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = convert(simpleDateFormat.format(date));
    }

    private byte[] convert(String str) {
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[6];
        for (int i = 0; i != 6; i++) {
            bArr[i] = (byte) (charArray[i] - '0');
        }
        return bArr;
    }

    PackedDate(byte[] bArr) {
        this.time = bArr;
    }

    public Date getDate() throws ParseException {
        return new SimpleDateFormat("yyyyMMdd").parse("20" + toString());
    }

    public int hashCode() {
        return Arrays.hashCode(this.time);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PackedDate)) {
            return false;
        }
        return Arrays.areEqual(this.time, ((PackedDate) obj).time);
    }

    public String toString() {
        int length = this.time.length;
        char[] cArr = new char[length];
        for (int i = 0; i != length; i++) {
            cArr[i] = (char) ((this.time[i] & UByte.MAX_VALUE) + 48);
        }
        return new String(cArr);
    }

    public byte[] getEncoding() {
        return Arrays.clone(this.time);
    }
}
