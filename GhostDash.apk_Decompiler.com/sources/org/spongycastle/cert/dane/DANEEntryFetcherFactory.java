package org.spongycastle.cert.dane;

public interface DANEEntryFetcherFactory {
    DANEEntryFetcher build(String str);
}
