var module27 = require('./27'),
  module35 = require('./35'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37');

function c() {
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

require('./52');

var module43 = require('./43'),
  module34 = require('./34'),
  module6 = require('./6');

class p {
  constructor(n) {
    module27(this, M);
    return L.call(this, module34.sharedSubscriber);
  }

  addListener(t, n, s) {
    if (null != this._nativeModule) this._nativeModule.addListener(t);
    return module35(module37(M.prototype), 'addListener', this).call(this, t, n, s);
  }

  removeAllListeners(t) {
    module6(t, 'eventType argument is required.');
    var n = this.listeners(t).length;
    if (null != this._nativeModule) this._nativeModule.removeListeners(n);
    module35(module37(M.prototype), 'removeAllListeners', this).call(this, t);
  }

  removeSubscription(t) {
    if (null != this._nativeModule) this._nativeModule.removeListeners(1);
    module35(module37(M.prototype), 'removeSubscription', this).call(this, t);
  }
}

module.exports = p;
