package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
final class zzba implements ObjectEncoder<zzae> {
    static final zzba zza = new zzba();
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
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("handledErrors");
        zzt zzt2 = new zzt();
        zzt2.zza(2);
        zzc = builder2.withProperty(zzt2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("partiallyHandledErrors");
        zzt zzt3 = new zzt();
        zzt3.zza(3);
        zzd = builder3.withProperty(zzt3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("unhandledErrors");
        zzt zzt4 = new zzt();
        zzt4.zza(4);
        zze = builder4.withProperty(zzt4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("modelNamespace");
        zzt zzt5 = new zzt();
        zzt5.zza(5);
        zzf = builder5.withProperty(zzt5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("delegateFilter");
        zzt zzt6 = new zzt();
        zzt6.zza(6);
        zzg = builder6.withProperty(zzt6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("httpResponseCode");
        zzt zzt7 = new zzt();
        zzt7.zza(7);
        zzh = builder7.withProperty(zzt7.zzb()).build();
    }

    private zzba() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzae zzae = (zzae) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
