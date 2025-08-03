var module14 = require('./14'),
  React = require('react'),
  ReactNative = require('react-native'),
  n = ReactNative.View,
  c = ReactNative.Text,
  s = ReactNative.Picker;

module.exports = function (o) {
  if (o.hidden) return null;
  var p = o.stylesheet,
    u = p.formGroup.normal,
    h = p.controlLabel.normal,
    b = module14({}, p.select.normal, p.pickerContainer.normal),
    y = p.helpBlock.normal,
    v = p.errorBlock;

  if (o.hasError) {
    u = p.formGroup.error;
    h = p.controlLabel.error;
    b = p.select.error;
    y = p.helpBlock.error;
  }

  var E = o.label ? <c style={h}>{o.label}</c> : null,
    f = o.help ? <c style={y}>{o.help}</c> : null,
    k =
      o.hasError && o.error ? (
        <c accessibilityLiveRegion="polite" style={v}>
          {o.error}
        </c>
      ) : null,
    L = o.options.map(function (l) {
      var o = l.value,
        n = l.text;
      return <s.Item key={o} value={o} label={n} />;
    });
  return (
    <n style={u}>
      {E}
      <s
        accessibilityLabel={o.label}
        ref="input"
        style={b}
        selectedValue={o.value}
        onValueChange={o.onChange}
        help={o.help}
        enabled={!o.disabled}
        mode={o.mode}
        prompt={o.prompt}
        itemStyle={o.itemStyle}
      >
        {L}
      </s>
      {f}
      {k}
    </n>
  );
};
