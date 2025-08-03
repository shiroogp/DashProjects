package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.ModalHostViewManagerInterface;

public class ModalHostViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & ModalHostViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public ModalHostViewManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: boolean} */
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
                case -1851617609: goto L_0x005e;
                case -1850124175: goto L_0x0052;
                case -1726194350: goto L_0x0046;
                case -1618432855: goto L_0x003b;
                case -1156137512: goto L_0x002f;
                case -795203165: goto L_0x0024;
                case 1195991583: goto L_0x0019;
                case 2031205598: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0068
        L_0x000e:
            java.lang.String r0 = "animationType"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0017
            goto L_0x0068
        L_0x0017:
            r2 = 7
            goto L_0x0068
        L_0x0019:
            java.lang.String r0 = "hardwareAccelerated"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0022
            goto L_0x0068
        L_0x0022:
            r2 = 6
            goto L_0x0068
        L_0x0024:
            java.lang.String r0 = "animated"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x002d
            goto L_0x0068
        L_0x002d:
            r2 = 5
            goto L_0x0068
        L_0x002f:
            java.lang.String r0 = "statusBarTranslucent"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0039
            goto L_0x0068
        L_0x0039:
            r2 = 4
            goto L_0x0068
        L_0x003b:
            java.lang.String r0 = "identifier"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0044
            goto L_0x0068
        L_0x0044:
            r2 = 3
            goto L_0x0068
        L_0x0046:
            java.lang.String r0 = "transparent"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0050
            goto L_0x0068
        L_0x0050:
            r2 = 2
            goto L_0x0068
        L_0x0052:
            java.lang.String r0 = "supportedOrientations"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x005c
            goto L_0x0068
        L_0x005c:
            r2 = 1
            goto L_0x0068
        L_0x005e:
            java.lang.String r0 = "presentationStyle"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0067
            goto L_0x0068
        L_0x0067:
            r2 = r1
        L_0x0068:
            switch(r2) {
                case 0: goto L_0x00da;
                case 1: goto L_0x00d0;
                case 2: goto L_0x00bf;
                case 3: goto L_0x00ae;
                case 4: goto L_0x009d;
                case 5: goto L_0x008c;
                case 6: goto L_0x007b;
                case 7: goto L_0x0070;
                default: goto L_0x006b;
            }
        L_0x006b:
            super.setProperty(r4, r5, r6)
            goto L_0x00e3
        L_0x0070:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            java.lang.String r6 = (java.lang.String) r6
            r5.setAnimationType(r4, r6)
            goto L_0x00e3
        L_0x007b:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            if (r6 != 0) goto L_0x0082
            goto L_0x0088
        L_0x0082:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x0088:
            r5.setHardwareAccelerated(r4, r1)
            goto L_0x00e3
        L_0x008c:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            if (r6 != 0) goto L_0x0093
            goto L_0x0099
        L_0x0093:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x0099:
            r5.setAnimated(r4, r1)
            goto L_0x00e3
        L_0x009d:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            if (r6 != 0) goto L_0x00a4
            goto L_0x00aa
        L_0x00a4:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x00aa:
            r5.setStatusBarTranslucent(r4, r1)
            goto L_0x00e3
        L_0x00ae:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            if (r6 != 0) goto L_0x00b5
            goto L_0x00bb
        L_0x00b5:
            java.lang.Double r6 = (java.lang.Double) r6
            int r1 = r6.intValue()
        L_0x00bb:
            r5.setIdentifier(r4, r1)
            goto L_0x00e3
        L_0x00bf:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            if (r6 != 0) goto L_0x00c6
            goto L_0x00cc
        L_0x00c6:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x00cc:
            r5.setTransparent(r4, r1)
            goto L_0x00e3
        L_0x00d0:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            com.facebook.react.bridge.ReadableArray r6 = (com.facebook.react.bridge.ReadableArray) r6
            r5.setSupportedOrientations(r4, r6)
            goto L_0x00e3
        L_0x00da:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r5 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r5
            java.lang.String r6 = (java.lang.String) r6
            r5.setPresentationStyle(r4, r6)
        L_0x00e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.ModalHostViewManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
