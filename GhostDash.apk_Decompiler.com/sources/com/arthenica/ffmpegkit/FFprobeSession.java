package com.arthenica.ffmpegkit;

public class FFprobeSession extends AbstractSession implements Session {
    private final FFprobeSessionCompleteCallback completeCallback;

    public boolean isFFmpeg() {
        return false;
    }

    public boolean isFFprobe() {
        return true;
    }

    public boolean isMediaInformation() {
        return false;
    }

    public FFprobeSession(String[] strArr) {
        this(strArr, (FFprobeSessionCompleteCallback) null);
    }

    public FFprobeSession(String[] strArr, FFprobeSessionCompleteCallback fFprobeSessionCompleteCallback) {
        this(strArr, fFprobeSessionCompleteCallback, (LogCallback) null);
    }

    public FFprobeSession(String[] strArr, FFprobeSessionCompleteCallback fFprobeSessionCompleteCallback, LogCallback logCallback) {
        this(strArr, fFprobeSessionCompleteCallback, logCallback, FFmpegKitConfig.getLogRedirectionStrategy());
    }

    public FFprobeSession(String[] strArr, FFprobeSessionCompleteCallback fFprobeSessionCompleteCallback, LogCallback logCallback, LogRedirectionStrategy logRedirectionStrategy) {
        super(strArr, logCallback, logRedirectionStrategy);
        this.completeCallback = fFprobeSessionCompleteCallback;
    }

    public FFprobeSessionCompleteCallback getCompleteCallback() {
        return this.completeCallback;
    }

    public String toString() {
        return "FFprobeSession{" + "sessionId=" + this.sessionId + ", createTime=" + this.createTime + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", arguments=" + FFmpegKitConfig.argumentsToString(this.arguments) + ", logs=" + getLogsAsString() + ", state=" + this.state + ", returnCode=" + this.returnCode + ", failStackTrace=" + '\'' + this.failStackTrace + '\'' + '}';
    }
}
