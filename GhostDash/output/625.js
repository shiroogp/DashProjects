var module27 = require('./27'),
  module35 = require('./35'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module50 = require('./50'),
  module619 = require('./619');

function p() {
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
    var c = Object.getOwnPropertySymbols(t);
    if (n)
      c = c.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, c);
  }

  return o;
}

function v(t) {
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

function O(t, n) {
  'worklet';

  var module28;
  module28 =
    undefined === n
      ? {
          forceChange: t.force,
        }
      : {
          forceChange: t.force - n.force,
        };
  return v(v({}, t), module28);
}

exports.ForceTouchGesture = (function (t) {
  module38.default(v, t);

  var module50 = v,
    module619 = p(),
    y = function () {
      var t,
        n = module37.default(module50);

      if (module619) {
        var o = module37.default(this).constructor;
        t = Reflect.construct(n, arguments, o);
      } else t = n.apply(this, arguments);

      return module40.default(this, t);
    };

  function v() {
    var t;
    module27.default(this, v);
    (t = y.call(this)).config = {};
    t.handlerName = 'ForceTouchGestureHandler';
    return t;
  }

  module28.default(v, [
    {
      key: 'minForce',
      value: function (t) {
        this.config.minForce = t;
        return this;
      },
    },
    {
      key: 'maxForce',
      value: function (t) {
        this.config.maxForce = t;
        return this;
      },
    },
    {
      key: 'feedbackOnActivation',
      value: function (t) {
        this.config.feedbackOnActivation = t;
        return this;
      },
    },
    {
      key: 'onChange',
      value: function (t) {
        this.handlers.changeEventCalculator = O;
        return module35.default(module37.default(v.prototype), 'onChange', this).call(this, t);
      },
    },
  ]);
  return v;
})(module619.ContinousBaseGesture);
