exports.getRelativeCoords = function (u, l, t) {
  'worklet';

  var o = module428.measure(u);
  if (null === o) return null;
  return {
    x: l - o.x,
    y: t - o.y,
  };
};

exports.isSharedValue = function (n) {
  'worklet';

  return true === (null == n ? undefined : n._isReanimatedSharedValue);
};

var module428 = require('./428');
