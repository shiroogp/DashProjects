exports.withTiming = function (u, s, o) {
  'worklet';

  return module437.defineAnimation(u, function () {
    var n = {
      duration: 300,
      easing: module440.Easing.inOut(module440.Easing.quad),
    };
    if (s)
      Object.keys(s).forEach(function (t) {
        return (n[t] = s[t]);
      });
    return {
      type: 'timing',
      onFrame: function (t, u) {
        var s = t.toValue,
          o = t.startTime,
          c = t.startValue,
          f = u - o;

        if (f >= n.duration) {
          t.startTime = 0;
          t.current = s;
          return true;
        }

        var l = t.easing(f / n.duration);
        t.current = c + (s - c) * l;
        return false;
      },
      onStart: function (t, s, o, c) {
        if (c && 'timing' === c.type && c.toValue === u && c.startTime) {
          t.startTime = c.startTime;
          t.startValue = c.startValue;
        } else {
          t.startTime = o;
          t.startValue = s;
        }

        t.current = s;
        if ('object' == typeof n.easing) t.easing = n.easing.factory();
        else t.easing = n.easing;
      },
      progress: 0,
      toValue: u,
      startValue: 0,
      startTime: 0,
      easing: function () {
        return 0;
      },
      current: u,
      callback: o,
    };
  });
};

var module440 = require('./440'),
  module437 = require('./437');
