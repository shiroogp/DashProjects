package com.google.mlkit.vision.common.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.odml.image.MlImage;

/* compiled from: com.google.mlkit:vision-common@@16.5.0 */
public final /* synthetic */ class zza implements OnCompleteListener {
    public final /* synthetic */ MlImage zza;

    public /* synthetic */ zza(MlImage mlImage) {
        this.zza = mlImage;
    }

    public final void onComplete(Task task) {
        MlImage mlImage = this.zza;
        int i = MobileVisionBase.zza;
        mlImage.close();
    }
}
