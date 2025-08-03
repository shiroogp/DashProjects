package com.facebook.react;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import co.apptailor.googlesignin.RNGoogleSigninPackage;
import com.BV.LinearGradient.LinearGradientPackage;
import com.RNAppleAuthentication.AppleAuthenticationAndroidPackage;
import com.RNFetchBlob.RNFetchBlobPackage;
import com.arthenica.ffmpegkit.reactnative.FFmpegKitReactNativePackage;
import com.brentvatne.react.ReactVideoPackage;
import com.corbt.keepawake.KCKeepAwakePackage;
import com.dylanvann.fastimage.FastImageViewPackage;
import com.eko.RNBackgroundDownloaderPackage;
import com.facebook.react.shell.MainPackageConfig;
import com.facebook.react.shell.MainReactPackage;
import com.learnium.RNDeviceInfo.RNDeviceInfo;
import com.lugg.ReactNativeConfig.ReactNativeConfigPackage;
import com.oblador.vectoricons.VectorIconsPackage;
import com.pedrouid.crypto.RNSCCryptoPackage;
import com.reactlibrary.rnwifi.RNWifiPackage;
import com.reactnative.ivpusic.imagepicker.PickerPackage;
import com.reactnativecommunity.asyncstorage.AsyncStoragePackage;
import com.reactnativecommunity.netinfo.NetInfoPackage;
import com.reactnativecommunity.picker.RNCPickerPackage;
import com.reactnativerestart.RestartPackage;
import com.rnfs.RNFSPackage;
import com.swmansion.gesturehandler.RNGestureHandlerPackage;
import com.swmansion.reanimated.ReanimatedPackage;
import com.swmansion.rnscreens.RNScreensPackage;
import com.th3rdwave.safeareacontext.SafeAreaContextPackage;
import com.zoontek.rnpermissions.RNPermissionsPackage;
import io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsPackage;
import io.invertase.firebase.app.ReactNativeFirebaseAppPackage;
import io.invertase.firebase.auth.ReactNativeFirebaseAuthPackage;
import io.invertase.firebase.crashlytics.ReactNativeFirebaseCrashlyticsPackage;
import io.invertase.firebase.database.ReactNativeFirebaseDatabasePackage;
import io.invertase.firebase.storage.ReactNativeFirebaseStoragePackage;
import it.innove.BleManagerPackage;
import java.util.ArrayList;
import java.util.Arrays;
import org.reactnative.camera.RNCameraPackage;
import org.reactnative.maskedview.RNCMaskedViewPackage;

public class PackageList {
    private Application application;
    private MainPackageConfig mConfig;
    private ReactNativeHost reactNativeHost;

    public PackageList(ReactNativeHost reactNativeHost2) {
        this(reactNativeHost2, (MainPackageConfig) null);
    }

    public PackageList(Application application2) {
        this(application2, (MainPackageConfig) null);
    }

    public PackageList(ReactNativeHost reactNativeHost2, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = reactNativeHost2;
        this.mConfig = mainPackageConfig;
    }

    public PackageList(Application application2, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = null;
        this.application = application2;
        this.mConfig = mainPackageConfig;
    }

    private ReactNativeHost getReactNativeHost() {
        return this.reactNativeHost;
    }

    private Resources getResources() {
        return getApplication().getResources();
    }

    private Application getApplication() {
        ReactNativeHost reactNativeHost2 = this.reactNativeHost;
        if (reactNativeHost2 == null) {
            return this.application;
        }
        return reactNativeHost2.getApplication();
    }

    private Context getApplicationContext() {
        return getApplication().getApplicationContext();
    }

    public ArrayList<ReactPackage> getPackages() {
        return new ArrayList<>(Arrays.asList(new ReactPackage[]{new MainReactPackage(this.mConfig), new AppleAuthenticationAndroidPackage(), new RNBackgroundDownloaderPackage(), new AsyncStoragePackage(), new RNCMaskedViewPackage(), new NetInfoPackage(), new ReactNativeFirebaseAnalyticsPackage(), new ReactNativeFirebaseAppPackage(), new ReactNativeFirebaseAuthPackage(), new ReactNativeFirebaseCrashlyticsPackage(), new ReactNativeFirebaseDatabasePackage(), new ReactNativeFirebaseStoragePackage(), new RNGoogleSigninPackage(), new RNCPickerPackage(), new FFmpegKitReactNativePackage(), new BleManagerPackage(), new RNCameraPackage(), new ReactNativeConfigPackage(), new RNDeviceInfo(), new FastImageViewPackage(), new RNFSPackage(), new RNGestureHandlerPackage(), new PickerPackage(), new KCKeepAwakePackage(), new LinearGradientPackage(), new RNPermissionsPackage(), new ReanimatedPackage(), new RestartPackage(), new SafeAreaContextPackage(), new RNScreensPackage(), new RNSCCryptoPackage(), new VectorIconsPackage(), new ReactVideoPackage(), new RNWifiPackage(), new RNFetchBlobPackage()}));
    }
}
