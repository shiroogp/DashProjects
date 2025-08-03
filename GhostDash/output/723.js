var ReactNative = require('react-native');

exports.TransitionIOSSpec = {
  animation: 'spring',
  config: {
    stiffness: 1e3,
    damping: 500,
    mass: 3,
    overshootClamping: true,
    restDisplacementThreshold: 0.01,
    restSpeedThreshold: 0.01,
  },
};
exports.FadeInFromBottomAndroidSpec = {
  animation: 'timing',
  config: {
    duration: 350,
    easing: ReactNative.Easing.out(ReactNative.Easing.poly(5)),
  },
};
exports.FadeOutToBottomAndroidSpec = {
  animation: 'timing',
  config: {
    duration: 150,
    easing: ReactNative.Easing.in(ReactNative.Easing.linear),
  },
};
exports.RevealFromBottomAndroidSpec = {
  animation: 'timing',
  config: {
    duration: 425,
    easing: ReactNative.Easing.bezier(0.35, 0.45, 0, 1),
  },
};
exports.ScaleFromCenterAndroidSpec = {
  animation: 'timing',
  config: {
    duration: 400,
    easing: ReactNative.Easing.bezier(0.35, 0.45, 0, 1),
  },
};
