package com.google.firebase.database.android;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.database.core.TokenProvider;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.InternalTokenResult;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

public class AndroidAuthTokenProvider implements TokenProvider {
    private final Deferred<InternalAuthProvider> deferredAuthProvider;
    private final AtomicReference<InternalAuthProvider> internalAuth = new AtomicReference<>();

    public void removeTokenChangeListener(TokenProvider.TokenChangeListener tokenChangeListener) {
    }

    public AndroidAuthTokenProvider(Deferred<InternalAuthProvider> deferred) {
        this.deferredAuthProvider = deferred;
        deferred.whenAvailable(new Deferred.DeferredHandler() {
            public final void handle(Provider provider) {
                AndroidAuthTokenProvider.this.lambda$new$0$AndroidAuthTokenProvider(provider);
            }
        });
    }

    public /* synthetic */ void lambda$new$0$AndroidAuthTokenProvider(Provider provider) {
        this.internalAuth.set((InternalAuthProvider) provider.get());
    }

    public void getToken(boolean z, TokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
        InternalAuthProvider internalAuthProvider = this.internalAuth.get();
        if (internalAuthProvider != null) {
            internalAuthProvider.getAccessToken(z).addOnSuccessListener(new OnSuccessListener() {
                public final void onSuccess(Object obj) {
                    TokenProvider.GetTokenCompletionListener.this.onSuccess(((GetTokenResult) obj).getToken());
                }
            }).addOnFailureListener(new OnFailureListener() {
                public final void onFailure(Exception exc) {
                    AndroidAuthTokenProvider.lambda$getToken$2(TokenProvider.GetTokenCompletionListener.this, exc);
                }
            });
        } else {
            getTokenCompletionListener.onSuccess((String) null);
        }
    }

    static /* synthetic */ void lambda$getToken$2(TokenProvider.GetTokenCompletionListener getTokenCompletionListener, Exception exc) {
        if (isUnauthenticatedUsage(exc)) {
            getTokenCompletionListener.onSuccess((String) null);
        } else {
            getTokenCompletionListener.onError(exc.getMessage());
        }
    }

    public void addTokenChangeListener(ExecutorService executorService, TokenProvider.TokenChangeListener tokenChangeListener) {
        this.deferredAuthProvider.whenAvailable(new Deferred.DeferredHandler(executorService, tokenChangeListener) {
            public final /* synthetic */ ExecutorService f$0;
            public final /* synthetic */ TokenProvider.TokenChangeListener f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void handle(Provider provider) {
                ((InternalAuthProvider) provider.get()).addIdTokenListener(new IdTokenListener(this.f$0, this.f$1) {
                    public final /* synthetic */ ExecutorService f$0;
                    public final /* synthetic */ TokenProvider.TokenChangeListener f$1;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                    }

                    public final void onIdTokenChanged(InternalTokenResult internalTokenResult) {
                        this.f$0.execute(new Runnable(internalTokenResult) {
                            public final /* synthetic */ InternalTokenResult f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                TokenProvider.TokenChangeListener.this.onTokenChange(this.f$1.getToken());
                            }
                        });
                    }
                });
            }
        });
    }

    private static boolean isUnauthenticatedUsage(Exception exc) {
        return (exc instanceof FirebaseApiNotAvailableException) || (exc instanceof FirebaseNoSignedInUserException);
    }
}
