package com.tonyodev.fetch2.database;

import com.tonyodev.fetch2.fetch.LiveSettings;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tonyodev/fetch2/fetch/LiveSettings;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: FetchDatabaseManagerImpl.kt */
final class FetchDatabaseManagerImpl$sanitizeOnFirstEntry$1 extends Lambda implements Function1<LiveSettings, Unit> {
    final /* synthetic */ FetchDatabaseManagerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FetchDatabaseManagerImpl$sanitizeOnFirstEntry$1(FetchDatabaseManagerImpl fetchDatabaseManagerImpl) {
        super(1);
        this.this$0 = fetchDatabaseManagerImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LiveSettings) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LiveSettings liveSettings) {
        Intrinsics.checkParameterIsNotNull(liveSettings, "it");
        if (!liveSettings.getDidSanitizeDatabaseOnFirstEntry()) {
            FetchDatabaseManagerImpl fetchDatabaseManagerImpl = this.this$0;
            boolean unused = fetchDatabaseManagerImpl.sanitize((List<? extends DownloadInfo>) fetchDatabaseManagerImpl.get(), true);
            liveSettings.setDidSanitizeDatabaseOnFirstEntry(true);
        }
    }
}
