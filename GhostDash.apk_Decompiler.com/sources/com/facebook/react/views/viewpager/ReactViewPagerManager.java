package com.facebook.react.views.viewpager;

import android.view.View;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.AndroidViewPagerManagerDelegate;
import com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface;
import java.util.Map;

@ReactModule(name = "AndroidViewPager")
public class ReactViewPagerManager extends ViewGroupManager<ReactViewPager> implements AndroidViewPagerManagerInterface<ReactViewPager> {
    public static final int COMMAND_SET_PAGE = 1;
    public static final int COMMAND_SET_PAGE_WITHOUT_ANIMATION = 2;
    public static final String REACT_CLASS = "AndroidViewPager";
    private final ViewManagerDelegate<ReactViewPager> mDelegate = new AndroidViewPagerManagerDelegate(this);

    public String getName() {
        return REACT_CLASS;
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    public void setInitialPage(ReactViewPager reactViewPager, int i) {
    }

    public void setKeyboardDismissMode(ReactViewPager reactViewPager, String str) {
    }

    public void setPage(ReactViewPager reactViewPager, int i) {
    }

    public void setPageWithoutAnimation(ReactViewPager reactViewPager, int i) {
    }

    /* access modifiers changed from: protected */
    public ReactViewPager createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactViewPager(themedReactContext);
    }

    @ReactProp(defaultBoolean = true, name = "scrollEnabled")
    public void setScrollEnabled(ReactViewPager reactViewPager, boolean z) {
        reactViewPager.setScrollEnabled(z);
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of(PageScrollEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPageScroll"), PageScrollStateChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPageScrollStateChanged"), PageSelectedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPageSelected"));
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("setPage", 1, "setPageWithoutAnimation", 2);
    }

    public void receiveCommand(ReactViewPager reactViewPager, int i, ReadableArray readableArray) {
        Assertions.assertNotNull(reactViewPager);
        Assertions.assertNotNull(readableArray);
        if (i == 1) {
            reactViewPager.setCurrentItemFromJs(readableArray.getInt(0), true);
        } else if (i == 2) {
            reactViewPager.setCurrentItemFromJs(readableArray.getInt(0), false);
        } else {
            throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", new Object[]{Integer.valueOf(i), getClass().getSimpleName()}));
        }
    }

    public void receiveCommand(ReactViewPager reactViewPager, String str, ReadableArray readableArray) {
        Assertions.assertNotNull(reactViewPager);
        Assertions.assertNotNull(readableArray);
        str.hashCode();
        if (str.equals("setPageWithoutAnimation")) {
            reactViewPager.setCurrentItemFromJs(readableArray.getInt(0), false);
        } else if (!str.equals("setPage")) {
            throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", new Object[]{str, getClass().getSimpleName()}));
        } else {
            reactViewPager.setCurrentItemFromJs(readableArray.getInt(0), true);
        }
    }

    public void addView(ReactViewPager reactViewPager, View view, int i) {
        reactViewPager.addViewToAdapter(view, i);
    }

    public int getChildCount(ReactViewPager reactViewPager) {
        return reactViewPager.getViewCountInAdapter();
    }

    public View getChildAt(ReactViewPager reactViewPager, int i) {
        return reactViewPager.getViewFromAdapter(i);
    }

    public void removeViewAt(ReactViewPager reactViewPager, int i) {
        reactViewPager.removeViewFromAdapter(i);
    }

    @ReactProp(defaultInt = 0, name = "pageMargin")
    public void setPageMargin(ReactViewPager reactViewPager, int i) {
        reactViewPager.setPageMargin((int) PixelUtil.toPixelFromDIP((float) i));
    }

    @ReactProp(defaultBoolean = false, name = "peekEnabled")
    public void setPeekEnabled(ReactViewPager reactViewPager, boolean z) {
        reactViewPager.setClipToPadding(!z);
    }

    public ViewManagerDelegate<ReactViewPager> getDelegate() {
        return this.mDelegate;
    }
}
