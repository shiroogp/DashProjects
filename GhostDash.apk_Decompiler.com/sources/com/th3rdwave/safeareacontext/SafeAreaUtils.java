package com.th3rdwave.safeareacontext;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;

class SafeAreaUtils {
    SafeAreaUtils() {
    }

    private static EdgeInsets getRootWindowInsetsCompat(View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            return new EdgeInsets((float) rootWindowInsets.getSystemWindowInsetTop(), (float) rootWindowInsets.getSystemWindowInsetRight(), (float) Math.min(rootWindowInsets.getSystemWindowInsetBottom(), rootWindowInsets.getStableInsetBottom()), (float) rootWindowInsets.getSystemWindowInsetLeft());
        }
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return new EdgeInsets((float) rect.top, (float) (view.getWidth() - rect.right), (float) (view.getHeight() - rect.bottom), (float) rect.left);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = r7.getRootView();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.th3rdwave.safeareacontext.EdgeInsets getSafeAreaInsets(android.view.View r7) {
        /*
            int r0 = r7.getHeight()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            android.view.View r0 = r7.getRootView()
            com.th3rdwave.safeareacontext.EdgeInsets r2 = getRootWindowInsetsCompat(r0)
            if (r2 != 0) goto L_0x0013
            return r1
        L_0x0013:
            int r1 = r0.getWidth()
            float r1 = (float) r1
            int r0 = r0.getHeight()
            float r0 = (float) r0
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>()
            r7.getGlobalVisibleRect(r3)
            float r4 = r2.top
            int r5 = r3.top
            float r5 = (float) r5
            float r4 = r4 - r5
            r5 = 0
            float r4 = java.lang.Math.max(r4, r5)
            r2.top = r4
            float r4 = r2.left
            int r6 = r3.left
            float r6 = (float) r6
            float r4 = r4 - r6
            float r4 = java.lang.Math.max(r4, r5)
            r2.left = r4
            int r4 = r3.top
            int r6 = r7.getHeight()
            int r4 = r4 + r6
            float r4 = (float) r4
            float r4 = r4 - r0
            float r0 = java.lang.Math.min(r4, r5)
            float r4 = r2.bottom
            float r0 = r0 + r4
            float r0 = java.lang.Math.max(r0, r5)
            r2.bottom = r0
            int r0 = r3.left
            int r7 = r7.getWidth()
            int r0 = r0 + r7
            float r7 = (float) r0
            float r7 = r7 - r1
            float r7 = java.lang.Math.min(r7, r5)
            float r0 = r2.right
            float r7 = r7 + r0
            float r7 = java.lang.Math.max(r7, r5)
            r2.right = r7
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.th3rdwave.safeareacontext.SafeAreaUtils.getSafeAreaInsets(android.view.View):com.th3rdwave.safeareacontext.EdgeInsets");
    }

    static Rect getFrame(ViewGroup viewGroup, View view) {
        if (view.getParent() == null) {
            return null;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        try {
            viewGroup.offsetDescendantRectToMyCoords(view, rect);
            return new Rect((float) rect.left, (float) rect.top, (float) view.getWidth(), (float) view.getHeight());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }
}
