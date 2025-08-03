exports.default = function (t) {
  switch (t) {
    case 'vertical':
      return 1;

    case 'vertical-inverted':
      return -1;

    case 'horizontal':
      return ReactNative.I18nManager.isRTL ? -1 : 1;

    case 'horizontal-inverted':
      return ReactNative.I18nManager.isRTL ? 1 : -1;
  }
};

var ReactNative = require('react-native');
