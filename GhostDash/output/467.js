var module50 = require('./50'),
  module15 = require('@babel/runtime/helpers/slicedToArray'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module443 = require('./443');

function h(t, n) {
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
      h(Object(o), true).forEach(function (l) {
        module50.default(t, l, o[l]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(o));
    else
      h(Object(o)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(o, n));
      });
  }

  return t;
}

function v(t) {
  var n = b();
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

exports.RotateInDownLeft = (function (t, ...args) {
  module38.default(f, t);
  var n = v(f);

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
        h = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            opacity: n(s, c(1, f)),
            transform: [
              {
                rotate: n(s, c('0deg', f)),
              },
              {
                translateX: n(s, c(0, f)),
              },
              {
                translateY: n(s, c(0, f)),
              },
            ],
          },
          initialValues: p(
            {
              opacity: 0,
              transform: [
                {
                  rotate: '-90deg',
                },
                {
                  translateX: t.targetWidth / 2 - t.targetHeight / 2,
                },
                {
                  translateY: -(t.targetWidth / 2 - t.targetHeight / 2),
                },
              ],
            },
            h
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

exports.RotateInDownRight = (function (t, ...args) {
  module38.default(f, t);
  var n = v(f);

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
        h = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            opacity: n(s, c(1, f)),
            transform: [
              {
                rotate: n(s, c('0deg', f)),
              },
              {
                translateX: n(s, c(0, f)),
              },
              {
                translateY: n(s, c(0, f)),
              },
            ],
          },
          initialValues: p(
            {
              opacity: 0,
              transform: [
                {
                  rotate: '90deg',
                },
                {
                  translateX: -(t.targetWidth / 2 - t.targetHeight / 2),
                },
                {
                  translateY: -(t.targetWidth / 2 - t.targetHeight / 2),
                },
              ],
            },
            h
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

exports.RotateInUpLeft = (function (t, ...args) {
  module38.default(f, t);
  var n = v(f);

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
        h = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            opacity: n(s, c(1, f)),
            transform: [
              {
                rotate: n(s, c('0deg', f)),
              },
              {
                translateX: n(s, c(0, f)),
              },
              {
                translateY: n(s, c(0, f)),
              },
            ],
          },
          initialValues: p(
            {
              opacity: 0,
              transform: [
                {
                  rotate: '90deg',
                },
                {
                  translateX: t.targetWidth / 2 - t.targetHeight / 2,
                },
                {
                  translateY: t.targetWidth / 2 - t.targetHeight / 2,
                },
              ],
            },
            h
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

exports.RotateInUpRight = (function (t, ...args) {
  module38.default(f, t);
  var n = v(f);

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
        h = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            opacity: n(s, c(1, f)),
            transform: [
              {
                rotate: n(s, c('0deg', f)),
              },
              {
                translateX: n(s, c(0, f)),
              },
              {
                translateY: n(s, c(0, f)),
              },
            ],
          },
          initialValues: p(
            {
              opacity: 0,
              transform: [
                {
                  rotate: '-90deg',
                },
                {
                  translateX: -(t.targetWidth / 2 - t.targetHeight / 2),
                },
                {
                  translateY: t.targetWidth / 2 - t.targetHeight / 2,
                },
              ],
            },
            h
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

exports.RotateOutDownLeft = (function (t, ...args) {
  module38.default(f, t);
  var n = v(f);

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
        h = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            opacity: n(s, c(0, f)),
            transform: [
              {
                rotate: n(s, c('90deg', f)),
              },
              {
                translateX: n(s, c(t.currentWidth / 2 - t.currentHeight / 2, f)),
              },
              {
                translateY: n(s, c(t.currentWidth / 2 - t.currentHeight / 2, f)),
              },
            ],
          },
          initialValues: p(
            {
              opacity: 1,
              transform: [
                {
                  rotate: '0deg',
                },
                {
                  translateX: 0,
                },
                {
                  translateY: 0,
                },
              ],
            },
            h
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

exports.RotateOutDownRight = (function (t, ...args) {
  module38.default(f, t);
  var n = v(f);

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
        h = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            opacity: n(s, c(0, f)),
            transform: [
              {
                rotate: n(s, c('-90deg', f)),
              },
              {
                translateX: n(s, c(-(t.currentWidth / 2 - t.currentHeight / 2), f)),
              },
              {
                translateY: n(s, c(t.currentWidth / 2 - t.currentHeight / 2, f)),
              },
            ],
          },
          initialValues: p(
            {
              opacity: 1,
              transform: [
                {
                  rotate: '0deg',
                },
                {
                  translateX: 0,
                },
                {
                  translateY: 0,
                },
              ],
            },
            h
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

exports.RotateOutUpLeft = (function (t, ...args) {
  module38.default(f, t);
  var n = v(f);

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
        h = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            opacity: n(s, c(0, f)),
            transform: [
              {
                rotate: n(s, c('-90deg', f)),
              },
              {
                translateX: n(s, c(t.currentWidth / 2 - t.currentHeight / 2, f)),
              },
              {
                translateY: n(s, c(-(t.currentWidth / 2 - t.currentHeight / 2), f)),
              },
            ],
          },
          initialValues: p(
            {
              opacity: 1,
              transform: [
                {
                  rotate: '0deg',
                },
                {
                  translateX: 0,
                },
                {
                  translateY: 0,
                },
              ],
            },
            h
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

exports.RotateOutUpRight = (function (t, ...args) {
  module38.default(f, t);
  var n = v(f);

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
        h = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            opacity: n(s, c(0, f)),
            transform: [
              {
                rotate: n(s, c('90deg', f)),
              },
              {
                translateX: n(s, c(-(t.currentWidth / 2 - t.currentHeight / 2), f)),
              },
              {
                translateY: n(s, c(-(t.currentWidth / 2 - t.currentHeight / 2), f)),
              },
            ],
          },
          initialValues: p(
            {
              opacity: 1,
              transform: [
                {
                  rotate: '0deg',
                },
                {
                  translateX: 0,
                },
                {
                  translateY: 0,
                },
              ],
            },
            h
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
