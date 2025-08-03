exports.withDecay = function (n, l) {
  'worklet';

  return module437.defineAnimation(0, function () {
    var t,
      o = {
        deceleration: 0.998,
        velocityFactor: 1,
        velocity: 0,
        rubberBandFactor: 0.6,
      };
    if (n)
      Object.keys(n).forEach(function (t) {
        return (o[t] = n[t]);
      });
    var u = 'web' !== ReactNative.Platform.OS ? 1 : 0.05;

    function p() {
      if (o.clamp) {
        if (!Array.isArray(o.clamp)) throw Error('config.clamp must be an array but is ' + typeof o.clamp);
        if (2 !== o.clamp.length) throw Error('clamp array must contain 2 items but is given ' + o.clamp.length);
      }

      if (o.velocityFactor <= 0) throw Error('config.velocityFactor must be greather then 0 but is ' + o.velocityFactor);
      if (o.rubberBandEffect && !o.clamp) throw Error('You need to set `clamp` property when using `rubberBandEffect`.');
    }

    return {
      onFrame: o.rubberBandEffect
        ? function (t, c) {
            var n = t.lastTimestamp,
              l = t.startTimestamp,
              u = t.current,
              p = t.initialVelocity,
              s = t.velocity,
              f = (c - n) ** 64,
              y = p > 0 ? 1 : 0,
              v = 0;
            if (((u < o.clamp[0] || u > o.clamp[1]) && (v = u - o.clamp[y]), 0 !== v)) t.springActive = true;
            else if (0 === v && t.springActive) {
              t.current = o.clamp[y];
              return true;
            }
            var b = s * Math.exp(-(1 - o.deceleration) * (c - l) * 0.1) - v * o.rubberBandFactor;
            t.current = u + (b * o.velocityFactor * f) / 1e3;
            t.velocity = b;
            t.lastTimestamp = c;
            return false;
          }
        : function (t, c) {
            var n = t.lastTimestamp,
              l = t.startTimestamp,
              p = t.initialVelocity,
              s = t.current,
              f = t.velocity,
              y = (c - n) ** 64,
              v = f * Math.exp(-(1 - o.deceleration) * (c - l) * 0.1);

            if (((t.current = s + (v * o.velocityFactor * y) / 1e3), (t.velocity = v), (t.lastTimestamp = c), o.clamp)) {
              if (p < 0 && t.current <= o.clamp[0]) {
                t.current = o.clamp[0];
                return true;
              }

              if (p > 0 && t.current >= o.clamp[1]) {
                t.current = o.clamp[1];
                return true;
              }
            }

            return Math.abs(v) < u;
          },
      onStart: function (t, c, n) {
        t.current = c;
        t.lastTimestamp = n;
        t.startTimestamp = n;
        t.initialVelocity = o.velocity;
        p();
      },
      callback: l,
      velocity: null != (t = o.velocity) ? t : 0,
      initialVelocity: 0,
      current: 0,
      lastTimestamp: 0,
      startTimestamp: 0,
    };
  });
};

var module437 = require('./437'),
  ReactNative = require('react-native');
