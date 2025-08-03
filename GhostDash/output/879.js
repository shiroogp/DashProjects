exports.default = function () {
  var t = arguments.length > 0 && undefined !== arguments[0] ? arguments[0] : 1,
    n = arguments.length > 1 && undefined !== arguments[1] ? arguments[1] : module877.default.colors.surface;

  if (t instanceof ReactNative.Animated.Value) {
    var l = [0, 1, 2, 3, 8, 24];
    return t.interpolate({
      inputRange: l,
      outputRange: l.map(function (t) {
        return f(n, t);
      }),
    });
  }

  return f(n, t);
};

var module760 = require('./760'),
  ReactNative = require('react-native'),
  module877 = require('./877');

function f(t, u) {
  var module877;
  module877 = u >= 1 && u <= 24 ? l[u] : u > 24 ? l[24] : l[1];
  return module760
    .default(t)
    .mix(module760.default('white'), 0.01 * module877)
    .hex();
}

var l = {
  1: 5,
  2: 7,
  3: 8,
  4: 9,
  5: 10,
  6: 11,
  7: 11.5,
  8: 12,
  9: 12.5,
  10: 13,
  11: 13.5,
  12: 14,
  13: 14.25,
  14: 14.5,
  15: 14.75,
  16: 15,
  17: 15.12,
  18: 15.24,
  19: 15.36,
  20: 15.48,
  21: 15.6,
  22: 15.72,
  23: 15.84,
  24: 16,
};
