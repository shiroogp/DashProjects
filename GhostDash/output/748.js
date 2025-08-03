exports.default = function (t) {
  var n = t.disabled,
    b = t.allowFontScaling,
    y = t.backImage,
    v = t.label,
    O = t.labelStyle,
    h = t.labelVisible,
    w = undefined === h ? 'ios' === ReactNative.Platform.OS : h,
    P = t.onLabelLayout,
    j = t.onPress,
    k = t.pressColorAndroid,
    M = t.screenLayout,
    L = t.tintColor,
    S = t.titleLayout,
    E = t.truncatedLabel,
    D = undefined === E ? 'Back' : E,
    C = t.accessibilityLabel,
    I = undefined === C ? (v && 'Back' !== v ? v + ', back' : 'Go back') : C,
    _ = module649.useTheme(),
    x = _.dark,
    R = _.colors,
    W = React.useState(undefined),
    T = module15.default(W, 2),
    V = T[0],
    F = T[1],
    z =
      undefined !== L
        ? L
        : ReactNative.Platform.select({
            ios: R.primary,
            default: R.text,
          }),
    B = undefined !== k ? k : x ? 'rgba(255, 255, 255, .32)' : 'rgba(0, 0, 0, .32)',
    A = function (t) {
      if (!(null == P)) P(t);
      F(t.nativeEvent.layout.x + t.nativeEvent.layout.width);
    },
    X = function () {
      return !v || (V && S && M && (M.width - S.width) / 2 < V + 26);
    };

  return React.createElement(
    module752.default,
    {
      disabled: n,
      accessible: true,
      accessibilityRole: 'button',
      accessibilityComponentType: 'button',
      accessibilityLabel: I,
      accessibilityTraits: 'button',
      testID: 'header-back',
      delayPressIn: 0,
      onPress: n
        ? undefined
        : function () {
            return j && requestAnimationFrame(j);
          },
      pressColor: B,
      style: [p.container, n && p.disabled],
      hitSlop: ReactNative.Platform.select({
        ios: undefined,
        default: {
          top: 16,
          right: 16,
          bottom: 16,
          left: 16,
        },
      }),
      borderless: true,
    },
    React.createElement(
      React.Fragment,
      null,
      y
        ? y({
            tintColor: z,
          })
        : React.createElement(ReactNative.Image, {
            style: [
              p.icon,
              Boolean(w) && p.iconWithLabel,
              Boolean(z) && {
                tintColor: z,
              },
            ],
            source: require('./754'),
            fadeDuration: 0,
          }),
      (function () {
        var t = X() ? D : v;
        if (!w || undefined === t) return null;
        var n = React.createElement(
          ReactNative.View,
          {
            style: M
              ? [
                  p.labelWrapper,
                  {
                    minWidth: M.width / 2 - 27,
                  },
                ]
              : null,
          },
          React.createElement(
            ReactNative.Animated.Text,
            {
              accessible: false,
              onLayout: t === v ? A : undefined,
              style: [
                p.label,
                z
                  ? {
                      color: z,
                    }
                  : null,
                O,
              ],
              numberOfLines: 1,
              allowFontScaling: !!b,
            },
            t
          )
        );
        if (y || 'ios' !== ReactNative.Platform.OS) return n;
        return React.createElement(
          module749.default,
          {
            maskElement: React.createElement(
              ReactNative.View,
              {
                style: p.iconMaskContainer,
              },
              React.createElement(ReactNative.Image, {
                source: require('./755'),
                style: p.iconMask,
              }),
              React.createElement(ReactNative.View, {
                style: p.iconMaskFillerRect,
              })
            ),
          },
          n
        );
      })()
    )
  );
};

var module50 = require('./50'),
  module15 = require('@babel/runtime/helpers/slicedToArray'),
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
      c = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var s in t)
      if ('default' !== s && Object.prototype.hasOwnProperty.call(t, s)) {
        var u = c ? Object.getOwnPropertyDescriptor(t, s) : null;
        if (u && (u.get || u.set)) Object.defineProperty(l, s, u);
        else l[s] = t[s];
      }

    l.default = t;
    if (o) o.set(t, l);
    return l;
  })(require('react')),
  ReactNative = require('react-native'),
  module649 = require('./649'),
  module749 = require('./749'),
  module752 = require('./752');

function b(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (b = function (t) {
    return t ? o : n;
  })(t);
}

function y(t, n) {
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

var p = ReactNative.StyleSheet.create({
  container: (function (t) {
    for (var o = 1; o < arguments.length; o++) {
      var l = null != arguments[o] ? arguments[o] : {};
      if (o % 2)
        y(Object(l), true).forEach(function (o) {
          module50.default(t, o, l[o]);
        });
      else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(l));
      else
        y(Object(l)).forEach(function (n) {
          Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(l, n));
        });
    }

    return t;
  })(
    {
      alignItems: 'center',
      flexDirection: 'row',
    },
    ReactNative.Platform.select({
      ios: null,
      default: {
        marginVertical: 3,
        marginHorizontal: 11,
      },
    })
  ),
  disabled: {
    opacity: 0.5,
  },
  label: {
    fontSize: 17,
    letterSpacing: 0.35,
  },
  labelWrapper: {
    flexDirection: 'row',
    alignItems: 'flex-start',
  },
  icon: ReactNative.Platform.select({
    ios: {
      height: 21,
      width: 13,
      marginLeft: 8,
      marginRight: 22,
      marginVertical: 12,
      resizeMode: 'contain',
      transform: [
        {
          scaleX: ReactNative.I18nManager.isRTL ? -1 : 1,
        },
      ],
    },
    default: {
      height: 24,
      width: 24,
      margin: 3,
      resizeMode: 'contain',
      transform: [
        {
          scaleX: ReactNative.I18nManager.isRTL ? -1 : 1,
        },
      ],
    },
  }),
  iconWithLabel:
    'ios' === ReactNative.Platform.OS
      ? {
          marginRight: 6,
        }
      : {},
  iconMaskContainer: {
    flex: 1,
    flexDirection: 'row',
    justifyContent: 'center',
  },
  iconMaskFillerRect: {
    flex: 1,
    backgroundColor: '#000',
  },
  iconMask: {
    height: 21,
    width: 13,
    marginLeft: -14.5,
    marginVertical: 12,
    alignSelf: 'center',
    resizeMode: 'contain',
    transform: [
      {
        scaleX: ReactNative.I18nManager.isRTL ? -1 : 1,
      },
    ],
  },
});
