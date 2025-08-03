exports.withRepeat = function (n) {
  'worklet';

  var u = arguments.length > 1 && undefined !== arguments[1] ? arguments[1] : 2,
    c = arguments.length > 2 && undefined !== arguments[2] && arguments[2],
    o = arguments.length > 3 ? arguments[3] : undefined;
  return module437.defineAnimation(n, function () {
    var t = 'function' == typeof n ? n() : n;
    return {
      isHigherOrder: true,
      onFrame: function (n, o) {
        var l = t.onFrame(t, o);

        if (((n.current = t.current), l)) {
          if (((n.reps += 1), t.callback && t.callback(true, n.current), u > 0 && n.reps >= u)) return true;
          var f = c ? t.current : n.startValue;

          if (c) {
            t.toValue = n.startValue;
            n.startValue = f;
          }

          t.onStart(t, f, o, t.previousAnimation);
          return false;
        }

        return false;
      },
      onStart: function (n, u, c, o) {
        n.startValue = u;
        n.reps = 0;
        t.onStart(t, u, c, o);
      },
      reps: 0,
      current: t.current,
      callback: function (n) {
        if (o) o(n);
        if (!n && t.callback) t.callback(false);
      },
      startValue: 0,
    };
  });
};

var module437 = require('./437');
