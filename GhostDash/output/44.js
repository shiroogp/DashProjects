var module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37');

function f() {
  if ('undefined' == typeof Reflect || !Reflect.construct) return false;
  if (Reflect.construct.sham) return false;
  if ('function' == typeof Proxy) return true;

  try {
    Boolean.prototype.valueOf.call(Reflect.construct(Boolean, [], function () {}));
    return true;
  } catch (t) {
    return false;
  }
}

var module45 = require('./45');

class l {
  constructor(n, c, o, u) {
    var f;
    module27(this, y);
    (f = p.call(this, c)).emitter = n;
    f.listener = o;
    f.context = u;
    return f;
  }

  remove() {
    this.emitter.removeSubscription(this);
  }
}

module.exports = l;
