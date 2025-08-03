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

function b(t) {
  var n = h();
  return function () {
    var l,
      u = module37.default(t);

    if (n) {
      var o = module37.default(this).constructor;
      l = Reflect.construct(u, arguments, o);
    } else l = u.apply(this, arguments);

    return module40.default(this, l);
  };
}

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

exports.FadeIn = (function (t, ...args) {
  module38.default(f, t);
  var n = b(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = t.callbackV,
        y = t.initialValues,
        p = t.getDelay();
      return function (t) {
        'worklet';

        return {
          animations: {
            opacity: n(p, c(1, f)),
          },
          initialValues: v(
            {
              opacity: 0,
            },
            y
          ),
          callback: s,
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

exports.FadeInRight = (function (t, ...args) {
  module38.default(f, t);
  var n = b(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = t.callbackV,
        y = t.initialValues,
        p = t.getDelay();
      return function () {
        'worklet';

        return {
          animations: {
            opacity: n(p, c(1, f)),
            transform: [
              {
                translateX: n(p, c(0, f)),
              },
            ],
          },
          initialValues: v(
            {
              opacity: 0,
              transform: [
                {
                  translateX: 25,
                },
              ],
            },
            y
          ),
          callback: s,
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

exports.FadeInLeft = (function (t, ...args) {
  module38.default(f, t);
  var n = b(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = t.callbackV,
        y = t.initialValues,
        p = t.getDelay();
      return function () {
        'worklet';

        return {
          animations: {
            opacity: n(p, c(1, f)),
            transform: [
              {
                translateX: n(p, c(0, f)),
              },
            ],
          },
          initialValues: v(
            {
              opacity: 0,
              transform: [
                {
                  translateX: -25,
                },
              ],
            },
            y
          ),
          callback: s,
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

exports.FadeInUp = (function (t, ...args) {
  module38.default(f, t);
  var n = b(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = t.callbackV,
        y = t.initialValues,
        p = t.getDelay();
      return function () {
        'worklet';

        return {
          animations: {
            opacity: n(p, c(1, f)),
            transform: [
              {
                translateY: n(p, c(0, f)),
              },
            ],
          },
          initialValues: v(
            {
              opacity: 0,
              transform: [
                {
                  translateY: -25,
                },
              ],
            },
            y
          ),
          callback: s,
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

exports.FadeInDown = (function (t, ...args) {
  module38.default(f, t);
  var n = b(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = t.callbackV,
        y = t.initialValues,
        p = t.getDelay();
      return function () {
        'worklet';

        return {
          animations: {
            opacity: n(p, c(1, f)),
            transform: [
              {
                translateY: n(p, c(0, f)),
              },
            ],
          },
          initialValues: v(
            {
              opacity: 0,
              transform: [
                {
                  translateY: 25,
                },
              ],
            },
            y
          ),
          callback: s,
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

exports.FadeOut = (function (t, ...args) {
  module38.default(f, t);
  var n = b(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = t.callbackV,
        y = t.initialValues,
        p = t.getDelay();
      return function (t) {
        'worklet';

        return {
          animations: {
            opacity: n(p, c(0, f)),
          },
          initialValues: v(
            {
              opacity: 1,
            },
            y
          ),
          callback: s,
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

exports.FadeOutRight = (function (t, ...args) {
  module38.default(f, t);
  var n = b(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = t.callbackV,
        y = t.initialValues,
        p = t.getDelay();
      return function () {
        'worklet';

        return {
          animations: {
            opacity: n(p, c(0, f)),
            transform: [
              {
                translateX: n(p, c(25, f)),
              },
            ],
          },
          initialValues: v(
            {
              opacity: 1,
              transform: [
                {
                  translateX: 0,
                },
              ],
            },
            y
          ),
          callback: s,
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

exports.FadeOutLeft = (function (t, ...args) {
  module38.default(f, t);
  var n = b(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = t.callbackV,
        y = t.initialValues,
        p = t.getDelay();
      return function () {
        'worklet';

        return {
          animations: {
            opacity: n(p, c(0, f)),
            transform: [
              {
                translateX: n(p, c(-25, f)),
              },
            ],
          },
          initialValues: v(
            {
              opacity: 1,
              transform: [
                {
                  translateX: 0,
                },
              ],
            },
            y
          ),
          callback: s,
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

exports.FadeOutUp = (function (t, ...args) {
  module38.default(f, t);
  var n = b(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = t.callbackV,
        y = t.initialValues,
        p = t.getDelay();
      return function () {
        'worklet';

        return {
          animations: {
            opacity: n(p, c(0, f)),
            transform: [
              {
                translateY: n(p, c(-25, f)),
              },
            ],
          },
          initialValues: v(
            {
              opacity: 1,
              transform: [
                {
                  translateY: 0,
                },
              ],
            },
            y
          ),
          callback: s,
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

exports.FadeOutDown = (function (t, ...args) {
  module38.default(f, t);
  var n = b(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = t.callbackV,
        y = t.initialValues,
        p = t.getDelay();
      return function () {
        'worklet';

        return {
          animations: {
            opacity: n(p, c(0, f)),
            transform: [
              {
                translateY: n(p, c(25, f)),
              },
            ],
          },
          initialValues: v(
            {
              opacity: 1,
              transform: [
                {
                  translateY: 0,
                },
              ],
            },
            y
          ),
          callback: s,
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
