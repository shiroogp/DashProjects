package com.tonyodev.fetch2;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/tonyodev/fetch2/Status;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "NONE", "QUEUED", "DOWNLOADING", "PAUSED", "COMPLETED", "CANCELLED", "FAILED", "REMOVED", "DELETED", "ADDED", "Companion", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Status.kt */
public enum Status {
    NONE(0),
    QUEUED(1),
    DOWNLOADING(2),
    PAUSED(3),
    COMPLETED(4),
    CANCELLED(5),
    FAILED(6),
    REMOVED(7),
    DELETED(8),
    ADDED(9);
    
    public static final Companion Companion = null;
    private final int value;

    @JvmStatic
    public static final Status valueOf(int i) {
        return Companion.valueOf(i);
    }

    private Status(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/tonyodev/fetch2/Status$Companion;", "", "()V", "valueOf", "Lcom/tonyodev/fetch2/Status;", "value", "", "fetch2_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Status.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Status valueOf(int i) {
            switch (i) {
                case 0:
                    return Status.NONE;
                case 1:
                    return Status.QUEUED;
                case 2:
                    return Status.DOWNLOADING;
                case 3:
                    return Status.PAUSED;
                case 4:
                    return Status.COMPLETED;
                case 5:
                    return Status.CANCELLED;
                case 6:
                    return Status.FAILED;
                case 7:
                    return Status.REMOVED;
                case 8:
                    return Status.DELETED;
                case 9:
                    return Status.ADDED;
                default:
                    return Status.NONE;
            }
        }
    }
}
