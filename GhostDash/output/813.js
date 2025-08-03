var module809 = require('./809'),
  module810 = require('./810');

module.exports = function (v, t, f, u) {
  var c = !f;
  if (!f) f = {};

  for (var _ = -1, h = t.length; ++_ < h; ) {
    var l = t[_],
      p = u ? u(f[l], v[l], l, f, v) : undefined;
    if (undefined === p) p = v[l];
    if (c) module810(f, l, p);
    else module809(f, l, p);
  }

  return f;
};
