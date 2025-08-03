exports.getInset = V;

exports.getStatusBarHeight = function (t) {
  return W(t);
};

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

    var o = _(n);

    if (o && o.has(t)) return o.get(t);
    var u = {
        __proto__: null,
      },
      s = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var c in t)
      if ('default' !== c && Object.prototype.hasOwnProperty.call(t, c)) {
        var p = s ? Object.getOwnPropertyDescriptor(t, c) : null;
        if (p && (p.get || p.set)) Object.defineProperty(u, c, p);
        else u[c] = t[c];
      }

    u.default = t;
    if (o) o.set(t, u);
    return u;
  })(require('react')),
  ReactNative = require('react-native'),
  module905 = require('./905'),
  module906 = require('./906'),
  b = ['padding', 'paddingVertical', 'paddingHorizontal', 'paddingTop', 'paddingBottom', 'paddingLeft', 'paddingRight'],
  O = ['forceInset', 'isLandscape', 'style'];

function _(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (_ = function (t) {
    return t ? o : n;
  })(t);
}

function S(t, n) {
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

function L(t) {
  for (var n = 1; n < arguments.length; n++) {
    var o = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      S(Object(o), true).forEach(function (n) {
        module50.default(t, n, o[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(o));
    else
      S(Object(o)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(o, n));
      });
  }

  return t;
}

function P(t) {
  var n = j();
  return function () {
    var o,
      u = module37.default(t);

    if (n) {
      var s = module37.default(this).constructor;
      o = Reflect.construct(u, arguments, s);
    } else o = u.apply(this, arguments);

    return module40.default(this, o);
  };
}

function j() {
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

((ReactNative.Platform.constants || {}).reactNativeVersion || {}).minor;

var B = function () {
    var t = ReactNative.Dimensions.get('window'),
      n = t.width,
      o = t.height;
    return 0 === n && 0 === o
      ? ReactNative.Dimensions.get('screen')
      : {
          width: n,
          height: o,
        };
  },
  M = B(),
  R = M.height,
  I = M.width,
  k =
    'web' !== ReactNative.Platform.OS &&
    (('ios' === ReactNative.Platform.OS && ((812 === R && 375 === I) || (375 === R && 812 === I))) || (896 === R && 414 === I) || (414 === R && 896 === I)),
  T = 'ios' === ReactNative.Platform.OS && ((1194 === R && 834 === I) || (834 === R && 1194 === I) || (1024 === R && 1366 === I) || (1366 === R && 1024 === I)),
  D = !('ios' !== ReactNative.Platform.OS || k || (R > I && I < 768) || (I > R && R < 768)),
  x = null,
  E = null,
  W = function (t) {
    return null !== x
      ? x
      : 'android' === ReactNative.Platform.OS
      ? globals.Expo
        ? globals.Expo.Constants.statusBarHeight
        : 0
      : k
      ? t
        ? 0
        : 44
      : T
      ? 24
      : D
      ? E
        ? 0
        : 20
      : t || E
      ? 0
      : 20;
  },
  H = function (t) {
    if (!t.includes('%')) return 0;
    var n = parseFloat(t) / 100;
    return isNaN(n) ? 0 : n;
  },
  A = (function (t, ...args) {
    module38.default(f, t);
    var u = P(f);

    function f() {
      var t;
      module27.default(this, f);
      (t = u.call(this, ...args)).state = {
        touchesTop: true,
        touchesBottom: true,
        touchesLeft: true,
        touchesRight: true,
        orientation: null,
        viewWidth: 0,
        viewHeight: 0,
      };

      t._handleLayout = function (n) {
        if (t.props.onLayout) t.props.onLayout(n);

        t._updateMeasurements();
      };

      t._updateMeasurements = function () {
        if (t._isMounted && t.view) {
          var n = t.props.isLandscape,
            o = t.state.orientation,
            u = n ? 'landscape' : 'portrait';

          if (!o || o !== u) {
            var s = B(),
              c = s.width,
              p = s.height;
            ('function' == typeof t.view.measureInWindow ? t.view : t.view.getNode()).measureInWindow(function (n, o, s, f) {
              if (t.view) {
                var l = o,
                  h = n;
                if (l >= p) l %= p;
                else if (l < 0) l = (l % p) + p;
                if (h >= c) h %= c;
                else if (h < 0) h = (h % c) + c;
                var v = 0 === l,
                  y = l + f >= p,
                  w = 0 === h,
                  b = h + s >= c;
                t.setState({
                  touchesTop: v,
                  touchesBottom: y,
                  touchesLeft: w,
                  touchesRight: b,
                  orientation: u,
                  viewWidth: s,
                  viewHeight: f,
                });
              }
            });
          }
        }
      };

      t._getSafeAreaStyle = function () {
        var n = t.state,
          o = n.touchesTop,
          u = n.touchesBottom,
          s = n.touchesLeft,
          c = n.touchesRight,
          p = t.props,
          f = p.forceInset,
          l = t._getViewStyles(),
          h = l.paddingTop,
          v = l.paddingBottom,
          y = l.paddingLeft,
          w = l.paddingRight,
          b = L(
            L({}, l.viewStyle),
            {},
            {
              paddingTop: o ? t._getInset('top') : 0,
              paddingBottom: u ? t._getInset('bottom') : 0,
              paddingLeft: s ? t._getInset('left') : 0,
              paddingRight: c ? t._getInset('right') : 0,
            }
          );

        if (f)
          Object.keys(f).forEach(function (n) {
            var o = f[n];

            switch (('always' === o && (o = t._getInset(n)), 'never' === o && (o = 0), n)) {
              case 'horizontal':
                b.paddingLeft = o;
                b.paddingRight = o;
                break;

              case 'vertical':
                b.paddingTop = o;
                b.paddingBottom = o;
                break;

              case 'left':
              case 'right':
              case 'top':
              case 'bottom':
                var u = 'padding' + n[0].toUpperCase() + n.slice(1);
                b[u] = o;
            }
          });
        if (b.height && 'number' == typeof b.height) b.height += b.paddingTop + b.paddingBottom;
        if (b.width && 'number' == typeof b.width) b.width += b.paddingLeft + b.paddingRight;
        b.paddingTop = b.paddingTop ** h;
        b.paddingBottom = b.paddingBottom ** v;
        b.paddingLeft = b.paddingLeft ** y;
        b.paddingRight = b.paddingRight ** w;
        return b;
      };

      t._getViewStyles = function () {
        var n = t.state.viewWidth,
          u = ReactNative.StyleSheet.flatten(t.props.style || {}),
          s = u.padding,
          c = undefined === s ? 0 : s,
          p = u.paddingVertical,
          f = undefined === p ? c : p,
          l = u.paddingHorizontal,
          h = undefined === l ? c : l,
          y = u.paddingTop,
          w = undefined === y ? f : y,
          O = u.paddingBottom,
          _ = undefined === O ? f : O,
          S = u.paddingLeft,
          L = undefined === S ? h : S,
          P = u.paddingRight,
          j = undefined === P ? h : P,
          B = module56.default(u, b);

        if ('number' != typeof w) w = H(w) * n;
        if ('number' != typeof _) _ = H(_) * n;
        if ('number' != typeof L) L = H(L) * n;
        if ('number' != typeof j) j = H(j) * n;
        return {
          paddingTop: w,
          paddingBottom: _,
          paddingLeft: L,
          paddingRight: j,
          viewStyle: B,
        };
      };

      t._getInset = function (n) {
        return V(n, t.props.isLandscape);
      };

      return t;
    }

    module28.default(f, [
      {
        key: 'componentDidMount',
        value: function () {
          var t = this;
          this._isMounted = true;
          ReactNative.InteractionManager.runAfterInteractions(function () {
            t._updateMeasurements();
          });
        },
      },
      {
        key: 'componentWillUnmount',
        value: function () {
          this._isMounted = false;
        },
      },
      {
        key: 'componentDidUpdate',
        value: function () {
          this._updateMeasurements();
        },
      },
      {
        key: 'render',
        value: function () {
          var t = this,
            u = this.props,
            s = module56.default(u, O),
            c = this._getSafeAreaStyle();

          return React.default.createElement(
            ReactNative.Animated.View,
            module14.default(
              {
                ref: function (n) {
                  return (t.view = n);
                },
                pointerEvents: 'box-none',
              },
              s,
              {
                onLayout: this._handleLayout,
                style: c,
              }
            )
          );
        },
      },
    ]);
    return f;
  })(React.Component);

function V(t, n) {
  switch (t) {
    case 'horizontal':
    case 'right':
    case 'left':
      return n && k ? 44 : 0;

    case 'vertical':
    case 'top':
      return W(n);

    case 'bottom':
      if (k) return n ? 24 : 34;
      else return T ? 20 : 0;
  }
}

A.setStatusBarHeight = function (t) {
  x = t;
};

A.setStatusBarHidden = function (t) {
  E = t;
};

var z = module906.default(A);
exports.default = z;

exports.withSafeArea = function () {
  var t = arguments.length > 0 && undefined !== arguments[0] ? arguments[0] : {};
  return function (n) {
    var o = (function (o) {
      module38.default(f, o);
      var u = P(f);

      function f() {
        module27.default(this, f);
        return u.apply(this, arguments);
      }

      module28.default(f, [
        {
          key: 'render',
          value: function () {
            return React.default.createElement(
              z,
              {
                style: {
                  flex: 1,
                },
                forceInset: t,
              },
              React.default.createElement(n, this.props)
            );
          },
        },
      ]);
      return f;
    })(React.Component);

    return module905.default(o, n);
  };
};
