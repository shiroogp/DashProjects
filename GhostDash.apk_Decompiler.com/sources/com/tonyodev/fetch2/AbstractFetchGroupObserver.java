package com.tonyodev.fetch2;

import com.tonyodev.fetch2core.Reason;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u001e\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/tonyodev/fetch2/AbstractFetchGroupObserver;", "Lcom/tonyodev/fetch2/FetchGroupObserver;", "()V", "onChanged", "", "data", "", "Lcom/tonyodev/fetch2/Download;", "triggerDownload", "reason", "Lcom/tonyodev/fetch2core/Reason;", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: AbstractFetchGroupObserver.kt */
public abstract class AbstractFetchGroupObserver implements FetchGroupObserver {
    public void onChanged(List<? extends Download> list, Download download, Reason reason) {
        Intrinsics.checkParameterIsNotNull(list, "data");
        Intrinsics.checkParameterIsNotNull(download, "triggerDownload");
        Intrinsics.checkParameterIsNotNull(reason, "reason");
    }

    public void onChanged(List<? extends Download> list, Reason reason) {
        Intrinsics.checkParameterIsNotNull(list, "data");
        Intrinsics.checkParameterIsNotNull(reason, "reason");
    }
}
