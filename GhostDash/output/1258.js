require('./1235');

require('./1211');

require('./1223');

require('./1219');

var module1210 = require('./1210'),
  module1220 = require('./1220'),
  module1236 = require('./1236'),
  module1237 = require('./1237'),
  module1238 = require('./1238'),
  module1246 = require('./1246'),
  module1212 = require('./1212');

function p(n) {
  return n.map(module1220).join(' | ');
}

function v(t, v) {
  var h = v || p(t),
    l = t.every(module1236);

  function y(n, t) {
    if (l) return n;
    var u = y.dispatch(n);
    return !u && y.is(n) ? n : module1237(u, n, t);
  }

  y.meta = {
    kind: 'union',
    types: t,
    name: v,
    identity: l,
  };
  y.displayName = h;

  y.is = function (n) {
    return t.some(function (t) {
      return module1238(n, t);
    });
  };

  y.dispatch = function (n) {
    for (var u = 0, f = t.length; u < f; u++) {
      var p = t[u];

      if (module1246(p)) {
        var v = p.dispatch(n);
        if (!module1212(v)) return v;
      } else if (module1238(n, p)) return p;
    }
  };

  y.update = function (t, u) {
    return y(module1210.update(t, u));
  };

  return y;
}

v.getDefaultName = p;
module.exports = v;
