package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerInterface;

public abstract class BaseViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T>> implements ViewManagerDelegate<T> {
    protected final U mViewManager;

    public BaseViewManagerDelegate(U u) {
        this.mViewManager = u;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r5, java.lang.String r6, java.lang.Object r7) {
        /*
            r4 = this;
            r6.hashCode()
            int r0 = r6.hashCode()
            r1 = 0
            r2 = -1
            switch(r0) {
                case -1721943862: goto L_0x014d;
                case -1721943861: goto L_0x0141;
                case -1267206133: goto L_0x0136;
                case -1228066334: goto L_0x012b;
                case -908189618: goto L_0x0120;
                case -908189617: goto L_0x0115;
                case -877170387: goto L_0x0109;
                case -731417480: goto L_0x00fd;
                case -101663499: goto L_0x00ef;
                case -101359900: goto L_0x00e1;
                case -80891667: goto L_0x00d3;
                case -40300674: goto L_0x00c5;
                case -4379043: goto L_0x00b7;
                case 36255470: goto L_0x00a9;
                case 333432965: goto L_0x009b;
                case 581268560: goto L_0x008d;
                case 588239831: goto L_0x007f;
                case 746986311: goto L_0x0071;
                case 1052666732: goto L_0x0062;
                case 1146842694: goto L_0x0054;
                case 1153872867: goto L_0x0046;
                case 1287124693: goto L_0x0038;
                case 1349188574: goto L_0x002a;
                case 1505602511: goto L_0x001c;
                case 2045685618: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0158
        L_0x000e:
            java.lang.String r0 = "nativeID"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0018
            goto L_0x0158
        L_0x0018:
            r2 = 24
            goto L_0x0158
        L_0x001c:
            java.lang.String r0 = "accessibilityActions"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0026
            goto L_0x0158
        L_0x0026:
            r2 = 23
            goto L_0x0158
        L_0x002a:
            java.lang.String r0 = "borderRadius"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0034
            goto L_0x0158
        L_0x0034:
            r2 = 22
            goto L_0x0158
        L_0x0038:
            java.lang.String r0 = "backgroundColor"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0042
            goto L_0x0158
        L_0x0042:
            r2 = 21
            goto L_0x0158
        L_0x0046:
            java.lang.String r0 = "accessibilityState"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0050
            goto L_0x0158
        L_0x0050:
            r2 = 20
            goto L_0x0158
        L_0x0054:
            java.lang.String r0 = "accessibilityLabel"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x005e
            goto L_0x0158
        L_0x005e:
            r2 = 19
            goto L_0x0158
        L_0x0062:
            java.lang.String r0 = "transform"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x006d
            goto L_0x0158
        L_0x006d:
            r2 = 18
            goto L_0x0158
        L_0x0071:
            java.lang.String r0 = "importantForAccessibility"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x007b
            goto L_0x0158
        L_0x007b:
            r2 = 17
            goto L_0x0158
        L_0x007f:
            java.lang.String r0 = "borderBottomRightRadius"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0089
            goto L_0x0158
        L_0x0089:
            r2 = 16
            goto L_0x0158
        L_0x008d:
            java.lang.String r0 = "borderBottomLeftRadius"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0097
            goto L_0x0158
        L_0x0097:
            r2 = 15
            goto L_0x0158
        L_0x009b:
            java.lang.String r0 = "borderTopRightRadius"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00a5
            goto L_0x0158
        L_0x00a5:
            r2 = 14
            goto L_0x0158
        L_0x00a9:
            java.lang.String r0 = "accessibilityLiveRegion"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00b3
            goto L_0x0158
        L_0x00b3:
            r2 = 13
            goto L_0x0158
        L_0x00b7:
            java.lang.String r0 = "elevation"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00c1
            goto L_0x0158
        L_0x00c1:
            r2 = 12
            goto L_0x0158
        L_0x00c5:
            java.lang.String r0 = "rotation"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00cf
            goto L_0x0158
        L_0x00cf:
            r2 = 11
            goto L_0x0158
        L_0x00d3:
            java.lang.String r0 = "renderToHardwareTextureAndroid"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00dd
            goto L_0x0158
        L_0x00dd:
            r2 = 10
            goto L_0x0158
        L_0x00e1:
            java.lang.String r0 = "accessibilityRole"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00eb
            goto L_0x0158
        L_0x00eb:
            r2 = 9
            goto L_0x0158
        L_0x00ef:
            java.lang.String r0 = "accessibilityHint"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00f9
            goto L_0x0158
        L_0x00f9:
            r2 = 8
            goto L_0x0158
        L_0x00fd:
            java.lang.String r0 = "zIndex"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0107
            goto L_0x0158
        L_0x0107:
            r2 = 7
            goto L_0x0158
        L_0x0109:
            java.lang.String r0 = "testID"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0113
            goto L_0x0158
        L_0x0113:
            r2 = 6
            goto L_0x0158
        L_0x0115:
            java.lang.String r0 = "scaleY"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x011e
            goto L_0x0158
        L_0x011e:
            r2 = 5
            goto L_0x0158
        L_0x0120:
            java.lang.String r0 = "scaleX"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0129
            goto L_0x0158
        L_0x0129:
            r2 = 4
            goto L_0x0158
        L_0x012b:
            java.lang.String r0 = "borderTopLeftRadius"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0134
            goto L_0x0158
        L_0x0134:
            r2 = 3
            goto L_0x0158
        L_0x0136:
            java.lang.String r0 = "opacity"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x013f
            goto L_0x0158
        L_0x013f:
            r2 = 2
            goto L_0x0158
        L_0x0141:
            java.lang.String r0 = "translateY"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x014b
            goto L_0x0158
        L_0x014b:
            r2 = 1
            goto L_0x0158
        L_0x014d:
            java.lang.String r0 = "translateX"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0157
            goto L_0x0158
        L_0x0157:
            r2 = r1
        L_0x0158:
            r6 = 1065353216(0x3f800000, float:1.0)
            r0 = 0
            r3 = 2143289344(0x7fc00000, float:NaN)
            switch(r2) {
                case 0: goto L_0x029c;
                case 1: goto L_0x028d;
                case 2: goto L_0x027e;
                case 3: goto L_0x026f;
                case 4: goto L_0x0260;
                case 5: goto L_0x0251;
                case 6: goto L_0x0249;
                case 7: goto L_0x0239;
                case 8: goto L_0x0230;
                case 9: goto L_0x0227;
                case 10: goto L_0x0217;
                case 11: goto L_0x0207;
                case 12: goto L_0x01f7;
                case 13: goto L_0x01ee;
                case 14: goto L_0x01de;
                case 15: goto L_0x01ce;
                case 16: goto L_0x01be;
                case 17: goto L_0x01b5;
                case 18: goto L_0x01ac;
                case 19: goto L_0x01a3;
                case 20: goto L_0x019a;
                case 21: goto L_0x0184;
                case 22: goto L_0x0174;
                case 23: goto L_0x016b;
                case 24: goto L_0x0162;
                default: goto L_0x0160;
            }
        L_0x0160:
            goto L_0x02aa
        L_0x0162:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setNativeId(r5, r7)
            goto L_0x02aa
        L_0x016b:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableArray r7 = (com.facebook.react.bridge.ReadableArray) r7
            r6.setAccessibilityActions(r5, r7)
            goto L_0x02aa
        L_0x0174:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0179
            goto L_0x017f
        L_0x0179:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x017f:
            r6.setBorderRadius(r5, r3)
            goto L_0x02aa
        L_0x0184:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0189
            goto L_0x0195
        L_0x0189:
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            int r1 = r7.intValue()
        L_0x0195:
            r6.setBackgroundColor(r5, r1)
            goto L_0x02aa
        L_0x019a:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableMap r7 = (com.facebook.react.bridge.ReadableMap) r7
            r6.setViewState(r5, r7)
            goto L_0x02aa
        L_0x01a3:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityLabel(r5, r7)
            goto L_0x02aa
        L_0x01ac:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableArray r7 = (com.facebook.react.bridge.ReadableArray) r7
            r6.setTransform(r5, r7)
            goto L_0x02aa
        L_0x01b5:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setImportantForAccessibility(r5, r7)
            goto L_0x02aa
        L_0x01be:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01c3
            goto L_0x01c9
        L_0x01c3:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x01c9:
            r6.setBorderBottomRightRadius(r5, r3)
            goto L_0x02aa
        L_0x01ce:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01d3
            goto L_0x01d9
        L_0x01d3:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x01d9:
            r6.setBorderBottomLeftRadius(r5, r3)
            goto L_0x02aa
        L_0x01de:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01e3
            goto L_0x01e9
        L_0x01e3:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x01e9:
            r6.setBorderTopRightRadius(r5, r3)
            goto L_0x02aa
        L_0x01ee:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityLiveRegion(r5, r7)
            goto L_0x02aa
        L_0x01f7:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01fc
            goto L_0x0202
        L_0x01fc:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x0202:
            r6.setElevation(r5, r0)
            goto L_0x02aa
        L_0x0207:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x020c
            goto L_0x0212
        L_0x020c:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x0212:
            r6.setRotation(r5, r0)
            goto L_0x02aa
        L_0x0217:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x021c
            goto L_0x0222
        L_0x021c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x0222:
            r6.setRenderToHardwareTexture(r5, r1)
            goto L_0x02aa
        L_0x0227:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityRole(r5, r7)
            goto L_0x02aa
        L_0x0230:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityHint(r5, r7)
            goto L_0x02aa
        L_0x0239:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x023e
            goto L_0x0244
        L_0x023e:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x0244:
            r6.setZIndex(r5, r0)
            goto L_0x02aa
        L_0x0249:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setTestId(r5, r7)
            goto L_0x02aa
        L_0x0251:
            U r0 = r4.mViewManager
            if (r7 != 0) goto L_0x0256
            goto L_0x025c
        L_0x0256:
            java.lang.Double r7 = (java.lang.Double) r7
            float r6 = r7.floatValue()
        L_0x025c:
            r0.setScaleY(r5, r6)
            goto L_0x02aa
        L_0x0260:
            U r0 = r4.mViewManager
            if (r7 != 0) goto L_0x0265
            goto L_0x026b
        L_0x0265:
            java.lang.Double r7 = (java.lang.Double) r7
            float r6 = r7.floatValue()
        L_0x026b:
            r0.setScaleX(r5, r6)
            goto L_0x02aa
        L_0x026f:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0274
            goto L_0x027a
        L_0x0274:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x027a:
            r6.setBorderTopLeftRadius(r5, r3)
            goto L_0x02aa
        L_0x027e:
            U r0 = r4.mViewManager
            if (r7 != 0) goto L_0x0283
            goto L_0x0289
        L_0x0283:
            java.lang.Double r7 = (java.lang.Double) r7
            float r6 = r7.floatValue()
        L_0x0289:
            r0.setOpacity(r5, r6)
            goto L_0x02aa
        L_0x028d:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0292
            goto L_0x0298
        L_0x0292:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x0298:
            r6.setTranslateY(r5, r0)
            goto L_0x02aa
        L_0x029c:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x02a1
            goto L_0x02a7
        L_0x02a1:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x02a7:
            r6.setTranslateX(r5, r0)
        L_0x02aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
