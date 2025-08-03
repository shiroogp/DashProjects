package com.arthenica.ffmpegkit;

public class MediaInformationSession extends AbstractSession implements Session {
    private final MediaInformationSessionCompleteCallback completeCallback;
    private MediaInformation mediaInformation;

    public boolean isFFmpeg() {
        return false;
    }

    public boolean isFFprobe() {
        return false;
    }

    public boolean isMediaInformation() {
        return true;
    }

    public MediaInformationSession(String[] strArr) {
        this(strArr, (MediaInformationSessionCompleteCallback) null);
    }

    public MediaInformationSession(String[] strArr, MediaInformationSessionCompleteCallback mediaInformationSessionCompleteCallback) {
        this(strArr, mediaInformationSessionCompleteCallback, (LogCallback) null);
    }

    public MediaInformationSession(String[] strArr, MediaInformationSessionCompleteCallback mediaInformationSessionCompleteCallback, LogCallback logCallback) {
        super(strArr, logCallback, LogRedirectionStrategy.NEVER_PRINT_LOGS);
        this.completeCallback = mediaInformationSessionCompleteCallback;
    }

    public MediaInformation getMediaInformation() {
        return this.mediaInformation;
    }

    public void setMediaInformation(MediaInformation mediaInformation2) {
        this.mediaInformation = mediaInformation2;
    }

    public MediaInformationSessionCompleteCallback getCompleteCallback() {
        return this.completeCallback;
    }

    public String toString() {
        return "MediaInformationSession{" + "sessionId=" + this.sessionId + ", createTime=" + this.createTime + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", arguments=" + FFmpegKitConfig.argumentsToString(this.arguments) + ", logs=" + getLogsAsString() + ", state=" + this.state + ", returnCode=" + this.returnCode + ", failStackTrace=" + '\'' + this.failStackTrace + '\'' + '}';
    }
}
