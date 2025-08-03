package com.google.mlkit.vision.barcode.internal;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.mlkit_vision_barcode.zze;
import com.google.android.gms.internal.mlkit_vision_barcode.zzf;
import com.google.android.gms.internal.mlkit_vision_barcode.zzg;
import com.google.android.gms.internal.mlkit_vision_barcode.zzh;
import com.google.android.gms.internal.mlkit_vision_barcode.zzi;
import com.google.android.gms.internal.mlkit_vision_barcode.zzj;
import com.google.android.gms.internal.mlkit_vision_barcode.zzk;
import com.google.android.gms.internal.mlkit_vision_barcode.zzl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzm;
import com.google.android.gms.internal.mlkit_vision_barcode.zzo;
import com.google.android.gms.internal.mlkit_vision_barcode.zzp;
import com.google.android.gms.internal.mlkit_vision_barcode.zzq;
import com.google.mlkit.vision.barcode.Barcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final class zzn implements zzk {
    private final zzq zza;

    public zzn(zzq zzq) {
        this.zza = zzq;
    }

    private static Barcode.CalendarDateTime zzq(zzf zzf) {
        if (zzf == null) {
            return null;
        }
        return new Barcode.CalendarDateTime(zzf.zza, zzf.zzb, zzf.zzc, zzf.zzd, zzf.zze, zzf.zzf, zzf.zzg, zzf.zzh);
    }

    public final int zza() {
        return this.zza.zza;
    }

    public final int zzb() {
        return this.zza.zzd;
    }

    public final Rect zzc() {
        zzq zzq = this.zza;
        int i = Integer.MIN_VALUE;
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        int i4 = Integer.MIN_VALUE;
        int i5 = Integer.MAX_VALUE;
        while (true) {
            Point[] pointArr = zzq.zze;
            if (i3 >= pointArr.length) {
                return new Rect(i5, i2, i, i4);
            }
            Point point = pointArr[i3];
            i5 = Math.min(i5, point.x);
            i = Math.max(i, point.x);
            i2 = Math.min(i2, point.y);
            i4 = Math.max(i4, point.y);
            i3++;
        }
    }

    public final Barcode.CalendarEvent zzd() {
        zzg zzg = this.zza.zzl;
        if (zzg == null) {
            return null;
        }
        return new Barcode.CalendarEvent(zzg.zza, zzg.zzb, zzg.zzc, zzg.zzd, zzg.zze, zzq(zzg.zzf), zzq(zzg.zzg));
    }

    public final Barcode.ContactInfo zze() {
        zzh zzh = this.zza.zzm;
        Barcode.PersonName personName = null;
        if (zzh == null) {
            return null;
        }
        zzl zzl = zzh.zza;
        if (zzl != null) {
            personName = new Barcode.PersonName(zzl.zza, zzl.zzb, zzl.zzc, zzl.zzd, zzl.zze, zzl.zzf, zzl.zzg);
        }
        Barcode.PersonName personName2 = personName;
        String str = zzh.zzb;
        String str2 = zzh.zzc;
        zzm[] zzmArr = zzh.zzd;
        ArrayList arrayList = new ArrayList();
        if (zzmArr != null) {
            for (zzm zzm : zzmArr) {
                if (zzm != null) {
                    arrayList.add(new Barcode.Phone(zzm.zzb, zzm.zza));
                }
            }
        }
        zzj[] zzjArr = zzh.zze;
        ArrayList arrayList2 = new ArrayList();
        if (zzjArr != null) {
            for (zzj zzj : zzjArr) {
                if (zzj != null) {
                    arrayList2.add(new Barcode.Email(zzj.zza, zzj.zzb, zzj.zzc, zzj.zzd));
                }
            }
        }
        String[] strArr = zzh.zzf;
        List asList = strArr != null ? Arrays.asList(strArr) : new ArrayList();
        zze[] zzeArr = zzh.zzg;
        ArrayList arrayList3 = new ArrayList();
        if (zzeArr != null) {
            for (zze zze : zzeArr) {
                if (zze != null) {
                    arrayList3.add(new Barcode.Address(zze.zza, zze.zzb));
                }
            }
        }
        return new Barcode.ContactInfo(personName2, str, str2, arrayList, arrayList2, asList, arrayList3);
    }

    public final Barcode.DriverLicense zzf() {
        zzi zzi = this.zza.zzn;
        if (zzi == null) {
            return null;
        }
        return new Barcode.DriverLicense(zzi.zza, zzi.zzb, zzi.zzc, zzi.zzd, zzi.zze, zzi.zzf, zzi.zzg, zzi.zzh, zzi.zzi, zzi.zzj, zzi.zzk, zzi.zzl, zzi.zzm, zzi.zzn);
    }

    public final Barcode.Email zzg() {
        zzj zzj = this.zza.zzf;
        if (zzj != null) {
            return new Barcode.Email(zzj.zza, zzj.zzb, zzj.zzc, zzj.zzd);
        }
        return null;
    }

    public final Barcode.GeoPoint zzh() {
        zzk zzk = this.zza.zzk;
        if (zzk != null) {
            return new Barcode.GeoPoint(zzk.zza, zzk.zzb);
        }
        return null;
    }

    public final Barcode.Phone zzi() {
        zzm zzm = this.zza.zzg;
        if (zzm != null) {
            return new Barcode.Phone(zzm.zzb, zzm.zza);
        }
        return null;
    }

    public final Barcode.Sms zzj() {
        com.google.android.gms.internal.mlkit_vision_barcode.zzn zzn = this.zza.zzh;
        if (zzn != null) {
            return new Barcode.Sms(zzn.zza, zzn.zzb);
        }
        return null;
    }

    public final Barcode.UrlBookmark zzk() {
        zzo zzo = this.zza.zzj;
        if (zzo != null) {
            return new Barcode.UrlBookmark(zzo.zza, zzo.zzb);
        }
        return null;
    }

    public final Barcode.WiFi zzl() {
        zzp zzp = this.zza.zzi;
        if (zzp != null) {
            return new Barcode.WiFi(zzp.zza, zzp.zzb, zzp.zzc);
        }
        return null;
    }

    public final String zzm() {
        return this.zza.zzc;
    }

    public final String zzn() {
        return this.zza.zzb;
    }

    public final byte[] zzo() {
        return this.zza.zzo;
    }

    public final Point[] zzp() {
        return this.zza.zze;
    }
}
