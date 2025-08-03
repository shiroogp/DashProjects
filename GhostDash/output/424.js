exports.registerWorkletStackDetails = function (t, n) {
  o.set(t, n);
};

exports.reportFatalErrorOnJS = function (t) {
  var n = t.message,
    o = t.stack,
    u = new Error();
  u.message = n;
  u.stack = o ? l(o) : undefined;
  u.name = 'ReanimatedError';
  u.jsEngine = 'reanimated';
  globals.ErrorUtils.reportFatalError(u);
};

var module15 = require('@babel/runtime/helpers/slicedToArray'),
  o = new Map();

function u(t) {
  var o,
    u,
    l = null == (o = t.stack) ? undefined : null == (u = o.split('\n')) ? undefined : u[0];

  if (l) {
    var c = /@([^@]+):(\d+):(\d+)/.exec(l);

    if (c) {
      var f = module15.default(c, 4),
        s = f[1],
        v = f[2],
        p = f[3];
      return [s, Number(v), Number(p)];
    }
  }

  return ['unknown', 0, 0];
}

function l(t) {
  var l = t.match(/worklet_(\d+):(\d+):(\d+)/g),
    c = t;
  if (!(null == l))
    l.forEach(function (t) {
      var l = t.split(/:|_/).map(Number),
        f = module15.default(l, 4),
        s = f[1],
        v = f[2],
        p = f[3],
        k = o.get(s);

      if (k) {
        var E = module15.default(k, 3),
          _ = E[0],
          b = E[1],
          w = E[2],
          N = u(_),
          h = module15.default(N, 3),
          j = h[0],
          F = v + h[1] + b,
          M = p + h[2] + w;
        c = c.replace(t, j + ':' + F + ':' + M);
      }
    });
  return c;
}
