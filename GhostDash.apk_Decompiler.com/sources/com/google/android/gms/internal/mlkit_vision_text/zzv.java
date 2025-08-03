package com.google.android.gms.internal.mlkit_vision_text;

import java.io.IOException;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final class zzv {
    private final String zza = ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE;

    private zzv(String str) {
    }

    public static zzv zza(String str) {
        return new zzv(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
    }

    static final CharSequence zzc(@CheckForNull Object obj) {
        obj.getClass();
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public final String zzb(Iterable<? extends Object> iterable) {
        Iterator<? extends Object> it2 = iterable.iterator();
        StringBuilder sb = new StringBuilder();
        try {
            if (it2.hasNext()) {
                sb.append(zzc(it2.next()));
                while (it2.hasNext()) {
                    sb.append(this.zza);
                    sb.append(zzc(it2.next()));
                }
            }
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
