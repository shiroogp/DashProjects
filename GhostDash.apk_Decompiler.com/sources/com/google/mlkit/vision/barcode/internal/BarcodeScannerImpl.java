package com.google.mlkit.vision.barcode.internal;

import com.google.android.gms.internal.mlkit_vision_barcode.zzjc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzje;
import com.google.android.gms.internal.mlkit_vision_barcode.zzjq;
import com.google.android.gms.internal.mlkit_vision_barcode.zzjr;
import com.google.android.gms.internal.mlkit_vision_barcode.zzlo;
import com.google.android.gms.internal.mlkit_vision_barcode.zzlr;
import com.google.android.gms.tasks.Task;
import com.google.android.odml.image.MlImage;
import com.google.mlkit.vision.barcode.Barcode;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public class BarcodeScannerImpl extends MobileVisionBase<List<Barcode>> implements BarcodeScanner {
    /* access modifiers changed from: private */
    public static final BarcodeScannerOptions zzb = new BarcodeScannerOptions.Builder().build();

    BarcodeScannerImpl(BarcodeScannerOptions barcodeScannerOptions, zzi zzi, Executor executor, zzlo zzlo) {
        super(zzi, executor);
        zzjq zzjq = new zzjq();
        zzjq.zzi(zzb.zzc(barcodeScannerOptions));
        zzjr zzj = zzjq.zzj();
        zzje zzje = new zzje();
        zzje.zzf(zzj);
        zzlo.zzd(zzlr.zze(zzje, 1), zzjc.ON_DEVICE_BARCODE_CREATE);
    }

    public final Task<List<Barcode>> process(MlImage mlImage) {
        return super.processBase(mlImage);
    }

    public final Task<List<Barcode>> process(InputImage inputImage) {
        return super.processBase(inputImage);
    }
}
