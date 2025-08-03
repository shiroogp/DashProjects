package org.reactnative.barcodedetector;

import android.content.Context;
import com.google.mlkit.vision.barcode.Barcode;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import java.util.List;
import org.reactnative.camera.utils.ImageDimensions;
import org.reactnative.frame.RNFrame;

public class RNBarcodeDetector {
    public static int ALL_FORMATS = 0;
    public static int ALTERNATE_MODE = 1;
    public static int INVERTED_MODE = 2;
    public static int NORMAL_MODE;
    private BarcodeScanner mBarcodeDetector = null;
    private int mBarcodeType = 0;
    private BarcodeScannerOptions.Builder mBuilder = new BarcodeScannerOptions.Builder().setBarcodeFormats(this.mBarcodeType, new int[0]);
    private ImageDimensions mPreviousDimensions;

    public RNBarcodeDetector(Context context) {
    }

    public boolean isOperational() {
        if (this.mBarcodeDetector != null) {
            return true;
        }
        createBarcodeDetector();
        return true;
    }

    public List<Barcode> detect(RNFrame rNFrame) {
        if (!rNFrame.getDimensions().equals(this.mPreviousDimensions)) {
            releaseBarcodeDetector();
        }
        if (this.mBarcodeDetector == null) {
            createBarcodeDetector();
            this.mPreviousDimensions = rNFrame.getDimensions();
        }
        return this.mBarcodeDetector.process(rNFrame.getFrame()).getResult();
    }

    public void setBarcodeType(int i) {
        if (i != this.mBarcodeType) {
            release();
            this.mBuilder.setBarcodeFormats(i, new int[0]);
            this.mBarcodeType = i;
        }
    }

    public void release() {
        releaseBarcodeDetector();
        this.mPreviousDimensions = null;
    }

    private void releaseBarcodeDetector() {
        BarcodeScanner barcodeScanner = this.mBarcodeDetector;
        if (barcodeScanner != null) {
            barcodeScanner.close();
            this.mBarcodeDetector = null;
        }
    }

    private void createBarcodeDetector() {
        this.mBarcodeDetector = BarcodeScanning.getClient(this.mBuilder.build());
    }
}
