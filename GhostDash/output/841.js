var module538 = require('./538'),
  module587 = require('./587'),
  n = '[object Symbol]';

module.exports = function (b) {
  return 'symbol' == typeof b || (module587(b) && module538(b) == n);
};
