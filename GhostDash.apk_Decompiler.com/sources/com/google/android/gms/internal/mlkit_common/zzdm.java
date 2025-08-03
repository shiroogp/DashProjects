package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:common@@17.2.0 */
final class zzdm implements ObjectEncoder<zzgd> {
    static final zzdm zza = new zzdm();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("modelType");
        zzas zzas = new zzas();
        zzas.zza(1);
        zzb = builder.withProperty(zzas.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("isSuccessful");
        zzas zzas2 = new zzas();
        zzas2.zza(2);
        zzc = builder2.withProperty(zzas2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("modelName");
        zzas zzas3 = new zzas();
        zzas3.zza(3);
        zzd = builder3.withProperty(zzas3.zzb()).build();
    }

    private zzdm() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzgd zzgd = (zzgd) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(zzb, (Object) zzgd.zza());
        objectEncoderContext.add(zzc, (Object) zzgd.zzb());
        objectEncoderContext.add(zzd, (Object) null);
    }
}
