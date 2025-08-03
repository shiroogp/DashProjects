package com.tonyodev.fetch2.database;

import androidx.room.RoomDatabase;
import com.tonyodev.fetch2.database.migration.Migration;
import com.tonyodev.fetch2.database.migration.MigrationFiveToSix;
import com.tonyodev.fetch2.database.migration.MigrationFourToFive;
import com.tonyodev.fetch2.database.migration.MigrationOneToTwo;
import com.tonyodev.fetch2.database.migration.MigrationSixToSeven;
import com.tonyodev.fetch2.database.migration.MigrationThreeToFour;
import com.tonyodev.fetch2.database.migration.MigrationTwoToThree;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, d2 = {"Lcom/tonyodev/fetch2/database/DownloadDatabase;", "Landroidx/room/RoomDatabase;", "()V", "requestDao", "Lcom/tonyodev/fetch2/database/DownloadDao;", "wasRowInserted", "", "row", "", "Companion", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DownloadDatabase.kt */
public abstract class DownloadDatabase extends RoomDatabase {
    public static final String COLUMN_AUTO_RETRY_ATTEMPTS = "_auto_retry_attempts";
    public static final String COLUMN_AUTO_RETRY_MAX_ATTEMPTS = "_auto_retry_max_attempts";
    public static final String COLUMN_CREATED = "_created";
    public static final String COLUMN_DOWNLOADED = "_written_bytes";
    public static final String COLUMN_DOWNLOAD_ON_ENQUEUE = "_download_on_enqueue";
    public static final String COLUMN_ENQUEUE_ACTION = "_enqueue_action";
    public static final String COLUMN_ERROR = "_error";
    public static final String COLUMN_EXTRAS = "_extras";
    public static final String COLUMN_FILE = "_file";
    public static final String COLUMN_GROUP = "_group";
    public static final String COLUMN_HEADERS = "_headers";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_IDENTIFIER = "_identifier";
    public static final String COLUMN_NAMESPACE = "_namespace";
    public static final String COLUMN_NETWORK_TYPE = "_network_type";
    public static final String COLUMN_PRIORITY = "_priority";
    public static final String COLUMN_STATUS = "_status";
    public static final String COLUMN_TAG = "_tag";
    public static final String COLUMN_TOTAL = "_total_bytes";
    public static final String COLUMN_URL = "_url";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DATABASE_VERSION = 7;
    public static final int OLD_DATABASE_VERSION = 6;
    public static final String TABLE_NAME = "requests";

    @JvmStatic
    public static final Migration[] getMigrations() {
        return Companion.getMigrations();
    }

    public abstract DownloadDao requestDao();

    public final boolean wasRowInserted(long j) {
        return j != ((long) -1);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0007¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/tonyodev/fetch2/database/DownloadDatabase$Companion;", "", "()V", "COLUMN_AUTO_RETRY_ATTEMPTS", "", "COLUMN_AUTO_RETRY_MAX_ATTEMPTS", "COLUMN_CREATED", "COLUMN_DOWNLOADED", "COLUMN_DOWNLOAD_ON_ENQUEUE", "COLUMN_ENQUEUE_ACTION", "COLUMN_ERROR", "COLUMN_EXTRAS", "COLUMN_FILE", "COLUMN_GROUP", "COLUMN_HEADERS", "COLUMN_ID", "COLUMN_IDENTIFIER", "COLUMN_NAMESPACE", "COLUMN_NETWORK_TYPE", "COLUMN_PRIORITY", "COLUMN_STATUS", "COLUMN_TAG", "COLUMN_TOTAL", "COLUMN_URL", "DATABASE_VERSION", "", "OLD_DATABASE_VERSION", "TABLE_NAME", "getMigrations", "", "Lcom/tonyodev/fetch2/database/migration/Migration;", "()[Lcom/tonyodev/fetch2/database/migration/Migration;", "fetch2_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: DownloadDatabase.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Migration[] getMigrations() {
            return new Migration[]{new MigrationOneToTwo(), new MigrationTwoToThree(), new MigrationThreeToFour(), new MigrationFourToFive(), new MigrationFiveToSix(), new MigrationSixToSeven()};
        }
    }
}
