var module27 = require('./27'),
  module1168 = new (require('./1168').default)('EventTarget');

module1168.disable();

exports.default = (function () {
  function t() {
    module27.default(this, t);
    module1168.info('constructor called');
    this.listeners = {};
  }

  module28.default(t, [
    {
      key: 'addEventListener',
      value: function (t, n) {
        module1168.info('add event listener', t, n);
        if (!(t in this.listeners)) this.listeners[t] = [];
        this.listeners[t].push(n);
      },
    },
    {
      key: 'removeEventListener',
      value: function (t, n) {
        if ((module1168.info('remove event listener', t, n), t in this.listeners)) {
          var s = this.listeners[t];

          for (var v in s)
            if (n === s[v]) {
              s.splice(v, 1);
              return this.removeEventListener(t, n);
            }
        }
      },
    },
    {
      key: 'dispatchEvent',
      value: function (t, n) {
        if ((module1168.info('dispatch event', n), t in this.listeners)) {
          var s = this.listeners[t];

          for (var v in s) s[v].call(this, n);
        }
      },
    },
    {
      key: 'clearEventListeners',
      value: function () {
        for (var t in this.listeners) delete this.listeners[t];
      },
    },
  ]);
  return t;
})();
