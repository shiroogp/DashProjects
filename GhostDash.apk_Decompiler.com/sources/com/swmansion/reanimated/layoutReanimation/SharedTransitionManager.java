package com.swmansion.reanimated.layoutReanimation;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.views.view.ReactViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public class SharedTransitionManager {
    private final List<View> mAddedSharedViews = new ArrayList();
    /* access modifiers changed from: private */
    public final AnimationsManager mAnimationsManager;
    private final Map<Integer, View> mCurrentSharedTransitionViews = new HashMap();
    private final Map<Integer, Integer> mDisableCleaningForViewTag = new HashMap();
    private boolean mIsSharedTransitionActive;
    /* access modifiers changed from: private */
    public NativeMethodsHolder mNativeMethodsHolder;
    /* access modifiers changed from: private */
    public final List<View> mRemovedSharedViews = new ArrayList();
    private List<SharedElement> mSharedElements = new ArrayList();
    private final Map<Integer, Integer> mSharedTransitionInParentIndex = new HashMap();
    private final Map<Integer, View> mSharedTransitionParent = new HashMap();
    private final Map<Integer, Snapshot> mSnapshotRegistry = new HashMap();
    private View mTransitionContainer;
    private final Set<Integer> mViewTagsToHide = new HashSet();
    private final Map<Integer, View> mViewsWithCanceledAnimation = new HashMap();

    interface TreeVisitor {
        void run(View view);
    }

    public SharedTransitionManager(AnimationsManager animationsManager) {
        this.mAnimationsManager = animationsManager;
    }

    /* access modifiers changed from: protected */
    public void notifyAboutNewView(View view) {
        this.mAddedSharedViews.add(view);
    }

    /* access modifiers changed from: protected */
    public void notifyAboutRemovedView(View view) {
        this.mRemovedSharedViews.add(view);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public View getTransitioningView(int i) {
        return this.mCurrentSharedTransitionViews.get(Integer.valueOf(i));
    }

    /* access modifiers changed from: protected */
    public void screenDidLayout() {
        tryStartSharedTransitionForViews(this.mAddedSharedViews, true);
        this.mAddedSharedViews.clear();
    }

    /* access modifiers changed from: protected */
    public void viewDidLayout(View view) {
        maybeRestartAnimationWithNewLayout(view);
    }

    /* access modifiers changed from: protected */
    public void onViewsRemoval(int[] iArr) {
        if (iArr != null) {
            restoreVisibility();
            visitTreeForTags(iArr, new SnapshotTreeVisitor());
            if (this.mRemovedSharedViews.size() > 0) {
                if (!tryStartSharedTransitionForViews(this.mRemovedSharedViews, false)) {
                    this.mRemovedSharedViews.clear();
                    return;
                }
                ConfigCleanerTreeVisitor configCleanerTreeVisitor = new ConfigCleanerTreeVisitor();
                for (View visitTree : this.mRemovedSharedViews) {
                    visitTree(visitTree, configCleanerTreeVisitor);
                }
                this.mRemovedSharedViews.clear();
                visitTreeForTags(iArr, configCleanerTreeVisitor);
            } else if (this.mCurrentSharedTransitionViews.size() > 0) {
                ArrayList<View> arrayList = new ArrayList<>();
                for (View next : this.mCurrentSharedTransitionViews.values()) {
                    for (int isViewChildParentWithTag : iArr) {
                        if (isViewChildParentWithTag(next, isViewChildParentWithTag)) {
                            arrayList.add(next);
                        }
                    }
                }
                tryStartSharedTransitionForViews(arrayList, false);
                for (View clearAllSharedConfigsForView : arrayList) {
                    clearAllSharedConfigsForView(clearAllSharedConfigsForView);
                }
            }
        }
    }

    private void restoreVisibility() {
        ReanimatedNativeHierarchyManager reanimatedNativeHierarchyManager = this.mAnimationsManager.getReanimatedNativeHierarchyManager();
        for (Integer intValue : this.mViewTagsToHide) {
            View resolveView = reanimatedNativeHierarchyManager.resolveView(intValue.intValue());
            if (resolveView != null) {
                resolveView.setVisibility(0);
            }
        }
        this.mViewTagsToHide.clear();
    }

    private boolean isViewChildParentWithTag(View view, int i) {
        Object obj = this.mSharedTransitionParent.get(Integer.valueOf(view.getId()));
        while (true) {
            View view2 = (View) obj;
            if (view2 != null) {
                if (view2.getId() != i) {
                    if (view2.getClass().getSimpleName().equals("Screen") || !(view2 instanceof View)) {
                        break;
                    }
                    obj = view2.getParent();
                } else {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void doSnapshotForTopScreenViews(ViewGroup viewGroup) {
        if (viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof ViewGroup) {
                visitNativeTreeAndMakeSnapshot(((ViewGroup) childAt).getChildAt(0));
            } else {
                Log.e("[Reanimated]", "Unable to recognize screen on stack.");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setNativeMethods(NativeMethodsHolder nativeMethodsHolder) {
        this.mNativeMethodsHolder = nativeMethodsHolder;
    }

    private void maybeRestartAnimationWithNewLayout(View view) {
        View view2 = this.mCurrentSharedTransitionViews.get(Integer.valueOf(view.getId()));
        if (view2 != null) {
            ArrayList arrayList = new ArrayList();
            for (SharedElement next : this.mSharedElements) {
                if (next.targetView == view2) {
                    arrayList.add(next);
                    View view3 = next.sourceView;
                    View view4 = next.targetView;
                    Snapshot snapshot = new Snapshot(view3);
                    Snapshot snapshot2 = this.mSnapshotRegistry.get(Integer.valueOf(view4.getId()));
                    Snapshot snapshot3 = new Snapshot(view4);
                    int i = (snapshot2.originX - snapshot2.originXByParent) + snapshot3.originX;
                    int i2 = (snapshot2.originY - snapshot2.originYByParent) + snapshot3.originY;
                    snapshot2.originX = i;
                    snapshot2.originY = i2;
                    snapshot2.globalOriginX = i;
                    snapshot2.globalOriginY = i2;
                    snapshot2.originXByParent = snapshot3.originXByParent;
                    snapshot2.originYByParent = snapshot3.originYByParent;
                    snapshot2.height = snapshot3.height;
                    snapshot2.width = snapshot3.width;
                    next.sourceViewSnapshot = snapshot;
                    next.targetViewSnapshot = snapshot2;
                    disableCleaningForViewTag(view3.getId());
                    disableCleaningForViewTag(view4.getId());
                }
            }
            startSharedTransition(arrayList);
        }
    }

    private boolean tryStartSharedTransitionForViews(List<View> list, boolean z) {
        if (list.isEmpty()) {
            return false;
        }
        sortViewsByTags(list);
        List<SharedElement> sharedElementsForCurrentTransition = getSharedElementsForCurrentTransition(list, z);
        if (sharedElementsForCurrentTransition.isEmpty()) {
            return false;
        }
        setupTransitionContainer();
        reparentSharedViewsForCurrentTransition(sharedElementsForCurrentTransition);
        startSharedTransition(sharedElementsForCurrentTransition);
        return true;
    }

    private void sortViewsByTags(List<View> list) {
        Collections.sort(list, $$Lambda$SharedTransitionManager$OlK7QO6YQS4K7VRkUAYdfTSHFM.INSTANCE);
    }

    private List<SharedElement> getSharedElementsForCurrentTransition(List<View> list, boolean z) {
        View view;
        ViewGroup viewGroup;
        ViewGroupManager viewGroupManager;
        int childCount;
        ArrayList<View> arrayList = new ArrayList<>();
        HashSet hashSet = new HashSet();
        if (!z) {
            for (View id : list) {
                hashSet.add(Integer.valueOf(id.getId()));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ReanimatedNativeHierarchyManager reanimatedNativeHierarchyManager = this.mAnimationsManager.getReanimatedNativeHierarchyManager();
        for (View next : list) {
            int findPrecedingViewTagForTransition = this.mNativeMethodsHolder.findPrecedingViewTagForTransition(next.getId());
            boolean z2 = !z && hashSet.contains(Integer.valueOf(findPrecedingViewTagForTransition));
            if (findPrecedingViewTagForTransition >= 0) {
                if (z) {
                    View resolveView = reanimatedNativeHierarchyManager.resolveView(findPrecedingViewTagForTransition);
                    view = next;
                    next = resolveView;
                } else {
                    view = reanimatedNativeHierarchyManager.resolveView(findPrecedingViewTagForTransition);
                }
                if (z2) {
                    clearAllSharedConfigsForView(next);
                    clearAllSharedConfigsForView(view);
                } else {
                    boolean containsKey = this.mCurrentSharedTransitionViews.containsKey(Integer.valueOf(next.getId()));
                    boolean containsKey2 = this.mCurrentSharedTransitionViews.containsKey(Integer.valueOf(view.getId()));
                    if (!containsKey && !containsKey2) {
                        View findScreen = findScreen(next);
                        View findScreen2 = findScreen(view);
                        if (!(findScreen == null || findScreen2 == null || (viewGroup = (ViewGroup) findStack(findScreen)) == null || (childCount = viewGroupManager.getChildCount(viewGroup)) < 2)) {
                            View childAt = (viewGroupManager = (ViewGroupManager) reanimatedNativeHierarchyManager.resolveViewManager(viewGroup.getId())).getChildAt(viewGroup, childCount - 1);
                            View childAt2 = viewGroupManager.getChildAt(viewGroup, childCount - 2);
                            if (!(!z ? childAt.getId() == findScreen.getId() && childAt2.getId() == findScreen2.getId() : childAt2.getId() == findScreen.getId() && childAt.getId() == findScreen2.getId())) {
                            }
                        }
                    }
                    Snapshot snapshot = null;
                    if (z) {
                        this.mViewTagsToHide.add(Integer.valueOf(next.getId()));
                        if (containsKey) {
                            snapshot = new Snapshot(next);
                        } else {
                            makeSnapshot(next);
                        }
                        makeSnapshot(view);
                    } else if (containsKey) {
                        makeSnapshot(next);
                    }
                    if (snapshot == null) {
                        snapshot = this.mSnapshotRegistry.get(Integer.valueOf(next.getId()));
                    }
                    arrayList.add(next);
                    arrayList.add(view);
                    arrayList2.add(new SharedElement(next, snapshot, view, this.mSnapshotRegistry.get(Integer.valueOf(view.getId()))));
                }
            }
        }
        if (!arrayList.isEmpty()) {
            for (View next2 : this.mCurrentSharedTransitionViews.values()) {
                if (arrayList.contains(next2)) {
                    disableCleaningForViewTag(next2.getId());
                } else {
                    this.mViewsWithCanceledAnimation.put(Integer.valueOf(next2.getId()), next2);
                }
            }
            this.mCurrentSharedTransitionViews.clear();
            for (View view2 : arrayList) {
                this.mCurrentSharedTransitionViews.put(Integer.valueOf(view2.getId()), view2);
            }
            for (View view3 : new ArrayList(this.mViewsWithCanceledAnimation.values())) {
                cancelAnimation(view3);
                finishSharedAnimation(view3.getId());
            }
        }
        this.mSharedElements = arrayList2;
        return arrayList2;
    }

    private void setupTransitionContainer() {
        if (!this.mIsSharedTransitionActive) {
            this.mIsSharedTransitionActive = true;
            ReactContext context = this.mAnimationsManager.getContext();
            Activity currentActivity = context.getCurrentActivity();
            if (currentActivity != null) {
                ViewGroup viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView().getRootView();
                if (this.mTransitionContainer == null) {
                    this.mTransitionContainer = new ReactViewGroup(context);
                }
                viewGroup.addView(this.mTransitionContainer);
                this.mTransitionContainer.bringToFront();
            }
        }
    }

    private void reparentSharedViewsForCurrentTransition(List<SharedElement> list) {
        for (SharedElement next : list) {
            View view = next.sourceView;
            View view2 = next.targetView;
            if (!this.mSharedTransitionParent.containsKey(Integer.valueOf(view.getId()))) {
                this.mSharedTransitionParent.put(Integer.valueOf(view.getId()), (View) view.getParent());
                this.mSharedTransitionInParentIndex.put(Integer.valueOf(view.getId()), Integer.valueOf(((ViewGroup) view.getParent()).indexOfChild(view)));
                ((ViewGroup) view.getParent()).removeView(view);
                ((ViewGroup) this.mTransitionContainer).addView(view);
            }
            if (!this.mSharedTransitionParent.containsKey(Integer.valueOf(view2.getId()))) {
                this.mSharedTransitionParent.put(Integer.valueOf(view2.getId()), (View) view2.getParent());
                this.mSharedTransitionInParentIndex.put(Integer.valueOf(view2.getId()), Integer.valueOf(((ViewGroup) view2.getParent()).indexOfChild(view2)));
                ((ViewGroup) view2.getParent()).removeView(view2);
                ((ViewGroup) this.mTransitionContainer).addView(view2);
            }
        }
    }

    private void startSharedTransition(List<SharedElement> list) {
        for (SharedElement next : list) {
            startSharedAnimationForView(next.sourceView, next.sourceViewSnapshot, next.targetViewSnapshot);
            startSharedAnimationForView(next.targetView, next.sourceViewSnapshot, next.targetViewSnapshot);
        }
    }

    private void startSharedAnimationForView(View view, Snapshot snapshot, Snapshot snapshot2) {
        HashMap<String, Object> targetMap = snapshot2.toTargetMap();
        HashMap<String, Object> prepareDataForAnimationWorklet = this.mAnimationsManager.prepareDataForAnimationWorklet(snapshot.toCurrentMap(), false, true);
        HashMap hashMap = new HashMap(this.mAnimationsManager.prepareDataForAnimationWorklet(targetMap, true, true));
        hashMap.putAll(prepareDataForAnimationWorklet);
        this.mNativeMethodsHolder.startAnimation(view.getId(), 4, hashMap);
    }

    /* access modifiers changed from: protected */
    public void finishSharedAnimation(int i) {
        ViewParent parent;
        if (this.mDisableCleaningForViewTag.containsKey(Integer.valueOf(i))) {
            enableCleaningForViewTag(i);
            return;
        }
        View view = this.mCurrentSharedTransitionViews.get(Integer.valueOf(i));
        if (view == null && (view = this.mViewsWithCanceledAnimation.get(Integer.valueOf(i))) != null) {
            this.mViewsWithCanceledAnimation.remove(Integer.valueOf(view.getId()));
        }
        if (view != null) {
            int id = view.getId();
            ((ViewGroup) this.mTransitionContainer).removeView(view);
            int intValue = this.mSharedTransitionInParentIndex.get(Integer.valueOf(id)).intValue();
            ViewGroup viewGroup = (ViewGroup) this.mSharedTransitionParent.get(Integer.valueOf(id));
            if (intValue <= viewGroup.getChildCount()) {
                viewGroup.addView(view, intValue);
            } else {
                viewGroup.addView(view);
            }
            Snapshot snapshot = this.mSnapshotRegistry.get(Integer.valueOf(id));
            if (snapshot != null) {
                int i2 = snapshot.originY;
                if (findStack(view) == null) {
                    snapshot.originY = snapshot.originYByParent;
                }
                HashMap<String, Object> basicMap = snapshot.toBasicMap();
                HashMap hashMap = new HashMap();
                for (String next : basicMap.keySet()) {
                    Object obj = basicMap.get(next);
                    if (next.equals(Snapshot.TRANSFORM_MATRIX)) {
                        hashMap.put(next, obj);
                    } else {
                        hashMap.put(next, Double.valueOf((double) PixelUtil.toDIPFromPixel((float) ((Integer) obj).intValue())));
                    }
                }
                this.mAnimationsManager.progressLayoutAnimation(id, hashMap, true);
                snapshot.originY = i2;
            }
            if (this.mViewTagsToHide.contains(Integer.valueOf(i))) {
                view.setVisibility(4);
            }
            this.mCurrentSharedTransitionViews.remove(Integer.valueOf(id));
            this.mSharedTransitionParent.remove(Integer.valueOf(id));
            this.mSharedTransitionInParentIndex.remove(Integer.valueOf(id));
        }
        if (this.mCurrentSharedTransitionViews.isEmpty()) {
            View view2 = this.mTransitionContainer;
            if (!(view2 == null || (parent = view2.getParent()) == null)) {
                ((ViewGroup) parent).removeView(this.mTransitionContainer);
            }
            this.mSharedElements.clear();
            this.mIsSharedTransitionActive = false;
        }
    }

    @Nullable
    private View findScreen(View view) {
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent.getClass().getSimpleName().equals("Screen")) {
                return (View) parent;
            }
        }
        return null;
    }

    @Nullable
    private View findStack(View view) {
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent.getClass().getSimpleName().equals("ScreenStack")) {
                return (View) parent;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void makeSnapshot(View view) {
        this.mSnapshotRegistry.put(Integer.valueOf(view.getId()), new Snapshot(view));
    }

    class SnapshotTreeVisitor implements TreeVisitor {
        SnapshotTreeVisitor() {
        }

        public void run(View view) {
            if (SharedTransitionManager.this.mAnimationsManager.hasAnimationForTag(view.getId(), 4)) {
                SharedTransitionManager.this.mRemovedSharedViews.add(view);
                SharedTransitionManager.this.makeSnapshot(view);
            }
        }
    }

    class ConfigCleanerTreeVisitor implements TreeVisitor {
        ConfigCleanerTreeVisitor() {
        }

        public void run(View view) {
            SharedTransitionManager.this.mNativeMethodsHolder.clearAnimationConfig(view.getId());
        }
    }

    /* access modifiers changed from: protected */
    public void visitTreeForTags(int[] iArr, TreeVisitor treeVisitor) {
        if (iArr != null) {
            ReanimatedNativeHierarchyManager reanimatedNativeHierarchyManager = this.mAnimationsManager.getReanimatedNativeHierarchyManager();
            for (int resolveView : iArr) {
                visitTree(reanimatedNativeHierarchyManager.resolveView(resolveView), treeVisitor);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.facebook.react.uimanager.ViewManager] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void visitTree(android.view.View r5, com.swmansion.reanimated.layoutReanimation.SharedTransitionManager.TreeVisitor r6) {
        /*
            r4 = this;
            int r0 = r5.getId()
            r1 = -1
            if (r0 != r1) goto L_0x0008
            return
        L_0x0008:
            r1 = 0
            com.swmansion.reanimated.layoutReanimation.AnimationsManager r2 = r4.mAnimationsManager
            com.swmansion.reanimated.layoutReanimation.ReanimatedNativeHierarchyManager r2 = r2.getReanimatedNativeHierarchyManager()
            r6.run(r5)     // Catch:{ IllegalViewOperationException -> 0x0038 }
            boolean r3 = r5 instanceof android.view.ViewGroup     // Catch:{ IllegalViewOperationException -> 0x0038 }
            if (r3 != 0) goto L_0x0017
            return
        L_0x0017:
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5     // Catch:{ IllegalViewOperationException -> 0x0038 }
            com.facebook.react.uimanager.ViewManager r0 = r2.resolveViewManager(r0)     // Catch:{ IllegalViewOperationException -> 0x0038 }
            boolean r2 = r0 instanceof com.facebook.react.uimanager.ViewGroupManager     // Catch:{ IllegalViewOperationException -> 0x0038 }
            if (r2 == 0) goto L_0x0024
            r1 = r0
            com.facebook.react.uimanager.ViewGroupManager r1 = (com.facebook.react.uimanager.ViewGroupManager) r1     // Catch:{ IllegalViewOperationException -> 0x0038 }
        L_0x0024:
            if (r1 != 0) goto L_0x0027
            return
        L_0x0027:
            r0 = 0
        L_0x0028:
            int r2 = r1.getChildCount(r5)
            if (r0 >= r2) goto L_0x0038
            android.view.View r2 = r1.getChildAt(r5, r0)
            r4.visitTree(r2, r6)
            int r0 = r0 + 1
            goto L_0x0028
        L_0x0038:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.reanimated.layoutReanimation.SharedTransitionManager.visitTree(android.view.View, com.swmansion.reanimated.layoutReanimation.SharedTransitionManager$TreeVisitor):void");
    }

    /* access modifiers changed from: package-private */
    public void visitNativeTreeAndMakeSnapshot(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (this.mAnimationsManager.hasAnimationForTag(view.getId(), 4)) {
                makeSnapshot(view);
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                visitNativeTreeAndMakeSnapshot(viewGroup.getChildAt(i));
            }
        }
    }

    private void clearAllSharedConfigsForView(View view) {
        int id = view.getId();
        this.mSnapshotRegistry.remove(Integer.valueOf(id));
        this.mNativeMethodsHolder.clearAnimationConfig(id);
    }

    private void cancelAnimation(View view) {
        this.mNativeMethodsHolder.cancelAnimation(view.getId(), 4, true, true);
    }

    private void disableCleaningForViewTag(int i) {
        Integer num = this.mDisableCleaningForViewTag.get(Integer.valueOf(i));
        if (num != null) {
            this.mDisableCleaningForViewTag.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
        } else {
            this.mDisableCleaningForViewTag.put(Integer.valueOf(i), 1);
        }
    }

    private void enableCleaningForViewTag(int i) {
        Integer num = this.mDisableCleaningForViewTag.get(Integer.valueOf(i));
        if (num != null) {
            if (num.intValue() == 1) {
                this.mDisableCleaningForViewTag.remove(Integer.valueOf(i));
            } else {
                this.mDisableCleaningForViewTag.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
            }
        }
    }
}
