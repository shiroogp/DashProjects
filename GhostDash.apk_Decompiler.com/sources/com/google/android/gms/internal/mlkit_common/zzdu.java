package com.google.android.gms.internal.mlkit_common;

import com.facebook.imagepipeline.producers.DecodeProducer;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:common@@17.2.0 */
final class zzdu implements ObjectEncoder<zzgk> {
    static final zzdu zza = new zzdu();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;
    private static final FieldDescriptor zzh;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("durationMs");
        zzas zzas = new zzas();
        zzas.zza(1);
        zzb = builder.withProperty(zzas.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("imageSource");
        zzas zzas2 = new zzas();
        zzas2.zza(2);
        zzc = builder2.withProperty(zzas2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder(DecodeProducer.EXTRA_IMAGE_FORMAT_NAME);
        zzas zzas3 = new zzas();
        zzas3.zza(3);
        zzd = builder3.withProperty(zzas3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("imageByteSize");
        zzas zzas4 = new zzas();
        zzas4.zza(4);
        zze = builder4.withProperty(zzas4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("imageWidth");
        zzas zzas5 = new zzas();
        zzas5.zza(5);
        zzf = builder5.withProperty(zzas5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("imageHeight");
        zzas zzas6 = new zzas();
        zzas6.zza(6);
        zzg = builder6.withProperty(zzas6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("rotationDegrees");
        zzas zzas7 = new zzas();
        zzas7.zza(7);
        zzh = builder7.withProperty(zzas7.zzb()).build();
    }

    private zzdu() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzgk zzgk = (zzgk) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
