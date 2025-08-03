var module577 = require('./577'),
  module578 = require('./578');

module.exports = function (o, u, c) {
  var f = u(o);
  return module578(o) ? f : module577(f, c(o));
};
