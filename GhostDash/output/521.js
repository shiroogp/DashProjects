var module522 = require('./522'),
  module523 = require('./523'),
  module526 = require('./526'),
  module527 = require('./527'),
  module528 = require('./528');

function s(t) {
  var o = -1,
    p = null == t ? 0 : t.length;

  for (this.clear(); ++o < p; ) {
    var l = t[o];
    this.set(l[0], l[1]);
  }
}

s.prototype.clear = module522;
s.prototype.delete = module523;
s.prototype.get = module526;
s.prototype.has = module527;
s.prototype.set = module528;
module.exports = s;
