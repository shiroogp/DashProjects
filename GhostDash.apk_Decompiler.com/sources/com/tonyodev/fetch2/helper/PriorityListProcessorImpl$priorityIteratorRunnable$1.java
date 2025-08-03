package com.tonyodev.fetch2.helper;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.NetworkType;
import com.tonyodev.fetch2core.FetchCoreUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
/* compiled from: PriorityListProcessorImpl.kt */
final class PriorityListProcessorImpl$priorityIteratorRunnable$1 implements Runnable {
    final /* synthetic */ PriorityListProcessorImpl this$0;

    PriorityListProcessorImpl$priorityIteratorRunnable$1(PriorityListProcessorImpl priorityListProcessorImpl) {
        this.this$0 = priorityListProcessorImpl;
    }

    public final void run() {
        NetworkType networkType;
        if (this.this$0.canContinueToProcess()) {
            if (this.this$0.downloadManager.canAccommodateNewDownload() && this.this$0.canContinueToProcess()) {
                List<Download> priorityList = this.this$0.getPriorityList();
                boolean z = true;
                boolean z2 = priorityList.isEmpty() || !this.this$0.networkInfoProvider.isNetworkAvailable();
                if (!z2) {
                    int lastIndex = CollectionsKt.getLastIndex(priorityList);
                    if (lastIndex >= 0) {
                        int i = 0;
                        while (this.this$0.downloadManager.canAccommodateNewDownload() && this.this$0.canContinueToProcess()) {
                            Download download = priorityList.get(i);
                            boolean isFetchFileServerUrl = FetchCoreUtils.isFetchFileServerUrl(download.getUrl());
                            if ((!isFetchFileServerUrl && !this.this$0.networkInfoProvider.isNetworkAvailable()) || !this.this$0.canContinueToProcess()) {
                                break;
                            }
                            if (this.this$0.getGlobalNetworkType() != NetworkType.GLOBAL_OFF) {
                                networkType = this.this$0.getGlobalNetworkType();
                            } else if (download.getNetworkType() == NetworkType.GLOBAL_OFF) {
                                networkType = NetworkType.ALL;
                            } else {
                                networkType = download.getNetworkType();
                            }
                            boolean isOnAllowedNetwork = this.this$0.networkInfoProvider.isOnAllowedNetwork(networkType);
                            if (!isOnAllowedNetwork) {
                                this.this$0.listenerCoordinator.getMainListener().onWaitingNetwork(download);
                            }
                            if (isFetchFileServerUrl || isOnAllowedNetwork) {
                                if (!this.this$0.downloadManager.contains(download.getId()) && this.this$0.canContinueToProcess()) {
                                    this.this$0.downloadManager.start(download);
                                }
                                z = false;
                            }
                            if (i == lastIndex) {
                                break;
                            }
                            i++;
                        }
                    }
                } else {
                    z = z2;
                }
                if (z) {
                    this.this$0.increaseBackOffTime();
                }
            }
            if (this.this$0.canContinueToProcess()) {
                this.this$0.registerPriorityIterator();
            }
        }
    }
}
