var module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module50 = require('./50'),
  module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  React = (function (t, o) {
    if (!o && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var n = P(o);
    if (n && n.has(t)) return n.get(t);
    var s = {
        __proto__: null,
      },
      u = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var l in t)
      if ('default' !== l && Object.prototype.hasOwnProperty.call(t, l)) {
        var c = u ? Object.getOwnPropertyDescriptor(t, l) : null;
        if (c && (c.get || c.set)) Object.defineProperty(s, l, c);
        else s[l] = t[l];
      }

    s.default = t;
    if (n) n.set(t, s);
    return s;
  })(require('react')),
  ReactNative = require('react-native'),
  module734 = require('./734'),
  module747 = require('./747'),
  module758 = require('./758'),
  module724 = require('./724'),
  module722 = require('./722'),
  module719 = require('./719'),
  module770 = require('./770'),
  D = ['enabled'],
  I = ['enabled', 'active'];

function P(t) {
  if ('function' != typeof WeakMap) return null;
  var o = new WeakMap(),
    n = new WeakMap();
  return (P = function (t) {
    return t ? n : o;
  })(t);
}

function E() {
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

function j(t, o) {
  var n = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var s = Object.getOwnPropertySymbols(t);
    if (o)
      s = s.filter(function (o) {
        return Object.getOwnPropertyDescriptor(t, o).enumerable;
      });
    n.push.apply(n, s);
  }

  return n;
}

function H(t) {
  for (var o = 1; o < arguments.length; o++) {
    var n = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      j(Object(n), true).forEach(function (o) {
        module50.default(t, o, n[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(n));
    else
      j(Object(n)).forEach(function (o) {
        Object.defineProperty(t, o, Object.getOwnPropertyDescriptor(n, o));
      });
  }

  return t;
}

exports.default = (function (t) {
  module38.default(R, t);

  var module56 = R,
    module734 = E(),
    S = function () {
      var t,
        o = module37.default(module56);

      if (module734) {
        var n = module37.default(this).constructor;
        t = Reflect.construct(o, arguments, n);
      } else t = o.apply(this, arguments);

      return module40.default(this, t);
    };

  function R(t) {
    var n;
    module27.default(this, R);

    (n = S.call(this, t)).handleLayout = function (t) {
      var o = t.nativeEvent.layout,
        s = o.height,
        u = o.width,
        l = {
          width: u,
          height: s,
        };
      n.setState(function (t, o) {
        return s === t.layout.height && u === t.layout.width
          ? null
          : {
              layout: l,
              headerHeights: A(o.routes, o.insets, t.descriptors, l, {}),
            };
      });
    };

    n.handleHeaderLayout = function (t) {
      var o = t.route,
        s = t.height;
      n.setState(function (t) {
        var n = t.headerHeights;
        return n[o.key] === s
          ? null
          : {
              headerHeights: H(H({}, n), {}, module50.default({}, o.key, s)),
            };
      });
    };

    n.getFocusedRoute = function () {
      var t = n.props.state;
      return t.routes[t.index];
    };

    var s = ReactNative.Dimensions.get('window'),
      u = s.height,
      l = undefined === u ? 0 : u,
      p = s.width,
      f = undefined === p ? 0 : p;
    n.state = {
      routes: [],
      scenes: [],
      gestures: {},
      layout: {
        height: l,
        width: f,
      },
      descriptors: n.props.descriptors,
      headerHeights: {},
    };
    return n;
  }

  module28.default(
    R,
    [
      {
        key: 'render',
        value: function () {
          var t = this,
            o = this.props,
            n = o.mode,
            s = o.insets,
            u = o.descriptors,
            l = o.state,
            c = o.routes,
            f = o.closingRouteKeys,
            v = o.onOpenRoute,
            S = o.onCloseRoute,
            R = o.getPreviousRoute,
            D = o.getGesturesEnabled,
            I = o.renderHeader,
            P = o.renderScene,
            E = o.headerMode,
            j = o.onTransitionStart,
            x = o.onTransitionEnd,
            A = o.onPageChangeStart,
            M = o.onPageChangeConfirm,
            T = o.onPageChangeCancel,
            L = this.state,
            V = L.scenes,
            B = L.layout,
            N = L.gestures,
            W = L.headerHeights,
            K = l.routes[l.index],
            z = u[K.key],
            G = z ? z.options : {},
            q = 'modal' === n ? module724.ModalTransition : module724.DefaultTransition;
          if ('screen' === E)
            q = H(
              H({}, q),
              {},
              {
                headerStyleInterpolator: module722.forNoAnimation,
              }
            );
          var J = G.safeAreaInsets || {},
            Q = J.top,
            U = undefined === Q ? s.top : Q,
            X = J.right,
            Y = undefined === X ? s.right : X,
            Z = J.bottom,
            $ = undefined === Z ? s.bottom : Z,
            ee = J.left,
            te = undefined === ee ? s.left : ee,
            re = 'android' === ReactNative.Platform.OS && 'modal' !== n;
          return (
            <React.Fragment>
              <C enabled={re} style={F.container} onLayout={this.handleLayout}>
                {c.map(function (o, n, u) {
                  var l = K.key === o.key,
                    c = N[o.key],
                    k = V[n],
                    O = k.progress.next
                      ? k.progress.next.interpolate({
                          inputRange: [0, 0.99, 1],
                          outputRange: [1, 1, 0],
                          extrapolate: 'clamp',
                        })
                      : 1,
                    H = k.descriptor ? k.descriptor.options : {},
                    C = H.safeAreaInsets,
                    F = H.headerShown,
                    L = H.headerTransparent,
                    z = H.cardShadowEnabled,
                    G = H.cardOverlayEnabled,
                    J = H.cardOverlay,
                    Q = H.cardStyle,
                    U = H.animationEnabled,
                    X = H.gestureResponseDistance,
                    Y = H.gestureVelocityImpact,
                    Z = H.gestureDirection,
                    $ = undefined === Z ? q.gestureDirection : Z,
                    ee = H.transitionSpec,
                    te = undefined === ee ? q.transitionSpec : ee,
                    oe = H.cardStyleInterpolator,
                    ne = undefined === oe ? (false === U ? module719.forNoAnimation : q.cardStyleInterpolator) : oe,
                    ae = H.headerStyleInterpolator,
                    ie = {
                      gestureDirection: $,
                      transitionSpec: te,
                      cardStyleInterpolator: ne,
                      headerStyleInterpolator: undefined === ae ? q.headerStyleInterpolator : ae,
                    };

                  if (n !== u.length - 1) {
                    var se = V[n + 1];

                    if (se) {
                      var ue = se.descriptor ? se.descriptor.options : {},
                        le = ue.animationEnabled,
                        de = ue.gestureDirection,
                        ce = undefined === de ? q.gestureDirection : de,
                        pe = ue.transitionSpec,
                        fe = undefined === pe ? q.transitionSpec : pe,
                        he = ue.cardStyleInterpolator,
                        ye = undefined === he ? (false === le ? module719.forNoAnimation : q.cardStyleInterpolator) : he,
                        ge = ue.headerStyleInterpolator;
                      ie = {
                        gestureDirection: ce,
                        transitionSpec: fe,
                        cardStyleInterpolator: ye,
                        headerStyleInterpolator: undefined === ge ? q.headerStyleInterpolator : ge,
                      };
                    }
                  }

                  var ve = C || {},
                    me = ve.top,
                    Se = undefined === me ? s.top : me,
                    be = ve.right,
                    ke = undefined === be ? s.right : be,
                    Oe = ve.bottom,
                    we = undefined === Oe ? s.bottom : Oe,
                    Re = ve.left,
                    De = undefined === Re ? s.left : Re,
                    Ie = R({
                      route: k.route,
                    }),
                    Pe = V[n - 1];
                  if (Ie)
                    for (var Ee = n - 1; Ee >= 0; Ee--) {
                      var je = V[Ee];

                      if (je && je.route.key === Ie.key) {
                        Pe = je;
                        break;
                      }
                    }
                  return (
                    <_ key={o.key} style={ReactNative.StyleSheet.absoluteFill} enabled={re} active={O} pointerEvents="box-none">
                      <module758.default />
                    </_>
                  );
                })}
              </C>
              {'float' === E
                ? I({
                    mode: 'float',
                    layout: B,
                    insets: {
                      top: U,
                      right: Y,
                      bottom: $,
                      left: te,
                    },
                    scenes: V,
                    getPreviousRoute: R,
                    getFocusedRoute: this.getFocusedRoute,
                    onContentHeightChange: this.handleHeaderLayout,
                    gestureDirection: undefined !== G.gestureDirection ? G.gestureDirection : q.gestureDirection,
                    styleInterpolator: undefined !== G.headerStyleInterpolator ? G.headerStyleInterpolator : q.headerStyleInterpolator,
                    style: F.floating,
                  })
                : null}
            </React.Fragment>
          );
        },
      },
    ],
    [
      {
        key: 'getDerivedStateFromProps',
        value: function (t, o) {
          if (t.routes === o.routes && t.descriptors === o.descriptors) return null;
          var n = t.routes.reduce(function (n, s) {
            var u = t.descriptors[s.key],
              l = ((null == u ? undefined : u.options) || {}).animationEnabled;
            n[s.key] = o.gestures[s.key] || new ReactNative.Animated.Value(t.openingRouteKeys.includes(s.key) && false !== l ? M(t.mode, o.layout, u) : 0);
            return n;
          }, {});
          return {
            routes: t.routes,
            scenes: t.routes.map(function (s, u, l) {
              var c = l[u - 1],
                p = l[u + 1],
                f = o.scenes[u],
                h = n[s.key],
                y = c ? n[c.key] : undefined,
                v = p ? n[p.key] : undefined,
                S = t.descriptors[s.key] || o.descriptors[s.key] || (f ? f.descriptor : x),
                b = t.descriptors[null == p ? undefined : p.key] || o.descriptors[null == p ? undefined : p.key],
                k = t.descriptors[null == c ? undefined : c.key] || o.descriptors[null == c ? undefined : c.key],
                O = {
                  route: s,
                  descriptor: S,
                  progress: {
                    current: T(t.mode, h, o.layout, S),
                    next: v ? T(t.mode, v, o.layout, b) : undefined,
                    previous: y ? T(t.mode, y, o.layout, k) : undefined,
                  },
                  __memo: [s, o.layout, S, b, k, h, v, y],
                };
              return f &&
                O.__memo.every(function (t, o) {
                  return f.__memo[o] === t;
                })
                ? f
                : O;
            }),
            gestures: n,
            descriptors: t.descriptors,
            headerHeights: A(t.routes, t.insets, o.descriptors, o.layout, o.headerHeights),
          };
        },
      },
    ]
  );
  return R;
})(React.Component);

var C = function (t) {
    var o = t.enabled,
      n = module56.default(t, D);
    return o && module734.screensEnabled() ? <module734.ScreenContainer /> : <ReactNative.View />;
  },
  _ = function (t) {
    var o = t.enabled,
      n = t.active,
      s = module56.default(t, I);
    return o && module734.screensEnabled() ? <module734.Screen /> : <ReactNative.View />;
  },
  x = Object.freeze({
    options: {},
  }),
  A = function (t, o, n, s, u) {
    return t.reduce(function (t, l) {
      var c = (n[l.key] || {}).options,
        p = undefined === c ? {} : c,
        f = ReactNative.StyleSheet.flatten(p.headerStyle || {}).height,
        h = undefined === f ? u[l.key] : f,
        v = H(H({}, o), p.safeAreaInsets),
        b = p.headerStatusBarHeight,
        k = undefined === b ? v.top : b;
      t[l.key] = 'number' == typeof h ? h : module747.getDefaultHeaderHeight(s, k);
      return t;
    }, {});
  },
  M = function (t, o, n) {
    var s = ((null == n ? undefined : n.options) || {}).gestureDirection,
      u = undefined === s ? ('modal' === t ? module724.ModalTransition.gestureDirection : module724.DefaultTransition.gestureDirection) : s;
    return module770.default(o, u);
  },
  T = function (t, o, n, s) {
    var u = M(
      t,
      {
        width: 1 ** n.width,
        height: 1 ** n.height,
      },
      s
    );
    return u > 0
      ? o.interpolate({
          inputRange: [0, u],
          outputRange: [1, 0],
        })
      : o.interpolate({
          inputRange: [u, 0],
          outputRange: [0, 1],
        });
  },
  F = ReactNative.StyleSheet.create({
    container: {
      flex: 1,
      overflow: 'hidden',
    },
    floating: {
      position: 'absolute',
      top: 0,
      left: 0,
      right: 0,
    },
  });
