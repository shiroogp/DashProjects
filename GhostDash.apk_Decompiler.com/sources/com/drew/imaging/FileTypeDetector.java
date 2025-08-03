package com.drew.imaging;

import com.drew.lang.ByteTrie;
import com.drew.metadata.avi.AviDirectory;
import com.drew.metadata.wav.WavDirectory;
import com.drew.metadata.webp.WebpDirectory;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.HashMap;
import org.spongycastle.bcpg.sig.RevocationReasonTags;

public class FileTypeDetector {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final HashMap<String, FileType> _ftypMap;
    private static final ByteTrie<FileType> _root;

    static {
        ByteTrie<FileType> byteTrie = new ByteTrie<>();
        _root = byteTrie;
        byteTrie.setDefaultValue(FileType.Unknown);
        byteTrie.addPath(FileType.Jpeg, new byte[]{-1, -40});
        byteTrie.addPath(FileType.Tiff, "II".getBytes(), new byte[]{42, 0});
        byteTrie.addPath(FileType.Tiff, "MM".getBytes(), new byte[]{0, 42});
        byteTrie.addPath(FileType.Psd, "8BPS".getBytes());
        byteTrie.addPath(FileType.Png, new byte[]{-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82});
        byteTrie.addPath(FileType.Bmp, "BM".getBytes());
        byteTrie.addPath(FileType.Bmp, "BA".getBytes());
        byteTrie.addPath(FileType.Bmp, "CI".getBytes());
        byteTrie.addPath(FileType.Bmp, "CP".getBytes());
        byteTrie.addPath(FileType.Bmp, "IC".getBytes());
        byteTrie.addPath(FileType.Bmp, "PT".getBytes());
        byteTrie.addPath(FileType.Gif, "GIF87a".getBytes());
        byteTrie.addPath(FileType.Gif, "GIF89a".getBytes());
        byteTrie.addPath(FileType.Ico, new byte[]{0, 0, 1, 0});
        byteTrie.addPath(FileType.Pcx, new byte[]{10, 0, 1});
        byteTrie.addPath(FileType.Pcx, new byte[]{10, 2, 1});
        byteTrie.addPath(FileType.Pcx, new byte[]{10, 3, 1});
        byteTrie.addPath(FileType.Pcx, new byte[]{10, 5, 1});
        byteTrie.addPath(FileType.Riff, "RIFF".getBytes());
        byteTrie.addPath(FileType.Arw, "II".getBytes(), new byte[]{42, 0, 8, 0});
        byteTrie.addPath(FileType.Crw, "II".getBytes(), new byte[]{26, 0, 0, 0}, "HEAPCCDR".getBytes());
        byteTrie.addPath(FileType.Cr2, "II".getBytes(), new byte[]{42, 0, Tnaf.POW_2_WIDTH, 0, 0, 0, 67, 82});
        byteTrie.addPath(FileType.Orf, "IIRO".getBytes(), new byte[]{8, 0});
        byteTrie.addPath(FileType.Orf, "MMOR".getBytes(), new byte[]{0, 0});
        byteTrie.addPath(FileType.Orf, "IIRS".getBytes(), new byte[]{8, 0});
        byteTrie.addPath(FileType.Raf, "FUJIFILMCCD-RAW".getBytes());
        byteTrie.addPath(FileType.Rw2, "II".getBytes(), new byte[]{85, 0});
        byteTrie.addPath(FileType.Eps, "%!PS".getBytes());
        byteTrie.addPath(FileType.Eps, new byte[]{-59, -48, -45, -58});
        HashMap<String, FileType> hashMap = new HashMap<>();
        _ftypMap = hashMap;
        hashMap.put("ftypmoov", FileType.Mov);
        hashMap.put("ftypwide", FileType.Mov);
        hashMap.put("ftypmdat", FileType.Mov);
        hashMap.put("ftypfree", FileType.Mov);
        hashMap.put("ftypqt  ", FileType.Mov);
        hashMap.put("ftypavc1", FileType.Mp4);
        hashMap.put("ftypiso2", FileType.Mp4);
        hashMap.put("ftypisom", FileType.Mp4);
        hashMap.put("ftypM4A ", FileType.Mp4);
        hashMap.put("ftypM4B ", FileType.Mp4);
        hashMap.put("ftypM4P ", FileType.Mp4);
        hashMap.put("ftypM4V ", FileType.Mp4);
        hashMap.put("ftypM4VH", FileType.Mp4);
        hashMap.put("ftypM4VP", FileType.Mp4);
        hashMap.put("ftypmmp4", FileType.Mp4);
        hashMap.put("ftypmp41", FileType.Mp4);
        hashMap.put("ftypmp42", FileType.Mp4);
        hashMap.put("ftypmp71", FileType.Mp4);
        hashMap.put("ftypMSNV", FileType.Mp4);
        hashMap.put("ftypNDAS", FileType.Mp4);
        hashMap.put("ftypNDSC", FileType.Mp4);
        hashMap.put("ftypNDSH", FileType.Mp4);
        hashMap.put("ftypNDSM", FileType.Mp4);
        hashMap.put("ftypNDSP", FileType.Mp4);
        hashMap.put("ftypNDSS", FileType.Mp4);
        hashMap.put("ftypNDXC", FileType.Mp4);
        hashMap.put("ftypNDXH", FileType.Mp4);
        hashMap.put("ftypNDXM", FileType.Mp4);
        hashMap.put("ftypNDXP", FileType.Mp4);
        hashMap.put("ftypNDXS", FileType.Mp4);
        hashMap.put("ftypmif1", FileType.Heif);
        hashMap.put("ftypmsf1", FileType.Heif);
        hashMap.put("ftypheic", FileType.Heif);
        hashMap.put("ftypheix", FileType.Heif);
        hashMap.put("ftyphevc", FileType.Heif);
        hashMap.put("ftyphevx", FileType.Heif);
        byteTrie.addPath(FileType.Aac, new byte[]{-1, -15});
        byteTrie.addPath(FileType.Aac, new byte[]{-1, -7});
        byteTrie.addPath(FileType.Asf, new byte[]{48, 38, -78, 117, -114, 102, -49, 17, -90, -39, 0, -86, 0, 98, -50, 108});
        byteTrie.addPath(FileType.Cfbf, new byte[]{-48, -49, 17, -32, -95, -79, 26, -31, 0});
        byteTrie.addPath(FileType.Flv, new byte[]{70, 76, 86});
        byteTrie.addPath(FileType.Indd, new byte[]{6, 6, -19, -11, -40, 29, 70, -27, -67, 49, -17, -25, -2, 116, -73, 29});
        byteTrie.addPath(FileType.Mxf, new byte[]{6, 14, 43, 52, 2, 5, 1, 1, 13, 1, 2, 1, 1, 2});
        byteTrie.addPath(FileType.Qxp, new byte[]{0, 0, 73, 73, 88, 80, 82, 51});
        byteTrie.addPath(FileType.Qxp, new byte[]{0, 0, 77, 77, 88, 80, 82, 51});
        byteTrie.addPath(FileType.Ram, new byte[]{114, 116, 115, 112, 58, 47, 47});
        byteTrie.addPath(FileType.Rtf, new byte[]{123, 92, 114, 116, 102, 49});
        byteTrie.addPath(FileType.Sit, new byte[]{83, 73, 84, 33, 0});
        byteTrie.addPath(FileType.Sit, new byte[]{83, 116, 117, 102, 102, 73, 116, RevocationReasonTags.USER_NO_LONGER_VALID, 40, 99, 41, 49, 57, 57, 55, 45});
        byteTrie.addPath(FileType.Sitx, new byte[]{83, 116, 117, 102, 102, 73, 116, 33});
        byteTrie.addPath(FileType.Swf, "CWS".getBytes());
        byteTrie.addPath(FileType.Swf, "FWS".getBytes());
        byteTrie.addPath(FileType.Swf, "ZWS".getBytes());
        byteTrie.addPath(FileType.Vob, new byte[]{0, 0, 1, -70});
        byteTrie.addPath(FileType.Zip, "PK".getBytes());
    }

    private FileTypeDetector() throws Exception {
        throw new Exception("Not intended for instantiation");
    }

    public static FileType detectFileType(BufferedInputStream bufferedInputStream) throws IOException {
        if (bufferedInputStream.markSupported()) {
            ByteTrie<FileType> byteTrie = _root;
            int max = Math.max(16, byteTrie.getMaxDepth());
            bufferedInputStream.mark(max);
            byte[] bArr = new byte[max];
            if (bufferedInputStream.read(bArr) != -1) {
                bufferedInputStream.reset();
                FileType find = byteTrie.find(bArr);
                if (find == FileType.Unknown) {
                    FileType fileType = _ftypMap.get(new String(bArr, 4, 8));
                    if (fileType != null) {
                        return fileType;
                    }
                    return find;
                } else if (find != FileType.Riff) {
                    return find;
                } else {
                    String str = new String(bArr, 8, 4);
                    if (str.equals(WavDirectory.FORMAT)) {
                        return FileType.Wav;
                    }
                    if (str.equals(AviDirectory.FORMAT)) {
                        return FileType.Avi;
                    }
                    if (str.equals(WebpDirectory.FORMAT)) {
                        return FileType.WebP;
                    }
                    return find;
                }
            } else {
                throw new IOException("Stream ended before file's magic number could be determined.");
            }
        } else {
            throw new IOException("Stream must support mark/reset");
        }
    }
}
