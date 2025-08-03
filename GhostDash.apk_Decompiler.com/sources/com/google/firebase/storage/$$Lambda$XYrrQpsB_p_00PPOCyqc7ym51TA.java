package com.google.firebase.storage;

import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.TaskListenerImpl;

/* renamed from: com.google.firebase.storage.-$$Lambda$XYrrQpsB_p_00PPOCyqc7ym51TA  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$XYrrQpsB_p_00PPOCyqc7ym51TA implements TaskListenerImpl.OnRaise {
    public static final /* synthetic */ $$Lambda$XYrrQpsB_p_00PPOCyqc7ym51TA INSTANCE = new $$Lambda$XYrrQpsB_p_00PPOCyqc7ym51TA();

    private /* synthetic */ $$Lambda$XYrrQpsB_p_00PPOCyqc7ym51TA() {
    }

    public final void raise(Object obj, Object obj2) {
        ((OnProgressListener) obj).onProgress((StorageTask.ProvideError) obj2);
    }
}
