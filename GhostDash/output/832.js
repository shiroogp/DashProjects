var module833 = require('./833'),
  module823 = require('./823'),
  module597 = require('./597');

module.exports = function (c) {
  return 'function' != typeof c.constructor || module597(c) ? {} : module833(module823(c));
};
