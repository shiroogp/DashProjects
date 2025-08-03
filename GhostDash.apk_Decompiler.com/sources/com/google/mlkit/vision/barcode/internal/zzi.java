package com.google.mlkit.vision.barcode.internal;

import android.os.SystemClock;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_barcode.zzby;
import com.google.android.gms.internal.mlkit_vision_barcode.zzdn;
import com.google.android.gms.internal.mlkit_vision_barcode.zzdo;
import com.google.android.gms.internal.mlkit_vision_barcode.zzdp;
import com.google.android.gms.internal.mlkit_vision_barcode.zzil;
import com.google.android.gms.internal.mlkit_vision_barcode.zzip;
import com.google.android.gms.internal.mlkit_vision_barcode.zziq;
import com.google.android.gms.internal.mlkit_vision_barcode.zziu;
import com.google.android.gms.internal.mlkit_vision_barcode.zzjb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzjc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzje;
import com.google.android.gms.internal.mlkit_vision_barcode.zzjq;
import com.google.android.gms.internal.mlkit_vision_barcode.zzlo;
import com.google.android.gms.internal.mlkit_vision_barcode.zzlq;
import com.google.android.gms.internal.mlkit_vision_barcode.zzlr;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.barcode.Barcode;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.BitmapInStreamingChecker;
import com.google.mlkit.vision.common.internal.ImageUtils;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final class zzi extends MLTask<List<Barcode>, InputImage> {
    static boolean zza = true;
    private static final ImageUtils zzb = ImageUtils.getInstance();
    private final BarcodeScannerOptions zzc;
    private final zzj zzd;
    private final zzlo zze;
    private final zzlq zzf;
    private final BitmapInStreamingChecker zzg = new BitmapInStreamingChecker();
    private boolean zzh;

    public zzi(MlKitContext mlKitContext, BarcodeScannerOptions barcodeScannerOptions, zzj zzj, zzlo zzlo) {
        Preconditions.checkNotNull(mlKitContext, "MlKitContext can not be null");
        Preconditions.checkNotNull(barcodeScannerOptions, "BarcodeScannerOptions can not be null");
        this.zzc = barcodeScannerOptions;
        this.zzd = zzj;
        this.zze = zzlo;
        this.zzf = zzlq.zza(mlKitContext.getApplicationContext());
    }

    private final void zzf(zzjb zzjb, long j, InputImage inputImage, List<Barcode> list) {
        zzby zzby = new zzby();
        zzby zzby2 = new zzby();
        if (list != null) {
            for (Barcode next : list) {
                zzby.zzd(zzb.zza(next.getFormat()));
                zzby2.zzd(zzb.zzb(next.getValueType()));
            }
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        this.zze.zzb(new zzh(this, elapsedRealtime, zzjb, zzby, zzby2, inputImage), zzjc.ON_DEVICE_BARCODE_DETECT);
        zzdo zzdo = new zzdo();
        zzdo.zze(zzjb);
        zzdo.zzf(Boolean.valueOf(zza));
        zzdo.zzg(zzb.zzc(this.zzc));
        zzdo.zzc(zzby.zzf());
        zzdo.zzd(zzby2.zzf());
        this.zze.zzf(zzdo.zzh(), elapsedRealtime, zzjc.AGGREGATED_ON_DEVICE_BARCODE_DETECTION, new zzg(this));
        long currentTimeMillis = System.currentTimeMillis();
        this.zzf.zzc(true != this.zzh ? 24301 : 24302, zzjb.zza(), currentTimeMillis - elapsedRealtime, currentTimeMillis);
    }

    public final synchronized void load() throws MlKitException {
        this.zzh = this.zzd.zzc();
    }

    public final synchronized void release() {
        this.zzd.zzb();
        zza = true;
    }

    /* renamed from: zzc */
    public final synchronized List<Barcode> run(InputImage inputImage) throws MlKitException {
        zzjb zzjb;
        List<Barcode> zza2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.zzg.check(inputImage);
        try {
            zza2 = this.zzd.zza(inputImage);
            zzf(zzjb.NO_ERROR, elapsedRealtime, inputImage, zza2);
            zza = false;
        } catch (MlKitException e) {
            MlKitException mlKitException = e;
            if (mlKitException.getErrorCode() == 14) {
                zzjb = zzjb.MODEL_NOT_DOWNLOADED;
            } else {
                zzjb = zzjb.UNKNOWN_ERROR;
            }
            zzf(zzjb, elapsedRealtime, inputImage, (List<Barcode>) null);
            throw mlKitException;
        }
        return zza2;
    }

    public final /* synthetic */ zzlr zzd(long j, zzjb zzjb, zzby zzby, zzby zzby2, InputImage inputImage) {
        zziq zziq;
        zzjq zzjq = new zzjq();
        zziu zziu = new zziu();
        zziu.zzc(Long.valueOf(j));
        zziu.zzd(zzjb);
        zziu.zze(Boolean.valueOf(zza));
        zziu.zza(true);
        zziu.zzb(true);
        zzjq.zzh(zziu.zzf());
        zzjq.zzi(zzb.zzc(this.zzc));
        zzjq.zze(zzby.zzf());
        zzjq.zzf(zzby2.zzf());
        int format = inputImage.getFormat();
        int mobileVisionImageSize = zzb.getMobileVisionImageSize(inputImage);
        zzip zzip = new zzip();
        if (format == -1) {
            zziq = zziq.BITMAP;
        } else if (format == 35) {
            zziq = zziq.YUV_420_888;
        } else if (format == 842094169) {
            zziq = zziq.YV12;
        } else if (format == 16) {
            zziq = zziq.NV16;
        } else if (format != 17) {
            zziq = zziq.UNKNOWN_FORMAT;
        } else {
            zziq = zziq.NV21;
        }
        zzip.zza(zziq);
        zzip.zzb(Integer.valueOf(mobileVisionImageSize));
        zzjq.zzg(zzip.zzd());
        zzje zzje = new zzje();
        zzje.zze(Boolean.valueOf(this.zzh));
        zzje.zzf(zzjq.zzj());
        return zzlr.zzd(zzje);
    }

    public final /* synthetic */ zzlr zze(zzdp zzdp, int i, zzil zzil) {
        zzje zzje = new zzje();
        zzje.zze(Boolean.valueOf(this.zzh));
        zzdn zzdn = new zzdn();
        zzdn.zza(Integer.valueOf(i));
        zzdn.zzc(zzdp);
        zzdn.zzb(zzil);
        zzje.zzc(zzdn.zze());
        return zzlr.zzd(zzje);
    }
}
