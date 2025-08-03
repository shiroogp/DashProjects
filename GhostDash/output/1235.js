var module1212 = require('./1212'),
  module1218 = require('./1218');

module.exports = function (o) {
  return module1212(o) || module1218(o);
};
