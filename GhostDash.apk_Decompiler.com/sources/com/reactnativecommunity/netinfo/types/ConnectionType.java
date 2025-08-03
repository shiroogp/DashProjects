package com.reactnativecommunity.netinfo.types;

import com.facebook.react.uimanager.ViewProps;

public enum ConnectionType {
    BLUETOOTH("bluetooth"),
    CELLULAR("cellular"),
    ETHERNET("ethernet"),
    NONE(ViewProps.NONE),
    UNKNOWN("unknown"),
    WIFI("wifi"),
    WIMAX("wimax"),
    VPN("vpn");
    
    public final String label;

    private ConnectionType(String str) {
        this.label = str;
    }
}
