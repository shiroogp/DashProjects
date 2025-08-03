var module538 = require('./538'),
  module578 = require('./578'),
  module587 = require('./587'),
  c = '[object String]';

module.exports = function (f) {
  return 'string' == typeof f || (!module578(f) && module587(f) && module538(f) == c);
};
