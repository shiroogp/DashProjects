package com.google.firebase.database.core.view;

import com.google.firebase.database.core.Context;
import com.google.firebase.database.core.EventTarget;
import com.google.firebase.database.logging.LogWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EventRaiser {
    private final EventTarget eventTarget;
    /* access modifiers changed from: private */
    public final LogWrapper logger;

    public EventRaiser(Context context) {
        this.eventTarget = context.getEventTarget();
        this.logger = context.getLogger("EventRaiser");
    }

    public void raiseEvents(List<? extends Event> list) {
        if (this.logger.logsDebug()) {
            this.logger.debug("Raising " + list.size() + " event(s)", new Object[0]);
        }
        final ArrayList arrayList = new ArrayList(list);
        this.eventTarget.postEvent(new Runnable() {
            public void run() {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    Event event = (Event) it2.next();
                    if (EventRaiser.this.logger.logsDebug()) {
                        EventRaiser.this.logger.debug("Raising " + event.toString(), new Object[0]);
                    }
                    event.fire();
                }
            }
        });
    }
}
