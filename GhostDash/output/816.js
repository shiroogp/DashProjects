var module544 = require('./544'),
  module597 = require('./597'),
  module817 = require('./817'),
  c = Object.prototype.hasOwnProperty;

module.exports = function (u) {
  if (!module544(u)) return module817(u);
  var p = module597(u),
    f = [];

  for (var s in u) ('constructor' != s || (!p && c.call(u, s))) && f.push(s);

  return f;
};
