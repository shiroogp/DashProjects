require('./1210');

require('./1211');

require('./1232');

var module1222 = require('./1222'),
  module1223 = require('./1223'),
  module1262 = require('./1262');

function u(u) {
  if (module1222(u)) return u instanceof Date || u instanceof RegExp ? u : module1262({}, u);
  else return module1223(u) ? u.concat() : u;
}

function c(n) {
  return s.commands.hasOwnProperty(n);
}

function f(n) {
  return s.commands[n];
}

function s(n, t) {
  var o,
    p = n,
    h = false;

  for (var l in t)
    t.hasOwnProperty(l) && (c(l) ? ((o = f(l)(t[l], p)) !== n ? ((h = true), (p = o)) : (p = n)) : (p === n && (p = u(n)), (o = s(p[l], t[l])), (h = h || o !== p[l]), (p[l] = o)));

  return h ? p : n;
}

s.commands = {
  $apply: function (n, t) {
    return n(t);
  },
  $push: function (n, t) {
    return n.length > 0 ? t.concat(n) : t;
  },
  $remove: function (n, t) {
    if (n.length > 0) {
      t = u(t);

      for (var o = 0, c = n.length; o < c; o++) delete t[n[o]];
    }

    return t;
  },
  $set: function (n) {
    return n;
  },
  $splice: function (n, t) {
    if (n.length > 0) {
      t = u(t);
      return n.reduce(function (n, t) {
        n.splice.apply(n, t);
        return n;
      }, t);
    } else return t;
  },
  $swap: function (n, t) {
    if (n.from !== n.to) {
      var o = (t = u(t))[n.to];
      t[n.to] = t[n.from];
      t[n.from] = o;
    }

    return t;
  },
  $unshift: function (n, t) {
    return n.length > 0 ? n.concat(t) : t;
  },
  $merge: function (n, t) {
    var o = false,
      c = u(t);

    for (var f in n) n.hasOwnProperty(f) && ((c[f] = n[f]), (o = o || c[f] !== t[f]));

    return o ? c : t;
  },
};
module.exports = s;
