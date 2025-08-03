package com.google.mlkit.vision.barcode.internal;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_barcode.zzmd;
import com.google.android.gms.internal.mlkit_vision_barcode.zzme;
import com.google.android.gms.internal.mlkit_vision_barcode.zzmf;
import com.google.android.gms.internal.mlkit_vision_barcode.zzmg;
import com.google.android.gms.internal.mlkit_vision_barcode.zzmh;
import com.google.android.gms.internal.mlkit_vision_barcode.zzmi;
import com.google.android.gms.internal.mlkit_vision_barcode.zzmj;
import com.google.android.gms.internal.mlkit_vision_barcode.zzmk;
import com.google.android.gms.internal.mlkit_vision_barcode.zzml;
import com.google.android.gms.internal.mlkit_vision_barcode.zzmm;
import com.google.android.gms.internal.mlkit_vision_barcode.zzmn;
import com.google.android.gms.internal.mlkit_vision_barcode.zzmo;
import com.google.android.gms.internal.mlkit_vision_barcode.zzmp;
import com.google.mlkit.vision.barcode.Barcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final class zzl implements zzk {
    private final zzmp zza;

    public zzl(zzmp zzmp) {
        this.zza = zzmp;
    }

    private static Barcode.CalendarDateTime zzq(zzme zzme) {
        if (zzme == null) {
            return null;
        }
        return new Barcode.CalendarDateTime(zzme.zzf(), zzme.zzd(), zzme.zza(), zzme.zzb(), zzme.zzc(), zzme.zze(), zzme.zzh(), zzme.zzg());
    }

    public final int zza() {
        return this.zza.zza();
    }

    public final int zzb() {
        return this.zza.zzb();
    }

    public final Rect zzc() {
        Point[] zzo = this.zza.zzo();
        if (zzo == null) {
            return null;
        }
        int i = Integer.MIN_VALUE;
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        for (Point point : zzo) {
            i2 = Math.min(i2, point.x);
            i = Math.max(i, point.x);
            i3 = Math.min(i3, point.y);
            i4 = Math.max(i4, point.y);
        }
        return new Rect(i2, i3, i, i4);
    }

    public final Barcode.CalendarEvent zzd() {
        zzmf zzc = this.zza.zzc();
        if (zzc != null) {
            return new Barcode.CalendarEvent(zzc.zzg(), zzc.zzc(), zzc.zzd(), zzc.zze(), zzc.zzf(), zzq(zzc.zzb()), zzq(zzc.zza()));
        }
        return null;
    }

    public final Barcode.ContactInfo zze() {
        List list;
        zzmg zzd = this.zza.zzd();
        Barcode.PersonName personName = null;
        if (zzd == null) {
            return null;
        }
        zzmk zza2 = zzd.zza();
        if (zza2 != null) {
            personName = new Barcode.PersonName(zza2.zzb(), zza2.zzf(), zza2.zze(), zza2.zza(), zza2.zzd(), zza2.zzc(), zza2.zzg());
        }
        Barcode.PersonName personName2 = personName;
        String zzb = zzd.zzb();
        String zzc = zzd.zzc();
        zzml[] zzf = zzd.zzf();
        ArrayList arrayList = new ArrayList();
        if (zzf != null) {
            for (zzml zzml : zzf) {
                if (zzml != null) {
                    arrayList.add(new Barcode.Phone(zzml.zzb(), zzml.zza()));
                }
            }
        }
        zzmi[] zze = zzd.zze();
        ArrayList arrayList2 = new ArrayList();
        if (zze != null) {
            for (zzmi zzmi : zze) {
                if (zzmi != null) {
                    arrayList2.add(new Barcode.Email(zzmi.zza(), zzmi.zzb(), zzmi.zzd(), zzmi.zzc()));
                }
            }
        }
        if (zzd.zzg() != null) {
            list = Arrays.asList((String[]) Preconditions.checkNotNull(zzd.zzg()));
        } else {
            list = new ArrayList();
        }
        List list2 = list;
        zzmd[] zzd2 = zzd.zzd();
        ArrayList arrayList3 = new ArrayList();
        if (zzd2 != null) {
            for (zzmd zzmd : zzd2) {
                if (zzmd != null) {
                    arrayList3.add(new Barcode.Address(zzmd.zza(), zzmd.zzb()));
                }
            }
        }
        return new Barcode.ContactInfo(personName2, zzb, zzc, arrayList, arrayList2, list2, arrayList3);
    }

    public final Barcode.DriverLicense zzf() {
        zzmh zze = this.zza.zze();
        if (zze != null) {
            return new Barcode.DriverLicense(zze.zzf(), zze.zzh(), zze.zzn(), zze.zzl(), zze.zzi(), zze.zzc(), zze.zza(), zze.zzb(), zze.zzd(), zze.zzm(), zze.zzj(), zze.zzg(), zze.zze(), zze.zzk());
        }
        return null;
    }

    public final Barcode.Email zzg() {
        zzmi zzf = this.zza.zzf();
        if (zzf == null) {
            return null;
        }
        return new Barcode.Email(zzf.zza(), zzf.zzb(), zzf.zzd(), zzf.zzc());
    }

    public final Barcode.GeoPoint zzh() {
        zzmj zzg = this.zza.zzg();
        if (zzg != null) {
            return new Barcode.GeoPoint(zzg.zza(), zzg.zzb());
        }
        return null;
    }

    public final Barcode.Phone zzi() {
        zzml zzh = this.zza.zzh();
        if (zzh != null) {
            return new Barcode.Phone(zzh.zzb(), zzh.zza());
        }
        return null;
    }

    public final Barcode.Sms zzj() {
        zzmm zzi = this.zza.zzi();
        if (zzi != null) {
            return new Barcode.Sms(zzi.zza(), zzi.zzb());
        }
        return null;
    }

    public final Barcode.UrlBookmark zzk() {
        zzmn zzj = this.zza.zzj();
        if (zzj != null) {
            return new Barcode.UrlBookmark(zzj.zza(), zzj.zzb());
        }
        return null;
    }

    public final Barcode.WiFi zzl() {
        zzmo zzk = this.zza.zzk();
        if (zzk != null) {
            return new Barcode.WiFi(zzk.zzc(), zzk.zzb(), zzk.zza());
        }
        return null;
    }

    public final String zzm() {
        return this.zza.zzl();
    }

    public final String zzn() {
        return this.zza.zzm();
    }

    public final byte[] zzo() {
        return this.zza.zzn();
    }

    public final Point[] zzp() {
        return this.zza.zzo();
    }
}
