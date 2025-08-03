package com.google.android.gms.auth;

import com.google.android.gms.common.Feature;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zze {
    public static final Feature zza;
    public static final Feature zzb;
    public static final Feature zzc;
    public static final Feature zzd;
    public static final Feature zze;
    public static final Feature zzf;
    public static final Feature zzg;
    public static final Feature zzh;
    public static final Feature zzi;
    public static final Feature[] zzj;

    static {
        Feature feature = new Feature("account_capability_api", 1);
        zza = feature;
        Feature feature2 = new Feature("account_data_service", 6);
        zzb = feature2;
        Feature feature3 = new Feature("account_data_service_legacy", 1);
        zzc = feature3;
        Feature feature4 = new Feature("account_data_service_token", 4);
        zzd = feature4;
        Feature feature5 = new Feature("account_data_service_visibility", 1);
        zze = feature5;
        Feature feature6 = new Feature("google_auth_service_token", 3);
        zzf = feature6;
        Feature feature7 = new Feature("google_auth_service_accounts", 2);
        zzg = feature7;
        Feature feature8 = new Feature("work_account_client_is_whitelisted", 1);
        zzh = feature8;
        Feature feature9 = new Feature("config_sync", 1);
        zzi = feature9;
        zzj = new Feature[]{feature, feature2, feature3, feature4, feature5, feature6, feature7, feature8, feature9};
    }
}
