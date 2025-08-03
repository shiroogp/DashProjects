var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var u = s(n);
    if (u && u.has(t)) return u.get(t);
    var f = {
        __proto__: null,
      },
      o = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var l in t)
      if ('default' !== l && Object.prototype.hasOwnProperty.call(t, l)) {
        var c = o ? Object.getOwnPropertyDescriptor(t, l) : null;
        if (c && (c.get || c.set)) Object.defineProperty(f, l, c);
        else f[l] = t[l];
      }

    f.default = t;
    if (u) u.set(t, f);
    return f;
  })(require('react')),
  module650 = require('./650'),
  module709 = require('./709'),
  module711 = require('./711'),
  module712 = require('./712'),
  v = ['theme'];

function s(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    u = new WeakMap();
  return (s = function (t) {
    return t ? u : n;
  })(t);
}

var y = React.forwardRef(function (t, s) {
  var y = t.theme,
    _ = undefined === y ? module711.default : y,
    O = module56.default(t, v),
    b = React.useRef(null);

  module712.default(b);
  React.useImperativeHandle(s, function () {
    return b.current;
  });
  return (
    <module709.default value={_}>
      <module650.BaseNavigationContainer />
    </module709.default>
  );
});
exports.default = y;
