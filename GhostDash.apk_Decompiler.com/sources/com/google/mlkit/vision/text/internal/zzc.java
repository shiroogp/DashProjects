package com.google.mlkit.vision.text.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_vision_text.zzd;
import com.google.android.gms.internal.mlkit_vision_text.zzh;
import com.google.android.gms.internal.mlkit_vision_text.zzj;
import com.google.android.gms.internal.mlkit_vision_text.zzp;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.CommonConvertUtils;
import com.google.mlkit.vision.common.internal.ImageConvertUtils;
import com.google.mlkit.vision.text.Text;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
final class zzc implements zzj {
    private final Context zza;
    private final zzp zzb = new zzp((String) null);
    private boolean zzc;
    private zzh zzd;

    zzc(Context context) {
        this.zza = context;
    }

    public final Text zza(InputImage inputImage) throws MlKitException {
        int i;
        Bitmap bitmap;
        if (this.zzd == null) {
            zzb();
        }
        if (this.zzd != null) {
            if (inputImage.getFormat() == -1) {
                bitmap = inputImage.getBitmapInternal();
                i = CommonConvertUtils.convertToMVRotation(inputImage.getRotationDegrees());
            } else {
                bitmap = ImageConvertUtils.getInstance().convertToUpRightBitmap(inputImage);
                i = 0;
            }
            try {
                return zzi.zza(((zzh) Preconditions.checkNotNull(this.zzd)).zze(ObjectWrapper.wrap(bitmap), new zzd(inputImage.getWidth(), inputImage.getHeight(), 0, 0, i)));
            } catch (RemoteException e) {
                throw new MlKitException("Failed to run legacy text recognizer.", 13, e);
            }
        } else {
            throw new MlKitException("Waiting for the text recognition module to be downloaded. Please wait.", 14);
        }
    }

    public final void zzb() throws MlKitException {
        if (this.zzd == null) {
            try {
                zzh zzd2 = zzj.zza(DynamiteModule.load(this.zza, DynamiteModule.PREFER_REMOTE, OptionalModuleUtils.DEPRECATED_DYNAMITE_MODULE_ID).instantiate("com.google.android.gms.vision.text.ChimeraNativeTextRecognizerCreator")).zzd(ObjectWrapper.wrap(this.zza), this.zzb);
                this.zzd = zzd2;
                if (zzd2 == null && !this.zzc) {
                    Log.d("LegacyTextDelegate", "Request OCR optional module download.");
                    OptionalModuleUtils.requestDownload(this.zza, OptionalModuleUtils.OCR);
                    this.zzc = true;
                }
            } catch (RemoteException e) {
                throw new MlKitException("Failed to create legacy text recognizer.", 13, e);
            } catch (DynamiteModule.LoadingException e2) {
                throw new MlKitException("Failed to load deprecated vision dynamite module.", 13, e2);
            }
        }
    }

    public final void zzc() {
        zzh zzh = this.zzd;
        if (zzh != null) {
            try {
                zzh.zzd();
            } catch (RemoteException e) {
                Log.e("LegacyTextDelegate", "Failed to release legacy text recognizer.", e);
            }
            this.zzd = null;
        }
    }
}
