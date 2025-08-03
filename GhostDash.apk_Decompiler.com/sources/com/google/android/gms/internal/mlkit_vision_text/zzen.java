package com.google.android.gms.internal.mlkit_vision_text;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
final class zzen implements ObjectEncoder<zzds> {
    static final zzen zza = new zzen();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("logEventKey");
        zzcm zzcm = new zzcm();
        zzcm.zza(1);
        zzb = builder.withProperty(zzcm.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("eventCount");
        zzcm zzcm2 = new zzcm();
        zzcm2.zza(2);
        zzc = builder2.withProperty(zzcm2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("inferenceDurationStats");
        zzcm zzcm3 = new zzcm();
        zzcm3.zza(3);
        zzd = builder3.withProperty(zzcm3.zzb()).build();
    }

    private zzen() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzds zzds = (zzds) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(zzb, (Object) zzds.zza());
        objectEncoderContext.add(zzc, (Object) zzds.zzc());
        objectEncoderContext.add(zzd, (Object) zzds.zzb());
    }
}
