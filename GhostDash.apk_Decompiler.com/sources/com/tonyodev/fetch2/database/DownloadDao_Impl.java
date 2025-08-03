package com.tonyodev.fetch2.database;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.tonyodev.fetch2.Status;
import java.util.ArrayList;
import java.util.List;

public final class DownloadDao_Impl implements DownloadDao {
    /* access modifiers changed from: private */
    public final Converter __converter = new Converter();
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<DownloadInfo> __deletionAdapterOfDownloadInfo;
    private final EntityInsertionAdapter<DownloadInfo> __insertionAdapterOfDownloadInfo;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final EntityDeletionOrUpdateAdapter<DownloadInfo> __updateAdapterOfDownloadInfo;

    public DownloadDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfDownloadInfo = new EntityInsertionAdapter<DownloadInfo>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR ABORT INTO `requests` (`_id`,`_namespace`,`_url`,`_file`,`_group`,`_priority`,`_headers`,`_written_bytes`,`_total_bytes`,`_status`,`_error`,`_network_type`,`_created`,`_tag`,`_enqueue_action`,`_identifier`,`_download_on_enqueue`,`_extras`,`_auto_retry_max_attempts`,`_auto_retry_attempts`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, DownloadInfo downloadInfo) {
                supportSQLiteStatement.bindLong(1, (long) downloadInfo.getId());
                if (downloadInfo.getNamespace() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, downloadInfo.getNamespace());
                }
                if (downloadInfo.getUrl() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, downloadInfo.getUrl());
                }
                if (downloadInfo.getFile() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, downloadInfo.getFile());
                }
                supportSQLiteStatement.bindLong(5, (long) downloadInfo.getGroup());
                supportSQLiteStatement.bindLong(6, (long) DownloadDao_Impl.this.__converter.toPriorityValue(downloadInfo.getPriority()));
                String headerStringsMap = DownloadDao_Impl.this.__converter.toHeaderStringsMap(downloadInfo.getHeaders());
                if (headerStringsMap == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, headerStringsMap);
                }
                supportSQLiteStatement.bindLong(8, downloadInfo.getDownloaded());
                supportSQLiteStatement.bindLong(9, downloadInfo.getTotal());
                supportSQLiteStatement.bindLong(10, (long) DownloadDao_Impl.this.__converter.toStatusValue(downloadInfo.getStatus()));
                supportSQLiteStatement.bindLong(11, (long) DownloadDao_Impl.this.__converter.toErrorValue(downloadInfo.getError()));
                supportSQLiteStatement.bindLong(12, (long) DownloadDao_Impl.this.__converter.toNetworkTypeValue(downloadInfo.getNetworkType()));
                supportSQLiteStatement.bindLong(13, downloadInfo.getCreated());
                if (downloadInfo.getTag() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, downloadInfo.getTag());
                }
                supportSQLiteStatement.bindLong(15, (long) DownloadDao_Impl.this.__converter.toEnqueueActionValue(downloadInfo.getEnqueueAction()));
                supportSQLiteStatement.bindLong(16, downloadInfo.getIdentifier());
                supportSQLiteStatement.bindLong(17, downloadInfo.getDownloadOnEnqueue() ? 1 : 0);
                String fromExtrasToString = DownloadDao_Impl.this.__converter.fromExtrasToString(downloadInfo.getExtras());
                if (fromExtrasToString == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindString(18, fromExtrasToString);
                }
                supportSQLiteStatement.bindLong(19, (long) downloadInfo.getAutoRetryMaxAttempts());
                supportSQLiteStatement.bindLong(20, (long) downloadInfo.getAutoRetryAttempts());
            }
        };
        this.__deletionAdapterOfDownloadInfo = new EntityDeletionOrUpdateAdapter<DownloadInfo>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `requests` WHERE `_id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, DownloadInfo downloadInfo) {
                supportSQLiteStatement.bindLong(1, (long) downloadInfo.getId());
            }
        };
        this.__updateAdapterOfDownloadInfo = new EntityDeletionOrUpdateAdapter<DownloadInfo>(roomDatabase) {
            public String createQuery() {
                return "UPDATE OR REPLACE `requests` SET `_id` = ?,`_namespace` = ?,`_url` = ?,`_file` = ?,`_group` = ?,`_priority` = ?,`_headers` = ?,`_written_bytes` = ?,`_total_bytes` = ?,`_status` = ?,`_error` = ?,`_network_type` = ?,`_created` = ?,`_tag` = ?,`_enqueue_action` = ?,`_identifier` = ?,`_download_on_enqueue` = ?,`_extras` = ?,`_auto_retry_max_attempts` = ?,`_auto_retry_attempts` = ? WHERE `_id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, DownloadInfo downloadInfo) {
                supportSQLiteStatement.bindLong(1, (long) downloadInfo.getId());
                if (downloadInfo.getNamespace() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, downloadInfo.getNamespace());
                }
                if (downloadInfo.getUrl() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, downloadInfo.getUrl());
                }
                if (downloadInfo.getFile() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, downloadInfo.getFile());
                }
                supportSQLiteStatement.bindLong(5, (long) downloadInfo.getGroup());
                supportSQLiteStatement.bindLong(6, (long) DownloadDao_Impl.this.__converter.toPriorityValue(downloadInfo.getPriority()));
                String headerStringsMap = DownloadDao_Impl.this.__converter.toHeaderStringsMap(downloadInfo.getHeaders());
                if (headerStringsMap == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, headerStringsMap);
                }
                supportSQLiteStatement.bindLong(8, downloadInfo.getDownloaded());
                supportSQLiteStatement.bindLong(9, downloadInfo.getTotal());
                supportSQLiteStatement.bindLong(10, (long) DownloadDao_Impl.this.__converter.toStatusValue(downloadInfo.getStatus()));
                supportSQLiteStatement.bindLong(11, (long) DownloadDao_Impl.this.__converter.toErrorValue(downloadInfo.getError()));
                supportSQLiteStatement.bindLong(12, (long) DownloadDao_Impl.this.__converter.toNetworkTypeValue(downloadInfo.getNetworkType()));
                supportSQLiteStatement.bindLong(13, downloadInfo.getCreated());
                if (downloadInfo.getTag() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, downloadInfo.getTag());
                }
                supportSQLiteStatement.bindLong(15, (long) DownloadDao_Impl.this.__converter.toEnqueueActionValue(downloadInfo.getEnqueueAction()));
                supportSQLiteStatement.bindLong(16, downloadInfo.getIdentifier());
                supportSQLiteStatement.bindLong(17, downloadInfo.getDownloadOnEnqueue() ? 1 : 0);
                String fromExtrasToString = DownloadDao_Impl.this.__converter.fromExtrasToString(downloadInfo.getExtras());
                if (fromExtrasToString == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindString(18, fromExtrasToString);
                }
                supportSQLiteStatement.bindLong(19, (long) downloadInfo.getAutoRetryMaxAttempts());
                supportSQLiteStatement.bindLong(20, (long) downloadInfo.getAutoRetryAttempts());
                supportSQLiteStatement.bindLong(21, (long) downloadInfo.getId());
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM requests";
            }
        };
    }

    public long insert(DownloadInfo downloadInfo) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long insertAndReturnId = this.__insertionAdapterOfDownloadInfo.insertAndReturnId(downloadInfo);
            this.__db.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    public List<Long> insert(List<? extends DownloadInfo> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> insertAndReturnIdsList = this.__insertionAdapterOfDownloadInfo.insertAndReturnIdsList(list);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    public void delete(DownloadInfo downloadInfo) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfDownloadInfo.handle(downloadInfo);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void delete(List<? extends DownloadInfo> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfDownloadInfo.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void update(DownloadInfo downloadInfo) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfDownloadInfo.handle(downloadInfo);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void update(List<? extends DownloadInfo> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfDownloadInfo.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAll.release(acquire);
        }
    }

    public List<DownloadInfo> get() {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM requests", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_NAMESPACE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_URL);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_FILE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_GROUP);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_PRIORITY);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_HEADERS);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_DOWNLOADED);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_TOTAL);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_STATUS);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_ERROR);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_NETWORK_TYPE);
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_CREATED);
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_TAG);
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_ENQUEUE_ACTION);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_IDENTIFIER);
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_DOWNLOAD_ON_ENQUEUE);
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_EXTRAS);
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_AUTO_RETRY_MAX_ATTEMPTS);
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_AUTO_RETRY_ATTEMPTS);
                int i = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    DownloadInfo downloadInfo = new DownloadInfo();
                    ArrayList arrayList2 = arrayList;
                    downloadInfo.setId(query.getInt(columnIndexOrThrow));
                    downloadInfo.setNamespace(query.getString(columnIndexOrThrow2));
                    downloadInfo.setUrl(query.getString(columnIndexOrThrow3));
                    downloadInfo.setFile(query.getString(columnIndexOrThrow4));
                    downloadInfo.setGroup(query.getInt(columnIndexOrThrow5));
                    int i2 = columnIndexOrThrow;
                    downloadInfo.setPriority(this.__converter.fromPriorityValue(query.getInt(columnIndexOrThrow6)));
                    downloadInfo.setHeaders(this.__converter.fromJsonString(query.getString(columnIndexOrThrow7)));
                    int i3 = columnIndexOrThrow2;
                    int i4 = columnIndexOrThrow3;
                    downloadInfo.setDownloaded(query.getLong(columnIndexOrThrow8));
                    downloadInfo.setTotal(query.getLong(columnIndexOrThrow9));
                    downloadInfo.setStatus(this.__converter.fromStatusValue(query.getInt(columnIndexOrThrow10)));
                    downloadInfo.setError(this.__converter.fromErrorValue(query.getInt(columnIndexOrThrow11)));
                    downloadInfo.setNetworkType(this.__converter.fromNetworkTypeValue(query.getInt(columnIndexOrThrow12)));
                    int i5 = i;
                    int i6 = columnIndexOrThrow4;
                    downloadInfo.setCreated(query.getLong(i5));
                    int i7 = columnIndexOrThrow14;
                    downloadInfo.setTag(query.getString(i7));
                    int i8 = i3;
                    int i9 = columnIndexOrThrow15;
                    int i10 = i4;
                    downloadInfo.setEnqueueAction(this.__converter.fromEnqueueActionValue(query.getInt(i9)));
                    int i11 = i5;
                    int i12 = columnIndexOrThrow16;
                    int i13 = i7;
                    downloadInfo.setIdentifier(query.getLong(i12));
                    int i14 = columnIndexOrThrow17;
                    downloadInfo.setDownloadOnEnqueue(query.getInt(i14) != 0);
                    int i15 = i12;
                    int i16 = columnIndexOrThrow18;
                    int i17 = i11;
                    downloadInfo.setExtras(this.__converter.fromExtrasJsonToExtras(query.getString(i16)));
                    int i18 = columnIndexOrThrow19;
                    downloadInfo.setAutoRetryMaxAttempts(query.getInt(i18));
                    columnIndexOrThrow19 = i18;
                    int i19 = columnIndexOrThrow20;
                    downloadInfo.setAutoRetryAttempts(query.getInt(i19));
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(downloadInfo);
                    columnIndexOrThrow20 = i19;
                    arrayList = arrayList3;
                    columnIndexOrThrow = i2;
                    int i20 = i15;
                    columnIndexOrThrow17 = i14;
                    columnIndexOrThrow2 = i8;
                    columnIndexOrThrow14 = i13;
                    columnIndexOrThrow16 = i20;
                    int i21 = i17;
                    columnIndexOrThrow18 = i16;
                    columnIndexOrThrow3 = i10;
                    columnIndexOrThrow15 = i9;
                    columnIndexOrThrow4 = i6;
                    i = i21;
                }
                ArrayList arrayList4 = arrayList;
                query.close();
                roomSQLiteQuery.release();
                return arrayList4;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public DownloadInfo get(int i) {
        RoomSQLiteQuery roomSQLiteQuery;
        DownloadInfo downloadInfo;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM requests WHERE _id = ?", 1);
        acquire.bindLong(1, (long) i);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_NAMESPACE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_URL);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_FILE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_GROUP);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_PRIORITY);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_HEADERS);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_DOWNLOADED);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_TOTAL);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_STATUS);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_ERROR);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_NETWORK_TYPE);
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_CREATED);
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_TAG);
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_ENQUEUE_ACTION);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_IDENTIFIER);
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_DOWNLOAD_ON_ENQUEUE);
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_EXTRAS);
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_AUTO_RETRY_MAX_ATTEMPTS);
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_AUTO_RETRY_ATTEMPTS);
                if (query.moveToFirst()) {
                    int i2 = columnIndexOrThrow20;
                    DownloadInfo downloadInfo2 = new DownloadInfo();
                    downloadInfo2.setId(query.getInt(columnIndexOrThrow));
                    downloadInfo2.setNamespace(query.getString(columnIndexOrThrow2));
                    downloadInfo2.setUrl(query.getString(columnIndexOrThrow3));
                    downloadInfo2.setFile(query.getString(columnIndexOrThrow4));
                    downloadInfo2.setGroup(query.getInt(columnIndexOrThrow5));
                    downloadInfo2.setPriority(this.__converter.fromPriorityValue(query.getInt(columnIndexOrThrow6)));
                    downloadInfo2.setHeaders(this.__converter.fromJsonString(query.getString(columnIndexOrThrow7)));
                    downloadInfo2.setDownloaded(query.getLong(columnIndexOrThrow8));
                    downloadInfo2.setTotal(query.getLong(columnIndexOrThrow9));
                    downloadInfo2.setStatus(this.__converter.fromStatusValue(query.getInt(columnIndexOrThrow10)));
                    downloadInfo2.setError(this.__converter.fromErrorValue(query.getInt(columnIndexOrThrow11)));
                    downloadInfo2.setNetworkType(this.__converter.fromNetworkTypeValue(query.getInt(columnIndexOrThrow12)));
                    downloadInfo2.setCreated(query.getLong(columnIndexOrThrow13));
                    downloadInfo2.setTag(query.getString(columnIndexOrThrow14));
                    downloadInfo2.setEnqueueAction(this.__converter.fromEnqueueActionValue(query.getInt(columnIndexOrThrow15)));
                    downloadInfo2.setIdentifier(query.getLong(columnIndexOrThrow16));
                    downloadInfo2.setDownloadOnEnqueue(query.getInt(columnIndexOrThrow17) != 0);
                    downloadInfo2.setExtras(this.__converter.fromExtrasJsonToExtras(query.getString(columnIndexOrThrow18)));
                    downloadInfo2.setAutoRetryMaxAttempts(query.getInt(columnIndexOrThrow19));
                    downloadInfo2.setAutoRetryAttempts(query.getInt(i2));
                    downloadInfo = downloadInfo2;
                } else {
                    downloadInfo = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return downloadInfo;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<DownloadInfo> get(List<Integer> list) {
        RoomSQLiteQuery roomSQLiteQuery;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT ");
        newStringBuilder.append("*");
        newStringBuilder.append(" FROM requests WHERE _id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i = 1;
        for (Integer next : list) {
            if (next == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindLong(i, (long) next.intValue());
            }
            i++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_NAMESPACE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_URL);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_FILE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_GROUP);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_PRIORITY);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_HEADERS);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_DOWNLOADED);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_TOTAL);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_STATUS);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_ERROR);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_NETWORK_TYPE);
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_CREATED);
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_TAG);
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_ENQUEUE_ACTION);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_IDENTIFIER);
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_DOWNLOAD_ON_ENQUEUE);
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_EXTRAS);
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_AUTO_RETRY_MAX_ATTEMPTS);
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_AUTO_RETRY_ATTEMPTS);
                int i2 = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    DownloadInfo downloadInfo = new DownloadInfo();
                    ArrayList arrayList2 = arrayList;
                    downloadInfo.setId(query.getInt(columnIndexOrThrow));
                    downloadInfo.setNamespace(query.getString(columnIndexOrThrow2));
                    downloadInfo.setUrl(query.getString(columnIndexOrThrow3));
                    downloadInfo.setFile(query.getString(columnIndexOrThrow4));
                    downloadInfo.setGroup(query.getInt(columnIndexOrThrow5));
                    int i3 = columnIndexOrThrow;
                    downloadInfo.setPriority(this.__converter.fromPriorityValue(query.getInt(columnIndexOrThrow6)));
                    downloadInfo.setHeaders(this.__converter.fromJsonString(query.getString(columnIndexOrThrow7)));
                    int i4 = columnIndexOrThrow2;
                    int i5 = columnIndexOrThrow3;
                    downloadInfo.setDownloaded(query.getLong(columnIndexOrThrow8));
                    downloadInfo.setTotal(query.getLong(columnIndexOrThrow9));
                    downloadInfo.setStatus(this.__converter.fromStatusValue(query.getInt(columnIndexOrThrow10)));
                    downloadInfo.setError(this.__converter.fromErrorValue(query.getInt(columnIndexOrThrow11)));
                    downloadInfo.setNetworkType(this.__converter.fromNetworkTypeValue(query.getInt(columnIndexOrThrow12)));
                    int i6 = columnIndexOrThrow12;
                    int i7 = i2;
                    int i8 = i5;
                    downloadInfo.setCreated(query.getLong(i7));
                    int i9 = columnIndexOrThrow14;
                    downloadInfo.setTag(query.getString(i9));
                    int i10 = i4;
                    int i11 = columnIndexOrThrow15;
                    int i12 = i9;
                    downloadInfo.setEnqueueAction(this.__converter.fromEnqueueActionValue(query.getInt(i11)));
                    int i13 = columnIndexOrThrow16;
                    int i14 = i11;
                    downloadInfo.setIdentifier(query.getLong(i13));
                    int i15 = columnIndexOrThrow17;
                    downloadInfo.setDownloadOnEnqueue(query.getInt(i15) != 0);
                    int i16 = i13;
                    int i17 = columnIndexOrThrow18;
                    int i18 = i15;
                    downloadInfo.setExtras(this.__converter.fromExtrasJsonToExtras(query.getString(i17)));
                    int i19 = columnIndexOrThrow19;
                    downloadInfo.setAutoRetryMaxAttempts(query.getInt(i19));
                    columnIndexOrThrow19 = i19;
                    int i20 = columnIndexOrThrow20;
                    downloadInfo.setAutoRetryAttempts(query.getInt(i20));
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(downloadInfo);
                    columnIndexOrThrow20 = i20;
                    arrayList = arrayList3;
                    columnIndexOrThrow = i3;
                    int i21 = i18;
                    columnIndexOrThrow18 = i17;
                    columnIndexOrThrow12 = i6;
                    columnIndexOrThrow3 = i8;
                    i2 = i7;
                    columnIndexOrThrow2 = i10;
                    columnIndexOrThrow14 = i12;
                    columnIndexOrThrow15 = i14;
                    columnIndexOrThrow16 = i16;
                    columnIndexOrThrow17 = i21;
                }
                ArrayList arrayList4 = arrayList;
                query.close();
                roomSQLiteQuery.release();
                return arrayList4;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public DownloadInfo getByFile(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        DownloadInfo downloadInfo;
        String str2 = str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM requests WHERE _file = ?", 1);
        if (str2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str2);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_NAMESPACE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_URL);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_FILE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_GROUP);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_PRIORITY);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_HEADERS);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_DOWNLOADED);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_TOTAL);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_STATUS);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_ERROR);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_NETWORK_TYPE);
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_CREATED);
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_TAG);
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_ENQUEUE_ACTION);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_IDENTIFIER);
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_DOWNLOAD_ON_ENQUEUE);
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_EXTRAS);
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_AUTO_RETRY_MAX_ATTEMPTS);
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_AUTO_RETRY_ATTEMPTS);
                if (query.moveToFirst()) {
                    int i = columnIndexOrThrow20;
                    DownloadInfo downloadInfo2 = new DownloadInfo();
                    downloadInfo2.setId(query.getInt(columnIndexOrThrow));
                    downloadInfo2.setNamespace(query.getString(columnIndexOrThrow2));
                    downloadInfo2.setUrl(query.getString(columnIndexOrThrow3));
                    downloadInfo2.setFile(query.getString(columnIndexOrThrow4));
                    downloadInfo2.setGroup(query.getInt(columnIndexOrThrow5));
                    downloadInfo2.setPriority(this.__converter.fromPriorityValue(query.getInt(columnIndexOrThrow6)));
                    downloadInfo2.setHeaders(this.__converter.fromJsonString(query.getString(columnIndexOrThrow7)));
                    downloadInfo2.setDownloaded(query.getLong(columnIndexOrThrow8));
                    downloadInfo2.setTotal(query.getLong(columnIndexOrThrow9));
                    downloadInfo2.setStatus(this.__converter.fromStatusValue(query.getInt(columnIndexOrThrow10)));
                    downloadInfo2.setError(this.__converter.fromErrorValue(query.getInt(columnIndexOrThrow11)));
                    downloadInfo2.setNetworkType(this.__converter.fromNetworkTypeValue(query.getInt(columnIndexOrThrow12)));
                    downloadInfo2.setCreated(query.getLong(columnIndexOrThrow13));
                    downloadInfo2.setTag(query.getString(columnIndexOrThrow14));
                    downloadInfo2.setEnqueueAction(this.__converter.fromEnqueueActionValue(query.getInt(columnIndexOrThrow15)));
                    downloadInfo2.setIdentifier(query.getLong(columnIndexOrThrow16));
                    downloadInfo2.setDownloadOnEnqueue(query.getInt(columnIndexOrThrow17) != 0);
                    downloadInfo2.setExtras(this.__converter.fromExtrasJsonToExtras(query.getString(columnIndexOrThrow18)));
                    downloadInfo2.setAutoRetryMaxAttempts(query.getInt(columnIndexOrThrow19));
                    downloadInfo2.setAutoRetryAttempts(query.getInt(i));
                    downloadInfo = downloadInfo2;
                } else {
                    downloadInfo = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return downloadInfo;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<DownloadInfo> getByStatus(Status status) {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM requests WHERE _status = ?", 1);
        acquire.bindLong(1, (long) this.__converter.toStatusValue(status));
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_NAMESPACE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_URL);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_FILE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_GROUP);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_PRIORITY);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_HEADERS);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_DOWNLOADED);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_TOTAL);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_STATUS);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_ERROR);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_NETWORK_TYPE);
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_CREATED);
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_TAG);
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_ENQUEUE_ACTION);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_IDENTIFIER);
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_DOWNLOAD_ON_ENQUEUE);
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_EXTRAS);
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_AUTO_RETRY_MAX_ATTEMPTS);
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_AUTO_RETRY_ATTEMPTS);
                int i = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    DownloadInfo downloadInfo = new DownloadInfo();
                    ArrayList arrayList2 = arrayList;
                    downloadInfo.setId(query.getInt(columnIndexOrThrow));
                    downloadInfo.setNamespace(query.getString(columnIndexOrThrow2));
                    downloadInfo.setUrl(query.getString(columnIndexOrThrow3));
                    downloadInfo.setFile(query.getString(columnIndexOrThrow4));
                    downloadInfo.setGroup(query.getInt(columnIndexOrThrow5));
                    int i2 = columnIndexOrThrow;
                    downloadInfo.setPriority(this.__converter.fromPriorityValue(query.getInt(columnIndexOrThrow6)));
                    downloadInfo.setHeaders(this.__converter.fromJsonString(query.getString(columnIndexOrThrow7)));
                    int i3 = columnIndexOrThrow2;
                    int i4 = columnIndexOrThrow3;
                    downloadInfo.setDownloaded(query.getLong(columnIndexOrThrow8));
                    downloadInfo.setTotal(query.getLong(columnIndexOrThrow9));
                    downloadInfo.setStatus(this.__converter.fromStatusValue(query.getInt(columnIndexOrThrow10)));
                    downloadInfo.setError(this.__converter.fromErrorValue(query.getInt(columnIndexOrThrow11)));
                    downloadInfo.setNetworkType(this.__converter.fromNetworkTypeValue(query.getInt(columnIndexOrThrow12)));
                    int i5 = columnIndexOrThrow12;
                    int i6 = i;
                    int i7 = i4;
                    downloadInfo.setCreated(query.getLong(i6));
                    int i8 = columnIndexOrThrow14;
                    downloadInfo.setTag(query.getString(i8));
                    int i9 = i3;
                    int i10 = columnIndexOrThrow15;
                    int i11 = i8;
                    downloadInfo.setEnqueueAction(this.__converter.fromEnqueueActionValue(query.getInt(i10)));
                    int i12 = columnIndexOrThrow16;
                    int i13 = i10;
                    downloadInfo.setIdentifier(query.getLong(i12));
                    int i14 = columnIndexOrThrow17;
                    downloadInfo.setDownloadOnEnqueue(query.getInt(i14) != 0);
                    int i15 = i12;
                    int i16 = columnIndexOrThrow18;
                    int i17 = i14;
                    downloadInfo.setExtras(this.__converter.fromExtrasJsonToExtras(query.getString(i16)));
                    int i18 = columnIndexOrThrow19;
                    downloadInfo.setAutoRetryMaxAttempts(query.getInt(i18));
                    columnIndexOrThrow19 = i18;
                    int i19 = columnIndexOrThrow20;
                    downloadInfo.setAutoRetryAttempts(query.getInt(i19));
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(downloadInfo);
                    columnIndexOrThrow20 = i19;
                    columnIndexOrThrow12 = i5;
                    columnIndexOrThrow3 = i7;
                    i = i6;
                    columnIndexOrThrow2 = i9;
                    columnIndexOrThrow14 = i11;
                    columnIndexOrThrow15 = i13;
                    columnIndexOrThrow16 = i15;
                    columnIndexOrThrow17 = i17;
                    columnIndexOrThrow18 = i16;
                    arrayList = arrayList3;
                    columnIndexOrThrow = i2;
                }
                ArrayList arrayList4 = arrayList;
                query.close();
                roomSQLiteQuery.release();
                return arrayList4;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<DownloadInfo> getByStatus(List<Status> list) {
        RoomSQLiteQuery roomSQLiteQuery;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT ");
        newStringBuilder.append("*");
        newStringBuilder.append(" FROM requests WHERE _status IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i = 1;
        for (Status statusValue : list) {
            acquire.bindLong(i, (long) this.__converter.toStatusValue(statusValue));
            i++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_NAMESPACE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_URL);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_FILE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_GROUP);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_PRIORITY);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_HEADERS);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_DOWNLOADED);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_TOTAL);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_STATUS);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_ERROR);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_NETWORK_TYPE);
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_CREATED);
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_TAG);
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_ENQUEUE_ACTION);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_IDENTIFIER);
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_DOWNLOAD_ON_ENQUEUE);
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_EXTRAS);
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_AUTO_RETRY_MAX_ATTEMPTS);
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_AUTO_RETRY_ATTEMPTS);
                int i2 = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    DownloadInfo downloadInfo = new DownloadInfo();
                    ArrayList arrayList2 = arrayList;
                    downloadInfo.setId(query.getInt(columnIndexOrThrow));
                    downloadInfo.setNamespace(query.getString(columnIndexOrThrow2));
                    downloadInfo.setUrl(query.getString(columnIndexOrThrow3));
                    downloadInfo.setFile(query.getString(columnIndexOrThrow4));
                    downloadInfo.setGroup(query.getInt(columnIndexOrThrow5));
                    int i3 = columnIndexOrThrow;
                    downloadInfo.setPriority(this.__converter.fromPriorityValue(query.getInt(columnIndexOrThrow6)));
                    downloadInfo.setHeaders(this.__converter.fromJsonString(query.getString(columnIndexOrThrow7)));
                    int i4 = columnIndexOrThrow2;
                    int i5 = columnIndexOrThrow3;
                    downloadInfo.setDownloaded(query.getLong(columnIndexOrThrow8));
                    downloadInfo.setTotal(query.getLong(columnIndexOrThrow9));
                    downloadInfo.setStatus(this.__converter.fromStatusValue(query.getInt(columnIndexOrThrow10)));
                    downloadInfo.setError(this.__converter.fromErrorValue(query.getInt(columnIndexOrThrow11)));
                    downloadInfo.setNetworkType(this.__converter.fromNetworkTypeValue(query.getInt(columnIndexOrThrow12)));
                    int i6 = columnIndexOrThrow12;
                    int i7 = i2;
                    int i8 = i5;
                    downloadInfo.setCreated(query.getLong(i7));
                    int i9 = columnIndexOrThrow14;
                    downloadInfo.setTag(query.getString(i9));
                    int i10 = i4;
                    int i11 = columnIndexOrThrow15;
                    int i12 = i9;
                    downloadInfo.setEnqueueAction(this.__converter.fromEnqueueActionValue(query.getInt(i11)));
                    int i13 = columnIndexOrThrow16;
                    int i14 = i11;
                    downloadInfo.setIdentifier(query.getLong(i13));
                    int i15 = columnIndexOrThrow17;
                    downloadInfo.setDownloadOnEnqueue(query.getInt(i15) != 0);
                    int i16 = i13;
                    int i17 = columnIndexOrThrow18;
                    int i18 = i15;
                    downloadInfo.setExtras(this.__converter.fromExtrasJsonToExtras(query.getString(i17)));
                    int i19 = columnIndexOrThrow19;
                    downloadInfo.setAutoRetryMaxAttempts(query.getInt(i19));
                    columnIndexOrThrow19 = i19;
                    int i20 = columnIndexOrThrow20;
                    downloadInfo.setAutoRetryAttempts(query.getInt(i20));
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(downloadInfo);
                    columnIndexOrThrow20 = i20;
                    arrayList = arrayList3;
                    columnIndexOrThrow = i3;
                    int i21 = i18;
                    columnIndexOrThrow18 = i17;
                    columnIndexOrThrow12 = i6;
                    columnIndexOrThrow3 = i8;
                    i2 = i7;
                    columnIndexOrThrow2 = i10;
                    columnIndexOrThrow14 = i12;
                    columnIndexOrThrow15 = i14;
                    columnIndexOrThrow16 = i16;
                    columnIndexOrThrow17 = i21;
                }
                ArrayList arrayList4 = arrayList;
                query.close();
                roomSQLiteQuery.release();
                return arrayList4;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<DownloadInfo> getByGroup(int i) {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM requests WHERE _group = ?", 1);
        acquire.bindLong(1, (long) i);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_NAMESPACE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_URL);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_FILE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_GROUP);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_PRIORITY);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_HEADERS);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_DOWNLOADED);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_TOTAL);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_STATUS);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_ERROR);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_NETWORK_TYPE);
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_CREATED);
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_TAG);
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_ENQUEUE_ACTION);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_IDENTIFIER);
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_DOWNLOAD_ON_ENQUEUE);
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_EXTRAS);
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_AUTO_RETRY_MAX_ATTEMPTS);
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_AUTO_RETRY_ATTEMPTS);
                int i2 = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    DownloadInfo downloadInfo = new DownloadInfo();
                    ArrayList arrayList2 = arrayList;
                    downloadInfo.setId(query.getInt(columnIndexOrThrow));
                    downloadInfo.setNamespace(query.getString(columnIndexOrThrow2));
                    downloadInfo.setUrl(query.getString(columnIndexOrThrow3));
                    downloadInfo.setFile(query.getString(columnIndexOrThrow4));
                    downloadInfo.setGroup(query.getInt(columnIndexOrThrow5));
                    int i3 = columnIndexOrThrow;
                    downloadInfo.setPriority(this.__converter.fromPriorityValue(query.getInt(columnIndexOrThrow6)));
                    downloadInfo.setHeaders(this.__converter.fromJsonString(query.getString(columnIndexOrThrow7)));
                    int i4 = columnIndexOrThrow2;
                    int i5 = columnIndexOrThrow3;
                    downloadInfo.setDownloaded(query.getLong(columnIndexOrThrow8));
                    downloadInfo.setTotal(query.getLong(columnIndexOrThrow9));
                    downloadInfo.setStatus(this.__converter.fromStatusValue(query.getInt(columnIndexOrThrow10)));
                    downloadInfo.setError(this.__converter.fromErrorValue(query.getInt(columnIndexOrThrow11)));
                    downloadInfo.setNetworkType(this.__converter.fromNetworkTypeValue(query.getInt(columnIndexOrThrow12)));
                    int i6 = columnIndexOrThrow12;
                    int i7 = i2;
                    int i8 = i5;
                    downloadInfo.setCreated(query.getLong(i7));
                    int i9 = columnIndexOrThrow14;
                    downloadInfo.setTag(query.getString(i9));
                    int i10 = i4;
                    int i11 = columnIndexOrThrow15;
                    int i12 = i9;
                    downloadInfo.setEnqueueAction(this.__converter.fromEnqueueActionValue(query.getInt(i11)));
                    int i13 = columnIndexOrThrow16;
                    int i14 = i11;
                    downloadInfo.setIdentifier(query.getLong(i13));
                    int i15 = columnIndexOrThrow17;
                    downloadInfo.setDownloadOnEnqueue(query.getInt(i15) != 0);
                    int i16 = i13;
                    int i17 = columnIndexOrThrow18;
                    int i18 = i15;
                    downloadInfo.setExtras(this.__converter.fromExtrasJsonToExtras(query.getString(i17)));
                    int i19 = columnIndexOrThrow19;
                    downloadInfo.setAutoRetryMaxAttempts(query.getInt(i19));
                    columnIndexOrThrow19 = i19;
                    int i20 = columnIndexOrThrow20;
                    downloadInfo.setAutoRetryAttempts(query.getInt(i20));
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(downloadInfo);
                    columnIndexOrThrow20 = i20;
                    columnIndexOrThrow12 = i6;
                    columnIndexOrThrow3 = i8;
                    i2 = i7;
                    columnIndexOrThrow2 = i10;
                    columnIndexOrThrow14 = i12;
                    columnIndexOrThrow15 = i14;
                    columnIndexOrThrow16 = i16;
                    columnIndexOrThrow17 = i18;
                    columnIndexOrThrow18 = i17;
                    arrayList = arrayList3;
                    columnIndexOrThrow = i3;
                }
                ArrayList arrayList4 = arrayList;
                query.close();
                roomSQLiteQuery.release();
                return arrayList4;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<DownloadInfo> getByGroupWithStatus(int i, List<Status> list) {
        RoomSQLiteQuery roomSQLiteQuery;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT ");
        newStringBuilder.append("*");
        newStringBuilder.append(" FROM requests WHERE _group = ");
        newStringBuilder.append("?");
        newStringBuilder.append(" AND _status IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 1);
        acquire.bindLong(1, (long) i);
        int i2 = 2;
        for (Status statusValue : list) {
            acquire.bindLong(i2, (long) this.__converter.toStatusValue(statusValue));
            i2++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_NAMESPACE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_URL);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_FILE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_GROUP);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_PRIORITY);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_HEADERS);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_DOWNLOADED);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_TOTAL);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_STATUS);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_ERROR);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_NETWORK_TYPE);
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_CREATED);
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_TAG);
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_ENQUEUE_ACTION);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_IDENTIFIER);
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_DOWNLOAD_ON_ENQUEUE);
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_EXTRAS);
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_AUTO_RETRY_MAX_ATTEMPTS);
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_AUTO_RETRY_ATTEMPTS);
                int i3 = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    DownloadInfo downloadInfo = new DownloadInfo();
                    ArrayList arrayList2 = arrayList;
                    downloadInfo.setId(query.getInt(columnIndexOrThrow));
                    downloadInfo.setNamespace(query.getString(columnIndexOrThrow2));
                    downloadInfo.setUrl(query.getString(columnIndexOrThrow3));
                    downloadInfo.setFile(query.getString(columnIndexOrThrow4));
                    downloadInfo.setGroup(query.getInt(columnIndexOrThrow5));
                    int i4 = columnIndexOrThrow;
                    downloadInfo.setPriority(this.__converter.fromPriorityValue(query.getInt(columnIndexOrThrow6)));
                    downloadInfo.setHeaders(this.__converter.fromJsonString(query.getString(columnIndexOrThrow7)));
                    int i5 = columnIndexOrThrow2;
                    int i6 = columnIndexOrThrow3;
                    downloadInfo.setDownloaded(query.getLong(columnIndexOrThrow8));
                    downloadInfo.setTotal(query.getLong(columnIndexOrThrow9));
                    downloadInfo.setStatus(this.__converter.fromStatusValue(query.getInt(columnIndexOrThrow10)));
                    downloadInfo.setError(this.__converter.fromErrorValue(query.getInt(columnIndexOrThrow11)));
                    downloadInfo.setNetworkType(this.__converter.fromNetworkTypeValue(query.getInt(columnIndexOrThrow12)));
                    int i7 = columnIndexOrThrow12;
                    int i8 = i3;
                    int i9 = i6;
                    downloadInfo.setCreated(query.getLong(i8));
                    int i10 = columnIndexOrThrow14;
                    downloadInfo.setTag(query.getString(i10));
                    int i11 = i5;
                    int i12 = columnIndexOrThrow15;
                    int i13 = i10;
                    downloadInfo.setEnqueueAction(this.__converter.fromEnqueueActionValue(query.getInt(i12)));
                    int i14 = columnIndexOrThrow16;
                    int i15 = i12;
                    downloadInfo.setIdentifier(query.getLong(i14));
                    int i16 = columnIndexOrThrow17;
                    downloadInfo.setDownloadOnEnqueue(query.getInt(i16) != 0);
                    int i17 = i14;
                    int i18 = columnIndexOrThrow18;
                    int i19 = i16;
                    downloadInfo.setExtras(this.__converter.fromExtrasJsonToExtras(query.getString(i18)));
                    int i20 = columnIndexOrThrow19;
                    downloadInfo.setAutoRetryMaxAttempts(query.getInt(i20));
                    columnIndexOrThrow19 = i20;
                    int i21 = columnIndexOrThrow20;
                    downloadInfo.setAutoRetryAttempts(query.getInt(i21));
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(downloadInfo);
                    columnIndexOrThrow20 = i21;
                    arrayList = arrayList3;
                    columnIndexOrThrow = i4;
                    int i22 = i8;
                    columnIndexOrThrow2 = i11;
                    columnIndexOrThrow14 = i13;
                    columnIndexOrThrow15 = i15;
                    columnIndexOrThrow16 = i17;
                    columnIndexOrThrow17 = i19;
                    columnIndexOrThrow18 = i18;
                    columnIndexOrThrow12 = i7;
                    columnIndexOrThrow3 = i9;
                    i3 = i22;
                }
                ArrayList arrayList4 = arrayList;
                query.close();
                roomSQLiteQuery.release();
                return arrayList4;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<DownloadInfo> getPendingDownloadsSorted(Status status) {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM requests WHERE _status = ? ORDER BY _priority DESC, _created ASC", 1);
        acquire.bindLong(1, (long) this.__converter.toStatusValue(status));
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_NAMESPACE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_URL);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_FILE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_GROUP);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_PRIORITY);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_HEADERS);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_DOWNLOADED);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_TOTAL);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_STATUS);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_ERROR);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_NETWORK_TYPE);
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_CREATED);
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_TAG);
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_ENQUEUE_ACTION);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_IDENTIFIER);
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_DOWNLOAD_ON_ENQUEUE);
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_EXTRAS);
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_AUTO_RETRY_MAX_ATTEMPTS);
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_AUTO_RETRY_ATTEMPTS);
                int i = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    DownloadInfo downloadInfo = new DownloadInfo();
                    ArrayList arrayList2 = arrayList;
                    downloadInfo.setId(query.getInt(columnIndexOrThrow));
                    downloadInfo.setNamespace(query.getString(columnIndexOrThrow2));
                    downloadInfo.setUrl(query.getString(columnIndexOrThrow3));
                    downloadInfo.setFile(query.getString(columnIndexOrThrow4));
                    downloadInfo.setGroup(query.getInt(columnIndexOrThrow5));
                    int i2 = columnIndexOrThrow;
                    downloadInfo.setPriority(this.__converter.fromPriorityValue(query.getInt(columnIndexOrThrow6)));
                    downloadInfo.setHeaders(this.__converter.fromJsonString(query.getString(columnIndexOrThrow7)));
                    int i3 = columnIndexOrThrow2;
                    int i4 = columnIndexOrThrow3;
                    downloadInfo.setDownloaded(query.getLong(columnIndexOrThrow8));
                    downloadInfo.setTotal(query.getLong(columnIndexOrThrow9));
                    downloadInfo.setStatus(this.__converter.fromStatusValue(query.getInt(columnIndexOrThrow10)));
                    downloadInfo.setError(this.__converter.fromErrorValue(query.getInt(columnIndexOrThrow11)));
                    downloadInfo.setNetworkType(this.__converter.fromNetworkTypeValue(query.getInt(columnIndexOrThrow12)));
                    int i5 = columnIndexOrThrow12;
                    int i6 = i;
                    int i7 = i4;
                    downloadInfo.setCreated(query.getLong(i6));
                    int i8 = columnIndexOrThrow14;
                    downloadInfo.setTag(query.getString(i8));
                    int i9 = i3;
                    int i10 = columnIndexOrThrow15;
                    int i11 = i8;
                    downloadInfo.setEnqueueAction(this.__converter.fromEnqueueActionValue(query.getInt(i10)));
                    int i12 = columnIndexOrThrow16;
                    int i13 = i10;
                    downloadInfo.setIdentifier(query.getLong(i12));
                    int i14 = columnIndexOrThrow17;
                    downloadInfo.setDownloadOnEnqueue(query.getInt(i14) != 0);
                    int i15 = i12;
                    int i16 = columnIndexOrThrow18;
                    int i17 = i14;
                    downloadInfo.setExtras(this.__converter.fromExtrasJsonToExtras(query.getString(i16)));
                    int i18 = columnIndexOrThrow19;
                    downloadInfo.setAutoRetryMaxAttempts(query.getInt(i18));
                    columnIndexOrThrow19 = i18;
                    int i19 = columnIndexOrThrow20;
                    downloadInfo.setAutoRetryAttempts(query.getInt(i19));
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(downloadInfo);
                    columnIndexOrThrow20 = i19;
                    columnIndexOrThrow12 = i5;
                    columnIndexOrThrow3 = i7;
                    i = i6;
                    columnIndexOrThrow2 = i9;
                    columnIndexOrThrow14 = i11;
                    columnIndexOrThrow15 = i13;
                    columnIndexOrThrow16 = i15;
                    columnIndexOrThrow17 = i17;
                    columnIndexOrThrow18 = i16;
                    arrayList = arrayList3;
                    columnIndexOrThrow = i2;
                }
                ArrayList arrayList4 = arrayList;
                query.close();
                roomSQLiteQuery.release();
                return arrayList4;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<DownloadInfo> getPendingDownloadsSortedDesc(Status status) {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM requests WHERE _status = ? ORDER BY _priority DESC, _created DESC", 1);
        acquire.bindLong(1, (long) this.__converter.toStatusValue(status));
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_NAMESPACE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_URL);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_FILE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_GROUP);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_PRIORITY);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_HEADERS);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_DOWNLOADED);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_TOTAL);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_STATUS);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_ERROR);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_NETWORK_TYPE);
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_CREATED);
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_TAG);
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_ENQUEUE_ACTION);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_IDENTIFIER);
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_DOWNLOAD_ON_ENQUEUE);
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_EXTRAS);
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_AUTO_RETRY_MAX_ATTEMPTS);
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_AUTO_RETRY_ATTEMPTS);
                int i = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    DownloadInfo downloadInfo = new DownloadInfo();
                    ArrayList arrayList2 = arrayList;
                    downloadInfo.setId(query.getInt(columnIndexOrThrow));
                    downloadInfo.setNamespace(query.getString(columnIndexOrThrow2));
                    downloadInfo.setUrl(query.getString(columnIndexOrThrow3));
                    downloadInfo.setFile(query.getString(columnIndexOrThrow4));
                    downloadInfo.setGroup(query.getInt(columnIndexOrThrow5));
                    int i2 = columnIndexOrThrow;
                    downloadInfo.setPriority(this.__converter.fromPriorityValue(query.getInt(columnIndexOrThrow6)));
                    downloadInfo.setHeaders(this.__converter.fromJsonString(query.getString(columnIndexOrThrow7)));
                    int i3 = columnIndexOrThrow2;
                    int i4 = columnIndexOrThrow3;
                    downloadInfo.setDownloaded(query.getLong(columnIndexOrThrow8));
                    downloadInfo.setTotal(query.getLong(columnIndexOrThrow9));
                    downloadInfo.setStatus(this.__converter.fromStatusValue(query.getInt(columnIndexOrThrow10)));
                    downloadInfo.setError(this.__converter.fromErrorValue(query.getInt(columnIndexOrThrow11)));
                    downloadInfo.setNetworkType(this.__converter.fromNetworkTypeValue(query.getInt(columnIndexOrThrow12)));
                    int i5 = columnIndexOrThrow12;
                    int i6 = i;
                    int i7 = i4;
                    downloadInfo.setCreated(query.getLong(i6));
                    int i8 = columnIndexOrThrow14;
                    downloadInfo.setTag(query.getString(i8));
                    int i9 = i3;
                    int i10 = columnIndexOrThrow15;
                    int i11 = i8;
                    downloadInfo.setEnqueueAction(this.__converter.fromEnqueueActionValue(query.getInt(i10)));
                    int i12 = columnIndexOrThrow16;
                    int i13 = i10;
                    downloadInfo.setIdentifier(query.getLong(i12));
                    int i14 = columnIndexOrThrow17;
                    downloadInfo.setDownloadOnEnqueue(query.getInt(i14) != 0);
                    int i15 = i12;
                    int i16 = columnIndexOrThrow18;
                    int i17 = i14;
                    downloadInfo.setExtras(this.__converter.fromExtrasJsonToExtras(query.getString(i16)));
                    int i18 = columnIndexOrThrow19;
                    downloadInfo.setAutoRetryMaxAttempts(query.getInt(i18));
                    columnIndexOrThrow19 = i18;
                    int i19 = columnIndexOrThrow20;
                    downloadInfo.setAutoRetryAttempts(query.getInt(i19));
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(downloadInfo);
                    columnIndexOrThrow20 = i19;
                    columnIndexOrThrow12 = i5;
                    columnIndexOrThrow3 = i7;
                    i = i6;
                    columnIndexOrThrow2 = i9;
                    columnIndexOrThrow14 = i11;
                    columnIndexOrThrow15 = i13;
                    columnIndexOrThrow16 = i15;
                    columnIndexOrThrow17 = i17;
                    columnIndexOrThrow18 = i16;
                    arrayList = arrayList3;
                    columnIndexOrThrow = i2;
                }
                ArrayList arrayList4 = arrayList;
                query.close();
                roomSQLiteQuery.release();
                return arrayList4;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<DownloadInfo> getDownloadsByRequestIdentifier(long j) {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM requests WHERE _identifier = ?", 1);
        acquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_NAMESPACE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_URL);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_FILE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_GROUP);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_PRIORITY);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_HEADERS);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_DOWNLOADED);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_TOTAL);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_STATUS);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_ERROR);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_NETWORK_TYPE);
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_CREATED);
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_TAG);
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_ENQUEUE_ACTION);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_IDENTIFIER);
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_DOWNLOAD_ON_ENQUEUE);
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_EXTRAS);
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_AUTO_RETRY_MAX_ATTEMPTS);
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_AUTO_RETRY_ATTEMPTS);
                int i = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    DownloadInfo downloadInfo = new DownloadInfo();
                    ArrayList arrayList2 = arrayList;
                    downloadInfo.setId(query.getInt(columnIndexOrThrow));
                    downloadInfo.setNamespace(query.getString(columnIndexOrThrow2));
                    downloadInfo.setUrl(query.getString(columnIndexOrThrow3));
                    downloadInfo.setFile(query.getString(columnIndexOrThrow4));
                    downloadInfo.setGroup(query.getInt(columnIndexOrThrow5));
                    int i2 = columnIndexOrThrow;
                    downloadInfo.setPriority(this.__converter.fromPriorityValue(query.getInt(columnIndexOrThrow6)));
                    downloadInfo.setHeaders(this.__converter.fromJsonString(query.getString(columnIndexOrThrow7)));
                    int i3 = columnIndexOrThrow2;
                    int i4 = columnIndexOrThrow3;
                    downloadInfo.setDownloaded(query.getLong(columnIndexOrThrow8));
                    downloadInfo.setTotal(query.getLong(columnIndexOrThrow9));
                    downloadInfo.setStatus(this.__converter.fromStatusValue(query.getInt(columnIndexOrThrow10)));
                    downloadInfo.setError(this.__converter.fromErrorValue(query.getInt(columnIndexOrThrow11)));
                    downloadInfo.setNetworkType(this.__converter.fromNetworkTypeValue(query.getInt(columnIndexOrThrow12)));
                    int i5 = columnIndexOrThrow12;
                    int i6 = i;
                    int i7 = i4;
                    downloadInfo.setCreated(query.getLong(i6));
                    int i8 = columnIndexOrThrow14;
                    downloadInfo.setTag(query.getString(i8));
                    int i9 = i3;
                    int i10 = columnIndexOrThrow15;
                    int i11 = i8;
                    downloadInfo.setEnqueueAction(this.__converter.fromEnqueueActionValue(query.getInt(i10)));
                    int i12 = columnIndexOrThrow16;
                    int i13 = i10;
                    downloadInfo.setIdentifier(query.getLong(i12));
                    int i14 = columnIndexOrThrow17;
                    downloadInfo.setDownloadOnEnqueue(query.getInt(i14) != 0);
                    int i15 = i12;
                    int i16 = columnIndexOrThrow18;
                    int i17 = i14;
                    downloadInfo.setExtras(this.__converter.fromExtrasJsonToExtras(query.getString(i16)));
                    int i18 = columnIndexOrThrow19;
                    downloadInfo.setAutoRetryMaxAttempts(query.getInt(i18));
                    columnIndexOrThrow19 = i18;
                    int i19 = columnIndexOrThrow20;
                    downloadInfo.setAutoRetryAttempts(query.getInt(i19));
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(downloadInfo);
                    columnIndexOrThrow20 = i19;
                    columnIndexOrThrow12 = i5;
                    columnIndexOrThrow3 = i7;
                    i = i6;
                    columnIndexOrThrow2 = i9;
                    columnIndexOrThrow14 = i11;
                    columnIndexOrThrow15 = i13;
                    columnIndexOrThrow16 = i15;
                    columnIndexOrThrow17 = i17;
                    columnIndexOrThrow18 = i16;
                    arrayList = arrayList3;
                    columnIndexOrThrow = i2;
                }
                ArrayList arrayList4 = arrayList;
                query.close();
                roomSQLiteQuery.release();
                return arrayList4;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<DownloadInfo> getDownloadsByTag(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        String str2 = str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM requests WHERE _tag = ?", 1);
        if (str2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str2);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_NAMESPACE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_URL);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_FILE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_GROUP);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_PRIORITY);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_HEADERS);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_DOWNLOADED);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_TOTAL);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_STATUS);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_ERROR);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_NETWORK_TYPE);
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_CREATED);
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_TAG);
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_ENQUEUE_ACTION);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_IDENTIFIER);
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_DOWNLOAD_ON_ENQUEUE);
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_EXTRAS);
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_AUTO_RETRY_MAX_ATTEMPTS);
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, DownloadDatabase.COLUMN_AUTO_RETRY_ATTEMPTS);
                int i = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    DownloadInfo downloadInfo = new DownloadInfo();
                    ArrayList arrayList2 = arrayList;
                    downloadInfo.setId(query.getInt(columnIndexOrThrow));
                    downloadInfo.setNamespace(query.getString(columnIndexOrThrow2));
                    downloadInfo.setUrl(query.getString(columnIndexOrThrow3));
                    downloadInfo.setFile(query.getString(columnIndexOrThrow4));
                    downloadInfo.setGroup(query.getInt(columnIndexOrThrow5));
                    int i2 = columnIndexOrThrow;
                    downloadInfo.setPriority(this.__converter.fromPriorityValue(query.getInt(columnIndexOrThrow6)));
                    downloadInfo.setHeaders(this.__converter.fromJsonString(query.getString(columnIndexOrThrow7)));
                    int i3 = columnIndexOrThrow2;
                    int i4 = columnIndexOrThrow3;
                    downloadInfo.setDownloaded(query.getLong(columnIndexOrThrow8));
                    downloadInfo.setTotal(query.getLong(columnIndexOrThrow9));
                    downloadInfo.setStatus(this.__converter.fromStatusValue(query.getInt(columnIndexOrThrow10)));
                    downloadInfo.setError(this.__converter.fromErrorValue(query.getInt(columnIndexOrThrow11)));
                    downloadInfo.setNetworkType(this.__converter.fromNetworkTypeValue(query.getInt(columnIndexOrThrow12)));
                    int i5 = columnIndexOrThrow12;
                    int i6 = i;
                    int i7 = i4;
                    downloadInfo.setCreated(query.getLong(i6));
                    int i8 = columnIndexOrThrow14;
                    downloadInfo.setTag(query.getString(i8));
                    int i9 = i3;
                    int i10 = columnIndexOrThrow15;
                    int i11 = i8;
                    downloadInfo.setEnqueueAction(this.__converter.fromEnqueueActionValue(query.getInt(i10)));
                    int i12 = columnIndexOrThrow16;
                    int i13 = i10;
                    downloadInfo.setIdentifier(query.getLong(i12));
                    int i14 = columnIndexOrThrow17;
                    downloadInfo.setDownloadOnEnqueue(query.getInt(i14) != 0);
                    int i15 = i12;
                    int i16 = columnIndexOrThrow18;
                    int i17 = i14;
                    downloadInfo.setExtras(this.__converter.fromExtrasJsonToExtras(query.getString(i16)));
                    int i18 = columnIndexOrThrow19;
                    downloadInfo.setAutoRetryMaxAttempts(query.getInt(i18));
                    columnIndexOrThrow19 = i18;
                    int i19 = columnIndexOrThrow20;
                    downloadInfo.setAutoRetryAttempts(query.getInt(i19));
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(downloadInfo);
                    columnIndexOrThrow20 = i19;
                    arrayList = arrayList3;
                    columnIndexOrThrow = i2;
                    int i20 = i17;
                    columnIndexOrThrow18 = i16;
                    columnIndexOrThrow12 = i5;
                    columnIndexOrThrow3 = i7;
                    i = i6;
                    columnIndexOrThrow2 = i9;
                    columnIndexOrThrow14 = i11;
                    columnIndexOrThrow15 = i13;
                    columnIndexOrThrow16 = i15;
                    columnIndexOrThrow17 = i20;
                }
                ArrayList arrayList4 = arrayList;
                query.close();
                roomSQLiteQuery.release();
                return arrayList4;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<Integer> getAllGroupIds() {
        Integer num;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT DISTINCT _group from requests", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    num = null;
                } else {
                    num = Integer.valueOf(query.getInt(0));
                }
                arrayList.add(num);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
