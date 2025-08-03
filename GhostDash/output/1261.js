require('./1235');

require('./1241');

require('./1229');

require('./1226');

require('./1220');

require('./1243');

var module1210 = require('./1210'),
  module1222 = require('./1222'),
  module1212 = require('./1212'),
  module1237 = require('./1237'),
  module1252 = require('./1252'),
  module1236 = require('./1236'),
  module1238 = require('./1238'),
  module1253 = require('./1253'),
  module1262 = require('./1262');

function y(t, n) {
  return module1253(O, t, n);
}

function l(t) {
  if (!module1222(t))
    t = module1212(t)
      ? {}
      : {
          name: t,
        };
  if (!t.hasOwnProperty('strict')) t.strict = O.strict;
  return t;
}

function O(n, p) {
  var O = (p = l(p)).name,
    x = p.strict,
    h = O || module1252(n),
    k = Object.keys(n)
      .map(function (t) {
        return n[t];
      })
      .every(module1236);

  function w(t, u) {
    if (k) return t;
    var f = true,
      o = k ? {} : module1262({}, t);

    for (var s in n) {
      var p = n[s],
        y = t[s],
        l = module1237(p, y, null);
      f = f && y === l;
      o[s] = l;
    }

    if (f) o = t;
    return o;
  }

  w.meta = {
    kind: 'interface',
    props: n,
    name: O,
    identity: k,
    strict: x,
  };
  w.displayName = h;

  w.is = function (t) {
    if (module1212(t)) return false;
    if (x) for (var c in t) if (!n.hasOwnProperty(c)) return false;

    for (var f in n) if (!module1238(t[f], n[f])) return false;

    return true;
  };

  w.update = function (n, u) {
    return w(module1210.update(n, u));
  };

  w.extend = function (t, n) {
    return y([w].concat(t), n);
  };

  return w;
}

O.strict = false;
O.getOptions = l;
O.getDefaultName = module1252;
O.extend = y;
module.exports = O;
