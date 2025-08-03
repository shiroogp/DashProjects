package com.google.mlkit.vision.barcode.internal;

import android.content.Context;
import android.media.Image;
import android.os.Build;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_vision_barcode.zzad;
import com.google.android.gms.internal.mlkit_vision_barcode.zzaf;
import com.google.android.gms.internal.mlkit_vision_barcode.zzah;
import com.google.android.gms.internal.mlkit_vision_barcode.zzaj;
import com.google.android.gms.internal.mlkit_vision_barcode.zzjb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzlo;
import com.google.android.gms.internal.mlkit_vision_barcode.zzq;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.barcode.Barcode;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.CommonConvertUtils;
import com.google.mlkit.vision.common.internal.ImageConvertUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
final class zzo implements zzj {
    private boolean zza;
    private final Context zzb;
    private final zzad zzc;
    private final zzlo zzd;
    private zzaf zze;

    zzo(Context context, BarcodeScannerOptions barcodeScannerOptions, zzlo zzlo) {
        zzad zzad = new zzad();
        this.zzc = zzad;
        this.zzb = context;
        zzad.zza = barcodeScannerOptions.zza();
        this.zzd = zzlo;
    }

    public final List<Barcode> zza(InputImage inputImage) throws MlKitException {
        zzq[] zzqArr;
        if (this.zze == null) {
            zzc();
        }
        zzaf zzaf = this.zze;
        if (zzaf != null) {
            zzaf zzaf2 = (zzaf) Preconditions.checkNotNull(zzaf);
            zzaj zzaj = new zzaj(inputImage.getWidth(), inputImage.getHeight(), 0, 0, CommonConvertUtils.convertToMVRotation(inputImage.getRotationDegrees()));
            try {
                int format = inputImage.getFormat();
                if (format == -1) {
                    zzqArr = zzaf2.zzf(ObjectWrapper.wrap(inputImage.getBitmapInternal()), zzaj);
                } else if (format != 17) {
                    if (format != 35) {
                        if (format == 842094169) {
                            zzqArr = zzaf2.zze(ObjectWrapper.wrap(ImageConvertUtils.getInstance().convertToNv21Buffer(inputImage, false)), zzaj);
                        }
                    } else if (Build.VERSION.SDK_INT >= 19) {
                        Image.Plane[] planeArr = (Image.Plane[]) Preconditions.checkNotNull(inputImage.getPlanes());
                        zzaj.zza = planeArr[0].getRowStride();
                        zzqArr = zzaf2.zze(ObjectWrapper.wrap(planeArr[0].getBuffer()), zzaj);
                    }
                    int format2 = inputImage.getFormat();
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Unsupported image format: ");
                    sb.append(format2);
                    throw new MlKitException(sb.toString(), 3);
                } else {
                    zzqArr = zzaf2.zze(ObjectWrapper.wrap(inputImage.getByteBuffer()), zzaj);
                }
                ArrayList arrayList = new ArrayList();
                for (zzq zzn : zzqArr) {
                    arrayList.add(new Barcode(new zzn(zzn)));
                }
                return arrayList;
            } catch (RemoteException e) {
                throw new MlKitException("Failed to detect with legacy barcode detector", 13, e);
            }
        } else {
            throw new MlKitException("Error initializing the legacy barcode scanner.", 14);
        }
    }

    public final void zzb() {
        zzaf zzaf = this.zze;
        if (zzaf != null) {
            try {
                zzaf.zzd();
            } catch (RemoteException e) {
                Log.e("LegacyBarcodeScanner", "Failed to release legacy barcode detector.", e);
            }
            this.zze = null;
        }
    }

    public final boolean zzc() throws MlKitException {
        if (this.zze != null) {
            return false;
        }
        try {
            zzaf zzd2 = zzah.zza(DynamiteModule.load(this.zzb, DynamiteModule.PREFER_REMOTE, OptionalModuleUtils.DEPRECATED_DYNAMITE_MODULE_ID).instantiate("com.google.android.gms.vision.barcode.ChimeraNativeBarcodeDetectorCreator")).zzd(ObjectWrapper.wrap(this.zzb), this.zzc);
            this.zze = zzd2;
            if (zzd2 == null) {
                if (!this.zza) {
                    Log.d("LegacyBarcodeScanner", "Request optional module download.");
                    OptionalModuleUtils.requestDownload(this.zzb, OptionalModuleUtils.BARCODE);
                    this.zza = true;
                    zzb.zze(this.zzd, zzjb.OPTIONAL_MODULE_NOT_AVAILABLE);
                    throw new MlKitException("Waiting for the barcode module to be downloaded. Please wait.", 14);
                }
            }
            zzb.zze(this.zzd, zzjb.NO_ERROR);
            return false;
        } catch (RemoteException e) {
            throw new MlKitException("Failed to create legacy barcode detector.", 13, e);
        } catch (DynamiteModule.LoadingException e2) {
            throw new MlKitException("Failed to load deprecated vision dynamite module.", 13, e2);
        }
    }
}
