package com.google.android.gms.internal.mlkit_vision_text;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
final class zzhf implements ObjectEncoder<zzki> {
    static final zzhf zza = new zzhf();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;
    private static final FieldDescriptor zzh;
    private static final FieldDescriptor zzi;
    private static final FieldDescriptor zzj;
    private static final FieldDescriptor zzk;
    private static final FieldDescriptor zzl;
    private static final FieldDescriptor zzm;
    private static final FieldDescriptor zzn;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("appId");
        zzcm zzcm = new zzcm();
        zzcm.zza(1);
        zzb = builder.withProperty(zzcm.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("appVersion");
        zzcm zzcm2 = new zzcm();
        zzcm2.zza(2);
        zzc = builder2.withProperty(zzcm2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("firebaseProjectId");
        zzcm zzcm3 = new zzcm();
        zzcm3.zza(3);
        zzd = builder3.withProperty(zzcm3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("mlSdkVersion");
        zzcm zzcm4 = new zzcm();
        zzcm4.zza(4);
        zze = builder4.withProperty(zzcm4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("tfliteSchemaVersion");
        zzcm zzcm5 = new zzcm();
        zzcm5.zza(5);
        zzf = builder5.withProperty(zzcm5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("gcmSenderId");
        zzcm zzcm6 = new zzcm();
        zzcm6.zza(6);
        zzg = builder6.withProperty(zzcm6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("apiKey");
        zzcm zzcm7 = new zzcm();
        zzcm7.zza(7);
        zzh = builder7.withProperty(zzcm7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("languages");
        zzcm zzcm8 = new zzcm();
        zzcm8.zza(8);
        zzi = builder8.withProperty(zzcm8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("mlSdkInstanceId");
        zzcm zzcm9 = new zzcm();
        zzcm9.zza(9);
        zzj = builder9.withProperty(zzcm9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("isClearcutClient");
        zzcm zzcm10 = new zzcm();
        zzcm10.zza(10);
        zzk = builder10.withProperty(zzcm10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("isStandaloneMlkit");
        zzcm zzcm11 = new zzcm();
        zzcm11.zza(11);
        zzl = builder11.withProperty(zzcm11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("isJsonLogging");
        zzcm zzcm12 = new zzcm();
        zzcm12.zza(12);
        zzm = builder12.withProperty(zzcm12.zzb()).build();
        FieldDescriptor.Builder builder13 = FieldDescriptor.builder("buildLevel");
        zzcm zzcm13 = new zzcm();
        zzcm13.zza(13);
        zzn = builder13.withProperty(zzcm13.zzb()).build();
    }

    private zzhf() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzki zzki = (zzki) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(zzb, (Object) zzki.zzf());
        objectEncoderContext.add(zzc, (Object) zzki.zzg());
        objectEncoderContext.add(zzd, (Object) null);
        objectEncoderContext.add(zze, (Object) zzki.zzi());
        objectEncoderContext.add(zzf, (Object) zzki.zzj());
        objectEncoderContext.add(zzg, (Object) null);
        objectEncoderContext.add(zzh, (Object) null);
        objectEncoderContext.add(zzi, (Object) zzki.zza());
        objectEncoderContext.add(zzj, (Object) zzki.zzh());
        objectEncoderContext.add(zzk, (Object) zzki.zzb());
        objectEncoderContext.add(zzl, (Object) zzki.zzd());
        objectEncoderContext.add(zzm, (Object) zzki.zzc());
        objectEncoderContext.add(zzn, (Object) zzki.zze());
    }
}
