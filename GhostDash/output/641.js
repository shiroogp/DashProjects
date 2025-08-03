var module50 = require('./50'),
  module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  ReactNative = require('react-native'),
  module639 = E(require('./639')),
  React = E(require('react')),
  v = React,
  b = ['style'];

function j(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (j = function (t) {
    return t ? o : n;
  })(t);
}

function E(t, n) {
  if (!n && t && t.__esModule) return t;
  if (null === t || ('object' != typeof t && 'function' != typeof t))
    return {
      default: t,
    };
  var o = j(n);
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
}

function P(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var u = Object.getOwnPropertySymbols(t);
    if (n)
      u = u.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, u);
  }

  return o;
}

function w(t) {
  for (var o = 1; o < arguments.length; o++) {
    var u = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      P(Object(u), true).forEach(function (o) {
        module50.default(t, o, u[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(u));
    else
      P(Object(u)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(u, n));
      });
  }

  return t;
}

function D() {
  if ('undefined' == typeof Reflect || !Reflect.construct) return false;
  if (Reflect.construct.sham) return false;
  if ('function' == typeof Proxy) return true;

  try {
    Boolean.prototype.valueOf.call(Reflect.construct(Boolean, [], function () {}));
    return true;
  } catch (t) {
    return false;
  }
}

(exports.default = (function (t, ...args) {
  module38.default(E, t);

  var module50 = E,
    React = D(),
    j = function () {
      var t,
        o = module37.default(module50);

      if (React) {
        var u = module37.default(this).constructor;
        t = Reflect.construct(o, arguments, u);
      } else t = o.apply(this, arguments);

      return module40.default(this, t);
    };

  function E() {
    var t;
    module27.default(this, E);

    (t = j.call(this, ...args)).getChildStyleOpacityWithDefault = function () {
      var n = ReactNative.StyleSheet.flatten(t.props.style) || {};
      return null == n.opacity ? 1 : n.opacity;
    };

    t.opacity = new ReactNative.Animated.Value(t.getChildStyleOpacityWithDefault());

    t.setOpacityTo = function (n, o) {
      var u;
      ReactNative.Animated.timing(t.opacity, {
        toValue: n,
        duration: o,
        easing: ReactNative.Easing.inOut(ReactNative.Easing.quad),
        useNativeDriver: null == (u = t.props.useNativeAnimations) || u,
      }).start();
    };

    t.onStateChange = function (n, o) {
      if (o === module639.TOUCHABLE_STATE.BEGAN) t.setOpacityTo(t.props.activeOpacity, 0);
      else if (!(o !== module639.TOUCHABLE_STATE.UNDETERMINED && o !== module639.TOUCHABLE_STATE.MOVED_OUTSIDE)) t.setOpacityTo(t.getChildStyleOpacityWithDefault(), 150);
    };

    return t;
  }

  module28.default(E, [
    {
      key: 'render',
      value: function () {
        var t = this.props,
          n = t.style,
          c = undefined === n ? {} : n,
          l = module56.default(t, b);
        return v.createElement(
          module639.default,
          module14.default({}, l, {
            style: [
              c,
              {
                opacity: this.opacity,
              },
            ],
            onStateChange: this.onStateChange,
          }),
          this.props.children ? this.props.children : v.createElement(ReactNative.View, null)
        );
      },
    },
  ]);
  return E;
})(React.Component)).defaultProps = w(
  w({}, module639.default.defaultProps),
  {},
  {
    activeOpacity: 0.2,
  }
);
