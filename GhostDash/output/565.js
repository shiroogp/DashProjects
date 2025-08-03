var module549 = require('./549'),
  module566 = require('./566'),
  module567 = require('./567');

function n(o) {
  var p = -1,
    n = null == o ? 0 : o.length;

  for (this.__data__ = new module549(); ++p < n; ) this.add(o[p]);
}

n.prototype.add = n.prototype.push = module566;
n.prototype.has = module567;
module.exports = n;
