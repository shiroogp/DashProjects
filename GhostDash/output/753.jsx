var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = O(n);
    if (o && o.has(t)) return o.get(t);
    var l = {
        __proto__: null,
      },
      u = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var c in t)
      if ('default' !== c && Object.prototype.hasOwnProperty.call(t, c)) {
        var f = u ? Object.getOwnPropertyDescriptor(t, c) : null;
        if (f && (f.get || f.set)) Object.defineProperty(l, c, f);
        else l[c] = t[c];
      }

    l.default = t;
    if (o) o.set(t, l);
    return l;
  })(require('react')),
  ReactNative = require('react-native'),
  module2 = require('./2'),
  h = ['children', 'style', 'enabled'];

function O(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (O = function (t) {
    return t ? o : n;
  })(t);
}

function b() {
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

var P = ReactNative.Animated.createAnimatedComponent(module2.BaseButton),
  A = 'web' !== ReactNative.Platform.OS;
(exports.default = (function (t, ...args) {
  module38.default(S, t);

  var module2 = S,
    O = b(),
    _ = function () {
      var t,
        n = module37.default(module2);

      if (O) {
        var o = module37.default(this).constructor;
        t = Reflect.construct(n, arguments, o);
      } else t = n.apply(this, arguments);

      return module40.default(this, t);
    };

  function S() {
    var t;
    module27.default(this, S);
    (t = _.call(this, ...args)).opacity = new ReactNative.Animated.Value(1);

    t.handleActiveStateChange = function (n) {
      if ('android' !== ReactNative.Platform.OS)
        ReactNative.Animated.spring(t.opacity, {
          stiffness: 1e3,
          damping: 500,
          mass: 3,
          overshootClamping: true,
          restDisplacementThreshold: 0.01,
          restSpeedThreshold: 0.01,
          toValue: n ? t.props.activeOpacity : 1,
          useNativeDriver: A,
        }).start();
      if (!(null == t.props.onActiveStateChange)) t.props.onActiveStateChange(n);
    };

    return t;
  }

  module28.default(S, [
    {
      key: 'render',
      value: function () {
        var t = this.props,
          l = t.children,
          u = t.style,
          c = t.enabled,
          f = module56.default(t, h);
        return <P>{l}</P>;
      },
    },
  ]);
  return S;
})(React.Component)).defaultProps = {
  activeOpacity: 0.3,
  borderless: true,
};
