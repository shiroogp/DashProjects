package org.spongycastle.cert.dane;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.spongycastle.util.CollectionStore;
import org.spongycastle.util.Selector;
import org.spongycastle.util.Store;
import org.spongycastle.util.StoreException;

public class DANEEntryStore implements Store {
    private final Map entries;

    DANEEntryStore(List list) {
        HashMap hashMap = new HashMap();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            DANEEntry dANEEntry = (DANEEntry) it2.next();
            hashMap.put(dANEEntry.getDomainName(), dANEEntry);
        }
        this.entries = Collections.unmodifiableMap(hashMap);
    }

    public Collection getMatches(Selector selector) throws StoreException {
        if (selector == null) {
            return this.entries.values();
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : this.entries.values()) {
            if (selector.match(next)) {
                arrayList.add(next);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Store toCertificateStore() {
        Collection<DANEEntry> matches = getMatches((Selector) null);
        ArrayList arrayList = new ArrayList(matches.size());
        for (DANEEntry certificate : matches) {
            arrayList.add(certificate.getCertificate());
        }
        return new CollectionStore(arrayList);
    }
}
