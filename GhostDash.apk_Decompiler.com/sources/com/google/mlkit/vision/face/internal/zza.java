package com.google.mlkit.vision.face.internal;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_vision_face.zzis;
import com.google.android.gms.internal.mlkit_vision_face.zzla;
import com.google.android.gms.internal.mlkit_vision_face.zzlo;
import com.google.android.gms.internal.mlkit_vision_face.zzls;
import com.google.android.gms.internal.mlkit_vision_face.zzlu;
import com.google.android.gms.internal.mlkit_vision_face.zzlw;
import com.google.android.gms.internal.mlkit_vision_face.zzly;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.CommonConvertUtils;
import com.google.mlkit.vision.common.internal.ImageConvertUtils;
import com.google.mlkit.vision.common.internal.ImageUtils;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
final class zza implements zzb {
    private final Context zza;
    private final FaceDetectorOptions zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzla zzf;
    private zzlw zzg;
    private zzlw zzh;

    zza(Context context, FaceDetectorOptions faceDetectorOptions, zzla zzla) {
        this.zza = context;
        this.zzb = faceDetectorOptions;
        this.zzf = zzla;
    }

    static boolean zzc(Context context) {
        return DynamiteModule.getLocalVersion(context, "com.google.mlkit.dynamite.face") > 0;
    }

    private final void zzf() throws DynamiteModule.LoadingException, RemoteException {
        if (this.zzb.zzc() == 2) {
            if (this.zzg == null) {
                this.zzg = zzg(new zzls(this.zzb.zze(), 1, 1, 2, false, this.zzb.zza()));
            }
            if ((this.zzb.zzd() == 2 || this.zzb.zzb() == 2 || this.zzb.zze() == 2) && this.zzh == null) {
                this.zzh = zzg(new zzls(this.zzb.zze(), this.zzb.zzd(), this.zzb.zzb(), 1, this.zzb.zzg(), this.zzb.zza()));
            }
        } else if (this.zzh == null) {
            this.zzh = zzg(new zzls(this.zzb.zze(), this.zzb.zzd(), this.zzb.zzb(), 1, this.zzb.zzg(), this.zzb.zza()));
        }
    }

    private final zzlw zzg(zzls zzls) throws DynamiteModule.LoadingException, RemoteException {
        if (this.zzd) {
            return zze(DynamiteModule.PREFER_LOCAL, "com.google.mlkit.dynamite.face", "com.google.android.gms.vision.face.mlkit.FaceDetectorCreator", zzls);
        }
        return zze(DynamiteModule.PREFER_REMOTE, "com.google.android.gms.vision.face", "com.google.android.gms.vision.face.mlkit.FaceDetectorCreator", zzls);
    }

    private static List<Face> zzh(zzlw zzlw, InputImage inputImage) throws MlKitException {
        if (inputImage.getFormat() == -1) {
            inputImage = InputImage.fromByteBuffer(ImageConvertUtils.getInstance().convertToNv21Buffer(inputImage, false), inputImage.getWidth(), inputImage.getHeight(), inputImage.getRotationDegrees(), 17);
        }
        try {
            List<zzlu> zzd2 = zzlw.zzd(ImageUtils.getInstance().getImageDataWrapper(inputImage), new zzlo(inputImage.getFormat(), inputImage.getWidth(), inputImage.getHeight(), CommonConvertUtils.convertToMVRotation(inputImage.getRotationDegrees()), SystemClock.elapsedRealtime()));
            ArrayList arrayList = new ArrayList();
            for (zzlu face : zzd2) {
                arrayList.add(new Face(face));
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new MlKitException("Failed to run face detector.", 13, e);
        }
    }

    public final Pair<List<Face>, List<Face>> zza(InputImage inputImage) throws MlKitException {
        List<Face> list;
        if (this.zzh == null && this.zzg == null) {
            zzd();
        }
        if (!this.zzc) {
            try {
                zzlw zzlw = this.zzh;
                if (zzlw != null) {
                    zzlw.zze();
                }
                zzlw zzlw2 = this.zzg;
                if (zzlw2 != null) {
                    zzlw2.zze();
                }
                this.zzc = true;
            } catch (RemoteException e) {
                throw new MlKitException("Failed to init face detector.", 13, e);
            }
        }
        zzlw zzlw3 = this.zzh;
        List<Face> list2 = null;
        if (zzlw3 != null) {
            list = zzh(zzlw3, inputImage);
            if (!this.zzb.zzg()) {
                zzh.zzd(list);
            }
        } else {
            list = null;
        }
        zzlw zzlw4 = this.zzg;
        if (zzlw4 != null) {
            list2 = zzh(zzlw4, inputImage);
            zzh.zzd(list2);
        }
        return new Pair<>(list, list2);
    }

    public final void zzb() {
        try {
            zzlw zzlw = this.zzh;
            if (zzlw != null) {
                zzlw.zzf();
                this.zzh = null;
            }
            zzlw zzlw2 = this.zzg;
            if (zzlw2 != null) {
                zzlw2.zzf();
                this.zzg = null;
            }
        } catch (RemoteException e) {
            Log.e("DecoupledFaceDelegate", "Failed to release face detector.", e);
        }
        this.zzc = false;
    }

    public final boolean zzd() throws MlKitException {
        if (this.zzh != null || this.zzg != null) {
            return this.zzd;
        }
        if (DynamiteModule.getLocalVersion(this.zza, "com.google.mlkit.dynamite.face") > 0) {
            this.zzd = true;
            try {
                zzf();
            } catch (DynamiteModule.LoadingException e) {
                throw new MlKitException("Failed to load the bundled face module.", 13, e);
            } catch (RemoteException e2) {
                throw new MlKitException("Failed to create thick face detector.", 13, e2);
            }
        } else {
            this.zzd = false;
            try {
                zzf();
            } catch (DynamiteModule.LoadingException unused) {
                if (!this.zze) {
                    OptionalModuleUtils.requestDownload(this.zza, OptionalModuleUtils.FACE);
                    this.zze = true;
                }
                zzj.zzc(this.zzf, this.zzd, zzis.OPTIONAL_MODULE_NOT_AVAILABLE);
                throw new MlKitException("Waiting for the face module to be downloaded. Please wait.", 14);
            } catch (RemoteException e3) {
                zzj.zzc(this.zzf, this.zzd, zzis.OPTIONAL_MODULE_INIT_ERROR);
                throw new MlKitException("Failed to create thin face detector.", 13, e3);
            }
        }
        zzj.zzc(this.zzf, this.zzd, zzis.NO_ERROR);
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final zzlw zze(DynamiteModule.VersionPolicy versionPolicy, String str, String str2, zzls zzls) throws DynamiteModule.LoadingException, RemoteException {
        return zzly.zza(DynamiteModule.load(this.zza, versionPolicy, str).instantiate("com.google.android.gms.vision.face.mlkit.FaceDetectorCreator")).zzd(ObjectWrapper.wrap(this.zza), zzls);
    }
}
