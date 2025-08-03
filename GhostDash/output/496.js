exports.interpolate = function (t, n, o, u) {
  'worklet';

  if (n.length < 2 || o.length < 2) throw Error('Interpolation input and output should contain at least two values.');
  var l = p(u),
    f = n.length,
    x = {
      leftEdgeInput: n[0],
      rightEdgeInput: n[1],
      leftEdgeOutput: o[0],
      rightEdgeOutput: o[1],
    };
  if (f > 2)
    if (t > n[f - 1]) {
      x.leftEdgeInput = n[f - 2];
      x.rightEdgeInput = n[f - 1];
      x.leftEdgeOutput = o[f - 2];
      x.rightEdgeOutput = o[f - 1];
    } else
      for (var h = 1; h < f; ++h)
        if (t <= n[h]) {
          x.leftEdgeInput = n[h - 1];
          x.rightEdgeInput = n[h];
          x.leftEdgeOutput = o[h - 1];
          x.rightEdgeOutput = o[h];
          break;
        }
  return E(t, x, l);
};

var module14 = require('./14'),
  o = (exports.Extrapolation = (function (t) {
    t.IDENTITY = 'identity';
    t.CLAMP = 'clamp';
    t.EXTEND = 'extend';
    return t;
  })({}));

function u(t, n, u, l, p, E) {
  'worklet';

  switch (t) {
    case o.IDENTITY:
      return E;

    case o.CLAMP:
      return n * u < n * l ? l : p;

    case o.EXTEND:
    default:
      return u;
  }
}

function l(t) {
  'worklet';

  return t === o.EXTEND || t === o.CLAMP || t === o.IDENTITY;
}

function p(t) {
  'worklet';

  var u = {
    extrapolateLeft: o.EXTEND,
    extrapolateRight: o.EXTEND,
  };
  if (!t) return u;

  if ('string' == typeof t) {
    if (!l(t))
      throw new Error(
        'Reanimated: not supported value for "interpolate" \nSupported values: ["extend", "clamp", "identity", Extrapolatation.CLAMP, Extrapolatation.EXTEND, Extrapolatation.IDENTITY]\n Valid example:\n        interpolate(value, [inputRange], [outputRange], "clamp")'
      );
    u.extrapolateLeft = t;
    u.extrapolateRight = t;
    return u;
  }

  if ((t.extrapolateLeft && !l(t.extrapolateLeft)) || (t.extrapolateRight && !l(t.extrapolateRight)))
    throw new Error(
      'Reanimated: not supported value for "interpolate" \nSupported values: ["extend", "clamp", "identity", Extrapolatation.CLAMP, Extrapolatation.EXTEND, Extrapolatation.IDENTITY]\n Valid example:\n      interpolate(value, [inputRange], [outputRange], {\n        extrapolateLeft: Extrapolation.CLAMP,\n        extrapolateRight: Extrapolation.IDENTITY\n      }})'
    );
  module14.default(u, t);
  return u;
}

function E(t, n, o) {
  'worklet';

  var l = n.leftEdgeInput,
    p = n.rightEdgeInput,
    E = n.leftEdgeOutput,
    f = n.rightEdgeOutput;
  if (p - l == 0) return E;
  var x = E + ((t - l) / (p - l)) * (f - E),
    h = f >= E ? 1 : -1;
  return h * x < h * E ? u(o.extrapolateLeft, h, x, E, f, t) : h * x > h * f ? u(o.extrapolateRight, h, x, E, f, t) : x;
}
