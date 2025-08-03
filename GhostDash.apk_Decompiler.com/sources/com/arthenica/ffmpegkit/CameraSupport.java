package com.arthenica.ffmpegkit;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

class CameraSupport {
    CameraSupport() {
    }

    static List<String> extractSupportedCameraIds(Context context) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
                if (cameraManager != null) {
                    for (String str : cameraManager.getCameraIdList()) {
                        Integer num = (Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
                        if (num != null && num.intValue() == 2) {
                            Log.d("ffmpeg-kit", "Detected camera with id " + str + " has LEGACY hardware level which is not supported by Android Camera2 NDK API.");
                        } else if (num != null) {
                            arrayList.add(str);
                        }
                    }
                }
            } catch (CameraAccessException e) {
                Log.w("ffmpeg-kit", "Detecting camera ids failed.", e);
            }
        }
        return arrayList;
    }
}
