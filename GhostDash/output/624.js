var module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module619 = require('./619');

function s() {
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

exports.FlingGesture = (function (t) {
  module38.default(y, t);

  var module619 = y,
    h = s(),
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
    t.handlerName = 'FlingGestureHandler';
    return t;
  }

  module28.default(y, [
    {
      key: 'numberOfPointers',
      value: function (t) {
        this.config.numberOfPointers = t;
        return this;
      },
    },
    {
      key: 'direction',
      value: function (t) {
        this.config.direction = t;
        return this;
      },
    },
  ]);
  return y;
})(module619.BaseGesture);
