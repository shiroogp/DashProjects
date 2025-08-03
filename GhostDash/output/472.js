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

exports.SequencedTransition = (function (t, ...args) {
  module38.default(y, t);

  var module443 = y,
    v = s(),
    w = function () {
      var t,
        n = module37.default(module443);

      if (v) {
        var u = module37.default(this).constructor;
        t = Reflect.construct(n, arguments, u);
      } else t = n.apply(this, arguments);

      return module40.default(this, t);
    };

  function y() {
    var t;
    module27.default(this, y);
    (t = w.call(this, ...args)).reversed = false;

    t.build = function () {
      var n,
        u = t.getDelayFunction(),
        c = t.callbackV,
        o = t.getDelay(),
        l = {
          duration: (null != (n = t.durationV) ? n : 500) / 2,
        },
        f = t.reversed;
      return function (t) {
        'worklet';

        return {
          initialValues: {
            originX: t.currentOriginX,
            originY: t.currentOriginY,
            width: t.currentWidth,
            height: t.currentHeight,
          },
          animations: {
            originX: u(o, module445.withSequence(module445.withTiming(f ? t.currentOriginX : t.targetOriginX, l), module445.withTiming(t.targetOriginX, l))),
            originY: u(o, module445.withSequence(module445.withTiming(f ? t.targetOriginY : t.currentOriginY, l), module445.withTiming(t.targetOriginY, l))),
            width: u(o, module445.withSequence(module445.withTiming(f ? t.currentWidth : t.targetWidth, l), module445.withTiming(t.targetWidth, l))),
            height: u(o, module445.withSequence(module445.withTiming(f ? t.targetHeight : t.currentHeight, l), module445.withTiming(t.targetHeight, l))),
          },
          callback: c,
        };
      };
    };

    return t;
  }

  module28.default(
    y,
    [
      {
        key: 'reverse',
        value: function () {
          this.reversed = !this.reversed;
          return this;
        },
      },
    ],
    [
      {
        key: 'createInstance',
        value: function () {
          return new y();
        },
      },
      {
        key: 'reverse',
        value: function () {
          return y.createInstance().reverse();
        },
      },
    ]
  );
  return y;
})(module443.BaseAnimationBuilder);
