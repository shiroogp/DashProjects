var module1212 = require('./1212'),
  module1223 = require('./1223');

module.exports = function (o) {
  return !module1212(o) && 'object' == typeof o && !module1223(o);
};
