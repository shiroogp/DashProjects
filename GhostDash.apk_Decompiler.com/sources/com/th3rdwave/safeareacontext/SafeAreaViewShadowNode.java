package com.th3rdwave.safeareacontext;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.NativeViewHierarchyOptimizer;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import java.util.EnumSet;

public class SafeAreaViewShadowNode extends LayoutShadowNode {
    private SafeAreaViewLocalData mLocalData;
    private float[] mMargins = new float[ViewProps.PADDING_MARGIN_SPACING_TYPES.length];
    private boolean mNeedsUpdate = false;
    private float[] mPaddings = new float[ViewProps.PADDING_MARGIN_SPACING_TYPES.length];

    public SafeAreaViewShadowNode() {
        for (int i = 0; i < ViewProps.PADDING_MARGIN_SPACING_TYPES.length; i++) {
            this.mPaddings[i] = Float.NaN;
            this.mMargins[i] = Float.NaN;
        }
    }

    private void updateInsets() {
        SafeAreaViewLocalData safeAreaViewLocalData = this.mLocalData;
        if (safeAreaViewLocalData != null) {
            float[] fArr = safeAreaViewLocalData.getMode() == SafeAreaViewMode.PADDING ? this.mPaddings : this.mMargins;
            float f = fArr[8];
            float f2 = 0.0f;
            if (Float.isNaN(f)) {
                f = 0.0f;
            }
            float f3 = f;
            float f4 = f3;
            float f5 = f4;
            float f6 = fArr[7];
            if (!Float.isNaN(f6)) {
                f = f6;
                f4 = f;
            }
            float f7 = fArr[6];
            if (!Float.isNaN(f7)) {
                f3 = f7;
                f5 = f3;
            }
            float f8 = fArr[1];
            if (!Float.isNaN(f8)) {
                f = f8;
            }
            float f9 = fArr[2];
            if (!Float.isNaN(f9)) {
                f3 = f9;
            }
            float f10 = fArr[3];
            if (!Float.isNaN(f10)) {
                f4 = f10;
            }
            float f11 = fArr[0];
            if (!Float.isNaN(f11)) {
                f5 = f11;
            }
            float pixelFromDIP = PixelUtil.toPixelFromDIP(f);
            float pixelFromDIP2 = PixelUtil.toPixelFromDIP(f3);
            float pixelFromDIP3 = PixelUtil.toPixelFromDIP(f4);
            float pixelFromDIP4 = PixelUtil.toPixelFromDIP(f5);
            EnumSet<SafeAreaViewEdges> edges = this.mLocalData.getEdges();
            EdgeInsets insets = this.mLocalData.getInsets();
            float f12 = edges.contains(SafeAreaViewEdges.TOP) ? insets.top : 0.0f;
            float f13 = edges.contains(SafeAreaViewEdges.RIGHT) ? insets.right : 0.0f;
            float f14 = edges.contains(SafeAreaViewEdges.BOTTOM) ? insets.bottom : 0.0f;
            if (edges.contains(SafeAreaViewEdges.LEFT)) {
                f2 = insets.left;
            }
            if (this.mLocalData.getMode() == SafeAreaViewMode.PADDING) {
                super.setPadding(1, f12 + pixelFromDIP);
                super.setPadding(2, f13 + pixelFromDIP2);
                super.setPadding(3, f14 + pixelFromDIP3);
                super.setPadding(0, f2 + pixelFromDIP4);
                return;
            }
            super.setMargin(1, f12 + pixelFromDIP);
            super.setMargin(2, f13 + pixelFromDIP2);
            super.setMargin(3, f14 + pixelFromDIP3);
            super.setMargin(0, f2 + pixelFromDIP4);
        }
    }

    private void resetInsets(SafeAreaViewMode safeAreaViewMode) {
        if (safeAreaViewMode == SafeAreaViewMode.PADDING) {
            super.setPadding(1, this.mPaddings[1]);
            super.setPadding(2, this.mPaddings[1]);
            super.setPadding(3, this.mPaddings[3]);
            super.setPadding(0, this.mPaddings[0]);
            return;
        }
        super.setMargin(1, this.mMargins[1]);
        super.setMargin(2, this.mMargins[1]);
        super.setMargin(3, this.mMargins[3]);
        super.setMargin(0, this.mMargins[0]);
    }

    public void onBeforeLayout() {
        if (this.mNeedsUpdate) {
            this.mNeedsUpdate = false;
            updateInsets();
        }
    }

    public void onBeforeLayout(NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        if (this.mNeedsUpdate) {
            this.mNeedsUpdate = false;
            updateInsets();
        }
    }

    public void setLocalData(Object obj) {
        if (obj instanceof SafeAreaViewLocalData) {
            SafeAreaViewLocalData safeAreaViewLocalData = (SafeAreaViewLocalData) obj;
            SafeAreaViewLocalData safeAreaViewLocalData2 = this.mLocalData;
            if (!(safeAreaViewLocalData2 == null || safeAreaViewLocalData2.getMode() == safeAreaViewLocalData.getMode())) {
                resetInsets(this.mLocalData.getMode());
            }
            this.mLocalData = safeAreaViewLocalData;
            this.mNeedsUpdate = false;
            updateInsets();
        }
    }

    @ReactPropGroup(names = {"padding", "paddingVertical", "paddingHorizontal", "paddingStart", "paddingEnd", "paddingTop", "paddingBottom", "paddingLeft", "paddingRight"})
    public void setPaddings(int i, Dynamic dynamic) {
        this.mPaddings[ViewProps.PADDING_MARGIN_SPACING_TYPES[i]] = dynamic.getType() == ReadableType.Number ? (float) dynamic.asDouble() : Float.NaN;
        super.setPaddings(i, dynamic);
        this.mNeedsUpdate = true;
    }

    @ReactPropGroup(names = {"margin", "marginVertical", "marginHorizontal", "marginStart", "marginEnd", "marginTop", "marginBottom", "marginLeft", "marginRight"})
    public void setMargins(int i, Dynamic dynamic) {
        this.mMargins[ViewProps.PADDING_MARGIN_SPACING_TYPES[i]] = dynamic.getType() == ReadableType.Number ? (float) dynamic.asDouble() : Float.NaN;
        super.setMargins(i, dynamic);
        this.mNeedsUpdate = true;
    }
}
