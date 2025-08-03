var module14 = require('./14'),
  module50 = require('./50'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = l(n);
    if (o && o.has(t)) return o.get(t);
    var c = {
        __proto__: null,
      },
      u = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var f in t)
      if ('default' !== f && Object.prototype.hasOwnProperty.call(t, f)) {
        var s = u ? Object.getOwnPropertyDescriptor(t, f) : null;
        if (s && (s.get || s.set)) Object.defineProperty(c, f, s);
        else c[f] = t[f];
      }

    c.default = t;
    if (o) o.set(t, c);
    return c;
  })(require('react')),
  module649 = require('./649'),
  module726 = require('./726'),
  p = ['initialRouteName', 'children', 'screenOptions'];

function l(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (l = function (t) {
    return t ? o : n;
  })(t);
}

function O(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var c = Object.getOwnPropertySymbols(t);
    if (n)
      c = c.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, c);
  }

  return o;
}

function y(t) {
  for (var n = 1; n < arguments.length; n++) {
    var c = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      O(Object(c), true).forEach(function (n) {
        module50.default(t, n, c[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(c));
    else
      O(Object(c)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(c, n));
      });
  }

  return t;
}

exports.default = module649.createNavigatorFactory(function (t) {
  var o = t.initialRouteName,
    l = t.children,
    O = t.screenOptions,
    b = module56.default(t, p),
    v = module649.useNavigationBuilder(module649.StackRouter, {
      initialRouteName: o,
      children: l,
      screenOptions: O,
    }),
    j = v.state,
    P = v.descriptors,
    w = v.navigation;
  React.useEffect(
    function () {
      return (
        w.addListener &&
        w.addListener('tabPress', function (t) {
          var n = w.isFocused();
          requestAnimationFrame(function () {
            if (j.index > 0 && n && !t.defaultPrevented)
              w.dispatch(
                y(
                  y({}, module649.StackActions.popToTop()),
                  {},
                  {
                    target: j.key,
                  }
                )
              );
          });
        })
      );
    },
    [w, j.index, j.key]
  );
  return <module726.default />;
});
