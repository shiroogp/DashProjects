var module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module619 = require('./619');

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

exports.TapGesture = (function (t) {
  module38.default(y, t);

  var module619 = y,
    h = l(),
    v = function () {
      var t,
        n = module37.default(module619);

      if (h) {
        var u = module37.default(this).constructor;
        t = Reflect.construct(n, arguments, u);
      } else t = n.apply(this, arguments);

      return module40.default(this, t);
    };

  function y() {
    var t;
    module27.default(this, y);
    (t = v.call(this)).config = {};
    t.handlerName = 'TapGestureHandler';
    t.shouldCancelWhenOutside(true);
    return t;
  }

  module28.default(y, [
    {
      key: 'minPointers',
      value: function (t) {
        this.config.minPointers = t;
        return this;
      },
    },
    {
      key: 'numberOfTaps',
      value: function (t) {
        this.config.numberOfTaps = t;
        return this;
      },
    },
    {
      key: 'maxDistance',
      value: function (t) {
        this.config.maxDist = t;
        return this;
      },
    },
    {
      key: 'maxDuration',
      value: function (t) {
        this.config.maxDurationMs = t;
        return this;
      },
    },
    {
      key: 'maxDelay',
      value: function (t) {
        this.config.maxDelayMs = t;
        return this;
      },
    },
    {
      key: 'maxDeltaX',
      value: function (t) {
        this.config.maxDeltaX = t;
        return this;
      },
    },
    {
      key: 'maxDeltaY',
      value: function (t) {
        this.config.maxDeltaY = t;
        return this;
      },
    },
  ]);
  return y;
})(module619.BaseGesture);
