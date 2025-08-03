exports.withSequence = function (...args) {
  'worklet';

  return module437.defineAnimation(args[0], function () {
    var n = args.map(function (n) {
        var t = 'function' == typeof n ? n() : n;
        t.finished = false;
        return t;
      }),
      t = n[0];
    return {
      isHigherOrder: true,
      onFrame: function (t, o) {
        var c = n[t.animationIndex],
          u = c.onFrame(c, o);

        if (((t.current = c.current), u)) {
          if ((c.callback && c.callback(true), (c.finished = true), (t.animationIndex += 1), t.animationIndex < n.length)) {
            var f = n[t.animationIndex];
            f.onStart(f, c.current, o, c);
            return false;
          }

          return true;
        }

        return false;
      },
      onStart: function (o, c, u, f) {
        o.animationIndex = 0;
        if (undefined === f) f = n[n.length - 1];
        t.onStart(t, c, u, f);
      },
      animationIndex: 0,
      current: t.current,
      callback: function (t) {
        if (t) return;
        n.forEach(function (n) {
          if (!('function' != typeof n.callback || n.finished)) n.callback(t);
        });
      },
    };
  });
};

var module437 = require('./437');
