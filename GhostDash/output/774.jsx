exports.default = function (t) {
  var c = t.mode,
    p = t.scenes,
    v = t.layout,
    y = t.insets,
    h = t.getFocusedRoute,
    b = t.getPreviousRoute,
    k = t.onContentHeightChange,
    w = t.gestureDirection,
    _ = t.styleInterpolator,
    E = t.style,
    O = h();
  return (
    <ReactNative.View pointerEvents="box-none" style={E}>
      {p.slice(-3).map(function (t, p, h) {
        if (('screen' === c && p !== h.length - 1) || !t) return null;
        var E,
          P = t.descriptor.options,
          S = O.key === t.route.key,
          j = b({
            route: t.route,
          });
        if (j)
          for (var M = p - 1; M >= 0; M--) {
            var x = h[M];

            if (x && x.route.key === j.key) {
              E = x;
              break;
            }
          }
        var C = h[p - 1],
          R = h[p + 1],
          D = (C && false === C.descriptor.options.headerShown && !R) || (R && false === R.descriptor.options.headerShown),
          N = {
            mode: c,
            layout: v,
            insets: y,
            scene: t,
            previous: E,
            navigation: t.descriptor.navigation,
            styleInterpolator:
              'float' === c
                ? D
                  ? 'vertical' === w || 'vertical-inverted' === w
                    ? module722.forSlideUp
                    : 'horizontal-inverted' === w
                    ? module722.forSlideRight
                    : module722.forSlideLeft
                  : _
                : module722.forNoAnimation,
          };
        return React.createElement(
          module649.NavigationContext.Provider,
          {
            key: t.route.key,
            value: t.descriptor.navigation,
          },
          React.createElement(
            module649.NavigationRouteContext.Provider,
            {
              value: t.route,
            },
            React.createElement(
              ReactNative.View,
              {
                onLayout: k
                  ? function (o) {
                      return k({
                        route: t.route,
                        height: o.nativeEvent.layout.height,
                      });
                    }
                  : undefined,
                pointerEvents: S ? 'box-none' : 'none',
                accessibilityElementsHidden: !S,
                importantForAccessibility: S ? 'auto' : 'no-hide-descendants',
                style: ('float' === c && !S) || P.headerTransparent ? f.header : null,
              },
              false !== P.headerShown ? (undefined !== P.header ? P.header(N) : React.createElement(module775.default, N)) : null
            )
          )
        );
      })}
    </ReactNative.View>
  );
};

var React = (function (t, o) {
    if (!o && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var n = c(o);
    if (n && n.has(t)) return n.get(t);
    var u = {
        __proto__: null,
      },
      l = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var s in t)
      if ('default' !== s && Object.prototype.hasOwnProperty.call(t, s)) {
        var f = l ? Object.getOwnPropertyDescriptor(t, s) : null;
        if (f && (f.get || f.set)) Object.defineProperty(u, s, f);
        else u[s] = t[s];
      }

    u.default = t;
    if (n) n.set(t, u);
    return u;
  })(require('react')),
  ReactNative = require('react-native'),
  module649 = require('./649'),
  module775 = require('./775'),
  module722 = require('./722');

function c(t) {
  if ('function' != typeof WeakMap) return null;
  var o = new WeakMap(),
    n = new WeakMap();
  return (c = function (t) {
    return t ? n : o;
  })(t);
}

var f = ReactNative.StyleSheet.create({
  header: {
    position: 'absolute',
    top: 0,
    left: 0,
    right: 0,
  },
});
