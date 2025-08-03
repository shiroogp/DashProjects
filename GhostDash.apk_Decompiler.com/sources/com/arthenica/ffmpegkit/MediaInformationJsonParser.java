package com.arthenica.ffmpegkit;

import android.util.Log;
import com.arthenica.smartexception.java.Exceptions;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaInformationJsonParser {
    public static final String KEY_CHAPTERS = "chapters";
    public static final String KEY_STREAMS = "streams";

    public static MediaInformation from(String str) {
        try {
            return fromWithError(str);
        } catch (JSONException e) {
            Log.e("ffmpeg-kit", String.format("MediaInformation parsing failed.%s", new Object[]{Exceptions.getStackTraceString(e)}));
            return null;
        }
    }

    public static MediaInformation fromWithError(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        JSONArray optJSONArray = jSONObject.optJSONArray(KEY_STREAMS);
        JSONArray optJSONArray2 = jSONObject.optJSONArray(KEY_CHAPTERS);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (optJSONArray != null && i2 < optJSONArray.length()) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                arrayList.add(new StreamInformation(optJSONObject));
            }
            i2++;
        }
        ArrayList arrayList2 = new ArrayList();
        while (optJSONArray2 != null && i < optJSONArray2.length()) {
            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i);
            if (optJSONObject2 != null) {
                arrayList2.add(new Chapter(optJSONObject2));
            }
            i++;
        }
        return new MediaInformation(jSONObject, arrayList, arrayList2);
    }
}
