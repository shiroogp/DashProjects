package com.google.android.gms.internal.mlkit_vision_face;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
final class zzha implements ObjectEncoder<zzkl> {
    static final zzha zza = new zzha();
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
        zzch zzch = new zzch();
        zzch.zza(1);
        zzb = builder.withProperty(zzch.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("appVersion");
        zzch zzch2 = new zzch();
        zzch2.zza(2);
        zzc = builder2.withProperty(zzch2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("firebaseProjectId");
        zzch zzch3 = new zzch();
        zzch3.zza(3);
        zzd = builder3.withProperty(zzch3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("mlSdkVersion");
        zzch zzch4 = new zzch();
        zzch4.zza(4);
        zze = builder4.withProperty(zzch4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("tfliteSchemaVersion");
        zzch zzch5 = new zzch();
        zzch5.zza(5);
        zzf = builder5.withProperty(zzch5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("gcmSenderId");
        zzch zzch6 = new zzch();
        zzch6.zza(6);
        zzg = builder6.withProperty(zzch6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("apiKey");
        zzch zzch7 = new zzch();
        zzch7.zza(7);
        zzh = builder7.withProperty(zzch7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("languages");
        zzch zzch8 = new zzch();
        zzch8.zza(8);
        zzi = builder8.withProperty(zzch8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("mlSdkInstanceId");
        zzch zzch9 = new zzch();
        zzch9.zza(9);
        zzj = builder9.withProperty(zzch9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("isClearcutClient");
        zzch zzch10 = new zzch();
        zzch10.zza(10);
        zzk = builder10.withProperty(zzch10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("isStandaloneMlkit");
        zzch zzch11 = new zzch();
        zzch11.zza(11);
        zzl = builder11.withProperty(zzch11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("isJsonLogging");
        zzch zzch12 = new zzch();
        zzch12.zza(12);
        zzm = builder12.withProperty(zzch12.zzb()).build();
        FieldDescriptor.Builder builder13 = FieldDescriptor.builder("buildLevel");
        zzch zzch13 = new zzch();
        zzch13.zza(13);
        zzn = builder13.withProperty(zzch13.zzb()).build();
    }

    private zzha() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzkl zzkl = (zzkl) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(zzb, (Object) zzkl.zzf());
        objectEncoderContext.add(zzc, (Object) zzkl.zzg());
        objectEncoderContext.add(zzd, (Object) null);
        objectEncoderContext.add(zze, (Object) zzkl.zzi());
        objectEncoderContext.add(zzf, (Object) zzkl.zzj());
        objectEncoderContext.add(zzg, (Object) null);
        objectEncoderContext.add(zzh, (Object) null);
        objectEncoderContext.add(zzi, (Object) zzkl.zza());
        objectEncoderContext.add(zzj, (Object) zzkl.zzh());
        objectEncoderContext.add(zzk, (Object) zzkl.zzb());
        objectEncoderContext.add(zzl, (Object) zzkl.zzd());
        objectEncoderContext.add(zzm, (Object) zzkl.zzc());
        objectEncoderContext.add(zzn, (Object) zzkl.zze());
    }
}
