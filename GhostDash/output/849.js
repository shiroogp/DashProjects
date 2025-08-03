var module839 = require('./839'),
  module850 = require('./850');

module.exports = function (t, u) {
  for (var f = 0, l = (u = module839(u, t)).length; null != t && f < l; ) t = t[module850(u[f++])];

  return f && f == l ? t : undefined;
};
