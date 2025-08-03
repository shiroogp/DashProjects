package com.tonyodev.fetch2.fetch;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f0\u0011R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/tonyodev/fetch2/fetch/LiveSettings;", "", "namespace", "", "(Ljava/lang/String;)V", "didSanitizeDatabaseOnFirstEntry", "", "getDidSanitizeDatabaseOnFirstEntry", "()Z", "setDidSanitizeDatabaseOnFirstEntry", "(Z)V", "lock", "getNamespace", "()Ljava/lang/String;", "execute", "", "func", "Lkotlin/Function1;", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: LiveSettings.kt */
public final class LiveSettings {
    private volatile boolean didSanitizeDatabaseOnFirstEntry;
    private final Object lock = new Object();
    private final String namespace;

    public LiveSettings(String str) {
        Intrinsics.checkParameterIsNotNull(str, "namespace");
        this.namespace = str;
    }

    public final String getNamespace() {
        return this.namespace;
    }

    public final boolean getDidSanitizeDatabaseOnFirstEntry() {
        return this.didSanitizeDatabaseOnFirstEntry;
    }

    public final void setDidSanitizeDatabaseOnFirstEntry(boolean z) {
        this.didSanitizeDatabaseOnFirstEntry = z;
    }

    public final void execute(Function1<? super LiveSettings, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "func");
        synchronized (this.lock) {
            function1.invoke(this);
            Unit unit = Unit.INSTANCE;
        }
    }
}
