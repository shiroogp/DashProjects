package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "nativeViewHierarchyManager", "Lcom/facebook/react/uimanager/NativeViewHierarchyManager;", "execute"}, k = 3, mv = {1, 4, 0})
/* compiled from: ScreensShadowNode.kt */
final class ScreensShadowNode$onBeforeLayout$1 implements UIBlock {
    final /* synthetic */ ScreensShadowNode this$0;

    ScreensShadowNode$onBeforeLayout$1(ScreensShadowNode screensShadowNode) {
        this.this$0 = screensShadowNode;
    }

    public final void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
        Intrinsics.checkNotNullParameter(nativeViewHierarchyManager, "nativeViewHierarchyManager");
        View resolveView = nativeViewHierarchyManager.resolveView(this.this$0.getReactTag());
        if (resolveView instanceof ScreenContainer) {
            ((ScreenContainer) resolveView).performUpdates();
        }
    }
}
