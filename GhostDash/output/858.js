var module859 = require('./859'),
  t = Math.max;

module.exports = function (o, f, u) {
  f = t(undefined === f ? o.length - 1 : f, 0);
  return function () {
    for (var h = arguments, v = -1, c = t(h.length - f, 0), l = Array(c); ++v < c; ) l[v] = h[f + v];

    v = -1;

    for (var s = Array(f + 1); ++v < f; ) s[v] = h[v];

    s[f] = u(l);
    return module859(o, this, s);
  };
};
