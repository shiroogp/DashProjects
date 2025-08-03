var module550 = require('./550'),
  module558 = require('./558'),
  module561 = require('./561'),
  module562 = require('./562'),
  module563 = require('./563');

function s(t) {
  var o = -1,
    p = null == t ? 0 : t.length;

  for (this.clear(); ++o < p; ) {
    var l = t[o];
    this.set(l[0], l[1]);
  }
}

s.prototype.clear = module550;
s.prototype.delete = module558;
s.prototype.get = module561;
s.prototype.has = module562;
s.prototype.set = module563;
module.exports = s;
