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
    var o = Object.getOwnPropertySymbols(t);
    if (n)
      o = o.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    l.push.apply(l, o);
  }

  return l;
}

function p(t) {
  for (var l = 1; l < arguments.length; l++) {
    var o = null != arguments[l] ? arguments[l] : {};
    if (l % 2)
      v(Object(o), true).forEach(function (l) {
        module50.default(t, l, o[l]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(o));
    else
      v(Object(o)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(o, n));
      });
  }

  return t;
}

function w(t) {
  var n = h();
  return function () {
    var l,
      o = module37.default(t);

    if (n) {
      var u = module37.default(this).constructor;
      l = Reflect.construct(o, arguments, u);
    } else l = o.apply(this, arguments);

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

exports.ZoomIn = (function (t, ...args) {
  module38.default(f, t);
  var n = w(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        o = t.getAnimationAndConfig(),
        u = module15.default(o, 2),
        c = u[0],
        f = u[1],
        s = t.getDelay(),
        y = t.callbackV,
        v = t.initialValues;
      return function () {
        'worklet';

        return {
          animations: {
            transform: [
              {
                scale: n(s, c(1, f)),
              },
            ],
          },
          initialValues: p(
            {
              transform: [
                {
                  scale: 0,
                },
              ],
            },
            v
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

exports.ZoomInRotate = (function (t, ...args) {
  module38.default(f, t);
  var n = w(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        o = t.getAnimationAndConfig(),
        u = module15.default(o, 2),
        c = u[0],
        f = u[1],
        s = t.getDelay(),
        y = t.rotateV ? t.rotateV : '0.3',
        v = t.callbackV,
        w = t.initialValues;
      return function () {
        'worklet';

        return {
          animations: {
            transform: [
              {
                scale: n(s, c(1, f)),
              },
              {
                rotate: n(s, c(0, f)),
              },
            ],
          },
          initialValues: p(
            {
              transform: [
                {
                  scale: 0,
                },
                {
                  rotate: y,
                },
              ],
            },
            w
          ),
          callback: v,
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

exports.ZoomInLeft = (function (t, ...args) {
  module38.default(f, t);
  var n = w(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        o = t.getAnimationAndConfig(),
        u = module15.default(o, 2),
        c = u[0],
        f = u[1],
        s = t.getDelay(),
        y = t.callbackV,
        v = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            transform: [
              {
                translateX: n(s, c(0, f)),
              },
              {
                scale: n(s, c(1, f)),
              },
            ],
          },
          initialValues: p(
            {
              transform: [
                {
                  translateX: -t.windowWidth,
                },
                {
                  scale: 0,
                },
              ],
            },
            v
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

exports.ZoomInRight = (function (t, ...args) {
  module38.default(f, t);
  var n = w(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        o = t.getAnimationAndConfig(),
        u = module15.default(o, 2),
        c = u[0],
        f = u[1],
        s = t.getDelay(),
        y = t.callbackV,
        v = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            transform: [
              {
                translateX: n(s, c(0, f)),
              },
              {
                scale: n(s, c(1, f)),
              },
            ],
          },
          initialValues: p(
            {
              transform: [
                {
                  translateX: t.windowWidth,
                },
                {
                  scale: 0,
                },
              ],
            },
            v
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

exports.ZoomInUp = (function (t, ...args) {
  module38.default(f, t);
  var n = w(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        o = t.getAnimationAndConfig(),
        u = module15.default(o, 2),
        c = u[0],
        f = u[1],
        s = t.getDelay(),
        y = t.callbackV,
        v = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            transform: [
              {
                translateY: n(s, c(0, f)),
              },
              {
                scale: n(s, c(1, f)),
              },
            ],
          },
          initialValues: p(
            {
              transform: [
                {
                  translateY: -t.windowHeight,
                },
                {
                  scale: 0,
                },
              ],
            },
            v
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

exports.ZoomInDown = (function (t, ...args) {
  module38.default(f, t);
  var n = w(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        o = t.getAnimationAndConfig(),
        u = module15.default(o, 2),
        c = u[0],
        f = u[1],
        s = t.getDelay(),
        y = t.callbackV,
        v = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            transform: [
              {
                translateY: n(s, c(0, f)),
              },
              {
                scale: n(s, c(1, f)),
              },
            ],
          },
          initialValues: p(
            {
              transform: [
                {
                  translateY: t.windowHeight,
                },
                {
                  scale: 0,
                },
              ],
            },
            v
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

exports.ZoomInEasyUp = (function (t, ...args) {
  module38.default(f, t);
  var n = w(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        o = t.getAnimationAndConfig(),
        u = module15.default(o, 2),
        c = u[0],
        f = u[1],
        s = t.getDelay(),
        y = t.callbackV,
        v = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            transform: [
              {
                translateY: n(s, c(0, f)),
              },
              {
                scale: n(s, c(1, f)),
              },
            ],
          },
          initialValues: p(
            {
              transform: [
                {
                  translateY: -t.targetHeight,
                },
                {
                  scale: 0,
                },
              ],
            },
            v
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

exports.ZoomInEasyDown = (function (t, ...args) {
  module38.default(f, t);
  var n = w(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        o = t.getAnimationAndConfig(),
        u = module15.default(o, 2),
        c = u[0],
        f = u[1],
        s = t.getDelay(),
        y = t.callbackV,
        v = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            transform: [
              {
                translateY: n(s, c(0, f)),
              },
              {
                scale: n(s, c(1, f)),
              },
            ],
          },
          initialValues: p(
            {
              transform: [
                {
                  translateY: t.targetHeight,
                },
                {
                  scale: 0,
                },
              ],
            },
            v
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

exports.ZoomOut = (function (t, ...args) {
  module38.default(f, t);
  var n = w(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        o = t.getAnimationAndConfig(),
        u = module15.default(o, 2),
        c = u[0],
        f = u[1],
        s = t.getDelay(),
        y = t.callbackV,
        v = t.initialValues;
      return function () {
        'worklet';

        return {
          animations: {
            transform: [
              {
                scale: n(s, c(0, f)),
              },
            ],
          },
          initialValues: p(
            {
              transform: [
                {
                  scale: 1,
                },
              ],
            },
            v
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

exports.ZoomOutRotate = (function (t, ...args) {
  module38.default(f, t);
  var n = w(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        o = t.getAnimationAndConfig(),
        u = module15.default(o, 2),
        c = u[0],
        f = u[1],
        s = t.getDelay(),
        y = t.rotateV ? t.rotateV : '0.3',
        v = t.callbackV,
        w = t.initialValues;
      return function () {
        'worklet';

        return {
          animations: {
            transform: [
              {
                scale: n(s, c(0, f)),
              },
              {
                rotate: n(s, c(y, f)),
              },
            ],
          },
          initialValues: p(
            {
              transform: [
                {
                  scale: 1,
                },
                {
                  rotate: '0',
                },
              ],
            },
            w
          ),
          callback: v,
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

exports.ZoomOutLeft = (function (t, ...args) {
  module38.default(f, t);
  var n = w(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        o = t.getAnimationAndConfig(),
        u = module15.default(o, 2),
        c = u[0],
        f = u[1],
        s = t.getDelay(),
        y = t.callbackV,
        v = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            transform: [
              {
                translateX: n(s, c(-t.windowWidth, f)),
              },
              {
                scale: n(s, c(0, f)),
              },
            ],
          },
          initialValues: p(
            {
              transform: [
                {
                  translateX: 0,
                },
                {
                  scale: 1,
                },
              ],
            },
            v
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

exports.ZoomOutRight = (function (t, ...args) {
  module38.default(f, t);
  var n = w(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        o = t.getAnimationAndConfig(),
        u = module15.default(o, 2),
        c = u[0],
        f = u[1],
        s = t.getDelay(),
        y = t.callbackV,
        v = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            transform: [
              {
                translateX: n(s, c(t.windowWidth, f)),
              },
              {
                scale: n(s, c(0, f)),
              },
            ],
          },
          initialValues: p(
            {
              transform: [
                {
                  translateX: 0,
                },
                {
                  scale: 1,
                },
              ],
            },
            v
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

exports.ZoomOutUp = (function (t, ...args) {
  module38.default(f, t);
  var n = w(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        o = t.getAnimationAndConfig(),
        u = module15.default(o, 2),
        c = u[0],
        f = u[1],
        s = t.getDelay(),
        y = t.callbackV,
        v = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            transform: [
              {
                translateY: n(s, c(-t.windowHeight, f)),
              },
              {
                scale: n(s, c(0, f)),
              },
            ],
          },
          initialValues: p(
            {
              transform: [
                {
                  translateY: 0,
                },
                {
                  scale: 1,
                },
              ],
            },
            v
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

exports.ZoomOutDown = (function (t, ...args) {
  module38.default(f, t);
  var n = w(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        o = t.getAnimationAndConfig(),
        u = module15.default(o, 2),
        c = u[0],
        f = u[1],
        s = t.getDelay(),
        y = t.callbackV,
        v = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            transform: [
              {
                translateY: n(s, c(t.windowHeight, f)),
              },
              {
                scale: n(s, c(0, f)),
              },
            ],
          },
          initialValues: p(
            {
              transform: [
                {
                  translateY: 0,
                },
                {
                  scale: 1,
                },
              ],
            },
            v
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

exports.ZoomOutEasyUp = (function (t, ...args) {
  module38.default(f, t);
  var n = w(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        o = t.getAnimationAndConfig(),
        u = module15.default(o, 2),
        c = u[0],
        f = u[1],
        s = t.getDelay(),
        y = t.callbackV,
        v = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            transform: [
              {
                translateY: n(s, c(-t.currentHeight, f)),
              },
              {
                scale: n(s, c(0, f)),
              },
            ],
          },
          initialValues: p(
            {
              transform: [
                {
                  translateY: 0,
                },
                {
                  scale: 1,
                },
              ],
            },
            v
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

exports.ZoomOutEasyDown = (function (t, ...args) {
  module38.default(f, t);
  var n = w(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        o = t.getAnimationAndConfig(),
        u = module15.default(o, 2),
        c = u[0],
        f = u[1],
        s = t.getDelay(),
        y = t.callbackV,
        v = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            transform: [
              {
                translateY: n(s, c(t.currentHeight, f)),
              },
              {
                scale: n(s, c(0, f)),
              },
            ],
          },
          initialValues: p(
            {
              transform: [
                {
                  translateY: 0,
                },
                {
                  scale: 1,
                },
              ],
            },
            v
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
