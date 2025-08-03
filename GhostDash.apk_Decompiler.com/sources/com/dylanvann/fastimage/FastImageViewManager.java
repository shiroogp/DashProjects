package com.dylanvann.fastimage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.request.BaseRequestOptions;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.Nullable;

class FastImageViewManager extends SimpleViewManager<FastImageViewWithUrl> implements FastImageProgressListener {
    private static final String REACT_CLASS = "FastImageView";
    private static final String REACT_ON_LOAD_START_EVENT = "onFastImageLoadStart";
    private static final String REACT_ON_PROGRESS_EVENT = "onFastImageProgress";
    private static final Map<String, List<FastImageViewWithUrl>> VIEWS_FOR_URLS = new WeakHashMap();
    @Nullable
    private RequestManager requestManager = null;

    public float getGranularityPercentage() {
        return 0.5f;
    }

    public String getName() {
        return REACT_CLASS;
    }

    FastImageViewManager() {
    }

    /* access modifiers changed from: protected */
    public FastImageViewWithUrl createViewInstance(ThemedReactContext themedReactContext) {
        if (isValidContextForGlide(themedReactContext)) {
            this.requestManager = Glide.with((Context) themedReactContext);
        }
        return new FastImageViewWithUrl(themedReactContext);
    }

    @ReactProp(name = "source")
    public void setSrc(FastImageViewWithUrl fastImageViewWithUrl, @Nullable ReadableMap readableMap) {
        if (readableMap == null || !readableMap.hasKey("uri") || isNullOrEmpty(readableMap.getString("uri"))) {
            RequestManager requestManager2 = this.requestManager;
            if (requestManager2 != null) {
                requestManager2.clear((View) fastImageViewWithUrl);
            }
            if (fastImageViewWithUrl.glideUrl != null) {
                FastImageOkHttpProgressGlideModule.forget(fastImageViewWithUrl.glideUrl.toStringUrl());
            }
            fastImageViewWithUrl.setImageDrawable((Drawable) null);
            return;
        }
        FastImageSource imageSource = FastImageViewConverter.getImageSource(fastImageViewWithUrl.getContext(), readableMap);
        GlideUrl glideUrl = imageSource.getGlideUrl();
        fastImageViewWithUrl.glideUrl = glideUrl;
        RequestManager requestManager3 = this.requestManager;
        if (requestManager3 != null) {
            requestManager3.clear((View) fastImageViewWithUrl);
        }
        String stringUrl = glideUrl.toStringUrl();
        FastImageOkHttpProgressGlideModule.expect(stringUrl, this);
        Map<String, List<FastImageViewWithUrl>> map = VIEWS_FOR_URLS;
        List list = map.get(stringUrl);
        if (list != null && !list.contains(fastImageViewWithUrl)) {
            list.add(fastImageViewWithUrl);
        } else if (list == null) {
            map.put(stringUrl, new ArrayList(Collections.singletonList(fastImageViewWithUrl)));
        }
        ThemedReactContext themedReactContext = (ThemedReactContext) fastImageViewWithUrl.getContext();
        ((RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(fastImageViewWithUrl.getId(), REACT_ON_LOAD_START_EVENT, new WritableNativeMap());
        RequestManager requestManager4 = this.requestManager;
        if (requestManager4 != null) {
            requestManager4.load(imageSource.getSourceForLoad()).apply((BaseRequestOptions<?>) FastImageViewConverter.getOptions(themedReactContext, imageSource, readableMap)).listener(new FastImageRequestListener(stringUrl)).into((ImageView) fastImageViewWithUrl);
        }
    }

    @ReactProp(customType = "Color", name = "tintColor")
    public void setTintColor(FastImageViewWithUrl fastImageViewWithUrl, @Nullable Integer num) {
        if (num == null) {
            fastImageViewWithUrl.clearColorFilter();
        } else {
            fastImageViewWithUrl.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    @ReactProp(name = "resizeMode")
    public void setResizeMode(FastImageViewWithUrl fastImageViewWithUrl, String str) {
        fastImageViewWithUrl.setScaleType(FastImageViewConverter.getScaleType(str));
    }

    public void onDropViewInstance(FastImageViewWithUrl fastImageViewWithUrl) {
        RequestManager requestManager2 = this.requestManager;
        if (requestManager2 != null) {
            requestManager2.clear((View) fastImageViewWithUrl);
        }
        if (fastImageViewWithUrl.glideUrl != null) {
            String glideUrl = fastImageViewWithUrl.glideUrl.toString();
            FastImageOkHttpProgressGlideModule.forget(glideUrl);
            Map<String, List<FastImageViewWithUrl>> map = VIEWS_FOR_URLS;
            List list = map.get(glideUrl);
            if (list != null) {
                list.remove(fastImageViewWithUrl);
                if (list.size() == 0) {
                    map.remove(glideUrl);
                }
            }
        }
        super.onDropViewInstance(fastImageViewWithUrl);
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put(REACT_ON_LOAD_START_EVENT, MapBuilder.of("registrationName", REACT_ON_LOAD_START_EVENT)).put(REACT_ON_PROGRESS_EVENT, MapBuilder.of("registrationName", REACT_ON_PROGRESS_EVENT)).put("onFastImageLoad", MapBuilder.of("registrationName", "onFastImageLoad")).put("onFastImageError", MapBuilder.of("registrationName", "onFastImageError")).put("onFastImageLoadEnd", MapBuilder.of("registrationName", "onFastImageLoadEnd")).build();
    }

    public void onProgress(String str, long j, long j2) {
        List<FastImageViewWithUrl> list = VIEWS_FOR_URLS.get(str);
        if (list != null) {
            for (FastImageViewWithUrl fastImageViewWithUrl : list) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putInt("loaded", (int) j);
                writableNativeMap.putInt("total", (int) j2);
                ((RCTEventEmitter) ((ThemedReactContext) fastImageViewWithUrl.getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(fastImageViewWithUrl.getId(), REACT_ON_PROGRESS_EVENT, writableNativeMap);
            }
        }
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    private static boolean isValidContextForGlide(Context context) {
        Activity activityFromContext = getActivityFromContext(context);
        if (activityFromContext == null) {
            return false;
        }
        return !isActivityDestroyed(activityFromContext);
    }

    private static Activity getActivityFromContext(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ThemedReactContext)) {
            return null;
        }
        Context baseContext = ((ThemedReactContext) context).getBaseContext();
        if (baseContext instanceof Activity) {
            return (Activity) baseContext;
        }
        if (!(baseContext instanceof ContextWrapper)) {
            return null;
        }
        Context baseContext2 = ((ContextWrapper) baseContext).getBaseContext();
        if (baseContext2 instanceof Activity) {
            return (Activity) baseContext2;
        }
        return null;
    }

    private static boolean isActivityDestroyed(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17) {
            if (activity.isDestroyed() || activity.isFinishing()) {
                return true;
            }
            return false;
        } else if (activity.isDestroyed() || activity.isFinishing() || activity.isChangingConfigurations()) {
            return true;
        } else {
            return false;
        }
    }
}
