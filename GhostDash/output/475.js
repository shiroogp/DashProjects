exports.combineTransition = function (t, n) {
  return b.entering(n).exiting(t);
};

var module50 = require('./50'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module443 = require('./443'),
  module445 = require('./445'),
  module461 = require('./461');

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

function p(t) {
  for (var o = 1; o < arguments.length; o++) {
    var u = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      y(Object(u), true).forEach(function (o) {
        module50.default(t, o, u[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(u));
    else
      y(Object(u)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(u, n));
      });
  }

  return t;
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

var b = (exports.EntryExitTransition = (function (t, ...args) {
  module38.default(w, t);

  var module443 = w,
    y = O(),
    b = function () {
      var t,
        n = module37.default(module443);

      if (y) {
        var o = module37.default(this).constructor;
        t = Reflect.construct(n, arguments, o);
      } else t = n.apply(this, arguments);

      return module40.default(this, t);
    };

  function w() {
    var t;
    module27.default(this, w);
    (t = b.call(this, ...args)).enteringV = module461.FadeIn;
    t.exitingV = module461.FadeOut;

    t.build = function () {
      var o = t.getDelayFunction(),
        u = t.callbackV,
        l = t.getDelay(),
        c = t.enteringV.build(),
        s = t.exitingV.build(),
        f = t.exitingV.getDuration();
      return function (t) {
        'worklet';

        for (
          var v,
            y,
            O = c(t),
            b = s(t),
            w = {
              transform: [],
            },
            j = 0,
            V = Object.keys(b.animations);
          j < V.length;
          j++
        ) {
          var k = V[j];

          if ('transform' === k) {
            var T;
            if (!(null == (T = b.animations[k])))
              T.forEach(function (t, u) {
                for (var c = 0, s = Object.keys(t); c < s.length; c++) {
                  var f,
                    v = s[c];
                  if (!(null == (f = w.transform)))
                    f.push(
                      module50.default(
                        {},
                        v,
                        o(
                          l,
                          module445.withSequence(
                            t[v],
                            module445.withTiming(b.initialValues.transform ? b.initialValues.transform[u][v] : 0, {
                              duration: 0,
                            })
                          )
                        )
                      )
                    );
                }
              });
          } else {
            var x =
              undefined !== O.animations[k]
                ? [
                    b.animations[k],
                    module445.withTiming(O.initialValues[k], {
                      duration: 0,
                    }),
                    O.animations[k],
                  ]
                : [
                    b.animations[k],
                    module445.withTiming(Object.keys(t).includes(k) ? t[k] : b.initialValues[k], {
                      duration: 0,
                    }),
                  ];
            w[k] = o(l, module445.withSequence.apply(undefined, x));
          }
        }

        for (var P = 0, E = Object.keys(O.animations); P < E.length; P++) {
          var D = E[P];

          if ('transform' === D) {
            var R;
            if (!(null == (R = O.animations[D])))
              R.forEach(function (t, u) {
                for (var c = 0, s = Object.keys(t); c < s.length; c++) {
                  var v,
                    y = s[c];
                  if (!(null == (v = w.transform)))
                    v.push(
                      module50.default(
                        {},
                        y,
                        o(
                          l + f,
                          module445.withSequence(
                            module445.withTiming(O.initialValues.transform ? O.initialValues.transform[u][y] : 0, {
                              duration: f,
                            }),
                            t[y]
                          )
                        )
                      )
                    );
                }
              });
          } else {
            if (undefined !== w[D]) continue;
            w[D] = o(
              l,
              module445.withSequence(
                module445.withTiming(O.initialValues[D], {
                  duration: 0,
                }),
                O.animations[D]
              )
            );
          }
        }

        var S = (null != (v = b.initialValues.transform) ? v : []).concat(
          (null != (y = O.animations.transform) ? y : []).map(function (t) {
            var o = Object.keys(t);

            if ((null == o ? undefined : o.length) < 1) {
              console.error('[Reanimated]: ${value} is not a valid Transform object');
              return t;
            }

            var u = o[0],
              l = t[u].current;
            if ('string' == typeof l) return l.includes('deg') ? module50.default({}, u, '0deg') : module50.default({}, u, '0');
            else return u.includes('translate') ? module50.default({}, u, 0) : module50.default({}, u, 1);
          })
        );
        return {
          initialValues: p(
            p({}, b.initialValues),
            {},
            {
              originX: t.currentOriginX,
              originY: t.currentOriginY,
              width: t.currentWidth,
              height: t.currentHeight,
              transform: S,
            }
          ),
          animations: p(
            {
              originX: o(
                l + f,
                module445.withTiming(t.targetOriginX, {
                  duration: f,
                })
              ),
              originY: o(
                l + f,
                module445.withTiming(t.targetOriginY, {
                  duration: f,
                })
              ),
              width: o(
                l + f,
                module445.withTiming(t.targetWidth, {
                  duration: f,
                })
              ),
              height: o(
                l + f,
                module445.withTiming(t.targetHeight, {
                  duration: f,
                })
              ),
            },
            w
          ),
          callback: u,
        };
      };
    };

    return t;
  }

  module28.default(
    w,
    [
      {
        key: 'entering',
        value: function (t) {
          this.enteringV = t;
          return this;
        },
      },
      {
        key: 'exiting',
        value: function (t) {
          this.exitingV = t;
          return this;
        },
      },
    ],
    [
      {
        key: 'createInstance',
        value: function () {
          return new w();
        },
      },
      {
        key: 'entering',
        value: function (t) {
          return this.createInstance().entering(t);
        },
      },
      {
        key: 'exiting',
        value: function (t) {
          return this.createInstance().exiting(t);
        },
      },
    ]
  );
  return w;
})(module443.BaseAnimationBuilder));
