package com.google.android.gms.internal.mlkit_vision_common;

import com.facebook.imagepipeline.producers.DecodeProducer;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
final class zzcv implements ObjectEncoder<zzfn> {
    static final zzcv zza = new zzcv();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;
    private static final FieldDescriptor zzh;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("durationMs");
        zzt zzt = new zzt();
        zzt.zza(1);
        zzb = builder.withProperty(zzt.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("imageSource");
        zzt zzt2 = new zzt();
        zzt2.zza(2);
        zzc = builder2.withProperty(zzt2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder(DecodeProducer.EXTRA_IMAGE_FORMAT_NAME);
        zzt zzt3 = new zzt();
        zzt3.zza(3);
        zzd = builder3.withProperty(zzt3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("imageByteSize");
        zzt zzt4 = new zzt();
        zzt4.zza(4);
        zze = builder4.withProperty(zzt4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("imageWidth");
        zzt zzt5 = new zzt();
        zzt5.zza(5);
        zzf = builder5.withProperty(zzt5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("imageHeight");
        zzt zzt6 = new zzt();
        zzt6.zza(6);
        zzg = builder6.withProperty(zzt6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("rotationDegrees");
        zzt zzt7 = new zzt();
        zzt7.zza(7);
        zzh = builder7.withProperty(zzt7.zzb()).build();
    }

    private zzcv() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzfn zzfn = (zzfn) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(zzb, (Object) zzfn.zzg());
        objectEncoderContext.add(zzc, (Object) zzfn.zzb());
        objectEncoderContext.add(zzd, (Object) zzfn.zza());
        objectEncoderContext.add(zze, (Object) zzfn.zzc());
        objectEncoderContext.add(zzf, (Object) zzfn.zze());
        objectEncoderContext.add(zzg, (Object) zzfn.zzd());
        objectEncoderContext.add(zzh, (Object) zzfn.zzf());
    }
}
