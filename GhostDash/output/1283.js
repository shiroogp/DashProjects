var module15 = require('@babel/runtime/helpers/slicedToArray'),
  React = v(require('react')),
  ReactNative = require('react-native'),
  module649 = require('./649'),
  module1284 = require('./1284'),
  module1106 = require('./1106'),
  module992 = v(require('./992')),
  module1277 = require('./1277');

function y(t) {
  if ('function' != typeof WeakMap) return null;
  var l = new WeakMap(),
    n = new WeakMap();
  return (y = function (t) {
    return t ? n : l;
  })(t);
}

function v(t, l) {
  if (!l && t && t.__esModule) return t;
  if (null === t || ('object' != typeof t && 'function' != typeof t))
    return {
      default: t,
    };
  var n = y(l);
  if (n && n.has(t)) return n.get(t);
  var o = {
      __proto__: null,
    },
    u = Object.defineProperty && Object.getOwnPropertyDescriptor;

  for (var f in t)
    if ('default' !== f && Object.prototype.hasOwnProperty.call(t, f)) {
      var c = u ? Object.getOwnPropertyDescriptor(t, f) : null;
      if (c && (c.get || c.set)) Object.defineProperty(o, f, c);
      else o[f] = t[f];
    }

  o.default = t;
  if (n) n.set(t, o);
  return o;
}

var h = ReactNative.StyleSheet.create({
  picker: {
    flex: 1,
    maxHeight: 0.6 * module992.layout.fullHeight,
  },
  smallPicker: {
    maxHeight: 0.3 * module992.layout.fullHeight,
  },
  subtitle: {
    marginVertical: 8,
    flexDirection: 'row',
    justifyContent: 'space-around',
  },
  gradientBlock: {
    width: module992.layout.paddedWidth,
    height: 48,
    borderRadius: 8,
    marginVertical: 16,
  },
});

exports.default = function () {
  var t = module649.useNavigation(),
    y = module649.useRoute().params,
    v = y.type,
    k = y.color,
    C = y.backRoute,
    P = y.gradient,
    b = React.useState((P ? k[0] : k) || 'FF0000'),
    E = module15.default(b, 2),
    _ = E[0],
    w = E[1],
    x = React.useState(k[1]),
    O = module15.default(x, 2),
    j = O[0],
    F = O[1];
  return React.default.createElement(
    React.default.Fragment,
    null,
    React.default.createElement(
      ReactNative.View,
      {
        style: module992.default.mainPadded,
      },
      React.default.createElement(module1284.TriangleColorPicker, {
        style: [h.picker, P ? h.smallPicker : {}],
        oldColor: (P ? k[0] : k) || 'FF0000',
        hideControls: P,
        onColorChange: function (t) {
          return w(module1284.fromHsv(t));
        },
      }),
      !P &&
        React.default.createElement(
          ReactNative.View,
          {
            style: h.subtitle,
          },
          React.default.createElement(ReactNative.Text, null, 'Cor atual'),
          React.default.createElement(ReactNative.Text, null, 'Nova cor')
        ),
      P &&
        React.default.createElement(
          React.default.Fragment,
          null,
          React.default.createElement(module1106.default, {
            colors: [_, j],
            style: h.gradientBlock,
            start: {
              x: 0,
              y: 0,
            },
            end: {
              x: 1,
              y: 0,
            },
          }),
          React.default.createElement(module1284.TriangleColorPicker, {
            style: [h.picker, P ? h.smallPicker : {}],
            oldColor: k[1] || 'FF0000',
            hideControls: true,
            onColorChange: function (t) {
              return F(module1284.fromHsv(t));
            },
          })
        )
    ),
    React.default.createElement(module1277.default, {
      onSave: function () {
        module15 = module1284.fromHsv(_);
        React = module1284.fromHsv(j);
        return void t.navigate(C, {
          type: v,
          color: P ? [module15, React] : module15,
        });
        var module15, React;
      },
      okText: 'selecionar',
    })
  );
};
