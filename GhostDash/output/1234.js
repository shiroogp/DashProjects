require('./1235');

require('./1211');

require('./1219');

var module1210 = require('./1210'),
  module1236 = require('./1236'),
  module1237 = require('./1237'),
  module1238 = require('./1238'),
  module1220 = require('./1220'),
  module1215 = require('./1215');

function p(t, n) {
  return '{' + module1220(t) + ' | ' + module1215(n) + '}';
}

function s(f, o, s) {
  var y = s || p(f, o),
    l = module1236(f);

  function v(t, n) {
    return module1237(f, t, n);
  }

  v.meta = {
    kind: 'subtype',
    type: f,
    predicate: o,
    name: s,
    identity: l,
  };
  v.displayName = y;

  v.is = function (t) {
    return module1238(t, f) && o(t);
  };

  v.update = function (n, u) {
    return v(module1210.update(n, u));
  };

  return v;
}

s.getDefaultName = p;
module.exports = s;
