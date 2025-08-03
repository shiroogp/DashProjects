var module839 = require('./839'),
  module585 = require('./585'),
  module578 = require('./578'),
  module590 = require('./590'),
  module593 = require('./593'),
  module850 = require('./850');

module.exports = function (v, c, h) {
  for (var _ = -1, b = (c = module839(c, v)).length, k = false; ++_ < b; ) {
    var p = module850(c[_]);
    if (!(k = null != v && h(v, p))) break;
    v = v[p];
  }

  return k || ++_ != b ? k : !!(b = null == v ? 0 : v.length) && module593(b) && module590(p, b) && (module578(v) || module585(v));
};
