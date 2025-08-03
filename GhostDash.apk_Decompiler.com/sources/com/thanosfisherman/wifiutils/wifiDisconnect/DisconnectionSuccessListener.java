package com.thanosfisherman.wifiutils.wifiDisconnect;

public interface DisconnectionSuccessListener {
    void failed(DisconnectionErrorCode disconnectionErrorCode);

    void success();
}
