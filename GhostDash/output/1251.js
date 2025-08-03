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
  module1253 = require('./1253');

function f(t) {
  return 'Struct' + module1252(t);
}

function p(t, n) {
  return module1253(P, t, n);
}

function l(t) {
  if (!module1222(t))
    t = module1212(t)
      ? {}
      : {
          name: t,
        };
  if (!t.hasOwnProperty('strict')) t.strict = P.strict;
  if (!t.hasOwnProperty('defaultProps')) t.defaultProps = {};
  return t;
}

function P(n, u) {
  var s = (u = l(u)).name,
    c = u.strict,
    P = u.defaultProps,
    h = s || f(n);

  function v(t, u) {
    if (v.is(t)) return t;
    if (!(this instanceof v)) return new v(t, u);

    for (var s in n)
      if (n.hasOwnProperty(s)) {
        var c = n[s],
          f = t[s];
        if (undefined === f) f = P[s];
        this[s] = module1237(c, f, null);
      }
  }

  v.meta = {
    kind: 'struct',
    props: n,
    name: s,
    identity: false,
    strict: c,
    defaultProps: P,
  };
  v.displayName = h;

  v.is = function (t) {
    return t instanceof v;
  };

  v.update = function (n, u) {
    return new v(module1210.update(n, u));
  };

  v.extend = function (t, n) {
    return p([v].concat(t), n);
  };

  return v;
}

P.strict = false;
P.getOptions = l;
P.getDefaultName = f;
P.extend = p;
module.exports = P;
