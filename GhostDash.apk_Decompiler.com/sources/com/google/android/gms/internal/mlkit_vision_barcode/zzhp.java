package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
final class zzhp implements ObjectEncoder<zzkw> {
    static final zzhp zza = new zzhp();
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
        zzcw zzcw = new zzcw();
        zzcw.zza(1);
        zzb = builder.withProperty(zzcw.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("appVersion");
        zzcw zzcw2 = new zzcw();
        zzcw2.zza(2);
        zzc = builder2.withProperty(zzcw2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("firebaseProjectId");
        zzcw zzcw3 = new zzcw();
        zzcw3.zza(3);
        zzd = builder3.withProperty(zzcw3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("mlSdkVersion");
        zzcw zzcw4 = new zzcw();
        zzcw4.zza(4);
        zze = builder4.withProperty(zzcw4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("tfliteSchemaVersion");
        zzcw zzcw5 = new zzcw();
        zzcw5.zza(5);
        zzf = builder5.withProperty(zzcw5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("gcmSenderId");
        zzcw zzcw6 = new zzcw();
        zzcw6.zza(6);
        zzg = builder6.withProperty(zzcw6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("apiKey");
        zzcw zzcw7 = new zzcw();
        zzcw7.zza(7);
        zzh = builder7.withProperty(zzcw7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("languages");
        zzcw zzcw8 = new zzcw();
        zzcw8.zza(8);
        zzi = builder8.withProperty(zzcw8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("mlSdkInstanceId");
        zzcw zzcw9 = new zzcw();
        zzcw9.zza(9);
        zzj = builder9.withProperty(zzcw9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("isClearcutClient");
        zzcw zzcw10 = new zzcw();
        zzcw10.zza(10);
        zzk = builder10.withProperty(zzcw10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("isStandaloneMlkit");
        zzcw zzcw11 = new zzcw();
        zzcw11.zza(11);
        zzl = builder11.withProperty(zzcw11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("isJsonLogging");
        zzcw zzcw12 = new zzcw();
        zzcw12.zza(12);
        zzm = builder12.withProperty(zzcw12.zzb()).build();
        FieldDescriptor.Builder builder13 = FieldDescriptor.builder("buildLevel");
        zzcw zzcw13 = new zzcw();
        zzcw13.zza(13);
        zzn = builder13.withProperty(zzcw13.zzb()).build();
    }

    private zzhp() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzkw zzkw = (zzkw) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(zzb, (Object) zzkw.zzf());
        objectEncoderContext.add(zzc, (Object) zzkw.zzg());
        objectEncoderContext.add(zzd, (Object) null);
        objectEncoderContext.add(zze, (Object) zzkw.zzi());
        objectEncoderContext.add(zzf, (Object) zzkw.zzj());
        objectEncoderContext.add(zzg, (Object) null);
        objectEncoderContext.add(zzh, (Object) null);
        objectEncoderContext.add(zzi, (Object) zzkw.zza());
        objectEncoderContext.add(zzj, (Object) zzkw.zzh());
        objectEncoderContext.add(zzk, (Object) zzkw.zzb());
        objectEncoderContext.add(zzl, (Object) zzkw.zzd());
        objectEncoderContext.add(zzm, (Object) zzkw.zzc());
        objectEncoderContext.add(zzn, (Object) zzkw.zze());
    }
}
