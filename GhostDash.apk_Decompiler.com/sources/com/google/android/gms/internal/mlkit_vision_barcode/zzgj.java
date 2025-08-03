package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
final class zzgj implements ObjectEncoder<zzjj> {
    static final zzgj zza = new zzgj();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("modelInfo");
        zzcw zzcw = new zzcw();
        zzcw.zza(1);
        zzb = builder.withProperty(zzcw.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("initialDownloadConditions");
        zzcw zzcw2 = new zzcw();
        zzcw2.zza(2);
        zzc = builder2.withProperty(zzcw2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("updateDownloadConditions");
        zzcw zzcw3 = new zzcw();
        zzcw3.zza(3);
        zzd = builder3.withProperty(zzcw3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("isModelUpdateEnabled");
        zzcw zzcw4 = new zzcw();
        zzcw4.zza(4);
        zze = builder4.withProperty(zzcw4.zzb()).build();
    }

    private zzgj() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzjj zzjj = (zzjj) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
