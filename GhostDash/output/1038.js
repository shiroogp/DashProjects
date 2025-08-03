var module1039 = require('./1039'),
  module1040 = require('./1040'),
  u = Array.prototype.push;

function o(n, t) {
  return 2 == t
    ? function (t, u) {
        return n.apply(undefined, arguments);
      }
    : function (t) {
        return n.apply(undefined, arguments);
      };
}

function c(n, t) {
  return 2 == t
    ? function (t, u) {
        return n(t, u);
      }
    : function (t) {
        return n(t);
      };
}

function f(n) {
  for (var t = n ? n.length : 0, u = Array(t); t--; ) u[t] = n[t];

  return u;
}

function p(n) {
  return function (t) {
    return n({}, t);
  };
}

function y(n, t) {
  return function (...args) {
    var p = args[t],
      y = args.slice(0, t);
    if (p) u.apply(y, p);
    if (t != c) u.apply(y, args.slice(t + 1));
    return n.apply(this, y);
  };
}

function v(n, t) {
  return function () {
    var u = arguments.length;

    if (u) {
      for (var o = Array(u); u--; ) o[u] = arguments[u];

      var c = (o[0] = t.apply(undefined, o));
      n.apply(undefined, o);
      return c;
    }
  };
}

module.exports = function u(l, s, h, x) {
  var A = 'function' == typeof s,
    b = s === Object(s);
  if ((b && ((x = h), (h = s), (s = undefined)), null == h)) throw new TypeError();
  if (!x) x = {};
  var k = {
      cap: !('cap' in x) || x.cap,
      curry: !('curry' in x) || x.curry,
      fixed: !('fixed' in x) || x.fixed,
      immutable: !('immutable' in x) || x.immutable,
      rearg: !('rearg' in x) || x.rearg,
    },
    E = A ? h : module1040,
    R = 'curry' in x && x.curry,
    j = 'fixed' in x && x.fixed,
    I = 'rearg' in x && x.rearg,
    M = A ? h.runInContext() : undefined,
    O = A
      ? h
      : {
          ary: l.ary,
          assign: l.assign,
          clone: l.clone,
          curry: l.curry,
          forEach: l.forEach,
          isArray: l.isArray,
          isError: l.isError,
          isFunction: l.isFunction,
          isWeakMap: l.isWeakMap,
          iteratee: l.iteratee,
          keys: l.keys,
          rearg: l.rearg,
          toInteger: l.toInteger,
          toPath: l.toPath,
        },
    F = O.ary,
    T = O.assign,
    C = O.clone,
    P = O.curry,
    W = O.forEach,
    w = O.isArray,
    S = O.isError,
    _ = O.isFunction,
    q = O.isWeakMap,
    z = O.keys,
    B = O.rearg,
    D = O.toInteger,
    G = O.toPath,
    H = z(module1039.aryMethod),
    J = {
      castArray: function (n) {
        return function () {
          var t = arguments[0];
          return w(t) ? n(f(t)) : n.apply(undefined, arguments);
        };
      },
      iteratee: function (n) {
        return function () {
          var t = arguments[0],
            u = arguments[1],
            o = n(t, u),
            f = o.length;

          if (k.cap && 'number' == typeof u) {
            u = u > 2 ? u - 2 : 1;
            return f && f <= u ? o : c(o, u);
          } else return o;
        };
      },
      mixin: function (n) {
        return function (t) {
          var u = this;
          if (!_(u)) return n(u, Object(t));
          var o = [];
          W(z(t), function (n) {
            if (_(t[n])) o.push([n, u.prototype[n]]);
          });
          n(u, Object(t));
          W(o, function (n) {
            var t = n[1];
            if (_(t)) u.prototype[n[0]] = t;
            else delete u.prototype[n[0]];
          });
          return u;
        };
      },
      nthArg: function (n) {
        return function (t) {
          var u = t < 0 ? 1 : D(t) + 1;
          return P(n(t), u);
        };
      },
      rearg: function (n) {
        return function (t, u) {
          var o = u ? u.length : 0;
          return P(n(t, u), o);
        };
      },
      runInContext: function (n) {
        return function (t) {
          return u(l, n(t), x);
        };
      },
    };

  function K(t, u) {
    if (k.cap) {
      var o = module1039.iterateeRearg[t];
      if (o) return X(u, o);
      var c = !A && module1039.iterateeAry[t];
      if (c) return V(u, c);
    }

    return u;
  }

  function L(t, u, o) {
    if (k.fixed && (j || !module1039.skipFixed[t])) {
      var c = module1039.methodSpread[t],
        f = c && c.start;
      return undefined === f ? F(u, o) : y(u, f);
    }

    return u;
  }

  function N(t, u, o) {
    return k.rearg && o > 1 && (I || !module1039.skipRearg[t]) ? B(u, module1039.methodRearg[t] || module1039.aryRearg[o]) : u;
  }

  function Q(n, t) {
    for (var u = -1, o = (t = G(t)).length, c = o - 1, f = C(Object(n)), p = f; null != p && ++u < o; ) {
      var y = t[u],
        v = p[y];
      if (!(null == v || _(v) || S(v) || q(v))) p[y] = C(u == c ? v : Object(v));
      p = p[y];
    }

    return f;
  }

  function U(t, o) {
    var c = module1039.aliasToReal[t] || t,
      f = module1039.remap[c] || c,
      p = x;
    return function (n) {
      var t = A ? M : O,
        y = A ? M[f] : o,
        v = T(T({}, p), n);
      return u(t, c, y, v);
    };
  }

  function V(n, t) {
    return Y(n, function (n) {
      return 'function' == typeof n ? c(n, t) : n;
    });
  }

  function X(n, t) {
    return Y(n, function (n) {
      var u = t.length;
      return o(B(c(n, u), t), u);
    });
  }

  function Y(n, t) {
    return function () {
      var u = arguments.length;
      if (!u) return n();

      for (var o = Array(u); u--; ) o[u] = arguments[u];

      var c = k.rearg ? 0 : u - 1;
      o[c] = t(o[c]);
      return n.apply(undefined, o);
    };
  }

  function Z(t, u, o) {
    var c,
      y = module1039.aliasToReal[t] || t,
      l = u,
      s = J[y];
    if (s) l = s(u);
    else if (k.immutable) module1039.mutate.array[y] ? (l = v(u, f)) : module1039.mutate.object[y] ? (l = v(u, p(u))) : module1039.mutate.set[y] && (l = v(u, Q));
    W(H, function (t) {
      W(module1039.aryMethod[t], function (u) {
        if (y == u) {
          var o = module1039.methodSpread[y],
            f = o && o.afterRearg;
          c = f ? L(y, N(y, l, t), t) : N(y, L(y, l, t), t);
          c = K(y, c);
          p = c;
          v = t;
          c = R || (k.curry && v > 1) ? P(p, v) : p;
          return false;
        }

        var p, v;
      });
      return !c;
    });
    if (!c) c = l;
    if (c == u)
      c = R
        ? P(c, 1)
        : function () {
            return u.apply(this, arguments);
          };
    c.convert = U(y, u);
    c.placeholder = u.placeholder = o;
    return c;
  }

  if (!b) return Z(s, h, E);
  var $ = h,
    rr = [];
  W(H, function (t) {
    W(module1039.aryMethod[t], function (t) {
      var u = $[module1039.remap[t] || t];
      if (u) rr.push([t, Z(t, u, $)]);
    });
  });
  W(z($), function (n) {
    var t = $[n];

    if ('function' == typeof t) {
      for (var u = rr.length; u--; ) if (rr[u][0] == n) return;

      t.convert = U(n, t);
      rr.push([n, t]);
    }
  });
  W(rr, function (n) {
    $[n[0]] = n[1];
  });

  $.convert = function (n) {
    return $.runInContext.convert(n)(undefined);
  };

  $.placeholder = $;
  W(z($), function (t) {
    W(module1039.realToAlias[t] || [], function (n) {
      $[n] = $[t];
    });
  });
  return $;
};
