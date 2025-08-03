var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
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
      u = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var f in t)
      if ('default' !== f && Object.prototype.hasOwnProperty.call(t, f)) {
        var c = u ? Object.getOwnPropertyDescriptor(t, f) : null;
        if (c && (c.get || c.set)) Object.defineProperty(l, f, c);
        else l[f] = t[f];
      }

    l.default = t;
    if (o) o.set(t, l);
    return l;
  })(require('react')),
  ReactNative = require('react-native'),
  module502 = require('./502'),
  c = ['itemLayoutAnimation'];

function y(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (y = function (t) {
    return t ? o : n;
  })(t);
}

var module412 = require('./412').default(ReactNative.FlatList),
  p = function (t, n) {
    return function (o) {
      return React.default.createElement(
        module502.default,
        {
          layout: t,
          onLayout: o.onLayout,
          style: n,
        },
        o.children
      );
    };
  },
  s = React.forwardRef(function (t, u) {
    var f = t.itemLayoutAnimation,
      y = module56.default(t, c),
      s = null != y && y.inverted ? (null != y && y.horizontal ? _.horizontallyInverted : _.verticallyInverted) : undefined,
      O = React.default.useMemo(
        function () {
          return p(f, s);
        },
        [s]
      );
    return React.default.createElement(
      module412,
      module14.default(
        {
          ref: u,
        },
        y,
        {
          CellRendererComponent: O,
        }
      )
    );
  }),
  _ = ReactNative.StyleSheet.create({
    verticallyInverted: {
      transform: [
        {
          scaleY: -1,
        },
      ],
    },
    horizontallyInverted: {
      transform: [
        {
          scaleX: -1,
        },
      ],
    },
  });

exports.default = s;
