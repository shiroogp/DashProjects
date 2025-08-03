package com.google.firebase.storage;

import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.TaskListenerImpl;

/* renamed from: com.google.firebase.storage.-$$Lambda$HI9VW-fkLzW-JEKLQBX3mZC5p1s  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$HI9VWfkLzWJEKLQBX3mZC5p1s implements TaskListenerImpl.OnRaise {
    public static final /* synthetic */ $$Lambda$HI9VWfkLzWJEKLQBX3mZC5p1s INSTANCE = new $$Lambda$HI9VWfkLzWJEKLQBX3mZC5p1s();

    private /* synthetic */ $$Lambda$HI9VWfkLzWJEKLQBX3mZC5p1s() {
    }

    public final void raise(Object obj, Object obj2) {
        ((OnPausedListener) obj).onPaused((StorageTask.ProvideError) obj2);
    }
}
