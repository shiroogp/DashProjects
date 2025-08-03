require('./1235');

require('./1211');

require('./1223');

require('./1236');

var module1210 = require('./1210'),
  module1238 = require('./1238'),
  module1220 = require('./1220'),
  module1236 = require('./1236');

function c(n) {
  return n.map(module1220).join(' & ');
}

function f(u, f) {
  var p = f || c(u),
    s = u.every(module1236);

  function y(n, t) {
    return n;
  }

  y.meta = {
    kind: 'intersection',
    types: u,
    name: f,
    identity: s,
  };
  y.displayName = p;

  y.is = function (n) {
    return u.every(function (u) {
      return module1238(n, u);
    });
  };

  y.update = function (t, u) {
    return y(module1210.update(t, u));
  };

  return y;
}

f.getDefaultName = c;
module.exports = f;
