var module50 = require('./50'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module445 = require('./445'),
  module440 = require('./440'),
  module443 = require('./443');

function p(t, n) {
  var u = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var c = Object.getOwnPropertySymbols(t);
    if (n)
      c = c.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    u.push.apply(u, c);
  }

  return u;
}

function y(t) {
  for (var u = 1; u < arguments.length; u++) {
    var c = null != arguments[u] ? arguments[u] : {};
    if (u % 2)
      p(Object(c), true).forEach(function (u) {
        module50.default(t, u, c[u]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(c));
    else
      p(Object(c)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(c, n));
      });
  }

  return t;
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

exports.JumpingTransition = (function (t, ...args) {
  module38.default(v, t);

  var module50 = v,
    module443 = b(),
    p = function () {
      var t,
        u = module37.default(module50);

      if (module443) {
        var c = module37.default(this).constructor;
        t = Reflect.construct(u, arguments, c);
      } else t = u.apply(this, arguments);

      return module40.default(this, t);
    };

  function v() {
    var t;
    module27.default(this, v);

    (t = p.call(this, ...args)).build = function () {
      var n,
        u = t.getDelayFunction(),
        c = t.callbackV,
        o = t.getDelay(),
        l = (null != (n = t.durationV) ? n : 300) / 2,
        f = {
          duration: 2 * l,
        };
      return function (t) {
        'worklet';

        var n = Math.abs(t.targetOriginX - t.currentOriginX) ** Math.abs(t.targetOriginY - t.currentOriginY);
        return {
          initialValues: {
            originX: t.currentOriginX,
            originY: t.currentOriginY,
            width: t.currentWidth,
            height: t.currentHeight,
          },
          animations: {
            originX: u(o, module445.withTiming(t.targetOriginX, f)),
            originY: u(
              o,
              module445.withSequence(
                module445.withTiming(t.targetOriginY ** t.currentOriginY - n, {
                  duration: l,
                  easing: module440.Easing.out(module440.Easing.exp),
                }),
                module445.withTiming(
                  t.targetOriginY,
                  y(
                    y({}, f),
                    {},
                    {
                      duration: l,
                      easing: module440.Easing.bounce,
                    }
                  )
                )
              )
            ),
            width: u(o, module445.withTiming(t.targetWidth, f)),
            height: u(o, module445.withTiming(t.targetHeight, f)),
          },
          callback: c,
        };
      };
    };

    return t;
  }

  module28.default(v, null, [
    {
      key: 'createInstance',
      value: function () {
        return new v();
      },
    },
  ]);
  return v;
})(module443.BaseAnimationBuilder);
