var module213 = require('./213'),
  o = module213.twoArgumentPooler;

function n(t, o) {
  this.left = t;
  this.top = o;
}

n.prototype.destructor = function () {
  this.left = null;
  this.top = null;
};

module213.addPoolingTo(n, o);
module.exports = n;
