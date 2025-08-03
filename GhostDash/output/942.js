var ReactNative = require('react-native'),
  t = globals.__expo,
  n = (null === t || undefined === t ? undefined : t.Constants) ? t.Constants.statusBarHeight : 0,
  s = ReactNative.Platform.select({
    android: n,
    ios: ReactNative.Platform.Version < 11 ? n : 0,
  });

exports.APPROX_STATUSBAR_HEIGHT = s;
