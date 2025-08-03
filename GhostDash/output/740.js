var module14 = require('./14'),
  React = require('react'),
  module741 = require('./741'),
  ReactNative = require('react-native');

exports.default = React.default.forwardRef(function (t, o) {
  return React.default.createElement(
    module741.default,
    module14.default(
      {
        ref: o,
      },
      t,
      {
        style: [t.style, ReactNative.StyleSheet.absoluteFill],
      }
    )
  );
});
