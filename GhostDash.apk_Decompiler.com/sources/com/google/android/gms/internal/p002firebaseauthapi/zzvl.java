package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
final class zzvl extends BroadcastReceiver {
    final /* synthetic */ zzvn zza;
    private final String zzb;

    public zzvl(zzvn zzvn, String str) {
        this.zza = zzvn;
        this.zzb = str;
    }

    public final void onReceive(Context context, Intent intent) {
        if (SmsRetriever.SMS_RETRIEVED_ACTION.equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            if (((Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")).getStatusCode() == 0) {
                String str = (String) extras.get(SmsRetriever.EXTRA_SMS_MESSAGE);
                zzvm zzvm = (zzvm) this.zza.zzd.get(this.zzb);
                if (zzvm == null) {
                    zzvn.zza.e("Verification code received with no active retrieval session.", new Object[0]);
                } else {
                    zzvm.zze = zzvn.zzb(str);
                    if (zzvm.zze == null) {
                        zzvn.zza.e("Unable to extract verification code.", new Object[0]);
                    } else if (!zzaf.zzd(zzvm.zzd)) {
                        zzvn.zze(this.zza, this.zzb);
                    }
                }
            }
            context.getApplicationContext().unregisterReceiver(this);
        }
    }
}
