var module27 = require('./27'),
  module35 = require('./35'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37');

function l() {
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

var module43 = require('./43'),
  module46 = require('./46');

class v {
  constructor() {
    var n;
    module27(this, R);
    var o = new module46();
    (n = b.call(this, o)).sharedSubscriber = o;
    return n;
  }

  addListener(t, n, c) {
    return module35(module37(R.prototype), 'addListener', this).call(this, t, n, c);
  }

  removeAllListeners(t) {
    module35(module37(R.prototype), 'removeAllListeners', this).call(this, t);
  }

  removeSubscription(t) {
    if (t.emitter !== this) t.emitter.removeSubscription(t);
    else module35(module37(R.prototype), 'removeSubscription', this).call(this, t);
  }
}

module.exports = new v();
