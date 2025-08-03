package com.google.mlkit.vision.text.internal;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.internal.mlkit_vision_text.zzdq;
import com.google.android.gms.internal.mlkit_vision_text.zzif;
import com.google.android.gms.internal.mlkit_vision_text.zzig;
import com.google.android.gms.internal.mlkit_vision_text.zzik;
import com.google.android.gms.internal.mlkit_vision_text.zzir;
import com.google.android.gms.internal.mlkit_vision_text.zzis;
import com.google.android.gms.internal.mlkit_vision_text.zziu;
import com.google.android.gms.internal.mlkit_vision_text.zzka;
import com.google.android.gms.internal.mlkit_vision_text.zzkb;
import com.google.android.gms.internal.mlkit_vision_text.zzkw;
import com.google.android.gms.internal.mlkit_vision_text.zzky;
import com.google.android.gms.internal.mlkit_vision_text.zzkz;
import com.google.android.gms.internal.mlkit_vision_text.zzlh;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.ImageUtils;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognizerOptionsInterface;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final class zzo extends MLTask<Text, InputImage> {
    static boolean zza = true;
    private static final ImageUtils zzb = ImageUtils.getInstance();
    private final zzj zzc;
    private final zzkw zzd;
    private final zzky zze;
    private final int zzf;

    public zzo(MlKitContext mlKitContext, TextRecognizerOptionsInterface textRecognizerOptionsInterface) {
        zzj zzj;
        zzkw zzb2 = zzlh.zzb(textRecognizerOptionsInterface.getLoggingLibraryName());
        Context applicationContext = mlKitContext.getApplicationContext();
        if (GoogleApiAvailabilityLight.getInstance().getApkVersion(applicationContext) >= 204700000 || textRecognizerOptionsInterface.getIsThickClient()) {
            zzj = new zzb(applicationContext, textRecognizerOptionsInterface);
        } else {
            zzj = new zzc(applicationContext);
        }
        int loggingEventId = textRecognizerOptionsInterface.getLoggingEventId();
        this.zzd = zzb2;
        this.zzc = zzj;
        this.zze = zzky.zza(MlKitContext.getInstance().getApplicationContext());
        this.zzf = loggingEventId;
    }

    static /* synthetic */ zzkz zzd(long j, zzir zzir, InputImage inputImage) {
        zzig zzig;
        zzka zzka = new zzka();
        zzik zzik = new zzik();
        zzik.zzc(Long.valueOf(j));
        zzik.zzd(zzir);
        zzik.zze(Boolean.valueOf(zza));
        zzik.zza(true);
        zzik.zzb(true);
        zzka.zzd(zzik.zzf());
        ImageUtils imageUtils = zzb;
        int mobileVisionImageFormat = imageUtils.getMobileVisionImageFormat(inputImage);
        int mobileVisionImageSize = imageUtils.getMobileVisionImageSize(inputImage);
        zzif zzif = new zzif();
        if (mobileVisionImageFormat == -1) {
            zzig = zzig.BITMAP;
        } else if (mobileVisionImageFormat == 35) {
            zzig = zzig.YUV_420_888;
        } else if (mobileVisionImageFormat == 842094169) {
            zzig = zzig.YV12;
        } else if (mobileVisionImageFormat == 16) {
            zzig = zzig.NV16;
        } else if (mobileVisionImageFormat != 17) {
            zzig = zzig.UNKNOWN_FORMAT;
        } else {
            zzig = zzig.NV21;
        }
        zzif.zza(zzig);
        zzif.zzb(Integer.valueOf(mobileVisionImageSize));
        zzka.zzc(zzif.zzd());
        zzkb zze2 = zzka.zze();
        zziu zziu = new zziu();
        zziu.zze(false);
        zziu.zzf(zze2);
        return zzkz.zzd(zziu);
    }

    private final void zze(zzir zzir, long j, InputImage inputImage) {
        zzir zzir2 = zzir;
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        this.zzd.zze(new zzn(elapsedRealtime, zzir2, inputImage), zzis.ON_DEVICE_TEXT_DETECT);
        zzdq zzdq = new zzdq();
        zzdq.zza(zzir2);
        zzdq.zzb(Boolean.valueOf(zza));
        long j2 = elapsedRealtime;
        this.zzd.zzf(zzdq.zzc(), j2, zzis.AGGREGATED_ON_DEVICE_TEXT_DETECTION, zzm.zza);
        long currentTimeMillis = System.currentTimeMillis();
        this.zze.zzc(this.zzf, zzir.zza(), currentTimeMillis - elapsedRealtime, currentTimeMillis);
    }

    public final synchronized void load() throws MlKitException {
        this.zzc.zzb();
    }

    public final synchronized void release() {
        zza = true;
        this.zzc.zzc();
    }

    /* renamed from: zzc */
    public final synchronized Text run(InputImage inputImage) throws MlKitException {
        zzir zzir;
        Text zza2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            zza2 = this.zzc.zza(inputImage);
            zze(zzir.NO_ERROR, elapsedRealtime, inputImage);
            zza = false;
        } catch (MlKitException e) {
            if (e.getErrorCode() == 14) {
                zzir = zzir.MODEL_NOT_DOWNLOADED;
            } else {
                zzir = zzir.UNKNOWN_ERROR;
            }
            zze(zzir, elapsedRealtime, inputImage);
            throw e;
        }
        return zza2;
    }
}
