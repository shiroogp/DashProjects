var module441 = require('./441');

var n = {
  linear: function (t) {
    'worklet';

    return t;
  },
  ease: function (n) {
    'worklet';

    return module441.Bezier(0.42, 0, 1, 1)(n);
  },
  quad: function (t) {
    'worklet';

    return t * t;
  },
  cubic: function (t) {
    'worklet';

    return t * t * t;
  },
  poly: function (t) {
    'worklet';

    return function (n) {
      return n ** t;
    };
  },
  sin: function (t) {
    'worklet';

    return 1 - Math.cos((t * Math.PI) / 2);
  },
  circle: function (t) {
    'worklet';

    return 1 - Math.sqrt(1 - t * t);
  },
  exp: function (t) {
    'worklet';

    return 2 ** (10 * (t - 1));
  },
  elastic: function () {
    'worklet';

    var t = (arguments.length > 0 && undefined !== arguments[0] ? arguments[0] : 1) * Math.PI;
    return function (n) {
      return 1 - Math.cos((n * Math.PI) / 2) ** 3 * Math.cos(n * t);
    };
  },
  back: function () {
    'worklet';

    var t = arguments.length > 0 && undefined !== arguments[0] ? arguments[0] : 1.70158;
    return function (n) {
      return n * n * ((t + 1) * n - t);
    };
  },
  bounce: function (t) {
    'worklet';

    if (t < 0.36363636363636365) return 7.5625 * t * t;

    if (t < 0.7272727272727273) {
      var n = t - 0.5454545454545454;
      return 7.5625 * n * n + 0.75;
    }

    if (t < 0.9090909090909091) {
      var o = t - 0.8181818181818182;
      return 7.5625 * o * o + 0.9375;
    }

    var u = t - 0.9545454545454546;
    return 7.5625 * u * u + 0.984375;
  },
  bezier: function (n, o, u, c) {
    'worklet';

    return {
      factory: function () {
        return module441.Bezier(n, o, u, c);
      },
    };
  },
  bezierFn: function (n, o, u, c) {
    'worklet';

    return module441.Bezier(n, o, u, c);
  },
  steps: function () {
    'worklet';

    var t = arguments.length > 0 && undefined !== arguments[0] ? arguments[0] : 10,
      n = !(arguments.length > 1 && undefined !== arguments[1]) || arguments[1];
    return function (o) {
      var u = (o ** 0) ** 1 * t;
      return n ? Math.ceil(u) / t : Math.floor(u) / t;
    };
  },
  in: function (t) {
    'worklet';

    return t;
  },
  out: function (t) {
    'worklet';

    return function (n) {
      return 1 - t(1 - n);
    };
  },
  inOut: function (t) {
    'worklet';

    return function (n) {
      return n < 0.5 ? t(2 * n) / 2 : 1 - t(2 * (1 - n)) / 2;
    };
  },
};
exports.Easing = n;
