var module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module445 = require('./445'),
  module443 = require('./443');

function s() {
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

exports.FadingTransition = (function (t, ...args) {
  module38.default(w, t);

  var module443 = w,
    y = s(),
    v = function () {
      var t,
        n = module37.default(module443);

      if (y) {
        var u = module37.default(this).constructor;
        t = Reflect.construct(n, arguments, u);
      } else t = n.apply(this, arguments);

      return module40.default(this, t);
    };

  function w() {
    var t;
    module27.default(this, w);

    (t = v.call(this, ...args)).build = function () {
      var n,
        u = t.getDelayFunction(),
        o = t.callbackV,
        c = t.getDelay(),
        l = null != (n = t.durationV) ? n : 500;
      return function (t) {
        'worklet';

        return {
          initialValues: {
            opacity: 1,
            originX: t.currentOriginX,
            originY: t.currentOriginY,
            width: t.currentWidth,
            height: t.currentHeight,
          },
          animations: {
            opacity: u(
              c,
              module445.withSequence(
                module445.withTiming(0, {
                  duration: l,
                }),
                module445.withTiming(1, {
                  duration: l,
                })
              )
            ),
            originX: u(
              c + l,
              module445.withTiming(t.targetOriginX, {
                duration: 50,
              })
            ),
            originY: u(
              c + l,
              module445.withTiming(t.targetOriginY, {
                duration: 50,
              })
            ),
            width: u(
              c + l,
              module445.withTiming(t.targetWidth, {
                duration: 50,
              })
            ),
            height: u(
              c + l,
              module445.withTiming(t.targetHeight, {
                duration: 50,
              })
            ),
          },
          callback: o,
        };
      };
    };

    return t;
  }

  module28.default(w, null, [
    {
      key: 'createInstance',
      value: function () {
        return new w();
      },
    },
  ]);
  return w;
})(module443.BaseAnimationBuilder);
