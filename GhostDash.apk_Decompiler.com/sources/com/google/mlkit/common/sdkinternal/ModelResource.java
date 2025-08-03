package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.MlKitException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public abstract class ModelResource {
    protected final TaskQueue taskQueue = new TaskQueue();
    private final AtomicInteger zza = new AtomicInteger(0);
    private final AtomicBoolean zzb = new AtomicBoolean(false);

    public <T> Task<T> callAfterLoad(Executor executor, Callable<T> callable, CancellationToken cancellationToken) {
        Preconditions.checkState(this.zza.get() > 0);
        if (cancellationToken.isCancellationRequested()) {
            return Tasks.forCanceled();
        }
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        this.taskQueue.submit(new zzn(executor, cancellationToken, cancellationTokenSource, taskCompletionSource), new zzm(this, cancellationToken, cancellationTokenSource, callable, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public boolean isLoaded() {
        return this.zzb.get();
    }

    public abstract void load() throws MlKitException;

    public void pin() {
        this.zza.incrementAndGet();
    }

    /* access modifiers changed from: protected */
    public abstract void release();

    public void unpin(Executor executor) {
        Preconditions.checkState(this.zza.get() > 0);
        this.taskQueue.submit(executor, new zzl(this));
    }

    public final /* synthetic */ void zza(CancellationToken cancellationToken, CancellationTokenSource cancellationTokenSource, Callable callable, TaskCompletionSource taskCompletionSource) {
        if (cancellationToken.isCancellationRequested()) {
            cancellationTokenSource.cancel();
            return;
        }
        try {
            if (!this.zzb.get()) {
                load();
                this.zzb.set(true);
            }
            if (cancellationToken.isCancellationRequested()) {
                cancellationTokenSource.cancel();
                return;
            }
            Object call = callable.call();
            if (cancellationToken.isCancellationRequested()) {
                cancellationTokenSource.cancel();
            } else {
                taskCompletionSource.setResult(call);
            }
        } catch (RuntimeException e) {
            throw new MlKitException("Internal error has occurred when executing ML Kit tasks", 13, e);
        } catch (Exception e2) {
            if (cancellationToken.isCancellationRequested()) {
                cancellationTokenSource.cancel();
            } else {
                taskCompletionSource.setException(e2);
            }
        }
    }

    public final /* synthetic */ void zzb() {
        int decrementAndGet = this.zza.decrementAndGet();
        Preconditions.checkState(decrementAndGet >= 0);
        if (decrementAndGet == 0) {
            release();
            this.zzb.set(false);
        }
    }
}
