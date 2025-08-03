package com.google.mlkit.vision.text.internal;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.mlkit_vision_text.zzf;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
final class zza {
    static Rect zza(List<Point> list) {
        int i = Integer.MIN_VALUE;
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        for (Point next : list) {
            i2 = Math.min(i2, next.x);
            i = Math.max(i, next.x);
            i3 = Math.min(i3, next.y);
            i4 = Math.max(i4, next.y);
        }
        return new Rect(i2, i3, i, i4);
    }

    static List<Point> zzb(zzf zzf) {
        Point[] pointArr = new Point[4];
        double sin = Math.sin(Math.toRadians((double) zzf.zze));
        double cos = Math.cos(Math.toRadians((double) zzf.zze));
        pointArr[0] = new Point(zzf.zza, zzf.zzb);
        int i = zzf.zza;
        double d = (double) zzf.zzc;
        Point point = new Point((int) (((double) i) + (d * cos)), (int) (((double) zzf.zzb) + (d * sin)));
        pointArr[1] = point;
        pointArr[2] = new Point((int) (((double) point.x) - (((double) zzf.zzd) * sin)), (int) (((double) pointArr[1].y) + (((double) zzf.zzd) * cos)));
        pointArr[3] = new Point(pointArr[0].x + (pointArr[2].x - pointArr[1].x), pointArr[0].y + (pointArr[2].y - pointArr[1].y));
        return Arrays.asList(pointArr);
    }
}
