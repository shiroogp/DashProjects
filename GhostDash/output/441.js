exports.Bezier = function (n, t, u, o) {
  'worklet';

  var f = 4,
    c = 0.001,
    v = 1e-7,
    l = 10,
    w = 0.1;

  function b(n, t) {
    return 1 - 3 * t + 3 * n;
  }

  function s(n, t) {
    return 3 * t - 6 * n;
  }

  function _(n) {
    return 3 * n;
  }

  function h(n, t, u) {
    return ((b(t, u) * n + s(t, u)) * n + _(t)) * n;
  }

  function y(n, t, u) {
    return 3 * b(t, u) * n * n + 2 * s(t, u) * n + _(t);
  }

  function z(n, t, u, o, f) {
    var c,
      w,
      b = 0;

    do {
      if ((c = h((w = t + (u - t) / 2), o, f) - n) > 0) u = w;
      else t = w;
    } while (Math.abs(c) > v && ++b < l);

    return w;
  }

  function M(n, t, u, o) {
    for (var c = 0; c < f; ++c) {
      var v = y(t, u, o);
      if (0 === v) return t;
      var l = h(t, u, o) - n;
      t -= l / v;
    }

    return t;
  }

  if (!(n >= 0 && n <= 1 && u >= 0 && u <= 1)) throw new Error('bezier x values must be in [0, 1] range');
  if (n === t && u === o)
    return function (n) {
      return n;
    };

  for (var j = new Array(11), k = 0; k < 11; ++k) j[k] = h(k * w, n, u);

  function p(t) {
    for (var o = 0, f = 1; 10 !== f && j[f] <= t; ++f) o += w;

    var v = (t - j[--f]) / (j[f + 1] - j[f]),
      l = o + v * w,
      b = y(l, n, u);
    return b >= c ? M(t, l, n, u) : 0 === b ? l : z(t, o, o + w, n, u);
  }

  return function (f) {
    return n === t && u === o ? f : 0 === f ? 0 : 1 === f ? 1 : h(p(f), t, o);
  };
};
