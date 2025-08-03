var module559 = require('./559');

module.exports = function (n) {
  var s = module559(this, n).delete(n);
  this.size -= s ? 1 : 0;
  return s;
};
