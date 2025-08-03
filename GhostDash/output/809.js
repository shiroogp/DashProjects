var module810 = require('./810'),
  module525 = require('./525'),
  n = Object.prototype.hasOwnProperty;

module.exports = function (c, p, v) {
  var f = c[p];
  if (!(n.call(c, p) && module525(f, v) && (undefined !== v || p in c))) module810(c, p, v);
};
