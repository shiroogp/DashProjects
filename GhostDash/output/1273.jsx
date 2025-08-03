var React = require('react'),
  ReactNative = require('react-native'),
  n = ReactNative.View,
  o = ReactNative.Text;

module.exports = function (t) {
  if (t.hidden) return null;
  var s = t.stylesheet,
    c = s.fieldset,
    u = s.controlLabel.normal;
  if (t.hasError) u = s.controlLabel.error;
  var b = t.label ? <o style={u}>{t.label}</o> : null,
    f =
      t.hasError && t.error ? (
        <o accessibilityLiveRegion="polite" style={s.errorBlock}>
          {t.error}
        </o>
      ) : null,
    y = t.order.map(function (l) {
      return t.inputs[l];
    });
  return (
    <n style={c}>
      {b}
      {f}
      {y}
    </n>
  );
};
