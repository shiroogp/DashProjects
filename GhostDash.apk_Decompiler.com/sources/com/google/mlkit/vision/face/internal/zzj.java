package com.google.mlkit.vision.face.internal;

import com.google.android.gms.internal.mlkit_vision_face.zzhz;
import com.google.android.gms.internal.mlkit_vision_face.zzia;
import com.google.android.gms.internal.mlkit_vision_face.zzib;
import com.google.android.gms.internal.mlkit_vision_face.zzic;
import com.google.android.gms.internal.mlkit_vision_face.zzid;
import com.google.android.gms.internal.mlkit_vision_face.zzie;
import com.google.android.gms.internal.mlkit_vision_face.zzis;
import com.google.android.gms.internal.mlkit_vision_face.zzit;
import com.google.android.gms.internal.mlkit_vision_face.zzla;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final class zzj {
    static final AtomicReference<String> zza = new AtomicReference<>();

    public static zzie zza(FaceDetectorOptions faceDetectorOptions) {
        zzic zzic;
        zzia zzia;
        zzid zzid;
        zzib zzib;
        zzhz zzhz = new zzhz();
        int zzd = faceDetectorOptions.zzd();
        if (zzd == 1) {
            zzic = zzic.NO_LANDMARKS;
        } else if (zzd != 2) {
            zzic = zzic.UNKNOWN_LANDMARKS;
        } else {
            zzic = zzic.ALL_LANDMARKS;
        }
        zzhz.zzd(zzic);
        int zzb = faceDetectorOptions.zzb();
        if (zzb == 1) {
            zzia = zzia.NO_CLASSIFICATIONS;
        } else if (zzb != 2) {
            zzia = zzia.UNKNOWN_CLASSIFICATIONS;
        } else {
            zzia = zzia.ALL_CLASSIFICATIONS;
        }
        zzhz.zza(zzia);
        int zze = faceDetectorOptions.zze();
        if (zze == 1) {
            zzid = zzid.FAST;
        } else if (zze != 2) {
            zzid = zzid.UNKNOWN_PERFORMANCE;
        } else {
            zzid = zzid.ACCURATE;
        }
        zzhz.zzf(zzid);
        int zzc = faceDetectorOptions.zzc();
        if (zzc == 1) {
            zzib = zzib.NO_CONTOURS;
        } else if (zzc != 2) {
            zzib = zzib.UNKNOWN_CONTOURS;
        } else {
            zzib = zzib.ALL_CONTOURS;
        }
        zzhz.zzb(zzib);
        zzhz.zzc(Boolean.valueOf(faceDetectorOptions.zzg()));
        zzhz.zze(Float.valueOf(faceDetectorOptions.zza()));
        return zzhz.zzk();
    }

    public static String zzb() {
        AtomicReference<String> atomicReference = zza;
        if (atomicReference.get() != null) {
            return atomicReference.get();
        }
        String str = true != zza.zzc(MlKitContext.getInstance().getApplicationContext()) ? "play-services-mlkit-face-detection" : "face-detection";
        atomicReference.set(str);
        return str;
    }

    public static void zzc(zzla zzla, boolean z, zzis zzis) {
        zzla.zzb(new zzi(z, zzis), zzit.ON_DEVICE_FACE_LOAD);
    }
}
