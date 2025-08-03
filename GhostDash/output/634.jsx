Object.defineProperty(exports, 'PureNativeButton', {
  enumerable: true,
  get: function () {
    return module635.default;
  },
});

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
    var o = b(n);
    if (o && o.has(t)) return o.get(t);
    var l = {
        __proto__: null,
      },
      u = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var s in t)
      if ('default' !== s && Object.prototype.hasOwnProperty.call(t, s)) {
        var c = u ? Object.getOwnPropertyDescriptor(t, s) : null;
        if (c && (c.get || c.set)) Object.defineProperty(l, s, c);
        else l[s] = t[s];
      }

    l.default = t;
    if (o) o.set(t, l);
    return l;
  })(require('react')),
  ReactNative = require('react-native'),
  module616 = require('./616'),
  module635 = require('./635'),
  module403 = require('./403'),
  S = ['rippleColor'],
  P = ['children', 'style'],
  A = ['children', 'style'];

function b(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (b = function (t) {
    return t ? o : n;
  })(t);
}

function E(t) {
  var n = R();
  return function () {
    var o,
      l = module37.default(t);

    if (n) {
      var u = module37.default(this).constructor;
      o = Reflect.construct(l, arguments, u);
    } else o = l.apply(this, arguments);

    return module40.default(this, o);
  };
}

function R() {
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

var O = (exports.RawButton = module616.default(module635.default, {
    shouldCancelWhenOutside: false,
    shouldActivateOnStart: false,
  })),
  B = (exports.BaseButton = (function (t) {
    module38.default(p, t);
    var c = E(p);

    function p(t) {
      var n;
      module27.default(this, p);

      (n = c.call(this, t)).handleEvent = function (t) {
        var o = t.nativeEvent,
          l = o.state,
          u = o.oldState,
          s = o.pointerInside,
          c = s && l === module403.State.ACTIVE;
        if (c !== n.lastActive && n.props.onActiveStateChange) n.props.onActiveStateChange(c);
        if (!n.longPressDetected && u === module403.State.ACTIVE && l !== module403.State.CANCELLED && n.lastActive && n.props.onPress) n.props.onPress(c);

        if (!n.lastActive && l === ('android' !== ReactNative.Platform.OS ? module403.State.ACTIVE : module403.State.BEGAN) && s) {
          n.longPressDetected = false;
          if (n.props.onLongPress) n.longPressTimeout = setTimeout(n.onLongPress, n.props.delayLongPress);
        } else if (
          !(
            (l !== module403.State.ACTIVE || s || undefined === n.longPressTimeout) &&
            (undefined === n.longPressTimeout || (l !== module403.State.END && l !== module403.State.CANCELLED && l !== module403.State.FAILED))
          )
        ) {
          clearTimeout(n.longPressTimeout);
          n.longPressTimeout = undefined;
        }

        n.lastActive = c;
      };

      n.onLongPress = function () {
        n.longPressDetected = true;
        if (!(null == n.props.onLongPress)) n.props.onLongPress();
      };

      n.onHandlerStateChange = function (t) {
        if (!(null == n.props.onHandlerStateChange)) n.props.onHandlerStateChange(t);
        n.handleEvent(t);
      };

      n.onGestureEvent = function (t) {
        if (!(null == n.props.onGestureEvent)) n.props.onGestureEvent(t);
        n.handleEvent(t);
      };

      n.lastActive = false;
      n.longPressDetected = false;
      return n;
    }

    module28.default(p, [
      {
        key: 'render',
        value: function () {
          var t = this.props,
            l = t.rippleColor,
            u = module56.default(t, S);
          return <O />;
        },
      },
    ]);
    return p;
  })(React.Component));

B.defaultProps = {
  delayLongPress: 600,
};
var L = ReactNative.Animated.createAnimatedComponent(B),
  T = ReactNative.StyleSheet.create({
    underlay: {
      position: 'absolute',
      left: 0,
      right: 0,
      bottom: 0,
      top: 0,
    },
  });
(exports.RectButton = (function (t) {
  module38.default(p, t);
  var c = E(p);

  function p(t) {
    var n;
    module27.default(this, p);

    (n = c.call(this, t)).onActiveStateChange = function (t) {
      if ('android' !== ReactNative.Platform.OS) n.opacity.setValue(t ? n.props.activeOpacity : 0);
      if (!(null == n.props.onActiveStateChange)) n.props.onActiveStateChange(t);
    };

    n.opacity = new ReactNative.Animated.Value(0);
    return n;
  }

  module28.default(p, [
    {
      key: 'render',
      value: function () {
        var t = this.props,
          l = t.children,
          u = t.style,
          s = module56.default(t, P),
          c = ReactNative.StyleSheet.flatten(null != u ? u : {});
        return (
          <B>
            {React.createElement(ReactNative.Animated.View, {
              style: [
                T.underlay,
                {
                  opacity: this.opacity,
                  backgroundColor: this.props.underlayColor,
                  borderRadius: c.borderRadius,
                  borderTopLeftRadius: c.borderTopLeftRadius,
                  borderTopRightRadius: c.borderTopRightRadius,
                  borderBottomLeftRadius: c.borderBottomLeftRadius,
                  borderBottomRightRadius: c.borderBottomRightRadius,
                },
              ],
            })}
            {l}
          </B>
        );
      },
    },
  ]);
  return p;
})(React.Component)).defaultProps = {
  activeOpacity: 0.105,
  underlayColor: 'black',
};
(exports.BorderlessButton = (function (t) {
  module38.default(p, t);
  var c = E(p);

  function p(t) {
    var n;
    module27.default(this, p);

    (n = c.call(this, t)).onActiveStateChange = function (t) {
      if ('android' !== ReactNative.Platform.OS) n.opacity.setValue(t ? n.props.activeOpacity : 1);
      if (!(null == n.props.onActiveStateChange)) n.props.onActiveStateChange(t);
    };

    n.opacity = new ReactNative.Animated.Value(1);
    return n;
  }

  module28.default(p, [
    {
      key: 'render',
      value: function () {
        var t = this.props,
          l = t.children,
          u = t.style,
          s = module56.default(t, A);
        return React.createElement(
          L,
          module14.default({}, s, {
            onActiveStateChange: this.onActiveStateChange,
            style: [
              u,
              'ios' === ReactNative.Platform.OS && {
                opacity: this.opacity,
              },
            ],
          }),
          l
        );
      },
    },
  ]);
  return p;
})(React.Component)).defaultProps = {
  activeOpacity: 0.3,
  borderless: true,
};
