package com.facebook.react.fabric;

import com.facebook.react.bridge.JSIModuleProvider;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.fabric.events.EventBeatManager;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.events.FabricEventEmitter;
import com.facebook.react.fabric.mounting.LayoutMetricsConversions;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.mountitems.BatchMountItem;
import com.facebook.react.fabric.mounting.mountitems.DeleteMountItem;
import com.facebook.react.fabric.mounting.mountitems.DispatchIntCommandMountItem;
import com.facebook.react.fabric.mounting.mountitems.DispatchStringCommandMountItem;
import com.facebook.react.fabric.mounting.mountitems.InsertMountItem;
import com.facebook.react.fabric.mounting.mountitems.MountItem;
import com.facebook.react.fabric.mounting.mountitems.PreAllocateViewMountItem;
import com.facebook.react.fabric.mounting.mountitems.RemoveMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateEventEmitterMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateLayoutMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateLocalDataMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdatePaddingMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdatePropsMountItem;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.BatchEventDispatchedListener;
import com.facebook.systrace.Systrace;

public class FabricJSIModuleProvider implements JSIModuleProvider<UIManager> {
    private final ComponentFactoryDelegate mComponentFactoryDelegate;
    private final ReactNativeConfig mConfig;
    private final JavaScriptContextHolder mJSContext;
    private final ReactApplicationContext mReactApplicationContext;

    public FabricJSIModuleProvider(ReactApplicationContext reactApplicationContext, JavaScriptContextHolder javaScriptContextHolder, ComponentFactoryDelegate componentFactoryDelegate, ReactNativeConfig reactNativeConfig) {
        this.mReactApplicationContext = reactApplicationContext;
        this.mJSContext = javaScriptContextHolder;
        this.mComponentFactoryDelegate = componentFactoryDelegate;
        this.mConfig = reactNativeConfig;
    }

    public UIManager get() {
        EventBeatManager eventBeatManager = new EventBeatManager(this.mReactApplicationContext);
        FabricUIManager createUIManager = createUIManager(eventBeatManager);
        Systrace.beginSection(0, "FabricJSIModuleProvider.registerBinding");
        Binding binding = new Binding();
        loadClasses();
        FabricUIManager fabricUIManager = createUIManager;
        binding.register(this.mJSContext, fabricUIManager, eventBeatManager, this.mReactApplicationContext.getCatalystInstance().getReactQueueConfiguration().getJSQueueThread(), this.mComponentFactoryDelegate, this.mConfig);
        Systrace.endSection(0);
        return createUIManager;
    }

    private FabricUIManager createUIManager(EventBeatManager eventBeatManager) {
        Systrace.beginSection(0, "FabricJSIModuleProvider.createUIManager");
        UIManagerModule uIManagerModule = (UIManagerModule) this.mReactApplicationContext.getNativeModule(UIManagerModule.class);
        FabricUIManager fabricUIManager = new FabricUIManager(this.mReactApplicationContext, uIManagerModule.getViewManagerRegistry_DO_NOT_USE(), uIManagerModule.getEventDispatcher(), eventBeatManager);
        Systrace.endSection(0);
        return fabricUIManager;
    }

    private static void loadClasses() {
        Class<BatchEventDispatchedListener> cls = BatchEventDispatchedListener.class;
        Class<ReactNativeConfig> cls2 = ReactNativeConfig.class;
        Class<FabricComponents> cls3 = FabricComponents.class;
        Class<StateWrapper> cls4 = StateWrapper.class;
        Class<FabricEventEmitter> cls5 = FabricEventEmitter.class;
        Class<FabricUIManager> cls6 = FabricUIManager.class;
        Class<GuardedFrameCallback> cls7 = GuardedFrameCallback.class;
        Class<BatchMountItem> cls8 = BatchMountItem.class;
        Class<DeleteMountItem> cls9 = DeleteMountItem.class;
        Class<DispatchIntCommandMountItem> cls10 = DispatchIntCommandMountItem.class;
        Class<DispatchStringCommandMountItem> cls11 = DispatchStringCommandMountItem.class;
        Class<InsertMountItem> cls12 = InsertMountItem.class;
        Class<MountItem> cls13 = MountItem.class;
        Class<RemoveMountItem> cls14 = RemoveMountItem.class;
        Class<UpdateEventEmitterMountItem> cls15 = UpdateEventEmitterMountItem.class;
        Class<UpdateLayoutMountItem> cls16 = UpdateLayoutMountItem.class;
        Class<UpdateLocalDataMountItem> cls17 = UpdateLocalDataMountItem.class;
        Class<UpdatePaddingMountItem> cls18 = UpdatePaddingMountItem.class;
        Class<UpdatePropsMountItem> cls19 = UpdatePropsMountItem.class;
        Class<LayoutMetricsConversions> cls20 = LayoutMetricsConversions.class;
        Class<MountingManager> cls21 = MountingManager.class;
        Class<Binding> cls22 = Binding.class;
        Class<ComponentFactoryDelegate> cls23 = ComponentFactoryDelegate.class;
        Class<EventBeatManager> cls24 = EventBeatManager.class;
        Class<EventEmitterWrapper> cls25 = EventEmitterWrapper.class;
        Class<StateWrapperImpl> cls26 = StateWrapperImpl.class;
        Class<FabricSoLoader> cls27 = FabricSoLoader.class;
        Class<PreAllocateViewMountItem> cls28 = PreAllocateViewMountItem.class;
    }
}
