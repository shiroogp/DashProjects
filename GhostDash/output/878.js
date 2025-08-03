exports.default = function () {
  var t = arguments.length > 0 && undefined !== arguments[0] ? arguments[0] : 0;

  if (t instanceof ReactNative.Animated.Value) {
    var n = [0, 1, 2, 3, 8, 24];
    return {
      shadowColor: u,
      shadowOffset: {
        width: new ReactNative.Animated.Value(0),
        height: t.interpolate({
          inputRange: n,
          outputRange: [0, 0.5, 0.75, 2, 7, 23],
        }),
      },
      shadowOpacity: new ReactNative.Animated.Value(s),
      shadowRadius: t.interpolate({
        inputRange: n,
        outputRange: [0, 0.75, 1.5, 3, 8, 24],
      }),
    };
  }

  if (0 === t) return {};
  var h, l;

  switch (t) {
    case 1:
      h = 0.5;
      l = 0.75;
      break;

    case 2:
      h = 0.75;
      l = 1.5;
      break;

    default:
      h = t - 1;
      l = t;
  }

  return {
    shadowColor: u,
    shadowOffset: {
      width: 0,
      height: h,
    },
    shadowOpacity: s,
    shadowRadius: l,
  };
};

var module787 = require('./787'),
  ReactNative = require('react-native'),
  u = module787.black,
  s = 0.24;
