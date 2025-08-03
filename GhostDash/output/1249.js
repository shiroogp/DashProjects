require('./1210');

require('./1235');

require('./1211');

require('./1219');

var module1250 = require('./1250'),
  module1236 = require('./1236'),
  module1216 = require('./1216'),
  module1237 = require('./1237'),
  module1230 = require('./1230'),
  module1238 = require('./1238'),
  module1220 = require('./1220');

function y(n) {
  return '?' + module1220(n);
}

function p(s, p) {
  if (module1250(s) || s === module1216 || s === module1230) return s;
  var l = p || y(s),
    v = module1236(s);

  function N(n, t) {
    return module1230.is(n) ? n : module1237(s, n, t);
  }

  N.meta = {
    kind: 'maybe',
    type: s,
    name: p,
    identity: v,
  };
  N.displayName = l;

  N.is = function (n) {
    return module1230.is(n) || module1238(n, s);
  };

  return N;
}

p.getDefaultName = y;
module.exports = p;
