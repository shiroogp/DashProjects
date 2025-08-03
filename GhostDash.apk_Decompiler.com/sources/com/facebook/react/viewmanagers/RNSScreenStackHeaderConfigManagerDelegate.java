package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface;

public class RNSScreenStackHeaderConfigManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSScreenStackHeaderConfigManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSScreenStackHeaderConfigManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v29, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v31, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v32, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v33, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v34, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v35, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v36, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r4, java.lang.String r5, java.lang.Object r6) {
        /*
            r3 = this;
            r5.hashCode()
            int r0 = r5.hashCode()
            r1 = 0
            r2 = -1
            switch(r0) {
                case -1822687399: goto L_0x014f;
                case -1799367701: goto L_0x0143;
                case -1774658170: goto L_0x0138;
                case -1715368693: goto L_0x012c;
                case -1503810304: goto L_0x0121;
                case -1225100257: goto L_0x0115;
                case -1217487446: goto L_0x010a;
                case -1094575123: goto L_0x00ff;
                case -962590849: goto L_0x00f1;
                case -389245640: goto L_0x00e3;
                case -140063148: goto L_0x00d5;
                case 347216: goto L_0x00c7;
                case 94842723: goto L_0x00b9;
                case 110371416: goto L_0x00aa;
                case 183888321: goto L_0x009c;
                case 243070244: goto L_0x008e;
                case 339462402: goto L_0x0080;
                case 490615652: goto L_0x0072;
                case 1038753243: goto L_0x0064;
                case 1287124693: goto L_0x0056;
                case 1324688817: goto L_0x0048;
                case 1518161768: goto L_0x0039;
                case 1564506303: goto L_0x002b;
                case 2029798365: goto L_0x001d;
                case 2099541337: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x015a
        L_0x000e:
            java.lang.String r0 = "topInsetEnabled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0019
            goto L_0x015a
        L_0x0019:
            r2 = 24
            goto L_0x015a
        L_0x001d:
            java.lang.String r0 = "largeTitle"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0027
            goto L_0x015a
        L_0x0027:
            r2 = 23
            goto L_0x015a
        L_0x002b:
            java.lang.String r0 = "largeTitleHideShadow"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0035
            goto L_0x015a
        L_0x0035:
            r2 = 22
            goto L_0x015a
        L_0x0039:
            java.lang.String r0 = "titleFontSize"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0044
            goto L_0x015a
        L_0x0044:
            r2 = 21
            goto L_0x015a
        L_0x0048:
            java.lang.String r0 = "backTitle"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0052
            goto L_0x015a
        L_0x0052:
            r2 = 20
            goto L_0x015a
        L_0x0056:
            java.lang.String r0 = "backgroundColor"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0060
            goto L_0x015a
        L_0x0060:
            r2 = 19
            goto L_0x015a
        L_0x0064:
            java.lang.String r0 = "hideBackButton"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x006e
            goto L_0x015a
        L_0x006e:
            r2 = 18
            goto L_0x015a
        L_0x0072:
            java.lang.String r0 = "largeTitleFontWeight"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x007c
            goto L_0x015a
        L_0x007c:
            r2 = 17
            goto L_0x015a
        L_0x0080:
            java.lang.String r0 = "hideShadow"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x008a
            goto L_0x015a
        L_0x008a:
            r2 = 16
            goto L_0x015a
        L_0x008e:
            java.lang.String r0 = "backTitleFontFamily"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0098
            goto L_0x015a
        L_0x0098:
            r2 = 15
            goto L_0x015a
        L_0x009c:
            java.lang.String r0 = "backTitleFontSize"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00a6
            goto L_0x015a
        L_0x00a6:
            r2 = 14
            goto L_0x015a
        L_0x00aa:
            java.lang.String r0 = "title"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00b5
            goto L_0x015a
        L_0x00b5:
            r2 = 13
            goto L_0x015a
        L_0x00b9:
            java.lang.String r0 = "color"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00c3
            goto L_0x015a
        L_0x00c3:
            r2 = 12
            goto L_0x015a
        L_0x00c7:
            java.lang.String r0 = "largeTitleFontFamily"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00d1
            goto L_0x015a
        L_0x00d1:
            r2 = 11
            goto L_0x015a
        L_0x00d5:
            java.lang.String r0 = "backButtonInCustomView"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00df
            goto L_0x015a
        L_0x00df:
            r2 = 10
            goto L_0x015a
        L_0x00e3:
            java.lang.String r0 = "largeTitleBackgroundColor"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00ed
            goto L_0x015a
        L_0x00ed:
            r2 = 9
            goto L_0x015a
        L_0x00f1:
            java.lang.String r0 = "direction"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00fb
            goto L_0x015a
        L_0x00fb:
            r2 = 8
            goto L_0x015a
        L_0x00ff:
            java.lang.String r0 = "largeTitleFontSize"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0108
            goto L_0x015a
        L_0x0108:
            r2 = 7
            goto L_0x015a
        L_0x010a:
            java.lang.String r0 = "hidden"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0113
            goto L_0x015a
        L_0x0113:
            r2 = 6
            goto L_0x015a
        L_0x0115:
            java.lang.String r0 = "titleFontWeight"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x011f
            goto L_0x015a
        L_0x011f:
            r2 = 5
            goto L_0x015a
        L_0x0121:
            java.lang.String r0 = "disableBackButtonMenu"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x012a
            goto L_0x015a
        L_0x012a:
            r2 = 4
            goto L_0x015a
        L_0x012c:
            java.lang.String r0 = "titleFontFamily"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0136
            goto L_0x015a
        L_0x0136:
            r2 = 3
            goto L_0x015a
        L_0x0138:
            java.lang.String r0 = "largeTitleColor"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0141
            goto L_0x015a
        L_0x0141:
            r2 = 2
            goto L_0x015a
        L_0x0143:
            java.lang.String r0 = "titleColor"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x014d
            goto L_0x015a
        L_0x014d:
            r2 = 1
            goto L_0x015a
        L_0x014f:
            java.lang.String r0 = "translucent"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0159
            goto L_0x015a
        L_0x0159:
            r2 = r1
        L_0x015a:
            r0 = 0
            switch(r2) {
                case 0: goto L_0x02ec;
                case 1: goto L_0x02dc;
                case 2: goto L_0x02cc;
                case 3: goto L_0x02be;
                case 4: goto L_0x02ad;
                case 5: goto L_0x029f;
                case 6: goto L_0x028e;
                case 7: goto L_0x027c;
                case 8: goto L_0x0271;
                case 9: goto L_0x0260;
                case 10: goto L_0x024e;
                case 11: goto L_0x023f;
                case 12: goto L_0x022e;
                case 13: goto L_0x021f;
                case 14: goto L_0x020d;
                case 15: goto L_0x01fe;
                case 16: goto L_0x01ec;
                case 17: goto L_0x01dd;
                case 18: goto L_0x01cb;
                case 19: goto L_0x01ba;
                case 20: goto L_0x01ab;
                case 21: goto L_0x0199;
                case 22: goto L_0x0187;
                case 23: goto L_0x0175;
                case 24: goto L_0x0163;
                default: goto L_0x015e;
            }
        L_0x015e:
            super.setProperty(r4, r5, r6)
            goto L_0x02fc
        L_0x0163:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r5 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r5
            if (r6 != 0) goto L_0x016a
            goto L_0x0170
        L_0x016a:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x0170:
            r5.setTopInsetEnabled(r4, r1)
            goto L_0x02fc
        L_0x0175:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r5 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r5
            if (r6 != 0) goto L_0x017c
            goto L_0x0182
        L_0x017c:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x0182:
            r5.setLargeTitle(r4, r1)
            goto L_0x02fc
        L_0x0187:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r5 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r5
            if (r6 != 0) goto L_0x018e
            goto L_0x0194
        L_0x018e:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x0194:
            r5.setLargeTitleHideShadow(r4, r1)
            goto L_0x02fc
        L_0x0199:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r5 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r5
            if (r6 != 0) goto L_0x01a0
            goto L_0x01a6
        L_0x01a0:
            java.lang.Double r6 = (java.lang.Double) r6
            int r1 = r6.intValue()
        L_0x01a6:
            r5.setTitleFontSize(r4, r1)
            goto L_0x02fc
        L_0x01ab:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r5 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r5
            if (r6 != 0) goto L_0x01b2
            goto L_0x01b5
        L_0x01b2:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x01b5:
            r5.setBackTitle(r4, r0)
            goto L_0x02fc
        L_0x01ba:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r5 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r5
            android.content.Context r0 = r4.getContext()
            java.lang.Integer r6 = com.facebook.react.bridge.ColorPropConverter.getColor(r6, r0)
            r5.setBackgroundColor(r4, r6)
            goto L_0x02fc
        L_0x01cb:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r5 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r5
            if (r6 != 0) goto L_0x01d2
            goto L_0x01d8
        L_0x01d2:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x01d8:
            r5.setHideBackButton(r4, r1)
            goto L_0x02fc
        L_0x01dd:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r5 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r5
            if (r6 != 0) goto L_0x01e4
            goto L_0x01e7
        L_0x01e4:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x01e7:
            r5.setLargeTitleFontWeight(r4, r0)
            goto L_0x02fc
        L_0x01ec:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r5 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r5
            if (r6 != 0) goto L_0x01f3
            goto L_0x01f9
        L_0x01f3:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x01f9:
            r5.setHideShadow(r4, r1)
            goto L_0x02fc
        L_0x01fe:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r5 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r5
            if (r6 != 0) goto L_0x0205
            goto L_0x0208
        L_0x0205:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x0208:
            r5.setBackTitleFontFamily(r4, r0)
            goto L_0x02fc
        L_0x020d:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r5 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r5
            if (r6 != 0) goto L_0x0214
            goto L_0x021a
        L_0x0214:
            java.lang.Double r6 = (java.lang.Double) r6
            int r1 = r6.intValue()
        L_0x021a:
            r5.setBackTitleFontSize(r4, r1)
            goto L_0x02fc
        L_0x021f:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r5 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r5
            if (r6 != 0) goto L_0x0226
            goto L_0x0229
        L_0x0226:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x0229:
            r5.setTitle(r4, r0)
            goto L_0x02fc
        L_0x022e:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r5 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r5
            android.content.Context r0 = r4.getContext()
            java.lang.Integer r6 = com.facebook.react.bridge.ColorPropConverter.getColor(r6, r0)
            r5.setColor(r4, r6)
            goto L_0x02fc
        L_0x023f:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r5 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r5
            if (r6 != 0) goto L_0x0246
            goto L_0x0249
        L_0x0246:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x0249:
            r5.setLargeTitleFontFamily(r4, r0)
            goto L_0x02fc
        L_0x024e:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r5 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r5
            if (r6 != 0) goto L_0x0255
            goto L_0x025b
        L_0x0255:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x025b:
            r5.setBackButtonInCustomView(r4, r1)
            goto L_0x02fc
        L_0x0260:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r5 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r5
            android.content.Context r0 = r4.getContext()
            java.lang.Integer r6 = com.facebook.react.bridge.ColorPropConverter.getColor(r6, r0)
            r5.setLargeTitleBackgroundColor(r4, r6)
            goto L_0x02fc
        L_0x0271:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r5 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r5
            java.lang.String r6 = (java.lang.String) r6
            r5.setDirection(r4, r6)
            goto L_0x02fc
        L_0x027c:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r5 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r5
            if (r6 != 0) goto L_0x0283
            goto L_0x0289
        L_0x0283:
            java.lang.Double r6 = (java.lang.Double) r6
            int r1 = r6.intValue()
        L_0x0289:
            r5.setLargeTitleFontSize(r4, r1)
            goto L_0x02fc
        L_0x028e:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r5 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r5
            if (r6 != 0) goto L_0x0295
            goto L_0x029b
        L_0x0295:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x029b:
            r5.setHidden(r4, r1)
            goto L_0x02fc
        L_0x029f:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r5 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r5
            if (r6 != 0) goto L_0x02a6
            goto L_0x02a9
        L_0x02a6:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x02a9:
            r5.setTitleFontWeight(r4, r0)
            goto L_0x02fc
        L_0x02ad:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r5 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r5
            if (r6 != 0) goto L_0x02b4
            goto L_0x02ba
        L_0x02b4:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x02ba:
            r5.setDisableBackButtonMenu(r4, r1)
            goto L_0x02fc
        L_0x02be:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r5 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r5
            if (r6 != 0) goto L_0x02c5
            goto L_0x02c8
        L_0x02c5:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x02c8:
            r5.setTitleFontFamily(r4, r0)
            goto L_0x02fc
        L_0x02cc:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r5 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r5
            android.content.Context r0 = r4.getContext()
            java.lang.Integer r6 = com.facebook.react.bridge.ColorPropConverter.getColor(r6, r0)
            r5.setLargeTitleColor(r4, r6)
            goto L_0x02fc
        L_0x02dc:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r5 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r5
            android.content.Context r0 = r4.getContext()
            java.lang.Integer r6 = com.facebook.react.bridge.ColorPropConverter.getColor(r6, r0)
            r5.setTitleColor(r4, r6)
            goto L_0x02fc
        L_0x02ec:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r5 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r5
            if (r6 != 0) goto L_0x02f3
            goto L_0x02f9
        L_0x02f3:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x02f9:
            r5.setTranslucent(r4, r1)
        L_0x02fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
