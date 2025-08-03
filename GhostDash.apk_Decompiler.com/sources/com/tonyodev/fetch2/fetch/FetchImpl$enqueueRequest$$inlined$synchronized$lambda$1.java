package com.tonyodev.fetch2.fetch;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.FetchErrorUtils;
import com.tonyodev.fetch2.Request;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2.database.DownloadInfo;
import com.tonyodev.fetch2.exception.FetchException;
import com.tonyodev.fetch2.fetch.FetchImpl;
import com.tonyodev.fetch2.util.FetchTypeConverterExtensions;
import com.tonyodev.fetch2core.FetchErrorStrings;
import com.tonyodev.fetch2core.Func;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/tonyodev/fetch2/fetch/FetchImpl$enqueueRequest$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: FetchImpl.kt */
final class FetchImpl$enqueueRequest$$inlined$synchronized$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Func $func$inlined;
    final /* synthetic */ Func $func2$inlined;
    final /* synthetic */ List $requests$inlined;
    final /* synthetic */ FetchImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FetchImpl$enqueueRequest$$inlined$synchronized$lambda$1(FetchImpl fetchImpl, List list, Func func, Func func2) {
        super(0);
        this.this$0 = fetchImpl;
        this.$requests$inlined = list;
        this.$func$inlined = func;
        this.$func2$inlined = func2;
    }

    public final void invoke() {
        try {
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (Object next : this.$requests$inlined) {
                if (hashSet.add(((Request) next).getFile())) {
                    arrayList.add(next);
                }
            }
            if (arrayList.size() == this.$requests$inlined.size()) {
                final List<Pair<Download, Error>> enqueue = this.this$0.fetchHandler.enqueue((List<? extends Request>) this.$requests$inlined);
                for (Pair first : enqueue) {
                    Download download = (Download) first.getFirst();
                    int i = FetchImpl.WhenMappings.$EnumSwitchMapping$0[download.getStatus().ordinal()];
                    if (i == 1) {
                        this.this$0.listenerCoordinator.getMainListener().onAdded(download);
                        this.this$0.logger.d("Added " + download);
                    } else if (i == 2) {
                        DownloadInfo downloadInfo = FetchTypeConverterExtensions.toDownloadInfo(download, this.this$0.fetchDatabaseManagerWrapper.getNewDownloadInfoInstance());
                        downloadInfo.setStatus(Status.ADDED);
                        this.this$0.listenerCoordinator.getMainListener().onAdded(downloadInfo);
                        this.this$0.logger.d("Added " + download);
                        this.this$0.listenerCoordinator.getMainListener().onQueued(download, false);
                        this.this$0.logger.d("Queued " + download + " for download");
                    } else if (i == 3) {
                        this.this$0.listenerCoordinator.getMainListener().onCompleted(download);
                        this.this$0.logger.d("Completed download " + download);
                    }
                }
                this.this$0.uiHandler.post(new Runnable(this) {
                    final /* synthetic */ FetchImpl$enqueueRequest$$inlined$synchronized$lambda$1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void run() {
                        Func func = this.this$0.$func$inlined;
                        if (func != null) {
                            Iterable<Pair> iterable = enqueue;
                            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                            for (Pair pair : iterable) {
                                arrayList.add(new Pair(((Download) pair.getFirst()).getRequest(), pair.getSecond()));
                            }
                            func.call((List) arrayList);
                        }
                    }
                });
                return;
            }
            throw new FetchException(FetchErrorStrings.ENQUEUED_REQUESTS_ARE_NOT_DISTINCT);
        } catch (Exception e) {
            this.this$0.logger.e("Failed to enqueue list " + this.$requests$inlined);
            final Error errorFromMessage = FetchErrorUtils.getErrorFromMessage(e.getMessage());
            errorFromMessage.setThrowable(e);
            if (this.$func2$inlined != null) {
                this.this$0.uiHandler.post(new Runnable(this) {
                    final /* synthetic */ FetchImpl$enqueueRequest$$inlined$synchronized$lambda$1 this$0;

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
