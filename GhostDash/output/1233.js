var module1234 = require('./1234'),
  module1231 = require('./1231');

module.exports = module1234(
  module1231,
  function (n) {
    return n % 1 == 0;
  },
  'Integer'
);
