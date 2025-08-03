package com.tonyodev.fetch2;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import com.tonyodev.fetch2.DownloadNotification;
import com.tonyodev.fetch2.util.FetchDefaults;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010%\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0014H&J&\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u000b2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00100.2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010/\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000bH\u0017J\b\u00100\u001a\u00020'H\u0016J\u0018\u00101\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0010H\u0016J\b\u00102\u001a\u00020\u0018H\u0002J\u0010\u00103\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u000bH\u0016J\u0010\u00104\u001a\u0002052\u0006\u0010#\u001a\u00020$H\u0016J\b\u00106\u001a\u00020\u0018H\u0016J\u0010\u00107\u001a\u0002052\u0006\u0010\u001e\u001a\u00020\u0010H\u0016J\u0010\u00108\u001a\u0002052\u0006\u0010\u001e\u001a\u00020\u0010H\u0016J\b\u00109\u001a\u00020\u0018H\u0016J.\u0010:\u001a\u0002052\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000e2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00100.2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J \u0010<\u001a\u00020\u00182\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00100\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006="}, d2 = {"Lcom/tonyodev/fetch2/DefaultFetchNotificationManager;", "Lcom/tonyodev/fetch2/FetchNotificationManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "broadcastReceiver", "Landroid/content/BroadcastReceiver;", "getBroadcastReceiver", "()Landroid/content/BroadcastReceiver;", "downloadNotificationExcludeSet", "", "", "downloadNotificationsBuilderMap", "", "Landroidx/core/app/NotificationCompat$Builder;", "downloadNotificationsMap", "Lcom/tonyodev/fetch2/DownloadNotification;", "notificationManager", "Landroid/app/NotificationManager;", "notificationManagerAction", "", "getNotificationManagerAction", "()Ljava/lang/String;", "cancelNotification", "", "notificationId", "cancelOngoingNotifications", "createNotificationChannels", "getActionPendingIntent", "Landroid/app/PendingIntent;", "downloadNotification", "actionType", "Lcom/tonyodev/fetch2/DownloadNotification$ActionType;", "getChannelId", "getDownloadNotificationTitle", "download", "Lcom/tonyodev/fetch2/Download;", "getEtaText", "etaInMilliSeconds", "", "getFetchInstanceForNamespace", "Lcom/tonyodev/fetch2/Fetch;", "namespace", "getGroupActionPendingIntent", "groupId", "downloadNotifications", "", "getNotificationBuilder", "getNotificationTimeOutMillis", "getSubtitleText", "initialize", "notify", "postDownloadUpdate", "", "registerBroadcastReceiver", "shouldCancelNotification", "shouldUpdateNotification", "unregisterBroadcastReceiver", "updateGroupSummaryNotification", "notificationBuilder", "updateNotification", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DefaultFetchNotificationManager.kt */
public abstract class DefaultFetchNotificationManager implements FetchNotificationManager {
    private final Context context;
    private final Set<Integer> downloadNotificationExcludeSet;
    private final Map<Integer, NotificationCompat.Builder> downloadNotificationsBuilderMap;
    private final Map<Integer, DownloadNotification> downloadNotificationsMap;
    private final NotificationManager notificationManager;
    private final String notificationManagerAction;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[DownloadNotification.ActionType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[DownloadNotification.ActionType.CANCEL.ordinal()] = 1;
            iArr[DownloadNotification.ActionType.DELETE.ordinal()] = 2;
            iArr[DownloadNotification.ActionType.RESUME.ordinal()] = 3;
            iArr[DownloadNotification.ActionType.PAUSE.ordinal()] = 4;
            iArr[DownloadNotification.ActionType.RETRY.ordinal()] = 5;
            int[] iArr2 = new int[DownloadNotification.ActionType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[DownloadNotification.ActionType.CANCEL_ALL.ordinal()] = 1;
            iArr2[DownloadNotification.ActionType.DELETE_ALL.ordinal()] = 2;
            iArr2[DownloadNotification.ActionType.RESUME_ALL.ordinal()] = 3;
            iArr2[DownloadNotification.ActionType.PAUSE_ALL.ordinal()] = 4;
            iArr2[DownloadNotification.ActionType.RETRY_ALL.ordinal()] = 5;
            int[] iArr3 = new int[Status.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[Status.COMPLETED.ordinal()] = 1;
            iArr3[Status.FAILED.ordinal()] = 2;
        }
    }

    public abstract Fetch getFetchInstanceForNamespace(String str);

    public long getNotificationTimeOutMillis() {
        return FetchDefaults.DEFAULT_NOTIFICATION_TIMEOUT_AFTER;
    }

    public DefaultFetchNotificationManager(Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Context applicationContext = context2.getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "context.applicationContext");
        this.context = applicationContext;
        Object systemService = context2.getSystemService("notification");
        if (systemService != null) {
            this.notificationManager = (NotificationManager) systemService;
            this.downloadNotificationsMap = new LinkedHashMap();
            this.downloadNotificationsBuilderMap = new LinkedHashMap();
            this.downloadNotificationExcludeSet = new LinkedHashSet();
            this.notificationManagerAction = "DEFAULT_FETCH2_NOTIFICATION_MANAGER_ACTION_" + System.currentTimeMillis();
            initialize();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.NotificationManager");
    }

    public String getNotificationManagerAction() {
        return this.notificationManagerAction;
    }

    public BroadcastReceiver getBroadcastReceiver() {
        return new DefaultFetchNotificationManager$broadcastReceiver$1(this);
    }

    private final void initialize() {
        registerBroadcastReceiver();
        createNotificationChannels(this.context, this.notificationManager);
    }

    public void registerBroadcastReceiver() {
        this.context.registerReceiver(getBroadcastReceiver(), new IntentFilter(getNotificationManagerAction()));
    }

    public void unregisterBroadcastReceiver() {
        this.context.unregisterReceiver(getBroadcastReceiver());
    }

    public void createNotificationChannels(Context context2, NotificationManager notificationManager2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(notificationManager2, "notificationManager");
        if (Build.VERSION.SDK_INT >= 26) {
            String string = context2.getString(R.string.fetch_notification_default_channel_id);
            Intrinsics.checkExpressionValueIsNotNull(string, "context.getString(R.stri…ation_default_channel_id)");
            if (notificationManager2.getNotificationChannel(string) == null) {
                String string2 = context2.getString(R.string.fetch_notification_default_channel_name);
                Intrinsics.checkExpressionValueIsNotNull(string2, "context.getString(R.stri…ion_default_channel_name)");
                notificationManager2.createNotificationChannel(new NotificationChannel(string, string2, 3));
            }
        }
    }

    public String getChannelId(int i, Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        String string = context2.getString(R.string.fetch_notification_default_channel_id);
        Intrinsics.checkExpressionValueIsNotNull(string, "context.getString(R.stri…ation_default_channel_id)");
        return string;
    }

    public boolean updateGroupSummaryNotification(int i, NotificationCompat.Builder builder, List<? extends DownloadNotification> list, Context context2) {
        Intrinsics.checkParameterIsNotNull(builder, "notificationBuilder");
        Intrinsics.checkParameterIsNotNull(list, "downloadNotifications");
        Intrinsics.checkParameterIsNotNull(context2, "context");
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        for (DownloadNotification downloadNotification : list) {
            inboxStyle.addLine(downloadNotification.getTotal() + ' ' + getSubtitleText(context2, downloadNotification));
        }
        builder.setPriority(0).setSmallIcon(17301634).setContentTitle(context2.getString(R.string.fetch_notification_default_channel_name)).setContentText("").setStyle(inboxStyle).setOnlyAlertOnce(true).setGroup(String.valueOf(i)).setGroupSummary(true);
        return false;
    }

    public void updateNotification(NotificationCompat.Builder builder, DownloadNotification downloadNotification, Context context2) {
        Intrinsics.checkParameterIsNotNull(builder, "notificationBuilder");
        Intrinsics.checkParameterIsNotNull(downloadNotification, "downloadNotification");
        Intrinsics.checkParameterIsNotNull(context2, "context");
        int i = 0;
        builder.setPriority(0).setSmallIcon(downloadNotification.isDownloading() ? 17301633 : 17301634).setContentTitle(downloadNotification.getTitle()).setContentText(getSubtitleText(context2, downloadNotification)).setOngoing(downloadNotification.isOnGoingNotification()).setGroup(String.valueOf(downloadNotification.getGroupId())).setGroupSummary(false);
        if (downloadNotification.isFailed() || downloadNotification.isCompleted()) {
            builder.setProgress(0, 0, false);
        } else {
            boolean progressIndeterminate = downloadNotification.getProgressIndeterminate();
            int i2 = downloadNotification.getProgressIndeterminate() ? 0 : 100;
            if (downloadNotification.getProgress() >= 0) {
                i = downloadNotification.getProgress();
            }
            builder.setProgress(i2, i, progressIndeterminate);
        }
        if (downloadNotification.isDownloading()) {
            builder.setTimeoutAfter(getNotificationTimeOutMillis()).addAction(R.drawable.fetch_notification_pause, context2.getString(R.string.fetch_notification_download_pause), getActionPendingIntent(downloadNotification, DownloadNotification.ActionType.PAUSE)).addAction(R.drawable.fetch_notification_cancel, context2.getString(R.string.fetch_notification_download_cancel), getActionPendingIntent(downloadNotification, DownloadNotification.ActionType.CANCEL));
        } else if (downloadNotification.isPaused()) {
            builder.setTimeoutAfter(getNotificationTimeOutMillis()).addAction(R.drawable.fetch_notification_resume, context2.getString(R.string.fetch_notification_download_resume), getActionPendingIntent(downloadNotification, DownloadNotification.ActionType.RESUME)).addAction(R.drawable.fetch_notification_cancel, context2.getString(R.string.fetch_notification_download_cancel), getActionPendingIntent(downloadNotification, DownloadNotification.ActionType.CANCEL));
        } else if (downloadNotification.isQueued()) {
            builder.setTimeoutAfter(getNotificationTimeOutMillis());
        } else {
            builder.setTimeoutAfter(FetchDefaults.DEFAULT_NOTIFICATION_TIMEOUT_AFTER_RESET);
        }
    }

    public PendingIntent getActionPendingIntent(DownloadNotification downloadNotification, DownloadNotification.ActionType actionType) {
        PendingIntent broadcast;
        Intrinsics.checkParameterIsNotNull(downloadNotification, "downloadNotification");
        Intrinsics.checkParameterIsNotNull(actionType, "actionType");
        synchronized (this.downloadNotificationsMap) {
            Intent intent = new Intent(getNotificationManagerAction());
            intent.putExtra(FetchIntent.EXTRA_NAMESPACE, downloadNotification.getNamespace());
            intent.putExtra(FetchIntent.EXTRA_DOWNLOAD_ID, downloadNotification.getNotificationId());
            intent.putExtra(FetchIntent.EXTRA_NOTIFICATION_ID, downloadNotification.getNotificationId());
            int i = 0;
            intent.putExtra(FetchIntent.EXTRA_GROUP_ACTION, false);
            intent.putExtra(FetchIntent.EXTRA_NOTIFICATION_GROUP_ID, downloadNotification.getGroupId());
            int i2 = WhenMappings.$EnumSwitchMapping$0[actionType.ordinal()];
            if (i2 == 1) {
                i = 4;
            } else if (i2 == 2) {
                i = 2;
            } else if (i2 == 3) {
                i = 1;
            } else if (i2 != 4) {
                i = i2 != 5 ? -1 : 5;
            }
            intent.putExtra(FetchIntent.EXTRA_ACTION_TYPE, i);
            broadcast = PendingIntent.getBroadcast(this.context, downloadNotification.getNotificationId() + i, intent, 134217728);
            Intrinsics.checkExpressionValueIsNotNull(broadcast, "PendingIntent.getBroadca…tent.FLAG_UPDATE_CURRENT)");
        }
        return broadcast;
    }

    public PendingIntent getGroupActionPendingIntent(int i, List<? extends DownloadNotification> list, DownloadNotification.ActionType actionType) {
        PendingIntent broadcast;
        Intrinsics.checkParameterIsNotNull(list, "downloadNotifications");
        Intrinsics.checkParameterIsNotNull(actionType, "actionType");
        synchronized (this.downloadNotificationsMap) {
            Intent intent = new Intent(getNotificationManagerAction());
            intent.putExtra(FetchIntent.EXTRA_NOTIFICATION_GROUP_ID, i);
            intent.putExtra(FetchIntent.EXTRA_DOWNLOAD_NOTIFICATIONS, new ArrayList(list));
            intent.putExtra(FetchIntent.EXTRA_GROUP_ACTION, true);
            int i2 = WhenMappings.$EnumSwitchMapping$1[actionType.ordinal()];
            int i3 = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? -1 : 10 : 6 : 7 : 9 : 8;
            intent.putExtra(FetchIntent.EXTRA_ACTION_TYPE, i3);
            broadcast = PendingIntent.getBroadcast(this.context, i + i3, intent, 134217728);
            Intrinsics.checkExpressionValueIsNotNull(broadcast, "PendingIntent.getBroadca…tent.FLAG_UPDATE_CURRENT)");
        }
        return broadcast;
    }

    public void cancelNotification(int i) {
        synchronized (this.downloadNotificationsMap) {
            this.notificationManager.cancel(i);
            this.downloadNotificationsBuilderMap.remove(Integer.valueOf(i));
            this.downloadNotificationExcludeSet.remove(Integer.valueOf(i));
            DownloadNotification downloadNotification = this.downloadNotificationsMap.get(Integer.valueOf(i));
            if (downloadNotification != null) {
                this.downloadNotificationsMap.remove(Integer.valueOf(i));
                notify(downloadNotification.getGroupId());
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public void cancelOngoingNotifications() {
        synchronized (this.downloadNotificationsMap) {
            Iterator<DownloadNotification> it2 = this.downloadNotificationsMap.values().iterator();
            while (it2.hasNext()) {
                DownloadNotification next = it2.next();
                if (!next.isFailed() && !next.isCompleted()) {
                    this.notificationManager.cancel(next.getNotificationId());
                    this.downloadNotificationsBuilderMap.remove(Integer.valueOf(next.getNotificationId()));
                    this.downloadNotificationExcludeSet.remove(Integer.valueOf(next.getNotificationId()));
                    it2.remove();
                    notify(next.getGroupId());
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public void notify(int i) {
        synchronized (this.downloadNotificationsMap) {
            Collection arrayList = new ArrayList();
            Iterator it2 = this.downloadNotificationsMap.values().iterator();
            while (true) {
                boolean z = true;
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (((DownloadNotification) next).getGroupId() != i) {
                    z = false;
                }
                if (z) {
                    arrayList.add(next);
                }
            }
            List<DownloadNotification> list = (List) arrayList;
            NotificationCompat.Builder notificationBuilder = getNotificationBuilder(i, i);
            boolean updateGroupSummaryNotification = updateGroupSummaryNotification(i, notificationBuilder, list, this.context);
            for (DownloadNotification downloadNotification : list) {
                if (shouldUpdateNotification(downloadNotification)) {
                    int notificationId = downloadNotification.getNotificationId();
                    NotificationCompat.Builder notificationBuilder2 = getNotificationBuilder(notificationId, i);
                    updateNotification(notificationBuilder2, downloadNotification, this.context);
                    this.notificationManager.notify(notificationId, notificationBuilder2.build());
                    int i2 = WhenMappings.$EnumSwitchMapping$2[downloadNotification.getStatus().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        this.downloadNotificationExcludeSet.add(Integer.valueOf(downloadNotification.getNotificationId()));
                    }
                }
            }
            if (updateGroupSummaryNotification) {
                this.notificationManager.notify(i, notificationBuilder.build());
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public boolean shouldUpdateNotification(DownloadNotification downloadNotification) {
        Intrinsics.checkParameterIsNotNull(downloadNotification, "downloadNotification");
        return !this.downloadNotificationExcludeSet.contains(Integer.valueOf(downloadNotification.getNotificationId()));
    }

    public boolean shouldCancelNotification(DownloadNotification downloadNotification) {
        Intrinsics.checkParameterIsNotNull(downloadNotification, "downloadNotification");
        return downloadNotification.isPaused();
    }

    public boolean postDownloadUpdate(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        synchronized (this.downloadNotificationsMap) {
            if (this.downloadNotificationsMap.size() > 50) {
                this.downloadNotificationsBuilderMap.clear();
                this.downloadNotificationsMap.clear();
            }
            DownloadNotification downloadNotification = this.downloadNotificationsMap.get(Integer.valueOf(download.getId()));
            if (downloadNotification == null) {
                downloadNotification = new DownloadNotification();
            }
            downloadNotification.setStatus(download.getStatus());
            downloadNotification.setProgress(download.getProgress());
            downloadNotification.setNotificationId(download.getId());
            downloadNotification.setGroupId(download.getGroup());
            downloadNotification.setEtaInMilliSeconds(download.getEtaInMilliSeconds());
            downloadNotification.setDownloadedBytesPerSecond(download.getDownloadedBytesPerSecond());
            downloadNotification.setTotal(download.getTotal());
            downloadNotification.setDownloaded(download.getDownloaded());
            downloadNotification.setNamespace(download.getNamespace());
            downloadNotification.setTitle(getDownloadNotificationTitle(download));
            this.downloadNotificationsMap.put(Integer.valueOf(download.getId()), downloadNotification);
            if (this.downloadNotificationExcludeSet.contains(Integer.valueOf(downloadNotification.getNotificationId())) && !downloadNotification.isFailed() && !downloadNotification.isCompleted()) {
                this.downloadNotificationExcludeSet.remove(Integer.valueOf(downloadNotification.getNotificationId()));
            }
            if (!downloadNotification.isCancelledNotification()) {
                if (!shouldCancelNotification(downloadNotification)) {
                    notify(download.getGroup());
                }
            }
            cancelNotification(downloadNotification.getNotificationId());
        }
        return true;
    }

    public NotificationCompat.Builder getNotificationBuilder(int i, int i2) {
        NotificationCompat.Builder builder;
        synchronized (this.downloadNotificationsMap) {
            builder = this.downloadNotificationsBuilderMap.get(Integer.valueOf(i));
            if (builder == null) {
                Context context2 = this.context;
                builder = new NotificationCompat.Builder(context2, getChannelId(i, context2));
            }
            this.downloadNotificationsBuilderMap.put(Integer.valueOf(i), builder);
            builder.setGroup(String.valueOf(i)).setStyle((NotificationCompat.Style) null).setProgress(0, 0, false).setContentTitle((CharSequence) null).setContentText((CharSequence) null).setContentIntent((PendingIntent) null).setGroupSummary(false).setTimeoutAfter(FetchDefaults.DEFAULT_NOTIFICATION_TIMEOUT_AFTER_RESET).setOngoing(false).setGroup(String.valueOf(i2)).setOnlyAlertOnce(true).setSmallIcon(17301634).mActions.clear();
        }
        return builder;
    }

    public String getDownloadNotificationTitle(Download download) {
        Intrinsics.checkParameterIsNotNull(download, "download");
        String lastPathSegment = download.getFileUri().getLastPathSegment();
        if (lastPathSegment == null) {
            Uri parse = Uri.parse(download.getUrl());
            Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(download.url)");
            lastPathSegment = parse.getLastPathSegment();
        }
        return lastPathSegment != null ? lastPathSegment : download.getUrl();
    }

    public String getSubtitleText(Context context2, DownloadNotification downloadNotification) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(downloadNotification, "downloadNotification");
        if (downloadNotification.isCompleted()) {
            String string = context2.getString(R.string.fetch_notification_download_complete);
            Intrinsics.checkExpressionValueIsNotNull(string, "context.getString(R.stri…cation_download_complete)");
            return string;
        } else if (downloadNotification.isFailed()) {
            String string2 = context2.getString(R.string.fetch_notification_download_failed);
            Intrinsics.checkExpressionValueIsNotNull(string2, "context.getString(R.stri…fication_download_failed)");
            return string2;
        } else if (downloadNotification.isPaused()) {
            String string3 = context2.getString(R.string.fetch_notification_download_paused);
            Intrinsics.checkExpressionValueIsNotNull(string3, "context.getString(R.stri…fication_download_paused)");
            return string3;
        } else if (downloadNotification.isQueued()) {
            String string4 = context2.getString(R.string.fetch_notification_download_starting);
            Intrinsics.checkExpressionValueIsNotNull(string4, "context.getString(R.stri…cation_download_starting)");
            return string4;
        } else if (downloadNotification.getEtaInMilliSeconds() >= 0) {
            return getEtaText(context2, downloadNotification.getEtaInMilliSeconds());
        } else {
            String string5 = context2.getString(R.string.fetch_notification_download_downloading);
            Intrinsics.checkExpressionValueIsNotNull(string5, "context.getString(R.stri…ion_download_downloading)");
            return string5;
        }
    }

    private final String getEtaText(Context context2, long j) {
        long j2 = j / ((long) 1000);
        long j3 = (long) NikonType2MakernoteDirectory.TAG_NIKON_SCAN;
        long j4 = j2 / j3;
        long j5 = j2 - (j3 * j4);
        long j6 = (long) 60;
        long j7 = j5 / j6;
        long j8 = j5 - (j6 * j7);
        if (j4 > 0) {
            String string = context2.getString(R.string.fetch_notification_download_eta_hrs, new Object[]{Long.valueOf(j4), Long.valueOf(j7), Long.valueOf(j8)});
            Intrinsics.checkExpressionValueIsNotNull(string, "context.getString(R.stri… hours, minutes, seconds)");
            return string;
        } else if (j7 > 0) {
            String string2 = context2.getString(R.string.fetch_notification_download_eta_min, new Object[]{Long.valueOf(j7), Long.valueOf(j8)});
            Intrinsics.checkExpressionValueIsNotNull(string2, "context.getString(R.stri…ta_min, minutes, seconds)");
            return string2;
        } else {
            String string3 = context2.getString(R.string.fetch_notification_download_eta_sec, new Object[]{Long.valueOf(j8)});
            Intrinsics.checkExpressionValueIsNotNull(string3, "context.getString(R.stri…ownload_eta_sec, seconds)");
            return string3;
        }
    }
}
