package com.thanosfisherman.wifiutils.wifiConnect;

public interface ConnectionSuccessListener {
    void failed(ConnectionErrorCode connectionErrorCode);

    void success();
}
