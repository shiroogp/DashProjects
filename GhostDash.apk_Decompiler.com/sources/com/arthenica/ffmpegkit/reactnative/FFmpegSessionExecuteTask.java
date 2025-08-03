package com.arthenica.ffmpegkit.reactnative;

import com.arthenica.ffmpegkit.FFmpegKitConfig;
import com.arthenica.ffmpegkit.FFmpegSession;
import com.facebook.react.bridge.Promise;

public class FFmpegSessionExecuteTask implements Runnable {
    private final FFmpegSession ffmpegSession;
    private final Promise promise;

    public FFmpegSessionExecuteTask(FFmpegSession fFmpegSession, Promise promise2) {
        this.ffmpegSession = fFmpegSession;
        this.promise = promise2;
    }

    public void run() {
        FFmpegKitConfig.ffmpegExecute(this.ffmpegSession);
        this.promise.resolve((Object) null);
    }
}
