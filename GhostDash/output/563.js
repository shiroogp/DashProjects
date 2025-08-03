var module559 = require('./559');

module.exports = function (t, n) {
  var h = module559(this, t),
    o = h.size;
  h.set(t, n);
  this.size += h.size == o ? 0 : 1;
  return this;
};
