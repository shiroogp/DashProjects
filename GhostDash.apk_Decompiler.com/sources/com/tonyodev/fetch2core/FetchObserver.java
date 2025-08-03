package com.tonyodev.fetch2core;

import kotlin.Metadata;

@FunctionalInterface
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/tonyodev/fetch2core/FetchObserver;", "T", "", "onChanged", "", "data", "reason", "Lcom/tonyodev/fetch2core/Reason;", "(Ljava/lang/Object;Lcom/tonyodev/fetch2core/Reason;)V", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FetchObserver.kt */
public interface FetchObserver<T> {
    void onChanged(T t, Reason reason);
}
