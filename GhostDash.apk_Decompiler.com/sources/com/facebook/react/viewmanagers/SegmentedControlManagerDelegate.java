package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.SegmentedControlManagerInterface;

public class SegmentedControlManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & SegmentedControlManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public SegmentedControlManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r5, java.lang.String r6, java.lang.Object r7) {
        /*
            r4 = this;
            r6.hashCode()
            int r0 = r6.hashCode()
            r1 = 1
            r2 = 0
            r3 = -1
            switch(r0) {
                case -1609594047: goto L_0x0053;
                case -1063571914: goto L_0x0047;
                case -823812830: goto L_0x003b;
                case 1287124693: goto L_0x0030;
                case 1327599912: goto L_0x0024;
                case 1436069623: goto L_0x0019;
                case 1684715624: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x005d
        L_0x000e:
            java.lang.String r0 = "momentary"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0017
            goto L_0x005d
        L_0x0017:
            r3 = 6
            goto L_0x005d
        L_0x0019:
            java.lang.String r0 = "selectedIndex"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0022
            goto L_0x005d
        L_0x0022:
            r3 = 5
            goto L_0x005d
        L_0x0024:
            java.lang.String r0 = "tintColor"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x002e
            goto L_0x005d
        L_0x002e:
            r3 = 4
            goto L_0x005d
        L_0x0030:
            java.lang.String r0 = "backgroundColor"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0039
            goto L_0x005d
        L_0x0039:
            r3 = 3
            goto L_0x005d
        L_0x003b:
            java.lang.String r0 = "values"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0045
            goto L_0x005d
        L_0x0045:
            r3 = 2
            goto L_0x005d
        L_0x0047:
            java.lang.String r0 = "textColor"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0051
            goto L_0x005d
        L_0x0051:
            r3 = r1
            goto L_0x005d
        L_0x0053:
            java.lang.String r0 = "enabled"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x005c
            goto L_0x005d
        L_0x005c:
            r3 = r2
        L_0x005d:
            switch(r3) {
                case 0: goto L_0x00c1;
                case 1: goto L_0x00b1;
                case 2: goto L_0x00a7;
                case 3: goto L_0x0097;
                case 4: goto L_0x0087;
                case 5: goto L_0x0076;
                case 6: goto L_0x0065;
                default: goto L_0x0060;
            }
        L_0x0060:
            super.setProperty(r5, r6, r7)
            goto L_0x00d1
        L_0x0065:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.SegmentedControlManagerInterface r6 = (com.facebook.react.viewmanagers.SegmentedControlManagerInterface) r6
            if (r7 != 0) goto L_0x006c
            goto L_0x0072
        L_0x006c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x0072:
            r6.setMomentary(r5, r2)
            goto L_0x00d1
        L_0x0076:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.SegmentedControlManagerInterface r6 = (com.facebook.react.viewmanagers.SegmentedControlManagerInterface) r6
            if (r7 != 0) goto L_0x007d
            goto L_0x0083
        L_0x007d:
            java.lang.Double r7 = (java.lang.Double) r7
            int r2 = r7.intValue()
        L_0x0083:
            r6.setSelectedIndex(r5, r2)
            goto L_0x00d1
        L_0x0087:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.SegmentedControlManagerInterface r6 = (com.facebook.react.viewmanagers.SegmentedControlManagerInterface) r6
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            r6.setTintColor(r5, r7)
            goto L_0x00d1
        L_0x0097:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.SegmentedControlManagerInterface r6 = (com.facebook.react.viewmanagers.SegmentedControlManagerInterface) r6
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            r6.setBackgroundColor(r5, r7)
            goto L_0x00d1
        L_0x00a7:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.SegmentedControlManagerInterface r6 = (com.facebook.react.viewmanagers.SegmentedControlManagerInterface) r6
            com.facebook.react.bridge.ReadableArray r7 = (com.facebook.react.bridge.ReadableArray) r7
            r6.setValues(r5, r7)
            goto L_0x00d1
        L_0x00b1:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.SegmentedControlManagerInterface r6 = (com.facebook.react.viewmanagers.SegmentedControlManagerInterface) r6
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            r6.setTextColor(r5, r7)
            goto L_0x00d1
        L_0x00c1:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.SegmentedControlManagerInterface r6 = (com.facebook.react.viewmanagers.SegmentedControlManagerInterface) r6
            if (r7 != 0) goto L_0x00c8
            goto L_0x00ce
        L_0x00c8:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x00ce:
            r6.setEnabled(r5, r1)
        L_0x00d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.SegmentedControlManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
