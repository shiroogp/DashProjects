package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.-$$Lambda$UBBq-fU2aA6PmTxK4UPAxrJHPac  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$UBBqfU2aA6PmTxK4UPAxrJHPac implements SQLiteEventStore.Function {
    public static final /* synthetic */ $$Lambda$UBBqfU2aA6PmTxK4UPAxrJHPac INSTANCE = new $$Lambda$UBBqfU2aA6PmTxK4UPAxrJHPac();

    private /* synthetic */ $$Lambda$UBBqfU2aA6PmTxK4UPAxrJHPac() {
    }

    public final Object apply(Object obj) {
        return Boolean.valueOf(((Cursor) obj).moveToNext());
    }
}
