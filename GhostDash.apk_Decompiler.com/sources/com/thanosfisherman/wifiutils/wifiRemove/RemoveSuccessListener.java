package com.thanosfisherman.wifiutils.wifiRemove;

public interface RemoveSuccessListener {
    void failed(RemoveErrorCode removeErrorCode);

    void success();
}
