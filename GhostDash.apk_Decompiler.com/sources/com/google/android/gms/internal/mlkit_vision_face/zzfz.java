package com.google.android.gms.internal.mlkit_vision_face;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
final class zzfz implements ObjectEncoder<zzje> {
    static final zzfz zza = new zzfz();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("inferenceCommonLogEvent");
        zzch zzch = new zzch();
        zzch.zza(1);
        zzb = builder.withProperty(zzch.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("options");
        zzch zzch2 = new zzch();
        zzch2.zza(2);
        zzc = builder2.withProperty(zzch2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("detectedBarcodeFormats");
        zzch zzch3 = new zzch();
        zzch3.zza(3);
        zzd = builder3.withProperty(zzch3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("detectedBarcodeValueTypes");
        zzch zzch4 = new zzch();
        zzch4.zza(4);
        zze = builder4.withProperty(zzch4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("imageInfo");
        zzch zzch5 = new zzch();
        zzch5.zza(5);
        zzf = builder5.withProperty(zzch5.zzb()).build();
    }

    private zzfz() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzje zzje = (zzje) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
