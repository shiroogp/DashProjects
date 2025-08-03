exports.getBottomSpace = function () {
  return n() ? 34 : 0;
};

exports.getStatusBarHeight = function (n) {
  return ReactNative.Platform.select({
    ios: o(n ? 44 : 30, 20),
    android: ReactNative.StatusBar.currentHeight,
    default: 0,
  });
};

exports.ifIphoneX = o;
exports.isIphoneX = n;

var ReactNative = require('react-native');

function n() {
  var n = ReactNative.Dimensions.get('window');
  return !(
    'ios' !== ReactNative.Platform.OS ||
    ReactNative.Platform.isPad ||
    ReactNative.Platform.isTVOS ||
    (780 !== n.height &&
      780 !== n.width &&
      812 !== n.height &&
      812 !== n.width &&
      844 !== n.height &&
      844 !== n.width &&
      896 !== n.height &&
      896 !== n.width &&
      926 !== n.height &&
      926 !== n.width)
  );
}

function o(t, o) {
  return n() ? t : o;
}
