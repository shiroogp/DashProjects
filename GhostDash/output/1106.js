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
    var o = R(n);
    if (o && o.has(t)) return o.get(t);
    var l = {
        __proto__: null,
      },
      u = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var s in t)
      if ('default' !== s && Object.prototype.hasOwnProperty.call(t, s)) {
        var f = u ? Object.getOwnPropertyDescriptor(t, s) : null;
        if (f && (f.get || f.set)) Object.defineProperty(l, s, f);
        else l[s] = t[s];
      }

    l.default = t;
    if (o) o.set(t, l);
    return l;
  })(require('react')),
  ReactNative = require('react-native'),
  module1107 = require('./1107'),
  b = ['children', 'colors', 'end', 'locations', 'useAngle', 'angleCenter', 'angle', 'start', 'style'];

function R(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (R = function (t) {
    return t ? o : n;
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

var P = function (t, n) {
  if (Array.isArray(n)) console.warn("LinearGradient '" + t + "' property should be an object with fields 'x' and 'y', Array type is deprecated.");
  return null !== n && 'object' == typeof n ? [n.x, n.y] : n;
};

(exports.default = (function (t) {
  module38.default(j, t);

  var R = j,
    O = v(),
    _ = function () {
      var t,
        n = module37.default(R);

      if (O) {
        var o = module37.default(this).constructor;
        t = Reflect.construct(n, arguments, o);
      } else t = n.apply(this, arguments);

      return module40.default(this, t);
    };

  function j() {
    module27.default(this, j);
    return _.apply(this, arguments);
  }

  module28.default(j, [
    {
      key: 'setNativeProps',
      value: function (t) {
        this.gradientRef.setNativeProps(t);
      },
    },
    {
      key: 'render',
      value: function () {
        var t = this,
          l = this.props,
          u = l.children,
          s = l.colors,
          f = l.end,
          c = l.locations,
          R = l.useAngle,
          v = l.angleCenter,
          O = l.angle,
          _ = l.start,
          j = l.style,
          w = module56.default(l, b);
        if (s && c && s.length !== c.length) console.warn('LinearGradient colors and locations props should be arrays of the same length');

        var A = C,
          B = ReactNative.StyleSheet.flatten(j) || {},
          C = B.borderRadius || 0,
          L = function (t) {
            return 'number' == typeof t ? t : A;
          },
          k = [
            L(B.borderTopLeftRadius),
            L(B.borderTopLeftRadius),
            L(B.borderTopRightRadius),
            L(B.borderTopRightRadius),
            L(B.borderBottomRightRadius),
            L(B.borderBottomRightRadius),
            L(B.borderBottomLeftRadius),
            L(B.borderBottomLeftRadius),
          ];

        return React.default.createElement(
          ReactNative.View,
          module14.default(
            {
              ref: function (n) {
                t.gradientRef = n;
              },
            },
            w,
            {
              style: j,
            }
          ),
          React.default.createElement(module1107.default, {
            style: {
              position: 'absolute',
              top: 0,
              left: 0,
              bottom: 0,
              right: 0,
            },
            colors: s.map(ReactNative.processColor),
            startPoint: P('start', _),
            endPoint: P('end', f),
            locations: c ? c.slice(0, s.length) : null,
            useAngle: R,
            angleCenter: P('angleCenter', v),
            angle: O,
            borderRadii: k,
          }),
          u
        );
      },
    },
  ]);
  return j;
})(React.Component)).defaultProps = {
  start: {
    x: 0.5,
    y: 0,
  },
  end: {
    x: 0.5,
    y: 1,
  },
};
