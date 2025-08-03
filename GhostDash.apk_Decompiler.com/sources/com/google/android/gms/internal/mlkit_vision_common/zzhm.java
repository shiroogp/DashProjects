package com.google.android.gms.internal.mlkit_vision_common;

import android.os.Build;
import android.os.SystemClock;
import com.yalantis.ucrop.view.CropImageView;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
public class zzhm implements Closeable {
    private static final Map<String, zzhm> zza = new HashMap();
    private final String zzb;
    private int zzc;
    private double zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private long zzh;

    private zzhm(String str) {
        this.zzg = 2147483647L;
        this.zzh = -2147483648L;
        this.zzb = str;
    }

    private final void zza() {
        this.zzc = 0;
        this.zzd = 0.0d;
        this.zze = 0;
        this.zzg = 2147483647L;
        this.zzh = -2147483648L;
    }

    public static long zze() {
        if (Build.VERSION.SDK_INT >= 17) {
            return SystemClock.elapsedRealtimeNanos() / 1000;
        }
        return SystemClock.elapsedRealtime() * 1000;
    }

    public static zzhm zzf(String str) {
        zzik.zza();
        if (!zzik.zzb()) {
            return zzhl.zza;
        }
        Map<String, zzhm> map = zza;
        if (map.get("detectorTaskWithResource#run") == null) {
            map.put("detectorTaskWithResource#run", new zzhm("detectorTaskWithResource#run"));
        }
        return map.get("detectorTaskWithResource#run");
    }

    public void close() {
        long j = this.zze;
        if (j != 0) {
            zzd(j);
            return;
        }
        throw new IllegalStateException("Did you forget to call start()?");
    }

    public zzhm zzb() {
        this.zze = zze();
        return this;
    }

    public void zzc(long j) {
        long zze2 = zze();
        long j2 = this.zzf;
        if (j2 != 0 && zze2 - j2 >= 1000000) {
            zza();
        }
        this.zzf = zze2;
        this.zzc++;
        this.zzd += (double) j;
        this.zzg = Math.min(this.zzg, j);
        this.zzh = Math.max(this.zzh, j);
        if (this.zzc % 50 == 0) {
            String.format(Locale.US, "[%s] cur=%dus, counts=%d, min=%dus, max=%dus, avg=%dus", new Object[]{this.zzb, Long.valueOf(j), Integer.valueOf(this.zzc), Long.valueOf(this.zzg), Long.valueOf(this.zzh), Integer.valueOf((int) (this.zzd / ((double) this.zzc)))});
            zzik.zza();
        }
        if (this.zzc % CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION == 0) {
            zza();
        }
    }

    public void zzd(long j) {
        zzc(zze() - j);
    }
}
