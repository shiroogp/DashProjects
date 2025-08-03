require('./1235');

require('./1219');

var module1210 = require('./1210'),
  module1232 = require('./1232'),
  module1218 = require('./1218');

require('./1222');

function o(t) {
  return Object.keys(t)
    .map(function (t) {
      return module1210.stringify(t);
    })
    .join(' | ');
}

function f(n, f) {
  var c = f || o(n);

  function s(n, t) {
    return n;
  }

  s.meta = {
    kind: 'enums',
    map: n,
    name: f,
    identity: true,
  };
  s.displayName = c;

  s.is = function (o) {
    return (module1218(o) || module1232(o)) && n.hasOwnProperty(o);
  };

  return s;
}

f.of = function (n, t) {
  var o = {};
  (n = module1218(n) ? n.split(' ') : n).forEach(function (n) {
    o[n] = n;
  });
  return f(o, t);
};

f.getDefaultName = o;
module.exports = f;
