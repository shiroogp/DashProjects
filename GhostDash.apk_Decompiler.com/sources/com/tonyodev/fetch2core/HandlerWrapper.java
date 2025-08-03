package com.tonyodev.fetch2core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0013\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0002J\u0014\u0010\u0015\u001a\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\u0006\u0010\u001b\u001a\u00020\u0019J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\u0006\u0010\u001d\u001a\u00020\u0011J\u0014\u0010\u001e\u001a\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017J\u0016\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020 J\u0006\u0010$\u001a\u00020\u000eR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/tonyodev/fetch2core/HandlerWrapper;", "", "namespace", "", "backgroundHandler", "Landroid/os/Handler;", "(Ljava/lang/String;Landroid/os/Handler;)V", "closed", "", "handler", "lock", "getNamespace", "()Ljava/lang/String;", "usageCounter", "", "workerTaskHandler", "close", "", "decrementUsageCounter", "equals", "other", "executeWorkerTask", "runnable", "Lkotlin/Function0;", "getLooper", "Landroid/os/Looper;", "getNewWorkerTaskHandler", "getWorkTaskLooper", "hashCode", "incrementUsageCounter", "post", "postDelayed", "Ljava/lang/Runnable;", "delayMillis", "", "removeCallbacks", "usageCount", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: HandlerWrapper.kt */
public final class HandlerWrapper {
    private boolean closed;
    private final Handler handler;
    private final Object lock;
    private final String namespace;
    private int usageCounter;
    private Handler workerTaskHandler;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.os.Handler} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HandlerWrapper(java.lang.String r2, android.os.Handler r3) {
        /*
            r1 = this;
            java.lang.String r0 = "namespace"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            r1.<init>()
            r1.namespace = r2
            java.lang.Object r2 = new java.lang.Object
            r2.<init>()
            r1.lock = r2
            if (r3 == 0) goto L_0x0014
            goto L_0x0022
        L_0x0014:
            com.tonyodev.fetch2core.HandlerWrapper$handler$1 r2 = new com.tonyodev.fetch2core.HandlerWrapper$handler$1
            r2.<init>(r1)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            java.lang.Object r2 = r2.invoke()
            r3 = r2
            android.os.Handler r3 = (android.os.Handler) r3
        L_0x0022:
            r1.handler = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2core.HandlerWrapper.<init>(java.lang.String, android.os.Handler):void");
    }

    public final String getNamespace() {
        return this.namespace;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HandlerWrapper(String str, Handler handler2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : handler2);
    }

    public final void post(Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "runnable");
        synchronized (this.lock) {
            if (!this.closed) {
                this.handler.post(new HandlerWrapper$sam$i$java_lang_Runnable$0(function0));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void postDelayed(Runnable runnable, long j) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        synchronized (this.lock) {
            if (!this.closed) {
                this.handler.postDelayed(runnable, j);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void removeCallbacks(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        synchronized (this.lock) {
            if (!this.closed) {
                this.handler.removeCallbacks(runnable);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void incrementUsageCounter() {
        synchronized (this.lock) {
            if (!this.closed) {
                this.usageCounter++;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void decrementUsageCounter() {
        synchronized (this.lock) {
            if (!this.closed) {
                int i = this.usageCounter;
                if (i != 0) {
                    this.usageCounter = i - 1;
                } else {
                    return;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final int usageCount() {
        int i;
        synchronized (this.lock) {
            i = !this.closed ? this.usageCounter : 0;
        }
        return i;
    }

    public final Looper getLooper() {
        Looper looper;
        synchronized (this.lock) {
            looper = this.handler.getLooper();
            Intrinsics.checkExpressionValueIsNotNull(looper, "handler.looper");
        }
        Intrinsics.checkExpressionValueIsNotNull(looper, "synchronized(lock) {\n   … handler.looper\n        }");
        return looper;
    }

    public final void executeWorkerTask(Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "runnable");
        synchronized (this.lock) {
            if (!this.closed) {
                if (this.workerTaskHandler == null) {
                    this.workerTaskHandler = getNewWorkerTaskHandler();
                }
                Handler handler2 = this.workerTaskHandler;
                if (handler2 != null) {
                    handler2.post(new HandlerWrapper$sam$i$java_lang_Runnable$0(function0));
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final Looper getWorkTaskLooper() {
        Looper looper;
        synchronized (this.lock) {
            Handler handler2 = this.workerTaskHandler;
            if (handler2 == null) {
                Handler newWorkerTaskHandler = getNewWorkerTaskHandler();
                this.workerTaskHandler = newWorkerTaskHandler;
                looper = newWorkerTaskHandler.getLooper();
                Intrinsics.checkExpressionValueIsNotNull(looper, "newHandler.looper");
            } else {
                looper = handler2.getLooper();
                Intrinsics.checkExpressionValueIsNotNull(looper, "workerHandler.looper");
            }
        }
        return looper;
    }

    private final Handler getNewWorkerTaskHandler() {
        HandlerThread handlerThread = new HandlerThread(this.namespace + " worker task");
        handlerThread.start();
        return new Handler(handlerThread.getLooper());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:2|3|(8:5|6|7|8|9|10|(1:12)|(1:16))|17|18|19) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:5|6|7|8|9|10|(1:12)|(1:16)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0030 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0019 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0022 A[Catch:{ Exception -> 0x0030 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.lock
            monitor-enter(r0)
            boolean r1 = r4.closed     // Catch:{ all -> 0x0034 }
            if (r1 != 0) goto L_0x0030
            r1 = 1
            r4.closed = r1     // Catch:{ all -> 0x0034 }
            r1 = 0
            android.os.Handler r2 = r4.handler     // Catch:{ Exception -> 0x0019 }
            r2.removeCallbacksAndMessages(r1)     // Catch:{ Exception -> 0x0019 }
            android.os.Handler r2 = r4.handler     // Catch:{ Exception -> 0x0019 }
            android.os.Looper r2 = r2.getLooper()     // Catch:{ Exception -> 0x0019 }
            r2.quit()     // Catch:{ Exception -> 0x0019 }
        L_0x0019:
            android.os.Handler r2 = r4.workerTaskHandler     // Catch:{ Exception -> 0x0030 }
            r3 = r1
            android.os.Handler r3 = (android.os.Handler) r3     // Catch:{ Exception -> 0x0030 }
            r4.workerTaskHandler = r3     // Catch:{ Exception -> 0x0030 }
            if (r2 == 0) goto L_0x0025
            r2.removeCallbacksAndMessages(r1)     // Catch:{ Exception -> 0x0030 }
        L_0x0025:
            if (r2 == 0) goto L_0x0030
            android.os.Looper r1 = r2.getLooper()     // Catch:{ Exception -> 0x0030 }
            if (r1 == 0) goto L_0x0030
            r1.quit()     // Catch:{ Exception -> 0x0030 }
        L_0x0030:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0034 }
            monitor-exit(r0)
            return
        L_0x0034:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2core.HandlerWrapper.close():void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.tonyodev.fetch2core.HandlerWrapper");
        } else if (!Intrinsics.areEqual((Object) this.namespace, (Object) ((HandlerWrapper) obj).namespace)) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return this.namespace.hashCode();
    }
}
