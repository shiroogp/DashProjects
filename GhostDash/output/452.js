var module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module445 = require('./445'),
  module444 = require('./444');

function f() {
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

exports.ComplexAnimationBuilder = (function (t) {
  module38.default(y, t);

  var module444 = y,
    p = f(),
    v = function () {
      var t,
        n = module37.default(module444);

      if (p) {
        var s = module37.default(this).constructor;
        t = Reflect.construct(n, arguments, s);
      } else t = n.apply(this, arguments);

      return module40.default(this, t);
    };

  function y() {
    module27.default(this, y);
    return v.apply(this, arguments);
  }

  module28.default(
    y,
    [
      {
        key: 'easing',
        value: function (t) {
          this.easingV = t;
          return this;
        },
      },
      {
        key: 'rotate',
        value: function (t) {
          this.rotateV = t;
          return this;
        },
      },
      {
        key: 'springify',
        value: function () {
          this.type = module445.withSpring;
          return this;
        },
      },
      {
        key: 'damping',
        value: function (t) {
          this.dampingV = t;
          return this;
        },
      },
      {
        key: 'mass',
        value: function (t) {
          this.massV = t;
          return this;
        },
      },
      {
        key: 'stiffness',
        value: function (t) {
          this.stiffnessV = t;
          return this;
        },
      },
      {
        key: 'overshootClamping',
        value: function (t) {
          this.overshootClampingV = t;
          return this;
        },
      },
      {
        key: 'restDisplacementThreshold',
        value: function (t) {
          this.restDisplacementThresholdV = t;
          return this;
        },
      },
      {
        key: 'restSpeedThreshold',
        value: function (t) {
          this.restSpeedThresholdV = t;
          return this;
        },
      },
      {
        key: 'withInitialValues',
        value: function (t) {
          this.initialValues = t;
          return this;
        },
      },
      {
        key: 'getAnimationAndConfig',
        value: function () {
          var t = this.durationV,
            n = this.easingV,
            s = this.rotateV,
            u = this.type ? this.type : module445.withTiming,
            o = this.dampingV,
            h = this.massV,
            c = this.stiffnessV,
            f = this.overshootClampingV,
            p = this.restDisplacementThresholdV,
            v = this.restSpeedThresholdV,
            y = u,
            k = {};

          if (u === module445.withTiming) {
            if (n) k.easing = n;
            if (t) k.duration = t;
            if (s) k.rotate = s;
          } else {
            if (o) k.damping = o;
            if (h) k.mass = h;
            if (c) k.stiffness = c;
            if (f) k.overshootClamping = f;
            if (p) k.restDisplacementThreshold = p;
            if (v) k.restSpeedThreshold = v;
            if (s) k.rotate = s;
          }

          return [y, k];
        },
      },
    ],
    [
      {
        key: 'easing',
        value: function (t) {
          return this.createInstance().easing(t);
        },
      },
      {
        key: 'rotate',
        value: function (t) {
          return this.createInstance().rotate(t);
        },
      },
      {
        key: 'springify',
        value: function () {
          return this.createInstance().springify();
        },
      },
      {
        key: 'damping',
        value: function (t) {
          return this.createInstance().damping(t);
        },
      },
      {
        key: 'mass',
        value: function (t) {
          return this.createInstance().mass(t);
        },
      },
      {
        key: 'stiffness',
        value: function (t) {
          return this.createInstance().stiffness(t);
        },
      },
      {
        key: 'overshootClamping',
        value: function (t) {
          return this.createInstance().overshootClamping(t);
        },
      },
      {
        key: 'restDisplacementThreshold',
        value: function (t) {
          return this.createInstance().restDisplacementThreshold(t);
        },
      },
      {
        key: 'restSpeedThreshold',
        value: function (t) {
          return this.createInstance().restSpeedThreshold(t);
        },
      },
      {
        key: 'withInitialValues',
        value: function (t) {
          return this.createInstance().withInitialValues(t);
        },
      },
    ]
  );
  return y;
})(module444.BaseAnimationBuilder);
