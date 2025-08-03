package com.arthenica.ffmpegkit;

import android.util.Log;
import com.arthenica.smartexception.java.Exceptions;

public class AsyncGetMediaInformationTask implements Runnable {
    private final MediaInformationSessionCompleteCallback completeCallback;
    private final MediaInformationSession mediaInformationSession;
    private final Integer waitTimeout;

    public AsyncGetMediaInformationTask(MediaInformationSession mediaInformationSession2) {
        this(mediaInformationSession2, Integer.valueOf(AbstractSession.DEFAULT_TIMEOUT_FOR_ASYNCHRONOUS_MESSAGES_IN_TRANSMIT));
    }

    public AsyncGetMediaInformationTask(MediaInformationSession mediaInformationSession2, Integer num) {
        this.mediaInformationSession = mediaInformationSession2;
        this.completeCallback = mediaInformationSession2.getCompleteCallback();
        this.waitTimeout = num;
    }

    public void run() {
        FFmpegKitConfig.getMediaInformationExecute(this.mediaInformationSession, this.waitTimeout.intValue());
        MediaInformationSessionCompleteCallback mediaInformationSessionCompleteCallback = this.completeCallback;
        if (mediaInformationSessionCompleteCallback != null) {
            try {
                mediaInformationSessionCompleteCallback.apply(this.mediaInformationSession);
            } catch (Exception e) {
                Log.e("ffmpeg-kit", String.format("Exception thrown inside session complete callback.%s", new Object[]{Exceptions.getStackTraceString(e)}));
            }
        }
        MediaInformationSessionCompleteCallback mediaInformationSessionCompleteCallback2 = FFmpegKitConfig.getMediaInformationSessionCompleteCallback();
        if (mediaInformationSessionCompleteCallback2 != null) {
            try {
                mediaInformationSessionCompleteCallback2.apply(this.mediaInformationSession);
            } catch (Exception e2) {
                Log.e("ffmpeg-kit", String.format("Exception thrown inside global complete callback.%s", new Object[]{Exceptions.getStackTraceString(e2)}));
            }
        }
    }
}
