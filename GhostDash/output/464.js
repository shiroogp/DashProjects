var module50 = require('./50'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module445 = require('./445'),
  module452 = require('./452');

function w(t, n) {
  var u = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var o = Object.getOwnPropertySymbols(t);
    if (n)
      o = o.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    u.push.apply(u, o);
  }

  return u;
}

function v(t) {
  for (var u = 1; u < arguments.length; u++) {
    var o = null != arguments[u] ? arguments[u] : {};
    if (u % 2)
      w(Object(o), true).forEach(function (u) {
        module50.default(t, u, o[u]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(o));
    else
      w(Object(o)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(o, n));
      });
  }

  return t;
}

function y(t) {
  var n = k();
  return function () {
    var u,
      o = module37.default(t);

    if (n) {
      var l = module37.default(this).constructor;
      u = Reflect.construct(o, arguments, l);
    } else u = o.apply(this, arguments);

    return module40.default(this, u);
  };
}

function k() {
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

exports.BounceIn = (function (t, ...args) {
  module38.default(c, t);
  var n = y(c);

  function c() {
    var t;
    module27.default(this, c);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getDelay(),
        o = t.getDuration(),
        l = t.callbackV,
        c = t.initialValues;
      return function () {
        'worklet';

        return {
          animations: {
            transform: [
              {
                scale: n(
                  u,
                  module445.withSequence(
                    module445.withTiming(1.2, {
                      duration: 0.55 * o,
                    }),
                    module445.withTiming(0.9, {
                      duration: 0.15 * o,
                    }),
                    module445.withTiming(1.1, {
                      duration: 0.15 * o,
                    }),
                    module445.withTiming(1, {
                      duration: 0.15 * o,
                    })
                  )
                ),
              },
            ],
          },
          initialValues: v(
            {
              transform: [
                {
                  scale: 0,
                },
              ],
            },
            c
          ),
          callback: l,
        };
      };
    };

    return t;
  }

  module28.default(
    c,
    [
      {
        key: 'getDuration',
        value: function () {
          var t;
          return null != (t = this.durationV) ? t : 600;
        },
      },
    ],
    [
      {
        key: 'createInstance',
        value: function () {
          return new c();
        },
      },
      {
        key: 'getDuration',
        value: function () {
          return 600;
        },
      },
    ]
  );
  return c;
})(module452.ComplexAnimationBuilder);

exports.BounceInDown = (function (t, ...args) {
  module38.default(c, t);
  var n = y(c);

  function c() {
    var t;
    module27.default(this, c);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getDelay(),
        o = t.getDuration(),
        l = t.callbackV,
        c = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            transform: [
              {
                translateY: n(
                  u,
                  module445.withSequence(
                    module445.withTiming(-20, {
                      duration: 0.55 * o,
                    }),
                    module445.withTiming(10, {
                      duration: 0.15 * o,
                    }),
                    module445.withTiming(-10, {
                      duration: 0.15 * o,
                    }),
                    module445.withTiming(0, {
                      duration: 0.15 * o,
                    })
                  )
                ),
              },
            ],
          },
          initialValues: v(
            {
              transform: [
                {
                  translateY: t.windowHeight,
                },
              ],
            },
            c
          ),
          callback: l,
        };
      };
    };

    return t;
  }

  module28.default(
    c,
    [
      {
        key: 'getDuration',
        value: function () {
          var t;
          return null != (t = this.durationV) ? t : 600;
        },
      },
    ],
    [
      {
        key: 'createInstance',
        value: function () {
          return new c();
        },
      },
      {
        key: 'getDuration',
        value: function () {
          return 600;
        },
      },
    ]
  );
  return c;
})(module452.ComplexAnimationBuilder);

exports.BounceInUp = (function (t, ...args) {
  module38.default(c, t);
  var n = y(c);

  function c() {
    var t;
    module27.default(this, c);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getDelay(),
        o = t.getDuration(),
        l = t.callbackV,
        c = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            transform: [
              {
                translateY: n(
                  u,
                  module445.withSequence(
                    module445.withTiming(20, {
                      duration: 0.55 * o,
                    }),
                    module445.withTiming(-10, {
                      duration: 0.15 * o,
                    }),
                    module445.withTiming(10, {
                      duration: 0.15 * o,
                    }),
                    module445.withTiming(0, {
                      duration: 0.15 * o,
                    })
                  )
                ),
              },
            ],
          },
          initialValues: v(
            {
              transform: [
                {
                  translateY: -t.windowHeight,
                },
              ],
            },
            c
          ),
          callback: l,
        };
      };
    };

    return t;
  }

  module28.default(
    c,
    [
      {
        key: 'getDuration',
        value: function () {
          var t;
          return null != (t = this.durationV) ? t : 600;
        },
      },
    ],
    [
      {
        key: 'createInstance',
        value: function () {
          return new c();
        },
      },
      {
        key: 'getDuration',
        value: function () {
          return 600;
        },
      },
    ]
  );
  return c;
})(module452.ComplexAnimationBuilder);

exports.BounceInLeft = (function (t, ...args) {
  module38.default(c, t);
  var n = y(c);

  function c() {
    var t;
    module27.default(this, c);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getDelay(),
        o = t.getDuration(),
        l = t.callbackV,
        c = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            transform: [
              {
                translateX: n(
                  u,
                  module445.withSequence(
                    module445.withTiming(20, {
                      duration: 0.55 * o,
                    }),
                    module445.withTiming(-10, {
                      duration: 0.15 * o,
                    }),
                    module445.withTiming(10, {
                      duration: 0.15 * o,
                    }),
                    module445.withTiming(0, {
                      duration: 0.15 * o,
                    })
                  )
                ),
              },
            ],
          },
          initialValues: v(
            {
              transform: [
                {
                  translateX: -t.windowWidth,
                },
              ],
            },
            c
          ),
          callback: l,
        };
      };
    };

    return t;
  }

  module28.default(
    c,
    [
      {
        key: 'getDuration',
        value: function () {
          var t;
          return null != (t = this.durationV) ? t : 600;
        },
      },
    ],
    [
      {
        key: 'createInstance',
        value: function () {
          return new c();
        },
      },
      {
        key: 'getDuration',
        value: function () {
          return 600;
        },
      },
    ]
  );
  return c;
})(module452.ComplexAnimationBuilder);

exports.BounceInRight = (function (t, ...args) {
  module38.default(c, t);
  var n = y(c);

  function c() {
    var t;
    module27.default(this, c);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getDelay(),
        o = t.getDuration(),
        l = t.callbackV,
        c = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            transform: [
              {
                translateX: n(
                  u,
                  module445.withSequence(
                    module445.withTiming(-20, {
                      duration: 0.55 * o,
                    }),
                    module445.withTiming(10, {
                      duration: 0.15 * o,
                    }),
                    module445.withTiming(-10, {
                      duration: 0.15 * o,
                    }),
                    module445.withTiming(0, {
                      duration: 0.15 * o,
                    })
                  )
                ),
              },
            ],
          },
          initialValues: v(
            {
              transform: [
                {
                  translateX: t.windowWidth,
                },
              ],
            },
            c
          ),
          callback: l,
        };
      };
    };

    return t;
  }

  module28.default(
    c,
    [
      {
        key: 'getDuration',
        value: function () {
          var t;
          return null != (t = this.durationV) ? t : 600;
        },
      },
    ],
    [
      {
        key: 'createInstance',
        value: function () {
          return new c();
        },
      },
      {
        key: 'getDuration',
        value: function () {
          return 600;
        },
      },
    ]
  );
  return c;
})(module452.ComplexAnimationBuilder);

exports.BounceOut = (function (t, ...args) {
  module38.default(c, t);
  var n = y(c);

  function c() {
    var t;
    module27.default(this, c);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getDelay(),
        o = t.getDuration(),
        l = t.callbackV,
        c = t.initialValues;
      return function () {
        'worklet';

        return {
          animations: {
            transform: [
              {
                scale: n(
                  u,
                  module445.withSequence(
                    module445.withTiming(1.1, {
                      duration: 0.15 * o,
                    }),
                    module445.withTiming(0.9, {
                      duration: 0.15 * o,
                    }),
                    module445.withTiming(1.2, {
                      duration: 0.15 * o,
                    }),
                    module445.withTiming(0, {
                      duration: 0.55 * o,
                    })
                  )
                ),
              },
            ],
          },
          initialValues: v(
            {
              transform: [
                {
                  scale: 1,
                },
              ],
            },
            c
          ),
          callback: l,
        };
      };
    };

    return t;
  }

  module28.default(
    c,
    [
      {
        key: 'getDuration',
        value: function () {
          var t;
          return null != (t = this.durationV) ? t : 600;
        },
      },
    ],
    [
      {
        key: 'createInstance',
        value: function () {
          return new c();
        },
      },
      {
        key: 'getDuration',
        value: function () {
          return 600;
        },
      },
    ]
  );
  return c;
})(module452.ComplexAnimationBuilder);

exports.BounceOutDown = (function (t, ...args) {
  module38.default(c, t);
  var n = y(c);

  function c() {
    var t;
    module27.default(this, c);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getDelay(),
        o = t.getDuration(),
        l = t.callbackV,
        c = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            transform: [
              {
                translateY: n(
                  u,
                  module445.withSequence(
                    module445.withTiming(-10, {
                      duration: 0.15 * o,
                    }),
                    module445.withTiming(10, {
                      duration: 0.15 * o,
                    }),
                    module445.withTiming(-20, {
                      duration: 0.15 * o,
                    }),
                    module445.withTiming(t.windowHeight, {
                      duration: 0.55 * o,
                    })
                  )
                ),
              },
            ],
          },
          initialValues: v(
            {
              transform: [
                {
                  translateY: 0,
                },
              ],
            },
            c
          ),
          callback: l,
        };
      };
    };

    return t;
  }

  module28.default(
    c,
    [
      {
        key: 'getDuration',
        value: function () {
          var t;
          return null != (t = this.durationV) ? t : 600;
        },
      },
    ],
    [
      {
        key: 'createInstance',
        value: function () {
          return new c();
        },
      },
      {
        key: 'getDuration',
        value: function () {
          return 600;
        },
      },
    ]
  );
  return c;
})(module452.ComplexAnimationBuilder);

exports.BounceOutUp = (function (t, ...args) {
  module38.default(c, t);
  var n = y(c);

  function c() {
    var t;
    module27.default(this, c);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getDelay(),
        o = t.getDuration(),
        l = t.callbackV,
        c = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            transform: [
              {
                translateY: n(
                  u,
                  module445.withSequence(
                    module445.withTiming(10, {
                      duration: 0.15 * o,
                    }),
                    module445.withTiming(-10, {
                      duration: 0.15 * o,
                    }),
                    module445.withTiming(20, {
                      duration: 0.15 * o,
                    }),
                    module445.withTiming(-t.windowHeight, {
                      duration: 0.55 * o,
                    })
                  )
                ),
              },
            ],
          },
          initialValues: v(
            {
              transform: [
                {
                  translateY: 0,
                },
              ],
            },
            c
          ),
          callback: l,
        };
      };
    };

    return t;
  }

  module28.default(
    c,
    [
      {
        key: 'getDuration',
        value: function () {
          var t;
          return null != (t = this.durationV) ? t : 600;
        },
      },
    ],
    [
      {
        key: 'createInstance',
        value: function () {
          return new c();
        },
      },
      {
        key: 'getDuration',
        value: function () {
          return 600;
        },
      },
    ]
  );
  return c;
})(module452.ComplexAnimationBuilder);

exports.BounceOutLeft = (function (t, ...args) {
  module38.default(c, t);
  var n = y(c);

  function c() {
    var t;
    module27.default(this, c);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getDelay(),
        o = t.getDuration(),
        l = t.callbackV,
        c = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            transform: [
              {
                translateX: n(
                  u,
                  module445.withSequence(
                    module445.withTiming(10, {
                      duration: 0.15 * o,
                    }),
                    module445.withTiming(-10, {
                      duration: 0.15 * o,
                    }),
                    module445.withTiming(20, {
                      duration: 0.15 * o,
                    }),
                    module445.withTiming(-t.windowWidth, {
                      duration: 0.55 * o,
                    })
                  )
                ),
              },
            ],
          },
          initialValues: v(
            {
              transform: [
                {
                  translateX: 0,
                },
              ],
            },
            c
          ),
          callback: l,
        };
      };
    };

    return t;
  }

  module28.default(
    c,
    [
      {
        key: 'getDuration',
        value: function () {
          var t;
          return null != (t = this.durationV) ? t : 600;
        },
      },
    ],
    [
      {
        key: 'createInstance',
        value: function () {
          return new c();
        },
      },
      {
        key: 'getDuration',
        value: function () {
          return 600;
        },
      },
    ]
  );
  return c;
})(module452.ComplexAnimationBuilder);

exports.BounceOutRight = (function (t, ...args) {
  module38.default(c, t);
  var n = y(c);

  function c() {
    var t;
    module27.default(this, c);

    (t = n.call(this, ...args)).build = function () {
      var n = t.getDelayFunction(),
        u = t.getDelay(),
        o = t.getDuration(),
        l = t.callbackV,
        c = t.initialValues;
      return function (t) {
        'worklet';

        return {
          animations: {
            transform: [
              {
                translateX: n(
                  u,
                  module445.withSequence(
                    module445.withTiming(-10, {
                      duration: 0.15 * o,
                    }),
                    module445.withTiming(10, {
                      duration: 0.15 * o,
                    }),
                    module445.withTiming(-20, {
                      duration: 0.15 * o,
                    }),
                    module445.withTiming(t.windowWidth, {
                      duration: 0.55 * o,
                    })
                  )
                ),
              },
            ],
          },
          initialValues: v(
            {
              transform: [
                {
                  translateX: 0,
                },
              ],
            },
            c
          ),
          callback: l,
        };
      };
    };

    return t;
  }

  module28.default(
    c,
    [
      {
        key: 'getDuration',
        value: function () {
          var t;
          return null != (t = this.durationV) ? t : 600;
        },
      },
    ],
    [
      {
        key: 'createInstance',
        value: function () {
          return new c();
        },
      },
      {
        key: 'getDuration',
        value: function () {
          return 600;
        },
      },
    ]
  );
  return c;
})(module452.ComplexAnimationBuilder);
