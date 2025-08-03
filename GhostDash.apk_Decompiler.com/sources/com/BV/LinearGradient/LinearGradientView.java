package com.BV.LinearGradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.PixelUtil;

public class LinearGradientView extends View {
    private float mAngle = 45.0f;
    private float[] mAngleCenter = {0.5f, 0.5f};
    private float[] mBorderRadii = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    private int[] mColors;
    private float[] mEndPos = {0.0f, 1.0f};
    private float[] mLocations;
    private final Paint mPaint = new Paint(1);
    private Path mPathForBorderRadius;
    private LinearGradient mShader;
    private int[] mSize = {0, 0};
    private float[] mStartPos = {0.0f, 0.0f};
    private RectF mTempRectForBorderRadius;
    private boolean mUseAngle = false;

    public LinearGradientView(Context context) {
        super(context);
    }

    public void setStartPosition(ReadableArray readableArray) {
        this.mStartPos = new float[]{(float) readableArray.getDouble(0), (float) readableArray.getDouble(1)};
        drawGradient();
    }

    public void setEndPosition(ReadableArray readableArray) {
        this.mEndPos = new float[]{(float) readableArray.getDouble(0), (float) readableArray.getDouble(1)};
        drawGradient();
    }

    public void setColors(ReadableArray readableArray) {
        int size = readableArray.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = readableArray.getInt(i);
        }
        this.mColors = iArr;
        drawGradient();
    }

    public void setLocations(ReadableArray readableArray) {
        int size = readableArray.size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = (float) readableArray.getDouble(i);
        }
        this.mLocations = fArr;
        drawGradient();
    }

    public void setUseAngle(boolean z) {
        this.mUseAngle = z;
        drawGradient();
    }

    public void setAngleCenter(ReadableArray readableArray) {
        this.mAngleCenter = new float[]{(float) readableArray.getDouble(0), (float) readableArray.getDouble(1)};
        drawGradient();
    }

    public void setAngle(float f) {
        this.mAngle = f;
        drawGradient();
    }

    public void setBorderRadii(ReadableArray readableArray) {
        int size = readableArray.size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = PixelUtil.toPixelFromDIP((float) readableArray.getDouble(i));
        }
        this.mBorderRadii = fArr;
        updatePath();
        drawGradient();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mSize = new int[]{i, i2};
        updatePath();
        drawGradient();
    }

    private float[] calculateGradientLocationWithAngle(float f) {
        float sqrt = (float) Math.sqrt(2.0d);
        double d = (double) ((f - 90.0f) * 0.017453292f);
        return new float[]{((float) Math.cos(d)) * sqrt, ((float) Math.sin(d)) * sqrt};
    }

    private void drawGradient() {
        int[] iArr = this.mColors;
        if (iArr != null) {
            float[] fArr = this.mLocations;
            if (fArr == null || iArr.length == fArr.length) {
                float[] fArr2 = this.mStartPos;
                float[] fArr3 = this.mEndPos;
                if (this.mUseAngle && this.mAngleCenter != null) {
                    float[] calculateGradientLocationWithAngle = calculateGradientLocationWithAngle(this.mAngle);
                    float[] fArr4 = this.mAngleCenter;
                    float[] fArr5 = {fArr4[0] - (calculateGradientLocationWithAngle[0] / 2.0f), fArr4[1] - (calculateGradientLocationWithAngle[1] / 2.0f)};
                    fArr3 = new float[]{fArr4[0] + (calculateGradientLocationWithAngle[0] / 2.0f), fArr4[1] + (calculateGradientLocationWithAngle[1] / 2.0f)};
                    fArr2 = fArr5;
                }
                float f = fArr2[0];
                int[] iArr2 = this.mSize;
                float f2 = ((float) iArr2[0]) * f;
                float f3 = fArr2[1] * ((float) iArr2[1]);
                LinearGradient linearGradient = new LinearGradient(f2, f3, fArr3[0] * ((float) iArr2[0]), fArr3[1] * ((float) iArr2[1]), this.mColors, this.mLocations, Shader.TileMode.CLAMP);
                this.mShader = linearGradient;
                this.mPaint.setShader(linearGradient);
                invalidate();
            }
        }
    }

    private void updatePath() {
        if (this.mPathForBorderRadius == null) {
            this.mPathForBorderRadius = new Path();
            this.mTempRectForBorderRadius = new RectF();
        }
        this.mPathForBorderRadius.reset();
        RectF rectF = this.mTempRectForBorderRadius;
        int[] iArr = this.mSize;
        rectF.set(0.0f, 0.0f, (float) iArr[0], (float) iArr[1]);
        this.mPathForBorderRadius.addRoundRect(this.mTempRectForBorderRadius, this.mBorderRadii, Path.Direction.CW);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = this.mPathForBorderRadius;
        if (path == null) {
            canvas.drawPaint(this.mPaint);
        } else {
            canvas.drawPath(path, this.mPaint);
        }
    }
}
