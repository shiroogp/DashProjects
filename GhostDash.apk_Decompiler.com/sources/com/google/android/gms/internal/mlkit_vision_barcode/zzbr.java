package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
final class zzbr<K, V> extends AbstractMap<K, V> implements Serializable {
    /* access modifiers changed from: private */
    public static final Object zzd = new Object();
    @NullableDecl
    transient int[] zza;
    @NullableDecl
    transient Object[] zzb;
    @NullableDecl
    transient Object[] zzc;
    /* access modifiers changed from: private */
    @NullableDecl
    public transient Object zze;
    /* access modifiers changed from: private */
    public transient int zzf;
    private transient int zzg;
    @NullableDecl
    private transient Set<K> zzh;
    @NullableDecl
    private transient Set<Map.Entry<K, V>> zzi;
    @NullableDecl
    private transient Collection<V> zzj;

    zzbr() {
        zzl(3);
    }

    static /* synthetic */ int zzd(zzbr zzbr) {
        int i = zzbr.zzg;
        zzbr.zzg = i - 1;
        return i;
    }

    /* access modifiers changed from: private */
    public final int zzo() {
        return (1 << (this.zzf & 31)) - 1;
    }

    /* access modifiers changed from: private */
    public final int zzp(@NullableDecl Object obj) {
        if (zzn()) {
            return -1;
        }
        int zza2 = zzbt.zza(obj);
        int zzo = zzo();
        int zzc2 = zzbs.zzc(this.zze, zza2 & zzo);
        if (zzc2 != 0) {
            int i = ~zzo;
            int i2 = zza2 & i;
            do {
                int i3 = zzc2 - 1;
                int i4 = this.zza[i3];
                if ((i4 & i) == i2 && zzam.zza(obj, this.zzb[i3])) {
                    return i3;
                }
                zzc2 = i4 & zzo;
            } while (zzc2 != 0);
        }
        return -1;
    }

    private final int zzq(int i, int i2, int i3, int i4) {
        Object zzd2 = zzbs.zzd(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            zzbs.zze(zzd2, i3 & i5, i4 + 1);
        }
        Object obj = this.zze;
        int[] iArr = this.zza;
        for (int i6 = 0; i6 <= i; i6++) {
            int zzc2 = zzbs.zzc(obj, i6);
            while (zzc2 != 0) {
                int i7 = zzc2 - 1;
                int i8 = iArr[i7];
                int i9 = ((~i) & i8) | i6;
                int i10 = i9 & i5;
                int zzc3 = zzbs.zzc(zzd2, i10);
                zzbs.zze(zzd2, i10, zzc2);
                iArr[i7] = ((~i5) & i9) | (zzc3 & i5);
                zzc2 = i8 & i;
            }
        }
        this.zze = zzd2;
        zzs(i5);
        return i5;
    }

    /* access modifiers changed from: private */
    @NullableDecl
    public final Object zzr(@NullableDecl Object obj) {
        if (zzn()) {
            return zzd;
        }
        int zzo = zzo();
        int zzb2 = zzbs.zzb(obj, (Object) null, zzo, this.zze, this.zza, this.zzb, (Object[]) null);
        if (zzb2 == -1) {
            return zzd;
        }
        Object obj2 = this.zzc[zzb2];
        zzm(zzb2, zzo);
        this.zzg--;
        zzk();
        return obj2;
    }

    private final void zzs(int i) {
        this.zzf = ((32 - Integer.numberOfLeadingZeros(i)) & 31) | (this.zzf & -32);
    }

    public final void clear() {
        if (!zzn()) {
            zzk();
            Map zzj2 = zzj();
            if (zzj2 != null) {
                this.zzf = zzct.zza(size(), 3, 1073741823);
                zzj2.clear();
                this.zze = null;
                this.zzg = 0;
                return;
            }
            Arrays.fill(this.zzb, 0, this.zzg, (Object) null);
            Arrays.fill(this.zzc, 0, this.zzg, (Object) null);
            Object obj = this.zze;
            if (obj instanceof byte[]) {
                Arrays.fill((byte[]) obj, (byte) 0);
            } else if (obj instanceof short[]) {
                Arrays.fill((short[]) obj, 0);
            } else {
                Arrays.fill((int[]) obj, 0);
            }
            Arrays.fill(this.zza, 0, this.zzg, 0);
            this.zzg = 0;
        }
    }

    public final boolean containsKey(@NullableDecl Object obj) {
        Map zzj2 = zzj();
        if (zzj2 != null) {
            return zzj2.containsKey(obj);
        }
        return zzp(obj) != -1;
    }

    public final boolean containsValue(@NullableDecl Object obj) {
        Map zzj2 = zzj();
        if (zzj2 != null) {
            return zzj2.containsValue(obj);
        }
        for (int i = 0; i < this.zzg; i++) {
            if (zzam.zza(obj, this.zzc[i])) {
                return true;
            }
        }
        return false;
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.zzi;
        if (set != null) {
            return set;
        }
        zzbm zzbm = new zzbm(this);
        this.zzi = zzbm;
        return zzbm;
    }

    public final V get(@NullableDecl Object obj) {
        Map zzj2 = zzj();
        if (zzj2 != null) {
            return zzj2.get(obj);
        }
        int zzp = zzp(obj);
        if (zzp == -1) {
            return null;
        }
        return this.zzc[zzp];
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final Set<K> keySet() {
        Set<K> set = this.zzh;
        if (set != null) {
            return set;
        }
        zzbo zzbo = new zzbo(this);
        this.zzh = zzbo;
        return zzbo;
    }

    @NullableDecl
    public final V put(@NullableDecl K k, @NullableDecl V v) {
        int min;
        K k2 = k;
        V v2 = v;
        if (zzn()) {
            zzaq.zzd(zzn(), "Arrays already allocated");
            int i = this.zzf;
            int max = Math.max(i + 1, 2);
            int highestOneBit = Integer.highestOneBit(max);
            if (max > ((int) ((double) highestOneBit)) && (highestOneBit = highestOneBit + highestOneBit) <= 0) {
                highestOneBit = 1073741824;
            }
            int max2 = Math.max(4, highestOneBit);
            this.zze = zzbs.zzd(max2);
            zzs(max2 - 1);
            this.zza = new int[i];
            this.zzb = new Object[i];
            this.zzc = new Object[i];
        }
        Map zzj2 = zzj();
        if (zzj2 != null) {
            return zzj2.put(k2, v2);
        }
        int[] iArr = this.zza;
        Object[] objArr = this.zzb;
        V[] vArr = this.zzc;
        int i2 = this.zzg;
        int i3 = i2 + 1;
        int zza2 = zzbt.zza(k);
        int zzo = zzo();
        int i4 = zza2 & zzo;
        int zzc2 = zzbs.zzc(this.zze, i4);
        if (zzc2 != 0) {
            int i5 = ~zzo;
            int i6 = zza2 & i5;
            int i7 = 0;
            while (true) {
                int i8 = zzc2 - 1;
                int i9 = iArr[i8];
                int i10 = i9 & i5;
                if (i10 != i6 || !zzam.zza(k2, objArr[i8])) {
                    int i11 = i9 & zzo;
                    i7++;
                    if (i11 != 0) {
                        zzc2 = i11;
                    } else if (i7 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(zzo() + 1, 1.0f);
                        for (int zze2 = zze(); zze2 >= 0; zze2 = zzf(zze2)) {
                            linkedHashMap.put(this.zzb[zze2], this.zzc[zze2]);
                        }
                        this.zze = linkedHashMap;
                        this.zza = null;
                        this.zzb = null;
                        this.zzc = null;
                        zzk();
                        return linkedHashMap.put(k2, v2);
                    } else if (i3 > zzo) {
                        zzo = zzq(zzo, zzbs.zza(zzo), zza2, i2);
                    } else {
                        iArr[i8] = (i3 & zzo) | i10;
                    }
                } else {
                    V v3 = vArr[i8];
                    vArr[i8] = v2;
                    return v3;
                }
            }
        } else if (i3 > zzo) {
            zzo = zzq(zzo, zzbs.zza(zzo), zza2, i2);
        } else {
            zzbs.zze(this.zze, i4, i3);
        }
        int length = this.zza.length;
        if (i3 > length && (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            this.zza = Arrays.copyOf(this.zza, min);
            this.zzb = Arrays.copyOf(this.zzb, min);
            this.zzc = Arrays.copyOf(this.zzc, min);
        }
        this.zza[i2] = (~zzo) & zza2;
        this.zzb[i2] = k2;
        this.zzc[i2] = v2;
        this.zzg = i3;
        zzk();
        return null;
    }

    @NullableDecl
    public final V remove(@NullableDecl Object obj) {
        Map zzj2 = zzj();
        if (zzj2 != null) {
            return zzj2.remove(obj);
        }
        V zzr = zzr(obj);
        if (zzr == zzd) {
            return null;
        }
        return zzr;
    }

    public final int size() {
        Map zzj2 = zzj();
        return zzj2 != null ? zzj2.size() : this.zzg;
    }

    public final Collection<V> values() {
        Collection<V> collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        zzbq zzbq = new zzbq(this);
        this.zzj = zzbq;
        return zzbq;
    }

    /* access modifiers changed from: package-private */
    public final int zze() {
        return isEmpty() ? -1 : 0;
    }

    /* access modifiers changed from: package-private */
    public final int zzf(int i) {
        int i2 = i + 1;
        if (i2 < this.zzg) {
            return i2;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    @NullableDecl
    public final Map<K, V> zzj() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void zzk() {
        this.zzf += 32;
    }

    /* access modifiers changed from: package-private */
    public final void zzl(int i) {
        this.zzf = zzct.zza(12, 1, 1073741823);
    }

    /* access modifiers changed from: package-private */
    public final void zzm(int i, int i2) {
        int size = size() - 1;
        if (i < size) {
            Object[] objArr = this.zzb;
            Object obj = objArr[size];
            objArr[i] = obj;
            Object[] objArr2 = this.zzc;
            objArr2[i] = objArr2[size];
            objArr[size] = null;
            objArr2[size] = null;
            int[] iArr = this.zza;
            iArr[i] = iArr[size];
            iArr[size] = 0;
            int zza2 = zzbt.zza(obj) & i2;
            int zzc2 = zzbs.zzc(this.zze, zza2);
            int i3 = size + 1;
            if (zzc2 != i3) {
                while (true) {
                    int i4 = zzc2 - 1;
                    int[] iArr2 = this.zza;
                    int i5 = iArr2[i4];
                    int i6 = i5 & i2;
                    if (i6 != i3) {
                        zzc2 = i6;
                    } else {
                        iArr2[i4] = ((i + 1) & i2) | ((~i2) & i5);
                        return;
                    }
                }
            } else {
                zzbs.zze(this.zze, zza2, i + 1);
            }
        } else {
            this.zzb[i] = null;
            this.zzc[i] = null;
            this.zza[i] = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzn() {
        return this.zze == null;
    }

    zzbr(int i) {
        zzl(12);
    }
}
