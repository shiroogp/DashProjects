package com.pedrouid.crypto;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.util.encoders.Hex;

public class RNSCHmac extends ReactContextBaseJavaModule {
    public static final String HMAC_SHA_256 = "HmacSHA256";

    public String getName() {
        return "RNSCHmac";
    }

    public RNSCHmac(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void hmac256(String str, String str2, Promise promise) {
        try {
            promise.resolve(hmac256(str, str2));
        } catch (Exception e) {
            promise.reject("-1", e.getMessage());
        }
    }

    private static String hmac256(String str, String str2) throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] decode = Hex.decode(str);
        byte[] decode2 = Hex.decode(str2);
        Mac instance = Mac.getInstance(HMAC_SHA_256);
        instance.init(new SecretKeySpec(decode2, HMAC_SHA_256));
        return Util.bytesToHex(instance.doFinal(decode));
    }
}
