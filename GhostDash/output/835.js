var module601 = require('./601'),
  module587 = require('./587'),
  o = '[object Map]';

module.exports = function (c) {
  return module587(c) && module601(c) == o;
};
