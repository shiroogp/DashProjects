package com.tonyodev.fetch2core;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\u0012\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/tonyodev/fetch2core/FetchFileServerUriBuilder;", "", "()V", "host", "", "identifier", "port", "", "build", "Landroid/net/Uri;", "setFileResourceIdentifier", "fileResourceId", "", "fileResourceName", "setHostAddress", "hostAddress", "setHostInetAddress", "setHostPort", "toString", "Companion", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FetchFileServerUriBuilder.kt */
public final class FetchFileServerUriBuilder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FETCH_URI_SCHEME = "fetchlocal";
    private String host = "00:00:00:00";
    private String identifier = "";
    private int port;

    public final FetchFileServerUriBuilder setHostAddress(String str) {
        Intrinsics.checkParameterIsNotNull(str, "hostAddress");
        this.host = str;
        return this;
    }

    public final FetchFileServerUriBuilder setHostPort(int i) {
        this.port = i;
        return this;
    }

    public final FetchFileServerUriBuilder setHostInetAddress(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "hostAddress");
        this.port = i;
        this.host = str;
        return this;
    }

    public final FetchFileServerUriBuilder setFileResourceIdentifier(String str) {
        Intrinsics.checkParameterIsNotNull(str, "fileResourceName");
        this.identifier = str;
        return this;
    }

    public final FetchFileServerUriBuilder setFileResourceIdentifier(long j) {
        this.identifier = String.valueOf(j);
        return this;
    }

    public final Uri build() {
        Uri build = new Uri.Builder().scheme(FETCH_URI_SCHEME).encodedAuthority(this.host + ':' + this.port).appendPath(this.identifier).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "Uri.Builder()\n          …\n                .build()");
        return build;
    }

    public String toString() {
        String uri = build().toString();
        Intrinsics.checkExpressionValueIsNotNull(uri, "build().toString()");
        return uri;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tonyodev/fetch2core/FetchFileServerUriBuilder$Companion;", "", "()V", "FETCH_URI_SCHEME", "", "fetch2core_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: FetchFileServerUriBuilder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
