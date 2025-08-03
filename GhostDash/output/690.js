exports.default = function (t) {
  var n = t.getState,
    l = t.getStateListeners,
    p = React.useContext(module661.default).addKeyedListener,
    O = React.useContext(module675.default),
    y = O ? O.key : 'root',
    b = React.useCallback(
      function () {
        var t = n(),
          o = t.routes.map(function (t) {
            var n,
              o = null == (n = l[t.key]) ? undefined : n.call(l);
            return t.state === o
              ? t
              : s(
                  s({}, t),
                  {},
                  {
                    state: o,
                  }
                );
          });
        return module691.default(t.routes, o)
          ? t
          : s(
              s({}, t),
              {},
              {
                routes: o,
              }
            );
      },
      [n, l]
    );
  React.useEffect(
    function () {
      return null == p ? undefined : p('getState', y, b);
    },
    [p, b, y]
  );
};

var module50 = require('./50'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = l(n);
    if (o && o.has(t)) return o.get(t);
    var u = {
        __proto__: null,
      },
      c = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var f in t)
      if ('default' !== f && Object.prototype.hasOwnProperty.call(t, f)) {
        var p = c ? Object.getOwnPropertyDescriptor(t, f) : null;
        if (p && (p.get || p.set)) Object.defineProperty(u, f, p);
        else u[f] = t[f];
      }

    u.default = t;
    if (o) o.set(t, u);
    return u;
  })(require('react')),
  module661 = require('./661'),
  module675 = require('./675'),
  module691 = require('./691');

function l(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (l = function (t) {
    return t ? o : n;
  })(t);
}

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

function s(t) {
  for (var o = 1; o < arguments.length; o++) {
    var u = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      p(Object(u), true).forEach(function (o) {
        module50.default(t, o, u[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(u));
    else
      p(Object(u)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(u, n));
      });
  }

  return t;
}
