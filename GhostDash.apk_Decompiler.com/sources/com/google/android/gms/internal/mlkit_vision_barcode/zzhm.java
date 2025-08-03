package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
final class zzhm implements ObjectEncoder<zzkr> {
    static final zzhm zza = new zzhm();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;
    private static final FieldDescriptor zzh;
    private static final FieldDescriptor zzi;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("inferenceCommonLogEvent");
        zzcw zzcw = new zzcw();
        zzcw.zza(1);
        zzb = builder.withProperty(zzcw.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("options");
        zzcw zzcw2 = new zzcw();
        zzcw2.zza(2);
        zzc = builder2.withProperty(zzcw2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("inputLength");
        zzcw zzcw3 = new zzcw();
        zzcw3.zza(3);
        zzd = builder3.withProperty(zzcw3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("outputLength");
        zzcw zzcw4 = new zzcw();
        zzcw4.zza(4);
        zze = builder4.withProperty(zzcw4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("loadDictionaryErrorCode");
        zzcw zzcw5 = new zzcw();
        zzcw5.zza(5);
        zzf = builder5.withProperty(zzcw5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("translateResultStatusCode");
        zzcw zzcw6 = new zzcw();
        zzcw6.zza(6);
        zzg = builder6.withProperty(zzcw6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("status");
        zzcw zzcw7 = new zzcw();
        zzcw7.zza(7);
        zzh = builder7.withProperty(zzcw7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("downloadHttpResponseCode");
        zzcw zzcw8 = new zzcw();
        zzcw8.zza(8);
        zzi = builder8.withProperty(zzcw8.zzb()).build();
    }

    private zzhm() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzkr zzkr = (zzkr) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
