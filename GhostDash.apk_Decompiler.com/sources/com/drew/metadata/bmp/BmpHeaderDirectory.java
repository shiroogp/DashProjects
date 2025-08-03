package com.drew.metadata.bmp;

import androidx.exifinterface.media.ExifInterface;
import com.drew.metadata.Directory;
import java.util.HashMap;

public class BmpHeaderDirectory extends Directory {
    public static final int TAG_ALPHA_MASK = 15;
    public static final int TAG_BITMAP_TYPE = -2;
    public static final int TAG_BITS_PER_PIXEL = 4;
    public static final int TAG_BLUE_MASK = 14;
    public static final int TAG_COLOR_ENCODING = 11;
    public static final int TAG_COLOR_SPACE_TYPE = 16;
    public static final int TAG_COLOUR_PLANES = 3;
    public static final int TAG_COMPRESSION = 5;
    public static final int TAG_GAMMA_BLUE = 19;
    public static final int TAG_GAMMA_GREEN = 18;
    public static final int TAG_GAMMA_RED = 17;
    public static final int TAG_GREEN_MASK = 13;
    public static final int TAG_HEADER_SIZE = -1;
    public static final int TAG_IMAGE_HEIGHT = 1;
    public static final int TAG_IMAGE_WIDTH = 2;
    public static final int TAG_IMPORTANT_COLOUR_COUNT = 9;
    public static final int TAG_INTENT = 20;
    public static final int TAG_LINKED_PROFILE = 21;
    public static final int TAG_PALETTE_COLOUR_COUNT = 8;
    public static final int TAG_RED_MASK = 12;
    public static final int TAG_RENDERING = 10;
    public static final int TAG_X_PIXELS_PER_METER = 6;
    public static final int TAG_Y_PIXELS_PER_METER = 7;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "BMP Header";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(-2, "Bitmap type");
        hashMap.put(-1, "Header Size");
        hashMap.put(1, "Image Height");
        hashMap.put(2, "Image Width");
        hashMap.put(3, "Planes");
        hashMap.put(4, "Bits Per Pixel");
        hashMap.put(5, ExifInterface.TAG_COMPRESSION);
        hashMap.put(6, "X Pixels per Meter");
        hashMap.put(7, "Y Pixels per Meter");
        hashMap.put(8, "Palette Colour Count");
        hashMap.put(9, "Important Colour Count");
        hashMap.put(10, "Rendering");
        hashMap.put(11, "Color Encoding");
        hashMap.put(12, "Red Mask");
        hashMap.put(13, "Green Mask");
        hashMap.put(14, "Blue Mask");
        hashMap.put(15, "Alpha Mask");
        hashMap.put(16, "Color Space Type");
        hashMap.put(17, "Red Gamma Curve");
        hashMap.put(18, "Green Gamma Curve");
        hashMap.put(19, "Blue Gamma Curve");
        hashMap.put(20, "Rendering Intent");
        hashMap.put(21, "Linked Profile File Name");
    }

    public BmpHeaderDirectory() {
        setDescriptor(new BmpHeaderDescriptor(this));
    }

    public BitmapType getBitmapType() {
        Integer integer = getInteger(-2);
        if (integer == null) {
            return null;
        }
        return BitmapType.typeOf(integer.intValue());
    }

    public Compression getCompression() {
        return Compression.typeOf(this);
    }

    public RenderingHalftoningAlgorithm getRendering() {
        Integer integer = getInteger(10);
        if (integer == null) {
            return null;
        }
        return RenderingHalftoningAlgorithm.typeOf(integer.intValue());
    }

    public ColorEncoding getColorEncoding() {
        Integer integer = getInteger(11);
        if (integer == null) {
            return null;
        }
        return ColorEncoding.typeOf(integer.intValue());
    }

    public ColorSpaceType getColorSpaceType() {
        Long longObject = getLongObject(16);
        if (longObject == null) {
            return null;
        }
        return ColorSpaceType.typeOf(longObject.longValue());
    }

    public RenderingIntent getRenderingIntent() {
        Integer integer = getInteger(20);
        if (integer == null) {
            return null;
        }
        return RenderingIntent.typeOf((long) integer.intValue());
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }

    public enum BitmapType {
        BITMAP(BmpReader.BITMAP),
        OS2_BITMAP_ARRAY(BmpReader.OS2_BITMAP_ARRAY),
        OS2_ICON(BmpReader.OS2_ICON),
        OS2_COLOR_ICON(BmpReader.OS2_COLOR_ICON),
        OS2_COLOR_POINTER(BmpReader.OS2_COLOR_POINTER),
        OS2_POINTER(BmpReader.OS2_POINTER);
        
        private final int value;

        private BitmapType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public static BitmapType typeOf(int i) {
            for (BitmapType bitmapType : values()) {
                if (bitmapType.value == i) {
                    return bitmapType;
                }
            }
            return null;
        }

        public String toString() {
            switch (AnonymousClass1.$SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$BitmapType[ordinal()]) {
                case 1:
                    return "Standard";
                case 2:
                    return "Bitmap Array";
                case 3:
                    return "Color Icon";
                case 4:
                    return "Color Pointer";
                case 5:
                    return "Monochrome Icon";
                case 6:
                    return "Monochrome Pointer";
                default:
                    throw new IllegalStateException("Unimplemented bitmap type " + super.toString());
            }
        }
    }

    public enum Compression {
        BI_RGB(0),
        BI_RLE8(1),
        BI_RLE4(2),
        BI_BITFIELDS(3),
        BI_HUFFMAN_1D(3),
        BI_JPEG(4),
        BI_RLE24(4),
        BI_PNG(5),
        BI_ALPHABITFIELDS(6),
        BI_CMYK(11),
        BI_CMYKRLE8(12),
        BI_CMYKRLE4(13);
        
        private final int value;

        private Compression(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public static Compression typeOf(BmpHeaderDirectory bmpHeaderDirectory) {
            Integer integer;
            Integer integer2 = bmpHeaderDirectory.getInteger(5);
            if (integer2 == null || (integer = bmpHeaderDirectory.getInteger(-1)) == null) {
                return null;
            }
            return typeOf(integer2.intValue(), integer.intValue());
        }

        public static Compression typeOf(int i, int i2) {
            switch (i) {
                case 0:
                    return BI_RGB;
                case 1:
                    return BI_RLE8;
                case 2:
                    return BI_RLE4;
                case 3:
                    return i2 == 64 ? BI_HUFFMAN_1D : BI_BITFIELDS;
                case 4:
                    return i2 == 64 ? BI_RLE24 : BI_JPEG;
                case 5:
                    return BI_PNG;
                case 6:
                    return BI_ALPHABITFIELDS;
                case 11:
                    return BI_CMYK;
                case 12:
                    return BI_CMYKRLE8;
                case 13:
                    return BI_CMYKRLE4;
                default:
                    return null;
            }
        }

        public String toString() {
            switch (AnonymousClass1.$SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$Compression[ordinal()]) {
                case 1:
                    return "None";
                case 2:
                    return "RLE 8-bit/pixel";
                case 3:
                    return "RLE 4-bit/pixel";
                case 4:
                    return "Bit Fields";
                case 5:
                    return "Huffman 1D";
                case 6:
                    return "JPEG";
                case 7:
                    return "RLE 24-bit/pixel";
                case 8:
                    return "PNG";
                case 9:
                    return "RGBA Bit Fields";
                case 10:
                    return "CMYK Uncompressed";
                case 11:
                    return "CMYK RLE-8";
                case 12:
                    return "CMYK RLE-4";
                default:
                    throw new IllegalStateException("Unimplemented compression type " + super.toString());
            }
        }
    }

    public enum RenderingHalftoningAlgorithm {
        NONE(0),
        ERROR_DIFFUSION(1),
        PANDA(2),
        SUPER_CIRCLE(3);
        
        private final int value;

        private RenderingHalftoningAlgorithm(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public static RenderingHalftoningAlgorithm typeOf(int i) {
            for (RenderingHalftoningAlgorithm renderingHalftoningAlgorithm : values()) {
                if (renderingHalftoningAlgorithm.value == i) {
                    return renderingHalftoningAlgorithm;
                }
            }
            return null;
        }

        public String toString() {
            int i = AnonymousClass1.$SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$RenderingHalftoningAlgorithm[ordinal()];
            if (i == 1) {
                return "No Halftoning Algorithm";
            }
            if (i == 2) {
                return "Error Diffusion Halftoning";
            }
            if (i == 3) {
                return "Processing Algorithm for Noncoded Document Acquisition";
            }
            if (i == 4) {
                return "Super-circle Halftoning";
            }
            throw new IllegalStateException("Unimplemented rendering halftoning algorithm type " + super.toString());
        }
    }

    public enum ColorEncoding {
        RGB(0);
        
        private final int value;

        private ColorEncoding(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public static ColorEncoding typeOf(int i) {
            if (i == 0) {
                return RGB;
            }
            return null;
        }
    }

    public enum ColorSpaceType {
        LCS_CALIBRATED_RGB(0),
        LCS_sRGB(1934772034),
        LCS_WINDOWS_COLOR_SPACE(1466527264),
        PROFILE_LINKED(1279872587),
        PROFILE_EMBEDDED(1296188740);
        
        private final long value;

        private ColorSpaceType(long j) {
            this.value = j;
        }

        public long getValue() {
            return this.value;
        }

        public static ColorSpaceType typeOf(long j) {
            for (ColorSpaceType colorSpaceType : values()) {
                if (colorSpaceType.value == j) {
                    return colorSpaceType;
                }
            }
            return null;
        }

        public String toString() {
            int i = AnonymousClass1.$SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$ColorSpaceType[ordinal()];
            if (i == 1) {
                return "Calibrated RGB";
            }
            if (i == 2) {
                return "sRGB Color Space";
            }
            if (i == 3) {
                return "System Default Color Space, sRGB";
            }
            if (i == 4) {
                return "Linked Profile";
            }
            if (i == 5) {
                return "Embedded Profile";
            }
            throw new IllegalStateException("Unimplemented color space type " + super.toString());
        }
    }

    public enum RenderingIntent {
        LCS_GM_BUSINESS(1),
        LCS_GM_GRAPHICS(2),
        LCS_GM_IMAGES(4),
        LCS_GM_ABS_COLORIMETRIC(8);
        
        private final int value;

        private RenderingIntent(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public static RenderingIntent typeOf(long j) {
            for (RenderingIntent renderingIntent : values()) {
                if (((long) renderingIntent.value) == j) {
                    return renderingIntent;
                }
            }
            return null;
        }

        public String toString() {
            int i = AnonymousClass1.$SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$RenderingIntent[ordinal()];
            if (i == 1) {
                return "Graphic, Saturation";
            }
            if (i == 2) {
                return "Proof, Relative Colorimetric";
            }
            if (i == 3) {
                return "Picture, Perceptual";
            }
            if (i == 4) {
                return "Match, Absolute Colorimetric";
            }
            throw new IllegalStateException("Unimplemented rendering intent " + super.toString());
        }
    }

    /* renamed from: com.drew.metadata.bmp.BmpHeaderDirectory$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$BitmapType;
        static final /* synthetic */ int[] $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$ColorSpaceType;
        static final /* synthetic */ int[] $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$Compression;
        static final /* synthetic */ int[] $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$RenderingHalftoningAlgorithm;
        static final /* synthetic */ int[] $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$RenderingIntent;

        /* JADX WARNING: Can't wrap try/catch for region: R(64:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|(2:23|24)|25|(2:27|28)|29|31|32|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|(2:49|50)|51|53|54|55|56|57|58|59|60|61|62|63|64|(2:65|66)|67|69|70|71|72|73|74|75|76|77|78|79|80|82) */
        /* JADX WARNING: Can't wrap try/catch for region: R(66:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|(2:23|24)|25|27|28|29|31|32|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|(2:49|50)|51|53|54|55|56|57|58|59|60|61|62|63|64|(2:65|66)|67|69|70|71|72|73|74|75|76|77|78|79|80|82) */
        /* JADX WARNING: Can't wrap try/catch for region: R(69:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|27|28|29|31|32|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|(2:49|50)|51|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|69|70|71|72|73|74|75|76|77|78|79|80|82) */
        /* JADX WARNING: Can't wrap try/catch for region: R(71:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|27|28|29|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|(2:49|50)|51|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|69|70|71|72|73|74|75|76|77|78|79|80|82) */
        /* JADX WARNING: Can't wrap try/catch for region: R(73:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|27|28|29|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|49|50|51|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|69|70|71|72|73|74|75|76|77|78|79|80|82) */
        /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x007e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0088 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00ad */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00b7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00c1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00cb */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00e0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00eb */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00f7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x0103 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x010f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x011b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x0138 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x0142 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x014c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x0156 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x0160 */
        static {
            /*
                com.drew.metadata.bmp.BmpHeaderDirectory$RenderingIntent[] r0 = com.drew.metadata.bmp.BmpHeaderDirectory.RenderingIntent.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$RenderingIntent = r0
                r1 = 1
                com.drew.metadata.bmp.BmpHeaderDirectory$RenderingIntent r2 = com.drew.metadata.bmp.BmpHeaderDirectory.RenderingIntent.LCS_GM_BUSINESS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$RenderingIntent     // Catch:{ NoSuchFieldError -> 0x001d }
                com.drew.metadata.bmp.BmpHeaderDirectory$RenderingIntent r3 = com.drew.metadata.bmp.BmpHeaderDirectory.RenderingIntent.LCS_GM_GRAPHICS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$RenderingIntent     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.drew.metadata.bmp.BmpHeaderDirectory$RenderingIntent r4 = com.drew.metadata.bmp.BmpHeaderDirectory.RenderingIntent.LCS_GM_IMAGES     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$RenderingIntent     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.drew.metadata.bmp.BmpHeaderDirectory$RenderingIntent r5 = com.drew.metadata.bmp.BmpHeaderDirectory.RenderingIntent.LCS_GM_ABS_COLORIMETRIC     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.drew.metadata.bmp.BmpHeaderDirectory$ColorSpaceType[] r4 = com.drew.metadata.bmp.BmpHeaderDirectory.ColorSpaceType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$ColorSpaceType = r4
                com.drew.metadata.bmp.BmpHeaderDirectory$ColorSpaceType r5 = com.drew.metadata.bmp.BmpHeaderDirectory.ColorSpaceType.LCS_CALIBRATED_RGB     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r4 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$ColorSpaceType     // Catch:{ NoSuchFieldError -> 0x004e }
                com.drew.metadata.bmp.BmpHeaderDirectory$ColorSpaceType r5 = com.drew.metadata.bmp.BmpHeaderDirectory.ColorSpaceType.LCS_sRGB     // Catch:{ NoSuchFieldError -> 0x004e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r4 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$ColorSpaceType     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.drew.metadata.bmp.BmpHeaderDirectory$ColorSpaceType r5 = com.drew.metadata.bmp.BmpHeaderDirectory.ColorSpaceType.LCS_WINDOWS_COLOR_SPACE     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r4[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r4 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$ColorSpaceType     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.drew.metadata.bmp.BmpHeaderDirectory$ColorSpaceType r5 = com.drew.metadata.bmp.BmpHeaderDirectory.ColorSpaceType.PROFILE_LINKED     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                r4 = 5
                int[] r5 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$ColorSpaceType     // Catch:{ NoSuchFieldError -> 0x006d }
                com.drew.metadata.bmp.BmpHeaderDirectory$ColorSpaceType r6 = com.drew.metadata.bmp.BmpHeaderDirectory.ColorSpaceType.PROFILE_EMBEDDED     // Catch:{ NoSuchFieldError -> 0x006d }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                com.drew.metadata.bmp.BmpHeaderDirectory$RenderingHalftoningAlgorithm[] r5 = com.drew.metadata.bmp.BmpHeaderDirectory.RenderingHalftoningAlgorithm.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$RenderingHalftoningAlgorithm = r5
                com.drew.metadata.bmp.BmpHeaderDirectory$RenderingHalftoningAlgorithm r6 = com.drew.metadata.bmp.BmpHeaderDirectory.RenderingHalftoningAlgorithm.NONE     // Catch:{ NoSuchFieldError -> 0x007e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                int[] r5 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$RenderingHalftoningAlgorithm     // Catch:{ NoSuchFieldError -> 0x0088 }
                com.drew.metadata.bmp.BmpHeaderDirectory$RenderingHalftoningAlgorithm r6 = com.drew.metadata.bmp.BmpHeaderDirectory.RenderingHalftoningAlgorithm.ERROR_DIFFUSION     // Catch:{ NoSuchFieldError -> 0x0088 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0088 }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0088 }
            L_0x0088:
                int[] r5 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$RenderingHalftoningAlgorithm     // Catch:{ NoSuchFieldError -> 0x0092 }
                com.drew.metadata.bmp.BmpHeaderDirectory$RenderingHalftoningAlgorithm r6 = com.drew.metadata.bmp.BmpHeaderDirectory.RenderingHalftoningAlgorithm.PANDA     // Catch:{ NoSuchFieldError -> 0x0092 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0092 }
                r5[r6] = r2     // Catch:{ NoSuchFieldError -> 0x0092 }
            L_0x0092:
                int[] r5 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$RenderingHalftoningAlgorithm     // Catch:{ NoSuchFieldError -> 0x009c }
                com.drew.metadata.bmp.BmpHeaderDirectory$RenderingHalftoningAlgorithm r6 = com.drew.metadata.bmp.BmpHeaderDirectory.RenderingHalftoningAlgorithm.SUPER_CIRCLE     // Catch:{ NoSuchFieldError -> 0x009c }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r5[r6] = r3     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                com.drew.metadata.bmp.BmpHeaderDirectory$Compression[] r5 = com.drew.metadata.bmp.BmpHeaderDirectory.Compression.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$Compression = r5
                com.drew.metadata.bmp.BmpHeaderDirectory$Compression r6 = com.drew.metadata.bmp.BmpHeaderDirectory.Compression.BI_RGB     // Catch:{ NoSuchFieldError -> 0x00ad }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ad }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x00ad }
            L_0x00ad:
                int[] r5 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$Compression     // Catch:{ NoSuchFieldError -> 0x00b7 }
                com.drew.metadata.bmp.BmpHeaderDirectory$Compression r6 = com.drew.metadata.bmp.BmpHeaderDirectory.Compression.BI_RLE8     // Catch:{ NoSuchFieldError -> 0x00b7 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b7 }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x00b7 }
            L_0x00b7:
                int[] r5 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$Compression     // Catch:{ NoSuchFieldError -> 0x00c1 }
                com.drew.metadata.bmp.BmpHeaderDirectory$Compression r6 = com.drew.metadata.bmp.BmpHeaderDirectory.Compression.BI_RLE4     // Catch:{ NoSuchFieldError -> 0x00c1 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c1 }
                r5[r6] = r2     // Catch:{ NoSuchFieldError -> 0x00c1 }
            L_0x00c1:
                int[] r5 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$Compression     // Catch:{ NoSuchFieldError -> 0x00cb }
                com.drew.metadata.bmp.BmpHeaderDirectory$Compression r6 = com.drew.metadata.bmp.BmpHeaderDirectory.Compression.BI_BITFIELDS     // Catch:{ NoSuchFieldError -> 0x00cb }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cb }
                r5[r6] = r3     // Catch:{ NoSuchFieldError -> 0x00cb }
            L_0x00cb:
                int[] r5 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$Compression     // Catch:{ NoSuchFieldError -> 0x00d5 }
                com.drew.metadata.bmp.BmpHeaderDirectory$Compression r6 = com.drew.metadata.bmp.BmpHeaderDirectory.Compression.BI_HUFFMAN_1D     // Catch:{ NoSuchFieldError -> 0x00d5 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d5 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x00d5 }
            L_0x00d5:
                r5 = 6
                int[] r6 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$Compression     // Catch:{ NoSuchFieldError -> 0x00e0 }
                com.drew.metadata.bmp.BmpHeaderDirectory$Compression r7 = com.drew.metadata.bmp.BmpHeaderDirectory.Compression.BI_JPEG     // Catch:{ NoSuchFieldError -> 0x00e0 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e0 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x00e0 }
            L_0x00e0:
                int[] r6 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$Compression     // Catch:{ NoSuchFieldError -> 0x00eb }
                com.drew.metadata.bmp.BmpHeaderDirectory$Compression r7 = com.drew.metadata.bmp.BmpHeaderDirectory.Compression.BI_RLE24     // Catch:{ NoSuchFieldError -> 0x00eb }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00eb }
                r8 = 7
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x00eb }
            L_0x00eb:
                int[] r6 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$Compression     // Catch:{ NoSuchFieldError -> 0x00f7 }
                com.drew.metadata.bmp.BmpHeaderDirectory$Compression r7 = com.drew.metadata.bmp.BmpHeaderDirectory.Compression.BI_PNG     // Catch:{ NoSuchFieldError -> 0x00f7 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f7 }
                r8 = 8
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x00f7 }
            L_0x00f7:
                int[] r6 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$Compression     // Catch:{ NoSuchFieldError -> 0x0103 }
                com.drew.metadata.bmp.BmpHeaderDirectory$Compression r7 = com.drew.metadata.bmp.BmpHeaderDirectory.Compression.BI_ALPHABITFIELDS     // Catch:{ NoSuchFieldError -> 0x0103 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0103 }
                r8 = 9
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0103 }
            L_0x0103:
                int[] r6 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$Compression     // Catch:{ NoSuchFieldError -> 0x010f }
                com.drew.metadata.bmp.BmpHeaderDirectory$Compression r7 = com.drew.metadata.bmp.BmpHeaderDirectory.Compression.BI_CMYK     // Catch:{ NoSuchFieldError -> 0x010f }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x010f }
                r8 = 10
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x010f }
            L_0x010f:
                int[] r6 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$Compression     // Catch:{ NoSuchFieldError -> 0x011b }
                com.drew.metadata.bmp.BmpHeaderDirectory$Compression r7 = com.drew.metadata.bmp.BmpHeaderDirectory.Compression.BI_CMYKRLE8     // Catch:{ NoSuchFieldError -> 0x011b }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x011b }
                r8 = 11
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x011b }
            L_0x011b:
                int[] r6 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$Compression     // Catch:{ NoSuchFieldError -> 0x0127 }
                com.drew.metadata.bmp.BmpHeaderDirectory$Compression r7 = com.drew.metadata.bmp.BmpHeaderDirectory.Compression.BI_CMYKRLE4     // Catch:{ NoSuchFieldError -> 0x0127 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0127 }
                r8 = 12
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0127 }
            L_0x0127:
                com.drew.metadata.bmp.BmpHeaderDirectory$BitmapType[] r6 = com.drew.metadata.bmp.BmpHeaderDirectory.BitmapType.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$BitmapType = r6
                com.drew.metadata.bmp.BmpHeaderDirectory$BitmapType r7 = com.drew.metadata.bmp.BmpHeaderDirectory.BitmapType.BITMAP     // Catch:{ NoSuchFieldError -> 0x0138 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0138 }
                r6[r7] = r1     // Catch:{ NoSuchFieldError -> 0x0138 }
            L_0x0138:
                int[] r1 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$BitmapType     // Catch:{ NoSuchFieldError -> 0x0142 }
                com.drew.metadata.bmp.BmpHeaderDirectory$BitmapType r6 = com.drew.metadata.bmp.BmpHeaderDirectory.BitmapType.OS2_BITMAP_ARRAY     // Catch:{ NoSuchFieldError -> 0x0142 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0142 }
                r1[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0142 }
            L_0x0142:
                int[] r0 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$BitmapType     // Catch:{ NoSuchFieldError -> 0x014c }
                com.drew.metadata.bmp.BmpHeaderDirectory$BitmapType r1 = com.drew.metadata.bmp.BmpHeaderDirectory.BitmapType.OS2_COLOR_ICON     // Catch:{ NoSuchFieldError -> 0x014c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x014c }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x014c }
            L_0x014c:
                int[] r0 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$BitmapType     // Catch:{ NoSuchFieldError -> 0x0156 }
                com.drew.metadata.bmp.BmpHeaderDirectory$BitmapType r1 = com.drew.metadata.bmp.BmpHeaderDirectory.BitmapType.OS2_COLOR_POINTER     // Catch:{ NoSuchFieldError -> 0x0156 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0156 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0156 }
            L_0x0156:
                int[] r0 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$BitmapType     // Catch:{ NoSuchFieldError -> 0x0160 }
                com.drew.metadata.bmp.BmpHeaderDirectory$BitmapType r1 = com.drew.metadata.bmp.BmpHeaderDirectory.BitmapType.OS2_ICON     // Catch:{ NoSuchFieldError -> 0x0160 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0160 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0160 }
            L_0x0160:
                int[] r0 = $SwitchMap$com$drew$metadata$bmp$BmpHeaderDirectory$BitmapType     // Catch:{ NoSuchFieldError -> 0x016a }
                com.drew.metadata.bmp.BmpHeaderDirectory$BitmapType r1 = com.drew.metadata.bmp.BmpHeaderDirectory.BitmapType.OS2_POINTER     // Catch:{ NoSuchFieldError -> 0x016a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x016a }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x016a }
            L_0x016a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.drew.metadata.bmp.BmpHeaderDirectory.AnonymousClass1.<clinit>():void");
        }
    }
}
