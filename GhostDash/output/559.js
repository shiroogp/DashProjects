var module560 = require('./560');

module.exports = function (n, _) {
  var o = n.__data__;
  return module560(_) ? o['string' == typeof _ ? 'string' : 'hash'] : o.map;
};
