var module213 = require('./213'),
  o = module213.twoArgumentPooler;

function n(t, o) {
  this.width = t;
  this.height = o;
}

n.prototype.destructor = function () {
  this.width = null;
  this.height = null;
};

n.getPooledFromElement = function (t) {
  return n.getPooled(t.offsetWidth, t.offsetHeight);
};

module213.addPoolingTo(n, o);
module.exports = n;
