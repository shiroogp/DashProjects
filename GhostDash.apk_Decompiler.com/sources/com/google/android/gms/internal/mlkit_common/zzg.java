package com.google.android.gms.internal.mlkit_common;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import com.facebook.common.util.UriUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public final class zzg {
    public static final /* synthetic */ int zza = 0;
    private static final String[] zzb = {"com.android.", "com.google.", "com.chrome.", "com.nest.", "com.waymo.", "com.waze"};
    private static final String[] zzc;
    private static final String[] zzd;

    static {
        String[] strArr = new String[2];
        strArr[0] = "media";
        String str = "";
        strArr[1] = true != (Build.HARDWARE.equals("goldfish") || Build.HARDWARE.equals("ranchu")) ? str : "androidx.test.services.storage.runfiles";
        zzc = strArr;
        String[] strArr2 = new String[3];
        strArr2[0] = Build.VERSION.SDK_INT <= 25 ? "com.google.android.inputmethod.latin.inputcontent" : str;
        if (Build.VERSION.SDK_INT <= 25) {
            str = "com.google.android.inputmethod.latin.dev.inputcontent";
        }
        strArr2[1] = str;
        strArr2[2] = "com.google.android.apps.docs.storage.legacy";
        zzd = strArr2;
    }

    public static AssetFileDescriptor zza(Context context, Uri uri, String str) throws FileNotFoundException {
        zzf zzf = zzf.zza;
        ContentResolver contentResolver = context.getContentResolver();
        Uri parse = Uri.parse(uri.toString());
        String scheme = parse.getScheme();
        if (UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(scheme)) {
            return contentResolver.openAssetFileDescriptor(parse, "r");
        }
        if ("content".equals(scheme)) {
            if (zzi(context, parse, 1, zzf)) {
                AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(parse, "r");
                zzc(openAssetFileDescriptor);
                return openAssetFileDescriptor;
            }
            throw new FileNotFoundException("Can't open content uri.");
        } else if (UriUtil.LOCAL_FILE_SCHEME.equals(scheme)) {
            AssetFileDescriptor openAssetFileDescriptor2 = contentResolver.openAssetFileDescriptor(parse, "r");
            zzc(openAssetFileDescriptor2);
            try {
                zzh(context, openAssetFileDescriptor2.getParcelFileDescriptor(), parse, zzf);
                return openAssetFileDescriptor2;
            } catch (FileNotFoundException e) {
                zzf(openAssetFileDescriptor2, e);
                throw e;
            } catch (IOException e2) {
                FileNotFoundException fileNotFoundException = new FileNotFoundException("Validation failed.");
                fileNotFoundException.initCause(e2);
                zzf(openAssetFileDescriptor2, fileNotFoundException);
                throw fileNotFoundException;
            }
        } else {
            throw new FileNotFoundException("Not implemented. Contact tiktok-users@");
        }
    }

    public static InputStream zzb(Context context, Uri uri) throws FileNotFoundException {
        zzf zzf = zzf.zza;
        ContentResolver contentResolver = context.getContentResolver();
        Uri parse = Uri.parse(uri.toString());
        String scheme = parse.getScheme();
        if (UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(scheme)) {
            return contentResolver.openInputStream(parse);
        }
        if ("content".equals(scheme)) {
            if (zzi(context, parse, 1, zzf)) {
                InputStream openInputStream = contentResolver.openInputStream(parse);
                zzc(openInputStream);
                return openInputStream;
            }
            throw new FileNotFoundException("Can't open content uri.");
        } else if (UriUtil.LOCAL_FILE_SCHEME.equals(scheme)) {
            try {
                ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(Uri.fromFile(new File(parse.getPath()).getCanonicalFile()), "r");
                try {
                    zzh(context, openFileDescriptor, parse, zzf);
                    return new ParcelFileDescriptor.AutoCloseInputStream(openFileDescriptor);
                } catch (FileNotFoundException e) {
                    zzg(openFileDescriptor, e);
                    throw e;
                } catch (IOException e2) {
                    FileNotFoundException fileNotFoundException = new FileNotFoundException("Validation failed.");
                    fileNotFoundException.initCause(e2);
                    zzg(openFileDescriptor, fileNotFoundException);
                    throw fileNotFoundException;
                }
            } catch (IOException e3) {
                FileNotFoundException fileNotFoundException2 = new FileNotFoundException("Canonicalization failed.");
                fileNotFoundException2.initCause(e3);
                throw fileNotFoundException2;
            }
        } else {
            throw new FileNotFoundException("Not implemented. Contact tiktok-users@");
        }
    }

    private static <T> T zzc(T t) throws FileNotFoundException {
        if (t != null) {
            return t;
        }
        throw new FileNotFoundException("Content resolver returned null value.");
    }

    private static String zzd(File file) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        return !canonicalPath.endsWith("/") ? String.valueOf(canonicalPath).concat("/") : canonicalPath;
    }

    private static void zze(Exception exc, Exception exc2) {
        if (Build.VERSION.SDK_INT >= 19) {
            exc.addSuppressed(exc2);
        }
    }

    private static void zzf(AssetFileDescriptor assetFileDescriptor, FileNotFoundException fileNotFoundException) {
        try {
            assetFileDescriptor.close();
        } catch (IOException e) {
            zze(fileNotFoundException, e);
        }
    }

    private static void zzg(ParcelFileDescriptor parcelFileDescriptor, FileNotFoundException fileNotFoundException) {
        try {
            parcelFileDescriptor.close();
        } catch (IOException e) {
            zze(fileNotFoundException, e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e2 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzh(android.content.Context r7, android.os.ParcelFileDescriptor r8, android.net.Uri r9, com.google.android.gms.internal.mlkit_common.zzf r10) throws java.io.IOException {
        /*
            java.io.File r0 = new java.io.File
            java.lang.String r9 = r9.getPath()
            r0.<init>(r9)
            java.lang.String r9 = r0.getCanonicalPath()
            java.io.FileDescriptor r8 = r8.getFileDescriptor()
            com.google.android.gms.internal.mlkit_common.zzn r8 = com.google.android.gms.internal.mlkit_common.zzn.zza(r8)
            com.google.android.gms.internal.mlkit_common.zzn r0 = com.google.android.gms.internal.mlkit_common.zzn.zzb(r9)
            boolean r1 = r0.zzc
            java.lang.String r2 = "Can't open file: "
            if (r1 == 0) goto L_0x0039
            java.io.FileNotFoundException r7 = new java.io.FileNotFoundException
            java.lang.String r8 = java.lang.String.valueOf(r9)
            int r9 = r8.length()
            if (r9 == 0) goto L_0x0030
            java.lang.String r8 = r2.concat(r8)
            goto L_0x0035
        L_0x0030:
            java.lang.String r8 = new java.lang.String
            r8.<init>(r2)
        L_0x0035:
            r7.<init>(r8)
            throw r7
        L_0x0039:
            long r3 = r8.zza
            long r5 = r0.zza
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x00fd
            long r3 = r8.zzb
            long r0 = r0.zzb
            int r8 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r8 != 0) goto L_0x00fd
            java.lang.String r8 = "/proc/"
            boolean r8 = r9.startsWith(r8)
            if (r8 == 0) goto L_0x0053
            goto L_0x00e3
        L_0x0053:
            java.lang.String r8 = "/data/misc/"
            boolean r8 = r9.startsWith(r8)
            if (r8 != 0) goto L_0x00e3
            boolean unused = r10.zzd
            java.io.File r8 = androidx.core.content.ContextCompat.getDataDir(r7)
            r0 = 0
            r1 = 1
            if (r8 == 0) goto L_0x0071
            java.lang.String r8 = zzd(r8)
            boolean r8 = r9.startsWith(r8)
            if (r8 == 0) goto L_0x0081
            goto L_0x007f
        L_0x0071:
            java.io.File r8 = android.os.Environment.getDataDirectory()
            java.lang.String r8 = zzd(r8)
            boolean r8 = r9.startsWith(r8)
            if (r8 == 0) goto L_0x0081
        L_0x007f:
            r0 = r1
            goto L_0x00dc
        L_0x0081:
            android.content.Context r8 = androidx.core.content.ContextCompat.createDeviceProtectedStorageContext(r7)
            if (r8 == 0) goto L_0x0098
            java.io.File r8 = androidx.core.content.ContextCompat.getDataDir(r8)
            if (r8 == 0) goto L_0x0098
            java.lang.String r8 = zzd(r8)
            boolean r8 = r9.startsWith(r8)
            if (r8 == 0) goto L_0x0098
            goto L_0x007f
        L_0x0098:
            int r8 = android.os.Build.VERSION.SDK_INT
            r3 = 19
            if (r8 < r3) goto L_0x00dc
            com.google.android.gms.internal.mlkit_common.zzb r8 = new com.google.android.gms.internal.mlkit_common.zzb
            r8.<init>(r7)
            java.io.File[] r8 = zzj(r8)
            int r3 = r8.length
            r4 = r0
        L_0x00a9:
            if (r4 >= r3) goto L_0x00bd
            r5 = r8[r4]
            if (r5 == 0) goto L_0x00ba
            java.lang.String r5 = zzd(r5)
            boolean r5 = r9.startsWith(r5)
            if (r5 == 0) goto L_0x00ba
            goto L_0x007f
        L_0x00ba:
            int r4 = r4 + 1
            goto L_0x00a9
        L_0x00bd:
            com.google.android.gms.internal.mlkit_common.zzc r8 = new com.google.android.gms.internal.mlkit_common.zzc
            r8.<init>(r7)
            java.io.File[] r7 = zzj(r8)
            int r8 = r7.length
            r3 = r0
        L_0x00c8:
            if (r3 >= r8) goto L_0x00dc
            r4 = r7[r3]
            if (r4 == 0) goto L_0x00d9
            java.lang.String r4 = zzd(r4)
            boolean r4 = r9.startsWith(r4)
            if (r4 == 0) goto L_0x00d9
            goto L_0x007f
        L_0x00d9:
            int r3 = r3 + 1
            goto L_0x00c8
        L_0x00dc:
            boolean r7 = r10.zzc
            if (r0 != r7) goto L_0x00e3
            return
        L_0x00e3:
            java.io.FileNotFoundException r7 = new java.io.FileNotFoundException
            java.lang.String r8 = java.lang.String.valueOf(r9)
            int r9 = r8.length()
            if (r9 == 0) goto L_0x00f4
            java.lang.String r8 = r2.concat(r8)
            goto L_0x00f9
        L_0x00f4:
            java.lang.String r8 = new java.lang.String
            r8.<init>(r2)
        L_0x00f9:
            r7.<init>(r8)
            throw r7
        L_0x00fd:
            java.io.FileNotFoundException r7 = new java.io.FileNotFoundException
            java.lang.String r8 = java.lang.String.valueOf(r9)
            int r9 = r8.length()
            if (r9 == 0) goto L_0x010e
            java.lang.String r8 = r2.concat(r8)
            goto L_0x0113
        L_0x010e:
            java.lang.String r8 = new java.lang.String
            r8.<init>(r2)
        L_0x0113:
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzg.zzh(android.content.Context, android.os.ParcelFileDescriptor, android.net.Uri, com.google.android.gms.internal.mlkit_common.zzf):void");
    }

    private static boolean zzi(Context context, Uri uri, int i, zzf zzf) {
        String authority = uri.getAuthority();
        ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 0);
        if (resolveContentProvider == null) {
            int lastIndexOf = authority.lastIndexOf(64);
            if (lastIndexOf >= 0) {
                authority = authority.substring(lastIndexOf + 1);
                resolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 0);
            }
            if (resolveContentProvider == null) {
                return !zzf.zzc;
            }
        }
        int zzc2 = zzf.zzc(zzf, context, new zzo(uri, resolveContentProvider, authority)) - 1;
        if (zzc2 == 0) {
            return true;
        }
        if (zzc2 == 1) {
            return false;
        }
        if (context.getPackageName().equals(resolveContentProvider.packageName)) {
            return zzf.zzc;
        }
        if (zzf.zzc) {
            return false;
        }
        if (context.checkUriPermission(uri, Process.myPid(), Process.myUid(), 1) != 0 && resolveContentProvider.exported) {
            String[] strArr = zzc;
            int length = strArr.length;
            for (int i2 = 0; i2 < 2; i2++) {
                if (strArr[i2].equals(authority)) {
                    return true;
                }
            }
            String[] strArr2 = zzd;
            int length2 = strArr2.length;
            for (int i3 = 0; i3 < 3; i3++) {
                if (strArr2[i3].equals(authority)) {
                    return true;
                }
            }
            String[] strArr3 = zzb;
            int length3 = strArr3.length;
            for (int i4 = 0; i4 < 6; i4++) {
                String str = strArr3[i4];
                if (str.charAt(str.length() - 1) == '.') {
                    if (resolveContentProvider.packageName.startsWith(str)) {
                        return false;
                    }
                } else if (resolveContentProvider.packageName.equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static File[] zzj(Callable<File[]> callable) {
        try {
            return callable.call();
        } catch (NullPointerException e) {
            if (Build.VERSION.SDK_INT < 22) {
                return new File[0];
            }
            throw e;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
