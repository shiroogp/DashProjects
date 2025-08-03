var n = 800,
  t = 16,
  o = Date.now;

module.exports = function (u) {
  var f = 0,
    v = 0;
  return function () {
    var c = o(),
      p = t - (c - v);

    if (((v = c), p > 0)) {
      if (++f >= n) return arguments[0];
    } else f = 0;

    return u.apply(undefined, arguments);
  };
};
