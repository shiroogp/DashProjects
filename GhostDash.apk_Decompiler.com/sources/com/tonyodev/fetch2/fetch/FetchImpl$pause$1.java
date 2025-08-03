package com.tonyodev.fetch2.fetch;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2core.Func;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "downloads", "", "Lcom/tonyodev/fetch2/Download;", "call"}, k = 3, mv = {1, 1, 16})
/* compiled from: FetchImpl.kt */
final class FetchImpl$pause$1<R> implements Func<List<? extends Download>> {
    final /* synthetic */ Func $func;
    final /* synthetic */ Func $func2;

    FetchImpl$pause$1(Func func, Func func2) {
        this.$func = func;
        this.$func2 = func2;
    }

    public final void call(List<? extends Download> list) {
        Intrinsics.checkParameterIsNotNull(list, "downloads");
        if (!list.isEmpty()) {
            Func func = this.$func;
            if (func != null) {
                func.call(CollectionsKt.first(list));
                return;
            }
            return;
        }
        Func func2 = this.$func2;
        if (func2 != null) {
            func2.call(Error.REQUEST_DOES_NOT_EXIST);
        }
    }
}
