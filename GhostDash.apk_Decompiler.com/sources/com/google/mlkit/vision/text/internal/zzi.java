package com.google.mlkit.vision.text.internal;

import android.graphics.Point;
import android.util.SparseArray;
import com.google.android.gms.internal.mlkit_vision_text.zzab;
import com.google.android.gms.internal.mlkit_vision_text.zzbi;
import com.google.android.gms.internal.mlkit_vision_text.zzbl;
import com.google.android.gms.internal.mlkit_vision_text.zzbs;
import com.google.android.gms.internal.mlkit_vision_text.zzci;
import com.google.android.gms.internal.mlkit_vision_text.zzf;
import com.google.android.gms.internal.mlkit_vision_text.zzl;
import com.google.android.gms.internal.mlkit_vision_text.zzv;
import com.google.mlkit.vision.text.Text;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
final class zzi {
    static final zzv zza = zzv.zza(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
    private static final Comparator<Map.Entry<String, Integer>> zzb = zzh.zza;

    static Text zza(zzl[] zzlArr) {
        SparseArray sparseArray = new SparseArray();
        int i = 0;
        for (zzl zzl : zzlArr) {
            SparseArray sparseArray2 = (SparseArray) sparseArray.get(zzl.zzj);
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                sparseArray.append(zzl.zzj, sparseArray2);
            }
            sparseArray2.append(zzl.zzk, zzl);
        }
        zzbi zzg = zzbl.zzg();
        int i2 = 0;
        while (i2 < sparseArray.size()) {
            SparseArray sparseArray3 = (SparseArray) sparseArray.valueAt(i2);
            zzbi zzg2 = zzbl.zzg();
            for (int i3 = i; i3 < sparseArray3.size(); i3++) {
                zzg2.zzb((zzl) sparseArray3.valueAt(i3));
            }
            zzbl zzc = zzg2.zzc();
            List zza2 = zzbs.zza(zzc, zzd.zza);
            zzf zzf = ((zzl) zzc.get(i)).zzb;
            zzci zzj = zzc.listIterator(i);
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MIN_VALUE;
            while (zzj.hasNext()) {
                zzf zzf2 = ((zzl) zzj.next()).zzb;
                int i8 = zzf.zza;
                int i9 = zzf.zzb;
                zzci zzci = zzj;
                double sin = Math.sin(Math.toRadians((double) zzf.zze));
                double cos = Math.cos(Math.toRadians((double) zzf.zze));
                SparseArray sparseArray4 = sparseArray;
                int i10 = i2;
                Point[] pointArr = new Point[4];
                zzbi zzbi = zzg;
                List list = zza2;
                Point point = new Point(zzf2.zza, zzf2.zzb);
                pointArr[0] = point;
                point.offset(-i8, -i9);
                int i11 = (int) ((((double) pointArr[0].x) * cos) + (((double) pointArr[0].y) * sin));
                int i12 = (int) ((((double) (-pointArr[0].x)) * sin) + (((double) pointArr[0].y) * cos));
                pointArr[0].x = i11;
                pointArr[0].y = i12;
                pointArr[1] = new Point(zzf2.zzc + i11, i12);
                pointArr[2] = new Point(zzf2.zzc + i11, zzf2.zzd + i12);
                pointArr[3] = new Point(i11, i12 + zzf2.zzd);
                for (int i13 = 0; i13 < 4; i13++) {
                    Point point2 = pointArr[i13];
                    i5 = Math.min(i5, point2.x);
                    i4 = Math.max(i4, point2.x);
                    i6 = Math.min(i6, point2.y);
                    i7 = Math.max(i7, point2.y);
                }
                zzj = zzci;
                sparseArray = sparseArray4;
                i2 = i10;
                zzg = zzbi;
                zza2 = list;
            }
            zzbi zzbi2 = zzg;
            SparseArray sparseArray5 = sparseArray;
            int i14 = i2;
            List list2 = zza2;
            int i15 = zzf.zza;
            int i16 = zzf.zzb;
            double sin2 = Math.sin(Math.toRadians((double) zzf.zze));
            double cos2 = Math.cos(Math.toRadians((double) zzf.zze));
            Point[] pointArr2 = {new Point(i5, i6), new Point(i4, i6), new Point(i4, i7), new Point(i5, i7)};
            int i17 = 0;
            for (int i18 = 4; i17 < i18; i18 = 4) {
                int i19 = pointArr2[i17].x;
                int i20 = pointArr2[i17].y;
                int i21 = pointArr2[i17].x;
                int i22 = pointArr2[i17].y;
                pointArr2[i17].x = (int) ((((double) i19) * cos2) - (((double) i20) * sin2));
                pointArr2[i17].y = (int) ((((double) i21) * sin2) + (((double) i22) * cos2));
                pointArr2[i17].offset(i15, i16);
                i17++;
            }
            List asList = Arrays.asList(pointArr2);
            List list3 = list2;
            zzbi zzbi3 = zzbi2;
            zzbi3.zzb(new Text.TextBlock(zza.zzb(zzbs.zza(list3, zzf.zza)), zza.zza(asList), asList, zzb(list3), list3));
            i2 = i14 + 1;
            zzg = zzbi3;
            sparseArray = sparseArray5;
            i = 0;
        }
        zzbl zzc2 = zzg.zzc();
        return new Text(zza.zzb(zzbs.zza(zzc2, zzg.zza)), zzc2);
    }

    private static String zzb(List<Text.Line> list) {
        HashMap hashMap = new HashMap();
        for (Text.Line recognizedLanguage : list) {
            String recognizedLanguage2 = recognizedLanguage.getRecognizedLanguage();
            hashMap.put(recognizedLanguage2, Integer.valueOf((hashMap.containsKey(recognizedLanguage2) ? ((Integer) hashMap.get(recognizedLanguage2)).intValue() : 0) + 1));
        }
        Set entrySet = hashMap.entrySet();
        if (entrySet.isEmpty()) {
            return "und";
        }
        String str = (String) ((Map.Entry) Collections.max(entrySet, zzb)).getKey();
        if (zzab.zzb(str)) {
            return "und";
        }
        return str;
    }
}
