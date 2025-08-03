var module580 = require('./580'),
  module581 = require('./581'),
  o = Object.prototype.propertyIsEnumerable,
  c = Object.getOwnPropertySymbols,
  u = c
    ? function (n) {
        if (null == n) return [];
        else {
          n = Object(n);
          return module580(c(n), function (t) {
            return o.call(n, t);
          });
        }
      }
    : module581;

module.exports = u;
