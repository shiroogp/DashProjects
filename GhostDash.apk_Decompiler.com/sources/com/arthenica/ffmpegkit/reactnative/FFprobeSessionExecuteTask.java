package com.arthenica.ffmpegkit.reactnative;

import com.arthenica.ffmpegkit.FFmpegKitConfig;
import com.arthenica.ffmpegkit.FFprobeSession;
import com.facebook.react.bridge.Promise;

public class FFprobeSessionExecuteTask implements Runnable {
    private final FFprobeSession ffprobeSession;
    private final Promise promise;

    public FFprobeSessionExecuteTask(FFprobeSession fFprobeSession, Promise promise2) {
        this.ffprobeSession = fFprobeSession;
        this.promise = promise2;
    }

    public void run() {
        FFmpegKitConfig.ffprobeExecute(this.ffprobeSession);
        this.promise.resolve((Object) null);
    }
}
