var React = require('react'),
  ReactNative = require('react-native'),
  module1106 = require('./1106'),
  module1199 = require('./1199'),
  module992 = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var l = c(n);
    if (l && l.has(t)) return l.get(t);
    var o = {
        __proto__: null,
      },
      u = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var f in t)
      if ('default' !== f && Object.prototype.hasOwnProperty.call(t, f)) {
        var p = u ? Object.getOwnPropertyDescriptor(t, f) : null;
        if (p && (p.get || p.set)) Object.defineProperty(o, f, p);
        else o[f] = t[f];
      }

    o.default = t;
    if (l) l.set(t, o);
    return o;
  })(require('./992'));

function c(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    l = new WeakMap();
  return (c = function (t) {
    return t ? l : n;
  })(t);
}

exports.default = function () {
  return React.default.createElement(
    ReactNative.View,
    {
      style: module1199.default.main,
    },
    React.default.createElement(module1106.default, {
      colors: module992.colors.gradientTop,
      style: module992.default.linearGradient,
      start: {
        x: 0,
        y: 0,
      },
      end: {
        x: 0,
        y: 1,
      },
    }),
    React.default.createElement(
      ReactNative.ScrollView,
      {
        contentContainerStyle: module1199.default.contentContainer,
      },
      React.default.createElement(
        ReactNative.View,
        {
          style: module1199.default.menuHolder,
        },
        React.default.createElement(
          ReactNative.View,
          {
            style: module1199.default.header,
          },
          React.default.createElement(
            ReactNative.Text,
            {
              style: module1199.default.headerText,
            },
            'Performance'
          )
        ),
        React.default.createElement(
          ReactNative.Text,
          {
            style: {
              color: module992.colors.mainText,
            },
          },
          'Op\xe7\xf5es de performance n\xe3o dispon\xedveis para o produto ativado.'
        )
      )
    )
  );
};
