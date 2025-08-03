exports.default = function (t) {
  var o = t.style,
    s = module56.default(t, p),
    y = module649.useTheme().colors;
  return React.createElement(
    ReactNative.Animated.View,
    module14.default(
      {
        style: [
          O.container,
          {
            backgroundColor: y.card,
            borderBottomColor: y.border,
            shadowColor: y.border,
          },
          o,
        ],
      },
      s
    )
  );
};

var module50 = require('./50'),
  module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  React = (function (t, o) {
    if (!o && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var n = s(o);
    if (n && n.has(t)) return n.get(t);
    var c = {
        __proto__: null,
      },
      l = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var u in t)
      if ('default' !== u && Object.prototype.hasOwnProperty.call(t, u)) {
        var f = l ? Object.getOwnPropertyDescriptor(t, u) : null;
        if (f && (f.get || f.set)) Object.defineProperty(c, u, f);
        else c[u] = t[u];
      }

    c.default = t;
    if (n) n.set(t, c);
    return c;
  })(require('react')),
  ReactNative = require('react-native'),
  module649 = require('./649'),
  p = ['style'];

function s(t) {
  if ('function' != typeof WeakMap) return null;
  var o = new WeakMap(),
    n = new WeakMap();
  return (s = function (t) {
    return t ? n : o;
  })(t);
}

function y(t, o) {
  var n = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var c = Object.getOwnPropertySymbols(t);
    if (o)
      c = c.filter(function (o) {
        return Object.getOwnPropertyDescriptor(t, o).enumerable;
      });
    n.push.apply(n, c);
  }

  return n;
}

var O = ReactNative.StyleSheet.create({
  container: (function (t) {
    for (var n = 1; n < arguments.length; n++) {
      var c = null != arguments[n] ? arguments[n] : {};
      if (n % 2)
        y(Object(c), true).forEach(function (n) {
          module50.default(t, n, c[n]);
        });
      else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(c));
      else
        y(Object(c)).forEach(function (o) {
          Object.defineProperty(t, o, Object.getOwnPropertyDescriptor(c, o));
        });
    }

    return t;
  })(
    {
      flex: 1,
    },
    ReactNative.Platform.select({
      android: {
        elevation: 4,
      },
      ios: {
        shadowOpacity: 0.85,
        shadowRadius: 0,
        shadowOffset: {
          width: 0,
          height: ReactNative.StyleSheet.hairlineWidth,
        },
      },
      default: {
        borderBottomWidth: ReactNative.StyleSheet.hairlineWidth,
      },
    })
  ),
});
