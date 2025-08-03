package com.drew.metadata.iptc;

import com.drew.metadata.Directory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class IptcDirectory extends Directory {
    public static final int TAG_ACTION_ADVISED = 554;
    public static final int TAG_APPLICATION_RECORD_VERSION = 512;
    public static final int TAG_ARM_IDENTIFIER = 376;
    public static final int TAG_ARM_VERSION = 378;
    public static final int TAG_AUDIO_DURATION = 665;
    public static final int TAG_AUDIO_OUTCUE = 666;
    public static final int TAG_AUDIO_SAMPLING_RATE = 663;
    public static final int TAG_AUDIO_SAMPLING_RESOLUTION = 664;
    public static final int TAG_AUDIO_TYPE = 662;
    public static final int TAG_BY_LINE = 592;
    public static final int TAG_BY_LINE_TITLE = 597;
    public static final int TAG_CAPTION = 632;
    public static final int TAG_CAPTION_WRITER = 634;
    public static final int TAG_CATEGORY = 527;
    public static final int TAG_CITY = 602;
    public static final int TAG_CODED_CHARACTER_SET = 346;
    public static final int TAG_CONTACT = 630;
    public static final int TAG_CONTENT_LOCATION_CODE = 538;
    public static final int TAG_CONTENT_LOCATION_NAME = 539;
    public static final int TAG_COPYRIGHT_NOTICE = 628;
    public static final int TAG_COUNTRY_OR_PRIMARY_LOCATION_CODE = 612;
    public static final int TAG_COUNTRY_OR_PRIMARY_LOCATION_NAME = 613;
    public static final int TAG_CREDIT = 622;
    public static final int TAG_DATE_CREATED = 567;
    public static final int TAG_DATE_SENT = 326;
    public static final int TAG_DESTINATION = 261;
    public static final int TAG_DIGITAL_DATE_CREATED = 574;
    public static final int TAG_DIGITAL_TIME_CREATED = 575;
    public static final int TAG_EDITORIAL_UPDATE = 520;
    public static final int TAG_EDIT_STATUS = 519;
    public static final int TAG_ENVELOPE_NUMBER = 296;
    public static final int TAG_ENVELOPE_PRIORITY = 316;
    public static final int TAG_ENVELOPE_RECORD_VERSION = 256;
    public static final int TAG_EXPIRATION_DATE = 549;
    public static final int TAG_EXPIRATION_TIME = 550;
    public static final int TAG_FILE_FORMAT = 276;
    public static final int TAG_FILE_VERSION = 278;
    public static final int TAG_FIXTURE_ID = 534;
    public static final int TAG_HEADLINE = 617;
    public static final int TAG_IMAGE_ORIENTATION = 643;
    public static final int TAG_IMAGE_TYPE = 642;
    public static final int TAG_JOB_ID = 696;
    public static final int TAG_KEYWORDS = 537;
    public static final int TAG_LANGUAGE_IDENTIFIER = 647;
    public static final int TAG_LOCAL_CAPTION = 633;
    public static final int TAG_MASTER_DOCUMENT_ID = 697;
    public static final int TAG_OBJECT_ATTRIBUTE_REFERENCE = 516;
    public static final int TAG_OBJECT_CYCLE = 587;
    public static final int TAG_OBJECT_NAME = 517;
    public static final int TAG_OBJECT_PREVIEW_DATA = 714;
    public static final int TAG_OBJECT_PREVIEW_FILE_FORMAT = 712;
    public static final int TAG_OBJECT_PREVIEW_FILE_FORMAT_VERSION = 713;
    public static final int TAG_OBJECT_TYPE_REFERENCE = 515;
    public static final int TAG_ORIGINAL_TRANSMISSION_REFERENCE = 615;
    public static final int TAG_ORIGINATING_PROGRAM = 577;
    public static final int TAG_OWNER_ID = 700;
    public static final int TAG_PRODUCT_ID = 306;
    public static final int TAG_PROGRAM_VERSION = 582;
    public static final int TAG_PROVINCE_OR_STATE = 607;
    public static final int TAG_RASTERIZED_CAPTION = 637;
    public static final int TAG_REFERENCE_DATE = 559;
    public static final int TAG_REFERENCE_NUMBER = 562;
    public static final int TAG_REFERENCE_SERVICE = 557;
    public static final int TAG_RELEASE_DATE = 542;
    public static final int TAG_RELEASE_TIME = 547;
    public static final int TAG_SERVICE_ID = 286;
    public static final int TAG_SHORT_DOCUMENT_ID = 698;
    public static final int TAG_SOURCE = 627;
    public static final int TAG_SPECIAL_INSTRUCTIONS = 552;
    public static final int TAG_SUBJECT_REFERENCE = 524;
    public static final int TAG_SUB_LOCATION = 604;
    public static final int TAG_SUPPLEMENTAL_CATEGORIES = 532;
    public static final int TAG_TIME_CREATED = 572;
    public static final int TAG_TIME_SENT = 336;
    public static final int TAG_UNIQUE_DOCUMENT_ID = 699;
    public static final int TAG_UNIQUE_OBJECT_NAME = 356;
    public static final int TAG_URGENCY = 522;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "IPTC";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        hashMap.put(256, "Enveloped Record Version");
        hashMap.put(261, "Destination");
        hashMap.put(276, "File Format");
        hashMap.put(278, "File Version");
        hashMap.put(286, "Service Identifier");
        hashMap.put(296, "Envelope Number");
        hashMap.put(306, "Product Identifier");
        hashMap.put(316, "Envelope Priority");
        hashMap.put(Integer.valueOf(TAG_DATE_SENT), "Date Sent");
        hashMap.put(Integer.valueOf(TAG_TIME_SENT), "Time Sent");
        hashMap.put(Integer.valueOf(TAG_CODED_CHARACTER_SET), "Coded Character Set");
        hashMap.put(Integer.valueOf(TAG_UNIQUE_OBJECT_NAME), "Unique Object Name");
        hashMap.put(Integer.valueOf(TAG_ARM_IDENTIFIER), "ARM Identifier");
        hashMap.put(Integer.valueOf(TAG_ARM_VERSION), "ARM Version");
        hashMap.put(512, "Application Record Version");
        hashMap.put(515, "Object Type Reference");
        hashMap.put(516, "Object Attribute Reference");
        hashMap.put(517, "Object Name");
        hashMap.put(519, "Edit Status");
        hashMap.put(520, "Editorial Update");
        hashMap.put(522, "Urgency");
        hashMap.put(524, "Subject Reference");
        hashMap.put(527, "Category");
        hashMap.put(532, "Supplemental Category(s)");
        hashMap.put(534, "Fixture Identifier");
        hashMap.put(537, "Keywords");
        hashMap.put(Integer.valueOf(TAG_CONTENT_LOCATION_CODE), "Content Location Code");
        hashMap.put(539, "Content Location Name");
        hashMap.put(542, "Release Date");
        hashMap.put(547, "Release Time");
        hashMap.put(549, "Expiration Date");
        hashMap.put(Integer.valueOf(TAG_EXPIRATION_TIME), "Expiration Time");
        hashMap.put(Integer.valueOf(TAG_SPECIAL_INSTRUCTIONS), "Special Instructions");
        hashMap.put(Integer.valueOf(TAG_ACTION_ADVISED), "Action Advised");
        hashMap.put(Integer.valueOf(TAG_REFERENCE_SERVICE), "Reference Service");
        hashMap.put(559, "Reference Date");
        hashMap.put(Integer.valueOf(TAG_REFERENCE_NUMBER), "Reference Number");
        hashMap.put(Integer.valueOf(TAG_DATE_CREATED), "Date Created");
        hashMap.put(Integer.valueOf(TAG_TIME_CREATED), "Time Created");
        hashMap.put(Integer.valueOf(TAG_DIGITAL_DATE_CREATED), "Digital Date Created");
        hashMap.put(Integer.valueOf(TAG_DIGITAL_TIME_CREATED), "Digital Time Created");
        hashMap.put(Integer.valueOf(TAG_ORIGINATING_PROGRAM), "Originating Program");
        hashMap.put(Integer.valueOf(TAG_PROGRAM_VERSION), "Program Version");
        hashMap.put(Integer.valueOf(TAG_OBJECT_CYCLE), "Object Cycle");
        hashMap.put(Integer.valueOf(TAG_BY_LINE), "By-line");
        hashMap.put(Integer.valueOf(TAG_BY_LINE_TITLE), "By-line Title");
        hashMap.put(Integer.valueOf(TAG_CITY), "City");
        hashMap.put(Integer.valueOf(TAG_SUB_LOCATION), "Sub-location");
        hashMap.put(Integer.valueOf(TAG_PROVINCE_OR_STATE), "Province/State");
        hashMap.put(Integer.valueOf(TAG_COUNTRY_OR_PRIMARY_LOCATION_CODE), "Country/Primary Location Code");
        hashMap.put(Integer.valueOf(TAG_COUNTRY_OR_PRIMARY_LOCATION_NAME), "Country/Primary Location Name");
        hashMap.put(Integer.valueOf(TAG_ORIGINAL_TRANSMISSION_REFERENCE), "Original Transmission Reference");
        hashMap.put(Integer.valueOf(TAG_HEADLINE), "Headline");
        hashMap.put(Integer.valueOf(TAG_CREDIT), "Credit");
        hashMap.put(Integer.valueOf(TAG_SOURCE), "Source");
        hashMap.put(Integer.valueOf(TAG_COPYRIGHT_NOTICE), "Copyright Notice");
        hashMap.put(Integer.valueOf(TAG_CONTACT), "Contact");
        hashMap.put(Integer.valueOf(TAG_CAPTION), "Caption/Abstract");
        hashMap.put(Integer.valueOf(TAG_LOCAL_CAPTION), "Local Caption");
        hashMap.put(Integer.valueOf(TAG_CAPTION_WRITER), "Caption Writer/Editor");
        hashMap.put(Integer.valueOf(TAG_RASTERIZED_CAPTION), "Rasterized Caption");
        hashMap.put(Integer.valueOf(TAG_IMAGE_TYPE), "Image Type");
        hashMap.put(Integer.valueOf(TAG_IMAGE_ORIENTATION), "Image Orientation");
        hashMap.put(Integer.valueOf(TAG_LANGUAGE_IDENTIFIER), "Language Identifier");
        hashMap.put(Integer.valueOf(TAG_AUDIO_TYPE), "Audio Type");
        hashMap.put(Integer.valueOf(TAG_AUDIO_SAMPLING_RATE), "Audio Sampling Rate");
        hashMap.put(Integer.valueOf(TAG_AUDIO_SAMPLING_RESOLUTION), "Audio Sampling Resolution");
        hashMap.put(Integer.valueOf(TAG_AUDIO_DURATION), "Audio Duration");
        hashMap.put(Integer.valueOf(TAG_AUDIO_OUTCUE), "Audio Outcue");
        hashMap.put(Integer.valueOf(TAG_JOB_ID), "Job Identifier");
        hashMap.put(Integer.valueOf(TAG_MASTER_DOCUMENT_ID), "Master Document Identifier");
        hashMap.put(Integer.valueOf(TAG_SHORT_DOCUMENT_ID), "Short Document Identifier");
        hashMap.put(Integer.valueOf(TAG_UNIQUE_DOCUMENT_ID), "Unique Document Identifier");
        hashMap.put(700, "Owner Identifier");
        hashMap.put(Integer.valueOf(TAG_OBJECT_PREVIEW_FILE_FORMAT), "Object Data Preview File Format");
        hashMap.put(Integer.valueOf(TAG_OBJECT_PREVIEW_FILE_FORMAT_VERSION), "Object Data Preview File Format Version");
        hashMap.put(Integer.valueOf(TAG_OBJECT_PREVIEW_DATA), "Object Data Preview Data");
    }

    public IptcDirectory() {
        setDescriptor(new IptcDescriptor(this));
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }

    public List<String> getKeywords() {
        String[] stringArray = getStringArray(537);
        if (stringArray == null) {
            return null;
        }
        return Arrays.asList(stringArray);
    }

    public Date getDateSent() {
        return getDate(TAG_DATE_SENT, TAG_TIME_SENT);
    }

    public Date getReleaseDate() {
        return getDate(542, 547);
    }

    public Date getExpirationDate() {
        return getDate(549, TAG_EXPIRATION_TIME);
    }

    public Date getDateCreated() {
        return getDate(TAG_DATE_CREATED, TAG_TIME_CREATED);
    }

    public Date getDigitalDateCreated() {
        return getDate(TAG_DIGITAL_DATE_CREATED, TAG_DIGITAL_TIME_CREATED);
    }

    private Date getDate(int i, int i2) {
        String string = getString(i);
        String string2 = getString(i2);
        if (string == null || string2 == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyyMMddHHmmssZ").parse(string + string2);
        } catch (ParseException unused) {
            return null;
        }
    }
}
