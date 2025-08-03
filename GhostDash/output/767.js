var module766 = require('./766');

function t() {
  for (var t = {}, u = Object.keys(module766), c = u.length, o = 0; o < c; o++)
    t[u[o]] = {
      distance: -1,
      parent: null,
    };

  return t;
}

function u(u) {
  var c = t(),
    o = [u];

  for (c[u].distance = 0; o.length; )
    for (var f = o.pop(), p = Object.keys(module766[f]), s = p.length, v = 0; v < s; v++) {
      var l = p[v],
        h = c[l];

      if (-1 === h.distance) {
        h.distance = c[f].distance + 1;
        h.parent = f;
        o.unshift(l);
      }
    }

  return c;
}

function c(n, t) {
  return function (u) {
    return t(n(u));
  };
}

function o(t, u) {
  for (var o = [u[t].parent, t], f = module766[u[t].parent][t], p = u[t].parent; u[p].parent; ) {
    o.unshift(u[p].parent);
    f = c(module766[u[p].parent][p], f);
    p = u[p].parent;
  }

  f.conversion = o;
  return f;
}

module.exports = function (n) {
  for (var t = u(n), c = {}, f = Object.keys(t), p = f.length, s = 0; s < p; s++) {
    var v = f[s];
    if (null !== t[v].parent) c[v] = o(v, t);
  }

  return c;
};
