package com.google.android.gms.internal.mlkit_vision_face;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
final class zzdx implements ObjectEncoder<zzcx> {
    static final zzdx zza = new zzdx();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;
    private static final FieldDescriptor zzh;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("errorCode");
        zzch zzch = new zzch();
        zzch.zza(1);
        zzb = builder.withProperty(zzch.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("hasResult");
        zzch zzch2 = new zzch();
        zzch2.zza(2);
        zzc = builder2.withProperty(zzch2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("isColdCall");
        zzch zzch3 = new zzch();
        zzch3.zza(3);
        zzd = builder3.withProperty(zzch3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("imageInfo");
        zzch zzch4 = new zzch();
        zzch4.zza(4);
        zze = builder4.withProperty(zzch4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("options");
        zzch zzch5 = new zzch();
        zzch5.zza(5);
        zzf = builder5.withProperty(zzch5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("detectedBarcodeFormats");
        zzch zzch6 = new zzch();
        zzch6.zza(6);
        zzg = builder6.withProperty(zzch6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("detectedBarcodeValueTypes");
        zzch zzch7 = new zzch();
        zzch7.zza(7);
        zzh = builder7.withProperty(zzch7.zzb()).build();
    }

    private zzdx() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzcx zzcx = (zzcx) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
