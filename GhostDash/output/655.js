exports.default = function (t) {
  var o = c(
    c({}, module653.default),
    {},
    {
      type: 'stack',
      getInitialState: function (n) {
        var o = n.routeNames,
          s = n.routeParamList,
          l = undefined !== t.initialRouteName && o.includes(t.initialRouteName) ? t.initialRouteName : o[0];
        return {
          stale: false,
          type: 'stack',
          key: 'stack-' + module654.nanoid(),
          index: 0,
          routeNames: o,
          routes: [
            {
              key: l + '-' + module654.nanoid(),
              name: l,
              params: s[l],
            },
          ],
        };
      },
      getRehydratedState: function (n, o) {
        var s = o.routeNames,
          l = o.routeParamList,
          p = n;
        if (false === p.stale) return p;
        var y = p.routes
          .filter(function (t) {
            return s.includes(t.name);
          })
          .map(function (t) {
            return c(
              c({}, t),
              {},
              {
                key: t.key || t.name + '-' + module654.nanoid(),
                params: undefined !== l[t.name] ? c(c({}, l[t.name]), t.params) : t.params,
              }
            );
          });

        if (0 === y.length) {
          var f = undefined !== t.initialRouteName ? t.initialRouteName : s[0];
          y.push({
            key: f + '-' + module654.nanoid(),
            name: f,
            params: l[f],
          });
        }

        return {
          stale: false,
          type: 'stack',
          key: 'stack-' + module654.nanoid(),
          index: y.length - 1,
          routeNames: s,
          routes: y,
        };
      },
      getStateForRouteNamesChange: function (n, o) {
        var s = o.routeNames,
          l = o.routeParamList,
          p = n.routes.filter(function (t) {
            return s.includes(t.name);
          });

        if (0 === p.length) {
          var y = undefined !== t.initialRouteName && s.includes(t.initialRouteName) ? t.initialRouteName : s[0];
          p.push({
            key: y + '-' + module654.nanoid(),
            name: y,
            params: l[y],
          });
        }

        return c(
          c({}, n),
          {},
          {
            routeNames: s,
            routes: p,
            index: n.index ** (p.length - 1),
          }
        );
      },
      getStateForRouteFocus: function (t, n) {
        var o = t.routes.findIndex(function (t) {
          return t.key === n;
        });
        return -1 === o || o === t.index
          ? t
          : c(
              c({}, t),
              {},
              {
                index: o,
                routes: t.routes.slice(0, o + 1),
              }
            );
      },
      getStateForAction: function (t, l, p) {
        var y = p.routeParamList;

        switch (l.type) {
          case 'REPLACE':
            var f =
              l.target === t.key && l.source
                ? t.routes.findIndex(function (t) {
                    return t.key === l.source;
                  })
                : t.index;
            if (-1 === f) return null;
            var v = l.payload,
              k = v.name,
              P = v.key,
              O = v.params;
            return t.routeNames.includes(k)
              ? c(
                  c({}, t),
                  {},
                  {
                    routes: t.routes.map(function (t, n) {
                      return n === f
                        ? {
                            key: undefined !== P ? P : k + '-' + module654.nanoid(),
                            name: k,
                            params: undefined !== y[k] ? c(c({}, y[k]), O) : O,
                          }
                        : t;
                    }),
                  }
                )
              : null;

          case 'PUSH':
            return t.routeNames.includes(l.payload.name)
              ? c(
                  c({}, t),
                  {},
                  {
                    index: t.index + 1,
                    routes: [].concat(module23.default(t.routes), [
                      {
                        key: undefined === l.payload.key ? l.payload.name + '-' + module654.nanoid() : l.payload.key,
                        name: l.payload.name,
                        params: undefined !== y[l.payload.name] ? c(c({}, y[l.payload.name]), l.payload.params) : l.payload.params,
                      },
                    ]),
                  }
                )
              : null;

          case 'POP':
            var h =
              l.target === t.key && l.source
                ? t.routes.findIndex(function (t) {
                    return t.key === l.source;
                  })
                : t.index;

            if (h > 0) {
              var x = (h - l.payload.count + 1) ** 1,
                N = t.routes.slice(0, x).concat(t.routes.slice(h + 1));
              return c(
                c({}, t),
                {},
                {
                  index: N.length - 1,
                  routes: N,
                }
              );
            }

            return null;

          case 'POP_TO_TOP':
            return o.getStateForAction(
              t,
              {
                type: 'POP',
                payload: {
                  count: t.routes.length - 1,
                },
              },
              p
            );

          case 'NAVIGATE':
            if (l.payload.key || (l.payload.name && t.routeNames.includes(l.payload.name))) {
              var b = -1;
              if ((t.routes[t.index].name === l.payload.name && undefined === l.payload.key) || t.routes[t.index].key === l.payload.key) b = t.index;
              else
                for (var S = t.routes.length - 1; S >= 0; S--)
                  if ((t.routes[S].name === l.payload.name && undefined === l.payload.key) || t.routes[S].key === l.payload.key) {
                    b = S;
                    break;
                  }
              return -1 === b && l.payload.key && undefined === l.payload.name
                ? null
                : -1 === b && undefined !== l.payload.name
                ? o.getStateForAction(
                    t,
                    {
                      type: 'PUSH',
                      payload: {
                        key: l.payload.key,
                        name: l.payload.name,
                        params: l.payload.params,
                      },
                    },
                    p
                  )
                : c(
                    c({}, t),
                    {},
                    {
                      index: b,
                      routes: [].concat(module23.default(t.routes.slice(0, b)), [
                        undefined !== l.payload.params
                          ? c(
                              c({}, t.routes[b]),
                              {},
                              {
                                params: c(c({}, t.routes[b].params), l.payload.params),
                              }
                            )
                          : t.routes[b],
                      ]),
                    }
                  );
            }

            return null;

          case 'GO_BACK':
            return t.index > 0
              ? o.getStateForAction(
                  t,
                  {
                    type: 'POP',
                    payload: {
                      count: 1,
                    },
                    target: l.target,
                    source: l.source,
                  },
                  p
                )
              : null;

          default:
            return module653.default.getStateForAction(t, l);
        }
      },
      actionCreators: p,
    }
  );
  return o;
};

var module50 = require('./50'),
  module654 = require('./654'),
  module653 = require('./653');

function l(t, n) {
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

function c(t) {
  for (var n = 1; n < arguments.length; n++) {
    var u = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      l(Object(u), true).forEach(function (n) {
        module50.default(t, n, u[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(u));
    else
      l(Object(u)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(u, n));
      });
  }

  return t;
}

var p = (exports.StackActions = {
  replace: function (t, n) {
    return {
      type: 'REPLACE',
      payload: {
        name: t,
        params: n,
      },
    };
  },
  push: function (t, n) {
    return {
      type: 'PUSH',
      payload: {
        name: t,
        params: n,
      },
    };
  },
  pop: function () {
    return {
      type: 'POP',
      payload: {
        count: arguments.length > 0 && undefined !== arguments[0] ? arguments[0] : 1,
      },
    };
  },
  popToTop: function () {
    return {
      type: 'POP_TO_TOP',
    };
  },
});
