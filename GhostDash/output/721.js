exports.default = function (t, l, o) {
  return n(
    u(t, l),
    u(
      t.interpolate({
        inputRange: [0, 1],
        outputRange: [1, 0],
      }),
      o
    )
  );
};

var ReactNative = require('react-native'),
  n = ReactNative.Animated.add,
  u = ReactNative.Animated.multiply;
