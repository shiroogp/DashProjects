package com.pedrouid.crypto;

import android.util.Base64;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.security.SecureRandom;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.util.encoders.Hex;

public class RNSCAes extends ReactContextBaseJavaModule {
    private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS7Padding";
    private static final String KEY_ALGORITHM = "AES";
    static final IvParameterSpec emptyIvSpec = new IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    public String getName() {
        return "RNSCAes";
    }

    public RNSCAes(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void encrypt(String str, String str2, String str3, Promise promise) {
        try {
            promise.resolve(encrypt(str, str2, str3));
        } catch (Exception e) {
            promise.reject("-1", e.getMessage());
        }
    }

    @ReactMethod
    public void decrypt(String str, String str2, String str3, Promise promise) {
        try {
            promise.resolve(decrypt(str, str2, str3));
        } catch (Exception e) {
            promise.reject("-1", e.getMessage());
        }
    }

    @ReactMethod
    public void randomUuid(Promise promise) {
        try {
            promise.resolve(UUID.randomUUID().toString());
        } catch (Exception e) {
            promise.reject("-1", e.getMessage());
        }
    }

    @ReactMethod
    public void randomKey(Integer num, Promise promise) {
        try {
            byte[] bArr = new byte[num.intValue()];
            new SecureRandom().nextBytes(bArr);
            promise.resolve(Util.bytesToHex(bArr));
        } catch (Exception e) {
            promise.reject("-1", e.getMessage());
        }
    }

    private static String encrypt(String str, String str2, String str3) throws Exception {
        if (str == null || str.length() == 0) {
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(Hex.decode(str2), KEY_ALGORITHM);
        Cipher instance = Cipher.getInstance(CIPHER_ALGORITHM);
        instance.init(1, secretKeySpec, str3 == null ? emptyIvSpec : new IvParameterSpec(Hex.decode(str3)));
        return Base64.encodeToString(instance.doFinal(Base64.decode(str, 0)), 2);
    }

    private static String decrypt(String str, String str2, String str3) throws Exception {
        if (str == null || str.length() == 0) {
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(Hex.decode(str2), KEY_ALGORITHM);
        Cipher instance = Cipher.getInstance(CIPHER_ALGORITHM);
        instance.init(2, secretKeySpec, str3 == null ? emptyIvSpec : new IvParameterSpec(Hex.decode(str3)));
        return Base64.encodeToString(instance.doFinal(Base64.decode(str, 0)), 2);
    }
}
