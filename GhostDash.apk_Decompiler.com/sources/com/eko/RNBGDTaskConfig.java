package com.eko;

import com.tonyodev.fetch2.util.FetchDefaults;
import java.io.Serializable;

public class RNBGDTaskConfig implements Serializable {
    public String destination;
    public String id;
    public String metadata = FetchDefaults.EMPTY_JSON_OBJECT_STRING;
    public boolean reportedBegin;

    public RNBGDTaskConfig(String str, String str2, String str3) {
        this.id = str;
        this.destination = str2;
        this.metadata = str3;
        this.reportedBegin = false;
    }
}
