package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:common@@17.2.0 */
final class zzeq implements ObjectEncoder<zzhx> {
    static final zzeq zza = new zzeq();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("confidence");
        zzas zzas = new zzas();
        zzas.zza(1);
        zzb = builder.withProperty(zzas.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("languageCode");
        zzas zzas2 = new zzas();
        zzas2.zza(2);
        zzc = builder2.withProperty(zzas2.zzb()).build();
    }

    private zzeq() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzhx zzhx = (zzhx) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
