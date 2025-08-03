var module539 = require('./539'),
  t = module539 ? module539.prototype : undefined,
  n = t ? t.valueOf : undefined;

module.exports = function (o) {
  return n ? Object(n.call(o)) : {};
};
