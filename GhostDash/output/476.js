var module27 = require('./27'),
  module445 = require('./445'),
  s = ['width', 'height', 'originX', 'originY', 'transform'],
  f = (exports.SharedTransition = (function () {
    function t() {
      module27.default(this, t);
      this.animationFactory = null;
      this.defaultDuration = 500;
    }

    module28.default(
      t,
      [
        {
          key: 'custom',
          value: function (t) {
            this.animationFactory = t;
            return this;
          },
        },
        {
          key: 'build',
          value: function () {
            var t = this.animationFactory,
              n = this.defaultDuration;
            return function (o) {
              'worklet';

              var f = {},
                c = {};

              if (t) {
                for (var l in (f = t(o))) if (!s.includes(l)) throw Error("The prop '" + l + "' is not supported yet.");
              } else
                for (var h = 0, v = s; h < v.length; h++) {
                  var y = v[h];

                  if ('transform' === y) {
                    var p = o.targetTransformMatrix;
                    f.transformMatrix = module445.withTiming(p, {
                      duration: n,
                    });
                  } else {
                    var T = 'target' + y.charAt(0).toUpperCase() + y.slice(1);
                    f[y] = module445.withTiming(o[T], {
                      duration: n,
                    });
                  }
                }

              for (var k in f)
                if ('transform' === k) c.transformMatrix = o.currentTransformMatrix;
                else {
                  var w = 'current' + k.charAt(0).toUpperCase() + k.slice(1);
                  c[k] = o[w];
                }

              return {
                initialValues: c,
                animations: f,
              };
            };
          },
        },
      ],
      [
        {
          key: 'createInstance',
          value: function () {
            return new t();
          },
        },
        {
          key: 'custom',
          value: function (t) {
            return this.createInstance().custom(t);
          },
        },
        {
          key: 'build',
          value: function () {
            return this.createInstance().build();
          },
        },
      ]
    );
    return t;
  })());

exports.DefaultSharedTransition = f;
