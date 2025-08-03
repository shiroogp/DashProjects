var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = p(n);
    if (o && o.has(t)) return o.get(t);
    var u = {
        __proto__: null,
      },
      c = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var l in t)
      if ('default' !== l && Object.prototype.hasOwnProperty.call(t, l)) {
        var f = c ? Object.getOwnPropertyDescriptor(t, l) : null;
        if (f && (f.get || f.set)) Object.defineProperty(u, l, f);
        else u[l] = t[l];
      }

    u.default = t;
    if (o) o.set(t, u);
    return u;
  })(require('react')),
  module649 = require('./649'),
  module784 = require('./784'),
  f = ['initialRouteName', 'backBehavior', 'children', 'screenOptions'];

function p(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (p = function (t) {
    return t ? o : n;
  })(t);
}

exports.default = module649.createNavigatorFactory(function (t) {
  var p = t.initialRouteName,
    s = t.backBehavior,
    v = t.children,
    O = t.screenOptions,
    b = module56.default(t, f),
    y = module649.useNavigationBuilder(module649.TabRouter, {
      initialRouteName: p,
      backBehavior: s,
      children: v,
      screenOptions: O,
    }),
    _ = y.state,
    h = y.descriptors,
    j = y.navigation;
  return <module784.default />;
});
