package com.pedrouid.crypto;

import android.util.Base64;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;

public class RNSCSha extends ReactContextBaseJavaModule {
    private static ArrayList<String> algorithms = new ArrayList<>(Arrays.asList(new String[]{"SHA-1", "SHA-256", "SHA-512"}));

    public String getName() {
        return "RNSCSha";
    }

    public RNSCSha(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private byte[] sha(byte[] bArr, String str) throws Exception {
        if (algorithms.contains(str)) {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return instance.digest();
        }
        throw new Exception("Invalid algorithm");
    }

    @ReactMethod
    public void shaBase64(String str, String str2, Promise promise) throws Exception {
        try {
            promise.resolve(Base64.encodeToString(sha(Base64.decode(str, 2), str2), 2));
        } catch (Exception e) {
            promise.reject("-1", e.getMessage());
        }
    }

    @ReactMethod
    public void shaUtf8(String str, String str2, Promise promise) throws Exception {
        try {
            promise.resolve(Util.bytesToHex(sha(str.getBytes(), str2)));
        } catch (Exception e) {
            promise.reject("-1", e.getMessage());
        }
    }
}
