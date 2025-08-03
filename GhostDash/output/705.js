exports.default = function (t, n) {
  if (null == t) throw Error("Got 'undefined' for the navigation state. You must pass a valid state object.");

  var o = module704.default(n),
    p = module15.default(o, 2),
    b = p[0],
    O = p[1],
    w = O ? j(b, O.screens) : {},
    x = '/',
    P = t,
    E = {},
    D = function () {
      for (
        var n,
          o,
          c = 'number' == typeof P.index ? P.index : 0,
          p = P.routes[c],
          O = v(t),
          j = w,
          D = [],
          I = true,
          R = function () {
            if (((n = j[p.name].pattern), D.push(p.name), p.params)) {
              var t,
                f,
                v = null == (t = j[p.name]) ? undefined : t.stringify,
                b = h(
                  Object.entries(p.params).map(function (t) {
                    var n = module15.default(t, 2),
                      o = n[0],
                      u = n[1];
                    return [o, null != v && v[o] ? v[o](u) : String(u)];
                  })
                );

              if ((n && module14.default(E, b), O === p)) {
                o = l({}, b);
                if (!(null == (f = n)))
                  f.split('/')
                    .filter(function (t) {
                      return t.startsWith(':');
                    })
                    .forEach(function (t) {
                      var n = y(t);
                      if (o) delete o[n];
                    });
              }
            }

            if (j[p.name].screens && undefined !== p.state) {
              c = 'number' == typeof p.state.index ? p.state.index : p.state.routes.length - 1;
              var w = p.state.routes[c],
                x = j[p.name].screens;

              if (x && (w.name in x)) {
                p = w;
                j = x;
              } else I = false;
            } else I = false;
          };
        p.name in j && I;

      )
        R();

      if (
        (undefined === n && (n = D.join('/')),
        undefined !== j[p.name]
          ? (x += n
              .split('/')
              .map(function (t) {
                var n = y(t);

                if ('*' === t) {
                  if (b)
                    throw new Error(
                      "Please update your config to the new format to use wildcard pattern ('*'). https://reactnavigation.org/docs/configuring-links/#updating-config"
                    );
                  return p.name;
                }

                if (t.startsWith(':')) {
                  var o = E[n];
                  return undefined === o && t.endsWith('?') ? '' : encodeURIComponent(o);
                }

                return encodeURIComponent(t);
              })
              .join('/'))
          : (x += encodeURIComponent(p.name)),
        o || (o = O.params),
        p.state)
      )
        x += '/';
      else if (o) {
        for (var U in o) 'undefined' === o[U] && delete o[U];

        var _ = module700.default.stringify(o);

        if (_) x += '?' + _;
      }
      P = p.state;
    };

  for (; P; ) D();

  x = (x = x.replace(/\/+/g, '/')).length > 1 ? x.replace(/\/$/, '') : x;
  return x;
};

var module50 = require('./50'),
  module14 = require('./14'),
  module15 = require('@babel/runtime/helpers/slicedToArray'),
  module700 = require('./700'),
  module704 = require('./704');

function p(t, n) {
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

function l(t) {
  for (var n = 1; n < arguments.length; n++) {
    var u = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      p(Object(u), true).forEach(function (n) {
        module50.default(t, n, u[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(u));
    else
      p(Object(u)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(u, n));
      });
  }

  return t;
}

var v = function t(n) {
  var o = 'number' == typeof n.index ? n.routes[n.index] : n.routes[n.routes.length - 1];
  return o.state ? t(o.state) : o;
};

var h = function (t) {
    return t.reduce(function (t, n) {
      var o = module15.default(n, 2),
        u = o[0],
        f = o[1];
      t[u] = f;
      return t;
    }, {});
  },
  y = function (t) {
    return t.replace(/^:/, '').replace(/\?$/, '');
  },
  b = function (...args) {
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
  O = function (t, n, o) {
    var u, s;
    if ('string' == typeof n)
      return {
        pattern: o ? b(o, n) : n,
      };
    if (t) s = true !== n.exact && o && n.path ? b(o, n.path) : n.path;
    else {
      if (n.exact && undefined === n.path)
        throw new Error("A 'path' needs to be specified when specifying 'exact: true'. If you don't want this screen in the URL, specify it as empty string, e.g. `path: ''`.");
      s = true !== n.exact ? b(o || '', n.path || '') : n.path || '';
    }
    var f = n.screens ? j(t, n.screens, s) : undefined;
    return {
      pattern: null == (u = s) ? undefined : u.split('/').filter(Boolean).join('/'),
      stringify: n.stringify,
      screens: f,
    };
  },
  j = function (t, n, o) {
    return h(
      Object.entries(n).map(function (n) {
        var u = module15.default(n, 2),
          f = u[0],
          c = u[1];
        return [f, O(t, c, o)];
      })
    );
  };
