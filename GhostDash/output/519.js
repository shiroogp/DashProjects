var module520 = require('./520'),
  module564 = require('./564'),
  module570 = require('./570'),
  module574 = require('./574'),
  module601 = require('./601'),
  module578 = require('./578'),
  module588 = require('./588'),
  module591 = require('./591'),
  l = 1,
  v = '[object Arguments]',
  w = '[object Array]',
  b = '[object Object]',
  j = Object.prototype.hasOwnProperty;

module.exports = function (s, y, O, A, h, x) {
  var P = module578(s),
    k = module578(y),
    q = P ? w : module601(s),
    z = k ? w : module601(y),
    B = (q = q == v ? b : q) == b,
    C = (z = z == v ? b : z) == b,
    D = q == z;

  if (D && module588(s)) {
    if (!module588(y)) return false;
    P = true;
    B = false;
  }

  if (D && !B) {
    if (!x) x = new module520();
    return P || module591(s) ? module564(s, y, O, A, h, x) : module570(s, y, q, O, A, h, x);
  }

  if (!(O & l)) {
    var E = B && j.call(s, '__wrapped__'),
      F = C && j.call(y, '__wrapped__');

    if (E || F) {
      var G = E ? s.value() : s,
        H = F ? y.value() : y;
      if (!x) x = new module520();
      return h(G, H, O, A, x);
    }
  }

  return !!D && (x || (x = new module520()), module574(s, y, O, A, h, x));
};
