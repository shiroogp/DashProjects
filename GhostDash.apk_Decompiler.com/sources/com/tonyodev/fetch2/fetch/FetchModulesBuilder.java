package com.tonyodev.fetch2.fetch;

import android.os.Handler;
import android.os.Looper;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.FetchConfiguration;
import com.tonyodev.fetch2.database.DownloadDatabase;
import com.tonyodev.fetch2.database.DownloadInfo;
import com.tonyodev.fetch2.database.FetchDatabaseManager;
import com.tonyodev.fetch2.database.FetchDatabaseManagerImpl;
import com.tonyodev.fetch2.database.FetchDatabaseManagerWrapper;
import com.tonyodev.fetch2.downloader.DownloadManager;
import com.tonyodev.fetch2.downloader.DownloadManagerCoordinator;
import com.tonyodev.fetch2.downloader.DownloadManagerImpl;
import com.tonyodev.fetch2.helper.DownloadInfoUpdater;
import com.tonyodev.fetch2.helper.PriorityListProcessor;
import com.tonyodev.fetch2.helper.PriorityListProcessorImpl;
import com.tonyodev.fetch2.provider.DownloadProvider;
import com.tonyodev.fetch2.provider.GroupInfoProvider;
import com.tonyodev.fetch2.provider.NetworkInfoProvider;
import com.tonyodev.fetch2.util.FetchUtils;
import com.tonyodev.fetch2core.DefaultStorageResolver;
import com.tonyodev.fetch2core.Downloader;
import com.tonyodev.fetch2core.FetchCoreUtils;
import com.tonyodev.fetch2core.HandlerWrapper;
import com.tonyodev.fetch2core.Logger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0013\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/tonyodev/fetch2/fetch/FetchModulesBuilder;", "", "()V", "holderMap", "", "", "Lcom/tonyodev/fetch2/fetch/FetchModulesBuilder$Holder;", "lock", "mainUIHandler", "Landroid/os/Handler;", "getMainUIHandler", "()Landroid/os/Handler;", "buildModulesFromPrefs", "Lcom/tonyodev/fetch2/fetch/FetchModulesBuilder$Modules;", "fetchConfiguration", "Lcom/tonyodev/fetch2/FetchConfiguration;", "removeNamespaceInstanceReference", "", "namespace", "Holder", "Modules", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FetchModulesBuilder.kt */
public final class FetchModulesBuilder {
    public static final FetchModulesBuilder INSTANCE = new FetchModulesBuilder();
    private static final Map<String, Holder> holderMap = new LinkedHashMap();
    private static final Object lock = new Object();
    private static final Handler mainUIHandler = new Handler(Looper.getMainLooper());

    private FetchModulesBuilder() {
    }

    public final Handler getMainUIHandler() {
        return mainUIHandler;
    }

    public final Modules buildModulesFromPrefs(FetchConfiguration fetchConfiguration) {
        Modules modules;
        Intrinsics.checkParameterIsNotNull(fetchConfiguration, "fetchConfiguration");
        synchronized (lock) {
            Map<String, Holder> map = holderMap;
            Holder holder = map.get(fetchConfiguration.getNamespace());
            if (holder != null) {
                modules = new Modules(fetchConfiguration, holder.getHandlerWrapper(), holder.getFetchDatabaseManagerWrapper(), holder.getDownloadProvider(), holder.getGroupInfoProvider(), holder.getUiHandler(), holder.getDownloadManagerCoordinator(), holder.getListenerCoordinator());
            } else {
                HandlerWrapper handlerWrapper = new HandlerWrapper(fetchConfiguration.getNamespace(), fetchConfiguration.getBackgroundHandler());
                LiveSettings liveSettings = new LiveSettings(fetchConfiguration.getNamespace());
                FetchDatabaseManager<DownloadInfo> fetchDatabaseManager = fetchConfiguration.getFetchDatabaseManager();
                if (fetchDatabaseManager == null) {
                    fetchDatabaseManager = new FetchDatabaseManagerImpl(fetchConfiguration.getAppContext(), fetchConfiguration.getNamespace(), fetchConfiguration.getLogger(), DownloadDatabase.Companion.getMigrations(), liveSettings, fetchConfiguration.getFileExistChecksEnabled(), new DefaultStorageResolver(fetchConfiguration.getAppContext(), FetchCoreUtils.getFileTempDir(fetchConfiguration.getAppContext())));
                }
                FetchDatabaseManagerWrapper fetchDatabaseManagerWrapper = new FetchDatabaseManagerWrapper(fetchDatabaseManager);
                DownloadProvider downloadProvider = new DownloadProvider(fetchDatabaseManagerWrapper);
                DownloadManagerCoordinator downloadManagerCoordinator = new DownloadManagerCoordinator(fetchConfiguration.getNamespace());
                GroupInfoProvider groupInfoProvider = new GroupInfoProvider(fetchConfiguration.getNamespace(), downloadProvider);
                String namespace = fetchConfiguration.getNamespace();
                Handler handler = mainUIHandler;
                ListenerCoordinator listenerCoordinator = new ListenerCoordinator(namespace, groupInfoProvider, downloadProvider, handler);
                Modules modules2 = new Modules(fetchConfiguration, handlerWrapper, fetchDatabaseManagerWrapper, downloadProvider, groupInfoProvider, handler, downloadManagerCoordinator, listenerCoordinator);
                map.put(fetchConfiguration.getNamespace(), new Holder(handlerWrapper, fetchDatabaseManagerWrapper, downloadProvider, groupInfoProvider, handler, downloadManagerCoordinator, listenerCoordinator, modules2.getNetworkInfoProvider()));
                modules = modules2;
            }
            modules.getHandlerWrapper().incrementUsageCounter();
        }
        return modules;
    }

    public final void removeNamespaceInstanceReference(String str) {
        Intrinsics.checkParameterIsNotNull(str, "namespace");
        synchronized (lock) {
            Map<String, Holder> map = holderMap;
            Holder holder = map.get(str);
            if (holder != null) {
                holder.getHandlerWrapper().decrementUsageCounter();
                if (holder.getHandlerWrapper().usageCount() == 0) {
                    holder.getHandlerWrapper().close();
                    holder.getListenerCoordinator().clearAll();
                    holder.getGroupInfoProvider().clear();
                    holder.getFetchDatabaseManagerWrapper().close();
                    holder.getDownloadManagerCoordinator().clearAll();
                    holder.getNetworkInfoProvider().unregisterAllNetworkChangeListeners();
                    map.remove(str);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\t\u0010(\u001a\u00020\rHÆ\u0003J\t\u0010)\u001a\u00020\u000fHÆ\u0003J\t\u0010*\u001a\u00020\u0011HÆ\u0003JY\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u000202HÖ\u0001R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00063"}, d2 = {"Lcom/tonyodev/fetch2/fetch/FetchModulesBuilder$Holder;", "", "handlerWrapper", "Lcom/tonyodev/fetch2core/HandlerWrapper;", "fetchDatabaseManagerWrapper", "Lcom/tonyodev/fetch2/database/FetchDatabaseManagerWrapper;", "downloadProvider", "Lcom/tonyodev/fetch2/provider/DownloadProvider;", "groupInfoProvider", "Lcom/tonyodev/fetch2/provider/GroupInfoProvider;", "uiHandler", "Landroid/os/Handler;", "downloadManagerCoordinator", "Lcom/tonyodev/fetch2/downloader/DownloadManagerCoordinator;", "listenerCoordinator", "Lcom/tonyodev/fetch2/fetch/ListenerCoordinator;", "networkInfoProvider", "Lcom/tonyodev/fetch2/provider/NetworkInfoProvider;", "(Lcom/tonyodev/fetch2core/HandlerWrapper;Lcom/tonyodev/fetch2/database/FetchDatabaseManagerWrapper;Lcom/tonyodev/fetch2/provider/DownloadProvider;Lcom/tonyodev/fetch2/provider/GroupInfoProvider;Landroid/os/Handler;Lcom/tonyodev/fetch2/downloader/DownloadManagerCoordinator;Lcom/tonyodev/fetch2/fetch/ListenerCoordinator;Lcom/tonyodev/fetch2/provider/NetworkInfoProvider;)V", "getDownloadManagerCoordinator", "()Lcom/tonyodev/fetch2/downloader/DownloadManagerCoordinator;", "getDownloadProvider", "()Lcom/tonyodev/fetch2/provider/DownloadProvider;", "getFetchDatabaseManagerWrapper", "()Lcom/tonyodev/fetch2/database/FetchDatabaseManagerWrapper;", "getGroupInfoProvider", "()Lcom/tonyodev/fetch2/provider/GroupInfoProvider;", "getHandlerWrapper", "()Lcom/tonyodev/fetch2core/HandlerWrapper;", "getListenerCoordinator", "()Lcom/tonyodev/fetch2/fetch/ListenerCoordinator;", "getNetworkInfoProvider", "()Lcom/tonyodev/fetch2/provider/NetworkInfoProvider;", "getUiHandler", "()Landroid/os/Handler;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "", "fetch2_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: FetchModulesBuilder.kt */
    public static final class Holder {
        private final DownloadManagerCoordinator downloadManagerCoordinator;
        private final DownloadProvider downloadProvider;
        private final FetchDatabaseManagerWrapper fetchDatabaseManagerWrapper;
        private final GroupInfoProvider groupInfoProvider;
        private final HandlerWrapper handlerWrapper;
        private final ListenerCoordinator listenerCoordinator;
        private final NetworkInfoProvider networkInfoProvider;
        private final Handler uiHandler;

        public static /* synthetic */ Holder copy$default(Holder holder, HandlerWrapper handlerWrapper2, FetchDatabaseManagerWrapper fetchDatabaseManagerWrapper2, DownloadProvider downloadProvider2, GroupInfoProvider groupInfoProvider2, Handler handler, DownloadManagerCoordinator downloadManagerCoordinator2, ListenerCoordinator listenerCoordinator2, NetworkInfoProvider networkInfoProvider2, int i, Object obj) {
            Holder holder2 = holder;
            int i2 = i;
            return holder.copy((i2 & 1) != 0 ? holder2.handlerWrapper : handlerWrapper2, (i2 & 2) != 0 ? holder2.fetchDatabaseManagerWrapper : fetchDatabaseManagerWrapper2, (i2 & 4) != 0 ? holder2.downloadProvider : downloadProvider2, (i2 & 8) != 0 ? holder2.groupInfoProvider : groupInfoProvider2, (i2 & 16) != 0 ? holder2.uiHandler : handler, (i2 & 32) != 0 ? holder2.downloadManagerCoordinator : downloadManagerCoordinator2, (i2 & 64) != 0 ? holder2.listenerCoordinator : listenerCoordinator2, (i2 & 128) != 0 ? holder2.networkInfoProvider : networkInfoProvider2);
        }

        public final HandlerWrapper component1() {
            return this.handlerWrapper;
        }

        public final FetchDatabaseManagerWrapper component2() {
            return this.fetchDatabaseManagerWrapper;
        }

        public final DownloadProvider component3() {
            return this.downloadProvider;
        }

        public final GroupInfoProvider component4() {
            return this.groupInfoProvider;
        }

        public final Handler component5() {
            return this.uiHandler;
        }

        public final DownloadManagerCoordinator component6() {
            return this.downloadManagerCoordinator;
        }

        public final ListenerCoordinator component7() {
            return this.listenerCoordinator;
        }

        public final NetworkInfoProvider component8() {
            return this.networkInfoProvider;
        }

        public final Holder copy(HandlerWrapper handlerWrapper2, FetchDatabaseManagerWrapper fetchDatabaseManagerWrapper2, DownloadProvider downloadProvider2, GroupInfoProvider groupInfoProvider2, Handler handler, DownloadManagerCoordinator downloadManagerCoordinator2, ListenerCoordinator listenerCoordinator2, NetworkInfoProvider networkInfoProvider2) {
            Intrinsics.checkParameterIsNotNull(handlerWrapper2, "handlerWrapper");
            Intrinsics.checkParameterIsNotNull(fetchDatabaseManagerWrapper2, "fetchDatabaseManagerWrapper");
            Intrinsics.checkParameterIsNotNull(downloadProvider2, "downloadProvider");
            Intrinsics.checkParameterIsNotNull(groupInfoProvider2, "groupInfoProvider");
            Intrinsics.checkParameterIsNotNull(handler, "uiHandler");
            DownloadManagerCoordinator downloadManagerCoordinator3 = downloadManagerCoordinator2;
            Intrinsics.checkParameterIsNotNull(downloadManagerCoordinator3, "downloadManagerCoordinator");
            ListenerCoordinator listenerCoordinator3 = listenerCoordinator2;
            Intrinsics.checkParameterIsNotNull(listenerCoordinator3, "listenerCoordinator");
            NetworkInfoProvider networkInfoProvider3 = networkInfoProvider2;
            Intrinsics.checkParameterIsNotNull(networkInfoProvider3, "networkInfoProvider");
            return new Holder(handlerWrapper2, fetchDatabaseManagerWrapper2, downloadProvider2, groupInfoProvider2, handler, downloadManagerCoordinator3, listenerCoordinator3, networkInfoProvider3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Holder)) {
                return false;
            }
            Holder holder = (Holder) obj;
            return Intrinsics.areEqual((Object) this.handlerWrapper, (Object) holder.handlerWrapper) && Intrinsics.areEqual((Object) this.fetchDatabaseManagerWrapper, (Object) holder.fetchDatabaseManagerWrapper) && Intrinsics.areEqual((Object) this.downloadProvider, (Object) holder.downloadProvider) && Intrinsics.areEqual((Object) this.groupInfoProvider, (Object) holder.groupInfoProvider) && Intrinsics.areEqual((Object) this.uiHandler, (Object) holder.uiHandler) && Intrinsics.areEqual((Object) this.downloadManagerCoordinator, (Object) holder.downloadManagerCoordinator) && Intrinsics.areEqual((Object) this.listenerCoordinator, (Object) holder.listenerCoordinator) && Intrinsics.areEqual((Object) this.networkInfoProvider, (Object) holder.networkInfoProvider);
        }

        public int hashCode() {
            HandlerWrapper handlerWrapper2 = this.handlerWrapper;
            int i = 0;
            int hashCode = (handlerWrapper2 != null ? handlerWrapper2.hashCode() : 0) * 31;
            FetchDatabaseManagerWrapper fetchDatabaseManagerWrapper2 = this.fetchDatabaseManagerWrapper;
            int hashCode2 = (hashCode + (fetchDatabaseManagerWrapper2 != null ? fetchDatabaseManagerWrapper2.hashCode() : 0)) * 31;
            DownloadProvider downloadProvider2 = this.downloadProvider;
            int hashCode3 = (hashCode2 + (downloadProvider2 != null ? downloadProvider2.hashCode() : 0)) * 31;
            GroupInfoProvider groupInfoProvider2 = this.groupInfoProvider;
            int hashCode4 = (hashCode3 + (groupInfoProvider2 != null ? groupInfoProvider2.hashCode() : 0)) * 31;
            Handler handler = this.uiHandler;
            int hashCode5 = (hashCode4 + (handler != null ? handler.hashCode() : 0)) * 31;
            DownloadManagerCoordinator downloadManagerCoordinator2 = this.downloadManagerCoordinator;
            int hashCode6 = (hashCode5 + (downloadManagerCoordinator2 != null ? downloadManagerCoordinator2.hashCode() : 0)) * 31;
            ListenerCoordinator listenerCoordinator2 = this.listenerCoordinator;
            int hashCode7 = (hashCode6 + (listenerCoordinator2 != null ? listenerCoordinator2.hashCode() : 0)) * 31;
            NetworkInfoProvider networkInfoProvider2 = this.networkInfoProvider;
            if (networkInfoProvider2 != null) {
                i = networkInfoProvider2.hashCode();
            }
            return hashCode7 + i;
        }

        public String toString() {
            return "Holder(handlerWrapper=" + this.handlerWrapper + ", fetchDatabaseManagerWrapper=" + this.fetchDatabaseManagerWrapper + ", downloadProvider=" + this.downloadProvider + ", groupInfoProvider=" + this.groupInfoProvider + ", uiHandler=" + this.uiHandler + ", downloadManagerCoordinator=" + this.downloadManagerCoordinator + ", listenerCoordinator=" + this.listenerCoordinator + ", networkInfoProvider=" + this.networkInfoProvider + ")";
        }

        public Holder(HandlerWrapper handlerWrapper2, FetchDatabaseManagerWrapper fetchDatabaseManagerWrapper2, DownloadProvider downloadProvider2, GroupInfoProvider groupInfoProvider2, Handler handler, DownloadManagerCoordinator downloadManagerCoordinator2, ListenerCoordinator listenerCoordinator2, NetworkInfoProvider networkInfoProvider2) {
            Intrinsics.checkParameterIsNotNull(handlerWrapper2, "handlerWrapper");
            Intrinsics.checkParameterIsNotNull(fetchDatabaseManagerWrapper2, "fetchDatabaseManagerWrapper");
            Intrinsics.checkParameterIsNotNull(downloadProvider2, "downloadProvider");
            Intrinsics.checkParameterIsNotNull(groupInfoProvider2, "groupInfoProvider");
            Intrinsics.checkParameterIsNotNull(handler, "uiHandler");
            Intrinsics.checkParameterIsNotNull(downloadManagerCoordinator2, "downloadManagerCoordinator");
            Intrinsics.checkParameterIsNotNull(listenerCoordinator2, "listenerCoordinator");
            Intrinsics.checkParameterIsNotNull(networkInfoProvider2, "networkInfoProvider");
            this.handlerWrapper = handlerWrapper2;
            this.fetchDatabaseManagerWrapper = fetchDatabaseManagerWrapper2;
            this.downloadProvider = downloadProvider2;
            this.groupInfoProvider = groupInfoProvider2;
            this.uiHandler = handler;
            this.downloadManagerCoordinator = downloadManagerCoordinator2;
            this.listenerCoordinator = listenerCoordinator2;
            this.networkInfoProvider = networkInfoProvider2;
        }

        public final HandlerWrapper getHandlerWrapper() {
            return this.handlerWrapper;
        }

        public final FetchDatabaseManagerWrapper getFetchDatabaseManagerWrapper() {
            return this.fetchDatabaseManagerWrapper;
        }

        public final DownloadProvider getDownloadProvider() {
            return this.downloadProvider;
        }

        public final GroupInfoProvider getGroupInfoProvider() {
            return this.groupInfoProvider;
        }

        public final Handler getUiHandler() {
            return this.uiHandler;
        }

        public final DownloadManagerCoordinator getDownloadManagerCoordinator() {
            return this.downloadManagerCoordinator;
        }

        public final ListenerCoordinator getListenerCoordinator() {
            return this.listenerCoordinator;
        }

        public final NetworkInfoProvider getNetworkInfoProvider() {
            return this.networkInfoProvider;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020100¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b4\u00105¨\u00066"}, d2 = {"Lcom/tonyodev/fetch2/fetch/FetchModulesBuilder$Modules;", "", "fetchConfiguration", "Lcom/tonyodev/fetch2/FetchConfiguration;", "handlerWrapper", "Lcom/tonyodev/fetch2core/HandlerWrapper;", "fetchDatabaseManagerWrapper", "Lcom/tonyodev/fetch2/database/FetchDatabaseManagerWrapper;", "downloadProvider", "Lcom/tonyodev/fetch2/provider/DownloadProvider;", "groupInfoProvider", "Lcom/tonyodev/fetch2/provider/GroupInfoProvider;", "uiHandler", "Landroid/os/Handler;", "downloadManagerCoordinator", "Lcom/tonyodev/fetch2/downloader/DownloadManagerCoordinator;", "listenerCoordinator", "Lcom/tonyodev/fetch2/fetch/ListenerCoordinator;", "(Lcom/tonyodev/fetch2/FetchConfiguration;Lcom/tonyodev/fetch2core/HandlerWrapper;Lcom/tonyodev/fetch2/database/FetchDatabaseManagerWrapper;Lcom/tonyodev/fetch2/provider/DownloadProvider;Lcom/tonyodev/fetch2/provider/GroupInfoProvider;Landroid/os/Handler;Lcom/tonyodev/fetch2/downloader/DownloadManagerCoordinator;Lcom/tonyodev/fetch2/fetch/ListenerCoordinator;)V", "downloadInfoUpdater", "Lcom/tonyodev/fetch2/helper/DownloadInfoUpdater;", "getDownloadInfoUpdater", "()Lcom/tonyodev/fetch2/helper/DownloadInfoUpdater;", "downloadManager", "Lcom/tonyodev/fetch2/downloader/DownloadManager;", "getDownloadManager", "()Lcom/tonyodev/fetch2/downloader/DownloadManager;", "getDownloadProvider", "()Lcom/tonyodev/fetch2/provider/DownloadProvider;", "getFetchConfiguration", "()Lcom/tonyodev/fetch2/FetchConfiguration;", "getFetchDatabaseManagerWrapper", "()Lcom/tonyodev/fetch2/database/FetchDatabaseManagerWrapper;", "fetchHandler", "Lcom/tonyodev/fetch2/fetch/FetchHandler;", "getFetchHandler", "()Lcom/tonyodev/fetch2/fetch/FetchHandler;", "getGroupInfoProvider", "()Lcom/tonyodev/fetch2/provider/GroupInfoProvider;", "getHandlerWrapper", "()Lcom/tonyodev/fetch2core/HandlerWrapper;", "getListenerCoordinator", "()Lcom/tonyodev/fetch2/fetch/ListenerCoordinator;", "networkInfoProvider", "Lcom/tonyodev/fetch2/provider/NetworkInfoProvider;", "getNetworkInfoProvider", "()Lcom/tonyodev/fetch2/provider/NetworkInfoProvider;", "priorityListProcessor", "Lcom/tonyodev/fetch2/helper/PriorityListProcessor;", "Lcom/tonyodev/fetch2/Download;", "getPriorityListProcessor", "()Lcom/tonyodev/fetch2/helper/PriorityListProcessor;", "getUiHandler", "()Landroid/os/Handler;", "fetch2_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: FetchModulesBuilder.kt */
    public static final class Modules {
        private final DownloadInfoUpdater downloadInfoUpdater;
        private final DownloadManager downloadManager;
        private final DownloadProvider downloadProvider;
        private final FetchConfiguration fetchConfiguration;
        private final FetchDatabaseManagerWrapper fetchDatabaseManagerWrapper;
        private final FetchHandler fetchHandler;
        private final GroupInfoProvider groupInfoProvider;
        private final HandlerWrapper handlerWrapper;
        private final ListenerCoordinator listenerCoordinator;
        private final NetworkInfoProvider networkInfoProvider;
        private final PriorityListProcessor<Download> priorityListProcessor;
        private final Handler uiHandler;

        public Modules(FetchConfiguration fetchConfiguration2, HandlerWrapper handlerWrapper2, FetchDatabaseManagerWrapper fetchDatabaseManagerWrapper2, DownloadProvider downloadProvider2, GroupInfoProvider groupInfoProvider2, Handler handler, DownloadManagerCoordinator downloadManagerCoordinator, ListenerCoordinator listenerCoordinator2) {
            FetchConfiguration fetchConfiguration3 = fetchConfiguration2;
            HandlerWrapper handlerWrapper3 = handlerWrapper2;
            FetchDatabaseManagerWrapper fetchDatabaseManagerWrapper3 = fetchDatabaseManagerWrapper2;
            DownloadProvider downloadProvider3 = downloadProvider2;
            GroupInfoProvider groupInfoProvider3 = groupInfoProvider2;
            Handler handler2 = handler;
            ListenerCoordinator listenerCoordinator3 = listenerCoordinator2;
            Intrinsics.checkParameterIsNotNull(fetchConfiguration3, "fetchConfiguration");
            Intrinsics.checkParameterIsNotNull(handlerWrapper3, "handlerWrapper");
            Intrinsics.checkParameterIsNotNull(fetchDatabaseManagerWrapper3, "fetchDatabaseManagerWrapper");
            Intrinsics.checkParameterIsNotNull(downloadProvider3, "downloadProvider");
            Intrinsics.checkParameterIsNotNull(groupInfoProvider3, "groupInfoProvider");
            Intrinsics.checkParameterIsNotNull(handler2, "uiHandler");
            Intrinsics.checkParameterIsNotNull(downloadManagerCoordinator, "downloadManagerCoordinator");
            Intrinsics.checkParameterIsNotNull(listenerCoordinator3, "listenerCoordinator");
            this.fetchConfiguration = fetchConfiguration3;
            this.handlerWrapper = handlerWrapper3;
            this.fetchDatabaseManagerWrapper = fetchDatabaseManagerWrapper3;
            this.downloadProvider = downloadProvider3;
            this.groupInfoProvider = groupInfoProvider3;
            this.uiHandler = handler2;
            this.listenerCoordinator = listenerCoordinator3;
            DownloadInfoUpdater downloadInfoUpdater2 = r2;
            DownloadInfoUpdater downloadInfoUpdater3 = new DownloadInfoUpdater(fetchDatabaseManagerWrapper3);
            this.downloadInfoUpdater = downloadInfoUpdater3;
            NetworkInfoProvider networkInfoProvider2 = r6;
            NetworkInfoProvider networkInfoProvider3 = new NetworkInfoProvider(fetchConfiguration2.getAppContext(), fetchConfiguration2.getInternetCheckUrl());
            this.networkInfoProvider = networkInfoProvider3;
            Downloader<?, ?> httpDownloader = fetchConfiguration2.getHttpDownloader();
            int concurrentLimit = fetchConfiguration2.getConcurrentLimit();
            long progressReportingIntervalMillis = fetchConfiguration2.getProgressReportingIntervalMillis();
            Logger logger = fetchConfiguration2.getLogger();
            boolean retryOnNetworkGain = fetchConfiguration2.getRetryOnNetworkGain();
            DownloadManager downloadManagerImpl = new DownloadManagerImpl(httpDownloader, concurrentLimit, progressReportingIntervalMillis, logger, networkInfoProvider2, retryOnNetworkGain, downloadInfoUpdater2, downloadManagerCoordinator, listenerCoordinator2, fetchConfiguration2.getFileServerDownloader(), fetchConfiguration2.getHashCheckingEnabled(), fetchConfiguration2.getStorageResolver(), fetchConfiguration2.getAppContext(), fetchConfiguration2.getNamespace(), groupInfoProvider2, fetchConfiguration2.getMaxAutoRetryAttempts(), fetchConfiguration2.getPreAllocateFileOnCreation());
            this.downloadManager = downloadManagerImpl;
            DownloadManager downloadManager2 = downloadManagerImpl;
            PriorityListProcessor<Download> priorityListProcessorImpl = new PriorityListProcessorImpl(handlerWrapper3, downloadProvider3, downloadManagerImpl, networkInfoProvider3, fetchConfiguration2.getLogger(), listenerCoordinator2, fetchConfiguration2.getConcurrentLimit(), fetchConfiguration2.getAppContext(), fetchConfiguration2.getNamespace(), fetchConfiguration2.getPrioritySort());
            this.priorityListProcessor = priorityListProcessorImpl;
            priorityListProcessorImpl.setGlobalNetworkType(fetchConfiguration2.getGlobalNetworkType());
            FetchHandler fetchHandler2 = fetchConfiguration2.getFetchHandler();
            if (fetchHandler2 == null) {
                fetchHandler2 = new FetchHandlerImpl(fetchConfiguration2.getNamespace(), fetchDatabaseManagerWrapper2, downloadManager2, priorityListProcessorImpl, fetchConfiguration2.getLogger(), fetchConfiguration2.getAutoStart(), fetchConfiguration2.getHttpDownloader(), fetchConfiguration2.getFileServerDownloader(), listenerCoordinator2, handler, fetchConfiguration2.getStorageResolver(), fetchConfiguration2.getFetchNotificationManager(), groupInfoProvider2, fetchConfiguration2.getPrioritySort(), fetchConfiguration2.getCreateFileOnEnqueue());
            }
            this.fetchHandler = fetchHandler2;
            fetchDatabaseManagerWrapper2.setDelegate(new FetchDatabaseManager.Delegate<DownloadInfo>(this) {
                final /* synthetic */ Modules this$0;

                {
                    this.this$0 = r1;
                }

                public void deleteTempFilesForDownload(DownloadInfo downloadInfo) {
                    Intrinsics.checkParameterIsNotNull(downloadInfo, "downloadInfo");
                    FetchUtils.deleteAllInFolderForId(downloadInfo.getId(), this.this$0.getFetchConfiguration().getStorageResolver().getDirectoryForFileDownloaderTypeParallel(FetchUtils.getRequestForDownload$default(downloadInfo, (String) null, 2, (Object) null)));
                }
            });
        }

        public final FetchConfiguration getFetchConfiguration() {
            return this.fetchConfiguration;
        }

        public final HandlerWrapper getHandlerWrapper() {
            return this.handlerWrapper;
        }

        public final FetchDatabaseManagerWrapper getFetchDatabaseManagerWrapper() {
            return this.fetchDatabaseManagerWrapper;
        }

        public final DownloadProvider getDownloadProvider() {
            return this.downloadProvider;
        }

        public final GroupInfoProvider getGroupInfoProvider() {
            return this.groupInfoProvider;
        }

        public final Handler getUiHandler() {
            return this.uiHandler;
        }

        public final ListenerCoordinator getListenerCoordinator() {
            return this.listenerCoordinator;
        }

        public final DownloadManager getDownloadManager() {
            return this.downloadManager;
        }

        public final PriorityListProcessor<Download> getPriorityListProcessor() {
            return this.priorityListProcessor;
        }

        public final DownloadInfoUpdater getDownloadInfoUpdater() {
            return this.downloadInfoUpdater;
        }

        public final NetworkInfoProvider getNetworkInfoProvider() {
            return this.networkInfoProvider;
        }

        public final FetchHandler getFetchHandler() {
            return this.fetchHandler;
        }
    }
}
