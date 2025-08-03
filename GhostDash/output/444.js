var module27 = require('./27'),
  module445 = require('./445');

exports.BaseAnimationBuilder = (function () {
  function t() {
    module27.default(this, t);
    this.randomizeDelay = false;

    this.build = function () {
      throw Error('Unimplemented method in child class.');
    };
  }

  module28.default(
    t,
    [
      {
        key: 'duration',
        value: function (t) {
          this.durationV = t;
          return this;
        },
      },
      {
        key: 'delay',
        value: function (t) {
          this.delayV = t;
          return this;
        },
      },
      {
        key: 'withCallback',
        value: function (t) {
          this.callbackV = t;
          return this;
        },
      },
      {
        key: 'getDuration',
        value: function () {
          var t;
          return null != (t = this.durationV) ? t : 300;
        },
      },
      {
        key: 'randomDelay',
        value: function () {
          this.randomizeDelay = true;
          return this;
        },
      },
      {
        key: 'getDelay',
        value: function () {
          var t, n;
          return this.randomizeDelay ? Math.random() * (null != (t = this.delayV) ? t : 1e3) : null != (n = this.delayV) ? n : 0;
        },
      },
      {
        key: 'getDelayFunction',
        value: function () {
          return this.randomizeDelay || this.delayV
            ? module445.withDelay
            : function (t, n) {
                'worklet';

                return n;
              };
        },
      },
    ],
    [
      {
        key: 'duration',
        value: function (t) {
          return this.createInstance().duration(t);
        },
      },
      {
        key: 'delay',
        value: function (t) {
          return this.createInstance().delay(t);
        },
      },
      {
        key: 'withCallback',
        value: function (t) {
          return this.createInstance().withCallback(t);
        },
      },
      {
        key: 'getDuration',
        value: function () {
          return 300;
        },
      },
      {
        key: 'randomDelay',
        value: function () {
          return this.createInstance().randomDelay();
        },
      },
      {
        key: 'build',
        value: function () {
          return this.createInstance().build();
        },
      },
    ]
  );
  return t;
})();
