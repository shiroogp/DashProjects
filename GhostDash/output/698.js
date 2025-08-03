exports.default = function (t, n) {
  var s,
    l = module704.default(n),
    f = module15.default(l, 2),
    p = f[0],
    v = f[1],
    h = [];
  if (null != v && v.initialRouteName)
    h.push({
      initialRouteName: v.initialRouteName,
      connectedRoutes: Object.keys(v.screens),
    });
  var b = null == v ? undefined : v.screens,
    x = t.replace(/\/+/g, '/').replace(/^\//, '').replace(/\?.*$/, '');

  if (((x = x.endsWith('/') ? x : x + '/'), undefined === b)) {
    var N = x
      .split('/')
      .filter(Boolean)
      .map(function (n, o, u) {
        var s = decodeURIComponent(n);
        return o === u.length - 1
          ? {
              name: s,
              params: A(t),
            }
          : {
              name: s,
            };
      });
    return N.length ? R(N, h) : undefined;
  }

  var P,
    S,
    W = (s = []).concat
      .apply(
        s,
        module23.default(
          Object.keys(b).map(function (t) {
            return j(p, t, b, [], h);
          })
        )
      )
      .sort(function (t, n) {
        if (t.pattern.startsWith(n.pattern)) return 1;
        if (n.pattern.startsWith(t.pattern)) return 1;
        var o = t.pattern.split('/'),
          u = n.pattern.split('/'),
          s = o.indexOf('*'),
          l = u.indexOf('*');
        return -1 === s && -1 !== l ? -1 : -1 !== s && -1 === l ? 1 : s === l ? u.length - o.length : l - s;
      });

  if ('/' === x) {
    var I = W.find(function (t) {
      return (
        '' === t.path &&
        t.routeNames.every(function (t) {
          var n;
          return !(
            null !=
              (n = W.find(function (n) {
                return n.screen === t;
              })) && n.path
          );
        })
      );
    });
    return I
      ? R(
          I.routeNames.map(function (n, o, u) {
            return o === u.length - 1
              ? {
                  name: n,
                  params: A(t, I.parse),
                }
              : {
                  name: n,
                };
          }),
          h
        )
      : undefined;
  }

  if (false === p) {
    var D = O(
        x,
        W.map(function (t) {
          return y(
            y({}, t),
            {},
            {
              regex: t.regex ? new RegExp(t.regex.source + '$') : undefined,
            }
          );
        })
      ),
      U = D.routeNames,
      $ = D.allParams,
      _ = D.remainingPath;

    if (undefined !== U) {
      x = _;
      S = R(k(W, U, $), h);
      P = S;
    }
  } else
    for (; x; ) {
      var B = O(x, W),
        C = B.routeNames,
        M = B.allParams,
        L = B.remainingPath;

      if (((x = L), undefined === C)) {
        var T = x.split('/');
        C = [decodeURIComponent(T[0])];
        T.shift();
        x = T.join('/');
      }

      var q = R(k(W, C, M), h);

      if (S) {
        for (var z; null != (F = S) && F.routes[S.index || 0].state; ) {
          var F;
          S = S.routes[S.index || 0].state;
        }

        S.routes[(null == (z = S) ? undefined : z.index) || 0].state = q;
      } else P = q;

      S = q;
    }

  if (null == S || null == P) return;
  var G = E(S),
    H = A(t, w(G.name, W));
  if (H) G.params = y(y({}, G.params), H);
  return P;
};

var module50 = require('./50'),
  module15 = require('@babel/runtime/helpers/slicedToArray'),
  module699 = require('./699'),
  module700 = require('./700'),
  module704 = require('./704');

function f(t, n) {
  var o = ('undefined' != typeof Symbol && t[Symbol.iterator]) || t['@@iterator'];
  if (o) return (o = o.call(t)).next.bind(o);

  if (Array.isArray(t) || (o = p(t)) || (n && t && 'number' == typeof t.length)) {
    if (o) t = o;
    var u = 0;
    return function () {
      return u >= t.length
        ? {
            done: true,
          }
        : {
            done: false,
            value: t[u++],
          };
    };
  }

  throw new TypeError('Invalid attempt to iterate non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.');
}

function p(t, n) {
  if (t) {
    if ('string' == typeof t) return v(t, n);
    var o = Object.prototype.toString.call(t).slice(8, -1);
    if ('Object' === o && t.constructor) o = t.constructor.name;
    return 'Map' === o || 'Set' === o ? Array.from(t) : 'Arguments' === o || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(o) ? v(t, n) : undefined;
  }
}

function v(t, n) {
  if (null == n || n > t.length) n = t.length;

  for (var o = 0, u = new Array(n); o < n; o++) u[o] = t[o];

  return u;
}

function h(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var u = Object.getOwnPropertySymbols(t);
    if (n)
      u = u.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, u);
  }

  return o;
}

function y(t) {
  for (var o = 1; o < arguments.length; o++) {
    var u = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      h(Object(u), true).forEach(function (o) {
        module50.default(t, o, u[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(u));
    else
      h(Object(u)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(u, n));
      });
  }

  return t;
}

var b = function (...args) {
    return (t = []).concat
      .apply(
        t,
        module23.default(
          args.map(function (t) {
            return t.split('/');
          })
        )
      )
      .filter(Boolean)
      .join('/');
  },
  O = function (t, n) {
    for (
      var u,
        s,
        l,
        c,
        p = t,
        v = function () {
          if (!y.regex) return 0;
          var t = p.match(y.regex);

          if (t) {
            u = module23.default(y.routeNames);
            var n = y.pattern.split('/').filter(function (t) {
              return t.startsWith(':');
            });
            if (n.length)
              s = n.reduce(function (n, o, u) {
                var s = t[2 * (u + 1)].replace(/\//, '');
                n[o] = s;
                return n;
              }, {});
            p = p.replace(t[1], '');
            return 1;
          }
        },
        h = f(n);
      !(c = h()).done;

    ) {
      var y = c.value;
      if (0 !== (l = v()) && 1 === l) break;
    }

    return {
      routeNames: u,
      allParams: s,
      remainingPath: p,
    };
  },
  j = function t(n, u, s) {
    var l = arguments.length > 3 && undefined !== arguments[3] ? arguments[3] : [],
      c = arguments.length > 4 ? arguments[4] : undefined,
      f = arguments.length > 5 ? arguments[5] : undefined,
      p = [];
    l.push(u);
    var v = s[u];

    if ('string' == typeof v) {
      var h = f ? b(f, v) : v;
      p.push(x(n, u, l, h, v));
    } else if ('object' == typeof v) {
      var y;

      if ('string' == typeof v.path) {
        if (n) y = true !== v.exact && f ? b(f, v.path) : v.path;
        else {
          if (v.exact && undefined === v.path)
            throw new Error("A 'path' needs to be specified when specifying 'exact: true'. If you don't want this screen in the URL, specify it as empty string, e.g. `path: ''`.");
          y = true !== v.exact ? b(f || '', v.path || '') : v.path || '';
        }
        p.push(x(n, u, l, y, v.path, v.parse));
      }

      if (v.screens) {
        if (v.initialRouteName)
          c.push({
            initialRouteName: v.initialRouteName,
            connectedRoutes: Object.keys(v.screens),
          });
        Object.keys(v.screens).forEach(function (u) {
          var s,
            h = t(n, u, v.screens, l, c, null != (s = y) ? s : f);
          p.push.apply(p, module23.default(h));
        });
      }
    }

    l.pop();
    return p;
  },
  x = function (t, n, u, l, c, f) {
    return {
      screen: n,
      regex: (l = l.split('/').filter(Boolean).join('/'))
        ? new RegExp(
            '^(' +
              l
                .split('/')
                .map(function (n) {
                  if (t && '*' === n)
                    throw new Error(
                      "Please update your config to the new format to use wildcard pattern ('*'). https://reactnavigation.org/docs/configuring-links/#updating-config"
                    );
                  return n.startsWith(':') ? '(([^/]+\\/)' + (n.endsWith('?') ? '?' : '') + ')' : ('*' === n ? '.*' : module699.default(n)) + '\\/';
                })
                .join('') +
              ')'
          )
        : undefined,
      pattern: l,
      path: c,
      routeNames: module23.default(u),
      parse: f,
    };
  },
  w = function (t, n) {
    for (var o, u = f(n); !(o = u()).done; ) {
      var s = o.value;
      if (t === s.routeNames[s.routeNames.length - 1]) return s.parse;
    }
  },
  N = function (t, n) {
    for (var o, u = f(n); !(o = u()).done; ) {
      var s = o.value;
      if (s.connectedRoutes.includes(t)) return s.initialRouteName === t ? undefined : s.initialRouteName;
    }
  },
  P = function (t, n, o, u) {
    if (u)
      return t
        ? {
            index: 1,
            routes: [
              {
                name: t,
              },
              {
                name: n,
                params: o,
              },
            ],
          }
        : {
            routes: [
              {
                name: n,
                params: o,
              },
            ],
          };
    else
      return t
        ? {
            index: 1,
            routes: [
              {
                name: t,
              },
              {
                name: n,
                params: o,
                state: {
                  routes: [],
                },
              },
            ],
          }
        : {
            routes: [
              {
                name: n,
                params: o,
                state: {
                  routes: [],
                },
              },
            ],
          };
  },
  R = function (t, n) {
    var o,
      u = t.shift(),
      s = N(u.name, n);
    if (((o = P(s, u.name, u.params, 0 === t.length)), t.length > 0))
      for (var l = o; (u = t.shift()); ) {
        s = N(u.name, n);
        var c = l.index || l.routes.length - 1;
        l.routes[c].state = P(s, u.name, u.params, 0 === t.length);
        if (t.length > 0) l = l.routes[c].state;
      }
    return o;
  },
  k = function (t, n, o) {
    return n.map(function (n) {
      var u,
        s = t.find(function (t) {
          return t.screen === n;
        });

      if (o && null != s && s.path) {
        var l = s.path;

        if (l) {
          var c = l.split('/').filter(function (t) {
            return t.startsWith(':');
          });
          if (c.length)
            u = c.reduce(function (t, n) {
              var u = n.replace(/^:/, '').replace(/\?$/, ''),
                l = o[n];
              if (l) t[u] = s.parse && s.parse[u] ? s.parse[u](l) : l;
              return t;
            }, {});
        }
      }

      return u && Object.keys(u).length
        ? {
            name: n,
            params: u,
          }
        : {
            name: n,
          };
    });
  },
  E = function (t) {
    for (var n, o = t; null != (u = o) && u.routes[o.index || 0].state; ) {
      var u;
      o = o.routes[o.index || 0].state;
    }

    return o.routes[(null == (n = o) ? undefined : n.index) || 0];
  },
  A = function (t, n) {
    var o = t.split('?')[1],
      u = module700.default.parse(o);
    if (n)
      Object.keys(u).forEach(function (t) {
        if (n[t] && 'string' == typeof u[t]) u[t] = n[t](u[t]);
      });
    return Object.keys(u).length ? u : undefined;
  };
