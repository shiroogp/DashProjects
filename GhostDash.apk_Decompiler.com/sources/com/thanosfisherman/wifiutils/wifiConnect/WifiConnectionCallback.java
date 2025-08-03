package com.thanosfisherman.wifiutils.wifiConnect;

public interface WifiConnectionCallback {
    void errorConnect(ConnectionErrorCode connectionErrorCode);

    void successfulConnect();
}
