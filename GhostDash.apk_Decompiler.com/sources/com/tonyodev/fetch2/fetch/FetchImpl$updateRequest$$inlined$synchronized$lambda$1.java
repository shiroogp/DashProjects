package com.tonyodev.fetch2.fetch;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.FetchErrorUtils;
import com.tonyodev.fetch2.Request;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2.database.DownloadInfo;
import com.tonyodev.fetch2.fetch.FetchImpl;
import com.tonyodev.fetch2.util.FetchTypeConverterExtensions;
import com.tonyodev.fetch2core.Func;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/tonyodev/fetch2/fetch/FetchImpl$updateRequest$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: FetchImpl.kt */
final class FetchImpl$updateRequest$$inlined$synchronized$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Func $func$inlined;
    final /* synthetic */ Func $func2$inlined;
    final /* synthetic */ boolean $notifyListeners$inlined;
    final /* synthetic */ int $requestId$inlined;
    final /* synthetic */ Request $updatedRequest$inlined;
    final /* synthetic */ FetchImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FetchImpl$updateRequest$$inlined$synchronized$lambda$1(FetchImpl fetchImpl, int i, Request request, boolean z, Func func, Func func2) {
        super(0);
        this.this$0 = fetchImpl;
        this.$requestId$inlined = i;
        this.$updatedRequest$inlined = request;
        this.$notifyListeners$inlined = z;
        this.$func$inlined = func;
        this.$func2$inlined = func2;
    }

    public final void invoke() {
        try {
            Pair<Download, Boolean> updateRequest = this.this$0.fetchHandler.updateRequest(this.$requestId$inlined, this.$updatedRequest$inlined);
            final Download first = updateRequest.getFirst();
            this.this$0.logger.d("UpdatedRequest with id: " + this.$requestId$inlined + " to " + first);
            if (this.$notifyListeners$inlined) {
                switch (FetchImpl.WhenMappings.$EnumSwitchMapping$1[first.getStatus().ordinal()]) {
                    case 1:
                        this.this$0.listenerCoordinator.getMainListener().onCompleted(first);
                        break;
                    case 2:
                        this.this$0.listenerCoordinator.getMainListener().onError(first, first.getError(), (Throwable) null);
                        break;
                    case 3:
                        this.this$0.listenerCoordinator.getMainListener().onCancelled(first);
                        break;
                    case 4:
                        this.this$0.listenerCoordinator.getMainListener().onDeleted(first);
                        break;
                    case 5:
                        this.this$0.listenerCoordinator.getMainListener().onPaused(first);
                        break;
                    case 6:
                        if (!updateRequest.getSecond().booleanValue()) {
                            DownloadInfo downloadInfo = FetchTypeConverterExtensions.toDownloadInfo(first, this.this$0.fetchDatabaseManagerWrapper.getNewDownloadInfoInstance());
                            downloadInfo.setStatus(Status.ADDED);
                            this.this$0.listenerCoordinator.getMainListener().onAdded(downloadInfo);
                            this.this$0.logger.d("Added " + first);
                        }
                        this.this$0.listenerCoordinator.getMainListener().onQueued(first, false);
                        break;
                    case 7:
                        this.this$0.listenerCoordinator.getMainListener().onRemoved(first);
                        break;
                    case 9:
                        this.this$0.listenerCoordinator.getMainListener().onAdded(first);
                        break;
                }
            }
            this.this$0.uiHandler.post(new Runnable(this) {
                final /* synthetic */ FetchImpl$updateRequest$$inlined$synchronized$lambda$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void run() {
                    Func func = this.this$0.$func$inlined;
                    if (func != null) {
                        func.call(first);
                    }
                }
            });
        } catch (Exception e) {
            Throwable th = e;
            this.this$0.logger.e("Failed to update request with id " + this.$requestId$inlined, th);
            final Error errorFromMessage = FetchErrorUtils.getErrorFromMessage(e.getMessage());
            errorFromMessage.setThrowable(th);
            if (this.$func2$inlined != null) {
                this.this$0.uiHandler.post(new Runnable(this) {
                    final /* synthetic */ FetchImpl$updateRequest$$inlined$synchronized$lambda$1 this$0;

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
