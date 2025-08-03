package com.google.firebase.crashlytics.ndk;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.google.firebase.crashlytics.ndk.-$$Lambda$JniNativeApi$ghN7sI30dtqhxuXhBjVGZNwcOUQ  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$JniNativeApi$ghN7sI30dtqhxuXhBjVGZNwcOUQ implements FilenameFilter {
    public static final /* synthetic */ $$Lambda$JniNativeApi$ghN7sI30dtqhxuXhBjVGZNwcOUQ INSTANCE = new $$Lambda$JniNativeApi$ghN7sI30dtqhxuXhBjVGZNwcOUQ();

    private /* synthetic */ $$Lambda$JniNativeApi$ghN7sI30dtqhxuXhBjVGZNwcOUQ() {
    }

    public final boolean accept(File file, String str) {
        return str.toLowerCase().endsWith(".apk");
    }
}
