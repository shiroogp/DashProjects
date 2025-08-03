var module50 = require('./50'),
  module15 = require('@babel/runtime/helpers/slicedToArray'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module443 = require('./443');

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
  for (var o = 1; o < arguments.length; o++) {
    var c = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      y(Object(c), true).forEach(function (o) {
        module50.default(t, o, c[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(c));
    else
      y(Object(c)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(c, n));
      });
  }

  return t;
}

function b(t) {
  var n = O();
  return function () {
    var o,
      c = module37.default(t);

    if (n) {
      var l = module37.default(this).constructor;
      o = Reflect.construct(c, arguments, l);
    } else o = c.apply(this, arguments);

    return module40.default(this, o);
  };
}

function O() {
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

exports.PinwheelIn = (function (t, ...args) {
  module38.default(f, t);
  var n = b(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        c = t.getAnimationAndConfig(),
        l = module15.default(c, 2),
        u = l[0],
        f = l[1],
        s = t.getDelay(),
        p = t.callbackV,
        y = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            opacity: n(s, u(1, f)),
            transform: [
              {
                scale: n(s, u(1, f)),
              },
              {
                rotate: n(s, u('0', f)),
              },
            ],
          },
          initialValues: v(
            {
              opacity: 0,
              transform: [
                {
                  scale: 0,
                },
                {
                  rotate: '5',
                },
              ],
            },
            y
          ),
          callback: p,
        };
      };
    };

    return t;
  }

  module28.default(f, null, [
    {
      key: 'createInstance',
      value: function () {
        return new f();
      },
    },
  ]);
  return f;
})(module443.ComplexAnimationBuilder);

exports.PinwheelOut = (function (t, ...args) {
  module38.default(f, t);
  var n = b(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        c = t.getAnimationAndConfig(),
        l = module15.default(c, 2),
        u = l[0],
        f = l[1],
        s = t.getDelay(),
        p = t.callbackV,
        y = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            opacity: n(s, u(0, f)),
            transform: [
              {
                scale: n(s, u(0, f)),
              },
              {
                rotate: n(s, u('5', f)),
              },
            ],
          },
          initialValues: v(
            {
              opacity: 1,
              transform: [
                {
                  scale: 1,
                },
                {
                  rotate: '0',
                },
              ],
            },
            y
          ),
          callback: p,
        };
      };
    };

    return t;
  }

  module28.default(f, null, [
    {
      key: 'createInstance',
      value: function () {
        return new f();
      },
    },
  ]);
  return f;
})(module443.ComplexAnimationBuilder);
