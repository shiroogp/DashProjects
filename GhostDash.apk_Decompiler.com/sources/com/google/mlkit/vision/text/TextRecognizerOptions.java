package com.google.mlkit.vision.text;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public class TextRecognizerOptions implements TextRecognizerOptionsInterface {
    public static final TextRecognizerOptions DEFAULT_OPTIONS = new Builder().build();
    final AtomicReference<Boolean> zza = new AtomicReference<>();
    private final Executor zzb;

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
    public static class Builder {
        private Executor zza;

        public TextRecognizerOptions build() {
            return new TextRecognizerOptions(this.zza, (zzd) null);
        }

        public Builder setExecutor(Executor executor) {
            this.zza = executor;
            return this;
        }
    }

    /* synthetic */ TextRecognizerOptions(Executor executor, zzd zzd) {
        this.zzb = executor;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TextRecognizerOptions)) {
            return false;
        }
        return Objects.equal(this.zzb, ((TextRecognizerOptions) obj).zzb);
    }

    public final String getCreatorClass() {
        return true != getIsThickClient() ? "com.google.android.gms.vision.text.mlkit.TextRecognizerCreator" : "com.google.mlkit.vision.text.bundled.latin.BundledLatinTextRecognizerCreator";
    }

    public final Executor getExecutor() {
        return this.zzb;
    }

    public final boolean getIsThickClient() {
        if (this.zza.get() != null) {
            return this.zza.get().booleanValue();
        }
        boolean z = DynamiteModule.getLocalVersion(MlKitContext.getInstance().getApplicationContext(), "com.google.mlkit.dynamite.text.latin") > 0;
        this.zza.set(Boolean.valueOf(z));
        return z;
    }

    public final int getLoggingEventId() {
        return getIsThickClient() ? 24317 : 24306;
    }

    public final String getLoggingLibraryName() {
        return true != getIsThickClient() ? "play-services-mlkit-text-recognition" : "text-recognition-latin";
    }

    public final String getModuleId() {
        return true != getIsThickClient() ? "com.google.android.gms.vision.ocr" : "com.google.mlkit.dynamite.text.latin";
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb);
    }
}
