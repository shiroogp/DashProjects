exports.default = function () {
  var t = module693.default(),
    f = React.useCallback(t.isFocused, [t]),
    c = React.useCallback(
      function (n) {
        var u = t.addListener('focus', n),
          o = t.addListener('blur', n);
        return function () {
          u();
          o();
        };
      },
      [t]
    );
  return module393.useSubscription({
    getCurrentValue: f,
    subscribe: c,
  });
};

var React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var u = f(n);
    if (u && u.has(t)) return u.get(t);
    var o = {
        __proto__: null,
      },
      c = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var l in t)
      if ('default' !== l && Object.prototype.hasOwnProperty.call(t, l)) {
        var s = c ? Object.getOwnPropertyDescriptor(t, l) : null;
        if (s && (s.get || s.set)) Object.defineProperty(o, l, s);
        else o[l] = t[l];
      }

    o.default = t;
    if (u) u.set(t, o);
    return o;
  })(require('react')),
  module393 = require('./393'),
  module693 = require('./693');

function f(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    u = new WeakMap();
  return (f = function (t) {
    return t ? u : n;
  })(t);
}
