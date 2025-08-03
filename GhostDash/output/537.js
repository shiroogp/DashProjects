var module538 = require('./538'),
  module544 = require('./544'),
  o = '[object AsyncFunction]',
  c = '[object Function]',
  u = '[object GeneratorFunction]',
  b = '[object Proxy]';

module.exports = function (j) {
  if (!module544(j)) return false;
  var f = module538(j);
  return f == c || f == u || f == o || f == b;
};
