package com.google.firebase.database.android;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.appcheck.interop.AppCheckTokenListener;
import com.google.firebase.appcheck.interop.InternalAppCheckTokenProvider;
import com.google.firebase.database.core.TokenProvider;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

public class AndroidAppCheckTokenProvider implements TokenProvider {
    private final Deferred<InternalAppCheckTokenProvider> deferredAppCheckProvider;
    private final AtomicReference<InternalAppCheckTokenProvider> internalAppCheck = new AtomicReference<>();

    public void removeTokenChangeListener(TokenProvider.TokenChangeListener tokenChangeListener) {
    }

    public AndroidAppCheckTokenProvider(Deferred<InternalAppCheckTokenProvider> deferred) {
        this.deferredAppCheckProvider = deferred;
        deferred.whenAvailable(new Deferred.DeferredHandler() {
            public final void handle(Provider provider) {
                AndroidAppCheckTokenProvider.this.lambda$new$0$AndroidAppCheckTokenProvider(provider);
            }
        });
    }

    public /* synthetic */ void lambda$new$0$AndroidAppCheckTokenProvider(Provider provider) {
        this.internalAppCheck.set((InternalAppCheckTokenProvider) provider.get());
    }

    public void getToken(boolean z, TokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
        InternalAppCheckTokenProvider internalAppCheckTokenProvider = this.internalAppCheck.get();
        if (internalAppCheckTokenProvider != null) {
            internalAppCheckTokenProvider.getToken(z).addOnSuccessListener(new OnSuccessListener() {
                public final void onSuccess(Object obj) {
                    TokenProvider.GetTokenCompletionListener.this.onSuccess(((AppCheckTokenResult) obj).getToken());
                }
            }).addOnFailureListener(new OnFailureListener() {
                public final void onFailure(Exception exc) {
                    TokenProvider.GetTokenCompletionListener.this.onError(exc.getMessage());
                }
            });
        } else {
            getTokenCompletionListener.onSuccess((String) null);
        }
    }

    public void addTokenChangeListener(ExecutorService executorService, TokenProvider.TokenChangeListener tokenChangeListener) {
        this.deferredAppCheckProvider.whenAvailable(new Deferred.DeferredHandler(executorService, tokenChangeListener) {
            public final /* synthetic */ ExecutorService f$0;
            public final /* synthetic */ TokenProvider.TokenChangeListener f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void handle(Provider provider) {
                ((InternalAppCheckTokenProvider) provider.get()).addAppCheckTokenListener(new AppCheckTokenListener(this.f$0, this.f$1) {
                    public final /* synthetic */ ExecutorService f$0;
                    public final /* synthetic */ TokenProvider.TokenChangeListener f$1;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                    }

                    public final void onAppCheckTokenChanged(AppCheckTokenResult appCheckTokenResult) {
                        this.f$0.execute(new Runnable(appCheckTokenResult) {
                            public final /* synthetic */ AppCheckTokenResult f$1;

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
}
