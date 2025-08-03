var React = require('react'),
  ReactNative = require('react-native'),
  module1186 = require('./1186'),
  module799 = require('./799'),
  module1190 = require('./1190'),
  module992 = require('./992');

exports.default = function (t) {
  var s = t.navigation;
  return React.default.createElement(module1186.default, {
    onRead: function (t) {
      s.replace('DashAddScreen', {
        qrcodeData: t.data,
      });
    },
    showMarker: true,
    topViewStyle: module1190.default.topViewStyle,
    bottomViewStyle: module1190.default.bottomViewStyle,
    topContent: React.default.createElement(
      ReactNative.Text,
      {
        style: module1190.default.centerText,
      },
      'Aproxime a c\xe2mera do QRCode apresentado na sua GhostDash'
    ),
    bottomContent: React.default.createElement(
      ReactNative.TouchableHighlight,
      {
        activeOpacity: 0.5,
        underlayColor: module992.colors.interactionColor,
        onPress: function () {
          return s.navigate('Dashboard');
        },
        style: module1190.default.cancelButton,
      },
      React.default.createElement(module799.default, {
        name: 'close-circle-outline',
        color: module992.colors.mainText,
        size: 56,
      })
    ),
  });
};
