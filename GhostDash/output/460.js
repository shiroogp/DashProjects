var module50 = require('./50'),
  module15 = require('@babel/runtime/helpers/slicedToArray'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module443 = require('./443');

function p(t, n) {
  var l = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var u = Object.getOwnPropertySymbols(t);
    if (n)
      u = u.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    l.push.apply(l, u);
  }

  return l;
}

function v(t) {
  for (var l = 1; l < arguments.length; l++) {
    var u = null != arguments[l] ? arguments[l] : {};
    if (l % 2)
      p(Object(u), true).forEach(function (l) {
        module50.default(t, l, u[l]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(u));
    else
      p(Object(u)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(u, n));
      });
  }

  return t;
}

function h(t) {
  var n = b();
  return function () {
    var l,
      u = module37.default(t);

    if (n) {
      var c = module37.default(this).constructor;
      l = Reflect.construct(u, arguments, c);
    } else l = u.apply(this, arguments);

    return module40.default(this, l);
  };
}

function b() {
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

exports.StretchInX = (function (t, ...args) {
  module38.default(f, t);
  var n = h(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        c = module15.default(u, 2),
        o = c[0],
        f = c[1],
        s = t.getDelay(),
        y = t.callbackV,
        p = t.initialValues;
      return function () {
        'worklet';

        return {
          animations: {
            transform: [
              {
                scaleX: n(s, o(1, f)),
              },
            ],
          },
          initialValues: v(
            {
              transform: [
                {
                  scaleX: 0,
                },
              ],
            },
            p
          ),
          callback: y,
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

exports.StretchInY = (function (t, ...args) {
  module38.default(f, t);
  var n = h(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        c = module15.default(u, 2),
        o = c[0],
        f = c[1],
        s = t.getDelay(),
        y = t.callbackV,
        p = t.initialValues;
      return function () {
        'worklet';

        return {
          animations: {
            transform: [
              {
                scaleY: n(s, o(1, f)),
              },
            ],
          },
          initialValues: v(
            {
              transform: [
                {
                  scaleY: 0,
                },
              ],
            },
            p
          ),
          callback: y,
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

exports.StretchOutX = (function (t, ...args) {
  module38.default(f, t);
  var n = h(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        c = module15.default(u, 2),
        o = c[0],
        f = c[1],
        s = t.getDelay(),
        y = t.callbackV,
        p = t.initialValues;
      return function () {
        'worklet';

        return {
          animations: {
            transform: [
              {
                scaleX: n(s, o(0, f)),
              },
            ],
          },
          initialValues: v(
            {
              transform: [
                {
                  scaleX: 1,
                },
              ],
            },
            p
          ),
          callback: y,
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

exports.StretchOutY = (function (t, ...args) {
  module38.default(f, t);
  var n = h(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        c = module15.default(u, 2),
        o = c[0],
        f = c[1],
        s = t.getDelay(),
        y = t.callbackV,
        p = t.initialValues;
      return function () {
        'worklet';

        return {
          animations: {
            transform: [
              {
                scaleY: n(s, o(0, f)),
              },
            ],
          },
          initialValues: v(
            {
              transform: [
                {
                  scaleY: 1,
                },
              ],
            },
            p
          ),
          callback: y,
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
