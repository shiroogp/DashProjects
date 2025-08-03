var module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module443 = require('./443'),
  module440 = require('./440'),
  module445 = require('./445');

function v() {
  if ('undefined' == typeof Reflect || !Reflect.construct) return false;
  if (Reflect.construct.sham) return false;
  if ('function' == typeof Proxy) return true;

  try {
    Boolean.prototype.valueOf.call(Reflect.construct(Boolean, [], function () {}));
    return true;
  } catch (n) {
    return false;
  }
}

exports.CurvedTransition = (function (n, ...args) {
  module38.default(k, n);

  var module443 = k,
    y = v(),
    V = function () {
      var n,
        t = module37.default(module443);

      if (y) {
        var s = module37.default(this).constructor;
        n = Reflect.construct(t, arguments, s);
      } else n = t.apply(this, arguments);

      return module40.default(this, n);
    };

  function k() {
    var n;
    module27.default(this, k);
    (n = V.call(this, ...args)).easingXV = module440.Easing.in(module440.Easing.ease);
    n.easingYV = module440.Easing.out(module440.Easing.ease);
    n.easingWidthV = module440.Easing.in(module440.Easing.exp);
    n.easingHeightV = module440.Easing.out(module440.Easing.exp);

    n.build = function () {
      var t,
        s = n.getDelayFunction(),
        u = n.callbackV,
        c = n.getDelay(),
        o = null != (t = n.durationV) ? t : 300,
        h = {
          easingX: n.easingXV,
          easingY: n.easingYV,
          easingWidth: n.easingWidthV,
          easingHeight: n.easingHeightV,
        };
      return function (n) {
        'worklet';

        return {
          initialValues: {
            originX: n.currentOriginX,
            originY: n.currentOriginY,
            width: n.currentWidth,
            height: n.currentHeight,
          },
          animations: {
            originX: s(
              c,
              module445.withTiming(n.targetOriginX, {
                duration: o,
                easing: h.easingX,
              })
            ),
            originY: s(
              c,
              module445.withTiming(n.targetOriginY, {
                duration: o,
                easing: h.easingY,
              })
            ),
            width: s(
              c,
              module445.withTiming(n.targetWidth, {
                duration: o,
                easing: h.easingWidth,
              })
            ),
            height: s(
              c,
              module445.withTiming(n.targetHeight, {
                duration: o,
                easing: h.easingHeight,
              })
            ),
          },
          callback: u,
        };
      };
    };

    return n;
  }

  module28.default(
    k,
    [
      {
        key: 'easingX',
        value: function (n) {
          this.easingXV = n;
          return this;
        },
      },
      {
        key: 'easingY',
        value: function (n) {
          this.easingYV = n;
          return this;
        },
      },
      {
        key: 'easingWidth',
        value: function (n) {
          this.easingWidthV = n;
          return this;
        },
      },
      {
        key: 'easingHeight',
        value: function (n) {
          this.easingHeightV = n;
          return this;
        },
      },
    ],
    [
      {
        key: 'createInstance',
        value: function () {
          return new k();
        },
      },
      {
        key: 'easingX',
        value: function (n) {
          return this.createInstance().easingX(n);
        },
      },
      {
        key: 'easingY',
        value: function (n) {
          return this.createInstance().easingY(n);
        },
      },
      {
        key: 'easingWidth',
        value: function (n) {
          return this.createInstance().easingWidth(n);
        },
      },
      {
        key: 'easingHeight',
        value: function (n) {
          return this.createInstance().easingHeight(n);
        },
      },
    ]
  );
  return k;
})(module443.BaseAnimationBuilder);
