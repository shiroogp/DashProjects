var React = require('react'),
  ReactNative = require('react-native'),
  n = ReactNative.View,
  l = ReactNative.Text,
  u = ReactNative.TextInput;

module.exports = function (o) {
  if (o.hidden) return null;
  var c = o.stylesheet,
    s = c.formGroup.normal,
    b = c.controlLabel.normal,
    y = c.textbox.normal,
    x = c.textboxView.normal,
    p = c.helpBlock.normal,
    h = c.errorBlock;

  if (o.hasError) {
    s = c.formGroup.error;
    b = c.controlLabel.error;
    y = c.textbox.error;
    x = c.textboxView.error;
    p = c.helpBlock.error;
  }

  if (false === o.editable) {
    y = c.textbox.notEditable;
    x = c.textboxView.notEditable;
  }

  var C = o.label ? <l style={b}>{o.label}</l> : null,
    E = o.help ? <l style={p}>{o.help}</l> : null,
    T =
      o.hasError && o.error ? (
        <l accessibilityLiveRegion="polite" style={h}>
          {o.error}
        </l>
      ) : null;
  return (
    <n style={s}>
      {C}
      <n style={x}>
        <u
          accessibilityLabel={o.label}
          ref="input"
          allowFontScaling={o.allowFontScaling}
          autoCapitalize={o.autoCapitalize}
          autoCorrect={o.autoCorrect}
          autoFocus={o.autoFocus}
          blurOnSubmit={o.blurOnSubmit}
          editable={o.editable}
          keyboardType={o.keyboardType}
          maxLength={o.maxLength}
          multiline={o.multiline}
          onBlur={o.onBlur}
          onEndEditing={o.onEndEditing}
          onFocus={o.onFocus}
          onLayout={o.onLayout}
          onSelectionChange={o.onSelectionChange}
          onSubmitEditing={o.onSubmitEditing}
          onContentSizeChange={o.onContentSizeChange}
          placeholderTextColor={o.placeholderTextColor}
          secureTextEntry={o.secureTextEntry}
          selectTextOnFocus={o.selectTextOnFocus}
          selectionColor={o.selectionColor}
          numberOfLines={o.numberOfLines}
          clearButtonMode={o.clearButtonMode}
          clearTextOnFocus={o.clearTextOnFocus}
          enablesReturnKeyAutomatically={o.enablesReturnKeyAutomatically}
          keyboardAppearance={o.keyboardAppearance}
          onKeyPress={o.onKeyPress}
          returnKeyType={o.returnKeyType}
          selectionState={o.selectionState}
          onChangeText={function (t) {
            return o.onChange(t);
          }}
          onChange={o.onChangeNative}
          placeholder={o.placeholder}
          style={y}
          value={o.value}
          testID={o.testID}
          textContentType={o.textContentType}
        />
      </n>
      {E}
      {T}
    </n>
  );
};
