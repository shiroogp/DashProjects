package com.google.android.gms.internal.mlkit_vision_text;

import com.arthenica.ffmpegkit.MediaInformation;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
final class zzes implements ObjectEncoder<zzkk> {
    static final zzes zza = new zzes();
    private static final FieldDescriptor zzb;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder(MediaInformation.KEY_MEDIA_PROPERTIES);
        zzcm zzcm = new zzcm();
        zzcm.zza(1);
        zzb = builder.withProperty(zzcm.zzb()).build();
    }

    private zzes() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzkk zzkk = (zzkk) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
