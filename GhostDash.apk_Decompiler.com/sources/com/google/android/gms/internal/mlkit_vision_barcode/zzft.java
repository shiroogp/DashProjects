package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
final class zzft implements ObjectEncoder<zzii> {
    static final zzft zza = new zzft();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("modelType");
        zzcw zzcw = new zzcw();
        zzcw.zza(1);
        zzb = builder.withProperty(zzcw.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("isSuccessful");
        zzcw zzcw2 = new zzcw();
        zzcw2.zza(2);
        zzc = builder2.withProperty(zzcw2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("modelName");
        zzcw zzcw3 = new zzcw();
        zzcw3.zza(3);
        zzd = builder3.withProperty(zzcw3.zzb()).build();
    }

    private zzft() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzii zzii = (zzii) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
