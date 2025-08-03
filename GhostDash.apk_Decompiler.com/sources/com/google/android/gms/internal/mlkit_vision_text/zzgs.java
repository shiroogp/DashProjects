package com.google.android.gms.internal.mlkit_vision_text;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
final class zzgs implements ObjectEncoder<zzjr> {
    static final zzgs zza = new zzgs();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("inferenceCommonLogEvent");
        zzcm zzcm = new zzcm();
        zzcm.zza(1);
        zzb = builder.withProperty(zzcm.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("imageInfo");
        zzcm zzcm2 = new zzcm();
        zzcm2.zza(2);
        zzc = builder2.withProperty(zzcm2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("detectorOptions");
        zzcm zzcm3 = new zzcm();
        zzcm3.zza(3);
        zzd = builder3.withProperty(zzcm3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("objectInfos");
        zzcm zzcm4 = new zzcm();
        zzcm4.zza(4);
        zze = builder4.withProperty(zzcm4.zzb()).build();
    }

    private zzgs() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzjr zzjr = (zzjr) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
