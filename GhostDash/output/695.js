exports.default = function (t) {
  var u = module693.default();
  React.useEffect(
    function () {
      var n,
        o = false,
        f = function () {
          var n = t();
          if (undefined === n || 'function' == typeof n) return n;
        };

      if (u.isFocused()) {
        n = f();
        o = true;
      }

      var c = u.addListener('focus', function () {
          if (!o) {
            if (undefined !== n) n();
            n = f();
            o = true;
          }
        }),
        l = u.addListener('blur', function () {
          if (undefined !== n) n();
          n = undefined;
          o = false;
        });
      return function () {
        if (undefined !== n) n();
        c();
        l();
      };
    },
    [t, u]
  );
};

var React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = u(n);
    if (o && o.has(t)) return o.get(t);
    var f = {
        __proto__: null,
      },
      c = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var l in t)
      if ('default' !== l && Object.prototype.hasOwnProperty.call(t, l)) {
        var p = c ? Object.getOwnPropertyDescriptor(t, l) : null;
        if (p && (p.get || p.set)) Object.defineProperty(f, l, p);
        else f[l] = t[l];
      }

    f.default = t;
    if (o) o.set(t, f);
    return f;
  })(require('react')),
  module693 = require('./693');

function u(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (u = function (t) {
    return t ? o : n;
  })(t);
}
