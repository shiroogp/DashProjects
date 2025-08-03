exports.useAnimatedStyle = function (t, u, b) {
  var A,
    h,
    w = module477.makeViewsRefSet(),
    j = React.useRef(),
    k = Object.values(null != (A = t._closure) ? A : {});
  if (module421.shouldBeUseWeb() && !k.length && null != (h = u) && h.length) k = u;
  var R = b ? (Array.isArray(b) ? b : [b]) : [],
    E = b ? module484.buildWorkletsHash(R) : null,
    D = module483.useSharedValue(true),
    C = React.useRef({});
  if (u) u.push(t.__workletHash);
  else u = [].concat(module23.default(k), [t.__workletHash]);

  if ((E && u.push(E), !j.current)) {
    var M = module445.initialUpdaterRun(t);
    module484.validateAnimatedStyles(M);
    j.current = {
      initial: {
        value: M,
        updater: t,
      },
      remoteState: module422.makeRemote({
        last: M,
        animations: {},
        isAnimationCancelled: false,
        isAnimationRunning: false,
      }),
      viewDescriptors: module477.makeViewDescriptorsSet(),
    };
  }

  var P = j.current,
    W = P.initial,
    F = P.remoteState,
    q = P.viewDescriptors,
    I = q.sharableViewDescriptors,
    J = module414.default.native ? undefined : w;
  u.push(I);
  React.useEffect(function () {
    var n,
      o = t;
    if (b)
      o = function () {
        'worklet';

        var n = t();
        R.forEach(function (t) {
          t(n);
        });
        return n;
      };
    n = module421.isJest()
      ? function () {
          'worklet';

          _(I, t, F, J, D, C, R);
        }
      : function () {
          'worklet';

          S(I, o, F, J, D);
        };
    var u = module422.startMapper(n, k);
    return function () {
      module422.stopMapper(u);
    };
  }, u);
  React.useEffect(function () {
    D.value = true;
    return function () {
      D.value = false;
    };
  }, []);
  O(W.value);
  return process.env.JEST_WORKER_ID
    ? {
        viewDescriptors: q,
        initial: W,
        viewsRef: w,
        animatedStyle: C,
      }
    : {
        viewDescriptors: q,
        initial: W,
        viewsRef: w,
      };
};

var React = require('react'),
  module422 = require('./422'),
  module442 = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = b(n);
    if (o && o.has(t)) return o.get(t);
    var l = {
        __proto__: null,
      },
      u = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var s in t)
      if ('default' !== s && Object.prototype.hasOwnProperty.call(t, s)) {
        var c = u ? Object.getOwnPropertyDescriptor(t, s) : null;
        if (c && (c.get || c.set)) Object.defineProperty(l, s, c);
        else l[s] = t[s];
      }

    l.default = t;
    if (o) o.set(t, l);
    return l;
  })(require('./442')),
  module445 = require('./445'),
  module414 = require('./414'),
  module483 = require('./483'),
  module484 = require('./484'),
  module477 = require('./477'),
  module421 = require('./421');

function b(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (b = function (t) {
    return t ? o : n;
  })(t);
}

function A(t, n) {
  var o = ('undefined' != typeof Symbol && t[Symbol.iterator]) || t['@@iterator'];
  if (o) return (o = o.call(t)).next.bind(o);

  if (Array.isArray(t) || (o = h(t)) || (n && t && 'number' == typeof t.length)) {
    if (o) t = o;
    var l = 0;
    return function () {
      return l >= t.length
        ? {
            done: true,
          }
        : {
            done: false,
            value: t[l++],
          };
    };
  }

  throw new TypeError('Invalid attempt to iterate non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.');
}

function h(t, n) {
  if (t) {
    if ('string' == typeof t) return w(t, n);
    var o = Object.prototype.toString.call(t).slice(8, -1);
    if ('Object' === o && t.constructor) o = t.constructor.name;
    return 'Map' === o || 'Set' === o ? Array.from(t) : 'Arguments' === o || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(o) ? w(t, n) : undefined;
  }
}

function w(t, n) {
  if (null == n || n > t.length) n = t.length;

  for (var o = 0, l = new Array(n); o < n; o++) l[o] = t[o];

  return l;
}

function j(t, n, o, l) {
  'worklet';

  if (
    (Array.isArray(n) &&
      n.forEach(function (n, u) {
        j(t, n, o && o[u], l && l[u]);
      }),
    'object' == typeof n && n.onFrame)
  ) {
    var u = n,
      s = u.current;
    if (undefined !== l)
      'object' == typeof l
        ? undefined !== l.value
          ? (s = l.value)
          : undefined !== l.onFrame && (undefined !== (null == o ? undefined : o.current) ? (s = o.current) : undefined !== (null == l ? undefined : l.current) && (s = l.current))
        : (s = l);

    u.callStart = function (t) {
      u.onStart(u, s, t, o);
    };

    u.callStart(t);
    u.callStart = null;
  } else
    'object' == typeof n &&
      Object.keys(n).forEach(function (u) {
        return j(t, n[u], o && o[u], l && l[u]);
      });
}

function k(t, n, o, l, u) {
  'worklet';

  if (!u.value) return true;

  if (Array.isArray(t)) {
    l[o] = [];
    var s = true;
    t.forEach(function (t, c) {
      if (!k(t, n, c, l[o], u)) s = false;
    });
    return s;
  }

  if ('object' == typeof t && t.onFrame) {
    var c = true;

    if (!t.finished) {
      if (t.callStart) {
        t.callStart(n);
        t.callStart = null;
      }

      c = t.onFrame(t, n);
      t.timestamp = n;

      if (c) {
        t.finished = true;
        if (t.callback) t.callback(true);
      }
    }

    l[o] = t.current;
    return c;
  }

  if ('object' == typeof t) {
    l[o] = {};
    var f = true;
    Object.keys(t).forEach(function (s) {
      if (!k(t[s], n, s, l[o], u)) f = false;
    });
    return f;
  }

  l[o] = t;
  return true;
}

function S(t, n, o, l, s) {
  'worklet';

  var c,
    f,
    p,
    y = null != (c = o.animations) ? c : {},
    b = null != (f = n()) ? f : {},
    A = o.last,
    h = {},
    w = false,
    S = false;

  for (var _ in b) {
    var O = b[_];

    if (module484.isAnimated(O)) {
      j((p = globals.__frameTimestamp || performance.now()), O, y[_], A[_]);
      y[_] = O;
      w = true;
    } else {
      S = true;
      h[_] = O;
      delete y[_];
    }
  }

  if (w) {
    o.animations = y;

    if (!o.isAnimationRunning) {
      o.isAnimationCancelled = false;
      o.isAnimationRunning = true;

      (function n(c) {
        var f = o.animations,
          v = o.last;
        if (o.isAnimationCancelled) o.isAnimationRunning = false;
        else {
          var p = {},
            y = true;

          for (var b in f) k(f[b], c, b, p, s) ? ((v[b] = p[b]), delete f[b]) : (y = false);

          module442.default(t, p, l);
          if (y) o.isAnimationRunning = false;
          else requestAnimationFrame(n);
        }
      })(p);
    }

    if (S) module442.default(t, h, l);
  } else {
    o.isAnimationCancelled = true;
    o.animations = [];
    if (!module484.shallowEqual(A, b)) module442.default(t, b, l);
  }

  o.last = b;
}

function _(t, n, o, l, s, c) {
  'worklet';

  var f,
    p,
    y,
    b = arguments.length > 6 && undefined !== arguments[6] ? arguments[6] : [],
    A = null != (f = o.animations) ? f : {},
    h = null != (p = n()) ? p : {},
    w = o.last,
    S = false;
  Object.keys(A).forEach(function (t) {
    var n = h[t];
    if (!module484.isAnimated(n)) delete A[t];
  });
  Object.keys(h).forEach(function (t) {
    var n = h[t];

    if (module484.isAnimated(n)) {
      j((y = globals.__frameTimestamp || performance.now()), n, A[t], w[t]);
      A[t] = n;
      S = true;
    }
  });

  if (S) {
    o.animations = A;

    if (!o.isAnimationRunning) {
      o.isAnimationCancelled = false;
      o.isAnimationRunning = true;

      (function n(f) {
        var v = o.animations,
          p = o.last;
        if (o.isAnimationCancelled) o.isAnimationRunning = false;
        else {
          var y = {},
            A = true;
          Object.keys(v).forEach(function (t) {
            if (k(v[t], f, t, y, s)) {
              p[t] = y[t];
              delete v[t];
            } else A = false;
          });
          if (Object.keys(y).length) module442.updatePropsJestWrapper(t, y, l, c, b);
          if (A) o.isAnimationRunning = false;
          else requestAnimationFrame(n);
        }
      })(y);
    }
  } else {
    o.isAnimationCancelled = true;
    o.animations = [];
  }

  o.last = h;
  if (!module484.shallowEqual(w, h)) module442.updatePropsJestWrapper(t, h, l, c, b);
}

function O(t, n) {
  if (Array.isArray(t))
    for (var o, l = A(t); !(o = l()).done; ) {
      O(o.value, n);
    }
  else if ('object' == typeof t && undefined === t.value)
    for (var u = 0, s = Object.keys(t); u < s.length; u++) {
      var c = s[u];
      O(t[c], c);
    }
  else if (undefined !== n && 'object' == typeof t && undefined !== t.value) throw new Error('invalid value passed to `' + n + '`, maybe you forgot to use `.value`?');
}
