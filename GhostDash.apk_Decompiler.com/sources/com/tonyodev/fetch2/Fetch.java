package com.tonyodev.fetch2;

import com.tonyodev.fetch2.exception.FetchException;
import com.tonyodev.fetch2.fetch.FetchImpl;
import com.tonyodev.fetch2.fetch.FetchModulesBuilder;
import com.tonyodev.fetch2core.DownloadBlock;
import com.tonyodev.fetch2core.Downloader;
import com.tonyodev.fetch2core.Extras;
import com.tonyodev.fetch2core.FetchErrorStrings;
import com.tonyodev.fetch2core.FetchObserver;
import com.tonyodev.fetch2core.FileResource;
import com.tonyodev.fetch2core.Func;
import com.tonyodev.fetch2core.Func2;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001J \u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H&J>\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00072\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&JJ\u0010\u001a\u001a\u00020\u00002\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u001c2\b\b\u0002\u0010\u0014\u001a\u00020\u00072\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\u0010\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001fH&J\u001a\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u0007H&J\"\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H&J5\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u001e\u0010%\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00170\u00100&\"\b\u0012\u0004\u0012\u00020\u00170\u0010H&¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020)H&J\u0010\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020,H&J\u0010\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$H&J4\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\u0016\u0010-\u001a\u00020\u00002\f\u0010/\u001a\b\u0012\u0004\u0012\u00020$0\u001cH&J@\u0010-\u001a\u00020\u00002\f\u0010/\u001a\b\u0012\u0004\u0012\u00020$0\u001c2\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\b\u00100\u001a\u00020\u0000H&J2\u00100\u001a\u00020\u00002\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\u0010\u00101\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$H&J:\u00101\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$2\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\b\u00102\u001a\u00020)H&J\u0010\u00103\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$H&J4\u00103\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\u0016\u00103\u001a\u00020\u00002\f\u0010/\u001a\b\u0012\u0004\u0012\u00020$0\u001cH&J@\u00103\u001a\u00020\u00002\f\u0010/\u001a\b\u0012\u0004\u0012\u00020$0\u001c2\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\b\u00104\u001a\u00020\u0000H&J2\u00104\u001a\u00020\u00002\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\u001e\u00105\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$2\f\u00106\u001a\b\u0012\u0004\u0012\u0002070\u001cH&JF\u00105\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$2\f\u00106\u001a\b\u0012\u0004\u0012\u0002070\u001c2\u0014\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\u0010\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u000207H&J:\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u0002072\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\u0010\u0010:\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$H&J:\u0010:\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$2\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\u0010\u0010;\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0007H&J4\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020?2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J:\u0010=\u001a\u00020\u00002\f\u0010@\u001a\b\u0012\u0004\u0012\u00020?0\u001c2\"\b\u0002\u0010\u0015\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020\u00190A0\u001c\u0018\u00010\u0016H&J\b\u0010B\u001a\u00020\u0000H&J,\u0010B\u001a\u00020\u00002\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\u001c\u0010C\u001a\u00020\u00002\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001c0\u0016H&J6\u0010D\u001a\u00020\u00002\u0006\u0010>\u001a\u00020?2\u0006\u0010E\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020,0\u00162\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J^\u0010F\u001a\u00020\u00002\f\u0010@\u001a\b\u0012\u0004\u0012\u00020?0\u001c2\u0006\u0010E\u001a\u00020\u00072\u001e\u0010\u0015\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020,0A0\u001c0\u00162\u001e\u0010\u0018\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020\u00190A0\u001c0\u0016H&J \u0010G\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$2\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170HH&J$\u0010I\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0\u001c0\u0016H&J\u001c\u0010K\u001a\u00020\u00002\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c0\u0016H&J*\u0010K\u001a\u00020\u00002\f\u0010L\u001a\b\u0012\u0004\u0012\u00020$0\u001c2\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c0\u0016H&J$\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020,2\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c0\u0016H&J$\u0010O\u001a\u00020\u00002\u0006\u0010P\u001a\u00020\n2\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c0\u0016H&J$\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020$2\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c0\u0016H&J2\u0010S\u001a\u00020\u00002\u0006\u0010R\u001a\u00020$2\f\u00106\u001a\b\u0012\u0004\u0012\u0002070\u001c2\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c0\u0016H&J$\u0010T\u001a\u00020\u00002\u0006\u00109\u001a\u0002072\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c0\u0016H&J*\u0010T\u001a\u00020\u00002\f\u00106\u001a\b\u0012\u0004\u0012\u0002070\u001c2\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c0\u0016H&J6\u0010U\u001a\u00020\u00002\u0006\u0010>\u001a\u00020?2\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020V0\u001c0\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\u001e\u0010W\u001a\u00020\u00002\u0006\u0010X\u001a\u00020$2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020Y0\u0016H&J\u000e\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001f0[H&JF\u0010\\\u001a\u00020\u00002\u0006\u0010]\u001a\u00020\n2\u0014\u0010^\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010_2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020`0\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\u001e\u0010a\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016H&J\u0010\u0010b\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$H&J4\u0010b\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\u0016\u0010b\u001a\u00020\u00002\f\u0010/\u001a\b\u0012\u0004\u0012\u00020$0\u001cH&J@\u0010b\u001a\u00020\u00002\f\u0010/\u001a\b\u0012\u0004\u0012\u00020$0\u001c2\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\b\u0010c\u001a\u00020\u0000H&J\u0010\u0010d\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$H&J:\u0010d\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$2\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\u0010\u0010e\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$H&J4\u0010e\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\u0016\u0010e\u001a\u00020\u00002\f\u0010/\u001a\b\u0012\u0004\u0012\u00020$0\u001cH&J@\u0010e\u001a\u00020\u00002\f\u0010/\u001a\b\u0012\u0004\u0012\u00020$0\u001c2\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\u0016\u0010f\u001a\u00020\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H&J\b\u0010g\u001a\u00020\u0000H&J2\u0010g\u001a\u00020\u00002\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\u001e\u0010h\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$2\f\u00106\u001a\b\u0012\u0004\u0012\u0002070\u001cH&JF\u0010h\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$2\f\u00106\u001a\b\u0012\u0004\u0012\u0002070\u001c2\u0014\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\u0010\u0010i\u001a\u00020\u00002\u0006\u00109\u001a\u000207H&J:\u0010i\u001a\u00020\u00002\u0006\u00109\u001a\u0002072\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J5\u0010j\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u001e\u0010%\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00170\u00100&\"\b\u0012\u0004\u0012\u00020\u00170\u0010H&¢\u0006\u0002\u0010'J\u0010\u0010k\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$H&J:\u0010k\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$2\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\u0010\u0010l\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001fH&J<\u0010m\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$2\u0006\u0010n\u001a\u00020\n2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J<\u0010o\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$2\u0006\u0010p\u001a\u00020q2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J@\u0010r\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010s\u001a\u00020\u00072\u0012\b\u0002\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010H2\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\u0010\u0010t\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$H&J4\u0010t\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\u0016\u0010t\u001a\u00020\u00002\f\u0010/\u001a\b\u0012\u0004\u0012\u00020$0\u001cH&J@\u0010t\u001a\u00020\u00002\f\u0010/\u001a\b\u0012\u0004\u0012\u00020$0\u001c2\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\b\u0010u\u001a\u00020\u0000H&J\u0010\u0010v\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$H&J:\u0010v\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$2\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\u0010\u0010w\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$H&J4\u0010w\u001a\u00020\u00002\u0006\u0010.\u001a\u00020$2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\u0016\u0010w\u001a\u00020\u00002\f\u0010/\u001a\b\u0012\u0004\u0012\u00020$0\u001cH&J@\u0010w\u001a\u00020\u00002\f\u0010/\u001a\b\u0012\u0004\u0012\u00020$0\u001c2\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\u0010\u0010x\u001a\u00020\u00002\u0006\u0010y\u001a\u00020$H&J\u0010\u0010z\u001a\u00020\u00002\u0006\u0010{\u001a\u00020|H&J\b\u0010}\u001a\u00020\u0000H&J,\u0010}\u001a\u00020\u00002\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&JH\u0010~\u001a\u00020\u00002\u0006\u0010\u001a\u00020$2\u0007\u0010\u0001\u001a\u00020?2\t\b\u0002\u0010\u0001\u001a\u00020\u00072\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0001"}, d2 = {"Lcom/tonyodev/fetch2/Fetch;", "", "fetchConfiguration", "Lcom/tonyodev/fetch2/FetchConfiguration;", "getFetchConfiguration", "()Lcom/tonyodev/fetch2/FetchConfiguration;", "isClosed", "", "()Z", "namespace", "", "getNamespace", "()Ljava/lang/String;", "addActiveDownloadsObserver", "includeAddedDownloads", "fetchObserver", "Lcom/tonyodev/fetch2core/FetchObserver;", "addCompletedDownload", "completedDownload", "Lcom/tonyodev/fetch2/CompletedDownload;", "alertListeners", "func", "Lcom/tonyodev/fetch2core/Func;", "Lcom/tonyodev/fetch2/Download;", "func2", "Lcom/tonyodev/fetch2/Error;", "addCompletedDownloads", "completedDownloads", "", "addListener", "listener", "Lcom/tonyodev/fetch2/FetchListener;", "notify", "autoStart", "attachFetchObserversForDownload", "downloadId", "", "fetchObservers", "", "(I[Lcom/tonyodev/fetch2core/FetchObserver;)Lcom/tonyodev/fetch2/Fetch;", "awaitFinish", "", "awaitFinishOrTimeout", "allowTimeInMilliseconds", "", "cancel", "id", "ids", "cancelAll", "cancelGroup", "close", "delete", "deleteAll", "deleteAllInGroupWithStatus", "statuses", "Lcom/tonyodev/fetch2/Status;", "deleteAllWithStatus", "status", "deleteGroup", "enableLogging", "enabled", "enqueue", "request", "Lcom/tonyodev/fetch2/Request;", "requests", "Lkotlin/Pair;", "freeze", "getAllGroupIds", "getContentLengthForRequest", "fromServer", "getContentLengthForRequests", "getDownload", "Lcom/tonyodev/fetch2core/Func2;", "getDownloadBlocks", "Lcom/tonyodev/fetch2core/DownloadBlock;", "getDownloads", "idList", "getDownloadsByRequestIdentifier", "identifier", "getDownloadsByTag", "tag", "getDownloadsInGroup", "groupId", "getDownloadsInGroupWithStatus", "getDownloadsWithStatus", "getFetchFileServerCatalog", "Lcom/tonyodev/fetch2core/FileResource;", "getFetchGroup", "group", "Lcom/tonyodev/fetch2/FetchGroup;", "getListenerSet", "", "getServerResponse", "url", "headers", "", "Lcom/tonyodev/fetch2core/Downloader$Response;", "hasActiveDownloads", "pause", "pauseAll", "pauseGroup", "remove", "removeActiveDownloadsObserver", "removeAll", "removeAllInGroupWithStatus", "removeAllWithStatus", "removeFetchObserversForDownload", "removeGroup", "removeListener", "renameCompletedDownloadFile", "newFileName", "replaceExtras", "extras", "Lcom/tonyodev/fetch2core/Extras;", "resetAutoRetryAttempts", "retryDownload", "resume", "resumeAll", "resumeGroup", "retry", "setDownloadConcurrentLimit", "downloadConcurrentLimit", "setGlobalNetworkType", "networkType", "Lcom/tonyodev/fetch2/NetworkType;", "unfreeze", "updateRequest", "requestId", "updatedRequest", "notifyListeners", "Impl", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Fetch.kt */
public interface Fetch {
    public static final Impl Impl = Impl.$$INSTANCE;

    Fetch addActiveDownloadsObserver(boolean z, FetchObserver<Boolean> fetchObserver);

    Fetch addCompletedDownload(CompletedDownload completedDownload, boolean z, Func<Download> func, Func<Error> func2);

    Fetch addCompletedDownloads(List<? extends CompletedDownload> list, boolean z, Func<List<Download>> func, Func<Error> func2);

    Fetch addListener(FetchListener fetchListener);

    Fetch addListener(FetchListener fetchListener, boolean z);

    Fetch addListener(FetchListener fetchListener, boolean z, boolean z2);

    Fetch attachFetchObserversForDownload(int i, FetchObserver<Download>... fetchObserverArr);

    void awaitFinish();

    void awaitFinishOrTimeout(long j);

    Fetch cancel(int i);

    Fetch cancel(int i, Func<Download> func, Func<Error> func2);

    Fetch cancel(List<Integer> list);

    Fetch cancel(List<Integer> list, Func<List<Download>> func, Func<Error> func2);

    Fetch cancelAll();

    Fetch cancelAll(Func<List<Download>> func, Func<Error> func2);

    Fetch cancelGroup(int i);

    Fetch cancelGroup(int i, Func<List<Download>> func, Func<Error> func2);

    void close();

    Fetch delete(int i);

    Fetch delete(int i, Func<Download> func, Func<Error> func2);

    Fetch delete(List<Integer> list);

    Fetch delete(List<Integer> list, Func<List<Download>> func, Func<Error> func2);

    Fetch deleteAll();

    Fetch deleteAll(Func<List<Download>> func, Func<Error> func2);

    Fetch deleteAllInGroupWithStatus(int i, List<? extends Status> list);

    Fetch deleteAllInGroupWithStatus(int i, List<? extends Status> list, Func<List<Download>> func, Func<Error> func2);

    Fetch deleteAllWithStatus(Status status);

    Fetch deleteAllWithStatus(Status status, Func<List<Download>> func, Func<Error> func2);

    Fetch deleteGroup(int i);

    Fetch deleteGroup(int i, Func<List<Download>> func, Func<Error> func2);

    Fetch enableLogging(boolean z);

    Fetch enqueue(Request request, Func<Request> func, Func<Error> func2);

    Fetch enqueue(List<? extends Request> list, Func<List<Pair<Request, Error>>> func);

    Fetch freeze();

    Fetch freeze(Func<Boolean> func, Func<Error> func2);

    Fetch getAllGroupIds(Func<List<Integer>> func);

    Fetch getContentLengthForRequest(Request request, boolean z, Func<Long> func, Func<Error> func2);

    Fetch getContentLengthForRequests(List<? extends Request> list, boolean z, Func<List<Pair<Request, Long>>> func, Func<List<Pair<Request, Error>>> func2);

    Fetch getDownload(int i, Func2<Download> func2);

    Fetch getDownloadBlocks(int i, Func<List<DownloadBlock>> func);

    Fetch getDownloads(Func<List<Download>> func);

    Fetch getDownloads(List<Integer> list, Func<List<Download>> func);

    Fetch getDownloadsByRequestIdentifier(long j, Func<List<Download>> func);

    Fetch getDownloadsByTag(String str, Func<List<Download>> func);

    Fetch getDownloadsInGroup(int i, Func<List<Download>> func);

    Fetch getDownloadsInGroupWithStatus(int i, List<? extends Status> list, Func<List<Download>> func);

    Fetch getDownloadsWithStatus(Status status, Func<List<Download>> func);

    Fetch getDownloadsWithStatus(List<? extends Status> list, Func<List<Download>> func);

    FetchConfiguration getFetchConfiguration();

    Fetch getFetchFileServerCatalog(Request request, Func<List<FileResource>> func, Func<Error> func2);

    Fetch getFetchGroup(int i, Func<FetchGroup> func);

    Set<FetchListener> getListenerSet();

    String getNamespace();

    Fetch getServerResponse(String str, Map<String, String> map, Func<Downloader.Response> func, Func<Error> func2);

    Fetch hasActiveDownloads(boolean z, Func<Boolean> func);

    boolean isClosed();

    Fetch pause(int i);

    Fetch pause(int i, Func<Download> func, Func<Error> func2);

    Fetch pause(List<Integer> list);

    Fetch pause(List<Integer> list, Func<List<Download>> func, Func<Error> func2);

    Fetch pauseAll();

    Fetch pauseGroup(int i);

    Fetch pauseGroup(int i, Func<List<Download>> func, Func<Error> func2);

    Fetch remove(int i);

    Fetch remove(int i, Func<Download> func, Func<Error> func2);

    Fetch remove(List<Integer> list);

    Fetch remove(List<Integer> list, Func<List<Download>> func, Func<Error> func2);

    Fetch removeActiveDownloadsObserver(FetchObserver<Boolean> fetchObserver);

    Fetch removeAll();

    Fetch removeAll(Func<List<Download>> func, Func<Error> func2);

    Fetch removeAllInGroupWithStatus(int i, List<? extends Status> list);

    Fetch removeAllInGroupWithStatus(int i, List<? extends Status> list, Func<List<Download>> func, Func<Error> func2);

    Fetch removeAllWithStatus(Status status);

    Fetch removeAllWithStatus(Status status, Func<List<Download>> func, Func<Error> func2);

    Fetch removeFetchObserversForDownload(int i, FetchObserver<Download>... fetchObserverArr);

    Fetch removeGroup(int i);

    Fetch removeGroup(int i, Func<List<Download>> func, Func<Error> func2);

    Fetch removeListener(FetchListener fetchListener);

    Fetch renameCompletedDownloadFile(int i, String str, Func<Download> func, Func<Error> func2);

    Fetch replaceExtras(int i, Extras extras, Func<Download> func, Func<Error> func2);

    Fetch resetAutoRetryAttempts(int i, boolean z, Func2<Download> func2, Func<Error> func);

    Fetch resume(int i);

    Fetch resume(int i, Func<Download> func, Func<Error> func2);

    Fetch resume(List<Integer> list);

    Fetch resume(List<Integer> list, Func<List<Download>> func, Func<Error> func2);

    Fetch resumeAll();

    Fetch resumeGroup(int i);

    Fetch resumeGroup(int i, Func<List<Download>> func, Func<Error> func2);

    Fetch retry(int i);

    Fetch retry(int i, Func<Download> func, Func<Error> func2);

    Fetch retry(List<Integer> list);

    Fetch retry(List<Integer> list, Func<List<Download>> func, Func<Error> func2);

    Fetch setDownloadConcurrentLimit(int i);

    Fetch setGlobalNetworkType(NetworkType networkType);

    Fetch unfreeze();

    Fetch unfreeze(Func<Boolean> func, Func<Error> func2);

    Fetch updateRequest(int i, Request request, boolean z, Func<Download> func, Func<Error> func2);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* compiled from: Fetch.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Fetch enqueue$default(Fetch fetch, Request request, Func func, Func func2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    func = null;
                }
                if ((i & 4) != 0) {
                    func2 = null;
                }
                return fetch.enqueue(request, func, func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enqueue");
        }

        public static /* synthetic */ Fetch enqueue$default(Fetch fetch, List list, Func func, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    func = null;
                }
                return fetch.enqueue(list, func);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enqueue");
        }

        public static /* synthetic */ Fetch pause$default(Fetch fetch, List list, Func func, Func func2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    func = null;
                }
                if ((i & 4) != 0) {
                    func2 = null;
                }
                return fetch.pause((List<Integer>) list, (Func<List<Download>>) func, (Func<Error>) func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pause");
        }

        public static /* synthetic */ Fetch pause$default(Fetch fetch, int i, Func func, Func func2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    func = null;
                }
                if ((i2 & 4) != 0) {
                    func2 = null;
                }
                return fetch.pause(i, (Func<Download>) func, (Func<Error>) func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pause");
        }

        public static /* synthetic */ Fetch pauseGroup$default(Fetch fetch, int i, Func func, Func func2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    func = null;
                }
                if ((i2 & 4) != 0) {
                    func2 = null;
                }
                return fetch.pauseGroup(i, func, func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pauseGroup");
        }

        public static /* synthetic */ Fetch freeze$default(Fetch fetch, Func func, Func func2, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    func = null;
                }
                if ((i & 2) != 0) {
                    func2 = null;
                }
                return fetch.freeze(func, func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: freeze");
        }

        public static /* synthetic */ Fetch resume$default(Fetch fetch, List list, Func func, Func func2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    func = null;
                }
                if ((i & 4) != 0) {
                    func2 = null;
                }
                return fetch.resume((List<Integer>) list, (Func<List<Download>>) func, (Func<Error>) func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resume");
        }

        public static /* synthetic */ Fetch resume$default(Fetch fetch, int i, Func func, Func func2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    func = null;
                }
                if ((i2 & 4) != 0) {
                    func2 = null;
                }
                return fetch.resume(i, (Func<Download>) func, (Func<Error>) func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resume");
        }

        public static /* synthetic */ Fetch resumeGroup$default(Fetch fetch, int i, Func func, Func func2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    func = null;
                }
                if ((i2 & 4) != 0) {
                    func2 = null;
                }
                return fetch.resumeGroup(i, func, func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeGroup");
        }

        public static /* synthetic */ Fetch unfreeze$default(Fetch fetch, Func func, Func func2, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    func = null;
                }
                if ((i & 2) != 0) {
                    func2 = null;
                }
                return fetch.unfreeze(func, func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unfreeze");
        }

        public static /* synthetic */ Fetch remove$default(Fetch fetch, List list, Func func, Func func2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    func = null;
                }
                if ((i & 4) != 0) {
                    func2 = null;
                }
                return fetch.remove((List<Integer>) list, (Func<List<Download>>) func, (Func<Error>) func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: remove");
        }

        public static /* synthetic */ Fetch remove$default(Fetch fetch, int i, Func func, Func func2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    func = null;
                }
                if ((i2 & 4) != 0) {
                    func2 = null;
                }
                return fetch.remove(i, (Func<Download>) func, (Func<Error>) func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: remove");
        }

        public static /* synthetic */ Fetch removeGroup$default(Fetch fetch, int i, Func func, Func func2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    func = null;
                }
                if ((i2 & 4) != 0) {
                    func2 = null;
                }
                return fetch.removeGroup(i, func, func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeGroup");
        }

        public static /* synthetic */ Fetch removeAll$default(Fetch fetch, Func func, Func func2, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    func = null;
                }
                if ((i & 2) != 0) {
                    func2 = null;
                }
                return fetch.removeAll(func, func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeAll");
        }

        public static /* synthetic */ Fetch removeAllWithStatus$default(Fetch fetch, Status status, Func func, Func func2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    func = null;
                }
                if ((i & 4) != 0) {
                    func2 = null;
                }
                return fetch.removeAllWithStatus(status, func, func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeAllWithStatus");
        }

        public static /* synthetic */ Fetch removeAllInGroupWithStatus$default(Fetch fetch, int i, List list, Func func, Func func2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 8) != 0) {
                    func2 = null;
                }
                return fetch.removeAllInGroupWithStatus(i, list, func, func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeAllInGroupWithStatus");
        }

        public static /* synthetic */ Fetch delete$default(Fetch fetch, List list, Func func, Func func2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    func = null;
                }
                if ((i & 4) != 0) {
                    func2 = null;
                }
                return fetch.delete((List<Integer>) list, (Func<List<Download>>) func, (Func<Error>) func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }

        public static /* synthetic */ Fetch delete$default(Fetch fetch, int i, Func func, Func func2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    func = null;
                }
                if ((i2 & 4) != 0) {
                    func2 = null;
                }
                return fetch.delete(i, (Func<Download>) func, (Func<Error>) func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }

        public static /* synthetic */ Fetch deleteGroup$default(Fetch fetch, int i, Func func, Func func2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    func = null;
                }
                if ((i2 & 4) != 0) {
                    func2 = null;
                }
                return fetch.deleteGroup(i, func, func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteGroup");
        }

        public static /* synthetic */ Fetch deleteAll$default(Fetch fetch, Func func, Func func2, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    func = null;
                }
                if ((i & 2) != 0) {
                    func2 = null;
                }
                return fetch.deleteAll(func, func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteAll");
        }

        public static /* synthetic */ Fetch deleteAllWithStatus$default(Fetch fetch, Status status, Func func, Func func2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    func = null;
                }
                if ((i & 4) != 0) {
                    func2 = null;
                }
                return fetch.deleteAllWithStatus(status, func, func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteAllWithStatus");
        }

        public static /* synthetic */ Fetch deleteAllInGroupWithStatus$default(Fetch fetch, int i, List list, Func func, Func func2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 8) != 0) {
                    func2 = null;
                }
                return fetch.deleteAllInGroupWithStatus(i, list, func, func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteAllInGroupWithStatus");
        }

        public static /* synthetic */ Fetch cancel$default(Fetch fetch, List list, Func func, Func func2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    func = null;
                }
                if ((i & 4) != 0) {
                    func2 = null;
                }
                return fetch.cancel((List<Integer>) list, (Func<List<Download>>) func, (Func<Error>) func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static /* synthetic */ Fetch cancel$default(Fetch fetch, int i, Func func, Func func2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    func = null;
                }
                if ((i2 & 4) != 0) {
                    func2 = null;
                }
                return fetch.cancel(i, (Func<Download>) func, (Func<Error>) func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static /* synthetic */ Fetch cancelGroup$default(Fetch fetch, int i, Func func, Func func2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    func = null;
                }
                if ((i2 & 4) != 0) {
                    func2 = null;
                }
                return fetch.cancelGroup(i, func, func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancelGroup");
        }

        public static /* synthetic */ Fetch cancelAll$default(Fetch fetch, Func func, Func func2, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    func = null;
                }
                if ((i & 2) != 0) {
                    func2 = null;
                }
                return fetch.cancelAll(func, func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancelAll");
        }

        public static /* synthetic */ Fetch retry$default(Fetch fetch, List list, Func func, Func func2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    func = null;
                }
                if ((i & 4) != 0) {
                    func2 = null;
                }
                return fetch.retry((List<Integer>) list, (Func<List<Download>>) func, (Func<Error>) func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: retry");
        }

        public static /* synthetic */ Fetch retry$default(Fetch fetch, int i, Func func, Func func2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    func = null;
                }
                if ((i2 & 4) != 0) {
                    func2 = null;
                }
                return fetch.retry(i, (Func<Download>) func, (Func<Error>) func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: retry");
        }

        public static /* synthetic */ Fetch updateRequest$default(Fetch fetch, int i, Request request, boolean z, Func func, Func func2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    z = true;
                }
                boolean z2 = z;
                if ((i2 & 8) != 0) {
                    func = null;
                }
                Func func3 = func;
                if ((i2 & 16) != 0) {
                    func2 = null;
                }
                return fetch.updateRequest(i, request, z2, func3, func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateRequest");
        }

        public static /* synthetic */ Fetch replaceExtras$default(Fetch fetch, int i, Extras extras, Func func, Func func2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    func = null;
                }
                if ((i2 & 8) != 0) {
                    func2 = null;
                }
                return fetch.replaceExtras(i, extras, func, func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: replaceExtras");
        }

        public static /* synthetic */ Fetch resetAutoRetryAttempts$default(Fetch fetch, int i, boolean z, Func2 func2, Func func, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    z = true;
                }
                if ((i2 & 4) != 0) {
                    func2 = null;
                }
                if ((i2 & 8) != 0) {
                    func = null;
                }
                return fetch.resetAutoRetryAttempts(i, z, func2, func);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resetAutoRetryAttempts");
        }

        public static /* synthetic */ Fetch renameCompletedDownloadFile$default(Fetch fetch, int i, String str, Func func, Func func2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    func = null;
                }
                if ((i2 & 8) != 0) {
                    func2 = null;
                }
                return fetch.renameCompletedDownloadFile(i, str, func, func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renameCompletedDownloadFile");
        }

        public static /* synthetic */ Fetch addListener$default(Fetch fetch, FetchListener fetchListener, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return fetch.addListener(fetchListener, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addListener");
        }

        public static /* synthetic */ Fetch addListener$default(Fetch fetch, FetchListener fetchListener, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return fetch.addListener(fetchListener, z, z2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addListener");
        }

        public static /* synthetic */ Fetch addCompletedDownload$default(Fetch fetch, CompletedDownload completedDownload, boolean z, Func func, Func func2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = true;
                }
                if ((i & 4) != 0) {
                    func = null;
                }
                if ((i & 8) != 0) {
                    func2 = null;
                }
                return fetch.addCompletedDownload(completedDownload, z, func, func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addCompletedDownload");
        }

        public static /* synthetic */ Fetch addCompletedDownloads$default(Fetch fetch, List list, boolean z, Func func, Func func2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = true;
                }
                if ((i & 4) != 0) {
                    func = null;
                }
                if ((i & 8) != 0) {
                    func2 = null;
                }
                return fetch.addCompletedDownloads(list, z, func, func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addCompletedDownloads");
        }

        public static /* synthetic */ Fetch getServerResponse$default(Fetch fetch, String str, Map map, Func func, Func func2, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    func2 = null;
                }
                return fetch.getServerResponse(str, map, func, func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getServerResponse");
        }

        public static /* synthetic */ Fetch getFetchFileServerCatalog$default(Fetch fetch, Request request, Func func, Func func2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    func2 = null;
                }
                return fetch.getFetchFileServerCatalog(request, func, func2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFetchFileServerCatalog");
        }

        public static /* synthetic */ Fetch addActiveDownloadsObserver$default(Fetch fetch, boolean z, FetchObserver fetchObserver, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return fetch.addActiveDownloadsObserver(z, fetchObserver);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addActiveDownloadsObserver");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/tonyodev/fetch2/Fetch$Impl;", "", "()V", "defaultFetchConfiguration", "Lcom/tonyodev/fetch2/FetchConfiguration;", "defaultFetchInstance", "Lcom/tonyodev/fetch2/Fetch;", "lock", "getDefaultFetchConfiguration", "getDefaultInstance", "getInstance", "fetchConfiguration", "setDefaultInstanceConfiguration", "", "fetch2_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Fetch.kt */
    public static final class Impl {
        static final /* synthetic */ Impl $$INSTANCE = new Impl();
        private static volatile FetchConfiguration defaultFetchConfiguration;
        private static volatile Fetch defaultFetchInstance;
        private static final Object lock = new Object();

        private Impl() {
        }

        public final void setDefaultInstanceConfiguration(FetchConfiguration fetchConfiguration) {
            Intrinsics.checkParameterIsNotNull(fetchConfiguration, "fetchConfiguration");
            synchronized (lock) {
                defaultFetchConfiguration = fetchConfiguration;
                Unit unit = Unit.INSTANCE;
            }
        }

        public final FetchConfiguration getDefaultFetchConfiguration() {
            FetchConfiguration fetchConfiguration;
            synchronized (lock) {
                fetchConfiguration = defaultFetchConfiguration;
            }
            return fetchConfiguration;
        }

        public final Fetch getDefaultInstance() {
            Fetch fetch;
            synchronized (lock) {
                FetchConfiguration fetchConfiguration = defaultFetchConfiguration;
                if (fetchConfiguration != null) {
                    fetch = defaultFetchInstance;
                    if (fetch == null || fetch.isClosed()) {
                        FetchImpl newInstance = FetchImpl.Companion.newInstance(FetchModulesBuilder.INSTANCE.buildModulesFromPrefs(fetchConfiguration));
                        defaultFetchInstance = newInstance;
                        fetch = newInstance;
                    }
                } else {
                    throw new FetchException(FetchErrorStrings.GLOBAL_FETCH_CONFIGURATION_NOT_SET);
                }
            }
            return fetch;
        }

        public final Fetch getInstance(FetchConfiguration fetchConfiguration) {
            Intrinsics.checkParameterIsNotNull(fetchConfiguration, "fetchConfiguration");
            return FetchImpl.Companion.newInstance(FetchModulesBuilder.INSTANCE.buildModulesFromPrefs(fetchConfiguration));
        }
    }
}
