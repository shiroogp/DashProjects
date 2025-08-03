package com.tonyodev.fetch2;

import com.tonyodev.fetch2core.FetchObserver;
import com.tonyodev.fetch2core.Reason;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J&\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/tonyodev/fetch2/FetchGroupObserver;", "Lcom/tonyodev/fetch2core/FetchObserver;", "", "Lcom/tonyodev/fetch2/Download;", "onChanged", "", "data", "triggerDownload", "reason", "Lcom/tonyodev/fetch2core/Reason;", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FetchGroupObserver.kt */
public interface FetchGroupObserver extends FetchObserver<List<? extends Download>> {
    void onChanged(List<? extends Download> list, Download download, Reason reason);
}
