require('./52');

var module27 = require('./27'),
  module216 = require('./216'),
  module143 = require('./143'),
  o = (function () {
    function t() {
      module27.default(this, t);
      this.__nativeTVNavigationEventListener = null;
      this.__nativeTVNavigationEventEmitter = null;
    }

    module28.default(t, [
      {
        key: 'enable',
        value: function (t, n) {
          this.__nativeTVNavigationEventEmitter = new module143(module216.default);
          this.__nativeTVNavigationEventListener = this.__nativeTVNavigationEventEmitter.addListener('onHWKeyEvent', function (v) {
            if (n) n(t, v);
          });
        },
      },
      {
        key: 'disable',
        value: function () {
          if (this.__nativeTVNavigationEventListener) {
            this.__nativeTVNavigationEventListener.remove();

            delete this.__nativeTVNavigationEventListener;
          }

          if (this.__nativeTVNavigationEventEmitter) delete this.__nativeTVNavigationEventEmitter;
        },
      },
    ]);
    return t;
  })();

module.exports = o;
