package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApi;
import com.google.firebase.FirebaseExceptionMapper;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
final class zztj implements Callable<zzpu<zzuf>> {
    private final zzuf zza;
    private final Context zzb;

    public zztj(zzuf zzuf, Context context) {
        this.zza = zzuf;
        this.zzb = context;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.zzb, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        boolean unused = zztk.zza = isGooglePlayServicesAvailable == 0 || isGooglePlayServicesAvailable == 2;
        Context context = this.zzb;
        zzuf zzb2 = this.zza.zza();
        zzb2.zza = true;
        return new zzpu(new zzpw(context, zzug.zzb, zzb2, new GoogleApi.Settings.Builder().setMapper(new FirebaseExceptionMapper()).build()));
    }
}
