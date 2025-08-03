package com.drew.metadata;

import java.util.HashMap;

public final class ErrorDirectory extends Directory {
    public String getName() {
        return "Error";
    }

    public String getTagName(int i) {
        return "";
    }

    public boolean hasTagName(int i) {
        return false;
    }

    public ErrorDirectory() {
    }

    public ErrorDirectory(String str) {
        super.addError(str);
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return new HashMap<>();
    }

    public void setObject(int i, Object obj) {
        throw new UnsupportedOperationException(String.format("Cannot add value to %s.", new Object[]{ErrorDirectory.class.getName()}));
    }
}
