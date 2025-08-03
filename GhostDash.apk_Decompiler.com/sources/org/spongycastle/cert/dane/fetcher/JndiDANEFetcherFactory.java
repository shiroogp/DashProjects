package org.spongycastle.cert.dane.fetcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.naming.Binding;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import org.spongycastle.cert.dane.DANEEntry;
import org.spongycastle.cert.dane.DANEEntryFetcher;
import org.spongycastle.cert.dane.DANEEntryFetcherFactory;
import org.spongycastle.cert.dane.DANEException;

public class JndiDANEFetcherFactory implements DANEEntryFetcherFactory {
    private static final String DANE_TYPE = "65500";
    private List dnsServerList = new ArrayList();
    private boolean isAuthoritative;

    public JndiDANEFetcherFactory usingDNSServer(String str) {
        this.dnsServerList.add(str);
        return this;
    }

    public JndiDANEFetcherFactory setAuthoritative(boolean z) {
        this.isAuthoritative = z;
        return this;
    }

    public DANEEntryFetcher build(final String str) {
        final Hashtable hashtable = new Hashtable();
        hashtable.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
        hashtable.put("java.naming.authoritative", this.isAuthoritative ? "true" : "false");
        if (this.dnsServerList.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            for (Object obj : this.dnsServerList) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(" ");
                }
                stringBuffer.append("dns://" + obj);
            }
            hashtable.put("java.naming.provider.url", stringBuffer.toString());
        }
        return new DANEEntryFetcher() {
            public List getEntries() throws DANEException {
                ArrayList arrayList = new ArrayList();
                try {
                    InitialDirContext initialDirContext = new InitialDirContext(hashtable);
                    if (str.indexOf("_smimecert.") > 0) {
                        initialDirContext.listBindings(str);
                        Attributes attributes = initialDirContext.getAttributes(str, new String[]{JndiDANEFetcherFactory.DANE_TYPE});
                        if (attributes.get(JndiDANEFetcherFactory.DANE_TYPE) != null) {
                            byte[] bArr = (byte[]) attributes.get(JndiDANEFetcherFactory.DANE_TYPE).get();
                            if (DANEEntry.isValidCertificate(bArr)) {
                                arrayList.add(new DANEEntry(str, bArr));
                            }
                        }
                    } else {
                        NamingEnumeration listBindings = initialDirContext.listBindings("_smimecert." + str);
                        while (listBindings.hasMore()) {
                            DirContext dirContext = (DirContext) ((Binding) listBindings.next()).getObject();
                            Attributes attributes2 = initialDirContext.getAttributes(dirContext.getNameInNamespace().substring(1, dirContext.getNameInNamespace().length() - 1), new String[]{JndiDANEFetcherFactory.DANE_TYPE});
                            if (attributes2.get(JndiDANEFetcherFactory.DANE_TYPE) != null) {
                                byte[] bArr2 = (byte[]) attributes2.get(JndiDANEFetcherFactory.DANE_TYPE).get();
                                if (DANEEntry.isValidCertificate(bArr2)) {
                                    String nameInNamespace = dirContext.getNameInNamespace();
                                    arrayList.add(new DANEEntry(nameInNamespace.substring(1, nameInNamespace.length() - 1), bArr2));
                                }
                            }
                        }
                    }
                    return arrayList;
                } catch (IOException e) {
                    throw new DANEException("Exception parsing entry: " + e.getMessage(), e);
                } catch (IOException e2) {
                    throw new DANEException("Exception parsing entry: " + e2.getMessage(), e2);
                } catch (NamingException e3) {
                    throw new DANEException("Exception dealing with DNS: " + e3.getMessage(), e3);
                }
            }
        };
    }
}
