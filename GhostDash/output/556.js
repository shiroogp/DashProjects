var module553 = require('./553'),
  o = Object.prototype.hasOwnProperty;

module.exports = function (n) {
  var _ = this.__data__;
  return module553 ? undefined !== _[n] : o.call(_, n);
};
