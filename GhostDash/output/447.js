function t(t) {
  'worklet';

  for (var n = t.min, o = t.max, s = t.func, l = t.maxIterations, u = undefined === l ? 20 : l, c = (o + n) / 2; Math.abs(s(c)) > 5e-5 && u > 0; ) {
    u -= 1;
    if (s(c) < 0) n = c;
    else o = c;
    c = (n + o) / 2;
  }

  return c;
}

exports.calcuateNewMassToMatchDuration = function (n, o, s) {
  'worklet';

  if (o.configIsInvalid) return 0;
  var l = o.stiffness,
    u = o.dampingRatio,
    c = o.restSpeedThreshold,
    h = o.duration;
  return t({
    min: 0,
    max: 100,
    func: function (t) {
      var o = (t * s * s + l * n * n) / (Math.exp(1 - 0.5 * u) * l),
        f = 2 * u * Math.sqrt(l * t);
      return ((-2 * t) / f) * 1e3 * Math.log((0.01 * c) / o) - h;
    },
  });
};

exports.criticallyDampedSpringCalculations = function (t, n) {
  'worklet';

  var o = t.toValue,
    s = n.v0,
    l = n.x0,
    u = n.omega0,
    c = n.t,
    h = Math.exp(-u * c);
  return {
    position: o - h * (l + (s + u * l) * c),
    velocity: h * (s * (c * u - 1) + c * l * u * u),
  };
};

exports.initialCalculations = function () {
  'worklet';

  var t = arguments.length > 0 && undefined !== arguments[0] ? arguments[0] : 0,
    n = arguments.length > 1 ? arguments[1] : undefined;
  if (n.configIsInvalid)
    return {
      zeta: 0,
      omega0: 0,
      omega1: 0,
    };

  if (n.useDuration) {
    var o = n.stiffness,
      s = n.dampingRatio,
      l = Math.sqrt(o / t),
      u = l * Math.sqrt(1 - s ** 2);
    return {
      zeta: s,
      omega0: l,
      omega1: u,
    };
  }

  var c = n.damping,
    h = n.mass,
    f = n.stiffness,
    v = c / (2 * Math.sqrt(f * h)),
    p = Math.sqrt(f / h),
    M = p * Math.sqrt(1 - v ** 2);
  return {
    zeta: v,
    omega0: p,
    omega1: M,
  };
};

exports.isAnimationTerminatingCalculation = function (t, n) {
  'worklet';

  var o = t.toValue,
    s = t.velocity,
    l = t.startValue,
    u = t.current,
    c = !!n.overshootClamping && ((u > o && l < o) || (u < o && l > o)),
    h = Math.abs(s) < n.restSpeedThreshold,
    f = Math.abs(o - u) < n.restDisplacementThreshold;
  return {
    isOvershooting: c,
    isVelocity: h,
    isDisplacement: f,
  };
};

exports.underDampedSpringCalculations = function (t, n) {
  'worklet';

  var o = t.toValue,
    s = t.current,
    l = t.velocity,
    u = n.zeta,
    c = n.t,
    h = n.omega0,
    f = n.omega1,
    v = -l,
    p = o - s,
    M = Math.sin(f * c),
    w = Math.cos(f * c),
    x = Math.exp(-u * h * c),
    y = x * (M * ((v + u * h * p) / f) + p * w);
  return {
    position: o - y,
    velocity: u * h * y - x * (w * (v + u * h * p) - f * p * M),
  };
};
