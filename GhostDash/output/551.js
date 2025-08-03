var module552 = require('./552'),
  module554 = require('./554'),
  module555 = require('./555'),
  module556 = require('./556'),
  module557 = require('./557');

function s(t) {
  var o = -1,
    p = null == t ? 0 : t.length;

  for (this.clear(); ++o < p; ) {
    var l = t[o];
    this.set(l[0], l[1]);
  }
}

s.prototype.clear = module552;
s.prototype.delete = module554;
s.prototype.get = module555;
s.prototype.has = module556;
s.prototype.set = module557;
module.exports = s;
