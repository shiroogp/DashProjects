package com.swmansion.reanimated;

public class ReanimatedMessageQueueThread extends ReanimatedMessageQueueThreadBase {
    public void runOnQueue(Runnable runnable) {
        this.messageQueueThread.runOnQueue(runnable);
    }
}
