var module50 = require('./50'),
  module15 = require('@babel/runtime/helpers/slicedToArray'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module445 = require('./445'),
  module443 = require('./443');

function y(t, n) {
  var u = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var l = Object.getOwnPropertySymbols(t);
    if (n)
      l = l.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    u.push.apply(u, l);
  }

  return u;
}

function w(t) {
  for (var u = 1; u < arguments.length; u++) {
    var l = null != arguments[u] ? arguments[u] : {};
    if (u % 2)
      y(Object(l), true).forEach(function (u) {
        module50.default(t, u, l[u]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(l));
    else
      y(Object(l)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(l, n));
      });
  }

  return t;
}

function v(t) {
  var n = b();
  return function () {
    var u,
      l = module37.default(t);

    if (n) {
      var o = module37.default(this).constructor;
      u = Reflect.construct(l, arguments, o);
    } else u = l.apply(this, arguments);

    return module40.default(this, u);
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

exports.LightSpeedInRight = (function (t, ...args) {
  module38.default(f, t);
  var n = v(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        l = t.getAnimationAndConfig(),
        o = module15.default(l, 2),
        c = o[0],
        f = o[1],
        s = t.getDelay(),
        h = t.getDuration(),
        y = t.callbackV,
        v = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            opacity: n(
              s,
              module445.withTiming(1, {
                duration: h,
              })
            ),
            transform: [
              {
                translateX: n(
                  s,
                  c(
                    0,
                    w(
                      w({}, f),
                      {},
                      {
                        duration: 0.7 * h,
                      }
                    )
                  )
                ),
              },
              {
                skewX: n(
                  s,
                  module445.withSequence(
                    module445.withTiming('10deg', {
                      duration: 0.7 * h,
                    }),
                    module445.withTiming('-5deg', {
                      duration: 0.15 * h,
                    }),
                    module445.withTiming('0deg', {
                      duration: 0.15 * h,
                    })
                  )
                ),
              },
            ],
          },
          initialValues: w(
            {
              opacity: 0,
              transform: [
                {
                  translateX: t.windowWidth,
                },
                {
                  skewX: '-45deg',
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

exports.LightSpeedInLeft = (function (t, ...args) {
  module38.default(f, t);
  var n = v(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        l = t.getAnimationAndConfig(),
        o = module15.default(l, 2),
        c = o[0],
        f = o[1],
        s = t.getDelay(),
        h = t.getDuration(),
        y = t.callbackV,
        v = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            opacity: n(
              s,
              module445.withTiming(1, {
                duration: h,
              })
            ),
            transform: [
              {
                translateX: n(
                  s,
                  c(
                    0,
                    w(
                      w({}, f),
                      {},
                      {
                        duration: 0.7 * h,
                      }
                    )
                  )
                ),
              },
              {
                skewX: n(
                  s,
                  module445.withSequence(
                    module445.withTiming('-10deg', {
                      duration: 0.7 * h,
                    }),
                    module445.withTiming('5deg', {
                      duration: 0.15 * h,
                    }),
                    module445.withTiming('0deg', {
                      duration: 0.15 * h,
                    })
                  )
                ),
              },
            ],
          },
          initialValues: w(
            {
              opacity: 0,
              transform: [
                {
                  translateX: -t.windowWidth,
                },
                {
                  skewX: '45deg',
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

exports.LightSpeedOutRight = (function (t, ...args) {
  module38.default(f, t);
  var n = v(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        l = t.getAnimationAndConfig(),
        o = module15.default(l, 2),
        c = o[0],
        f = o[1],
        s = t.getDelay(),
        p = t.callbackV,
        h = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            opacity: n(s, c(0, f)),
            transform: [
              {
                translateX: n(s, c(t.windowWidth, f)),
              },
              {
                skewX: n(s, c('-45deg', f)),
              },
            ],
          },
          initialValues: w(
            {
              opacity: 1,
              transform: [
                {
                  translateX: 0,
                },
                {
                  skewX: '0deg',
                },
              ],
            },
            h
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

exports.LightSpeedOutLeft = (function (t, ...args) {
  module38.default(f, t);
  var n = v(f);

  function f() {
    var t;
    module27.default(this, f);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        l = t.getAnimationAndConfig(),
        o = module15.default(l, 2),
        c = o[0],
        f = o[1],
        s = t.getDelay(),
        p = t.callbackV,
        h = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            opacity: n(s, c(0, f)),
            transform: [
              {
                translateX: n(s, c(-t.windowWidth, f)),
              },
              {
                skewX: n(s, c('45deg', f)),
              },
            ],
          },
          initialValues: w(
            {
              opacity: 1,
              transform: [
                {
                  translateX: 0,
                },
                {
                  skewX: '0deg',
                },
              ],
            },
            h
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
