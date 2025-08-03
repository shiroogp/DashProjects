package com.google.mlkit.vision.face;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.gms.internal.mlkit_vision_face.zzd;
import com.google.android.gms.internal.mlkit_vision_face.zzf;
import com.google.android.gms.internal.mlkit_vision_face.zzlq;
import com.google.android.gms.internal.mlkit_vision_face.zzlu;
import com.google.android.gms.internal.mlkit_vision_face.zzma;
import com.google.android.gms.internal.mlkit_vision_face.zzn;
import com.google.android.gms.internal.mlkit_vision_face.zzv;
import com.google.android.gms.internal.mlkit_vision_face.zzw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public class Face {
    private final Rect zza;
    private int zzb;
    private final float zzc;
    private final float zzd;
    private final float zze;
    private final float zzf;
    private final float zzg;
    private final float zzh;
    private final SparseArray<FaceLandmark> zzi = new SparseArray<>();
    private final SparseArray<FaceContour> zzj = new SparseArray<>();

    public Face(zzf zzf2) {
        float f = zzf2.zzc;
        float f2 = zzf2.zze / 2.0f;
        float f3 = zzf2.zzd;
        float f4 = zzf2.zzf / 2.0f;
        this.zza = new Rect((int) (f - f2), (int) (f3 - f4), (int) (f + f2), (int) (f3 + f4));
        this.zzb = zzf2.zzb;
        for (zzn zzn : zzf2.zzj) {
            if (zze(zzn.zzd)) {
                SparseArray<FaceLandmark> sparseArray = this.zzi;
                int i = zzn.zzd;
                sparseArray.put(i, new FaceLandmark(i, new PointF(zzn.zzb, zzn.zzc)));
            }
        }
        for (zzd zzd2 : zzf2.zzn) {
            int i2 = zzd2.zzb;
            if (zzd(i2)) {
                SparseArray<FaceContour> sparseArray2 = this.zzj;
                PointF[] pointFArr = zzd2.zza;
                Objects.requireNonNull(pointFArr);
                int length = pointFArr.length;
                long j = ((long) length) + 5 + ((long) (length / 10));
                ArrayList arrayList = new ArrayList(j > 2147483647L ? Integer.MAX_VALUE : (int) j);
                Collections.addAll(arrayList, pointFArr);
                sparseArray2.put(i2, new FaceContour(i2, arrayList));
            }
        }
        this.zzf = zzf2.zzi;
        this.zzg = zzf2.zzg;
        this.zzh = zzf2.zzh;
        this.zze = zzf2.zzm;
        this.zzd = zzf2.zzk;
        this.zzc = zzf2.zzl;
    }

    private static boolean zzd(int i) {
        return i <= 15 && i > 0;
    }

    private static boolean zze(int i) {
        return i == 0 || i == 1 || i == 7 || i == 3 || i == 9 || i == 4 || i == 10 || i == 5 || i == 11 || i == 6;
    }

    public List<FaceContour> getAllContours() {
        ArrayList arrayList = new ArrayList();
        int size = this.zzj.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.zzj.valueAt(i));
        }
        return arrayList;
    }

    public List<FaceLandmark> getAllLandmarks() {
        ArrayList arrayList = new ArrayList();
        int size = this.zzi.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.zzi.valueAt(i));
        }
        return arrayList;
    }

    public Rect getBoundingBox() {
        return this.zza;
    }

    public FaceContour getContour(int i) {
        return this.zzj.get(i);
    }

    public float getHeadEulerAngleX() {
        return this.zzf;
    }

    public float getHeadEulerAngleY() {
        return this.zzg;
    }

    public float getHeadEulerAngleZ() {
        return this.zzh;
    }

    public FaceLandmark getLandmark(int i) {
        return this.zzi.get(i);
    }

    public Float getLeftEyeOpenProbability() {
        float f = this.zze;
        if (f < 0.0f || f > 1.0f) {
            return null;
        }
        return Float.valueOf(this.zzd);
    }

    public Float getRightEyeOpenProbability() {
        float f = this.zzc;
        if (f < 0.0f || f > 1.0f) {
            return null;
        }
        return Float.valueOf(f);
    }

    public Float getSmilingProbability() {
        float f = this.zze;
        if (f < 0.0f || f > 1.0f) {
            return null;
        }
        return Float.valueOf(f);
    }

    public Integer getTrackingId() {
        int i = this.zzb;
        if (i == -1) {
            return null;
        }
        return Integer.valueOf(i);
    }

    public String toString() {
        zzv zza2 = zzw.zza("Face");
        zza2.zzc("boundingBox", this.zza);
        zza2.zzb("trackingId", this.zzb);
        zza2.zza("rightEyeOpenProbability", this.zzc);
        zza2.zza("leftEyeOpenProbability", this.zzd);
        zza2.zza("smileProbability", this.zze);
        zza2.zza("eulerX", this.zzf);
        zza2.zza("eulerY", this.zzg);
        zza2.zza("eulerZ", this.zzh);
        zzv zza3 = zzw.zza("Landmarks");
        for (int i = 0; i <= 11; i++) {
            if (zze(i)) {
                StringBuilder sb = new StringBuilder(20);
                sb.append("landmark_");
                sb.append(i);
                zza3.zzc(sb.toString(), getLandmark(i));
            }
        }
        zza2.zzc("landmarks", zza3.toString());
        zzv zza4 = zzw.zza("Contours");
        for (int i2 = 1; i2 <= 15; i2++) {
            StringBuilder sb2 = new StringBuilder(19);
            sb2.append("Contour_");
            sb2.append(i2);
            zza4.zzc(sb2.toString(), getContour(i2));
        }
        zza2.zzc("contours", zza4.toString());
        return zza2.toString();
    }

    public final SparseArray<FaceContour> zza() {
        return this.zzj;
    }

    public final void zzb(SparseArray<FaceContour> sparseArray) {
        this.zzj.clear();
        for (int i = 0; i < sparseArray.size(); i++) {
            this.zzj.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
        }
    }

    public final void zzc(int i) {
        this.zzb = -1;
    }

    public Face(zzlu zzlu) {
        this.zza = zzlu.zzh();
        this.zzb = zzlu.zzg();
        for (zzma next : zzlu.zzj()) {
            if (zze(next.zza())) {
                this.zzi.put(next.zza(), new FaceLandmark(next.zza(), next.zzb()));
            }
        }
        for (zzlq next2 : zzlu.zzi()) {
            int zza2 = next2.zza();
            if (zzd(zza2)) {
                this.zzj.put(zza2, new FaceContour(zza2, next2.zzb()));
            }
        }
        this.zzf = zzlu.zzf();
        this.zzg = zzlu.zzb();
        this.zzh = -zzlu.zzd();
        this.zze = zzlu.zze();
        this.zzd = zzlu.zza();
        this.zzc = zzlu.zzc();
    }
}
