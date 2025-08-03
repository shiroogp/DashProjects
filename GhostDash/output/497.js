exports.useInterpolateConfig = function (o, n) {
  var l = arguments.length > 2 && undefined !== arguments[2] ? arguments[2] : C.RGB,
    p = arguments.length > 3 && undefined !== arguments[3] ? arguments[3] : {};
  return module483.useSharedValue({
    inputRange: o,
    outputRange: n,
    colorSpace: l,
    cache: module422.makeMutable(null),
    options: p,
  });
};

exports.interpolateColor = function (o, t, n) {
  'worklet';

  var u = arguments.length > 3 && undefined !== arguments[3] ? arguments[3] : 'RGB',
    l = arguments.length > 4 && undefined !== arguments[4] ? arguments[4] : {};
  if ('HSV' === u) return p(o, t, f(n), l);
  if ('RGB' === u) return c(o, t, s(n), l);
  throw new Error('Invalid color space provided: ' + u + ". Supported values are: ['RGB', 'HSV']");
};

var module438 = require('./438'),
  module422 = require('./422'),
  module496 = require('./496'),
  module483 = require('./483'),
  l = (exports.Extrapolate = {
    EXTEND: 'extend',
    CLAMP: 'clamp',
    IDENTITY: 'identity',
  }),
  p = function (t, u, p, v) {
    'worklet';

    var h = 0,
      c = v.useCorrectedHSVInterpolation;

    if (undefined === c || c) {
      for (var s = [u[0]], f = p.h, C = [f[0]], S = 1; S < f.length; ++S) {
        var M = f[S] - f[S - 1];

        if (f[S] > f[S - 1] && M > 0.5) {
          s.push(u[S]);
          s.push(u[S] + 1e-5);
          C.push(f[S] - 1);
          C.push(f[S]);
        } else if (f[S] < f[S - 1] && M < -0.5) {
          s.push(u[S]);
          s.push(u[S] + 1e-5);
          C.push(f[S] + 1);
          C.push(f[S]);
        } else {
          s.push(u[S]);
          C.push(f[S]);
        }
      }

      h = (module496.interpolate(t, s, C, l.CLAMP) + 1) % 1;
    } else h = module496.interpolate(t, u, p.h, l.CLAMP);

    var R = module496.interpolate(t, u, p.s, l.CLAMP),
      w = module496.interpolate(t, u, p.v, l.CLAMP),
      b = module496.interpolate(t, u, p.a, l.CLAMP);
    return module438.hsvToColor(h, R, w, b);
  },
  v = function (o, t) {
    'worklet';

    return o.map(function (o) {
      return (o / 255) ** t;
    });
  },
  h = function (o, t) {
    'worklet';

    return Math.round(255 * o ** (1 / t));
  },
  c = function (t, u, p, c) {
    'worklet';

    var s = c.gamma,
      f = undefined === s ? 2.2 : s,
      C = p.r,
      S = p.g,
      M = p.b;

    if (1 !== f) {
      C = v(C, f);
      S = v(S, f);
      M = v(M, f);
    }

    var R = module496.interpolate(t, u, C, l.CLAMP),
      w = module496.interpolate(t, u, S, l.CLAMP),
      b = module496.interpolate(t, u, M, l.CLAMP),
      P = module496.interpolate(t, u, p.a, l.CLAMP);
    return 1 === f ? module438.rgbaColor(R, w, b, P) : module438.rgbaColor(h(R, f), h(w, f), h(b, f), P);
  },
  s = function (t) {
    'worklet';

    for (var n = [], u = [], l = [], p = [], v = 0; v < t.length; ++v) {
      var h = t[v],
        c = module438.processColor(h);

      if (null !== c && undefined !== c) {
        n.push(module438.red(c));
        u.push(module438.green(c));
        l.push(module438.blue(c));
        p.push(module438.opacity(c));
      }
    }

    return {
      r: n,
      g: u,
      b: l,
      a: p,
    };
  },
  f = function (t) {
    'worklet';

    for (var n = [], u = [], l = [], p = [], v = 0; v < t.length; ++v) {
      var h = t[v],
        c = module438.processColor(h);

      if ('number' == typeof c) {
        var s = module438.RGBtoHSV(module438.red(c), module438.green(c), module438.blue(c));
        n.push(s.h);
        u.push(s.s);
        l.push(s.v);
        p.push(module438.opacity(c));
      }
    }

    return {
      h: n,
      s: u,
      v: l,
      a: p,
    };
  },
  C = (exports.ColorSpace = (function (o) {
    o[(o.RGB = 0)] = 'RGB';
    o[(o.HSV = 1)] = 'HSV';
    return o;
  })({}));

exports.interpolateSharableColor = function (o, t) {
  'worklet';

  var n = t.value.cache.value;

  if (t.value.colorSpace === C.RGB) {
    if (!n) {
      n = s(t.value.outputRange);
      t.value.cache.value = n;
    }

    return c(o, t.value.inputRange, n, t.value.options);
  }

  if (t.value.colorSpace === C.HSV) {
    if (!n) {
      n = f(t.value.outputRange);
      t.value.cache.value = n;
    }

    return p(o, t.value.inputRange, n, t.value.options);
  }

  throw new Error('Invalid color space provided: ' + t.value.colorSpace + ". Supported values are: ['RGB', 'HSV']");
};
