package com.google.firebase.auth;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zztk;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zze;

/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
final class zzp implements OnCompleteListener<zze> {
    final /* synthetic */ PhoneAuthOptions zza;
    final /* synthetic */ FirebaseAuth zzb;

    zzp(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions) {
        this.zzb = firebaseAuth;
        this.zza = phoneAuthOptions;
    }

    public final void onComplete(Task<zze> task) {
        String str;
        String str2;
        if (!task.isSuccessful()) {
            String str3 = "Error while validating application identity: ";
            if (task.getException() != null) {
                String valueOf = String.valueOf(task.getException().getMessage());
                if (valueOf.length() != 0) {
                    str3 = str3.concat(valueOf);
                } else {
                    str3 = new String(str3);
                }
            }
            Log.e("FirebaseAuth", str3);
            Log.e("FirebaseAuth", "Proceeding without any application identifier.");
            str2 = null;
            str = null;
        } else {
            String zzb2 = task.getResult().zzb();
            str = task.getResult().zza();
            str2 = zzb2;
        }
        long longValue = this.zza.zzg().longValue();
        PhoneAuthProvider.OnVerificationStateChangedCallbacks zzt = this.zzb.zzJ(this.zza.zzh(), this.zza.zze());
        zzag zzag = (zzag) Preconditions.checkNotNull(this.zza.zzc());
        if (zzag.zze()) {
            this.zzb.zze.zzH(zzag, (String) Preconditions.checkNotNull(this.zza.zzh()), this.zzb.zzi, longValue, this.zza.zzd() != null, this.zza.zzj(), str2, str, zztk.zzb(), zzt, this.zza.zzi(), this.zza.zza());
        } else {
            this.zzb.zze.zzI(zzag, (PhoneMultiFactorInfo) Preconditions.checkNotNull(this.zza.zzf()), this.zzb.zzi, longValue, this.zza.zzd() != null, this.zza.zzj(), str2, str, zztk.zzb(), zzt, this.zza.zzi(), this.zza.zza());
        }
    }
}
