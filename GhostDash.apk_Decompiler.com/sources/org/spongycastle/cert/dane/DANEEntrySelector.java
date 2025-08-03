package org.spongycastle.cert.dane;

import org.spongycastle.util.Selector;

public class DANEEntrySelector implements Selector {
    private final String domainName;

    public Object clone() {
        return this;
    }

    DANEEntrySelector(String str) {
        this.domainName = str;
    }

    public boolean match(Object obj) {
        return ((DANEEntry) obj).getDomainName().equals(this.domainName);
    }

    public String getDomainName() {
        return this.domainName;
    }
}
