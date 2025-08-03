package com.google.android.gms.internal.mlkit_common;

import android.os.Build;
import android.system.OsConstants;
import android.system.StructStat;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:common@@17.2.0 */
final class zzn {
    final long zza;
    final long zzb;
    final boolean zzc;

    private zzn(long j, long j2, boolean z) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = z;
    }

    static zzn zza(FileDescriptor fileDescriptor) throws IOException {
        if (Build.VERSION.SDK_INT < 21) {
            return zzm.zza(fileDescriptor);
        }
        StructStat structStat = (StructStat) zzc(new zzh(fileDescriptor));
        return new zzn(structStat.st_dev, structStat.st_ino, OsConstants.S_ISLNK(structStat.st_mode));
    }

    static zzn zzb(String str) throws IOException {
        if (Build.VERSION.SDK_INT < 21) {
            return zzm.zzd(str);
        }
        StructStat structStat = (StructStat) zzc(new zzi(str));
        return new zzn(structStat.st_dev, structStat.st_ino, OsConstants.S_ISLNK(structStat.st_mode));
    }

    private static <T> T zzc(Callable<T> callable) throws IOException {
        try {
            return callable.call();
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }
}
