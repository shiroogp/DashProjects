package com.drew.metadata;

import com.drew.lang.Rational;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import kotlin.UByte;

public abstract class Directory {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String _floatFormatPattern = "0.###";
    protected final Collection<Tag> _definedTagList = new ArrayList();
    protected TagDescriptor _descriptor;
    private final Collection<String> _errorList = new ArrayList(4);
    private Directory _parent;
    protected final Map<Integer, Object> _tagMap = new HashMap();

    public abstract String getName();

    /* access modifiers changed from: protected */
    public abstract HashMap<Integer, String> getTagNameMap();

    protected Directory() {
    }

    public boolean isEmpty() {
        return this._errorList.isEmpty() && this._definedTagList.isEmpty();
    }

    public boolean containsTag(int i) {
        return this._tagMap.containsKey(Integer.valueOf(i));
    }

    public Collection<Tag> getTags() {
        return Collections.unmodifiableCollection(this._definedTagList);
    }

    public int getTagCount() {
        return this._definedTagList.size();
    }

    public void setDescriptor(TagDescriptor tagDescriptor) {
        Objects.requireNonNull(tagDescriptor, "cannot set a null descriptor");
        this._descriptor = tagDescriptor;
    }

    public void addError(String str) {
        this._errorList.add(str);
    }

    public boolean hasErrors() {
        return this._errorList.size() > 0;
    }

    public Iterable<String> getErrors() {
        return Collections.unmodifiableCollection(this._errorList);
    }

    public int getErrorCount() {
        return this._errorList.size();
    }

    public Directory getParent() {
        return this._parent;
    }

    public void setParent(Directory directory) {
        this._parent = directory;
    }

    public void setInt(int i, int i2) {
        setObject(i, Integer.valueOf(i2));
    }

    public void setIntArray(int i, int[] iArr) {
        setObjectArray(i, iArr);
    }

    public void setFloat(int i, float f) {
        setObject(i, Float.valueOf(f));
    }

    public void setFloatArray(int i, float[] fArr) {
        setObjectArray(i, fArr);
    }

    public void setDouble(int i, double d) {
        setObject(i, Double.valueOf(d));
    }

    public void setDoubleArray(int i, double[] dArr) {
        setObjectArray(i, dArr);
    }

    public void setStringValue(int i, StringValue stringValue) {
        Objects.requireNonNull(stringValue, "cannot set a null StringValue");
        setObject(i, stringValue);
    }

    public void setString(int i, String str) {
        Objects.requireNonNull(str, "cannot set a null String");
        setObject(i, str);
    }

    public void setStringArray(int i, String[] strArr) {
        setObjectArray(i, strArr);
    }

    public void setStringValueArray(int i, StringValue[] stringValueArr) {
        setObjectArray(i, stringValueArr);
    }

    public void setBoolean(int i, boolean z) {
        setObject(i, Boolean.valueOf(z));
    }

    public void setLong(int i, long j) {
        setObject(i, Long.valueOf(j));
    }

    public void setDate(int i, Date date) {
        setObject(i, date);
    }

    public void setRational(int i, Rational rational) {
        setObject(i, rational);
    }

    public void setRationalArray(int i, Rational[] rationalArr) {
        setObjectArray(i, rationalArr);
    }

    public void setByteArray(int i, byte[] bArr) {
        setObjectArray(i, bArr);
    }

    public void setObject(int i, Object obj) {
        Objects.requireNonNull(obj, "cannot set a null object");
        if (!this._tagMap.containsKey(Integer.valueOf(i))) {
            this._definedTagList.add(new Tag(i, this));
        }
        this._tagMap.put(Integer.valueOf(i), obj);
    }

    public void setObjectArray(int i, Object obj) {
        setObject(i, obj);
    }

    public int getInt(int i) throws MetadataException {
        Integer integer = getInteger(i);
        if (integer != null) {
            return integer.intValue();
        }
        Object object = getObject(i);
        if (object == null) {
            throw new MetadataException("Tag '" + getTagName(i) + "' has not been set -- check using containsTag() first");
        }
        throw new MetadataException("Tag '" + i + "' cannot be converted to int.  It is of type '" + object.getClass() + "'.");
    }

    public Integer getInteger(int i) {
        Object object = getObject(i);
        if (object == null) {
            return null;
        }
        if (object instanceof Number) {
            return Integer.valueOf(((Number) object).intValue());
        }
        if ((object instanceof String) || (object instanceof StringValue)) {
            try {
                return Integer.valueOf(Integer.parseInt(object.toString()));
            } catch (NumberFormatException unused) {
                long j = 0;
                for (byte b : object.toString().getBytes()) {
                    j = (j << 8) + ((long) (b & UByte.MAX_VALUE));
                }
                return Integer.valueOf((int) j);
            }
        } else {
            if (object instanceof Rational[]) {
                Rational[] rationalArr = (Rational[]) object;
                if (rationalArr.length == 1) {
                    return Integer.valueOf(rationalArr[0].intValue());
                }
            } else if (object instanceof byte[]) {
                byte[] bArr = (byte[]) object;
                if (bArr.length == 1) {
                    return Integer.valueOf(bArr[0]);
                }
            } else if (object instanceof int[]) {
                int[] iArr = (int[]) object;
                if (iArr.length == 1) {
                    return Integer.valueOf(iArr[0]);
                }
            } else if (object instanceof short[]) {
                short[] sArr = (short[]) object;
                if (sArr.length == 1) {
                    return Integer.valueOf(sArr[0]);
                }
            }
            return null;
        }
    }

    public String[] getStringArray(int i) {
        Object object = getObject(i);
        if (object == null) {
            return null;
        }
        if (object instanceof String[]) {
            return (String[]) object;
        }
        int i2 = 0;
        if (object instanceof String) {
            return new String[]{(String) object};
        } else if (object instanceof StringValue) {
            return new String[]{object.toString()};
        } else if (object instanceof StringValue[]) {
            StringValue[] stringValueArr = (StringValue[]) object;
            int length = stringValueArr.length;
            String[] strArr = new String[length];
            while (i2 < length) {
                strArr[i2] = stringValueArr[i2].toString();
                i2++;
            }
            return strArr;
        } else if (object instanceof int[]) {
            int[] iArr = (int[]) object;
            int length2 = iArr.length;
            String[] strArr2 = new String[length2];
            while (i2 < length2) {
                strArr2[i2] = Integer.toString(iArr[i2]);
                i2++;
            }
            return strArr2;
        } else if (object instanceof byte[]) {
            byte[] bArr = (byte[]) object;
            int length3 = bArr.length;
            String[] strArr3 = new String[length3];
            while (i2 < length3) {
                strArr3[i2] = Byte.toString(bArr[i2]);
                i2++;
            }
            return strArr3;
        } else if (!(object instanceof Rational[])) {
            return null;
        } else {
            Rational[] rationalArr = (Rational[]) object;
            int length4 = rationalArr.length;
            String[] strArr4 = new String[length4];
            for (int i3 = 0; i3 < length4; i3++) {
                strArr4[i3] = rationalArr[i3].toSimpleString(false);
            }
            return strArr4;
        }
    }

    public StringValue[] getStringValueArray(int i) {
        Object object = getObject(i);
        if (object == null) {
            return null;
        }
        if (object instanceof StringValue[]) {
            return (StringValue[]) object;
        }
        if (!(object instanceof StringValue)) {
            return null;
        }
        return new StringValue[]{(StringValue) object};
    }

    public int[] getIntArray(int i) {
        Object object = getObject(i);
        if (object == null) {
            return null;
        }
        if (object instanceof int[]) {
            return (int[]) object;
        }
        int i2 = 0;
        if (object instanceof Rational[]) {
            Rational[] rationalArr = (Rational[]) object;
            int length = rationalArr.length;
            int[] iArr = new int[length];
            while (i2 < length) {
                iArr[i2] = rationalArr[i2].intValue();
                i2++;
            }
            return iArr;
        } else if (object instanceof short[]) {
            short[] sArr = (short[]) object;
            int[] iArr2 = new int[sArr.length];
            while (i2 < sArr.length) {
                iArr2[i2] = sArr[i2];
                i2++;
            }
            return iArr2;
        } else if (object instanceof byte[]) {
            byte[] bArr = (byte[]) object;
            int[] iArr3 = new int[bArr.length];
            while (i2 < bArr.length) {
                iArr3[i2] = bArr[i2];
                i2++;
            }
            return iArr3;
        } else if (object instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) object;
            int[] iArr4 = new int[charSequence.length()];
            while (i2 < charSequence.length()) {
                iArr4[i2] = charSequence.charAt(i2);
                i2++;
            }
            return iArr4;
        } else if (!(object instanceof Integer)) {
            return null;
        } else {
            return new int[]{((Integer) object).intValue()};
        }
    }

    public byte[] getByteArray(int i) {
        Object object = getObject(i);
        if (object == null) {
            return null;
        }
        if (object instanceof StringValue) {
            return ((StringValue) object).getBytes();
        }
        int i2 = 0;
        if (object instanceof Rational[]) {
            Rational[] rationalArr = (Rational[]) object;
            int length = rationalArr.length;
            byte[] bArr = new byte[length];
            while (i2 < length) {
                bArr[i2] = rationalArr[i2].byteValue();
                i2++;
            }
            return bArr;
        } else if (object instanceof byte[]) {
            return (byte[]) object;
        } else {
            if (object instanceof int[]) {
                int[] iArr = (int[]) object;
                byte[] bArr2 = new byte[iArr.length];
                while (i2 < iArr.length) {
                    bArr2[i2] = (byte) iArr[i2];
                    i2++;
                }
                return bArr2;
            } else if (object instanceof short[]) {
                short[] sArr = (short[]) object;
                byte[] bArr3 = new byte[sArr.length];
                while (i2 < sArr.length) {
                    bArr3[i2] = (byte) sArr[i2];
                    i2++;
                }
                return bArr3;
            } else if (object instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) object;
                byte[] bArr4 = new byte[charSequence.length()];
                while (i2 < charSequence.length()) {
                    bArr4[i2] = (byte) charSequence.charAt(i2);
                    i2++;
                }
                return bArr4;
            } else if (!(object instanceof Integer)) {
                return null;
            } else {
                return new byte[]{((Integer) object).byteValue()};
            }
        }
    }

    public double getDouble(int i) throws MetadataException {
        Double doubleObject = getDoubleObject(i);
        if (doubleObject != null) {
            return doubleObject.doubleValue();
        }
        Object object = getObject(i);
        if (object == null) {
            throw new MetadataException("Tag '" + getTagName(i) + "' has not been set -- check using containsTag() first");
        }
        throw new MetadataException("Tag '" + i + "' cannot be converted to a double.  It is of type '" + object.getClass() + "'.");
    }

    public Double getDoubleObject(int i) {
        Object object = getObject(i);
        if (object == null) {
            return null;
        }
        if ((object instanceof String) || (object instanceof StringValue)) {
            try {
                return Double.valueOf(Double.parseDouble(object.toString()));
            } catch (NumberFormatException unused) {
                return null;
            }
        } else if (object instanceof Number) {
            return Double.valueOf(((Number) object).doubleValue());
        } else {
            return null;
        }
    }

    public float getFloat(int i) throws MetadataException {
        Float floatObject = getFloatObject(i);
        if (floatObject != null) {
            return floatObject.floatValue();
        }
        Object object = getObject(i);
        if (object == null) {
            throw new MetadataException("Tag '" + getTagName(i) + "' has not been set -- check using containsTag() first");
        }
        throw new MetadataException("Tag '" + i + "' cannot be converted to a float.  It is of type '" + object.getClass() + "'.");
    }

    public Float getFloatObject(int i) {
        Object object = getObject(i);
        if (object == null) {
            return null;
        }
        if ((object instanceof String) || (object instanceof StringValue)) {
            try {
                return Float.valueOf(Float.parseFloat(object.toString()));
            } catch (NumberFormatException unused) {
                return null;
            }
        } else if (object instanceof Number) {
            return Float.valueOf(((Number) object).floatValue());
        } else {
            return null;
        }
    }

    public long getLong(int i) throws MetadataException {
        Long longObject = getLongObject(i);
        if (longObject != null) {
            return longObject.longValue();
        }
        Object object = getObject(i);
        if (object == null) {
            throw new MetadataException("Tag '" + getTagName(i) + "' has not been set -- check using containsTag() first");
        }
        throw new MetadataException("Tag '" + i + "' cannot be converted to a long.  It is of type '" + object.getClass() + "'.");
    }

    public Long getLongObject(int i) {
        Object object = getObject(i);
        if (object == null) {
            return null;
        }
        if (object instanceof Number) {
            return Long.valueOf(((Number) object).longValue());
        }
        if ((object instanceof String) || (object instanceof StringValue)) {
            try {
                return Long.valueOf(Long.parseLong(object.toString()));
            } catch (NumberFormatException unused) {
                return null;
            }
        } else {
            if (object instanceof Rational[]) {
                Rational[] rationalArr = (Rational[]) object;
                if (rationalArr.length == 1) {
                    return Long.valueOf(rationalArr[0].longValue());
                }
            } else if (object instanceof byte[]) {
                byte[] bArr = (byte[]) object;
                if (bArr.length == 1) {
                    return Long.valueOf((long) bArr[0]);
                }
            } else if (object instanceof int[]) {
                int[] iArr = (int[]) object;
                if (iArr.length == 1) {
                    return Long.valueOf((long) iArr[0]);
                }
            } else if (object instanceof short[]) {
                short[] sArr = (short[]) object;
                if (sArr.length == 1) {
                    return Long.valueOf((long) sArr[0]);
                }
            }
            return null;
        }
    }

    public boolean getBoolean(int i) throws MetadataException {
        Boolean booleanObject = getBooleanObject(i);
        if (booleanObject != null) {
            return booleanObject.booleanValue();
        }
        Object object = getObject(i);
        if (object == null) {
            throw new MetadataException("Tag '" + getTagName(i) + "' has not been set -- check using containsTag() first");
        }
        throw new MetadataException("Tag '" + i + "' cannot be converted to a boolean.  It is of type '" + object.getClass() + "'.");
    }

    public Boolean getBooleanObject(int i) {
        Object object = getObject(i);
        if (object == null) {
            return null;
        }
        if (object instanceof Boolean) {
            return (Boolean) object;
        }
        if ((object instanceof String) || (object instanceof StringValue)) {
            try {
                return Boolean.valueOf(Boolean.getBoolean(object.toString()));
            } catch (NumberFormatException unused) {
                return null;
            }
        } else if (!(object instanceof Number)) {
            return null;
        } else {
            return Boolean.valueOf(((Number) object).doubleValue() != 0.0d);
        }
    }

    public Date getDate(int i) {
        return getDate(i, (String) null, (TimeZone) null);
    }

    public Date getDate(int i, TimeZone timeZone) {
        return getDate(i, (String) null, timeZone);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Date getDate(int r16, java.lang.String r17, java.util.TimeZone r18) {
        /*
            r15 = this;
            java.lang.Object r0 = r15.getObject(r16)
            boolean r1 = r0 instanceof java.util.Date
            if (r1 == 0) goto L_0x000b
            java.util.Date r0 = (java.util.Date) r0
            return r0
        L_0x000b:
            boolean r1 = r0 instanceof java.lang.String
            r2 = 0
            if (r1 != 0) goto L_0x001a
            boolean r1 = r0 instanceof com.drew.metadata.StringValue
            if (r1 == 0) goto L_0x0015
            goto L_0x001a
        L_0x0015:
            r0 = r17
        L_0x0017:
            r1 = r2
            goto L_0x00c6
        L_0x001a:
            r1 = 12
            java.lang.String r3 = "yyyy:MM:dd HH:mm:ss"
            java.lang.String r4 = "yyyy:MM:dd HH:mm"
            java.lang.String r5 = "yyyy-MM-dd HH:mm:ss"
            java.lang.String r6 = "yyyy-MM-dd HH:mm"
            java.lang.String r7 = "yyyy.MM.dd HH:mm:ss"
            java.lang.String r8 = "yyyy.MM.dd HH:mm"
            java.lang.String r9 = "yyyy-MM-dd'T'HH:mm:ss"
            java.lang.String r10 = "yyyy-MM-dd'T'HH:mm"
            java.lang.String r11 = "yyyy-MM-dd"
            java.lang.String r12 = "yyyy-MM"
            java.lang.String r13 = "yyyyMMdd"
            java.lang.String r14 = "yyyy"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14}
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "(\\d\\d:\\d\\d:\\d\\d)(\\.\\d+)"
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4)
            java.util.regex.Matcher r4 = r4.matcher(r0)
            boolean r5 = r4.find()
            if (r5 == 0) goto L_0x0069
            r0 = 2
            java.lang.String r0 = r4.group(r0)
            r5 = 1
            java.lang.String r0 = r0.substring(r5)
            java.lang.String r5 = "$1"
            java.lang.String r4 = r4.replaceAll(r5)
            goto L_0x006c
        L_0x0069:
            r4 = r0
            r0 = r17
        L_0x006c:
            java.lang.String r5 = "(Z|[+-]\\d\\d:\\d\\d)$"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.util.regex.Matcher r5 = r5.matcher(r4)
            boolean r6 = r5.find()
            java.lang.String r7 = "GMT"
            if (r6 == 0) goto L_0x00a4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r4 = r4.append(r7)
            java.lang.String r6 = r5.group()
            java.lang.String r8 = "Z"
            java.lang.String r9 = ""
            java.lang.String r6 = r6.replaceAll(r8, r9)
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.String r4 = r4.toString()
            java.util.TimeZone r4 = java.util.TimeZone.getTimeZone(r4)
            java.lang.String r5 = r5.replaceAll(r9)
            goto L_0x00a7
        L_0x00a4:
            r5 = r4
            r4 = r18
        L_0x00a7:
            r6 = 0
        L_0x00a8:
            if (r6 >= r1) goto L_0x0017
            r8 = r3[r6]
            java.text.SimpleDateFormat r9 = new java.text.SimpleDateFormat     // Catch:{ ParseException -> 0x00c3 }
            r9.<init>(r8)     // Catch:{ ParseException -> 0x00c3 }
            if (r4 == 0) goto L_0x00b7
            r9.setTimeZone(r4)     // Catch:{ ParseException -> 0x00c3 }
            goto L_0x00be
        L_0x00b7:
            java.util.TimeZone r8 = java.util.TimeZone.getTimeZone(r7)     // Catch:{ ParseException -> 0x00c3 }
            r9.setTimeZone(r8)     // Catch:{ ParseException -> 0x00c3 }
        L_0x00be:
            java.util.Date r1 = r9.parse(r5)     // Catch:{ ParseException -> 0x00c3 }
            goto L_0x00c6
        L_0x00c3:
            int r6 = r6 + 1
            goto L_0x00a8
        L_0x00c6:
            if (r1 != 0) goto L_0x00c9
            return r2
        L_0x00c9:
            if (r0 != 0) goto L_0x00cc
            return r1
        L_0x00cc:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0101 }
            r2.<init>()     // Catch:{ NumberFormatException -> 0x0101 }
            java.lang.String r3 = "."
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ NumberFormatException -> 0x0101 }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ NumberFormatException -> 0x0101 }
            java.lang.String r0 = r0.toString()     // Catch:{ NumberFormatException -> 0x0101 }
            double r2 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x0101 }
            r4 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r2 = r2 * r4
            int r0 = (int) r2     // Catch:{ NumberFormatException -> 0x0101 }
            if (r0 < 0) goto L_0x0101
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r0 >= r2) goto L_0x0101
            java.util.Calendar r2 = java.util.Calendar.getInstance()     // Catch:{ NumberFormatException -> 0x0101 }
            r2.setTime(r1)     // Catch:{ NumberFormatException -> 0x0101 }
            r3 = 14
            r2.set(r3, r0)     // Catch:{ NumberFormatException -> 0x0101 }
            java.util.Date r0 = r2.getTime()     // Catch:{ NumberFormatException -> 0x0101 }
            return r0
        L_0x0101:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.drew.metadata.Directory.getDate(int, java.lang.String, java.util.TimeZone):java.util.Date");
    }

    public Rational getRational(int i) {
        Object object = getObject(i);
        if (object == null) {
            return null;
        }
        if (object instanceof Rational) {
            return (Rational) object;
        }
        if (object instanceof Integer) {
            return new Rational((long) ((Integer) object).intValue(), 1);
        }
        if (object instanceof Long) {
            return new Rational(((Long) object).longValue(), 1);
        }
        return null;
    }

    public Rational[] getRationalArray(int i) {
        Object object = getObject(i);
        if (object != null && (object instanceof Rational[])) {
            return (Rational[]) object;
        }
        return null;
    }

    public String getString(int i) {
        Object object = getObject(i);
        if (object == null) {
            return null;
        }
        if (object instanceof Rational) {
            return ((Rational) object).toSimpleString(true);
        }
        if (object.getClass().isArray()) {
            int length = Array.getLength(object);
            Class<?> componentType = object.getClass().getComponentType();
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            if (Object.class.isAssignableFrom(componentType)) {
                while (i2 < length) {
                    if (i2 != 0) {
                        sb.append(' ');
                    }
                    sb.append(Array.get(object, i2).toString());
                    i2++;
                }
            } else if (componentType.getName().equals("int")) {
                while (i2 < length) {
                    if (i2 != 0) {
                        sb.append(' ');
                    }
                    sb.append(Array.getInt(object, i2));
                    i2++;
                }
            } else if (componentType.getName().equals("short")) {
                while (i2 < length) {
                    if (i2 != 0) {
                        sb.append(' ');
                    }
                    sb.append(Array.getShort(object, i2));
                    i2++;
                }
            } else if (componentType.getName().equals("long")) {
                while (i2 < length) {
                    if (i2 != 0) {
                        sb.append(' ');
                    }
                    sb.append(Array.getLong(object, i2));
                    i2++;
                }
            } else if (componentType.getName().equals("float")) {
                DecimalFormat decimalFormat = new DecimalFormat(_floatFormatPattern);
                while (i2 < length) {
                    if (i2 != 0) {
                        sb.append(' ');
                    }
                    String format = decimalFormat.format((double) Array.getFloat(object, i2));
                    if (format.equals("-0")) {
                        format = "0";
                    }
                    sb.append(format);
                    i2++;
                }
            } else if (componentType.getName().equals("double")) {
                DecimalFormat decimalFormat2 = new DecimalFormat(_floatFormatPattern);
                while (i2 < length) {
                    if (i2 != 0) {
                        sb.append(' ');
                    }
                    String format2 = decimalFormat2.format(Array.getDouble(object, i2));
                    if (format2.equals("-0")) {
                        format2 = "0";
                    }
                    sb.append(format2);
                    i2++;
                }
            } else if (componentType.getName().equals("byte")) {
                while (i2 < length) {
                    if (i2 != 0) {
                        sb.append(' ');
                    }
                    sb.append(Array.getByte(object, i2) & UByte.MAX_VALUE);
                    i2++;
                }
            } else {
                addError("Unexpected array component type: " + componentType.getName());
            }
            return sb.toString();
        } else if (object instanceof Double) {
            return new DecimalFormat(_floatFormatPattern).format(((Double) object).doubleValue());
        } else {
            if (object instanceof Float) {
                return new DecimalFormat(_floatFormatPattern).format((double) ((Float) object).floatValue());
            }
            return object.toString();
        }
    }

    public String getString(int i, String str) {
        byte[] byteArray = getByteArray(i);
        if (byteArray == null) {
            return null;
        }
        try {
            return new String(byteArray, str);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public StringValue getStringValue(int i) {
        Object object = getObject(i);
        if (object instanceof StringValue) {
            return (StringValue) object;
        }
        return null;
    }

    public Object getObject(int i) {
        return this._tagMap.get(Integer.valueOf(i));
    }

    public String getTagName(int i) {
        HashMap<Integer, String> tagNameMap = getTagNameMap();
        if (tagNameMap.containsKey(Integer.valueOf(i))) {
            return tagNameMap.get(Integer.valueOf(i));
        }
        String hexString = Integer.toHexString(i);
        while (hexString.length() < 4) {
            hexString = "0" + hexString;
        }
        return "Unknown tag (0x" + hexString + ")";
    }

    public boolean hasTagName(int i) {
        return getTagNameMap().containsKey(Integer.valueOf(i));
    }

    public String getDescription(int i) {
        return this._descriptor.getDescription(i);
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = getName();
        objArr[1] = Integer.valueOf(this._tagMap.size());
        objArr[2] = this._tagMap.size() == 1 ? "tag" : "tags";
        return String.format("%s Directory (%d %s)", objArr);
    }
}
