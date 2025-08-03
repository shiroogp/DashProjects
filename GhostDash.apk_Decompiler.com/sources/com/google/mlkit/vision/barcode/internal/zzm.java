package com.google.mlkit.vision.barcode.internal;

import android.content.Context;
import android.media.Image;
import android.os.Build;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_vision_barcode.zzjb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzlo;
import com.google.android.gms.internal.mlkit_vision_barcode.zzmp;
import com.google.android.gms.internal.mlkit_vision_barcode.zzmr;
import com.google.android.gms.internal.mlkit_vision_barcode.zzmz;
import com.google.android.gms.internal.mlkit_vision_barcode.zznb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzni;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.barcode.Barcode;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.CommonConvertUtils;
import com.google.mlkit.vision.common.internal.ImageUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
final class zzm implements zzj {
    private boolean zza;
    private boolean zzb;
    private boolean zzc;
    private final Context zzd;
    private final BarcodeScannerOptions zze;
    private final zzlo zzf;
    private zzmz zzg;

    zzm(Context context, BarcodeScannerOptions barcodeScannerOptions, zzlo zzlo) {
        this.zzd = context;
        this.zze = barcodeScannerOptions;
        this.zzf = zzlo;
    }

    static boolean zzd(Context context) {
        return DynamiteModule.getLocalVersion(context, "com.google.mlkit.dynamite.barcode") > 0;
    }

    public final List<Barcode> zza(InputImage inputImage) throws MlKitException {
        if (this.zzg == null) {
            zzc();
        }
        zzmz zzmz = (zzmz) Preconditions.checkNotNull(this.zzg);
        if (!this.zza) {
            try {
                zzmz.zze();
                this.zza = true;
            } catch (RemoteException e) {
                throw new MlKitException("Failed to init barcode scanner.", 13, e);
            }
        }
        int width = inputImage.getWidth();
        if (inputImage.getFormat() == 35 && Build.VERSION.SDK_INT >= 19) {
            width = ((Image.Plane[]) Preconditions.checkNotNull(inputImage.getPlanes()))[0].getRowStride();
        }
        try {
            List<zzmp> zzd2 = zzmz.zzd(ImageUtils.getInstance().getImageDataWrapper(inputImage), new zzni(inputImage.getFormat(), width, inputImage.getHeight(), CommonConvertUtils.convertToMVRotation(inputImage.getRotationDegrees()), SystemClock.elapsedRealtime()));
            ArrayList arrayList = new ArrayList();
            for (zzmp zzl : zzd2) {
                arrayList.add(new Barcode(new zzl(zzl)));
            }
            return arrayList;
        } catch (RemoteException e2) {
            throw new MlKitException("Failed to run barcode scanner.", 13, e2);
        }
    }

    public final void zzb() {
        zzmz zzmz = this.zzg;
        if (zzmz != null) {
            try {
                zzmz.zzf();
            } catch (RemoteException e) {
                Log.e("DecoupledBarcodeScanner", "Failed to release barcode scanner.", e);
            }
            this.zzg = null;
            this.zza = false;
        }
    }

    public final boolean zzc() throws MlKitException {
        if (this.zzg != null) {
            return this.zzb;
        }
        if (zzd(this.zzd)) {
            this.zzb = true;
            try {
                this.zzg = zze(DynamiteModule.PREFER_LOCAL, "com.google.mlkit.dynamite.barcode", "com.google.mlkit.vision.barcode.bundled.internal.ThickBarcodeScannerCreator");
            } catch (DynamiteModule.LoadingException e) {
                throw new MlKitException("Failed to load the bundled barcode module.", 13, e);
            } catch (RemoteException e2) {
                throw new MlKitException("Failed to create thick barcode scanner.", 13, e2);
            }
        } else {
            this.zzb = false;
            try {
                this.zzg = zze(DynamiteModule.PREFER_REMOTE, "com.google.android.gms.vision.barcode", "com.google.android.gms.vision.barcode.mlkit.BarcodeScannerCreator");
            } catch (DynamiteModule.LoadingException unused) {
                if (!this.zzc) {
                    OptionalModuleUtils.requestDownload(this.zzd, OptionalModuleUtils.BARCODE);
                    this.zzc = true;
                }
                zzb.zze(this.zzf, zzjb.OPTIONAL_MODULE_NOT_AVAILABLE);
                throw new MlKitException("Waiting for the barcode module to be downloaded. Please wait.", 14);
            } catch (RemoteException e3) {
                zzb.zze(this.zzf, zzjb.OPTIONAL_MODULE_INIT_ERROR);
                throw new MlKitException("Failed to create thin barcode scanner.", 13, e3);
            }
        }
        zzb.zze(this.zzf, zzjb.NO_ERROR);
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final zzmz zze(DynamiteModule.VersionPolicy versionPolicy, String str, String str2) throws DynamiteModule.LoadingException, RemoteException {
        return zznb.zza(DynamiteModule.load(this.zzd, versionPolicy, str).instantiate(str2)).zzd(ObjectWrapper.wrap(this.zzd), new zzmr(this.zze.zza()));
    }
}
