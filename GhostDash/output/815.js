var module583 = require('./583'),
  module816 = require('./816'),
  module600 = require('./600');

module.exports = function (u) {
  return module600(u) ? module583(u, true) : module816(u);
};
