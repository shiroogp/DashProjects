var module521 = require('./521'),
  module529 = require('./529'),
  module530 = require('./530'),
  module531 = require('./531'),
  module532 = require('./532'),
  module533 = require('./533');

function y(o) {
  var p = (this.__data__ = new module521(o));
  this.size = p.size;
}

y.prototype.clear = module529;
y.prototype.delete = module530;
y.prototype.get = module531;
y.prototype.has = module532;
y.prototype.set = module533;
module.exports = y;
