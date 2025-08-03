var React = (function (t, u) {
  if (!u && t && t.__esModule) return t;
  if (null === t || ('object' != typeof t && 'function' != typeof t))
    return {
      default: t,
    };
  var o = n(u);
  if (o && o.has(t)) return o.get(t);
  var f = {
      __proto__: null,
    },
    l = Object.defineProperty && Object.getOwnPropertyDescriptor;

  for (var c in t)
    if ('default' !== c && Object.prototype.hasOwnProperty.call(t, c)) {
      var p = l ? Object.getOwnPropertyDescriptor(t, c) : null;
      if (p && (p.get || p.set)) Object.defineProperty(f, c, p);
      else f[c] = t[c];
    }

  f.default = t;
  if (o) o.set(t, f);
  return f;
})(require('react'));

function n(t) {
  if ('function' != typeof WeakMap) return null;
  var u = new WeakMap(),
    o = new WeakMap();
  return (n = function (t) {
    return t ? o : u;
  })(t);
}

exports.default = React.memo(
  function (t) {
    return t.children;
  },
  function (t, n) {
    var u = Object.keys(t),
      o = Object.keys(n);
    if (u.length !== o.length) return false;

    for (var f = 0, l = u; f < l.length; f++) {
      var c = l[f];
      if ('children' !== c && t[c] !== n[c]) return false;
    }

    return true;
  }
);
