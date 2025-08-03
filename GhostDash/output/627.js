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

exports.LongPressGesture = (function (t) {
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
    t.handlerName = 'LongPressGestureHandler';
    t.shouldCancelWhenOutside(true);
    return t;
  }

  module28.default(y, [
    {
      key: 'minDuration',
      value: function (t) {
        this.config.minDurationMs = t;
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
  ]);
  return y;
})(module619.BaseGesture);
