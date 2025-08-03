package com.google.firebase.crashlytics.internal;

import android.content.Context;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.IOException;

public class DevelopmentPlatformProvider {
    private static final String FLUTTER_ASSETS_PATH = "flutter_assets";
    private static final String FLUTTER_PLATFORM = "Flutter";
    private static final String UNITY_PLATFORM = "Unity";
    private static final String UNITY_VERSION_FIELD = "com.google.firebase.crashlytics.unity_version";
    /* access modifiers changed from: private */
    public final Context context;
    private DevelopmentPlatform developmentPlatform = null;

    public DevelopmentPlatformProvider(Context context2) {
        this.context = context2;
    }

    public String getDevelopmentPlatform() {
        return initDevelopmentPlatform().developmentPlatform;
    }

    public String getDevelopmentPlatformVersion() {
        return initDevelopmentPlatform().developmentPlatformVersion;
    }

    public static boolean isUnity(Context context2) {
        return CommonUtils.getResourcesIdentifier(context2, UNITY_VERSION_FIELD, "string") != 0;
    }

    /* access modifiers changed from: private */
    public boolean assetPathExists(String str) {
        String[] list;
        try {
            if (this.context.getAssets() == null || (list = this.context.getAssets().list(str)) == null || list.length <= 0) {
                return false;
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private DevelopmentPlatform initDevelopmentPlatform() {
        if (this.developmentPlatform == null) {
            this.developmentPlatform = new DevelopmentPlatform();
        }
        return this.developmentPlatform;
    }

    private class DevelopmentPlatform {
        /* access modifiers changed from: private */
        public final String developmentPlatform;
        /* access modifiers changed from: private */
        public final String developmentPlatformVersion;

        private DevelopmentPlatform() {
            int resourcesIdentifier = CommonUtils.getResourcesIdentifier(DevelopmentPlatformProvider.this.context, DevelopmentPlatformProvider.UNITY_VERSION_FIELD, "string");
            if (resourcesIdentifier != 0) {
                this.developmentPlatform = DevelopmentPlatformProvider.UNITY_PLATFORM;
                String string = DevelopmentPlatformProvider.this.context.getResources().getString(resourcesIdentifier);
                this.developmentPlatformVersion = string;
                Logger.getLogger().v("Unity Editor version is: " + string);
            } else if (DevelopmentPlatformProvider.this.assetPathExists(DevelopmentPlatformProvider.FLUTTER_ASSETS_PATH)) {
                this.developmentPlatform = DevelopmentPlatformProvider.FLUTTER_PLATFORM;
                this.developmentPlatformVersion = null;
                Logger.getLogger().v("Development platform is: Flutter");
            } else {
                this.developmentPlatform = null;
                this.developmentPlatformVersion = null;
            }
        }
    }
}
