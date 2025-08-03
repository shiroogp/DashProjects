var React = require('react'),
  ReactNative = require('react-native'),
  l = ReactNative.View,
  o = ReactNative.Text,
  c = ReactNative.TouchableHighlight;

function u(n) {
  return <l key={n.key}>{n.input}</l>;
}

function s(n, l, u) {
  return (
    <c key={n.type} style={[l.button, u]} onPress={n.click}>
      <o style={l.buttonText}>{n.label}</o>
    </c>
  );
}

function y(n, o) {
  return (
    <l
      style={{
        flexDirection: 'row',
      }}
    >
      {n.map(function (t) {
        return s(t, o, {
          width: 50,
        });
      })}
    </l>
  );
}

function f(n, o) {
  return (
    <l
      key={n.key}
      style={{
        flexDirection: 'row',
      }}
    >
      <l
        style={{
          flex: 1,
        }}
      >
        {n.input}
      </l>
      <l
        style={{
          flex: 1,
        }}
      >
        <n.buttons />
      </l>
    </l>
  );
}

module.exports = function (n) {
  if (n.hidden) return null;
  var c = n.stylesheet,
    y = c.fieldset,
    E = c.controlLabel.normal;
  if (n.hasError) E = c.controlLabel.error;
  var b = n.label ? <o style={E}>{n.label}</o> : null,
    h =
      n.hasError && n.error ? (
        <o accessibilityLiveRegion="polite" style={c.errorBlock}>
          {n.error}
        </o>
      ) : null,
    k = n.items.map(function (t) {
      return 0 === t.buttons.length ? u(t) : f(t, c);
    }),
    p = n.add ? s(n.add, c) : null;
  return (
    <l style={y}>
      {b}
      {h}
      {k}
      {p}
    </l>
  );
};
