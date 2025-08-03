exports.cancelAnimation = function (t) {
  'worklet';

  t.value = t.value;
};

exports.defineAnimation = p;

exports.initialUpdaterRun = function (t) {
  o = true;
  var n = t();
  o = false;
  return n;
};

exports.withStartValue = function (t, n) {
  'worklet';

  return p(t, function () {
    if (!(_WORKLET || 'function' != typeof n)) n = n();
    n.current = t;
    return n;
  });
};

var module14 = require('./14'),
  module438 = require('./438'),
  o = false;

function c(t) {
  'worklet';

  if ('string' == typeof t) {
    var n,
      u = t.match(/([A-Za-z]*)(-?\d*\.?\d*)([eE][-+]?[0-9]+)?([A-Za-z%]*)/);
    if (!u) throw Error("Couldn't parse animation value. Check if there isn't any typo.");
    var o = u[1],
      c = u[4],
      f = u[2] + (null != (n = u[3]) ? n : '');
    return {
      prefix: o,
      suffix: c,
      strippedValue: parseFloat(f),
    };
  }

  return {
    strippedValue: t,
  };
}

function f(t) {
  'worklet';

  if (!t.isHigherOrder) {
    var o = t.onStart,
      f = t.onFrame,
      l = module14.default({}, t);
    delete l.callback;

    var p = function (t, n, u, f) {
        var l,
          p,
          v = c(n),
          s = v.prefix,
          _ = v.suffix,
          x = v.strippedValue;
        t.__prefix = s;
        t.__suffix = _;
        t.strippedCurrent = x;
        var V,
          A,
          S = c(t.toValue).strippedValue;

        if (((t.current = x), (t.startValue = x), (t.toValue = S), f && f !== t)) {
          var h = c(f.current),
            y = h.prefix,
            R = h.suffix,
            C = h.strippedValue;
          f.current = C;
          f.__prefix = y;
          f.__suffix = R;
        }

        if ((o(t, x, u, f), (t.current = (null != (l = t.__prefix) ? l : '') + t.current + (null != (p = t.__suffix) ? p : '')), f && f !== t))
          f.current = (null != (V = f.__prefix) ? V : '') + f.current + (null != (A = f.__suffix) ? A : '');
      },
      v = function (t, n) {
        var u, o;
        t.current = t.strippedCurrent;
        var c = f(t, n);
        t.strippedCurrent = t.current;
        t.current = (null != (u = t.__prefix) ? u : '') + t.current + (null != (o = t.__suffix) ? o : '');
        return c;
      },
      s = ['R', 'G', 'B', 'A'],
      _ = function (t, o, c, f) {
        var p,
          v,
          _,
          x = [];

        if (module438.isColor(o)) {
          v = module438.toLinearSpace(module438.convertToRGBA(t.current));
          p = module438.toLinearSpace(module438.convertToRGBA(o));
          if (t.toValue) _ = module438.toLinearSpace(module438.convertToRGBA(t.toValue));
        }

        s.forEach(function (u, o) {
          t[u] = module14.default({}, l);
          t[u].current = v[o];
          t[u].toValue = _ ? _[o] : undefined;
          t[u].onStart(t[u], p[o], c, f ? f[u] : undefined);
          x.push(t[u].current);
        });
        t.current = module438.rgbaArrayToRGBAColor(module438.toGammaSpace(x));
      },
      x = function (t, n) {
        var o = module438.toLinearSpace(module438.convertToRGBA(t.current)),
          c = [],
          f = true;
        s.forEach(function (u, l) {
          t[u].current = o[l];
          f &= t[u].onFrame(t[u], n);
          c.push(t[u].current);
        });
        t.current = module438.rgbaArrayToRGBAColor(module438.toGammaSpace(c));
        return f;
      },
      V = function (t, u, o, c) {
        u.forEach(function (u, f) {
          t[f] = module14.default({}, l);
          t[f].current = u;
          t[f].toValue = t.toValue[f];
          t[f].onStart(t[f], u, o, c ? c[f] : undefined);
        });
        t.current = u;
      },
      A = function (t, n) {
        var u = true;
        t.current.forEach(function (o, c) {
          u &= t[c].onFrame(t[c], n);
          t.current[c] = t[c].current;
        });
        return u;
      },
      S = function (t, u, o, c) {
        for (var f in u) {
          t[f] = module14.default({}, l);
          t[f].onStart = t.onStart;
          t[f].current = u[f];
          t[f].toValue = t.toValue[f];
          t[f].onStart(t[f], u[f], o, c ? c[f] : undefined);
        }

        t.current = u;
      },
      h = function (t, n) {
        var u = true,
          o = {};

        for (var c in t.current) {
          u &= t[c].onFrame(t[c], n);
          o[c] = t[c].current;
        }

        t.current = o;
        return u;
      };

    t.onStart = function (t, n, c, f) {
      if (module438.isColor(n)) {
        _(t, n, c, f);

        return void (t.onFrame = x);
      } else if (Array.isArray(n)) {
        V(t, n, c, f);
        return void (t.onFrame = A);
      } else if ('string' == typeof n) {
        p(t, n, c, f);
        return void (t.onFrame = v);
      } else if ('object' == typeof n && null !== n) {
        S(t, n, c, f);
        return void (t.onFrame = h);
      } else return void o(t, n, c, f);
    };
  }
}

var module414 = require('./414').default.native;

function p(t, n) {
  'worklet';

  if (o) return t;

  var u = function () {
    var t = n();
    f(t);
    return t;
  };

  return _WORKLET || !module414 ? u() : u;
}
