package org.spongycastle.apache.bzip2;

import androidx.core.app.FrameMetricsAggregator;
import androidx.room.RoomDatabase;
import com.adobe.xmp.XMPError;
import com.drew.metadata.exif.ExifDirectoryBase;
import com.drew.metadata.exif.makernotes.CanonMakernoteDirectory;
import com.drew.metadata.exif.makernotes.LeicaMakernoteDirectory;
import com.drew.metadata.exif.makernotes.OlympusFocusInfoMakernoteDirectory;
import com.drew.metadata.exif.makernotes.OlympusMakernoteDirectory;
import com.drew.metadata.exif.makernotes.OlympusRawInfoMakernoteDirectory;
import com.drew.metadata.iptc.IptcDirectory;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import com.google.zxing.pdf417.PDF417Common;
import com.yalantis.ucrop.view.CropImageView;
import org.spongycastle.asn1.eac.CertificateBody;
import org.spongycastle.crypto.tls.CipherSuite;

public interface BZip2Constants {
    public static final int G_SIZE = 50;
    public static final int MAX_ALPHA_SIZE = 258;
    public static final int MAX_CODE_LEN = 23;
    public static final int MAX_SELECTORS = 18002;
    public static final int NUM_OVERSHOOT_BYTES = 20;
    public static final int N_GROUPS = 6;
    public static final int N_ITERS = 4;
    public static final int RUNA = 0;
    public static final int RUNB = 1;
    public static final int baseBlockSize = 100000;
    public static final int[] rNums = {619, 720, CertificateBody.profileType, 481, 931, LeicaMakernoteDirectory.TAG_CCD_VERSION, 813, 233, 566, 247, 985, 724, 205, 454, 863, 491, 741, 242, 949, 214, 733, 859, 335, 708, 621, IptcDirectory.TAG_DIGITAL_DATE_CREATED, 73, 654, 730, 472, 419, 436, 278, 496, 867, 210, 399, 680, 480, 51, 878, 465, 811, 169, 869, 675, 611, IptcDirectory.TAG_MASTER_DOCUMENT_ID, 867, 561, 862, 687, 507, 283, 482, 129, 807, 591, 733, 623, 150, 238, 59, 379, 684, 877, 625, 169, IptcDirectory.TAG_IMAGE_ORIENTATION, 105, 170, IptcDirectory.TAG_PROVINCE_OR_STATE, 520, 932, 727, 476, 693, 425, 174, IptcDirectory.TAG_LANGUAGE_IDENTIFIER, 73, 122, 335, 530, 442, 853, 695, 249, 445, 515, 909, 545, 703, 919, 874, 474, 882, CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, 594, IptcDirectory.TAG_COUNTRY_OR_PRIMARY_LOCATION_CODE, 641, LeicaMakernoteDirectory.TAG_COLOR_TEMPERATURE, 220, 162, LeicaMakernoteDirectory.TAG_M16_C_VERSION, 984, 589, 513, 495, 799, 161, IptcDirectory.TAG_SUB_LOCATION, 958, 533, 221, StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB, 386, 867, 600, 782, 382, 596, 414, 171, 516, 375, 682, 485, 911, 276, 98, 553, 163, 354, IptcDirectory.TAG_AUDIO_OUTCUE, 933, 424, 341, 533, 870, 227, 730, 475, CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256, 263, IptcDirectory.TAG_LANGUAGE_IDENTIFIER, 537, 686, 600, CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY, 469, 68, 770, 919, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA256, 373, 294, 822, OlympusFocusInfoMakernoteDirectory.TagAfInfo, 206, 184, 943, 795, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 383, 461, 404, 758, 839, 887, 715, 67, 618, 276, XMPError.BADSTREAM, 918, 873, 777, IptcDirectory.TAG_SUB_LOCATION, 560, 951, 160, 578, 722, 79, LeicaMakernoteDirectory.TAG_WB_BLUE_LEVEL, 96, 409, IptcDirectory.TAG_OBJECT_PREVIEW_FILE_FORMAT_VERSION, 940, 652, 934, 970, 447, ExifDirectoryBase.TAG_WHITE_POINT, 353, 859, 672, 112, 785, 645, 863, LeicaMakernoteDirectory.TAG_WB_GREEN_LEVEL, 350, 139, 93, 354, 99, 820, 908, 609, 772, 154, 274, 580, 184, 79, 626, IptcDirectory.TAG_CONTACT, 742, 653, 282, 762, 623, 680, 81, 927, 626, 789, 125, 411, 521, 938, 300, 821, 78, 343, 175, 128, 250, 170, 774, 972, 275, RoomDatabase.MAX_BIND_PARAMETER_CNT, 639, 495, 78, 352, 126, 857, 956, 358, 619, 580, 124, 737, 594, 701, IptcDirectory.TAG_COUNTRY_OR_PRIMARY_LOCATION_CODE, 669, 112, 134, 694, 363, 992, 809, 743, 168, 974, 944, 375, 748, 52, 600, 747, IptcDirectory.TAG_IMAGE_TYPE, 182, 862, 81, 344, 805, 988, 739, FrameMetricsAggregator.EVERY_DURATION, 655, 814, 334, 249, 515, 897, 955, IptcDirectory.TAG_AUDIO_SAMPLING_RESOLUTION, 981, 649, 113, 974, 459, 893, 228, 433, 837, 553, 268, 926, 240, 102, 654, 459, 51, 686, 754, 806, 760, 493, 403, 415, 394, 687, 700, 946, 670, 656, 610, 738, 392, 760, 799, 887, 653, 978, 321, 576, IptcDirectory.TAG_HEADLINE, 626, 502, 894, 679, 243, 440, 680, 879, CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA256, IptcDirectory.TAG_TIME_CREATED, OlympusMakernoteDirectory.TAG_PREVIEW_IMAGE, 724, 926, 56, XMPError.BADSTREAM, 700, 707, 151, 457, 449, 797, CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA256, 791, 558, 945, 679, ExifDirectoryBase.TAG_PAGE_NUMBER, 59, 87, 824, IptcDirectory.TAG_OBJECT_PREVIEW_FILE_FORMAT_VERSION, IptcDirectory.TAG_AUDIO_SAMPLING_RATE, 412, 693, ExifDirectoryBase.TAG_TRANSFER_RANGE, 606, 134, 108, 571, 364, 631, 212, 174, IptcDirectory.TAG_IMAGE_ORIENTATION, OlympusRawInfoMakernoteDirectory.TagWbRbLevelsDaylightFluor, 329, 343, 97, 430, 751, 497, 314, 983, 374, 822, PDF417Common.MAX_CODEWORDS_IN_BARCODE, 140, 206, 73, 263, 980, 736, 876, 478, 430, 305, 170, 514, 364, 692, 829, 82, 855, 953, 676, 246, 369, 970, 294, 750, 807, 827, 150, 790, 288, 923, LeicaMakernoteDirectory.TAG_WB_BLUE_LEVEL, IptcDirectory.TAG_ARM_VERSION, JfifUtil.MARKER_RST7, 828, IptcDirectory.TAG_BY_LINE, 281, 565, 555, 710, 82, 896, 831, 547, 261, 524, 462, 293, 465, 502, 56, 661, 821, 976, 991, 658, 869, 905, 758, 745, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256, 768, IptcDirectory.TAG_EXPIRATION_TIME, 608, 933, IptcDirectory.TAG_ARM_VERSION, 286, JfifUtil.MARKER_RST7, 979, 792, 961, 61, 688, 793, 644, 986, 403, 106, 366, 905, 644, 372, IptcDirectory.TAG_DATE_CREATED, 466, 434, 645, 210, 389, IptcDirectory.TAG_EXPIRATION_TIME, 919, 135, 780, 773, 635, 389, 707, 100, 626, 958, 165, 504, 920, 176, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256, IptcDirectory.TAG_OBJECT_PREVIEW_FILE_FORMAT_VERSION, 857, 265, XMPError.BADXMP, 50, 668, 108, 645, 990, 626, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA256, 510, 357, 358, 850, 858, 364, 936, 638};
}
