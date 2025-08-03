package com.arthenica.ffmpegkit;

import android.util.Log;
import java.util.LinkedList;
import java.util.List;

public class FFmpegSession extends AbstractSession implements Session {
    private final FFmpegSessionCompleteCallback completeCallback;
    private final List<Statistics> statistics;
    private final StatisticsCallback statisticsCallback;
    private final Object statisticsLock;

    public boolean isFFmpeg() {
        return true;
    }

    public boolean isFFprobe() {
        return false;
    }

    public boolean isMediaInformation() {
        return false;
    }

    public FFmpegSession(String[] strArr) {
        this(strArr, (FFmpegSessionCompleteCallback) null);
    }

    public FFmpegSession(String[] strArr, FFmpegSessionCompleteCallback fFmpegSessionCompleteCallback) {
        this(strArr, fFmpegSessionCompleteCallback, (LogCallback) null, (StatisticsCallback) null);
    }

    public FFmpegSession(String[] strArr, FFmpegSessionCompleteCallback fFmpegSessionCompleteCallback, LogCallback logCallback, StatisticsCallback statisticsCallback2) {
        this(strArr, fFmpegSessionCompleteCallback, logCallback, statisticsCallback2, FFmpegKitConfig.getLogRedirectionStrategy());
    }

    public FFmpegSession(String[] strArr, FFmpegSessionCompleteCallback fFmpegSessionCompleteCallback, LogCallback logCallback, StatisticsCallback statisticsCallback2, LogRedirectionStrategy logRedirectionStrategy) {
        super(strArr, logCallback, logRedirectionStrategy);
        this.completeCallback = fFmpegSessionCompleteCallback;
        this.statisticsCallback = statisticsCallback2;
        this.statistics = new LinkedList();
        this.statisticsLock = new Object();
    }

    public StatisticsCallback getStatisticsCallback() {
        return this.statisticsCallback;
    }

    public FFmpegSessionCompleteCallback getCompleteCallback() {
        return this.completeCallback;
    }

    public List<Statistics> getAllStatistics(int i) {
        waitForAsynchronousMessagesInTransmit(i);
        if (thereAreAsynchronousMessagesInTransmit()) {
            Log.i("ffmpeg-kit", String.format("getAllStatistics was called to return all statistics but there are still statistics being transmitted for session id %d.", new Object[]{Long.valueOf(this.sessionId)}));
        }
        return getStatistics();
    }

    public List<Statistics> getAllStatistics() {
        return getAllStatistics(AbstractSession.DEFAULT_TIMEOUT_FOR_ASYNCHRONOUS_MESSAGES_IN_TRANSMIT);
    }

    public List<Statistics> getStatistics() {
        List<Statistics> list;
        synchronized (this.statisticsLock) {
            list = this.statistics;
        }
        return list;
    }

    public Statistics getLastReceivedStatistics() {
        synchronized (this.statisticsLock) {
            if (this.statistics.size() <= 0) {
                return null;
            }
            List<Statistics> list = this.statistics;
            Statistics statistics2 = list.get(list.size() - 1);
            return statistics2;
        }
    }

    public void addStatistics(Statistics statistics2) {
        synchronized (this.statisticsLock) {
            this.statistics.add(statistics2);
        }
    }

    public String toString() {
        return "FFmpegSession{" + "sessionId=" + this.sessionId + ", createTime=" + this.createTime + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", arguments=" + FFmpegKitConfig.argumentsToString(this.arguments) + ", logs=" + getLogsAsString() + ", state=" + this.state + ", returnCode=" + this.returnCode + ", failStackTrace=" + '\'' + this.failStackTrace + '\'' + '}';
    }
}
