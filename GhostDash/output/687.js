exports.default = function (t) {
  var o = t.state,
    f = t.emitter,
    c = React.useContext(module674.default),
    l = React.useRef(),
    s = o.routes[o.index].key;
  React.useEffect(
    function () {
      return null == c
        ? undefined
        : c.addListener('focus', function () {
            l.current = s;
            f.emit({
              type: 'focus',
              target: s,
            });
          });
    },
    [s, f, c]
  );
  React.useEffect(
    function () {
      return null == c
        ? undefined
        : c.addListener('blur', function () {
            l.current = undefined;
            f.emit({
              type: 'blur',
              target: s,
            });
          });
    },
    [s, f, c]
  );
  React.useEffect(
    function () {
      var t = l.current;
      l.current = s;
      if (!(undefined !== t || c))
        f.emit({
          type: 'focus',
          target: s,
        });
      if (!(t === s || (c && !c.isFocused())))
        undefined !== t &&
          (f.emit({
            type: 'blur',
            target: t,
          }),
          f.emit({
            type: 'focus',
            target: s,
          }));
    },
    [s, f, c]
  );
};

var React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var u = o(n);
    if (u && u.has(t)) return u.get(t);
    var f = {
        __proto__: null,
      },
      c = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var l in t)
      if ('default' !== l && Object.prototype.hasOwnProperty.call(t, l)) {
        var s = c ? Object.getOwnPropertyDescriptor(t, l) : null;
        if (s && (s.get || s.set)) Object.defineProperty(f, l, s);
        else f[l] = t[l];
      }

    f.default = t;
    if (u) u.set(t, f);
    return f;
  })(require('react')),
  module674 = require('./674');

function o(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    u = new WeakMap();
  return (o = function (t) {
    return t ? u : n;
  })(t);
}
