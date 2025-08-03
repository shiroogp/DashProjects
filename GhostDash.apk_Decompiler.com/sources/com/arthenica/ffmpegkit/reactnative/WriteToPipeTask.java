package com.arthenica.ffmpegkit.reactnative;

import android.util.Log;
import com.facebook.react.bridge.Promise;
import java.io.IOException;

public class WriteToPipeTask implements Runnable {
    private final String inputPath;
    private final String namedPipePath;
    private final Promise promise;

    public WriteToPipeTask(String str, String str2, Promise promise2) {
        this.inputPath = str;
        this.namedPipePath = str2;
        this.promise = promise2;
    }

    public void run() {
        try {
            Log.d(FFmpegKitReactNativeModule.LIBRARY_NAME, String.format("Starting copy %s to pipe %s operation.", new Object[]{this.inputPath, this.namedPipePath}));
            long currentTimeMillis = System.currentTimeMillis();
            int waitFor = Runtime.getRuntime().exec(new String[]{"sh", "-c", "cat " + this.inputPath + " > " + this.namedPipePath}).waitFor();
            Log.d(FFmpegKitReactNativeModule.LIBRARY_NAME, String.format("Copying %s to pipe %s operation completed with rc %d in %d seconds.", new Object[]{this.inputPath, this.namedPipePath, Integer.valueOf(waitFor), Long.valueOf((System.currentTimeMillis() - currentTimeMillis) / 1000)}));
            this.promise.resolve(Integer.valueOf(waitFor));
        } catch (IOException | InterruptedException e) {
            Log.e(FFmpegKitReactNativeModule.LIBRARY_NAME, String.format("Copy %s to pipe %s failed with error.", new Object[]{this.inputPath, this.namedPipePath}), e);
            this.promise.reject("Copy failed", String.format("Copy %s to pipe %s failed with error.", new Object[]{this.inputPath, this.namedPipePath}), e);
        }
    }
}
