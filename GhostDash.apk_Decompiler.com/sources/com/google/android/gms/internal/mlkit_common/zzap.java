package com.google.android.gms.internal.mlkit_common;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public abstract class zzap extends zzac implements ExecutorService {
    protected zzap() {
    }

    public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return zzb().awaitTermination(j, timeUnit);
    }

    public void execute(Runnable runnable) {
        zzb().execute(runnable);
    }

    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return zzb().invokeAll(collection);
    }

    public final <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return zzb().invokeAny(collection);
    }

    public final boolean isShutdown() {
        return zzb().isShutdown();
    }

    public final boolean isTerminated() {
        return zzb().isTerminated();
    }

    public final void shutdown() {
        zzb().shutdown();
    }

    public final List<Runnable> shutdownNow() {
        return zzb().shutdownNow();
    }

    public final Future<?> submit(Runnable runnable) {
        return zzb().submit(runnable);
    }

    /* access modifiers changed from: protected */
    public /* bridge */ /* synthetic */ Object zza() {
        throw null;
    }

    /* access modifiers changed from: protected */
    public abstract ExecutorService zzb();

    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return zzb().invokeAll(collection, j, timeUnit);
    }

    public final <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return zzb().invokeAny(collection, j, timeUnit);
    }

    public final <T> Future<T> submit(Runnable runnable, T t) {
        return zzb().submit(runnable, t);
    }

    public final <T> Future<T> submit(Callable<T> callable) {
        return zzb().submit(callable);
    }
}
