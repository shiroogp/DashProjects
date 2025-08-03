exports.default = function () {
  var n = React.useRef({
      getState: {},
      beforeRemove: {},
    }).current,
    u = React.useCallback(
      function (t, u, o) {
        n[t][u] = o;
        return function () {
          n[t][u] = undefined;
        };
      },
      [n]
    );
  return {
    keyedListeners: n,
    addKeyedListener: u,
  };
};

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
})(require('react'));

function n(t) {
  if ('function' != typeof WeakMap) return null;
  var u = new WeakMap(),
    o = new WeakMap();
  return (n = function (t) {
    return t ? o : u;
  })(t);
}
