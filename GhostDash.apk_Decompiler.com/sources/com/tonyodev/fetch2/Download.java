package com.tonyodev.fetch2;

import android.net.Uri;
import android.os.Parcelable;
import com.tonyodev.fetch2core.Extras;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010O\u001a\u00020\u0000H&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0012\u0010\u0013\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u0012\u0010\u0015\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0019\u001a\u00020\u001aX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001d\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\fR\u0012\u0010\u001f\u001a\u00020 X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0012\u0010#\u001a\u00020$X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0012\u0010'\u001a\u00020(X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0012\u0010+\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0006R\u001e\u0010-\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0.X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0012\u00101\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0006R\u0012\u00103\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\fR\u0012\u00105\u001a\u00020$X¦\u0004¢\u0006\u0006\u001a\u0004\b6\u0010&R\u0012\u00107\u001a\u000208X¦\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0012\u0010;\u001a\u00020<X¦\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0012\u0010?\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\u0006R\u0012\u0010A\u001a\u00020BX¦\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0012\u0010E\u001a\u00020FX¦\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0014\u0010I\u001a\u0004\u0018\u00010$X¦\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010&R\u0012\u0010K\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\fR\u0012\u0010M\u001a\u00020$X¦\u0004¢\u0006\u0006\u001a\u0004\bN\u0010&¨\u0006P"}, d2 = {"Lcom/tonyodev/fetch2/Download;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "autoRetryAttempts", "", "getAutoRetryAttempts", "()I", "autoRetryMaxAttempts", "getAutoRetryMaxAttempts", "created", "", "getCreated", "()J", "downloadOnEnqueue", "", "getDownloadOnEnqueue", "()Z", "downloaded", "getDownloaded", "downloadedBytesPerSecond", "getDownloadedBytesPerSecond", "enqueueAction", "Lcom/tonyodev/fetch2/EnqueueAction;", "getEnqueueAction", "()Lcom/tonyodev/fetch2/EnqueueAction;", "error", "Lcom/tonyodev/fetch2/Error;", "getError", "()Lcom/tonyodev/fetch2/Error;", "etaInMilliSeconds", "getEtaInMilliSeconds", "extras", "Lcom/tonyodev/fetch2core/Extras;", "getExtras", "()Lcom/tonyodev/fetch2core/Extras;", "file", "", "getFile", "()Ljava/lang/String;", "fileUri", "Landroid/net/Uri;", "getFileUri", "()Landroid/net/Uri;", "group", "getGroup", "headers", "", "getHeaders", "()Ljava/util/Map;", "id", "getId", "identifier", "getIdentifier", "namespace", "getNamespace", "networkType", "Lcom/tonyodev/fetch2/NetworkType;", "getNetworkType", "()Lcom/tonyodev/fetch2/NetworkType;", "priority", "Lcom/tonyodev/fetch2/Priority;", "getPriority", "()Lcom/tonyodev/fetch2/Priority;", "progress", "getProgress", "request", "Lcom/tonyodev/fetch2/Request;", "getRequest", "()Lcom/tonyodev/fetch2/Request;", "status", "Lcom/tonyodev/fetch2/Status;", "getStatus", "()Lcom/tonyodev/fetch2/Status;", "tag", "getTag", "total", "getTotal", "url", "getUrl", "copy", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Download.kt */
public interface Download extends Parcelable, Serializable {
    Download copy();

    int getAutoRetryAttempts();

    int getAutoRetryMaxAttempts();

    long getCreated();

    boolean getDownloadOnEnqueue();

    long getDownloaded();

    long getDownloadedBytesPerSecond();

    EnqueueAction getEnqueueAction();

    Error getError();

    long getEtaInMilliSeconds();

    Extras getExtras();

    String getFile();

    Uri getFileUri();

    int getGroup();

    Map<String, String> getHeaders();

    int getId();

    long getIdentifier();

    String getNamespace();

    NetworkType getNetworkType();

    Priority getPriority();

    int getProgress();

    Request getRequest();

    Status getStatus();

    String getTag();

    long getTotal();

    String getUrl();
}
