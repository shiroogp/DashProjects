var module849 = require('./849'),
  module851 = require('./851');

module.exports = function (o, u) {
  return u.length < 2 ? o : module849(o, module851(u, 0, -1));
};
