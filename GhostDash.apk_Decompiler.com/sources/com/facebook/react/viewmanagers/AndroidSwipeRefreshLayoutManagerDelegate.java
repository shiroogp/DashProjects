package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface;

public class AndroidSwipeRefreshLayoutManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & AndroidSwipeRefreshLayoutManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public AndroidSwipeRefreshLayoutManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r5, java.lang.String r6, java.lang.Object r7) {
        /*
            r4 = this;
            r6.hashCode()
            int r0 = r6.hashCode()
            r1 = 0
            r2 = 1
            r3 = -1
            switch(r0) {
                case -1609594047: goto L_0x0046;
                case -1354842768: goto L_0x003b;
                case -885150488: goto L_0x0030;
                case -416037467: goto L_0x0025;
                case -321826009: goto L_0x001a;
                case 3530753: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0050
        L_0x000e:
            java.lang.String r0 = "size"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0018
            goto L_0x0050
        L_0x0018:
            r3 = 5
            goto L_0x0050
        L_0x001a:
            java.lang.String r0 = "refreshing"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0023
            goto L_0x0050
        L_0x0023:
            r3 = 4
            goto L_0x0050
        L_0x0025:
            java.lang.String r0 = "progressViewOffset"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x002e
            goto L_0x0050
        L_0x002e:
            r3 = 3
            goto L_0x0050
        L_0x0030:
            java.lang.String r0 = "progressBackgroundColor"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0039
            goto L_0x0050
        L_0x0039:
            r3 = 2
            goto L_0x0050
        L_0x003b:
            java.lang.String r0 = "colors"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0044
            goto L_0x0050
        L_0x0044:
            r3 = r2
            goto L_0x0050
        L_0x0046:
            java.lang.String r0 = "enabled"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x004f
            goto L_0x0050
        L_0x004f:
            r3 = r1
        L_0x0050:
            switch(r3) {
                case 0: goto L_0x00a5;
                case 1: goto L_0x009b;
                case 2: goto L_0x008b;
                case 3: goto L_0x0079;
                case 4: goto L_0x0068;
                case 5: goto L_0x0057;
                default: goto L_0x0053;
            }
        L_0x0053:
            super.setProperty(r5, r6, r7)
            goto L_0x00b5
        L_0x0057:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface) r6
            if (r7 != 0) goto L_0x005e
            goto L_0x0064
        L_0x005e:
            java.lang.Double r7 = (java.lang.Double) r7
            int r2 = r7.intValue()
        L_0x0064:
            r6.setSize(r5, r2)
            goto L_0x00b5
        L_0x0068:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface) r6
            if (r7 != 0) goto L_0x006f
            goto L_0x0075
        L_0x006f:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x0075:
            r6.setRefreshing(r5, r1)
            goto L_0x00b5
        L_0x0079:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface) r6
            if (r7 != 0) goto L_0x0081
            r7 = 0
            goto L_0x0087
        L_0x0081:
            java.lang.Double r7 = (java.lang.Double) r7
            float r7 = r7.floatValue()
        L_0x0087:
            r6.setProgressViewOffset(r5, r7)
            goto L_0x00b5
        L_0x008b:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface) r6
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            r6.setProgressBackgroundColor(r5, r7)
            goto L_0x00b5
        L_0x009b:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface) r6
            com.facebook.react.bridge.ReadableArray r7 = (com.facebook.react.bridge.ReadableArray) r7
            r6.setColors(r5, r7)
            goto L_0x00b5
        L_0x00a5:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface) r6
            if (r7 != 0) goto L_0x00ac
            goto L_0x00b2
        L_0x00ac:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x00b2:
            r6.setEnabled(r5, r2)
        L_0x00b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }

    public void receiveCommand(AndroidSwipeRefreshLayoutManagerInterface<T> androidSwipeRefreshLayoutManagerInterface, T t, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("setNativeRefreshing")) {
            androidSwipeRefreshLayoutManagerInterface.setNativeRefreshing(t, readableArray.getBoolean(0));
        }
    }
}
