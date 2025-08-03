package com.pedrouid.crypto;

import android.os.AsyncTask;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableNativeMap;
import java.security.NoSuchAlgorithmException;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2ParameterSpec;

public class RNSCRsa extends ReactContextBaseJavaModule {
    private final ReactApplicationContext reactContext;

    public String getName() {
        return "RNSCRsa";
    }

    public RNSCRsa(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    /* access modifiers changed from: private */
    public String getAlgorithmFromHash(String str) {
        if (str.equals("Raw")) {
            return "NONEwithRSA";
        }
        if (str.equals("SHA1")) {
            return "SHA1withRSA";
        }
        if (str.equals("SHA224")) {
            return "SHA224withRSA";
        }
        if (str.equals(McElieceCCA2ParameterSpec.DEFAULT_MD)) {
            return "SHA256withRSA";
        }
        if (str.equals("SHA384")) {
            return "SHA384withRSA";
        }
        if (str.equals("SHA512")) {
        }
        return "SHA512withRSA";
    }

    @ReactMethod
    public void generate(Promise promise) {
        generateKeys(2048, promise);
    }

    @ReactMethod
    public void generateKeys(final int i, final Promise promise) {
        AsyncTask.execute(new Runnable() {
            public void run() {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                try {
                    RSA rsa = new RSA();
                    rsa.generate(i);
                    writableNativeMap.putString("public", rsa.getPublicKey());
                    writableNativeMap.putString("private", rsa.getPrivateKey());
                    promise.resolve(writableNativeMap);
                } catch (NoSuchAlgorithmException e) {
                    promise.reject("Error", e.getMessage());
                } catch (Exception e2) {
                    promise.reject("Error", e2.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void encrypt(final String str, final String str2, final Promise promise) {
        AsyncTask.execute(new Runnable() {
            public void run() {
                try {
                    RSA rsa = new RSA();
                    rsa.setPublicKey(str2);
                    promise.resolve(rsa.encrypt(str));
                } catch (Exception e) {
                    promise.reject("Error", e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void encrypt64(final String str, final String str2, final Promise promise) {
        AsyncTask.execute(new Runnable() {
            public void run() {
                try {
                    RSA rsa = new RSA();
                    rsa.setPublicKey(str2);
                    promise.resolve(rsa.encrypt64(str));
                } catch (Exception e) {
                    promise.reject("Error", e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void decrypt(final String str, final String str2, final Promise promise) {
        AsyncTask.execute(new Runnable() {
            public void run() {
                try {
                    RSA rsa = new RSA();
                    rsa.setPrivateKey(str2);
                    promise.resolve(rsa.decrypt(str));
                } catch (Exception e) {
                    promise.reject("Error", e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void decrypt64(final String str, final String str2, final Promise promise) {
        AsyncTask.execute(new Runnable() {
            public void run() {
                try {
                    RSA rsa = new RSA();
                    rsa.setPrivateKey(str2);
                    promise.resolve(rsa.decrypt64(str));
                } catch (Exception e) {
                    promise.reject("Error", e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void sign(String str, String str2, String str3, Promise promise) {
        final String str4 = str2;
        final String str5 = str;
        final String str6 = str3;
        final Promise promise2 = promise;
        AsyncTask.execute(new Runnable() {
            public void run() {
                try {
                    RSA rsa = new RSA();
                    rsa.setPrivateKey(str4);
                    promise2.resolve(rsa.sign(str5, RNSCRsa.this.getAlgorithmFromHash(str6)));
                } catch (Exception e) {
                    promise2.reject("Error", e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void sign64(String str, String str2, String str3, Promise promise) {
        final String str4 = str2;
        final String str5 = str;
        final String str6 = str3;
        final Promise promise2 = promise;
        AsyncTask.execute(new Runnable() {
            public void run() {
                try {
                    RSA rsa = new RSA();
                    rsa.setPrivateKey(str4);
                    promise2.resolve(rsa.sign64(str5, RNSCRsa.this.getAlgorithmFromHash(str6)));
                } catch (Exception e) {
                    promise2.reject("Error", e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void verify(String str, String str2, String str3, String str4, Promise promise) {
        final String str5 = str3;
        final String str6 = str;
        final String str7 = str2;
        final String str8 = str4;
        final Promise promise2 = promise;
        AsyncTask.execute(new Runnable() {
            public void run() {
                try {
                    RSA rsa = new RSA();
                    rsa.setPublicKey(str5);
                    promise2.resolve(Boolean.valueOf(rsa.verify(str6, str7, RNSCRsa.this.getAlgorithmFromHash(str8))));
                } catch (Exception e) {
                    promise2.reject("Error", e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void verify64(String str, String str2, String str3, String str4, Promise promise) {
        final String str5 = str3;
        final String str6 = str;
        final String str7 = str2;
        final String str8 = str4;
        final Promise promise2 = promise;
        AsyncTask.execute(new Runnable() {
            public void run() {
                try {
                    RSA rsa = new RSA();
                    rsa.setPublicKey(str5);
                    promise2.resolve(Boolean.valueOf(rsa.verify64(str6, str7, RNSCRsa.this.getAlgorithmFromHash(str8))));
                } catch (Exception e) {
                    promise2.reject("Error", e.getMessage());
                }
            }
        });
    }
}
