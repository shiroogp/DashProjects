package com.google.mlkit.vision.common.internal;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_common.zzhm;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.odml.image.MlImage;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.vision.common.InputImage;
import java.io.Closeable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
public class MobileVisionBase<DetectionResultT> implements Closeable, LifecycleObserver {
    public static final /* synthetic */ int zza = 0;
    private static final GmsLogger zzb = new GmsLogger("MobileVisionBase", "");
    private final AtomicBoolean zzc = new AtomicBoolean(false);
    private final MLTask<DetectionResultT, InputImage> zzd;
    private final CancellationTokenSource zze;
    private final Executor zzf;

    public MobileVisionBase(MLTask<DetectionResultT, InputImage> mLTask, Executor executor) {
        this.zzd = mLTask;
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        this.zze = cancellationTokenSource;
        this.zzf = executor;
        mLTask.pin();
        mLTask.callAfterLoad(executor, zze.zza, cancellationTokenSource.getToken()).addOnFailureListener(zzb.zza);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public synchronized void close() {
        if (!this.zzc.getAndSet(true)) {
            this.zze.cancel();
            this.zzd.unpin(this.zzf);
        }
    }

    public synchronized Task<DetectionResultT> processBase(MlImage mlImage) {
        Preconditions.checkNotNull(mlImage, "MlImage can not be null");
        if (this.zzc.get()) {
            return Tasks.forException(new MlKitException("This detector is already closed!", 14));
        } else if (mlImage.getWidth() < 32 || mlImage.getHeight() < 32) {
            return Tasks.forException(new MlKitException("MlImage width and height should be at least 32!", 3));
        } else {
            mlImage.getInternal().acquire();
            return this.zzd.callAfterLoad(this.zzf, new zzc(this, mlImage), this.zze.getToken()).addOnCompleteListener(new zza(mlImage));
        }
    }

    public final /* synthetic */ Object zza(InputImage inputImage) throws Exception {
        zzhm zzf2 = zzhm.zzf("detectorTaskWithResource#run");
        zzf2.zzb();
        try {
            DetectionResultT run = this.zzd.run(inputImage);
            zzf2.close();
            return run;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public final /* synthetic */ Object zzb(MlImage mlImage) throws Exception {
        InputImage zza2 = CommonConvertUtils.zza(mlImage);
        if (zza2 != null) {
            return this.zzd.run(zza2);
        }
        throw new MlKitException("Current type of MlImage is not supported.", 13);
    }

    public synchronized Task<DetectionResultT> processBase(InputImage inputImage) {
        Preconditions.checkNotNull(inputImage, "InputImage can not be null");
        if (this.zzc.get()) {
            return Tasks.forException(new MlKitException("This detector is already closed!", 14));
        } else if (inputImage.getWidth() < 32 || inputImage.getHeight() < 32) {
            return Tasks.forException(new MlKitException("InputImage width and height should be at least 32!", 3));
        } else {
            return this.zzd.callAfterLoad(this.zzf, new zzd(this, inputImage), this.zze.getToken());
        }
    }
}
