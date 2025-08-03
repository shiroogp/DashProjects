var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module50 = require('./50'),
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
    var o = D(n);
    if (o && o.has(t)) return o.get(t);
    var l = {
        __proto__: null,
      },
      s = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var c in t)
      if ('default' !== c && Object.prototype.hasOwnProperty.call(t, c)) {
        var u = s ? Object.getOwnPropertyDescriptor(t, c) : null;
        if (u && (u.get || u.set)) Object.defineProperty(l, c, u);
        else l[c] = t[c];
      }

    l.default = t;
    if (o) o.set(t, l);
    return l;
  })(require('react')),
  ReactNative = require('react-native'),
  module2 = require('./2'),
  module760 = require('./760'),
  module768 = require('./768'),
  module769 = require('./769'),
  module770 = require('./770'),
  module771 = require('./771'),
  module757 = require('./757'),
  C = [
    'styleInterpolator',
    'index',
    'current',
    'gesture',
    'next',
    'layout',
    'insets',
    'overlay',
    'overlayEnabled',
    'shadowEnabled',
    'gestureEnabled',
    'gestureDirection',
    'children',
    'containerStyle',
    'contentStyle',
  ];

function D(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (D = function (t) {
    return t ? o : n;
  })(t);
}

function P(t, n) {
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
    var o = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      P(Object(o), true).forEach(function (n) {
        module50.default(t, n, o[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(o));
    else
      P(Object(o)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(o, n));
      });
  }

  return t;
}

function x() {
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

var j = 1,
  I = 0,
  k = 'web' !== ReactNative.Platform.OS;
(exports.default = (function (t, ...args) {
  module38.default(H, t);

  var module50 = H,
    D = x(),
    P = function () {
      var t,
        n = module37.default(module50);

      if (D) {
        var o = module37.default(this).constructor;
        t = Reflect.construct(n, arguments, o);
      } else t = n.apply(this, arguments);

      return module40.default(this, t);
    };

  function H() {
    var t;
    module27.default(this, H);
    (t = P.call(this, ...args)).isClosing = new ReactNative.Animated.Value(I);
    t.inverted = new ReactNative.Animated.Value(module771.default(t.props.gestureDirection));
    t.layout = {
      width: new ReactNative.Animated.Value(t.props.layout.width),
      height: new ReactNative.Animated.Value(t.props.layout.height),
    };
    t.isSwiping = new ReactNative.Animated.Value(I);

    t.animate = function (n) {
      var o = n.closing,
        l = n.velocity,
        s = t.props,
        c = s.gesture,
        u = s.transitionSpec,
        f = s.onOpen,
        h = s.onClose,
        p = s.onTransitionStart,
        y = t.getAnimateToValue(
          A(
            A({}, t.props),
            {},
            {
              closing: o,
            }
          )
        ),
        w = o ? u.close : u.open,
        b = 'spring' === w.animation ? ReactNative.Animated.spring : ReactNative.Animated.timing;
      t.setPointerEventsEnabled(!o);
      t.handleStartInteraction();
      clearTimeout(t.pendingGestureCallback);
      if (!(null == p))
        p({
          closing: o,
        });
      b(
        c,
        A(
          A({}, w.config),
          {},
          {
            velocity: l,
            toValue: y,
            useNativeDriver: k,
            isInteraction: false,
          }
        )
      ).start(function (n) {
        var l = n.finished;
        t.handleEndInteraction();
        clearTimeout(t.pendingGestureCallback);
        if (l) o ? h() : f();
      });
    };

    t.getAnimateToValue = function (t) {
      var n = t.closing,
        o = t.layout,
        l = t.gestureDirection;
      return n ? module770.default(o, l) : 0;
    };

    t.setPointerEventsEnabled = function (n) {
      var o,
        l = n ? 'box-none' : 'none';
      if (!(null == (o = t.contentRef.current)))
        o.setNativeProps({
          pointerEvents: l,
        });
    };

    t.handleStartInteraction = function () {
      if (undefined === t.interactionHandle) t.interactionHandle = ReactNative.InteractionManager.createInteractionHandle();
    };

    t.handleEndInteraction = function () {
      if (undefined !== t.interactionHandle) {
        ReactNative.InteractionManager.clearInteractionHandle(t.interactionHandle);
        t.interactionHandle = undefined;
      }
    };

    t.handleGestureStateChange = function (n) {
      var o = n.nativeEvent,
        l = t.props,
        s = l.layout,
        c = l.onClose,
        u = l.onGestureBegin,
        f = l.onGestureCanceled,
        h = l.onGestureEnd,
        p = l.gestureDirection,
        v = l.gestureVelocityImpact;

      switch (o.state) {
        case module2.State.BEGAN:
          t.isSwiping.setValue(j);
          t.handleStartInteraction();
          if (!(null == u)) u();
          break;

        case module2.State.CANCELLED:
          t.isSwiping.setValue(I);
          t.handleEndInteraction();
          var w = 'vertical' === p || 'vertical-inverted' === p ? o.velocityY : o.velocityX;
          t.animate({
            closing: t.props.closing,
            velocity: w,
          });
          if (!(null == f)) f();
          break;

        case module2.State.END:
          var b, E, S;
          t.isSwiping.setValue(I);

          if ('vertical' === p || 'vertical-inverted' === p) {
            b = s.height;
            E = o.translationY;
            S = o.velocityY;
          } else {
            b = s.width;
            E = o.translationX;
            S = o.velocityX;
          }

          var V = (E + S * v) * module771.default(p) > b / 2 && (0 !== S || 0 !== E);
          t.animate({
            closing: V,
            velocity: S,
          });
          if (V) t.pendingGestureCallback = setTimeout(c, 32);
          if (!(null == h)) h();
      }
    };

    t.getInterpolatedStyle = module757.default(function (n, o, l, s, c, u, f, h, p) {
      return n({
        index: o,
        current: {
          progress: l,
        },
        next: s && {
          progress: s,
        },
        closing: t.isClosing,
        swiping: t.isSwiping,
        inverted: t.inverted,
        layouts: {
          screen: c,
        },
        insets: {
          top: u,
          right: f,
          bottom: h,
          left: p,
        },
      });
    });
    t.getCardAnimationContext = module757.default(function (n, o, l, s, c, u, f, h) {
      return {
        index: n,
        current: {
          progress: o,
        },
        next: l && {
          progress: l,
        },
        closing: t.isClosing,
        swiping: t.isSwiping,
        inverted: t.inverted,
        layouts: {
          screen: s,
        },
        insets: {
          top: c,
          right: u,
          bottom: f,
          left: h,
        },
      };
    });
    t.gestureRef = React.createRef();
    t.contentRef = React.createRef();
    return t;
  }

  module28.default(H, [
    {
      key: 'componentDidMount',
      value: function () {
        this.animate({
          closing: this.props.closing,
        });
      },
    },
    {
      key: 'componentDidUpdate',
      value: function (t) {
        var n = this.props,
          o = n.layout,
          l = n.gestureDirection,
          s = n.closing,
          c = o.width,
          u = o.height;
        if (c !== t.layout.width) this.layout.width.setValue(c);
        if (u !== t.layout.height) this.layout.height.setValue(u);
        if (l !== t.gestureDirection) this.inverted.setValue(module771.default(l));
        if (this.getAnimateToValue(this.props) !== this.getAnimateToValue(t))
          this.animate({
            closing: s,
          });
      },
    },
    {
      key: 'componentWillUnmount',
      value: function () {
        this.handleEndInteraction();
      },
    },
    {
      key: 'gestureActivationCriteria',
      value: function () {
        var t = this.props,
          n = t.layout,
          o = t.gestureDirection,
          l = t.gestureResponseDistance,
          s =
            'vertical' === o || 'vertical-inverted' === o
              ? undefined !== (null == l ? undefined : l.vertical)
                ? l.vertical
                : 135
              : undefined !== (null == l ? undefined : l.horizontal)
              ? l.horizontal
              : 50;
        if ('vertical' === o)
          return {
            maxDeltaX: 15,
            minOffsetY: 5,
            hitSlop: {
              bottom: -n.height + s,
            },
          };
        if ('vertical-inverted' === o)
          return {
            maxDeltaX: 15,
            minOffsetY: -5,
            hitSlop: {
              top: -n.height + s,
            },
          };
        var c = -n.width + s;
        return 1 === module771.default(o)
          ? {
              minOffsetX: 5,
              maxDeltaY: 20,
              hitSlop: {
                right: c,
              },
            }
          : {
              minOffsetX: -5,
              maxDeltaY: 20,
              hitSlop: {
                left: c,
              },
            };
      },
    },
    {
      key: 'render',
      value: function () {
        var t = this.props,
          l = t.styleInterpolator,
          s = t.index,
          c = t.current,
          u = t.gesture,
          f = t.next,
          h = t.layout,
          S = t.insets,
          O = t.overlay,
          V = t.overlayEnabled,
          D = t.shadowEnabled,
          P = t.gestureEnabled,
          A = t.gestureDirection,
          x = t.children,
          j = t.containerStyle,
          I = t.contentStyle,
          H = module56.default(t, C),
          G = this.getInterpolatedStyle(l, s, c, f, h, S.top, S.right, S.bottom, S.left),
          T = this.getCardAnimationContext(s, c, f, h, S.top, S.right, S.bottom, S.left),
          _ = G.containerStyle,
          M = G.cardStyle,
          X = G.overlayStyle,
          Y = G.shadowStyle,
          z = P
            ? ReactNative.Animated.event(
                [
                  {
                    nativeEvent:
                      'vertical' === A || 'vertical-inverted' === A
                        ? {
                            translationY: u,
                          }
                        : {
                            translationX: u,
                          },
                  },
                ],
                {
                  useNativeDriver: k,
                }
              )
            : undefined,
          B = ReactNative.StyleSheet.flatten(I || {}).backgroundColor,
          N = !!B && 0 === module760.default(B).alpha();
        return React.createElement(
          module769.default.Provider,
          {
            value: T,
          },
          React.createElement(
            ReactNative.View,
            module14.default(
              {
                pointerEvents: 'box-none',
              },
              H
            ),
            V
              ? React.createElement(
                  ReactNative.View,
                  {
                    pointerEvents: 'box-none',
                    style: ReactNative.StyleSheet.absoluteFill,
                  },
                  O({
                    style: X,
                  })
                )
              : null,
            React.createElement(
              ReactNative.Animated.View,
              {
                style: [R.container, _, j],
                pointerEvents: 'box-none',
              },
              React.createElement(
                module2.PanGestureHandler,
                module14.default(
                  {
                    ref: this.gestureRef,
                    enabled: 0 !== h.width && P,
                    onGestureEvent: z,
                    onHandlerStateChange: this.handleGestureStateChange,
                  },
                  this.gestureActivationCriteria()
                ),
                React.createElement(
                  ReactNative.Animated.View,
                  {
                    style: [R.container, M],
                  },
                  D && Y && !N
                    ? React.createElement(ReactNative.Animated.View, {
                        style: [
                          R.shadow,
                          'horizontal' === A
                            ? [R.shadowHorizontal, R.shadowLeft]
                            : 'horizontal-inverted' === A
                            ? [R.shadowHorizontal, R.shadowRight]
                            : 'vertical' === A
                            ? [R.shadowVertical, R.shadowTop]
                            : [R.shadowVertical, R.shadowBottom],
                          {
                            backgroundColor: B,
                          },
                          Y,
                        ],
                        pointerEvents: 'none',
                      })
                    : null,
                  React.createElement(
                    ReactNative.View,
                    {
                      ref: this.contentRef,
                      style: [R.content, I],
                    },
                    React.createElement(
                      module768.default.Provider,
                      {
                        value: this.gestureRef,
                      },
                      x
                    )
                  )
                )
              )
            )
          )
        );
      },
    },
  ]);
  return H;
})(React.Component)).defaultProps = {
  overlayEnabled: 'ios' !== ReactNative.Platform.OS,
  shadowEnabled: true,
  gestureEnabled: true,
  gestureVelocityImpact: 0.3,
  overlay: function (t) {
    var n = t.style;
    return n
      ? React.createElement(ReactNative.Animated.View, {
          pointerEvents: 'none',
          style: [R.overlay, n],
        })
      : null;
  },
};
var R = ReactNative.StyleSheet.create({
  container: {
    flex: 1,
  },
  content: {
    flex: 1,
    overflow: 'hidden',
  },
  overlay: {
    flex: 1,
    backgroundColor: '#000',
  },
  shadow: {
    position: 'absolute',
    shadowRadius: 5,
    shadowColor: '#000',
    shadowOpacity: 0.3,
  },
  shadowHorizontal: {
    top: 0,
    bottom: 0,
    width: 3,
    shadowOffset: {
      width: -1,
      height: 1,
    },
  },
  shadowLeft: {
    left: 0,
  },
  shadowRight: {
    right: 0,
  },
  shadowVertical: {
    left: 0,
    right: 0,
    height: 3,
    shadowOffset: {
      width: 1,
      height: -1,
    },
  },
  shadowTop: {
    top: 0,
  },
  shadowBottom: {
    bottom: 0,
  },
});
