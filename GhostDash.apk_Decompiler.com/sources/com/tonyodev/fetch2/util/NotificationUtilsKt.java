package com.tonyodev.fetch2.util;

import android.content.Context;
import android.content.Intent;
import com.tonyodev.fetch2.DownloadNotification;
import com.tonyodev.fetch2.Fetch;
import com.tonyodev.fetch2.FetchIntent;
import com.tonyodev.fetch2.FetchNotificationManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"onDownloadNotificationActionTriggered", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "fetchNotificationManager", "Lcom/tonyodev/fetch2/FetchNotificationManager;", "fetch2_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: NotificationUtils.kt */
public final class NotificationUtilsKt {
    public static final void onDownloadNotificationActionTriggered(Context context, Intent intent, FetchNotificationManager fetchNotificationManager) {
        List list;
        Intrinsics.checkParameterIsNotNull(fetchNotificationManager, "fetchNotificationManager");
        if (context != null && intent != null) {
            String stringExtra = intent.getStringExtra(FetchIntent.EXTRA_NAMESPACE);
            int intExtra = intent.getIntExtra(FetchIntent.EXTRA_DOWNLOAD_ID, -1);
            int intExtra2 = intent.getIntExtra(FetchIntent.EXTRA_ACTION_TYPE, -1);
            intent.getIntExtra(FetchIntent.EXTRA_NOTIFICATION_ID, -1);
            int intExtra3 = intent.getIntExtra(FetchIntent.EXTRA_NOTIFICATION_GROUP_ID, -1);
            boolean z = false;
            boolean booleanExtra = intent.getBooleanExtra(FetchIntent.EXTRA_GROUP_ACTION, false);
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(FetchIntent.EXTRA_DOWNLOAD_NOTIFICATIONS);
            if (parcelableArrayListExtra != null) {
                list = parcelableArrayListExtra;
            } else {
                list = CollectionsKt.emptyList();
            }
            if (!booleanExtra) {
                CharSequence charSequence = stringExtra;
                if (charSequence == null || charSequence.length() == 0) {
                    z = true;
                }
                if (!z && intExtra != -1 && intExtra2 != -1) {
                    Fetch fetchInstanceForNamespace = fetchNotificationManager.getFetchInstanceForNamespace(stringExtra);
                    if (fetchInstanceForNamespace.isClosed()) {
                        return;
                    }
                    if (intExtra2 == 0) {
                        fetchInstanceForNamespace.pause(intExtra);
                    } else if (intExtra2 == 1) {
                        fetchInstanceForNamespace.resume(intExtra);
                    } else if (intExtra2 == 2) {
                        fetchInstanceForNamespace.delete(intExtra);
                    } else if (intExtra2 == 4) {
                        fetchInstanceForNamespace.cancel(intExtra);
                    } else if (intExtra2 == 5) {
                        fetchInstanceForNamespace.retry(intExtra);
                    }
                }
            } else if (intExtra3 != -1 && (!list.isEmpty())) {
                Map linkedHashMap = new LinkedHashMap();
                for (Object next : list) {
                    String namespace = ((DownloadNotification) next).getNamespace();
                    Object obj = linkedHashMap.get(namespace);
                    if (obj == null) {
                        obj = new ArrayList();
                        linkedHashMap.put(namespace, obj);
                    }
                    ((List) obj).add(next);
                }
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    String str = (String) entry.getKey();
                    Iterable<DownloadNotification> iterable = (Iterable) entry.getValue();
                    Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                    for (DownloadNotification notificationId : iterable) {
                        arrayList.add(Integer.valueOf(notificationId.getNotificationId()));
                    }
                    List list2 = (List) arrayList;
                    Fetch fetchInstanceForNamespace2 = fetchNotificationManager.getFetchInstanceForNamespace(str);
                    if (!fetchInstanceForNamespace2.isClosed()) {
                        switch (intExtra2) {
                            case 6:
                                fetchInstanceForNamespace2.pause((List<Integer>) list2);
                                break;
                            case 7:
                                fetchInstanceForNamespace2.resume((List<Integer>) list2);
                                break;
                            case 8:
                                fetchInstanceForNamespace2.cancel((List<Integer>) list2);
                                break;
                            case 9:
                                fetchInstanceForNamespace2.delete((List<Integer>) list2);
                                break;
                            case 10:
                                fetchInstanceForNamespace2.retry((List<Integer>) list2);
                                break;
                        }
                    }
                }
            }
        }
    }
}
