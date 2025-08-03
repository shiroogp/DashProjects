package com.tonyodev.fetch2.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.facebook.common.util.UriUtil;
import com.tonyodev.fetch2.PrioritySort;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2.database.FetchDatabaseManager;
import com.tonyodev.fetch2.database.migration.Migration;
import com.tonyodev.fetch2.exception.FetchException;
import com.tonyodev.fetch2.fetch.LiveSettings;
import com.tonyodev.fetch2.util.FetchDefaults;
import com.tonyodev.fetch2core.DefaultStorageResolver;
import com.tonyodev.fetch2core.Extras;
import com.tonyodev.fetch2core.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0002H\u0016J\u0016\u0010(\u001a\u00020'2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020+H\u0016J\b\u0010,\u001a\u00020'H\u0016J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00020+H\u0016J\u0012\u0010-\u001a\u0004\u0018\u00010\u00022\u0006\u0010.\u001a\u00020/H\u0016J\u001e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020+2\f\u00100\u001a\b\u0012\u0004\u0012\u00020/0+H\u0016J\u000e\u00101\u001a\b\u0012\u0004\u0012\u00020/0+H\u0016J\u0012\u00102\u001a\u0004\u0018\u00010\u00022\u0006\u00103\u001a\u00020\u0006H\u0016J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00020\u00020+2\u0006\u00105\u001a\u00020/H\u0016J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00020\u00020+2\u0006\u00107\u001a\u000208H\u0016J\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u00020+2\f\u00109\u001a\b\u0012\u0004\u0012\u0002080+H\u0016J\u0016\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00020+2\u0006\u0010;\u001a\u00020<H\u0016J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00020+2\u0006\u0010>\u001a\u00020\u0006H\u0016J$\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00020+2\u0006\u0010@\u001a\u00020/2\f\u00109\u001a\b\u0012\u0004\u0012\u0002080+H\u0016J\b\u0010A\u001a\u00020\u0002H\u0016J\u0010\u0010B\u001a\u00020<2\u0006\u0010C\u001a\u00020\u000fH\u0016J\u0016\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00020+2\u0006\u0010E\u001a\u00020FH\u0016J\u001c\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0H2\u0006\u0010)\u001a\u00020\u0002H\u0016J(\u0010G\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0H0+2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020+H\u0016J\u0010\u0010I\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0002H\u0002J\u0018\u0010J\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u000fH\u0002J\u0010\u0010L\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0002H\u0002J\u001c\u0010M\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010N\u001a\u00020\u000fH\u0002J \u0010M\u001a\u00020\u000f2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00020+2\b\b\u0002\u0010K\u001a\u00020\u000fH\u0002J\b\u0010P\u001a\u00020'H\u0016J\b\u0010Q\u001a\u00020'H\u0002J\u0010\u0010R\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0002H\u0016J\u0016\u0010R\u001a\u00020'2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020+H\u0016J\u001a\u0010S\u001a\u0004\u0018\u00010\u00022\u0006\u0010.\u001a\u00020/2\u0006\u0010T\u001a\u00020UH\u0016J\u0010\u0010V\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0002H\u0016R\u000e\u0010\u0013\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020%X\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/tonyodev/fetch2/database/FetchDatabaseManagerImpl;", "Lcom/tonyodev/fetch2/database/FetchDatabaseManager;", "Lcom/tonyodev/fetch2/database/DownloadInfo;", "context", "Landroid/content/Context;", "namespace", "", "logger", "Lcom/tonyodev/fetch2core/Logger;", "migrations", "", "Lcom/tonyodev/fetch2/database/migration/Migration;", "liveSettings", "Lcom/tonyodev/fetch2/fetch/LiveSettings;", "fileExistChecksEnabled", "", "defaultStorageResolver", "Lcom/tonyodev/fetch2core/DefaultStorageResolver;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tonyodev/fetch2core/Logger;[Lcom/tonyodev/fetch2/database/migration/Migration;Lcom/tonyodev/fetch2/fetch/LiveSettings;ZLcom/tonyodev/fetch2core/DefaultStorageResolver;)V", "closed", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "delegate", "Lcom/tonyodev/fetch2/database/FetchDatabaseManager$Delegate;", "getDelegate", "()Lcom/tonyodev/fetch2/database/FetchDatabaseManager$Delegate;", "setDelegate", "(Lcom/tonyodev/fetch2/database/FetchDatabaseManager$Delegate;)V", "isClosed", "()Z", "getLogger", "()Lcom/tonyodev/fetch2core/Logger;", "pendingCountIncludeAddedQuery", "pendingCountQuery", "requestDatabase", "Lcom/tonyodev/fetch2/database/DownloadDatabase;", "updatedDownloadsList", "", "close", "", "delete", "downloadInfo", "downloadInfoList", "", "deleteAll", "get", "id", "", "ids", "getAllGroupIds", "getByFile", "file", "getByGroup", "group", "getByStatus", "status", "Lcom/tonyodev/fetch2/Status;", "statuses", "getDownloadsByRequestIdentifier", "identifier", "", "getDownloadsByTag", "tag", "getDownloadsInGroupWithStatus", "groupId", "getNewDownloadInfoInstance", "getPendingCount", "includeAddedDownloads", "getPendingDownloadsSorted", "prioritySort", "Lcom/tonyodev/fetch2/PrioritySort;", "insert", "Lkotlin/Pair;", "onCompleted", "onDownloading", "firstEntry", "onPaused", "sanitize", "initializing", "downloads", "sanitizeOnFirstEntry", "throwExceptionIfClosed", "update", "updateExtras", "extras", "Lcom/tonyodev/fetch2core/Extras;", "updateFileBytesInfoAndStatusOnly", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FetchDatabaseManagerImpl.kt */
public final class FetchDatabaseManagerImpl implements FetchDatabaseManager<DownloadInfo> {
    private volatile boolean closed;
    private final SupportSQLiteDatabase database;
    private final DefaultStorageResolver defaultStorageResolver;
    private FetchDatabaseManager.Delegate<DownloadInfo> delegate;
    private final boolean fileExistChecksEnabled;
    private final LiveSettings liveSettings;
    private final Logger logger;
    private final String namespace;
    private final String pendingCountIncludeAddedQuery = ("SELECT _id FROM requests" + " WHERE _status = '" + Status.QUEUED.getValue() + '\'' + " OR _status = '" + Status.DOWNLOADING.getValue() + '\'' + " OR _status = '" + Status.ADDED.getValue() + '\'');
    private final String pendingCountQuery = ("SELECT _id FROM requests" + " WHERE _status = '" + Status.QUEUED.getValue() + '\'' + " OR _status = '" + Status.DOWNLOADING.getValue() + '\'');
    private final DownloadDatabase requestDatabase;
    private final List<DownloadInfo> updatedDownloadsList = new ArrayList();

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Status.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Status.COMPLETED.ordinal()] = 1;
            iArr[Status.DOWNLOADING.ordinal()] = 2;
            iArr[Status.QUEUED.ordinal()] = 3;
            iArr[Status.PAUSED.ordinal()] = 4;
            iArr[Status.CANCELLED.ordinal()] = 5;
            iArr[Status.FAILED.ordinal()] = 6;
            iArr[Status.ADDED.ordinal()] = 7;
            iArr[Status.NONE.ordinal()] = 8;
            iArr[Status.DELETED.ordinal()] = 9;
            iArr[Status.REMOVED.ordinal()] = 10;
        }
    }

    public FetchDatabaseManagerImpl(Context context, String str, Logger logger2, Migration[] migrationArr, LiveSettings liveSettings2, boolean z, DefaultStorageResolver defaultStorageResolver2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "namespace");
        Intrinsics.checkParameterIsNotNull(logger2, "logger");
        Intrinsics.checkParameterIsNotNull(migrationArr, "migrations");
        Intrinsics.checkParameterIsNotNull(liveSettings2, "liveSettings");
        Intrinsics.checkParameterIsNotNull(defaultStorageResolver2, "defaultStorageResolver");
        this.namespace = str;
        this.logger = logger2;
        this.liveSettings = liveSettings2;
        this.fileExistChecksEnabled = z;
        this.defaultStorageResolver = defaultStorageResolver2;
        RoomDatabase.Builder<DownloadDatabase> databaseBuilder = Room.databaseBuilder(context, DownloadDatabase.class, str + ".db");
        Intrinsics.checkExpressionValueIsNotNull(databaseBuilder, "Room.databaseBuilder(con…ss.java, \"$namespace.db\")");
        androidx.room.migration.Migration[] migrationArr2 = (androidx.room.migration.Migration[]) migrationArr;
        databaseBuilder.addMigrations((androidx.room.migration.Migration[]) Arrays.copyOf(migrationArr2, migrationArr2.length));
        DownloadDatabase build = databaseBuilder.build();
        Intrinsics.checkExpressionValueIsNotNull(build, "builder.build()");
        DownloadDatabase downloadDatabase = build;
        this.requestDatabase = downloadDatabase;
        SupportSQLiteOpenHelper openHelper = downloadDatabase.getOpenHelper();
        Intrinsics.checkExpressionValueIsNotNull(openHelper, "requestDatabase.openHelper");
        SupportSQLiteDatabase writableDatabase = openHelper.getWritableDatabase();
        Intrinsics.checkExpressionValueIsNotNull(writableDatabase, "requestDatabase.openHelper.writableDatabase");
        this.database = writableDatabase;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public FetchDatabaseManager.Delegate<DownloadInfo> getDelegate() {
        return this.delegate;
    }

    public void setDelegate(FetchDatabaseManager.Delegate<DownloadInfo> delegate2) {
        this.delegate = delegate2;
    }

    public Pair<DownloadInfo, Boolean> insert(DownloadInfo downloadInfo) {
        Intrinsics.checkParameterIsNotNull(downloadInfo, "downloadInfo");
        throwExceptionIfClosed();
        return new Pair<>(downloadInfo, Boolean.valueOf(this.requestDatabase.wasRowInserted(this.requestDatabase.requestDao().insert(downloadInfo))));
    }

    public List<Pair<DownloadInfo, Boolean>> insert(List<? extends DownloadInfo> list) {
        Intrinsics.checkParameterIsNotNull(list, "downloadInfoList");
        throwExceptionIfClosed();
        List<Long> insert = this.requestDatabase.requestDao().insert(list);
        Iterable indices = CollectionsKt.getIndices(insert);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(indices, 10));
        Iterator it2 = indices.iterator();
        while (it2.hasNext()) {
            int nextInt = ((IntIterator) it2).nextInt();
            arrayList.add(new Pair(list.get(nextInt), Boolean.valueOf(this.requestDatabase.wasRowInserted(insert.get(nextInt).longValue()))));
        }
        return (List) arrayList;
    }

    public void delete(DownloadInfo downloadInfo) {
        Intrinsics.checkParameterIsNotNull(downloadInfo, "downloadInfo");
        throwExceptionIfClosed();
        this.requestDatabase.requestDao().delete(downloadInfo);
    }

    public void delete(List<? extends DownloadInfo> list) {
        Intrinsics.checkParameterIsNotNull(list, "downloadInfoList");
        throwExceptionIfClosed();
        this.requestDatabase.requestDao().delete(list);
    }

    public void deleteAll() {
        throwExceptionIfClosed();
        this.requestDatabase.requestDao().deleteAll();
        getLogger().d("Cleared Database " + this.namespace);
    }

    public void update(DownloadInfo downloadInfo) {
        Intrinsics.checkParameterIsNotNull(downloadInfo, "downloadInfo");
        throwExceptionIfClosed();
        this.requestDatabase.requestDao().update(downloadInfo);
    }

    public void update(List<? extends DownloadInfo> list) {
        Intrinsics.checkParameterIsNotNull(list, "downloadInfoList");
        throwExceptionIfClosed();
        this.requestDatabase.requestDao().update(list);
    }

    public void updateFileBytesInfoAndStatusOnly(DownloadInfo downloadInfo) {
        Intrinsics.checkParameterIsNotNull(downloadInfo, "downloadInfo");
        throwExceptionIfClosed();
        try {
            this.database.beginTransaction();
            this.database.execSQL("UPDATE requests SET _written_bytes = ?, _total_bytes = ?, _status = ? WHERE _id = ?", new Object[]{Long.valueOf(downloadInfo.getDownloaded()), Long.valueOf(downloadInfo.getTotal()), Integer.valueOf(downloadInfo.getStatus().getValue()), Integer.valueOf(downloadInfo.getId())});
            this.database.setTransactionSuccessful();
        } catch (SQLiteException e) {
            getLogger().e("DatabaseManager exception", e);
        }
        try {
            this.database.endTransaction();
        } catch (SQLiteException e2) {
            getLogger().e("DatabaseManager exception", e2);
        }
    }

    public DownloadInfo updateExtras(int i, Extras extras) {
        Intrinsics.checkParameterIsNotNull(extras, "extras");
        throwExceptionIfClosed();
        this.database.beginTransaction();
        this.database.execSQL("UPDATE requests SET _extras = '?' WHERE _id = ?", new Object[]{extras.toJSONString(), Integer.valueOf(i)});
        this.database.setTransactionSuccessful();
        this.database.endTransaction();
        DownloadInfo downloadInfo = this.requestDatabase.requestDao().get(i);
        sanitize$default(this, downloadInfo, false, 2, (Object) null);
        return downloadInfo;
    }

    public List<DownloadInfo> get() {
        throwExceptionIfClosed();
        List<DownloadInfo> list = this.requestDatabase.requestDao().get();
        sanitize$default(this, (List) list, false, 2, (Object) null);
        return list;
    }

    public DownloadInfo get(int i) {
        throwExceptionIfClosed();
        DownloadInfo downloadInfo = this.requestDatabase.requestDao().get(i);
        sanitize$default(this, downloadInfo, false, 2, (Object) null);
        return downloadInfo;
    }

    public List<DownloadInfo> get(List<Integer> list) {
        Intrinsics.checkParameterIsNotNull(list, "ids");
        throwExceptionIfClosed();
        List<DownloadInfo> list2 = this.requestDatabase.requestDao().get(list);
        sanitize$default(this, (List) list2, false, 2, (Object) null);
        return list2;
    }

    public DownloadInfo getByFile(String str) {
        Intrinsics.checkParameterIsNotNull(str, UriUtil.LOCAL_FILE_SCHEME);
        throwExceptionIfClosed();
        DownloadInfo byFile = this.requestDatabase.requestDao().getByFile(str);
        sanitize$default(this, byFile, false, 2, (Object) null);
        return byFile;
    }

    public List<DownloadInfo> getByStatus(Status status) {
        Intrinsics.checkParameterIsNotNull(status, "status");
        throwExceptionIfClosed();
        List<DownloadInfo> byStatus = this.requestDatabase.requestDao().getByStatus(status);
        if (!sanitize$default(this, (List) byStatus, false, 2, (Object) null)) {
            return byStatus;
        }
        Collection arrayList = new ArrayList();
        for (Object next : byStatus) {
            if (((DownloadInfo) next).getStatus() == status) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public List<DownloadInfo> getByStatus(List<? extends Status> list) {
        Intrinsics.checkParameterIsNotNull(list, "statuses");
        throwExceptionIfClosed();
        List<DownloadInfo> byStatus = this.requestDatabase.requestDao().getByStatus((List<Status>) list);
        if (!sanitize$default(this, (List) byStatus, false, 2, (Object) null)) {
            return byStatus;
        }
        Collection arrayList = new ArrayList();
        for (Object next : byStatus) {
            if (list.contains(((DownloadInfo) next).getStatus())) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public List<DownloadInfo> getByGroup(int i) {
        throwExceptionIfClosed();
        List<DownloadInfo> byGroup = this.requestDatabase.requestDao().getByGroup(i);
        sanitize$default(this, (List) byGroup, false, 2, (Object) null);
        return byGroup;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0028 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.tonyodev.fetch2.database.DownloadInfo> getDownloadsInGroupWithStatus(int r9, java.util.List<? extends com.tonyodev.fetch2.Status> r10) {
        /*
            r8 = this;
            java.lang.String r0 = "statuses"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)
            r8.throwExceptionIfClosed()
            com.tonyodev.fetch2.database.DownloadDatabase r0 = r8.requestDatabase
            com.tonyodev.fetch2.database.DownloadDao r0 = r0.requestDao()
            java.util.List r9 = r0.getByGroupWithStatus(r9, r10)
            r0 = 0
            r1 = 2
            r2 = 0
            boolean r1 = sanitize$default((com.tonyodev.fetch2.database.FetchDatabaseManagerImpl) r8, (java.util.List) r9, (boolean) r0, (int) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x006c
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r9 = r9.iterator()
        L_0x0028:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L_0x0069
            java.lang.Object r2 = r9.next()
            r3 = r2
            com.tonyodev.fetch2.database.DownloadInfo r3 = (com.tonyodev.fetch2.database.DownloadInfo) r3
            r4 = r10
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            boolean r5 = r4 instanceof java.util.Collection
            r6 = 1
            if (r5 == 0) goto L_0x0048
            r5 = r4
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x0048
        L_0x0046:
            r6 = r0
            goto L_0x0063
        L_0x0048:
            java.util.Iterator r4 = r4.iterator()
        L_0x004c:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0046
            java.lang.Object r5 = r4.next()
            com.tonyodev.fetch2.Status r5 = (com.tonyodev.fetch2.Status) r5
            com.tonyodev.fetch2.Status r7 = r3.getStatus()
            if (r5 != r7) goto L_0x0060
            r5 = r6
            goto L_0x0061
        L_0x0060:
            r5 = r0
        L_0x0061:
            if (r5 == 0) goto L_0x004c
        L_0x0063:
            if (r6 == 0) goto L_0x0028
            r1.add(r2)
            goto L_0x0028
        L_0x0069:
            r9 = r1
            java.util.List r9 = (java.util.List) r9
        L_0x006c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2.database.FetchDatabaseManagerImpl.getDownloadsInGroupWithStatus(int, java.util.List):java.util.List");
    }

    public List<DownloadInfo> getDownloadsByRequestIdentifier(long j) {
        throwExceptionIfClosed();
        List<DownloadInfo> downloadsByRequestIdentifier = this.requestDatabase.requestDao().getDownloadsByRequestIdentifier(j);
        sanitize$default(this, (List) downloadsByRequestIdentifier, false, 2, (Object) null);
        return downloadsByRequestIdentifier;
    }

    public List<DownloadInfo> getPendingDownloadsSorted(PrioritySort prioritySort) {
        List<DownloadInfo> list;
        Intrinsics.checkParameterIsNotNull(prioritySort, "prioritySort");
        throwExceptionIfClosed();
        if (prioritySort == PrioritySort.ASC) {
            list = this.requestDatabase.requestDao().getPendingDownloadsSorted(Status.QUEUED);
        } else {
            list = this.requestDatabase.requestDao().getPendingDownloadsSortedDesc(Status.QUEUED);
        }
        if (!sanitize$default(this, (List) list, false, 2, (Object) null)) {
            return list;
        }
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (((DownloadInfo) next).getStatus() == Status.QUEUED) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public List<Integer> getAllGroupIds() {
        throwExceptionIfClosed();
        return this.requestDatabase.requestDao().getAllGroupIds();
    }

    public List<DownloadInfo> getDownloadsByTag(String str) {
        Intrinsics.checkParameterIsNotNull(str, "tag");
        throwExceptionIfClosed();
        List<DownloadInfo> downloadsByTag = this.requestDatabase.requestDao().getDownloadsByTag(str);
        sanitize$default(this, (List) downloadsByTag, false, 2, (Object) null);
        return downloadsByTag;
    }

    public long getPendingCount(boolean z) {
        String str;
        if (z) {
            try {
                str = this.pendingCountIncludeAddedQuery;
            } catch (Exception unused) {
                return -1;
            }
        } else {
            str = this.pendingCountQuery;
        }
        Cursor query = this.database.query(str);
        long count = query != null ? (long) query.getCount() : -1;
        if (query != null) {
            query.close();
        }
        return count;
    }

    public void sanitizeOnFirstEntry() {
        throwExceptionIfClosed();
        this.liveSettings.execute(new FetchDatabaseManagerImpl$sanitizeOnFirstEntry$1(this));
    }

    static /* synthetic */ boolean sanitize$default(FetchDatabaseManagerImpl fetchDatabaseManagerImpl, List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return fetchDatabaseManagerImpl.sanitize((List<? extends DownloadInfo>) list, z);
    }

    /* access modifiers changed from: private */
    public final boolean sanitize(List<? extends DownloadInfo> list, boolean z) {
        this.updatedDownloadsList.clear();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            DownloadInfo downloadInfo = (DownloadInfo) list.get(i);
            int i2 = WhenMappings.$EnumSwitchMapping$0[downloadInfo.getStatus().ordinal()];
            if (i2 == 1) {
                onCompleted(downloadInfo);
            } else if (i2 == 2) {
                onDownloading(downloadInfo, z);
            } else if (i2 == 3 || i2 == 4) {
                onPaused(downloadInfo);
            }
        }
        int size2 = this.updatedDownloadsList.size();
        if (size2 > 0) {
            try {
                update((List<? extends DownloadInfo>) this.updatedDownloadsList);
            } catch (Exception e) {
                getLogger().e("Failed to update", e);
            }
        }
        this.updatedDownloadsList.clear();
        if (size2 > 0) {
            return true;
        }
        return false;
    }

    private final void onPaused(DownloadInfo downloadInfo) {
        if (downloadInfo.getDownloaded() > 0 && this.fileExistChecksEnabled && !this.defaultStorageResolver.fileExists(downloadInfo.getFile())) {
            downloadInfo.setDownloaded(0);
            downloadInfo.setTotal(-1);
            downloadInfo.setError(FetchDefaults.getDefaultNoError());
            this.updatedDownloadsList.add(downloadInfo);
            FetchDatabaseManager.Delegate<DownloadInfo> delegate2 = getDelegate();
            if (delegate2 != null) {
                delegate2.deleteTempFilesForDownload(downloadInfo);
            }
        }
    }

    private final void onDownloading(DownloadInfo downloadInfo, boolean z) {
        Status status;
        if (z) {
            if (downloadInfo.getDownloaded() <= 0 || downloadInfo.getTotal() <= 0 || downloadInfo.getDownloaded() < downloadInfo.getTotal()) {
                status = Status.QUEUED;
            } else {
                status = Status.COMPLETED;
            }
            downloadInfo.setStatus(status);
            downloadInfo.setError(FetchDefaults.getDefaultNoError());
            this.updatedDownloadsList.add(downloadInfo);
        }
    }

    private final void onCompleted(DownloadInfo downloadInfo) {
        if (downloadInfo.getTotal() < 1 && downloadInfo.getDownloaded() > 0) {
            downloadInfo.setTotal(downloadInfo.getDownloaded());
            downloadInfo.setError(FetchDefaults.getDefaultNoError());
            this.updatedDownloadsList.add(downloadInfo);
        }
    }

    static /* synthetic */ boolean sanitize$default(FetchDatabaseManagerImpl fetchDatabaseManagerImpl, DownloadInfo downloadInfo, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return fetchDatabaseManagerImpl.sanitize(downloadInfo, z);
    }

    private final boolean sanitize(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return false;
        }
        return sanitize((List<? extends DownloadInfo>) CollectionsKt.listOf(downloadInfo), z);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:3|4|5|6|7|8|10) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r2 = this;
            boolean r0 = r2.closed
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 1
            r2.closed = r0
            androidx.sqlite.db.SupportSQLiteDatabase r0 = r2.database     // Catch:{ Exception -> 0x000d }
            r0.close()     // Catch:{ Exception -> 0x000d }
        L_0x000d:
            com.tonyodev.fetch2.database.DownloadDatabase r0 = r2.requestDatabase     // Catch:{ Exception -> 0x0012 }
            r0.close()     // Catch:{ Exception -> 0x0012 }
        L_0x0012:
            com.tonyodev.fetch2core.Logger r0 = r2.getLogger()
            java.lang.String r1 = "Database closed"
            r0.d(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2.database.FetchDatabaseManagerImpl.close():void");
    }

    public DownloadInfo getNewDownloadInfoInstance() {
        return new DownloadInfo();
    }

    private final void throwExceptionIfClosed() {
        if (this.closed) {
            throw new FetchException(this.namespace + " database is closed");
        }
    }
}
