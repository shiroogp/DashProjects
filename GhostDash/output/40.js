var module41 = require('./41'),
  module42 = require('./42');

module.exports = function (o, c) {
  return !c || ('object' !== module41(c) && 'function' != typeof c) ? module42(o) : c;
};
