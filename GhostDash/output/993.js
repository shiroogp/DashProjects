exports.getStatusBarHeight = function (o) {
  return ReactNative.Platform.select({
    ios: u,
    android: o ? 0 : ReactNative.StatusBar.currentHeight,
    default: 0,
  });
};

var ReactNative = require('react-native'),
  o = ReactNative.Dimensions.get('window'),
  t = o.height,
  s = o.width,
  u = 20,
  h = false,
  P = false,
  f = false,
  c = false,
  I = false;

if (!('ios' !== ReactNative.Platform.OS || ReactNative.Platform.isPad || ReactNative.Platform.isTVOS))
  375 === s && 812 === t
    ? ((I = true), (h = true), (u = 44))
    : 414 === s && 896 === t
    ? ((I = true), (P = true), (u = 44))
    : 390 === s && 844 === t
    ? ((I = true), (f = true), (u = 47))
    : 428 === s && 926 === t && ((I = true), (c = true), (u = 47));

exports.isIPhoneX = function () {
  return h;
};

exports.isIPhoneXMax = function () {
  return P;
};

exports.isIPhone12 = function () {
  return f;
};

exports.isIPhone12Max = function () {
  return c;
};

exports.isIPhoneWithMonobrow = function () {
  return I;
};

exports.isExpo = function () {
  return undefined !== (globals.Expo || globals.__expo || globals.__exponent);
};
