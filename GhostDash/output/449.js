exports.withDelay = function (t, u) {
  'worklet';

  return module437.defineAnimation(u, function () {
    var n = 'function' == typeof u ? u() : u;
    return {
      isHigherOrder: true,
      onFrame: function (u, o) {
        var c = u.startTime,
          l = u.started,
          s = u.previousAnimation;

        if (o - c > t) {
          if (!l) {
            n.onStart(n, u.current, o, s);
            u.previousAnimation = null;
            u.started = true;
          }

          var f = n.onFrame(n, o);
          u.current = n.current;
          return f;
        }

        if (s) {
          var v = s.finished || s.onFrame(s, o);
          u.current = s.current;
          if (v) u.previousAnimation = null;
        }

        return false;
      },
      onStart: function (n, t, u, o) {
        n.startTime = u;
        n.started = false;
        n.current = t;
        n.previousAnimation = o === n ? o.previousAnimation : o;
      },
      current: n.current,
      callback: function (t) {
        if (n.callback) n.callback(t);
      },
      previousAnimation: null,
      startTime: 0,
      started: false,
    };
  });
};

var module437 = require('./437');
