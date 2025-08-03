package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.-$$Lambda$SchemaManager$rGcUdOceFhSffkhz_AHgqHOrsTQ  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$SchemaManager$rGcUdOceFhSffkhz_AHgqHOrsTQ implements SchemaManager.Migration {
    public static final /* synthetic */ $$Lambda$SchemaManager$rGcUdOceFhSffkhz_AHgqHOrsTQ INSTANCE = new $$Lambda$SchemaManager$rGcUdOceFhSffkhz_AHgqHOrsTQ();

    private /* synthetic */ $$Lambda$SchemaManager$rGcUdOceFhSffkhz_AHgqHOrsTQ() {
    }

    public final void upgrade(SQLiteDatabase sQLiteDatabase) {
        SchemaManager.lambda$static$4(sQLiteDatabase);
    }
}
