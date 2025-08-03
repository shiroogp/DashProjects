package com.tonyodev.fetch2.fetch;

import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.Request;
import com.tonyodev.fetch2core.Func;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "result", "", "Lkotlin/Pair;", "Lcom/tonyodev/fetch2/Request;", "Lcom/tonyodev/fetch2/Error;", "call"}, k = 3, mv = {1, 1, 16})
/* compiled from: FetchImpl.kt */
final class FetchImpl$enqueue$1<R> implements Func<List<? extends Pair<? extends Request, ? extends Error>>> {
    final /* synthetic */ Func $func;
    final /* synthetic */ Func $func2;
    final /* synthetic */ FetchImpl this$0;

    FetchImpl$enqueue$1(FetchImpl fetchImpl, Func func, Func func2) {
        this.this$0 = fetchImpl;
        this.$func2 = func;
        this.$func = func2;
    }

    public final void call(List<? extends Pair<? extends Request, ? extends Error>> list) {
        Intrinsics.checkParameterIsNotNull(list, "result");
        if (!list.isEmpty()) {
            final Pair pair = (Pair) CollectionsKt.first(list);
            if (((Error) pair.getSecond()) != Error.NONE) {
                this.this$0.uiHandler.post(new Runnable(this) {
                    final /* synthetic */ FetchImpl$enqueue$1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void run() {
                        Func func = this.this$0.$func2;
                        if (func != null) {
                            func.call(pair.getSecond());
                        }
                    }
                });
            } else {
                this.this$0.uiHandler.post(new Runnable(this) {
                    final /* synthetic */ FetchImpl$enqueue$1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void run() {
                        Func func = this.this$0.$func;
                        if (func != null) {
                            func.call(pair.getFirst());
                        }
                    }
                });
            }
        } else {
            this.this$0.uiHandler.post(new Runnable(this) {
                final /* synthetic */ FetchImpl$enqueue$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void run() {
                    Func func = this.this$0.$func2;
                    if (func != null) {
                        func.call(Error.ENQUEUE_NOT_SUCCESSFUL);
                    }
                }
            });
        }
    }
}
