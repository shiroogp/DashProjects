package com.arthenica.ffmpegkit;

@FunctionalInterface
public interface FFmpegSessionCompleteCallback {
    void apply(FFmpegSession fFmpegSession);
}
