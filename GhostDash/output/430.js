Object.defineProperty(exports, 'stopMapper', {
  enumerable: true,
  get: function () {
    return module425.stopMapper;
  },
});

exports.valueSetter = function (n, t) {
  'worklet';

  var l = n._animation;

  if (l) {
    l.cancelled = true;
    n._animation = null;
  }

  if ('function' == typeof t || (null !== t && 'object' == typeof t && undefined !== t.onFrame)) {
    var c = 'function' == typeof t ? t() : t;
    if (n._value === c.current && !c.isHigherOrder) return void (c.callback && c.callback(true));
    var o = globals.__frameTimestamp || performance.now();
    u = o;
    c.onStart(c, n.value, u, l);
    n._animation = c;

    (function t(l) {
      if (c.cancelled) return void (c.callback && c.callback(false));
      var o = c.onFrame(c, l);
      c.finished = true;
      c.timestamp = l;
      n._value = c.current;
      if (o) {
        if (c.callback) c.callback(true);
      } else requestAnimationFrame(t);
    })(o);
  } else {
    if (n._value === t) return;
    n._value = t;
  }

  var u;
};

var module425 = require('./425');
