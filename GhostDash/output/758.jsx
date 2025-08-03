var module15 = require('@babel/runtime/helpers/slicedToArray'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = f(n);
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
  module649 = require('./649'),
  module759 = require('./759'),
  module772 = require('./772');

function f(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (f = function (t) {
    return t ? o : n;
  })(t);
}

var p = 0.1;
exports.default = React.memo(function (t) {
  var f = t.active,
    y = t.cardOverlay,
    h = t.cardOverlayEnabled,
    b = t.cardShadowEnabled,
    S = t.cardStyle,
    E = t.cardStyleInterpolator,
    x = t.closing,
    O = t.gesture,
    C = t.focused,
    P = t.gestureDirection,
    w = t.gestureEnabled,
    I = t.gestureResponseDistance,
    _ = t.gestureVelocityImpact,
    R = t.getPreviousRoute,
    D = t.getFocusedRoute,
    j = t.headerMode,
    T = t.headerShown,
    H = t.headerStyleInterpolator,
    M = t.headerTransparent,
    k = t.headerHeight,
    A = t.onHeaderHeightChange,
    L = t.index,
    F = t.layout,
    V = t.onCloseRoute,
    W = t.onOpenRoute,
    B = t.onPageChangeCancel,
    G = t.onPageChangeConfirm,
    q = t.onPageChangeStart,
    z = t.onTransitionEnd,
    J = t.onTransitionStart,
    K = t.previousScene,
    N = t.renderHeader,
    Q = t.renderScene,
    U = t.safeAreaInsetBottom,
    X = t.safeAreaInsetLeft,
    Y = t.safeAreaInsetRight,
    Z = t.safeAreaInsetTop,
    $ = t.scene,
    ee = t.transitionSpec;
  React.useEffect(
    function () {
      if (!(null == G)) G();
    },
    [f, G]
  );
  var te = {
      top: Z,
      right: Y,
      bottom: U,
      left: X,
    },
    ne = module649.useTheme().colors,
    re = React.useState('box-none'),
    oe = module15.default(re, 2),
    ae = oe[0],
    le = oe[1];
  React.useEffect(
    function () {
      var t,
        n =
          null == (t = $.progress.next)
            ? undefined
            : null == t.addListener
            ? undefined
            : t.addListener(function (t) {
                var n = t.value;
                le(n <= p ? 'box-none' : 'none');
              });
      return function () {
        var t;
        if (n) null == (t = $.progress.next) || null == t.removeListener || t.removeListener(n);
      };
    },
    [ae, $.progress.next]
  );
  return (
    <module759.default
      index={L}
      gestureDirection={P}
      layout={F}
      insets={te}
      gesture={O}
      current={$.progress.current}
      next={$.progress.next}
      closing={x}
      onOpen={function () {
        if (!(null == z))
          z(
            {
              route: $.route,
            },
            false
          );
        W({
          route: $.route,
        });
      }}
      onClose={function () {
        if (!(null == z))
          z(
            {
              route: $.route,
            },
            true
          );
        V({
          route: $.route,
        });
      }}
      overlay={y}
      overlayEnabled={h}
      shadowEnabled={b}
      onTransitionStart={function (t) {
        var n = t.closing;
        if (f && n) {
          if (!(null == G)) G();
        } else if (!(null == B)) B();
        if (!(null == J))
          J(
            {
              route: $.route,
            },
            n
          );
      }}
      onGestureBegin={q}
      onGestureCanceled={B}
      gestureEnabled={w}
      gestureResponseDistance={I}
      gestureVelocityImpact={_}
      transitionSpec={ee}
      styleInterpolator={E}
      accessibilityElementsHidden={!C}
      importantForAccessibility={C ? 'auto' : 'no-hide-descendants'}
      pointerEvents={f ? 'box-none' : ae}
      containerStyle={
        'float' !== j || M || false === T
          ? null
          : {
              marginTop: k,
            }
      }
      contentStyle={[
        {
          backgroundColor: ne.background,
        },
        S,
      ]}
      style={ReactNative.StyleSheet.absoluteFill}
    >
      <ReactNative.View style={v.container}>
        <ReactNative.View style={v.scene}>
          {React.createElement(
            module772.default.Provider,
            {
              value: k,
            },
            Q({
              route: $.route,
            })
          )}
        </ReactNative.View>
        {'screen' === j
          ? N({
              mode: 'screen',
              layout: F,
              insets: te,
              scenes: [K, $],
              getPreviousRoute: R,
              getFocusedRoute: D,
              gestureDirection: P,
              styleInterpolator: H,
              onContentHeightChange: A,
            })
          : null}
      </ReactNative.View>
    </module759.default>
  );
});
var v = ReactNative.StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: 'column-reverse',
  },
  scene: {
    flex: 1,
  },
});
