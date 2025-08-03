exports.default = function (t) {
  var c = React.useRef(f),
    o = React.useRef(false),
    l = React.useRef(true);
  React.useEffect(function () {
    l.current = true;
    return function () {
      l.current = false;
    };
  }, []);
  if (c.current === f) c.current = 'function' == typeof t ? t() : t;

  var p = React.useState(c.current),
    s = module15.default(p, 2),
    y = s[0],
    b = s[1],
    v = React.useCallback(function () {
      return c.current;
    }, []),
    _ = React.useCallback(function (t) {
      if (t !== c.current && l.current) {
        c.current = t;
        if (!o.current) b(t);
      }
    }, []),
    O = React.useCallback(function (t) {
      o.current = true;

      try {
        t();
      } finally {
        o.current = false;
      }
    }, []),
    j = React.useCallback(function () {
      if (l.current) b(c.current);
    }, []);

  if (y !== c.current) b(c.current);
  return [c.current, v, _, O, j];
};

var module15 = require('@babel/runtime/helpers/slicedToArray'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var u = c(n);
    if (u && u.has(t)) return u.get(t);
    var f = {
        __proto__: null,
      },
      o = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var l in t)
      if ('default' !== l && Object.prototype.hasOwnProperty.call(t, l)) {
        var p = o ? Object.getOwnPropertyDescriptor(t, l) : null;
        if (p && (p.get || p.set)) Object.defineProperty(f, l, p);
        else f[l] = t[l];
      }

    f.default = t;
    if (u) u.set(t, f);
    return f;
  })(require('react'));

function c(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    u = new WeakMap();
  return (c = function (t) {
    return t ? u : n;
  })(t);
}

var f = {};
