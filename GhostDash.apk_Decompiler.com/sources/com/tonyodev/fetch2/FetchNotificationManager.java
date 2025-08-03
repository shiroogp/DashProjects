package com.tonyodev.fetch2;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.tonyodev.fetch2.DownloadNotification;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000bH&J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0018\u0010\u001a\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0007H&J&\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\r2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170$2\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0018\u0010%\u001a\u00020&2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\rH&J\b\u0010'\u001a\u00020(H&J\u0018\u0010)\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\rH&J\u0010\u0010+\u001a\u00020,2\u0006\u0010\u001c\u001a\u00020\u001dH&J\b\u0010-\u001a\u00020\u000bH&J\u0010\u0010.\u001a\u00020,2\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010/\u001a\u00020,2\u0006\u0010\u0016\u001a\u00020\u0017H&J\b\u00100\u001a\u00020\u000bH&J.\u00101\u001a\u00020,2\u0006\u0010\"\u001a\u00020\r2\u0006\u00102\u001a\u00020&2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170$2\u0006\u0010\u0010\u001a\u00020\u0011H&J \u00103\u001a\u00020\u000b2\u0006\u00102\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0011H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u00064"}, d2 = {"Lcom/tonyodev/fetch2/FetchNotificationManager;", "", "broadcastReceiver", "Landroid/content/BroadcastReceiver;", "getBroadcastReceiver", "()Landroid/content/BroadcastReceiver;", "notificationManagerAction", "", "getNotificationManagerAction", "()Ljava/lang/String;", "cancelNotification", "", "notificationId", "", "cancelOngoingNotifications", "createNotificationChannels", "context", "Landroid/content/Context;", "notificationManager", "Landroid/app/NotificationManager;", "getActionPendingIntent", "Landroid/app/PendingIntent;", "downloadNotification", "Lcom/tonyodev/fetch2/DownloadNotification;", "actionType", "Lcom/tonyodev/fetch2/DownloadNotification$ActionType;", "getChannelId", "getDownloadNotificationTitle", "download", "Lcom/tonyodev/fetch2/Download;", "getFetchInstanceForNamespace", "Lcom/tonyodev/fetch2/Fetch;", "namespace", "getGroupActionPendingIntent", "groupId", "downloadNotifications", "", "getNotificationBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "getNotificationTimeOutMillis", "", "getSubtitleText", "notify", "postDownloadUpdate", "", "registerBroadcastReceiver", "shouldCancelNotification", "shouldUpdateNotification", "unregisterBroadcastReceiver", "updateGroupSummaryNotification", "notificationBuilder", "updateNotification", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FetchNotificationManager.kt */
public interface FetchNotificationManager {
    void cancelNotification(int i);

    void cancelOngoingNotifications();

    void createNotificationChannels(Context context, NotificationManager notificationManager);

    PendingIntent getActionPendingIntent(DownloadNotification downloadNotification, DownloadNotification.ActionType actionType);

    BroadcastReceiver getBroadcastReceiver();

    String getChannelId(int i, Context context);

    String getDownloadNotificationTitle(Download download);

    Fetch getFetchInstanceForNamespace(String str);

    PendingIntent getGroupActionPendingIntent(int i, List<? extends DownloadNotification> list, DownloadNotification.ActionType actionType);

    NotificationCompat.Builder getNotificationBuilder(int i, int i2);

    String getNotificationManagerAction();

    long getNotificationTimeOutMillis();

    String getSubtitleText(Context context, DownloadNotification downloadNotification);

    void notify(int i);

    boolean postDownloadUpdate(Download download);

    void registerBroadcastReceiver();

    boolean shouldCancelNotification(DownloadNotification downloadNotification);

    boolean shouldUpdateNotification(DownloadNotification downloadNotification);

    void unregisterBroadcastReceiver();

    boolean updateGroupSummaryNotification(int i, NotificationCompat.Builder builder, List<? extends DownloadNotification> list, Context context);

    void updateNotification(NotificationCompat.Builder builder, DownloadNotification downloadNotification, Context context);
}
