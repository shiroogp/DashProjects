var module15 = require('@babel/runtime/helpers/slicedToArray'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module452 = require('./452');

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

var y = (exports.LinearTransition = (function (t, ...args) {
  module38.default(p, t);

  var module452 = p,
    y = s(),
    v = function () {
      var t,
        n = module37.default(module452);

      if (y) {
        var u = module37.default(this).constructor;
        t = Reflect.construct(n, arguments, u);
      } else t = n.apply(this, arguments);

      return module40.default(this, t);
    };

  function p() {
    var t;
    module27.default(this, p);

    (t = v.call(this, ...args)).build = function () {
      var u = t.getDelayFunction(),
        o = t.getAnimationAndConfig(),
        c = module15.default(o, 2),
        l = c[0],
        f = c[1],
        h = t.callbackV,
        s = t.getDelay();
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
            originX: u(s, l(t.targetOriginX, f)),
            originY: u(s, l(t.targetOriginY, f)),
            width: u(s, l(t.targetWidth, f)),
            height: u(s, l(t.targetHeight, f)),
          },
          callback: h,
        };
      };
    };

    return t;
  }

  module28.default(p, null, [
    {
      key: 'createInstance',
      value: function () {
        return new p();
      },
    },
  ]);
  return p;
})(module452.ComplexAnimationBuilder));

exports.Layout = y;
