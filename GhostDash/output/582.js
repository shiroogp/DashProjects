var module583 = require('./583'),
  module596 = require('./596'),
  module600 = require('./600');

module.exports = function (u) {
  return module600(u) ? module583(u) : module596(u);
};
