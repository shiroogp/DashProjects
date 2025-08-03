exports.executeNativeBackPress = function () {
  ReactNative.BackHandler.exitApp();
  return true;
};

var ReactNative = require('react-native');

exports.isSearchBarAvailableForCurrentPlatform = ['ios', 'android'].includes(ReactNative.Platform.OS);
