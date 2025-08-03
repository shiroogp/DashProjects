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

exports.NativeGesture = (function (t) {
  module38.default(p, t);

  var module619 = p,
    v = s(),
    h = function () {
      var t,
        n = module37.default(module619);

      if (v) {
        var u = module37.default(this).constructor;
        t = Reflect.construct(n, arguments, u);
      } else t = n.apply(this, arguments);

      return module40.default(this, t);
    };

  function p() {
    var t;
    module27.default(this, p);
    (t = h.call(this)).config = {};
    t.handlerName = 'NativeViewGestureHandler';
    return t;
  }

  module28.default(p, [
    {
      key: 'shouldActivateOnStart',
      value: function (t) {
        this.config.shouldActivateOnStart = t;
        return this;
      },
    },
    {
      key: 'disallowInterruption',
      value: function (t) {
        this.config.disallowInterruption = t;
        return this;
      },
    },
  ]);
  return p;
})(module619.BaseGesture);
