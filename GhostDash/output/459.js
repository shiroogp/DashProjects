var module50 = require('./50'),
  module15 = require('@babel/runtime/helpers/slicedToArray'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module443 = require('./443');

function v(t, n) {
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

function y(t) {
  for (var l = 1; l < arguments.length; l++) {
    var u = null != arguments[l] ? arguments[l] : {};
    if (l % 2)
      v(Object(u), true).forEach(function (l) {
        module50.default(t, l, u[l]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(u));
    else
      v(Object(u)).forEach(function (n) {
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
      var o = module37.default(this).constructor;
      l = Reflect.construct(u, arguments, o);
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

exports.FlipInXUp = (function (t, ...args) {
  module38.default(f, t);
  var n = h(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = t.getDelay(),
        p = t.callbackV,
        v = t.initialValues;
      return function (t) {
        'worklet';

        return {
          initialValues: y(
            {
              transform: [
                {
                  perspective: 500,
                },
                {
                  rotateX: '90deg',
                },
                {
                  translateY: -t.targetHeight,
                },
              ],
            },
            v
          ),
          animations: {
            transform: [
              {
                perspective: 500,
              },
              {
                rotateX: n(s, c('0deg', f)),
              },
              {
                translateY: n(s, c(0, f)),
              },
            ],
          },
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

exports.FlipInYLeft = (function (t, ...args) {
  module38.default(f, t);
  var n = h(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = t.getDelay(),
        p = t.callbackV,
        v = t.initialValues;
      return function (t) {
        'worklet';

        return {
          initialValues: y(
            {
              transform: [
                {
                  perspective: 500,
                },
                {
                  rotateY: '-90deg',
                },
                {
                  translateX: -t.targetWidth,
                },
              ],
            },
            v
          ),
          animations: {
            transform: [
              {
                perspective: n(s, c(500, f)),
              },
              {
                rotateY: n(s, c('0deg', f)),
              },
              {
                translateX: n(s, c(0, f)),
              },
            ],
          },
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

exports.FlipInXDown = (function (t, ...args) {
  module38.default(f, t);
  var n = h(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = t.getDelay(),
        p = t.callbackV,
        v = t.initialValues;
      return function (t) {
        'worklet';

        return {
          initialValues: y(
            {
              transform: [
                {
                  perspective: 500,
                },
                {
                  rotateX: '-90deg',
                },
                {
                  translateY: t.targetHeight,
                },
              ],
            },
            v
          ),
          animations: {
            transform: [
              {
                perspective: n(s, c(500, f)),
              },
              {
                rotateX: n(s, c('0deg', f)),
              },
              {
                translateY: n(s, c(0, f)),
              },
            ],
          },
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

exports.FlipInYRight = (function (t, ...args) {
  module38.default(f, t);
  var n = h(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = t.getDelay(),
        p = t.callbackV,
        v = t.initialValues;
      return function (t) {
        'worklet';

        return {
          initialValues: y(
            {
              transform: [
                {
                  perspective: 500,
                },
                {
                  rotateY: '90deg',
                },
                {
                  translateX: t.targetWidth,
                },
              ],
            },
            v
          ),
          animations: {
            transform: [
              {
                perspective: n(s, c(500, f)),
              },
              {
                rotateY: n(s, c('0deg', f)),
              },
              {
                translateX: n(s, c(0, f)),
              },
            ],
          },
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

exports.FlipInEasyX = (function (t, ...args) {
  module38.default(f, t);
  var n = h(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = t.getDelay(),
        p = t.callbackV,
        v = t.initialValues;
      return function () {
        'worklet';

        return {
          initialValues: y(
            {
              transform: [
                {
                  perspective: 500,
                },
                {
                  rotateX: '90deg',
                },
              ],
            },
            v
          ),
          animations: {
            transform: [
              {
                perspective: n(s, c(500, f)),
              },
              {
                rotateX: n(s, c('0deg', f)),
              },
            ],
          },
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

exports.FlipInEasyY = (function (t, ...args) {
  module38.default(f, t);
  var n = h(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = t.getDelay(),
        p = t.callbackV,
        v = t.initialValues;
      return function () {
        'worklet';

        return {
          initialValues: y(
            {
              transform: [
                {
                  perspective: 500,
                },
                {
                  rotateY: '90deg',
                },
              ],
            },
            v
          ),
          animations: {
            transform: [
              {
                perspective: n(s, c(500, f)),
              },
              {
                rotateY: n(s, c('0deg', f)),
              },
            ],
          },
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

exports.FlipOutXUp = (function (t, ...args) {
  module38.default(f, t);
  var n = h(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = t.getDelay(),
        p = t.callbackV,
        v = t.initialValues;
      return function (t) {
        'worklet';

        return {
          initialValues: y(
            {
              transform: [
                {
                  perspective: 500,
                },
                {
                  rotateX: '0deg',
                },
                {
                  translateY: 0,
                },
              ],
            },
            v
          ),
          animations: {
            transform: [
              {
                perspective: n(s, c(500, f)),
              },
              {
                rotateX: n(s, c('90deg', f)),
              },
              {
                translateY: n(s, c(-t.currentHeight, f)),
              },
            ],
          },
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

exports.FlipOutYLeft = (function (t, ...args) {
  module38.default(f, t);
  var n = h(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = t.getDelay(),
        p = t.callbackV,
        v = t.initialValues;
      return function (t) {
        'worklet';

        return {
          initialValues: y(
            {
              transform: [
                {
                  perspective: 500,
                },
                {
                  rotateY: '0deg',
                },
                {
                  translateX: 0,
                },
              ],
            },
            v
          ),
          animations: {
            transform: [
              {
                perspective: n(s, c(500, f)),
              },
              {
                rotateY: n(s, c('-90deg', f)),
              },
              {
                translateX: n(s, c(-t.currentWidth, f)),
              },
            ],
          },
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

exports.FlipOutXDown = (function (t, ...args) {
  module38.default(f, t);
  var n = h(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = t.getDelay(),
        p = t.callbackV,
        v = t.initialValues;
      return function (t) {
        'worklet';

        return {
          initialValues: y(
            {
              transform: [
                {
                  perspective: 500,
                },
                {
                  rotateX: '0deg',
                },
                {
                  translateY: 0,
                },
              ],
            },
            v
          ),
          animations: {
            transform: [
              {
                perspective: n(s, c(500, f)),
              },
              {
                rotateX: n(s, c('-90deg', f)),
              },
              {
                translateY: n(s, c(t.currentHeight, f)),
              },
            ],
          },
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

exports.FlipOutYRight = (function (t, ...args) {
  module38.default(f, t);
  var n = h(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = t.getDelay(),
        p = t.callbackV,
        v = t.initialValues;
      return function (t) {
        'worklet';

        return {
          initialValues: y(
            {
              transform: [
                {
                  perspective: 500,
                },
                {
                  rotateY: '0deg',
                },
                {
                  translateX: 0,
                },
              ],
            },
            v
          ),
          animations: {
            transform: [
              {
                perspective: n(s, c(500, f)),
              },
              {
                rotateY: n(s, c('90deg', f)),
              },
              {
                translateX: n(s, c(t.currentWidth, f)),
              },
            ],
          },
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

exports.FlipOutEasyX = (function (t, ...args) {
  module38.default(f, t);
  var n = h(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = t.getDelay(),
        p = t.callbackV,
        v = t.initialValues;
      return function () {
        'worklet';

        return {
          initialValues: y(
            {
              transform: [
                {
                  perspective: 500,
                },
                {
                  rotateX: '0deg',
                },
              ],
            },
            v
          ),
          animations: {
            transform: [
              {
                perspective: n(s, c(500, f)),
              },
              {
                rotateX: n(s, c('90deg', f)),
              },
            ],
          },
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

exports.FlipOutEasyY = (function (t, ...args) {
  module38.default(f, t);
  var n = h(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = t.getDelay(),
        p = t.callbackV,
        v = t.initialValues;
      return function () {
        'worklet';

        return {
          initialValues: y(
            {
              transform: [
                {
                  perspective: 500,
                },
                {
                  rotateY: '0deg',
                },
              ],
            },
            v
          ),
          animations: {
            transform: [
              {
                perspective: n(s, c(500, f)),
              },
              {
                rotateY: n(s, c('90deg', f)),
              },
            ],
          },
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
