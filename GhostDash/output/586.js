var module538 = require('./538'),
  module587 = require('./587'),
  o = '[object Arguments]';

module.exports = function (u) {
  return module587(u) && module538(u) == o;
};
