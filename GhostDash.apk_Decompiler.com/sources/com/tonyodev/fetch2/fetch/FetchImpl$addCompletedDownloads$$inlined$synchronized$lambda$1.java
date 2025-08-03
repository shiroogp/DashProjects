package com.tonyodev.fetch2.fetch;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.FetchErrorUtils;
import com.tonyodev.fetch2core.Func;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/tonyodev/fetch2/fetch/FetchImpl$addCompletedDownloads$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: FetchImpl.kt */
final class FetchImpl$addCompletedDownloads$$inlined$synchronized$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $alertListeners$inlined;
    final /* synthetic */ List $completedDownloads$inlined;
    final /* synthetic */ Func $func$inlined;
    final /* synthetic */ Func $func2$inlined;
    final /* synthetic */ FetchImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FetchImpl$addCompletedDownloads$$inlined$synchronized$lambda$1(FetchImpl fetchImpl, List list, boolean z, Func func, Func func2) {
        super(0);
        this.this$0 = fetchImpl;
        this.$completedDownloads$inlined = list;
        this.$alertListeners$inlined = z;
        this.$func$inlined = func;
        this.$func2$inlined = func2;
    }

    public final void invoke() {
        try {
            final List<Download> enqueueCompletedDownloads = this.this$0.fetchHandler.enqueueCompletedDownloads(this.$completedDownloads$inlined);
            if (this.$alertListeners$inlined) {
                for (Download download : enqueueCompletedDownloads) {
                    this.this$0.listenerCoordinator.getMainListener().onCompleted(download);
                    this.this$0.logger.d("Added CompletedDownload " + download);
                }
            }
            this.this$0.uiHandler.post(new Runnable(this) {
                final /* synthetic */ FetchImpl$addCompletedDownloads$$inlined$synchronized$lambda$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void run() {
                    Func func = this.this$0.$func$inlined;
                    if (func != null) {
                        func.call(enqueueCompletedDownloads);
                    }
                }
            });
        } catch (Exception e) {
            this.this$0.logger.e("Failed to add CompletedDownload list " + this.$completedDownloads$inlined);
            final Error errorFromMessage = FetchErrorUtils.getErrorFromMessage(e.getMessage());
            errorFromMessage.setThrowable(e);
            if (this.$func2$inlined != null) {
                this.this$0.uiHandler.post(new Runnable(this) {
                    final /* synthetic */ FetchImpl$addCompletedDownloads$$inlined$synchronized$lambda$1 this$0;

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
