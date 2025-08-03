exports.default = function (t) {
  var o = t.state,
    s = t.navigation,
    y = t.descriptors,
    v = module56.default(t, b),
    P = module649.useTheme(),
    k = P.dark,
    h = P.colors,
    B = React.useMemo(
      function () {
        var t = k ? module785.DarkTheme : module785.DefaultTheme;
        return O(
          O({}, t),
          {},
          {
            colors: O(
              O(O({}, t.colors), h),
              {},
              {
                surface: h.card,
              }
            ),
          }
        );
      },
      [h, k]
    );
  return <module785.BottomNavigation />;
};

var module14 = require('./14'),
  module50 = require('./50'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = y(n);
    if (o && o.has(t)) return o.get(t);
    var c = {
        __proto__: null,
      },
      u = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var s in t)
      if ('default' !== s && Object.prototype.hasOwnProperty.call(t, s)) {
        var l = u ? Object.getOwnPropertyDescriptor(t, s) : null;
        if (l && (l.get || l.set)) Object.defineProperty(c, s, l);
        else c[s] = t[s];
      }

    c.default = t;
    if (o) o.set(t, c);
    return c;
  })(require('react')),
  ReactNative = require('react-native'),
  module785 = require('./785'),
  module799 = require('./799'),
  module649 = require('./649'),
  b = ['state', 'navigation', 'descriptors'];

function y(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (y = function (t) {
    return t ? o : n;
  })(t);
}

function v(t, n) {
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

function O(t) {
  for (var n = 1; n < arguments.length; n++) {
    var c = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      v(Object(c), true).forEach(function (n) {
        module50.default(t, n, c[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(c));
    else
      v(Object(c)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(c, n));
      });
  }

  return t;
}

var j = ReactNative.StyleSheet.create({
  icon: {
    backgroundColor: 'transparent',
  },
});
