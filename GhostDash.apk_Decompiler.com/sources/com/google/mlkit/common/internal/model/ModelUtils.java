package com.google.mlkit.common.internal.model;

import android.content.Context;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzaa;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;

/* compiled from: com.google.mlkit:common@@17.2.0 */
public class ModelUtils {
    private static final GmsLogger zza = new GmsLogger("ModelUtils", "");

    /* compiled from: com.google.mlkit:common@@17.2.0 */
    public static abstract class AutoMLManifest {
        public abstract String getLabelsFile();

        public abstract String getModelFile();

        public abstract String getModelType();
    }

    /* compiled from: com.google.mlkit:common@@17.2.0 */
    public static abstract class ModelLoggingInfo {
        static ModelLoggingInfo zza(long j, String str, boolean z) {
            return new AutoValue_ModelUtils_ModelLoggingInfo(j, zzaa.zzb(str), z);
        }

        public abstract String getHash();

        public abstract long getSize();

        public abstract boolean isManifestModel();
    }

    private ModelUtils() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f7 A[SYNTHETIC, Splitter:B:82:0x00f7] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0106 A[SYNTHETIC, Splitter:B:90:0x0106] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo getModelLoggingInfo(android.content.Context r11, com.google.mlkit.common.model.LocalModel r12) {
        /*
            java.lang.String r0 = r12.getAssetFilePath()
            java.lang.String r1 = r12.getAbsoluteFilePath()
            android.net.Uri r2 = r12.getUri()
            java.lang.String r3 = "Failed to open model file"
            java.lang.String r4 = "ModelUtils"
            r5 = 0
            if (r0 == 0) goto L_0x0047
            boolean r6 = r12.isManifestFile()
            if (r6 == 0) goto L_0x0022
            r6 = 1
            java.lang.String r0 = zzb(r11, r0, r6)
            if (r0 == 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            return r5
        L_0x0022:
            android.content.res.AssetManager r6 = r11.getAssets()     // Catch:{ IOException -> 0x0040 }
            android.content.res.AssetFileDescriptor r6 = r6.openFd(r0)     // Catch:{ IOException -> 0x0040 }
            long r7 = r6.getLength()     // Catch:{ all -> 0x0034 }
            if (r6 == 0) goto L_0x0073
            r6.close()     // Catch:{ IOException -> 0x0040 }
            goto L_0x0073
        L_0x0034:
            r11 = move-exception
            if (r6 == 0) goto L_0x003f
            r6.close()     // Catch:{ all -> 0x003b }
            goto L_0x003f
        L_0x003b:
            r12 = move-exception
            r11.addSuppressed(r12)     // Catch:{ IOException -> 0x0040 }
        L_0x003f:
            throw r11     // Catch:{ IOException -> 0x0040 }
        L_0x0040:
            r11 = move-exception
            com.google.android.gms.common.internal.GmsLogger r12 = zza
            r12.e(r4, r3, r11)
            return r5
        L_0x0047:
            if (r1 == 0) goto L_0x0062
            boolean r6 = r12.isManifestFile()
            if (r6 == 0) goto L_0x0058
            r6 = 0
            java.lang.String r1 = zzb(r11, r1, r6)
            if (r1 == 0) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            return r5
        L_0x0058:
            java.io.File r6 = new java.io.File
            r6.<init>(r1)
            long r7 = r6.length()
            goto L_0x0073
        L_0x0062:
            if (r2 == 0) goto L_0x0124
            java.lang.String r6 = "r"
            android.content.res.AssetFileDescriptor r6 = com.google.android.gms.internal.mlkit_common.zzg.zza(r11, r2, r6)     // Catch:{ IOException -> 0x011d }
            long r7 = r6.getLength()     // Catch:{ all -> 0x0111 }
            if (r6 == 0) goto L_0x0073
            r6.close()     // Catch:{ IOException -> 0x011d }
        L_0x0073:
            com.google.mlkit.common.sdkinternal.MlKitContext r6 = com.google.mlkit.common.sdkinternal.MlKitContext.getInstance()
            java.lang.Class<com.google.mlkit.common.sdkinternal.SharedPrefManager> r9 = com.google.mlkit.common.sdkinternal.SharedPrefManager.class
            java.lang.Object r6 = r6.get(r9)
            com.google.mlkit.common.sdkinternal.SharedPrefManager r6 = (com.google.mlkit.common.sdkinternal.SharedPrefManager) r6
            if (r0 == 0) goto L_0x0083
            r9 = r0
            goto L_0x0091
        L_0x0083:
            if (r1 == 0) goto L_0x0087
            r9 = r1
            goto L_0x0091
        L_0x0087:
            java.lang.Object r9 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)
            android.net.Uri r9 = (android.net.Uri) r9
            java.lang.String r9 = r9.toString()
        L_0x0091:
            java.lang.String r10 = r6.zza(r9, r7)
            if (r10 == 0) goto L_0x00a0
            boolean r11 = r12.isManifestFile()
            com.google.mlkit.common.internal.model.ModelUtils$ModelLoggingInfo r11 = com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo.zza(r7, r10, r11)
            return r11
        L_0x00a0:
            java.lang.String r10 = "Failed to close model file"
            if (r0 == 0) goto L_0x00b1
            android.content.res.AssetManager r11 = r11.getAssets()     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            java.io.InputStream r11 = r11.open(r0)     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            goto L_0x00c8
        L_0x00ad:
            r11 = move-exception
            goto L_0x00ec
        L_0x00af:
            r11 = move-exception
            goto L_0x00ee
        L_0x00b1:
            if (r1 == 0) goto L_0x00be
            java.io.FileInputStream r11 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            java.io.File r0 = new java.io.File     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            r0.<init>(r1)     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            r11.<init>(r0)     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            goto L_0x00c8
        L_0x00be:
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            android.net.Uri r0 = (android.net.Uri) r0     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
            java.io.InputStream r11 = com.google.android.gms.internal.mlkit_common.zzg.zzb(r11, r0)     // Catch:{ IOException -> 0x00af, all -> 0x00ad }
        L_0x00c8:
            if (r11 == 0) goto L_0x00d1
            java.lang.String r0 = zzc(r11)     // Catch:{ IOException -> 0x00cf }
            goto L_0x00d2
        L_0x00cf:
            r12 = move-exception
            goto L_0x00f0
        L_0x00d1:
            r0 = r5
        L_0x00d2:
            if (r0 == 0) goto L_0x00d7
            r6.zzb(r9, r7, r0)     // Catch:{ IOException -> 0x00cf }
        L_0x00d7:
            boolean r12 = r12.isManifestFile()     // Catch:{ IOException -> 0x00cf }
            com.google.mlkit.common.internal.model.ModelUtils$ModelLoggingInfo r12 = com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo.zza(r7, r0, r12)     // Catch:{ IOException -> 0x00cf }
            if (r11 == 0) goto L_0x00eb
            r11.close()     // Catch:{ IOException -> 0x00e5 }
            goto L_0x00eb
        L_0x00e5:
            r11 = move-exception
            com.google.android.gms.common.internal.GmsLogger r0 = zza
            r0.e(r4, r10, r11)
        L_0x00eb:
            return r12
        L_0x00ec:
            r12 = r11
            goto L_0x0104
        L_0x00ee:
            r12 = r11
            r11 = r5
        L_0x00f0:
            com.google.android.gms.common.internal.GmsLogger r0 = zza     // Catch:{ all -> 0x0102 }
            r0.e(r4, r3, r12)     // Catch:{ all -> 0x0102 }
            if (r11 == 0) goto L_0x0101
            r11.close()     // Catch:{ IOException -> 0x00fb }
            goto L_0x0101
        L_0x00fb:
            r11 = move-exception
            com.google.android.gms.common.internal.GmsLogger r12 = zza
            r12.e(r4, r10, r11)
        L_0x0101:
            return r5
        L_0x0102:
            r12 = move-exception
            r5 = r11
        L_0x0104:
            if (r5 == 0) goto L_0x0110
            r5.close()     // Catch:{ IOException -> 0x010a }
            goto L_0x0110
        L_0x010a:
            r11 = move-exception
            com.google.android.gms.common.internal.GmsLogger r0 = zza
            r0.e(r4, r10, r11)
        L_0x0110:
            throw r12
        L_0x0111:
            r11 = move-exception
            if (r6 == 0) goto L_0x011c
            r6.close()     // Catch:{ all -> 0x0118 }
            goto L_0x011c
        L_0x0118:
            r12 = move-exception
            r11.addSuppressed(r12)     // Catch:{ IOException -> 0x011d }
        L_0x011c:
            throw r11     // Catch:{ IOException -> 0x011d }
        L_0x011d:
            r11 = move-exception
            com.google.android.gms.common.internal.GmsLogger r12 = zza
            r12.e(r4, r3, r11)
            return r5
        L_0x0124:
            com.google.android.gms.common.internal.GmsLogger r11 = zza
            java.lang.String r12 = "Local model doesn't have any valid path."
            r11.e(r4, r12)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.internal.model.ModelUtils.getModelLoggingInfo(android.content.Context, com.google.mlkit.common.model.LocalModel):com.google.mlkit.common.internal.model.ModelUtils$ModelLoggingInfo");
    }

    public static String getSHA256(File file) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            String zzc = zzc(fileInputStream);
            fileInputStream.close();
            return zzc;
        } catch (IOException e) {
            GmsLogger gmsLogger = zza;
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 44);
            sb.append("Failed to create FileInputStream for model: ");
            sb.append(valueOf);
            gmsLogger.e("ModelUtils", sb.toString());
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        if (new java.io.File(r5).exists() == false) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.mlkit.common.internal.model.ModelUtils.AutoMLManifest parseManifestFile(java.lang.String r5, boolean r6, android.content.Context r7) {
        /*
            com.google.android.gms.common.internal.GmsLogger r0 = zza
            java.lang.String r1 = java.lang.String.valueOf(r5)
            int r2 = r1.length()
            java.lang.String r3 = "Manifest file path: "
            if (r2 == 0) goto L_0x0013
            java.lang.String r1 = r3.concat(r1)
            goto L_0x0018
        L_0x0013:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3)
        L_0x0018:
            java.lang.String r2 = "ModelUtils"
            r0.d(r2, r1)
            r1 = 0
            if (r6 == 0) goto L_0x002e
            android.content.res.AssetManager r3 = r7.getAssets()     // Catch:{ IOException -> 0x0039 }
            java.io.InputStream r3 = r3.open(r5)     // Catch:{ IOException -> 0x0039 }
            if (r3 == 0) goto L_0x0041
            r3.close()     // Catch:{ IOException -> 0x0039 }
            goto L_0x0041
        L_0x002e:
            java.io.File r3 = new java.io.File
            r3.<init>(r5)
            boolean r3 = r3.exists()
            if (r3 != 0) goto L_0x0041
        L_0x0039:
            com.google.android.gms.common.internal.GmsLogger r5 = zza
            java.lang.String r6 = "Manifest file does not exist."
            r5.e(r2, r6)
            return r1
        L_0x0041:
            boolean r3 = r5.isEmpty()     // Catch:{ JSONException -> 0x00b8, IOException -> 0x00b6 }
            r4 = 0
            if (r3 == 0) goto L_0x004b
            byte[] r5 = new byte[r4]     // Catch:{ JSONException -> 0x00b8, IOException -> 0x00b6 }
            goto L_0x0070
        L_0x004b:
            if (r6 == 0) goto L_0x0056
            android.content.res.AssetManager r6 = r7.getAssets()     // Catch:{ JSONException -> 0x00b8, IOException -> 0x00b6 }
            java.io.InputStream r5 = r6.open(r5)     // Catch:{ JSONException -> 0x00b8, IOException -> 0x00b6 }
            goto L_0x0061
        L_0x0056:
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ JSONException -> 0x00b8, IOException -> 0x00b6 }
            java.io.File r7 = new java.io.File     // Catch:{ JSONException -> 0x00b8, IOException -> 0x00b6 }
            r7.<init>(r5)     // Catch:{ JSONException -> 0x00b8, IOException -> 0x00b6 }
            r6.<init>(r7)     // Catch:{ JSONException -> 0x00b8, IOException -> 0x00b6 }
            r5 = r6
        L_0x0061:
            int r6 = r5.available()     // Catch:{ all -> 0x00aa }
            byte[] r7 = new byte[r6]     // Catch:{ all -> 0x00aa }
            r5.read(r7, r4, r6)     // Catch:{ all -> 0x00aa }
            if (r5 == 0) goto L_0x006f
            r5.close()     // Catch:{ JSONException -> 0x00b8, IOException -> 0x00b6 }
        L_0x006f:
            r5 = r7
        L_0x0070:
            java.lang.String r6 = new java.lang.String     // Catch:{ JSONException -> 0x00b8, IOException -> 0x00b6 }
            java.lang.String r7 = "UTF-8"
            r6.<init>(r5, r7)     // Catch:{ JSONException -> 0x00b8, IOException -> 0x00b6 }
            java.lang.String r5 = "Json string from the manifest file: "
            int r7 = r6.length()     // Catch:{ JSONException -> 0x00b8, IOException -> 0x00b6 }
            if (r7 == 0) goto L_0x0084
            java.lang.String r5 = r5.concat(r6)     // Catch:{ JSONException -> 0x00b8, IOException -> 0x00b6 }
            goto L_0x008a
        L_0x0084:
            java.lang.String r7 = new java.lang.String     // Catch:{ JSONException -> 0x00b8, IOException -> 0x00b6 }
            r7.<init>(r5)     // Catch:{ JSONException -> 0x00b8, IOException -> 0x00b6 }
            r5 = r7
        L_0x008a:
            r0.d(r2, r5)     // Catch:{ JSONException -> 0x00b8, IOException -> 0x00b6 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00b8, IOException -> 0x00b6 }
            r5.<init>(r6)     // Catch:{ JSONException -> 0x00b8, IOException -> 0x00b6 }
            java.lang.String r6 = "modelType"
            java.lang.String r6 = r5.getString(r6)     // Catch:{ JSONException -> 0x00b8, IOException -> 0x00b6 }
            java.lang.String r7 = "modelFile"
            java.lang.String r7 = r5.getString(r7)     // Catch:{ JSONException -> 0x00b8, IOException -> 0x00b6 }
            java.lang.String r0 = "labelsFile"
            java.lang.String r5 = r5.getString(r0)     // Catch:{ JSONException -> 0x00b8, IOException -> 0x00b6 }
            com.google.mlkit.common.internal.model.AutoValue_ModelUtils_AutoMLManifest r0 = new com.google.mlkit.common.internal.model.AutoValue_ModelUtils_AutoMLManifest     // Catch:{ JSONException -> 0x00b8, IOException -> 0x00b6 }
            r0.<init>(r6, r7, r5)     // Catch:{ JSONException -> 0x00b8, IOException -> 0x00b6 }
            return r0
        L_0x00aa:
            r6 = move-exception
            if (r5 == 0) goto L_0x00b5
            r5.close()     // Catch:{ all -> 0x00b1 }
            goto L_0x00b5
        L_0x00b1:
            r5 = move-exception
            r6.addSuppressed(r5)     // Catch:{ JSONException -> 0x00b8, IOException -> 0x00b6 }
        L_0x00b5:
            throw r6     // Catch:{ JSONException -> 0x00b8, IOException -> 0x00b6 }
        L_0x00b6:
            r5 = move-exception
            goto L_0x00b9
        L_0x00b8:
            r5 = move-exception
        L_0x00b9:
            com.google.android.gms.common.internal.GmsLogger r6 = zza
            java.lang.String r7 = "Error parsing the manifest file."
            r6.e(r2, r7, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.internal.model.ModelUtils.parseManifestFile(java.lang.String, boolean, android.content.Context):com.google.mlkit.common.internal.model.ModelUtils$AutoMLManifest");
    }

    public static boolean zza(File file, String str) {
        String sha256 = getSHA256(file);
        GmsLogger gmsLogger = zza;
        String valueOf = String.valueOf(sha256);
        gmsLogger.d("ModelUtils", valueOf.length() != 0 ? "Calculated hash value is: ".concat(valueOf) : new String("Calculated hash value is: "));
        return str.equals(sha256);
    }

    private static String zzb(Context context, String str, boolean z) {
        AutoMLManifest parseManifestFile = parseManifestFile(str, z, context);
        if (parseManifestFile != null) {
            return new File(new File(str).getParent(), parseManifestFile.getModelFile()).toString();
        }
        zza.e("ModelUtils", "Failed to parse manifest file.");
        return null;
    }

    private static String zzc(InputStream inputStream) {
        int i;
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            byte[] bArr = new byte[1048576];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                instance.update(bArr, 0, read);
            }
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & UByte.MAX_VALUE);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            zza.e("ModelUtils", "Do not have SHA-256 algorithm");
            return null;
        } catch (IOException unused2) {
            zza.e("ModelUtils", "Failed to read model file");
            return null;
        }
    }
}
