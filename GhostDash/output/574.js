var module575 = require('./575'),
  n = 1,
  o = Object.prototype.hasOwnProperty;

module.exports = function (c, f, u, s, v, l) {
  var p = u & n,
    y = module575(c),
    h = y.length;
  if (h != module575(f).length && !p) return false;

  for (var b = h; b--; ) {
    var O = y[b];
    if (!(p ? O in f : o.call(f, O))) return false;
  }

  var _ = l.get(c),
    j = l.get(f);

  if (_ && j) return _ == f && j == c;
  var k = true;
  l.set(c, f);
  l.set(f, c);

  for (var w = p; ++b < h; ) {
    var x = c[(O = y[b])],
      P = f[O];
    if (s) var q = p ? s(P, x, O, f, c, l) : s(x, P, O, c, f, l);

    if (!(undefined === q ? x === P || v(x, P, u, s, l) : q)) {
      k = false;
      break;
    }

    if (!w) w = 'constructor' == O;
  }

  if (k && !w) {
    var z = c.constructor,
      A = f.constructor;
    if (z != A && 'constructor' in c && 'constructor' in f && !('function' == typeof z && z instanceof z && 'function' == typeof A && A instanceof A)) k = false;
  }

  l.delete(c);
  l.delete(f);
  return k;
};
