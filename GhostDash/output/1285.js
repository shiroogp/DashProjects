exports.createPanResponder = function (n) {
  var o = n.onStart,
    u = undefined === o ? v : o,
    s = n.onMove,
    p = undefined === s ? v : s,
    c = n.onEnd,
    f = undefined === c ? v : c;
  return ReactNative.PanResponder.create({
    onStartShouldSetPanResponder: v,
    onStartShouldSetPanResponderCapture: v,
    onMoveShouldSetPanResponder: v,
    onMoveShouldSetPanResponderCapture: v,
    onPanResponderTerminationRequest: v,
    onPanResponderGrant: function (n, t) {
      return u(
        {
          x: n.nativeEvent.pageX,
          y: n.nativeEvent.pageY,
        },
        n,
        t
      );
    },
    onPanResponderMove: function (n, t) {
      return p(
        {
          x: n.nativeEvent.pageX,
          y: n.nativeEvent.pageY,
        },
        n,
        t
      );
    },
    onPanResponderRelease: function (n, t) {
      return f(
        {
          x: n.nativeEvent.pageX,
          y: n.nativeEvent.pageY,
        },
        n,
        t
      );
    },
  });
};

exports.fromHsv = function (n) {
  return module1286.default(n).toHexString();
};

exports.rotatePoint = function (n, t, o) {
  if (undefined === o)
    o = {
      x: 0,
      y: 0,
    };
  var v = n.x - o.x,
    u = n.y - o.y,
    s = v * Math.cos(t) - u * Math.sin(t),
    p = u * Math.cos(t) + v * Math.sin(t),
    c = s + o.x,
    f = p + o.y;
  return {
    x: c,
    y: f,
  };
};

exports.toHsv = function (n) {
  return module1286.default(n).toHsv();
};

var ReactNative = require('react-native'),
  module1286 = require('./1286');

var v = function () {
  return true;
};
