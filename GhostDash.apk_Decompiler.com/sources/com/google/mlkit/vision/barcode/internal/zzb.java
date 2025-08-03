package com.google.mlkit.vision.barcode.internal;

import android.util.SparseArray;
import com.google.android.gms.internal.mlkit_vision_barcode.zzby;
import com.google.android.gms.internal.mlkit_vision_barcode.zzjb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzjc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzjo;
import com.google.android.gms.internal.mlkit_vision_barcode.zzjp;
import com.google.android.gms.internal.mlkit_vision_barcode.zzky;
import com.google.android.gms.internal.mlkit_vision_barcode.zzla;
import com.google.android.gms.internal.mlkit_vision_barcode.zzlb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzlo;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final class zzb {
    static final AtomicReference<String> zza = new AtomicReference<>();
    private static final SparseArray<zzjo> zzb;
    private static final SparseArray<zzjp> zzc;
    private static final Map<Integer, zzky> zzd;

    static {
        SparseArray<zzjo> sparseArray = new SparseArray<>();
        zzb = sparseArray;
        SparseArray<zzjp> sparseArray2 = new SparseArray<>();
        zzc = sparseArray2;
        sparseArray.put(-1, zzjo.FORMAT_UNKNOWN);
        sparseArray.put(1, zzjo.FORMAT_CODE_128);
        sparseArray.put(2, zzjo.FORMAT_CODE_39);
        sparseArray.put(4, zzjo.FORMAT_CODE_93);
        sparseArray.put(8, zzjo.FORMAT_CODABAR);
        sparseArray.put(16, zzjo.FORMAT_DATA_MATRIX);
        sparseArray.put(32, zzjo.FORMAT_EAN_13);
        sparseArray.put(64, zzjo.FORMAT_EAN_8);
        sparseArray.put(128, zzjo.FORMAT_ITF);
        sparseArray.put(256, zzjo.FORMAT_QR_CODE);
        sparseArray.put(512, zzjo.FORMAT_UPC_A);
        sparseArray.put(1024, zzjo.FORMAT_UPC_E);
        sparseArray.put(2048, zzjo.FORMAT_PDF417);
        sparseArray.put(4096, zzjo.FORMAT_AZTEC);
        sparseArray2.put(0, zzjp.TYPE_UNKNOWN);
        sparseArray2.put(1, zzjp.TYPE_CONTACT_INFO);
        sparseArray2.put(2, zzjp.TYPE_EMAIL);
        sparseArray2.put(3, zzjp.TYPE_ISBN);
        sparseArray2.put(4, zzjp.TYPE_PHONE);
        sparseArray2.put(5, zzjp.TYPE_PRODUCT);
        sparseArray2.put(6, zzjp.TYPE_SMS);
        sparseArray2.put(7, zzjp.TYPE_TEXT);
        sparseArray2.put(8, zzjp.TYPE_URL);
        sparseArray2.put(9, zzjp.TYPE_WIFI);
        sparseArray2.put(10, zzjp.TYPE_GEO);
        sparseArray2.put(11, zzjp.TYPE_CALENDAR_EVENT);
        sparseArray2.put(12, zzjp.TYPE_DRIVER_LICENSE);
        HashMap hashMap = new HashMap();
        zzd = hashMap;
        hashMap.put(1, zzky.CODE_128);
        hashMap.put(2, zzky.CODE_39);
        hashMap.put(4, zzky.CODE_93);
        hashMap.put(8, zzky.CODABAR);
        hashMap.put(16, zzky.DATA_MATRIX);
        hashMap.put(32, zzky.EAN_13);
        hashMap.put(64, zzky.EAN_8);
        hashMap.put(128, zzky.ITF);
        hashMap.put(256, zzky.QR_CODE);
        hashMap.put(512, zzky.UPC_A);
        hashMap.put(1024, zzky.UPC_E);
        hashMap.put(2048, zzky.PDF417);
        hashMap.put(4096, zzky.AZTEC);
    }

    public static zzjo zza(int i) {
        zzjo zzjo = zzb.get(i);
        return zzjo == null ? zzjo.FORMAT_UNKNOWN : zzjo;
    }

    public static zzjp zzb(int i) {
        zzjp zzjp = zzc.get(i);
        return zzjp == null ? zzjp.TYPE_UNKNOWN : zzjp;
    }

    public static zzlb zzc(BarcodeScannerOptions barcodeScannerOptions) {
        int zza2 = barcodeScannerOptions.zza();
        zzby zzby = new zzby();
        if (zza2 == 0) {
            zzby.zze(zzd.values());
        } else {
            for (Map.Entry next : zzd.entrySet()) {
                if ((((Integer) next.getKey()).intValue() & zza2) != 0) {
                    zzby.zzd((zzky) next.getValue());
                }
            }
        }
        zzla zzla = new zzla();
        zzla.zzb(zzby.zzf());
        return zzla.zzc();
    }

    public static String zzd() {
        AtomicReference<String> atomicReference = zza;
        if (atomicReference.get() != null) {
            return atomicReference.get();
        }
        String str = true != zzm.zzd(MlKitContext.getInstance().getApplicationContext()) ? "play-services-mlkit-barcode-scanning" : "barcode-scanning";
        atomicReference.set(str);
        return str;
    }

    static void zze(zzlo zzlo, zzjb zzjb) {
        zzlo.zzb(new zza(zzjb), zzjc.ON_DEVICE_BARCODE_LOAD);
    }
}
