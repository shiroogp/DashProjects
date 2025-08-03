exports.default = function (t) {
  var u = t.router,
    f = t.getState,
    c = t.key,
    l = t.setState,
    p = React.useContext(module661.default).onRouteFocus;
  return React.useCallback(
    function (t) {
      var n = f(),
        o = u.getStateForRouteFocus(n, t);
      if (o !== n) l(o);
      if (undefined !== p && undefined !== c) p(c);
    },
    [f, p, u, l, c]
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
  module661 = require('./661');

function u(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (u = function (t) {
    return t ? o : n;
  })(t);
}
