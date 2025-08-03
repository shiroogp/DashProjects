package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSScreenManagerInterface;

public class RNSScreenManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSScreenManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSScreenManagerDelegate(U u) {
        super(u);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r6, java.lang.String r7, java.lang.Object r8) {
        /*
            r5 = this;
            r7.hashCode()
            int r0 = r7.hashCode()
            r1 = 1
            r2 = -1
            r3 = 0
            switch(r0) {
                case -1853558344: goto L_0x00b5;
                case -1322084375: goto L_0x00a9;
                case -1156137512: goto L_0x009c;
                case -1150711358: goto L_0x008f;
                case -1047235902: goto L_0x0084;
                case -973702878: goto L_0x0078;
                case -958765200: goto L_0x006c;
                case -577711652: goto L_0x0060;
                case -462720700: goto L_0x0053;
                case -257141968: goto L_0x0046;
                case 17337291: goto L_0x0038;
                case 227582404: goto L_0x002b;
                case 1387359683: goto L_0x001d;
                case 1729091548: goto L_0x0010;
                default: goto L_0x000d;
            }
        L_0x000d:
            r0 = r2
            goto L_0x00c0
        L_0x0010:
            java.lang.String r0 = "nativeBackButtonDismissalEnabled"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L_0x0019
            goto L_0x000d
        L_0x0019:
            r0 = 13
            goto L_0x00c0
        L_0x001d:
            java.lang.String r0 = "statusBarAnimation"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L_0x0027
            goto L_0x000d
        L_0x0027:
            r0 = 12
            goto L_0x00c0
        L_0x002b:
            java.lang.String r0 = "screenOrientation"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L_0x0034
            goto L_0x000d
        L_0x0034:
            r0 = 11
            goto L_0x00c0
        L_0x0038:
            java.lang.String r0 = "statusBarHidden"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L_0x0042
            goto L_0x000d
        L_0x0042:
            r0 = 10
            goto L_0x00c0
        L_0x0046:
            java.lang.String r0 = "replaceAnimation"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L_0x004f
            goto L_0x000d
        L_0x004f:
            r0 = 9
            goto L_0x00c0
        L_0x0053:
            java.lang.String r0 = "navigationBarColor"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L_0x005c
            goto L_0x000d
        L_0x005c:
            r0 = 8
            goto L_0x00c0
        L_0x0060:
            java.lang.String r0 = "stackAnimation"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L_0x006a
            goto L_0x000d
        L_0x006a:
            r0 = 7
            goto L_0x00c0
        L_0x006c:
            java.lang.String r0 = "statusBarStyle"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L_0x0076
            goto L_0x000d
        L_0x0076:
            r0 = 6
            goto L_0x00c0
        L_0x0078:
            java.lang.String r0 = "statusBarColor"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L_0x0082
            goto L_0x000d
        L_0x0082:
            r0 = 5
            goto L_0x00c0
        L_0x0084:
            java.lang.String r0 = "activityState"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L_0x008d
            goto L_0x000d
        L_0x008d:
            r0 = 4
            goto L_0x00c0
        L_0x008f:
            java.lang.String r0 = "stackPresentation"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L_0x009a
            goto L_0x000d
        L_0x009a:
            r0 = 3
            goto L_0x00c0
        L_0x009c:
            java.lang.String r0 = "statusBarTranslucent"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L_0x00a7
            goto L_0x000d
        L_0x00a7:
            r0 = 2
            goto L_0x00c0
        L_0x00a9:
            java.lang.String r0 = "navigationBarHidden"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L_0x00b3
            goto L_0x000d
        L_0x00b3:
            r0 = r1
            goto L_0x00c0
        L_0x00b5:
            java.lang.String r0 = "gestureEnabled"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L_0x00bf
            goto L_0x000d
        L_0x00bf:
            r0 = r3
        L_0x00c0:
            r4 = 0
            switch(r0) {
                case 0: goto L_0x018d;
                case 1: goto L_0x017c;
                case 2: goto L_0x016b;
                case 3: goto L_0x0161;
                case 4: goto L_0x0150;
                case 5: goto L_0x0140;
                case 6: goto L_0x0132;
                case 7: goto L_0x0127;
                case 8: goto L_0x0116;
                case 9: goto L_0x010b;
                case 10: goto L_0x00f9;
                case 11: goto L_0x00ea;
                case 12: goto L_0x00db;
                case 13: goto L_0x00c9;
                default: goto L_0x00c4;
            }
        L_0x00c4:
            super.setProperty(r6, r7, r8)
            goto L_0x019d
        L_0x00c9:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.RNSScreenManagerInterface r7 = (com.facebook.react.viewmanagers.RNSScreenManagerInterface) r7
            if (r8 != 0) goto L_0x00d0
            goto L_0x00d6
        L_0x00d0:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r3 = r8.booleanValue()
        L_0x00d6:
            r7.setNativeBackButtonDismissalEnabled(r6, r3)
            goto L_0x019d
        L_0x00db:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.RNSScreenManagerInterface r7 = (com.facebook.react.viewmanagers.RNSScreenManagerInterface) r7
            if (r8 != 0) goto L_0x00e2
            goto L_0x00e5
        L_0x00e2:
            r4 = r8
            java.lang.String r4 = (java.lang.String) r4
        L_0x00e5:
            r7.setStatusBarAnimation(r6, r4)
            goto L_0x019d
        L_0x00ea:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.RNSScreenManagerInterface r7 = (com.facebook.react.viewmanagers.RNSScreenManagerInterface) r7
            if (r8 != 0) goto L_0x00f1
            goto L_0x00f4
        L_0x00f1:
            r4 = r8
            java.lang.String r4 = (java.lang.String) r4
        L_0x00f4:
            r7.setScreenOrientation(r6, r4)
            goto L_0x019d
        L_0x00f9:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.RNSScreenManagerInterface r7 = (com.facebook.react.viewmanagers.RNSScreenManagerInterface) r7
            if (r8 != 0) goto L_0x0100
            goto L_0x0106
        L_0x0100:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r3 = r8.booleanValue()
        L_0x0106:
            r7.setStatusBarHidden(r6, r3)
            goto L_0x019d
        L_0x010b:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.RNSScreenManagerInterface r7 = (com.facebook.react.viewmanagers.RNSScreenManagerInterface) r7
            java.lang.String r8 = (java.lang.String) r8
            r7.setReplaceAnimation(r6, r8)
            goto L_0x019d
        L_0x0116:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.RNSScreenManagerInterface r7 = (com.facebook.react.viewmanagers.RNSScreenManagerInterface) r7
            android.content.Context r0 = r6.getContext()
            java.lang.Integer r8 = com.facebook.react.bridge.ColorPropConverter.getColor(r8, r0)
            r7.setNavigationBarColor(r6, r8)
            goto L_0x019d
        L_0x0127:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.RNSScreenManagerInterface r7 = (com.facebook.react.viewmanagers.RNSScreenManagerInterface) r7
            java.lang.String r8 = (java.lang.String) r8
            r7.setStackAnimation(r6, r8)
            goto L_0x019d
        L_0x0132:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.RNSScreenManagerInterface r7 = (com.facebook.react.viewmanagers.RNSScreenManagerInterface) r7
            if (r8 != 0) goto L_0x0139
            goto L_0x013c
        L_0x0139:
            r4 = r8
            java.lang.String r4 = (java.lang.String) r4
        L_0x013c:
            r7.setStatusBarStyle(r6, r4)
            goto L_0x019d
        L_0x0140:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.RNSScreenManagerInterface r7 = (com.facebook.react.viewmanagers.RNSScreenManagerInterface) r7
            android.content.Context r0 = r6.getContext()
            java.lang.Integer r8 = com.facebook.react.bridge.ColorPropConverter.getColor(r8, r0)
            r7.setStatusBarColor(r6, r8)
            goto L_0x019d
        L_0x0150:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.RNSScreenManagerInterface r7 = (com.facebook.react.viewmanagers.RNSScreenManagerInterface) r7
            if (r8 != 0) goto L_0x0157
            goto L_0x015d
        L_0x0157:
            java.lang.Double r8 = (java.lang.Double) r8
            int r2 = r8.intValue()
        L_0x015d:
            r7.setActivityState(r6, r2)
            goto L_0x019d
        L_0x0161:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.RNSScreenManagerInterface r7 = (com.facebook.react.viewmanagers.RNSScreenManagerInterface) r7
            java.lang.String r8 = (java.lang.String) r8
            r7.setStackPresentation(r6, r8)
            goto L_0x019d
        L_0x016b:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.RNSScreenManagerInterface r7 = (com.facebook.react.viewmanagers.RNSScreenManagerInterface) r7
            if (r8 != 0) goto L_0x0172
            goto L_0x0178
        L_0x0172:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r3 = r8.booleanValue()
        L_0x0178:
            r7.setStatusBarTranslucent(r6, r3)
            goto L_0x019d
        L_0x017c:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.RNSScreenManagerInterface r7 = (com.facebook.react.viewmanagers.RNSScreenManagerInterface) r7
            if (r8 != 0) goto L_0x0183
            goto L_0x0189
        L_0x0183:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r3 = r8.booleanValue()
        L_0x0189:
            r7.setNavigationBarHidden(r6, r3)
            goto L_0x019d
        L_0x018d:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.RNSScreenManagerInterface r7 = (com.facebook.react.viewmanagers.RNSScreenManagerInterface) r7
            if (r8 != 0) goto L_0x0194
            goto L_0x019a
        L_0x0194:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r1 = r8.booleanValue()
        L_0x019a:
            r7.setGestureEnabled(r6, r1)
        L_0x019d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSScreenManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
