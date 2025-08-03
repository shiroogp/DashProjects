var module27 = require('./27'),
  module35 = require('./35'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module50 = require('./50'),
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

function y(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var u = Object.getOwnPropertySymbols(t);
    if (n)
      u = u.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, u);
  }

  return o;
}

function O(t) {
  for (var n = 1; n < arguments.length; n++) {
    var o = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      y(Object(o), true).forEach(function (n) {
        module50.default(t, n, o[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(o));
    else
      y(Object(o)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(o, n));
      });
  }

  return t;
}

function v(t, n) {
  'worklet';

  var module28;
  module28 =
    undefined === n
      ? {
          rotationChange: t.rotation,
        }
      : {
          rotationChange: t.rotation - n.rotation,
        };
  return O(O({}, t), module28);
}

exports.RotationGesture = (function (t) {
  module38.default(O, t);

  var module50 = O,
    module619 = h(),
    y = function () {
      var t,
        n = module37.default(module50);

      if (module619) {
        var o = module37.default(this).constructor;
        t = Reflect.construct(n, arguments, o);
      } else t = n.apply(this, arguments);

      return module40.default(this, t);
    };

  function O() {
    var t;
    module27.default(this, O);
    (t = y.call(this)).handlerName = 'RotationGestureHandler';
    return t;
  }

  module28.default(O, [
    {
      key: 'onChange',
      value: function (t) {
        this.handlers.changeEventCalculator = v;
        return module35.default(module37.default(O.prototype), 'onChange', this).call(this, t);
      },
    },
  ]);
  return O;
})(module619.ContinousBaseGesture);
