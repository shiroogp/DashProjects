var module806 = require('./806'),
  module807 = require('./807'),
  module838 = require('./838'),
  module839 = require('./839'),
  module813 = require('./813'),
  module852 = require('./852'),
  module854 = require('./854'),
  module824 = require('./824'),
  h = module854(function (v, h) {
    var _ = {};
    if (null == v) return _;
    var p = false;
    h = module806(h, function (n) {
      module806 = module839(module806, v);
      if (!p) p = module806.length > 1;
      return module806;
    });
    module813(v, module824(v), _);
    if (p) _ = module807(_, 7, module852);

    for (var s = h.length; s--; ) module838(_, h[s]);

    return _;
  });

module.exports = h;
