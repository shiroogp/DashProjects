package org.spongycastle.jcajce;

import java.security.cert.Certificate;
import java.util.Collection;
import org.spongycastle.util.Selector;
import org.spongycastle.util.Store;
import org.spongycastle.util.StoreException;

public interface PKIXCertStore<T extends Certificate> extends Store<T> {
    Collection<T> getMatches(Selector<T> selector) throws StoreException;
}
