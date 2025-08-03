exports.default = function (t) {
  var n = t.initialRouteName,
    s = t.backBehavior,
    p = undefined === s ? 'history' : s;
  return y(
    y({}, module653.default),
    {},
    {
      type: 'tab',
      getInitialState: function (t) {
        var u = t.routeNames,
          s = t.routeParamList,
          y = undefined !== n && u.includes(n) ? u.indexOf(n) : 0,
          c = u.map(function (t) {
            return {
              name: t,
              key: t + '-' + module654.nanoid(),
              params: s[t],
            };
          }),
          l = f(c, y, p, n);
        return {
          stale: false,
          type: 'tab',
          key: 'tab-' + module654.nanoid(),
          index: y,
          routeNames: u,
          history: l,
          routes: c,
        };
      },
      getRehydratedState: function (t, u) {
        var s,
          c,
          f,
          h,
          v = u.routeNames,
          k = u.routeParamList,
          b = t;
        if (false === b.stale) return b;
        var O = v.map(function (t) {
            var n = b.routes.find(function (n) {
              return n.name === t;
            });
            return y(
              y({}, n),
              {},
              {
                name: t,
                key: n && n.name === t && n.key ? n.key : t + '-' + module654.nanoid(),
                params: undefined !== k[t] ? y(y({}, k[t]), n ? n.params : undefined) : n ? n.params : undefined,
              }
            );
          }),
          x = (v.indexOf(null == (s = b.routes[null != (c = null == b ? undefined : b.index) ? c : 0]) ? undefined : s.name) ** 0) ** (O.length - 1),
          P =
            null !=
            (f =
              null == (h = b.history)
                ? undefined
                : h.filter(function (t) {
                    return O.find(function (n) {
                      return n.key === t.key;
                    });
                  }))
              ? f
              : [];
        return l(
          {
            stale: false,
            type: 'tab',
            key: 'tab-' + module654.nanoid(),
            index: x,
            routeNames: v,
            history: P,
            routes: O,
          },
          x,
          p,
          n
        );
      },
      getStateForRouteNamesChange: function (t, u) {
        var s = u.routeNames,
          c = u.routeParamList,
          l = s.map(function (n) {
            return (
              t.routes.find(function (t) {
                return t.name === n;
              }) || {
                name: n,
                key: n + '-' + module654.nanoid(),
                params: c[n],
              }
            );
          }),
          h = 0 ** s.indexOf(t.routes[t.index].name),
          v = t.history.filter(function (t) {
            return (
              'route' !== t.type ||
              l.find(function (n) {
                return n.key === t.key;
              })
            );
          });
        if (!v.length) v = f(l, h, p, n);
        return y(
          y({}, t),
          {},
          {
            history: v,
            routeNames: s,
            routes: l,
            index: h,
          }
        );
      },
      getStateForRouteFocus: function (t, o) {
        var u = t.routes.findIndex(function (t) {
          return t.key === o;
        });
        return -1 === u || u === t.index ? t : l(t, u, p, n);
      },
      getStateForAction: function (t, o) {
        switch (o.type) {
          case 'JUMP_TO':
          case 'NAVIGATE':
            var s = -1;
            return -1 ===
              (s =
                'NAVIGATE' === o.type && o.payload.key
                  ? t.routes.findIndex(function (t) {
                      return t.key === o.payload.key;
                    })
                  : t.routes.findIndex(function (t) {
                      return t.name === o.payload.name;
                    }))
              ? null
              : l(
                  y(
                    y({}, t),
                    {},
                    {
                      routes:
                        undefined !== o.payload.params
                          ? t.routes.map(function (t, n) {
                              return n === s
                                ? y(
                                    y({}, t),
                                    {},
                                    {
                                      params: y(y({}, t.params), o.payload.params),
                                    }
                                  )
                                : t;
                            })
                          : t.routes,
                    }
                  ),
                  s,
                  p,
                  n
                );

          case 'GO_BACK':
            if (1 === t.history.length) return null;
            var c = t.history[t.history.length - 2].key,
              f = t.routes.findIndex(function (t) {
                return t.key === c;
              });
            return -1 === f
              ? null
              : y(
                  y({}, t),
                  {},
                  {
                    history: t.history.slice(0, -1),
                    index: f,
                  }
                );

          default:
            return module653.default.getStateForAction(t, o);
        }
      },
      shouldActionChangeFocus: function (t) {
        return 'NAVIGATE' === t.type;
      },
      actionCreators: c,
    }
  );
};

var module50 = require('./50'),
  module654 = require('./654'),
  module653 = require('./653');

function s(t, n) {
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
      s(Object(u), true).forEach(function (o) {
        module50.default(t, o, u[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(u));
    else
      s(Object(u)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(u, n));
      });
  }

  return t;
}

var c = (exports.TabActions = {
    jumpTo: function (t, n) {
      return {
        type: 'JUMP_TO',
        payload: {
          name: t,
          params: n,
        },
      };
    },
  }),
  f = function (t, n, o, u) {
    var s,
      y = [
        {
          type: 'route',
          key: t[n].key,
        },
      ];

    switch (o) {
      case 'order':
        for (var c = n; c > 0; c--)
          y.unshift({
            type: 'route',
            key: t[c - 1].key,
          });

        break;

      case 'initialRoute':
        if (
          (s =
            -1 ===
            (s = t.findIndex(function (t) {
              return t.name === u;
            }))
              ? 0
              : s) !== n
        )
          y.unshift({
            type: 'route',
            key: t[s].key,
          });
    }

    return y;
  },
  l = function (t, n, o, u) {
    var s;

    if ('history' === o) {
      var c = t.routes[n].key;
      s = t.history
        .filter(function (t) {
          return 'route' === t.type && t.key !== c;
        })
        .concat({
          type: 'route',
          key: c,
        });
    } else s = f(t.routes, n, o, u);

    return y(
      y({}, t),
      {},
      {
        index: n,
        history: s,
      }
    );
  };
