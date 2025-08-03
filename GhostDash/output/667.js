exports.default = function (t) {
  var o = t.key,
    c = t.options,
    f = t.navigation,
    s = React.useRef(c),
    p = React.useRef({}),
    v = React.useContext(module661.default).onOptionsChange,
    O = React.useContext(module662.default).addOptionsGetter,
    y = React.useCallback(
      function () {
        var t,
          n,
          u = null == (t = null == f ? undefined : f.isFocused()) || t,
          l = Object.keys(p.current).length;
        if (u && !l) v(null != (n = s.current) ? n : {});
      },
      [f, v]
    );
  React.useEffect(
    function () {
      s.current = c;
      y();
      return null == f ? undefined : f.addListener('focus', y);
    },
    [f, c, y]
  );

  var b = React.useCallback(function () {
      for (var t in p.current)
        if (p.current.hasOwnProperty(t)) {
          var n,
            u,
            l = null == (n = (u = p.current)[t]) ? undefined : n.call(u);
          if (null !== l) return l;
        }

      return null;
    }, []),
    _ = React.useCallback(
      function () {
        var t,
          n = null == (t = null == f ? undefined : f.isFocused()) || t;
        if (!n) return null;
        var u = b();
        return null !== u ? u : s.current;
      },
      [f, b]
    );

  React.useEffect(
    function () {
      return null == O ? undefined : O(o, _);
    },
    [_, O, o]
  );
  return {
    addOptionsGetter: React.useCallback(
      function (t, n) {
        p.current[t] = n;
        y();
        return function () {
          delete p.current[t];
          y();
        };
      },
      [y]
    ),
    getCurrentOptions: _,
  };
};

var React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var u = o(n);
    if (u && u.has(t)) return u.get(t);
    var l = {
        __proto__: null,
      },
      c = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var f in t)
      if ('default' !== f && Object.prototype.hasOwnProperty.call(t, f)) {
        var s = c ? Object.getOwnPropertyDescriptor(t, f) : null;
        if (s && (s.get || s.set)) Object.defineProperty(l, f, s);
        else l[f] = t[f];
      }

    l.default = t;
    if (u) u.set(t, l);
    return l;
  })(require('react')),
  module662 = require('./662'),
  module661 = require('./661');

function o(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    u = new WeakMap();
  return (o = function (t) {
    return t ? u : n;
  })(t);
}
