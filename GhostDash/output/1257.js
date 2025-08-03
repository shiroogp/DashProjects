require('./1235');

require('./1211');

var module1210 = require('./1210'),
  module1220 = require('./1220'),
  module1236 = require('./1236'),
  module1223 = require('./1223'),
  module1237 = require('./1237'),
  module1238 = require('./1238');

function p(n) {
  return '[' + n.map(module1220).join(', ') + ']';
}

function c(t, c) {
  var v = c || p(t),
    s = t.every(module1236);

  function y(n, u) {
    if (s) return n;

    for (var f = true, l = [], p = 0, c = t.length; p < c; p++) {
      var v = t[p],
        y = n[p],
        h = module1237(v, y, null);
      f = f && y === h;
      l.push(h);
    }

    if (f) l = n;
    return l;
  }

  y.meta = {
    kind: 'tuple',
    types: t,
    name: c,
    identity: s,
  };
  y.displayName = v;

  y.is = function (n) {
    return (
      module1223(n) &&
      n.length === t.length &&
      t.every(function (t, u) {
        return module1238(n[u], t);
      })
    );
  };

  y.update = function (t, u) {
    return y(module1210.update(t, u));
  };

  return y;
}

c.getDefaultName = p;
module.exports = c;
