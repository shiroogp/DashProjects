var module809 = require('./809'),
  module839 = require('./839'),
  module590 = require('./590'),
  module544 = require('./544'),
  module850 = require('./850');

module.exports = function (v, _, c, p) {
  if (!module544(v)) return v;

  for (var l = -1, s = (_ = module839(_, v)).length, h = s - 1, x = v; null != x && ++l < s; ) {
    var y = module850(_[l]),
      b = c;
    if ('__proto__' === y || 'constructor' === y || 'prototype' === y) return v;

    if (l != h) {
      var j = x[y];
      if (undefined === (b = p ? p(j, y, x) : undefined)) b = module544(j) ? j : module590(_[l + 1]) ? [] : {};
    }

    module809(x, y, b);
    x = x[y];
  }

  return v;
};
