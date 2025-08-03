var module14 = require('./14'),
  module50 = require('./50'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  React = require('react'),
  ReactNative = require('react-native'),
  f = '/Users/trensik/dev/react-native-paper/src/components/Typography/AnimatedText.tsx';

function p(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var c = Object.getOwnPropertySymbols(t);
    if (n)
      c = c.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, c);
  }

  return o;
}

function O(t) {
  for (var n = 1; n < arguments.length; n++) {
    var o = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      p(Object(o), true).forEach(function (n) {
        module50.default(t, n, o[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(o));
    else
      p(Object(o)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(o, n));
      });
  }

  return t;
}

var module788 = require('./788').withTheme(function (t) {
  var n = t.style,
    c = t.theme,
    p = module56.default(t, ['style', 'theme']),
    y = ReactNative.I18nManager.isRTL ? 'rtl' : 'ltr';
  return React.createElement(
    ReactNative.Animated.Text,
    module14.default({}, p, {
      style: [
        O({}, c.fonts.regular, {
          color: c.colors.text,
          textAlign: 'left',
          writingDirection: y,
        }),
        n,
      ],
      __source: {
        fileName: f,
        lineNumber: 23,
      },
    })
  );
});

exports.default = module788;
