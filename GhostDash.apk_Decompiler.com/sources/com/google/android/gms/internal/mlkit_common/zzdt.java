package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:common@@17.2.0 */
final class zzdt implements ObjectEncoder<zzgj> {
    static final zzdt zza = new zzdt();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;
    private static final FieldDescriptor zzh;
    private static final FieldDescriptor zzi;
    private static final FieldDescriptor zzj;
    private static final FieldDescriptor zzk;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("durationMs");
        zzas zzas = new zzas();
        zzas.zza(1);
        zzb = builder.withProperty(zzas.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("errorCode");
        zzas zzas2 = new zzas();
        zzas2.zza(2);
        zzc = builder2.withProperty(zzas2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("isColdCall");
        zzas zzas3 = new zzas();
        zzas3.zza(3);
        zzd = builder3.withProperty(zzas3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("autoManageModelOnBackground");
        zzas zzas4 = new zzas();
        zzas4.zza(4);
        zze = builder4.withProperty(zzas4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("autoManageModelOnLowMemory");
        zzas zzas5 = new zzas();
        zzas5.zza(5);
        zzf = builder5.withProperty(zzas5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("isNnApiEnabled");
        zzas zzas6 = new zzas();
        zzas6.zza(6);
        zzg = builder6.withProperty(zzas6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("eventsCount");
        zzas zzas7 = new zzas();
        zzas7.zza(7);
        zzh = builder7.withProperty(zzas7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("otherErrors");
        zzas zzas8 = new zzas();
        zzas8.zza(8);
        zzi = builder8.withProperty(zzas8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("remoteConfigValueForAcceleration");
        zzas zzas9 = new zzas();
        zzas9.zza(9);
        zzj = builder9.withProperty(zzas9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("isAccelerated");
        zzas zzas10 = new zzas();
        zzas10.zza(10);
        zzk = builder10.withProperty(zzas10.zzb()).build();
    }

    private zzdt() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzgj zzgj = (zzgj) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
