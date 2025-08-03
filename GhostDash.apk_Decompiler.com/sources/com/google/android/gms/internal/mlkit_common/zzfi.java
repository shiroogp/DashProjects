package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:common@@17.2.0 */
final class zzfi implements ObjectEncoder<zzis> {
    static final zzfi zza = new zzfi();
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
        zzas zzas = new zzas();
        zzas.zza(1);
        zzb = builder.withProperty(zzas.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("appVersion");
        zzas zzas2 = new zzas();
        zzas2.zza(2);
        zzc = builder2.withProperty(zzas2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("firebaseProjectId");
        zzas zzas3 = new zzas();
        zzas3.zza(3);
        zzd = builder3.withProperty(zzas3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("mlSdkVersion");
        zzas zzas4 = new zzas();
        zzas4.zza(4);
        zze = builder4.withProperty(zzas4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("tfliteSchemaVersion");
        zzas zzas5 = new zzas();
        zzas5.zza(5);
        zzf = builder5.withProperty(zzas5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("gcmSenderId");
        zzas zzas6 = new zzas();
        zzas6.zza(6);
        zzg = builder6.withProperty(zzas6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("apiKey");
        zzas zzas7 = new zzas();
        zzas7.zza(7);
        zzh = builder7.withProperty(zzas7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("languages");
        zzas zzas8 = new zzas();
        zzas8.zza(8);
        zzi = builder8.withProperty(zzas8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("mlSdkInstanceId");
        zzas zzas9 = new zzas();
        zzas9.zza(9);
        zzj = builder9.withProperty(zzas9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("isClearcutClient");
        zzas zzas10 = new zzas();
        zzas10.zza(10);
        zzk = builder10.withProperty(zzas10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("isStandaloneMlkit");
        zzas zzas11 = new zzas();
        zzas11.zza(11);
        zzl = builder11.withProperty(zzas11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("isJsonLogging");
        zzas zzas12 = new zzas();
        zzas12.zza(12);
        zzm = builder12.withProperty(zzas12.zzb()).build();
        FieldDescriptor.Builder builder13 = FieldDescriptor.builder("buildLevel");
        zzas zzas13 = new zzas();
        zzas13.zza(13);
        zzn = builder13.withProperty(zzas13.zzb()).build();
    }

    private zzfi() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzis zzis = (zzis) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(zzb, (Object) zzis.zzf());
        objectEncoderContext.add(zzc, (Object) zzis.zzg());
        objectEncoderContext.add(zzd, (Object) null);
        objectEncoderContext.add(zze, (Object) zzis.zzi());
        objectEncoderContext.add(zzf, (Object) zzis.zzj());
        objectEncoderContext.add(zzg, (Object) null);
        objectEncoderContext.add(zzh, (Object) null);
        objectEncoderContext.add(zzi, (Object) zzis.zza());
        objectEncoderContext.add(zzj, (Object) zzis.zzh());
        objectEncoderContext.add(zzk, (Object) zzis.zzb());
        objectEncoderContext.add(zzl, (Object) zzis.zzd());
        objectEncoderContext.add(zzm, (Object) zzis.zzc());
        objectEncoderContext.add(zzn, (Object) zzis.zze());
    }
}
