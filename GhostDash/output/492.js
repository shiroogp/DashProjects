var module27 = require('./27'),
  module422 = require('./422'),
  module493 = require('./493');

exports.default = (function () {
  function t() {
    module27.default(this, t);
    this.nextCallbackId = 0;
    module493.prepareUIRegistry();
  }

  module28.default(t, [
    {
      key: 'registerFrameCallback',
      value: function (t) {
        if (!t) return -1;
        var n = this.nextCallbackId;
        this.nextCallbackId++;
        module422.runOnUI(function () {
          globals._frameCallbackRegistry.registerFrameCallback(t, n);
        })();
        return n;
      },
    },
    {
      key: 'unregisterFrameCallback',
      value: function (t) {
        module422.runOnUI(function () {
          globals._frameCallbackRegistry.unregisterFrameCallback(t);
        })();
      },
    },
    {
      key: 'manageStateFrameCallback',
      value: function (t, n) {
        module422.runOnUI(function () {
          globals._frameCallbackRegistry.manageStateFrameCallback(t, n);
        })();
      },
    },
  ]);
  return t;
})();
