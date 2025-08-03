package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface;

public class AndroidViewPagerManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & AndroidViewPagerManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public AndroidViewPagerManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: boolean} */
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
                case -1151046732: goto L_0x003a;
                case -764307226: goto L_0x002f;
                case 1097821469: goto L_0x0024;
                case 1233251315: goto L_0x0019;
                case 1919780198: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0044
        L_0x000e:
            java.lang.String r0 = "peekEnabled"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0017
            goto L_0x0044
        L_0x0017:
            r3 = 4
            goto L_0x0044
        L_0x0019:
            java.lang.String r0 = "initialPage"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0022
            goto L_0x0044
        L_0x0022:
            r3 = 3
            goto L_0x0044
        L_0x0024:
            java.lang.String r0 = "pageMargin"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x002d
            goto L_0x0044
        L_0x002d:
            r3 = 2
            goto L_0x0044
        L_0x002f:
            java.lang.String r0 = "keyboardDismissMode"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0038
            goto L_0x0044
        L_0x0038:
            r3 = r1
            goto L_0x0044
        L_0x003a:
            java.lang.String r0 = "scrollEnabled"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x0044
        L_0x0043:
            r3 = r2
        L_0x0044:
            switch(r3) {
                case 0: goto L_0x0088;
                case 1: goto L_0x007e;
                case 2: goto L_0x006d;
                case 3: goto L_0x005c;
                case 4: goto L_0x004b;
                default: goto L_0x0047;
            }
        L_0x0047:
            super.setProperty(r5, r6, r7)
            goto L_0x0098
        L_0x004b:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface) r6
            if (r7 != 0) goto L_0x0052
            goto L_0x0058
        L_0x0052:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x0058:
            r6.setPeekEnabled(r5, r2)
            goto L_0x0098
        L_0x005c:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface) r6
            if (r7 != 0) goto L_0x0063
            goto L_0x0069
        L_0x0063:
            java.lang.Double r7 = (java.lang.Double) r7
            int r2 = r7.intValue()
        L_0x0069:
            r6.setInitialPage(r5, r2)
            goto L_0x0098
        L_0x006d:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface) r6
            if (r7 != 0) goto L_0x0074
            goto L_0x007a
        L_0x0074:
            java.lang.Double r7 = (java.lang.Double) r7
            int r2 = r7.intValue()
        L_0x007a:
            r6.setPageMargin(r5, r2)
            goto L_0x0098
        L_0x007e:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface) r6
            java.lang.String r7 = (java.lang.String) r7
            r6.setKeyboardDismissMode(r5, r7)
            goto L_0x0098
        L_0x0088:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface) r6
            if (r7 != 0) goto L_0x008f
            goto L_0x0095
        L_0x008f:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x0095:
            r6.setScrollEnabled(r5, r1)
        L_0x0098:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.AndroidViewPagerManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }

    public void receiveCommand(AndroidViewPagerManagerInterface<T> androidViewPagerManagerInterface, T t, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("setPageWithoutAnimation")) {
            androidViewPagerManagerInterface.setPageWithoutAnimation(t, readableArray.getInt(0));
        } else if (str.equals("setPage")) {
            androidViewPagerManagerInterface.setPage(t, readableArray.getInt(0));
        }
    }
}
