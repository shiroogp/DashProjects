exports.withSpring = function (t, n, s) {
  'worklet';

  return module437.defineAnimation(t, function () {
    var o = u(
      u(
        u(
          {},
          {
            damping: 10,
            mass: 1,
            stiffness: 100,
            overshootClamping: false,
            restDisplacementThreshold: 0.01,
            restSpeedThreshold: 2,
            velocity: 0,
            duration: 2e3,
            dampingRatio: 0.5,
          }
        ),
        n
      ),
      {},
      {
        useDuration: !!((null != n && n.duration) || (null != n && n.dampingRatio)),
        configIsInvalid: false,
      }
    );

    function c(t, n) {
      return (
        (null == t ? undefined : t.startTimestamp) &&
        (null == t ? undefined : t.toValue) === n.toValue &&
        (null == t ? undefined : t.duration) === n.duration &&
        (null == t ? undefined : t.dampingRatio) === n.dampingRatio
      );
    }

    if (
      [o.stiffness, o.damping, o.duration, o.dampingRatio, o.restDisplacementThreshold, o.restSpeedThreshold].some(function (t) {
        return t <= 0;
      }) ||
      0 === o.mass
    ) {
      o.configIsInvalid = true;
      console.warn(
        "You have provided invalid spring animation configuration! \n Value of stiffness, damping, duration and damping ratio must be greater than zero, and mass can't equal zero."
      );
    }

    return {
      onFrame: function (t, n) {
        var s = t.toValue,
          u = t.startTimestamp,
          c = t.current,
          p = n - u;

        if (o.useDuration && p >= o.duration) {
          t.current = s;
          t.lastTimestamp = 0;
          return true;
        }

        if (o.configIsInvalid) return !o.useDuration && ((t.current = s), (t.lastTimestamp = 0), true);
        var v = t.lastTimestamp,
          f = t.velocity,
          y = (n - v) ** 64;
        t.lastTimestamp = n;
        var T = y / 1e3,
          h = -f,
          O = s - c,
          b = t.zeta,
          D = t.omega0,
          j = t.omega1,
          w =
            b < 1
              ? module447.underDampedSpringCalculations(t, {
                  zeta: b,
                  v0: h,
                  x0: O,
                  omega0: D,
                  omega1: j,
                  t: T,
                })
              : module447.criticallyDampedSpringCalculations(t, {
                  v0: h,
                  x0: O,
                  omega0: D,
                  t: T,
                }),
          V = w.position,
          z = w.velocity;
        t.current = V;
        t.velocity = z;
        var P = module447.isAnimationTerminatingCalculation(t, o),
          S = P.isOvershooting,
          I = P.isVelocity,
          C = P.isDisplacement,
          R = S || (I && C);

        if (!o.useDuration && R) {
          t.velocity = 0;
          t.current = s;
          t.lastTimestamp = 0;
          return true;
        }

        return false;
      },
      onStart: function (t, n, s, u) {
        t.current = n;
        t.startValue = n;
        var p = o.mass,
          v = c(u, t),
          f = o.duration,
          y = v ? (null == u ? undefined : u.startValue) : Number(t.toValue) - n;
        t.velocity = u ? (v ? (null == u ? undefined : u.velocity) : (null == u ? undefined : u.velocity) + o.velocity) || 0 : o.velocity || 0;

        if (v) {
          t.zeta = (null == u ? undefined : u.zeta) || 0;
          t.omega0 = (null == u ? undefined : u.omega0) || 0;
          t.omega1 = (null == u ? undefined : u.omega1) || 0;
        } else {
          if (o.useDuration) {
            var T = v ? f - (((null == u ? undefined : u.lastTimestamp) || 0) - ((null == u ? undefined : u.startTimestamp) || 0)) : f;
            o.duration = T;
            p = module447.calcuateNewMassToMatchDuration(y, o, t.velocity);
          }

          var h = module447.initialCalculations(p, o),
            O = h.zeta,
            b = h.omega0,
            D = h.omega1;
          t.zeta = O;
          t.omega0 = b;
          t.omega1 = D;
        }

        t.lastTimestamp = (null == u ? undefined : u.lastTimestamp) || s;
        t.startTimestamp = (v && (null == u ? undefined : u.startTimestamp)) || s;
      },
      toValue: t,
      velocity: o.velocity || 0,
      current: t,
      startValue: 0,
      callback: s,
      lastTimestamp: 0,
      startTimestamp: 0,
      zeta: 0,
      omega0: 0,
      omega1: 0,
    };
  });
};

var module50 = require('./50'),
  module437 = require('./437'),
  module447 = require('./447');

function s(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var l = Object.getOwnPropertySymbols(t);
    if (n)
      l = l.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, l);
  }

  return o;
}

function u(t) {
  for (var o = 1; o < arguments.length; o++) {
    var l = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      s(Object(l), true).forEach(function (o) {
        module50.default(t, o, l[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(l));
    else
      s(Object(l)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(l, n));
      });
  }

  return t;
}
