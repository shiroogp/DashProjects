package com.arthenica.ffmpegkit;

@FunctionalInterface
public interface StatisticsCallback {
    void apply(Statistics statistics);
}
