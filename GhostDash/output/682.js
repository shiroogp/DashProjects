exports.default = function (t) {
  var p = t.state,
    s = t.getState,
    l = t.navigation,
    O = t.setOptions,
    b = t.router,
    j = t.emitter,
    v = React.useMemo(
      function () {
        return {
          current: {},
        };
      },
      [s, l, O, b, j]
    ),
    k = y(y({}, b.actionCreators), module651.CommonActions);
  v.current = p.routes.reduce(function (t, u) {
    var c = v.current[u.key];
    if (c) t[u.key] = c;
    else {
      l.emit;

      var p = module56.default(l, f),
        b = function (t) {
          var n = 'function' == typeof t ? t(s()) : t;
          l.dispatch(
            'object' == typeof n && null != n
              ? y(
                  {
                    source: u.key,
                  },
                  n
                )
              : n
          );
        },
        P = Object.keys(k).reduce(function (t, n) {
          t[n] = function () {
            return b(k[n].apply(k, arguments));
          };

          return t;
        }, {});

      t[u.key] = y(
        y(y(y({}, p), P), j.create(u.key)),
        {},
        {
          dispatch: b,
          setOptions: function (t) {
            return O(function (n) {
              return y(y({}, n), {}, module50.default({}, u.key, y(y({}, n[u.key]), t)));
            });
          },
          isFocused: function () {
            var t = s();
            return t.routes[t.index].key === u.key && (!l || l.isFocused());
          },
        }
      );
    }
    return t;
  }, {});
  return v.current;
};

var module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module50 = require('./50'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = p(n);
    if (o && o.has(t)) return o.get(t);
    var u = {
        __proto__: null,
      },
      c = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var f in t)
      if ('default' !== f && Object.prototype.hasOwnProperty.call(t, f)) {
        var s = c ? Object.getOwnPropertyDescriptor(t, f) : null;
        if (s && (s.get || s.set)) Object.defineProperty(u, f, s);
        else u[f] = t[f];
      }

    u.default = t;
    if (o) o.set(t, u);
    return u;
  })(require('react')),
  module651 = require('./651'),
  f = ['emit'];

function p(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (p = function (t) {
    return t ? o : n;
  })(t);
}

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
  for (var n = 1; n < arguments.length; n++) {
    var u = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      s(Object(u), true).forEach(function (n) {
        module50.default(t, n, u[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(u));
    else
      s(Object(u)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(u, n));
      });
  }

  return t;
}
