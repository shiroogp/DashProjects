require('./1210');

require('./1225');

var module1221 = require('./1221');

require('./1220');

module.exports = function (n) {
  return !module1221(n) || n.meta.identity;
};
