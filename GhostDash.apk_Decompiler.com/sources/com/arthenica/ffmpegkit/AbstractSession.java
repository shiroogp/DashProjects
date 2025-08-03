package com.arthenica.ffmpegkit;

import android.util.Log;
import com.arthenica.smartexception.java.Exceptions;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

public abstract class AbstractSession implements Session {
    public static final int DEFAULT_TIMEOUT_FOR_ASYNCHRONOUS_MESSAGES_IN_TRANSMIT = 5000;
    protected static final AtomicLong sessionIdGenerator = new AtomicLong(1);
    protected final String[] arguments;
    protected final Date createTime;
    protected Date endTime;
    protected String failStackTrace;
    protected Future<?> future;
    protected final LogCallback logCallback;
    protected final LogRedirectionStrategy logRedirectionStrategy;
    protected final List<Log> logs;
    protected final Object logsLock;
    protected ReturnCode returnCode;
    protected final long sessionId = sessionIdGenerator.getAndIncrement();
    protected Date startTime;
    protected SessionState state;

    public AbstractSession(String[] strArr, LogCallback logCallback2, LogRedirectionStrategy logRedirectionStrategy2) {
        this.logCallback = logCallback2;
        this.createTime = new Date();
        this.startTime = null;
        this.endTime = null;
        this.arguments = strArr;
        this.logs = new LinkedList();
        this.logsLock = new Object();
        this.future = null;
        this.state = SessionState.CREATED;
        this.returnCode = null;
        this.failStackTrace = null;
        this.logRedirectionStrategy = logRedirectionStrategy2;
        FFmpegKitConfig.addSession(this);
    }

    public LogCallback getLogCallback() {
        return this.logCallback;
    }

    public long getSessionId() {
        return this.sessionId;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public long getDuration() {
        Date date = this.startTime;
        Date date2 = this.endTime;
        if (date == null || date2 == null) {
            return 0;
        }
        return date2.getTime() - date.getTime();
    }

    public String[] getArguments() {
        return this.arguments;
    }

    public String getCommand() {
        return FFmpegKitConfig.argumentsToString(this.arguments);
    }

    public List<Log> getAllLogs(int i) {
        waitForAsynchronousMessagesInTransmit(i);
        if (thereAreAsynchronousMessagesInTransmit()) {
            Log.i("ffmpeg-kit", String.format("getAllLogs was called to return all logs but there are still logs being transmitted for session id %d.", new Object[]{Long.valueOf(this.sessionId)}));
        }
        return getLogs();
    }

    public List<Log> getAllLogs() {
        return getAllLogs(DEFAULT_TIMEOUT_FOR_ASYNCHRONOUS_MESSAGES_IN_TRANSMIT);
    }

    public List<Log> getLogs() {
        LinkedList linkedList;
        synchronized (this.logsLock) {
            linkedList = new LinkedList(this.logs);
        }
        return linkedList;
    }

    public String getAllLogsAsString(int i) {
        waitForAsynchronousMessagesInTransmit(i);
        if (thereAreAsynchronousMessagesInTransmit()) {
            Log.i("ffmpeg-kit", String.format("getAllLogsAsString was called to return all logs but there are still logs being transmitted for session id %d.", new Object[]{Long.valueOf(this.sessionId)}));
        }
        return getLogsAsString();
    }

    public String getAllLogsAsString() {
        return getAllLogsAsString(DEFAULT_TIMEOUT_FOR_ASYNCHRONOUS_MESSAGES_IN_TRANSMIT);
    }

    public String getLogsAsString() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.logsLock) {
            for (Log message : this.logs) {
                sb.append(message.getMessage());
            }
        }
        return sb.toString();
    }

    public String getOutput() {
        return getAllLogsAsString();
    }

    public SessionState getState() {
        return this.state;
    }

    public ReturnCode getReturnCode() {
        return this.returnCode;
    }

    public String getFailStackTrace() {
        return this.failStackTrace;
    }

    public LogRedirectionStrategy getLogRedirectionStrategy() {
        return this.logRedirectionStrategy;
    }

    public boolean thereAreAsynchronousMessagesInTransmit() {
        return FFmpegKitConfig.messagesInTransmit(this.sessionId) != 0;
    }

    public void addLog(Log log) {
        synchronized (this.logsLock) {
            this.logs.add(log);
        }
    }

    public Future<?> getFuture() {
        return this.future;
    }

    public void cancel() {
        if (this.state == SessionState.RUNNING) {
            FFmpegKit.cancel(this.sessionId);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void waitForAsynchronousMessagesInTransmit(int r7) {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
        L_0x0004:
            boolean r2 = r6.thereAreAsynchronousMessagesInTransmit()
            if (r2 == 0) goto L_0x0021
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = (long) r7
            long r4 = r4 + r0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0021
            monitor-enter(r6)
            r2 = 100
            r6.wait(r2)     // Catch:{ InterruptedException -> 0x001d }
            goto L_0x001d
        L_0x001b:
            r7 = move-exception
            goto L_0x001f
        L_0x001d:
            monitor-exit(r6)     // Catch:{ all -> 0x001b }
            goto L_0x0004
        L_0x001f:
            monitor-exit(r6)     // Catch:{ all -> 0x001b }
            throw r7
        L_0x0021:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arthenica.ffmpegkit.AbstractSession.waitForAsynchronousMessagesInTransmit(int):void");
    }

    /* access modifiers changed from: package-private */
    public void setFuture(Future<?> future2) {
        this.future = future2;
    }

    /* access modifiers changed from: package-private */
    public void startRunning() {
        this.state = SessionState.RUNNING;
        this.startTime = new Date();
    }

    /* access modifiers changed from: package-private */
    public void complete(ReturnCode returnCode2) {
        this.returnCode = returnCode2;
        this.state = SessionState.COMPLETED;
        this.endTime = new Date();
    }

    /* access modifiers changed from: package-private */
    public void fail(Exception exc) {
        this.failStackTrace = Exceptions.getStackTraceString(exc);
        this.state = SessionState.FAILED;
        this.endTime = new Date();
    }
}
