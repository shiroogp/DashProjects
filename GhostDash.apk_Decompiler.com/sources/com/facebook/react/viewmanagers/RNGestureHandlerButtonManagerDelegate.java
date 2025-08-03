package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface;

public class RNGestureHandlerButtonManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNGestureHandlerButtonManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNGestureHandlerButtonManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: boolean} */
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
                case -2143114526: goto L_0x0051;
                case -1609594047: goto L_0x0046;
                case -775297261: goto L_0x003b;
                case 1387411372: goto L_0x002f;
                case 1686617758: goto L_0x0024;
                case 1825644485: goto L_0x0019;
                case 1984457027: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x005b
        L_0x000e:
            java.lang.String r0 = "foreground"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0017
            goto L_0x005b
        L_0x0017:
            r3 = 6
            goto L_0x005b
        L_0x0019:
            java.lang.String r0 = "borderless"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0022
            goto L_0x005b
        L_0x0022:
            r3 = 5
            goto L_0x005b
        L_0x0024:
            java.lang.String r0 = "exclusive"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x002d
            goto L_0x005b
        L_0x002d:
            r3 = 4
            goto L_0x005b
        L_0x002f:
            java.lang.String r0 = "touchSoundDisabled"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0039
            goto L_0x005b
        L_0x0039:
            r3 = 3
            goto L_0x005b
        L_0x003b:
            java.lang.String r0 = "rippleColor"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0044
            goto L_0x005b
        L_0x0044:
            r3 = 2
            goto L_0x005b
        L_0x0046:
            java.lang.String r0 = "enabled"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x004f
            goto L_0x005b
        L_0x004f:
            r3 = r1
            goto L_0x005b
        L_0x0051:
            java.lang.String r0 = "rippleRadius"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x005a
            goto L_0x005b
        L_0x005a:
            r3 = r2
        L_0x005b:
            switch(r3) {
                case 0: goto L_0x00c9;
                case 1: goto L_0x00b8;
                case 2: goto L_0x00a8;
                case 3: goto L_0x0097;
                case 4: goto L_0x0086;
                case 5: goto L_0x0075;
                case 6: goto L_0x0063;
                default: goto L_0x005e;
            }
        L_0x005e:
            super.setProperty(r5, r6, r7)
            goto L_0x00d9
        L_0x0063:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface r6 = (com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface) r6
            if (r7 != 0) goto L_0x006a
            goto L_0x0070
        L_0x006a:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x0070:
            r6.setForeground(r5, r2)
            goto L_0x00d9
        L_0x0075:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface r6 = (com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface) r6
            if (r7 != 0) goto L_0x007c
            goto L_0x0082
        L_0x007c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x0082:
            r6.setBorderless(r5, r2)
            goto L_0x00d9
        L_0x0086:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface r6 = (com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface) r6
            if (r7 != 0) goto L_0x008d
            goto L_0x0093
        L_0x008d:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x0093:
            r6.setExclusive(r5, r1)
            goto L_0x00d9
        L_0x0097:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface r6 = (com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface) r6
            if (r7 != 0) goto L_0x009e
            goto L_0x00a4
        L_0x009e:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x00a4:
            r6.setTouchSoundDisabled(r5, r2)
            goto L_0x00d9
        L_0x00a8:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface r6 = (com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface) r6
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            r6.setRippleColor(r5, r7)
            goto L_0x00d9
        L_0x00b8:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface r6 = (com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface) r6
            if (r7 != 0) goto L_0x00bf
            goto L_0x00c5
        L_0x00bf:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x00c5:
            r6.setEnabled(r5, r1)
            goto L_0x00d9
        L_0x00c9:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface r6 = (com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface) r6
            if (r7 != 0) goto L_0x00d0
            goto L_0x00d6
        L_0x00d0:
            java.lang.Double r7 = (java.lang.Double) r7
            int r2 = r7.intValue()
        L_0x00d6:
            r6.setRippleRadius(r5, r2)
        L_0x00d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
