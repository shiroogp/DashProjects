package com.google.firebase.crashlytics.ndk;

import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import java.io.File;

class SessionFilesProvider implements NativeSessionFileProvider {
    private final SessionFiles sessionFiles;

    SessionFilesProvider(SessionFiles sessionFiles2) {
        this.sessionFiles = sessionFiles2;
    }

    public File getMinidumpFile() {
        return this.sessionFiles.minidump;
    }

    public File getBinaryImagesFile() {
        return this.sessionFiles.binaryImages;
    }

    public File getMetadataFile() {
        return this.sessionFiles.metadata;
    }

    public File getSessionFile() {
        return this.sessionFiles.session;
    }

    public File getAppFile() {
        return this.sessionFiles.app;
    }

    public File getDeviceFile() {
        return this.sessionFiles.device;
    }

    public File getOsFile() {
        return this.sessionFiles.os;
    }
}
