package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.-$$Lambda$SchemaManager$XH3bHEgPsw1uBZYVhTMum4Uai4g  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$SchemaManager$XH3bHEgPsw1uBZYVhTMum4Uai4g implements SchemaManager.Migration {
    public static final /* synthetic */ $$Lambda$SchemaManager$XH3bHEgPsw1uBZYVhTMum4Uai4g INSTANCE = new $$Lambda$SchemaManager$XH3bHEgPsw1uBZYVhTMum4Uai4g();

    private /* synthetic */ $$Lambda$SchemaManager$XH3bHEgPsw1uBZYVhTMum4Uai4g() {
    }

    public final void upgrade(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }
}
