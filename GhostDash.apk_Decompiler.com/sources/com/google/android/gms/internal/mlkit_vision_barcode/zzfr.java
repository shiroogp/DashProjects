package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
final class zzfr implements ObjectEncoder<zzig> {
    static final zzfr zza = new zzfr();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("inferenceCommonLogEvent");
        zzcw zzcw = new zzcw();
        zzcw.zza(1);
        zzb = builder.withProperty(zzcw.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("options");
        zzcw zzcw2 = new zzcw();
        zzcw2.zza(2);
        zzc = builder2.withProperty(zzcw2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("inputsFormats");
        zzcw zzcw3 = new zzcw();
        zzcw3.zza(3);
        zzd = builder3.withProperty(zzcw3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("outputFormats");
        zzcw zzcw4 = new zzcw();
        zzcw4.zza(4);
        zze = builder4.withProperty(zzcw4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("modelInitializationMs");
        zzcw zzcw5 = new zzcw();
        zzcw5.zza(5);
        zzf = builder5.withProperty(zzcw5.zzb()).build();
    }

    private zzfr() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzig zzig = (zzig) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
