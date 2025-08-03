package com.google.mlkit.vision.barcode;

import com.google.android.gms.common.internal.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public class BarcodeScannerOptions {
    private final int zza;
    @Nullable
    private final Executor zzb;

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
    public static class Builder {
        private int zza = 0;
        @Nullable
        private Executor zzb;

        public BarcodeScannerOptions build() {
            return new BarcodeScannerOptions(this.zza, this.zzb, (zza) null);
        }

        public Builder setBarcodeFormats(int i, int... iArr) {
            this.zza = i;
            if (iArr != null) {
                for (int i2 : iArr) {
                    this.zza = i2 | this.zza;
                }
            }
            return this;
        }

        public Builder setExecutor(Executor executor) {
            this.zzb = executor;
            return this;
        }
    }

    /* synthetic */ BarcodeScannerOptions(int i, Executor executor, zza zza2) {
        this.zza = i;
        this.zzb = executor;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BarcodeScannerOptions)) {
            return false;
        }
        BarcodeScannerOptions barcodeScannerOptions = (BarcodeScannerOptions) obj;
        return this.zza == barcodeScannerOptions.zza && Objects.equal(this.zzb, barcodeScannerOptions.zzb);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), this.zzb);
    }

    public final int zza() {
        return this.zza;
    }

    public final Executor zzb() {
        return this.zzb;
    }
}
