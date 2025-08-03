package com.google.mlkit.vision.text.internal;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_vision_text.zzlk;
import com.google.android.gms.internal.mlkit_vision_text.zzlm;
import com.google.android.gms.internal.mlkit_vision_text.zzlo;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.CommonConvertUtils;
import com.google.mlkit.vision.common.internal.ImageUtils;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognizerOptionsInterface;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
final class zzb implements zzj {
    private final Context zza;
    private final TextRecognizerOptionsInterface zzb;
    private boolean zzc;
    private boolean zzd;
    private zzlm zze;

    zzb(Context context, TextRecognizerOptionsInterface textRecognizerOptionsInterface) {
        this.zza = context;
        this.zzb = textRecognizerOptionsInterface;
    }

    public final Text zza(InputImage inputImage) throws MlKitException {
        String str;
        String str2;
        if (this.zze == null) {
            zzb();
        }
        zzlm zzlm = (zzlm) Preconditions.checkNotNull(this.zze);
        if (!this.zzc) {
            try {
                zzlm.zze();
                this.zzc = true;
            } catch (RemoteException e) {
                String valueOf = String.valueOf(this.zzb.getLoggingLibraryName());
                if (valueOf.length() != 0) {
                    str2 = "Failed to init text recognizer ".concat(valueOf);
                } else {
                    str2 = new String("Failed to init text recognizer ");
                }
                throw new MlKitException(str2, 13, e);
            }
        }
        try {
            return new Text(zzlm.zzd(ImageUtils.getInstance().getImageDataWrapper(inputImage), new zzlk(inputImage.getFormat(), inputImage.getWidth(), inputImage.getHeight(), CommonConvertUtils.convertToMVRotation(inputImage.getRotationDegrees()), SystemClock.elapsedRealtime())));
        } catch (RemoteException e2) {
            String valueOf2 = String.valueOf(this.zzb.getLoggingLibraryName());
            if (valueOf2.length() != 0) {
                str = "Failed to run text recognizer ".concat(valueOf2);
            } else {
                str = new String("Failed to run text recognizer ");
            }
            throw new MlKitException(str, 13, e2);
        }
    }

    public final void zzb() throws MlKitException {
        DynamiteModule.VersionPolicy versionPolicy;
        if (this.zze == null) {
            try {
                Context context = this.zza;
                if (this.zzb.getIsThickClient()) {
                    versionPolicy = DynamiteModule.PREFER_LOCAL;
                } else {
                    versionPolicy = DynamiteModule.PREFER_REMOTE;
                }
                this.zze = zzlo.zza(DynamiteModule.load(context, versionPolicy, this.zzb.getModuleId()).instantiate(this.zzb.getCreatorClass())).zzd(ObjectWrapper.wrap(this.zza));
            } catch (DynamiteModule.LoadingException e) {
                if (!this.zzb.getIsThickClient()) {
                    if (!this.zzd) {
                        OptionalModuleUtils.requestDownload(this.zza, OptionalModuleUtils.OCR);
                        this.zzd = true;
                    }
                    throw new MlKitException("Waiting for the text optional module to be downloaded. Please wait.", 14);
                }
                throw new MlKitException(String.format("Failed to load text module %s. %s", new Object[]{this.zzb.getLoggingLibraryName(), e.getMessage()}), 13, e);
            } catch (RemoteException e2) {
                String valueOf = String.valueOf(this.zzb.getLoggingLibraryName());
                throw new MlKitException(valueOf.length() != 0 ? "Failed to create text recognizer ".concat(valueOf) : new String("Failed to create text recognizer "), 13, e2);
            }
        }
    }

    public final void zzc() {
        zzlm zzlm = this.zze;
        if (zzlm != null) {
            try {
                zzlm.zzf();
            } catch (RemoteException e) {
                String valueOf = String.valueOf(this.zzb.getLoggingLibraryName());
                Log.e("DecoupledTextDelegate", valueOf.length() != 0 ? "Failed to release text recognizer ".concat(valueOf) : new String("Failed to release text recognizer "), e);
            }
            this.zze = null;
        }
        this.zzc = false;
    }
}
