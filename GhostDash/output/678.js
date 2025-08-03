exports.default = function () {
  var t = React.useState(function () {
      return module654.nanoid();
    }),
    c = module15.default(t, 1)[0],
    p = React.useContext(module660.SingleNavigatorContext);
  if (undefined === p) throw new Error("Couldn't register the navigator. Have you wrapped your app with 'NavigationContainer'?");
  React.useEffect(
    function () {
      var t = p.register,
        n = p.unregister;
      t(c);
      return function () {
        return n(c);
      };
    },
    [p, c]
  );
  return c;
};

var module15 = require('@babel/runtime/helpers/slicedToArray'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = c(n);
    if (o && o.has(t)) return o.get(t);
    var u = {
        __proto__: null,
      },
      f = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var p in t)
      if ('default' !== p && Object.prototype.hasOwnProperty.call(t, p)) {
        var l = f ? Object.getOwnPropertyDescriptor(t, p) : null;
        if (l && (l.get || l.set)) Object.defineProperty(u, p, l);
        else u[p] = t[p];
      }

    u.default = t;
    if (o) o.set(t, u);
    return u;
  })(require('react')),
  module654 = require('./654'),
  module660 = require('./660');

function c(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (c = function (t) {
    return t ? o : n;
  })(t);
}
