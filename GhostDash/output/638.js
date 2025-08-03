var module50 = require('./50'),
  module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  ReactNative = require('react-native'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = h(n);
    if (o && o.has(t)) return o.get(t);
    var u = {
        __proto__: null,
      },
      l = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var c in t)
      if ('default' !== c && Object.prototype.hasOwnProperty.call(t, c)) {
        var p = l ? Object.getOwnPropertyDescriptor(t, c) : null;
        if (p && (p.get || p.set)) Object.defineProperty(u, c, p);
        else u[c] = t[c];
      }

    u.default = t;
    if (o) o.set(t, u);
    return u;
  })(require('react')),
  O = React,
  module639 = require('./639'),
  P = ['style'];

function h(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (h = function (t) {
    return t ? o : n;
  })(t);
}

function j(t, n) {
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

function B(t) {
  for (var o = 1; o < arguments.length; o++) {
    var u = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      j(Object(u), true).forEach(function (o) {
        module50.default(t, o, u[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(u));
    else
      j(Object(u)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(u, n));
      });
  }

  return t;
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

var k = (exports.default = (function (t) {
  module38.default(h, t);

  var module50 = h,
    ReactNative = R(),
    b = function () {
      var t,
        o = module37.default(module50);

      if (ReactNative) {
        var u = module37.default(this).constructor;
        t = Reflect.construct(o, arguments, u);
      } else t = o.apply(this, arguments);

      return module40.default(this, t);
    };

  function h() {
    module27.default(this, h);
    return b.apply(this, arguments);
  }

  module28.default(h, [
    {
      key: 'getExtraButtonProps',
      value: function () {
        var t = {},
          n = this.props.background;

        if (n) {
          if ('RippleAndroid' === n.type) {
            t.borderless = n.borderless;
            t.rippleColor = n.color;
          } else if ('ThemeAttrAndroid' === n.type) t.borderless = 'selectableItemBackgroundBorderless' === n.attribute;

          t.rippleRadius = n.rippleRadius;
        }

        t.foreground = this.props.useForeground;
        return t;
      },
    },
    {
      key: 'render',
      value: function () {
        var t = this.props,
          n = t.style,
          l = undefined === n ? {} : n,
          c = module56.default(t, P);
        return O.createElement(
          module639.default,
          module14.default({}, c, {
            style: l,
            extraButtonProps: this.getExtraButtonProps(),
          })
        );
      },
    },
  ]);
  return h;
})(React.Component));

k.defaultProps = B(
  B({}, module639.default.defaultProps),
  {},
  {
    useForeground: true,
    extraButtonProps: {
      rippleColor: null,
    },
  }
);

k.SelectableBackground = function (t) {
  return {
    type: 'ThemeAttrAndroid',
    attribute: 'selectableItemBackground',
    rippleRadius: t,
  };
};

k.SelectableBackgroundBorderless = function (t) {
  return {
    type: 'ThemeAttrAndroid',
    attribute: 'selectableItemBackgroundBorderless',
    rippleRadius: t,
  };
};

k.Ripple = function (t, n, o) {
  return {
    type: 'RippleAndroid',
    color: t,
    borderless: n,
    rippleRadius: o,
  };
};

k.canUseNativeForeground = function () {
  return ReactNative.Platform.Version >= 23;
};
