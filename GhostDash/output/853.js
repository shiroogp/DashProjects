var module538 = require('./538'),
  module823 = require('./823'),
  module587 = require('./587'),
  c = '[object Object]',
  u = Function.prototype,
  l = Object.prototype,
  f = u.toString,
  p = l.hasOwnProperty,
  s = f.call(Object);

module.exports = function (u) {
  if (!module587(u) || module538(u) != c) return false;
  var l = module823(u);
  if (null === l) return true;
  var b = p.call(l, 'constructor') && l.constructor;
  return 'function' == typeof b && b instanceof b && f.call(b) == s;
};
