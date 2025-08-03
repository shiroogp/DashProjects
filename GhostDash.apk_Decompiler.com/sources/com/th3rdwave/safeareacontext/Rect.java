package com.th3rdwave.safeareacontext;

class Rect {
    float height;
    float width;
    float x;
    float y;

    Rect(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
    }

    /* access modifiers changed from: package-private */
    public boolean equalsToRect(Rect rect) {
        if (this == rect) {
            return true;
        }
        return this.x == rect.x && this.y == rect.y && this.width == rect.width && this.height == rect.height;
    }
}
