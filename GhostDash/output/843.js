var module844 = require('./844'),
  c = 500;

module.exports = function (t) {
  var u = module844(t, function (n) {
      if (o.size === c) o.clear();
      return n;
    }),
    o = u.cache;
  return u;
};
