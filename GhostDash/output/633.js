var module27 = require('./27'),
  module35 = require('./35'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module619 = require('./619');

function h() {
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

function v(t, n) {
  'worklet';

  return t;
}

exports.ManualGesture = (function (t) {
  module38.default(R, t);

  var module619 = R,
    p = h(),
    y = function () {
      var t,
        n = module37.default(module619);

      if (p) {
        var u = module37.default(this).constructor;
        t = Reflect.construct(n, arguments, u);
      } else t = n.apply(this, arguments);

      return module40.default(this, t);
    };

  function R() {
    var t;
    module27.default(this, R);
    (t = y.call(this)).handlerName = 'ManualGestureHandler';
    return t;
  }

  module28.default(R, [
    {
      key: 'onChange',
      value: function (t) {
        this.handlers.changeEventCalculator = v;
        return module35.default(module37.default(R.prototype), 'onChange', this).call(this, t);
      },
    },
  ]);
  return R;
})(module619.ContinousBaseGesture);
