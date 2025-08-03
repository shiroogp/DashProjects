package io.invertase.firebase.auth;

import android.app.Activity;
import android.net.Uri;
import android.os.Parcel;
import android.util.Log;
import com.arthenica.ffmpegkit.reactnative.FFmpegKitReactNativeModule;
import com.brentvatne.react.ReactVideoView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.GithubAuthProvider;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.OAuthProvider;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.TwitterAuthProvider;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.UserProfileChangeRequest;
import io.invertase.firebase.auth.ReactNativeFirebaseAuthModule;
import io.invertase.firebase.common.ReactNativeFirebaseEvent;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import io.invertase.firebase.common.SharedUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

class ReactNativeFirebaseAuthModule extends ReactNativeFirebaseModule {
    private static final String TAG = "Auth";
    private static HashMap<String, FirebaseAuth.AuthStateListener> mAuthListeners = new HashMap<>();
    private static HashMap<String, FirebaseAuth.IdTokenListener> mIdTokenListeners = new HashMap<>();
    /* access modifiers changed from: private */
    public PhoneAuthCredential mCredential;
    /* access modifiers changed from: private */
    public PhoneAuthProvider.ForceResendingToken mForceResendingToken;
    private String mLastPhoneNumber;
    /* access modifiers changed from: private */
    public String mVerificationId;

    ReactNativeFirebaseAuthModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, TAG);
    }

    public void initialize() {
        super.initialize();
        Log.d(TAG, "instance-initialized");
    }

    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        Log.d(TAG, "instance-destroyed");
        Iterator<Map.Entry<String, FirebaseAuth.AuthStateListener>> it2 = mAuthListeners.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry next = it2.next();
            FirebaseAuth.getInstance(FirebaseApp.getInstance((String) next.getKey())).removeAuthStateListener((FirebaseAuth.AuthStateListener) next.getValue());
            it2.remove();
        }
        Iterator<Map.Entry<String, FirebaseAuth.IdTokenListener>> it3 = mIdTokenListeners.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry next2 = it3.next();
            FirebaseAuth.getInstance(FirebaseApp.getInstance((String) next2.getKey())).removeIdTokenListener((FirebaseAuth.IdTokenListener) next2.getValue());
            it3.remove();
        }
    }

    @ReactMethod
    public void addAuthStateListener(String str) {
        Log.d(TAG, "addAuthStateListener");
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        if (mAuthListeners.get(str) == null) {
            $$Lambda$ReactNativeFirebaseAuthModule$3LES0pIezWfVbMdAymxrWGMvRsA r1 = new FirebaseAuth.AuthStateListener(str) {
                public final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void onAuthStateChanged(FirebaseAuth firebaseAuth) {
                    ReactNativeFirebaseAuthModule.this.lambda$addAuthStateListener$0$ReactNativeFirebaseAuthModule(this.f$1, firebaseAuth);
                }
            };
            instance.addAuthStateListener(r1);
            mAuthListeners.put(str, r1);
        }
    }

    public /* synthetic */ void lambda$addAuthStateListener$0$ReactNativeFirebaseAuthModule(String str, FirebaseAuth firebaseAuth) {
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        WritableMap createMap = Arguments.createMap();
        ReactNativeFirebaseEventEmitter sharedInstance = ReactNativeFirebaseEventEmitter.getSharedInstance();
        if (currentUser != null) {
            createMap.putString("appName", str);
            createMap.putMap("user", firebaseUserToMap(currentUser));
        } else {
            createMap.putString("appName", str);
        }
        Log.d(TAG, "addAuthStateListener:eventBody " + createMap.toString());
        sharedInstance.sendEvent(new ReactNativeFirebaseEvent("auth_state_changed", createMap, str));
    }

    @ReactMethod
    public void removeAuthStateListener(String str) {
        Log.d(TAG, "removeAuthStateListener");
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseAuth.AuthStateListener authStateListener = mAuthListeners.get(str);
        if (authStateListener != null) {
            instance.removeAuthStateListener(authStateListener);
            mAuthListeners.remove(str);
        }
    }

    @ReactMethod
    public void addIdTokenListener(String str) {
        Log.d(TAG, "addIdTokenListener");
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        if (!mIdTokenListeners.containsKey(str)) {
            $$Lambda$ReactNativeFirebaseAuthModule$0sGV_gySlJ2impzgzgPAPRsabI r1 = new FirebaseAuth.IdTokenListener(str) {
                public final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void onIdTokenChanged(FirebaseAuth firebaseAuth) {
                    ReactNativeFirebaseAuthModule.this.lambda$addIdTokenListener$1$ReactNativeFirebaseAuthModule(this.f$1, firebaseAuth);
                }
            };
            instance.addIdTokenListener((FirebaseAuth.IdTokenListener) r1);
            mIdTokenListeners.put(str, r1);
        }
    }

    public /* synthetic */ void lambda$addIdTokenListener$1$ReactNativeFirebaseAuthModule(String str, FirebaseAuth firebaseAuth) {
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        ReactNativeFirebaseEventEmitter sharedInstance = ReactNativeFirebaseEventEmitter.getSharedInstance();
        WritableMap createMap = Arguments.createMap();
        if (currentUser != null) {
            createMap.putBoolean("authenticated", true);
            createMap.putString("appName", str);
            createMap.putMap("user", firebaseUserToMap(currentUser));
        } else {
            createMap.putString("appName", str);
            createMap.putBoolean("authenticated", false);
        }
        sharedInstance.sendEvent(new ReactNativeFirebaseEvent("auth_id_token_changed", createMap, str));
    }

    @ReactMethod
    public void removeIdTokenListener(String str) {
        Log.d(TAG, "removeIdTokenListener");
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseAuth.IdTokenListener idTokenListener = mIdTokenListeners.get(str);
        if (idTokenListener != null) {
            instance.removeIdTokenListener(idTokenListener);
            mIdTokenListeners.remove(str);
        }
    }

    @ReactMethod
    public void setAutoRetrievedSmsCodeForPhoneNumber(String str, String str2, String str3, Promise promise) {
        Log.d(TAG, "setAutoRetrievedSmsCodeForPhoneNumber");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getFirebaseAuthSettings().setAutoRetrievedSmsCodeForPhoneNumber(str2, str3);
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void setAppVerificationDisabledForTesting(String str, boolean z, Promise promise) {
        Log.d(TAG, "setAppVerificationDisabledForTesting");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getFirebaseAuthSettings().setAppVerificationDisabledForTesting(z);
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void signOut(String str, Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        Log.d(TAG, "signOut");
        if (instance == null || instance.getCurrentUser() == null) {
            promiseNoUser(promise, true);
            return;
        }
        instance.signOut();
        promiseNoUser(promise, false);
    }

    @ReactMethod
    private void signInAnonymously(String str, Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        Log.d(TAG, "signInAnonymously");
        instance.signInAnonymously().addOnSuccessListener(new OnSuccessListener(promise) {
            public final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onSuccess(Object obj) {
                ReactNativeFirebaseAuthModule.this.lambda$signInAnonymously$2$ReactNativeFirebaseAuthModule(this.f$1, (AuthResult) obj);
            }
        }).addOnFailureListener(new OnFailureListener(promise) {
            public final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onFailure(Exception exc) {
                ReactNativeFirebaseAuthModule.this.lambda$signInAnonymously$3$ReactNativeFirebaseAuthModule(this.f$1, exc);
            }
        });
    }

    public /* synthetic */ void lambda$signInAnonymously$2$ReactNativeFirebaseAuthModule(Promise promise, AuthResult authResult) {
        Log.d(TAG, "signInAnonymously:onComplete:success");
        promiseWithAuthResult(authResult, promise);
    }

    public /* synthetic */ void lambda$signInAnonymously$3$ReactNativeFirebaseAuthModule(Promise promise, Exception exc) {
        Log.e(TAG, "signInAnonymously:onComplete:failure", exc);
        promiseRejectAuthException(promise, exc);
    }

    @ReactMethod
    private void createUserWithEmailAndPassword(String str, String str2, String str3, Promise promise) {
        Log.d(TAG, "createUserWithEmailAndPassword");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).createUserWithEmailAndPassword(str2, str3).addOnSuccessListener(new OnSuccessListener(promise) {
            public final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onSuccess(Object obj) {
                ReactNativeFirebaseAuthModule.this.lambda$createUserWithEmailAndPassword$4$ReactNativeFirebaseAuthModule(this.f$1, (AuthResult) obj);
            }
        }).addOnFailureListener(new OnFailureListener(promise) {
            public final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onFailure(Exception exc) {
                ReactNativeFirebaseAuthModule.this.lambda$createUserWithEmailAndPassword$5$ReactNativeFirebaseAuthModule(this.f$1, exc);
            }
        });
    }

    public /* synthetic */ void lambda$createUserWithEmailAndPassword$4$ReactNativeFirebaseAuthModule(Promise promise, AuthResult authResult) {
        Log.d(TAG, "createUserWithEmailAndPassword:onComplete:success");
        promiseWithAuthResult(authResult, promise);
        Log.d(TAG, "createUserWithEmailAndPassword:onComplete:promiseResolved");
    }

    public /* synthetic */ void lambda$createUserWithEmailAndPassword$5$ReactNativeFirebaseAuthModule(Promise promise, Exception exc) {
        Log.e(TAG, "createUserWithEmailAndPassword:onComplete:failure", exc);
        promiseRejectAuthException(promise, exc);
    }

    @ReactMethod
    private void signInWithEmailAndPassword(String str, String str2, String str3, Promise promise) {
        Log.d(TAG, "signInWithEmailAndPassword");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).signInWithEmailAndPassword(str2, str3).addOnSuccessListener(new OnSuccessListener(promise) {
            public final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onSuccess(Object obj) {
                ReactNativeFirebaseAuthModule.this.lambda$signInWithEmailAndPassword$6$ReactNativeFirebaseAuthModule(this.f$1, (AuthResult) obj);
            }
        }).addOnFailureListener(new OnFailureListener(promise) {
            public final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onFailure(Exception exc) {
                ReactNativeFirebaseAuthModule.this.lambda$signInWithEmailAndPassword$7$ReactNativeFirebaseAuthModule(this.f$1, exc);
            }
        });
    }

    public /* synthetic */ void lambda$signInWithEmailAndPassword$6$ReactNativeFirebaseAuthModule(Promise promise, AuthResult authResult) {
        Log.d(TAG, "signInWithEmailAndPassword:onComplete:success");
        promiseWithAuthResult(authResult, promise);
    }

    public /* synthetic */ void lambda$signInWithEmailAndPassword$7$ReactNativeFirebaseAuthModule(Promise promise, Exception exc) {
        Log.e(TAG, "signInWithEmailAndPassword:onComplete:failure", exc);
        promiseRejectAuthException(promise, exc);
    }

    @ReactMethod
    private void signInWithEmailLink(String str, String str2, String str3, Promise promise) {
        Log.d(TAG, "signInWithEmailLink");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).signInWithEmailLink(str2, str3).addOnSuccessListener(new OnSuccessListener(promise) {
            public final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onSuccess(Object obj) {
                ReactNativeFirebaseAuthModule.this.lambda$signInWithEmailLink$8$ReactNativeFirebaseAuthModule(this.f$1, (AuthResult) obj);
            }
        }).addOnFailureListener(new OnFailureListener(promise) {
            public final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onFailure(Exception exc) {
                ReactNativeFirebaseAuthModule.this.lambda$signInWithEmailLink$9$ReactNativeFirebaseAuthModule(this.f$1, exc);
            }
        });
    }

    public /* synthetic */ void lambda$signInWithEmailLink$8$ReactNativeFirebaseAuthModule(Promise promise, AuthResult authResult) {
        Log.d(TAG, "signInWithEmailLink:onComplete:success");
        promiseWithAuthResult(authResult, promise);
    }

    public /* synthetic */ void lambda$signInWithEmailLink$9$ReactNativeFirebaseAuthModule(Promise promise, Exception exc) {
        Log.e(TAG, "signInWithEmailLink:onComplete:failure", exc);
        promiseRejectAuthException(promise, exc);
    }

    @ReactMethod
    private void signInWithCustomToken(String str, String str2, Promise promise) {
        Log.d(TAG, "signInWithCustomToken");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).signInWithCustomToken(str2).addOnSuccessListener(new OnSuccessListener(promise) {
            public final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onSuccess(Object obj) {
                ReactNativeFirebaseAuthModule.this.lambda$signInWithCustomToken$10$ReactNativeFirebaseAuthModule(this.f$1, (AuthResult) obj);
            }
        }).addOnFailureListener(new OnFailureListener(promise) {
            public final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onFailure(Exception exc) {
                ReactNativeFirebaseAuthModule.this.lambda$signInWithCustomToken$11$ReactNativeFirebaseAuthModule(this.f$1, exc);
            }
        });
    }

    public /* synthetic */ void lambda$signInWithCustomToken$10$ReactNativeFirebaseAuthModule(Promise promise, AuthResult authResult) {
        Log.d(TAG, "signInWithCustomToken:onComplete:success");
        promiseWithAuthResult(authResult, promise);
    }

    public /* synthetic */ void lambda$signInWithCustomToken$11$ReactNativeFirebaseAuthModule(Promise promise, Exception exc) {
        Log.e(TAG, "signInWithCustomToken:onComplete:failure", exc);
        promiseRejectAuthException(promise, exc);
    }

    @ReactMethod
    public void sendPasswordResetEmail(String str, String str2, ReadableMap readableMap, Promise promise) {
        Log.d(TAG, "sendPasswordResetEmail");
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        $$Lambda$ReactNativeFirebaseAuthModule$OWqK2MYnBQjhoxADmmlkUMYx4NE r0 = new OnCompleteListener(promise) {
            public final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$sendPasswordResetEmail$12$ReactNativeFirebaseAuthModule(this.f$1, task);
            }
        };
        if (readableMap == null) {
            instance.sendPasswordResetEmail(str2).addOnCompleteListener((Executor) getExecutor(), r0);
        } else {
            instance.sendPasswordResetEmail(str2, buildActionCodeSettings(readableMap)).addOnCompleteListener((Executor) getExecutor(), r0);
        }
    }

    public /* synthetic */ void lambda$sendPasswordResetEmail$12$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "sendPasswordResetEmail:onComplete:success");
            promiseNoUser(promise, false);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "sendPasswordResetEmail:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void sendSignInLinkToEmail(String str, String str2, ReadableMap readableMap, Promise promise) {
        Log.d(TAG, "sendSignInLinkToEmail");
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        instance.sendSignInLinkToEmail(str2, buildActionCodeSettings(readableMap)).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
            public final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$sendSignInLinkToEmail$13$ReactNativeFirebaseAuthModule(this.f$1, task);
            }
        });
    }

    public /* synthetic */ void lambda$sendSignInLinkToEmail$13$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "sendSignInLinkToEmail:onComplete:success");
            promiseNoUser(promise, false);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "sendSignInLinkToEmail:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void delete(String str, Promise promise) {
        FirebaseUser currentUser = FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getCurrentUser();
        Log.d(TAG, "delete");
        if (currentUser != null) {
            currentUser.delete().addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
                public final /* synthetic */ Promise f$1;

                {
                    this.f$1 = r2;
                }

                public final void onComplete(Task task) {
                    ReactNativeFirebaseAuthModule.this.lambda$delete$14$ReactNativeFirebaseAuthModule(this.f$1, task);
                }
            });
            return;
        }
        Log.e(TAG, "delete:failure:noCurrentUser");
        promiseNoUser(promise, true);
    }

    public /* synthetic */ void lambda$delete$14$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "delete:onComplete:success");
            promiseNoUser(promise, false);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "delete:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void reload(String str, Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = instance.getCurrentUser();
        Log.d(TAG, "reload");
        if (currentUser == null) {
            promiseNoUser(promise, false);
            Log.e(TAG, "reload:failure:noCurrentUser");
            return;
        }
        currentUser.reload().addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(instance, promise) {
            public final /* synthetic */ FirebaseAuth f$1;
            public final /* synthetic */ Promise f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$reload$15$ReactNativeFirebaseAuthModule(this.f$1, this.f$2, task);
            }
        });
    }

    public /* synthetic */ void lambda$reload$15$ReactNativeFirebaseAuthModule(FirebaseAuth firebaseAuth, Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "reload:onComplete:success");
            promiseWithUser(firebaseAuth.getCurrentUser(), promise);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "reload:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void sendEmailVerification(String str, ReadableMap readableMap, Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = instance.getCurrentUser();
        Log.d(TAG, "sendEmailVerification");
        if (currentUser == null) {
            promiseNoUser(promise, false);
            Log.e(TAG, "sendEmailVerification:failure:noCurrentUser");
            return;
        }
        $$Lambda$ReactNativeFirebaseAuthModule$w4k_ET65RHM91vj34k0fjgy0m8 r1 = new OnCompleteListener(instance, promise) {
            public final /* synthetic */ FirebaseAuth f$1;
            public final /* synthetic */ Promise f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$sendEmailVerification$16$ReactNativeFirebaseAuthModule(this.f$1, this.f$2, task);
            }
        };
        if (readableMap == null) {
            currentUser.sendEmailVerification().addOnCompleteListener((Executor) getExecutor(), r1);
        } else {
            currentUser.sendEmailVerification(buildActionCodeSettings(readableMap)).addOnCompleteListener((Executor) getExecutor(), r1);
        }
    }

    public /* synthetic */ void lambda$sendEmailVerification$16$ReactNativeFirebaseAuthModule(FirebaseAuth firebaseAuth, Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "sendEmailVerification:onComplete:success");
            promiseWithUser(firebaseAuth.getCurrentUser(), promise);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "sendEmailVerification:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void verifyBeforeUpdateEmail(String str, String str2, ReadableMap readableMap, Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = instance.getCurrentUser();
        Log.d(TAG, "verifyBeforeUpdateEmail");
        if (currentUser == null) {
            promiseNoUser(promise, false);
            Log.e(TAG, "verifyBeforeUpdateEmail:failure:noCurrentUser");
            return;
        }
        $$Lambda$ReactNativeFirebaseAuthModule$2IJYj4m_dcpC26L99cdV2ZiV6g r1 = new OnCompleteListener(instance, promise) {
            public final /* synthetic */ FirebaseAuth f$1;
            public final /* synthetic */ Promise f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$verifyBeforeUpdateEmail$17$ReactNativeFirebaseAuthModule(this.f$1, this.f$2, task);
            }
        };
        if (readableMap == null) {
            currentUser.verifyBeforeUpdateEmail(str2).addOnCompleteListener((Executor) getExecutor(), r1);
        } else {
            currentUser.verifyBeforeUpdateEmail(str2, buildActionCodeSettings(readableMap)).addOnCompleteListener((Executor) getExecutor(), r1);
        }
    }

    public /* synthetic */ void lambda$verifyBeforeUpdateEmail$17$ReactNativeFirebaseAuthModule(FirebaseAuth firebaseAuth, Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "verifyBeforeUpdateEmail:onComplete:success");
            promiseWithUser(firebaseAuth.getCurrentUser(), promise);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "verifyBeforeUpdateEmail:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void updateEmail(String str, String str2, Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = instance.getCurrentUser();
        Log.d(TAG, "updateEmail");
        if (currentUser == null) {
            promiseNoUser(promise, false);
            Log.e(TAG, "updateEmail:failure:noCurrentUser");
            return;
        }
        currentUser.updateEmail(str2).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(instance, promise) {
            public final /* synthetic */ FirebaseAuth f$1;
            public final /* synthetic */ Promise f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$updateEmail$18$ReactNativeFirebaseAuthModule(this.f$1, this.f$2, task);
            }
        });
    }

    public /* synthetic */ void lambda$updateEmail$18$ReactNativeFirebaseAuthModule(FirebaseAuth firebaseAuth, Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "updateEmail:onComplete:success");
            promiseWithUser(firebaseAuth.getCurrentUser(), promise);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "updateEmail:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void updatePassword(String str, String str2, Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = instance.getCurrentUser();
        Log.d(TAG, "updatePassword");
        if (currentUser == null) {
            promiseNoUser(promise, false);
            Log.e(TAG, "updatePassword:failure:noCurrentUser");
            return;
        }
        currentUser.updatePassword(str2).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(instance, promise) {
            public final /* synthetic */ FirebaseAuth f$1;
            public final /* synthetic */ Promise f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$updatePassword$19$ReactNativeFirebaseAuthModule(this.f$1, this.f$2, task);
            }
        });
    }

    public /* synthetic */ void lambda$updatePassword$19$ReactNativeFirebaseAuthModule(FirebaseAuth firebaseAuth, Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "updatePassword:onComplete:success");
            promiseWithUser(firebaseAuth.getCurrentUser(), promise);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "updatePassword:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    private void updatePhoneNumber(String str, String str2, String str3, String str4, Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = instance.getCurrentUser();
        if (!str2.equals("phone")) {
            rejectPromiseWithCodeAndMessage(promise, "invalid-credential", "The supplied auth credential does not have a phone provider.");
        }
        PhoneAuthCredential phoneAuthCredential = getPhoneAuthCredential(str3, str4);
        if (phoneAuthCredential == null) {
            rejectPromiseWithCodeAndMessage(promise, "invalid-credential", "The supplied auth credential is malformed, has expired or is not currently supported.");
        } else if (currentUser == null) {
            promiseNoUser(promise, false);
            Log.e(TAG, "updatePhoneNumber:failure:noCurrentUser");
        } else {
            Log.d(TAG, "updatePhoneNumber");
            currentUser.updatePhoneNumber(phoneAuthCredential).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(instance, promise) {
                public final /* synthetic */ FirebaseAuth f$1;
                public final /* synthetic */ Promise f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onComplete(Task task) {
                    ReactNativeFirebaseAuthModule.this.lambda$updatePhoneNumber$20$ReactNativeFirebaseAuthModule(this.f$1, this.f$2, task);
                }
            });
        }
    }

    public /* synthetic */ void lambda$updatePhoneNumber$20$ReactNativeFirebaseAuthModule(FirebaseAuth firebaseAuth, Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "updatePhoneNumber:onComplete:success");
            promiseWithUser(firebaseAuth.getCurrentUser(), promise);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "updatePhoneNumber:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void updateProfile(String str, ReadableMap readableMap, Promise promise) {
        Uri uri;
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = instance.getCurrentUser();
        Log.d(TAG, "updateProfile");
        if (currentUser == null) {
            promiseNoUser(promise, false);
            Log.e(TAG, "updateProfile:failure:noCurrentUser");
            return;
        }
        UserProfileChangeRequest.Builder builder = new UserProfileChangeRequest.Builder();
        if (readableMap.hasKey("displayName")) {
            builder.setDisplayName(readableMap.getString("displayName"));
        }
        if (readableMap.hasKey("photoURL")) {
            String string = readableMap.getString("photoURL");
            if (string == null) {
                uri = null;
            } else {
                uri = Uri.parse(string);
            }
            builder.setPhotoUri(uri);
        }
        currentUser.updateProfile(builder.build()).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(instance, promise) {
            public final /* synthetic */ FirebaseAuth f$1;
            public final /* synthetic */ Promise f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$updateProfile$21$ReactNativeFirebaseAuthModule(this.f$1, this.f$2, task);
            }
        });
    }

    public /* synthetic */ void lambda$updateProfile$21$ReactNativeFirebaseAuthModule(FirebaseAuth firebaseAuth, Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "updateProfile:onComplete:success");
            promiseWithUser(firebaseAuth.getCurrentUser(), promise);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "updateProfile:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    private void signInWithCredential(String str, String str2, String str3, String str4, Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        AuthCredential credentialForProvider = getCredentialForProvider(str2, str3, str4);
        if (credentialForProvider == null) {
            rejectPromiseWithCodeAndMessage(promise, "invalid-credential", "The supplied auth credential is malformed, has expired or is not currently supported.");
            return;
        }
        Log.d(TAG, "signInWithCredential");
        instance.signInWithCredential(credentialForProvider).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
            public final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$signInWithCredential$22$ReactNativeFirebaseAuthModule(this.f$1, task);
            }
        });
    }

    public /* synthetic */ void lambda$signInWithCredential$22$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "signInWithCredential:onComplete:success");
            promiseWithAuthResult((AuthResult) task.getResult(), promise);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "signInWithCredential:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void signInWithPhoneNumber(String str, String str2, boolean z, final Promise promise) {
        Log.d(TAG, "signInWithPhoneNumber");
        final FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        Activity currentActivity = getCurrentActivity();
        if (!str2.equals(this.mLastPhoneNumber)) {
            this.mForceResendingToken = null;
            this.mLastPhoneNumber = str2;
        }
        this.mVerificationId = null;
        AnonymousClass1 r6 = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            private boolean promiseResolved = false;

            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                instance.signInWithCredential(phoneAuthCredential).addOnCompleteListener((Executor) ReactNativeFirebaseAuthModule.this.getExecutor(), new OnCompleteListener(phoneAuthCredential, promise) {
                    public final /* synthetic */ PhoneAuthCredential f$1;
                    public final /* synthetic */ Promise f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onComplete(Task task) {
                        ReactNativeFirebaseAuthModule.AnonymousClass1.this.lambda$onVerificationCompleted$0$ReactNativeFirebaseAuthModule$1(this.f$1, this.f$2, task);
                    }
                });
            }

            public /* synthetic */ void lambda$onVerificationCompleted$0$ReactNativeFirebaseAuthModule$1(PhoneAuthCredential phoneAuthCredential, Promise promise, Task task) {
                if (task.isSuccessful()) {
                    Log.d(ReactNativeFirebaseAuthModule.TAG, "signInWithPhoneNumber:autoVerified:signInWithCredential:onComplete:success");
                    if (!this.promiseResolved) {
                        WritableMap createMap = Arguments.createMap();
                        Parcel obtain = Parcel.obtain();
                        phoneAuthCredential.writeToParcel(obtain, 0);
                        obtain.setDataPosition(16);
                        String readString = obtain.readString();
                        String unused = ReactNativeFirebaseAuthModule.this.mVerificationId = readString;
                        obtain.recycle();
                        createMap.putString("verificationId", readString);
                        promise.resolve(createMap);
                        return;
                    }
                    return;
                }
                Exception exception = task.getException();
                Log.e(ReactNativeFirebaseAuthModule.TAG, "signInWithPhoneNumber:autoVerified:signInWithCredential:onComplete:failure", exception);
                if (!this.promiseResolved) {
                    ReactNativeFirebaseAuthModule.this.promiseRejectAuthException(promise, exception);
                }
            }

            public void onVerificationFailed(FirebaseException firebaseException) {
                Log.d(ReactNativeFirebaseAuthModule.TAG, "signInWithPhoneNumber:verification:failed");
                ReactNativeFirebaseAuthModule.this.promiseRejectAuthException(promise, firebaseException);
            }

            public void onCodeSent(String str, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                String unused = ReactNativeFirebaseAuthModule.this.mVerificationId = str;
                PhoneAuthProvider.ForceResendingToken unused2 = ReactNativeFirebaseAuthModule.this.mForceResendingToken = forceResendingToken;
                WritableMap createMap = Arguments.createMap();
                createMap.putString("verificationId", str);
                promise.resolve(createMap);
                this.promiseResolved = true;
            }

            public void onCodeAutoRetrievalTimeOut(String str) {
                super.onCodeAutoRetrievalTimeOut(str);
            }
        };
        if (currentActivity == null) {
            return;
        }
        if (!z || this.mForceResendingToken == null) {
            PhoneAuthProvider.getInstance(instance).verifyPhoneNumber(str2, 60, TimeUnit.SECONDS, currentActivity, r6);
            return;
        }
        PhoneAuthProvider.getInstance(instance).verifyPhoneNumber(str2, 60, TimeUnit.SECONDS, currentActivity, r6, this.mForceResendingToken);
    }

    @ReactMethod
    public void confirmationResultConfirm(String str, String str2, Promise promise) {
        try {
            FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).signInWithCredential(PhoneAuthProvider.getCredential(this.mVerificationId, str2)).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
                public final /* synthetic */ Promise f$1;

                {
                    this.f$1 = r2;
                }

                public final void onComplete(Task task) {
                    ReactNativeFirebaseAuthModule.this.lambda$confirmationResultConfirm$23$ReactNativeFirebaseAuthModule(this.f$1, task);
                }
            });
        } catch (Exception e) {
            Log.d(TAG, "confirmationResultConfirm::getCredential::failure", e);
            promiseRejectAuthException(promise, e);
        }
    }

    public /* synthetic */ void lambda$confirmationResultConfirm$23$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "confirmationResultConfirm:signInWithCredential:onComplete:success");
            promiseWithAuthResult((AuthResult) Objects.requireNonNull((AuthResult) task.getResult()), promise);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "confirmationResultConfirm:signInWithCredential:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void verifyPhoneNumber(final String str, String str2, final String str3, int i, boolean z) {
        Log.d(TAG, "verifyPhoneNumber:" + str2);
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        Activity currentActivity = getCurrentActivity();
        if (!str2.equals(this.mLastPhoneNumber)) {
            this.mForceResendingToken = null;
            this.mLastPhoneNumber = str2;
        }
        this.mCredential = null;
        AnonymousClass2 r7 = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                PhoneAuthCredential unused = ReactNativeFirebaseAuthModule.this.mCredential = phoneAuthCredential;
                Log.d(ReactNativeFirebaseAuthModule.TAG, "verifyPhoneNumber:verification:onVerificationCompleted");
                WritableMap createMap = Arguments.createMap();
                Parcel obtain = Parcel.obtain();
                phoneAuthCredential.writeToParcel(obtain, 0);
                obtain.setDataPosition(16);
                String readString = obtain.readString();
                obtain.setDataPosition(obtain.dataPosition() + 8);
                createMap.putString("code", obtain.readString());
                createMap.putString("verificationId", readString);
                obtain.recycle();
                ReactNativeFirebaseAuthModule.this.sendPhoneStateEvent(str, str3, "onVerificationComplete", createMap);
            }

            public void onVerificationFailed(FirebaseException firebaseException) {
                Log.d(ReactNativeFirebaseAuthModule.TAG, "verifyPhoneNumber:verification:onVerificationFailed");
                WritableMap createMap = Arguments.createMap();
                createMap.putMap(ReactVideoView.EVENT_PROP_ERROR, ReactNativeFirebaseAuthModule.this.getJSError(firebaseException));
                ReactNativeFirebaseAuthModule.this.sendPhoneStateEvent(str, str3, "onVerificationFailed", createMap);
            }

            public void onCodeSent(String str, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                Log.d(ReactNativeFirebaseAuthModule.TAG, "verifyPhoneNumber:verification:onCodeSent");
                PhoneAuthProvider.ForceResendingToken unused = ReactNativeFirebaseAuthModule.this.mForceResendingToken = forceResendingToken;
                WritableMap createMap = Arguments.createMap();
                createMap.putString("verificationId", str);
                createMap.putString("verificationId", str);
                ReactNativeFirebaseAuthModule.this.sendPhoneStateEvent(str, str3, "onCodeSent", createMap);
            }

            public void onCodeAutoRetrievalTimeOut(String str) {
                super.onCodeAutoRetrievalTimeOut(str);
                Log.d(ReactNativeFirebaseAuthModule.TAG, "verifyPhoneNumber:verification:onCodeAutoRetrievalTimeOut");
                WritableMap createMap = Arguments.createMap();
                createMap.putString("verificationId", str);
                ReactNativeFirebaseAuthModule.this.sendPhoneStateEvent(str, str3, "onCodeAutoRetrievalTimeout", createMap);
            }
        };
        if (currentActivity == null) {
            return;
        }
        if (!z || this.mForceResendingToken == null) {
            PhoneAuthProvider.getInstance(instance).verifyPhoneNumber(str2, (long) i, TimeUnit.SECONDS, currentActivity, r7);
            return;
        }
        PhoneAuthProvider.getInstance(instance).verifyPhoneNumber(str2, (long) i, TimeUnit.SECONDS, currentActivity, r7, this.mForceResendingToken);
    }

    @ReactMethod
    public void confirmPasswordReset(String str, String str2, String str3, Promise promise) {
        Log.d(TAG, "confirmPasswordReset");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).confirmPasswordReset(str2, str3).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
            public final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$confirmPasswordReset$24$ReactNativeFirebaseAuthModule(this.f$1, task);
            }
        });
    }

    public /* synthetic */ void lambda$confirmPasswordReset$24$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "confirmPasswordReset:onComplete:success");
            promiseNoUser(promise, false);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "confirmPasswordReset:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void applyActionCode(String str, String str2, Promise promise) {
        Log.d(TAG, "applyActionCode");
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        instance.applyActionCode(str2).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(instance, promise) {
            public final /* synthetic */ FirebaseAuth f$1;
            public final /* synthetic */ Promise f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$applyActionCode$25$ReactNativeFirebaseAuthModule(this.f$1, this.f$2, task);
            }
        });
    }

    public /* synthetic */ void lambda$applyActionCode$25$ReactNativeFirebaseAuthModule(FirebaseAuth firebaseAuth, Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "applyActionCode:onComplete:success");
            promiseWithUser(firebaseAuth.getCurrentUser(), promise);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "applyActionCode:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void checkActionCode(String str, String str2, Promise promise) {
        Log.d(TAG, "checkActionCode");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).checkActionCode(str2).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
            public final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$checkActionCode$26$ReactNativeFirebaseAuthModule(this.f$1, task);
            }
        });
    }

    public /* synthetic */ void lambda$checkActionCode$26$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "checkActionCode:onComplete:success");
            ActionCodeResult actionCodeResult = (ActionCodeResult) Objects.requireNonNull((ActionCodeResult) task.getResult());
            WritableMap createMap = Arguments.createMap();
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putString("email", actionCodeResult.getData(0));
            createMap2.putString("fromEmail", actionCodeResult.getData(1));
            createMap.putMap("data", createMap2);
            int operation = actionCodeResult.getOperation();
            createMap.putString("operation", operation != 0 ? operation != 1 ? operation != 2 ? operation != 3 ? operation != 4 ? "UNKNOWN" : "EMAIL_SIGNIN" : "ERROR" : "RECOVER_EMAIL" : "VERIFY_EMAIL" : "PASSWORD_RESET");
            promise.resolve(createMap);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "checkActionCode:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    private void linkWithCredential(String str, String str2, String str3, String str4, Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        AuthCredential credentialForProvider = getCredentialForProvider(str2, str3, str4);
        if (credentialForProvider == null) {
            rejectPromiseWithCodeAndMessage(promise, "invalid-credential", "The supplied auth credential is malformed, has expired or is not currently supported.");
            return;
        }
        FirebaseUser currentUser = instance.getCurrentUser();
        Log.d(TAG, "link");
        if (currentUser != null) {
            currentUser.linkWithCredential(credentialForProvider).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
                public final /* synthetic */ Promise f$1;

                {
                    this.f$1 = r2;
                }

                public final void onComplete(Task task) {
                    ReactNativeFirebaseAuthModule.this.lambda$linkWithCredential$27$ReactNativeFirebaseAuthModule(this.f$1, task);
                }
            });
        } else {
            promiseNoUser(promise, true);
        }
    }

    public /* synthetic */ void lambda$linkWithCredential$27$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "link:onComplete:success");
            promiseWithAuthResult((AuthResult) task.getResult(), promise);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "link:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void unlink(String str, String str2, Promise promise) {
        FirebaseUser currentUser = FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getCurrentUser();
        Log.d(TAG, "unlink");
        if (currentUser != null) {
            currentUser.unlink(str2).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
                public final /* synthetic */ Promise f$1;

                {
                    this.f$1 = r2;
                }

                public final void onComplete(Task task) {
                    ReactNativeFirebaseAuthModule.this.lambda$unlink$28$ReactNativeFirebaseAuthModule(this.f$1, task);
                }
            });
        } else {
            promiseNoUser(promise, true);
        }
    }

    public /* synthetic */ void lambda$unlink$28$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "unlink:onComplete:success");
            promiseWithUser(((AuthResult) Objects.requireNonNull((AuthResult) task.getResult())).getUser(), promise);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "unlink:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    private void reauthenticateWithCredential(String str, String str2, String str3, String str4, Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        AuthCredential credentialForProvider = getCredentialForProvider(str2, str3, str4);
        if (credentialForProvider == null) {
            rejectPromiseWithCodeAndMessage(promise, "invalid-credential", "The supplied auth credential is malformed, has expired or is not currently supported.");
            return;
        }
        FirebaseUser currentUser = instance.getCurrentUser();
        Log.d(TAG, "reauthenticate");
        if (currentUser != null) {
            currentUser.reauthenticateAndRetrieveData(credentialForProvider).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
                public final /* synthetic */ Promise f$1;

                {
                    this.f$1 = r2;
                }

                public final void onComplete(Task task) {
                    ReactNativeFirebaseAuthModule.this.lambda$reauthenticateWithCredential$29$ReactNativeFirebaseAuthModule(this.f$1, task);
                }
            });
        } else {
            promiseNoUser(promise, true);
        }
    }

    public /* synthetic */ void lambda$reauthenticateWithCredential$29$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "reauthenticate:onComplete:success");
            promiseWithAuthResult((AuthResult) task.getResult(), promise);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "reauthenticate:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    private AuthCredential getCredentialForProvider(String str, String str2, String str3) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2095271699:
                if (str.equals("apple.com")) {
                    c = 0;
                    break;
                }
                break;
            case -1830313082:
                if (str.equals("twitter.com")) {
                    c = 1;
                    break;
                }
                break;
            case -1536293812:
                if (str.equals("google.com")) {
                    c = 2;
                    break;
                }
                break;
            case -364826023:
                if (str.equals("facebook.com")) {
                    c = 3;
                    break;
                }
                break;
            case 105516695:
                if (str.equals("oauth")) {
                    c = 4;
                    break;
                }
                break;
            case 106642798:
                if (str.equals("phone")) {
                    c = 5;
                    break;
                }
                break;
            case 1216985755:
                if (str.equals("password")) {
                    c = 6;
                    break;
                }
                break;
            case 1985010934:
                if (str.equals("github.com")) {
                    c = 7;
                    break;
                }
                break;
            case 2120171958:
                if (str.equals(EmailAuthProvider.EMAIL_LINK_SIGN_IN_METHOD)) {
                    c = 8;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return OAuthProvider.newCredentialBuilder(str).setIdTokenWithRawNonce(str2, str3).build();
            case 1:
                return TwitterAuthProvider.getCredential(str2, str3);
            case 2:
                return GoogleAuthProvider.getCredential(str2, str3);
            case 3:
                return FacebookAuthProvider.getCredential(str2);
            case 4:
                return OAuthProvider.getCredential(str, str2, str3);
            case 5:
                return getPhoneAuthCredential(str2, str3);
            case 6:
                return EmailAuthProvider.getCredential(str2, str3);
            case 7:
                return GithubAuthProvider.getCredential(str2);
            case 8:
                return EmailAuthProvider.getCredentialWithLink(str2, str3);
            default:
                return null;
        }
    }

    private PhoneAuthCredential getPhoneAuthCredential(String str, String str2) {
        PhoneAuthCredential phoneAuthCredential;
        if (str == null && (phoneAuthCredential = this.mCredential) != null) {
            this.mCredential = null;
            return phoneAuthCredential;
        } else if (str != null) {
            return PhoneAuthProvider.getCredential(str, str2);
        } else {
            return null;
        }
    }

    @ReactMethod
    public void getIdToken(String str, Boolean bool, Promise promise) {
        Log.d(TAG, "getIdToken");
        FirebaseUser currentUser = FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getCurrentUser();
        if (currentUser == null) {
            promiseNoUser(promise, true);
        } else {
            currentUser.getIdToken(bool.booleanValue()).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
                public final /* synthetic */ Promise f$1;

                {
                    this.f$1 = r2;
                }

                public final void onComplete(Task task) {
                    ReactNativeFirebaseAuthModule.this.lambda$getIdToken$30$ReactNativeFirebaseAuthModule(this.f$1, task);
                }
            });
        }
    }

    public /* synthetic */ void lambda$getIdToken$30$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "getIdToken:onComplete:success");
            promise.resolve(((GetTokenResult) Objects.requireNonNull((GetTokenResult) task.getResult())).getToken());
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "getIdToken:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void getIdTokenResult(String str, Boolean bool, Promise promise) {
        Log.d(TAG, "getIdTokenResult");
        FirebaseUser currentUser = FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getCurrentUser();
        if (currentUser == null) {
            promiseNoUser(promise, true);
        } else {
            currentUser.getIdToken(bool.booleanValue()).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
                public final /* synthetic */ Promise f$1;

                {
                    this.f$1 = r2;
                }

                public final void onComplete(Task task) {
                    ReactNativeFirebaseAuthModule.this.lambda$getIdTokenResult$31$ReactNativeFirebaseAuthModule(this.f$1, task);
                }
            });
        }
    }

    public /* synthetic */ void lambda$getIdTokenResult$31$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "getIdTokenResult:onComplete:success");
            GetTokenResult getTokenResult = (GetTokenResult) task.getResult();
            WritableMap createMap = Arguments.createMap();
            SharedUtils.mapPutValue("authTime", SharedUtils.timestampToUTC(((GetTokenResult) Objects.requireNonNull(getTokenResult)).getAuthTimestamp()), createMap);
            SharedUtils.mapPutValue("expirationTime", SharedUtils.timestampToUTC(getTokenResult.getExpirationTimestamp()), createMap);
            SharedUtils.mapPutValue("issuedAtTime", SharedUtils.timestampToUTC(getTokenResult.getIssuedAtTimestamp()), createMap);
            SharedUtils.mapPutValue("claims", getTokenResult.getClaims(), createMap);
            SharedUtils.mapPutValue("signInProvider", getTokenResult.getSignInProvider(), createMap);
            SharedUtils.mapPutValue("token", getTokenResult.getToken(), createMap);
            promise.resolve(createMap);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "getIdTokenResult:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void fetchSignInMethodsForEmail(String str, String str2, Promise promise) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        Log.d(TAG, "fetchProvidersForEmail");
        instance.fetchSignInMethodsForEmail(str2).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
            public final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$fetchSignInMethodsForEmail$32$ReactNativeFirebaseAuthModule(this.f$1, task);
            }
        });
    }

    public /* synthetic */ void lambda$fetchSignInMethodsForEmail$32$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "fetchProvidersForEmail:onComplete:success");
            List<String> signInMethods = ((SignInMethodQueryResult) Objects.requireNonNull((SignInMethodQueryResult) task.getResult())).getSignInMethods();
            WritableArray createArray = Arguments.createArray();
            if (signInMethods != null) {
                for (String pushString : signInMethods) {
                    createArray.pushString(pushString);
                }
            }
            promise.resolve(createArray);
            return;
        }
        Exception exception = task.getException();
        Log.d(TAG, "fetchProvidersForEmail:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void setLanguageCode(String str, String str2) {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        if (str2 == null) {
            instance.useAppLanguage();
        } else {
            instance.setLanguageCode(str2);
        }
    }

    @ReactMethod
    public void setTenantId(String str, String str2) {
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).setTenantId(str2);
    }

    @ReactMethod
    public void useDeviceLanguage(String str) {
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).useAppLanguage();
    }

    @ReactMethod
    public void verifyPasswordResetCode(String str, String str2, Promise promise) {
        Log.d(TAG, "verifyPasswordResetCode");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).verifyPasswordResetCode(str2).addOnCompleteListener((Executor) getExecutor(), new OnCompleteListener(promise) {
            public final /* synthetic */ Promise f$1;

            {
                this.f$1 = r2;
            }

            public final void onComplete(Task task) {
                ReactNativeFirebaseAuthModule.this.lambda$verifyPasswordResetCode$33$ReactNativeFirebaseAuthModule(this.f$1, task);
            }
        });
    }

    public /* synthetic */ void lambda$verifyPasswordResetCode$33$ReactNativeFirebaseAuthModule(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "verifyPasswordResetCode:onComplete:success");
            promise.resolve(task.getResult());
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "verifyPasswordResetCode:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @ReactMethod
    public void useEmulator(String str, String str2, int i) {
        Log.d(TAG, "useEmulator");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).useEmulator(str2, i);
    }

    private void promiseNoUser(Promise promise, Boolean bool) {
        if (bool.booleanValue()) {
            rejectPromiseWithCodeAndMessage(promise, "no-current-user", "No user currently signed in.");
        } else {
            promise.resolve((Object) null);
        }
    }

    private void promiseWithUser(@Nullable FirebaseUser firebaseUser, Promise promise) {
        if (firebaseUser != null) {
            promise.resolve(firebaseUserToMap(firebaseUser));
        } else {
            promiseNoUser(promise, true);
        }
    }

    private void promiseWithAuthResult(AuthResult authResult, Promise promise) {
        if (authResult == null || authResult.getUser() == null) {
            promiseNoUser(promise, true);
            return;
        }
        WritableMap createMap = Arguments.createMap();
        WritableMap firebaseUserToMap = firebaseUserToMap(authResult.getUser());
        if (authResult.getAdditionalUserInfo() != null) {
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putBoolean("isNewUser", authResult.getAdditionalUserInfo().isNewUser());
            if (authResult.getAdditionalUserInfo().getProfile() != null) {
                SharedUtils.mapPutValue(Scopes.PROFILE, authResult.getAdditionalUserInfo().getProfile(), createMap2);
            }
            if (authResult.getAdditionalUserInfo().getProviderId() != null) {
                createMap2.putString("providerId", authResult.getAdditionalUserInfo().getProviderId());
            }
            if (authResult.getAdditionalUserInfo().getUsername() != null) {
                createMap2.putString("username", authResult.getAdditionalUserInfo().getUsername());
            }
            createMap.putMap("additionalUserInfo", createMap2);
        }
        createMap.putMap("user", firebaseUserToMap);
        promise.resolve(createMap);
    }

    /* access modifiers changed from: private */
    public void promiseRejectAuthException(Promise promise, Exception exc) {
        WritableMap jSError = getJSError(exc);
        rejectPromiseWithCodeAndMessage(promise, jSError.getString("code"), jSError.getString(FFmpegKitReactNativeModule.KEY_LOG_MESSAGE));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0109, code lost:
        if (r6.equals("INVALID_CREDENTIAL") == false) goto L_0x0047;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.react.bridge.WritableMap getJSError(java.lang.Exception r11) {
        /*
            r10 = this;
            java.lang.String r0 = "The user's credential is no longer valid. The user must sign in again."
            java.lang.String r1 = "UNKNOWN"
            java.lang.String r2 = "INVALID_EMAIL"
            com.facebook.react.bridge.WritableMap r3 = com.facebook.react.bridge.Arguments.createMap()
            java.lang.String r4 = r11.getMessage()
            java.lang.String r5 = "The email address is badly formatted."
            r6 = r11
            com.google.firebase.auth.FirebaseAuthException r6 = (com.google.firebase.auth.FirebaseAuthException) r6     // Catch:{ Exception -> 0x0022 }
            java.lang.String r7 = r6.getErrorCode()     // Catch:{ Exception -> 0x0022 }
            java.lang.String r8 = "nativeErrorCode"
            r3.putString(r8, r7)     // Catch:{ Exception -> 0x0023 }
            java.lang.String r0 = r6.getMessage()     // Catch:{ Exception -> 0x0023 }
            goto L_0x014b
        L_0x0022:
            r7 = r1
        L_0x0023:
            java.lang.String r6 = "([A-Z]*_[A-Z]*)"
            java.util.regex.Pattern r6 = java.util.regex.Pattern.compile(r6)
            java.util.regex.Matcher r6 = r6.matcher(r4)
            boolean r8 = r6.find()
            if (r8 == 0) goto L_0x014a
            r7 = 1
            java.lang.String r6 = r6.group(r7)
            java.lang.String r6 = r6.trim()
            r6.hashCode()
            r8 = -1
            int r9 = r6.hashCode()
            switch(r9) {
                case -2127468245: goto L_0x010d;
                case -1971163201: goto L_0x0103;
                case -1112393964: goto L_0x00f9;
                case -1035666916: goto L_0x00ed;
                case -333672188: goto L_0x00e1;
                case -324930558: goto L_0x00d5;
                case -311841705: goto L_0x00c9;
                case -75433118: goto L_0x00be;
                case -49749054: goto L_0x00b2;
                case -40686718: goto L_0x00a5;
                case 583750925: goto L_0x0098;
                case 748182870: goto L_0x008b;
                case 864281573: goto L_0x007e;
                case 1072360691: goto L_0x0071;
                case 1388786705: goto L_0x0064;
                case 1433767024: goto L_0x0057;
                case 1563975629: goto L_0x004a;
                default: goto L_0x0047;
            }
        L_0x0047:
            r7 = r8
            goto L_0x0118
        L_0x004a:
            java.lang.String r7 = "INVALID_USER_TOKEN"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x0053
            goto L_0x0047
        L_0x0053:
            r7 = 16
            goto L_0x0118
        L_0x0057:
            java.lang.String r7 = "USER_DISABLED"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x0060
            goto L_0x0047
        L_0x0060:
            r7 = 15
            goto L_0x0118
        L_0x0064:
            java.lang.String r7 = "INVALID_IDENTIFIER"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x006d
            goto L_0x0047
        L_0x006d:
            r7 = 14
            goto L_0x0118
        L_0x0071:
            java.lang.String r7 = "INVALID_CUSTOM_TOKEN"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x007a
            goto L_0x0047
        L_0x007a:
            r7 = 13
            goto L_0x0118
        L_0x007e:
            java.lang.String r7 = "ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x0087
            goto L_0x0047
        L_0x0087:
            r7 = 12
            goto L_0x0118
        L_0x008b:
            java.lang.String r7 = "REQUIRES_RECENT_LOGIN"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x0094
            goto L_0x0047
        L_0x0094:
            r7 = 11
            goto L_0x0118
        L_0x0098:
            java.lang.String r7 = "WRONG_PASSWORD"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x00a1
            goto L_0x0047
        L_0x00a1:
            r7 = 10
            goto L_0x0118
        L_0x00a5:
            java.lang.String r7 = "WEAK_PASSWORD"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x00ae
            goto L_0x0047
        L_0x00ae:
            r7 = 9
            goto L_0x0118
        L_0x00b2:
            java.lang.String r7 = "USER_MISMATCH"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x00bb
            goto L_0x0047
        L_0x00bb:
            r7 = 8
            goto L_0x0118
        L_0x00be:
            java.lang.String r7 = "USER_NOT_FOUND"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x00c7
            goto L_0x0047
        L_0x00c7:
            r7 = 7
            goto L_0x0118
        L_0x00c9:
            java.lang.String r7 = "EMAIL_ALREADY_IN_USE"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x00d3
            goto L_0x0047
        L_0x00d3:
            r7 = 6
            goto L_0x0118
        L_0x00d5:
            java.lang.String r7 = "CUSTOM_TOKEN_MISMATCH"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x00df
            goto L_0x0047
        L_0x00df:
            r7 = 5
            goto L_0x0118
        L_0x00e1:
            java.lang.String r7 = "OPERATION_NOT_ALLOWED"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x00eb
            goto L_0x0047
        L_0x00eb:
            r7 = 4
            goto L_0x0118
        L_0x00ed:
            java.lang.String r7 = "CREDENTIAL_ALREADY_IN_USE"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x00f7
            goto L_0x0047
        L_0x00f7:
            r7 = 3
            goto L_0x0118
        L_0x00f9:
            boolean r7 = r6.equals(r2)
            if (r7 != 0) goto L_0x0101
            goto L_0x0047
        L_0x0101:
            r7 = 2
            goto L_0x0118
        L_0x0103:
            java.lang.String r9 = "INVALID_CREDENTIAL"
            boolean r9 = r6.equals(r9)
            if (r9 != 0) goto L_0x0118
            goto L_0x0047
        L_0x010d:
            java.lang.String r7 = "USER_TOKEN_EXPIRED"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x0117
            goto L_0x0047
        L_0x0117:
            r7 = 0
        L_0x0118:
            switch(r7) {
                case 0: goto L_0x011c;
                case 1: goto L_0x0147;
                case 2: goto L_0x0145;
                case 3: goto L_0x0142;
                case 4: goto L_0x013f;
                case 5: goto L_0x013c;
                case 6: goto L_0x0139;
                case 7: goto L_0x0136;
                case 8: goto L_0x0133;
                case 9: goto L_0x0130;
                case 10: goto L_0x012d;
                case 11: goto L_0x012a;
                case 12: goto L_0x0127;
                case 13: goto L_0x0124;
                case 14: goto L_0x0121;
                case 15: goto L_0x011e;
                case 16: goto L_0x011c;
                default: goto L_0x011b;
            }
        L_0x011b:
            r0 = r4
        L_0x011c:
            r7 = r6
            goto L_0x014b
        L_0x011e:
            java.lang.String r0 = "The user account has been disabled by an administrator."
            goto L_0x011c
        L_0x0121:
            r7 = r2
            r0 = r5
            goto L_0x014b
        L_0x0124:
            java.lang.String r0 = "The custom token format is incorrect. Please check the documentation."
            goto L_0x011c
        L_0x0127:
            java.lang.String r0 = "An account already exists with the same email address but different sign-in credentials. Sign in using a provider associated with this email address."
            goto L_0x011c
        L_0x012a:
            java.lang.String r0 = "This operation is sensitive and requires recent authentication. Log in again before retrying this request."
            goto L_0x011c
        L_0x012d:
            java.lang.String r0 = "The password is invalid or the user does not have a password."
            goto L_0x011c
        L_0x0130:
            java.lang.String r0 = "The given password is invalid."
            goto L_0x011c
        L_0x0133:
            java.lang.String r0 = "The supplied credentials do not correspond to the previously signed in user."
            goto L_0x011c
        L_0x0136:
            java.lang.String r0 = "There is no user record corresponding to this identifier. The user may have been deleted."
            goto L_0x011c
        L_0x0139:
            java.lang.String r0 = "The email address is already in use by another account."
            goto L_0x011c
        L_0x013c:
            java.lang.String r0 = "The custom token corresponds to a different audience."
            goto L_0x011c
        L_0x013f:
            java.lang.String r0 = "This operation is not allowed. You must enable this service in the console."
            goto L_0x011c
        L_0x0142:
            java.lang.String r0 = "This credential is already associated with a different user account."
            goto L_0x011c
        L_0x0145:
            r0 = r5
            goto L_0x011c
        L_0x0147:
            java.lang.String r0 = "The supplied auth credential is malformed or has expired."
            goto L_0x011c
        L_0x014a:
            r0 = r4
        L_0x014b:
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L_0x0165
            boolean r1 = r11 instanceof com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
            if (r1 == 0) goto L_0x0156
            goto L_0x0167
        L_0x0156:
            boolean r1 = r11 instanceof com.google.firebase.FirebaseNetworkException
            if (r1 == 0) goto L_0x015e
            java.lang.String r2 = "NETWORK_REQUEST_FAILED"
        L_0x015c:
            r5 = r0
            goto L_0x0167
        L_0x015e:
            boolean r1 = r11 instanceof com.google.firebase.FirebaseTooManyRequestsException
            if (r1 == 0) goto L_0x0165
            java.lang.String r2 = "TOO_MANY_REQUESTS"
            goto L_0x015c
        L_0x0165:
            r5 = r0
            r2 = r7
        L_0x0167:
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r0 = r2.toLowerCase(r0)
            java.lang.String r1 = "error_"
            java.lang.String r2 = ""
            java.lang.String r0 = r0.replace(r1, r2)
            r1 = 95
            r2 = 45
            java.lang.String r0 = r0.replace(r1, r2)
            java.lang.String r1 = "code"
            r3.putString(r1, r0)
            java.lang.String r0 = "message"
            r3.putString(r0, r5)
            java.lang.String r11 = r11.getMessage()
            java.lang.String r0 = "nativeErrorMessage"
            r3.putString(r0, r11)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.auth.ReactNativeFirebaseAuthModule.getJSError(java.lang.Exception):com.facebook.react.bridge.WritableMap");
    }

    private WritableArray convertProviderData(List<? extends UserInfo> list, FirebaseUser firebaseUser) {
        WritableArray createArray = Arguments.createArray();
        for (UserInfo userInfo : list) {
            if (!FirebaseAuthProvider.PROVIDER_ID.equals(userInfo.getProviderId())) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("providerId", userInfo.getProviderId());
                createMap.putString("uid", userInfo.getUid());
                createMap.putString("displayName", userInfo.getDisplayName());
                Uri photoUrl = userInfo.getPhotoUrl();
                if (photoUrl == null || "".equals(photoUrl.toString())) {
                    createMap.putNull("photoURL");
                } else {
                    createMap.putString("photoURL", photoUrl.toString());
                }
                String phoneNumber = userInfo.getPhoneNumber();
                if ("phone".equals(userInfo.getProviderId()) && (userInfo.getPhoneNumber() == null || "".equals(userInfo.getPhoneNumber()))) {
                    createMap.putString("phoneNumber", firebaseUser.getPhoneNumber());
                } else if (phoneNumber == null || "".equals(phoneNumber)) {
                    createMap.putNull("phoneNumber");
                } else {
                    createMap.putString("phoneNumber", phoneNumber);
                }
                if ("password".equals(userInfo.getProviderId()) && (userInfo.getEmail() == null || "".equals(userInfo.getEmail()))) {
                    createMap.putString("email", userInfo.getUid());
                } else if (userInfo.getEmail() == null || "".equals(userInfo.getEmail())) {
                    createMap.putNull("email");
                } else {
                    createMap.putString("email", userInfo.getEmail());
                }
                createArray.pushMap(createMap);
            }
        }
        return createArray;
    }

    private WritableMap firebaseUserToMap(FirebaseUser firebaseUser) {
        WritableMap createMap = Arguments.createMap();
        String uid = firebaseUser.getUid();
        String email = firebaseUser.getEmail();
        Uri photoUrl = firebaseUser.getPhotoUrl();
        String displayName = firebaseUser.getDisplayName();
        String providerId = firebaseUser.getProviderId();
        boolean isEmailVerified = firebaseUser.isEmailVerified();
        String phoneNumber = firebaseUser.getPhoneNumber();
        String tenantId = firebaseUser.getTenantId();
        createMap.putString("uid", uid);
        createMap.putString("providerId", providerId);
        createMap.putBoolean("emailVerified", isEmailVerified);
        createMap.putBoolean("isAnonymous", firebaseUser.isAnonymous());
        if (email == null || "".equals(email)) {
            createMap.putNull("email");
        } else {
            createMap.putString("email", email);
        }
        if (displayName == null || "".equals(displayName)) {
            createMap.putNull("displayName");
        } else {
            createMap.putString("displayName", displayName);
        }
        if (photoUrl == null || "".equals(photoUrl.toString())) {
            createMap.putNull("photoURL");
        } else {
            createMap.putString("photoURL", photoUrl.toString());
        }
        if (phoneNumber == null || "".equals(phoneNumber)) {
            createMap.putNull("phoneNumber");
        } else {
            createMap.putString("phoneNumber", phoneNumber);
        }
        if (tenantId == null || "".equals(tenantId)) {
            createMap.putNull("tenantId");
        } else {
            createMap.putString("tenantId", tenantId);
        }
        createMap.putArray("providerData", convertProviderData(firebaseUser.getProviderData(), firebaseUser));
        WritableMap createMap2 = Arguments.createMap();
        FirebaseUserMetadata metadata = firebaseUser.getMetadata();
        if (metadata != null) {
            createMap2.putDouble("creationTime", (double) metadata.getCreationTimestamp());
            createMap2.putDouble("lastSignInTime", (double) metadata.getLastSignInTimestamp());
        }
        createMap.putMap(ReactVideoView.EVENT_PROP_METADATA, createMap2);
        return createMap;
    }

    private ActionCodeSettings buildActionCodeSettings(ReadableMap readableMap) {
        ActionCodeSettings.Builder url = ActionCodeSettings.newBuilder().setUrl((String) Objects.requireNonNull(readableMap.getString(ImagesContract.URL)));
        if (readableMap.hasKey("handleCodeInApp")) {
            url = url.setHandleCodeInApp(readableMap.getBoolean("handleCodeInApp"));
        }
        if (readableMap.hasKey("dynamicLinkDomain")) {
            url = url.setDynamicLinkDomain(readableMap.getString("dynamicLinkDomain"));
        }
        if (readableMap.hasKey(FFmpegKitReactNativeModule.PLATFORM_NAME)) {
            ReadableMap map = readableMap.getMap(FFmpegKitReactNativeModule.PLATFORM_NAME);
            url = url.setAndroidPackageName((String) Objects.requireNonNull(map.getString("packageName")), ((ReadableMap) Objects.requireNonNull(map)).hasKey("installApp") && map.getBoolean("installApp"), map.hasKey("minimumVersion") ? map.getString("minimumVersion") : null);
        }
        if (readableMap.hasKey("iOS")) {
            url = url.setIOSBundleId((String) Objects.requireNonNull(readableMap.getMap("iOS").getString("bundleId")));
        }
        return url.build();
    }

    /* access modifiers changed from: private */
    public void sendPhoneStateEvent(String str, String str2, String str3, WritableMap writableMap) {
        WritableMap createMap = Arguments.createMap();
        ReactNativeFirebaseEventEmitter sharedInstance = ReactNativeFirebaseEventEmitter.getSharedInstance();
        createMap.putString("appName", str);
        createMap.putString("requestKey", str2);
        createMap.putString("type", str3);
        createMap.putMap("state", writableMap);
        sharedInstance.sendEvent(new ReactNativeFirebaseEvent("phone_auth_state_changed", createMap, str));
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        List<FirebaseApp> apps = FirebaseApp.getApps(getReactApplicationContext());
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        for (FirebaseApp name : apps) {
            String name2 = name.getName();
            FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(name2));
            FirebaseUser currentUser = instance.getCurrentUser();
            hashMap2.put(name2, instance.getLanguageCode());
            if (currentUser != null) {
                hashMap3.put(name2, firebaseUserToMap(currentUser));
            }
        }
        hashMap.put("APP_LANGUAGE", hashMap2);
        hashMap.put("APP_USER", hashMap3);
        return hashMap;
    }
}
