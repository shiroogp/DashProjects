var module14 = require('./14'),
  module50 = require('./50'),
  module27 = require('./27'),
  module42 = require('./42'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = y(n);
    if (o && o.has(t)) return o.get(t);
    var l = {
        __proto__: null,
      },
      s = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var p in t)
      if ('default' !== p && Object.prototype.hasOwnProperty.call(t, p)) {
        var u = s ? Object.getOwnPropertyDescriptor(t, p) : null;
        if (u && (u.get || u.set)) Object.defineProperty(l, p, u);
        else l[p] = t[p];
      }

    l.default = t;
    if (o) o.set(t, l);
    return l;
  })(require('react')),
  v = React,
  ReactNative = require('react-native'),
  module612 = require('./612'),
  module515 = require('./515'),
  module403 = require('./403');

function y(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (y = function (t) {
    return t ? o : n;
  })(t);
}

function R(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var l = Object.getOwnPropertySymbols(t);
    if (n)
      l = l.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, l);
  }

  return o;
}

function A(t) {
  for (var n = 1; n < arguments.length; n++) {
    var l = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      R(Object(l), true).forEach(function (n) {
        module50.default(t, n, l[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(l));
    else
      R(Object(l)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(l, n));
      });
  }

  return t;
}

function W() {
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

var E = 0.05;
(exports.default = (function (t) {
  module38.default(R, t);

  var module50 = R,
    React = W(),
    y = function () {
      var t,
        n = module37.default(module50);

      if (React) {
        var l = module37.default(this).constructor;
        t = Reflect.construct(n, arguments, l);
      } else t = n.apply(this, arguments);

      return module40.default(this, t);
    };

  function R(t) {
    var n;
    module27.default(this, R);

    (n = y.call(this, t)).updateAnimatedEvent = function (t, o) {
      var l = t.friction,
        s = t.overshootFriction,
        p = o.dragX,
        u = o.rowTranslation,
        f = o.leftWidth,
        c = undefined === f ? 0 : f,
        h = o.rowWidth,
        v = undefined === h ? 0 : h,
        O = o.rightOffset,
        b = undefined === O ? v : O,
        S = 0 ** (v - b),
        y = t.overshootLeft,
        R = undefined === y ? c > 0 : y,
        A = t.overshootRight,
        W = undefined === A ? S > 0 : A,
        E = ReactNative.Animated.add(
          u,
          p.interpolate({
            inputRange: [0, l],
            outputRange: [0, 1],
          })
        ).interpolate({
          inputRange: [-S - 1, -S, c, c + 1],
          outputRange: [-S - (W ? 1 / s : 0), -S, c, c + (R ? 1 / s : 0)],
        });
      n.transX = E;
      n.showLeftAction =
        c > 0
          ? E.interpolate({
              inputRange: [-1, 0, c],
              outputRange: [0, 0, 1],
            })
          : new ReactNative.Animated.Value(0);
      n.leftActionTranslate = n.showLeftAction.interpolate({
        inputRange: [0, Number.MIN_VALUE],
        outputRange: [-1e4, 0],
        extrapolate: 'clamp',
      });
      n.showRightAction =
        S > 0
          ? E.interpolate({
              inputRange: [-S, 0, 1],
              outputRange: [1, 0, 0],
            })
          : new ReactNative.Animated.Value(0);
      n.rightActionTranslate = n.showRightAction.interpolate({
        inputRange: [0, Number.MIN_VALUE],
        outputRange: [-1e4, 0],
        extrapolate: 'clamp',
      });
    };

    n.onTapHandlerStateChange = function (t) {
      if (t.nativeEvent.oldState === module403.State.ACTIVE) n.close();
    };

    n.onHandlerStateChange = function (t) {
      if (t.nativeEvent.oldState === module403.State.ACTIVE) n.handleRelease(t);
    };

    n.handleRelease = function (t) {
      var o = t.nativeEvent,
        l = o.velocityX,
        s = o.translationX,
        p = n.state,
        u = p.leftWidth,
        f = undefined === u ? 0 : u,
        c = p.rowWidth,
        h = undefined === c ? 0 : c,
        v = p.rowState,
        w = n.state.rightOffset,
        O = h - (undefined === w ? h : w),
        b = n.props,
        S = b.friction,
        y = b.leftThreshold,
        R = undefined === y ? f / 2 : y,
        A = b.rightThreshold,
        W = undefined === A ? O / 2 : A,
        L = n.currentOffset() + s / S,
        j = (s + E * l) / S,
        T = 0;
      if (0 === v) j > R ? (T = f) : j < -W && (T = -O);
      else if (1 === v) {
        if (j > -R) T = f;
      } else if (j < W) T = -O;
      n.animateRow(L, T, l / S);
    };

    n.animateRow = function (t, o, l) {
      var s = n.state,
        u = s.dragX,
        f = s.rowTranslation;

      if (
        (u.setValue(0),
        f.setValue(t),
        n.setState({
          rowState: Math.sign(o),
        }),
        ReactNative.Animated.spring(
          f,
          A(
            {
              restSpeedThreshold: 1.7,
              restDisplacementThreshold: 0.4,
              velocity: l,
              bounciness: 0,
              toValue: o,
              useNativeDriver: n.props.useNativeAnimations,
            },
            n.props.animationOptions
          )
        ).start(function (l) {
          if (l.finished)
            if (o > 0) {
              if (!(null == n.props.onSwipeableLeftOpen)) n.props.onSwipeableLeftOpen();
              if (!(null == n.props.onSwipeableOpen)) n.props.onSwipeableOpen('left', module42.default(n));
            } else if (o < 0) {
              if (!(null == n.props.onSwipeableRightOpen)) n.props.onSwipeableRightOpen();
              if (!(null == n.props.onSwipeableOpen)) n.props.onSwipeableOpen('right', module42.default(n));
            } else {
              var s = t > 0 ? 'left' : 'right';
              if (!(null == n.props.onSwipeableClose)) n.props.onSwipeableClose(s, module42.default(n));
            }
        }),
        o > 0)
      ) {
        if (!(null == n.props.onSwipeableLeftWillOpen)) n.props.onSwipeableLeftWillOpen();
        if (!(null == n.props.onSwipeableWillOpen)) n.props.onSwipeableWillOpen('left');
      } else if (o < 0) {
        if (!(null == n.props.onSwipeableRightWillOpen)) n.props.onSwipeableRightWillOpen();
        if (!(null == n.props.onSwipeableWillOpen)) n.props.onSwipeableWillOpen('right');
      } else {
        var c = t > 0 ? 'left' : 'right';
        if (!(null == n.props.onSwipeableWillClose)) n.props.onSwipeableWillClose(c);
      }
    };

    n.onRowLayout = function (t) {
      var o = t.nativeEvent;
      n.setState({
        rowWidth: o.layout.width,
      });
    };

    n.currentOffset = function () {
      var t = n.state,
        o = t.leftWidth,
        l = undefined === o ? 0 : o,
        s = t.rowWidth,
        p = undefined === s ? 0 : s,
        u = t.rowState,
        f = n.state.rightOffset;
      return 1 === u ? l : -1 === u ? -(p - (undefined === f ? p : f)) : 0;
    };

    n.close = function () {
      n.animateRow(n.currentOffset(), 0);
    };

    n.openLeft = function () {
      var t = n.state.leftWidth,
        o = undefined === t ? 0 : t;
      n.animateRow(n.currentOffset(), o);
    };

    n.openRight = function () {
      var t = n.state.rowWidth,
        o = undefined === t ? 0 : t,
        l = n.state.rightOffset,
        s = o - (undefined === l ? o : l);
      n.animateRow(n.currentOffset(), -s);
    };

    var o = new ReactNative.Animated.Value(0);
    n.state = {
      dragX: o,
      rowTranslation: new ReactNative.Animated.Value(0),
      rowState: 0,
      leftWidth: undefined,
      rightOffset: undefined,
      rowWidth: undefined,
    };
    n.updateAnimatedEvent(t, n.state);
    n.onGestureEvent = ReactNative.Animated.event(
      [
        {
          nativeEvent: {
            translationX: o,
          },
        },
      ],
      {
        useNativeDriver: t.useNativeAnimations,
      }
    );
    return n;
  }

  module28.default(R, [
    {
      key: 'shouldComponentUpdate',
      value: function (t, n) {
        if (
          !(
            this.props.friction === t.friction &&
            this.props.overshootLeft === t.overshootLeft &&
            this.props.overshootRight === t.overshootRight &&
            this.props.overshootFriction === t.overshootFriction &&
            this.state.leftWidth === n.leftWidth &&
            this.state.rightOffset === n.rightOffset &&
            this.state.rowWidth === n.rowWidth
          )
        )
          this.updateAnimatedEvent(t, n);
        return true;
      },
    },
    {
      key: 'render',
      value: function () {
        var t = this,
          o = this.state.rowState,
          l = this.props,
          s = l.children,
          p = l.renderLeftActions,
          u = l.renderRightActions,
          f =
            p &&
            v.createElement(
              ReactNative.Animated.View,
              {
                style: [
                  L.leftActions,
                  {
                    transform: [
                      {
                        translateX: this.leftActionTranslate,
                      },
                    ],
                  },
                ],
              },
              p(this.showLeftAction, this.transX),
              v.createElement(ReactNative.View, {
                onLayout: function (n) {
                  var o = n.nativeEvent;
                  return t.setState({
                    leftWidth: o.layout.x,
                  });
                },
              })
            ),
          c =
            u &&
            v.createElement(
              ReactNative.Animated.View,
              {
                style: [
                  L.rightActions,
                  {
                    transform: [
                      {
                        translateX: this.rightActionTranslate,
                      },
                    ],
                  },
                ],
              },
              u(this.showRightAction, this.transX, this),
              v.createElement(ReactNative.View, {
                onLayout: function (n) {
                  var o = n.nativeEvent;
                  return t.setState({
                    rightOffset: o.layout.x,
                  });
                },
              })
            );
        return v.createElement(
          module612.PanGestureHandler,
          module14.default(
            {
              activeOffsetX: [-10, 10],
            },
            this.props,
            {
              onGestureEvent: this.onGestureEvent,
              onHandlerStateChange: this.onHandlerStateChange,
            }
          ),
          v.createElement(
            ReactNative.Animated.View,
            {
              onLayout: this.onRowLayout,
              style: [L.container, this.props.containerStyle],
            },
            f,
            c,
            v.createElement(
              module515.TapGestureHandler,
              {
                enabled: 0 !== o,
                onHandlerStateChange: this.onTapHandlerStateChange,
              },
              v.createElement(
                ReactNative.Animated.View,
                {
                  pointerEvents: 0 === o ? 'auto' : 'box-only',
                  style: [
                    {
                      transform: [
                        {
                          translateX: this.transX,
                        },
                      ],
                    },
                    this.props.childrenContainerStyle,
                  ],
                },
                s
              )
            )
          )
        );
      },
    },
  ]);
  return R;
})(React.Component)).defaultProps = {
  friction: 1,
  overshootFriction: 1,
  useNativeAnimations: true,
};
var L = ReactNative.StyleSheet.create({
  container: {
    overflow: 'hidden',
  },
  leftActions: A(
    A({}, ReactNative.StyleSheet.absoluteFillObject),
    {},
    {
      flexDirection: ReactNative.I18nManager.isRTL ? 'row-reverse' : 'row',
    }
  ),
  rightActions: A(
    A({}, ReactNative.StyleSheet.absoluteFillObject),
    {},
    {
      flexDirection: ReactNative.I18nManager.isRTL ? 'row' : 'row-reverse',
    }
  ),
});
