package com.arthenica.ffmpegkit;

@FunctionalInterface
public interface FFprobeSessionCompleteCallback {
    void apply(FFprobeSession fFprobeSession);
}
