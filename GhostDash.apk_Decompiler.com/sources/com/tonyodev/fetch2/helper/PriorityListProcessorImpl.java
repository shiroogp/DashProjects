package com.tonyodev.fetch2.helper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.FetchIntent;
import com.tonyodev.fetch2.NetworkType;
import com.tonyodev.fetch2.PrioritySort;
import com.tonyodev.fetch2.downloader.DownloadManager;
import com.tonyodev.fetch2.fetch.ListenerCoordinator;
import com.tonyodev.fetch2.provider.DownloadProvider;
import com.tonyodev.fetch2.provider.NetworkInfoProvider;
import com.tonyodev.fetch2core.HandlerWrapper;
import com.tonyodev.fetch2core.Logger;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001@BU\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\b\u00102\u001a\u00020%H\u0002J\b\u00103\u001a\u000204H\u0016J\u000e\u00105\u001a\b\u0012\u0004\u0012\u00020\u000206H\u0016J\b\u00107\u001a\u000204H\u0002J\b\u00108\u001a\u000204H\u0016J\b\u00109\u001a\u000204H\u0002J\b\u0010:\u001a\u000204H\u0016J\b\u0010;\u001a\u000204H\u0016J\b\u0010<\u001a\u000204H\u0016J\b\u0010=\u001a\u000204H\u0016J\b\u0010>\u001a\u000204H\u0016J\b\u0010?\u001a\u000204H\u0002R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010&R\u0014\u0010'\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010&R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/tonyodev/fetch2/helper/PriorityListProcessorImpl;", "Lcom/tonyodev/fetch2/helper/PriorityListProcessor;", "Lcom/tonyodev/fetch2/Download;", "handlerWrapper", "Lcom/tonyodev/fetch2core/HandlerWrapper;", "downloadProvider", "Lcom/tonyodev/fetch2/provider/DownloadProvider;", "downloadManager", "Lcom/tonyodev/fetch2/downloader/DownloadManager;", "networkInfoProvider", "Lcom/tonyodev/fetch2/provider/NetworkInfoProvider;", "logger", "Lcom/tonyodev/fetch2core/Logger;", "listenerCoordinator", "Lcom/tonyodev/fetch2/fetch/ListenerCoordinator;", "downloadConcurrentLimit", "", "context", "Landroid/content/Context;", "namespace", "", "prioritySort", "Lcom/tonyodev/fetch2/PrioritySort;", "(Lcom/tonyodev/fetch2core/HandlerWrapper;Lcom/tonyodev/fetch2/provider/DownloadProvider;Lcom/tonyodev/fetch2/downloader/DownloadManager;Lcom/tonyodev/fetch2/provider/NetworkInfoProvider;Lcom/tonyodev/fetch2core/Logger;Lcom/tonyodev/fetch2/fetch/ListenerCoordinator;ILandroid/content/Context;Ljava/lang/String;Lcom/tonyodev/fetch2/PrioritySort;)V", "backOffTime", "", "getDownloadConcurrentLimit", "()I", "setDownloadConcurrentLimit", "(I)V", "globalNetworkType", "Lcom/tonyodev/fetch2/NetworkType;", "getGlobalNetworkType", "()Lcom/tonyodev/fetch2/NetworkType;", "setGlobalNetworkType", "(Lcom/tonyodev/fetch2/NetworkType;)V", "isPaused", "", "()Z", "isStopped", "lock", "", "networkChangeListener", "Lcom/tonyodev/fetch2/provider/NetworkInfoProvider$NetworkChangeListener;", "paused", "priorityBackoffResetReceiver", "Landroid/content/BroadcastReceiver;", "priorityIteratorRunnable", "Ljava/lang/Runnable;", "stopped", "canContinueToProcess", "close", "", "getPriorityList", "", "increaseBackOffTime", "pause", "registerPriorityIterator", "resetBackOffTime", "resume", "sendBackOffResetSignal", "start", "stop", "unregisterPriorityIterator", "Companion", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PriorityListProcessorImpl.kt */
public final class PriorityListProcessorImpl implements PriorityListProcessor<Download> {
    @Deprecated
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long ONE_MINUTE_IN_MILLISECONDS = 60000;
    /* access modifiers changed from: private */
    public volatile long backOffTime = 500;
    private final Context context;
    private volatile int downloadConcurrentLimit;
    /* access modifiers changed from: private */
    public final DownloadManager downloadManager;
    private final DownloadProvider downloadProvider;
    private volatile NetworkType globalNetworkType = NetworkType.GLOBAL_OFF;
    /* access modifiers changed from: private */
    public final HandlerWrapper handlerWrapper;
    /* access modifiers changed from: private */
    public final ListenerCoordinator listenerCoordinator;
    private final Object lock = new Object();
    private final Logger logger;
    /* access modifiers changed from: private */
    public final String namespace;
    private final NetworkInfoProvider.NetworkChangeListener networkChangeListener;
    /* access modifiers changed from: private */
    public final NetworkInfoProvider networkInfoProvider;
    /* access modifiers changed from: private */
    public volatile boolean paused;
    private final BroadcastReceiver priorityBackoffResetReceiver;
    private final Runnable priorityIteratorRunnable;
    private final PrioritySort prioritySort;
    /* access modifiers changed from: private */
    public volatile boolean stopped = true;

    public PriorityListProcessorImpl(HandlerWrapper handlerWrapper2, DownloadProvider downloadProvider2, DownloadManager downloadManager2, NetworkInfoProvider networkInfoProvider2, Logger logger2, ListenerCoordinator listenerCoordinator2, int i, Context context2, String str, PrioritySort prioritySort2) {
        Intrinsics.checkParameterIsNotNull(handlerWrapper2, "handlerWrapper");
        Intrinsics.checkParameterIsNotNull(downloadProvider2, "downloadProvider");
        Intrinsics.checkParameterIsNotNull(downloadManager2, "downloadManager");
        Intrinsics.checkParameterIsNotNull(networkInfoProvider2, "networkInfoProvider");
        Intrinsics.checkParameterIsNotNull(logger2, "logger");
        Intrinsics.checkParameterIsNotNull(listenerCoordinator2, "listenerCoordinator");
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(str, "namespace");
        Intrinsics.checkParameterIsNotNull(prioritySort2, "prioritySort");
        this.handlerWrapper = handlerWrapper2;
        this.downloadProvider = downloadProvider2;
        this.downloadManager = downloadManager2;
        this.networkInfoProvider = networkInfoProvider2;
        this.logger = logger2;
        this.listenerCoordinator = listenerCoordinator2;
        this.downloadConcurrentLimit = i;
        this.context = context2;
        this.namespace = str;
        this.prioritySort = prioritySort2;
        NetworkInfoProvider.NetworkChangeListener priorityListProcessorImpl$networkChangeListener$1 = new PriorityListProcessorImpl$networkChangeListener$1(this);
        this.networkChangeListener = priorityListProcessorImpl$networkChangeListener$1;
        BroadcastReceiver priorityListProcessorImpl$priorityBackoffResetReceiver$1 = new PriorityListProcessorImpl$priorityBackoffResetReceiver$1(this);
        this.priorityBackoffResetReceiver = priorityListProcessorImpl$priorityBackoffResetReceiver$1;
        networkInfoProvider2.registerNetworkChangeListener(priorityListProcessorImpl$networkChangeListener$1);
        context2.registerReceiver(priorityListProcessorImpl$priorityBackoffResetReceiver$1, new IntentFilter(FetchIntent.ACTION_QUEUE_BACKOFF_RESET));
        this.priorityIteratorRunnable = new PriorityListProcessorImpl$priorityIteratorRunnable$1(this);
    }

    public int getDownloadConcurrentLimit() {
        return this.downloadConcurrentLimit;
    }

    public void setDownloadConcurrentLimit(int i) {
        this.downloadConcurrentLimit = i;
    }

    public NetworkType getGlobalNetworkType() {
        return this.globalNetworkType;
    }

    public void setGlobalNetworkType(NetworkType networkType) {
        Intrinsics.checkParameterIsNotNull(networkType, "<set-?>");
        this.globalNetworkType = networkType;
    }

    public boolean isPaused() {
        return this.paused;
    }

    public boolean isStopped() {
        return this.stopped;
    }

    public void start() {
        synchronized (this.lock) {
            resetBackOffTime();
            this.stopped = false;
            this.paused = false;
            registerPriorityIterator();
            this.logger.d("PriorityIterator started");
            Unit unit = Unit.INSTANCE;
        }
    }

    public void stop() {
        synchronized (this.lock) {
            unregisterPriorityIterator();
            this.paused = false;
            this.stopped = true;
            this.downloadManager.cancelAll();
            this.logger.d("PriorityIterator stop");
            Unit unit = Unit.INSTANCE;
        }
    }

    public void pause() {
        synchronized (this.lock) {
            unregisterPriorityIterator();
            this.paused = true;
            this.stopped = false;
            this.downloadManager.cancelAll();
            this.logger.d("PriorityIterator paused");
            Unit unit = Unit.INSTANCE;
        }
    }

    public void resume() {
        synchronized (this.lock) {
            resetBackOffTime();
            this.paused = false;
            this.stopped = false;
            registerPriorityIterator();
            this.logger.d("PriorityIterator resumed");
            Unit unit = Unit.INSTANCE;
        }
    }

    public List<Download> getPriorityList() {
        List<Download> list;
        synchronized (this.lock) {
            try {
                list = this.downloadProvider.getPendingDownloadsSorted(this.prioritySort);
            } catch (Exception e) {
                this.logger.d("PriorityIterator failed access database", e);
                list = CollectionsKt.emptyList();
            }
        }
        return list;
    }

    /* access modifiers changed from: private */
    public final void registerPriorityIterator() {
        if (getDownloadConcurrentLimit() > 0) {
            this.handlerWrapper.postDelayed(this.priorityIteratorRunnable, this.backOffTime);
        }
    }

    private final void unregisterPriorityIterator() {
        if (getDownloadConcurrentLimit() > 0) {
            this.handlerWrapper.removeCallbacks(this.priorityIteratorRunnable);
        }
    }

    /* access modifiers changed from: private */
    public final boolean canContinueToProcess() {
        return !this.stopped && !this.paused;
    }

    public void resetBackOffTime() {
        synchronized (this.lock) {
            this.backOffTime = 500;
            unregisterPriorityIterator();
            registerPriorityIterator();
            this.logger.d("PriorityIterator backoffTime reset to " + this.backOffTime + " milliseconds");
            Unit unit = Unit.INSTANCE;
        }
    }

    public void sendBackOffResetSignal() {
        synchronized (this.lock) {
            Intent intent = new Intent(FetchIntent.ACTION_QUEUE_BACKOFF_RESET);
            intent.putExtra(FetchIntent.EXTRA_NAMESPACE, this.namespace);
            this.context.sendBroadcast(intent);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void close() {
        synchronized (this.lock) {
            this.networkInfoProvider.unregisterNetworkChangeListener(this.networkChangeListener);
            this.context.unregisterReceiver(this.priorityBackoffResetReceiver);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final void increaseBackOffTime() {
        long j;
        if (this.backOffTime == 500) {
            j = ONE_MINUTE_IN_MILLISECONDS;
        } else {
            j = this.backOffTime * 2;
        }
        this.backOffTime = j;
        this.logger.d("PriorityIterator backoffTime increased to " + TimeUnit.MILLISECONDS.toMinutes(this.backOffTime) + " minute(s)");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tonyodev/fetch2/helper/PriorityListProcessorImpl$Companion;", "", "()V", "ONE_MINUTE_IN_MILLISECONDS", "", "fetch2_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: PriorityListProcessorImpl.kt */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
