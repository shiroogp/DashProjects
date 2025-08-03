package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
final class zzbq implements ObjectEncoder<zzat> {
    static final zzbq zza = new zzbq();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("errorCode");
        zzt zzt = new zzt();
        zzt.zza(1);
        zzb = builder.withProperty(zzt.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("isColdCall");
        zzt zzt2 = new zzt();
        zzt2.zza(2);
        zzc = builder2.withProperty(zzt2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("imageInfo");
        zzt zzt3 = new zzt();
        zzt3.zza(3);
        zzd = builder3.withProperty(zzt3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("detectorOptions");
        zzt zzt4 = new zzt();
        zzt4.zza(4);
        zze = builder4.withProperty(zzt4.zzb()).build();
    }

    private zzbq() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzat zzat = (zzat) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
