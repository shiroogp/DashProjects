require('./1235');

require('./1211');

var module1210 = require('./1210'),
  module1220 = require('./1220'),
  module1236 = require('./1236'),
  module1222 = require('./1222'),
  module1237 = require('./1237'),
  module1238 = require('./1238');

function l(n, u) {
  return '{[key: ' + module1220(n) + ']: ' + module1220(u) + '}';
}

function p(p, v, s) {
  module1220(p);
  module1220(v);
  var y = s || l(p, v),
    h = module1236(p) && module1236(v);

  function k(n, t) {
    if (h) return n;
    var u = true,
      o = {};

    for (var c in n)
      if (n.hasOwnProperty(c)) {
        var l = n[(c = module1237(p, c, null))],
          s = module1237(v, l, null);
        u = u && l === s;
        o[c] = s;
      }

    if (u) o = n;
    return o;
  }

  k.meta = {
    kind: 'dict',
    domain: p,
    codomain: v,
    name: s,
    identity: h,
  };
  k.displayName = y;

  k.is = function (n) {
    if (!module1222(n)) return false;

    for (var t in n) if (n.hasOwnProperty(t) && (!module1238(t, p) || !module1238(n[t], v))) return false;

    return true;
  };

  k.update = function (t, u) {
    return k(module1210.update(t, u));
  };

  return k;
}

p.getDefaultName = l;
module.exports = p;
