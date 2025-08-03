var module1211 = require('./1211'),
  module1222 = require('./1222');

module.exports = function (o) {
  return module1211(o) && module1222(o.meta);
};
