package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

public class CrashlyticsNdkRegistrar implements ComponentRegistrar {
    public List<Component<?>> getComponents() {
        return Arrays.asList(new Component[]{Component.builder(CrashlyticsNativeComponent.class).add(Dependency.required(Context.class)).factory(new ComponentFactory() {
            public final Object create(ComponentContainer componentContainer) {
                return CrashlyticsNdkRegistrar.this.buildCrashlyticsNdk(componentContainer);
            }
        }).eagerInDefaultApp().build(), LibraryVersionComponent.create("fire-cls-ndk", "18.2.8")});
    }

    /* access modifiers changed from: private */
    public CrashlyticsNativeComponent buildCrashlyticsNdk(ComponentContainer componentContainer) {
        Context context = (Context) componentContainer.get(Context.class);
        return FirebaseCrashlyticsNdk.create(context, !DevelopmentPlatformProvider.isUnity(context));
    }
}
