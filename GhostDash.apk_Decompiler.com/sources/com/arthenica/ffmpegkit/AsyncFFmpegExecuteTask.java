package com.arthenica.ffmpegkit;

import android.util.Log;
import com.arthenica.smartexception.java.Exceptions;

public class AsyncFFmpegExecuteTask implements Runnable {
    private final FFmpegSessionCompleteCallback completeCallback;
    private final FFmpegSession ffmpegSession;

    public AsyncFFmpegExecuteTask(FFmpegSession fFmpegSession) {
        this.ffmpegSession = fFmpegSession;
        this.completeCallback = fFmpegSession.getCompleteCallback();
    }

    public void run() {
        FFmpegKitConfig.ffmpegExecute(this.ffmpegSession);
        FFmpegSessionCompleteCallback fFmpegSessionCompleteCallback = this.completeCallback;
        if (fFmpegSessionCompleteCallback != null) {
            try {
                fFmpegSessionCompleteCallback.apply(this.ffmpegSession);
            } catch (Exception e) {
                Log.e("ffmpeg-kit", String.format("Exception thrown inside session complete callback.%s", new Object[]{Exceptions.getStackTraceString(e)}));
            }
        }
        FFmpegSessionCompleteCallback fFmpegSessionCompleteCallback2 = FFmpegKitConfig.getFFmpegSessionCompleteCallback();
        if (fFmpegSessionCompleteCallback2 != null) {
            try {
                fFmpegSessionCompleteCallback2.apply(this.ffmpegSession);
            } catch (Exception e2) {
                Log.e("ffmpeg-kit", String.format("Exception thrown inside global complete callback.%s", new Object[]{Exceptions.getStackTraceString(e2)}));
            }
        }
    }
}
