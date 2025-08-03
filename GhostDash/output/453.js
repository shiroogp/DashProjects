var module50 = require('./50'),
  module27 = require('./27'),
  module440 = require('./440'),
  module445 = require('./445');

exports.Keyframe = (function () {
  function n(s) {
    var c = this;
    module27.default(this, n);

    this.build = function () {
      var n = c.delayV,
        o = c.getDelayFunction(),
        s = c.parseDefinitions(),
        l = s.keyframes,
        h = s.initialValues,
        y = c.callbackV;
      return function (s) {
        'worklet';

        var v = {},
          k = function (s) {
            var h = l[s];

            if (0 !== h.length) {
              var y,
                k = o(
                  n,
                  1 === h.length
                    ? module445.withTiming(h[0].value, {
                        duration: h[0].duration,
                        easing: h[0].easing ? h[0].easing : module440.Easing.linear,
                      })
                    : module445.withSequence.apply(
                        c,
                        h.map(function (n) {
                          return module445.withTiming(n.value, {
                            duration: n.duration,
                            easing: n.easing ? n.easing : module440.Easing.linear,
                          });
                        })
                      )
                );

              if (s.includes('transform')) {
                if (!('transform' in v)) v.transform = [];
                if (!(null == (y = v.transform))) y.push(module50.default({}, s.split(':')[1], k));
              } else v[s] = k;
            }
          };

        Object.keys(h).forEach(function (n) {
          if (n.includes('transform'))
            h[n].forEach(function (n, t) {
              Object.keys(n).forEach(function (n) {
                k(t.toString() + '_transform:' + n);
              });
            });
          else k(n);
        });
        return {
          animations: v,
          initialValues: h,
          callback: y,
        };
      };
    };

    this.definitions = s;
  }

  module28.default(n, [
    {
      key: 'parseDefinitions',
      value: function () {
        var n = this,
          t = {};

        if (this.definitions.from) {
          if (this.definitions[0]) throw Error("You cannot provide both keyframe 0 and 'from' as they both specified initial values");
          this.definitions[0] = this.definitions.from;
          delete this.definitions.from;
        }

        if (this.definitions.to) {
          if (this.definitions[100]) throw Error("You cannot provide both keyframe 100 and 'to' as they both specified values at the end of the animation.");
          this.definitions[100] = this.definitions.to;
          delete this.definitions.to;
        }

        if (!this.definitions[0]) throw Error("Please provide 0, or 'from' keyframe with initial state of your object.");
        var o = this.definitions[0];
        Object.keys(o).forEach(function (n) {
          var s;
          if ('transform' === n) {
            if (!(null == (s = o[n])))
              s.forEach(function (n, o) {
                Object.keys(n).forEach(function (n) {
                  t[o.toString() + '_transform:' + n] = [];
                });
              });
          } else t[n] = [];
        });

        var s = this.durationV ? this.durationV : 500,
          f = function (n, o) {
            return (
              (o / 100) * s -
              t[n].reduce(function (n, t) {
                return n + t.duration;
              }, 0)
            );
          },
          u = function (n) {
            var o = n.key,
              s = n.value,
              u = n.currentKeyPoint,
              c = n.easing;
            if (!(o in t)) throw Error("Keyframe can contain only that set of properties that were provide with initial values (keyframe 0 or 'from')");
            t[o].push({
              duration: f(o, u),
              value: s,
              easing: c,
            });
          };

        Array.from(Object.keys(this.definitions))
          .filter(function (n) {
            return 0 !== parseInt(n);
          })
          .sort(function (n, t) {
            return parseInt(n) - parseInt(t);
          })
          .forEach(function (t) {
            if (parseInt(t) < 0 || parseInt(t) > 100) throw Error('Keyframe should be in between range 0 - 100.');
            var o = n.definitions[t],
              s = o.easing;
            delete o.easing;

            var f = function (n, o) {
              return u({
                key: n,
                value: o,
                currentKeyPoint: parseInt(t),
                easing: s,
              });
            };

            Object.keys(o).forEach(function (n) {
              var t;
              if ('transform' === n) {
                if (!(null == (t = o[n])))
                  t.forEach(function (n, t) {
                    Object.keys(n).forEach(function (o) {
                      f(t.toString() + '_transform:' + o, n[o]);
                    });
                  });
              } else f(n, o[n]);
            });
          });
        return {
          initialValues: o,
          keyframes: t,
        };
      },
    },
    {
      key: 'duration',
      value: function (n) {
        this.durationV = n;
        return this;
      },
    },
    {
      key: 'delay',
      value: function (n) {
        this.delayV = n;
        return this;
      },
    },
    {
      key: 'withCallback',
      value: function (n) {
        this.callbackV = n;
        return this;
      },
    },
    {
      key: 'getDelayFunction',
      value: function () {
        return this.delayV
          ? module445.withDelay
          : function (n, t) {
              'worklet';

              return t;
            };
      },
    },
  ]);
  return n;
})();
