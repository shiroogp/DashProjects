var React = require('react'),
  ReactNative = require('react-native'),
  t = ReactNative.View,
  n = ReactNative.Text,
  c = ReactNative.Switch;

module.exports = function (o) {
  if (o.hidden) return null;
  var s = o.stylesheet,
    u = s.formGroup.normal,
    h = s.controlLabel.normal,
    b = s.checkbox.normal,
    p = s.helpBlock.normal,
    y = s.errorBlock;

  if (o.hasError) {
    u = s.formGroup.error;
    h = s.controlLabel.error;
    b = s.checkbox.error;
    p = s.helpBlock.error;
  }

  var C = o.label ? <n style={h}>{o.label}</n> : null,
    f = o.help ? <n style={p}>{o.help}</n> : null,
    E =
      o.hasError && o.error ? (
        <n accessibilityLiveRegion="polite" style={y}>
          {o.error}
        </n>
      ) : null;
  return (
    <t style={u}>
      {C}
      <c
        accessibilityLabel={o.label}
        ref="input"
        disabled={o.disabled}
        onTintColor={o.onTintColor}
        thumbTintColor={o.thumbTintColor}
        tintColor={o.tintColor}
        style={b}
        onValueChange={function (l) {
          return o.onChange(l);
        }}
        value={o.value}
        testID={o.testID}
      />
      {f}
      {E}
    </t>
  );
};
