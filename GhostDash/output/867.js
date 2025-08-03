var module849 = require('./849'),
  module868 = require('./868'),
  module839 = require('./839');

module.exports = function (f, u, v) {
  for (var c = -1, _ = u.length, h = {}; ++c < _; ) {
    var l = u[c],
      p = module849(f, l);
    if (v(p, l)) module868(h, module839(l, f), p);
  }

  return h;
};
