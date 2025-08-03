package com.arthenica.ffmpegkit.reactnative;

import com.arthenica.ffmpegkit.FFmpegKitConfig;
import com.arthenica.ffmpegkit.MediaInformationSession;
import com.facebook.react.bridge.Promise;

public class MediaInformationSessionExecuteTask implements Runnable {
    private final MediaInformationSession mediaInformationSession;
    private final Promise promise;
    private final int timeout;

    public MediaInformationSessionExecuteTask(MediaInformationSession mediaInformationSession2, int i, Promise promise2) {
        this.mediaInformationSession = mediaInformationSession2;
        this.timeout = i;
        this.promise = promise2;
    }

    public void run() {
        FFmpegKitConfig.getMediaInformationExecute(this.mediaInformationSession, this.timeout);
        this.promise.resolve((Object) null);
    }
}
