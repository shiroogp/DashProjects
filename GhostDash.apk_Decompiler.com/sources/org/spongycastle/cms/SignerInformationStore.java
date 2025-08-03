package org.spongycastle.cms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.spongycastle.util.Iterable;

public class SignerInformationStore implements Iterable<SignerInformation> {
    private List all = new ArrayList();
    private Map table = new HashMap();

    public SignerInformationStore(SignerInformation signerInformation) {
        ArrayList arrayList = new ArrayList(1);
        this.all = arrayList;
        arrayList.add(signerInformation);
        this.table.put(signerInformation.getSID(), this.all);
    }

    public SignerInformationStore(Collection<SignerInformation> collection) {
        for (SignerInformation next : collection) {
            SignerId sid = next.getSID();
            ArrayList arrayList = (ArrayList) this.table.get(sid);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.table.put(sid, arrayList);
            }
            arrayList.add(next);
        }
        this.all = new ArrayList(collection);
    }

    public SignerInformation get(SignerId signerId) {
        Collection<SignerInformation> signers = getSigners(signerId);
        if (signers.size() == 0) {
            return null;
        }
        return signers.iterator().next();
    }

    public int size() {
        return this.all.size();
    }

    public Collection<SignerInformation> getSigners() {
        return new ArrayList(this.all);
    }

    public Collection<SignerInformation> getSigners(SignerId signerId) {
        if (signerId.getIssuer() == null || signerId.getSubjectKeyIdentifier() == null) {
            ArrayList arrayList = (ArrayList) this.table.get(signerId);
            return arrayList == null ? new ArrayList() : new ArrayList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        Collection<SignerInformation> signers = getSigners(new SignerId(signerId.getIssuer(), signerId.getSerialNumber()));
        if (signers != null) {
            arrayList2.addAll(signers);
        }
        Collection<SignerInformation> signers2 = getSigners(new SignerId(signerId.getSubjectKeyIdentifier()));
        if (signers2 != null) {
            arrayList2.addAll(signers2);
        }
        return arrayList2;
    }

    public Iterator<SignerInformation> iterator() {
        return getSigners().iterator();
    }
}
