var ReactNative = require('react-native').UIManager.getViewManagerConfig('RNCSafeAreaProvider'),
  t = (exports.initialWindowMetrics = null != ReactNative && null != ReactNative.Constants ? ReactNative.Constants.initialWindowMetrics : null);

exports.initialWindowSafeAreaInsets = null == t ? undefined : t.insets;
