package org.reactnative.camera.tasks;

import android.graphics.Rect;
import android.os.AsyncTask;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.TextRecognizerOptions;
import java.util.List;
import org.reactnative.camera.utils.ImageDimensions;
import org.reactnative.facedetector.FaceDetectorUtils;
import org.reactnative.frame.RNFrameFactory;

public class TextRecognizerAsyncTask extends AsyncTask<Void, Void, List<Text.TextBlock>> {
    private TextRecognizerAsyncTaskDelegate mDelegate;
    private int mHeight;
    private byte[] mImageData;
    private ImageDimensions mImageDimensions;
    private int mPaddingLeft;
    private int mPaddingTop;
    private int mRotation;
    private double mScaleX;
    private double mScaleY;
    private TextRecognizer mTextRecognizer;
    private ThemedReactContext mThemedReactContext;
    private int mWidth;

    public TextRecognizerAsyncTask(TextRecognizerAsyncTaskDelegate textRecognizerAsyncTaskDelegate, ThemedReactContext themedReactContext, byte[] bArr, int i, int i2, int i3, float f, int i4, int i5, int i6, int i7, int i8) {
        this.mDelegate = textRecognizerAsyncTaskDelegate;
        this.mThemedReactContext = themedReactContext;
        this.mImageData = bArr;
        this.mWidth = i;
        this.mHeight = i2;
        this.mRotation = i3;
        ImageDimensions imageDimensions = new ImageDimensions(i, i2, i3, i4);
        this.mImageDimensions = imageDimensions;
        this.mScaleX = ((double) i5) / ((double) (((float) imageDimensions.getWidth()) * f));
        this.mScaleY = ((double) i6) / ((double) (((float) this.mImageDimensions.getHeight()) * f));
        this.mPaddingLeft = i7;
        this.mPaddingTop = i8;
    }

    /* access modifiers changed from: protected */
    public List<Text.TextBlock> doInBackground(Void... voidArr) {
        if (isCancelled() || this.mDelegate == null) {
            return null;
        }
        this.mTextRecognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);
        return this.mTextRecognizer.process(RNFrameFactory.buildFrame(this.mImageData, this.mWidth, this.mHeight, this.mRotation).getFrame()).getResult().getTextBlocks();
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(List<Text.TextBlock> list) {
        super.onPostExecute(list);
        TextRecognizer textRecognizer = this.mTextRecognizer;
        if (textRecognizer != null) {
            textRecognizer.close();
        }
        if (list != null) {
            WritableArray createArray = Arguments.createArray();
            for (int i = 0; i < list.size(); i++) {
                WritableMap serializeText = serializeText(list.get(i));
                if (this.mImageDimensions.getFacing() == 1) {
                    serializeText = rotateTextX(serializeText);
                }
                createArray.pushMap(serializeText);
            }
            this.mDelegate.onTextRecognized(createArray);
        }
        this.mDelegate.onTextRecognizerTaskCompleted();
    }

    private WritableMap serializeText(Text.TextBlock textBlock) {
        WritableMap createMap = Arguments.createMap();
        WritableArray createArray = Arguments.createArray();
        for (Text.Line serializeText : textBlock.getLines()) {
            createArray.pushMap(serializeText(serializeText));
        }
        createMap.putArray("components", createArray);
        createMap.putString("value", textBlock.getText());
        createMap.putMap("bounds", serializeBounds(textBlock.getBoundingBox()));
        createMap.putString("type", "block");
        return createMap;
    }

    private WritableMap serializeText(Text.Line line) {
        WritableMap createMap = Arguments.createMap();
        WritableArray createArray = Arguments.createArray();
        for (Text.Element serializeText : line.getElements()) {
            createArray.pushMap(serializeText(serializeText));
        }
        createMap.putArray("components", createArray);
        createMap.putString("value", line.getText());
        createMap.putMap("bounds", serializeBounds(line.getBoundingBox()));
        createMap.putString("type", "line");
        return createMap;
    }

    private WritableMap serializeText(Text.Element element) {
        WritableMap createMap = Arguments.createMap();
        createMap.putArray("components", Arguments.createArray());
        createMap.putString("value", element.getText());
        createMap.putMap("bounds", serializeBounds(element.getBoundingBox()));
        createMap.putString("type", "element");
        return createMap;
    }

    private WritableMap serializeBounds(Rect rect) {
        int i = rect.left;
        int i2 = rect.top;
        int width = rect.width();
        int height = rect.height();
        int i3 = this.mWidth;
        if (i < i3 / 2) {
            i += this.mPaddingLeft / 2;
        } else if (i > i3 / 2) {
            i -= this.mPaddingLeft / 2;
        }
        int i4 = this.mHeight;
        if (height < i4 / 2) {
            i2 += this.mPaddingTop / 2;
        } else if (height > i4 / 2) {
            i2 -= this.mPaddingTop / 2;
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("x", ((double) i) * this.mScaleX);
        createMap.putDouble("y", ((double) i2) * this.mScaleY);
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putDouble("width", ((double) width) * this.mScaleX);
        createMap2.putDouble("height", ((double) height) * this.mScaleY);
        WritableMap createMap3 = Arguments.createMap();
        createMap3.putMap("origin", createMap);
        createMap3.putMap("size", createMap2);
        return createMap3;
    }

    private WritableMap rotateTextX(WritableMap writableMap) {
        ReadableMap map = writableMap.getMap("bounds");
        WritableMap positionTranslatedHorizontally = FaceDetectorUtils.positionTranslatedHorizontally(FaceDetectorUtils.positionMirroredHorizontally(map.getMap("origin"), this.mImageDimensions.getWidth(), this.mScaleX), -map.getMap("size").getDouble("width"));
        WritableMap createMap = Arguments.createMap();
        createMap.merge(map);
        createMap.putMap("origin", positionTranslatedHorizontally);
        writableMap.putMap("bounds", createMap);
        ReadableArray array = writableMap.getArray("components");
        WritableArray createArray = Arguments.createArray();
        for (int i = 0; i < array.size(); i++) {
            WritableMap createMap2 = Arguments.createMap();
            createMap2.merge(array.getMap(i));
            rotateTextX(createMap2);
            createArray.pushMap(createMap2);
        }
        writableMap.putArray("components", createArray);
        return writableMap;
    }
}
