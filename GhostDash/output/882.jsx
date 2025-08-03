var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  React = require('react'),
  ReactNative = require('react-native'),
  module797 = require('./797'),
  module798 = require('./798'),
  module788 = require('./788'),
  y = '/Users/trensik/dev/react-native-paper/src/components/Icon.tsx',
  b = function (t) {
    return (
      ('object' == typeof t && null !== t && Object.prototype.hasOwnProperty.call(t, 'uri') && 'string' == typeof t.uri) ||
      'number' == typeof t ||
      ('web' === ReactNative.Platform.OS && 'string' == typeof t && (t.startsWith('data:image') || /\.(bmp|jpg|jpeg|png|gif|svg)$/.test(t)))
    );
  },
  h = function (t) {
    return 'object' == typeof t && null !== t && Object.prototype.hasOwnProperty.call(t, 'uri') && 'string' == typeof t.uri ? t.uri : t;
  };

exports.isValidIcon = function (t) {
  return 'string' == typeof t || b(t);
};

exports.isEqualIcon = function (t, o) {
  return t === o || h(t) === h(o);
};

var j = module788.withTheme(function (t) {
  var o = t.source,
    p = t.color,
    h = t.size,
    j = t.theme,
    v = module56.default(t, ['source', 'color', 'size', 'theme']),
    _ = 'object' == typeof o && o.direction && o.source ? ('auto' === o.direction ? (ReactNative.I18nManager.isRTL ? 'rtl' : 'ltr') : o.direction) : null,
    I = 'object' == typeof o && o.direction && o.source ? o.source : o,
    O = p || j.colors.text;

  return b(I) ? (
    <ReactNative.Image />
  ) : 'string' == typeof I ? (
    <module797.Consumer
      __source={{
        fileName: y,
        lineNumber: 106,
      }}
    >
      {function (t) {
        return t.icon({
          name: I,
          color: O,
          size: h,
          direction: _,
        });
      }}
    </module797.Consumer>
  ) : 'function' == typeof I ? (
    I({
      color: O,
      size: h,
      direction: _,
    })
  ) : null;
});
exports.default = j;
