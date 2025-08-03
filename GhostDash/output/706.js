exports.default = function (t) {
  if (0 === t.routes.length) return;
  var n = t.routes[t.routes.length - 1],
    o = {
      name: n.name,
      params: s({}, n.params),
    },
    u = n.state,
    c = o.params;

  for (; u; ) {
    if (0 === u.routes.length) return;
    n = u.routes[u.routes.length - 1];
    c.initial = 1 === u.routes.length;
    c.screen = n.name;

    if (n.state) {
      c.params = s({}, n.params);
      c = c.params;
    } else c.params = n.params;

    u = n.state;
  }

  return {
    type: 'NAVIGATE',
    payload: o,
  };
};

var module50 = require('./50');

function o(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var s = Object.getOwnPropertySymbols(t);
    if (n)
      s = s.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, s);
  }

  return o;
}

function s(t) {
  for (var s = 1; s < arguments.length; s++) {
    var u = null != arguments[s] ? arguments[s] : {};
    if (s % 2)
      o(Object(u), true).forEach(function (o) {
        module50.default(t, o, u[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(u));
    else
      o(Object(u)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(u, n));
      });
  }

  return t;
}
