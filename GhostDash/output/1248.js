require('./1235');

require('./1211');

var module1210 = require('./1210'),
  module1220 = require('./1220'),
  module1236 = require('./1236'),
  module1237 = require('./1237'),
  module1238 = require('./1238'),
  module1223 = require('./1223');

function l(n) {
  return 'Array<' + module1220(n) + '>';
}

function p(p, s) {
  module1220(p);
  var v = s || l(p),
    y = module1236(p);

  function h(n, t) {
    if (y) return n;

    for (var u = true, o = [], c = 0, l = n.length; c < l; c++) {
      var s = n[c],
        v = module1237(p, s, null);
      u = u && s === v;
      o.push(v);
    }

    if (u) o = n;
    return o;
  }

  h.meta = {
    kind: 'list',
    type: p,
    name: s,
    identity: y,
  };
  h.displayName = v;

  h.is = function (n) {
    return (
      module1223(n) &&
      n.every(function (n) {
        return module1238(n, p);
      })
    );
  };

  h.update = function (t, u) {
    return h(module1210.update(t, u));
  };

  return h;
}

p.getDefaultName = l;
module.exports = p;
