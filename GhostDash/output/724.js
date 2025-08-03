exports.ModalPresentationIOS = {
  gestureDirection: 'vertical',
  transitionSpec: {
    open: module723.TransitionIOSSpec,
    close: module723.TransitionIOSSpec,
  },
  cardStyleInterpolator: module719.forModalPresentationIOS,
  headerStyleInterpolator: module722.forFade,
};
exports.ScaleFromCenterAndroid = {
  gestureDirection: 'horizontal',
  transitionSpec: {
    open: module723.ScaleFromCenterAndroidSpec,
    close: module723.ScaleFromCenterAndroidSpec,
  },
  cardStyleInterpolator: module719.forScaleFromCenterAndroid,
  headerStyleInterpolator: module722.forFade,
};

var module719 = require('./719'),
  module722 = require('./722'),
  module723 = require('./723'),
  ReactNative = require('react-native'),
  S = (exports.SlideFromRightIOS = {
    gestureDirection: 'horizontal',
    transitionSpec: {
      open: module723.TransitionIOSSpec,
      close: module723.TransitionIOSSpec,
    },
    cardStyleInterpolator: module719.forHorizontalIOS,
    headerStyleInterpolator: module722.forFade,
  }),
  c = (exports.ModalSlideFromBottomIOS = {
    gestureDirection: 'vertical',
    transitionSpec: {
      open: module723.TransitionIOSSpec,
      close: module723.TransitionIOSSpec,
    },
    cardStyleInterpolator: module719.forVerticalIOS,
    headerStyleInterpolator: module722.forFade,
  }),
  p = (exports.FadeFromBottomAndroid = {
    gestureDirection: 'vertical',
    transitionSpec: {
      open: module723.FadeInFromBottomAndroidSpec,
      close: module723.FadeOutToBottomAndroidSpec,
    },
    cardStyleInterpolator: module719.forFadeFromBottomAndroid,
    headerStyleInterpolator: module722.forFade,
  }),
  s = (exports.RevealFromBottomAndroid = {
    gestureDirection: 'vertical',
    transitionSpec: {
      open: module723.RevealFromBottomAndroidSpec,
      close: module723.RevealFromBottomAndroidSpec,
    },
    cardStyleInterpolator: module719.forRevealFromBottomAndroid,
    headerStyleInterpolator: module722.forFade,
  }),
  F = (exports.DefaultTransition = ReactNative.Platform.select({
    ios: S,
    default: 'android' === ReactNative.Platform.OS && ReactNative.Platform.Version >= 28 ? s : p,
  }));

exports.ModalTransition = ReactNative.Platform.select({
  ios: c,
  default: F,
});
