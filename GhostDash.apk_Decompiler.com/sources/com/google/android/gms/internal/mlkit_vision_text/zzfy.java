package com.google.android.gms.internal.mlkit_vision_text;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
final class zzfy implements ObjectEncoder<zzix> {
    static final zzfy zza = new zzfy();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;
    private static final FieldDescriptor zzh;
    private static final FieldDescriptor zzi;
    private static final FieldDescriptor zzj;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder(AppMeasurementSdk.ConditionalUserProperty.NAME);
        zzcm zzcm = new zzcm();
        zzcm.zza(1);
        zzb = builder.withProperty(zzcm.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("version");
        zzcm zzcm2 = new zzcm();
        zzcm2.zza(2);
        zzc = builder2.withProperty(zzcm2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder(FirebaseAnalytics.Param.SOURCE);
        zzcm zzcm3 = new zzcm();
        zzcm3.zza(3);
        zzd = builder3.withProperty(zzcm3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("uri");
        zzcm zzcm4 = new zzcm();
        zzcm4.zza(4);
        zze = builder4.withProperty(zzcm4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("hash");
        zzcm zzcm5 = new zzcm();
        zzcm5.zza(5);
        zzf = builder5.withProperty(zzcm5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("modelType");
        zzcm zzcm6 = new zzcm();
        zzcm6.zza(6);
        zzg = builder6.withProperty(zzcm6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("size");
        zzcm zzcm7 = new zzcm();
        zzcm7.zza(7);
        zzh = builder7.withProperty(zzcm7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("hasLabelMap");
        zzcm zzcm8 = new zzcm();
        zzcm8.zza(8);
        zzi = builder8.withProperty(zzcm8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("isManifestModel");
        zzcm zzcm9 = new zzcm();
        zzcm9.zza(9);
        zzj = builder9.withProperty(zzcm9.zzb()).build();
    }

    private zzfy() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzix zzix = (zzix) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
