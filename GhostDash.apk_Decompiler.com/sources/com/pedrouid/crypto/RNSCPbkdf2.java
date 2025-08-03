package com.pedrouid.crypto;

import android.util.Base64;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2ParameterSpec;

public class RNSCPbkdf2 extends ReactContextBaseJavaModule {
    public String getName() {
        return "RNSCPbkdf2";
    }

    public RNSCPbkdf2(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void hash(String str, String str2, Integer num, Integer num2, String str3, Promise promise) {
        try {
            promise.resolve(Base64.encodeToString(pbkdf2(Base64.decode(str, 0), Base64.decode(str2, 0), num, num2, str3), 2));
        } catch (Exception e) {
            promise.reject("-1", e.getMessage());
        }
    }

    private static byte[] pbkdf2(byte[] bArr, byte[] bArr2, Integer num, Integer num2, String str) throws NullPointerException, NoSuchAlgorithmException {
        HashMap hashMap = new HashMap();
        hashMap.put("SHA1", new SHA1Digest());
        hashMap.put("SHA224", new SHA224Digest());
        hashMap.put(McElieceCCA2ParameterSpec.DEFAULT_MD, new SHA256Digest());
        hashMap.put("SHA384", new SHA384Digest());
        hashMap.put("SHA512", new SHA512Digest());
        ExtendedDigest extendedDigest = (ExtendedDigest) hashMap.get(str);
        if (extendedDigest != null) {
            PKCS5S2ParametersGenerator pKCS5S2ParametersGenerator = new PKCS5S2ParametersGenerator(extendedDigest);
            pKCS5S2ParametersGenerator.init(bArr, bArr2, num.intValue());
            return ((KeyParameter) pKCS5S2ParametersGenerator.generateDerivedParameters(num2.intValue() * 8)).getKey();
        }
        throw new NoSuchAlgorithmException("Specified hash algorithm is not supported");
    }
}
