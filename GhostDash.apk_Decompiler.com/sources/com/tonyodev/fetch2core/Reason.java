package com.tonyodev.fetch2core;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0001\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lcom/tonyodev/fetch2core/Reason;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "NOT_SPECIFIED", "DOWNLOAD_ADDED", "DOWNLOAD_QUEUED", "DOWNLOAD_STARTED", "DOWNLOAD_WAITING_ON_NETWORK", "DOWNLOAD_PROGRESS_CHANGED", "DOWNLOAD_COMPLETED", "DOWNLOAD_ERROR", "DOWNLOAD_PAUSED", "DOWNLOAD_RESUMED", "DOWNLOAD_CANCELLED", "DOWNLOAD_REMOVED", "DOWNLOAD_DELETED", "DOWNLOAD_BLOCK_UPDATED", "OBSERVER_ATTACHED", "REPORTING", "Companion", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Reason.kt */
public enum Reason {
    NOT_SPECIFIED(0),
    DOWNLOAD_ADDED(1),
    DOWNLOAD_QUEUED(2),
    DOWNLOAD_STARTED(3),
    DOWNLOAD_WAITING_ON_NETWORK(4),
    DOWNLOAD_PROGRESS_CHANGED(5),
    DOWNLOAD_COMPLETED(6),
    DOWNLOAD_ERROR(7),
    DOWNLOAD_PAUSED(8),
    DOWNLOAD_RESUMED(9),
    DOWNLOAD_CANCELLED(10),
    DOWNLOAD_REMOVED(11),
    DOWNLOAD_DELETED(12),
    DOWNLOAD_BLOCK_UPDATED(13),
    OBSERVER_ATTACHED(14),
    REPORTING(15);
    
    public static final Companion Companion = null;
    private final int value;

    @JvmStatic
    public static final Reason valueOf(int i) {
        return Companion.valueOf(i);
    }

    private Reason(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/tonyodev/fetch2core/Reason$Companion;", "", "()V", "valueOf", "Lcom/tonyodev/fetch2core/Reason;", "value", "", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Reason.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Reason valueOf(int i) {
            switch (i) {
                case 1:
                    return Reason.DOWNLOAD_ADDED;
                case 2:
                    return Reason.DOWNLOAD_QUEUED;
                case 3:
                    return Reason.DOWNLOAD_STARTED;
                case 4:
                    return Reason.DOWNLOAD_WAITING_ON_NETWORK;
                case 5:
                    return Reason.DOWNLOAD_PROGRESS_CHANGED;
                case 6:
                    return Reason.DOWNLOAD_COMPLETED;
                case 7:
                    return Reason.DOWNLOAD_ERROR;
                case 8:
                    return Reason.DOWNLOAD_PAUSED;
                case 9:
                    return Reason.DOWNLOAD_RESUMED;
                case 10:
                    return Reason.DOWNLOAD_CANCELLED;
                case 11:
                    return Reason.DOWNLOAD_REMOVED;
                case 12:
                    return Reason.DOWNLOAD_DELETED;
                case 13:
                    return Reason.DOWNLOAD_BLOCK_UPDATED;
                case 14:
                    return Reason.OBSERVER_ATTACHED;
                case 15:
                    return Reason.REPORTING;
                default:
                    return Reason.NOT_SPECIFIED;
            }
        }
    }
}
