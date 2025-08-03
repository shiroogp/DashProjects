package com.google.android.gms.internal.mlkit_vision_barcode;

import com.arthenica.ffmpegkit.MediaInformation;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
final class zzfc implements ObjectEncoder<zzlb> {
    static final zzfc zza = new zzfc();
    private static final FieldDescriptor zzb;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder(MediaInformation.KEY_MEDIA_PROPERTIES);
        zzcw zzcw = new zzcw();
        zzcw.zza(1);
        zzb = builder.withProperty(zzcw.zzb()).build();
    }

    private zzfc() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        ((ObjectEncoderContext) obj2).add(zzb, (Object) ((zzlb) obj).zza());
    }
}
