var module14 = require('./14'),
  React = require('react'),
  module743 = require('./743'),
  ReactNative = require('react-native').StyleSheet.create({
    headerSubview: {
      position: 'absolute',
      top: 0,
      right: 0,
      flexDirection: 'row',
      alignItems: 'center',
      justifyContent: 'center',
    },
  });

exports.default = function (t) {
  return React.default.createElement(
    module743.default,
    module14.default({}, t, {
      style: ReactNative.headerSubview,
    })
  );
};
