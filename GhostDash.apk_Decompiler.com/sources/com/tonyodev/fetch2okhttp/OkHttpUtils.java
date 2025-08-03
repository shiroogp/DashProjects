package com.tonyodev.fetch2okhttp;

import com.tonyodev.fetch2core.FetchCoreUtils;
import kotlin.Metadata;
import okhttp3.CookieJar;
import okhttp3.JavaNetCookieJar;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, d2 = {"getDefaultCookieJar", "Lokhttp3/CookieJar;", "fetch2okhttp_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: Utils.kt */
public final class OkHttpUtils {
    public static final CookieJar getDefaultCookieJar() {
        return new JavaNetCookieJar(FetchCoreUtils.getDefaultCookieManager());
    }
}
