package com.th3rdwave.safeareacontext;

import java.util.EnumSet;

public class SafeAreaViewLocalData {
    private EnumSet<SafeAreaViewEdges> mEdges;
    private EdgeInsets mInsets;
    private SafeAreaViewMode mMode;

    public SafeAreaViewLocalData(EdgeInsets edgeInsets, SafeAreaViewMode safeAreaViewMode, EnumSet<SafeAreaViewEdges> enumSet) {
        this.mInsets = edgeInsets;
        this.mMode = safeAreaViewMode;
        this.mEdges = enumSet;
    }

    public EdgeInsets getInsets() {
        return this.mInsets;
    }

    public SafeAreaViewMode getMode() {
        return this.mMode;
    }

    public EnumSet<SafeAreaViewEdges> getEdges() {
        return this.mEdges;
    }
}
