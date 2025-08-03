var ReactNative = require('react-native'),
  module406 = require('./406'),
  t = ReactNative.NativeModules.RNGestureHandlerModule;

if (null == t)
  console.error(
    module406.tagMessage(
      "react-native-gesture-handler module was not found. Make sure you're running your app on the native platform and your code is linked properly (cd ios && pod install && cd ..).\n\n      For installation instructions, please refer to https://docs.swmansion.com/react-native-gesture-handler/docs/#installation"
        .split('\n')
        .map(function (n) {
          return n.trim();
        })
        .join('\n')
    )
  );
if (t && undefined === t.flushOperations) t.flushOperations = function () {};
exports.default = t;
