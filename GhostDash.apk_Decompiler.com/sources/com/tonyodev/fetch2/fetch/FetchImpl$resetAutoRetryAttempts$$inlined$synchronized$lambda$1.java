package com.tonyodev.fetch2.fetch;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.FetchErrorUtils;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2core.Func;
import com.tonyodev.fetch2core.Func2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/tonyodev/fetch2/fetch/FetchImpl$resetAutoRetryAttempts$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: FetchImpl.kt */
final class FetchImpl$resetAutoRetryAttempts$$inlined$synchronized$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $downloadId$inlined;
    final /* synthetic */ Func2 $func$inlined;
    final /* synthetic */ Func $func2$inlined;
    final /* synthetic */ boolean $retryDownload$inlined;
    final /* synthetic */ FetchImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FetchImpl$resetAutoRetryAttempts$$inlined$synchronized$lambda$1(FetchImpl fetchImpl, int i, boolean z, Func2 func2, Func func) {
        super(0);
        this.this$0 = fetchImpl;
        this.$downloadId$inlined = i;
        this.$retryDownload$inlined = z;
        this.$func$inlined = func2;
        this.$func2$inlined = func;
    }

    public final void invoke() {
        try {
            final Download resetAutoRetryAttempts = this.this$0.fetchHandler.resetAutoRetryAttempts(this.$downloadId$inlined, this.$retryDownload$inlined);
            if (resetAutoRetryAttempts != null && resetAutoRetryAttempts.getStatus() == Status.QUEUED) {
                this.this$0.logger.d("Queued " + resetAutoRetryAttempts + " for download");
                this.this$0.listenerCoordinator.getMainListener().onQueued(resetAutoRetryAttempts, false);
            }
            this.this$0.uiHandler.post(new Runnable(this) {
                final /* synthetic */ FetchImpl$resetAutoRetryAttempts$$inlined$synchronized$lambda$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void run() {
                    Func2 func2 = this.this$0.$func$inlined;
                    if (func2 != null) {
                        func2.call(resetAutoRetryAttempts);
                    }
                }
            });
        } catch (Exception e) {
            Throwable th = e;
            this.this$0.logger.e("Fetch with namespace " + this.this$0.getNamespace() + " error", th);
            final Error errorFromMessage = FetchErrorUtils.getErrorFromMessage(e.getMessage());
            errorFromMessage.setThrowable(th);
            if (this.$func2$inlined != null) {
                this.this$0.uiHandler.post(new Runnable(this) {
                    final /* synthetic */ FetchImpl$resetAutoRetryAttempts$$inlined$synchronized$lambda$1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void run() {
                        this.this$0.$func2$inlined.call(errorFromMessage);
                    }
                });
            }
        }
    }
}
