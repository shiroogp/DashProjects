var module50 = require('./50'),
  module654 = require('./654');

function u(t, n) {
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
  for (var o = 1; o < arguments.length; o++) {
    var c = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      u(Object(c), true).forEach(function (o) {
        module50.default(t, o, c[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(c));
    else
      u(Object(c)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(c, n));
      });
  }

  return t;
}

var s = {
  getStateForAction: function (t, n) {
    switch (n.type) {
      case 'SET_PARAMS':
        var u = n.source
          ? t.routes.findIndex(function (t) {
              return t.key === n.source;
            })
          : t.index;
        return -1 === u
          ? null
          : c(
              c({}, t),
              {},
              {
                routes: t.routes.map(function (t, o) {
                  return o === u
                    ? c(
                        c({}, t),
                        {},
                        {
                          params: c(c({}, t.params), n.payload.params),
                        }
                      )
                    : t;
                }),
              }
            );

      case 'RESET':
        var s = n.payload;
        return 0 === s.routes.length ||
          s.routes.some(function (n) {
            return !t.routeNames.includes(n.name);
          })
          ? null
          : false === s.stale
          ? t.routeNames.length !== s.routeNames.length ||
            s.routeNames.some(function (n) {
              return !t.routeNames.includes(n);
            })
            ? null
            : c(
                c({}, s),
                {},
                {
                  routes: s.routes.map(function (t) {
                    return t.key
                      ? t
                      : c(
                          c({}, t),
                          {},
                          {
                            key: t.name + '-' + module654.nanoid(),
                          }
                        );
                  }),
                }
              )
          : s;

      default:
        return null;
    }
  },
  shouldActionChangeFocus: function (t) {
    return 'NAVIGATE' === t.type;
  },
};
exports.default = s;
