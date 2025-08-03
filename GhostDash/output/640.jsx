var module14 = require('./14'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var f = o(n);
    if (f && f.has(t)) return f.get(t);
    var u = {
        __proto__: null,
      },
      l = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var p in t)
      if ('default' !== p && Object.prototype.hasOwnProperty.call(t, p)) {
        var c = l ? Object.getOwnPropertyDescriptor(t, p) : null;
        if (c && (c.get || c.set)) Object.defineProperty(u, p, c);
        else u[p] = t[p];
      }

    u.default = t;
    if (f) f.set(t, u);
    return u;
  })(require('react')),
  module639 = require('./639');

function o(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    f = new WeakMap();
  return (o = function (t) {
    return t ? f : n;
  })(t);
}

var l = React.forwardRef(function (t, o) {
  return <module639.default />;
});
l.defaultProps = module639.default.defaultProps;
exports.default = l;
