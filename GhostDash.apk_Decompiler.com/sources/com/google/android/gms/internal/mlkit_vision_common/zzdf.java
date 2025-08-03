package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
final class zzdf implements ObjectEncoder<zzga> {
    static final zzdf zza = new zzdf();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("eventType");
        zzt zzt = new zzt();
        zzt.zza(1);
        zzb = builder.withProperty(zzt.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("errorCode");
        zzt zzt2 = new zzt();
        zzt2.zza(2);
        zzc = builder2.withProperty(zzt2.zzb()).build();
    }

    private zzdf() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzga zzga = (zzga) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
