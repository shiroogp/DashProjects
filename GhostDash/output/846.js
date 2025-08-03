var module539 = require('./539'),
  module806 = require('./806'),
  module578 = require('./578'),
  module841 = require('./841'),
  u = module539 ? module539.prototype : undefined,
  p = u ? u.toString : undefined;

module.exports = function t(u) {
  if ('string' == typeof u) return u;
  if (module578(u)) return module806(u, t) + '';
  if (module841(u)) return p ? p.call(u) : '';
  var v = u + '';
  return '0' == v && 1 / u == -1 / 0 ? '-0' : v;
};
