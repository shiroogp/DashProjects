var t,
  ReactNative = require('react-native');

exports.default = null != (t = null == ReactNative.NativeModules ? undefined : ReactNative.NativeModules.PlatformConstants) ? t : ReactNative.Platform.constants;
