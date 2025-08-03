package com.lwansbrough.RCTCamera;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.util.List;

public class RCTCameraView extends ViewGroup {
    private int _actualDeviceOrientation = -1;
    private int _aspect = 1;
    private int _captureMode = 0;
    private String _captureQuality = RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_HIGH;
    private boolean _clearWindowBackground = false;
    /* access modifiers changed from: private */
    public final Context _context;
    private int _flashMode = -1;
    private final OrientationEventListener _orientationListener;
    private int _torchMode = -1;
    private RCTCameraViewFinder _viewFinder = null;
    private int _zoom = 0;

    public RCTCameraView(Context context) {
        super(context);
        this._context = context;
        RCTCamera.createInstance(getDeviceOrientation(context));
        AnonymousClass1 r0 = new OrientationEventListener(context, 3) {
            public void onOrientationChanged(int i) {
                RCTCameraView rCTCameraView = RCTCameraView.this;
                if (rCTCameraView.setActualDeviceOrientation(rCTCameraView._context)) {
                    RCTCameraView.this.layoutViewFinder();
                }
            }
        };
        this._orientationListener = r0;
        if (r0.canDetectOrientation()) {
            r0.enable();
        } else {
            r0.disable();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        layoutViewFinder(i, i2, i3, i4);
    }

    public void onViewAdded(View view) {
        RCTCameraViewFinder rCTCameraViewFinder = this._viewFinder;
        if (rCTCameraViewFinder != view) {
            removeView(rCTCameraViewFinder);
            addView(this._viewFinder, 0);
        }
    }

    public void setAspect(int i) {
        this._aspect = i;
        layoutViewFinder();
    }

    public void setCameraType(int i) {
        RCTCameraViewFinder rCTCameraViewFinder = this._viewFinder;
        if (rCTCameraViewFinder != null) {
            rCTCameraViewFinder.setCameraType(i);
            RCTCamera.getInstance().adjustPreviewLayout(i);
            return;
        }
        RCTCameraViewFinder rCTCameraViewFinder2 = new RCTCameraViewFinder(this._context, i);
        this._viewFinder = rCTCameraViewFinder2;
        int i2 = this._flashMode;
        if (-1 != i2) {
            rCTCameraViewFinder2.setFlashMode(i2);
        }
        int i3 = this._torchMode;
        if (-1 != i3) {
            this._viewFinder.setTorchMode(i3);
        }
        int i4 = this._zoom;
        if (i4 != 0) {
            this._viewFinder.setZoom(i4);
        }
        this._viewFinder.setClearWindowBackground(this._clearWindowBackground);
        addView(this._viewFinder);
    }

    public void setCaptureMode(int i) {
        this._captureMode = i;
        RCTCameraViewFinder rCTCameraViewFinder = this._viewFinder;
        if (rCTCameraViewFinder != null) {
            rCTCameraViewFinder.setCaptureMode(i);
        }
    }

    public void setCaptureQuality(String str) {
        this._captureQuality = str;
        RCTCameraViewFinder rCTCameraViewFinder = this._viewFinder;
        if (rCTCameraViewFinder != null) {
            rCTCameraViewFinder.setCaptureQuality(str);
        }
    }

    public void setTorchMode(int i) {
        this._torchMode = i;
        RCTCameraViewFinder rCTCameraViewFinder = this._viewFinder;
        if (rCTCameraViewFinder != null) {
            rCTCameraViewFinder.setTorchMode(i);
        }
    }

    public void setFlashMode(int i) {
        this._flashMode = i;
        RCTCameraViewFinder rCTCameraViewFinder = this._viewFinder;
        if (rCTCameraViewFinder != null) {
            rCTCameraViewFinder.setFlashMode(i);
        }
    }

    public void setZoom(int i) {
        this._zoom = i;
        RCTCameraViewFinder rCTCameraViewFinder = this._viewFinder;
        if (rCTCameraViewFinder != null) {
            rCTCameraViewFinder.setZoom(i);
        }
    }

    public void setOrientation(int i) {
        RCTCamera.getInstance().setOrientation(i);
        if (this._viewFinder != null) {
            layoutViewFinder();
        }
    }

    public void setBarcodeScannerEnabled(boolean z) {
        RCTCamera.getInstance().setBarcodeScannerEnabled(z);
    }

    public void setBarCodeTypes(List<String> list) {
        RCTCamera.getInstance().setBarCodeTypes(list);
    }

    public void setClearWindowBackground(boolean z) {
        this._clearWindowBackground = z;
        RCTCameraViewFinder rCTCameraViewFinder = this._viewFinder;
        if (rCTCameraViewFinder != null) {
            rCTCameraViewFinder.setClearWindowBackground(z);
        }
    }

    public void stopPreview() {
        RCTCameraViewFinder rCTCameraViewFinder = this._viewFinder;
        if (rCTCameraViewFinder != null) {
            rCTCameraViewFinder.stopPreview();
        }
    }

    public void startPreview() {
        RCTCameraViewFinder rCTCameraViewFinder = this._viewFinder;
        if (rCTCameraViewFinder != null) {
            rCTCameraViewFinder.startPreview();
        }
    }

    /* access modifiers changed from: private */
    public boolean setActualDeviceOrientation(Context context) {
        int deviceOrientation = getDeviceOrientation(context);
        if (this._actualDeviceOrientation == deviceOrientation) {
            return false;
        }
        this._actualDeviceOrientation = deviceOrientation;
        RCTCamera.getInstance().setActualDeviceOrientation(this._actualDeviceOrientation);
        return true;
    }

    private int getDeviceOrientation(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getOrientation();
    }

    /* access modifiers changed from: private */
    public void layoutViewFinder() {
        layoutViewFinder(getLeft(), getTop(), getRight(), getBottom());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (r0 > r2) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        if (r0 < r2) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        r9 = (int) (r2 / r8);
        r8 = (int) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        r8 = (int) r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void layoutViewFinder(int r6, int r7, int r8, int r9) {
        /*
            r5 = this;
            com.lwansbrough.RCTCamera.RCTCameraViewFinder r0 = r5._viewFinder
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            int r8 = r8 - r6
            float r6 = (float) r8
            int r9 = r9 - r7
            float r7 = (float) r9
            int r8 = r5._aspect
            if (r8 == 0) goto L_0x001f
            r9 = 1
            if (r8 == r9) goto L_0x0013
            int r8 = (int) r6
        L_0x0011:
            int r9 = (int) r7
            goto L_0x0030
        L_0x0013:
            double r8 = r0.getRatio()
            double r0 = (double) r7
            double r0 = r0 * r8
            double r2 = (double) r6
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x002e
            goto L_0x002a
        L_0x001f:
            double r8 = r0.getRatio()
            double r0 = (double) r7
            double r0 = r0 * r8
            double r2 = (double) r6
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x002e
        L_0x002a:
            double r2 = r2 / r8
            int r9 = (int) r2
            int r8 = (int) r6
            goto L_0x0030
        L_0x002e:
            int r8 = (int) r0
            goto L_0x0011
        L_0x0030:
            float r0 = (float) r8
            float r0 = r6 - r0
            r1 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r1
            int r0 = (int) r0
            float r2 = (float) r9
            float r2 = r7 - r2
            float r2 = r2 / r1
            int r1 = (int) r2
            com.lwansbrough.RCTCamera.RCTCamera r2 = com.lwansbrough.RCTCamera.RCTCamera.getInstance()
            com.lwansbrough.RCTCamera.RCTCameraViewFinder r3 = r5._viewFinder
            int r3 = r3.getCameraType()
            int r6 = (int) r6
            int r7 = (int) r7
            r2.setPreviewVisibleSize(r3, r6, r7)
            com.lwansbrough.RCTCamera.RCTCameraViewFinder r6 = r5._viewFinder
            int r8 = r8 + r0
            int r9 = r9 + r1
            r6.layout(r0, r1, r8, r9)
            int r6 = r5.getLeft()
            int r7 = r5.getTop()
            int r8 = r5.getRight()
            int r9 = r5.getBottom()
            r5.postInvalidate(r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lwansbrough.RCTCamera.RCTCameraView.layoutViewFinder(int, int, int, int):void");
    }
}
