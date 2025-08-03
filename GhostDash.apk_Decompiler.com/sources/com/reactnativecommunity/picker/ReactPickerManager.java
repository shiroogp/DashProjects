package com.reactnativecommunity.picker;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.reactnativecommunity.picker.ReactPicker;
import java.util.Map;
import javax.annotation.Nullable;

public abstract class ReactPickerManager extends BaseViewManager<ReactPicker, ReactPickerShadowNode> {
    private static final int BLUR_PICKER = 2;
    private static final ReadableArray EMPTY_ARRAY = Arguments.createArray();
    private static final int FOCUS_PICKER = 1;

    public void updateExtraData(ReactPicker reactPicker, Object obj) {
    }

    @Nullable
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder().put("topSelect", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onSelect", "captured", "onSelectCapture"))).put(PickerFocusEvent.EVENT_NAME, MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onFocus", "captured", "onFocusCapture"))).put(PickerBlurEvent.EVENT_NAME, MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onBlur", "captured", "onBlurCapture"))).build();
    }

    @Nullable
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("focus", 1, "blur", 2);
    }

    @ReactProp(name = "items")
    public void setItems(ReactPicker reactPicker, @Nullable ReadableArray readableArray) {
        ReactPickerAdapter reactPickerAdapter = (ReactPickerAdapter) reactPicker.getAdapter();
        if (reactPickerAdapter == null) {
            ReactPickerAdapter reactPickerAdapter2 = new ReactPickerAdapter(reactPicker.getContext(), readableArray);
            reactPickerAdapter2.setPrimaryTextColor(reactPicker.getPrimaryColor());
            reactPicker.setAdapter((SpinnerAdapter) reactPickerAdapter2);
            return;
        }
        reactPickerAdapter.setItems(readableArray);
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(ReactPicker reactPicker, @Nullable Integer num) {
        reactPicker.setPrimaryColor(num);
        ReactPickerAdapter reactPickerAdapter = (ReactPickerAdapter) reactPicker.getAdapter();
        if (reactPickerAdapter != null) {
            reactPickerAdapter.setPrimaryTextColor(num);
        }
    }

    @ReactProp(name = "prompt")
    public void setPrompt(ReactPicker reactPicker, @Nullable String str) {
        reactPicker.setPrompt(str);
    }

    @ReactProp(defaultBoolean = true, name = "enabled")
    public void setEnabled(ReactPicker reactPicker, boolean z) {
        reactPicker.setEnabled(z);
    }

    @ReactProp(name = "selected")
    public void setSelected(ReactPicker reactPicker, int i) {
        reactPicker.setStagedSelection(i);
    }

    @ReactProp(name = "backgroundColor")
    public void setBackgroundColor(ReactPicker reactPicker, @Nullable int i) {
        reactPicker.setBackgroundColor(i);
    }

    @ReactProp(name = "dropdownIconColor")
    public void setDropdownIconColor(ReactPicker reactPicker, @Nullable int i) {
        reactPicker.setDropdownIconColor(i);
    }

    @ReactProp(name = "dropdownIconRippleColor")
    public void setDropdownIconRippleColor(ReactPicker reactPicker, @Nullable int i) {
        reactPicker.setDropdownIconRippleColor(i);
    }

    @ReactProp(defaultInt = 1, name = "numberOfLines")
    public void setNumberOfLines(ReactPicker reactPicker, int i) {
        ReactPickerAdapter reactPickerAdapter = (ReactPickerAdapter) reactPicker.getAdapter();
        if (reactPickerAdapter == null) {
            ReactPickerAdapter reactPickerAdapter2 = new ReactPickerAdapter(reactPicker.getContext(), EMPTY_ARRAY);
            reactPickerAdapter2.setPrimaryTextColor(reactPicker.getPrimaryColor());
            reactPickerAdapter2.setNumberOfLines(i);
            reactPicker.setAdapter((SpinnerAdapter) reactPickerAdapter2);
            return;
        }
        reactPickerAdapter.setNumberOfLines(i);
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(ReactPicker reactPicker) {
        super.onAfterUpdateTransaction(reactPicker);
        reactPicker.updateStagedSelection();
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(ThemedReactContext themedReactContext, ReactPicker reactPicker) {
        PickerEventEmitter pickerEventEmitter = new PickerEventEmitter(reactPicker, ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher());
        reactPicker.setOnSelectListener(pickerEventEmitter);
        reactPicker.setOnFocusListener(pickerEventEmitter);
    }

    public void receiveCommand(ReactPicker reactPicker, int i, ReadableArray readableArray) {
        if (i == 1) {
            reactPicker.performClick();
        } else if (i == 2) {
            reactPicker.clearFocus();
        }
    }

    public void receiveCommand(ReactPicker reactPicker, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("blur")) {
            reactPicker.clearFocus();
        } else if (str.equals("focus")) {
            reactPicker.performClick();
        }
    }

    public ReactPickerShadowNode createShadowNodeInstance() {
        return new ReactPickerShadowNode();
    }

    public Class<? extends ReactPickerShadowNode> getShadowNodeClass() {
        return ReactPickerShadowNode.class;
    }

    private static class ReactPickerAdapter extends BaseAdapter {
        private final LayoutInflater mInflater;
        @Nullable
        private ReadableArray mItems;
        private int mNumberOfLines = 1;
        @Nullable
        private Integer mPrimaryTextColor;

        public long getItemId(int i) {
            return (long) i;
        }

        public ReactPickerAdapter(Context context, @Nullable ReadableArray readableArray) {
            this.mItems = readableArray;
            this.mInflater = (LayoutInflater) Assertions.assertNotNull(context.getSystemService("layout_inflater"));
        }

        public void setItems(@Nullable ReadableArray readableArray) {
            this.mItems = readableArray;
            notifyDataSetChanged();
        }

        public int getCount() {
            ReadableArray readableArray = this.mItems;
            if (readableArray == null) {
                return 0;
            }
            return readableArray.size();
        }

        public ReadableMap getItem(int i) {
            ReadableArray readableArray = this.mItems;
            if (readableArray == null) {
                return null;
            }
            return readableArray.getMap(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getView(i, view, viewGroup, false);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return getView(i, view, viewGroup, true);
        }

        private View getView(int i, View view, ViewGroup viewGroup, boolean z) {
            Integer num;
            int i2;
            ReadableMap item = getItem(i);
            ReadableMap map = item.hasKey("style") ? item.getMap("style") : null;
            if (view == null) {
                if (z) {
                    i2 = R.layout.simple_spinner_dropdown_item;
                } else {
                    i2 = R.layout.simple_spinner_item;
                }
                view = this.mInflater.inflate(i2, viewGroup, false);
            }
            boolean z2 = item.hasKey(ViewProps.ENABLED) ? item.getBoolean(ViewProps.ENABLED) : true;
            view.setEnabled(z2);
            view.setClickable(!z2);
            TextView textView = (TextView) view;
            textView.setText(item.getString("label"));
            textView.setMaxLines(this.mNumberOfLines);
            if (map != null) {
                if (!map.hasKey(ViewProps.BACKGROUND_COLOR) || map.isNull(ViewProps.BACKGROUND_COLOR)) {
                    view.setBackgroundColor(0);
                } else {
                    view.setBackgroundColor(map.getInt(ViewProps.BACKGROUND_COLOR));
                }
                if (map.hasKey(ViewProps.COLOR) && !map.isNull(ViewProps.COLOR)) {
                    textView.setTextColor(map.getInt(ViewProps.COLOR));
                }
                if (map.hasKey(ViewProps.FONT_SIZE) && !map.isNull(ViewProps.FONT_SIZE)) {
                    textView.setTextSize((float) map.getDouble(ViewProps.FONT_SIZE));
                }
                if (map.hasKey(ViewProps.FONT_FAMILY) && !map.isNull(ViewProps.FONT_FAMILY)) {
                    textView.setTypeface(Typeface.create(map.getString(ViewProps.FONT_FAMILY), 0));
                }
            }
            if (!z && (num = this.mPrimaryTextColor) != null) {
                textView.setTextColor(num.intValue());
            } else if (item.hasKey(ViewProps.COLOR) && !item.isNull(ViewProps.COLOR)) {
                textView.setTextColor(item.getInt(ViewProps.COLOR));
            }
            if (item.hasKey("contentDescription") && !item.isNull("contentDescription")) {
                textView.setContentDescription(item.getString("contentDescription"));
            }
            if (item.hasKey(ViewProps.FONT_FAMILY) && !item.isNull(ViewProps.FONT_FAMILY)) {
                textView.setTypeface(Typeface.create(item.getString(ViewProps.FONT_FAMILY), 0));
            }
            if (I18nUtil.getInstance().isRTL(view.getContext())) {
                view.setLayoutDirection(1);
                view.setTextDirection(4);
            } else {
                view.setLayoutDirection(0);
                view.setTextDirection(3);
            }
            return view;
        }

        public void setPrimaryTextColor(@Nullable Integer num) {
            this.mPrimaryTextColor = num;
            notifyDataSetChanged();
        }

        public void setNumberOfLines(int i) {
            this.mNumberOfLines = i;
            notifyDataSetChanged();
        }
    }

    private static class PickerEventEmitter implements ReactPicker.OnSelectListener, ReactPicker.OnFocusListener {
        private final EventDispatcher mEventDispatcher;
        private final ReactPicker mReactPicker;

        public PickerEventEmitter(ReactPicker reactPicker, EventDispatcher eventDispatcher) {
            this.mReactPicker = reactPicker;
            this.mEventDispatcher = eventDispatcher;
        }

        public void onItemSelected(int i) {
            this.mEventDispatcher.dispatchEvent(new PickerItemSelectEvent(this.mReactPicker.getId(), i));
        }

        public void onPickerBlur() {
            this.mEventDispatcher.dispatchEvent(new PickerBlurEvent(this.mReactPicker.getId()));
        }

        public void onPickerFocus() {
            this.mEventDispatcher.dispatchEvent(new PickerFocusEvent(this.mReactPicker.getId()));
        }
    }
}
