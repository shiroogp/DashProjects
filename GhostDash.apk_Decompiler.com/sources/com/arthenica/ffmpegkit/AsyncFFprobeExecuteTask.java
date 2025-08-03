package com.arthenica.ffmpegkit;

import android.util.Log;
import com.arthenica.smartexception.java.Exceptions;

public class AsyncFFprobeExecuteTask implements Runnable {
    private final FFprobeSessionCompleteCallback completeCallback;
    private final FFprobeSession ffprobeSession;

    public AsyncFFprobeExecuteTask(FFprobeSession fFprobeSession) {
        this.ffprobeSession = fFprobeSession;
        this.completeCallback = fFprobeSession.getCompleteCallback();
    }

    public void run() {
        FFmpegKitConfig.ffprobeExecute(this.ffprobeSession);
        FFprobeSessionCompleteCallback fFprobeSessionCompleteCallback = this.completeCallback;
        if (fFprobeSessionCompleteCallback != null) {
            try {
                fFprobeSessionCompleteCallback.apply(this.ffprobeSession);
            } catch (Exception e) {
                Log.e("ffmpeg-kit", String.format("Exception thrown inside session complete callback.%s", new Object[]{Exceptions.getStackTraceString(e)}));
            }
        }
        FFprobeSessionCompleteCallback fFprobeSessionCompleteCallback2 = FFmpegKitConfig.getFFprobeSessionCompleteCallback();
        if (fFprobeSessionCompleteCallback2 != null) {
            try {
                fFprobeSessionCompleteCallback2.apply(this.ffprobeSession);
            } catch (Exception e2) {
                Log.e("ffmpeg-kit", String.format("Exception thrown inside global complete callback.%s", new Object[]{Exceptions.getStackTraceString(e2)}));
            }
        }
    }
}
