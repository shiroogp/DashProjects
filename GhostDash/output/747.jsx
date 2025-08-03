var module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  React = (function (t, o) {
    if (!o && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var n = S(o);
    if (n && n.has(t)) return n.get(t);
    var l = {
        __proto__: null,
      },
      u = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var h in t)
      if ('default' !== h && Object.prototype.hasOwnProperty.call(t, h)) {
        var s = u ? Object.getOwnPropertyDescriptor(t, h) : null;
        if (s && (s.get || s.set)) Object.defineProperty(l, h, s);
        else l[h] = t[h];
      }

    l.default = t;
    if (n) n.set(t, l);
    return l;
  })(require('react')),
  ReactNative = require('react-native'),
  module748 = require('./748'),
  module756 = require('./756'),
  module757 = require('./757'),
  R = [
    'height',
    'minHeight',
    'maxHeight',
    'backgroundColor',
    'borderBottomColor',
    'borderBottomEndRadius',
    'borderBottomLeftRadius',
    'borderBottomRightRadius',
    'borderBottomStartRadius',
    'borderBottomWidth',
    'borderColor',
    'borderEndColor',
    'borderEndWidth',
    'borderLeftColor',
    'borderLeftWidth',
    'borderRadius',
    'borderRightColor',
    'borderRightWidth',
    'borderStartColor',
    'borderStartWidth',
    'borderStyle',
    'borderTopColor',
    'borderTopEndRadius',
    'borderTopLeftRadius',
    'borderTopRightRadius',
    'borderTopStartRadius',
    'borderTopWidth',
    'borderWidth',
    'boxShadow',
    'elevation',
    'shadowColor',
    'shadowOffset',
    'shadowOpacity',
    'shadowRadius',
    'opacity',
    'transform',
  ];

function S(t) {
  if ('function' != typeof WeakMap) return null;
  var o = new WeakMap(),
    n = new WeakMap();
  return (S = function (t) {
    return t ? n : o;
  })(t);
}

function v() {
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

exports.default = (function (t, ...args) {
  module38.default(T, t);

  var S = T,
    L = v(),
    B = function () {
      var t,
        o = module37.default(S);

      if (L) {
        var n = module37.default(this).constructor;
        t = Reflect.construct(o, arguments, n);
      } else t = o.apply(this, arguments);

      return module40.default(this, t);
    };

  function T() {
    var t;
    module27.default(this, T);
    (t = B.call(this, ...args)).state = {};

    t.handleTitleLayout = function (o) {
      var n = o.nativeEvent.layout,
        l = n.height,
        u = n.width;
      t.setState(function (t) {
        var o = t.titleLayout;
        return o && l === o.height && u === o.width
          ? null
          : {
              titleLayout: {
                height: l,
                width: u,
              },
            };
      });
    };

    t.handleLeftLabelLayout = function (o) {
      var n = o.nativeEvent.layout,
        l = n.height,
        u = n.width,
        h = t.state.leftLabelLayout;
      if (!(h && l === h.height && u === h.width))
        t.setState({
          leftLabelLayout: {
            height: l,
            width: u,
          },
        });
    };

    t.getInterpolatedStyle = module757.default(function (t, o, n, l, u, h, s) {
      return t({
        current: {
          progress: n,
        },
        next: l && {
          progress: l,
        },
        layouts: {
          header: {
            height: s,
            width: o.width,
          },
          screen: o,
          title: u,
          leftLabel: h,
        },
      });
    });
    return t;
  }

  module28.default(T, [
    {
      key: 'render',
      value: function () {
        module56.default(Y, R);
        var t = this.props,
          n = t.scene,
          l = t.layout,
          u = t.insets,
          h = t.title,
          s = t.leftLabel,
          p = t.onGoBack,
          S = t.headerTitle,
          v = t.headerTitleAlign,
          L =
            undefined === v
              ? ReactNative.Platform.select({
                  ios: 'center',
                  default: 'left',
                })
              : v,
          B = t.headerLeft,
          T =
            undefined === B
              ? p
                ? function (t) {
                    return <module748.default />;
                  }
                : undefined
              : B,
          E = t.headerTransparent,
          W = t.headerTintColor,
          k = t.headerBackground,
          x = t.headerRight,
          O = t.headerBackImage,
          P = t.headerBackTitle,
          H = t.headerBackTitleVisible,
          A = t.headerTruncatedBackTitle,
          j = t.headerPressColorAndroid,
          _ = t.headerBackAllowFontScaling,
          V = t.headerTitleAllowFontScaling,
          I = t.headerTitleStyle,
          F = t.headerBackTitleStyle,
          D = t.headerLeftContainerStyle,
          M = t.headerRightContainerStyle,
          G = t.headerTitleContainerStyle,
          z = t.headerStyle,
          q = t.headerStatusBarHeight,
          J = undefined === q ? u.top : q,
          K = t.styleInterpolator,
          N = this.state,
          Q = N.leftLabelLayout,
          U = N.titleLayout,
          X = w(l, J),
          Y = ReactNative.StyleSheet.flatten(z || {}),
          Z = Y.height,
          $ = undefined === Z ? X : Z,
          ee = Y.minHeight,
          te = Y.maxHeight,
          oe = Y.backgroundColor,
          re = Y.borderBottomColor,
          ae = Y.borderBottomEndRadius,
          ie = Y.borderBottomLeftRadius,
          de = Y.borderBottomRightRadius,
          ne = Y.borderBottomStartRadius,
          le = Y.borderBottomWidth,
          ue = Y.borderColor,
          he = Y.borderEndColor,
          se = Y.borderEndWidth,
          fe = Y.borderLeftColor,
          be = Y.borderLeftWidth,
          ce = Y.borderRadius,
          ye = Y.borderRightColor,
          pe = Y.borderRightWidth,
          ge = Y.borderStartColor,
          me = Y.borderStartWidth,
          Re = Y.borderStyle,
          Se = Y.borderTopColor,
          ve = Y.borderTopEndRadius,
          we = Y.borderTopLeftRadius,
          Ce = Y.borderTopRightRadius,
          Le = Y.borderTopStartRadius,
          Be = Y.borderTopWidth,
          Te = Y.borderWidth,
          Ee = Y.boxShadow,
          We = Y.elevation,
          ke = Y.shadowColor,
          xe = Y.shadowOffset,
          Oe = Y.shadowOpacity,
          Pe = Y.shadowRadius,
          He = Y.opacity,
          Ae = Y.transform,
          je = {
            backgroundColor: oe,
            borderBottomColor: re,
            borderBottomEndRadius: ae,
            borderBottomLeftRadius: ie,
            borderBottomRightRadius: de,
            borderBottomStartRadius: ne,
            borderBottomWidth: le,
            borderColor: ue,
            borderEndColor: he,
            borderEndWidth: se,
            borderLeftColor: fe,
            borderLeftWidth: be,
            borderRadius: ce,
            borderRightColor: ye,
            borderRightWidth: pe,
            borderStartColor: ge,
            borderStartWidth: me,
            borderStyle: Re,
            borderTopColor: Se,
            borderTopEndRadius: ve,
            borderTopLeftRadius: we,
            borderTopRightRadius: Ce,
            borderTopStartRadius: Le,
            borderTopWidth: Be,
            borderWidth: Te,
            boxShadow: Ee,
            elevation: We,
            shadowColor: ke,
            shadowOffset: xe,
            shadowOpacity: Oe,
            shadowRadius: Pe,
            opacity: He,
            transform: Ae,
          };

        for (var _e in je) undefined === je[_e] && delete je[_e];

        var Ve = this.getInterpolatedStyle(K, l, n.progress.current, n.progress.next, U, s ? Q : undefined, 'number' == typeof $ ? $ : X),
          Ie = Ve.titleStyle,
          Fe = Ve.leftButtonStyle,
          De = Ve.leftLabelStyle,
          Me = Ve.rightButtonStyle,
          Ge = Ve.backgroundStyle,
          ze = T
            ? T({
                backImage: O,
                pressColorAndroid: j,
                allowFontScaling: _,
                onPress: p,
                labelVisible: H,
                label: undefined !== P ? P : s,
                truncatedLabel: A,
                labelStyle: [De, F],
                onLabelLayout: this.handleLeftLabelLayout,
                screenLayout: l,
                titleLayout: U,
                tintColor: W,
                canGoBack: Boolean(p),
              })
            : null;
        return (
          <React.Fragment>
            {React.createElement(
              ReactNative.Animated.View,
              {
                pointerEvents: 'none',
                style: [ReactNative.StyleSheet.absoluteFill, Ge],
              },
              k
                ? k({
                    style: je,
                  })
                : E
                ? null
                : React.createElement(module756.default, {
                    style: je,
                  })
            )}
            {React.createElement(
              ReactNative.Animated.View,
              {
                pointerEvents: 'box-none',
                style: [
                  {
                    height: $,
                    minHeight: ee,
                    maxHeight: te,
                    opacity: He,
                    transform: Ae,
                  },
                ],
              },
              React.createElement(ReactNative.View, {
                pointerEvents: 'none',
                style: {
                  height: J,
                },
              }),
              React.createElement(
                ReactNative.View,
                {
                  pointerEvents: 'box-none',
                  style: C.content,
                },
                ze
                  ? React.createElement(
                      ReactNative.Animated.View,
                      {
                        pointerEvents: 'box-none',
                        style: [
                          C.left,
                          {
                            left: u.left,
                          },
                          Fe,
                          D,
                        ],
                      },
                      ze
                    )
                  : null,
                React.createElement(
                  ReactNative.Animated.View,
                  {
                    pointerEvents: 'box-none',
                    style: [
                      'left' === L
                        ? {
                            position: 'absolute',
                            left: ze ? 72 : 16,
                          }
                        : {
                            marginHorizontal: 18,
                          },
                      Ie,
                      G,
                    ],
                  },
                  S({
                    children: h,
                    onLayout: this.handleTitleLayout,
                    allowFontScaling: V,
                    tintColor: W,
                    style: I,
                  })
                ),
                x
                  ? React.createElement(
                      ReactNative.Animated.View,
                      {
                        pointerEvents: 'box-none',
                        style: [
                          C.right,
                          {
                            right: u.right,
                          },
                          Me,
                          M,
                        ],
                      },
                      x({
                        tintColor: W,
                      })
                    )
                  : null
              )
            )}
          </React.Fragment>
        );
      },
    },
  ]);
  return T;
})(React.Component);

var w = (exports.getDefaultHeaderHeight = function (t, o) {
    var n = t.width > t.height;
    return ('ios' === ReactNative.Platform.OS ? (n && !ReactNative.Platform.isPad ? 32 : 44) : 'android' === ReactNative.Platform.OS ? 56 : 64) + o;
  }),
  C = ReactNative.StyleSheet.create({
    content: {
      flex: 1,
      flexDirection: 'row',
      alignItems: 'center',
      justifyContent: 'center',
    },
    left: {
      position: 'absolute',
      left: 0,
      top: 0,
      bottom: 0,
      justifyContent: 'center',
      alignItems: 'flex-start',
    },
    right: {
      position: 'absolute',
      right: 0,
      top: 0,
      bottom: 0,
      justifyContent: 'center',
      alignItems: 'flex-end',
    },
  });
