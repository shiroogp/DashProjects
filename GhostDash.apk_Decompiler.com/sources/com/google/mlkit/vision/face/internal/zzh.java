package com.google.mlkit.vision.face.internal;

import android.os.SystemClock;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_face.zzda;
import com.google.android.gms.internal.mlkit_vision_face.zzdb;
import com.google.android.gms.internal.mlkit_vision_face.zzdc;
import com.google.android.gms.internal.mlkit_vision_face.zzhw;
import com.google.android.gms.internal.mlkit_vision_face.zzig;
import com.google.android.gms.internal.mlkit_vision_face.zzih;
import com.google.android.gms.internal.mlkit_vision_face.zzil;
import com.google.android.gms.internal.mlkit_vision_face.zzis;
import com.google.android.gms.internal.mlkit_vision_face.zzit;
import com.google.android.gms.internal.mlkit_vision_face.zziv;
import com.google.android.gms.internal.mlkit_vision_face.zzjh;
import com.google.android.gms.internal.mlkit_vision_face.zzji;
import com.google.android.gms.internal.mlkit_vision_face.zzla;
import com.google.android.gms.internal.mlkit_vision_face.zzlc;
import com.google.android.gms.internal.mlkit_vision_face.zzld;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.BitmapInStreamingChecker;
import com.google.mlkit.vision.common.internal.ImageUtils;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final class zzh extends MLTask<List<Face>, InputImage> {
    static final AtomicBoolean zza = new AtomicBoolean(true);
    private static final ImageUtils zzb = ImageUtils.getInstance();
    private final FaceDetectorOptions zzc;
    private final zzla zzd;
    private final zzlc zze;
    private final zzb zzf;
    private boolean zzg;
    private final BitmapInStreamingChecker zzh = new BitmapInStreamingChecker();

    public zzh(zzla zzla, FaceDetectorOptions faceDetectorOptions, zzb zzb2) {
        Preconditions.checkNotNull(faceDetectorOptions, "FaceDetectorOptions can not be null");
        this.zzc = faceDetectorOptions;
        this.zzd = zzla;
        this.zzf = zzb2;
        this.zze = zzlc.zza(MlKitContext.getInstance().getApplicationContext());
    }

    static void zzd(List<Face> list) {
        for (Face zzc2 : list) {
            zzc2.zzc(-1);
        }
    }

    private final synchronized void zzg(zzis zzis, long j, InputImage inputImage, int i, int i2) {
        synchronized (this) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - j;
            this.zzd.zzb(new zzg(this, elapsedRealtime, zzis, i, i2, inputImage), zzit.ON_DEVICE_FACE_DETECT);
            zzdb zzdb = new zzdb();
            zzdb.zzc(zzis);
            zzdb.zzd(Boolean.valueOf(zza.get()));
            zzdb.zza(Integer.valueOf(i));
            zzdb.zze(Integer.valueOf(i2));
            zzdb.zzb(zzj.zza(this.zzc));
            this.zzd.zzf(zzdb.zzf(), elapsedRealtime, zzit.AGGREGATED_ON_DEVICE_FACE_DETECTION, new zzf(this));
            long currentTimeMillis = System.currentTimeMillis();
            this.zze.zzc(true != this.zzg ? 24303 : 24304, zzis.zza(), currentTimeMillis - elapsedRealtime, currentTimeMillis);
        }
    }

    public final synchronized void load() throws MlKitException {
        this.zzg = this.zzf.zzd();
    }

    public final synchronized void release() {
        this.zzf.zzb();
        zza.set(true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0108 A[Catch:{ MlKitException -> 0x0129 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x010a A[Catch:{ MlKitException -> 0x0129 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0111 A[Catch:{ MlKitException -> 0x0129 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0113 A[Catch:{ MlKitException -> 0x0129 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0139  */
    /* renamed from: zzc */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<com.google.mlkit.vision.face.Face> run(com.google.mlkit.vision.common.InputImage r21) throws com.google.mlkit.common.MlKitException {
        /*
            r20 = this;
            r8 = r20
            r9 = r21
            monitor-enter(r20)
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0148 }
            com.google.mlkit.vision.common.internal.BitmapInStreamingChecker r0 = r8.zzh     // Catch:{ all -> 0x0148 }
            r0.check(r9)     // Catch:{ all -> 0x0148 }
            com.google.mlkit.vision.face.internal.zzb r0 = r8.zzf     // Catch:{ MlKitException -> 0x012b }
            android.util.Pair r0 = r0.zza(r9)     // Catch:{ MlKitException -> 0x012b }
            java.lang.Object r1 = r0.first     // Catch:{ MlKitException -> 0x012b }
            java.util.List r1 = (java.util.List) r1     // Catch:{ MlKitException -> 0x012b }
            java.lang.Object r0 = r0.second     // Catch:{ MlKitException -> 0x012b }
            java.util.List r0 = (java.util.List) r0     // Catch:{ MlKitException -> 0x012b }
            if (r1 != 0) goto L_0x002b
            if (r0 == 0) goto L_0x0021
            goto L_0x002b
        L_0x0021:
            com.google.mlkit.common.MlKitException r0 = new com.google.mlkit.common.MlKitException     // Catch:{ MlKitException -> 0x012b }
            java.lang.String r1 = "No detector is enabled"
            r2 = 13
            r0.<init>(r1, r2)     // Catch:{ MlKitException -> 0x012b }
            throw r0     // Catch:{ MlKitException -> 0x012b }
        L_0x002b:
            if (r1 != 0) goto L_0x0038
            java.lang.Object r2 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ MlKitException -> 0x012b }
            java.util.List r2 = (java.util.List) r2     // Catch:{ MlKitException -> 0x012b }
        L_0x0033:
            r9 = r2
            r18 = r10
            goto L_0x0104
        L_0x0038:
            if (r0 != 0) goto L_0x0041
            java.lang.Object r2 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)     // Catch:{ MlKitException -> 0x012b }
            java.util.List r2 = (java.util.List) r2     // Catch:{ MlKitException -> 0x012b }
            goto L_0x0033
        L_0x0041:
            java.util.HashSet r2 = new java.util.HashSet     // Catch:{ MlKitException -> 0x012b }
            r2.<init>()     // Catch:{ MlKitException -> 0x012b }
            java.util.Iterator r3 = r0.iterator()     // Catch:{ MlKitException -> 0x012b }
        L_0x004a:
            boolean r4 = r3.hasNext()     // Catch:{ MlKitException -> 0x012b }
            if (r4 == 0) goto L_0x00fc
            java.lang.Object r4 = r3.next()     // Catch:{ MlKitException -> 0x012b }
            com.google.mlkit.vision.face.Face r4 = (com.google.mlkit.vision.face.Face) r4     // Catch:{ MlKitException -> 0x012b }
            java.util.Iterator r5 = r1.iterator()     // Catch:{ MlKitException -> 0x012b }
            r6 = 0
        L_0x005b:
            boolean r7 = r5.hasNext()     // Catch:{ MlKitException -> 0x012b }
            if (r7 == 0) goto L_0x00eb
            java.lang.Object r7 = r5.next()     // Catch:{ MlKitException -> 0x012b }
            com.google.mlkit.vision.face.Face r7 = (com.google.mlkit.vision.face.Face) r7     // Catch:{ MlKitException -> 0x012b }
            android.graphics.Rect r13 = r4.getBoundingBox()     // Catch:{ MlKitException -> 0x012b }
            if (r13 == 0) goto L_0x00d8
            android.graphics.Rect r13 = r7.getBoundingBox()     // Catch:{ MlKitException -> 0x012b }
            if (r13 == 0) goto L_0x00d8
            android.graphics.Rect r13 = r4.getBoundingBox()     // Catch:{ MlKitException -> 0x012b }
            android.graphics.Rect r14 = r7.getBoundingBox()     // Catch:{ MlKitException -> 0x012b }
            boolean r15 = r13.intersect(r14)     // Catch:{ MlKitException -> 0x012b }
            if (r15 == 0) goto L_0x00d8
            int r15 = r13.right     // Catch:{ MlKitException -> 0x012b }
            int r12 = r14.right     // Catch:{ MlKitException -> 0x012b }
            int r12 = java.lang.Math.min(r15, r12)     // Catch:{ MlKitException -> 0x012b }
            int r15 = r13.left     // Catch:{ MlKitException -> 0x012b }
            r16 = r3
            int r3 = r14.left     // Catch:{ MlKitException -> 0x012b }
            int r3 = java.lang.Math.max(r15, r3)     // Catch:{ MlKitException -> 0x012b }
            int r12 = r12 - r3
            int r3 = r13.bottom     // Catch:{ MlKitException -> 0x012b }
            int r15 = r14.bottom     // Catch:{ MlKitException -> 0x012b }
            int r3 = java.lang.Math.min(r3, r15)     // Catch:{ MlKitException -> 0x012b }
            int r15 = r13.top     // Catch:{ MlKitException -> 0x012b }
            r17 = r5
            int r5 = r14.top     // Catch:{ MlKitException -> 0x012b }
            int r5 = java.lang.Math.max(r15, r5)     // Catch:{ MlKitException -> 0x012b }
            int r3 = r3 - r5
            int r12 = r12 * r3
            r18 = r10
            double r9 = (double) r12
            int r3 = r13.right     // Catch:{ MlKitException -> 0x0129 }
            int r5 = r13.left     // Catch:{ MlKitException -> 0x0129 }
            int r3 = r3 - r5
            int r5 = r13.bottom     // Catch:{ MlKitException -> 0x0129 }
            int r11 = r13.top     // Catch:{ MlKitException -> 0x0129 }
            int r5 = r5 - r11
            int r3 = r3 * r5
            double r11 = (double) r3     // Catch:{ MlKitException -> 0x0129 }
            int r3 = r14.right     // Catch:{ MlKitException -> 0x0129 }
            int r5 = r14.left     // Catch:{ MlKitException -> 0x0129 }
            int r3 = r3 - r5
            int r5 = r14.bottom     // Catch:{ MlKitException -> 0x0129 }
            int r13 = r14.top     // Catch:{ MlKitException -> 0x0129 }
            int r5 = r5 - r13
            int r3 = r3 * r5
            double r13 = (double) r3     // Catch:{ MlKitException -> 0x0129 }
            double r11 = r11 + r13
            double r11 = r11 - r9
            double r9 = r9 / r11
            r11 = 4603579539098121011(0x3fe3333333333333, double:0.6)
            int r3 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r3 <= 0) goto L_0x00de
            android.util.SparseArray r3 = r4.zza()     // Catch:{ MlKitException -> 0x0129 }
            r7.zzb(r3)     // Catch:{ MlKitException -> 0x0129 }
            r6 = 1
            goto L_0x00de
        L_0x00d8:
            r16 = r3
            r17 = r5
            r18 = r10
        L_0x00de:
            r2.add(r7)     // Catch:{ MlKitException -> 0x0129 }
            r9 = r21
            r3 = r16
            r5 = r17
            r10 = r18
            goto L_0x005b
        L_0x00eb:
            r16 = r3
            r18 = r10
            if (r6 != 0) goto L_0x00f4
            r2.add(r4)     // Catch:{ MlKitException -> 0x0129 }
        L_0x00f4:
            r9 = r21
            r3 = r16
            r10 = r18
            goto L_0x004a
        L_0x00fc:
            r18 = r10
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ MlKitException -> 0x0129 }
            r3.<init>(r2)     // Catch:{ MlKitException -> 0x0129 }
            r9 = r3
        L_0x0104:
            com.google.android.gms.internal.mlkit_vision_face.zzis r2 = com.google.android.gms.internal.mlkit_vision_face.zzis.NO_ERROR     // Catch:{ MlKitException -> 0x0129 }
            if (r0 != 0) goto L_0x010a
            r6 = 0
            goto L_0x010f
        L_0x010a:
            int r0 = r0.size()     // Catch:{ MlKitException -> 0x0129 }
            r6 = r0
        L_0x010f:
            if (r1 != 0) goto L_0x0113
            r7 = 0
            goto L_0x0118
        L_0x0113:
            int r0 = r1.size()     // Catch:{ MlKitException -> 0x0129 }
            r7 = r0
        L_0x0118:
            r1 = r20
            r3 = r18
            r5 = r21
            r1.zzg(r2, r3, r5, r6, r7)     // Catch:{ MlKitException -> 0x0129 }
            java.util.concurrent.atomic.AtomicBoolean r0 = zza     // Catch:{ MlKitException -> 0x0129 }
            r1 = 0
            r0.set(r1)     // Catch:{ MlKitException -> 0x0129 }
            monitor-exit(r20)
            return r9
        L_0x0129:
            r0 = move-exception
            goto L_0x012e
        L_0x012b:
            r0 = move-exception
            r18 = r10
        L_0x012e:
            int r1 = r0.getErrorCode()     // Catch:{ all -> 0x0148 }
            r2 = 14
            if (r1 != r2) goto L_0x0139
            com.google.android.gms.internal.mlkit_vision_face.zzis r1 = com.google.android.gms.internal.mlkit_vision_face.zzis.MODEL_NOT_DOWNLOADED     // Catch:{ all -> 0x0148 }
            goto L_0x013b
        L_0x0139:
            com.google.android.gms.internal.mlkit_vision_face.zzis r1 = com.google.android.gms.internal.mlkit_vision_face.zzis.UNKNOWN_ERROR     // Catch:{ all -> 0x0148 }
        L_0x013b:
            r2 = r1
            r6 = 0
            r7 = 0
            r1 = r20
            r3 = r18
            r5 = r21
            r1.zzg(r2, r3, r5, r6, r7)     // Catch:{ all -> 0x0148 }
            throw r0     // Catch:{ all -> 0x0148 }
        L_0x0148:
            r0 = move-exception
            monitor-exit(r20)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.face.internal.zzh.run(com.google.mlkit.vision.common.InputImage):java.util.List");
    }

    public final /* synthetic */ zzld zze(long j, zzis zzis, int i, int i2, InputImage inputImage) {
        zzih zzih;
        zzjh zzjh = new zzjh();
        zzil zzil = new zzil();
        zzil.zzc(Long.valueOf(j));
        zzil.zzd(zzis);
        zzil.zze(Boolean.valueOf(zza.get()));
        zzil.zza(true);
        zzil.zzb(true);
        zzjh.zzg(zzil.zzf());
        zzjh.zze(zzj.zza(this.zzc));
        zzjh.zzd(Integer.valueOf(i));
        zzjh.zzh(Integer.valueOf(i2));
        ImageUtils imageUtils = zzb;
        int mobileVisionImageFormat = imageUtils.getMobileVisionImageFormat(inputImage);
        int mobileVisionImageSize = imageUtils.getMobileVisionImageSize(inputImage);
        zzig zzig = new zzig();
        if (mobileVisionImageFormat == -1) {
            zzih = zzih.BITMAP;
        } else if (mobileVisionImageFormat == 35) {
            zzih = zzih.YUV_420_888;
        } else if (mobileVisionImageFormat == 842094169) {
            zzih = zzih.YV12;
        } else if (mobileVisionImageFormat == 16) {
            zzih = zzih.NV16;
        } else if (mobileVisionImageFormat != 17) {
            zzih = zzih.UNKNOWN_FORMAT;
        } else {
            zzih = zzih.NV21;
        }
        zzig.zza(zzih);
        zzig.zzb(Integer.valueOf(mobileVisionImageSize));
        zzjh.zzf(zzig.zzd());
        zzji zzi = zzjh.zzi();
        zziv zziv = new zziv();
        zziv.zze(Boolean.valueOf(this.zzg));
        zziv.zzf(zzi);
        return zzld.zzd(zziv);
    }

    public final /* synthetic */ zzld zzf(zzdc zzdc, int i, zzhw zzhw) {
        zziv zziv = new zziv();
        zziv.zze(Boolean.valueOf(this.zzg));
        zzda zzda = new zzda();
        zzda.zza(Integer.valueOf(i));
        zzda.zzc(zzdc);
        zzda.zzb(zzhw);
        zziv.zzc(zzda.zze());
        return zzld.zzd(zziv);
    }
}
