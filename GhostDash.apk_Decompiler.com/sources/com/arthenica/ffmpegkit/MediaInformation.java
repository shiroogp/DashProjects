package com.arthenica.ffmpegkit;

import java.util.List;
import org.json.JSONObject;

public class MediaInformation {
    public static final String KEY_BIT_RATE = "bit_rate";
    public static final String KEY_DURATION = "duration";
    public static final String KEY_FILENAME = "filename";
    public static final String KEY_FORMAT = "format_name";
    public static final String KEY_FORMAT_LONG = "format_long_name";
    public static final String KEY_MEDIA_PROPERTIES = "format";
    public static final String KEY_SIZE = "size";
    public static final String KEY_START_TIME = "start_time";
    public static final String KEY_TAGS = "tags";
    private final List<Chapter> chapters;
    private final JSONObject jsonObject;
    private final List<StreamInformation> streams;

    public MediaInformation(JSONObject jSONObject, List<StreamInformation> list, List<Chapter> list2) {
        this.jsonObject = jSONObject;
        this.streams = list;
        this.chapters = list2;
    }

    public String getFilename() {
        return getStringProperty(KEY_FILENAME);
    }

    public String getFormat() {
        return getStringProperty(KEY_FORMAT);
    }

    public String getLongFormat() {
        return getStringProperty(KEY_FORMAT_LONG);
    }

    public String getDuration() {
        return getStringProperty("duration");
    }

    public String getStartTime() {
        return getStringProperty("start_time");
    }

    public String getSize() {
        return getStringProperty("size");
    }

    public String getBitrate() {
        return getStringProperty("bit_rate");
    }

    public JSONObject getTags() {
        return getProperties("tags");
    }

    public List<StreamInformation> getStreams() {
        return this.streams;
    }

    public List<Chapter> getChapters() {
        return this.chapters;
    }

    public String getStringProperty(String str) {
        JSONObject mediaProperties = getMediaProperties();
        if (mediaProperties != null && mediaProperties.has(str)) {
            return mediaProperties.optString(str);
        }
        return null;
    }

    public Long getNumberProperty(String str) {
        JSONObject mediaProperties = getMediaProperties();
        if (mediaProperties != null && mediaProperties.has(str)) {
            return Long.valueOf(mediaProperties.optLong(str));
        }
        return null;
    }

    public JSONObject getProperties(String str) {
        JSONObject mediaProperties = getMediaProperties();
        if (mediaProperties == null) {
            return null;
        }
        return mediaProperties.optJSONObject(str);
    }

    public JSONObject getMediaProperties() {
        return this.jsonObject.optJSONObject(KEY_MEDIA_PROPERTIES);
    }

    public JSONObject getAllProperties() {
        return this.jsonObject;
    }
}
