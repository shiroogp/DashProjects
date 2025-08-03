package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.UnimplementedNativeViewManagerInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

public class UnimplementedNativeViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & UnimplementedNativeViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public UnimplementedNativeViewManagerDelegate(U u) {
        super(u);
    }

    public void setProperty(T t, String str, Object obj) {
        str.hashCode();
        if (!str.equals(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
            super.setProperty(t, str, obj);
        } else {
            ((UnimplementedNativeViewManagerInterface) this.mViewManager).setName(t, obj == null ? "" : (String) obj);
        }
    }
}
