package com.tonyodev.fetch2.fetch;

import android.os.Handler;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tonyodev.fetch2.CompletedDownload;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.Fetch;
import com.tonyodev.fetch2.FetchConfiguration;
import com.tonyodev.fetch2.FetchGroup;
import com.tonyodev.fetch2.FetchListener;
import com.tonyodev.fetch2.NetworkType;
import com.tonyodev.fetch2.Request;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2.database.DownloadDatabase;
import com.tonyodev.fetch2.database.FetchDatabaseManagerWrapper;
import com.tonyodev.fetch2.exception.FetchException;
import com.tonyodev.fetch2.fetch.FetchModulesBuilder;
import com.tonyodev.fetch2.util.ActiveDownloadInfo;
import com.tonyodev.fetch2.util.FetchUtils;
import com.tonyodev.fetch2core.DownloadBlock;
import com.tonyodev.fetch2core.Downloader;
import com.tonyodev.fetch2core.Extras;
import com.tonyodev.fetch2core.FetchObserver;
import com.tonyodev.fetch2core.FileResource;
import com.tonyodev.fetch2core.Func;
import com.tonyodev.fetch2core.Func2;
import com.tonyodev.fetch2core.HandlerWrapper;
import com.tonyodev.fetch2core.Logger;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 ¢\u00012\u00020\u0001:\u0002¢\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u001e\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u00192\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00190%H\u0016J8\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00192\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016JD\u0010/\u001a\u00020\u00012\f\u00100\u001a\b\u0012\u0004\u0012\u00020(012\u0006\u0010)\u001a\u00020\u00192\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\u0010\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u000204H\u0016J\u0018\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0019H\u0016J \u00102\u001a\u00020\u00012\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00192\u0006\u00106\u001a\u00020\u0019H\u0016J5\u00107\u001a\u00020\u00012\u0006\u00108\u001a\u0002092\u001e\u0010:\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020,0%0;\"\b\u0012\u0004\u0012\u00020,0%H\u0016¢\u0006\u0002\u0010<J\b\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010B\u001a\u00020\u00012\u0006\u0010C\u001a\u000209H\u0016J0\u0010B\u001a\u00020\u00012\u0006\u0010C\u001a\u0002092\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\u0016\u0010B\u001a\u00020\u00012\f\u0010D\u001a\b\u0012\u0004\u0012\u00020901H\u0016J<\u0010B\u001a\u00020\u00012\f\u0010D\u001a\b\u0012\u0004\u0012\u000209012\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\b\u0010E\u001a\u00020\u0001H\u0016J.\u0010E\u001a\u00020\u00012\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\u0010\u0010F\u001a\u00020\u00012\u0006\u0010C\u001a\u000209H\u0016J6\u0010F\u001a\u00020\u00012\u0006\u0010C\u001a\u0002092\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\b\u0010G\u001a\u00020>H\u0016J\u0010\u0010H\u001a\u00020\u00012\u0006\u0010C\u001a\u000209H\u0016J0\u0010H\u001a\u00020\u00012\u0006\u0010C\u001a\u0002092\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\u0016\u0010H\u001a\u00020\u00012\f\u0010D\u001a\b\u0012\u0004\u0012\u00020901H\u0016J<\u0010H\u001a\u00020\u00012\f\u0010D\u001a\b\u0012\u0004\u0012\u000209012\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\b\u0010I\u001a\u00020\u0001H\u0016J.\u0010I\u001a\u00020\u00012\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\u001e\u0010J\u001a\u00020\u00012\u0006\u0010C\u001a\u0002092\f\u0010K\u001a\b\u0012\u0004\u0012\u00020L01H\u0016JD\u0010J\u001a\u00020\u00012\u0006\u0010C\u001a\u0002092\f\u0010K\u001a\b\u0012\u0004\u0012\u00020L012\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\u0010\u0010M\u001a\u00020\u00012\u0006\u0010N\u001a\u00020LH\u0016J6\u0010M\u001a\u00020\u00012\u0006\u0010N\u001a\u00020L2\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\u0010\u0010O\u001a\u00020\u00012\u0006\u0010C\u001a\u000209H\u0016J6\u0010O\u001a\u00020\u00012\u0006\u0010C\u001a\u0002092\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\u0010\u0010P\u001a\u00020\u00012\u0006\u0010Q\u001a\u00020\u0019H\u0016J0\u0010R\u001a\u00020\u00012\u0006\u0010S\u001a\u00020T2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J8\u0010R\u001a\u00020\u00012\f\u0010U\u001a\b\u0012\u0004\u0012\u00020T012 \u0010*\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020.0V01\u0018\u00010+H\u0016JH\u0010W\u001a\u00020>2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020T012 \u0010*\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020.0V01\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0002JB\u0010X\u001a\u00020\u00012\u0012\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,010Z2\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0002JB\u0010[\u001a\u00020\u00012\u0012\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,010Z2\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0002JB\u0010\\\u001a\u00020\u00012\u0012\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,010Z2\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0002J\b\u0010]\u001a\u00020\u0001H\u0016J(\u0010]\u001a\u00020\u00012\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\u001c\u0010^\u001a\u00020\u00012\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000209010+H\u0016J6\u0010_\u001a\u00020\u00012\u0006\u0010S\u001a\u00020T2\u0006\u0010`\u001a\u00020\u00192\f\u0010*\u001a\b\u0012\u0004\u0012\u00020A0+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J^\u0010a\u001a\u00020\u00012\f\u0010U\u001a\b\u0012\u0004\u0012\u00020T012\u0006\u0010`\u001a\u00020\u00192\u001e\u0010*\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020A0V010+2\u001e\u0010-\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020.0V010+H\u0016J \u0010b\u001a\u00020\u00012\u0006\u0010C\u001a\u0002092\u000e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0cH\u0016J$\u0010d\u001a\u00020\u00012\u0006\u00108\u001a\u0002092\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020e010+H\u0016J\u001c\u0010f\u001a\u00020\u00012\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,010+H\u0016J*\u0010f\u001a\u00020\u00012\f\u0010g\u001a\b\u0012\u0004\u0012\u000209012\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,010+H\u0016J$\u0010h\u001a\u00020\u00012\u0006\u0010i\u001a\u00020A2\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,010+H\u0016J$\u0010j\u001a\u00020\u00012\u0006\u0010k\u001a\u00020\u00032\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,010+H\u0016J$\u0010l\u001a\u00020\u00012\u0006\u0010m\u001a\u0002092\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,010+H\u0016J2\u0010n\u001a\u00020\u00012\u0006\u0010m\u001a\u0002092\f\u0010K\u001a\b\u0012\u0004\u0012\u00020L012\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,010+H\u0016J$\u0010o\u001a\u00020\u00012\u0006\u0010N\u001a\u00020L2\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,010+H\u0016J*\u0010o\u001a\u00020\u00012\f\u0010K\u001a\b\u0012\u0004\u0012\u00020L012\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,010+H\u0016J4\u0010p\u001a\u00020\u00012\u0006\u0010S\u001a\u00020T2\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020q010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\u001e\u0010r\u001a\u00020\u00012\u0006\u0010s\u001a\u0002092\f\u0010*\u001a\b\u0012\u0004\u0012\u00020t0+H\u0016J\u000e\u0010u\u001a\b\u0012\u0004\u0012\u0002040vH\u0016JD\u0010w\u001a\u00020\u00012\u0006\u0010x\u001a\u00020\u00032\u0014\u0010y\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010z2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020{0+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\u001e\u0010|\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u00192\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00190+H\u0016J\u0010\u0010}\u001a\u00020\u00012\u0006\u0010C\u001a\u000209H\u0016J0\u0010}\u001a\u00020\u00012\u0006\u0010C\u001a\u0002092\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\u0016\u0010}\u001a\u00020\u00012\f\u0010D\u001a\b\u0012\u0004\u0012\u00020901H\u0016J<\u0010}\u001a\u00020\u00012\f\u0010D\u001a\b\u0012\u0004\u0012\u000209012\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\b\u0010~\u001a\u00020\u0001H\u0016JN\u0010\u001a\u00020>2\u000e\u0010D\u001a\n\u0012\u0004\u0012\u000209\u0018\u0001012\b\u0010m\u001a\u0004\u0018\u0001092\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0002¢\u0006\u0003\u0010\u0001J\u0011\u0010\u0001\u001a\u00020\u00012\u0006\u0010C\u001a\u000209H\u0016J7\u0010\u0001\u001a\u00020\u00012\u0006\u0010C\u001a\u0002092\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\t\u0010\u0001\u001a\u00020>H\u0002J\u0011\u0010\u0001\u001a\u00020\u00012\u0006\u0010C\u001a\u000209H\u0016J1\u0010\u0001\u001a\u00020\u00012\u0006\u0010C\u001a\u0002092\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\u0017\u0010\u0001\u001a\u00020\u00012\f\u0010D\u001a\b\u0012\u0004\u0012\u00020901H\u0016J=\u0010\u0001\u001a\u00020\u00012\f\u0010D\u001a\b\u0012\u0004\u0012\u000209012\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\u0017\u0010\u0001\u001a\u00020\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00190%H\u0016J\t\u0010\u0001\u001a\u00020\u0001H\u0016J/\u0010\u0001\u001a\u00020\u00012\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\u001f\u0010\u0001\u001a\u00020\u00012\u0006\u0010C\u001a\u0002092\f\u0010K\u001a\b\u0012\u0004\u0012\u00020L01H\u0016JE\u0010\u0001\u001a\u00020\u00012\u0006\u0010C\u001a\u0002092\f\u0010K\u001a\b\u0012\u0004\u0012\u00020L012\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\u0011\u0010\u0001\u001a\u00020\u00012\u0006\u0010N\u001a\u00020LH\u0016J7\u0010\u0001\u001a\u00020\u00012\u0006\u0010N\u001a\u00020L2\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J6\u0010\u0001\u001a\u00020\u00012\u0006\u00108\u001a\u0002092\u001e\u0010:\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020,0%0;\"\b\u0012\u0004\u0012\u00020,0%H\u0016¢\u0006\u0002\u0010<J\u0011\u0010\u0001\u001a\u00020\u00012\u0006\u0010C\u001a\u000209H\u0016J7\u0010\u0001\u001a\u00020\u00012\u0006\u0010C\u001a\u0002092\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\u0011\u0010\u0001\u001a\u00020\u00012\u0006\u00103\u001a\u000204H\u0016J:\u0010\u0001\u001a\u00020\u00012\u0006\u0010C\u001a\u0002092\u0007\u0010\u0001\u001a\u00020\u00032\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J;\u0010\u0001\u001a\u00020\u00012\u0006\u0010C\u001a\u0002092\b\u0010\u0001\u001a\u00030\u00012\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J<\u0010\u0001\u001a\u00020\u00012\u0006\u00108\u001a\u0002092\u0007\u0010\u0001\u001a\u00020\u00192\u0010\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010,\u0018\u00010c2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\u0011\u0010\u0001\u001a\u00020\u00012\u0006\u0010C\u001a\u000209H\u0016J1\u0010\u0001\u001a\u00020\u00012\u0006\u0010C\u001a\u0002092\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\u0017\u0010\u0001\u001a\u00020\u00012\f\u0010D\u001a\b\u0012\u0004\u0012\u00020901H\u0016J=\u0010\u0001\u001a\u00020\u00012\f\u0010D\u001a\b\u0012\u0004\u0012\u000209012\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\t\u0010\u0001\u001a\u00020\u0001H\u0016JO\u0010\u0001\u001a\u00020>2\u000e\u0010D\u001a\n\u0012\u0004\u0012\u000209\u0018\u0001012\b\u0010m\u001a\u0004\u0018\u0001092\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0002¢\u0006\u0003\u0010\u0001J\u0011\u0010\u0001\u001a\u00020\u00012\u0006\u0010C\u001a\u000209H\u0016J7\u0010\u0001\u001a\u00020\u00012\u0006\u0010C\u001a\u0002092\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\u0011\u0010\u0001\u001a\u00020\u00012\u0006\u0010C\u001a\u000209H\u0016J1\u0010\u0001\u001a\u00020\u00012\u0006\u0010C\u001a\u0002092\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\u0017\u0010\u0001\u001a\u00020\u00012\f\u0010D\u001a\b\u0012\u0004\u0012\u00020901H\u0016J=\u0010\u0001\u001a\u00020\u00012\f\u0010D\u001a\b\u0012\u0004\u0012\u000209012\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020,01\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016J\u0012\u0010\u0001\u001a\u00020\u00012\u0007\u0010\u0001\u001a\u000209H\u0016J\u0013\u0010\u0001\u001a\u00020\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016J\t\u0010\u0001\u001a\u00020>H\u0002J\t\u0010\u0001\u001a\u00020\u0001H\u0016J)\u0010\u0001\u001a\u00020\u00012\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016JD\u0010\u0001\u001a\u00020\u00012\u0007\u0010\u0001\u001a\u0002092\u0007\u0010 \u0001\u001a\u00020T2\u0007\u0010¡\u0001\u001a\u00020\u00192\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010+H\u0016R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006£\u0001"}, d2 = {"Lcom/tonyodev/fetch2/fetch/FetchImpl;", "Lcom/tonyodev/fetch2/Fetch;", "namespace", "", "fetchConfiguration", "Lcom/tonyodev/fetch2/FetchConfiguration;", "handlerWrapper", "Lcom/tonyodev/fetch2core/HandlerWrapper;", "uiHandler", "Landroid/os/Handler;", "fetchHandler", "Lcom/tonyodev/fetch2/fetch/FetchHandler;", "logger", "Lcom/tonyodev/fetch2core/Logger;", "listenerCoordinator", "Lcom/tonyodev/fetch2/fetch/ListenerCoordinator;", "fetchDatabaseManagerWrapper", "Lcom/tonyodev/fetch2/database/FetchDatabaseManagerWrapper;", "(Ljava/lang/String;Lcom/tonyodev/fetch2/FetchConfiguration;Lcom/tonyodev/fetch2core/HandlerWrapper;Landroid/os/Handler;Lcom/tonyodev/fetch2/fetch/FetchHandler;Lcom/tonyodev/fetch2core/Logger;Lcom/tonyodev/fetch2/fetch/ListenerCoordinator;Lcom/tonyodev/fetch2/database/FetchDatabaseManagerWrapper;)V", "activeDownloadsRunnable", "Ljava/lang/Runnable;", "activeDownloadsSet", "", "Lcom/tonyodev/fetch2/util/ActiveDownloadInfo;", "closed", "", "getFetchConfiguration", "()Lcom/tonyodev/fetch2/FetchConfiguration;", "isClosed", "()Z", "lock", "Ljava/lang/Object;", "getNamespace", "()Ljava/lang/String;", "addActiveDownloadsObserver", "includeAddedDownloads", "fetchObserver", "Lcom/tonyodev/fetch2core/FetchObserver;", "addCompletedDownload", "completedDownload", "Lcom/tonyodev/fetch2/CompletedDownload;", "alertListeners", "func", "Lcom/tonyodev/fetch2core/Func;", "Lcom/tonyodev/fetch2/Download;", "func2", "Lcom/tonyodev/fetch2/Error;", "addCompletedDownloads", "completedDownloads", "", "addListener", "listener", "Lcom/tonyodev/fetch2/FetchListener;", "notify", "autoStart", "attachFetchObserversForDownload", "downloadId", "", "fetchObservers", "", "(I[Lcom/tonyodev/fetch2core/FetchObserver;)Lcom/tonyodev/fetch2/Fetch;", "awaitFinish", "", "awaitFinishOrTimeout", "allowTimeInMilliseconds", "", "cancel", "id", "ids", "cancelAll", "cancelGroup", "close", "delete", "deleteAll", "deleteAllInGroupWithStatus", "statuses", "Lcom/tonyodev/fetch2/Status;", "deleteAllWithStatus", "status", "deleteGroup", "enableLogging", "enabled", "enqueue", "request", "Lcom/tonyodev/fetch2/Request;", "requests", "Lkotlin/Pair;", "enqueueRequest", "executeCancelAction", "downloadAction", "Lkotlin/Function0;", "executeDeleteAction", "executeRemoveAction", "freeze", "getAllGroupIds", "getContentLengthForRequest", "fromServer", "getContentLengthForRequests", "getDownload", "Lcom/tonyodev/fetch2core/Func2;", "getDownloadBlocks", "Lcom/tonyodev/fetch2core/DownloadBlock;", "getDownloads", "idList", "getDownloadsByRequestIdentifier", "identifier", "getDownloadsByTag", "tag", "getDownloadsInGroup", "groupId", "getDownloadsInGroupWithStatus", "getDownloadsWithStatus", "getFetchFileServerCatalog", "Lcom/tonyodev/fetch2core/FileResource;", "getFetchGroup", "group", "Lcom/tonyodev/fetch2/FetchGroup;", "getListenerSet", "", "getServerResponse", "url", "headers", "", "Lcom/tonyodev/fetch2core/Downloader$Response;", "hasActiveDownloads", "pause", "pauseAll", "pauseDownloads", "(Ljava/util/List;Ljava/lang/Integer;Lcom/tonyodev/fetch2core/Func;Lcom/tonyodev/fetch2core/Func;)V", "pauseGroup", "registerActiveDownloadsRunnable", "remove", "removeActiveDownloadsObserver", "removeAll", "removeAllInGroupWithStatus", "removeAllWithStatus", "removeFetchObserversForDownload", "removeGroup", "removeListener", "renameCompletedDownloadFile", "newFileName", "replaceExtras", "extras", "Lcom/tonyodev/fetch2core/Extras;", "resetAutoRetryAttempts", "retryDownload", "resume", "resumeAll", "resumeDownloads", "resumeGroup", "retry", "setDownloadConcurrentLimit", "downloadConcurrentLimit", "setGlobalNetworkType", "networkType", "Lcom/tonyodev/fetch2/NetworkType;", "throwExceptionIfClosed", "unfreeze", "updateRequest", "requestId", "updatedRequest", "notifyListeners", "Companion", "fetch2_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FetchImpl.kt */
public class FetchImpl implements Fetch {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Runnable activeDownloadsRunnable = new FetchImpl$activeDownloadsRunnable$1(this);
    /* access modifiers changed from: private */
    public final Set<ActiveDownloadInfo> activeDownloadsSet = new LinkedHashSet();
    private volatile boolean closed;
    private final FetchConfiguration fetchConfiguration;
    /* access modifiers changed from: private */
    public final FetchDatabaseManagerWrapper fetchDatabaseManagerWrapper;
    /* access modifiers changed from: private */
    public final FetchHandler fetchHandler;
    private final HandlerWrapper handlerWrapper;
    /* access modifiers changed from: private */
    public final ListenerCoordinator listenerCoordinator;
    private final Object lock = new Object();
    /* access modifiers changed from: private */
    public final Logger logger;
    private final String namespace;
    /* access modifiers changed from: private */
    public final Handler uiHandler;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Status.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Status.ADDED.ordinal()] = 1;
            iArr[Status.QUEUED.ordinal()] = 2;
            iArr[Status.COMPLETED.ordinal()] = 3;
            int[] iArr2 = new int[Status.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[Status.COMPLETED.ordinal()] = 1;
            iArr2[Status.FAILED.ordinal()] = 2;
            iArr2[Status.CANCELLED.ordinal()] = 3;
            iArr2[Status.DELETED.ordinal()] = 4;
            iArr2[Status.PAUSED.ordinal()] = 5;
            iArr2[Status.QUEUED.ordinal()] = 6;
            iArr2[Status.REMOVED.ordinal()] = 7;
            iArr2[Status.DOWNLOADING.ordinal()] = 8;
            iArr2[Status.ADDED.ordinal()] = 9;
            iArr2[Status.NONE.ordinal()] = 10;
        }
    }

    @JvmStatic
    public static final FetchImpl newInstance(FetchModulesBuilder.Modules modules) {
        return Companion.newInstance(modules);
    }

    public FetchImpl(String str, FetchConfiguration fetchConfiguration2, HandlerWrapper handlerWrapper2, Handler handler, FetchHandler fetchHandler2, Logger logger2, ListenerCoordinator listenerCoordinator2, FetchDatabaseManagerWrapper fetchDatabaseManagerWrapper2) {
        Intrinsics.checkParameterIsNotNull(str, "namespace");
        Intrinsics.checkParameterIsNotNull(fetchConfiguration2, "fetchConfiguration");
        Intrinsics.checkParameterIsNotNull(handlerWrapper2, "handlerWrapper");
        Intrinsics.checkParameterIsNotNull(handler, "uiHandler");
        Intrinsics.checkParameterIsNotNull(fetchHandler2, "fetchHandler");
        Intrinsics.checkParameterIsNotNull(logger2, "logger");
        Intrinsics.checkParameterIsNotNull(listenerCoordinator2, "listenerCoordinator");
        Intrinsics.checkParameterIsNotNull(fetchDatabaseManagerWrapper2, "fetchDatabaseManagerWrapper");
        this.namespace = str;
        this.fetchConfiguration = fetchConfiguration2;
        this.handlerWrapper = handlerWrapper2;
        this.uiHandler = handler;
        this.fetchHandler = fetchHandler2;
        this.logger = logger2;
        this.listenerCoordinator = listenerCoordinator2;
        this.fetchDatabaseManagerWrapper = fetchDatabaseManagerWrapper2;
        handlerWrapper2.post(new Function0<Unit>(this) {
            final /* synthetic */ FetchImpl this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                this.this$0.fetchHandler.init();
            }
        });
        registerActiveDownloadsRunnable();
    }

    public String getNamespace() {
        return this.namespace;
    }

    public final FetchConfiguration getFetchConfiguration() {
        return this.fetchConfiguration;
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this.lock) {
            z = this.closed;
        }
        return z;
    }

    /* access modifiers changed from: private */
    public final void registerActiveDownloadsRunnable() {
        this.handlerWrapper.postDelayed(this.activeDownloadsRunnable, this.fetchConfiguration.getActiveDownloadsCheckInterval());
    }

    public Fetch enqueue(Request request, Func<Request> func, Func<Error> func2) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        enqueueRequest(CollectionsKt.listOf(request), new FetchImpl$enqueue$1(this, func2, func), func2);
        return this;
    }

    public Fetch enqueue(List<? extends Request> list, Func<List<Pair<Request, Error>>> func) {
        Intrinsics.checkParameterIsNotNull(list, DownloadDatabase.TABLE_NAME);
        enqueueRequest(list, func, (Func<Error>) null);
        return this;
    }

    private final void enqueueRequest(List<? extends Request> list, Func<List<Pair<Request, Error>>> func, Func<Error> func2) {
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$enqueueRequest$$inlined$synchronized$lambda$1(this, list, func, func2));
            Unit unit = Unit.INSTANCE;
        }
    }

    public Fetch pause(List<Integer> list, Func<List<Download>> func, Func<Error> func2) {
        Intrinsics.checkParameterIsNotNull(list, "ids");
        pauseDownloads(list, (Integer) null, func, func2);
        return this;
    }

    public Fetch pause(List<Integer> list) {
        Intrinsics.checkParameterIsNotNull(list, "ids");
        return pause(list, (Func<List<Download>>) null, (Func<Error>) null);
    }

    public Fetch pause(int i, Func<Download> func, Func<Error> func2) {
        return pause((List<Integer>) CollectionsKt.listOf(Integer.valueOf(i)), (Func<List<Download>>) new FetchImpl$pause$1(func, func2), func2);
    }

    public Fetch pause(int i) {
        return pause(i, (Func<Download>) null, (Func<Error>) null);
    }

    public Fetch pauseGroup(int i, Func<List<Download>> func, Func<Error> func2) {
        pauseDownloads((List<Integer>) null, Integer.valueOf(i), func, func2);
        return this;
    }

    private final void pauseDownloads(List<Integer> list, Integer num, Func<List<Download>> func, Func<Error> func2) {
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$pauseDownloads$$inlined$synchronized$lambda$1(this, list, num, func, func2));
            Unit unit = Unit.INSTANCE;
        }
    }

    public Fetch pauseGroup(int i) {
        return pauseGroup(i, (Func<List<Download>>) null, (Func<Error>) null);
    }

    public Fetch pauseAll() {
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$pauseAll$$inlined$synchronized$lambda$1(this));
            Unit unit = Unit.INSTANCE;
        }
        return this;
    }

    public Fetch freeze(Func<Boolean> func, Func<Error> func2) {
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$freeze$$inlined$synchronized$lambda$1(this, func, func2));
        }
        return this;
    }

    public Fetch freeze() {
        return freeze((Func<Boolean>) null, (Func<Error>) null);
    }

    public Fetch unfreeze(Func<Boolean> func, Func<Error> func2) {
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$unfreeze$$inlined$synchronized$lambda$1(this, func, func2));
        }
        return this;
    }

    public Fetch unfreeze() {
        return unfreeze((Func<Boolean>) null, (Func<Error>) null);
    }

    public Fetch resume(List<Integer> list, Func<List<Download>> func, Func<Error> func2) {
        Intrinsics.checkParameterIsNotNull(list, "ids");
        resumeDownloads(list, (Integer) null, func, func2);
        return this;
    }

    public Fetch resume(List<Integer> list) {
        Intrinsics.checkParameterIsNotNull(list, "ids");
        return resume(list, (Func<List<Download>>) null, (Func<Error>) null);
    }

    public Fetch resume(int i, Func<Download> func, Func<Error> func2) {
        return resume((List<Integer>) CollectionsKt.listOf(Integer.valueOf(i)), (Func<List<Download>>) new FetchImpl$resume$1(func, func2), func2);
    }

    public Fetch resume(int i) {
        return resume(i, (Func<Download>) null, (Func<Error>) null);
    }

    public Fetch resumeGroup(int i, Func<List<Download>> func, Func<Error> func2) {
        resumeDownloads((List<Integer>) null, Integer.valueOf(i), func, func2);
        return this;
    }

    public Fetch resumeGroup(int i) {
        return resumeGroup(i, (Func<List<Download>>) null, (Func<Error>) null);
    }

    private final void resumeDownloads(List<Integer> list, Integer num, Func<List<Download>> func, Func<Error> func2) {
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$resumeDownloads$$inlined$synchronized$lambda$1(this, list, num, func, func2));
            Unit unit = Unit.INSTANCE;
        }
    }

    public Fetch resumeAll() {
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$resumeAll$$inlined$synchronized$lambda$1(this));
            Unit unit = Unit.INSTANCE;
        }
        return this;
    }

    public Fetch remove(List<Integer> list, Func<List<Download>> func, Func<Error> func2) {
        Intrinsics.checkParameterIsNotNull(list, "ids");
        return executeRemoveAction(new FetchImpl$remove$1(this, list), func, func2);
    }

    public Fetch remove(List<Integer> list) {
        Intrinsics.checkParameterIsNotNull(list, "ids");
        return remove(list, (Func<List<Download>>) null, (Func<Error>) null);
    }

    public Fetch remove(int i) {
        return remove(i, (Func<Download>) null, (Func<Error>) null);
    }

    public Fetch remove(int i, Func<Download> func, Func<Error> func2) {
        return remove((List<Integer>) CollectionsKt.listOf(Integer.valueOf(i)), (Func<List<Download>>) new FetchImpl$remove$2(func, func2), func2);
    }

    public Fetch removeGroup(int i, Func<List<Download>> func, Func<Error> func2) {
        return executeRemoveAction(new FetchImpl$removeGroup$1(this, i), func, func2);
    }

    public Fetch removeGroup(int i) {
        return removeGroup(i, (Func<List<Download>>) null, (Func<Error>) null);
    }

    public Fetch removeAll(Func<List<Download>> func, Func<Error> func2) {
        return executeRemoveAction(new FetchImpl$removeAll$1(this), func, func2);
    }

    public Fetch removeAll() {
        return removeAll((Func<List<Download>>) null, (Func<Error>) null);
    }

    public Fetch removeAllWithStatus(Status status, Func<List<Download>> func, Func<Error> func2) {
        Intrinsics.checkParameterIsNotNull(status, "status");
        return executeRemoveAction(new FetchImpl$removeAllWithStatus$1(this, status), func, func2);
    }

    public Fetch removeAllWithStatus(Status status) {
        Intrinsics.checkParameterIsNotNull(status, "status");
        return removeAllWithStatus(status, (Func<List<Download>>) null, (Func<Error>) null);
    }

    public Fetch removeAllInGroupWithStatus(int i, List<? extends Status> list, Func<List<Download>> func, Func<Error> func2) {
        Intrinsics.checkParameterIsNotNull(list, "statuses");
        return executeRemoveAction(new FetchImpl$removeAllInGroupWithStatus$1(this, i, list), func, func2);
    }

    public Fetch removeAllInGroupWithStatus(int i, List<? extends Status> list) {
        Intrinsics.checkParameterIsNotNull(list, "statuses");
        return removeAllInGroupWithStatus(i, list, (Func<List<Download>>) null, (Func<Error>) null);
    }

    private final Fetch executeRemoveAction(Function0<? extends List<? extends Download>> function0, Func<List<Download>> func, Func<Error> func2) {
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$executeRemoveAction$$inlined$synchronized$lambda$1(this, function0, func, func2));
        }
        return this;
    }

    public Fetch delete(List<Integer> list, Func<List<Download>> func, Func<Error> func2) {
        Intrinsics.checkParameterIsNotNull(list, "ids");
        return executeDeleteAction(new FetchImpl$delete$1(this, list), func, func2);
    }

    public Fetch delete(int i, Func<Download> func, Func<Error> func2) {
        return delete((List<Integer>) CollectionsKt.listOf(Integer.valueOf(i)), (Func<List<Download>>) new FetchImpl$delete$2(func, func2), func2);
    }

    public Fetch deleteGroup(int i, Func<List<Download>> func, Func<Error> func2) {
        return executeDeleteAction(new FetchImpl$deleteGroup$1(this, i), func, func2);
    }

    public Fetch delete(List<Integer> list) {
        Intrinsics.checkParameterIsNotNull(list, "ids");
        return delete(list, (Func<List<Download>>) null, (Func<Error>) null);
    }

    public Fetch delete(int i) {
        return delete(i, (Func<Download>) null, (Func<Error>) null);
    }

    public Fetch deleteGroup(int i) {
        return deleteGroup(i, (Func<List<Download>>) null, (Func<Error>) null);
    }

    public Fetch deleteAll(Func<List<Download>> func, Func<Error> func2) {
        return executeDeleteAction(new FetchImpl$deleteAll$1(this), func, func2);
    }

    public Fetch deleteAll() {
        return deleteAll((Func<List<Download>>) null, (Func<Error>) null);
    }

    public Fetch deleteAllWithStatus(Status status, Func<List<Download>> func, Func<Error> func2) {
        Intrinsics.checkParameterIsNotNull(status, "status");
        return executeDeleteAction(new FetchImpl$deleteAllWithStatus$1(this, status), func, func2);
    }

    public Fetch deleteAllWithStatus(Status status) {
        Intrinsics.checkParameterIsNotNull(status, "status");
        return deleteAllWithStatus(status, (Func<List<Download>>) null, (Func<Error>) null);
    }

    public Fetch deleteAllInGroupWithStatus(int i, List<? extends Status> list, Func<List<Download>> func, Func<Error> func2) {
        Intrinsics.checkParameterIsNotNull(list, "statuses");
        return executeDeleteAction(new FetchImpl$deleteAllInGroupWithStatus$1(this, i, list), func, func2);
    }

    public Fetch deleteAllInGroupWithStatus(int i, List<? extends Status> list) {
        Intrinsics.checkParameterIsNotNull(list, "statuses");
        return deleteAllInGroupWithStatus(i, list, (Func<List<Download>>) null, (Func<Error>) null);
    }

    private final Fetch executeDeleteAction(Function0<? extends List<? extends Download>> function0, Func<List<Download>> func, Func<Error> func2) {
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$executeDeleteAction$$inlined$synchronized$lambda$1(this, function0, func, func2));
        }
        return this;
    }

    public Fetch cancel(List<Integer> list, Func<List<Download>> func, Func<Error> func2) {
        Intrinsics.checkParameterIsNotNull(list, "ids");
        return executeCancelAction(new FetchImpl$cancel$1(this, list), func, func2);
    }

    public Fetch cancel(List<Integer> list) {
        Intrinsics.checkParameterIsNotNull(list, "ids");
        return cancel(list, (Func<List<Download>>) null, (Func<Error>) null);
    }

    public Fetch cancel(int i, Func<Download> func, Func<Error> func2) {
        return cancel((List<Integer>) CollectionsKt.listOf(Integer.valueOf(i)), (Func<List<Download>>) new FetchImpl$cancel$2(func, func2), func2);
    }

    public Fetch cancel(int i) {
        return cancel(i, (Func<Download>) null, (Func<Error>) null);
    }

    public Fetch cancelGroup(int i, Func<List<Download>> func, Func<Error> func2) {
        return executeCancelAction(new FetchImpl$cancelGroup$1(this, i), func, func2);
    }

    public Fetch cancelGroup(int i) {
        return cancelGroup(i, (Func<List<Download>>) null, (Func<Error>) null);
    }

    public Fetch cancelAll(Func<List<Download>> func, Func<Error> func2) {
        return executeCancelAction(new FetchImpl$cancelAll$1(this), func, func2);
    }

    public Fetch cancelAll() {
        return cancelAll((Func<List<Download>>) null, (Func<Error>) null);
    }

    private final Fetch executeCancelAction(Function0<? extends List<? extends Download>> function0, Func<List<Download>> func, Func<Error> func2) {
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$executeCancelAction$$inlined$synchronized$lambda$1(this, function0, func, func2));
        }
        return this;
    }

    public Fetch retry(List<Integer> list, Func<List<Download>> func, Func<Error> func2) {
        Intrinsics.checkParameterIsNotNull(list, "ids");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$retry$$inlined$synchronized$lambda$1(this, list, func, func2));
        }
        return this;
    }

    public Fetch resetAutoRetryAttempts(int i, boolean z, Func2<Download> func2, Func<Error> func) {
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$resetAutoRetryAttempts$$inlined$synchronized$lambda$1(this, i, z, func2, func));
        }
        return this;
    }

    public Fetch retry(List<Integer> list) {
        Intrinsics.checkParameterIsNotNull(list, "ids");
        return retry(list, (Func<List<Download>>) null, (Func<Error>) null);
    }

    public Fetch retry(int i, Func<Download> func, Func<Error> func2) {
        return retry((List<Integer>) CollectionsKt.listOf(Integer.valueOf(i)), (Func<List<Download>>) new FetchImpl$retry$2(func, func2), func2);
    }

    public Fetch retry(int i) {
        return retry(i, (Func<Download>) null, (Func<Error>) null);
    }

    public Fetch updateRequest(int i, Request request, boolean z, Func<Download> func, Func<Error> func2) {
        Intrinsics.checkParameterIsNotNull(request, "updatedRequest");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$updateRequest$$inlined$synchronized$lambda$1(this, i, request, z, func, func2));
        }
        return this;
    }

    public Fetch renameCompletedDownloadFile(int i, String str, Func<Download> func, Func<Error> func2) {
        Intrinsics.checkParameterIsNotNull(str, "newFileName");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$renameCompletedDownloadFile$$inlined$synchronized$lambda$1(this, i, str, func, func2));
        }
        return this;
    }

    public Fetch replaceExtras(int i, Extras extras, Func<Download> func, Func<Error> func2) {
        Intrinsics.checkParameterIsNotNull(extras, "extras");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$replaceExtras$$inlined$synchronized$lambda$1(this, i, extras, func, func2));
        }
        return this;
    }

    public Fetch getDownloads(Func<List<Download>> func) {
        Intrinsics.checkParameterIsNotNull(func, "func");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$getDownloads$$inlined$synchronized$lambda$1(this, func));
        }
        return this;
    }

    public Fetch getDownload(int i, Func2<Download> func2) {
        Fetch fetch;
        Intrinsics.checkParameterIsNotNull(func2, "func2");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$getDownload$$inlined$synchronized$lambda$1(this, i, func2));
            fetch = this;
        }
        return fetch;
    }

    public Fetch getDownloads(List<Integer> list, Func<List<Download>> func) {
        Fetch fetch;
        Intrinsics.checkParameterIsNotNull(list, "idList");
        Intrinsics.checkParameterIsNotNull(func, "func");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$getDownloads$$inlined$synchronized$lambda$2(this, list, func));
            fetch = this;
        }
        return fetch;
    }

    public Fetch getDownloadsInGroup(int i, Func<List<Download>> func) {
        Fetch fetch;
        Intrinsics.checkParameterIsNotNull(func, "func");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$getDownloadsInGroup$$inlined$synchronized$lambda$1(this, i, func));
            fetch = this;
        }
        return fetch;
    }

    public Fetch getDownloadsWithStatus(Status status, Func<List<Download>> func) {
        Fetch fetch;
        Intrinsics.checkParameterIsNotNull(status, "status");
        Intrinsics.checkParameterIsNotNull(func, "func");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$getDownloadsWithStatus$$inlined$synchronized$lambda$1(this, status, func));
            fetch = this;
        }
        return fetch;
    }

    public Fetch getDownloadsInGroupWithStatus(int i, List<? extends Status> list, Func<List<Download>> func) {
        Fetch fetch;
        Intrinsics.checkParameterIsNotNull(list, "statuses");
        Intrinsics.checkParameterIsNotNull(func, "func");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$getDownloadsInGroupWithStatus$$inlined$synchronized$lambda$1(this, i, list, func));
            fetch = this;
        }
        return fetch;
    }

    public Fetch getDownloadsByRequestIdentifier(long j, Func<List<Download>> func) {
        Fetch fetch;
        Intrinsics.checkParameterIsNotNull(func, "func");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$getDownloadsByRequestIdentifier$$inlined$synchronized$lambda$1(this, j, func));
            fetch = this;
        }
        return fetch;
    }

    public Fetch getDownloadsWithStatus(List<? extends Status> list, Func<List<Download>> func) {
        Fetch fetch;
        Intrinsics.checkParameterIsNotNull(list, "statuses");
        Intrinsics.checkParameterIsNotNull(func, "func");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$getDownloadsWithStatus$$inlined$synchronized$lambda$2(this, list, func));
            fetch = this;
        }
        return fetch;
    }

    public Fetch getAllGroupIds(Func<List<Integer>> func) {
        Fetch fetch;
        Intrinsics.checkParameterIsNotNull(func, "func");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$getAllGroupIds$$inlined$synchronized$lambda$1(this, func));
            fetch = this;
        }
        return fetch;
    }

    public Fetch getDownloadsByTag(String str, Func<List<Download>> func) {
        Fetch fetch;
        Intrinsics.checkParameterIsNotNull(str, "tag");
        Intrinsics.checkParameterIsNotNull(func, "func");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$getDownloadsByTag$$inlined$synchronized$lambda$1(this, str, func));
            fetch = this;
        }
        return fetch;
    }

    public Fetch addCompletedDownload(CompletedDownload completedDownload, boolean z, Func<Download> func, Func<Error> func2) {
        Intrinsics.checkParameterIsNotNull(completedDownload, "completedDownload");
        return addCompletedDownloads(CollectionsKt.listOf(completedDownload), z, new FetchImpl$addCompletedDownload$1(func, func2), func2);
    }

    public Fetch addCompletedDownloads(List<? extends CompletedDownload> list, boolean z, Func<List<Download>> func, Func<Error> func2) {
        Fetch fetch;
        Intrinsics.checkParameterIsNotNull(list, "completedDownloads");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$addCompletedDownloads$$inlined$synchronized$lambda$1(this, list, z, func, func2));
            fetch = this;
        }
        return fetch;
    }

    public Fetch getFetchGroup(int i, Func<FetchGroup> func) {
        Intrinsics.checkParameterIsNotNull(func, "func");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$getFetchGroup$$inlined$synchronized$lambda$1(this, i, func));
            Unit unit = Unit.INSTANCE;
        }
        return this;
    }

    public Fetch hasActiveDownloads(boolean z, Func<Boolean> func) {
        Intrinsics.checkParameterIsNotNull(func, "func");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$hasActiveDownloads$$inlined$synchronized$lambda$1(this, z, func));
            Unit unit = Unit.INSTANCE;
        }
        return this;
    }

    public Fetch addListener(FetchListener fetchListener) {
        Intrinsics.checkParameterIsNotNull(fetchListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return addListener(fetchListener, false);
    }

    public Fetch addListener(FetchListener fetchListener, boolean z) {
        Intrinsics.checkParameterIsNotNull(fetchListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return addListener(fetchListener, z, false);
    }

    public Fetch addListener(FetchListener fetchListener, boolean z, boolean z2) {
        Fetch fetch;
        Intrinsics.checkParameterIsNotNull(fetchListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$addListener$$inlined$synchronized$lambda$1(this, fetchListener, z, z2));
            fetch = this;
        }
        return fetch;
    }

    public Fetch removeListener(FetchListener fetchListener) {
        Fetch fetch;
        Intrinsics.checkParameterIsNotNull(fetchListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$removeListener$$inlined$synchronized$lambda$1(this, fetchListener));
            fetch = this;
        }
        return fetch;
    }

    public Set<FetchListener> getListenerSet() {
        Set<FetchListener> listenerSet;
        synchronized (this.lock) {
            throwExceptionIfClosed();
            listenerSet = this.fetchHandler.getListenerSet();
        }
        return listenerSet;
    }

    public Fetch attachFetchObserversForDownload(int i, FetchObserver<Download>... fetchObserverArr) {
        Fetch fetch;
        Intrinsics.checkParameterIsNotNull(fetchObserverArr, "fetchObservers");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$attachFetchObserversForDownload$$inlined$synchronized$lambda$1(this, i, fetchObserverArr));
            fetch = this;
        }
        return fetch;
    }

    public Fetch removeFetchObserversForDownload(int i, FetchObserver<Download>... fetchObserverArr) {
        Fetch fetch;
        Intrinsics.checkParameterIsNotNull(fetchObserverArr, "fetchObservers");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$removeFetchObserversForDownload$$inlined$synchronized$lambda$1(this, i, fetchObserverArr));
            fetch = this;
        }
        return fetch;
    }

    public Fetch getDownloadBlocks(int i, Func<List<DownloadBlock>> func) {
        Fetch fetch;
        Intrinsics.checkParameterIsNotNull(func, "func");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$getDownloadBlocks$$inlined$synchronized$lambda$1(this, i, func));
            fetch = this;
        }
        return fetch;
    }

    public Fetch getContentLengthForRequest(Request request, boolean z, Func<Long> func, Func<Error> func2) {
        Fetch fetch;
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(func, "func");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.executeWorkerTask(new FetchImpl$getContentLengthForRequest$$inlined$synchronized$lambda$1(this, request, z, func, func2));
            fetch = this;
        }
        return fetch;
    }

    public Fetch getContentLengthForRequests(List<? extends Request> list, boolean z, Func<List<Pair<Request, Long>>> func, Func<List<Pair<Request, Error>>> func2) {
        Fetch fetch;
        Intrinsics.checkParameterIsNotNull(list, DownloadDatabase.TABLE_NAME);
        Intrinsics.checkParameterIsNotNull(func, "func");
        Intrinsics.checkParameterIsNotNull(func2, "func2");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.executeWorkerTask(new FetchImpl$getContentLengthForRequests$$inlined$synchronized$lambda$1(this, list, z, func, func2));
            fetch = this;
        }
        return fetch;
    }

    public Fetch getServerResponse(String str, Map<String, String> map, Func<Downloader.Response> func, Func<Error> func2) {
        Fetch fetch;
        Intrinsics.checkParameterIsNotNull(str, ImagesContract.URL);
        Intrinsics.checkParameterIsNotNull(func, "func");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.executeWorkerTask(new FetchImpl$getServerResponse$$inlined$synchronized$lambda$1(this, str, map, func, func2));
            fetch = this;
        }
        return fetch;
    }

    public Fetch getFetchFileServerCatalog(Request request, Func<List<FileResource>> func, Func<Error> func2) {
        Fetch fetch;
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(func, "func");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.executeWorkerTask(new FetchImpl$getFetchFileServerCatalog$$inlined$synchronized$lambda$1(this, request, func, func2));
            fetch = this;
        }
        return fetch;
    }

    public Fetch setGlobalNetworkType(NetworkType networkType) {
        Fetch fetch;
        Intrinsics.checkParameterIsNotNull(networkType, "networkType");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$setGlobalNetworkType$$inlined$synchronized$lambda$1(this, networkType));
            fetch = this;
        }
        return fetch;
    }

    public Fetch setDownloadConcurrentLimit(int i) {
        Fetch fetch;
        synchronized (this.lock) {
            throwExceptionIfClosed();
            if (i >= 0) {
                this.handlerWrapper.post(new FetchImpl$setDownloadConcurrentLimit$$inlined$synchronized$lambda$1(this, i));
                fetch = this;
            } else {
                throw new FetchException("Concurrent limit cannot be less than 0");
            }
        }
        return fetch;
    }

    public Fetch enableLogging(boolean z) {
        Fetch fetch;
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$enableLogging$$inlined$synchronized$lambda$1(this, z));
            fetch = this;
        }
        return fetch;
    }

    public void close() {
        synchronized (this.lock) {
            if (!this.closed) {
                this.closed = true;
                this.logger.d(getNamespace() + " closing/shutting down");
                this.handlerWrapper.removeCallbacks(this.activeDownloadsRunnable);
                this.handlerWrapper.post(new FetchImpl$close$$inlined$synchronized$lambda$1(this));
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final void throwExceptionIfClosed() {
        if (this.closed) {
            throw new FetchException("This fetch instance has been closed. Create a new instance using the builder.");
        }
    }

    public void awaitFinishOrTimeout(long j) {
        FetchUtils.awaitFinishOrTimeout(j, this.fetchHandler);
    }

    public void awaitFinish() {
        awaitFinishOrTimeout(-1);
    }

    public Fetch addActiveDownloadsObserver(boolean z, FetchObserver<Boolean> fetchObserver) {
        Fetch fetch;
        Intrinsics.checkParameterIsNotNull(fetchObserver, "fetchObserver");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$addActiveDownloadsObserver$$inlined$synchronized$lambda$1(this, fetchObserver, z));
            fetch = this;
        }
        return fetch;
    }

    public Fetch removeActiveDownloadsObserver(FetchObserver<Boolean> fetchObserver) {
        Fetch fetch;
        Intrinsics.checkParameterIsNotNull(fetchObserver, "fetchObserver");
        synchronized (this.lock) {
            throwExceptionIfClosed();
            this.handlerWrapper.post(new FetchImpl$removeActiveDownloadsObserver$$inlined$synchronized$lambda$1(this, fetchObserver));
            fetch = this;
        }
        return fetch;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/tonyodev/fetch2/fetch/FetchImpl$Companion;", "", "()V", "newInstance", "Lcom/tonyodev/fetch2/fetch/FetchImpl;", "modules", "Lcom/tonyodev/fetch2/fetch/FetchModulesBuilder$Modules;", "fetch2_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: FetchImpl.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final FetchImpl newInstance(FetchModulesBuilder.Modules modules) {
            Intrinsics.checkParameterIsNotNull(modules, "modules");
            return new FetchImpl(modules.getFetchConfiguration().getNamespace(), modules.getFetchConfiguration(), modules.getHandlerWrapper(), modules.getUiHandler(), modules.getFetchHandler(), modules.getFetchConfiguration().getLogger(), modules.getListenerCoordinator(), modules.getFetchDatabaseManagerWrapper());
        }
    }
}
