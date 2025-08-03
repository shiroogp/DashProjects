package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBufferObserver;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
public final class DataBufferObserverSet implements DataBufferObserver, DataBufferObserver.Observable {
    private HashSet<DataBufferObserver> zaa = new HashSet<>();

    public void addObserver(DataBufferObserver dataBufferObserver) {
        this.zaa.add(dataBufferObserver);
    }

    public void clear() {
        this.zaa.clear();
    }

    public boolean hasObservers() {
        return !this.zaa.isEmpty();
    }

    public void onDataChanged() {
        Iterator<DataBufferObserver> it2 = this.zaa.iterator();
        while (it2.hasNext()) {
            it2.next().onDataChanged();
        }
    }

    public void onDataRangeChanged(int i, int i2) {
        Iterator<DataBufferObserver> it2 = this.zaa.iterator();
        while (it2.hasNext()) {
            it2.next().onDataRangeChanged(i, i2);
        }
    }

    public void onDataRangeInserted(int i, int i2) {
        Iterator<DataBufferObserver> it2 = this.zaa.iterator();
        while (it2.hasNext()) {
            it2.next().onDataRangeInserted(i, i2);
        }
    }

    public void onDataRangeMoved(int i, int i2, int i3) {
        Iterator<DataBufferObserver> it2 = this.zaa.iterator();
        while (it2.hasNext()) {
            it2.next().onDataRangeMoved(i, i2, i3);
        }
    }

    public void onDataRangeRemoved(int i, int i2) {
        Iterator<DataBufferObserver> it2 = this.zaa.iterator();
        while (it2.hasNext()) {
            it2.next().onDataRangeRemoved(i, i2);
        }
    }

    public void removeObserver(DataBufferObserver dataBufferObserver) {
        this.zaa.remove(dataBufferObserver);
    }
}
