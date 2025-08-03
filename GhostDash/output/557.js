var module553 = require('./553'),
  s = '__lodash_hash_undefined__';

module.exports = function (t, h) {
  var n = this.__data__;
  this.size += this.has(t) ? 0 : 1;
  n[t] = module553 && undefined === h ? s : h;
  return this;
};
