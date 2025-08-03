var module1221 = require('./1221');

module.exports = function (n) {
  return module1221(n) && 'struct' === n.meta.kind;
};
