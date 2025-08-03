package com.th3rdwave.safeareacontext;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewManager;
import java.util.EnumSet;

public class SafeAreaViewManager extends ReactViewManager {
    public String getName() {
        return "RNCSafeAreaView";
    }

    public SafeAreaView createViewInstance(ThemedReactContext themedReactContext) {
        return new SafeAreaView(themedReactContext);
    }

    public SafeAreaViewShadowNode createShadowNodeInstance() {
        return new SafeAreaViewShadowNode();
    }

    public Class<? extends LayoutShadowNode> getShadowNodeClass() {
        return SafeAreaViewShadowNode.class;
    }

    @ReactProp(name = "mode")
    public void setMode(SafeAreaView safeAreaView, String str) {
        if (ViewProps.PADDING.equals(str)) {
            safeAreaView.setMode(SafeAreaViewMode.PADDING);
        } else if (ViewProps.MARGIN.equals(str)) {
            safeAreaView.setMode(SafeAreaViewMode.MARGIN);
        }
    }

    @ReactProp(name = "edges")
    public void setEdges(SafeAreaView safeAreaView, ReadableArray readableArray) {
        EnumSet<E> noneOf = EnumSet.noneOf(SafeAreaViewEdges.class);
        if (readableArray != null) {
            for (int i = 0; i < readableArray.size(); i++) {
                String string = readableArray.getString(i);
                if (ViewProps.TOP.equals(string)) {
                    noneOf.add(SafeAreaViewEdges.TOP);
                } else if (ViewProps.RIGHT.equals(string)) {
                    noneOf.add(SafeAreaViewEdges.RIGHT);
                } else if (ViewProps.BOTTOM.equals(string)) {
                    noneOf.add(SafeAreaViewEdges.BOTTOM);
                } else if (ViewProps.LEFT.equals(string)) {
                    noneOf.add(SafeAreaViewEdges.LEFT);
                }
            }
        }
        safeAreaView.setEdges(noneOf);
    }
}
