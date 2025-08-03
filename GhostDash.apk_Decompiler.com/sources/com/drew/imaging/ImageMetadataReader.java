package com.drew.imaging;

import com.drew.imaging.avi.AviMetadataReader;
import com.drew.imaging.bmp.BmpMetadataReader;
import com.drew.imaging.eps.EpsMetadataReader;
import com.drew.imaging.gif.GifMetadataReader;
import com.drew.imaging.ico.IcoMetadataReader;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.mp4.Mp4MetadataReader;
import com.drew.imaging.pcx.PcxMetadataReader;
import com.drew.imaging.png.PngMetadataReader;
import com.drew.imaging.psd.PsdMetadataReader;
import com.drew.imaging.quicktime.QuickTimeMetadataReader;
import com.drew.imaging.raf.RafMetadataReader;
import com.drew.imaging.tiff.TiffMetadataReader;
import com.drew.imaging.wav.WavMetadataReader;
import com.drew.imaging.webp.WebpMetadataReader;
import com.drew.lang.RandomAccessReader;
import com.drew.lang.RandomAccessStreamReader;
import com.drew.lang.StringUtil;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.file.FileSystemMetadataReader;
import com.drew.metadata.file.FileTypeDirectory;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class ImageMetadataReader {
    public static Metadata readMetadata(InputStream inputStream) throws ImageProcessingException, IOException {
        return readMetadata(inputStream, -1);
    }

    public static Metadata readMetadata(InputStream inputStream, long j) throws ImageProcessingException, IOException {
        BufferedInputStream bufferedInputStream = inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream);
        FileType detectFileType = FileTypeDetector.detectFileType(bufferedInputStream);
        Metadata readMetadata = readMetadata(bufferedInputStream, j, detectFileType);
        readMetadata.addDirectory(new FileTypeDirectory(detectFileType));
        return readMetadata;
    }

    /* renamed from: com.drew.imaging.ImageMetadataReader$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$drew$imaging$FileType;

        /* JADX WARNING: Can't wrap try/catch for region: R(42:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|(3:41|42|44)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(44:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|44) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.drew.imaging.FileType[] r0 = com.drew.imaging.FileType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$drew$imaging$FileType = r0
                com.drew.imaging.FileType r1 = com.drew.imaging.FileType.Jpeg     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$drew$imaging$FileType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.drew.imaging.FileType r1 = com.drew.imaging.FileType.Tiff     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$drew$imaging$FileType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.drew.imaging.FileType r1 = com.drew.imaging.FileType.Arw     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$drew$imaging$FileType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.drew.imaging.FileType r1 = com.drew.imaging.FileType.Cr2     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$drew$imaging$FileType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.drew.imaging.FileType r1 = com.drew.imaging.FileType.Nef     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$drew$imaging$FileType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.drew.imaging.FileType r1 = com.drew.imaging.FileType.Orf     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$drew$imaging$FileType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.drew.imaging.FileType r1 = com.drew.imaging.FileType.Rw2     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$drew$imaging$FileType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.drew.imaging.FileType r1 = com.drew.imaging.FileType.Psd     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$drew$imaging$FileType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.drew.imaging.FileType r1 = com.drew.imaging.FileType.Png     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$drew$imaging$FileType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.drew.imaging.FileType r1 = com.drew.imaging.FileType.Bmp     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$drew$imaging$FileType     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.drew.imaging.FileType r1 = com.drew.imaging.FileType.Gif     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$drew$imaging$FileType     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.drew.imaging.FileType r1 = com.drew.imaging.FileType.Ico     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$drew$imaging$FileType     // Catch:{ NoSuchFieldError -> 0x009c }
                com.drew.imaging.FileType r1 = com.drew.imaging.FileType.Pcx     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$drew$imaging$FileType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.drew.imaging.FileType r1 = com.drew.imaging.FileType.WebP     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$drew$imaging$FileType     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.drew.imaging.FileType r1 = com.drew.imaging.FileType.Raf     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$drew$imaging$FileType     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.drew.imaging.FileType r1 = com.drew.imaging.FileType.Avi     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$drew$imaging$FileType     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.drew.imaging.FileType r1 = com.drew.imaging.FileType.Wav     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = $SwitchMap$com$drew$imaging$FileType     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.drew.imaging.FileType r1 = com.drew.imaging.FileType.Mov     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = $SwitchMap$com$drew$imaging$FileType     // Catch:{ NoSuchFieldError -> 0x00e4 }
                com.drew.imaging.FileType r1 = com.drew.imaging.FileType.Mp4     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r0 = $SwitchMap$com$drew$imaging$FileType     // Catch:{ NoSuchFieldError -> 0x00f0 }
                com.drew.imaging.FileType r1 = com.drew.imaging.FileType.Eps     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                int[] r0 = $SwitchMap$com$drew$imaging$FileType     // Catch:{ NoSuchFieldError -> 0x00fc }
                com.drew.imaging.FileType r1 = com.drew.imaging.FileType.Unknown     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.drew.imaging.ImageMetadataReader.AnonymousClass1.<clinit>():void");
        }
    }

    public static Metadata readMetadata(InputStream inputStream, long j, FileType fileType) throws IOException, ImageProcessingException {
        switch (AnonymousClass1.$SwitchMap$com$drew$imaging$FileType[fileType.ordinal()]) {
            case 1:
                return JpegMetadataReader.readMetadata(inputStream);
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return TiffMetadataReader.readMetadata((RandomAccessReader) new RandomAccessStreamReader(inputStream, 2048, j));
            case 8:
                return PsdMetadataReader.readMetadata(inputStream);
            case 9:
                return PngMetadataReader.readMetadata(inputStream);
            case 10:
                return BmpMetadataReader.readMetadata(inputStream);
            case 11:
                return GifMetadataReader.readMetadata(inputStream);
            case 12:
                return IcoMetadataReader.readMetadata(inputStream);
            case 13:
                return PcxMetadataReader.readMetadata(inputStream);
            case 14:
                return WebpMetadataReader.readMetadata(inputStream);
            case 15:
                return RafMetadataReader.readMetadata(inputStream);
            case 16:
                return AviMetadataReader.readMetadata(inputStream);
            case 17:
                return WavMetadataReader.readMetadata(inputStream);
            case 18:
                return QuickTimeMetadataReader.readMetadata(inputStream);
            case 19:
                return Mp4MetadataReader.readMetadata(inputStream);
            case 20:
                return EpsMetadataReader.readMetadata(inputStream);
            case 21:
                throw new ImageProcessingException("File format could not be determined");
            default:
                return new Metadata();
        }
    }

    /* JADX INFO: finally extract failed */
    public static Metadata readMetadata(File file) throws ImageProcessingException, IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            Metadata readMetadata = readMetadata(fileInputStream, file.length());
            fileInputStream.close();
            new FileSystemMetadataReader().read(file, readMetadata);
            return readMetadata;
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }

    private ImageMetadataReader() throws Exception {
        throw new Exception("Not intended for instantiation");
    }

    public static void main(String[] strArr) throws MetadataException, IOException {
        String str;
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(strArr));
        boolean remove = arrayList.remove("-markdown");
        boolean remove2 = arrayList.remove("-hex");
        if (arrayList.size() < 1) {
            String implementationVersion = ImageMetadataReader.class.getPackage().getImplementationVersion();
            System.out.println("metadata-extractor version " + implementationVersion);
            System.out.println();
            PrintStream printStream = System.out;
            Object[] objArr = new Object[1];
            if (implementationVersion == null) {
                implementationVersion = "a.b.c";
            }
            objArr[0] = implementationVersion;
            printStream.println(String.format("Usage: java -jar metadata-extractor-%s.jar <filename> [<filename>] [-thumb] [-markdown] [-hex]", objArr));
            System.exit(1);
        }
        for (String str2 : arrayList) {
            long nanoTime = System.nanoTime();
            File file = new File(str2);
            if (!remove && arrayList.size() > 1) {
                System.out.printf("\n***** PROCESSING: %s%n%n", new Object[]{str2});
            }
            Metadata metadata = null;
            try {
                metadata = readMetadata(file);
            } catch (Exception e) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
            long nanoTime2 = System.nanoTime() - nanoTime;
            if (!remove) {
                System.out.printf("Processed %.3f MB file in %.2f ms%n%n", new Object[]{Double.valueOf(((double) file.length()) / 1048576.0d), Double.valueOf(((double) nanoTime2) / 1000000.0d)});
            }
            if (remove) {
                String name = file.getName();
                String urlEncode = StringUtil.urlEncode(str2);
                ExifIFD0Directory exifIFD0Directory = (ExifIFD0Directory) metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
                String str3 = "";
                if (exifIFD0Directory == null) {
                    str = str3;
                } else {
                    str = exifIFD0Directory.getString(271);
                }
                if (exifIFD0Directory != null) {
                    str3 = exifIFD0Directory.getString(272);
                }
                System.out.println();
                System.out.println("---");
                System.out.println();
                System.out.printf("# %s - %s%n", new Object[]{str, str3});
                System.out.println();
                System.out.printf("<a href=\"https://raw.githubusercontent.com/drewnoakes/metadata-extractor-images/master/%s\">%n", new Object[]{urlEncode});
                System.out.printf("<img src=\"https://raw.githubusercontent.com/drewnoakes/metadata-extractor-images/master/%s\" width=\"300\"/><br/>%n", new Object[]{urlEncode});
                System.out.println(name);
                System.out.println("</a>");
                System.out.println();
                System.out.println("Directory | Tag Id | Tag Name | Extracted Value");
                System.out.println(":--------:|-------:|----------|----------------");
            }
            for (Directory next : metadata.getDirectories()) {
                String name2 = next.getName();
                for (Tag next2 : next.getTags()) {
                    String tagName = next2.getTagName();
                    String description = next2.getDescription();
                    if (description != null && description.length() > 1024) {
                        description = description.substring(0, 1024) + "...";
                    }
                    if (remove) {
                        System.out.printf("%s|0x%s|%s|%s%n", new Object[]{name2, Integer.toHexString(next2.getTagType()), tagName, description});
                    } else if (remove2) {
                        System.out.printf("[%s - %s] %s = %s%n", new Object[]{name2, next2.getTagTypeHex(), tagName, description});
                    } else {
                        System.out.printf("[%s] %s = %s%n", new Object[]{name2, tagName, description});
                    }
                }
                for (String str4 : next.getErrors()) {
                    System.err.println("ERROR: " + str4);
                }
            }
        }
    }
}
