package com.tonyodev.fetch2;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/tonyodev/fetch2/EnqueueAction;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "REPLACE_EXISTING", "INCREMENT_FILE_NAME", "DO_NOT_ENQUEUE_IF_EXISTING", "UPDATE_ACCORDINGLY", "Companion", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: EnqueueAction.kt */
public enum EnqueueAction {
    REPLACE_EXISTING(0),
    INCREMENT_FILE_NAME(1),
    DO_NOT_ENQUEUE_IF_EXISTING(2),
    UPDATE_ACCORDINGLY(3);
    
    public static final Companion Companion = null;
    private final int value;

    @JvmStatic
    public static final EnqueueAction valueOf(int i) {
        return Companion.valueOf(i);
    }

    private EnqueueAction(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/tonyodev/fetch2/EnqueueAction$Companion;", "", "()V", "valueOf", "Lcom/tonyodev/fetch2/EnqueueAction;", "value", "", "fetch2_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: EnqueueAction.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final EnqueueAction valueOf(int i) {
            if (i == 1) {
                return EnqueueAction.INCREMENT_FILE_NAME;
            }
            if (i == 2) {
                return EnqueueAction.DO_NOT_ENQUEUE_IF_EXISTING;
            }
            if (i != 3) {
                return EnqueueAction.REPLACE_EXISTING;
            }
            return EnqueueAction.UPDATE_ACCORDINGLY;
        }
    }
}
