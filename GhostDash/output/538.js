var module539 = require('./539'),
  module542 = require('./542'),
  module543 = require('./543'),
  c = '[object Null]',
  u = '[object Undefined]',
  l = module539 ? module539.toStringTag : undefined;

module.exports = function (n) {
  if (null == n) return undefined === n ? u : c;
  else return l && l in Object(n) ? module542(n) : module543(n);
};
