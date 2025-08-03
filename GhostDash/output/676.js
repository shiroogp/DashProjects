function t(n) {
  if ('function' != typeof WeakMap) return null;
  var o = new WeakMap(),
    u = new WeakMap();
  return (t = function (t) {
    return t ? u : o;
  })(n);
}

var React = (function (n, o) {
  if (!o && n && n.__esModule) return n;
  if (null === n || ('object' != typeof n && 'function' != typeof n))
    return {
      default: n,
    };
  var u = t(o);
  if (u && u.has(n)) return u.get(n);
  var f = {
      __proto__: null,
    },
    l = Object.defineProperty && Object.getOwnPropertyDescriptor;

  for (var c in n)
    if ('default' !== c && Object.prototype.hasOwnProperty.call(n, c)) {
      var p = l ? Object.getOwnPropertyDescriptor(n, c) : null;
      if (p && (p.get || p.set)) Object.defineProperty(f, c, p);
      else f[c] = n[c];
    }

  f.default = n;
  if (u) u.set(n, f);
  return f;
})(require('react')).createContext(undefined);

exports.default = React;
