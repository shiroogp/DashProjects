package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.interfaces.ECPrivateKey;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzkl {
    private final ECPrivateKey zza;

    public zzkl(ECPrivateKey eCPrivateKey) {
        this.zza = eCPrivateKey;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01e1 A[SYNTHETIC, Splitter:B:71:0x01e1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zza(byte[] r10, java.lang.String r11, byte[] r12, byte[] r13, int r14, int r15) throws java.security.GeneralSecurityException {
        /*
            r9 = this;
            java.security.interfaces.ECPrivateKey r13 = r9.zza
            java.security.spec.ECParameterSpec r13 = r13.getParams()
            java.security.spec.EllipticCurve r0 = r13.getCurve()
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzkn.zza(r0)
            r2 = -1
            int r15 = r15 + r2
            java.lang.String r3 = "invalid point size"
            r4 = 2
            r5 = 0
            r6 = 1
            if (r15 == 0) goto L_0x008a
            if (r15 == r4) goto L_0x0063
            java.math.BigInteger r15 = com.google.android.gms.internal.p002firebaseauthapi.zzkn.zzb(r0)
            int r3 = r10.length
            int r1 = r1 + r6
            if (r3 != r1) goto L_0x005b
            byte r1 = r10[r5]
            if (r1 != r4) goto L_0x0027
            r1 = r5
            goto L_0x002b
        L_0x0027:
            r7 = 3
            if (r1 != r7) goto L_0x0053
            r1 = r6
        L_0x002b:
            java.math.BigInteger r7 = new java.math.BigInteger
            byte[] r3 = java.util.Arrays.copyOfRange(r10, r6, r3)
            r7.<init>(r6, r3)
            int r3 = r7.signum()
            if (r3 == r2) goto L_0x004a
            int r15 = r7.compareTo(r15)
            if (r15 >= 0) goto L_0x004a
            java.math.BigInteger r15 = com.google.android.gms.internal.p002firebaseauthapi.zzkn.zzc(r7, r1, r0)
            java.security.spec.ECPoint r0 = new java.security.spec.ECPoint
            r0.<init>(r7, r15)
            goto L_0x00b1
        L_0x004a:
            java.security.GeneralSecurityException r10 = new java.security.GeneralSecurityException
            java.lang.String r11 = "x is out of range"
            r10.<init>(r11)
            throw r10
        L_0x0053:
            java.security.GeneralSecurityException r10 = new java.security.GeneralSecurityException
            java.lang.String r11 = "invalid format"
            r10.<init>(r11)
            throw r10
        L_0x005b:
            java.security.GeneralSecurityException r10 = new java.security.GeneralSecurityException
            java.lang.String r11 = "compressed point has wrong length"
            r10.<init>(r11)
            throw r10
        L_0x0063:
            int r15 = r10.length
            int r7 = r1 + r1
            if (r15 != r7) goto L_0x0084
            java.math.BigInteger r3 = new java.math.BigInteger
            byte[] r7 = java.util.Arrays.copyOfRange(r10, r5, r1)
            r3.<init>(r6, r7)
            java.math.BigInteger r7 = new java.math.BigInteger
            byte[] r15 = java.util.Arrays.copyOfRange(r10, r1, r15)
            r7.<init>(r6, r15)
            java.security.spec.ECPoint r15 = new java.security.spec.ECPoint
            r15.<init>(r3, r7)
            com.google.android.gms.internal.p002firebaseauthapi.zzkn.zzd(r15, r0)
        L_0x0082:
            r0 = r15
            goto L_0x00b1
        L_0x0084:
            java.security.GeneralSecurityException r10 = new java.security.GeneralSecurityException
            r10.<init>(r3)
            throw r10
        L_0x008a:
            int r15 = r10.length
            int r7 = r1 + r1
            int r7 = r7 + r6
            if (r15 != r7) goto L_0x01fe
            byte r3 = r10[r5]
            r7 = 4
            if (r3 != r7) goto L_0x01f6
            int r1 = r1 + r6
            java.math.BigInteger r3 = new java.math.BigInteger
            byte[] r7 = java.util.Arrays.copyOfRange(r10, r6, r1)
            r3.<init>(r6, r7)
            java.math.BigInteger r7 = new java.math.BigInteger
            byte[] r15 = java.util.Arrays.copyOfRange(r10, r1, r15)
            r7.<init>(r6, r15)
            java.security.spec.ECPoint r15 = new java.security.spec.ECPoint
            r15.<init>(r3, r7)
            com.google.android.gms.internal.p002firebaseauthapi.zzkn.zzd(r15, r0)
            goto L_0x0082
        L_0x00b1:
            java.security.spec.ECPublicKeySpec r15 = new java.security.spec.ECPublicKeySpec
            r15.<init>(r0, r13)
            com.google.android.gms.internal.firebase-auth-api.zzkp<com.google.android.gms.internal.firebase-auth-api.zzks, java.security.KeyFactory> r13 = com.google.android.gms.internal.p002firebaseauthapi.zzkp.zzg
            java.lang.String r0 = "EC"
            java.lang.Object r13 = r13.zza(r0)
            java.security.KeyFactory r13 = (java.security.KeyFactory) r13
            java.security.PublicKey r13 = r13.generatePublic(r15)
            java.security.interfaces.ECPublicKey r13 = (java.security.interfaces.ECPublicKey) r13
            java.security.interfaces.ECPrivateKey r15 = r9.zza
            java.security.spec.ECParameterSpec r1 = r13.getParams()     // Catch:{ IllegalArgumentException -> 0x01eb, NullPointerException -> 0x01e9 }
            java.security.spec.ECParameterSpec r3 = r15.getParams()     // Catch:{ IllegalArgumentException -> 0x01eb, NullPointerException -> 0x01e9 }
            java.security.spec.EllipticCurve r7 = r1.getCurve()     // Catch:{ IllegalArgumentException -> 0x01eb, NullPointerException -> 0x01e9 }
            java.security.spec.EllipticCurve r8 = r3.getCurve()     // Catch:{ IllegalArgumentException -> 0x01eb, NullPointerException -> 0x01e9 }
            boolean r7 = r7.equals(r8)     // Catch:{ IllegalArgumentException -> 0x01eb, NullPointerException -> 0x01e9 }
            if (r7 == 0) goto L_0x01e1
            java.security.spec.ECPoint r7 = r1.getGenerator()     // Catch:{ IllegalArgumentException -> 0x01eb, NullPointerException -> 0x01e9 }
            java.security.spec.ECPoint r8 = r3.getGenerator()     // Catch:{ IllegalArgumentException -> 0x01eb, NullPointerException -> 0x01e9 }
            boolean r7 = r7.equals(r8)     // Catch:{ IllegalArgumentException -> 0x01eb, NullPointerException -> 0x01e9 }
            if (r7 == 0) goto L_0x01e1
            java.math.BigInteger r7 = r1.getOrder()     // Catch:{ IllegalArgumentException -> 0x01eb, NullPointerException -> 0x01e9 }
            java.math.BigInteger r8 = r3.getOrder()     // Catch:{ IllegalArgumentException -> 0x01eb, NullPointerException -> 0x01e9 }
            boolean r7 = r7.equals(r8)     // Catch:{ IllegalArgumentException -> 0x01eb, NullPointerException -> 0x01e9 }
            if (r7 == 0) goto L_0x01e1
            int r1 = r1.getCofactor()     // Catch:{ IllegalArgumentException -> 0x01eb, NullPointerException -> 0x01e9 }
            int r3 = r3.getCofactor()     // Catch:{ IllegalArgumentException -> 0x01eb, NullPointerException -> 0x01e9 }
            if (r1 != r3) goto L_0x01e1
            java.security.spec.ECPoint r13 = r13.getW()
            java.security.spec.ECParameterSpec r1 = r15.getParams()
            java.security.spec.EllipticCurve r1 = r1.getCurve()
            com.google.android.gms.internal.p002firebaseauthapi.zzkn.zzd(r13, r1)
            java.security.spec.ECParameterSpec r1 = r15.getParams()
            java.security.spec.ECPublicKeySpec r3 = new java.security.spec.ECPublicKeySpec
            r3.<init>(r13, r1)
            com.google.android.gms.internal.firebase-auth-api.zzkp<com.google.android.gms.internal.firebase-auth-api.zzks, java.security.KeyFactory> r13 = com.google.android.gms.internal.p002firebaseauthapi.zzkp.zzg
            java.lang.Object r13 = r13.zza(r0)
            java.security.KeyFactory r13 = (java.security.KeyFactory) r13
            java.security.PublicKey r13 = r13.generatePublic(r3)
            com.google.android.gms.internal.firebase-auth-api.zzkp<com.google.android.gms.internal.firebase-auth-api.zzkr, javax.crypto.KeyAgreement> r0 = com.google.android.gms.internal.p002firebaseauthapi.zzkp.zze
            java.lang.String r1 = "ECDH"
            java.lang.Object r0 = r0.zza(r1)
            javax.crypto.KeyAgreement r0 = (javax.crypto.KeyAgreement) r0
            r0.init(r15)
            r0.doPhase(r13, r6)     // Catch:{ IllegalStateException -> 0x01d6 }
            byte[] r13 = r0.generateSecret()     // Catch:{ IllegalStateException -> 0x01d6 }
            java.security.spec.ECParameterSpec r15 = r15.getParams()     // Catch:{ IllegalStateException -> 0x01d6 }
            java.security.spec.EllipticCurve r15 = r15.getCurve()     // Catch:{ IllegalStateException -> 0x01d6 }
            java.math.BigInteger r0 = new java.math.BigInteger     // Catch:{ IllegalStateException -> 0x01d6 }
            r0.<init>(r6, r13)     // Catch:{ IllegalStateException -> 0x01d6 }
            int r1 = r0.signum()     // Catch:{ IllegalStateException -> 0x01d6 }
            if (r1 == r2) goto L_0x01cd
            java.math.BigInteger r1 = com.google.android.gms.internal.p002firebaseauthapi.zzkn.zzb(r15)     // Catch:{ IllegalStateException -> 0x01d6 }
            int r1 = r0.compareTo(r1)     // Catch:{ IllegalStateException -> 0x01d6 }
            if (r1 >= 0) goto L_0x01cd
            com.google.android.gms.internal.p002firebaseauthapi.zzkn.zzc(r0, r6, r15)     // Catch:{ IllegalStateException -> 0x01d6 }
            byte[][] r15 = new byte[r4][]
            r15[r5] = r10
            r15[r6] = r13
            byte[] r10 = com.google.android.gms.internal.p002firebaseauthapi.zzkd.zzc(r15)
            com.google.android.gms.internal.firebase-auth-api.zzkp<com.google.android.gms.internal.firebase-auth-api.zzku, javax.crypto.Mac> r13 = com.google.android.gms.internal.p002firebaseauthapi.zzkp.zzb
            java.lang.Object r13 = r13.zza(r11)
            javax.crypto.Mac r13 = (javax.crypto.Mac) r13
            int r15 = r13.getMacLength()
            int r15 = r15 * 255
            if (r14 > r15) goto L_0x01c4
            if (r12 == 0) goto L_0x0185
            int r15 = r12.length
            if (r15 != 0) goto L_0x017c
            goto L_0x0185
        L_0x017c:
            javax.crypto.spec.SecretKeySpec r15 = new javax.crypto.spec.SecretKeySpec
            r15.<init>(r12, r11)
            r13.init(r15)
            goto L_0x0193
        L_0x0185:
            javax.crypto.spec.SecretKeySpec r12 = new javax.crypto.spec.SecretKeySpec
            int r15 = r13.getMacLength()
            byte[] r15 = new byte[r15]
            r12.<init>(r15, r11)
            r13.init(r12)
        L_0x0193:
            byte[] r10 = r13.doFinal(r10)
            byte[] r12 = new byte[r14]
            javax.crypto.spec.SecretKeySpec r15 = new javax.crypto.spec.SecretKeySpec
            r15.<init>(r10, r11)
            r13.init(r15)
            byte[] r10 = new byte[r5]
            r11 = r5
        L_0x01a4:
            r13.update(r10)
            r10 = 0
            r13.update(r10)
            byte r10 = (byte) r6
            r13.update(r10)
            byte[] r10 = r13.doFinal()
            int r15 = r10.length
            int r0 = r11 + r15
            if (r0 >= r14) goto L_0x01bf
            java.lang.System.arraycopy(r10, r5, r12, r11, r15)
            int r6 = r6 + 1
            r11 = r0
            goto L_0x01a4
        L_0x01bf:
            int r14 = r14 - r11
            java.lang.System.arraycopy(r10, r5, r12, r11, r14)
            return r12
        L_0x01c4:
            java.security.GeneralSecurityException r10 = new java.security.GeneralSecurityException
            java.lang.String r11 = "size too large"
            r10.<init>(r11)
            throw r10
        L_0x01cd:
            java.security.GeneralSecurityException r10 = new java.security.GeneralSecurityException     // Catch:{ IllegalStateException -> 0x01d6 }
            java.lang.String r11 = "shared secret is out of range"
            r10.<init>(r11)     // Catch:{ IllegalStateException -> 0x01d6 }
            throw r10     // Catch:{ IllegalStateException -> 0x01d6 }
        L_0x01d6:
            r10 = move-exception
            java.security.GeneralSecurityException r11 = new java.security.GeneralSecurityException
            java.lang.String r10 = r10.toString()
            r11.<init>(r10)
            throw r11
        L_0x01e1:
            java.security.GeneralSecurityException r10 = new java.security.GeneralSecurityException     // Catch:{ IllegalArgumentException -> 0x01eb, NullPointerException -> 0x01e9 }
            java.lang.String r11 = "invalid public key spec"
            r10.<init>(r11)     // Catch:{ IllegalArgumentException -> 0x01eb, NullPointerException -> 0x01e9 }
            throw r10     // Catch:{ IllegalArgumentException -> 0x01eb, NullPointerException -> 0x01e9 }
        L_0x01e9:
            r10 = move-exception
            goto L_0x01ec
        L_0x01eb:
            r10 = move-exception
        L_0x01ec:
            java.security.GeneralSecurityException r11 = new java.security.GeneralSecurityException
            java.lang.String r10 = r10.toString()
            r11.<init>(r10)
            throw r11
        L_0x01f6:
            java.security.GeneralSecurityException r10 = new java.security.GeneralSecurityException
            java.lang.String r11 = "invalid point format"
            r10.<init>(r11)
            throw r10
        L_0x01fe:
            java.security.GeneralSecurityException r10 = new java.security.GeneralSecurityException
            r10.<init>(r3)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzkl.zza(byte[], java.lang.String, byte[], byte[], int, int):byte[]");
    }
}
